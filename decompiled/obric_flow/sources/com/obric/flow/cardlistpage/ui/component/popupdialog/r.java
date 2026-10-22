package com.obric.flow.cardlistpage.ui.component.popupdialog;

import com.obric.flow.cardlistpage.ui.view.WidgetBox;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class r extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WidgetBox f11742a;

    public r(WidgetBox r5) {
        Intrinsics.checkNotNullParameter(r5, "widgetBox");
        this.f11742a = r5;
    }

    @Override // com.obric.flow.cardlistpage.mvi.j
    public final String a() {
        return "NotifyWidgetDragEnd";
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof r) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f11742a, ((r) r5).f11742a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f11742a.hashCode();
    }

    public final String toString() {
        return "NotifyWidgetDragEnd(widgetBox=" + this.f11742a + ")";
    }
}
