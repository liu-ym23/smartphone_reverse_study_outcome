package com.larus.dora.obric.device_management.explore;

import com.bytedance.dora.annotation.ProductNameType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class g {
    public final int a;
    public final ProductNameType b;
    public final z49.b c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        ProductNameType r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.c.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "DoraObricExploreDeviceRequest(order=" + this.a + ", productType=" + this.b + ", device=" + this.c + ')';
    }

    public g(int r2, ProductNameType r3, z49.b r4) {
        Intrinsics.checkNotNullParameter(r4, "device");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
