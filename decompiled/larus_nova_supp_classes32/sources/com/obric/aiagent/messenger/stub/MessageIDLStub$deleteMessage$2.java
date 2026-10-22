package com.obric.aiagent.messenger.stub;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.stub.MessageIDLStub", f = "MessageIDLStub.kt", i = {0, 0, 0, 0}, l = {2325}, m = "deleteMessage", n = {"conversationId", "messages", "remote", "byUser"}, s = {"L$0", "L$1", "Z$0", "Z$1"})
public final class MessageIDLStub$deleteMessage$2 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    boolean Z$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MessageIDLStub this$0;

    public MessageIDLStub$deleteMessage$2(MessageIDLStub r1, Continuation<? super MessageIDLStub$deleteMessage$2> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return MessageIDLStub.access$deleteMessage(this.this$0, null, false, false, null, this);
    }
}
