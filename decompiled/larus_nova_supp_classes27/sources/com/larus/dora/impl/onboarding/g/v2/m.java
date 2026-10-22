package com.larus.dora.impl.onboarding.g.v2;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import com.larus.dora.impl.databinding.LarusDoraGOnboardingFragmentV2Binding;
import com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class m extends f {
    @Override // com.larus.dora.impl.onboarding.g.v2.f
    public final void b() {
        DoraGOnboardingViewModelV2 r0 = this.c;
        if (r0 == null) goto L5;
        r0.enterVoiceOnlyMode();
    L5:
        LarusDoraGOnboardingFragmentV2Binding r1 = this.b;
        if (r1 == null) goto L9;
        DoraGOnboardingFragmentUiStateV2Kt.h(r1);
        d69.a.a(r1.c);
        d69.a.a(r1.b);
        AppCompatTextView r2 = r1.w;
        r2.setText(DoraGOnboardingFragmentUiStateV2Kt.c(2131902819));
        Intrinsics.checkNotNull(r2);
        d69.a.a(r2);
        AppCompatTextView r3 = r1.v;
        r3.setText(DoraGOnboardingFragmentUiStateV2Kt.c(2131902820));
        Intrinsics.checkNotNull(r3);
        d69.a.a(r3);
        j19.c.d(r1.u);
        j19.c.d(r1.t);
        this.e = DoraGOnboardingFragmentUiStateV2Kt.e(this.a, this.b);
        return;
    }

    @Override // com.larus.dora.impl.onboarding.g.v2.f
    public final f g() {
        Job r0 = this.e;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        DoraGOnboardingViewModelV2 r1 = this.c;
        if (r1 == null) goto L9;
        r1.exitVoiceOnly();
        r1.stopTTS("enter media control");
    L9:
        return new l(this.a, this.b, this.c);
    }

    public m(Fragment r2, LarusDoraGOnboardingFragmentV2Binding r3, DoraGOnboardingViewModelV2 r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2, r3, r4);
    }
}
