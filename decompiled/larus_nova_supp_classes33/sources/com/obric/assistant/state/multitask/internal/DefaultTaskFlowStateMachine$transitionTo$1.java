package com.obric.assistant.state.multitask.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.multitask.internal.DefaultTaskFlowStateMachine", f = "DefaultTaskFlowStateMachine.kt", i = {}, l = {81}, m = "transitionTo", n = {}, s = {})
public final class DefaultTaskFlowStateMachine$transitionTo$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DefaultTaskFlowStateMachine<S> this$0;

    public DefaultTaskFlowStateMachine$transitionTo$1(DefaultTaskFlowStateMachine<S> r1, Continuation<? super DefaultTaskFlowStateMachine$transitionTo$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, (Continuation<? super Boolean>) this);
    }
}
