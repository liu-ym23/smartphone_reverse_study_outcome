package com.obric.flow.cardlistpage.ui.component.overlayanimator;

/* JADX INFO: loaded from: classes3.dex */
public final class f0 implements h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f11661a;

    public f0(float r5) {
        this.f11661a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f0) == true) goto L9;
        return false;
    L9:
        if (Float.compare(this.f11661a, ((f0) r5).f11661a) == 0) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return Float.hashCode(this.f11661a);
    }

    public final String toString() {
        return "RequestOverscrollSpringBack(velocityX=" + this.f11661a + ")";
    }
}
