package com.larus.voicecall.impl.tracer;

import com.larus.audio.call.RealtimeCallParam;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.tracer.RealtimeCallTracer$onResumeCall$1", f = "RealtimeCallTracer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeCallTracer$onResumeCall$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RealtimeCallParam $params;
    final /* synthetic */ int $pendingState;
    int label;
    final /* synthetic */ RealtimeCallTracer this$0;

    public RealtimeCallTracer$onResumeCall$1(RealtimeCallTracer r1, RealtimeCallParam r2, int r3, Continuation<? super RealtimeCallTracer$onResumeCall$1> r4) {
        this.this$0 = r1;
        this.$params = r2;
        this.$pendingState = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new RealtimeCallTracer$onResumeCall$1(this.this$0, this.$params, this.$pendingState, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        RealtimeCallTracerReporterKt.d(this.this$0, this.$params, this.$pendingState, "call");
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
