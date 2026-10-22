package com.obric.flow.cardlistpage.ui.component.popupdialog;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class v extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f11746a;

    public v(d r5) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        this.f11746a = r5;
    }

    @Override // com.obric.flow.cardlistpage.mvi.j
    public final String a() {
        return "ShowExternalLongClickPopup";
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof v) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f11746a, ((v) r5).f11746a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f11746a.hashCode();
    }

    public final String toString() {
        return "ShowExternalLongClickPopup(descriptor=" + this.f11746a + ")";
    }
}
