package com.larus.dora.impl.onboarding.g.v2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import com.larus.dora.impl.onboarding.DoraOnboardingBaseViewModel;
import com.larus.dora.impl.onboarding.g.v2.viewmodel.DoraGOnboardingViewModelV2;
import com.larus.dora.impl.onboarding.n0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraGOnboardingDelegateV2 implements n0 {
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
        return new DoraGOnboardingWelcomeStateFragment();
    }

    @Override // com.larus.dora.impl.onboarding.n0
    public final DoraOnboardingBaseViewModel f() {
        return (DoraGOnboardingViewModelV2) this.a.getValue();
    }

    public DoraGOnboardingDelegateV2(final AppCompatActivity r7) {
        Intrinsics.checkNotNullParameter(r7, "activity");
        Function0<ViewModelProvider.Factory> r0 = new DoraGOnboardingDelegateV2$special$$inlined$viewModels$default$1(r7);
        final Function0 r5 = null;
        this.a = new ViewModelLazy(Reflection.getOrCreateKotlinClass(DoraGOnboardingViewModelV2.class), new DoraGOnboardingDelegateV2$special$$inlined$viewModels$default$2(r7), r0, new DoraGOnboardingDelegateV2$special$$inlined$viewModels$default$3(r5, r7));
    }
}
