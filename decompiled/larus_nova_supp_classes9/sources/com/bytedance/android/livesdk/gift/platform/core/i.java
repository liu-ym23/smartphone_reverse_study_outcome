package com.bytedance.android.livesdk.gift.platform.core;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i {
    public final long a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof i) == false) goto L16;
        i r7 = (i) r6;
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
        if (this.e == r7.e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

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
        return r7 + ((int) (r8 ^ (r8 >>> 32)));
    }

    public final String toString() {
        return "GiftEventTime(openDialog=" + this.a + ", giftPreview=" + this.b + ", giftDoubleClick=" + this.c + ", sendGift=" + this.d + ", giftShow=" + this.e + ")";
    }

    public i(long r1, long r3, long r5, long r7, long r9) {
        this.a = r1;
        this.b = r3;
        this.c = r5;
        this.d = r7;
        this.e = r9;
    }

    public static i a(i r14, long r15, long r17, long r19, long r21, int r23) {
        if ((r23 & 1) == 0) goto L5;
        long r1 = r14.a;
    L6:
        long r4 = r1;
        if ((r23 & 2) == 0) goto L9;
        long r6 = r14.b;
    L11:
        if ((r23 & 4) == 0) goto L13;
        long r8 = r14.c;
    L15:
        if ((r23 & 8) == 0) goto L17;
        long r10 = r14.d;
    L19:
        if ((r23 & 16) == 0) goto L21;
        long r13 = r14.e;
    L23:
        return new i(r4, r6, r8, r10, r13);
    L21:
        r13 = r21;
        goto L23
    L17:
        r10 = r19;
        goto L19
    L13:
        r8 = r17;
        goto L15
    L9:
        r6 = r15;
        goto L11
    L5:
        r1 = 0;
        goto L6
    }
}
