package com.larus.bmhome.chat.component.cvs;

import com.larus.im.bean.bot.BotModel;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class s implements Function1 {
    public final /* synthetic */ com.larus.bmhome.social.userchat.model.a a;
    public final /* synthetic */ BotModel b;

    public /* synthetic */ s(com.larus.bmhome.social.userchat.model.a r1, BotModel r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r3) {
        return ChatConversationVM.So(this.a, this.b, (ChatConversationVMState) r3);
    }
}
