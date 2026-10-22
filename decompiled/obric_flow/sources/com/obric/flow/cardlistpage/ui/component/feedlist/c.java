package com.obric.flow.cardlistpage.ui.component.feedlist;

import com.obric.flow.cardlistpage.mvi.MviLogLevel;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f11580a = null;

    static {
        f11580a = new c();
    }

    @Override // com.obric.flow.cardlistpage.mvi.f
    public final String a() {
        return "RequestDismissEditPopup";
    }

    @Override // com.obric.flow.cardlistpage.mvi.f
    public final MviLogLevel b() {
        return MviLogLevel.INFO;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L9;
        return false;
    L9:
        return true;
    }

    public final int hashCode() {
        return -1327740731;
    }

    public final String toString() {
        return "RequestDismissEditPopup";
    }
}
