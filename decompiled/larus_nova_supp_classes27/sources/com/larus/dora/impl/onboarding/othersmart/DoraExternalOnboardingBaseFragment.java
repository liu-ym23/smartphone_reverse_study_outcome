package com.larus.dora.impl.onboarding.othersmart;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment;
import com.larus.dora.impl.onboarding.othersmart.archive.DoraExternalOnboardingKeepAliveFragmentOld;
import com.larus.dora.impl.onboarding.othersmart.streamlined.DoraHStreamlinedCompletionFragment;
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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0004J \u0010\u0019\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0004J(\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0004J\u0006\u0010\u001f\u001a\u00020\rJ\b\u0010 \u001a\u00020\u0014H\u0004J\b\u0010!\u001a\u00020\rH\u0004J\u0012\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u0014H\u0004J\u0012\u0010%\u001a\u00020\r2\b\b\u0002\u0010$\u001a\u00020\u0014H\u0004R\u001b\u0010\u0004\u001a\u00020\u00058DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/larus/dora/impl/onboarding/othersmart/DoraExternalOnboardingBaseFragment;", "Lcom/larus/dora/impl/onboarding/DoraOnboardingBaseFragment;", "<init>", "()V", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/onboarding/othersmart/DoraExternalOnboardingViewModel;", "getModel", "()Lcom/larus/dora/impl/onboarding/othersmart/DoraExternalOnboardingViewModel;", "model$delegate", "Lkotlin/Lazy;", "goNextJob", "Lkotlinx/coroutines/Job;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onSkipButtonClicked", "shouldShowSkipButton", "", "next", "fragment", "Landroidx/fragment/app/Fragment;", "navigateToFragment", "nextWithSharedElement", "sharedElementView", "transitionName", "", "nextWithSharedElementOverlay", "fragmentTag", "gotoOnboardingKeepAlivePage", "shouldSkipNotificationGuideForObric", "goDeviceManagementPage", "getContinueButtonBackgroundRes", "", "clickable", "applyContinueButtonBackgroundIfNeeded", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class DoraExternalOnboardingBaseFragment extends DoraOnboardingBaseFragment {
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

    public final DoraExternalOnboardingViewModel ca0() {
        return (DoraExternalOnboardingViewModel) this.m.getValue();
    }

    public final void da0() {
        IFlowSdkDepend r0 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r0 == null) goto L13;
        com.larus.home.impl.sdk.s r1 = r0.s0();
        if (r1 == null) goto L13;
        Context r2 = getActivity();
        if (r2 != null) goto L12;
        r2 = getContext();
        if (r2 != null) goto L12;
        r2 = AppHost.a.getApplication();
    L12:
        r1.M(r2, null);
    L13:
        FragmentActivity r3 = getActivity();
        if (r3 == null) goto L17;
        r3.finish();
        return;
    }

    public DoraExternalOnboardingBaseFragment() {
        this.m = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraExternalOnboardingViewModel.class), new DoraExternalOnboardingBaseFragment$special$$inlined$activityViewModels$default$1(this), new DoraExternalOnboardingBaseFragment$special$$inlined$activityViewModels$default$2(this));
    }

    public final void ea0() {
        if (DoraOnboardingBaseFragment.Y90() == true) goto L5;
    L10:
        DoraSetting.a.getClass();
        if (DoraSetting.h() == false) goto L13;
        Fragment r0 = new DoraExternalOnboardingKeepAliveFragment();
    L14:
        Z90(r0);
        return;
    L13:
        r0 = new DoraExternalOnboardingKeepAliveFragmentOld();
        goto L14
    L5:
        if (DoraOnboardingBaseFragment.X90() == true) goto L10;
        DoraSetting.a.getClass();
        if (DoraSetting.m() == false) goto L9;
        Z90(new DoraHStreamlinedCompletionFragment());
        return;
    L9:
        da0();
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public void aa0() {
        ea0();
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final void Z90(Fragment r10) {
        Intrinsics.checkNotNullParameter(r10, "fragment");
        Intrinsics.checkNotNullParameter(r10, "fragment");
        if (isAdded() == true) goto L5;
    L11:
        g49.d.e("DoraExternalOnboardingBaseFragment", "current fragment is not added or statedSaved, cannot navigate to next fragment");
        return;
    L5:
        if (isStateSaved() == true) goto L11;
        Job r0 = this.n;
        if (r0 == null) goto L10;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L10:
        this.n = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new DoraExternalOnboardingBaseFragment$navigateToFragment$1(this, r10, null), 2, null);
    }

    @Override // com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        TextView r4 = this.h;
        if (r4 == null) goto L6;
        r4.setBackgroundResource(2131240628);
        return;
    }
}
