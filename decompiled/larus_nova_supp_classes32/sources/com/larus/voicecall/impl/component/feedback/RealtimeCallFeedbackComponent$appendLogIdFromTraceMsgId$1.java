package com.larus.voicecall.impl.component.feedback;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.component.feedback.RealtimeCallFeedbackComponent", f = "RealtimeCallFeedbackComponent.kt", i = {}, l = {528}, m = "appendLogIdFromTraceMsgId", n = {}, s = {})
final class RealtimeCallFeedbackComponent$appendLogIdFromTraceMsgId$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RealtimeCallFeedbackComponent this$0;

    public RealtimeCallFeedbackComponent$appendLogIdFromTraceMsgId$1(RealtimeCallFeedbackComponent r1, Continuation<? super RealtimeCallFeedbackComponent$appendLogIdFromTraceMsgId$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return RealtimeCallFeedbackComponent.h3(this.this$0, this);
    }
}
