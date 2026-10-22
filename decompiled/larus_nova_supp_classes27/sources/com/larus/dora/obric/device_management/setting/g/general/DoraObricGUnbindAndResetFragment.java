package com.larus.dora.obric.device_management.setting.g.general;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
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
import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.annotation.DoraScene;
import com.larus.dora.impl.core.DoraSceneManager;
import com.larus.dora.impl.device.settings.DoraUnbindBaseFragment;
import com.larus.dora.impl.device.settings.unbind.DoraUnbindViewModel;
import com.larus.dora.impl.ota.DoraOTAManager;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.dora.obric.utils.DoraObricToastUtils;
import com.larus.utils.e1;
import com.larus.utils.j0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.v2.alert.style.ButtonStyleController;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 <2\u00020\u0001:\u0001<B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u001a\u001a\u00020\u000bH\u0002J\b\u0010\u001b\u001a\u00020\u000bH\u0002J\b\u0010\u001c\u001a\u00020\u000bH\u0002J\b\u0010\u001d\u001a\u00020\u000bH\u0002J\b\u0010\u001e\u001a\u00020\u000bH\u0002J\u0018\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\u0014H\u0002J\b\u0010&\u001a\u00020\u0014H\u0002J\b\u0010'\u001a\u00020\u0014H\u0002J\b\u0010(\u001a\u00020\u0014H\u0002J\b\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020*H\u0002J\b\u0010,\u001a\u00020*H\u0002J\b\u0010-\u001a\u00020*H\u0002J\b\u0010.\u001a\u00020*H\u0002J\b\u0010/\u001a\u00020*H\u0002J\u0018\u00100\u001a\u0002012\u0006\u00102\u001a\u00020*2\u0006\u00103\u001a\u00020*H\u0002J\f\u00104\u001a\u00020\u0014*\u00020$H\u0002J\f\u00105\u001a\u00020\u0014*\u00020$H\u0002J\f\u00106\u001a\u00020\u0014*\u00020$H\u0002J\f\u00107\u001a\u00020\u0014*\u000208H\u0002J\f\u00109\u001a\u00020**\u00020*H\u0002J\f\u0010:\u001a\u00020**\u00020;H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/larus/dora/obric/device_management/setting/g/general/DoraObricGUnbindAndResetFragment;", "Lcom/larus/dora/impl/device/settings/DoraUnbindBaseFragment;", "<init>", "()V", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/device/settings/unbind/DoraUnbindViewModel;", "getModel", "()Lcom/larus/dora/impl/device/settings/unbind/DoraUnbindViewModel;", "model$delegate", "Lkotlin/Lazy;", "pageMaskView", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "getCurrentPageName", "", "getPageMaskView", "buildContentView", "buildTitleBar", "buildBody", "buildNoticeCard", "buildNoticeText", "buildNoticeRow", "text", "showDivider", "", "buildResetButtonCard", "Lcom/obric/oui/lisitem/OCardListItem;", "onResetClicked", "showLowPowerConfirmDialog", "showUnbindConfirmDialog", "observeUnbindState", "resolveBackgroundColor", "", "resolveCardColor", "resolvePrimaryTextColor", "resolveHintTextColor", "resolveDividerColor", "resolveDestructiveTextColor", "roundedDrawable", "Landroid/graphics/drawable/GradientDrawable;", "color", "radiusDp", "applyActionButtonCardStyle", "resetCardContainerMargins", "applyCardRadius", "applyTitleBarTextStyle", "Landroid/widget/TextView;", "dp", "sp", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricGUnbindAndResetFragment extends DoraUnbindBaseFragment {
    public static final /* synthetic */ int i = 0;
    public final Lazy g;
    public View h;

    public static final class a {
    }

    static {
    }

    public final String k() {
        return "dora_unbind";
    }

    public final void onDestroyView() {
        this.h = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public final void Y90() {
        DoraSceneManager r0 = DoraSceneManager.a;
        boolean r3 = true;
        if (DoraSceneManager.d(new DoraScene[]{DoraScene.OTA_TRANSFER_DATA, DoraScene.OTA_PERIPHERAL_INSTALL}) == true) goto L39;
        DoraOTAManager.a.getClass();
        DoraDevice r1 = kj4.a.g().c();
        if (r1 == null) goto L12;
        com.larus.dora.impl.ota.p r2 = DoraOTAManager.e(r1);
        if (r2 == null) goto L12;
        if (r2.a() != 4) goto L12;
    L13:
        if (r3 == true) goto L39;
        IDoraService r4 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r4 == null) goto L24;
        DeviceService r5 = r4.device();
        if (r5 == null) goto L24;
        int[] r6 = r5.h();
        if (r6 == null) goto L24;
        Integer r7 = ArraysKt.firstOrNull(r6);
        if (r7 == null) goto L24;
        int r8 = r7.intValue();
    L26:
        if (r8 >= 20) goto L33;
        com.obric.oui.dialog.v2.alert.g r9 = new com.obric.oui.dialog.v2.alert.g(requireContext());
        r9.w = false;
        int r10 = j0.a;
        String r11 = j0.d(2131902937);
        r9.j = false;
        r9.h = r11;
        r9.i = j0.d(2131902936);
        r9.h(j0.d(2131902925), new v());
        com.obric.oui.dialog.v2.alert.c r12 = r9.a();
        if (DialogLancet.shouldBlockDialogShow(r12) == false) goto L43;
        DialogLancet.handleBlockedDialogShow(r12);
        return;
    L43:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L41
    L31:
        DialogLancet.beforeDialogShow(r12);
        r12.show();
        DialogLancet.afterDialogShow(r12);
        return;
    L33:
        int r13 = j49.a.a;
        j49.a.i();
        com.obric.oui.dialog.v2.alert.g r14 = new com.obric.oui.dialog.v2.alert.g(requireContext());
        r14.w = false;
        int r15 = j0.a;
        String r16 = j0.d(2131902954);
        r14.j = false;
        r14.h = r16;
        r14.i = j0.d(2131902941);
        com.obric.oui.dialog.v2.alert.g.c(r14);
        r14.e(j0.d(2131902465), new t());
        r14.g(j0.d(2131902466), new u(this), ButtonStyleController.TextColorType.Negative);
        com.obric.oui.dialog.v2.alert.c r17 = r14.a();
        if (DialogLancet.shouldBlockDialogShow(r17) == false) goto L45;
        DialogLancet.handleBlockedDialogShow(r17);
        return;
    L45:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L42
    L37:
        DialogLancet.beforeDialogShow(r17);
        r17.show();
        DialogLancet.afterDialogShow(r17);
        return;
    L24:
        r8 = 0;
    L12:
        r3 = false;
    L39:
        WeakReference<com.obric.oui.toast.f> r18 = DoraObricToastUtils.a;
        DoraObricToastUtils.b(requireContext(), getString(2131902928));
    }

    public DoraObricGUnbindAndResetFragment() {
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraUnbindViewModel.class), new DoraObricGUnbindAndResetFragment$special$$inlined$activityViewModels$default$1(this), new DoraObricGUnbindAndResetFragment$special$$inlined$activityViewModels$default$2(this));
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        return this.h;
    }

    public final int X90(int r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public final int Z90(float r3) {
        Resources r0 = getResources();
        return (int) TypedValue.applyDimension(2, r3, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()));
    }

    public final View W90(String r10, boolean r11) {
        Context r0 = requireContext();
        LinearLayout r1 = new LinearLayout(r0);
        r1.setOrientation(1);
        LinearLayout r3 = new LinearLayout(r0);
        r3.setOrientation(1);
        r3.setGravity(16);
        OTextView r4 = new OTextView(r0, null, 0, 14);
        r4.setText(r10);
        r4.setTextColor(v19.c.a(2130972079, requireContext(), 2131103136));
        r4.setTextSize(2, 16.0f);
        r4.setIncludeFontPadding(false);
        TextViewCompat.setLineHeight(r4, Z90(22.0f));
        r3.addView(r4, new LinearLayout.LayoutParams(-1, -2));
        r3.setPadding(0, X90(14), 0, X90(14));
        r3.setMinimumHeight(X90(56));
        r1.addView(r3, new LinearLayout.LayoutParams(-1, -2));
        if (r11 == false) goto L5;
        View r12 = new View(r0);
        r12.setBackgroundColor(v19.c.a(2130972086, requireContext(), 2131103159));
        r1.addView(r12, new LinearLayout.LayoutParams(-1, 1));
    L5:
        return r1;
    }

    @Override // com.larus.dora.impl.device.settings.DoraUnbindBaseFragment
    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super.onViewCreated(r7, r8);
        Lifecycle.State r9 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricGUnbindAndResetFragment$observeUnbindState$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r9, null, this), 3, null);
    }

    public final View onCreateView(LayoutInflater r17, ViewGroup r18, Bundle r110) {
        Intrinsics.checkNotNullParameter(r17, "inflater");
        Context r1 = requireContext();
        OFloatingTitleBar r2 = new OFloatingTitleBar(requireContext(), null, 6, 0);
        r2.setClipChildren(false);
        r2.setClipToPadding(false);
        r2.setBackgroundColor(v19.c.a(2130970531, requireContext(), 2131102535));
        r2.setCenterTitle(getString(2131902947));
        r2.setCenterTitleColor(v19.c.a(2130972079, requireContext(), 2131103136));
        TextView r3 = (TextView) r2.findViewById(2131365427);
        if (r3 == null) goto L5;
        r3.setTextColor(v19.c.a(2130972079, requireContext(), 2131103136));
        r3.setTextSize(2, 16.0f);
        TextViewCompat.setLineHeight(r3, Z90(22.0f));
        r3.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 600, false));
    L5:
        r2.R(false);
        OFloatingTitleBar.k(r2, null, 6).setOnClickListener(new q(this));
        Context r4 = requireContext();
        LinearLayout r9 = new LinearLayout(r4);
        r9.setOrientation(1);
        r9.setGravity(1);
        r9.setPadding(X90(12), X90(16), X90(12), X90(24));
        LinearLayout r7 = new LinearLayout(requireContext());
        r7.setOrientation(1);
        r7.setGravity(1);
        int r5 = v19.c.a(2130970532, requireContext(), 2131102539);
        GradientDrawable r12 = new GradientDrawable();
        r12.setShape(0);
        r12.setColor(r5);
        r12.setCornerRadius(X90(20));
        r7.setBackground(r12);
        r7.setPadding(X90(24), X90(0), X90(24), X90(0));
        r7.addView(W90(getString(2131902955), true));
        r7.addView(W90(getString(2131902944), true));
        r7.addView(W90(getString(2131902943), true));
        r7.addView(W90(getString(2131902951), false));
        r9.addView(r7);
        OTextView r6 = new OTextView(requireContext(), null, 0, 14);
        r6.setText(getString(2131902940));
        r6.setGravity(8388611);
        r6.setTextColor(v19.c.a(2130972081, requireContext(), 2131103143));
        r6.setTextSize(2, 12.0f);
        r6.setIncludeFontPadding(false);
        TextViewCompat.setLineHeight(r6, Z90(16.0f));
        r6.setPadding(X90(20), X90(8), X90(20), X90(8));
        LinearLayout.LayoutParams r8 = new LinearLayout.LayoutParams(-1, -2);
        r8.topMargin = X90(0);
        Unit r13 = Unit.INSTANCE;
        r9.addView(r6, r8);
        OButton r10 = new OButton(requireContext(), null, 0, 28);
        r10.setText(getString(2131902953));
        r10.setGravity(17);
        r10.setBackground(new ColorDrawable(ContextCompat.getColor(requireContext(), R.color.transparent)));
        r10.setTextColor(v19.c.a(2130970996, requireContext(), 2131102650));
        r10.setTextSize(2, 16.0f);
        r10.setIncludeFontPadding(false);
        TextViewCompat.setLineHeight(r10, Z90(22.0f));
        r10.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 500, false));
        r10.setPadding(X90(16), 0, X90(16), 0);
        r10.setLayoutParams(new LinearLayout.LayoutParams(-1, X90(56)));
        e1.d(r10, new r(this));
        View r11 = new OCardListItem(requireContext(), null, 6, 0);
        r11.setCardType(2);
        OCardListItem.h(r11, 0);
        r11.setShowCardBg(true);
        r11.setCustomStartView(r10);
        r11.n(true);
        r11.m(false);
        r11.r(false);
        r11.setOnContentClickListener(new s(this));
        ViewGroup.LayoutParams r14 = r11.getCardContainer().getLayoutParams();
        if ((r14 instanceof ViewGroup.MarginLayoutParams) == false) goto L8;
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r14;
    L9:
        if (r15 == null) goto L11;
        r15.setMarginStart(0);
        r15.setMarginEnd(0);
        r15.leftMargin = 0;
        r15.rightMargin = 0;
        r11.getCardContainer().setLayoutParams(r15);
    L11:
        r11.getCardContainer().setPadding(0, 0, 0, 0);
        r11.getContentContainer().setPadding(0, 0, 0, 0);
        r11.o(false);
        Iterator r16 = CollectionsKt.listOf(new Drawable[]{r11.getCardContainer().getBackground(), r11.getContentContainer().getBackground()}).iterator();
    L13:
        if (r16.hasNext() == false) goto L21;
        Drawable r111 = (Drawable) r16.next();
        if ((r111 instanceof GradientDrawable) == false) goto L17;
        GradientDrawable r112 = (GradientDrawable) r111;
    L18:
        if (r112 == null) goto L13;
        r112.setCornerRadius(X90(20));
        goto L13
    L17:
        r112 = null;
        goto L18
    L21:
        LinearLayout.LayoutParams r20 = new LinearLayout.LayoutParams(-1, -2);
        r20.topMargin = X90(16);
        Unit r21 = Unit.INSTANCE;
        r9.addView(r11, r20);
        NestedScrollView r22 = new NestedScrollView(r4);
        r22.setClipChildren(true);
        r22.setClipToPadding(false);
        r22.setOverScrollMode(2);
        r22.setFillViewport(true);
        r22.addView(r9, new ViewGroup.LayoutParams(-1, -2));
        return com.larus.dora.obric.utils.c.c(r1, r2, r22, v19.c.a(2130970531, requireContext(), 2131102535), new p(this));
    L8:
        r15 = null;
        goto L9
    }
}
