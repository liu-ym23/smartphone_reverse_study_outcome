package com.larus.dora.impl.device.settings.gesture;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import androidx.activity.OnBackPressedDispatcher;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.router.SmartRouter;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemGroupTitle;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.databinding.LarusDoraPageGestureSettingsBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.device.settings.gesture.options.OptionModel;
import com.larus.dora.impl.device.settings.gesture.wakeup.GestureWakeupType;
import com.larus.dora.impl.device.settings.gesture.widget.DoraGestureGuidanceMaskView;
import com.larus.dora.impl.model.GestureSettingsKey;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.util.DoraImageType;
import com.larus.dora.impl.util.DoraResourceUtil;
import com.larus.dora.impl.util.DoraSKU;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.e1;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.dora.IObricDoraService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\b\u000b\u0018\u0000 :2\u00020\u0001:\u0001:B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010!\u001a\u00020\u001fH\u0002J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u0017H\u0002J\u0012\u0010$\u001a\u0004\u0018\u00010\t2\u0006\u0010%\u001a\u00020\u0012H\u0002J\u0018\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020+H\u0016J#\u0010,\u001a\u0004\u0018\u00010\u001f2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002000.H\u0002¢\u0006\u0002\u00101J\n\u00102\u001a\u0004\u0018\u00010\u0017H\u0016J\u000f\u00103\u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0002\u00104J\u000f\u00105\u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0002\u00104J\u0010\u00106\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\u0012H\u0002J\u0010\u00108\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\u0012H\u0002J\b\u00109\u001a\u00020\u001fH\u0002R\u0018\u0010\u0004\u001a\u00020\u0005*\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/larus/dora/impl/device/settings/gesture/GestureSettingsFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "dp", "", "getDp", "(I)I", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageGestureSettingsBinding;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/device/settings/gesture/GestureSettingsViewModel;", "getModel", "()Lcom/larus/dora/impl/device/settings/gesture/GestureSettingsViewModel;", "model$delegate", "Lkotlin/Lazy;", "isFirst", "isSupportSimulInterpret", "", "isSupportOta3p5", "doraGestureGuidanceMask", "Lcom/larus/dora/impl/device/settings/gesture/widget/DoraGestureGuidanceMaskView;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setSimultaneousInterpretGuideMask", "showGuideMask", "targetItem", "updateGestureWakeupGroup", "isSupport", "updateGestureWakeup", "side", "type", "Lcom/larus/dora/impl/device/settings/gesture/wakeup/GestureWakeupType;", "getCurrentPageName", "", "bind", "map", "", "Lcom/larus/dora/impl/model/GestureSettingsKey;", "", "(Ljava/util/Map;)Lkotlin/Unit;", "getPageMaskView", "setupTitle", "()Lkotlin/Unit;", "setPrefer", "gotoMediaGestureSettingsPage", "isLeft", "gotoCallingGestureSettingsPage", "setupBackPressedCallback", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GestureSettingsFragment extends DoraBaseFragment {
    public static final /* synthetic */ int l = 0;
    public LarusDoraPageGestureSettingsBinding f;
    public final Lazy g;
    public int h;
    public boolean i;
    public boolean j;
    public DoraGestureGuidanceMaskView k;

    public static final class a {
    }

    public static final class b<T> implements FlowCollector {
        public final /* synthetic */ GestureSettingsFragment a;

        public b(GestureSettingsFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r4, Continuation r5) {
            c0 r6 = (c0) r4;
            if (Intrinsics.areEqual(r6, c0.a.a) == true) goto L14;
            if (Intrinsics.areEqual(r6, c0.b.a) == true) goto L14;
            if ((r6 instanceof c0.c) == false) goto L12;
            GestureSettingsFragment r7 = this.a;
            Map<GestureSettingsKey, Byte> r8 = ((c0.c) r6).a;
            LarusDoraPageGestureSettingsBinding r9 = r7.f;
            if (r9 == null) goto L14;
            ItemTextArrow r0 = r9.e;
            GestureSettingsRepository r1 = GestureSettingsRepository.a;
            Byte r2 = r8.get(GestureSettingsKey.MEDIA_LEFT_DOUBLE_CLICK);
            r1.getClass();
            String r3 = GestureSettingsRepository.i(r2);
            int r10 = ItemTextArrow.k;
            r0.Z5(r3, null);
            r9.f.Z5(GestureSettingsRepository.i(r8.get(GestureSettingsKey.MEDIA_RIGHT_DOUBLE_CLICK)), null);
            r9.c.Z5(GestureSettingsRepository.i(r8.get(GestureSettingsKey.CALLING_LEFT_DOUBLE_CLICK)), null);
            r9.d.Z5(GestureSettingsRepository.i(r8.get(GestureSettingsKey.CALLING_RIGHT_DOUBLE_CLICK)), null);
            Unit r11 = Unit.INSTANCE;
            goto L14
        L12:
            throw new NoWhenBranchMatchedException();
        L14:
            return Unit.INSTANCE;
        }
    }

    public static final class c<T> implements FlowCollector {
        public final /* synthetic */ GestureSettingsFragment a;

        public c(GestureSettingsFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r6, Continuation r7) {
            com.larus.dora.impl.device.settings.gesture.wakeup.h r8 = (com.larus.dora.impl.device.settings.gesture.wakeup.h) r6;
            if (r8 == null) goto L26;
            GestureWakeupType r9 = r8.getType();
            if (r9 == null) goto L26;
            GestureSettingsFragment r0 = this.a;
            int r10 = r8.b;
            int r1 = GestureSettingsFragment.l;
            r0.getClass();
            if (r10 != 0) goto L9;
        L11:
            LarusDoraPageGestureSettingsBinding r2 = r0.f;
            if (r2 == null) goto L16;
            ItemTextArrow r3 = r2.i;
            if (r3 == null) goto L16;
            int r4 = j0.a;
            String r5 = j0.d(r9.getTitleResId());
            int r11 = ItemTextArrow.k;
            r3.Z5(r5, null);
        L16:
            if (r10 != 0) goto L18;
        L20:
            LarusDoraPageGestureSettingsBinding r12 = r0.f;
            if (r12 == null) goto L26;
            ItemTextArrow r13 = r12.j;
            if (r13 == null) goto L26;
            int r14 = j0.a;
            String r15 = j0.d(r9.getTitleResId());
            int r16 = ItemTextArrow.k;
            r13.Z5(r15, null);
            goto L26
        L18:
            if (r10 == 2) goto L20;
        L9:
            if (r10 == 1) goto L11;
        L26:
            return Unit.INSTANCE;
        }
    }

    public static final class d<T> implements FlowCollector {
        public final /* synthetic */ GestureSettingsFragment a;

        public d(GestureSettingsFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r3, Continuation r4) {
            boolean r5 = ((Boolean) r3).booleanValue();
            final GestureSettingsFragment r6 = this.a;
            LarusDoraPageGestureSettingsBinding r0 = r6.f;
            if (r0 == null) goto L8;
            if (r5 == false) goto L6;
            e1.x(r0.g);
            e1.x(r0.h);
            e1.d(r0.i, new t(r6));
            e1.d(r0.j, new u(r6));
            goto L8
        L6:
            e1.o(r0.g);
            e1.o(r0.h);
        L8:
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final String k() {
        return "gesture_setting";
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        LarusDoraPageGestureSettingsBinding r0 = this.f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.k;
    }

    public GestureSettingsFragment() {
        final Function0<Fragment> r0 = new GestureSettingsFragment$special$$inlined$viewModels$default$1(this);
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(GestureSettingsViewModel.class), new GestureSettingsFragment$special$$inlined$viewModels$default$2(r0), new GestureSettingsFragment$special$$inlined$viewModels$default$3(r0, this));
    }

    public final void W90(boolean r9) {
        if (r9 == false) goto L4;
        GestureSettingsKey r0 = GestureSettingsKey.CALLING_LEFT_DOUBLE_CLICK;
    L5:
        ArrayList r1 = CollectionsKt.arrayListOf(new OptionModel[]{new OptionModel(getString(2131903003), "", r0, (byte) 1), new OptionModel(getString(2131902999), "", r0, (byte) 2), new OptionModel(getString(2131903002), "", r0, (byte) 3), new OptionModel(getString(2131903039), "", r0, (byte) 0)});
        if (r9 == false) goto L8;
        String r10 = getString(2131903015);
    L9:
        Intrinsics.checkNotNull(r10);
        com.bytedance.router.i r2 = SmartRouter.buildRoute(getContext(), "//dora_options_activity");
        Bundle r3 = com.larus.utils.f.c(new Pair[0]);
        by7.h.k(r3, this);
        r2.c.putExtras(r3);
        r2.c.putExtra("options_title", r10);
        r2.c.putExtra("options_data", r1);
        r2.d = 2130772401;
        r2.e = 2130772399;
        r2.d();
        return;
    L8:
        r10 = getString(2131903016);
        goto L9
    L4:
        r0 = GestureSettingsKey.CALLING_RIGHT_DOUBLE_CLICK;
        goto L5
    }

    public final void X90(boolean r9) {
        DoraGestureGuidanceMaskView r0 = this.k;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        if (r9 == false) goto L7;
        GestureSettingsKey r1 = GestureSettingsKey.MEDIA_LEFT_DOUBLE_CLICK;
    L8:
        boolean r5 = true;
        ArrayList r2 = CollectionsKt.arrayListOf(new OptionModel[]{new OptionModel(getString(2131903033), "", r1, (byte) 16), new OptionModel(getString(2131903034), "", r1, (byte) 19), new OptionModel(getString(2131903032), "", r1, (byte) 20)});
        if (this.i == false) goto L12;
        r2.add(new OptionModel(getString(2131903053), "", r1, (byte) 34));
    L12:
        if (this.j == false) goto L21;
        IObricDoraService r3 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r3 != null) goto L16;
    L18:
        r5 = false;
    L19:
        if (r5 == true) goto L21;
        r2.add(new OptionModel(getString(2131902250), "", r1, (byte) -1));
        goto L21
    L16:
        if (r3.t() != true) goto L18;
    L21:
        r2.add(new OptionModel(getString(2131903039), "", r1, (byte) 0));
        if (r9 == false) goto L24;
        String r10 = getString(2131903015);
    L25:
        Intrinsics.checkNotNull(r10);
        com.bytedance.router.i r4 = SmartRouter.buildRoute(getContext(), "//dora_options_activity");
        Bundle r6 = com.larus.utils.f.c(new Pair[0]);
        by7.h.k(r6, this);
        r4.c.putExtras(r6);
        r4.c.putExtra("options_title", r10);
        r4.c.putExtra("options_data", r2);
        r4.d = 2130772401;
        r4.e = 2130772399;
        r4.d();
        return;
    L24:
        r10 = getString(2131903016);
        goto L25
    L7:
        r1 = GestureSettingsKey.MEDIA_RIGHT_DOUBLE_CLICK;
        goto L8
    }

    public final void onViewCreated(View r20, Bundle r21) {
        Intrinsics.checkNotNullParameter(r20, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r20, r21);
        Bundle r1 = getArguments();
        boolean r2 = false;
        if (r1 == null) goto L5;
        int r3 = r1.getInt("is_first");
    L6:
        this.h = r3;
        IDoraService r4 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r4 == null) goto L13;
        DeviceService r5 = r4.device();
        if (r5 == null) goto L13;
        if (r5.j0() != true) goto L13;
        boolean r6 = true;
    L14:
        this.i = r6;
        if (r4 == null) goto L21;
        DeviceService r7 = r4.device();
        if (r7 == null) goto L21;
        if (r7.q0(null) != true) goto L21;
        boolean r8 = true;
    L22:
        this.j = r8;
        LarusDoraPageGestureSettingsBinding r9 = this.f;
        if (r9 == null) goto L29;
        NovaTitleBarEx r10 = r9.l;
        NovaTitleBarEx.Y5(r10, getString(2131902423), null, null, 6);
        NovaTitleBarEx.b6(r10, 2131240517, false, null, null, new v(this), 14);
        DoraDevice r11 = DoraAdapterExtKt.h(kj4.a.g());
        if (r11 == null) goto L27;
        Integer r12 = Integer.valueOf(r11.sku);
    L28:
        DoraSKU r13 = DoraSKU.a.b(DoraSKU.Companion, r12);
        g49.d.d("GestureSettingsFragment", "GestureSettings sku=" + r12 + ", doraSku name is " + r13);
        ImageView r14 = r9.b;
        DoraResourceUtil r15 = DoraResourceUtil.a;
        r14.setImageBitmap(DoraResourceUtil.c(DoraImageType.IMAGE_ONBOARDING_POPUP_HEADPHONE_GESTURE.fileName(r13)));
        Unit r16 = Unit.INSTANCE;
        goto L29
    L27:
        r12 = null;
    L29:
        final LarusDoraPageGestureSettingsBinding r17 = this.f;
        if (r17 == null) goto L65;
        e1.d(r17.e, new w(this));
        e1.d(r17.f, new x(this));
        if (this.h != 0) goto L34;
    L47:
        e1.d(r17.c, new z(this));
        e1.d(r17.d, new a0(this));
        IDoraService r18 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r18 == null) goto L54;
        DeviceService r22 = r18.device();
        if (r22 == null) goto L54;
        if (r22.q0(null) != true) goto L54;
        boolean r23 = true;
    L55:
        if (r23 == false) goto L63;
        IObricDoraService r24 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r24 != null) goto L59;
    L61:
        if (r2 == true) goto L63;
        e1.x(r17.j);
        r17.i.setText(getString(2131903367));
    L64:
        Unit r25 = Unit.INSTANCE;
        goto L65
    L59:
        if (r24.t() != true) goto L61;
        r2 = true;
    L63:
        r17.i.setText(getString(2131904049));
        e1.o(r17.j);
    L54:
        r23 = false;
        goto L55
    L34:
        if (this.i == false) goto L47;
        Window r26 = requireActivity().getWindow();
        if (r26 == null) goto L42;
        View r27 = r26.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L43;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r28 = ThreadMethodProxy.currentThread();
        if (r28 == com.larus.home.impl.utils.c.a) goto L43;
        com.larus.home.impl.utils.c.a(r28, "getDecorView");
    L43:
        Intrinsics.checkNotNull(r27, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r30 = (ViewGroup) r27;
        this.k = new DoraGestureGuidanceMaskView(requireContext(), null, 6, 0);
        FrameLayout.LayoutParams r31 = new FrameLayout.LayoutParams(-1, -1);
        DoraGestureGuidanceMaskView r32 = this.k;
        if (r32 == null) goto L46;
        boolean r33 = v19.h.a;
        r32.setDarkMode(v19.h.a(null));
        r32.setClickable(false);
        r32.setFocusable(true);
    L46:
        r30.addView(this.k, r31);
        r17.f.post(new y(this, r17));
        this.h = 0;
        goto L47
    L42:
        r27 = null;
    L65:
        FragmentActivity r34 = getActivity();
        if (r34 == null) goto L70;
        OnBackPressedDispatcher r35 = r34.getOnBackPressedDispatcher();
        if (r35 == null) goto L70;
        r35.addCallback(getViewLifecycleOwner(), new GestureSettingsFragment$setupBackPressedCallback$1(this));
    L70:
        Lifecycle.State r36 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new GestureSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r36, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new GestureSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r36, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new GestureSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r36, null, this), 3, null);
        return;
    L21:
        r8 = false;
    L13:
        r6 = false;
        goto L14
    L5:
        r3 = 0;
        goto L6
    }

    public final View onCreateView(LayoutInflater r17, ViewGroup r18, Bundle r110) {
        Intrinsics.checkNotNullParameter(r17, "inflater");
        ConstraintLayout r0 = r17.inflate(2131562267, r18, false);
        int r1 = 2131369491;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r0, 2131369491);
        if (r5 == null) goto L33;
        r1 = 2131369610;
        if (ViewBindings.findChildViewById(r0, 2131369610) == null) goto L33;
        r1 = 2131369612;
        ItemTextArrow r6 = ViewBindings.findChildViewById(r0, 2131369612);
        if (r6 == null) goto L33;
        r1 = 2131369613;
        ItemTextArrow r7 = ViewBindings.findChildViewById(r0, 2131369613);
        if (r7 == null) goto L33;
        r1 = 2131369616;
        if (ViewBindings.findChildViewById(r0, 2131369616) == null) goto L33;
        r1 = 2131369618;
        ItemTextArrow r8 = ViewBindings.findChildViewById(r0, 2131369618);
        if (r8 == null) goto L33;
        r1 = 2131369619;
        ItemTextArrow r9 = ViewBindings.findChildViewById(r0, 2131369619);
        if (r9 == null) goto L33;
        r1 = 2131369620;
        ItemGroup r10 = ViewBindings.findChildViewById(r0, 2131369620);
        if (r10 == null) goto L33;
        r1 = 2131369621;
        ItemGroupTitle r11 = ViewBindings.findChildViewById(r0, 2131369621);
        if (r11 == null) goto L33;
        r1 = 2131369627;
        ItemTextArrow r12 = ViewBindings.findChildViewById(r0, 2131369627);
        if (r12 == null) goto L33;
        r1 = 2131369628;
        ItemTextArrow r13 = ViewBindings.findChildViewById(r0, 2131369628);
        if (r13 == null) goto L33;
        r1 = 2131369962;
        View r14 = ViewBindings.findChildViewById(r0, 2131369962);
        if (r14 == null) goto L33;
        r1 = 2131385238;
        if (((ScrollView) ViewBindings.findChildViewById(r0, 2131385238)) == null) goto L33;
        r1 = 2131388772;
        NovaTitleBarEx r15 = ViewBindings.findChildViewById(r0, 2131388772);
        if (r15 == null) goto L33;
        ConstraintLayout r2 = r0;
        this.f = new LarusDoraPageGestureSettingsBinding(r2, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
        return r2;
    L33:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }
}
