package com.larus.dora.impl.onboarding.othersmart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import com.larus.dora.impl.onboarding.DoraOnboardingBaseViewModel;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraExternalOnboardingDelegate implements com.larus.dora.impl.onboarding.n0 {
    public final ViewModelLazy a;

    @Override // com.larus.dora.impl.onboarding.n0
    public final int b() {
        return 2131102529;
    }

    @Override // com.larus.dora.impl.onboarding.n0
    public final int c() {
        return 2131562242;
    }

    @Override // com.larus.dora.impl.onboarding.n0
    public final boolean d() {
        return true;
    }

    @Override // com.larus.dora.impl.onboarding.n0
    public final boolean e() {
        return true;
    }

    @Override // com.larus.dora.impl.onboarding.n0
    public final Fragment a() {
        return new DoraExternalSmartOnboardingWelcomeFragment();
    }

    @Override // com.larus.dora.impl.onboarding.n0
    public final DoraOnboardingBaseViewModel f() {
        return (DoraExternalOnboardingViewModel) this.a.getValue();
    }

    @Override // com.larus.dora.impl.onboarding.n0
    public final void onStart() {
        ((DoraExternalOnboardingViewModel) this.a.getValue()).registerDoraCallback();
    }

    @Override // com.larus.dora.impl.onboarding.n0
    public final void onStop() {
        ((DoraExternalOnboardingViewModel) this.a.getValue()).unregisterDoraCallback();
    }

    public DoraExternalOnboardingDelegate(final AppCompatActivity r7) {
        Intrinsics.checkNotNullParameter(r7, "activity");
        Function0<ViewModelProvider.Factory> r0 = new DoraExternalOnboardingDelegate$special$$inlined$viewModels$default$1(r7);
        final Function0 r5 = null;
        this.a = new ViewModelLazy(Reflection.getOrCreateKotlinClass(DoraExternalOnboardingViewModel.class), new DoraExternalOnboardingDelegate$special$$inlined$viewModels$default$2(r7), r0, new DoraExternalOnboardingDelegate$special$$inlined$viewModels$default$3(r5, r7));
    }
}
