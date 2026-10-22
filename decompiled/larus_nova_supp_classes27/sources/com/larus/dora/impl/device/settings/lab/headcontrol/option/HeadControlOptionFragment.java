package com.larus.dora.impl.device.settings.lab.headcontrol.option;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemTextSelector;
import com.larus.dora.impl.databinding.LarusDoraPageHeadControlOptionBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.device.settings.lab.headcontrol.HeadControlActionOption;
import com.larus.dora.impl.device.settings.lab.headcontrol.HeadControlGestureType;
import com.larus.utils.e1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u0012H\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\u000f\u0010!\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0002\u0010\"J\u0014\u0010#\u001a\u00020\u001a*\u00020\u00122\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020\u001aH\u0002J\u0010\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020%H\u0002J\b\u0010)\u001a\u00020\u001aH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f¨\u0006+"}, d2 = {"Lcom/larus/dora/impl/device/settings/lab/headcontrol/option/HeadControlOptionFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageHeadControlOptionBinding;", "viewModel", "Lcom/larus/dora/impl/device/settings/lab/headcontrol/option/HeadControlOptionViewModel;", "getViewModel", "()Lcom/larus/dora/impl/device/settings/lab/headcontrol/option/HeadControlOptionViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "gestureType", "Lcom/larus/dora/impl/device/settings/lab/headcontrol/HeadControlGestureType;", "getGestureType", "()Lcom/larus/dora/impl/device/settings/lab/headcontrol/HeadControlGestureType;", "gestureType$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "getCurrentPageName", "", "getPageMaskView", "setupTitle", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "bindOptions", "()Lkotlin/Unit;", "bindOption", "option", "Lcom/larus/dora/impl/device/settings/lab/headcontrol/HeadControlActionOption;", "observeState", "updateSelection", "selectedOption", "onDestroyView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HeadControlOptionFragment extends DoraBaseFragment {
    public static final /* synthetic */ int i = 0;
    public LarusDoraPageHeadControlOptionBinding f;
    public final Lazy g;
    public final Lazy h;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        LarusDoraPageHeadControlOptionBinding r0 = this.f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b;
    }

    public final String k() {
        if (((HeadControlGestureType) this.h.getValue()) != HeadControlGestureType.NOD) goto L5;
        return "head_control_nod_option";
    L5:
        return "head_control_shake_option";
    }

    public HeadControlOptionFragment() {
        final Function0<Fragment> r0 = new HeadControlOptionFragment$special$$inlined$viewModels$default$1(this);
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(HeadControlOptionViewModel.class), new HeadControlOptionFragment$special$$inlined$viewModels$default$2(r0), new HeadControlOptionFragment$special$$inlined$viewModels$default$3(r0, this));
        this.h = LazyKt.lazy(LazyThreadSafetyMode.NONE, new com.larus.dora.impl.device.settings.lab.headcontrol.option.a(this));
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        this.f = null;
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r8, r9);
        LarusDoraPageHeadControlOptionBinding r10 = this.f;
        if (r10 == null) goto L7;
        NovaTitleBarEx r0 = r10.f;
        if (r0 == null) goto L7;
        NovaTitleBarEx.Y5(r0, ((HeadControlGestureType) this.h.getValue()).getTitle(), null, null, 6);
        NovaTitleBarEx.b6(r0, 2131240517, false, null, null, new b(this), 14);
    L7:
        LarusDoraPageHeadControlOptionBinding r11 = this.f;
        if (r11 == null) goto L10;
        ItemTextSelector r1 = r11.c;
        final HeadControlActionOption r2 = HeadControlActionOption.ACCEPT_CONFIRM;
        r1.setText(r2.getTitle());
        ItemTextSelector r3 = r11.e;
        final HeadControlActionOption r4 = HeadControlActionOption.REJECT_CLOSE;
        r3.setText(r4.getTitle());
        ItemTextSelector r5 = r11.d;
        final HeadControlActionOption r6 = HeadControlActionOption.NONE;
        r5.setText(r6.getTitle());
        e1.d(r11.c, new c(this, r2));
        e1.d(r11.e, new c(this, r4));
        e1.d(r11.d, new c(this, r6));
        Unit r12 = Unit.INSTANCE;
    L10:
        Lifecycle.State r13 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new HeadControlOptionFragment$observeState$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r13, null, this), 3, null);
        ((HeadControlOptionViewModel) this.g.getValue()).loadHeadGestureOptions();
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        ConstraintLayout r11 = r8.inflate(2131562268, r9, false);
        int r12 = 2131369962;
        View r2 = ViewBindings.findChildViewById(r11, 2131369962);
        if (r2 == null) goto L19;
        r12 = 2131374218;
        ItemTextSelector r3 = ViewBindings.findChildViewById(r11, 2131374218);
        if (r3 == null) goto L19;
        r12 = 2131374230;
        ItemTextSelector r4 = ViewBindings.findChildViewById(r11, 2131374230);
        if (r4 == null) goto L19;
        r12 = 2131374231;
        if (ViewBindings.findChildViewById(r11, 2131374231) == null) goto L19;
        r12 = 2131374233;
        ItemTextSelector r5 = ViewBindings.findChildViewById(r11, 2131374233);
        if (r5 == null) goto L19;
        r12 = 2131385238;
        if (((ScrollView) ViewBindings.findChildViewById(r11, 2131385238)) == null) goto L19;
        r12 = 2131388772;
        NovaTitleBarEx r6 = ViewBindings.findChildViewById(r11, 2131388772);
        if (r6 == null) goto L19;
        ConstraintLayout r13 = r11;
        this.f = new LarusDoraPageHeadControlOptionBinding(r13, r2, r3, r4, r5, r6);
        return r13;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }
}
