package com.obric.assistant.state.multitask.internal.engine;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.multitask.internal.engine.TaskFlowPolicyEngine", f = "TaskFlowPolicyEngine.kt", i = {0, 0, 0, 0, 0, 0}, l = {91}, m = "executeCriticalResolvers", n = {"id", "event", "succeeded", "resolver", "sequenceId", "startMillis"}, s = {"L$0", "L$1", "L$2", "L$4", "J$0", "J$1"})
public final class TaskFlowPolicyEngine$executeCriticalResolvers$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TaskFlowPolicyEngine this$0;

    public TaskFlowPolicyEngine$executeCriticalResolvers$1(TaskFlowPolicyEngine r1, Continuation<? super TaskFlowPolicyEngine$executeCriticalResolvers$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, 0, this);
    }
}
