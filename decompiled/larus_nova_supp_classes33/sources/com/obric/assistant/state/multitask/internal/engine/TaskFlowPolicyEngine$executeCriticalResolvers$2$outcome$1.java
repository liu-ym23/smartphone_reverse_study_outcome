package com.obric.assistant.state.multitask.internal.engine;

import com.obric.assistant.state.multitask.core.TaskFlowCriticalResolver;
import jha.g;
import jha.q;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.multitask.internal.engine.TaskFlowPolicyEngine$executeCriticalResolvers$2$outcome$1", f = "TaskFlowPolicyEngine.kt", i = {}, l = {92}, m = "invokeSuspend", n = {}, s = {})
public final class TaskFlowPolicyEngine$executeCriticalResolvers$2$outcome$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ q<?> $event;
    final /* synthetic */ g<?> $id;
    final /* synthetic */ TaskFlowCriticalResolver $resolver;
    int label;

    public TaskFlowPolicyEngine$executeCriticalResolvers$2$outcome$1(TaskFlowCriticalResolver r1, g<?> r2, q<?> r3, Continuation<? super TaskFlowPolicyEngine$executeCriticalResolvers$2$outcome$1> r4) {
        this.$resolver = r1;
        this.$id = r2;
        this.$event = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new TaskFlowPolicyEngine$executeCriticalResolvers$2$outcome$1(this.$resolver, this.$id, this.$event, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        TaskFlowCriticalResolver r6 = this.$resolver;
        g<?> r2 = this.$id;
        q<?> r3 = this.$event;
        this.label = 1;
        if (r6.a(r2, r3) != r0) goto L12;
        return r0;
    }
}
