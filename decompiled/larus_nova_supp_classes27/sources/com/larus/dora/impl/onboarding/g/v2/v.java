package com.larus.dora.impl.onboarding.g.v2;

import androidx.fragment.app.Fragment;
import com.larus.dora.impl.databinding.LarusDoraGOnboardingFragmentV2Binding;
import com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2;
import com.larus.dora.impl.view.DoraMovieView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class v extends f {
    @Override // com.larus.dora.impl.onboarding.g.v2.f
    public final void b() {
        DoraGOnboardingViewModelV2 r0 = this.c;
        if (r0 == null) goto L5;
        r0.playWelcomeMusic();
    L5:
        LarusDoraGOnboardingFragmentV2Binding r1 = this.b;
        if (r1 == null) goto L9;
        DoraGOnboardingFragmentUiStateV2Kt.g(r1, false);
        final DoraMovieView r2 = r1.o;
        r2.post(new u(r2, this));
        j19.c.d(r1.n);
        r1.f.setText(DoraGOnboardingFragmentUiStateV2Kt.i(2131902827, 2131902803));
        j19.c.d(r1.g);
        DoraGOnboardingFragmentUiStateV2Kt.b(r1, DoraGOnboardingFragmentUiStateV2Kt.c(2131902810), false);
        return;
    }

    @Override // com.larus.dora.impl.onboarding.g.v2.f
    public final f g() {
        DoraGOnboardingViewModelV2 r0 = this.c;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L13;
        if (this.c.isSupportNewOb() == false) goto L15;
        return new DoraGOnboardingFragmentUiStatePhoto(this.a, this.b, this.c);
    L15:
        return new l(this.a, this.b, this.c);
    L13:
        return new t(this.a, this.b, this.c);
    L5:
        if (r0.isWearState() != true) goto L7;
        r1 = true;
        goto L7
    }

    public v(Fragment r2, LarusDoraGOnboardingFragmentV2Binding r3, DoraGOnboardingViewModelV2 r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2, r3, r4);
    }
}
