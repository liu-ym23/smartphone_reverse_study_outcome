package com.larus.dora.obric.device_management.explore;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class z0 {
    public final String a;
    public final int b;

    public z0() {
        this(null, 0, 3);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof z0) == true) goto L8;
        return false;
    L8:
        z0 r6 = (z0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (r1 * 31) + this.b;
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public final String toString() {
        return "DoraObricGlassesIntroductionImage(uri=" + this.a + ", resId=" + this.b + ')';
    }

    public z0(String r2, int r3, int r4) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = 0;
    L8:
        this.a = r2;
        this.b = r3;
    }
}
