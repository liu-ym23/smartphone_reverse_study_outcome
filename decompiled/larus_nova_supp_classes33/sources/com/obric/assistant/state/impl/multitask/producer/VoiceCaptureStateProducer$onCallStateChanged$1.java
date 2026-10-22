package com.obric.assistant.state.impl.multitask.producer;

import aha.h0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.api.multitask.state.VoiceCaptureScene;
import com.obric.assistant.state.multitask.ext.TaskFlowDslKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.VoiceCaptureStateProducer$onCallStateChanged$1", f = "VoiceCaptureStateProducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class VoiceCaptureStateProducer$onCallStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $callState;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ VoiceCaptureScene $scene;
    final /* synthetic */ String $sessionId;
    final /* synthetic */ Integer $sourceType;
    int label;
    final /* synthetic */ VoiceCaptureStateProducer this$0;

    public VoiceCaptureStateProducer$onCallStateChanged$1(VoiceCaptureStateProducer r1, String r2, VoiceCaptureScene r3, int r4, String r5, Integer r6, Continuation<? super VoiceCaptureStateProducer$onCallStateChanged$1> r7) {
        this.this$0 = r1;
        this.$conversationId = r2;
        this.$scene = r3;
        this.$callState = r4;
        this.$sessionId = r5;
        this.$sourceType = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new VoiceCaptureStateProducer$onCallStateChanged$1(this.this$0, this.$conversationId, this.$scene, this.$callState, this.$sessionId, this.$sourceType, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r9);
        String r10 = VoiceCaptureStateProducer.g(this.this$0, this.$conversationId, this.$scene);
        FLogger.a.i("VoiceCaptureStateProducer", "onCallStateChanged, key=" + r10 + ", callState=" + this.$callState + ", sessionId=" + this.$sessionId);
        VoiceCaptureStateProducer.a r11 = this.this$0.b.get(r10);
        if (r11 == null) goto L7;
        String r0 = this.$sessionId;
        if (r0 != null) goto L11;
    L14:
        jha.l<h0> r1 = r11.b;
        String r2 = this.$conversationId;
        VoiceCaptureScene r3 = this.$scene;
        Integer r4 = this.$sourceType;
        this.this$0.getClass();
        TaskFlowDslKt.f(r1, new h0.d(r2, r3, r4, MapsKt.plus(VoiceCaptureStateProducer.h(r4), MapsKt.mapOf(TuplesKt.to("instance_call_state", Boxing.boxInt(this.$callState)))), r11.c));
        return Unit.INSTANCE;
    L11:
        if (Intrinsics.areEqual(r11.a, r0) == true) goto L14;
        return Unit.INSTANCE;
    L7:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
