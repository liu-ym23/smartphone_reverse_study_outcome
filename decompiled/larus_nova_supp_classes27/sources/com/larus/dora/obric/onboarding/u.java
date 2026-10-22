package com.larus.dora.obric.onboarding;

import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.larus.dora.impl.databinding.ObricDoraGOnboardingFragmentV2Binding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class u extends p {
    public final String h;
    public final boolean i;

    @Override // com.larus.dora.obric.onboarding.p
    public final void b() {
        ObricDoraGOnboardingViewModelV2 r0 = this.c;
        final ObricDoraGOnboardingWelcomeStateFragment r1 = null;
        if (r0 == null) goto L5;
        r0.enterMediaControlMode();
        ObricDoraGOnboardingViewModelV2.playTTSAfterVuiModeReady$default(r0, w.b(2131903701), null, 2, null);
    L5:
        ObricDoraGOnboardingFragmentV2Binding r2 = this.b;
        if (r2 == null) goto L8;
        j19.c.d(r2.e);
        w.a(r2, w.b(2131903731), false);
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
        FrameLayout r6 = (FrameLayout) r5.findViewById(2131381208);
        if (r6 == null) goto L24;
        r1.jb0(4);
        final FrameLayout r7 = (FrameLayout) r6.findViewById(2131381209);
        final int r8 = r1.O + 1;
        r1.O = r8;
        com.larus.utils.e1.x(r6);
        r7.post(new j1(r8, r1, r7));
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
        r0.stopTTS("exit media control");
    L5:
        Fragment r1 = this.a;
        if ((r1 instanceof ObricDoraGOnboardingWelcomeStateFragment) == false) goto L8;
        ObricDoraGOnboardingWelcomeStateFragment r2 = (ObricDoraGOnboardingWelcomeStateFragment) r1;
    L9:
        if (r2 == null) goto L12;
        r2.Ka0();
    L12:
        return new v(this.a, this.b, this.c, this.h, this.i);
    L8:
        r2 = null;
        goto L9
    }

    @Override // com.larus.dora.obric.onboarding.p
    public final p f() {
        ObricDoraGOnboardingViewModelV2 r0 = this.c;
        if (r0 == null) goto L5;
        r0.stopTTS("back from media control");
    L5:
        Fragment r1 = this.a;
        if ((r1 instanceof ObricDoraGOnboardingWelcomeStateFragment) == false) goto L8;
        ObricDoraGOnboardingWelcomeStateFragment r2 = (ObricDoraGOnboardingWelcomeStateFragment) r1;
    L9:
        if (r2 == null) goto L12;
        r2.Ka0();
    L12:
        return new t(this.a, this.b, this.c, this.h, this.i);
    L8:
        r2 = null;
        goto L9
    }

    public u(Fragment r2, ObricDoraGOnboardingFragmentV2Binding r3, ObricDoraGOnboardingViewModelV2 r4, String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2, r3, r4);
        this.h = r5;
        this.i = r6;
    }
}
