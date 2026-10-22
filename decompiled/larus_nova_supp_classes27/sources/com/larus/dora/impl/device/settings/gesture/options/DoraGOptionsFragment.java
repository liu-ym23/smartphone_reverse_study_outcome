package com.larus.dora.impl.device.settings.gesture.options;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemGroupTitle;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.databinding.LarusDoraGPageOptionsBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.device.settings.gesture.DoraGGestureSettings;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.j0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 12\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u000f\u0010\u0019\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\rH\u0002J\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u00172\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002¢\u0006\u0002\u0010\"J\u0018\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020!H\u0002J\u0010\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020!H\u0002J\u0010\u0010(\u001a\u00020\u00172\u0006\u0010%\u001a\u00020!H\u0002J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020+H\u0002J\b\u0010,\u001a\u00020\u001cH\u0016J\n\u0010-\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020\u001cH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/larus/dora/impl/device/settings/gesture/options/DoraGOptionsFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraGPageOptionsBinding;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/device/settings/gesture/options/DoraGOptionsViewModel;", "getModel", "()Lcom/larus/dora/impl/device/settings/gesture/options/DoraGOptionsViewModel;", "model$delegate", "Lkotlin/Lazy;", "isDarkMode", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setPrefer", "()Lkotlin/Unit;", "getImageResourceName", "", "isLeft", "refreshOptionsList", "optionList", "", "Lcom/larus/dora/impl/device/settings/gesture/DoraGGestureSettings;", "(Ljava/util/List;)Lkotlin/Unit;", "shouldShowHeadphoneModeExitConfirmDialog", "currentGesture", "selectedOption", "showDeviceLottie", "gestureSettings", "showHeadphoneModeExitConfirmDialog", "showQuickControlGuideDialog", "dialog", "Lcom/larus/dora/impl/device/settings/gesture/options/QuickControlGuideDialogData;", "getCurrentPageName", "getPageMaskView", "setupTitle", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "titleText", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraGOptionsFragment extends DoraBaseFragment {
    public static final /* synthetic */ int i = 0;
    public LarusDoraGPageOptionsBinding f;
    public final Lazy g;
    public final boolean h;

    public static final class a {
    }

    static {
    }

    public final String k() {
        return "Gesture_Options";
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        LarusDoraGPageOptionsBinding r0 = this.f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.g;
    }

    public final DoraGOptionsViewModel X90() {
        return (DoraGOptionsViewModel) this.g.getValue();
    }

    public DoraGOptionsFragment() {
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraGOptionsViewModel.class), new DoraGOptionsFragment$special$$inlined$activityViewModels$default$1(this), new DoraGOptionsFragment$special$$inlined$activityViewModels$default$2(this));
        boolean r0 = v19.h.a;
        this.h = v19.h.a(null);
    }

    public final void onViewCreated(View r20, Bundle r21) {
        Intrinsics.checkNotNullParameter(r20, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r20, r21);
        Bundle r1 = getArguments();
        if (r1 == null) goto L5;
        DoraGGestureSettings r2 = (DoraGGestureSettings) r1.getParcelable("options_data");
    L6:
        IDoraService r3 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        boolean r4 = true;
        if (r3 == null) goto L13;
        DeviceService r5 = r3.device();
        if (r5 == null) goto L13;
        if (r5.N() == true) goto L13;
        boolean r6 = true;
    L14:
        boolean r7 = !r6;
        if (X90().getCurrentGesture() != null) goto L17;
        X90().initData(r2, r7);
    L18:
        if (r2 != null) goto L20;
    L22:
        r4 = false;
    L24:
        if (r4 == false) goto L26;
        StringBuilder r8 = new StringBuilder();
        int r9 = j0.a;
        r8.append(j0.d(2131902357));
        r8.append(' ');
        r8.append(r2.d());
        String r10 = r8.toString();
    L30:
        LarusDoraGPageOptionsBinding r11 = this.f;
        if (r11 == null) goto L33;
        NovaTitleBarEx r12 = r11.h;
        NovaTitleBarEx.Y5(r12, r10, null, null, 6);
        NovaTitleBarEx.b6(r12, 2131240517, false, null, null, new c(this), 14);
    L33:
        LarusDoraGPageOptionsBinding r13 = this.f;
        if (r13 == null) goto L37;
        r13.f.setPadding(i5.q(), 0, 0, i5.n0());
        Lifecycle.State r14 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraGOptionsFragment$setPrefer$lambda$4$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r14, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraGOptionsFragment$setPrefer$lambda$4$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r14, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraGOptionsFragment$setPrefer$lambda$4$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r14, null, this), 3, null);
        Unit r15 = Unit.INSTANCE;
        return;
    L37:
        return;
    L26:
        if (r2 == null) goto L29;
        r10 = r2.e() + ' ' + r2.d();
        if (r10 != null) goto L30;
    L29:
        r10 = "";
        goto L30
    L20:
        if (r2.b != 4) goto L22;
    L17:
        X90().initData(X90().getCurrentGesture(), r7);
    L13:
        r6 = false;
        goto L14
    L5:
        r2 = null;
        goto L6
    }

    public static void W90(CommonDialog r1, FragmentManager r2, String r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r1, r3, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, r1, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r1.show(r2, r3);
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        ConstraintLayout r13 = r10.inflate(2131562201, r11, false);
        int r14 = 2131365019;
        View r2 = ViewBindings.findChildViewById(r13, 2131365019);
        if (r2 == null) goto L21;
        r14 = 2131369479;
        ImageView r3 = (ImageView) ViewBindings.findChildViewById(r13, 2131369479);
        if (r3 == null) goto L21;
        r14 = 2131369493;
        LottieAnimationView r4 = ViewBindings.findChildViewById(r13, 2131369493);
        if (r4 == null) goto L21;
        r14 = 2131369954;
        ItemGroup r5 = ViewBindings.findChildViewById(r13, 2131369954);
        if (r5 == null) goto L21;
        r14 = 2131369955;
        ItemGroupTitle r6 = ViewBindings.findChildViewById(r13, 2131369955);
        if (r6 == null) goto L21;
        r14 = 2131369962;
        View r7 = ViewBindings.findChildViewById(r13, 2131369962);
        if (r7 == null) goto L21;
        r14 = 2131385238;
        if (((ScrollView) ViewBindings.findChildViewById(r13, 2131385238)) == null) goto L21;
        r14 = 2131388772;
        NovaTitleBarEx r8 = ViewBindings.findChildViewById(r13, 2131388772);
        if (r8 == null) goto L21;
        ConstraintLayout r15 = r13;
        this.f = new LarusDoraGPageOptionsBinding(r15, r2, r3, r4, r5, r6, r7, r8);
        return r15;
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r14)));
    }
}
