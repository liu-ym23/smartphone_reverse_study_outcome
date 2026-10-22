package com.larus.dora.obric.onboarding;

import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingWelcomeStateFragment$preloadNextAlphaVideoAssets$1$1$result$1", f = "ObricDoraGOnboardingWelcomeStateFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricDoraGOnboardingWelcomeStateFragment$preloadNextAlphaVideoAssets$1$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends File>>, Object> {
    final /* synthetic */ String $assetPath;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ObricDoraGOnboardingWelcomeStateFragment this$0;

    public ObricDoraGOnboardingWelcomeStateFragment$preloadNextAlphaVideoAssets$1$1$result$1(ObricDoraGOnboardingWelcomeStateFragment r1, String r2, Continuation<? super ObricDoraGOnboardingWelcomeStateFragment$preloadNextAlphaVideoAssets$1$1$result$1> r3) {
        this.this$0 = r1;
        this.$assetPath = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        ObricDoraGOnboardingWelcomeStateFragment$preloadNextAlphaVideoAssets$1$1$result$1 r0 = new ObricDoraGOnboardingWelcomeStateFragment$preloadNextAlphaVideoAssets$1$1$result$1(this.this$0, this.$assetPath, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<? extends File>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r3);
        CoroutineScope r4 = (CoroutineScope) this.L$0;
        ObricDoraGOnboardingWelcomeStateFragment r5 = this.this$0;
        String r0 = this.$assetPath;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        int r2 = ObricDoraGOnboardingWelcomeStateFragment.y1;     // Catch: Throwable -> L7
        Object r6 = Result.constructor-impl(r5.Wa0(r0));     // Catch: Throwable -> L7
    L10:
        return Result.box-impl(r6);
    L7:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
