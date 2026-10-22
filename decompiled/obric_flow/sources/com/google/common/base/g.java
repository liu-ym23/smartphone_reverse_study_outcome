package com.google.common.base;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g implements z {
    public static String a(char r10) {
        char[] r5 = new char[6];
        int r11 = 0;
        r5[0] = '\\';
        r5[1] = 'u';
        r5[2] = 0;
        r5[3] = 0;
        r5[4] = 0;
        r5[5] = 0;
    L3:
        if (r11 >= 4) goto L6;
        r5[5 - r11] = "0123456789ABCDEF".charAt(r10 & 15);
        r10 = (char) (r10 >> 4);
        r11 = r11 + 1;
        goto L3
    L6:
        return String.copyValueOf(r5);
    }

    public abstract boolean b(char r5);
}
