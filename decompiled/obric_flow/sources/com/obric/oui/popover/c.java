package com.obric.oui.popover;

import ai.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f14125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f14126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f14127c;
    public int d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r10 = (c) r5;
        if (Intrinsics.areEqual(Float.valueOf(this.f14125a), Float.valueOf(r10.f14125a)) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(Float.valueOf(this.f14126b), Float.valueOf(r10.f14126b)) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(Float.valueOf(this.f14127c), Float.valueOf(r10.f14127c)) == true) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r5 = Float.hashCode(this.f14125a) * 31;
        int r10 = androidx.constraintlayout.motion.widget.a.b(this.f14126b, r5, 31);
        int r11 = androidx.constraintlayout.motion.widget.a.b(this.f14127c, r10, 31);
        return Integer.hashCode(this.d) + r11;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("ShadowConfig(radius=");
        r5.append(this.f14125a);
        r5.append(", dx=");
        r5.append(this.f14126b);
        r5.append(", dy=");
        r5.append(this.f14127c);
        r5.append(", color=");
        return j0.n(r5, this.d, ')');
    }
}
