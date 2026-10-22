package com.larus.dora.obric.onboarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelLazy;
import com.larus.dora.impl.onboarding.DoraOnboardingBaseViewModel;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class ObricDoraGOnboardingDelegateV2 implements com.larus.dora.impl.onboarding.n0 {
    public final ViewModelLazy a;

    @Override // com.larus.dora.impl.onboarding.n0
    public final int b() {
        return 2131103063;
    }

    @Override // com.larus.dora.impl.onboarding.n0
    public final int c() {
        return 2131562194;
    }

    @Override // com.larus.dora.impl.onboarding.n0
    public final boolean d() {
        return false;
    }

    @Override // com.larus.dora.impl.onboarding.n0
    public final boolean e() {
        return false;
    }

    @Override // com.larus.dora.impl.onboarding.n0
    public final void onStart() {
    }

    @Override // com.larus.dora.impl.onboarding.n0
    public final void onStop() {
    }

    @Override // com.larus.dora.impl.onboarding.n0
    public final Fragment a() {
        return new ObricDoraGOnboardingWelcomeStateFragment();
    }

    @Override // com.larus.dora.impl.onboarding.n0
    public final DoraOnboardingBaseViewModel f() {
        return (ObricDoraGOnboardingViewModelV2) this.a.getValue();
    }

    public ObricDoraGOnboardingDelegateV2(final AppCompatActivity r6, final boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "activity");
        Function0 r0 = new o(r7);
        final Function0 r4 = null;
        this.a = new ViewModelLazy(Reflection.getOrCreateKotlinClass(ObricDoraGOnboardingViewModelV2.class), new ObricDoraGOnboardingDelegateV2$special$$inlined$viewModels$default$2(r6), r0, new ObricDoraGOnboardingDelegateV2$special$$inlined$viewModels$default$3(r4, r6));
    }
}
