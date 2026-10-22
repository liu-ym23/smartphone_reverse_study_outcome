package com.obric.flow.cardlistpage.ui.component.popupdialog;

/* JADX INFO: loaded from: classes3.dex */
public final class t extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f11744a = null;

    static {
        f11744a = new t();
    }

    @Override // com.obric.flow.cardlistpage.mvi.j
    public final String a() {
        return "OnPopupDismissed";
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof t) == true) goto L9;
        return false;
    L9:
        return true;
    }

    public final int hashCode() {
        return -1701001236;
    }

    public final String toString() {
        return "OnPopupDismissed";
    }
}
