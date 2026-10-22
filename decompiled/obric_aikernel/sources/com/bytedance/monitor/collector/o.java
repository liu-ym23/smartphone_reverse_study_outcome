package com.bytedance.monitor.collector;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f2381a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f2382b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f2383c = false;

    static {
    }

    public static String a(String r10) {
        if (TextUtils.isEmpty(r10) == true) goto L8;
        int r11 = r10.indexOf("at ") + 3;
        int r12 = r10.indexOf(40);
        if (r11 < r12) goto L7;
        return "unknownMethodName";
    L7:
        return r10.substring(r11, r12);
    L8:
        return "unknownMethodName";
    }

    public static String b(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L43;
        return "unknown message";
    L43:
        String[] r11 = r10.split(":");     // Catch: Throwable -> L40
        if (r11.length != 2) goto L10;
        String r12 = r11[1];     // Catch: Throwable -> L40
    L12:
        if (r10.contains("{") == true) goto L14;
    L17:
        String r13 = r10;
    L19:
        if (r10.contains("@") == false) goto L24;
        String[] r14 = r10.split("@");     // Catch: Throwable -> L38
        if (r14.length <= 1) goto L24;
        r10 = r14[0];     // Catch: Throwable -> L38
    L24:
        if (r10.contains("(") == false) goto L34;
        if (r10.contains(")") == false) goto L34;
        if (r10.endsWith(" null") == true) goto L34;
        String[] r15 = r10.split("\\(");     // Catch: Throwable -> L38
        if (r15.length <= 1) goto L32;
        r10 = r15[1];     // Catch: Throwable -> L38
    L32:
        r10 = r10.replace(")", "");     // Catch: Throwable -> L38
    L34:
        if (r10.startsWith(" ") == false) goto L36;
        r10 = r10.replace(" ", "");     // Catch: Throwable -> L38
    L36:
        return r10 + r12;
    L39:
        return r13;
    L14:
        if (r10.contains("}") == false) goto L17;
        r13 = r10.split("\\{")[0];     // Catch: Throwable -> L40
        r10 = r13 + r10.split("\\}")[1];     // Catch: Throwable -> L38
        goto L19
    L10:
        r12 = "";
    L45:
        return r10;
    }

    public static String c(StackTraceElement[] r10) {
        if (r10 != null) goto L5;
        return "Invalid Stack\n";
    L5:
        StringBuilder r11 = new StringBuilder();
        int r12 = r10.length;
        int r13 = 0;
        int r14 = 0;
    L6:
        if (r13 >= r12) goto L12;
        StackTraceElement r15 = r10[r13];
        r14 = r14 + 1;
        r11.append("\tat " + r15.getClassName());
        r11.append(".");
        r11.append(r15.getMethodName());
        r11.append("(");
        r11.append(r15.getFileName());
        r11.append(":");
        r11.append(r15.getLineNumber());
        r11.append(")\n");
        if (r14 > 40) goto L12;
        r13 = r13 + 1;
    L12:
        return r11.toString();
    }

    public static String d(StackTraceElement[] r10) {
        if (r10 != null) goto L5;
        return "Invalid Stack\n";
    L5:
        StringBuilder r11 = new StringBuilder();
        int r12 = r10.length;
        int r13 = 0;
        int r14 = 0;
    L6:
        if (r13 >= r12) goto L12;
        StackTraceElement r15 = r10[r13];
        r14 = r14 + 1;
        r11.append("\\tat " + r15.getClassName());
        r11.append(".");
        r11.append(r15.getMethodName());
        r11.append("(");
        r11.append(r15.getFileName());
        r11.append(":");
        r11.append(r15.getLineNumber());
        r11.append(")\\n");
        if (r14 > 40) goto L12;
        r13 = r13 + 1;
    L12:
        return r11.toString();
    }
}
