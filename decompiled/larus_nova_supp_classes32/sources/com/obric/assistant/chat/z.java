package com.obric.assistant.chat;

import com.larus.im.bean.message.Message;
import com.obric.assistant.chat.impl.MessageApiImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class z implements Function1 {
    public final /* synthetic */ Message a;

    public /* synthetic */ z(Message r1) {
        this.a = r1;
    }

    public final Object invoke(Object r6) {
        Message r0 = this.a;
        Message r7 = (Message) r6;
        if (r7 == null) goto L16;
        if (Intrinsics.areEqual(r7.getMessageId(), r0.getMessageId()) == true) goto L11;
        if (Intrinsics.areEqual(r7.getLocalMessageId(), r0.getLocalMessageId()) == true) goto L11;
        if (r7.getLocalIndex() > r0.getLocalIndex()) goto L16;
    L11:
        if (r0.getMessageStatusLocal() != 11) goto L13;
    L14:
        MessageApiImpl r8 = MessageApiImpl.a;
        MessageApiImpl.k(r0);
        goto L16
    L13:
        if (r0.getMessageStatusLocal() == 10) goto L14;
    L16:
        return Unit.INSTANCE;
    }
}
