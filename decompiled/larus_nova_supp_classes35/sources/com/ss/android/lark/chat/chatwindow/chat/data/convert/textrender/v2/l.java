package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class l implements View.OnAttachStateChangeListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ TextLayoutCacheStoreImpl2 b;
    public final /* synthetic */ com.ss.android.lark.widget.light.viewstub.h c;
    public final /* synthetic */ View d;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r1) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r3) {
        this.a.removeOnAttachStateChangeListener(this);
        this.b.g(this.c, this.d);
    }

    public l(View r1, TextLayoutCacheStoreImpl2 r2, com.ss.android.lark.widget.light.viewstub.h r3, View r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
