package com.larus.dora.impl.device.settings.lab.headdown;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.widget.roundlayout.RoundImageView;
import com.larus.dora.impl.databinding.LarusDoraPageHeadDownDetectionBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.view.DoraTextView;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 62\u00020\u0001:\u00016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u000fH\u0016J\u000f\u0010\u001c\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u0017H\u0002J\u000f\u0010\u001f\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0002\u0010\u001dJ\b\u0010 \u001a\u00020\u0017H\u0002J\b\u0010!\u001a\u00020\u0017H\u0002J\u0017\u0010\"\u001a\u0004\u0018\u00010\u00172\u0006\u0010#\u001a\u00020$H\u0002¢\u0006\u0002\u0010%J\b\u0010&\u001a\u00020\u0017H\u0002J\u0018\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*H\u0002J\u0018\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020*2\u0006\u0010.\u001a\u00020*H\u0002J\b\u0010/\u001a\u00020\u0017H\u0002J\b\u00100\u001a\u00020\u0017H\u0002J\u0010\u00101\u001a\u00020*2\u0006\u00102\u001a\u00020*H\u0002J\u0012\u00103\u001a\u0004\u0018\u0001042\u0006\u0010#\u001a\u00020$H\u0002J\b\u00105\u001a\u00020\u0017H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u00067"}, d2 = {"Lcom/larus/dora/impl/device/settings/lab/headdown/HeadDownDetectionFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageHeadDownDetectionBinding;", "needWearDialog", "Lcom/larus/common_ui/dialog/CommonDialog;", "viewModel", "Lcom/larus/dora/impl/device/settings/lab/headdown/HeadDownDetectionViewModel;", "getViewModel", "()Lcom/larus/dora/impl/device/settings/lab/headdown/HeadDownDetectionViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "getCurrentPageName", "", "getPageMaskView", "setupTitle", "()Lkotlin/Unit;", "bindBackPressed", "bindActions", "observeState", "observeEffects", "renderState", "state", "Lcom/larus/dora/impl/device/settings/lab/headdown/HeadDownDetectionUiState;", "(Lcom/larus/dora/impl/device/settings/lab/headdown/HeadDownDetectionUiState;)Lkotlin/Unit;", "showNeedWearDialog", "buildHighlightedDescText", "", "descResId", "", "highlightResId", "updateVisualContainerSize", "widthRes", "heightRes", "showRunningAnimationIfNeeded", "hideRunningAnimation", "getColorCompat", "colorRes", "renderTitle", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "onDestroyView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HeadDownDetectionFragment extends DoraBaseFragment {
    public static final /* synthetic */ int i = 0;
    public LarusDoraPageHeadDownDetectionBinding f;
    public CommonDialog g;
    public final Lazy h;

    public static final class a {
    }

    static {
    }

    public final String k() {
        return "head_down_detection";
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        LarusDoraPageHeadDownDetectionBinding r0 = this.f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b;
    }

    public final HeadDownDetectionViewModel X90() {
        return (HeadDownDetectionViewModel) this.h.getValue();
    }

    public final void Y90() {
        LarusDoraPageHeadDownDetectionBinding r0 = this.f;
        if (r0 == null) goto L7;
        LottieAnimationView r1 = r0.k;
        if (r1 == null) goto L7;
        r1.cancelAnimation();
        r1.setVisibility(8);
    L7:
        LarusDoraPageHeadDownDetectionBinding r2 = this.f;
        if (r2 == null) goto L13;
        ImageView r3 = r2.j;
        if (r3 == null) goto L14;
        r3.setVisibility(8);
        return;
    L14:
        return;
    }

    public HeadDownDetectionFragment() {
        final Function0<Fragment> r0 = new HeadDownDetectionFragment$special$$inlined$viewModels$default$1(this);
        this.h = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(HeadDownDetectionViewModel.class), new HeadDownDetectionFragment$special$$inlined$viewModels$default$2(r0), new HeadDownDetectionFragment$special$$inlined$viewModels$default$3(r0, this));
    }

    public final void onDestroyView() {
        Y90();
        CommonDialog r0 = this.g;
        if (r0 != null) goto L12;
    L10:
        this.g = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.f = null;
        return;
    L12:
        r0.dismissAllowingStateLoss();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r1 = DialogFragmentLancet.sLastShowStack;
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L10
    }

    public final CharSequence W90(int r7, int r8) {
        String r9 = getString(r7);
        String r10 = getString(r8);
        int r0 = StringsKt.indexOf$default(r9, r10, 0, false, 6, null);
        if (r0 >= 0) goto L5;
        return r9;
    L5:
        SpannableString r1 = new SpannableString(r9);
        r1.setSpan(new ForegroundColorSpan(ContextCompat.getColor(requireContext(), 2131103136)), r0, r10.length() + r0, 33);
        return r1;
    }

    public final void Z90(int r4, int r5) {
        LarusDoraPageHeadDownDetectionBinding r0 = this.f;
        if (r0 == null) goto L14;
        FrameLayout r1 = r0.n;
        if (r1 == null) goto L15;
        if (r0 == null) goto L11;
        if (r1 == null) goto L11;
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if (r2 == null) goto L11;
        r2.width = getResources().getDimensionPixelSize(r4);
        r2.height = getResources().getDimensionPixelSize(r5);
    L12:
        r1.setLayoutParams(r2);
        return;
    L11:
        r2 = null;
        goto L12
    L15:
        return;
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r8, r9);
        if (r9 != null) goto L5;
        X90().resetFlow();
    L5:
        X90().startIfNeeded();
        LarusDoraPageHeadDownDetectionBinding r10 = this.f;
        if (r10 == null) goto L10;
        NovaTitleBarEx r11 = r10.o;
        if (r11 == null) goto L10;
        NovaTitleBarEx.Y5(r11, getString(2131902761), null, null, 6);
        Unit r12 = Unit.INSTANCE;
    L10:
        OnBackPressedDispatcherKt.addCallback$default(requireActivity().getOnBackPressedDispatcher(), getViewLifecycleOwner(), false, new c(this), 2, null);
        LarusDoraPageHeadDownDetectionBinding r13 = this.f;
        if (r13 == null) goto L13;
        r13.c.setOnClickListener(new d(this));
        Unit r14 = Unit.INSTANCE;
    L13:
        Lifecycle.State r15 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new HeadDownDetectionFragment$observeState$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r15, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new HeadDownDetectionFragment$observeEffects$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r15, null, this), 3, null);
    }

    public final View onCreateView(LayoutInflater r110, ViewGroup r20, Bundle r21) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        ConstraintLayout r0 = r110.inflate(2131562271, r20, false);
        int r1 = 2131369962;
        View r4 = ViewBindings.findChildViewById(r0, 2131369962);
        if (r4 == null) goto L35;
        r1 = 2131374235;
        DoraTextView r5 = (DoraTextView) ViewBindings.findChildViewById(r0, 2131374235);
        if (r5 == null) goto L35;
        r1 = 2131374236;
        HeadDownCircularProgressView r6 = (HeadDownCircularProgressView) ViewBindings.findChildViewById(r0, 2131374236);
        if (r6 == null) goto L35;
        r1 = 2131374237;
        if (((LinearLayout) ViewBindings.findChildViewById(r0, 2131374237)) == null) goto L35;
        r1 = 2131374238;
        DoraTextView r7 = (DoraTextView) ViewBindings.findChildViewById(r0, 2131374238);
        if (r7 == null) goto L35;
        r1 = 2131374239;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131374239);
        if (r8 == null) goto L35;
        r1 = 2131374240;
        DoraTextView r9 = (DoraTextView) ViewBindings.findChildViewById(r0, 2131374240);
        if (r9 == null) goto L35;
        r1 = 2131374241;
        DoraTextView r10 = (DoraTextView) ViewBindings.findChildViewById(r0, 2131374241);
        if (r10 == null) goto L35;
        r1 = 2131374242;
        RoundImageView r11 = (RoundImageView) ViewBindings.findChildViewById(r0, 2131374242);
        if (r11 == null) goto L35;
        r1 = 2131374243;
        ImageView r12 = (ImageView) ViewBindings.findChildViewById(r0, 2131374243);
        if (r12 == null) goto L35;
        r1 = 2131374244;
        LottieAnimationView r13 = ViewBindings.findChildViewById(r0, 2131374244);
        if (r13 == null) goto L35;
        r1 = 2131374245;
        ImageView r14 = (ImageView) ViewBindings.findChildViewById(r0, 2131374245);
        if (r14 == null) goto L35;
        r1 = 2131374246;
        DoraTextView r15 = (DoraTextView) ViewBindings.findChildViewById(r0, 2131374246);
        if (r15 == null) goto L35;
        r1 = 2131374247;
        FrameLayout r16 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131374247);
        if (r16 == null) goto L35;
        r1 = 2131388772;
        NovaTitleBarEx r17 = ViewBindings.findChildViewById(r0, 2131388772);
        if (r17 == null) goto L35;
        ConstraintLayout r2 = r0;
        this.f = new LarusDoraPageHeadDownDetectionBinding(r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
        return r2;
    L35:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }
}
