package com.obric.flow.cardlistpage.ui.component.overlayanimator;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f11666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f11667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f11668c;
    public final boolean d;
    public final ControllerState e;
    public final OverlayTransitionMode f;

    public i0(float r5, float r10, float r11, boolean r12, ControllerState r13, OverlayTransitionMode r14) {
        Intrinsics.checkNotNullParameter(r13, "controllerState");
        Intrinsics.checkNotNullParameter(r14, "transitionMode");
        this.f11666a = r5;
        this.f11667b = r10;
        this.f11668c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i0) == true) goto L8;
        return false;
    L8:
        i0 r10 = (i0) r5;
        float r11 = r10.f11666a;
        if (Float.compare(this.f11666a, r11) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f11667b, r10.f11667b) == 0) goto L15;
        return false;
    L15:
        if (Float.compare(this.f11668c, r10.f11668c) == 0) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L21;
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
        int r5 = Float.hashCode(this.f11666a) * 31;
        int r10 = androidx.constraintlayout.motion.widget.a.b(this.f11667b, r5, 31);
        int r11 = androidx.room.jarjarred.org.antlr.runtime.a.d(androidx.constraintlayout.motion.widget.a.b(this.f11668c, r10, 31), 31, this.d);
        int r12 = (this.e.hashCode() + r11) * 31;
        return this.f.hashCode() + r12;
    }

    public final String toString() {
        return "OverlayRenderTarget(progress=" + this.f11666a + ", blurProgress=" + this.f11667b + ", alpha=" + this.f11668c + ", rtl=" + this.d + ", controllerState=" + this.e + ", transitionMode=" + this.f + ")";
    }
}
