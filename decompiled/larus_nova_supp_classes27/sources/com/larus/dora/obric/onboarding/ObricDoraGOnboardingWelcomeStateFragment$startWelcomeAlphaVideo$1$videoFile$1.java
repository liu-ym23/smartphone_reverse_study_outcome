package com.larus.dora.obric.onboarding;

import java.io.File;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingWelcomeStateFragment$startWelcomeAlphaVideo$1$videoFile$1", f = "ObricDoraGOnboardingWelcomeStateFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricDoraGOnboardingWelcomeStateFragment$startWelcomeAlphaVideo$1$videoFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super File>, Object> {
    final /* synthetic */ String $assetPath;
    int label;
    final /* synthetic */ ObricDoraGOnboardingWelcomeStateFragment this$0;

    public ObricDoraGOnboardingWelcomeStateFragment$startWelcomeAlphaVideo$1$videoFile$1(ObricDoraGOnboardingWelcomeStateFragment r1, String r2, Continuation<? super ObricDoraGOnboardingWelcomeStateFragment$startWelcomeAlphaVideo$1$videoFile$1> r3) {
        this.this$0 = r1;
        this.$assetPath = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ObricDoraGOnboardingWelcomeStateFragment$startWelcomeAlphaVideo$1$videoFile$1(this.this$0, this.$assetPath, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super File> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        ObricDoraGOnboardingWelcomeStateFragment r4 = this.this$0;
        String r0 = this.$assetPath;
        int r1 = ObricDoraGOnboardingWelcomeStateFragment.y1;
        return r4.Wa0(r0);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
