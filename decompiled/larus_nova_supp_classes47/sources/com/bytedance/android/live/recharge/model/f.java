package com.bytedance.android.live.recharge.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public final int a;
    public final String b;
    public final int c;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof f) == false) goto L12;
        f r4 = (f) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        String r1 = this.b;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return ((r0 + r2) * 31) + this.c;
    L5:
        r2 = 0;
        goto L7
    }

    public final String toString() {
        return "RechargeOtherParams(needAccount=" + this.a + ", enoughCallback=" + this.b + ", rechargeSource=" + this.c + ")";
    }

    public f(int r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "enoughCallback");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
