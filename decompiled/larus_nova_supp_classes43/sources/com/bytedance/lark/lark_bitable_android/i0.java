package com.bytedance.lark.lark_bitable_android;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i0 {
    public final String a;
    public final boolean b;
    public final String c;
    public final List<f0> d;
    public final List<g0> e;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof i0) == true) goto L8;
        return false;
    L8:
        i0 r11 = (i0) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r11.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L7:
        return ((((((r0 + r1) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "HomepageListData(lastLabel=" + this.a + ", hasMore=" + this.b + ", spaceToken=" + this.c + ", docDataList=" + this.d + ", rawDataList=" + this.e + ')';
    }

    public i0(String r10, boolean r11, String r12, List<f0> r13, List<g0> r14) {
        Intrinsics.checkNotNullParameter(r10, "lastLabel");
        Intrinsics.checkNotNullParameter(r12, "spaceToken");
        Intrinsics.checkNotNullParameter(r13, "docDataList");
        Intrinsics.checkNotNullParameter(r14, "rawDataList");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
    }
}
