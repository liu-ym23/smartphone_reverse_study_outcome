package com.obric.flow.cardlistpage.ui.component.floatingbtn;

import com.obric.flow.cardlistpage.mvi.MviLogLevel;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11631a = null;

    static {
        f11631a = new a();
    }

    @Override // com.obric.flow.cardlistpage.mvi.f
    public final String a() {
        return "OnAddWidgetClick";
    }

    @Override // com.obric.flow.cardlistpage.mvi.f
    public final MviLogLevel b() {
        return MviLogLevel.INFO;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L9;
        return false;
    L9:
        return true;
    }

    public final int hashCode() {
        return -1320418316;
    }

    public final String toString() {
        return "OnAddWidgetClick";
    }
}
