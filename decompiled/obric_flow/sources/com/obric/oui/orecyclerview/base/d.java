package com.obric.oui.orecyclerview.base;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f13710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f13711b;

    public d(float r5, boolean r10) {
        this.f13710a = r5;
        this.f13711b = r10;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r10 = (d) r5;
        if (Intrinsics.areEqual(Float.valueOf(this.f13710a), Float.valueOf(r10.f13710a)) == true) goto L12;
        return false;
    L12:
        if (this.f13711b == r10.f13711b) goto L14;
        return false;
    L14:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    public final int hashCode() {
        int r5 = Float.hashCode(this.f13710a) * 31;
        boolean r10 = this.f13711b;
        ?? r11 = r10;
        if (r10 == false) goto L6;
        r11 = 1;
    L6:
        return r5 + r11;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("SpringBackValue(value=");
        r5.append(this.f13710a);
        r5.append(", isFinished=");
        return androidx.constraintlayout.motion.widget.a.w(r5, this.f13711b, ')');
    }
}
