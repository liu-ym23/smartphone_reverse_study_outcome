package com.obric.flow.cardlistpage.ui.component.floatingbtn;

import com.obric.flow.cardlistpage.mvi.MviLogLevel;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f11632a = null;

    static {
        f11632a = new b();
    }

    @Override // com.obric.flow.cardlistpage.mvi.f
    public final String a() {
        return "OnSettingsClick";
    }

    @Override // com.obric.flow.cardlistpage.mvi.f
    public final MviLogLevel b() {
        return MviLogLevel.INFO;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L9;
        return false;
    L9:
        return true;
    }

    public final int hashCode() {
        return 1415950164;
    }

    public final String toString() {
        return "OnSettingsClick";
    }
}
