package com.google.common.base;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static char a(char r1) {
        if (b(r1) == true) goto L5;
        return r1;
    L5:
        return (char) (r1 ^ ' ');
    }

    public static String a(String r4) {
        int r0 = r4.length();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L15;
        if (c(r4.charAt(r1)) == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        char[] r5 = r4.toCharArray();
    L7:
        if (r1 >= r0) goto L13;
        char r2 = r5[r1];
        if (c(r2) == false) goto L11;
        r5[r1] = (char) (r2 ^ ' ');
    L11:
        r1 = r1 + 1;
        goto L7
    L13:
        return String.valueOf(r5);
    L15:
        return r4;
    }

    public static String b(String r4) {
        int r0 = r4.length();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L15;
        if (b(r4.charAt(r1)) == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        char[] r5 = r4.toCharArray();
    L7:
        if (r1 >= r0) goto L13;
        char r2 = r5[r1];
        if (b(r2) == false) goto L11;
        r5[r1] = (char) (r2 ^ ' ');
    L11:
        r1 = r1 + 1;
        goto L7
    L13:
        return String.valueOf(r5);
    L15:
        return r4;
    }

    public static boolean b(char r1) {
        if (r1 >= 'a') goto L5;
    L7:
        return false;
    L5:
        if (r1 > 'z') goto L7;
        return true;
    }

    public static boolean c(char r1) {
        if (r1 >= 'A') goto L5;
    L7:
        return false;
    L5:
        if (r1 > 'Z') goto L7;
        return true;
    }
}
