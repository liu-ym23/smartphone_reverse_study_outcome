package com.obric.flow.cardlistpage.ui.component.popupdialog;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class u extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f11745a;

    public u(c r5) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        this.f11745a = r5;
    }

    @Override // com.obric.flow.cardlistpage.mvi.j
    public final String a() {
        c r5 = this.f11745a;
        b r10 = r5.f11722b;
        return ug.a.n(r10.f11720c, r5.f11723c.f11724a, r10.f11718a, String.valueOf(r10.f11719b));
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof u) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f11745a, ((u) r5).f11745a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f11745a.hashCode();
    }

    public final String toString() {
        return "ShowEditPopup(descriptor=" + this.f11745a + ")";
    }
}
