package com.bytedance.android.live.profit.lottery;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f1 {
    public final long a;
    public final long b;
    public final boolean c;
    public final long d;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof f1) == false) goto L14;
        f1 r7 = (f1) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (this.d == r7.d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.b;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        boolean r4 = this.c;
        ?? r5 = r4;
        if (r4 == false) goto L5;
        r5 = 1;
    L5:
        long r6 = this.d;
        return ((r2 + r5) * 31) + ((int) (r6 ^ (r6 >>> 32)));
    }

    public final String toString() {
        return "LotteryParticipateSuccessInfo(lotteryId=" + this.a + ", candidateUid=" + this.b + ", isParticipated=" + this.c + ", version=" + this.d + ")";
    }

    public f1(long r1, long r3, boolean r5, long r6) {
        this.a = r1;
        this.b = r3;
        this.c = r5;
        this.d = r6;
    }
}
