package com.larus.dora.impl.onboarding.g.v2;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import com.larus.dora.impl.databinding.LarusDoraGOnboardingFragmentV2Binding;
import com.larus.dora.impl.onboarding.ext.AnimViewType;
import com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2;
import com.larus.utils.e1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s extends f {
    @Override // com.larus.dora.impl.onboarding.g.v2.f
    public final boolean f() {
        return true;
    }

    @Override // com.larus.dora.impl.onboarding.g.v2.f
    public final void b() {
        LarusDoraGOnboardingFragmentV2Binding r0 = this.b;
        if (r0 == null) goto L6;
        DoraGOnboardingFragmentUiStateV2Kt.h(r0);
        e1.x(r0.c);
        e1.x(r0.b);
        b69.w.k(r0.b, AnimViewType.AVATAR);
        AppCompatTextView r1 = r0.s;
        r1.setText(DoraGOnboardingFragmentUiStateV2Kt.c(2131902776));
        Intrinsics.checkNotNull(r1);
        b69.w.a(r1);
        DoraGOnboardingTopicView r2 = r0.u;
        Intrinsics.checkNotNull(r2);
        b69.w.a(r2);
        e1.x(r0.t);
        this.e = DoraGOnboardingFragmentUiStateV2Kt.e(this.a, this.b);
        return;
    }

    @Override // com.larus.dora.impl.onboarding.g.v2.f
    public final f d() {
        return new r(this.a, this.b, this.c);
    }

    @Override // com.larus.dora.impl.onboarding.g.v2.f
    public final f g() {
        Job r0 = this.e;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        DoraGOnboardingViewModelV2 r1 = this.c;
        if (r1 == null) goto L9;
        r1.exitVideoCall();
    L9:
        return new m(this.a, this.b, this.c);
    }

    public s(Fragment r2, LarusDoraGOnboardingFragmentV2Binding r3, DoraGOnboardingViewModelV2 r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2, r3, r4);
    }
}
