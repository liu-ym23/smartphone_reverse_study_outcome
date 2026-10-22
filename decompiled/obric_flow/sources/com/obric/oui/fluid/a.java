package com.obric.oui.fluid;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f13225a;

    public a(float[] r5) {
        this.f13225a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L5;
        return true;
    L5:
        if (r5 != null) goto L7;
        Class<?> r10 = null;
    L9:
        if (Intrinsics.areEqual(a.class, r10) == true) goto L11;
        return false;
    L11:
        if (r5 == null) goto L17;
        if (Arrays.equals(this.f13225a, ((a) r5).f13225a) == true) goto L15;
        return false;
    L15:
        return true;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.fluid.FluidConfig");
    L7:
        r10 = r5.getClass();
        goto L9
    }

    public final int hashCode() {
        float[] r5 = this.f13225a;
        if (r5 != null) goto L6;
        return 0;
    L6:
        return Arrays.hashCode(r5);
    }

    public final String toString() {
        return "FluidConfig(glassParams=" + Arrays.toString(this.f13225a) + ')';
    }
}
