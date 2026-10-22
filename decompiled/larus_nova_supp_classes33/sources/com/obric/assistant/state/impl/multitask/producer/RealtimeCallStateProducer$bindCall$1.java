package com.obric.assistant.state.impl.multitask.producer;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.RealtimeCallStateProducer", f = "RealtimeCallStateProducer.kt", i = {0, 0, 1, 1}, l = {221, 230}, m = "bindCall", n = {"activeCall", "callId", "activeCall", "callId"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class RealtimeCallStateProducer$bindCall$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RealtimeCallStateProducer this$0;

    public RealtimeCallStateProducer$bindCall$1(RealtimeCallStateProducer r1, Continuation<? super RealtimeCallStateProducer$bindCall$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        RealtimeCallStateProducer r3 = this.this$0;
        int r0 = RealtimeCallStateProducer.j;
        return r3.j(null, null, this);
    }
}
