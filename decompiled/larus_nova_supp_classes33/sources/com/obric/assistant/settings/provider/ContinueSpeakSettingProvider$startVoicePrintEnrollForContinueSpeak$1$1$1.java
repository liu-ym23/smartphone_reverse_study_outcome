package com.obric.assistant.settings.provider;

import android.content.Context;
import com.obric.assistant.settings.VoicePrintScene;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.provider.ContinueSpeakSettingProvider$startVoicePrintEnrollForContinueSpeak$1$1$1", f = "ContinueSpeakSettingProvider.kt", i = {}, l = {135}, m = "invokeSuspend", n = {}, s = {})
final class ContinueSpeakSettingProvider$startVoicePrintEnrollForContinueSpeak$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ com.obric.assistant.settings.spi.b $host;
    int label;

    public ContinueSpeakSettingProvider$startVoicePrintEnrollForContinueSpeak$1$1$1(Context r1, com.obric.assistant.settings.spi.b r2, Continuation<? super ContinueSpeakSettingProvider$startVoicePrintEnrollForContinueSpeak$1$1$1> r3) {
        this.$context = r1;
        this.$host = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ContinueSpeakSettingProvider$startVoicePrintEnrollForContinueSpeak$1$1$1(this.$context, this.$host, r4);
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
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        ega.c r6 = ega.c.a;
        Context r2 = this.$context;
        VoicePrintScene r3 = VoicePrintScene.NOISE_REDUCTION;
        final com.obric.assistant.settings.spi.b r4 = this.$host;
        Function0 r7 = new s0(r4);
        Function0 r8 = new t0();
        r6.getClass();
        ega.c.b(r2, r3, r7, r8);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        this.label = 1;
        if (DelayKt.delay(300, this) != r0) goto L11;
        return r0;
    }
}
