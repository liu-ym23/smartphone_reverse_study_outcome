package com.obric.flow.cardlistpage.ui.component.overlayanimator;

/* JADX INFO: loaded from: classes3.dex */
public final class g0 implements h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f11662a;

    public g0(boolean r5) {
        this.f11662a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g0) == true) goto L9;
        return false;
    L9:
        if (this.f11662a == ((g0) r5).f11662a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f11662a);
    }

    public final String toString() {
        return ai.j0.r(new StringBuilder("SnapToState(open="), this.f11662a, ")");
    }
}
