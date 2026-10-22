package com.google.common.primitives;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double[] f9334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9335b;

    public c(int r5) {
        this.f9335b = 0;
        this.f9334a = new double[r5];
    }

    public final void a(int r5) {
        int r10 = this.f9335b + r5;
        double[] r11 = this.f9334a;
        if (r10 <= r11.length) goto L14;
        int r12 = r11.length;
        if (r10 < 0) goto L13;
        int r13 = (r12 + (r12 >> 1)) + 1;
        if (r13 >= r10) goto L9;
        r13 = Integer.highestOneBit(r10 - 1) << 1;
    L9:
        if (r13 >= 0) goto L11;
        r13 = Integer.MAX_VALUE;
    L11:
        this.f9334a = Arrays.copyOf(r11, r13);
        return;
    L13:
        throw new AssertionError("cannot store more than MAX_VALUE elements");
    }
}
