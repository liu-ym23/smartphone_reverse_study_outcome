package com.obric.assistant.state.impl.multitask.producer;

import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.MessageStateProducer", f = "MessageStateProducer.kt", i = {0, 0, 0, 0, 0}, l = {730}, m = "emitMessageActiveState", n = {"conversationId", "msg", "taskRootMessageId", "trackingKey", "state"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
public final class MessageStateProducer$emitMessageActiveState$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MessageStateProducer this$0;

    public MessageStateProducer$emitMessageActiveState$1(MessageStateProducer r1, Continuation<? super MessageStateProducer$emitMessageActiveState$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        this.label |= Integer.MIN_VALUE;
        MessageStateProducer r0 = this.this$0;
        Set r9 = MessageStateProducer.w;
        return r0.k(null, null, null, false, false, this);
    }
}
