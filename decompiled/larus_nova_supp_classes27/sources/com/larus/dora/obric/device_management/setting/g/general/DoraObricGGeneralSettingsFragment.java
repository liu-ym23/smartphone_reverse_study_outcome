package com.larus.dora.obric.device_management.setting.g.general;

import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.larus.dora.impl.device.settings.DoraUnbindBaseFragment;
import com.larus.dora.impl.device.settings.general.GeneralSettingsViewModel;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0091\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u001f\u0018\u0000 e2\u00020\u0001:\u0001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u001a\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00122\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010.\u001a\u00020,H\u0016J\b\u0010/\u001a\u00020,H\u0016J\b\u00100\u001a\u00020,H\u0016J\b\u00101\u001a\u00020,H\u0016J\u0010\u00102\u001a\u00020,2\u0006\u00103\u001a\u00020\u000bH\u0016J\b\u00104\u001a\u000205H\u0016J\n\u00106\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u00107\u001a\u00020\u0012H\u0002J\b\u00108\u001a\u00020\u0012H\u0002J\b\u00109\u001a\u00020\u0012H\u0002J,\u0010:\u001a\u00020\u00102\u0006\u0010;\u001a\u0002052\u0006\u0010<\u001a\u0002052\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020,0>H\u0002J&\u0010?\u001a\u00020\u00102\u0006\u0010@\u001a\u0002052\u0006\u0010A\u001a\u00020\u000b2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020,0CH\u0002J\b\u0010D\u001a\u00020,H\u0002J\b\u0010E\u001a\u00020,H\u0002J\u0010\u0010F\u001a\u00020,2\u0006\u0010G\u001a\u00020HH\u0002J\u0010\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020JH\u0002J\u0010\u0010L\u001a\u00020,2\u0006\u0010M\u001a\u00020\u000bH\u0002J\u0010\u0010N\u001a\u00020,2\u0006\u0010M\u001a\u00020\u000bH\u0002J\b\u0010O\u001a\u00020,H\u0002J\b\u0010P\u001a\u00020,H\u0002J\b\u0010Q\u001a\u00020,H\u0002J\u0018\u0010R\u001a\u00020,2\u0006\u0010;\u001a\u0002052\u0006\u0010S\u001a\u000205H\u0002J\b\u0010T\u001a\u00020,H\u0002J\f\u0010U\u001a\u00020,*\u00020\u0010H\u0002J\f\u0010V\u001a\u00020,*\u00020\u0010H\u0002J\f\u0010W\u001a\u00020,*\u00020\u0010H\u0002J\f\u0010X\u001a\u00020,*\u00020\u0010H\u0002J\u0010\u0010Y\u001a\u00020\u00122\u0006\u0010Z\u001a\u00020JH\u0002J\b\u0010[\u001a\u00020JH\u0002J\b\u0010\\\u001a\u00020JH\u0002J\b\u0010]\u001a\u00020JH\u0002J\b\u0010^\u001a\u00020JH\u0002J\b\u0010_\u001a\u00020JH\u0002J\f\u0010`\u001a\u00020,*\u00020aH\u0002J\f\u0010b\u001a\u00020J*\u00020JH\u0002J\f\u0010c\u001a\u00020J*\u00020dH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006f"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/g/general/DoraObricGGeneralSettingsFragment;", "Lcom/larus/dora/impl/device/settings/DoraUnbindBaseFragment;", "<init>", "()V", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/device/settings/general/GeneralSettingsViewModel;", "getModel", "()Lcom/larus/dora/impl/device/settings/general/GeneralSettingsViewModel;", "model$delegate", "Lkotlin/Lazy;", "multiDeviceSettingEnabled", "", "getMultiDeviceSettingEnabled", "()Z", "multiDeviceSettingEnabled$delegate", "multiDeviceCard", "Lcom/obric/oui/lisitem/OCardListItem;", "wearSensorCard", "Landroid/view/View;", "rebootButtonCard", "unbindButtonCard", "resetFactoryButtonCard", "multiDeviceSwitch", "Lcom/obric/oui/oswitch/OSwitch;", "wearSensorSwitch", "multiToWearGap", "switchToRebootGap", "rebootToUnbindGap", "unbindToResetGap", "pageMaskView", "wearDetectionUpdateReceiver", "com/larus/dora/obric/device_management/setting/g/general/DoraObricGGeneralSettingsFragment$wearDetectionUpdateReceiver$1", "Lcom/larus/dora/obric/device_management/setting/g/general/DoraObricGGeneralSettingsFragment$wearDetectionUpdateReceiver$1;", "multiDeviceCheckedChangeListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "wearSensorCheckedChangeListener", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "onStart", "onStop", "onDestroyView", "onDoraConnectStateChanged", "isConnected", "getCurrentPageName", "", "getPageMaskView", "buildContentView", "buildTitleBar", "buildScrollContent", "buildSwitchCard", "title", "subtitle", "onSwitchCreated", "Lkotlin/Function1;", "buildActionButtonCard", "text", "destructive", "onClick", "Lkotlin/Function0;", "observeGeneralSettings", "observeUnbindState", "bindGeneralSettings", "state", "Lcom/larus/dora/impl/device/settings/general/GeneralSettingsState$Success;", "multiDeviceTipsResId", "", "productId", "updateMultiDeviceSwitch", "checked", "updateWearSensorSwitch", "updateCardGaps", "openUnbindAndResetPage", "showRebootConfirmDialog", "showUnbindConfirmDialog", "msg", "handleUnbindSuccess", "applySwitchCardStyle", "applyActionButtonCardStyle", "resetCardContainerMargins", "applyCardRadius", "buildSpacer", "heightDp", "resolveBackgroundColor", "resolvePrimaryTextColor", "resolveSecondaryTextColor", "resolvePrimaryColor", "resolveDestructiveTextColor", "applyTitleBarTextStyle", "Landroid/widget/TextView;", "dp", "sp", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricGGeneralSettingsFragment extends DoraUnbindBaseFragment {
    public static final /* synthetic */ int x = 0;
    public final Lazy g;
    public final Lazy h;
    public OCardListItem i;
    public OCardListItem j;
    public OCardListItem k;
    public OCardListItem l;
    public OCardListItem m;
    public OSwitch n;
    public OSwitch o;
    public View p;
    public View q;
    public View r;
    public View s;
    public View t;
    public final DoraObricGGeneralSettingsFragment$wearDetectionUpdateReceiver$1 u;
    public final e v;
    public final f w;

    public static final class a {
    }

    static {
    }

    public final String k() {
        return "general_setting";
    }

    public final void onDestroyView() {
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public final GeneralSettingsViewModel ba0() {
        return (GeneralSettingsViewModel) this.g.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.larus.dora.obric.device_management.setting.g.general.DoraObricGGeneralSettingsFragment$wearDetectionUpdateReceiver$1] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.larus.dora.obric.device_management.setting.g.general.e] */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.larus.dora.obric.device_management.setting.g.general.f] */
    public DoraObricGGeneralSettingsFragment() {
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(GeneralSettingsViewModel.class), new DoraObricGGeneralSettingsFragment$special$$inlined$activityViewModels$default$1(this), new DoraObricGGeneralSettingsFragment$special$$inlined$activityViewModels$default$2(this));
        this.h = LazyKt.lazy(new com.larus.dora.obric.device_management.setting.g.general.a());
        this.u = new DoraObricGGeneralSettingsFragment$wearDetectionUpdateReceiver$1(this);
        this.v = new e(this);
        this.w = new f(this);
    }

    public final void onResume() {
        super.onResume();
        ba0().loadGeneralSettings();
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void onStart() {
        super.onStart();
        LocalBroadcastManager r0 = LocalBroadcastManager.getInstance(requireContext());
        DoraObricGGeneralSettingsFragment$wearDetectionUpdateReceiver$1 r1 = this.u;
        int r2 = com.larus.dora.impl.device.settings.general.a.a;
        r0.registerReceiver(r1, new IntentFilter("com.larus.dora.impl.action.WEAR_DETECTION_CHANGED"));
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void onStop() {
        LocalBroadcastManager.getInstance(requireContext()).unregisterReceiver(this.u);
        super.onStop();
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        return this.t;
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void V90(boolean r1) {
        super.V90(r1);
        if (r1 == false) goto L6;
        ba0().loadGeneralSettings();
        return;
    }

    public final void W90(OCardListItem r4) {
        Iterator r5 = CollectionsKt.listOf(new Drawable[]{r4.getCardContainer().getBackground(), r4.getContentContainer().getBackground()}).iterator();
    L4:
        if (r5.hasNext() == false) goto L12;
        Drawable r0 = (Drawable) r5.next();
        if ((r0 instanceof GradientDrawable) == false) goto L8;
        GradientDrawable r1 = (GradientDrawable) r0;
    L9:
        if (r1 == null) goto L4;
        r1.setCornerRadius(aa0(20));
        goto L4
    L8:
        r1 = null;
        goto L9
    }

    public final View Y90(int r4) {
        View r5 = new View(requireContext());
        r5.setLayoutParams(new LinearLayout.LayoutParams(-1, aa0(16)));
        return r5;
    }

    public final int aa0(int r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public final void ca0(OCardListItem r3) {
        ViewGroup.LayoutParams r0 = r3.getCardContainer().getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
    L6:
        if (r1 == null) goto L9;
        r1.setMarginStart(0);
        r1.setMarginEnd(0);
        r1.leftMargin = 0;
        r1.rightMargin = 0;
        r3.getCardContainer().setLayoutParams(r1);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final int da0(float r3) {
        Resources r0 = getResources();
        return (int) TypedValue.applyDimension(2, r3, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()));
    }

    @Override // com.larus.dora.impl.device.settings.DoraUnbindBaseFragment
    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        Lifecycle.State r10 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricGGeneralSettingsFragment$observeGeneralSettings$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r10, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricGGeneralSettingsFragment$observeUnbindState$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r10, null, this), 3, null);
    }

    public final OCardListItem X90(String r6, boolean r7, final Function0<Unit> r8) {
        ConstraintLayout.LayoutParams r2 = null;
        OCardListItem r0 = new OCardListItem(requireContext(), null, 6, 0);
        r0.setCardType(0);
        OCardListItem.h(r0, 0);
        r0.setShowCardBg(true);
        r0.p(false);
        r0.setTitle(r6);
        r0.s(true);
        r0.q(false);
        r0.m(false);
        r0.r(false);
        r0.o(false);
        if (r7 == false) goto L5;
        int r9 = ContextCompat.getColor(requireContext(), 2131104979);
    L6:
        r0.l(r9, r9);
        r0.setOnContentClickListener(new b(r8));
        ca0(r0);
        r0.getCardContainer().setPadding(aa0(8), aa0(8), aa0(8), aa0(8));
        r0.getContentContainer().setPadding(0, 0, 0, 0);
        LinearLayout r10 = r0.getTitleContainer();
        r10.setGravity(17);
        r10.setPadding(aa0(16), 0, aa0(16), 0);
        ConstraintLayout.LayoutParams r11 = r10.getLayoutParams();
        if ((r11 instanceof ConstraintLayout.LayoutParams) == false) goto L9;
        r2 = r11;
    L9:
        if (r2 == null) goto L11;
        ((ViewGroup.MarginLayoutParams) r2).width = 0;
        r2.t = 0;
        r2.v = 0;
        r2.s = -1;
        r2.u = -1;
        r2.E = 0.5f;
        r10.setLayoutParams(r2);
    L11:
        OTextView r12 = r0.getTitleView();
        r12.setGravity(17);
        r12.setIncludeFontPadding(false);
        r12.setTextSize(2, 16.0f);
        TextViewCompat.setLineHeight(r12, da0(22.0f));
        r12.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 500, false));
        r0.o(false);
        W90(r0);
        return r0;
    L5:
        r9 = v19.c.a(2130972123, requireContext(), 2131103203);
        goto L6
    }

    public final OCardListItem Z90(String r8, String r9, Function1<? super OSwitch, Unit> r10) {
        ViewGroup.MarginLayoutParams r2 = null;
        OCardListItem r0 = new OCardListItem(requireContext(), null, 6, 0);
        r0.setCardType(0);
        OCardListItem.h(r0, 0);
        r0.setShowCardBg(true);
        r0.p(false);
        r0.setTitle(r8);
        r0.s(true);
        r0.setSubTitle(r9);
        r0.getSubTitleView().setMaxLines(5);
        r0.q(true);
        r0.setDefaultCustomEndView(1);
        r0.m(true);
        r0.r(false);
        OSwitch r11 = r0.getEndSwitch();
        if (r11 == null) goto L5;
        r10.invoke(r11);
    L5:
        ca0(r0);
        r0.getCardContainer().setPadding(aa0(8), aa0(8), aa0(8), aa0(8));
        r0.getContentContainer().setPadding(0, 0, aa0(4), 0);
        r0.getTitleContainer().setGravity(16);
        r0.getTitleContainer().setPadding(aa0(12), aa0(10), aa0(8), aa0(10));
        OTextView r12 = r0.getTitleView();
        r12.setGravity(8388611);
        r12.setMaxLines(1);
        r12.setTextColor(v19.c.a(2130972079, requireContext(), 2131103136));
        r12.setTextSize(2, 16.0f);
        TextViewCompat.setLineHeight(r12, da0(22.0f));
        r12.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 400, false));
        OTextView r13 = r0.getSubTitleView();
        r13.setTextColor(ContextCompat.getColor(requireContext(), 2131104359));
        r13.setTextSize(2, 12.0f);
        TextViewCompat.setLineHeight(r13, da0(16.0f));
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if ((r14 instanceof ViewGroup.MarginLayoutParams) == false) goto L8;
        r2 = (ViewGroup.MarginLayoutParams) r14;
    L8:
        if (r2 == null) goto L10;
        r2.topMargin = aa0(2);
        r13.setLayoutParams(r2);
    L10:
        r0.o(false);
        W90(r0);
        return r0;
    }

    public final View onCreateView(LayoutInflater r12, ViewGroup r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r12, "inflater");
        Context r15 = requireContext();
        OFloatingTitleBar r16 = new OFloatingTitleBar(requireContext(), null, 6, 0);
        r16.setClipChildren(false);
        r16.setClipToPadding(false);
        r16.setBackgroundColor(v19.c.a(2130970531, requireContext(), 2131102535));
        r16.setCenterTitle(getString(2131902422));
        r16.setCenterTitleColor(v19.c.a(2130972079, requireContext(), 2131103136));
        TextView r17 = (TextView) r16.findViewById(2131365427);
        if (r17 == null) goto L5;
        r17.setTextColor(v19.c.a(2130972079, requireContext(), 2131103136));
        r17.setTextSize(2, 16.0f);
        TextViewCompat.setLineHeight(r17, da0(22.0f));
        r17.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 600, false));
    L5:
        r16.R(false);
        OFloatingTitleBar.k(r16, null, 6).setOnClickListener(new m(this));
        Context r18 = requireContext();
        LinearLayout r0 = new LinearLayout(r18);
        r0.setOrientation(1);
        r0.setClipChildren(false);
        r0.setClipToPadding(false);
        r0.setPadding(aa0(12), aa0(16), aa0(12), aa0(24));
        if (((Boolean) this.h.getValue()).booleanValue() == false) goto L8;
        OCardListItem r5 = Z90(getString(2131903507), getString(2131902766), new j(this));
        r0.addView(r5);
        this.i = r5;
        View r6 = Y90(16);
        r0.addView(r6);
        this.p = r6;
    L8:
        OCardListItem r7 = Z90(getString(2131902697), getString(2131902987), new k(this));
        r0.addView(r7);
        this.j = r7;
        View r8 = Y90(16);
        r0.addView(r8);
        this.q = r8;
        OCardListItem r9 = X90(getString(2131902673), false, new DoraObricGGeneralSettingsFragment$buildScrollContent$contentContainer$1$7(this));
        r0.addView(r9);
        this.k = r9;
        View r10 = Y90(16);
        r0.addView(r10);
        this.r = r10;
        OCardListItem r11 = X90(getString(2131902982), false, new l(this));
        r0.addView(r11);
        this.l = r11;
        View r20 = Y90(16);
        r0.addView(r20);
        this.s = r20;
        OCardListItem r21 = X90(getString(2131902947), true, new DoraObricGGeneralSettingsFragment$buildScrollContent$contentContainer$1$13(this));
        r0.addView(r21);
        this.m = r21;
        NestedScrollView r22 = new NestedScrollView(r18);
        r22.setClipChildren(true);
        r22.setClipToPadding(false);
        r22.setOverScrollMode(2);
        r22.setFillViewport(true);
        r22.addView(r0, new ViewGroup.LayoutParams(-1, -2));
        return com.larus.dora.obric.utils.c.c(r15, r16, r22, v19.c.a(2130970531, requireContext(), 2131102535), new g(this));
    }
}
