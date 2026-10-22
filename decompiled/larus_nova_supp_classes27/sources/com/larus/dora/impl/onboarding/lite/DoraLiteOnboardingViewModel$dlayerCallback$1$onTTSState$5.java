package com.larus.dora.impl.onboarding.lite;

import android.app.Application;
import com.larus.common.apphost.AppHost;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.onboarding.lite.DoraLiteOnboardingViewModel$dlayerCallback$1$onTTSState$5", f = "DoraLiteOnboardingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraLiteOnboardingViewModel$dlayerCallback$1$onTTSState$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DoraLiteOnboardingViewModel this$0;

    public DoraLiteOnboardingViewModel$dlayerCallback$1$onTTSState$5(DoraLiteOnboardingViewModel r1, Continuation<? super DoraLiteOnboardingViewModel$dlayerCallback$1$onTTSState$5> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraLiteOnboardingViewModel$dlayerCallback$1$onTTSState$5(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r3);
        this.this$0.stopTTS("TTS_CONNECT_FAILED");
        t19.s r4 = t19.s.a;
        Application r0 = AppHost.a.getApplication();
        r4.getClass();
        t19.s.b(r0, 2131908080, false);
        com.larus.call_plugins_doubao_common.manager.r r5 = DoraLiteOnboardingViewModel.access$getMediaManager$p(this.this$0);
        if (r5 == null) goto L8;
        com.larus.call_plugins_doubao_common.manager.n0.b(r5);
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
