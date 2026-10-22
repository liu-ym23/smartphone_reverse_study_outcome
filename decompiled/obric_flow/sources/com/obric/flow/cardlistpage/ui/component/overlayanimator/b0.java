package com.obric.flow.cardlistpage.ui.component.overlayanimator;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 extends c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f11650a;

    public b0(boolean r5) {
        this.f11650a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b0) == true) goto L9;
        return false;
    L9:
        if (this.f11650a == ((b0) r5).f11650a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f11650a);
    }

    public final String toString() {
        return "UpdateVisibility(isVisible=" + this.f11650a + ")";
    }
}
