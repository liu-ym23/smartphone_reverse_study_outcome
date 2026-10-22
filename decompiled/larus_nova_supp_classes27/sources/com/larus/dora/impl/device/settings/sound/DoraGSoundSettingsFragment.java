package com.larus.dora.impl.device.settings.sound;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.dora.impl.databinding.LarusDoragPageSoundSettingsBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u0017H\u0002J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/larus/dora/impl/device/settings/sound/DoraGSoundSettingsFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoragPageSoundSettingsBinding;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/device/settings/sound/DoraGSoundSettingsViewModel;", "getModel", "()Lcom/larus/dora/impl/device/settings/sound/DoraGSoundSettingsViewModel;", "model$delegate", "Lkotlin/Lazy;", "checkedChangeListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "getCurrentPageName", "", "getPageMaskView", "setupTitle", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "setupAntiSoundLeak", "refreshAntiSoundLeakCheckedState", "state", "Lcom/larus/dora/impl/device/settings/sound/AntiSoundLeakState;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraGSoundSettingsFragment extends DoraBaseFragment {
    public static final /* synthetic */ int i = 0;
    public LarusDoragPageSoundSettingsBinding f;
    public final Lazy g;
    public final c h;

    public static final class a {
    }

    static {
    }

    public final String k() {
        return "g_sound_setting";
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        LarusDoragPageSoundSettingsBinding r0 = this.f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.dora.impl.device.settings.sound.c] */
    public DoraGSoundSettingsFragment() {
        final Function0<Fragment> r0 = new DoraGSoundSettingsFragment$special$$inlined$viewModels$default$1(this);
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraGSoundSettingsViewModel.class), new DoraGSoundSettingsFragment$special$$inlined$viewModels$default$2(r0), new DoraGSoundSettingsFragment$special$$inlined$viewModels$default$3(r0, this));
        this.h = new c(this);
    }

    public static final void W90(DoraGSoundSettingsFragment r2, com.larus.dora.impl.device.settings.sound.a r3) {
        LarusDoragPageSoundSettingsBinding r0 = r2.f;
        if (r0 == null) goto L9;
        ItemTextToggle r1 = r0.c;
        if (r1 == null) goto L9;
        CustomSwitchCompat r4 = r1.getToggleView();
        if (r4 == null) goto L9;
        r4.setOnCheckedChangeListener(null);
    L9:
        LarusDoragPageSoundSettingsBinding r5 = r2.f;
        if (r5 == null) goto L16;
        ItemTextToggle r6 = r5.c;
        if (r6 == null) goto L16;
        CustomSwitchCompat r7 = r6.getToggleView();
        if (r7 == null) goto L16;
        r7.setChecked(Intrinsics.areEqual(r3, com.larus.dora.impl.device.settings.sound.a.b.a));
    L16:
        LarusDoragPageSoundSettingsBinding r8 = r2.f;
        if (r8 == null) goto L24;
        ItemTextToggle r9 = r8.c;
        if (r9 == null) goto L25;
        CustomSwitchCompat r10 = r9.getToggleView();
        if (r10 == null) goto L26;
        r10.setOnCheckedChangeListener(r2.h);
        return;
    L26:
        return;
    L25:
        return;
    }

    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r10, r11);
        LarusDoragPageSoundSettingsBinding r12 = this.f;
        if (r12 == null) goto L5;
        NovaTitleBarEx r0 = r12.d;
        NovaTitleBarEx.Y5(r0, getString(2131903999), null, null, 6);
        NovaTitleBarEx.b6(r0, 2131240517, false, null, null, new d(this), 14);
    L5:
        LarusDoragPageSoundSettingsBinding r13 = this.f;
        if (r13 == null) goto L12;
        ItemTextToggle r14 = r13.c;
        if (r14 == null) goto L12;
        CustomSwitchCompat r15 = r14.getToggleView();
        if (r15 == null) goto L12;
        r15.setOnCheckedChangeListener(this.h);
    L12:
        Lifecycle.State r16 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraGSoundSettingsFragment$setupAntiSoundLeak$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r16, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraGSoundSettingsFragment$setupAntiSoundLeak$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r16, null, this), 3, null);
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        View r6 = r3.inflate(2131562316, r4, false);
        int r7 = 2131369962;
        View r8 = ViewBindings.findChildViewById(r6, 2131369962);
        if (r8 == null) goto L17;
        r7 = 2131370079;
        if (ViewBindings.findChildViewById(r6, 2131370079) == null) goto L17;
        r7 = 2131370080;
        if (ViewBindings.findChildViewById(r6, 2131370080) == null) goto L17;
        r7 = 2131370081;
        ItemTextToggle r0 = ViewBindings.findChildViewById(r6, 2131370081);
        if (r0 == null) goto L17;
        r7 = 2131385238;
        if (((ScrollView) ViewBindings.findChildViewById(r6, 2131385238)) == null) goto L17;
        r7 = 2131388772;
        NovaTitleBarEx r1 = ViewBindings.findChildViewById(r6, 2131388772);
        if (r1 == null) goto L17;
        LinearLayout r9 = (LinearLayout) r6;
        this.f = new LarusDoragPageSoundSettingsBinding(r9, r8, r0, r1);
        return r9;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
    }
}
