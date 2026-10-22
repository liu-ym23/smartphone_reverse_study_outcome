package com.ss.android.lark.flow.chat.message.block.sharegroup;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.chat.api.service.IChatService;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.ShareGroupChatContent;
import com.ss.android.lark.statistics.message.MessageHitPoint;
import w4b.e0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ View.OnClickListener a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ Chat d;
    public final /* synthetic */ IChatService e;
    public final /* synthetic */ TextView f;
    public final /* synthetic */ TextView g;
    public final /* synthetic */ ShareGroupChatContent h;
    public final /* synthetic */ Message i;
    public final /* synthetic */ String j;

    public class a implements e0.a {
        public a() {
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r13) {
        View.OnClickListener r0 = this.a;
        if (r0 == null) goto L6;
        r0.onClick(r13);
    L6:
        if (this.b != 4) goto L8;
        ChatCoreModule.a().getThreadDependency().a(this.c, this.d.getId(), new a());
        return;
    L8:
        MessageHitPoint.b(this.d, false);
        final Context r2 = this.c;
        IChatService r14 = this.e;
        final TextView r4 = this.f;
        final TextView r5 = this.g;
        final Chat r6 = this.d;
        final ShareGroupChatContent r7 = this.h;
        final int r8 = this.b;
        final Message r1 = this.i;
        final String r10 = this.j;
        IGetDataCallback<Chat> r11 = new FlowShareGroupChatHelper$5(r2, r1, r4, r5, r6, r7, r8, r10);
        r14.t9(r1.getId(), r10, new UIGetDataCallback(r11));
    }

    public d(FlowShareGroupContentBlock.c r1, Context r2, Chat r3, IChatService r4, UDButton r5, TextView r6, ShareGroupChatContent r7, Message r8, String r9) {
        this.a = r1;
        this.b = 0;
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.i = r8;
        this.j = r9;
    }
}
