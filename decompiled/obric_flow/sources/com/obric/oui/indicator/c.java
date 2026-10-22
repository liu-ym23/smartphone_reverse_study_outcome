package com.obric.oui.indicator;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f13470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f13471c;
    public final IndicatorViewportShiftDirection d;
    public final IndicatorAnimator$RenderReason e;

    public c(int r5, h r10, h r11, IndicatorViewportShiftDirection r12, IndicatorAnimator$RenderReason r13) {
        Intrinsics.checkNotNullParameter(r10, "sourceState");
        Intrinsics.checkNotNullParameter(r11, "targetState");
        Intrinsics.checkNotNullParameter(r12, "direction");
        Intrinsics.checkNotNullParameter(r13, "reason");
        this.f13469a = r5;
        this.f13470b = r10;
        this.f13471c = r11;
        this.d = r12;
        this.e = r13;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r10 = (c) r5;
        int r11 = r10.f13469a;
        if (this.f13469a == r11) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f13470b, r10.f13470b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f13471c, r10.f13471c) == true) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L21;
        return false;
    L21:
        if (this.e == r10.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r5 = Integer.hashCode(this.f13469a) * 31;
        int r10 = (this.f13470b.hashCode() + r5) * 31;
        int r11 = (this.f13471c.hashCode() + r10) * 31;
        int r12 = (this.d.hashCode() + r11) * 31;
        return this.e.hashCode() + r12;
    }

    public final String toString() {
        return "ActiveViewportTransition(transitionToken=" + this.f13469a + ", sourceState=" + this.f13470b + ", targetState=" + this.f13471c + ", direction=" + this.d + ", reason=" + this.e + ')';
    }
}
