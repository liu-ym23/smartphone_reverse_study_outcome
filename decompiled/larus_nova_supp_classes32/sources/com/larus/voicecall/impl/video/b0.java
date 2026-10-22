package com.larus.voicecall.impl.video;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b0 {
    public final float a;
    public final int[] b;
    public final ViewPortContainerView c;
    public final float d;
    public final float e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b0) == true) goto L8;
        return false;
    L8:
        b0 r6 = (b0) r5;
        if (Float.compare(this.a, r6.a) == 0) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Float.compare(this.d, r6.d) == 0) goto L21;
        return false;
    L21:
        if (Float.compare(this.e, r6.e) == 0) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((Float.floatToIntBits(this.a) * 31) + Arrays.hashCode(this.b)) * 31) + this.c.hashCode()) * 31) + Float.floatToIntBits(this.d)) * 31) + Float.floatToIntBits(this.e);
    }

    public final String toString() {
        return "ZoomInOutAnimParam(scale=" + this.a + ", targetLocation=" + Arrays.toString(this.b) + ", viewPortContainer=" + this.c + ", fromAlpha=" + this.d + ", toAlpha=" + this.e + ')';
    }

    public b0(float r2, int[] r3, ViewPortContainerView r4, float r5, float r6) {
        Intrinsics.checkNotNullParameter(r3, "targetLocation");
        Intrinsics.checkNotNullParameter(r4, "viewPortContainer");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
