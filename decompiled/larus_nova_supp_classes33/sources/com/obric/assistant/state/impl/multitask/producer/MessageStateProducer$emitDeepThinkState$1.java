package com.obric.assistant.state.impl.multitask.producer;

import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.MessageStateProducer", f = "MessageStateProducer.kt", i = {0}, l = {795}, m = "emitDeepThinkState", n = {"trackingKey"}, s = {"L$0"})
public final class MessageStateProducer$emitDeepThinkState$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MessageStateProducer this$0;

    public MessageStateProducer$emitDeepThinkState$1(MessageStateProducer r1, Continuation<? super MessageStateProducer$emitDeepThinkState$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        MessageStateProducer r0 = this.this$0;
        Set r8 = MessageStateProducer.w;
        return r0.i(null, null, null, false, this);
    }
}
