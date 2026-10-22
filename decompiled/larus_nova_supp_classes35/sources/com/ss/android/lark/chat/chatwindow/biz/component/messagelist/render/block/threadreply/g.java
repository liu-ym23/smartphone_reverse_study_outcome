package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.threadreply;

import android.view.View;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.ThreadReplyBlock;
import com.ss.android.lark.widget.listener.OnSingleClickListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g extends OnSingleClickListener {
    public final /* synthetic */ d a;
    public final /* synthetic */ b b;
    public final /* synthetic */ y6b.c<?> c;

    public final void onSingleClick(View r3) {
        c r4 = this.a.c;
        if (r4 == null) goto L6;
        r4.a(this.b, this.c);
        return;
    }

    public g(d r1, ThreadReplyBlock.a r2, y6b.c r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
