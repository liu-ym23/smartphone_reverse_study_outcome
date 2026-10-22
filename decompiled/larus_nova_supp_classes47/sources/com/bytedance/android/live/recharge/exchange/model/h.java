package com.bytedance.android.live.recharge.exchange.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h {
    public final boolean a;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof h) == true) goto L6;
        return false;
    L6:
        if (this.a == ((h) r2).a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        boolean r0 = this.a;
        if (r0 == false) goto L6;
        return 1;
    L6:
        return r0 ? 1 : 0;
    }

    public final String toString() {
        return "XiguaWalletInfo(showXiguaDiamondExchange=" + this.a + ")";
    }

    public h(boolean r1) {
        this.a = r1;
    }
}
