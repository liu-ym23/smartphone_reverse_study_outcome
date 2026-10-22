package com.obric.flow.cardlistpage.ui.component.overlayanimator;

/* JADX INFO: loaded from: classes3.dex */
public final class x extends c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f11713a;

    public x(boolean r5) {
        this.f11713a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof x) == true) goto L9;
        return false;
    L9:
        if (this.f11713a == ((x) r5).f11713a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f11713a);
    }

    public final String toString() {
        return "AnimateToShow(anim=" + this.f11713a + ")";
    }
}
