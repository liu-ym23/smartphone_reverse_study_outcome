package com.larus.dora.obric.onboarding;

import com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController;
import com.ss.android.ugc.aweme.live.alphaplayer.model.DataSource;
import java.io.File;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingWelcomeStateFragment$startWelcomeAlphaVideo$1", f = "ObricDoraGOnboardingWelcomeStateFragment.kt", i = {0}, l = {310}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class ObricDoraGOnboardingWelcomeStateFragment$startWelcomeAlphaVideo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $assetPath;
    final /* synthetic */ int $playbackId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ObricDoraGOnboardingWelcomeStateFragment this$0;

    public ObricDoraGOnboardingWelcomeStateFragment$startWelcomeAlphaVideo$1(int r1, ObricDoraGOnboardingWelcomeStateFragment r2, String r3, Continuation<? super ObricDoraGOnboardingWelcomeStateFragment$startWelcomeAlphaVideo$1> r4) {
        this.$playbackId = r1;
        this.this$0 = r2;
        this.$assetPath = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        ObricDoraGOnboardingWelcomeStateFragment$startWelcomeAlphaVideo$1 r0 = new ObricDoraGOnboardingWelcomeStateFragment$startWelcomeAlphaVideo$1(this.$playbackId, this.this$0, this.$assetPath, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r8);
    L13:
        if (((File) r8) == null) goto L30;
        if (CoroutineScopeKt.isActive(r2) == false) goto L30;
        int r9 = this.$playbackId;
        ObricDoraGOnboardingWelcomeStateFragment r3 = this.this$0;
        if (r9 != r3.J) goto L30;
        IPlayerController r10 = r3.Ya0();
        if (r10 == null) goto L22;
        DataSource r4 = this.this$0.Da0(this.$assetPath, 199, false);
        if (r4 == null) goto L26;
        this.this$0.cb0();
        r10.f(r4, true);
        this.this$0.Ta0("welcome", new Pair[]{TuplesKt.to("onboarding/vision_query/light/vision_query_afx.mp4", "onboarding/vision_query/dark/vision_query_afx.mp4")});
        return Unit.INSTANCE;
    L26:
        return Unit.INSTANCE;
    L22:
        return Unit.INSTANCE;
    L30:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        CoroutineDispatcher r5 = Dispatchers.getIO();
        ObricDoraGOnboardingWelcomeStateFragment$startWelcomeAlphaVideo$1$videoFile$1 r6 = new ObricDoraGOnboardingWelcomeStateFragment$startWelcomeAlphaVideo$1$videoFile$1(this.this$0, this.$assetPath, null);
        this.L$0 = r11;
        this.label = 1;
        Object r7 = BuildersKt.withContext(r5, r6, this);
        if (r7 != r0) goto L11;
        return r0;
    L11:
        r2 = r11;
        r8 = r7;
        goto L13
    }
}
