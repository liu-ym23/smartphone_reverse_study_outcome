package com.ss.android.lark.message.lynxcard.message;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ LynxCardMessageCell a;
    public final /* synthetic */ v5b.c<v5b.a<?>> b;
    public final /* synthetic */ LynxCardViewHolder c;

    public e(LynxCardMessageCell r1, v5b.c<v5b.a<?>> r2, LynxCardViewHolder r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        LynxCardMessageCell r5 = this.a;
        r5.b.m(this.b, this.c.i, r5.a);
    }
}
