package com.google.common.primitives;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long[] f9338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9339b;

    public g(int r5) {
        this.f9339b = 0;
        this.f9338a = new long[r5];
    }

    public final void a(int r5) {
        int r10 = this.f9339b + r5;
        long[] r11 = this.f9338a;
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
        this.f9338a = Arrays.copyOf(r11, r13);
        return;
    L13:
        throw new AssertionError("cannot store more than MAX_VALUE elements");
    }
}
