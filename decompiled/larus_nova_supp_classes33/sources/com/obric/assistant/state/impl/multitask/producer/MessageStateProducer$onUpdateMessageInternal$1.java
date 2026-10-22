package com.obric.assistant.state.impl.multitask.producer;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.MessageStateProducer", f = "MessageStateProducer.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {336, 344, 351}, m = "onUpdateMessageInternal", n = {"cid", "msg", "taskRootMessageId", "trackingKey", "cid", "msg", "taskRootMessageId", "trackingKey", "cid", "msg", "taskRootMessageId", "trackingKey"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
final class MessageStateProducer$onUpdateMessageInternal$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MessageStateProducer this$0;

    public MessageStateProducer$onUpdateMessageInternal$1(MessageStateProducer r1, Continuation<? super MessageStateProducer$onUpdateMessageInternal$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return MessageStateProducer.b(this.this$0, null, null, false, false, this);
    }
}
