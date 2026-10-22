package com.google.common.hash;

import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicLongArray f9287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f9288b;

    public h(long r18) {
        boolean r5 = false;
        if (r18 <= 0) goto L5;
        boolean r10 = true;
    L6:
        com.google.common.base.b0.g("data length is zero!", r10);
        RoundingMode r11 = RoundingMode.CEILING;
        r11.getClass();
        long r12 = r18 / 64;
        long r13 = r18 - (64 * r12);
        if (r13 == 0) goto L29;
        int r14 = ((int) ((r18 ^ 64) >> 63)) | 1;
        switch(com.google.common.math.h.f9310a[r11.ordinal()]) {
            case 1: goto L28;
            case 2: goto L29;
            case 3: goto L26;
            case 4: goto L27;
            case 5: goto L24;
            case 6: goto L13;
            case 7: goto L13;
            case 8: goto L13;
            default: goto L12;
        };
    L13:
        long r15 = Math.abs(r13);
        long r16 = r15 - (Math.abs(64) - r15);
        if (r16 == 0) goto L16;
        if (r16 <= 0) goto L29;
    L16:
        if (r11 == RoundingMode.HALF_UP) goto L27;
        if (r11 != RoundingMode.HALF_EVEN) goto L29;
        if ((1 & r12) == 0) goto L29;
    L24:
        if (r14 <= 0) goto L29;
    L26:
        if (r14 >= 0) goto L29;
    L27:
        r12 = r12 + ((long) r14);
        goto L29
    L28:
        if (r13 == 0) goto L29;
        throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
    L12:
        throw new AssertionError();
    L29:
        int r17 = (int) r12;
        if (r17 != r12) goto L32;
        r5 = true;
    L32:
        com.google.common.base.b0.f("Out of range: %s", r12, r5);
        this.f9287a = new AtomicLongArray(r17);
        this.f9288b = (r) u.f9293a.get();
        return;
    L5:
        r10 = false;
        goto L6
    }

    public static long[] e(AtomicLongArray r5) {
        int r10 = r5.length();
        long[] r11 = new long[r10];
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L5;
        r11[r12] = r5.get(r12);
        r12 = r12 + 1;
        goto L3
    L5:
        return r11;
    }

    public final long a() {
        return ((long) this.f9287a.length()) * 64;
    }

    public final boolean b(long r5) {
        AtomicLongArray r10 = this.f9287a;
        long r11 = r10.get((int) (r5 >>> 6));
        if (((1 << ((int) r5)) & r11) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void c(int r12, long r13) {
    L2:
        long r10 = this.f9287a.get(r12);
        long r11 = r10 | r13;
        if (r10 == r11) goto L12;
        if (this.f9287a.compareAndSet(r12, r10, r11) == false) goto L2;
        this.f9288b.add(Long.bitCount(r11) - Long.bitCount(r10));
        return;
    }

    public final boolean d(long r11) {
        if (b(r11) == false) goto L5;
        return false;
    L5:
        int r5 = (int) (r11 >>> 6);
        long r12 = 1 << ((int) r11);
    L6:
        long r10 = this.f9287a.get(r5);
        long r13 = r10 | r12;
        if (r10 == r13) goto L8;
        if (this.f9287a.compareAndSet(r5, r10, r13) == false) goto L6;
        this.f9288b.increment();
        return true;
    L8:
        return false;
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof h) == true) goto L5;
        return false;
    L5:
        return Arrays.equals(e(this.f9287a), e(((h) r5).f9287a));
    }

    public final int hashCode() {
        return Arrays.hashCode(e(this.f9287a));
    }

    public h(long[] r10) {
        int r5 = 0;
        if (r10.length <= 0) goto L5;
        boolean r11 = true;
    L6:
        com.google.common.base.b0.g("data length is zero!", r11);
        this.f9287a = new AtomicLongArray(r10);
        this.f9288b = (r) u.f9293a.get();
        int r12 = r10.length;
        long r13 = 0;
    L7:
        if (r5 >= r12) goto L9;
        r13 = r13 + ((long) Long.bitCount(r10[r5]));
        r5 = r5 + 1;
        goto L7
    L9:
        this.f9288b.add(r13);
        return;
    L5:
        r11 = false;
        goto L6
    }
}
