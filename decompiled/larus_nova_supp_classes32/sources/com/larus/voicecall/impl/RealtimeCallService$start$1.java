package com.larus.voicecall.impl;

import com.larus.audio.call.arch.LLMCallController;
import com.larus.audio.call.mgr.MajorState;
import com.larus.audio.call.plugins.c1;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.RealtimeCallService$start$1", f = "RealtimeCallService.kt", i = {}, l = {178}, m = "invokeSuspend", n = {}, s = {})
public final class RealtimeCallService$start$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RealtimeCallService this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ RealtimeCallService a;

        public a(RealtimeCallService r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            Pair r4 = (Pair) r2;
            MajorState r5 = (MajorState) ((Pair) r4.getSecond()).getFirst();
            int r6 = ((Number) ((Pair) r4.getSecond()).getSecond()).intValue();
            this.a.f(r5, r6);
            return Unit.INSTANCE;
        }
    }

    public RealtimeCallService$start$1(RealtimeCallService r1, Continuation<? super RealtimeCallService$start$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new RealtimeCallService$start$1(this.this$0, r3);
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
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        MutableSharedFlow r6 = LLMCallController.w(this.this$0.u, Reflection.getOrCreateKotlinClass(c1.class)).W();
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
