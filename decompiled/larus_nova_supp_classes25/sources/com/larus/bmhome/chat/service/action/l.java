package com.larus.bmhome.chat.service.action;

import com.larus.bmhome.chat.api.ConversationFeedActionType;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.im.bean.bot.BotModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import tx9.k1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l implements b {
    public final a a;

    public l(a r2) {
        Intrinsics.checkNotNullParameter(r2, "executeContext");
        this.a = r2;
    }

    @Override // com.larus.bmhome.chat.service.action.b
    public final void a(wh8.a r12) {
        Intrinsics.checkNotNullParameter(r12, "data");
        a r0 = this.a;
        com.larus.bmhome.chat.api.i r1 = r0.a;
        wc9.e r2 = r12.a;
        if (r2 == null) goto L5;
        r0.b.hideConversation(r2);
    L5:
        BotModel r3 = r12.b;
        Integer r4 = null;
        if (r3 == null) goto L8;
        String r5 = r3.getBotId();
    L9:
        if (r5 != null) goto L11;
        r5 = "";
    L11:
        String r6 = r5;
        String r7 = r1.d;
        ChatControlTrace r8 = ChatControlTrace.b;
        wc9.e r9 = r12.a;
        if (r9 == null) goto L14;
        r4 = r9.v;
    L14:
        String r10 = r8.g(r4, c.b(r12), c.a(r12));
        Integer r11 = c.b(r12);
        String r13 = r1.c;
        if (r1.e == false) goto L17;
        String r14 = "1";
    L18:
        k1.a(r6, r7, r13, r10, r11, r14, r1.b, 64);
        Function2<ConversationFeedActionType, wh8.a, Unit> r15 = r1.j;
        if (r15 == null) goto L21;
        r15.invoke(ConversationFeedActionType.HIDE, r12);
    L21:
        Function0<Unit> r16 = r1.i;
        if (r16 == null) goto L25;
        r16.invoke();
        return;
    L25:
        return;
    L17:
        r14 = "0";
        goto L18
    L8:
        r5 = null;
        goto L9
    }
}
