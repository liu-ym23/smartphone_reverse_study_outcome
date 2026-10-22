package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply;

import android.view.View;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.ReplyBlock;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f implements View.OnLongClickListener {
    public final /* synthetic */ d a;
    public final /* synthetic */ b b;
    public final /* synthetic */ y6b.c<?> c;

    public f(d r1, ReplyBlock.a r2, y6b.c r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r3) {
        d r4 = this.a;
        c.a r0 = r4.d;
        if (r0 == null) goto L6;
        return r0.a(this.b, this.c);
    L6:
        return r4.d().a(this.b, this.c);
    }
}
