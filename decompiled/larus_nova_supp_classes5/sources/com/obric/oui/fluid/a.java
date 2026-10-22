package com.obric.oui.fluid;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a {
    public final float[] a;

    public a() {
        this(null);
    }

    public final String toString() {
        return "FluidConfig(glassParams=" + Arrays.toString(this.a) + ')';
    }

    public final int hashCode() {
        float[] r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return Arrays.hashCode(r0);
    }

    public a(float[] r1) {
        this.a = r1;
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (r4 != null) goto L8;
        Class<?> r2 = null;
    L10:
        if (Intrinsics.areEqual(a.class, r2) == true) goto L12;
        return false;
    L12:
        if (r4 == null) goto L18;
        if (Arrays.equals(this.a, ((a) r4).a) == true) goto L16;
        return false;
    L16:
        return true;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.fluid.FluidConfig");
    L8:
        r2 = r4.getClass();
        goto L10
    }
}
