package com.larus.dora.impl.onboarding.othersmart.streamlined;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.dora.impl.databinding.LarusDoraHSimplifiedCompletionBinding;
import com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment;
import com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingBaseFragment;
import com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingViewModel;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.utils.e1;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0002J\b\u0010\u001b\u001a\u00020\u000fH\u0002J\b\u0010\u001c\u001a\u00020\u000fH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\rH\u0016J\b\u0010 \u001a\u00020\u000fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedCompletionFragment;", "Lcom/larus/dora/impl/onboarding/othersmart/DoraExternalOnboardingBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraHSimplifiedCompletionBinding;", "streamlinedModel", "Lcom/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedOnboardingViewModel;", "getStreamlinedModel", "()Lcom/larus/dora/impl/onboarding/othersmart/streamlined/DoraHStreamlinedOnboardingViewModel;", "streamlinedModel$delegate", "Lkotlin/Lazy;", "shouldSkipStopTTSOnDestroyView", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "setupVisualContent", "setupClickListeners", "jumpToDeviceManageExplorePage", "getCurrentPageName", "", "shouldShowSkipButton", "onDestroyView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraHStreamlinedCompletionFragment extends DoraExternalOnboardingBaseFragment {
    public static final /* synthetic */ int r = 0;
    public LarusDoraHSimplifiedCompletionBinding o;
    public final Lazy p;
    public boolean q;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingBaseFragment, com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final boolean ba0() {
        return false;
    }

    public final String k() {
        return "complete_guidance";
    }

    public final void onDestroyView() {
        if (this.q == true) goto L5;
        ((DoraHStreamlinedOnboardingViewModel) this.p.getValue()).stopTTS("completion onDestroyView");
    L5:
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L10;
        boolean r1 = true;
        if (r0.isChangingConfigurations() != true) goto L10;
    L11:
        if (r1 == true) goto L13;
        ((DoraHStreamlinedOnboardingViewModel) this.p.getValue()).releasePageEntryTTS("complete_guidance");
    L13:
        super.onDestroyView();
        this.o = null;
        return;
    L10:
        r1 = false;
        goto L11
    }

    public DoraHStreamlinedCompletionFragment() {
        this.p = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraHStreamlinedOnboardingViewModel.class), new DoraHStreamlinedCompletionFragment$special$$inlined$activityViewModels$default$1(this), new DoraHStreamlinedCompletionFragment$special$$inlined$activityViewModels$default$2(this));
    }

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        if (DoraOnboardingBaseFragment.Y90() == false) goto L6;
        ca0().exitOnboardingMode();
        return;
    }

    @Override // com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingBaseFragment, com.larus.dora.impl.onboarding.DoraOnboardingBaseFragment
    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        ItemGroup r10 = this.f;
        if (r10 == null) goto L5;
        e1.o(r10);
    L5:
        LarusDoraHSimplifiedCompletionBinding r11 = this.o;
        if (r11 == null) goto L10;
        SimpleDraweeView r12 = r11.b;
        if (r12 == null) goto L10;
        r12.post(new c(this));
    L10:
        TextView r13 = this.h;
        if (r13 == null) goto L13;
        e1.x(r13);
        r13.setText(2131903128);
        e1.d(r13, new com.larus.dora.impl.onboarding.othersmart.streamlined.a(this));
    L13:
        TextView r14 = this.k;
        if (r14 == null) goto L16;
        e1.x(r14);
        r14.setText(2131903130);
        e1.d(r14, new b(this));
    L16:
        DoraExternalOnboardingViewModel.playPageEntryTTSIfNeeded$default((DoraHStreamlinedOnboardingViewModel) this.p.getValue(), "complete_guidance", 2131903669, 0, 4, null);
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        ConstraintLayout r6 = r3.inflate(2131562206, r4, false);
        int r7 = 2131369871;
        SimpleDraweeView r8 = ViewBindings.findChildViewById(r6, 2131369871);
        if (r8 == null) goto L11;
        r7 = 2131369872;
        FrameLayout r0 = (FrameLayout) ViewBindings.findChildViewById(r6, 2131369872);
        if (r0 == null) goto L11;
        r7 = 2131369873;
        if (((DoraTextView) ViewBindings.findChildViewById(r6, 2131369873)) == null) goto L11;
        ConstraintLayout r9 = r6;
        this.o = new LarusDoraHSimplifiedCompletionBinding(r9, r8, r0);
        return r9;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
    }
}
