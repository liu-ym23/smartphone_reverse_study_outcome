package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import com.ss.android.lark.chat.base.model.dispatch.ActionDispatcher;
import com.ss.android.lark.chat.chatwindow.chat.menu.handler.ReactionHandler;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.reaction.widget.detailwindow.ReactionPopupFacade;
import com.ss.android.lark.reaction.widget.flowlayout.ReactionFlowLayout;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i0 implements ReactionFlowLayout.b {
    public final /* synthetic */ ReactionBlock a;
    public final /* synthetic */ y6b.c<?> b;

    public i0(ReactionBlock r1, y6b.c<?> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(String r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        List r0 = this.a.c.j5().c(mya.d.class);
        if ((!r0.isEmpty()) == false) goto L10;
        Iterator r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L17;
        ((mya.d) r1.next()).t(this.b.c, r5);
        goto L8
    L17:
        return;
    L10:
        final ReactionHandler r2 = this.a.i;
        String r3 = this.b.c;
        f5b.b r4 = (f5b.b) ActionDispatcher.from(r2.a).dispatchSyncQuery(new com.ss.android.lark.chat.base.model.dispatch.b(r3));
        if (r4 != null) goto L13;
        Log.e("ReactionHandler", "click more reaction error: message info is null, message id = " + r3 + ", reaction key = " + r5);
        return;
    L13:
        final ReactionPopupFacade r6 = ReactionPopupFacade.S90(k7b.a.b(r4.getReactionInfoList()), r5, false);
        r6.f = new com.ss.android.lark.chat.chatwindow.chat.menu.handler.r(r2, r6);
        r6.U90(r2.a.getSupportFragmentManager());
    }
}
