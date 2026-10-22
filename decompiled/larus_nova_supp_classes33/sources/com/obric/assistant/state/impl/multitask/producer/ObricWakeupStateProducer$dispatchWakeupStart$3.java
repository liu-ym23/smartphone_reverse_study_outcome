package com.obric.assistant.state.impl.multitask.producer;

import aha.v;
import com.obric.assistant.state.multitask.core.TaskFlowDispatchStrategy;
import com.obric.assistant.state.multitask.ext.TaskFlowDslKt;
import java.util.concurrent.atomic.AtomicReference;
import jha.c;
import jha.f;
import jha.g;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.ObricWakeupStateProducer$dispatchWakeupStart$3", f = "ObricWakeupStateProducer.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
public final class ObricWakeupStateProducer$dispatchWakeupStart$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $effectiveWakeupId;
    final /* synthetic */ v.b $startState;
    final /* synthetic */ g<v> $taskFlowId;
    final /* synthetic */ String $wakeupSource;
    int label;
    final /* synthetic */ ObricWakeupStateProducer this$0;

    public ObricWakeupStateProducer$dispatchWakeupStart$3(g<v> r1, v.b r2, ObricWakeupStateProducer r3, String r4, String r5, Continuation<? super ObricWakeupStateProducer$dispatchWakeupStart$3> r6) {
        this.$taskFlowId = r1;
        this.$startState = r2;
        this.this$0 = r3;
        this.$effectiveWakeupId = r4;
        this.$wakeupSource = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ObricWakeupStateProducer$dispatchWakeupStart$3(this.$taskFlowId, this.$startState, this.this$0, this.$effectiveWakeupId, this.$wakeupSource, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r15);
    L11:
        jha.m r16 = (jha.m) r15;
        if (r16 != null) goto L16;
        return Unit.INSTANCE;
    L16:
        if (r16.b == true) goto L18;
        TaskFlowDslKt.f(r16.a, this.$startState);
    L18:
        ObricWakeupStateProducer r4 = this.this$0;
        String r5 = this.$effectiveWakeupId;
        String r6 = this.$wakeupSource;
        jha.l<S> r17 = r16.a;
        Object r2 = r4.c;
        monitor-enter(r2);
        ObricWakeupStateProducer.b r18 = r4.b.put(r5, new ObricWakeupStateProducer.b(r17));     // Catch: Throwable -> L33
        if (r18 == null) goto L27;
        AtomicReference<Job> r19 = r18.b;     // Catch: Throwable -> L33
        if (r19 == null) goto L27;
        Job r110 = r19.getAndSet(null);     // Catch: Throwable -> L33
        if (r110 == null) goto L27;
        Job.DefaultImpls.cancel$default(r110, null, 1, null);     // Catch: Throwable -> L33
    L27:
        ObricWakeupStateProducer.b r7 = r4.b.get(r5);     // Catch: Throwable -> L33
        if (r7 == null) goto L30;
        r7.b.set(BuildersKt.launch$default(r4.a, null, null, new ObricWakeupStateProducer$registerWakeupTask$1$1$1(r4, r5, r6, r7, null), 3, null));     // Catch: Throwable -> L33
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L33
    L30:
        monitor-exit(r2);
        return Unit.INSTANCE;
    L33:
        th = move-exception;
        throw th;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        g<v> r112 = this.$taskFlowId;
        v.b r3 = this.$startState;
        this.this$0.getClass();
        ExecutorCoroutineDispatcher r8 = f.a;
        Intrinsics.checkNotNullParameter("ObricWakeupStateProducer", "orderingDomain");
        c r9 = new c(TaskFlowDispatchStrategy.CALLER_CONTEXT, "ObricWakeupStateProducer");
        this.label = 1;
        r15 = TaskFlowDslKt.e(r112, r3, r9, this);
        if (r15 != r0) goto L11;
        return r0;
    }
}
