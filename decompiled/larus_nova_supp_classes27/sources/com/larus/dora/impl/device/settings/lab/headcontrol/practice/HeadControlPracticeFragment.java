package com.larus.dora.impl.device.settings.lab.headcontrol.practice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.common_ui.widget.roundlayout.RoundImageView;
import com.larus.dora.impl.databinding.LarusDoraPageHeadControlPracticeBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.device.settings.lab.headcontrol.HeadControlGestureType;
import com.larus.dora.impl.view.DoraTextView;
import g49.d;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\u000f\u0010\u001e\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020\u0015H\u0002J\u0017\u0010!\u001a\u0004\u0018\u00010\u00152\u0006\u0010\"\u001a\u00020#H\u0002¢\u0006\u0002\u0010$J\u0010\u0010%\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010&\u001a\u00020\u0015H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006("}, d2 = {"Lcom/larus/dora/impl/device/settings/lab/headcontrol/practice/HeadControlPracticeFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageHeadControlPracticeBinding;", "viewModel", "Lcom/larus/dora/impl/device/settings/lab/headcontrol/practice/HeadControlPracticeViewModel;", "getViewModel", "()Lcom/larus/dora/impl/device/settings/lab/headcontrol/practice/HeadControlPracticeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onStart", "onStop", "getCurrentPageName", "", "getPageMaskView", "setupTitle", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "bindActions", "()Lkotlin/Unit;", "observeState", "renderPracticeState", "practiceState", "Lcom/larus/dora/impl/device/settings/lab/headcontrol/HeadControlPracticeState;", "(Lcom/larus/dora/impl/device/settings/lab/headcontrol/HeadControlPracticeState;)Lkotlin/Unit;", "renderGestureIcon", "onDestroyView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HeadControlPracticeFragment extends DoraBaseFragment {
    public static final /* synthetic */ int h = 0;
    public LarusDoraPageHeadControlPracticeBinding f;
    public final Lazy g;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[HeadControlGestureType.values().length];
            r0[HeadControlGestureType.NOD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[HeadControlGestureType.SHAKE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public final String k() {
        return "head_control_practice";
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        LarusDoraPageHeadControlPracticeBinding r0 = this.f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b;
    }

    public final void onDestroyView() {
        LarusDoraPageHeadControlPracticeBinding r0 = this.f;
        if (r0 == null) goto L7;
        LottieAnimationView r1 = r0.g;
        if (r1 == null) goto L7;
        r1.cancelAnimation();
    L7:
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.f = null;
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void onStop() {
        d.d("HeadControlPractice", "stop head gesture detection");
        ((HeadControlPracticeViewModel) this.g.getValue()).stopHeadGestureDetection();
        super.onStop();
    }

    public HeadControlPracticeFragment() {
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(HeadControlPracticeViewModel.class), new HeadControlPracticeFragment$special$$inlined$activityViewModels$default$1(this), new HeadControlPracticeFragment$special$$inlined$activityViewModels$default$2(this));
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void onStart() {
        super.onStart();
        d.d("HeadControlPractice", "start head gesture detection");
        ((HeadControlPracticeViewModel) this.g.getValue()).startHeadGestureDetection();
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r8, r9);
        if (r9 != null) goto L5;
        ((HeadControlPracticeViewModel) this.g.getValue()).resetPractice();
    L5:
        LarusDoraPageHeadControlPracticeBinding r10 = this.f;
        if (r10 == null) goto L10;
        NovaTitleBarEx r0 = r10.i;
        if (r0 == null) goto L10;
        NovaTitleBarEx.Y5(r0, getString(2131902753), null, null, 6);
        NovaTitleBarEx.b6(r0, 2131240517, false, null, null, new com.larus.dora.impl.device.settings.lab.headcontrol.practice.a(this), 14);
    L10:
        LarusDoraPageHeadControlPracticeBinding r11 = this.f;
        if (r11 == null) goto L15;
        AppCompatTextView r12 = r11.c;
        if (r12 == null) goto L15;
        r12.setOnClickListener(new com.larus.dora.impl.device.settings.lab.headcontrol.practice.b(this));
        Unit r13 = Unit.INSTANCE;
    L15:
        Lifecycle.State r14 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new HeadControlPracticeFragment$observeState$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r14, null, this), 3, null);
    }

    public final View onCreateView(LayoutInflater r11, ViewGroup r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r11, "inflater");
        ConstraintLayout r14 = r11.inflate(2131562269, r12, false);
        int r15 = 2131369962;
        View r2 = ViewBindings.findChildViewById(r14, 2131369962);
        if (r2 == null) goto L23;
        r15 = 2131374219;
        DoraTextView r3 = (DoraTextView) ViewBindings.findChildViewById(r14, 2131374219);
        if (r3 == null) goto L23;
        r15 = 2131374223;
        if (((LinearLayout) ViewBindings.findChildViewById(r14, 2131374223)) == null) goto L23;
        r15 = 2131374224;
        FrameLayout r4 = (FrameLayout) ViewBindings.findChildViewById(r14, 2131374224);
        if (r4 == null) goto L23;
        r15 = 2131374225;
        DoraTextView r5 = (DoraTextView) ViewBindings.findChildViewById(r14, 2131374225);
        if (r5 == null) goto L23;
        r15 = 2131374226;
        RoundImageView r6 = (RoundImageView) ViewBindings.findChildViewById(r14, 2131374226);
        if (r6 == null) goto L23;
        r15 = 2131374227;
        LottieAnimationView r7 = ViewBindings.findChildViewById(r14, 2131374227);
        if (r7 == null) goto L23;
        r15 = 2131374228;
        DoraTextView r8 = (DoraTextView) ViewBindings.findChildViewById(r14, 2131374228);
        if (r8 == null) goto L23;
        r15 = 2131388772;
        NovaTitleBarEx r9 = ViewBindings.findChildViewById(r14, 2131388772);
        if (r9 == null) goto L23;
        ConstraintLayout r16 = r14;
        this.f = new LarusDoraPageHeadControlPracticeBinding(r16, r2, r3, r4, r5, r6, r7, r8, r9);
        return r16;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r15)));
    }
}
