package com.larus.dora.obric.onboarding;

import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.dora.impl.databinding.ObricDoraGOnboardingFragmentV2Binding;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class y extends p {
    @Override // com.larus.dora.obric.onboarding.p
    public final void b() {
        ObricDoraGOnboardingViewModelV2 r0 = this.c;
        if (r0 == null) goto L5;
        r0.setWelcomeMusicAllowed(true, "obric welcome display");
        r0.playWelcomeMusic();
    L5:
        ObricDoraGOnboardingFragmentV2Binding r1 = this.b;
        if (r1 == null) goto L18;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        LinearLayout r2 = r1.e;
        Intrinsics.checkNotNull(r2);
        d69.a.b(r2, false);
        r1.f.y();
        j19.c.d(r1.v);
        j19.c.d(r1.u);
        j19.c.d(r1.c);
        j19.c.d(r1.k);
        j19.c.d(r1.h);
        j19.c.d(r1.r);
        j19.c.d(r1.t);
        j19.c.d(r1.s);
        j19.c.d(r1.b);
        j19.c.d(r1.j);
        j19.c.d(r1.l);
        j19.c.d(r1.m);
        j19.c.d(r1.p);
        com.larus.utils.e1.q(r1.d.c);
        Fragment r3 = this.a;
        if ((r3 instanceof ObricDoraGOnboardingWelcomeStateFragment) == false) goto L10;
        ObricDoraGOnboardingWelcomeStateFragment r4 = (ObricDoraGOnboardingWelcomeStateFragment) r3;
    L11:
        if (r4 == null) goto L16;
        int r5 = r4.J + 1;
        r4.J = r5;
        Job r6 = r4.K;
        if (r6 == null) goto L15;
        Job.DefaultImpls.cancel$default(r6, null, 1, null);
    L15:
        r4.K = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r4.getViewLifecycleOwner()), null, null, new ObricDoraGOnboardingWelcomeStateFragment$startWelcomeAlphaVideo$1(r5, r4, ObricDoraGOnboardingWelcomeStateFragment.Va0("onboarding/welcome/light/welcome_afx.mp4", "onboarding/welcome/dark/welcome_afx.mp4"), null), 3, null);
    L16:
        j19.c.d(r1.n);
        AppCompatTextView r7 = r1.f;
        StringBuilder r8 = new StringBuilder();
        int r9 = com.larus.utils.j0.a;
        r8.append(com.larus.utils.j0.d(2131902827));
        r8.append('\n');
        r8.append(com.larus.utils.j0.d(2131902803));
        r7.setText(r8.toString());
        j19.c.d(r1.g);
        w.a(r1, w.b(2131902810), false);
        return;
    L10:
        r4 = null;
        goto L11
    }

    @Override // com.larus.dora.obric.onboarding.p
    public final p e() {
        Fragment r0 = this.a;
        if ((r0 instanceof ObricDoraGOnboardingWelcomeStateFragment) == false) goto L5;
        ObricDoraGOnboardingWelcomeStateFragment r1 = (ObricDoraGOnboardingWelcomeStateFragment) r0;
    L6:
        if (r1 == null) goto L9;
        r1.fb0();
    L9:
        return new x(this.a, this.b, this.c);
    L5:
        r1 = null;
        goto L6
    }

    public y(Fragment r2, ObricDoraGOnboardingFragmentV2Binding r3, ObricDoraGOnboardingViewModelV2 r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2, r3, r4);
    }
}
