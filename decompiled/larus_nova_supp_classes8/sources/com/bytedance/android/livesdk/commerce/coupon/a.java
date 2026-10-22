package com.bytedance.android.livesdk.commerce.coupon;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public final int a;
    public final long b;
    public final String c;
    public final int d;
    public final long e;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.commerce.coupon.a$a, reason: collision with other inner class name */
    public static final class C0108a {
    }

    static {
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof a) == false) goto L16;
        a r7 = (a) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
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
        int r0 = this.a * 31;
        long r1 = this.b;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        String r3 = this.c;
        if (r3 == null) goto L5;
        int r4 = r3.hashCode();
    L6:
        int r5 = (((r2 + r4) * 31) + this.d) * 31;
        long r6 = this.e;
        return r5 + ((int) (r6 ^ (r6 >>> 32)));
    L5:
        r4 = 0;
        goto L6
    }

    public final String toString() {
        return "CouponMessage(msgType=" + this.a + ", serverTime=" + this.b + ", activity=" + this.c + ", couponType=" + this.d + ", metaId=" + this.e + ")";
    }

    public final String getActivity() {
        return this.c;
    }

    public a(int r1, long r2, String r4, int r5, long r6) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
