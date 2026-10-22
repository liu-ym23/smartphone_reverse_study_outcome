package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.view.View;
import com.ss.android.lark.chat.base.view.vo.message.PostContentVO;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d0 implements View.OnLongClickListener {
    public final /* synthetic */ com.ss.android.lark.blueprint.m<y6b.a<PostContentVO>> a;
    public final /* synthetic */ PostContentBlock b;
    public final /* synthetic */ y6b.a<PostContentVO> c;

    public d0(com.ss.android.lark.blueprint.m<y6b.a<PostContentVO>> r1, PostContentBlock r2, y6b.a<PostContentVO> r3) {
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
