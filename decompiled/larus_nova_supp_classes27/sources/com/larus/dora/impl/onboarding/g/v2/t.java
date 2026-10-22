package com.larus.dora.impl.onboarding.g.v2;

import androidx.fragment.app.Fragment;
import com.larus.dora.impl.databinding.LarusDoraGOnboardingFragmentV2Binding;
import com.larus.dora.impl.onboarding.g.v2.base.DoraGOnboardingUiStateBaseFragment;
import com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class t extends f {
    /* JADX WARN: Type inference failed for: r1v2, types: [android.widget.TextView, com.larus.dora.impl.view.DoraTextViewWithAnim] */
    @Override // com.larus.dora.impl.onboarding.g.v2.f
    public final void b() {
        DoraGOnboardingViewModelV2 r0 = this.c;
        if (r0 == null) goto L5;
        r0.enterCheckWearMode();
    L5:
        LarusDoraGOnboardingFragmentV2Binding r1 = this.b;
        if (r1 == null) goto L9;
        DoraGOnboardingFragmentUiStateV2Kt.g(r1, false);
        j19.c.d(r1.n);
        ?? r2 = r1.f;
        r2.setText(DoraGOnboardingFragmentUiStateV2Kt.c(2131902825));
        r2.x();
        j19.c.d(r1.g);
        DoraGOnboardingFragmentUiStateV2Kt.a(r1);
        return;
    }

    @Override // com.larus.dora.impl.onboarding.g.v2.f
    public final f g() {
        DoraGOnboardingViewModelV2 r0 = this.c;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == true) goto L9;
        Fragment r2 = this.a;
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.larus.dora.impl.onboarding.g.v2.base.DoraGOnboardingUiStateBaseFragment");
        return new DoraGOnboardingFragmentUiStatePhoto((DoraGOnboardingUiStateBaseFragment) r2, this.b, this.c);
    L9:
        return new l(this.a, this.b, this.c);
    L5:
        if (r0.isSupportNewOb() == true) goto L7;
        r1 = true;
        goto L7
    }

    @Override // com.larus.dora.impl.onboarding.g.v2.f
    public final void h(boolean r1) {
        if (r1 == true) goto L4;
        return;
    L4:
        if (this.i == false) goto L6;
        return;
    L6:
        this.i = true;
        LarusDoraGOnboardingFragmentV2Binding r2 = this.b;
        if (r2 == null) goto L14;
        DoraGOnboardingFragmentUiStateV2Kt.f(r2);
        DoraGOnboardingViewModelV2 r3 = this.c;
        if (r3 == null) goto L11;
        r3.playSuccessMusic();
    L11:
        DoraGOnboardingFragmentUiStateV2Kt.d(this.a);
        return;
    }

    public t(Fragment r2, LarusDoraGOnboardingFragmentV2Binding r3, DoraGOnboardingViewModelV2 r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2, r3, r4);
    }
}
