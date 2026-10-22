package com.bytedance.android.live.profit.lottery;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class t {
    public final long a;
    public final int b;
    public final long c;
    public final int d;
    public long e;
    public final long f;
    public final List<Integer> g;
    public final boolean h;
    public final String i;
    public final String j;
    public final c k;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof t) == false) goto L28;
        t r7 = (t) r6;
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
        if (Intrinsics.areEqual(this.g, r7.g) == true) goto L20;
        return false;
    L20:
        if (this.h == r7.h) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r7.i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.j, r7.j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.k, r7.k) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r1v14, types: [int] */
    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b) * 31;
        long r3 = this.c;
        int r2 = (((r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.d) * 31;
        long r4 = this.e;
        int r5 = (r2 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        long r6 = this.f;
        int r7 = (r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31;
        List<Integer> r8 = this.g;
        int r9 = 0;
        if (r8 == null) goto L5;
        int r10 = r8.hashCode();
    L6:
        int r12 = (r7 + r10) * 31;
        boolean r13 = this.h;
        ?? r14 = r13;
        if (r13 == false) goto L9;
        r14 = 1;
    L9:
        int r15 = (r12 + r14) * 31;
        String r16 = this.i;
        if (r16 == null) goto L12;
        int r17 = r16.hashCode();
    L13:
        int r18 = (r15 + r17) * 31;
        String r19 = this.j;
        if (r19 == null) goto L16;
        int r20 = r19.hashCode();
    L17:
        int r22 = (r18 + r20) * 31;
        c r23 = this.k;
        if (r23 == null) goto L21;
        r9 = r23.hashCode();
    L21:
        return r22 + r9;
    L16:
        r20 = 0;
        goto L17
    L12:
        r17 = 0;
        goto L13
    L5:
        r10 = 0;
        goto L6
    }

    public final String toString() {
        return "LocalLotteryInfo(lotteryId=" + this.a + ", status=" + this.b + ", localDrawTime=" + this.c + ", prizeType=" + this.d + ", prizeCount=" + this.e + ", maxRandomDelayDurationByMs=" + this.f + ", conditionTypes=" + this.g + ", useNewDrawInteraction=" + this.h + ", serverBizData=" + this.i + ", uiConfig=" + this.j + ", extra=" + this.k + ")";
    }

    public t(long r5, int r7, long r8, int r10, long r12, long r13, List<Integer> r15, boolean r16, String r17, String r18, c r19) {
        Intrinsics.checkNotNullParameter(r15, "conditionTypes");
        this.a = r5;
        this.b = r7;
        this.c = r8;
        this.d = r10;
        this.e = r12;
        this.f = r13;
        this.g = r15;
        this.h = r16;
        this.i = r17;
        this.j = r18;
        this.k = r19;
    }
}
