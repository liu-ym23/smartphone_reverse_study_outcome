package com.obric.flow.cardlistpage.ui.component.overlayanimator;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f11671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ControllerState f11672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f11673c;
    public final float d;
    public final boolean e;
    public final boolean f;

    public j0(boolean r5, ControllerState r10, float r11, float r12, boolean r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r10, "controllerState");
        this.f11671a = r5;
        this.f11672b = r10;
        this.f11673c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j0) == true) goto L8;
        return false;
    L8:
        j0 r10 = (j0) r5;
        boolean r11 = r10.f11671a;
        if (this.f11671a == r11) goto L12;
        return false;
    L12:
        if (this.f11672b == r10.f11672b) goto L15;
        return false;
    L15:
        if (Float.compare(this.f11673c, r10.f11673c) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.d, r10.d) == 0) goto L21;
        return false;
    L21:
        if (this.e == r10.e) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r5 = Boolean.hashCode(this.f11671a) * 31;
        int r10 = (this.f11672b.hashCode() + r5) * 31;
        int r11 = androidx.constraintlayout.motion.widget.a.b(this.f11673c, r10, 31);
        int r12 = androidx.room.jarjarred.org.antlr.runtime.a.d(androidx.constraintlayout.motion.widget.a.b(this.d, r11, 31), 31, this.e);
        return Boolean.hashCode(this.f) + r12;
    }

    public final String toString() {
        return "OverlayVisualDescriptor(committedOpen=" + this.f11671a + ", controllerState=" + this.f11672b + ", progress=" + this.f11673c + ", alpha=" + this.d + ", isDragging=" + this.e + ", isAnimating=" + this.f + ")";
    }
}
