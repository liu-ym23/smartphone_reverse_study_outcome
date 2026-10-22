package com.obric.assistant.audio;

import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.settings.experience.ObricUserExperiencePlanManager;
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
@DebugMetadata(c = "com.obric.assistant.audio.ObricEnrollInteropServiceImpl$syncHelpImproveVoiceWakeupEnabled$1", f = "ObricEnrollInteropServiceImpl.kt", i = {}, l = {274}, m = "invokeSuspend", n = {}, s = {})
final class ObricEnrollInteropServiceImpl$syncHelpImproveVoiceWakeupEnabled$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ String $uid;
    int label;

    public ObricEnrollInteropServiceImpl$syncHelpImproveVoiceWakeupEnabled$1(boolean r1, String r2, Continuation<? super ObricEnrollInteropServiceImpl$syncHelpImproveVoiceWakeupEnabled$1> r3) {
        this.$enabled = r1;
        this.$uid = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ObricEnrollInteropServiceImpl$syncHelpImproveVoiceWakeupEnabled$1(this.$enabled, this.$uid, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L12:
        if (((Boolean) r4).booleanValue() == true) goto L15;
        FLogger.a.w("ObricEnrollInteropServiceImpl", "syncHelpImproveVoiceWakeupEnabled failed uidLen=" + this.$uid.length() + " enabled=" + this.$enabled);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        ObricUserExperiencePlanManager r5 = ObricUserExperiencePlanManager.a;
        boolean r2 = this.$enabled;
        this.label = 1;
        r4 = r5.j(r2, this);
        if (r4 != r0) goto L12;
        return r0;
    }
}
