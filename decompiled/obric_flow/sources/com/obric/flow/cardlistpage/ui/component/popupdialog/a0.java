package com.obric.flow.cardlistpage.ui.component.popupdialog;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f11717a;

    public a0(e r5) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        this.f11717a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a0) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f11717a, ((a0) r5).f11717a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f11717a.hashCode();
    }

    public final String toString() {
        return "Visible(descriptor=" + this.f11717a + ")";
    }
}
