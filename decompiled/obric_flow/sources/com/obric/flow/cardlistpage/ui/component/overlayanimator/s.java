package com.obric.flow.cardlistpage.ui.component.overlayanimator;

/* JADX INFO: loaded from: classes3.dex */
public final class s implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f11704a;

    public s(float r5) {
        this.f11704a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof s) == true) goto L9;
        return false;
    L9:
        if (Float.compare(this.f11704a, ((s) r5).f11704a) == 0) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return Float.hashCode(this.f11704a);
    }

    public final String toString() {
        return "OnOverlayProgressChanged(progress=" + this.f11704a + ")";
    }
}
