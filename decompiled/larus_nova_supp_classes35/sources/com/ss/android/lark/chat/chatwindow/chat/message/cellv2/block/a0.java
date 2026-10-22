package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a0 implements View.OnLongClickListener {
    public final /* synthetic */ z a;
    public final /* synthetic */ com.ss.android.lark.blueprint.m<y6b.a<?>> b;
    public final /* synthetic */ y6b.c<?> c;

    public a0(z r1, com.ss.android.lark.blueprint.m<y6b.a<?>> r2, y6b.c<?> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r4) {
        z r5 = this.a;
        e6b.b r0 = this.b;
        y6b.c<?> r1 = this.c;
        r5.getClass();
        if ((r0 instanceof e6b.b) == false) goto L5;
        e6b.b r2 = r0;
    L6:
        if (r2 != null) goto L10;
        return false;
    L10:
        return r2.e(r5, r1);
    L5:
        r2 = null;
        goto L6
    }
}
