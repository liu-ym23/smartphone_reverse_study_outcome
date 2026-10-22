package com.obric.assistant.state.platform;

import com.obric.assistant.state.multitask.TaskFlowManager;
import jha.g;
import jha.k;
import jha.o;
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
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 176)
@DebugMetadata(c = "com.obric.assistant.state.platform.AndroidLifecycleExtensionsKt$observeEventsInScope$1", f = "AndroidLifecycleExtensions.kt", i = {}, l = {24}, m = "invokeSuspend", n = {}, s = {})
public final class AndroidLifecycleExtensionsKt$observeEventsInScope$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<g<o>, q<o>, Unit> $onEvent;
    final /* synthetic */ TaskFlowManager $this_observeEventsInScope;
    final /* synthetic */ k<o> $type;
    int label;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ Function2<g<o>, q<o>, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function2<? super g<o>, ? super q<o>, Unit> r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            Pair r4 = (Pair) r2;
            g r5 = (g) r4.component1();
            q r6 = (q) r4.component2();
            this.a.invoke(r5, r6);
            return Unit.INSTANCE;
        }
    }

    public static final class b implements Flow<Pair<? extends g<?>, ? extends q<?>>> {
        public final Object collect(FlowCollector r1, Continuation r2) {
            throw null;
        }
    }

    public static final class c implements Flow<Pair<? extends g<o>, ? extends q<o>>> {
        public final Object collect(FlowCollector r1, Continuation r2) {
            throw null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AndroidLifecycleExtensionsKt$observeEventsInScope$1(TaskFlowManager r1, k<o> r2, Function2<? super g<o>, ? super q<o>, Unit> r3, Continuation<? super AndroidLifecycleExtensionsKt$observeEventsInScope$1> r4) {
        this.$this_observeEventsInScope = r1;
        this.$type = r2;
        this.$onEvent = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new AndroidLifecycleExtensionsKt$observeEventsInScope$1(this.$this_observeEventsInScope, this.$type, this.$onEvent, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L19:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        TaskFlowManager r7 = this.$this_observeEventsInScope;
        k<o> r2 = this.$type;
        r7.getClass();
        Flow r8 = e.c(TaskFlowManager.h, 128, BufferOverflow.DROP_OLDEST);
        Intrinsics.needClassReification();
        a r3 = new a(this.$onEvent);
        this.label = 1;
        Object r9 = r8.collect(new AndroidLifecycleExtensionsKt$observeEventsInScope$1$invokeSuspend$$inlined$observeEventsByType$1$2(new AndroidLifecycleExtensionsKt$observeEventsInScope$1$invokeSuspend$$inlined$observeEventsByType$2$2(r3), r2), this);
        if (r9 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        r9 = Unit.INSTANCE;
    L13:
        if (r9 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L16;
        r9 = Unit.INSTANCE;
    L16:
        if (r9 != r0) goto L19;
        return r0;
    }

    public final Object invokeSuspend$$forInline(Object r4) {
        TaskFlowManager r5 = this.$this_observeEventsInScope;
        k<o> r0 = this.$type;
        r5.getClass();
        Flow r6 = e.c(TaskFlowManager.h, 128, BufferOverflow.DROP_OLDEST);
        Intrinsics.needClassReification();
        a r1 = new a(this.$onEvent);
        InlineMarker.mark(0);
        Object r7 = r6.collect(new AndroidLifecycleExtensionsKt$observeEventsInScope$1$invokeSuspend$$inlined$observeEventsByType$1$2(new AndroidLifecycleExtensionsKt$observeEventsInScope$1$invokeSuspend$$inlined$observeEventsByType$2$2(r1), r0), this);
        if (r7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L7;
        r7 = Unit.INSTANCE;
    L7:
        if (r7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        Unit r8 = Unit.INSTANCE;
    L10:
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }
}
