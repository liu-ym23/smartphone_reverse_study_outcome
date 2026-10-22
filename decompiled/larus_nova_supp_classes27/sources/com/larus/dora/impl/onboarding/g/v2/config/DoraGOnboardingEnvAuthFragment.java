package com.larus.dora.impl.onboarding.g.v2.config;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.dora.impl.databinding.LarusDoraGEnvObserveAuthBinding;
import com.larus.dora.impl.databinding.LarusDoraGOnboardingBottomBtnLayoutBinding;
import com.larus.dora.impl.device.settings.lab.env.auth.EnvAuthViewModel;
import com.larus.utils.e1;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowCollector;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/larus/dora/impl/onboarding/g/v2/config/DoraGOnboardingEnvAuthFragment;", "Lcom/larus/dora/impl/onboarding/g/v2/config/DoraGOnboardingBaseNoSkipFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraGEnvObserveAuthBinding;", "envAuthModel", "Lcom/larus/dora/impl/device/settings/lab/env/auth/EnvAuthViewModel;", "getEnvAuthModel", "()Lcom/larus/dora/impl/device/settings/lab/env/auth/EnvAuthViewModel;", "envAuthModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onWearState", "", "state", "", "onViewCreated", "view", "getCurrentPageName", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraGOnboardingEnvAuthFragment extends DoraGOnboardingBaseNoSkipFragment {
    public static final /* synthetic */ int u = 0;
    public LarusDoraGEnvObserveAuthBinding s;
    public final Lazy t;

    public static final class a {
    }

    public static final class b<T> implements FlowCollector {
        public final /* synthetic */ DoraGOnboardingEnvAuthFragment a;

        public b(DoraGOnboardingEnvAuthFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r3, Continuation r4) {
            com.larus.dora.impl.device.settings.lab.env.auth.c r5 = (com.larus.dora.impl.device.settings.lab.env.auth.c) r3;
            if (Intrinsics.areEqual(r5, com.larus.dora.impl.device.settings.lab.env.auth.c.b.a) == true) goto L13;
            if ((r5 instanceof com.larus.dora.impl.device.settings.lab.env.auth.c.a) == false) goto L11;
            if (((com.larus.dora.impl.device.settings.lab.env.auth.c.a) r5).a == true) goto L9;
            s r6 = s.a;
            Context r7 = this.a.getContext();
            String r0 = this.a.getString(2131903992);
            r6.getClass();
            s.c(r7, r0);
            return Unit.INSTANCE;
        L9:
            this.a.ja0();
            goto L13
        L11:
            throw new NoWhenBranchMatchedException();
        L13:
            return Unit.INSTANCE;
        }
    }

    static {
    }

    @Override // com.larus.dora.impl.onboarding.g.v2.config.DoraGOnboardingBaseNoSkipFragment, e69.a
    public final void bO(boolean r1) {
    }

    public final String k() {
        return "privacy_environmental_memory";
    }

    public DoraGOnboardingEnvAuthFragment() {
        final Function0<Fragment> r0 = new DoraGOnboardingEnvAuthFragment$special$$inlined$viewModels$default$1(this);
        this.t = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(EnvAuthViewModel.class), new DoraGOnboardingEnvAuthFragment$special$$inlined$viewModels$default$2(r0), new DoraGOnboardingEnvAuthFragment$special$$inlined$viewModels$default$3(r0, this));
    }

    @Override // com.larus.dora.impl.onboarding.g.v2.config.DoraGOnboardingBaseNoSkipFragment, com.larus.dora.impl.onboarding.g.v2.base.DoraGOnboardingBaseFragmentV2, com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super.onViewCreated(r7, r8);
        LarusDoraGEnvObserveAuthBinding r9 = this.s;
        if (r9 == null) goto L5;
        e1.o(r9.b);
        LarusDoraGOnboardingBottomBtnLayoutBinding r10 = r9.e;
        e1.x(r10.c);
        e1.o(r10.f);
        e1.x(r10.e);
        e1.d(r10.b, new com.larus.dora.impl.onboarding.g.v2.config.a(this));
        e1.d(r10.d, new com.larus.dora.impl.onboarding.g.v2.config.b(this));
    L5:
        Lifecycle.State r11 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraGOnboardingEnvAuthFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r11, null, this), 3, null);
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        LarusDoraGEnvObserveAuthBinding r4 = LarusDoraGEnvObserveAuthBinding.a(r1, r2);
        this.s = r4;
        return r4.a;
    }
}
