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
@DebugMetadata(c = "com.larus.voicecall.impl.tracer.RealtimeCallTracer$onInterruptCall$1", f = "RealtimeCallTracer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeCallTracer$onInterruptCall$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RealtimeCallParam.c $actionBarInfo;
    final /* synthetic */ String $asrTaskId;
    final /* synthetic */ String $botId;
    final /* synthetic */ String $callId;
    final /* synthetic */ String $chatType;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ String $enterMethod;
    final /* synthetic */ boolean $isAutoInterrupt;
    final /* synthetic */ boolean $isContinuousTalk;
    final /* synthetic */ String $isImmersiveBackground;
    final /* synthetic */ boolean $isObricContinueTalk;
    final /* synthetic */ int $pendingState;
    final /* synthetic */ String $speakerId;
    final /* synthetic */ String $ttsTaskId;
    int label;
    final /* synthetic */ RealtimeCallTracer this$0;

    public RealtimeCallTracer$onInterruptCall$1(RealtimeCallTracer r4, String r5, String r6, String r7, int r8, boolean r9, String r10, String r11, String r12, boolean r13, boolean r14, String r15, String r16, RealtimeCallParam.c r17, String r18, Continuation<? super RealtimeCallTracer$onInterruptCall$1> r19) {
        this.this$0 = r4;
        this.$botId = r5;
        this.$conversationId = r6;
        this.$callId = r7;
        this.$pendingState = r8;
        this.$isAutoInterrupt = r9;
        this.$asrTaskId = r10;
        this.$ttsTaskId = r11;
        this.$isImmersiveBackground = r12;
        this.$isContinuousTalk = r13;
        this.$isObricContinueTalk = r14;
        this.$enterMethod = r15;
        this.$chatType = r16;
        this.$actionBarInfo = r17;
        this.$speakerId = r18;
        super(2, r19);
    }

    public final Continuation<Unit> create(Object r20, Continuation<?> r21) {
        return new RealtimeCallTracer$onInterruptCall$1(this.this$0, this.$botId, this.$conversationId, this.$callId, this.$pendingState, this.$isAutoInterrupt, this.$asrTaskId, this.$ttsTaskId, this.$isImmersiveBackground, this.$isContinuousTalk, this.$isObricContinueTalk, this.$enterMethod, this.$chatType, this.$actionBarInfo, this.$speakerId, r21);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r18);
        RealtimeCallTracerReporterKt.c(this.this$0, this.$botId, this.$conversationId, this.$callId, this.$pendingState, this.$isAutoInterrupt, this.$asrTaskId, this.$ttsTaskId, this.$isImmersiveBackground, this.$isContinuousTalk, this.$isObricContinueTalk, this.$enterMethod, this.$chatType, this.$actionBarInfo, this.$speakerId);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
