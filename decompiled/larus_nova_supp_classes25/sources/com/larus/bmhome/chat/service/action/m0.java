package com.larus.bmhome.chat.service.action;

import com.larus.bmhome.chat.api.ConversationFeedActionType;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.api.IShareService;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.im.bean.bot.BotModel;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m0 implements b {
    public final com.larus.bmhome.chat.service.action.a a;

    public static final class a {
    }

    static {
    }

    public m0(com.larus.bmhome.chat.service.action.a r2) {
        Intrinsics.checkNotNullParameter(r2, "executeContext");
        this.a = r2;
    }

    @Override // com.larus.bmhome.chat.service.action.b
    public final void a(wh8.a r14) {
        Intrinsics.checkNotNullParameter(r14, "data");
        com.larus.bmhome.chat.api.i r0 = this.a.a;
        FLogger r1 = FLogger.a;
        StringBuilder r2 = new StringBuilder("handle share action, conversationId=");
        wc9.e r3 = r14.a;
        String r4 = null;
        if (r3 == null) goto L5;
        String r5 = r3.a;
    L6:
        r2.append(r5);
        r2.append(", botId=");
        BotModel r6 = r14.b;
        if (r6 == null) goto L9;
        r4 = r6.getBotId();
    L9:
        r2.append(r4);
        r2.append(", fragment=");
        r2.append(r0.a);
        r2.append(", fragmentContext=");
        r2.append(r0.a.getActivity());
        r1.i("ShareConversationActionHandler", r2.toString());
        IShareService.a.b(ShareServiceDelegate.b, r0.a.getActivity(), r14.a, r14.b, ShareScene.MESSAGES_LINK_SUB_CONV, null, r0.b, null, 80);
        Function2<ConversationFeedActionType, wh8.a, Unit> r7 = r0.j;
        if (r7 == null) goto L12;
        r7.invoke(ConversationFeedActionType.SHARE, r14);
    L12:
        Function0<Unit> r15 = r0.i;
        if (r15 == null) goto L16;
        r15.invoke();
        return;
    L16:
        return;
    L5:
        r5 = null;
        goto L6
    }
}
