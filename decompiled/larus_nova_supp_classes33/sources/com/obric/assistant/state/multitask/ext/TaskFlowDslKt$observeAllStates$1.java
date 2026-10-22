package com.obric.assistant.state.multitask.ext;

import com.obric.assistant.state.multitask.TaskFlowManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jha.k;
import jha.q;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u001c\u0012\u0018\u0012\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/Pair;", "Lcom/obric/assistant/state/multitask/core/TaskFlowId;", "Lcom/obric/assistant/state/multitask/core/TaskStateEvent;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.multitask.ext.TaskFlowDslKt$observeAllStates$1", f = "TaskFlowDsl.kt", i = {0}, l = {133}, m = "invokeSuspend", n = {"$this$onStart"}, s = {"L$0"})
final class TaskFlowDslKt$observeAllStates$1 extends SuspendLambda implements Function2<FlowCollector<? super Pair<? extends jha.g<?>, ? extends q<?>>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ k<Object> $this_observeAllStates;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public TaskFlowDslKt$observeAllStates$1(k<Object> r1, Continuation<? super TaskFlowDslKt$observeAllStates$1> r2) {
        this.$this_observeAllStates = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        TaskFlowDslKt$observeAllStates$1 r0 = new TaskFlowDslKt$observeAllStates$1(this.$this_observeAllStates, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((FlowCollector) r1, (Continuation) r2);
    }

    public final Object invoke(FlowCollector<? super Pair<? extends jha.g<?>, ? extends q<?>>> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Iterator r2 = (Iterator) this.L$1;
        FlowCollector r3 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r8);
    L16:
        if (r2.hasNext() == false) goto L21;
        Pair r9 = (Pair) r2.next();
        this.L$0 = r3;
        this.L$1 = r2;
        this.label = 1;
        if (r3.emit(r9, this) != r0) goto L16;
        return r0;
    L21:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        r3 = (FlowCollector) this.L$0;
        TaskFlowManager r10 = TaskFlowManager.a;
        List r11 = TaskFlowManager.c();
        k<Object> r4 = this.$this_observeAllStates;
        ArrayList r5 = new ArrayList();
        Iterator r12 = ((ArrayList) r11).iterator();
    L10:
        if (r12.hasNext() == false) goto L14;
        Object r6 = r12.next();
        if (Intrinsics.areEqual(((jha.g) ((Pair) r6).getFirst()).getType(), r4) == false) goto L10;
        r5.add(r6);
        goto L10
    L14:
        r2 = r5.iterator();
        goto L16
    }
}
