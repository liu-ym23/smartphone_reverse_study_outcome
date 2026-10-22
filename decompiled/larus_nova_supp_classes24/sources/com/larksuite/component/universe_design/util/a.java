package com.larksuite.component.universe_design.util;

import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static final int[] a = null;

    static {
        a = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    }

    @JvmStatic
    public static final int a(int r3, int r4) {
        if (r4 <= 12) goto L5;
        r3 = r3 + 1;
        r4 = 1;
    L7:
        int[] r1 = a;
        if ((r3 % 4) != 0) goto L12;
        if ((r3 % 100) == 0) goto L12;
    L13:
        r1[1] = 29;
    L21:
        return r1[r4 - 1];
    L18:
        e = move-exception;
        e.getStackTrace();
        return 0;
    L12:
        if ((r3 % 400) == 0) goto L13;
        r1[1] = 28;
        goto L21
    L5:
        if (r4 >= 1) goto L7;
        r3 = r3 - 1;
        r4 = 12;
        goto L7
    }
}
