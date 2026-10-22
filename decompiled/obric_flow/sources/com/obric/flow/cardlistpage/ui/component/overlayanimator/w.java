package com.obric.flow.cardlistpage.ui.component.overlayanimator;

/* JADX INFO: loaded from: classes3.dex */
public final class w extends c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f11712a;

    public w(boolean r5) {
        this.f11712a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof w) == true) goto L9;
        return false;
    L9:
        if (this.f11712a == ((w) r5).f11712a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f11712a);
    }

    public final String toString() {
        return "AnimateToHidden(anim=" + this.f11712a + ")";
    }
}
