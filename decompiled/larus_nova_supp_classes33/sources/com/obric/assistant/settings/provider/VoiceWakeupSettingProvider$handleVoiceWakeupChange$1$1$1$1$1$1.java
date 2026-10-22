package com.obric.assistant.settings.provider;

import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.provider.VoiceWakeupSettingProvider$handleVoiceWakeupChange$1$1$1$1$1$1", f = "VoiceWakeupSettingProvider.kt", i = {}, l = {115}, m = "invokeSuspend", n = {}, s = {})
public final class VoiceWakeupSettingProvider$handleVoiceWakeupChange$1$1$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.obric.assistant.settings.spi.b $host;
    int label;

    public VoiceWakeupSettingProvider$handleVoiceWakeupChange$1$1$1$1$1$1(com.obric.assistant.settings.spi.b r1, Continuation<? super VoiceWakeupSettingProvider$handleVoiceWakeupChange$1$1$1$1$1$1> r2) {
        this.$host = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new VoiceWakeupSettingProvider$handleVoiceWakeupChange$1$1$1$1$1$1(this.$host, r3);
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
        boolean r6 = ((Boolean) r5).booleanValue();
        FLogger.a.d("VoiceWakeupSettingProvider", "VoiceWakeupSettingProvider: isVoicePrintExisted = " + r6);
        this.$host.kW();
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        CoroutineDispatcher r7 = Dispatchers.getIO();
        VoiceWakeupSettingProvider$handleVoiceWakeupChange$1$1$1$1$1$1$mIsVoicePrintExisted$1 r2 = new VoiceWakeupSettingProvider$handleVoiceWakeupChange$1$1$1$1$1$1$mIsVoicePrintExisted$1(null);
        this.label = 1;
        r5 = BuildersKt.withContext(r7, r2, this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
