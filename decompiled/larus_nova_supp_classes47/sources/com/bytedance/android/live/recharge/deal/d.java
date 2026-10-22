package com.bytedance.android.live.recharge.deal;

import com.bytedance.android.live.saas.middleware.fresco.DefaultConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d extends f {
    public final long b;
    public final long c;
    public final int d;
    public final String e;
    public final String f;
    public final long g;
    public final long h;
    public final float i;
    public final String j;
    public final boolean k;

    @Override // com.bytedance.android.live.recharge.deal.f
    public final int e() {
        return (int) (this.i * this.c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r1v18, types: [int] */
    public final int hashCode() {
        long r0 = this.b;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.c;
        int r2 = (((r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.d) * 31;
        String r4 = this.e;
        int r5 = 0;
        if (r4 == null) goto L5;
        int r6 = r4.hashCode();
    L6:
        int r7 = (r2 + r6) * 31;
        String r8 = this.f;
        if (r8 == null) goto L9;
        int r9 = r8.hashCode();
    L10:
        long r10 = this.g;
        int r12 = (((r7 + r9) * 31) + ((int) (r10 ^ (r10 >>> 32)))) * 31;
        long r13 = this.h;
        int r14 = (((r12 + ((int) (r13 ^ (r13 >>> 32)))) * 31) + Float.floatToIntBits(this.i)) * 31;
        String r15 = this.j;
        if (r15 == null) goto L13;
        r5 = r15.hashCode();
    L13:
        int r16 = (r14 + r5) * 31;
        boolean r17 = this.k;
        ?? r18 = r17;
        if (r17 == false) goto L17;
        r18 = 1;
    L17:
        return r16 + r18;
    L9:
        r9 = 0;
        goto L10
    L5:
        r6 = 0;
        goto L6
    }

    public final String toString() {
        return "CustomDeal(dealId=" + this.b + ", price=" + this.c + ", rewardDiamondCount=" + this.d + ", description=" + this.e + ", iapProductId=" + this.f + ", priceMin=" + this.g + ", priceMax=" + this.h + ", diamondCountRate=" + this.i + ", couponId=" + this.j + ", isUserCustomized=" + this.k + ")";
    }

    @Override // com.bytedance.android.live.recharge.deal.f
    public final long b() {
        return this.b;
    }

    @Override // com.bytedance.android.live.recharge.deal.f
    public final String d() {
        return this.e;
    }

    @Override // com.bytedance.android.live.recharge.deal.f
    public final String f() {
        return this.f;
    }

    @Override // com.bytedance.android.live.recharge.deal.f
    public final long g() {
        return this.c;
    }

    @Override // com.bytedance.android.live.recharge.deal.f
    public final int h() {
        return this.d;
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof d) == false) goto L26;
        d r7 = (d) r6;
        if (this.b == r7.b) goto L8;
        return false;
    L8:
        if (this.c == r7.c) goto L10;
        return false;
    L10:
        if (this.d == r7.d) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.e, r7.e) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f, r7.f) == true) goto L16;
        return false;
    L16:
        if (this.g == r7.g) goto L18;
        return false;
    L18:
        if (this.h == r7.h) goto L20;
        return false;
    L20:
        if (Float.compare(this.i, r7.i) == 0) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.j, r7.j) == true) goto L24;
        return false;
    L24:
        if (this.k == r7.k) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public static d j(d r22, long r23, boolean r25, int r26) {
        long r3 = 0;
        if ((r26 & 1) == 0) goto L5;
        long r8 = r22.b;
    L7:
        if ((r26 & 2) == 0) goto L9;
        long r10 = r22.c;
    L11:
        if ((r26 & 4) == 0) goto L13;
        int r12 = r22.d;
    L15:
        if ((r26 & 8) == 0) goto L17;
        String r13 = r22.e;
    L19:
        if ((r26 & 16) == 0) goto L21;
        String r14 = r22.f;
    L23:
        if ((r26 & 32) == 0) goto L25;
        long r15 = r22.g;
    L27:
        if ((r26 & 64) == 0) goto L29;
        r3 = r22.h;
    L29:
        long r17 = r3;
        if ((r26 & 128) == 0) goto L32;
        float r19 = r22.i;
    L34:
        if ((r26 & DefaultConfig.MAX_CACHE_ENTRIES) == 0) goto L36;
        String r2 = r22.j;
    L38:
        if ((r26 & 512) == 0) goto L40;
        boolean r24 = r22.k;
    L41:
        r22.getClass();
        Intrinsics.checkNotNullParameter(r13, "description");
        Intrinsics.checkNotNullParameter(r14, "iapProductId");
        Intrinsics.checkNotNullParameter(r2, "couponId");
        return new d(r8, r10, r12, r13, r14, r15, r17, r19, r2, r24);
    L40:
        r24 = r25;
        goto L41
    L36:
        r2 = null;
        goto L38
    L32:
        r19 = 0.0f;
        goto L34
    L25:
        r15 = 0;
        goto L27
    L21:
        r14 = null;
        goto L23
    L17:
        r13 = null;
        goto L19
    L13:
        r12 = 0;
        goto L15
    L9:
        r10 = r23;
        goto L11
    L5:
        r8 = 0;
        goto L7
    }

    public d(long r2, long r4, int r6, String r7, String r8, long r9, long r12, float r13, String r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r7, "description");
        Intrinsics.checkNotNullParameter(r8, "iapProductId");
        Intrinsics.checkNotNullParameter(r14, "couponId");
        this.b = r2;
        this.c = r4;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r12;
        this.i = r13;
        this.j = r14;
        this.k = r15;
    }
}
