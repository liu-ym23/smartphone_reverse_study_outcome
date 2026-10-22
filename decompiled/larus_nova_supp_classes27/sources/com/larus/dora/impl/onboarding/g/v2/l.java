package com.larus.dora.impl.onboarding.g.v2;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import com.larus.dora.impl.databinding.LarusDoraGOnboardingFragmentV2Binding;
import com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2;
import com.larus.dora.impl.view.DoraMovieView;
import com.larus.utils.e1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class l extends f {
    @Override // com.larus.dora.impl.onboarding.g.v2.f
    public final void b() {
        DoraGOnboardingViewModelV2 r0 = this.c;
        if (r0 == null) goto L5;
        r0.enterMediaControlMode();
    L5:
        LarusDoraGOnboardingFragmentV2Binding r1 = this.b;
        if (r1 == null) goto L9;
        DoraGOnboardingFragmentUiStateV2Kt.g(r1, true);
        final DoraMovieView r2 = r1.o;
        r2.f();
        r2.post(new j(r2, this));
        j19.c.d(r1.n);
        AppCompatTextView r3 = r1.f;
        r3.setText(DoraGOnboardingFragmentUiStateV2Kt.c(2131902802));
        Intrinsics.checkNotNull(r3);
        e1.x(r3);
        AppCompatTextView r4 = r1.g;
        Intrinsics.checkNotNull(r4);
        e1.x(r4);
        r4.setText(DoraGOnboardingFragmentUiStateV2Kt.c(2131902801));
        DoraGOnboardingFragmentUiStateV2Kt.b(r1, DoraGOnboardingFragmentUiStateV2Kt.c(2131902789), false);
        return;
    }

    @Override // com.larus.dora.impl.onboarding.g.v2.f
    public final f g() {
        return new i(this.a, this.b, this.c);
    }

    public l(Fragment r2, LarusDoraGOnboardingFragmentV2Binding r3, DoraGOnboardingViewModelV2 r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2, r3, r4);
    }
}
