package com.ss.android.lark.flow.chat.message.block.replay;

import android.view.View;
import com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply.d;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.ReplyBlock;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements View.OnLongClickListener {
    public final /* synthetic */ c a;
    public final /* synthetic */ com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply.b b;
    public final /* synthetic */ y6b.c<?> c;

    public b(c r1, ReplyBlock.a r2, y6b.c r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r3) {
        c r4 = this.a;
        com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply.c.a r0 = ((d) r4).d;
        if (r0 == null) goto L6;
        return r0.a(this.b, this.c);
    L6:
        return r4.f.a(this.b, this.c);
    }
}
