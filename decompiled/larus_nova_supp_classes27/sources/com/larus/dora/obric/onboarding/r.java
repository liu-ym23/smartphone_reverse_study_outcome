package com.larus.dora.obric.onboarding;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.dora.impl.databinding.ObricDoraGOnboardingFragmentV2Binding;
import com.ss.android.ugc.aweme.live.alphaplayer.controller.IPlayerController;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class r extends p {
    @Override // com.larus.dora.obric.onboarding.p
    public final void b() {
        ObricDoraGOnboardingViewModelV2 r0 = this.c;
        if (r0 == null) goto L5;
        r0.exitOnboarding();
    L5:
        ObricDoraGOnboardingViewModelV2 r1 = this.c;
        boolean r2 = true;
        if (r1 != null) goto L8;
    L10:
        boolean r3 = false;
    L12:
        if (r3 == false) goto L27;
        Bundle r4 = this.a.getArguments();
        if (r4 != null) goto L16;
    L18:
        boolean r5 = false;
    L19:
        if (r5 == true) goto L27;
        g49.d.d("ObricDoraGOnboardingFragmentUiState", "skip diary onboarding because env observe is already enabled");
        LifecycleOwner r6 = this.a;
        Intrinsics.checkNotNullParameter(r6, "<this>");
        if ((r6 instanceof ObricDoraGOnboardingUiStateBaseFragment) == false) goto L23;
        ObricDoraGOnboardingUiStateBaseFragment r7 = (ObricDoraGOnboardingUiStateBaseFragment) r6;
    L24:
        if (r7 == null) goto L81;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r7), null, null, new ObricDoraGOnboardingFragmentUiStateV2Kt$gotoNext$1$1(r7, null), 3, null);
        return;
    L81:
        return;
    L23:
        r7 = null;
        goto L24
    L16:
        if (r4.getBoolean("obric_open_env_observe_after_auth") != true) goto L18;
        r5 = true;
    L27:
        Bundle r8 = this.a.getArguments();
        if (r8 != null) goto L30;
    L32:
        r2 = false;
    L33:
        if (r2 == true) goto L37;
        ObricDoraGOnboardingViewModelV2 r9 = this.c;
        if (r9 == null) goto L37;
        ObricDoraGOnboardingViewModelV2.playTTS$default(r9, w.b(2131903691), null, 2, null);
    L37:
        ObricDoraGOnboardingFragmentV2Binding r10 = this.b;
        if (r10 == null) goto L40;
        j19.c.d(r10.e);
        j19.c.d(r10.d.a);
    L40:
        Fragment r11 = this.a;
        if ((r11 instanceof ObricDoraGOnboardingWelcomeStateFragment) == false) goto L43;
        final ObricDoraGOnboardingWelcomeStateFragment r12 = (ObricDoraGOnboardingWelcomeStateFragment) r11;
    L44:
        if (r12 == null) goto L82;
        IPlayerController r13 = r12.B;
        if (r13 == null) goto L48;
        r13.stop();
    L48:
        IPlayerController r14 = r12.B;
        if (r14 == null) goto L51;
        r14.release();
    L51:
        r12.B = null;
        IPlayerController r15 = r12.C;
        if (r15 == null) goto L54;
        r15.stop();
    L54:
        IPlayerController r16 = r12.C;
        if (r16 == null) goto L57;
        r16.release();
    L57:
        r12.C = null;
        FrameLayout r17 = r12.D;
        if (r17 == null) goto L65;
        ViewParent r18 = r17.getParent();
        if ((r18 instanceof ViewGroup) == false) goto L62;
        ViewGroup r20 = (ViewGroup) r18;
    L63:
        if (r20 == null) goto L65;
        r20.removeView(r17);
        goto L65
    L62:
        r20 = null;
    L65:
        r12.D = null;
        r12.E = null;
        r12.F = false;
        FrameLayout r21 = r12.Za0();
        if (r21 == null) goto L68;
        r21.removeAllViews();
        com.larus.utils.e1.q(r21);
    L68:
        r12.Xa0();
        ObricDoraGOnboardingFragmentV2Binding r22 = r12.r;
        if (r22 == null) goto L83;
        ConstraintLayout r23 = r22.a;
        if (r23 == null) goto L84;
        ScrollView r24 = (ScrollView) r23.findViewById(2131381190);
        if (r24 == null) goto L85;
        com.larus.utils.e1.x(r24);
        View r25 = r24.findViewById(2131381187);
        if (r25 == null) goto L77;
        r25.setOnClickListener(new l1(r12));
    L77:
        View r26 = r24.findViewById(2131381189);
        if (r26 == null) goto L86;
        r26.setOnClickListener(new m1(r12));
        return;
    L86:
        return;
    L85:
        return;
    L84:
        return;
    L83:
        return;
    L82:
        return;
    L43:
        r12 = null;
        goto L44
    L30:
        if (r8.getBoolean("obric_open_env_observe_after_auth") != true) goto L32;
    L8:
        if (r1.isEnvAuth() != true) goto L10;
        r3 = true;
        goto L12
    }

    @Override // com.larus.dora.obric.onboarding.p
    public final p e() {
        ObricDoraGOnboardingViewModelV2 r0 = this.c;
        if (r0 == null) goto L5;
        r0.stopTTS("exit diary");
    L5:
        Fragment r1 = this.a;
        if ((r1 instanceof ObricDoraGOnboardingWelcomeStateFragment) == false) goto L8;
        ObricDoraGOnboardingWelcomeStateFragment r2 = (ObricDoraGOnboardingWelcomeStateFragment) r1;
    L9:
        if (r2 == null) goto L24;
        ObricDoraGOnboardingFragmentV2Binding r3 = r2.r;
        if (r3 == null) goto L24;
        ConstraintLayout r4 = r3.a;
        if (r4 == null) goto L24;
        ScrollView r5 = (ScrollView) r4.findViewById(2131381190);
        if (r5 == null) goto L24;
        View r6 = r5.findViewById(2131381187);
        if (r6 == null) goto L19;
        r6.setOnClickListener(null);
    L19:
        View r7 = r5.findViewById(2131381189);
        if (r7 == null) goto L22;
        r7.setOnClickListener(null);
    L22:
        com.larus.utils.e1.o(r5);
    L24:
        return new s(this.a, this.b, this.c);
    L8:
        r2 = null;
        goto L9
    }

    public r(Fragment r2, ObricDoraGOnboardingFragmentV2Binding r3, ObricDoraGOnboardingViewModelV2 r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2, r3, r4);
    }
}
