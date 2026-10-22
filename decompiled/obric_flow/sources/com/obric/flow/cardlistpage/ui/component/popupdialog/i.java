package com.obric.flow.cardlistpage.ui.component.popupdialog;

import com.obric.flow.cardlistpage.mvi.MviLogLevel;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f11734a = null;

    static {
        f11734a = new i();
    }

    @Override // com.obric.flow.cardlistpage.mvi.f
    public final String a() {
        return "OnDismiss";
    }

    @Override // com.obric.flow.cardlistpage.mvi.f
    public final MviLogLevel b() {
        return MviLogLevel.INFO;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i) == true) goto L9;
        return false;
    L9:
        return true;
    }

    public final int hashCode() {
        return 394928629;
    }

    public final String toString() {
        return "OnDismiss";
    }
}
