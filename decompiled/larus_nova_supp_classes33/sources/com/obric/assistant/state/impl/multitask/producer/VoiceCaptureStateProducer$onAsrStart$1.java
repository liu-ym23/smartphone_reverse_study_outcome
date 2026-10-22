package com.obric.assistant.state.impl.multitask.producer;

import aha.h0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.api.multitask.state.VoiceCaptureScene;
import com.obric.assistant.state.multitask.ext.TaskFlowDslKt;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.VoiceCaptureStateProducer$onAsrStart$1", f = "VoiceCaptureStateProducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class VoiceCaptureStateProducer$onAsrStart$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $conversationId;
    final /* synthetic */ VoiceCaptureScene $scene;
    final /* synthetic */ String $sessionId;
    final /* synthetic */ Integer $sourceType;
    int label;
    final /* synthetic */ VoiceCaptureStateProducer this$0;

    public VoiceCaptureStateProducer$onAsrStart$1(VoiceCaptureStateProducer r1, String r2, VoiceCaptureScene r3, String r4, Integer r5, Continuation<? super VoiceCaptureStateProducer$onAsrStart$1> r6) {
        this.this$0 = r1;
        this.$conversationId = r2;
        this.$scene = r3;
        this.$sessionId = r4;
        this.$sourceType = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new VoiceCaptureStateProducer$onAsrStart$1(this.this$0, this.$conversationId, this.$scene, this.$sessionId, this.$sourceType, r9);
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
        FLogger r0 = FLogger.a;
        r0.i("VoiceCaptureStateProducer", "onAsrStart, key=" + r10 + ", sessionId=" + this.$sessionId + ", sourceType=" + this.$sourceType);
        VoiceCaptureStateProducer.a r1 = this.this$0.b.get(r10);
        if (r1 != null) goto L8;
        r0.w("VoiceCaptureStateProducer", "onAsrStart: no active session for key=" + r10);
        return Unit.INSTANCE;
    L8:
        String r3 = this.$sessionId;
        if (r3 != null) goto L11;
    L14:
        jha.l<h0> r11 = r1.b;
        String r4 = this.$conversationId;
        VoiceCaptureScene r5 = this.$scene;
        Integer r6 = this.$sourceType;
        this.this$0.getClass();
        TaskFlowDslKt.f(r11, new h0.b(r4, r5, r6, VoiceCaptureStateProducer.h(r6), r1.c));
        return Unit.INSTANCE;
    L11:
        if (Intrinsics.areEqual(r1.a, r3) == true) goto L14;
        r0.w("VoiceCaptureStateProducer", "onAsrStart: sessionId mismatch for key=" + r10);
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
