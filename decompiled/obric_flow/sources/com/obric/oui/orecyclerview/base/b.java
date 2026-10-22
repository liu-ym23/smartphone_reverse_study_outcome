package com.obric.oui.orecyclerview.base;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f13706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f13707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f13708c;

    public b(float r5, float r10, boolean r11) {
        this.f13706a = r5;
        this.f13707b = r10;
        this.f13708c = r11;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r10 = (b) r5;
        if (Intrinsics.areEqual(Float.valueOf(this.f13706a), Float.valueOf(r10.f13706a)) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(Float.valueOf(this.f13707b), Float.valueOf(r10.f13707b)) == true) goto L15;
        return false;
    L15:
        if (this.f13708c == r10.f13708c) goto L17;
        return false;
    L17:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    public final int hashCode() {
        int r5 = Float.hashCode(this.f13706a) * 31;
        int r10 = androidx.constraintlayout.motion.widget.a.b(this.f13707b, r5, 31);
        boolean r11 = this.f13708c;
        ?? r12 = r11;
        if (r11 == false) goto L6;
        r12 = 1;
    L6:
        return r10 + r12;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("ScrollValue(value=");
        r5.append(this.f13706a);
        r5.append(", velocity=");
        r5.append(this.f13707b);
        r5.append(", isFinished=");
        return androidx.constraintlayout.motion.widget.a.w(r5, this.f13708c, ')');
    }
}
