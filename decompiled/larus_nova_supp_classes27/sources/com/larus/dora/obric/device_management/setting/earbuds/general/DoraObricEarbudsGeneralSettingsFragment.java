package com.larus.dora.obric.device_management.setting.earbuds.general;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.device.settings.general.GeneralSettingsViewModel;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 ^2\u00020\u0001:\u0001^B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010#\u001a\u00020!H\u0016J\b\u0010$\u001a\u00020!H\u0016J\u0010\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020\u0018H\u0016J\b\u0010'\u001a\u00020(H\u0016J\n\u0010)\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010*\u001a\u00020\u000bH\u0002J\b\u0010+\u001a\u00020\u000bH\u0002J\b\u0010,\u001a\u00020\u000bH\u0002J(\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020(2\b\b\u0002\u0010/\u001a\u0002002\f\u00101\u001a\b\u0012\u0004\u0012\u00020!02H\u0002J\b\u00103\u001a\u00020\u000bH\u0002J\b\u00104\u001a\u00020\u0010H\u0002J\u0010\u00105\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020(H\u0002J\u0010\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020(H\u0002J4\u00108\u001a\u00020\u00102\u0006\u0010.\u001a\u00020(2\u0006\u00109\u001a\u00020\u00182\b\b\u0002\u0010/\u001a\u0002002\u0010\b\u0002\u00101\u001a\n\u0012\u0004\u0012\u00020!\u0018\u000102H\u0002J\b\u0010:\u001a\u00020!H\u0002J\u0010\u0010;\u001a\u00020!2\u0006\u0010<\u001a\u00020=H\u0002J\b\u0010>\u001a\u00020!H\u0002J\u0010\u0010?\u001a\u00020!2\u0006\u0010<\u001a\u00020=H\u0002J\u0010\u0010@\u001a\u00020!2\u0006\u0010A\u001a\u00020(H\u0002J\b\u0010B\u001a\u00020!H\u0002J\b\u0010C\u001a\u00020!H\u0002J\b\u0010D\u001a\u00020!H\u0002J\n\u0010E\u001a\u0004\u0018\u00010FH\u0002J\f\u0010G\u001a\u00020!*\u00020\u0010H\u0002J\f\u0010H\u001a\u00020!*\u00020\u0010H\u0002J\f\u0010I\u001a\u00020!*\u00020\u0010H\u0002J\u0014\u0010J\u001a\u00020!*\u00020K2\u0006\u0010L\u001a\u00020\u0018H\u0002J\b\u0010M\u001a\u00020NH\u0002J\b\u0010O\u001a\u000200H\u0002J\b\u0010P\u001a\u000200H\u0002J\b\u0010Q\u001a\u000200H\u0002J\b\u0010R\u001a\u000200H\u0002J\f\u0010S\u001a\u00020!*\u00020TH\u0002J\f\u0010U\u001a\u00020!*\u00020TH\u0002J\f\u0010V\u001a\u00020!*\u00020TH\u0002J\u0010\u0010W\u001a\u00020!2\u0006\u0010X\u001a\u00020\u000bH\u0002J\u0010\u0010Y\u001a\u00020\u000b2\u0006\u0010Z\u001a\u000200H\u0002J\f\u0010[\u001a\u000200*\u000200H\u0002J\f\u0010\\\u001a\u000200*\u00020]H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006_"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/earbuds/general/DoraObricEarbudsGeneralSettingsFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/device/settings/general/GeneralSettingsViewModel;", "getModel", "()Lcom/larus/dora/impl/device/settings/general/GeneralSettingsViewModel;", "model$delegate", "Lkotlin/Lazy;", "multiDeviceSection", "Landroid/view/View;", "multiDeviceSpacer", "multiDeviceSwitch", "Lcom/obric/oui/oswitch/OSwitch;", "deviceNameItem", "Lcom/obric/oui/lisitem/OCardListItem;", "deviceNameSpacer", "versionItem", "caseVersionItem", "snItem", "unbindItem", "pageMaskView", "hasUploadedCopySn", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "onDestroyView", "onDoraConnectStateChanged", "isConnected", "getCurrentPageName", "", "getPageMaskView", "buildContentView", "buildTitleBar", "buildScrollContent", "buildDangerButtonItem", "title", "position", "", "onClick", "Lkotlin/Function0;", "buildMultiDeviceSection", "buildMultiDeviceSwitchCard", "buildSectionTitle", "buildSupportiveText", "text", "buildInfoItem", "showArrow", "observeGeneralSettings", "bindMultiDeviceSwitch", "state", "Lcom/larus/dora/impl/device/settings/general/GeneralSettingsState$Success;", "observeUnbindState", "bindDeviceInfo", "bindSnText", "sn", "openOtaPage", "copySn", "showUnbindConfirmDialog", "currentDevice", "Lcom/bytedance/dora/device/DoraDevice;", "applyCardStyle", "applyDangerTextStyle", "resetCardContainerMargins", "applyValueTextStyle", "Lcom/obric/oui/text/OTextView;", "showRedDot", "buildRedDotDrawable", "Landroid/graphics/drawable/GradientDrawable;", "resolveBackgroundColor", "resolvePrimaryTextColor", "resolveSecondaryTextColor", "resolveRedDotColor", "applyTitleBarTextStyle", "Landroid/widget/TextView;", "applySectionTitleTextStyle", "applySupportiveTextStyle", "relaxClipForShadow", "target", "buildSpacer", "heightDp", "dp", "sp", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricEarbudsGeneralSettingsFragment extends DoraBaseFragment {
    public static final /* synthetic */ int p = 0;
    public final Lazy f;
    public View g;
    public View h;
    public OSwitch i;
    public OCardListItem j;
    public View k;
    public OCardListItem l;
    public OCardListItem m;
    public View n;
    public boolean o;

    public static final class a {
    }

    static {
    }

    public final String k() {
        return "general_setting";
    }

    public final void onDestroyView() {
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.h = null;
        this.n = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public final GeneralSettingsViewModel ca0() {
        return (GeneralSettingsViewModel) this.f.getValue();
    }

    public DoraObricEarbudsGeneralSettingsFragment() {
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(GeneralSettingsViewModel.class), new DoraObricEarbudsGeneralSettingsFragment$special$$inlined$activityViewModels$default$1(this), new DoraObricEarbudsGeneralSettingsFragment$special$$inlined$activityViewModels$default$2(this));
    }

    public final void onResume() {
        super.onResume();
        ca0().loadGeneralSettings();
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        return this.n;
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void V90(boolean r1) {
        super.V90(r1);
        if (r1 == false) goto L6;
        ca0().loadGeneralSettings();
        return;
    }

    public final void W90(OCardListItem r7) {
        ViewGroup.LayoutParams r0 = r7.getCardContainer().getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
    L7:
        if (r1 == null) goto L9;
        r1.setMarginStart(0);
        r1.setMarginEnd(0);
        r1.leftMargin = 0;
        r1.rightMargin = 0;
        r7.getCardContainer().setLayoutParams(r1);
    L9:
        r7.getContentContainer().setPadding(0, 0, ba0(4), 0);
        r7.getTitleContainer().setGravity(16);
        r7.getTitleContainer().setPadding(ba0(12), ba0(8), ba0(8), ba0(8));
        OTextView r2 = r7.getTitleView();
        r2.setGravity(8388611);
        r2.setMaxLines(1);
        r2.setTextColor(v19.c.a(2130972079, requireContext(), 2131103136));
        r2.setTextSize(2, 16.0f);
        TextViewCompat.setLineHeight(r2, da0(22.0f));
        r2.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 400, false));
        r7.o(false);
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final View Z90(String r8) {
        OSectionTitleBar r0 = new OSectionTitleBar(requireContext(), null, 6, 0);
        LinearLayout r1 = (LinearLayout) r0.findViewById(2131367728);
        if (r1 == null) goto L5;
        r1.setPadding(ba0(20), ba0(8), ba0(12), ba0(8));
    L5:
        r0.setTitleText(r8);
        r0.setTitleTextSize(12.0f);
        r0.setTitleTextColor(ContextCompat.getColor(requireContext(), 2131104359));
        TextView r2 = (TextView) r0.findViewById(2131388792);
        if (r2 == null) goto L8;
        r2.setTextColor(ContextCompat.getColor(requireContext(), 2131104359));
        r2.setTextSize(2, 12.0f);
        TextViewCompat.setLineHeight(r2, da0(16.0f));
        r2.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 500, false));
    L8:
        r0.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return r0;
    }

    public final View aa0(int r4) {
        View r5 = new View(requireContext());
        r5.setLayoutParams(new LinearLayout.LayoutParams(-1, ba0(16)));
        return r5;
    }

    public final int ba0(int r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public final int da0(float r3) {
        Resources r0 = getResources();
        return (int) TypedValue.applyDimension(2, r3, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()));
    }

    public final void X90(OTextView r5, boolean r6) {
        r5.setTextColor(ContextCompat.getColor(requireContext(), 2131104359));
        r5.setTextSize(2, 14.0f);
        TextViewCompat.setLineHeight(r5, da0(18.0f));
        r5.setSingleLine(true);
        r5.setMaxLines(1);
        r5.setEllipsize(TextUtils.TruncateAt.END);
        r5.setCompoundDrawablePadding(ba0(4));
        if (r6 == false) goto L5;
        int r7 = ba0(6);
        GradientDrawable r2 = new GradientDrawable();
        r2.setShape(1);
        r2.setColor(ContextCompat.getColor(requireContext(), 2131104979));
        r2.setSize(r7, r7);
        r2.setBounds(0, 0, r7, r7);
    L6:
        r5.setCompoundDrawables(null, null, r2, null);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r8, r9);
        Lifecycle.State r10 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricEarbudsGeneralSettingsFragment$observeGeneralSettings$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r10, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricEarbudsGeneralSettingsFragment$observeUnbindState$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r10, null, this), 3, null);
    }

    public final View onCreateView(LayoutInflater r17, ViewGroup r18, Bundle r110) {
        Intrinsics.checkNotNullParameter(r17, "inflater");
        Context r1 = requireContext();
        LinearLayout r2 = new LinearLayout(r1);
        r2.setOrientation(1);
        r2.setClipChildren(true);
        r2.setClipToPadding(true);
        r2.setBackgroundColor(v19.c.a(2130970531, requireContext(), 2131102535));
        ConstraintLayout.LayoutParams r8 = null;
        OFloatingTitleBar r4 = new OFloatingTitleBar(requireContext(), null, 6, 0);
        com.larus.dora.obric.utils.c.a(r4);
        r4.setBackgroundColor(v19.c.a(2130970531, requireContext(), 2131102535));
        r4.setCenterTitle(getString(2131902422));
        r4.setCenterTitleColor(v19.c.a(2130972079, requireContext(), 2131103136));
        TextView r7 = (TextView) r4.findViewById(2131365427);
        if (r7 == null) goto L5;
        r7.setTextColor(v19.c.a(2130972079, requireContext(), 2131103136));
        r7.setTextSize(2, 16.0f);
        TextViewCompat.setLineHeight(r7, da0(22.0f));
        r7.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 600, false));
    L5:
        r4.R(false);
        final View r5 = OFloatingTitleBar.k(r4, null, 6);
        r5.setOnClickListener(new g(this));
        r4.post(new h(this, r5));
        r2.addView(r4, new LinearLayout.LayoutParams(-1, -2));
        Context r6 = requireContext();
        LinearLayout r9 = new LinearLayout(r6);
        r9.setOrientation(1);
        r9.setClipChildren(false);
        r9.setClipToPadding(false);
        r9.setPadding(ba0(12), 0, ba0(12), ba0(16));
        LinearLayout r10 = new LinearLayout(requireContext());
        r10.setOrientation(1);
        r10.setClipChildren(false);
        r10.setClipToPadding(false);
        r10.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r10.addView(Z90(getString(2131902425)));
        final View r12 = new OCardListItem(requireContext(), null, 6, 0);
        r12.setCardType(0);
        OCardListItem.h(r12, 0);
        r12.setShowCardBg(true);
        r12.p(false);
        r12.setTitle(getString(2131903372));
        r12.s(true);
        r12.q(false);
        r12.setDefaultCustomEndView(1);
        r12.m(true);
        r12.r(false);
        OSwitch r15 = r12.getEndSwitch();
        if (r15 == null) goto L8;
        this.i = r15;
    L8:
        r12.setOnContentClickListener(new com.larus.dora.obric.device_management.setting.earbuds.general.a(r12));
        W90(r12);
        r10.addView(r12);
        String r13 = getString(2131903373);
        OSectionSupportiveText r16 = new OSectionSupportiveText(requireContext(), null, 6, 0);
        r16.setPadding(ba0(20), 0, ba0(20), 0);
        r16.setSectionDes(r13);
        TextView r3 = (TextView) r16.findViewById(2131385718);
        if (r3 == null) goto L11;
        r3.setTextColor(ContextCompat.getColor(requireContext(), 2131104359));
        r3.setTextSize(2, 12.0f);
        TextViewCompat.setLineHeight(r3, da0(16.0f));
        r3.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 400, false));
    L11:
        r16.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r10.addView(r16);
        r9.addView(r10);
        this.g = r10;
        View r11 = aa0(16);
        r9.addView(r11);
        this.h = r11;
        View r14 = Y90(getString(2131902445), false, 0, null);
        r9.addView(r14);
        this.j = r14;
        View r20 = aa0(16);
        r9.addView(r20);
        this.k = r20;
        r9.addView(Z90(getString(2131903494)));
        LinearLayout r21 = new LinearLayout(r6);
        r21.setOrientation(1);
        r21.setClipChildren(false);
        r21.setClipToPadding(false);
        OCardListItem r22 = Y90(getString(2131903495), true, 1, new DoraObricEarbudsGeneralSettingsFragment$buildScrollContent$contentContainer$1$basicInfoGroup$1$1(this));
        this.l = r22;
        r21.addView(r22);
        OCardListItem r23 = Y90(getString(2131902452), false, 3, new DoraObricEarbudsGeneralSettingsFragment$buildScrollContent$contentContainer$1$basicInfoGroup$1$2(this));
        this.m = r23;
        r21.addView(r23);
        r9.addView(r21);
        r9.addView(aa0(16));
        String r24 = getString(2131902350);
        final DoraObricEarbudsGeneralSettingsFragment$buildScrollContent$contentContainer$1$5 r25 = new DoraObricEarbudsGeneralSettingsFragment$buildScrollContent$contentContainer$1$5(this);
        final View r26 = new OCardListItem(requireContext(), null, 6, 0);
        r26.setCardType(0);
        OCardListItem.h(r26, 0);
        r26.setShowCardBg(true);
        r26.p(false);
        r26.setTitle(r24);
        r26.s(true);
        r26.q(false);
        r26.m(false);
        r26.r(false);
        W90(r26);
        LinearLayout r27 = r26.getTitleContainer();
        r27.setGravity(17);
        r27.setPadding(0, ba0(8), 0, ba0(8));
        ConstraintLayout.LayoutParams r111 = r27.getLayoutParams();
        if ((r111 instanceof ConstraintLayout.LayoutParams) == false) goto L14;
        r8 = r111;
    L14:
        if (r8 == null) goto L16;
        ((ViewGroup.MarginLayoutParams) r8).width = 0;
        r8.t = 0;
        r8.v = 0;
        r8.s = -1;
        r8.u = -1;
        r8.E = 0.5f;
        r27.setLayoutParams(r8);
    L16:
        OTextView r28 = r26.getTitleView();
        r28.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r28.setTextColor(ContextCompat.getColor(r28.getContext(), 2131102625));
        r28.setGravity(17);
        r26.setOnContentClickListener(new i(r26, r25));
        r9.addView(r26);
        NestedScrollView r30 = new NestedScrollView(r6);
        r30.setClipChildren(false);
        r30.setClipToPadding(false);
        r30.setOverScrollMode(2);
        r30.setFillViewport(true);
        r30.setPadding(0, ba0(16), 0, 0);
        r30.addView(r9, new ViewGroup.LayoutParams(-1, -2));
        r2.addView(r30, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        FrameLayout r31 = new FrameLayout(r1);
        r31.setBackgroundColor(v19.c.a(2130970531, requireContext(), 2131102535));
        r31.addView(r2, new FrameLayout.LayoutParams(-1, -1));
        View r32 = new View(r1);
        r32.setBackgroundColor(ContextCompat.getColor(r1, 2131103066));
        r32.setClickable(true);
        r32.setFocusable(true);
        r31.addView(r32, new FrameLayout.LayoutParams(-1, -1));
        this.n = r32;
        return r31;
    }

    public final OCardListItem Y90(String r6, boolean r7, int r8, final Function0<Unit> r9) {
        final OCardListItem r0 = new OCardListItem(requireContext(), null, 6, 0);
        r0.setCardType(0);
        OCardListItem.h(r0, r8);
        r0.setShowCardBg(true);
        r0.p(false);
        r0.setTitle(r6);
        r0.s(true);
        r0.q(false);
        r0.setDefaultCustomEndView(3);
        r0.m(true);
        r0.k("", ba0(140));
        OTextView r10 = r0.getEndDetail();
        if (r10 == null) goto L5;
        X90(r10, false);
    L5:
        if (r7 == false) goto L7;
        r0.setDefaultTailIcon(0);
        r0.r(true);
    L8:
        W90(r0);
        if (r9 == null) goto L11;
        r0.setOnContentClickListener(new b(r0, r9));
    L11:
        return r0;
    L7:
        r0.r(false);
        goto L8
    }
}
