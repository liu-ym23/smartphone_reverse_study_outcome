package com.obric.flow.cardlistpage.ui.component.feedlist;

import ai.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final obric.flow.miniappwidget.f f11583a;

    public g(obric.flow.miniappwidget.f r5) {
        Intrinsics.checkNotNullParameter(r5, "input");
        this.f11583a = r5;
    }

    @Override // com.obric.flow.cardlistpage.mvi.e
    public final String a() {
        obric.flow.miniappwidget.f r5 = this.f11583a;
        return j0.l("AddMiniAppWidget(appletId=", r5.f20475a, ", widgetId=", r5.f20476b, ")");
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f11583a, ((g) r5).f11583a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f11583a.hashCode();
    }

    public final String toString() {
        return "AddMiniAppWidget(input=" + this.f11583a + ")";
    }
}
