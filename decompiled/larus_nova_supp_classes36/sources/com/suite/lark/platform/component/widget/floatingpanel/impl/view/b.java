package com.suite.lark.platform.component.widget.floatingpanel.impl.view;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements View.OnLayoutChangeListener {
    public final /* synthetic */ FloatingCardContainer a;

    public b(FloatingCardContainer r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        r1.removeOnLayoutChangeListener(this);
        FloatingCardContainer r10 = this.a;
        int r11 = FloatingCardContainer.h;
        r10.c(false);
    }
}
