package com.larus.dora.obric.onboarding;

import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.larus.dora.impl.databinding.ObricDoraGOnboardingFragmentV2Binding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class t extends p {
    public final String h;
    public final boolean i;

    @Override // com.larus.dora.obric.onboarding.p
    public final void b() {
        ObricDoraGOnboardingViewModelV2 r0 = this.c;
        final ObricDoraGOnboardingWelcomeStateFragment r1 = null;
        if (r0 == null) goto L5;
        r0.enterLongPressWakeupMode();
        ObricDoraGOnboardingViewModelV2.playTTSAfterVuiModeReady$default(r0, w.b(2131912742), null, 2, null);
    L5:
        ObricDoraGOnboardingFragmentV2Binding r2 = this.b;
        if (r2 == null) goto L8;
        j19.c.d(r2.e);
        w.a(r2, w.b(2131903698), false);
    L8:
        Fragment r3 = this.a;
        if ((r3 instanceof ObricDoraGOnboardingWelcomeStateFragment) == false) goto L11;
        r1 = (ObricDoraGOnboardingWelcomeStateFragment) r3;
    L11:
        if (r1 == null) goto L24;
        ObricDoraGOnboardingFragmentV2Binding r4 = r1.r;
        if (r4 == null) goto L25;
        ConstraintLayout r5 = r4.a;
        if (r5 == null) goto L26;
        FrameLayout r6 = (FrameLayout) r5.findViewById(2131381205);
        if (r6 == null) goto L27;
        r1.jb0(3);
        final FrameLayout r7 = (FrameLayout) r6.findViewById(2131381206);
        LinearLayout r8 = (LinearLayout) r6.findViewById(2131381204);
        if (r8 == null) goto L22;
        com.larus.utils.e1.x(r8);
    L22:
        final int r9 = r1.N + 1;
        r1.N = r9;
        com.larus.utils.e1.x(r6);
        r7.post(new i1(r9, r1, r7));
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    }

    @Override // com.larus.dora.obric.onboarding.p
    public final p e() {
        ObricDoraGOnboardingViewModelV2 r0 = this.c;
        if (r0 == null) goto L5;
        r0.stopTTS("exit long press wakeup");
    L5:
        Fragment r1 = this.a;
        if ((r1 instanceof ObricDoraGOnboardingWelcomeStateFragment) == false) goto L8;
        ObricDoraGOnboardingWelcomeStateFragment r2 = (ObricDoraGOnboardingWelcomeStateFragment) r1;
    L9:
        if (r2 == null) goto L12;
        r2.Ja0();
    L12:
        return new u(this.a, this.b, this.c, this.h, this.i);
    L8:
        r2 = null;
        goto L9
    }

    @Override // com.larus.dora.obric.onboarding.p
    public final p f() {
        ObricDoraGOnboardingViewModelV2 r0 = this.c;
        if (r0 == null) goto L5;
        r0.stopTTS("back from long press wakeup");
    L5:
        Fragment r1 = this.a;
        if ((r1 instanceof ObricDoraGOnboardingWelcomeStateFragment) == false) goto L8;
        ObricDoraGOnboardingWelcomeStateFragment r2 = (ObricDoraGOnboardingWelcomeStateFragment) r1;
    L9:
        if (r2 == null) goto L12;
        r2.Ja0();
    L12:
        return new x(this.a, this.b, this.c);
    L8:
        r2 = null;
        goto L9
    }

    public t(Fragment r2, ObricDoraGOnboardingFragmentV2Binding r3, ObricDoraGOnboardingViewModelV2 r4, String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2, r3, r4);
        this.h = r5;
        this.i = r6;
    }
}
