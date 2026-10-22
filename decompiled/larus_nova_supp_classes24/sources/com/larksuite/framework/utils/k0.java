package com.larksuite.framework.utils;

import java.util.Random;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class k0 {
    public static final String[] a = null;
    public static final short b = 0;

    public k0() {
    }

    static {
        String[] r0 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".split("");
        a = r0;
        b = (short) r0.length;
    }

    public static String a(short r1) {
        return b(r1, b);
    }

    public static String b(short r5, short r6) {
        short r0 = b;
        if (r6 <= r0) goto L5;
        r6 = r0;
    L5:
        if (r6 < 0) goto L8;
        r0 = r6;
    L8:
        Random r7 = new Random();
        if (r5 <= 0) goto L14;
        StringBuilder r1 = new StringBuilder();
        short r2 = 0;
    L11:
        if (r2 >= r5) goto L17;
        short r3 = (short) r7.nextInt(r0);
        r1.append(a[r3]);
        r2 = (short) (r2 + 1);
        goto L11
    L17:
        return r1.toString();
    L14:
        return null;
    }
}
