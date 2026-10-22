package com.ctc.wstx.shaded.msv_core.util;

/* JADX INFO: loaded from: classes2.dex */
public class f {
    public static boolean a(String r10) {
        int r0 = r10.length();
        if (r0 != 0) goto L6;
        return true;
    L6:
        if (r0 >= 2) goto L8;
        return false;
    L8:
        char r2 = r10.charAt(0);
        if ('a' > r2) goto L11;
        if (r2 > 'z') goto L11;
    L13:
        int r3 = 1;
    L14:
        if (r3 >= r0) goto L32;
        char r8 = r10.charAt(r3);
        if (r8 == ':') goto L17;
        if ('a' > r8) goto L20;
        if (r8 > 'z') goto L20;
    L31:
        r3 = r3 + 1;
    L20:
        if ('A' > r8) goto L24;
        if (r8 <= 'Z') goto L31;
    L24:
        if (r8 == '-') goto L31;
        if (r8 == '+') goto L31;
        if (r8 == '.') goto L31;
        return false;
    L17:
        return true;
    L32:
        return false;
    L11:
        if ('A' > r2) goto L32;
        if (r2 > 'Z') goto L32;
        goto L13
    }
}
