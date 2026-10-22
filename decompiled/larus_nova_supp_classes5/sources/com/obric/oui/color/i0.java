package com.obric.oui.color;

import com.obric.oui.graphic.BlendMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class i0 {
    public final float a;
    public final int b;
    public final BlendMode c;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i0) == true) goto L8;
        return false;
    L8:
        i0 r6 = (i0) r5;
        if (Intrinsics.areEqual(Float.valueOf(this.a), Float.valueOf(r6.a)) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((Float.floatToIntBits(this.a) * 31) + this.b) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "StrokeConfig(width=" + this.a + ", color=" + this.b + ", blendMode=" + this.c + ')';
    }

    public final j0 a() {
        return new j0(this.a, this.b, this.c);
    }

    public i0(float r2, int r3, BlendMode r4) {
        Intrinsics.checkNotNullParameter(r4, "blendMode");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
