package com.bytedance.android.live.profit.lottery;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class y2 {
    public final long a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final long f;
    public final long g;
    public final long h;
    public final long i;
    public final String j;
    public final boolean k;
    public final long l;
    public final long m;

    public y2() {
        this(0);
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof y2) == false) goto L32;
        y2 r7 = (y2) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (this.d == r7.d) goto L14;
        return false;
    L14:
        if (this.e == r7.e) goto L16;
        return false;
    L16:
        if (this.f == r7.f) goto L18;
        return false;
    L18:
        if (this.g == r7.g) goto L20;
        return false;
    L20:
        if (this.h == r7.h) goto L22;
        return false;
    L22:
        if (this.i == r7.i) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r7.j) == true) goto L26;
        return false;
    L26:
        if (this.k == r7.k) goto L28;
        return false;
    L28:
        if (this.l == r7.l) goto L30;
        return false;
    L30:
        if (this.m == r7.m) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r1v20, types: [int] */
    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.b;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r4 = this.c;
        int r5 = (r2 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        long r6 = this.d;
        int r7 = (r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31;
        long r8 = this.e;
        int r9 = (r7 + ((int) (r8 ^ (r8 >>> 32)))) * 31;
        long r10 = this.f;
        int r12 = (r9 + ((int) (r10 ^ (r10 >>> 32)))) * 31;
        long r13 = this.g;
        int r14 = (r12 + ((int) (r13 ^ (r13 >>> 32)))) * 31;
        long r15 = this.h;
        int r16 = (r14 + ((int) (r15 ^ (r15 >>> 32)))) * 31;
        long r17 = this.i;
        int r18 = (r16 + ((int) (r17 ^ (r17 >>> 32)))) * 31;
        String r19 = this.j;
        if (r19 == null) goto L5;
        int r20 = r19.hashCode();
    L6:
        int r22 = (r18 + r20) * 31;
        boolean r23 = this.k;
        ?? r24 = r23;
        if (r23 == false) goto L9;
        r24 = 1;
    L9:
        long r25 = this.l;
        int r26 = (((r22 + r24) * 31) + ((int) (r25 ^ (r25 >>> 32)))) * 31;
        long r27 = this.m;
        return r26 + ((int) (r27 ^ (r27 >>> 32)));
    L5:
        r20 = 0;
        goto L6
    }

    public final String toString() {
        return "LotteryTempStatusInfo(lotteryId=" + this.a + ", lotteryType=" + this.b + ", luckyCount=" + this.c + ", prizeCount=" + this.d + ", candidateTotalCount=" + this.e + ", lastSurgeTimeStamp=" + this.f + ", startTime=" + this.g + ", drawTime=" + this.h + ", enabledDilatation=" + this.i + ", dilatationConfigDetail=" + this.j + ", dilatationNow=" + this.k + ", prizeCountBeforeDilatation=" + this.l + ", luckyCountBeforeDilatation=" + this.m + ")";
    }

    public /* synthetic */ y2(int r26) {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0, "", false, 0, 0);
    }

    public y2(long r5, long r7, long r9, long r12, long r13, long r15, long r17, long r19, long r22, String r23, boolean r24, long r25, long r27) {
        Intrinsics.checkNotNullParameter(r23, "dilatationConfigDetail");
        this.a = r5;
        this.b = r7;
        this.c = r9;
        this.d = r12;
        this.e = r13;
        this.f = r15;
        this.g = r17;
        this.h = r19;
        this.i = r22;
        this.j = r23;
        this.k = r24;
        this.l = r25;
        this.m = r27;
    }
}
