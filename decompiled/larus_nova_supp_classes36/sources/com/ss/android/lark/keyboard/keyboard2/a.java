package com.ss.android.lark.keyboard.keyboard2;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements View.OnAttachStateChangeListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ BasicKeyboard b;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r1) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r1) {
        this.a.removeOnAttachStateChangeListener(this);
        BasicKeyboard.Q(this.b);
    }

    public a(KeyboardRootContainer r1, BasicKeyboard r2) {
        this.a = r1;
        this.b = r2;
    }
}
