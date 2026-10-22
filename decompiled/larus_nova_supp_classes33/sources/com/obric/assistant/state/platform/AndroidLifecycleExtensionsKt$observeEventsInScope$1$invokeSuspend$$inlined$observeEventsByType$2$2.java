package com.obric.assistant.state.platform;

import jha.g;
import jha.q;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class AndroidLifecycleExtensionsKt$observeEventsInScope$1$invokeSuspend$$inlined$observeEventsByType$2$2<T> implements FlowCollector {
    public final /* synthetic */ FlowCollector a;

    /* JADX INFO: renamed from: com.obric.assistant.state.platform.AndroidLifecycleExtensionsKt$observeEventsInScope$1$invokeSuspend$$inlined$observeEventsByType$2$2$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
    @DebugMetadata(c = "com.obric.assistant.state.platform.AndroidLifecycleExtensionsKt$observeEventsInScope$1$invokeSuspend$$inlined$observeEventsByType$2$2", f = "AndroidLifecycleExtensions.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AndroidLifecycleExtensionsKt$observeEventsInScope$1$invokeSuspend$$inlined$observeEventsByType$2$2 this$0;

        public AnonymousClass1(AndroidLifecycleExtensionsKt$observeEventsInScope$1$invokeSuspend$$inlined$observeEventsByType$2$2 r1, Continuation r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.emit(null, this);
        }
    }

    public AndroidLifecycleExtensionsKt$observeEventsInScope$1$invokeSuspend$$inlined$observeEventsByType$2$2(FlowCollector r1) {
        this.a = r1;
    }

    public final Object emit(Object r6, Continuation r7) {
        if ((r7 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
    L18:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        FlowCollector r9 = this.a;
        Pair r10 = (Pair) r6;
        g r4 = (g) r10.component1();
        q r11 = (q) r10.component2();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.obric.assistant.state.multitask.core.TaskFlowId<S of com.obric.assistant.state.multitask.ext.TaskFlowExtensionsKt.observeEventsByType>");
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type com.obric.assistant.state.multitask.core.TaskStateEvent<S of com.obric.assistant.state.multitask.ext.TaskFlowExtensionsKt.observeEventsByType>");
        Pair r12 = TuplesKt.to(r4, r11);
        r0.label = 1;
        if (r9.emit(r12, r0) != r2) goto L18;
        return r2;
    L7:
        r0 = new AnonymousClass1(this, r7);
        goto L8
    }
}
