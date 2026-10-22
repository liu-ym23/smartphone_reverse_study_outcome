package com.obric.assistant.state.impl.multitask.producer;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.AiNoteStateProducer", f = "AiNoteStateProducer.kt", i = {0, 0}, l = {98}, m = "startRecording", n = {"meetingId", "state"}, s = {"L$0", "L$1"})
final class AiNoteStateProducer$startRecording$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AiNoteStateProducer this$0;

    public AiNoteStateProducer$startRecording$1(AiNoteStateProducer r1, Continuation<? super AiNoteStateProducer$startRecording$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return AiNoteStateProducer.b(this.this$0, null, this);
    }
}
