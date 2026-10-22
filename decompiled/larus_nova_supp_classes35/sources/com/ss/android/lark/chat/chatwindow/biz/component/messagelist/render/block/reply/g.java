package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply;

import android.view.View;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.ReplyBlock;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g extends OnSingleClickListener {
    public final /* synthetic */ d a;
    public final /* synthetic */ b b;
    public final /* synthetic */ y6b.c<?> c;

    public final void onSingleClick(View r3) {
        Intrinsics.checkNotNullParameter(r3, "v");
        d r4 = this.a;
        c.a r0 = r4.d;
        if (r0 == null) goto L5;
        r0.b(this.b, this.c);
        return;
    L5:
        r4.d().b(this.b, this.c);
    }

    public g(d r1, ReplyBlock.a r2, y6b.c r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
