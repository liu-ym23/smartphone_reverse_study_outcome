package com.bytedance.android.live.profit.fansclub;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m {
    public final int a;
    public final long b;
    public final long c;
    public final long d;

    public m() {
        int r3 = 0;
        this(r3, 0, 15);
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof m) == false) goto L14;
        m r7 = (m) r6;
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

    public final int hashCode() {
        int r0 = this.a * 31;
        long r1 = this.b;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.c;
        int r4 = (r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r5 = this.d;
        return r4 + ((int) (r5 ^ (r5 >>> 32)));
    }

    public final String toString() {
        return "GuardInfo(guardStatus=" + this.a + ", activeGuardDay=" + this.b + ", totalGuardDay=" + this.c + ", expireTime=" + this.d + ")";
    }

    public final String a() {
        int r0 = this.a;
        if (r0 != GuardStatus.NotParticipateGuard.getValue()) goto L6;
        return "nonactivated";
    L6:
        if (r0 != GuardStatus.ActiveGuard.getValue()) goto L9;
        return "activated";
    L9:
        if (r0 != GuardStatus.InactiveGuard.getValue()) goto L13;
        return "expired";
    L13:
        return "nonactivated";
    }

    public /* synthetic */ m(int r12, long r13, int r14) {
        if ((r14 & 1) == 0) goto L5;
        r12 = GuardStatus.NoGuard.getValue();
    L5:
        int r1 = r12;
        if ((r14 & 2) == 0) goto L8;
        long r6 = -1;
    L10:
        if ((r14 & 4) == 0) goto L12;
        long r8 = -1;
    L14:
        if ((r14 & 8) == 0) goto L16;
        r13 = -1;
    L16:
        this(r1, r6, r8, r13);
        return;
    L12:
        r8 = 0;
        goto L14
    L8:
        r6 = 0;
        goto L10
    }

    public m(int r1, long r2, long r4, long r6) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r6;
    }
}
