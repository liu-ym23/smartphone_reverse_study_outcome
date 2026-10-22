package com.obric.flow.cardlistpage.ui.component.overlayanimator;

/* JADX INFO: loaded from: classes3.dex */
public final class z extends c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f11715a;

    public z(boolean r5) {
        this.f11715a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof z) == true) goto L9;
        return false;
    L9:
        if (this.f11715a == ((z) r5).f11715a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f11715a);
    }

    public final String toString() {
        return ai.j0.r(new StringBuilder("SnapToState(open="), this.f11715a, ")");
    }
}
