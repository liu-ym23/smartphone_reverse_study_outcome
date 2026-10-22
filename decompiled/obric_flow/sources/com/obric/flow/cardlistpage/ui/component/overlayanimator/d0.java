package com.obric.flow.cardlistpage.ui.component.overlayanimator;

/* JADX INFO: loaded from: classes3.dex */
public final class d0 implements h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f11654a;

    public d0(boolean r5) {
        this.f11654a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d0) == true) goto L9;
        return false;
    L9:
        if (this.f11654a == ((d0) r5).f11654a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f11654a);
    }

    public final String toString() {
        return "AnimateTo(open=" + this.f11654a + ")";
    }
}
