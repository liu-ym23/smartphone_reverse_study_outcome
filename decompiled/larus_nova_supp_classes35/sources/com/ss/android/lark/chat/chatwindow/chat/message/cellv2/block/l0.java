package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class l0 implements View.OnLongClickListener {
    public final /* synthetic */ com.ss.android.lark.blueprint.m<y6b.a<com.ss.android.lark.chat.base.view.vo.message.e>> a;
    public final /* synthetic */ TextContentBlock b;
    public final /* synthetic */ y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> c;

    public l0(com.ss.android.lark.blueprint.m<y6b.a<com.ss.android.lark.chat.base.view.vo.message.e>> r1, TextContentBlock r2, y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r3) {
        e6b.b r4 = this.a;
        if ((r4 instanceof e6b.b) == false) goto L5;
        e6b.b r5 = r4;
    L6:
        if (r5 != null) goto L10;
        return false;
    L10:
        return r5.e(this.b, this.c);
    L5:
        r5 = null;
        goto L6
    }
}
