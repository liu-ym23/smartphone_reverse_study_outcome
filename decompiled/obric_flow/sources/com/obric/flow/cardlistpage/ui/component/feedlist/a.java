package com.obric.flow.cardlistpage.ui.component.feedlist;

import com.obric.flow.cardlistpage.mvi.MviLogLevel;
import com.obric.flow.cardlistpage.ui.view.WidgetBox;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WidgetBox f11578a;

    public a(WidgetBox r5) {
        Intrinsics.checkNotNullParameter(r5, "widgetBox");
        this.f11578a = r5;
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
        if ((r5 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f11578a, ((a) r5).f11578a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f11578a.hashCode();
    }

    public final String toString() {
        return "NotifyWidgetDragEnd(widgetBox=" + this.f11578a + ")";
    }
}
