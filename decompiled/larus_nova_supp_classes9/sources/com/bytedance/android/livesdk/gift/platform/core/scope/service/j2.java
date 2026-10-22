package com.bytedance.android.livesdk.gift.platform.core.scope.service;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j2 {
    public int a;
    public long b;
    public long c;

    public j2() {
        this(0);
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof j2) == false) goto L12;
        j2 r7 = (j2) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        long r1 = this.b;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.c;
        return r2 + ((int) (r3 ^ (r3 >>> 32)));
    }

    public final String toString() {
        return "GiftSendDetail(sendTimes=" + this.a + ", sendCount=" + this.b + ", sendDiamond=" + this.c + ")";
    }

    public j2(int r3) {
        this.a = 0;
        this.b = 0;
        this.c = 0;
    }
}
