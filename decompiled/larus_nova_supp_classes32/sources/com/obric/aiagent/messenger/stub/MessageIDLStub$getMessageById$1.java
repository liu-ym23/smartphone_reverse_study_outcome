package com.obric.aiagent.messenger.stub;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.stub.MessageIDLStub", f = "MessageIDLStub.kt", i = {0}, l = {2325}, m = "getMessageById", n = {"id"}, s = {"L$0"})
public final class MessageIDLStub$getMessageById$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MessageIDLStub this$0;

    public MessageIDLStub$getMessageById$1(MessageIDLStub r1, Continuation<? super MessageIDLStub$getMessageById$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return MessageIDLStub.access$getMessageById(this.this$0, null, this);
    }
}
