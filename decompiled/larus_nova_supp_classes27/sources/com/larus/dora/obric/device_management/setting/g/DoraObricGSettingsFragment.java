package com.larus.dora.obric.device_management.setting.g;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.dora.obric.device_v2.ObricDoraGConnectFailedDialogFragment;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.oui.badge.OBadgeView;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000·\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0016\u0018\u0000 j2\u00020\u0001:\u0001jB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020!H\u0016J\b\u0010'\u001a\u00020!H\u0016J\b\u0010(\u001a\u00020!H\u0016J\b\u0010)\u001a\u00020!H\u0016J\u0010\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020\rH\u0016J\b\u0010.\u001a\u00020!H\u0016J\b\u0010/\u001a\u00020\u0019H\u0002J\b\u00100\u001a\u00020\u0019H\u0002J\b\u00101\u001a\u00020\u0019H\u0002J\b\u00102\u001a\u00020!H\u0002J\u0016\u00103\u001a\u00020!2\f\u00104\u001a\b\u0012\u0004\u0012\u00020605H\u0002J\b\u00107\u001a\u00020\u0019H\u0002J0\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\r2\u0006\u0010;\u001a\u00020,2\b\b\u0002\u0010<\u001a\u00020,2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020!0>H\u0002J\b\u0010?\u001a\u00020!H\u0002J\u0012\u0010?\u001a\u00020!2\b\u0010@\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010A\u001a\u00020!H\u0002J\u0010\u0010B\u001a\u00020!2\u0006\u0010@\u001a\u00020\rH\u0002J\b\u0010C\u001a\u00020!H\u0002J\u0012\u0010D\u001a\u00020!2\b\u0010@\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010E\u001a\u00020!H\u0002J\u0010\u0010F\u001a\u00020\u00192\u0006\u0010G\u001a\u00020\rH\u0002J\u0018\u0010H\u001a\u00020\u00192\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020LH\u0002J\u0014\u0010M\u001a\u00020!*\u0002092\u0006\u0010I\u001a\u00020JH\u0002J\u0018\u0010N\u001a\u00020L2\u0006\u0010O\u001a\u00020L2\u0006\u0010P\u001a\u00020LH\u0002J\b\u0010Q\u001a\u00020\u0019H\u0002J\u0010\u0010R\u001a\u00020\u00192\u0006\u0010S\u001a\u00020LH\u0002J\b\u0010T\u001a\u00020!H\u0002J\b\u0010U\u001a\u00020!H\u0002J\b\u0010V\u001a\u00020!H\u0002J\b\u0010W\u001a\u00020!H\u0002J\u0010\u0010X\u001a\u00020!2\u0006\u0010Y\u001a\u00020ZH\u0002J\u0010\u0010[\u001a\u00020!2\u0006\u0010Y\u001a\u00020ZH\u0002J\u0012\u0010\\\u001a\u00020!2\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0002J\b\u0010]\u001a\u00020!H\u0002J\b\u0010^\u001a\u00020!H\u0002J\u0010\u0010_\u001a\u00020!2\u0006\u0010`\u001a\u00020aH\u0002J\b\u0010b\u001a\u00020LH\u0002J\b\u0010c\u001a\u00020LH\u0002J\b\u0010d\u001a\u00020LH\u0002J\f\u0010e\u001a\u00020!*\u00020fH\u0002J\f\u0010g\u001a\u00020L*\u00020LH\u0002J\f\u0010h\u001a\u00020L*\u00020iH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017¨\u0006k"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/g/DoraObricGSettingsFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "viewModel", "Lcom/larus/dora/obric/device_management/setting/g/DoraObricGSettingsViewModel;", "getViewModel", "()Lcom/larus/dora/obric/device_management/setting/g/DoraObricGSettingsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "contentContainer", "Landroid/widget/LinearLayout;", "pendingReconnectMac", "", "btSwitch", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "connectFailedDialog", "Lcom/larus/dora/obric/device_v2/ObricDoraGConnectFailedDialogFragment;", "gpsDialog", "Lcom/obric/oui/dialog/v2/alert/OAlertDialog;", "localReceiver", "com/larus/dora/obric/device_management/setting/g/DoraObricGSettingsFragment$localReceiver$1", "Lcom/larus/dora/obric/device_management/setting/g/DoraObricGSettingsFragment$localReceiver$1;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onAttach", "context", "Landroid/content/Context;", "onStart", "onResume", "onStop", "onDestroyView", "onDoraConnectStateChanged", "isConnected", "", "getCurrentPageName", "logEnterPage", "buildContentView", "buildScrollContent", "buildTitleBar", "renderSettings", "renderSections", "sections", "", "Lcom/larus/dora/obric/device_management/setting/g/DoraObricGSettingsSection;", "buildDisconnectedActionPanel", "buildDisconnectedActionButton", "Lcom/obric/oui/lisitem/OCardListItem;", "text", "primary", "isLoading", "onClick", "Lkotlin/Function0;", "checkReadyForReconnect", "mac", "showGpsDialogForReconnect", "requestBluetoothPermissionForReconnect", "requestEnableBluetoothForReconnect", "startReconnect", "openDeviceHome", "buildSectionTitle", "title", "buildSettingItem", "item", "Lcom/larus/dora/obric/device_management/setting/g/DoraObricGSettingsItem;", "position", "", "bindEndContent", "resolveCardPosition", "index", "size", "buildRedDotView", "buildSpacer", "heightDp", "observeUiState", "observeNavigation", "observeEffects", "showDisconnectedUnbindDialog", "showReconnectUnbindDialog", "device", "Lcom/bytedance/dora/device/DoraDevice;", "unbindAndDisconnect", "showConnectFailedDialog", "dismissConnectFailedDialog", "dismissGpsDialog", "openRoute", "navigation", "Lcom/larus/dora/obric/device_management/setting/g/DoraObricGSettingsNavigation$Route;", "resolveBackgroundColor", "resolvePrimaryTextColor", "resolveSecondaryTextColor", "applyValueTextStyle", "Lcom/obric/oui/text/OTextView;", "dp", "sp", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricGSettingsFragment extends DoraBaseFragment {
    public static final /* synthetic */ int m = 0;
    public final Lazy f;
    public LinearLayout g;
    public String h;
    public ActivityResultLauncher<Intent> i;
    public ObricDoraGConnectFailedDialogFragment j;
    public com.obric.oui.dialog.v2.alert.c k;
    public final DoraObricGSettingsFragment$localReceiver$1 l;

    public static final class a {
    }

    static {
    }

    public final String k() {
        return "settings_home";
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void T90() {
        int r0 = y69.a.a;
        String r1 = y69.b.a(this, getArguments());
        Bundle r2 = getArguments();
        if (r2 == null) goto L5;
        String r3 = r2.getString(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD);
    L6:
        y69.a.a("settings_home", r1, r3);
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void Y90() {
        com.obric.oui.dialog.v2.alert.c r0 = this.k;
        if (r0 == null) goto L21;
        Handler r1 = DialogLancet.resolveDialogHandler(r0);
        if (r1 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r0);
        r0.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r0);
        goto L21
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r0);
        throw th;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r2 == null) goto L18;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r1.getLooper()) goto L9;
        r1.post(DialogLancet.createDismissRunnable(r0));
    L21:
        this.k = null;
    }

    public final DoraObricGSettingsViewModel aa0() {
        return (DoraObricGSettingsViewModel) this.f.getValue();
    }

    public final void ca0() {
        LinearLayout r0 = this.g;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.removeAllViews();
        u r1 = (u) aa0().getUiState().getValue();
        String r2 = aa0().currentDeviceName();
        if (r1.a == true) goto L9;
        ba0(aa0().disconnected(r2));
        Context r3 = requireContext();
        u r4 = (u) aa0().getUiState().getValue();
        LinearLayout r5 = new LinearLayout(r3);
        r5.setOrientation(1);
        r5.setGravity(1);
        r5.setPadding(0, Z90(16), 0, 0);
        View r6 = W90(getString(2131902419), true, r4.b, new DoraObricGSettingsFragment$buildDisconnectedActionPanel$1$1(this));
        LinearLayout.LayoutParams r7 = new LinearLayout.LayoutParams(-1, Z90(64));
        r7.topMargin = Z90(0);
        Unit r8 = Unit.INSTANCE;
        r5.addView(r6, r7);
        View r9 = W90(getString(2131902982), false, false, new DoraObricGSettingsFragment$buildDisconnectedActionPanel$1$3(this));
        LinearLayout.LayoutParams r10 = new LinearLayout.LayoutParams(-1, Z90(64));
        r10.topMargin = Z90(16);
        r5.addView(r9, r10);
        r0.addView(r5);
        return;
    L9:
        ba0(aa0().connected(r2));
    }

    public final void onDestroyView() {
        ObricDoraGConnectFailedDialogFragment r0 = this.j;
        if (r0 != null) goto L12;
    L10:
        this.j = null;
        Y90();
        this.g = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        return;
    L12:
        r0.dismissAllowingStateLoss();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r1 = DialogFragmentLancet.sLastShowStack;
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L10
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void onStop() {
        LocalBroadcastManager.getInstance(AppHost.a.getApplication()).unregisterReceiver(this.l);
        super.onStop();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.dora.obric.device_management.setting.g.DoraObricGSettingsFragment$localReceiver$1] */
    public DoraObricGSettingsFragment() {
        final Function0<Fragment> r0 = new DoraObricGSettingsFragment$special$$inlined$viewModels$default$1(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraObricGSettingsViewModel.class), new DoraObricGSettingsFragment$special$$inlined$viewModels$default$2(r0), new DoraObricGSettingsFragment$special$$inlined$viewModels$default$3(r0, this));
        this.l = new DoraObricGSettingsFragment$localReceiver$1(this);
    }

    public final void onResume() {
        super.onResume();
        aa0().refreshConnectionState();
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void onStart() {
        super.onStart();
        LocalBroadcastManager.getInstance(AppHost.a.getApplication()).registerReceiver(this.l, new IntentFilter("action.DEVICE_UPDATE_NAME"));
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void V90(boolean r1) {
        super.V90(r1);
        aa0().refreshConnectionState();
    }

    public final void X90(String r8) {
        if (r8 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L11;
        g49.d.e("DoraObricGSettingsFragment", "checkReadyForReconnect skipped, mac is empty");
        return;
    L11:
        this.h = r8;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DoraObricGSettingsFragment$checkReadyForReconnect$1(this, r8, null), 3, null);
        return;
    L4:
        if (r8.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public final int Z90(int r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v18, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v20 */
    public final void ba0(List<t> r17) {
        LinearLayout r1 = this.g;
        if (r1 != null) goto L5;
        return;
    L5:
        Iterator<T> r2 = r17.iterator();
        int r3 = 0;
        int r4 = 0;
    L7:
        if (r2.hasNext() == false) goto L58;
        Object r5 = r2.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        t r7 = (t) r5;
        if (r4 <= 0) goto L14;
        View r8 = new View(requireContext());
        r8.setLayoutParams(new LinearLayout.LayoutParams(-1, Z90(16)));
        r1.addView(r8);
    L14:
        String r9 = r7.a;
        int r10 = 8;
        if (r9 == null) goto L20;
        OSectionTitleBar r11 = new OSectionTitleBar(requireContext(), null, 6, r3);
        LinearLayout r12 = (LinearLayout) r11.findViewById(2131367728);
        if (r12 == null) goto L19;
        r12.setPadding(Z90(20), Z90(8), Z90(12), Z90(8));
    L19:
        r11.setTitleText(r9);
        r11.setTitleStyle(2131953405);
        r11.setLayoutParams(new LinearLayout.LayoutParams(-1, Z90(32)));
        r1.addView(r11);
    L20:
        Iterator<T> r13 = r7.b.iterator();
        int r14 = 0;
    L22:
        if (r13.hasNext() == false) goto L57;
        Object r15 = r13.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L26;
        CollectionsKt.throwIndexOverflow();
    L26:
        final r r18 = (r) r15;
        int r110 = r7.b.size();
        if (r110 > 1) goto L29;
        int r20 = 0;
    L35:
        View r111 = new OCardListItem(requireContext(), null, 6, 0);
        r111.setCardType(0);
        OCardListItem.h(r111, r20);
        r111.setShowCardBg(true);
        r111.p(false);
        r111.setTitle(r18.a);
        r111.s(true);
        r111.q(false);
        if (r18.d == false) goto L39;
        int r21 = Z90(r10);
        OTextView r22 = new OBadgeView(requireContext(), null, 6, 0);
        r22.setLayoutParams(new FrameLayout.LayoutParams(r21, r21, 17));
        r111.setCustomEndView(r22);
        r111.m(true);
    L38:
        ?? r23 = 0;
    L53:
        if (r18.e == false) goto L55;
        r111.setDefaultTailIcon(r23);
        r111.r(true);
        r111.getTailIconView().setColorFilter(null);
    L56:
        r111.o(r23);
        r111.setOnContentClickListener(new g(this, r18));
        r1.addView(r111);
        r14 = r16;
        r10 = 8;
        goto L22
    L55:
        r111.r(r23);
        goto L56
    L39:
        String r24 = r18.c;
        if (r24 != null) goto L42;
    L45:
        boolean r112 = true;
    L46:
        if (r112 == true) goto L51;
        r111.setDefaultCustomEndView(3);
        r111.k(r18.c, -1);
        OTextView r25 = r111.getEndDetail();
        if (r25 == null) goto L50;
        r25.setTextColor(v19.c.a(2130972081, requireContext(), 2131103143));
        r25.setTextSize(2, 14.0f);
        Resources r26 = getResources();
        TextViewCompat.setLineHeight(r25, (int) TypedValue.applyDimension(2, 18.0f, WindowDisplayMetricsOverride.apply(r26, r26.getDisplayMetrics())));
        r25.setSingleLine(true);
        r25.setMaxLines(1);
        r25.setEllipsize(TextUtils.TruncateAt.END);
    L50:
        r111.m(true);
        goto L38
    L51:
        r23 = 0;
        r111.m(false);
        goto L53
    L42:
        if (r24.length() == 0) goto L45;
        r112 = false;
        goto L46
    L29:
        if (r14 != 0) goto L32;
        r20 = 1;
        goto L35
    L32:
        if (r14 != (r110 - 1)) goto L34;
        r20 = 3;
        goto L35
    L34:
        r20 = 2;
        goto L35
    L57:
        r4 = r6;
        r3 = 0;
        goto L7
    }

    public final void da0(String r3) {
        StringBuilder r0 = new StringBuilder("startReconnect macEmpty=");
        if (r3 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        r0.append(r1);
        g49.d.d("DoraObricGSettingsFragment", r0.toString());
        this.h = null;
        aa0().startReconnect(r3);
        return;
    L5:
        if (r3.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final void onAttach(final Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super/*androidx.fragment.app.Fragment*/.onAttach(r3);
        this.i = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new f(r3, this));
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r8, r9);
        aa0().initialize(getArguments());
        aa0().refreshConnectionState();
        Lifecycle.State r10 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricGSettingsFragment$observeUiState$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r10, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricGSettingsFragment$observeNavigation$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r10, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricGSettingsFragment$observeEffects$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r10, null, this), 3, null);
        ca0();
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        Context r11 = requireContext();
        OFloatingTitleBar r12 = new OFloatingTitleBar(requireContext(), null, 6, 0);
        r12.setClipChildren(false);
        r12.setClipToPadding(false);
        r12.setBackgroundColor(v19.c.a(2130970531, requireContext(), 2131102535));
        r12.setCenterTitle(getString(2131902441));
        r12.R(false);
        OFloatingTitleBar.k(r12, null, 6).setOnClickListener(new h(this));
        Context r13 = requireContext();
        LinearLayout r1 = new LinearLayout(r13);
        r1.setOrientation(1);
        r1.setClipChildren(false);
        r1.setClipToPadding(false);
        r1.setPadding(0, 0, 0, Z90(24));
        this.g = r1;
        NestedScrollView r2 = new NestedScrollView(r13);
        r2.setClipChildren(true);
        r2.setClipToPadding(false);
        r2.setOverScrollMode(2);
        r2.setFillViewport(true);
        r2.setPadding(0, Z90(16), 0, 0);
        r2.addView(this.g, new ViewGroup.LayoutParams(-1, -2));
        return com.larus.dora.obric.utils.c.c(r11, r12, r2, v19.c.a(2130970531, requireContext(), 2131102535), null);
    }

    public final OCardListItem W90(String r7, boolean r8, boolean r9, final Function0<Unit> r10) {
        Context r0 = requireContext();
        if (r8 == false) goto L5;
        int r11 = 2131104023;
    L6:
        int r12 = ContextCompat.getColor(r0, r11);
        ConstraintLayout.LayoutParams r3 = null;
        OCardListItem r1 = new OCardListItem(r0, null, 6, 0);
        r1.setCardType(0);
        OCardListItem.h(r1, 0);
        r1.setShowCardBg(true);
        r1.p(false);
        r1.setTitle(r7);
        r1.s(!r9);
        r1.q(false);
        r1.m(false);
        r1.r(false);
        r1.o(false);
        r1.l(r12, r12);
        r1.getContentContainer().setPadding(0, 0, 0, 0);
        LinearLayout r13 = r1.getTitleContainer();
        r13.setGravity(17);
        r13.setPadding(Z90(16), 0, Z90(16), 0);
        ConstraintLayout.LayoutParams r2 = r13.getLayoutParams();
        if ((r2 instanceof ConstraintLayout.LayoutParams) == false) goto L9;
        r3 = r2;
    L9:
        if (r3 == null) goto L11;
        ((ViewGroup.MarginLayoutParams) r3).width = 0;
        r3.t = 0;
        r3.v = 0;
        r3.s = -1;
        r3.u = -1;
        r3.E = 0.5f;
        r13.setLayoutParams(r3);
    L11:
        OTextView r14 = r1.getTitleView();
        r14.setGravity(17);
        r14.setTextSize(2, 16.0f);
        r14.setIncludeFontPadding(false);
        Resources r15 = getResources();
        TextViewCompat.setLineHeight(r14, (int) TypedValue.applyDimension(2, 22.0f, WindowDisplayMetricsOverride.apply(r15, r15.getDisplayMetrics())));
        r14.setTypeface(Typeface.create(Typeface.create("sans-serif", 0), 500, false));
        if (r9 == false) goto L14;
        View r16 = new ODownloadProgressView(r0);
        r16.setLayoutParams(new LinearLayout.LayoutParams(Z90(24), Z90(24)));
        r16.setSize(2);
        r16.setProcessingColor(ContextCompat.getColor(r0, 2131104350));
        r16.setProgressBackgroundColor(ContextCompat.getColor(r0, 2131104330));
        r16.setCurrentState(0);
        r16.setClickable(false);
        r1.n.addView(r16, 0);
    L14:
        r1.setOnContentClickListener(new e(r10));
        return r1;
    L5:
        r11 = 2131104983;
        goto L6
    }
}
