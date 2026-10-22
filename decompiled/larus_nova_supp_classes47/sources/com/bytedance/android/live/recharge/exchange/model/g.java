package com.bytedance.android.live.recharge.exchange.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g {
    public final int a;
    public final Throwable b;
    public final Integer c;
    public final String d;
    public final long e;
    public final com.bytedance.android.live.recharge.platform.business.model.exchange.b f;
    public final zv0.e g;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof g) == false) goto L20;
        g r7 = (g) r6;
        if (this.a == r7.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
        return false;
    L14:
        if (this.e == r7.e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r7.g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        Throwable r1 = this.b;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        Integer r5 = this.c;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.d;
        if (r8 == null) goto L13;
        int r9 = r8.hashCode();
    L14:
        long r10 = this.e;
        int r12 = (((r7 + r9) * 31) + ((int) (r10 ^ (r10 >>> 32)))) * 31;
        com.bytedance.android.live.recharge.platform.business.model.exchange.b r13 = this.f;
        if (r13 == null) goto L17;
        int r14 = r13.hashCode();
    L18:
        int r15 = (r12 + r14) * 31;
        zv0.e r16 = this.g;
        if (r16 == null) goto L22;
        r2 = r16.hashCode();
    L22:
        return r15 + r2;
    L17:
        r14 = 0;
        goto L18
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        return "StateBean(status=" + this.a + ", message=" + this.b + ", rebateCoin=" + this.c + ", rebateMessage=" + this.d + ", diamond=" + this.e + ", exchangeMarketData=" + this.f + ", listener=" + this.g + ")";
    }

    public g(int r3, Throwable r4, Integer r5, String r6, long r7, zv0.e r9, int r10) {
        if ((r10 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r10 & 4) == 0) goto L9;
        r5 = 0;
    L9:
        if ((r10 & 8) == 0) goto L12;
        r6 = null;
    L12:
        if ((r10 & 16) == 0) goto L15;
        r7 = 0;
    L15:
        if ((r10 & 64) == 0) goto L17;
        r9 = null;
    L17:
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = null;
        this.g = r9;
    }
}
