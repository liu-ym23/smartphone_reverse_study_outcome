package com.google.common.primitives;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long[] f9342a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f9343b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f9344c = null;

    static {
        f9342a = new long[37];
        f9343b = new int[37];
        f9344c = new int[37];
        BigInteger r5 = new BigInteger("10000000000000000", 16);
        int r10 = 2;
    L4:
        if (r10 > 36) goto L6;
        long r11 = r10;
        f9342a[r10] = f8.b.m(-1, r11);
        f9343b[r10] = (int) f8.b.o(-1, r11);
        f9344c[r10] = r5.toString(r10).length() - 1;
        r10 = r10 + 1;
        goto L4
    }
}
