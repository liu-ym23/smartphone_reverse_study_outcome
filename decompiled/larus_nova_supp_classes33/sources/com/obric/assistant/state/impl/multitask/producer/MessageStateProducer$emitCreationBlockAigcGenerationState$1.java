package com.obric.assistant.state.impl.multitask.producer;

import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.MessageStateProducer", f = "MessageStateProducer.kt", i = {0, 0}, l = {485}, m = "emitCreationBlockAigcGenerationState", n = {"conversationId", "msg"}, s = {"L$0", "L$1"})
public final class MessageStateProducer$emitCreationBlockAigcGenerationState$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MessageStateProducer this$0;

    public MessageStateProducer$emitCreationBlockAigcGenerationState$1(MessageStateProducer r1, Continuation<? super MessageStateProducer$emitCreationBlockAigcGenerationState$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        MessageStateProducer r3 = this.this$0;
        Set r0 = MessageStateProducer.w;
        return r3.h(null, null, this);
    }
}
