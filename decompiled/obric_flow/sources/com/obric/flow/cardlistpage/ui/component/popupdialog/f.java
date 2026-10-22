package com.obric.flow.cardlistpage.ui.component.popupdialog;

import com.obric.flow.cardlistpage.mvi.MviLogLevel;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f11729a = null;

    static {
        f11729a = new f();
    }

    @Override // com.obric.flow.cardlistpage.mvi.f
    public final String a() {
        return "OnAddWidget";
    }

    @Override // com.obric.flow.cardlistpage.mvi.f
    public final MviLogLevel b() {
        return MviLogLevel.INFO;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L9;
        return false;
    L9:
        return true;
    }

    public final int hashCode() {
        return 1514619632;
    }

    public final String toString() {
        return "OnAddWidget";
    }
}
