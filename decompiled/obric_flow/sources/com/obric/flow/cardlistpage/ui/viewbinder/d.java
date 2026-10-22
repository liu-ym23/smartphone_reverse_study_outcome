package com.obric.flow.cardlistpage.ui.viewbinder;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MiniAppWidgetCardViewBinder$ViewHolder f11869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f11870b;

    public /* synthetic */ d(MiniAppWidgetCardViewBinder$ViewHolder r5, View r10) {
        this.f11869a = r5;
        this.f11870b = r10;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int r5 = MiniAppWidgetCardViewBinder$ViewHolder.f11859i;
        MiniAppWidgetCardViewBinder$ViewHolder r10 = this.f11869a;
        Intrinsics.checkNotNullParameter(r10, "this$0");
        View r11 = this.f11870b;
        Intrinsics.checkNotNullParameter(r11, "$view");
        r10.getClass();
        if (MiniAppWidgetCardViewBinder$ViewHolder.c(r11) == false) goto L6;
        r11.requestLayout();
        return;
    }
}
