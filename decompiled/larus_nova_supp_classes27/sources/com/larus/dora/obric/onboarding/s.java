package com.larus.dora.obric.onboarding;

import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.dora.impl.databinding.ObricDoraGOnboardingFragmentV2Binding;
import com.larus.dora.impl.onboarding.DoraOnboardingDevice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s extends p {
    @Override // com.larus.dora.obric.onboarding.p
    public final p a() {
        Fragment r0 = this.a;
        if ((r0 instanceof ObricDoraGOnboardingWelcomeStateFragment) == false) goto L5;
        ObricDoraGOnboardingWelcomeStateFragment r1 = (ObricDoraGOnboardingWelcomeStateFragment) r0;
    L6:
        if (r1 == null) goto L8;
        r1.Ia0();
    L8:
        ObricDoraGOnboardingViewModelV2 r2 = this.c;
        if (r2 == null) goto L12;
        r2.stopTTS("exit finish");
        r2.againOnboarding();
    L12:
        return new y(this.a, this.b, this.c);
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.larus.dora.obric.onboarding.p
    public final void b() {
        ObricDoraGOnboardingViewModelV2 r0 = this.c;
        final ObricDoraGOnboardingWelcomeStateFragment r1 = null;
        if (r0 == null) goto L5;
        ObricDoraGOnboardingViewModelV2.playTTS$default(r0, w.b(2131903695), null, 2, null);
    L5:
        ObricDoraGOnboardingFragmentV2Binding r2 = this.b;
        if (r2 == null) goto L8;
        j19.c.d(r2.e);
        w.a(r2, w.b(2131903692), false);
    L8:
        Fragment r3 = this.a;
        if ((r3 instanceof ObricDoraGOnboardingWelcomeStateFragment) == false) goto L11;
        r1 = (ObricDoraGOnboardingWelcomeStateFragment) r3;
    L11:
        if (r1 == null) goto L21;
        ObricDoraGOnboardingFragmentV2Binding r4 = r1.r;
        if (r4 == null) goto L22;
        ConstraintLayout r5 = r4.a;
        if (r5 == null) goto L23;
        FrameLayout r6 = (FrameLayout) r5.findViewById(2131381192);
        if (r6 == null) goto L24;
        final FrameLayout r7 = (FrameLayout) r6.findViewById(2131381193);
        final int r8 = r1.Q + 1;
        r1.Q = r8;
        r1.Ma0(false);
        com.larus.utils.e1.x(r6);
        r7.post(new k1(r8, r1, r7));
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    }

    @Override // com.larus.dora.obric.onboarding.p
    public final p e() {
        ObricDoraGOnboardingViewModelV2 r0 = this.c;
        if (r0 == null) goto L5;
        r0.stopTTS("exit finish");
    L5:
        Fragment r1 = this.a;
        if ((r1 instanceof ObricDoraGOnboardingWelcomeStateFragment) == false) goto L8;
        ObricDoraGOnboardingWelcomeStateFragment r2 = (ObricDoraGOnboardingWelcomeStateFragment) r1;
    L9:
        if (r2 == null) goto L11;
        r2.Ia0();
    L11:
        ObricDoraGOnboardingViewModelV2 r3 = this.c;
        if (r3 == null) goto L14;
        r3.exitOnboarding();
    L14:
        Fragment r4 = this.a;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.larus.dora.obric.onboarding.ObricDoraGOnboardingUiStateBaseFragment");
        DoraOnboardingDevice r5 = ((ObricDoraGOnboardingUiStateBaseFragment) r4).ga0().getDoraOnboardingDevice();
        if (r5 == null) goto L17;
        String r6 = r5.b;
    L18:
        if (r6 != null) goto L20;
    L23:
        boolean r7 = true;
    L24:
        if (r7 == true) goto L27;
        ObricDoraGOnboardingBaseFragmentV2.ha0(r6);
    L27:
        FragmentActivity r8 = ((ObricDoraGOnboardingUiStateBaseFragment) this.a).getActivity();
        if (r8 == null) goto L30;
        r8.finish();
    L30:
        return null;
    L20:
        if (r6.length() == 0) goto L23;
        r7 = false;
        goto L24
    L17:
        r6 = null;
        goto L18
    L8:
        r2 = null;
        goto L9
    }

    public s(Fragment r2, ObricDoraGOnboardingFragmentV2Binding r3, ObricDoraGOnboardingViewModelV2 r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2, r3, r4);
    }
}
