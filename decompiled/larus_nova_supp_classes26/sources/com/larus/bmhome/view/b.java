package com.larus.bmhome.view;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public final int a;
    public final float b;
    public final int c;
    public final int d;
    public final Integer e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Float.compare(this.b, r6.b) == 0) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a * 31) + Float.floatToIntBits(this.b)) * 31) + this.c) * 31) + this.d) * 31;
        Integer r1 = this.e;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "BottomMenuColorStyle(textColor=" + this.a + ", iconAlpha=" + this.b + ", iconTint=" + this.c + ", backgroundAlpha=" + this.d + ", backgroundDrawableRes=" + this.e + ')';
    }

    public /* synthetic */ b(int r7, Integer r8) {
        this(r7, 1.0f, 0, 255, r8);
    }

    public b(int r1, float r2, int r3, int r4, Integer r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
