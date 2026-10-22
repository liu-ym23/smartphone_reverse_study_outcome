package com.larus.dora.obric.onboarding;

import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.ss.android.ugc.aweme.live.alphaplayer.Configuration;
import com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController;
import com.ss.android.ugc.aweme.live.alphaplayer.controller.PlayerController;
import com.ss.android.ugc.aweme.live.alphaplayer.model.DataSource;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingWelcomeStateFragment$preloadNextAlphaVideoAssets$1", f = "ObricDoraGOnboardingWelcomeStateFragment.kt", i = {0, 0}, l = {1378}, m = "invokeSuspend", n = {"$this$launch", "assetPath"}, s = {"L$0", "L$4"})
public final class ObricDoraGOnboardingWelcomeStateFragment$preloadNextAlphaVideoAssets$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $assetPaths;
    final /* synthetic */ String $reason;
    final /* synthetic */ int $requestId;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ ObricDoraGOnboardingWelcomeStateFragment this$0;

    public ObricDoraGOnboardingWelcomeStateFragment$preloadNextAlphaVideoAssets$1(List<String> r1, int r2, ObricDoraGOnboardingWelcomeStateFragment r3, String r4, Continuation<? super ObricDoraGOnboardingWelcomeStateFragment$preloadNextAlphaVideoAssets$1> r5) {
        this.$assetPaths = r1;
        this.$requestId = r2;
        this.this$0 = r3;
        this.$reason = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        ObricDoraGOnboardingWelcomeStateFragment$preloadNextAlphaVideoAssets$1 r6 = new ObricDoraGOnboardingWelcomeStateFragment$preloadNextAlphaVideoAssets$1(this.$assetPaths, this.$requestId, this.this$0, this.$reason, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x007f -> B:15:0x0088). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r24) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        int r3 = 1;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        int r4 = this.I$0;
        String r5 = (String) this.L$4;
        Iterator r6 = (Iterator) this.L$3;
        String r7 = (String) this.L$2;
        ObricDoraGOnboardingWelcomeStateFragment r8 = (ObricDoraGOnboardingWelcomeStateFragment) this.L$1;
        CoroutineScope r9 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r24);
        Object r10 = r24;
        CoroutineScope r11 = r9;
        ObricDoraGOnboardingWelcomeStateFragment r12 = r8;
        String r13 = r7;
        Iterator r14 = r6;
        ObricDoraGOnboardingWelcomeStateFragment$preloadNextAlphaVideoAssets$1 r15 = this;
    L15:
        Object r16 = ((Result) r10).unbox-impl();
        if (Result.isSuccess-impl(r16) == false) goto L21;
        File r17 = (File) r16;
        if (r17 == null) goto L21;
        g49.d.d("ObricDoraGOnboardingWelcomeStateFragment", "preload alpha video cache success, reason=" + r13 + ", assetPath=" + r5 + ", size=" + r17.length());
    L21:
        Throwable r18 = Result.exceptionOrNull-impl(r16);
        if (r18 == null) goto L25;
        g49.d.c("ObricDoraGOnboardingWelcomeStateFragment", "preload alpha video cache failed, reason=" + r13 + ", assetPath=" + r5, r18);
    L25:
        if (CoroutineScopeKt.isActive(r11) == false) goto L31;
        if (r4 != r12.H) goto L31;
        ObricDoraGOnboardingWelcomeStateFragment$preloadNextAlphaVideoAssets$1 r20 = r15;
        Iterator r21 = r14;
        String r22 = r13;
        ObricDoraGOnboardingWelcomeStateFragment r23 = r12;
        CoroutineScope r25 = r11;
        r3 = 1;
    L10:
        if (r21.hasNext() == false) goto L32;
        String r26 = (String) r21.next();
        CoroutineDispatcher r110 = Dispatchers.getIO();
        ObricDoraGOnboardingWelcomeStateFragment$preloadNextAlphaVideoAssets$1$1$result$1 r111 = new ObricDoraGOnboardingWelcomeStateFragment$preloadNextAlphaVideoAssets$1$1$result$1(r23, r26, null);
        r20.L$0 = r25;
        r20.L$1 = r23;
        r20.L$2 = r22;
        r20.L$3 = r21;
        r20.L$4 = r26;
        r20.I$0 = r4;
        r20.label = r3;
        r10 = BuildersKt.withContext(r110, r111, r20);
        if (r10 != r1) goto L14;
        return r1;
    L14:
        Iterator r27 = r21;
        r15 = r20;
        r5 = r26;
        r11 = r25;
        r12 = r23;
        r13 = r22;
        r14 = r27;
        goto L15
    L32:
        String r28 = (String) CollectionsKt.firstOrNull(r20.$assetPaths);
        if (r28 == null) goto L101;
        int r30 = r20.$requestId;
        ObricDoraGOnboardingWelcomeStateFragment r31 = r20.this$0;
        if (r30 != r31.H) goto L101;
        if (StringsKt.contains$default(r28, "welcome_afx", false, 2, null) == false) goto L40;
        int r32 = 199;
    L68:
        if (r30 != r31.H) goto L101;
        if (Intrinsics.areEqual(r28, r31.E) == true) goto L73;
    L75:
        DataSource r33 = r31.Da0(r28, r32, false);
        if (r33 == null) goto L101;
        IPlayerController r34 = r31.C;
        if (r34 == null) goto L81;
        r34.release();
    L81:
        r31.C = null;
        FrameLayout r35 = r31.D;
        if (r35 == null) goto L89;
        ViewParent r36 = r35.getParent();
        if ((r36 instanceof ViewGroup) == false) goto L86;
        ViewGroup r37 = (ViewGroup) r36;
    L87:
        if (r37 == null) goto L89;
        r37.removeView(r35);
        goto L89
    L86:
        r37 = null;
    L89:
        FrameLayout r38 = r31.Za0();
        if (r38 == null) goto L92;
        ViewParent r40 = r38.getParent();
    L94:
        if ((r40 instanceof ViewGroup) == false) goto L96;
        ViewGroup r41 = (ViewGroup) r40;
    L97:
        if (r41 == null) goto L101;
        FrameLayout r42 = new FrameLayout(r31.requireContext());
        r42.setVisibility(4);
        r41.addView(r42, new ViewGroup.LayoutParams(-1, -1));
        Configuration r43 = new Configuration();
        r43.a = r31.requireContext();
        r43.b = r31.getViewLifecycleOwner();
        r43.c = 1;
        r43.e = true;
        PlayerController r44 = new PlayerController(r43, null);
        r44.attachAlphaView(r42);
        r44.v = new p1(r42, r30, r31, r44, r28);
        r44.h = new q1();
        r31.C = r44;
        r31.D = r42;
        r31.E = r28;
        r31.F = false;
        r44.f(r33, false);
        goto L101
    L96:
        r41 = null;
        goto L97
    L92:
        r40 = null;
        goto L94
    L73:
        if (r31.C == null) goto L75;
    L40:
        if (StringsKt.contains$default(r28, "vision_query_afx", false, 2, null) == false) goto L43;
        r32 = 110;
        goto L68
    L43:
        if (StringsKt.contains$default(r28, "click_stop_a_afx", false, 2, null) == false) goto L46;
        r32 = 104;
        goto L68
    L46:
        if (StringsKt.contains$default(r28, "click_stop_b_afx", false, 2, null) == false) goto L49;
        r32 = 163;
        goto L68
    L49:
        if (StringsKt.contains$default(r28, "long_press_a_afx", false, 2, null) == false) goto L52;
        r32 = 112;
        goto L68
    L52:
        if (StringsKt.contains$default(r28, "long_press_b_afx", false, 2, null) == false) goto L55;
        r32 = 225;
        goto L68
    L55:
        if (StringsKt.contains$default(r28, "volume_afx", false, 2, null) == false) goto L58;
        r32 = 394;
        goto L68
    L58:
        if (StringsKt.contains$default(r28, "photo_a_afx", false, 2, null) == false) goto L61;
        r32 = 109;
        goto L68
    L61:
        if (StringsKt.contains$default(r28, "photo_b_afx", false, 2, null) == false) goto L64;
        r32 = 156;
        goto L68
    L64:
        if (StringsKt.contains$default(r28, "reality_guide_afx", false, 2, null) == false) goto L66;
        r32 = 82;
        goto L68
    L66:
        r32 = 0;
    L101:
        return Unit.INSTANCE;
    L31:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r24);
        CoroutineScope r45 = (CoroutineScope) this.L$0;
        List<String> r46 = this.$assetPaths;
        int r47 = this.$requestId;
        ObricDoraGOnboardingWelcomeStateFragment r48 = this.this$0;
        String r50 = this.$reason;
        r25 = r45;
        r4 = r47;
        r21 = r46.iterator();
        r20 = this;
        r23 = r48;
        r22 = r50;
        goto L10
    }
}
