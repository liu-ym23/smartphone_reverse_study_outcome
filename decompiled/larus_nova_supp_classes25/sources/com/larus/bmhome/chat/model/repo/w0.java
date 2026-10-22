package com.larus.bmhome.chat.model.repo;

import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.im.bean.message.Message;
import com.larus.im.internal.jni.bean.OmniBreakReason;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class w0 implements Function0 {
    public final /* synthetic */ Message a;
    public final /* synthetic */ ChatSender b;
    public final /* synthetic */ ChatPageContext c;

    public /* synthetic */ w0(Message r1, ChatSender r2, ChatPageContext r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke() {
        Message r0 = this.a;
        ChatSender r1 = this.b;
        ChatPageContext r2 = this.c;
        if (com.larus.bmhome.chat.bean.d.G0(r0) == false) goto L8;
        String r3 = r0.getConversationId();
        if (r3 != null) goto L7;
        r3 = "";
    L7:
        r1.n1(r3, OmniBreakReason.OmniBreakReason_SEND_NEW_MSG);
    L8:
        BuildersKt.launch$default(r1.b, null, null, new ChatSender$retryNew$retryAction$1$1(r1, r0, r2, null), 3, null);
        return Unit.INSTANCE;
    }
}
