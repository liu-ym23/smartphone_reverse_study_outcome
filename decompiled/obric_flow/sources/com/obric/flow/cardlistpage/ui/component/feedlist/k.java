package com.obric.flow.cardlistpage.ui.component.feedlist;

import ai.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11590a;

    public k(String r5) {
        Intrinsics.checkNotNullParameter(r5, "appletId");
        this.f11590a = r5;
    }

    @Override // com.obric.flow.cardlistpage.mvi.e
    public final String a() {
        return j0.q(new StringBuilder("RemoveMiniAppWidgetsByAppletId(appletId="), this.f11590a, ")");
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof k) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f11590a, ((k) r5).f11590a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f11590a.hashCode();
    }

    public final String toString() {
        return j0.q(new StringBuilder("RemoveMiniAppWidgetsByAppletId(appletId="), this.f11590a, ")");
    }
}
