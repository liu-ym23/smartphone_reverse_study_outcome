package com.obric.assistant.state.impl.multitask.producer;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.api.multitask.state.VoiceCaptureScene;
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
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.VoiceCaptureStateProducer$end$1", f = "VoiceCaptureStateProducer.kt", i = {}, l = {240}, m = "invokeSuspend", n = {}, s = {})
public final class VoiceCaptureStateProducer$end$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $conversationId;
    final /* synthetic */ VoiceCaptureScene $scene;
    final /* synthetic */ String $sessionId;
    final /* synthetic */ Integer $sourceType;
    int label;
    final /* synthetic */ VoiceCaptureStateProducer this$0;

    public VoiceCaptureStateProducer$end$1(VoiceCaptureStateProducer r1, String r2, VoiceCaptureScene r3, String r4, Integer r5, Continuation<? super VoiceCaptureStateProducer$end$1> r6) {
        this.this$0 = r1;
        this.$conversationId = r2;
        this.$scene = r3;
        this.$sessionId = r4;
        this.$sourceType = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new VoiceCaptureStateProducer$end$1(this.this$0, this.$conversationId, this.$scene, this.$sessionId, this.$sourceType, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r20);
    L27:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r20);
        String r3 = VoiceCaptureStateProducer.g(this.this$0, this.$conversationId, this.$scene);
        FLogger r4 = FLogger.a;
        r4.i("VoiceCaptureStateProducer", "end, key=" + r3 + ", sessionId=" + this.$sessionId + ", sourceType=" + this.$sourceType);
        VoiceCaptureStateProducer.a r5 = this.this$0.b.get(r3);
        if (r5 != null) goto L17;
        VoiceCaptureStateProducer r6 = this.this$0;
        String r9 = this.$conversationId;
        VoiceCaptureScene r10 = this.$scene;
        Integer r11 = this.$sourceType;
        String r7 = this.$sessionId;
        VoiceCaptureStateProducer.c r8 = r6.c.get(r3);
        if (r8 == null) goto L15;
        Job r12 = r8.e;
        if (r12 == null) goto L15;
        Job.DefaultImpls.cancel$default(r12, null, 1, null);
    L15:
        r6.c.put(r3, new VoiceCaptureStateProducer.c(r9, r10, r11, r7, BuildersKt.launch$default(r6.a, null, null, new VoiceCaptureStateProducer$bufferPendingEnd$timeoutJob$1(r6, r3, r7, null), 3, null)));
        r4.w("VoiceCaptureStateProducer", "bufferPendingEnd: buffered End for key=" + r3 + ", sessionId=" + r7 + ", waiting for Start");
        return Unit.INSTANCE;
    L17:
        String r13 = this.$sessionId;
        if (r13 != null) goto L20;
    L23:
        VoiceCaptureStateProducer r14 = this.this$0;
        String r15 = this.$conversationId;
        VoiceCaptureScene r16 = this.$scene;
        Integer r17 = this.$sourceType;
        this.label = 1;
        if (r14.i(r3, r15, r16, r17) != r1) goto L27;
        return r1;
    L20:
        if (Intrinsics.areEqual(r5.a, r13) == true) goto L23;
        r4.w("VoiceCaptureStateProducer", "end: sessionId mismatch for key=" + r3);
        return Unit.INSTANCE;
    }
}
