package com.bytedance.android.live.recharge.deal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class u extends f {
    public final long b;
    public final long c;
    public final int d;
    public final int e;
    public final String f;
    public final String g;
    public final boolean h;
    public final int i;
    public final int j;
    public final String k;
    public final int l;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    public final int hashCode() {
        long r0 = this.b;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.c;
        int r2 = (((((r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.d) * 31) + this.e) * 31;
        String r4 = this.f;
        int r5 = 0;
        if (r4 == null) goto L5;
        int r6 = r4.hashCode();
    L6:
        int r7 = (r2 + r6) * 31;
        String r8 = this.g;
        if (r8 == null) goto L9;
        int r9 = r8.hashCode();
    L10:
        int r10 = (r7 + r9) * 31;
        boolean r12 = this.h;
        ?? r13 = r12;
        if (r12 == false) goto L13;
        r13 = 1;
    L13:
        int r14 = (((((r10 + r13) * 31) + this.i) * 31) + this.j) * 31;
        String r15 = this.k;
        if (r15 == null) goto L17;
        r5 = r15.hashCode();
    L17:
        return ((r14 + r5) * 31) + this.l;
    L9:
        r9 = 0;
        goto L10
    L5:
        r6 = 0;
        goto L6
    }

    public final String toString() {
        return "RegularDeal(dealId=" + this.b + ", price=" + this.c + ", diamondCount=" + this.d + ", rewardDiamondCount=" + this.e + ", description=" + this.f + ", iapProductId=" + this.g + ", isServerCustomized=" + this.h + ", discountPrice=" + this.i + ", exchangePrice=" + this.j + ", diamondSignInfo=" + this.k + ", describeType=" + this.l + ")";
    }

    @Override // com.bytedance.android.live.recharge.deal.f
    public final long b() {
        return this.b;
    }

    @Override // com.bytedance.android.live.recharge.deal.f
    public final String d() {
        return this.f;
    }

    @Override // com.bytedance.android.live.recharge.deal.f
    public final int e() {
        return this.d;
    }

    @Override // com.bytedance.android.live.recharge.deal.f
    public final String f() {
        return this.g;
    }

    @Override // com.bytedance.android.live.recharge.deal.f
    public final long g() {
        return this.c;
    }

    @Override // com.bytedance.android.live.recharge.deal.f
    public final int h() {
        return this.e;
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof u) == false) goto L28;
        u r7 = (u) r6;
        if (this.b == r7.b) goto L8;
        return false;
    L8:
        if (this.c == r7.c) goto L10;
        return false;
    L10:
        if (this.d == r7.d) goto L12;
        return false;
    L12:
        if (this.e == r7.e) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.g, r7.g) == true) goto L18;
        return false;
    L18:
        if (this.h == r7.h) goto L20;
        return false;
    L20:
        if (this.i == r7.i) goto L22;
        return false;
    L22:
        if (this.j == r7.j) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.k, r7.k) == true) goto L26;
        return false;
    L26:
        if (this.l == r7.l) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    public u(long r2, long r4, int r6, int r7, String r8, String r9, boolean r10, int r12, int r13, String r14, int r15) {
        Intrinsics.checkNotNullParameter(r8, "description");
        Intrinsics.checkNotNullParameter(r9, "iapProductId");
        Intrinsics.checkNotNullParameter(r14, "diamondSignInfo");
        this.b = r2;
        this.c = r4;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r12;
        this.j = r13;
        this.k = r14;
        this.l = r15;
    }
}
