package com.larus.dora.impl.device.settings.lab.headcontrol.settings;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.dora.impl.databinding.LarusDoraPageHeadControlSettingsBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.device.settings.lab.headcontrol.HeadControlGestureType;
import com.larus.utils.e1;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u000f\u0010\u001f\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\u0017H\u0002J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\rH\u0002J\b\u0010'\u001a\u00020\u0017H\u0002J\b\u0010(\u001a\u00020\u0017H\u0002J\b\u0010)\u001a\u00020\u0017H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/larus/dora/impl/device/settings/lab/headcontrol/settings/HeadControlSettingsFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageHeadControlSettingsBinding;", "viewModel", "Lcom/larus/dora/impl/device/settings/lab/headcontrol/settings/HeadControlSettingsViewModel;", "getViewModel", "()Lcom/larus/dora/impl/device/settings/lab/headcontrol/settings/HeadControlSettingsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "isSyncingBehaviorAware", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "getCurrentPageName", "", "getPageMaskView", "setupTitle", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "bindActions", "()Lkotlin/Unit;", "observeState", "openOptionPage", "type", "Lcom/larus/dora/impl/device/settings/lab/headcontrol/HeadControlGestureType;", "renderBehaviorAwareBanner", "show", "showBehaviorAwareEnableDialog", "syncBehaviorAwareThenRefresh", "onDestroyView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HeadControlSettingsFragment extends DoraBaseFragment {
    public static final int i = 0;
    public LarusDoraPageHeadControlSettingsBinding f;
    public final Lazy g;
    public boolean h;

    public static final class a {
    }

    public final String k() {
        return "head_control_settings";
    }

    static {
        i = Color.rgb(152, 102, 65);
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        LarusDoraPageHeadControlSettingsBinding r0 = this.f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b;
    }

    public final HeadControlSettingsViewModel W90() {
        return (HeadControlSettingsViewModel) this.g.getValue();
    }

    public HeadControlSettingsFragment() {
        final Function0<Fragment> r0 = new HeadControlSettingsFragment$special$$inlined$viewModels$default$1(this);
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(HeadControlSettingsViewModel.class), new HeadControlSettingsFragment$special$$inlined$viewModels$default$2(r0), new HeadControlSettingsFragment$special$$inlined$viewModels$default$3(r0, this));
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.f = null;
    }

    public final void onResume() {
        super.onResume();
        W90().refreshBehaviorAwareBannerState();
    }

    public final void X90(HeadControlGestureType r4) {
        g49.d.d("HeadControlSettings", "open option page, type=" + r4);
        com.bytedance.router.i r0 = SmartRouter.buildRoute(getContext(), "//flow/dora/lab_head_control_option");
        Bundle r1 = com.larus.utils.f.c(new Pair[0]);
        by7.h.k(r1, this);
        r0.c.putExtras(r1);
        r0.c.putExtra("arg_gesture_type", r4.name());
        r0.d = 2130772401;
        r0.e = 2130772399;
        r0.d();
    }

    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r10, r11);
        LarusDoraPageHeadControlSettingsBinding r12 = this.f;
        if (r12 == null) goto L7;
        NovaTitleBarEx r0 = r12.i;
        if (r0 == null) goto L7;
        NovaTitleBarEx.Y5(r0, getString(2131902753), null, null, 6);
        NovaTitleBarEx.b6(r0, 2131240517, false, null, null, new com.larus.dora.impl.device.settings.lab.headcontrol.settings.a(this), 14);
    L7:
        LarusDoraPageHeadControlSettingsBinding r13 = this.f;
        if (r13 == null) goto L10;
        e1.d(r13.f, new b(this));
        e1.d(r13.h, new c(this));
        r13.g.setTextColor(v19.c.a(2130972123, r13.a.getContext(), 2131103203));
        e1.d(r13.g, new d(this));
        Unit r14 = Unit.INSTANCE;
    L10:
        Lifecycle.State r15 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new HeadControlSettingsFragment$observeState$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r15, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new HeadControlSettingsFragment$observeState$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r15, null, this), 3, null);
        W90().loadHeadGestureOptions();
    }

    public final View onCreateView(LayoutInflater r11, ViewGroup r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r11, "inflater");
        ConstraintLayout r14 = r11.inflate(2131562270, r12, false);
        int r15 = 2131369962;
        View r2 = ViewBindings.findChildViewById(r14, 2131369962);
        if (r2 == null) goto L21;
        r15 = 2131374220;
        ConstraintLayout r3 = ViewBindings.findChildViewById(r14, 2131374220);
        if (r3 == null) goto L21;
        r15 = 2131374221;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r14, 2131374221);
        if (r4 == null) goto L21;
        r15 = 2131374222;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r14, 2131374222);
        if (r5 == null) goto L21;
        r15 = 2131374229;
        ItemTextArrow r6 = ViewBindings.findChildViewById(r14, 2131374229);
        if (r6 == null) goto L21;
        r15 = 2131374232;
        ItemTextArrow r7 = ViewBindings.findChildViewById(r14, 2131374232);
        if (r7 == null) goto L21;
        r15 = 2131374234;
        ItemTextArrow r8 = ViewBindings.findChildViewById(r14, 2131374234);
        if (r8 == null) goto L21;
        r15 = 2131388772;
        NovaTitleBarEx r9 = ViewBindings.findChildViewById(r14, 2131388772);
        if (r9 == null) goto L21;
        ConstraintLayout r16 = r14;
        this.f = new LarusDoraPageHeadControlSettingsBinding(r16, r2, r3, r4, r5, r6, r7, r8, r9);
        return r16;
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r15)));
    }
}
