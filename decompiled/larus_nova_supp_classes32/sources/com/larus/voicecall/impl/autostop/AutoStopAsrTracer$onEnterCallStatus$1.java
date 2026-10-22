package com.larus.voicecall.impl.autostop;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.autostop.AutoStopAsrTracer$onEnterCallStatus$1", f = "AutoStopAsrTracer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AutoStopAsrTracer$onEnterCallStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $duration;
    final /* synthetic */ RealtimeCallParam $params;
    final /* synthetic */ long $pseudoDuration;
    final /* synthetic */ IRealtimeCallTracer.EnterCallSessionStatus $sessionStatus;
    int label;
    final /* synthetic */ AutoStopAsrTracer this$0;

    public AutoStopAsrTracer$onEnterCallStatus$1(AutoStopAsrTracer r1, RealtimeCallParam r2, IRealtimeCallTracer.EnterCallSessionStatus r3, long r4, long r6, Continuation<? super AutoStopAsrTracer$onEnterCallStatus$1> r8) {
        this.this$0 = r1;
        this.$params = r2;
        this.$sessionStatus = r3;
        this.$duration = r4;
        this.$pseudoDuration = r6;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AutoStopAsrTracer$onEnterCallStatus$1(this.this$0, this.$params, this.$sessionStatus, this.$duration, this.$pseudoDuration, r11);
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
        AutoStopAsrTracer.v0(this.this$0, this.$params, this.$sessionStatus, this.$duration, "1", null, null, Boxing.boxLong(this.$pseudoDuration), 48);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
