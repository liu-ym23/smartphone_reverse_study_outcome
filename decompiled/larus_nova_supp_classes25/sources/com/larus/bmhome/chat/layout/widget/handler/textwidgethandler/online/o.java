package com.larus.bmhome.chat.layout.widget.handler.textwidgethandler.online;

import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import io.noties.markwon.core.spans.CustomCitationSpan;
import kotlin.jvm.internal.Intrinsics;
import tx9.x1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o implements lw8.b {
    public final /* synthetic */ k a;
    public final /* synthetic */ Message b;
    public final /* synthetic */ BotModel c;

    public final void a(CustomCitationSpan r19) {
        Intrinsics.checkNotNullParameter(r19, "span");
        k.a r2 = k.e(this.a, r19);
        String r3 = this.a.a.d.d;
        if (r3 != null) goto L5;
    L12:
        r3 = "chat";
    L13:
        String r4 = r3;
        String r5 = this.a.a.d.c;
        String r6 = this.b.getMessageId();
        String r7 = this.b.getConversationId();
        String r8 = this.c.getBotId();
        String r9 = this.a.a.d.e;
        String r10 = this.b.getReplyId();
        String r11 = r19.e;
        String r12 = r2.a;
        String r13 = r2.e;
        String r14 = r2.b;
        String r15 = r2.d;
        String r1 = r2.c;
        x1.b(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, com.larus.bmhome.chat.bean.d.u(this.b), r1);
        return;
    L5:
        if (r3.length() <= 0) goto L7;
        boolean r16 = true;
    L8:
        if (r16 == true) goto L11;
        r3 = null;
    L11:
        if (r3 != null) goto L13;
    L7:
        r16 = false;
        goto L8
    }

    public o(k r1, Message r2, BotModel r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
