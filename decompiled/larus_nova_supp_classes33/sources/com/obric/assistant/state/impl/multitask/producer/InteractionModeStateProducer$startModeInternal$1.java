package com.obric.assistant.state.impl.multitask.producer;

import com.obric.cae.libs.useraware.ApWakeEvent;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.InteractionModeStateProducer", f = "InteractionModeStateProducer.kt", i = {0, 0, 0}, l = {ApWakeEvent.ACCELERATING_START}, m = "startModeInternal", n = {"state", "effectiveTimeout", "sessionId"}, s = {"L$0", "L$1", "L$2"})
final class InteractionModeStateProducer$startModeInternal$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InteractionModeStateProducer this$0;

    public InteractionModeStateProducer$startModeInternal$1(InteractionModeStateProducer r1, Continuation<? super InteractionModeStateProducer$startModeInternal$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return InteractionModeStateProducer.e(this.this$0, null, null, this);
    }
}
