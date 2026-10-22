package com.ss.android.lark.message.lynxcard.message;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class q implements View.OnAttachStateChangeListener {
    public final /* synthetic */ a a;

    public q(a r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r2) {
        LynxCardViewHolder r3 = LynxCardViewHolder.V3(r2);
        if (r3 == null) goto L6;
        this.a.b(r3);
        return;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r2) {
        LynxCardViewHolder r3 = LynxCardViewHolder.V3(r2);
        if (r3 == null) goto L6;
        this.a.j(r3);
        return;
    }
}
