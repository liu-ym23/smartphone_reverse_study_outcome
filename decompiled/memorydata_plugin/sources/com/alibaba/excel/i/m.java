package com.alibaba.excel.i;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f217a = null;

    static {
        f217a = Pattern.compile("(\\$?[A-Z]+)?(\\$?[0-9]+)?", 2);
    }

    public static int a(String r3) {
        if (r3 != null) goto L5;
        return -1;
    L5:
        int r0 = r3.length() - 1;
    L6:
        if (r0 < 0) goto L14;
        char r1 = r3.charAt(r0);
        if (r1 < '0') goto L14;
        if (r1 > '9') goto L14;
        r0 = r0 - 1;
    L14:
        return Integer.parseUnsignedInt(r3.substring(r0 + 1)) - 1;
    }

    public static int a(String r0, Integer r1) {
        if (r0 != null) goto L4;
        if (r1 != null) goto L8;
        r1 = -1;
    L8:
        return r1.intValue() + 1;
    L4:
        return Integer.parseInt(r0) - 1;
    }

    public static int b(String r6, Integer r7) {
        if (r6 != null) goto L9;
        if (r7 != null) goto L7;
        r7 = -1;
    L7:
        return r7.intValue() + 1;
    L9:
        if (r6.charAt(0) != '$') goto L11;
        int r1 = 1;
    L12:
        int r3 = 0;
    L14:
        if (r1 >= r6.length()) goto L28;
        char r4 = r6.charAt(r1);
        if (r4 != '$') goto L18;
    L23:
        boolean r5 = true;
    L24:
        if (r5 == true) goto L28;
        r3 = (((r3 * 26) + Character.toUpperCase(r4)) - 65) + 1;
        r1 = r1 + 1;
        goto L14
    L18:
        if (r4 >= '0') goto L20;
    L22:
        r5 = false;
        goto L24
    L20:
        if (r4 > '9') goto L22;
    L28:
        return r3 - 1;
    L11:
        r1 = 0;
        goto L12
    }
}
