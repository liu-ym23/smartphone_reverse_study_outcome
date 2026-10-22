package com.obric.oui.blur;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public float a;
    public int b;
    public float c;
    public final int d;
    public final float e;

    public a() {
        int r0 = 0;
        float r2 = 0.0f;
        this(r2, r0, r0, 31);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(Float.valueOf(this.a), Float.valueOf(r6.a)) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(Float.valueOf(this.c), Float.valueOf(r6.c)) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(Float.valueOf(this.e), Float.valueOf(r6.e)) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((Float.floatToIntBits(this.a) * 31) + this.b) * 31) + Float.floatToIntBits(this.c)) * 31) + this.d) * 31) + Float.floatToIntBits(this.e);
    }

    public final String toString() {
        return "BlurConfig(blurRadius=" + this.a + ", direction=" + this.b + ", alpha=" + this.c + ", curveType=" + this.d + ", endPoint=" + this.e + ')';
    }

    public /* synthetic */ a(float r9, int r10, int r11, int r12) {
        if ((r12 & 1) == 0) goto L5;
        float r3 = 0.0f;
    L7:
        if ((r12 & 2) == 0) goto L9;
        int r4 = 0;
    L11:
        if ((r12 & 4) == 0) goto L13;
        float r5 = 1.0f;
    L15:
        if ((r12 & 8) == 0) goto L17;
        int r6 = 0;
    L19:
        if ((r12 & 16) == 0) goto L21;
        float r7 = 1.0f;
    L22:
        this(r3, r4, r5, r6, r7);
        return;
    L21:
        r7 = 0.0f;
        goto L22
    L17:
        r6 = r11;
        goto L19
    L13:
        r5 = 0.0f;
        goto L15
    L9:
        r4 = r10;
        goto L11
    L5:
        r3 = r9;
        goto L7
    }

    public a(float r1, int r2, float r3, int r4, float r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
