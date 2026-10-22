package com.obric.flow.cardlistpage.ui.component.feedlist;

import com.obric.flow.cardlistpage.mvi.MviLogLevel;
import com.obric.flow.cardlistpage.ui.view.WidgetBox;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WidgetBox f11579a;

    public b(WidgetBox r5) {
        Intrinsics.checkNotNullParameter(r5, "widgetBox");
        this.f11579a = r5;
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
        if ((r5 instanceof b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f11579a, ((b) r5).f11579a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f11579a.hashCode();
    }

    public final String toString() {
        return "NotifyWidgetDragStarted(widgetBox=" + this.f11579a + ")";
    }
}
