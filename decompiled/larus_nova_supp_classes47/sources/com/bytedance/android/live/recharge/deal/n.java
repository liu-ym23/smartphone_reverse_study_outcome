package com.bytedance.android.live.recharge.deal;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n extends f {
    public final long b;
    public final String c;
    public final String d;
    public final int e;
    public final int f;
    public final int g;

    @Override // com.bytedance.android.live.recharge.deal.f
    public final long b() {
        return 0;
    }

    @Override // com.bytedance.android.live.recharge.deal.f
    public final int h() {
        return 0;
    }

    public final int hashCode() {
        return (((this.e * 31) + this.f) * 31) + this.g;
    }

    public final String toString() {
        return "ExchangeCustomDeal(diamondCount=" + this.e + ", cashAmount=" + this.f + ", goldAmount=" + this.g + ")";
    }

    @Override // com.bytedance.android.live.recharge.deal.f
    public final String d() {
        return this.c;
    }

    @Override // com.bytedance.android.live.recharge.deal.f
    public final int e() {
        return this.e;
    }

    @Override // com.bytedance.android.live.recharge.deal.f
    public final String f() {
        return this.d;
    }

    @Override // com.bytedance.android.live.recharge.deal.f
    public final long g() {
        return this.b;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof n) == false) goto L12;
        n r4 = (n) r3;
        if (this.e == r4.e) goto L8;
        return false;
    L8:
        if (this.f == r4.f) goto L10;
        return false;
    L10:
        if (this.g == r4.g) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public n(int r3, int r4, int r5) {
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.b = ((long) r3) * 10;
        this.c = "";
        this.d = "";
    }
}
