package com.obric.oui.indicator;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f13499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f13500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f13501c;

    public o(float r5, float r10, float r11) {
        this.f13499a = r5;
        this.f13500b = r10;
        this.f13501c = r11;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof o) == true) goto L8;
        return false;
    L8:
        o r10 = (o) r5;
        if (Intrinsics.areEqual(Float.valueOf(this.f13499a), Float.valueOf(r10.f13499a)) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(Float.valueOf(this.f13500b), Float.valueOf(r10.f13500b)) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(Float.valueOf(this.f13501c), Float.valueOf(r10.f13501c)) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r5 = Float.hashCode(this.f13499a) * 31;
        int r10 = androidx.constraintlayout.motion.widget.a.b(this.f13500b, r5, 31);
        return Float.hashCode(this.f13501c) + r10;
    }

    public final String toString() {
        return "DotLayoutProfile(width=" + this.f13499a + ", height=" + this.f13500b + ", spacing=" + this.f13501c + ')';
    }
}
