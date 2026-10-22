package com.obric.assistant.state.multitask.ext;

import com.obric.assistant.state.multitask.TaskFlowManager;
import com.obric.assistant.state.multitask.TaskFlowManager$b;
import jha.i;
import jha.o;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.multitask.ext.TaskFlowDslKt$observeStates$2", f = "TaskFlowDsl.kt", i = {}, l = {119}, m = "invokeSuspend", n = {}, s = {})
final class TaskFlowDslKt$observeStates$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<o, Continuation<? super Unit>, Object> $action;
    final /* synthetic */ jha.g<o> $this_observeStates;
    int label;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ Function2<o, Continuation<? super Unit>, Object> a;

        public a(Function2<o, ? super Continuation<? super Unit>, ? extends Object> r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            Function2<o, Continuation<? super Unit>, Object> r0 = this.a;
            Object r4 = r0.invoke((o) r2, r3);
            if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r4;
        L6:
            return Unit.INSTANCE;
        }
    }

    public TaskFlowDslKt$observeStates$2(jha.g<o> r1, Function2<o, ? super Continuation<? super Unit>, ? extends Object> r2, Continuation<? super TaskFlowDslKt$observeStates$2> r3) {
        this.$this_observeStates = r1;
        this.$action = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new TaskFlowDslKt$observeStates$2(this.$this_observeStates, this.$action, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.obric.assistant.state.multitask.ext.TaskFlowDslKt$observeStates$$inlined$map$1] */
    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L24:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        jha.g<o> r6 = this.$this_observeStates;
        Intrinsics.checkNotNullParameter(r6, "<this>");
        TaskFlowManager r2 = TaskFlowManager.a;
        Intrinsics.checkNotNullParameter(r6, "id");
        Object r7 = TaskFlowManager.d.get(r6);
        TaskFlowDslKt$observeStates$$inlined$map$1 r3 = 0;
        if ((r7 instanceof TaskFlowManager$b) == false) goto L11;
        TaskFlowManager$b r8 = (TaskFlowManager$b) r7;
    L12:
        if (r8 == null) goto L16;
        i<S> r9 = r8.b;
        if (r9 == 0) goto L16;
        final a1 r10 = r9.getEvents();
    L17:
        if (r10 == null) goto L19;
        r3 = new TaskFlowDslKt$observeStates$$inlined$map$1(r10);
    L19:
        if (r3 == 0) goto L24;
        a r11 = new a(this.$action);
        this.label = 1;
        if (r3.collect(r11, this) != r0) goto L24;
        return r0;
    L16:
        r10 = null;
        goto L17
    L11:
        r8 = null;
        goto L12
    }
}
