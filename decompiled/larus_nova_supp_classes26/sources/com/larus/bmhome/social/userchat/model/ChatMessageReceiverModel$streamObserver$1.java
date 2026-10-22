package com.larus.bmhome.social.userchat.model;

import com.larus.bmhome.social.page.datasource.event.RefreshTraceSource;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ChatMessageReceiverModel$streamObserver$1 implements nf9.c {
    public String a;
    public final /* synthetic */ ChatMessageReceiverModel b;

    public ChatMessageReceiverModel$streamObserver$1(ChatMessageReceiverModel r1) {
        this.b = r1;
        this.a = "";
    }

    public final void A(Message r9) {
        Intrinsics.checkNotNullParameter(r9, "message");
        String r0 = com.larus.bmhome.social.page.datasource.event.d.a(RefreshTraceSource.STREAM_END);
        FLogger.a.i(this.b.k, "onStreamEnd: " + this.a);
        ChatMessageReceiverModel r1 = this.b;
        BuildersKt.launch$default(r1.a, r1.l, null, new ChatMessageReceiverModel$streamObserver$1$onStreamEnd$1(r1, r0, r9, null), 2, null);
    }

    public final void B(Message r8) {
        Intrinsics.checkNotNullParameter(r8, "message");
        ChatMessageReceiverModel r0 = this.b;
        r0.getClass();
        if (com.larus.platform.exp.h.a == true) goto L5;
        boolean r1 = z2.a.enableTtsWhenStreaming();
    L6:
        if (r1 == false) goto L9;
        ChatMessageReceiverModel r2 = this.b;
        BuildersKt.launch$default(r2.a, r2.l, null, new ChatMessageReceiverModel$streamObserver$1$onStreamUpdate$1(r2, r8, null), 2, null);
        return;
    L9:
        return;
    L5:
        r1 = r0.v;
        goto L6
    }

    public final void C(Message r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        FLogger.a.i(this.b.k, "onStreamBegin: " + this.a + ", " + r5.getMessageId());
    }
}
