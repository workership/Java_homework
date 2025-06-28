package xueshengchengjiguanlixitong;

import java.util.Scanner;
import java.io.IOException;

// ANSI颜色转义序列定义
class Color {
    public static final String RESET = "\033[0m";     // 重置颜色
    public static final String PURPLE = "\033[35m";   
    public static final String CYAN = "\033[36m";     
    public static final String GREEN = "\033[32m";     
    public static final String YELLOW = "\033[33m";    
    public static final String BLUE = "\033[34m";      
    public static final String RED = "\033[31m";       
    public static final String PINK = "\033[38;5;206m";  
}

class MyPro {
    public static void main(String[] args) {
        int select; 
        select = 1;
        Student stu[] = new Student[10];
        StudentInfo mis = new StudentInfo();
        Scanner sc = new Scanner(System.in);
int flg = 0;
        while (select != 0) {
            //Menu
            System.out.println(Color.PURPLE + "┌──────────────────────┐" + Color.RESET);
            System.out.println(Color.PURPLE + "│     爪哇成绩管理系统  │" + Color.RESET);
            System.out.println(Color.PURPLE + "└──────────────────────┘" + Color.RESET);
            System.out.println("\n" + Color.PURPLE + "===== 我们是" + Color.CYAN + "🌟A🌟S🌟O🌟U🌟L🌟" + Color.PURPLE + " =====\n" + Color.RESET);
            System.out.println("    ∧  ∧");
            System.out.println("   ( o o )");
          
            System.out.println(Color.CYAN + "  [1] " + Color.GREEN + "🐾 添加学生" + Color.RESET);
            System.out.println(Color.CYAN + "  [2] " + Color.GREEN + "✨ 修改成绩" + Color.RESET);
            System.out.println(Color.CYAN + "  [3] " + Color.GREEN + "🔍 查找学生" + Color.RESET);
            System.out.println(Color.CYAN + "  [4] " + Color.GREEN + "🎵 计算平均分" + Color.RESET);
            System.out.println(Color.CYAN + "  [5] " + Color.GREEN + "👑 最高分成员" + Color.RESET);
            System.out.println(Color.CYAN + "  [6] " + Color.GREEN + "📊 按成绩排序" + Color.RESET);
            System.out.println(Color.CYAN + "  [7] " + Color.GREEN + "📌 按学号排序" + Color.RESET);
            System.out.println(Color.CYAN + "  [8] " + Color.GREEN + "💖 按姓名排序" + Color.RESET);
            System.out.println(Color.CYAN + "  [9] " + Color.GREEN + "📉 成绩分段统计" + Color.RESET);
            System.out.println(Color.CYAN + "  [10] " + Color.GREEN + "🎒 扩容数组" + Color.RESET);
            System.out.println(Color.CYAN + "  [11] " + Color.GREEN + "📋 显示全部" + Color.RESET);
            System.out.println(Color.CYAN + "  [0] " + Color.GREEN + "🥺 退出系统" + Color.RESET);
            System.out.print(Color.YELLOW + "        (๑>◡<๑)：" + Color.RESET);

            try {
                select = sc.nextInt();
                sc.nextLine(); // 消耗换行符

               
                System.out.println(Color.PURPLE + "💜" + Color.RESET + 
                                  Color.BLUE + "💙" + Color.RESET + 
                                  Color.YELLOW + "💛" + Color.RESET + 
                                  Color.RED + "🧡" + Color.RESET + 
                                  Color.PINK + "❤️────────────────" + 
                                  Color.PINK + "❤️" + Color.RESET + 
                                  Color.RED + "🧡" + Color.RESET + 
                                  Color.YELLOW + "💛" + Color.RESET + 
                                  Color.BLUE + "💙" + Color.RESET + 
                                  Color.PURPLE + "💜" + Color.RESET);
                
                switch (select) {
                    case 1:
                        System.out.println(Color.YELLOW + "✨ 塔菲正在记录新同学" + Color.RESET);
                        try {
                            mis.Inputstu(stu);
                        } catch (IOException e) {
                            System.out.println(Color.RED + "输入出错啦: " + e.getMessage() + Color.RESET);
                        }
                        break;
                    case 2:
                        System.out.println(Color.YELLOW + "📝 要修改谁的成绩" + Color.RESET);
                        System.out.print(Color.YELLOW + "学生姓名: " + Color.RESET);
                        String name = sc.nextLine();
                        Student updatedStu = mis.change(name, stu);
                        if (updatedStu != null) {
                            System.out.println(Color.GREEN + "修改好了捏！新成绩素: " + updatedStu.Getchengji() + "分哦~" + Color.RESET);
                        }
                        break;
                    case 3:
                        System.out.println(Color.YELLOW + "🔍 塔菲找找看喵" + Color.RESET);
                        System.out.print(Color.YELLOW + "学生姓名: " + Color.RESET);
                        Student foundStu = mis.search(stu);
                        if (foundStu != null) {
                            System.out.println(Color.GREEN + "耶找到了 学生信息在这里:" + Color.RESET);
                            foundStu.print();
                        }
                        break;
                    case 4:
                        double avgScore = mis.Pingfen(stu);
                        if (Student.sumstu == 0) {
                            System.out.println(Color.RED + "还没有雏草姬的数据" + Color.RESET);
                        } else {
                            System.out.printf(Color.BLUE + "大家的平均分是: %.2f 分✨\n" + Color.RESET, avgScore);
                        }
                        break;
                    case 5:
                        System.out.println(Color.YELLOW + "👑 寻找成绩最棒的同学  " + Color.RESET);
                        Student[] topStudents = mis.Topchengji(stu);
                        if (topStudents.length > 0) {
                            System.out.println(Color.GREEN + "是这些同学哦 :\n" + Color.RESET);
                            for (Student s : topStudents) {
                                if (s != null) {
                                    s.print();
                                }
                            }
                        } else {
                            System.out.println(Color.RED + "还没有雏草姬的数据" + Color.RESET);
                        }
                        break;
                    case 6:
                        System.out.println(Color.YELLOW + "📊 按成绩排好队啦:" + Color.RESET);
                        mis.sortcj(stu);
                        break;
                    case 7:
                        System.out.println(Color.YELLOW + "📌 按学号排好队啦:" + Color.RESET);
                        mis.sortxh(stu);
                        break;
                    case 8:
                        System.out.println(Color.YELLOW + "💖 按姓名排好队啦:" + Color.RESET);
                        mis.sortname(stu);
                        break;
                    case 9:
                        System.out.println(Color.YELLOW + "📉 成绩分段统计~" + Color.RESET);
                        mis.test(stu);
                        break;
                    case 10:
                        stu = mis.kuorong(stu);
                        System.out.println(Color.GREEN + "背包扩容成功！现在能装 " + stu.length + " 个雏草姬啦~" + Color.RESET);
                        break;
                    case 11:
                        System.out.println(Color.YELLOW + "📋 全体同学集合喵~" + Color.RESET);
                        mis.print(stu);
                        break;
                    case 0:
                        System.out.println(Color.RED + "(´；ω；`) 塔菲要下播啦，下次再见喵~" + Color.RESET);
                        break;
                    default:
                        System.out.println(Color.RED + "不对捏~ 再选一个吧 " + Color.RESET);
                }
                
                // 结束分隔线（带颜色ASoul团标）
                switch(flg) {
                case 0:System.out.println("\n\n" + Color.PINK + "===== “你怎么知道水母没有梦想呢” =====\n" + Color.RESET);flg++;break;
                case 1:System.out.println("\n\n" + Color.PINK + "===== “你是不是嫌我傻啦吧唧的” =====\n" + Color.RESET);flg++;break;
                case 2:System.out.println(" \n\n" + Color.PINK + "===== “我可以跟99岁老乃琳聊天，还可以跟3岁小然比聊天，我简直完美融入了这过年的氛围啊！” =====\n" + Color.RESET);flg++;break;
                case 3:System.out.println(" \n\n" + Color.PINK + "===== “雷达要全开，我接受你的挑战” =====\n" + Color.RESET);flg++;break;
                case 4:System.out.println(" \n\n" + Color.PINK + "===== “永远热泪盈眶，永远不长记性，永远被当枪使，永远感动在自我。” =====\n" + Color.RESET);flg++;break;
                case 5:System.out.println(" \n\n" + Color.PINK + "===== “没有贾布，没有A-SOUL的今天” =====\n" + Color.RESET);flg++;break;
                case 6:System.out.println(" \n\n" + Color.PINK + "===== “你们知道水母是没有自己的动力系统的吗” =====\n" + Color.RESET);flg++;break;
                case 7:System.out.println(" \n\n" + Color.PINK + "===== “珈乐的娇羞就像真爱，想要永恒” =====\n" + Color.RESET);flg++;break;
                case 8:System.out.println(" \n\n" + Color.PINK + "===== “塔菲不是热水器喵” =====\n" + Color.RESET);flg++;break;
                case 9:System.out.println(" \n\n" + Color.PINK + "===== “没你最近是不是在兼职在外面兼职！你是不是小粒Q!” =====\n" + Color.RESET);flg++;break;
                case 10:System.out.println("\n\n" + Color.PINK + "===== “我是然比，你是晚比” =====\n" + Color.RESET);flg++;break;
                case 11:System.out.println("\n\n" + Color.PINK + "===== “关注嘉然今天吃什么谢谢喵” =====\n" + Color.RESET);flg=0;break;
                }
                
            } catch (Exception e) {
                System.out.println(Color.RED + "操作失误了吗: " + e.getMessage() + Color.RESET);
                System.out.println(Color.YELLOW + "请重新输入哦~" + Color.RESET);
                sc.nextLine(); // 清除错误输入
            }
        }
        sc.close();
        System.out.println(Color.GREEN + "(=^･ω･^=) 白白喵 " + Color.RESET);
    }
}

class Student {
    String id;
    String name;
    int chengji;
    public static int sumstu = 0;

    public Student() {
        sumstu++;
    }

    public Student(String number) {
        this.id = number;
        sumstu++;
    }

    void SetChengji(int n) {
        this.chengji = n;
    }

    String Getname() {
        return name;
    }

    int Getchengji() {
        return chengji;
    }

    void print() {
        System.out.printf(Color.GREEN + "🐾 学号: " + Color.BLUE + "%s" + Color.GREEN + " | 姓名: " + Color.BLUE + "%s" + Color.GREEN + " | 成绩: " + Color.RED + "%d" + Color.GREEN + "分喵 ✨\n" + Color.RESET, id, name, chengji);
    }
}

class StudentInfo {
    public StudentInfo() {
    }

    public void Inputstu(Student a[]) throws IOException {
        String tmp;
        boolean flat = false;
        Scanner sc = new Scanner(System.in);
        int num = Student.sumstu;
        
        System.out.print(Color.YELLOW + "  📝 请输入学号喵: " + Color.RESET);
        tmp = sc.next();

        do {
            flat = false;
            for (int i = 0; i < num; i++) {
                if (a[i] != null && a[i].id.equals(tmp)) {
                    flat = true;
                    System.out.print(Color.RED + "学号重复啦喵，请重新输入: " + Color.RESET);
                    tmp = sc.next();
                }
            }
        } while (flat);

        if (num < a.length) {
            a[num] = new Student(tmp);
            System.out.print(Color.YELLOW + "  💖 请输入姓名: " + Color.RESET);
            a[num].name = sc.next();
            System.out.print(Color.YELLOW + "  🎵 请输入成绩: " + Color.RESET);
            a[num].SetChengji(sc.nextInt());
            System.out.println(Color.GREEN + "添加成功~ (≧∇≦)ﾉ" + Color.RESET);
        } else {
            System.out.println(Color.RED + "装不下这么多了，容量升级请上舰喵" + Color.RESET);
        }
    }

    public Student[] Topchengji(Student a[]) {
        int max = -1;
        int count = 0;

        for (int i = 0; i < Student.sumstu; i++) {
            if (a[i] != null && a[i].Getchengji() > max) {
                max = a[i].Getchengji();
                count = 1;
            } else if (a[i] != null && a[i].Getchengji() == max) {
                count++;
            }
        }

        Student[] topStudents = new Student[count];
        int index = 0;

        for (int i = 0; i < Student.sumstu; i++) {
            if (a[i] != null && a[i].Getchengji() == max) {
                topStudents[index++] = a[i];
            }
        }

        return topStudents;
    }

    public Student search(Student a[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print(Color.YELLOW + "请输入要开盒的姓名 : " + Color.RESET);
        String tmpname = sc.next();
        int searchid = -1;

        for (int i = 0; i < Student.sumstu; i++) {
            if (a[i] != null && a[i].Getname().equals(tmpname)) {
                searchid = i;
                break;
            }
        }

        if (searchid == -1) {
            System.out.println(Color.RED + "没找到呢 " + Color.RESET);
            return null;
        } else {
            return a[searchid];
        }
    }

    public void test(Student a[]) {
        int[] counts = new int[5]; // 0: <60, 1: 60-70, 2: 70-80, 3: 80-90, 4: 90-100

        for (int i = 0; i < Student.sumstu; i++) {
            if (a[i] != null) {
                int score = a[i].Getchengji();
                if (score < 60) {
                    counts[0]++;
                } else if (score < 70) {
                    counts[1]++;
                } else if (score < 80) {
                    counts[2]++;
                } else if (score < 90) {
                    counts[3]++;
                } else {
                    counts[4]++;
                }
            }
        }

        // 带颜色的成绩分段统计
        System.out.println(Color.YELLOW + "📊 成绩分段统计喵:" + Color.RESET);
        System.out.printf(Color.RED + "60分以下: %d人 🌧️(要加油哦)\n" + Color.RESET, counts[0]);
        System.out.printf(Color.YELLOW + "60-70分: %d人 🐾(不错啦)\n" + Color.RESET, counts[1]);
        System.out.printf(Color.GREEN + "70-80分: %d人 ✨(很棒哦)\n" + Color.RESET, counts[2]);
        System.out.printf(Color.CYAN + "80-90分: %d人 🌟(超厉害呢)\n" + Color.RESET, counts[3]);
        System.out.printf(Color.BLUE + "90-100分: %d人 👑(是顶流哦)\n" + Color.RESET, counts[4]);
    }

    public Student change(String name, Student a[]) {
        for (int i = 0; i < Student.sumstu; i++) {
            if (a[i] != null && a[i].Getname().equals(name)) {
                Scanner sc = new Scanner(System.in);
                System.out.print(Color.YELLOW + "请输入新成绩 : " + Color.RESET);
                int newScore = sc.nextInt();
                a[i].SetChengji(newScore);
                System.out.println(Color.GREEN + "修改好了~ (≧∇≦)ﾉ" + Color.RESET);
                return a[i];
            }
        }
        System.out.println(Color.RED + "没找到这个同学呢  " + Color.RESET);
        return null;
    }

    double Pingfen(Student a[]) {
    	// 先过滤掉null元素，创建有效学生数组
        Student[] validStu = new Student[Student.sumstu];
        int validCount = 0;
        
        for (int i = 0; i < Student.sumstu; i++) {
            if (a[i] != null) {
                validStu[validCount++] = a[i];
            }
        }
        if (Student.sumstu == 0) {
            return 0;
        }
        
        int sum = 0;
        for (int i = 0; i < validCount; i++) {
            if (validStu[i] != null) {
                sum += validStu[i].Getchengji();
            }
        }
        return (double) sum / validCount;
    }

    public void sortcj(Student[] stu1) {
        // 先过滤掉null元素，创建有效学生数组
        Student[] validStu = new Student[Student.sumstu];
        int validCount = 0;
        
        for (int i = 0; i < Student.sumstu; i++) {
            if (stu1[i] != null) {
                validStu[validCount++] = stu1[i];
            }
        }
        
        // 复制有效学生数组用于排序
        Student[] sortstu = new Student[validCount];
        for (int i = 0; i < validCount; i++) {
            sortstu[i] = new Student();
            sortstu[i].id = validStu[i].id;
            sortstu[i].name = validStu[i].name;
            sortstu[i].chengji = validStu[i].chengji;
        }

        // 冒泡排序（从高到低）
        for (int i = 0; i < validCount - 1; i++) {
            for (int j = 0; j < validCount - i - 1; j++) {
                if (sortstu[j].Getchengji() < sortstu[j + 1].Getchengji()) {
                    Student temp = sortstu[j];
                    sortstu[j] = sortstu[j + 1];
                    sortstu[j + 1] = temp;
                }
            }
        }

        // 打印排序结果
        for (int i = 0; i < validCount; i++) {
            sortstu[i].print();
        }
    }


    public void sortxh(Student[] stu1) {
        // 先过滤掉null元素，创建有效学生数组
        Student[] validStu = new Student[Student.sumstu];
        int validCount = 0;
        
        for (int i = 0; i < Student.sumstu; i++) {
            if (stu1[i] != null) {
                validStu[validCount++] = stu1[i];
            }
        }
        
        // 复制有效学生数组用于排序
        Student[] sortstu = new Student[validCount];
        for (int i = 0; i < validCount; i++) {
            sortstu[i] = new Student();
            sortstu[i].id = validStu[i].id;
            sortstu[i].name = validStu[i].name;
            sortstu[i].chengji = validStu[i].chengji;
        }

        // 按学号排序
        for (int i = 0; i < validCount - 1; i++) {
            for (int j = 0; j < validCount - i - 1; j++) {
                if (sortstu[j].id.compareTo(sortstu[j + 1].id) > 0) {
                    Student temp = sortstu[j];
                    sortstu[j] = sortstu[j + 1];
                    sortstu[j + 1] = temp;
                }
            }
        }

        // 打印排序结果
        for (int i = 0; i < validCount; i++) {
            sortstu[i].print();
        }
    }

    public void sortname(Student[] stu1) {
        // 先过滤掉null元素，创建有效学生数组
        Student[] validStu = new Student[Student.sumstu];
        int validCount = 0;
        
        for (int i = 0; i < Student.sumstu; i++) {
            if (stu1[i] != null) {
                validStu[validCount++] = stu1[i];
            }
        }
        
        // 复制有效学生数组用于排序
        Student[] sortstu = new Student[validCount];
        for (int i = 0; i < validCount; i++) {
            sortstu[i] = new Student();
            sortstu[i].id = validStu[i].id;
            sortstu[i].name = validStu[i].name;
            sortstu[i].chengji = validStu[i].chengji;
        }

        // 按姓名排序
        for (int i = 0; i < validCount - 1; i++) {
            for (int j = 0; j < validCount - i - 1; j++) {
                if (sortstu[j].name.compareTo(sortstu[j + 1].name) > 0) {
                    Student temp = sortstu[j];
                    sortstu[j] = sortstu[j + 1];
                    sortstu[j + 1] = temp;
                }
            }
        }

        // 打印排序结果
        for (int i = 0; i < validCount; i++) {
            sortstu[i].print();
        }
    }

    public Student[] kuorong(Student[] stu1) {
        // 计算当前有效学生数量
        int validCount = 0;
        for (int i = 0; i < Student.sumstu; i++) {
            if (stu1[i] != null) {
                validCount++;
            }
        }
        
        // 创建新数组，扩容20个位置
        Student[] newArray = new Student[stu1.length + 20];
        
        // 复制原有有效学生
        for (int i = 0; i < validCount; i++) {
            newArray[i] = new Student();
            newArray[i].id = stu1[i].id;
            newArray[i].name = stu1[i].name;
            newArray[i].chengji = stu1[i].chengji;
        }
        
        return newArray;
    }
    void print(Student a[]) {
        if (Student.sumstu == 0) {
            System.out.println(Color.RED + "还没有同学呃呃 ~" + Color.RESET);
            return;
        }
   
        System.out.println(Color.PURPLE + "===== " + Color.CYAN + "🌟舰长登船🌟 " + Color.PURPLE + "=====\n\n" + Color.RESET);
        for (int i = 0; i < Student.sumstu; i++) {
            if (a[i] != null) {
                a[i].print();
            }
        }
    }
}