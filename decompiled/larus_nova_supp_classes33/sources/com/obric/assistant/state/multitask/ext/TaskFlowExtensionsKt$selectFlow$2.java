package com.obric.assistant.state.multitask.ext;

import com.obric.assistant.state.multitask.TaskFlowManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.multitask.ext.TaskFlowExtensionsKt$selectFlow$2", f = "TaskFlowExtensions.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
final class TaskFlowExtensionsKt$selectFlow$2 extends SuspendLambda implements Function2<FlowCollector<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<TaskFlowManager, Object> $selector;
    final /* synthetic */ TaskFlowManager $this_selectFlow;
    private /* synthetic */ Object L$0;
    int label;

    public TaskFlowExtensionsKt$selectFlow$2(Function1<? super TaskFlowManager, Object> r1, TaskFlowManager r2, Continuation<? super TaskFlowExtensionsKt$selectFlow$2> r3) {
        this.$selector = r1;
        this.$this_selectFlow = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        TaskFlowExtensionsKt$selectFlow$2 r0 = new TaskFlowExtensionsKt$selectFlow$2(this.$selector, this.$this_selectFlow, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((FlowCollector) r1, (Continuation) r2);
    }

    public final Object invoke(FlowCollector<Object> r1, Continuation<? super Unit> r2) {
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
        FlowCollector r6 = (FlowCollector) this.L$0;
        Object r2 = this.$selector.invoke(this.$this_selectFlow);
        this.label = 1;
        if (r6.emit(r2, this) != r0) goto L12;
        return r0;
    }
}
