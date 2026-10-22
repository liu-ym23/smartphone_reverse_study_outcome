package com.obric.assistant.obric_action.handler.omni_task;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.obric_action.handler.omni_task.OmniTaskFeedbackHandler", f = "OmniTaskFeedbackHandler.kt", i = {}, l = {75}, m = "execute", n = {}, s = {})
public final class OmniTaskFeedbackHandler$execute$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OmniTaskFeedbackHandler this$0;

    public OmniTaskFeedbackHandler$execute$1(OmniTaskFeedbackHandler r1, Continuation<? super OmniTaskFeedbackHandler$execute$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(null, null, this);
    }
}
