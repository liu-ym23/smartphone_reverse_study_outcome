package com.larus.dora.obric.device_management.setting.g.gesture;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.larus.dora.impl.databinding.LarusDoraPageObricGGestureOptionsBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.device.settings.gesture.DoraGGestureSettings;
import com.larus.dora.impl.device.settings.gesture.options.DoraGOptionsViewModel;
import com.larus.dora.impl.resource.DoraResourceDeviceType;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.checkbox.OCheckMark;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.titlebar.OFloatingTitleBar;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 O2\u00020\u0001:\u0001OB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\n\u0010!\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020 H\u0002J\b\u0010$\u001a\u00020\u001cH\u0002J\u0012\u0010%\u001a\u00020\u001c2\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J\u0010\u0010(\u001a\u00020 2\u0006\u0010&\u001a\u00020'H\u0002J\u0016\u0010)\u001a\u00020\u001c2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020'0+H\u0002J\u0018\u0010,\u001a\u00020\u00142\u0006\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020'H\u0002J\u0018\u00101\u001a\u00020\r2\u0006\u00102\u001a\u00020'2\u0006\u00103\u001a\u00020'H\u0002J\b\u00104\u001a\u00020\u001cH\u0002J\u0014\u00105\u001a\u00020\u001c*\u0002062\u0006\u00107\u001a\u00020\rH\u0002J\u0010\u00108\u001a\u00020\r2\u0006\u0010-\u001a\u00020'H\u0002J\u0010\u00109\u001a\u00020\u001c2\u0006\u0010:\u001a\u00020'H\u0002J\u0010\u0010;\u001a\u00020 2\u0006\u0010:\u001a\u00020'H\u0002J\u0010\u0010<\u001a\u00020 2\u0006\u0010:\u001a\u00020'H\u0002J\u0010\u0010=\u001a\u00020 2\u0006\u0010:\u001a\u00020'H\u0002J\u0018\u0010>\u001a\u00020 2\u0006\u0010?\u001a\u00020\r2\u0006\u0010@\u001a\u00020\rH\u0002J\b\u0010A\u001a\u00020\u000fH\u0002J\u0010\u0010B\u001a\u00020\u001c2\u0006\u0010?\u001a\u00020\rH\u0002J\u0010\u0010C\u001a\u00020\u001c2\u0006\u00103\u001a\u00020'H\u0002J\u0010\u0010D\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020FH\u0002J\u0012\u0010G\u001a\u00020 2\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J\u0018\u0010H\u001a\u00020/2\u0006\u0010I\u001a\u00020/2\u0006\u0010J\u001a\u00020/H\u0002J\b\u0010K\u001a\u00020/H\u0002J\b\u0010L\u001a\u00020/H\u0002J\u0014\u0010M\u001a\u00020\u001c*\u0002062\u0006\u0010.\u001a\u00020/H\u0002J\f\u0010N\u001a\u00020/*\u00020/H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0010\u0010\u0011¨\u0006P"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/g/gesture/DoraObricGGestureOptionsFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageObricGGestureOptionsBinding;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/device/settings/gesture/options/DoraGOptionsViewModel;", "getModel", "()Lcom/larus/dora/impl/device/settings/gesture/options/DoraGOptionsViewModel;", "model$delegate", "Lkotlin/Lazy;", "isDarkMode", "", "gestureResourceDeviceType", "Lcom/larus/dora/impl/resource/DoraResourceDeviceType;", "getGestureResourceDeviceType", "()Lcom/larus/dora/impl/resource/DoraResourceDeviceType;", "gestureResourceDeviceType$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "getCurrentPageName", "", "getPageMaskView", "setupTitle", "title", "observeOptions", "setupSectionTitle", "settings", "Lcom/larus/dora/impl/device/settings/gesture/DoraGGestureSettings;", "sectionTitleFor", "refreshOptionsList", "optionList", "", "buildOptionItem", "option", "position", "", "onOptionClicked", "shouldShowHeadphoneModeExitConfirmDialog", "currentGesture", "selectedOption", "syncSelectedOptionMark", "setOptionSelected", "Lcom/obric/oui/lisitem/OCardListItem;", "selected", "isSelectedOption", "showDeviceLottie", "gestureSettings", "resolveGestureAnimationPath", "resolveG1GestureAnimationPath", "resolveG2GestureAnimationPath", "g1ImageResourceName", "isButtonGesture", "isLeft", "resolveGestureResourceDeviceType", "updateOptionsGroupTopMargin", "showHeadphoneModeExitConfirmDialog", "showQuickControlGuideDialog", "dialog", "Lcom/larus/dora/impl/device/settings/gesture/options/QuickControlGuideDialogData;", "resolveTitle", "resolveCardPosition", "index", "size", "resolveBackgroundColor", "resolveSectionTitleColor", "applyCardStyle", "dp", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricGGestureOptionsFragment extends DoraBaseFragment {
    public static final /* synthetic */ int j = 0;
    public LarusDoraPageObricGGestureOptionsBinding f;
    public final Lazy g;
    public final boolean h;
    public final Lazy i;

    public static final class a {
    }

    static {
    }

    public final String k() {
        return "Gesture_Options";
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        LarusDoraPageObricGGestureOptionsBinding r0 = this.f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.f;
    }

    public final DoraGOptionsViewModel X90() {
        return (DoraGOptionsViewModel) this.g.getValue();
    }

    public final void onDestroyView() {
        LarusDoraPageObricGGestureOptionsBinding r0 = this.f;
        if (r0 == null) goto L7;
        LottieAnimationView r1 = r0.c;
        if (r1 == null) goto L7;
        r1.cancelAnimation();
    L7:
        this.f = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public DoraObricGGestureOptionsFragment() {
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraGOptionsViewModel.class), new DoraObricGGestureOptionsFragment$special$$inlined$activityViewModels$default$1(this), new DoraObricGGestureOptionsFragment$special$$inlined$activityViewModels$default$2(this));
        boolean r0 = v19.h.a;
        this.h = v19.h.a(null);
        this.i = LazyKt.lazy(new e(this));
    }

    public final int W90(int r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public static void Y90(OCardListItem r1, boolean r2) {
        r1.m(true);
        OCheckMark r3 = r1.getEndMark();
        if (r3 == null) goto L10;
        r3.setChecked(r2);
        if (r2 == false) goto L7;
        int r4 = 0;
    L8:
        r3.setVisibility(r4);
        return;
    L7:
        r4 = 4;
        goto L8
    }

    public final void onViewCreated(View r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r14, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r14, r15);
        Bundle r16 = getArguments();
        if (r16 == null) goto L5;
        DoraGGestureSettings r17 = (DoraGGestureSettings) r16.getParcelable("options_data");
    L6:
        boolean r2 = true;
        int r3 = 0;
        if (((DoraResourceDeviceType) this.i.getValue()) != DoraResourceDeviceType.G1) goto L9;
        boolean r0 = true;
    L11:
        if (X90().getCurrentGesture() != null) goto L13;
        X90().initData(r17, r0);
    L15:
        if (r17 != null) goto L17;
    L19:
        boolean r1 = false;
    L20:
        String r4 = "";
        if (r1 == false) goto L23;
        String r5 = r17.d();
    L28:
        LarusDoraPageObricGGestureOptionsBinding r6 = this.f;
        if (r6 == null) goto L33;
        OFloatingTitleBar r7 = r6.g;
        if (r7 == null) goto L33;
        com.larus.dora.obric.utils.c.a(r7);
        r7.setBackgroundColor(v19.c.a(2130970531, requireContext(), 2131102535));
        r7.setCenterTitle(r5);
        r7.R(false);
        OFloatingTitleBar.k(r7, null, 6).setOnClickListener(new com.larus.dora.obric.device_management.setting.g.gesture.a(this));
    L33:
        DoraGGestureSettings r8 = X90().getCurrentGesture();
        if (r8 == null) goto L37;
        r17 = r8;
    L37:
        LarusDoraPageObricGGestureOptionsBinding r9 = this.f;
        if (r9 == null) goto L62;
        OSectionTitleBar r10 = r9.e;
        if (r10 == null) goto L62;
        LinearLayout r11 = (LinearLayout) r10.findViewById(2131367728);
        if (r11 == null) goto L44;
        r11.setPadding(W90(20), W90(8), W90(8), W90(8));
    L44:
        r10.setTitleTextSize(12.0f);
        r10.setTitleTextColor(v19.c.a(2130972081, requireContext(), 2131103143));
        if (r17 != null) goto L47;
        String r12 = null;
    L51:
        if (r12 == null) goto L54;
        r4 = r12;
    L54:
        r10.setTitleText(r4);
        if (r17 != null) goto L58;
        r2 = false;
    L58:
        if (r2 == true) goto L61;
        r3 = 8;
    L61:
        r10.setVisibility(r3);
        goto L62
    L47:
        if (r17.b != 4) goto L49;
        r12 = getString(2131902358);
        Intrinsics.checkNotNull(r12);
        goto L51
    L49:
        r12 = r17.g();
    L62:
        Lifecycle.State r18 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricGGestureOptionsFragment$observeOptions$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r18, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricGGestureOptionsFragment$observeOptions$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r18, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricGGestureOptionsFragment$observeOptions$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r18, null, this), 3, null);
        return;
    L23:
        if (r17 == null) goto L25;
        r5 = r17.e() + ' ' + r17.d();
    L26:
        if (r5 != null) goto L28;
        r5 = "";
        goto L28
    L25:
        r5 = null;
        goto L26
    L17:
        if (r17.b != 4) goto L19;
        r1 = true;
        goto L20
    L13:
        X90().initData(X90().getCurrentGesture(), r0);
        goto L15
    L9:
        r0 = false;
        goto L11
    L5:
        r17 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r9, ViewGroup r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r9, "inflater");
        ConstraintLayout r12 = r9.inflate(2131562281, r10, false);
        int r13 = 2131369834;
        if (((LinearLayout) ViewBindings.findChildViewById(r12, 2131369834)) == null) goto L23;
        r13 = 2131369835;
        ImageView r2 = (ImageView) ViewBindings.findChildViewById(r12, 2131369835);
        if (r2 == null) goto L23;
        r13 = 2131369836;
        LottieAnimationView r3 = ViewBindings.findChildViewById(r12, 2131369836);
        if (r3 == null) goto L23;
        r13 = 2131369837;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r12, 2131369837);
        if (r4 == null) goto L23;
        r13 = 2131369838;
        OSectionTitleBar r5 = ViewBindings.findChildViewById(r12, 2131369838);
        if (r5 == null) goto L23;
        r13 = 2131369839;
        View r6 = ViewBindings.findChildViewById(r12, 2131369839);
        if (r6 == null) goto L23;
        r13 = 2131369840;
        if (ViewBindings.findChildViewById(r12, 2131369840) == null) goto L23;
        r13 = 2131369841;
        if (((ScrollView) ViewBindings.findChildViewById(r12, 2131369841)) == null) goto L23;
        r13 = 2131369842;
        OFloatingTitleBar r7 = ViewBindings.findChildViewById(r12, 2131369842);
        if (r7 == null) goto L23;
        ConstraintLayout r14 = r12;
        this.f = new LarusDoraPageObricGGestureOptionsBinding(r14, r2, r3, r4, r5, r6, r7);
        return r14;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r13)));
    }
}
