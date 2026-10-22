package com.obric.flow.cardlistpage.ui.component.feedlist;

import com.obric.flow.cardlistpage.mvi.MviLogLevel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.obric.flow.cardlistpage.ui.component.popupdialog.c f11581a;

    public d(com.obric.flow.cardlistpage.ui.component.popupdialog.c r5) {
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        this.f11581a = r5;
    }

    @Override // com.obric.flow.cardlistpage.mvi.f
    public final String a() {
        return toString();
    }

    @Override // com.obric.flow.cardlistpage.mvi.f
    public final MviLogLevel b() {
        return MviLogLevel.INFO;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f11581a, ((d) r5).f11581a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f11581a.hashCode();
    }

    public final String toString() {
        return "RequestShowEditPopup(descriptor=" + this.f11581a + ")";
    }
}
