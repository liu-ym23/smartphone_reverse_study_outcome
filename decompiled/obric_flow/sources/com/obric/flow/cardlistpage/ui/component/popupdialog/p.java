package com.obric.flow.cardlistpage.ui.component.popupdialog;

import ai.j0;

/* JADX INFO: loaded from: classes3.dex */
public final class p extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f11740a;

    public p(boolean r5) {
        this.f11740a = r5;
    }

    @Override // com.obric.flow.cardlistpage.mvi.j
    public final String a() {
        return j0.r(new StringBuilder("DismissAllPopup(withAnim="), this.f11740a, ")");
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof p) == true) goto L9;
        return false;
    L9:
        if (this.f11740a == ((p) r5).f11740a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f11740a);
    }

    public final String toString() {
        return j0.r(new StringBuilder("DismissAllPopup(withAnim="), this.f11740a, ")");
    }
}
