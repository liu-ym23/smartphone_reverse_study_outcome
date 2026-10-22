package com.larus.dora.impl.onboarding.lite;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment;
import com.larus.dora.impl.onboarding.lite.archive.DoraLiteOnboardingKeepAliveFragmentOld;
import com.larus.dora.impl.settings.DoraSetting;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0006\u0010\u0013\u001a\u00020\rR\u001b\u0010\u0004\u001a\u00020\u00058DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/dora/impl/onboarding/lite/DoraLiteOnboardingBaseFragment;", "Lcom/larus/dora/impl/onboarding/DoraOnboardingBaseFragment;", "<init>", "()V", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/onboarding/lite/DoraLiteOnboardingViewModel;", "getModel", "()Lcom/larus/dora/impl/onboarding/lite/DoraLiteOnboardingViewModel;", "model$delegate", "Lkotlin/Lazy;", "goNextJob", "Lkotlinx/coroutines/Job;", "onSkipButtonClicked", "", "shouldShowSkipButton", "", "next", "fragment", "Landroidx/fragment/app/Fragment;", "gotoOnboardingKeepAlivePage", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class DoraLiteOnboardingBaseFragment extends DoraOnboardingBaseFragment {
    public final Lazy m;
    public Job n;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public boolean ba0() {
        DoraSetting.a.getClass();
        if (DoraSetting.h() == true) goto L5;
    L8:
        return true;
    L5:
        if (ca0().isOnboardingNoSkip() == false) goto L8;
        return false;
    }

    public final DoraLiteOnboardingViewModel ca0() {
        return (DoraLiteOnboardingViewModel) this.m.getValue();
    }

    public DoraLiteOnboardingBaseFragment() {
        this.m = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraLiteOnboardingViewModel.class), new DoraLiteOnboardingBaseFragment$special$$inlined$activityViewModels$default$1(this), new DoraLiteOnboardingBaseFragment$special$$inlined$activityViewModels$default$2(this));
    }

    public final void da0() {
        if (DoraOnboardingBaseFragment.Y90() == true) goto L5;
    L20:
        DoraSetting.a.getClass();
        if (DoraSetting.h() == false) goto L23;
        Fragment r0 = new DoraLiteOnboardingKeepAliveFragment();
    L24:
        Z90(r0);
        return;
    L23:
        r0 = new DoraLiteOnboardingKeepAliveFragmentOld();
        goto L24
    L5:
        if (DoraOnboardingBaseFragment.X90() == true) goto L20;
        IFlowSdkDepend r1 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r1 == null) goto L17;
        com.larus.home.impl.sdk.s r2 = r1.s0();
        if (r2 == null) goto L17;
        Context r3 = getActivity();
        if (r3 != null) goto L16;
        r3 = getContext();
        if (r3 != null) goto L16;
        r3 = AppHost.a.getApplication();
    L16:
        r2.M(r3, null);
    L17:
        FragmentActivity r4 = getActivity();
        if (r4 == null) goto L26;
        r4.finish();
        return;
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public void aa0() {
        da0();
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final void Z90(Fragment r10) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        if (isAdded() == true) goto L5;
    L12:
        g49.d.e("DoraLiteOnboardingBaseFragment", "current fragment is not added or statedSaved, cannot navigate to next fragment");
        return;
    L5:
        if (isStateSaved() == true) goto L12;
        Job r0 = this.n;
        if (r0 == null) goto L10;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L10:
        this.n = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new DoraLiteOnboardingBaseFragment$next$1(this, r10, null), 2, null);
    }
}
