package com.obric.flow.cardlistpage.ui.view;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class j implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WidgetBox f11856a;

    public /* synthetic */ j(WidgetBox r5) {
        this.f11856a = r5;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r5) {
        int r10 = WidgetBox.f11830j;
        WidgetBox r11 = this.f11856a;
        Intrinsics.checkNotNullParameter(r11, "this$0");
        return r11.performLongClick();
    }
}
