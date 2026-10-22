package com.obric.assistant.state.impl.multitask.producer;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.RealtimeCallStateProducer", f = "RealtimeCallStateProducer.kt", i = {0}, l = {274}, m = "findOrBindActiveCall", n = {"activeCall"}, s = {"L$0"})
final class RealtimeCallStateProducer$findOrBindActiveCall$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RealtimeCallStateProducer this$0;

    public RealtimeCallStateProducer$findOrBindActiveCall$1(RealtimeCallStateProducer r1, Continuation<? super RealtimeCallStateProducer$findOrBindActiveCall$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return RealtimeCallStateProducer.h(this.this$0, null, null, this);
    }
}
