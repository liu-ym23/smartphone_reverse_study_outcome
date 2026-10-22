package com.ss.android.lark.flow.chat.message.block.sharegroup;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.biz.im.api.bundle.ChatBundle;
import com.ss.android.lark.biz.im.api.bundle.SourceType;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import w4b.g;
import w4b.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ Chat a;
    public final /* synthetic */ Message b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ View.OnClickListener d;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        e.a(this.a, this.b, false, null);
        g r0 = ChatCoreModule.a().getChatDependency();
        Context r1 = this.c;
        ChatBundle.a r2 = new ChatBundle.a();
        r2.a = this.a.getId();
        r2.h = SourceType.CARD;
        r2.d = "group_share";
        r0.openChat(r1, new ChatBundle(r2));
        m r3 = ChatCoreModule.a().getFeedDependency();
        this.a.getId();
        r3.e();
        View.OnClickListener r4 = this.d;
        if (r4 == null) goto L6;
        r4.onClick(r5);
        return;
    }

    public b(Chat r1, Message r2, Context r3, FlowShareGroupContentBlock.c r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
