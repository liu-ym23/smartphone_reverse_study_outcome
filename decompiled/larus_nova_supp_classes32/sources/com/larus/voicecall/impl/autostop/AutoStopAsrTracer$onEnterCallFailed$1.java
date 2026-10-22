package com.larus.voicecall.impl.autostop;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
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
@DebugMetadata(c = "com.larus.voicecall.impl.autostop.AutoStopAsrTracer$onEnterCallFailed$1", f = "AutoStopAsrTracer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AutoStopAsrTracer$onEnterCallFailed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Integer $errorCode;
    final /* synthetic */ RealtimeCallParam $params;
    final /* synthetic */ String $reason;
    final /* synthetic */ IRealtimeCallTracer.EnterCallSessionStatus $sessionStatus;
    int label;
    final /* synthetic */ AutoStopAsrTracer this$0;

    public AutoStopAsrTracer$onEnterCallFailed$1(AutoStopAsrTracer r1, RealtimeCallParam r2, IRealtimeCallTracer.EnterCallSessionStatus r3, String r4, Integer r5, Continuation<? super AutoStopAsrTracer$onEnterCallFailed$1> r6) {
        this.this$0 = r1;
        this.$params = r2;
        this.$sessionStatus = r3;
        this.$reason = r4;
        this.$errorCode = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new AutoStopAsrTracer$onEnterCallFailed$1(this.this$0, this.$params, this.$sessionStatus, this.$reason, this.$errorCode, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r12);
        AutoStopAsrTracer.v0(this.this$0, this.$params, this.$sessionStatus, 0, "0", this.$reason, this.$errorCode, null, 64);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
