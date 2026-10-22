package com.obric.flow.cardlistpage.ui.component.popupdialog;

/* JADX INFO: loaded from: classes3.dex */
public final class q extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f11741a = null;

    static {
        f11741a = new q();
    }

    @Override // com.obric.flow.cardlistpage.mvi.j
    public final String a() {
        return "DismissEditPopup";
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof q) == true) goto L9;
        return false;
    L9:
        return true;
    }

    public final int hashCode() {
        return 805510184;
    }

    public final String toString() {
        return "DismissEditPopup";
    }
}
