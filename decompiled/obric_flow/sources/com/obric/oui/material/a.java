package com.obric.oui.material;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f13607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final es.a[] f13608b;

    public a(float r5, es.a[] r10) {
        Intrinsics.checkNotNullParameter(r10, "shadow");
        this.f13607a = r5;
        this.f13608b = r10;
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
        if (r5 == null) goto L20;
        a r11 = (a) r5;
        if (this.f13607a == r11.f13607a) goto L15;
        return false;
    L15:
        if (Arrays.equals(this.f13608b, r11.f13608b) == true) goto L17;
        return false;
    L17:
        return true;
    L20:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.material.BlurShadowConfig");
    L7:
        r10 = r5.getClass();
        goto L9
    }

    public final int hashCode() {
        return (int) ((31 * this.f13607a) + Arrays.hashCode(this.f13608b));
    }

    public final String toString() {
        return "BlurShadowConfig(blurRadius=" + this.f13607a + ", shadow=" + Arrays.toString(this.f13608b) + ')';
    }
}
