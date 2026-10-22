package com.larus.dora.obric.device_management.setting.g.device_info;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
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
import com.larus.dora.impl.device.settings.DoraUnbindBaseFragment;
import com.larus.dora.impl.device.settings.general.GeneralSettingsViewModel;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.lisitem.OCardListItem;
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
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 J2\u00020\u0001:\u0001JB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0019H\u0016J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u0010H\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\n\u0010!\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\"\u001a\u00020\u000eH\u0002J\b\u0010#\u001a\u00020\u000eH\u0002J\b\u0010$\u001a\u00020\u000eH\u0002J.\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00102\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00190+H\u0002J\b\u0010,\u001a\u00020\u0019H\u0002J\u0010\u0010-\u001a\u00020\u00192\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020\u00192\u0006\u00101\u001a\u00020 H\u0002J\b\u00102\u001a\u00020\u0019H\u0002J\b\u00103\u001a\u00020\u0019H\u0002J\n\u00104\u001a\u0004\u0018\u000105H\u0002J\f\u00106\u001a\u00020\u0019*\u00020\u000bH\u0002J\u0010\u00107\u001a\u00020(2\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u00108\u001a\u00020(2\u0006\u0010'\u001a\u00020(H\u0002J\f\u00109\u001a\u00020\u0019*\u00020\u000bH\u0002J\u0014\u0010:\u001a\u00020\u0019*\u00020;2\u0006\u0010<\u001a\u00020\u0010H\u0002J\b\u0010=\u001a\u00020>H\u0002J\u001c\u0010?\u001a\u00020\u0019*\u00020>2\u0006\u0010'\u001a\u00020(2\u0006\u0010@\u001a\u00020(H\u0002J\b\u0010A\u001a\u00020(H\u0002J\b\u0010B\u001a\u00020(H\u0002J\b\u0010C\u001a\u00020(H\u0002J\b\u0010D\u001a\u00020(H\u0002J\f\u0010E\u001a\u00020\u0019*\u00020FH\u0002J\f\u0010G\u001a\u00020(*\u00020(H\u0002J\f\u0010H\u001a\u00020(*\u00020IH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/g/device_info/DoraObricGDeviceInfoFragment;", "Lcom/larus/dora/impl/device/settings/DoraUnbindBaseFragment;", "<init>", "()V", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/device/settings/general/GeneralSettingsViewModel;", "getModel", "()Lcom/larus/dora/impl/device/settings/general/GeneralSettingsViewModel;", "model$delegate", "Lkotlin/Lazy;", "versionItem", "Lcom/obric/oui/lisitem/OCardListItem;", "snItem", "pageMaskView", "Landroid/view/View;", "hasUploadedCopySn", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "onDestroyView", "onDoraConnectStateChanged", "isConnected", "getCurrentPageName", "", "getPageMaskView", "buildContentView", "buildTitleBar", "buildScrollContent", "buildInfoItem", "title", "position", "", "showArrow", "onClick", "Lkotlin/Function0;", "observeGeneralSettings", "bindDeviceInfo", "state", "Lcom/larus/dora/impl/device/settings/general/GeneralSettingsState$Success;", "bindSnText", "sn", "openOtaPage", "copySn", "currentDevice", "Lcom/bytedance/dora/device/DoraDevice;", "applyInfoCardStyle", "sectionTopPadding", "sectionBottomPadding", "resetCardContainerMargins", "applyValueTextStyle", "Lcom/obric/oui/text/OTextView;", "showRedDot", "buildRedDotDrawable", "Landroid/graphics/drawable/GradientDrawable;", "applySectionCornerRadii", "radiusDp", "resolveBackgroundColor", "resolvePrimaryTextColor", "resolveSecondaryTextColor", "resolveRedDotColor", "applyTitleBarTextStyle", "Landroid/widget/TextView;", "dp", "sp", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricGDeviceInfoFragment extends DoraUnbindBaseFragment {
    public static final /* synthetic */ int l = 0;
    public final Lazy g;
    public OCardListItem h;
    public OCardListItem i;
    public View j;
    public boolean k;

    public static final class a {
    }

    static {
    }

    public final String k() {
        return "general_setting";
    }

    public final void onDestroyView() {
        this.h = null;
        this.i = null;
        this.j = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public DoraObricGDeviceInfoFragment() {
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(GeneralSettingsViewModel.class), new DoraObricGDeviceInfoFragment$special$$inlined$activityViewModels$default$1(this), new DoraObricGDeviceInfoFragment$special$$inlined$activityViewModels$default$2(this));
    }

    public final void onResume() {
        super.onResume();
        ((GeneralSettingsViewModel) this.g.getValue()).loadGeneralSettings();
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        return this.j;
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void V90(boolean r1) {
        super.V90(r1);
        if (r1 == false) goto L6;
        ((GeneralSettingsViewModel) this.g.getValue()).loadGeneralSettings();
        return;
    }

    public final int Z90(int r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public final void X90(OTextView r5, boolean r6) {
        r5.setTextColor(ContextCompat.getColor(requireContext(), 2131104359));
        r5.setTextSize(2, 14.0f);
        Resources r0 = getResources();
        TextViewCompat.setLineHeight(r5, (int) TypedValue.applyDimension(2, 18.0f, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics())));
        r5.setSingleLine(true);
        r5.setMaxLines(1);
        r5.setEllipsize(TextUtils.TruncateAt.END);
        r5.setCompoundDrawablePadding(Z90(4));
        if (r6 == false) goto L5;
        int r7 = Z90(6);
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

    @Override // com.larus.dora.impl.device.settings.DoraUnbindBaseFragment
    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super.onViewCreated(r7, r8);
        Lifecycle.State r9 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricGDeviceInfoFragment$observeGeneralSettings$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r9, null, this), 3, null);
    }

    public final void W90(GradientDrawable r11, int r12, int r13) {
        float r14 = Z90(r13);
        if (r12 != 0) goto L5;
        float[] r15 = {r14, r14, r14, r14, r14, r14, r14, r14};
    L11:
        r11.setCornerRadii(r15);
        return;
    L5:
        if (r12 == 1) goto L9;
        if (r12 == 3) goto L8;
        r15 = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        goto L11
    L8:
        r15 = new float[]{0.0f, 0.0f, 0.0f, 0.0f, r14, r14, r14, r14};
        goto L11
    L9:
        r15 = new float[]{r14, r14, r14, r14, 0.0f, 0.0f, 0.0f, 0.0f};
        goto L11
    }

    public final View onCreateView(LayoutInflater r11, ViewGroup r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r11, "inflater");
        Context r14 = requireContext();
        OFloatingTitleBar r15 = new OFloatingTitleBar(requireContext(), null, 6, 0);
        r15.setClipChildren(false);
        r15.setClipToPadding(false);
        r15.setBackgroundColor(v19.c.a(2130970531, requireContext(), 2131102535));
        r15.setCenterTitle(getString(2131903630));
        r15.setCenterTitleColor(v19.c.a(2130972079, requireContext(), 2131103136));
        TextView r16 = (TextView) r15.findViewById(2131365427);
        if (r16 == null) goto L5;
        r16.setTextColor(v19.c.a(2130972079, requireContext(), 2131103136));
        r16.setTextSize(2, 16.0f);
        Resources r5 = getResources();
        TextViewCompat.setLineHeight(r16, (int) TypedValue.applyDimension(2, 22.0f, WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics())));
        r16.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 600, false));
    L5:
        r15.R(false);
        OFloatingTitleBar.k(r15, null, 6).setOnClickListener(new c(this));
        Context r17 = requireContext();
        LinearLayout r0 = new LinearLayout(r17);
        r0.setOrientation(1);
        r0.setClipChildren(false);
        r0.setClipToPadding(false);
        r0.setPadding(Z90(12), Z90(16), Z90(12), Z90(24));
        OCardListItem r6 = Y90(getString(2131902649), 1, true, new DoraObricGDeviceInfoFragment$buildScrollContent$contentContainer$1$1(this));
        r0.addView(r6);
        this.h = r6;
        OCardListItem r7 = Y90(getString(2131902648), 3, false, new DoraObricGDeviceInfoFragment$buildScrollContent$contentContainer$1$3(this));
        r0.addView(r7);
        this.i = r7;
        NestedScrollView r8 = new NestedScrollView(r17);
        r8.setClipChildren(true);
        r8.setClipToPadding(false);
        r8.setOverScrollMode(2);
        r8.setFillViewport(true);
        r8.addView(r0, new ViewGroup.LayoutParams(-1, -2));
        return com.larus.dora.obric.utils.c.c(r14, r15, r8, v19.c.a(2130970531, requireContext(), 2131102535), new b(this));
    }

    public final OCardListItem Y90(String r8, int r9, boolean r10, final Function0<Unit> r11) {
        GradientDrawable r2 = null;
        OCardListItem r0 = new OCardListItem(requireContext(), null, 6, 0);
        r0.setCardType(0);
        OCardListItem.h(r0, r9);
        r0.setShowCardBg(true);
        r0.p(false);
        r0.setTitle(r8);
        r0.s(true);
        r0.q(false);
        r0.setDefaultCustomEndView(3);
        r0.m(true);
        r0.k("", Z90(140));
        OTextView r1 = r0.getEndDetail();
        if (r1 == null) goto L5;
        X90(r1, false);
    L5:
        if (r10 == false) goto L7;
        r0.setDefaultTailIcon(0);
        r0.r(true);
    L8:
        r0.setOnContentClickListener(new d(r11));
        int r12 = r0.getCardPosition();
        ViewGroup.LayoutParams r13 = r0.getCardContainer().getLayoutParams();
        if ((r13 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        ViewGroup.MarginLayoutParams r14 = (ViewGroup.MarginLayoutParams) r13;
    L12:
        if (r14 == null) goto L14;
        r14.setMarginStart(0);
        r14.setMarginEnd(0);
        r14.leftMargin = 0;
        r14.rightMargin = 0;
        r0.getCardContainer().setLayoutParams(r14);
    L14:
        FrameLayout r15 = r0.getCardContainer();
        int r3 = Z90(8);
        if (r12 == 0) goto L18;
        if (r12 == 1) goto L18;
        int r5 = 0;
    L19:
        int r6 = Z90(8);
        if (r12 == 0) goto L23;
        if (r12 == 3) goto L23;
        int r16 = 0;
    L24:
        r15.setPadding(r3, r5, r6, r16);
        r0.getContentContainer().setPadding(0, 0, Z90(4), 0);
        r0.getTitleContainer().setGravity(16);
        r0.getTitleContainer().setPadding(Z90(12), Z90(8), Z90(8), Z90(8));
        OTextView r17 = r0.getTitleView();
        r17.setGravity(8388611);
        r17.setMaxLines(1);
        r17.setTextColor(v19.c.a(2130972079, requireContext(), 2131103136));
        r17.setTextSize(2, 16.0f);
        Resources r18 = getResources();
        TextViewCompat.setLineHeight(r17, (int) TypedValue.applyDimension(2, 22.0f, WindowDisplayMetricsOverride.apply(r18, r18.getDisplayMetrics())));
        r17.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 400, false));
        r0.o(false);
        Drawable r20 = r0.getCardContainer().getBackground();
        if ((r20 instanceof GradientDrawable) == false) goto L27;
        GradientDrawable r21 = (GradientDrawable) r20;
    L28:
        if (r21 == null) goto L30;
        W90(r21, r12, 20);
    L30:
        Drawable r22 = r0.getContentContainer().getBackground();
        if ((r22 instanceof GradientDrawable) == false) goto L33;
        r2 = (GradientDrawable) r22;
    L33:
        if (r2 == null) goto L35;
        W90(r2, r12, 12);
    L35:
        return r0;
    L27:
        r21 = null;
    L23:
        r16 = Z90(8);
    L18:
        r5 = Z90(8);
        goto L19
    L11:
        r14 = null;
        goto L12
    L7:
        r0.r(false);
        goto L8
    }
}
