package com.obric.audio.enroll;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.enroll.VoiceEnrollServiceImpl$syncDefaultVoicePrintCloudForUidExternally$1", f = "VoiceEnrollServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class VoiceEnrollServiceImpl$syncDefaultVoicePrintCloudForUidExternally$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $reason;
    final /* synthetic */ String $uid;
    int label;
    final /* synthetic */ VoiceEnrollServiceImpl this$0;

    public VoiceEnrollServiceImpl$syncDefaultVoicePrintCloudForUidExternally$1(VoiceEnrollServiceImpl r1, String r2, String r3, Continuation<? super VoiceEnrollServiceImpl$syncDefaultVoicePrintCloudForUidExternally$1> r4) {
        this.this$0 = r1;
        this.$uid = r2;
        this.$reason = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new VoiceEnrollServiceImpl$syncDefaultVoicePrintCloudForUidExternally$1(this.this$0, this.$uid, this.$reason, r5);
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
        VoiceEnrollServiceImpl r5 = this.this$0;
        String r0 = this.$uid;
        String r1 = this.$reason;
        VoiceEnrollServiceImpl.b r2 = VoiceEnrollServiceImpl.k;
        r5.E(r0, r1);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
