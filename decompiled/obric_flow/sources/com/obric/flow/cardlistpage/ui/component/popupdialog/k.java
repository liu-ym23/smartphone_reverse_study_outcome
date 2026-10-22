package com.obric.flow.cardlistpage.ui.component.popupdialog;

import com.obric.flow.cardlistpage.mvi.MviLogLevel;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f11737a = null;

    static {
        f11737a = new k();
    }

    @Override // com.obric.flow.cardlistpage.mvi.f
    public final String a() {
        return "OnShow";
    }

    @Override // com.obric.flow.cardlistpage.mvi.f
    public final MviLogLevel b() {
        return MviLogLevel.INFO;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof k) == true) goto L9;
        return false;
    L9:
        return true;
    }

    public final int hashCode() {
        return 202152818;
    }

    public final String toString() {
        return "OnShow";
    }
}
