package com.obric.assistant.settings.provider;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.provider.ContinueSpeakNoiseReductionSettingProvider$getSettingItems$4", f = "ContinueSpeakNoiseReductionSettingProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ContinueSpeakNoiseReductionSettingProvider$getSettingItems$4 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
    int label;

    public ContinueSpeakNoiseReductionSettingProvider$getSettingItems$4(Continuation<? super ContinueSpeakNoiseReductionSettingProvider$getSettingItems$4> r2) {
        super(1, r2);
    }

    public final Continuation<Unit> create(Continuation<?> r2) {
        return new ContinueSpeakNoiseReductionSettingProvider$getSettingItems$4(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Boolean> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r3);
        com.obric.assistant.t1 r4 = com.obric.assistant.t1.a;
        if (r4.P() == true) goto L7;
    L13:
        boolean r5 = false;
    L15:
        return Boxing.boxBoolean(r5);
    L7:
        if (t9a.b.a().c("obric_feature_audio_os_mic_ref_sync") == false) goto L13;
        if (r4.isObricContTalkPvadSwitchShowEnable() == false) goto L13;
        if (r4.N() == false) goto L13;
        r5 = true;
        goto L15
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
