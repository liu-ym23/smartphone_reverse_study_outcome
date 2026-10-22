package com.obric.miniapp.lynx;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class x5 {
    public final int a;
    public final int b;
    public final int c;
    public final float d;
    public final com.obric.oui.material.c e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof x5) == true) goto L8;
        return false;
    L8:
        x5 r6 = (x5) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Float.compare(this.d, r6.d) == 0) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.a * 31) + this.b) * 31) + this.c) * 31) + Float.floatToIntBits(this.d)) * 31) + this.e.hashCode();
    }

    public final String toString() {
        return "MiniAppMenuBackgroundAppearance(backgroundColor=" + this.a + ", borderColor=" + this.b + ", borderWidthPx=" + this.c + ", cornerRadiusPx=" + this.d + ", materialConfig=" + this.e + ')';
    }

    public x5(int r2, int r3, int r4, float r5, com.obric.oui.material.c r6) {
        Intrinsics.checkNotNullParameter(r6, "materialConfig");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
