package com.obric.flow.cardlistpage.ui.component.popupdialog;

import com.obric.flow.cardlistpage.ui.view.WidgetBox;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WidgetBox f11716a;

    public a(WidgetBox r5) {
        this.f11716a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f11716a, ((a) r5).f11716a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        WidgetBox r5 = this.f11716a;
        if (r5 != null) goto L6;
        return 0;
    L6:
        return r5.hashCode();
    }

    public final String toString() {
        return "AnchorDescriptor(widgetBox=" + this.f11716a + ")";
    }
}
