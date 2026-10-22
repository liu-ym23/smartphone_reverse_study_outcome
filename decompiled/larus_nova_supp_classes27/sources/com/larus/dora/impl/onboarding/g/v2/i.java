package com.larus.dora.impl.onboarding.g.v2;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import com.larus.dora.impl.databinding.LarusDoraGOnboardingBottomBtnLayoutBinding;
import com.larus.dora.impl.databinding.LarusDoraGOnboardingFragmentV2Binding;
import com.larus.dora.impl.onboarding.g.v2.base.DoraGOnboardingUiStateBaseFragment;
import com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2;
import com.larus.dora.impl.view.DoraMovieView;
import com.larus.utils.e1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class i extends f {
    @Override // com.larus.dora.impl.onboarding.g.v2.f
    public final f a() {
        DoraGOnboardingViewModelV2 r0 = this.c;
        if (r0 == null) goto L5;
        r0.againOnboarding();
    L5:
        LarusDoraGOnboardingFragmentV2Binding r1 = this.b;
        if (r1 == null) goto L9;
        final DoraMovieView r2 = r1.o;
        r2.post(new h(r2));
    L9:
        return new v(this.a, this.b, this.c);
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [android.widget.TextView, com.larus.dora.impl.view.DoraTextViewWithAnim] */
    @Override // com.larus.dora.impl.onboarding.g.v2.f
    public final void b() {
        LarusDoraGOnboardingFragmentV2Binding r0 = this.b;
        if (r0 == null) goto L9;
        DoraGOnboardingFragmentUiStateV2Kt.g(r0, false);
        final DoraMovieView r1 = r0.o;
        r1.post(new g(r1, this));
        j19.c.d(r0.n);
        ?? r2 = r0.f;
        r2.y();
        r2.setText(DoraGOnboardingFragmentUiStateV2Kt.c(2131902797));
        j19.c.d(r0.g);
        CharSequence r3 = DoraGOnboardingFragmentUiStateV2Kt.c(2131902788);
        CharSequence r4 = DoraGOnboardingFragmentUiStateV2Kt.c(2131902824);
        Intrinsics.checkNotNullParameter(r0, "<this>");
        LarusDoraGOnboardingBottomBtnLayoutBinding r5 = r0.d;
        e1.x(r5.c);
        AppCompatTextView r6 = r5.d;
        Intrinsics.checkNotNull(r6);
        e1.x(r6);
        if (r3 == null) goto L7;
        r6.setText(r3);
    L7:
        r6.setBackgroundResource(com.larus.dora.impl.util.u.a.a("larus_dora_g_onboarding_next_btn_bg"));
        j19.c.d(r5.f);
        e1.x(r5.e);
        AppCompatTextView r7 = r5.b;
        Intrinsics.checkNotNull(r7);
        e1.x(r7);
        r7.setText(r4);
        return;
    }

    @Override // com.larus.dora.impl.onboarding.g.v2.f
    public final f g() {
        DoraGOnboardingViewModelV2 r0 = this.c;
        if (r0 == null) goto L5;
        r0.exitOnboarding();
    L5:
        Fragment r1 = this.a;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.larus.dora.impl.onboarding.g.v2.base.DoraGOnboardingUiStateBaseFragment");
        ((DoraGOnboardingUiStateBaseFragment) r1).na0();
        return null;
    }

    public i(Fragment r2, LarusDoraGOnboardingFragmentV2Binding r3, DoraGOnboardingViewModelV2 r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2, r3, r4);
    }
}
