package com.bytedance.android.live.ktv.common.karaokestation.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public final OrderSongRequiredConfig a;
    public final u b;

    public a() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L10;
        a r4 = (a) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        OrderSongRequiredConfig r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        u r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "CommonOrderSongConfig(requiredConfig=" + this.a + ", optionalConfig=" + this.b + ")";
    }

    public /* synthetic */ a(int r21) {
        this(new OrderSongRequiredConfig(0), new u(null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, 65535));
    }

    public a(OrderSongRequiredConfig r2, u r3) {
        Intrinsics.checkNotNullParameter(r2, "requiredConfig");
        Intrinsics.checkNotNullParameter(r3, "optionalConfig");
        this.a = r2;
        this.b = r3;
    }
}
