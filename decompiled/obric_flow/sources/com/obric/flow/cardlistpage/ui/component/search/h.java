package com.obric.flow.cardlistpage.ui.component.search;

import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f11760a;

    public h(i r5) {
        this.f11760a = r5;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r5, int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17) {
        r5.removeOnLayoutChangeListener(this);
        this.f11760a.e.invoke(Integer.valueOf(r5.getBottom()));
    }
}
