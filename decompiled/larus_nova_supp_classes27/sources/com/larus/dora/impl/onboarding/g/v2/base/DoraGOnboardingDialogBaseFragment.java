package com.larus.dora.impl.onboarding.g.v2.base;

import android.R;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.router.SmartRouter;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.dora.impl.databinding.LarusDoraGOnboardingDialogBinding;
import com.larus.dora.impl.dynamic.n1;
import com.larus.dora.impl.onboarding.DoraOnboardingDevice;
import com.larus.dora.impl.onboarding.DoraOnboardingDialogViewModel;
import com.larus.dora.impl.onboarding.TOAST_TYPE;
import com.larus.dora.impl.onboarding.g.v2.DoraGOnboardingDialogFragmentV2;
import com.larus.dora.impl.onboarding.o0;
import com.larus.dora.impl.onboarding.q0;
import com.larus.dora.impl.onboarding.x;
import com.larus.dora.impl.util.s;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.e1;
import com.larus.utils.i0;
import com.larus.utils.m0;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.Collection;
import java.util.Locale;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowCollector;
import v19.i5;
import v19.o5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 c2\u00020\u0001:\u0001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010+\u001a\u00020,H&J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020,0.H\u0014J\b\u0010/\u001a\u00020\u001bH&J\b\u00100\u001a\u00020\u001bH&J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H&J\u0010\u00105\u001a\u0002022\u0006\u00103\u001a\u000204H\u0016J\u0012\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020<H\u0014J\b\u0010=\u001a\u000202H\u0014J\u0010\u0010>\u001a\u0002022\u0006\u0010?\u001a\u00020@H\u0016J\b\u0010A\u001a\u00020'H\u0016J\u0012\u0010B\u001a\u00020:2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J&\u0010E\u001a\u0004\u0018\u00010<2\u0006\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010I2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\b\u0010J\u001a\u00020!H\u0002J\u001a\u0010K\u001a\u0002022\u0006\u0010L\u001a\u00020<2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\u0010\u0010M\u001a\u0002022\u0006\u0010N\u001a\u00020!H\u0002J\u0010\u0010O\u001a\u0002022\u0006\u0010P\u001a\u00020QH\u0002J\b\u0010R\u001a\u000202H\u0016J\b\u0010S\u001a\u000202H\u0016J\b\u0010T\u001a\u000202H\u0004J\u0012\u0010U\u001a\u0004\u0018\u00010V2\u0006\u00103\u001a\u000204H\u0016J\u0018\u0010W\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u0010?\u001a\u00020@H\u0004J\n\u0010X\u001a\u0004\u0018\u00010@H\u0002J\u0010\u0010Y\u001a\u00020\u001b2\u0006\u0010?\u001a\u00020@H\u0004J\u0010\u0010Z\u001a\u00020'2\u0006\u00103\u001a\u000204H\u0014J\u0010\u0010[\u001a\u0002022\u0006\u0010?\u001a\u00020@H\u0016J\u0010\u0010\\\u001a\u0002022\u0006\u0010]\u001a\u00020^H\u0014J\b\u0010_\u001a\u000202H\u0002J\u0010\u0010`\u001a\u0002022\u0006\u0010?\u001a\u00020@H\u0002J\b\u0010a\u001a\u000202H\u0002J\b\u0010b\u001a\u00020!H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u000bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001b\u0010\u0014\u001a\u00020\u00158DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001a\u001a\u00020\u001bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u00020#X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0018\u0010&\u001a\u0004\u0018\u00010'X\u0094\u0004¢\u0006\n\n\u0002\u0010*\u001a\u0004\b(\u0010)R\u0014\u00106\u001a\u00020!X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b7\u00108¨\u0006d"}, d2 = {"Lcom/larus/dora/impl/onboarding/g/v2/base/DoraGOnboardingDialogBaseFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraGOnboardingDialogBinding;", "getBinding", "()Lcom/larus/dora/impl/databinding/LarusDoraGOnboardingDialogBinding;", "setBinding", "(Lcom/larus/dora/impl/databinding/LarusDoraGOnboardingDialogBinding;)V", "interruptDialog", "Lcom/larus/common_ui/dialog/CommonDialog;", "needUnbindDialog", "getNeedUnbindDialog", "()Lcom/larus/common_ui/dialog/CommonDialog;", "setNeedUnbindDialog", "(Lcom/larus/common_ui/dialog/CommonDialog;)V", "authDeviceFailedDialog", "getAuthDeviceFailedDialog", "setAuthDeviceFailedDialog", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/onboarding/DoraOnboardingDialogViewModel;", "getModel", "()Lcom/larus/dora/impl/onboarding/DoraOnboardingDialogViewModel;", "model$delegate", "Lkotlin/Lazy;", "buryPointSource", "", "getBuryPointSource", "()Ljava/lang/String;", "setBuryPointSource", "(Ljava/lang/String;)V", "hasStartedAutoConnect", "", "scanForALongTimeInMillis", "", "getScanForALongTimeInMillis", "()J", "bluetoothOffToastResId", "", "getBluetoothOffToastResId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "productType", "Lcom/bytedance/dora/annotation/ProductNameType;", "scanProductTypes", "", "productTypeDisplayName", "sku", "handleBottomTips", "", "state", "Lcom/larus/dora/impl/onboarding/OnboardingUiState;", "handleMovie", "usesCustomDialogContainer", "getUsesCustomDialogContainer", "()Z", "createCustomDialog", "Landroid/app/Dialog;", "content", "Landroid/view/View;", "onOnboardingContentReady", "handleUnbind", "device", "Lcom/bytedance/dora/device/DoraDevice;", "getTheme", "onCreateDialog", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "isCurrentProductEnabled", "onViewCreated", "view", "initializeOnboardingContent", "useFragmentViewLifecycle", "applyBottomSheetStartBehavior", "bottomDialog", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "onStart", "onStop", "dismissOrShowInterruptDialog", "handleUiState", "", "updateConnectedUI", "resolveAutoConnectDevice", "resolveFoundDeviceName", "getTitleText", "gotoOnboardingPage", "handleAction", "action", "Lcom/larus/dora/impl/onboarding/OnboardingAction;", "showInterruptDialog", "showNeedUnbindDialog", "showAuthDeviceFailedDialog", "shouldAuthDevice", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class DoraGOnboardingDialogBaseFragment extends BottomSheetDialogFragment {
    public static final /* synthetic */ int l = 0;
    public LarusDoraGOnboardingDialogBinding d;
    public CommonDialog e;
    public CommonDialog f;
    public CommonDialog g;
    public final Lazy h;
    public String i;
    public boolean j;
    public final long k;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ DoraGOnboardingDialogBaseFragment a;
        public final /* synthetic */ q0 b;

        public b(DoraGOnboardingDialogBaseFragment r1, q0 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.ba0(((q0.b) this.b).a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c<T> implements FlowCollector {
        public final /* synthetic */ DoraGOnboardingDialogBaseFragment a;

        public c(DoraGOnboardingDialogBaseFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            DoraGOnboardingDialogBaseFragment r3 = this.a;
            r3.fa0((q0) r1);
            return Unit.INSTANCE;
        }
    }

    public static final class d<T> implements FlowCollector {
        public final /* synthetic */ DoraGOnboardingDialogBaseFragment a;

        public d(DoraGOnboardingDialogBaseFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            DoraGOnboardingDialogBaseFragment r3 = this.a;
            r3.ca0((o0) r1);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public Dialog U90(View r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        return null;
    }

    public Integer W90() {
        return null;
    }

    public boolean aa0() {
        return false;
    }

    public abstract void da0(q0 r1);

    public void ea0(q0 r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final int getTheme() {
        return 2131951936;
    }

    public void ja0() {
    }

    public abstract ProductNameType ka0();

    public abstract String la0();

    public boolean oa0() {
        return this instanceof DoraGOnboardingDialogFragmentV2;
    }

    public abstract String pa0();

    public final DoraOnboardingDialogViewModel X90() {
        return (DoraOnboardingDialogViewModel) this.h.getValue();
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        boolean r2 = false;
        DoraDevice r3 = null;
        if (aa0() == true) goto L16;
        BottomSheetDialog r1 = getDialog();
        if ((r1 instanceof BottomSheetDialog) == false) goto L7;
        BottomSheetDialog r4 = r1;
    L8:
        if (r4 == null) goto L16;
        View r5 = r4.findViewById(2131368870);
        if (r5 != null) goto L12;
        g49.d.e("DoraOnboardingDialogFragment", "applyBottomSheetStartBehavior: design_bottom_sheet is null, skip dialog start behavior");
        goto L16
    L12:
        BottomSheetBehavior.from(r5).setHideable(false);
        View r6 = r4.findViewById(2131389274);
        if (r6 == null) goto L15;
        r6.setOnClickListener(new e(this));
        goto L16
    L15:
        g49.d.e("DoraOnboardingDialogFragment", "applyBottomSheetStartBehavior: touch_outside is null, skip outside click listener");
        goto L16
    L7:
        r4 = null;
    L16:
        Bundle r7 = getArguments();
        if (r7 != null) goto L20;
    L61:
        if (r3 != null) goto L63;
        X90().startScan(na0(), pa0(), Y90());
        return;
    L63:
        if (this.j == true) goto L67;
        this.j = true;
        g49.d.d("DoraOnboardingDialogFragment", "onStart: auto connect device, productId=" + r3.productId + ", type=" + r3.type + ", sku=" + r3.sku);
        X90().bindAndConnect(r3, W90());
        return;
    L67:
        return;
    L20:
        if (r7.getBoolean("key_dora_onboarding_auto_connect", false) == false) goto L61;
        ProductNameType r8 = ka0();
        String r9 = r7.getString("key_dora_onboarding_device_name");
        String r10 = "";
        if (r9 != null) goto L25;
        r9 = "";
    L25:
        String r11 = StringsKt.trim(r9).toString();
        String r12 = r7.getString("key_dora_onboarding_device_mac");
        if (r12 != null) goto L28;
        r12 = "";
    L28:
        String r13 = StringsKt.trim(r12).toString();
        int r15 = r7.getInt("key_dora_onboarding_device_sku", -1);
        if (r11.length() != 0) goto L31;
        boolean r14 = true;
    L32:
        if (r14 == false) goto L34;
    L53:
        StringBuilder r16 = new StringBuilder("resolveAutoConnectDevice: skip, hasName=");
        if (r11.length() <= 0) goto L56;
        boolean r17 = true;
    L57:
        r16.append(r17);
        r16.append(", hasMac=");
        if (r13.length() <= 0) goto L60;
        r2 = true;
    L60:
        r16.append(r2);
        r16.append(", productId=");
        r16.append(r8.id);
        r16.append(", sku=");
        r16.append(r15);
        g49.d.d("DoraOnboardingDialogFragment", r16.toString());
        goto L61
    L56:
        r17 = false;
        goto L57
    L34:
        if (r13.length() != 0) goto L36;
        boolean r18 = true;
    L37:
        if (r18 == true) goto L53;
        if (r8.id <= 0) goto L53;
        if (r15 < 0) goto L53;
        String r20 = r7.getString("key_dora_onboarding_device_sn");
        if (r20 == null) goto L46;
        r10 = r20;
    L46:
        String r110 = StringsKt.trim(r10).toString();
        int r111 = r8.deviceType;
        int[] r21 = r7.getIntArray("key_dora_onboarding_device_battery");
        if (r21 != null) goto L49;
        r21 = new int[]{-1, -1, -1};
    L49:
        int[] r112 = r21;
        int[] r22 = r7.getIntArray("key_dora_onboarding_device_charge");
        if (r22 != null) goto L52;
        r22 = new int[]{-1, -1, -1};
    L52:
        r3 = x.b(new DoraOnboardingDevice(r11, r13, r110, r111, r15, r112, r22, r8.id, 1));
        goto L61
    L36:
        r18 = false;
        goto L37
    L31:
        r14 = false;
        goto L32
    }

    public DoraGOnboardingDialogBaseFragment() {
        final Function0<Fragment> r0 = new DoraGOnboardingDialogBaseFragment$special$$inlined$viewModels$default$1(this);
        this.h = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraOnboardingDialogViewModel.class), new DoraGOnboardingDialogBaseFragment$special$$inlined$viewModels$default$2(r0), new DoraGOnboardingDialogBaseFragment$special$$inlined$viewModels$default$3(r0, this));
        this.i = "";
        this.k = 12000;
    }

    public final void V90() {
        if ((X90().getUiStateFlow().getValue() instanceof q0.c) == false) goto L16;
        g49.d.d("DoraOnboardingDialogFragment", "showInterruptDialog");
        boolean r1 = false;
        if (this.e != null) goto L7;
        String r0 = la0();
        AppHost.Companion r3 = AppHost.a;
        String r4 = r3.getApplication().getString(2131903937, new Object[]{r0});
        String r2 = r3.getApplication().getString(2131903936, new Object[]{r0});
        CommonDialog.a r5 = new CommonDialog.a();
        r5.i(r4);
        r5.g(r2);
        CommonDialog.a.f(r5, new g(this), getString(2131903744), false, 12);
        CommonDialog.a.e(r5, new h(this), getString(2131903743), 4);
        this.e = r5.a();
    L7:
        CommonDialog r6 = this.e;
        if (r6 != null) goto L10;
    L12:
        if (r1 == true) goto L18;
        CommonDialog r7 = this.e;
        if (r7 == null) goto L19;
        T90(r7, getChildFragmentManager());
        return;
    L19:
        return;
    L18:
        return;
    L10:
        if (r6.isVisible() != true) goto L12;
        r1 = true;
        goto L12
    L16:
        g49.d.d("DoraOnboardingDialogFragment", "dismissAllowingStateLoss");
        S90(this);
    }

    public final boolean ia0() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        int r1 = r0.getInt("key_dora_product_id", -1);
    L6:
        if (r1 == (-1)) goto L10;
        int r2 = s.a;
        if (s.c(Integer.valueOf(r1)) == false) goto L10;
        return true;
    L10:
        return false;
    L5:
        r1 = -1;
        goto L6
    }

    public Collection<ProductNameType> na0() {
        return CollectionsKt.listOf(ka0());
    }

    public final void onStop() {
        super/*androidx.fragment.app.DialogFragment*/.onStop();
        X90().stopScan();
    }

    public long Y90() {
        return this.k;
    }

    public static void S90(DoraGOnboardingDialogBaseFragment r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public static String ma0(DoraDevice r110) {
        Intrinsics.checkNotNullParameter(r110, "device");
        String r1 = o59.a.d(r110);
        int r2 = r110.type;
        if (r2 == 17) goto L7;
        if (r2 == 18) goto L7;
        if (r2 == 19) goto L7;
        return r1;
    L7:
        boolean r6 = true;
        if ((!StringsKt.isBlank(r1)) == true) goto L10;
    L12:
        String r0 = r110.mac;
        if (r0 != null) goto L15;
        r0 = "";
    L15:
        String r3 = StringsKt.trim(StringsKt.replace$default(StringsKt.replace$default(r0, ":", "", false, 4, null), "-", "", false, 4, null)).toString().toUpperCase(Locale.US);
        if (r3.length() >= 4) goto L18;
        return r1;
    L18:
        int r8 = 0;
    L20:
        if (r8 >= r3.length()) goto L41;
        char r9 = r3.charAt(r8);
        if ('0' <= r9) goto L24;
    L26:
        boolean r10 = false;
    L27:
        if (r10 == false) goto L29;
    L37:
        boolean r11 = true;
    L38:
        if (r11 == false) goto L39;
        r8 = r8 + 1;
        goto L20
    L39:
        r6 = false;
        goto L41
    L29:
        if ('A' <= r9) goto L31;
    L33:
        boolean r12 = false;
    L34:
        if (r12 == true) goto L37;
        r11 = false;
        goto L38
    L31:
        if (r9 >= 'G') goto L33;
        r12 = true;
        goto L34
    L24:
        if (r9 >= ':') goto L26;
        r10 = true;
    L41:
        if (r6 == true) goto L43;
        return r1;
    L43:
        if (r2 == 18) goto L47;
        if (r2 == 19) goto L46;
        String r4 = "DoraG2_";
    L49:
        return r4 + StringsKt.takeLast(r3, 4);
    L46:
        r4 = "DoraGPin_";
        goto L49
    L47:
        r4 = "DoraGAir_";
        goto L49
    L10:
        if (Intrinsics.areEqual(r1, "Ola Friend") == true) goto L12;
        return r1;
    }

    public final int Z90(q0 r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        int r1 = 2131902189;
        if (Intrinsics.areEqual(r3, q0.e.a) == false) goto L6;
    L12:
        return r1;
    L6:
        if (Intrinsics.areEqual(r3, q0.f.a) == true) goto L12;
        r1 = 2131903675;
        if ((r3 instanceof q0.d) == true) goto L12;
        boolean r4 = r3 instanceof q0.c;
        goto L12
    }

    public final void ba0(DoraDevice r8) {
        Intrinsics.checkNotNullParameter(r8, "device");
        Bundle r2 = getArguments();     // Catch: Throwable -> L20
        if (r2 == null) goto L6;
        String r3 = r2.getString("key_dora_onboarding_origin_from");     // Catch: Throwable -> L20
    L7:
        Context r4 = getContext();     // Catch: Throwable -> L20
        if (r4 != null) goto L10;
        return;
    L10:
        Intent r5 = new Intent("action.DEVICE_UPDATE_DYNAMIC");     // Catch: Throwable -> L20
        r5.putExtra("mac", r8.mac);     // Catch: Throwable -> L20
        LocalBroadcastManager.getInstance(AppHost.a.getApplication()).sendBroadcast(r5);     // Catch: Throwable -> L20
        boolean r6 = ObricFeatureServiceDelegate.b.b();     // Catch: Throwable -> L20
        if (Intrinsics.areEqual(r3, "device_manage") == true) goto L14;
        if (r6 == true) goto L14;
        n1.i();     // Catch: Throwable -> L20
    L16:
        com.bytedance.router.i r1 = SmartRouter.buildRoute(r4, "//dora_onboarding_v2");     // Catch: Throwable -> L20
        r1.d = 2130772372;     // Catch: Throwable -> L20
        r1.e = 2130772399;     // Catch: Throwable -> L20
        r1.c.putExtra("key_dora_onboarding_device", x.c(r8));     // Catch: Throwable -> L20
        r1.d();     // Catch: Throwable -> L20
        S90(this);     // Catch: Throwable -> L20
        FragmentActivity r9 = getActivity();     // Catch: Throwable -> L20
        if (r9 == null) goto L25;
        r9.finish();     // Catch: Throwable -> L20
        return;
    L25:
        return;
    L14:
        if (r6 == false) goto L16;
        g49.d.d("DoraOnboardingDialogFragment", "skip legacy device management route, from=" + r3);     // Catch: Throwable -> L20
        goto L16
    L6:
        r3 = null;
    L20:
        th = move-exception;
        g49.d.c("DoraOnboardingDialogFragment", "gotoDeviceGuide: exception", th);
        S90(this);
    }

    public void ca0(o0 r5) {
        Intrinsics.checkNotNullParameter(r5, "action");
        g49.d.d("DoraOnboardingDialogFragment", "handleAction: " + r5);
        if ((r5 instanceof o0.c) == false) goto L6;
        ga0(((o0.c) r5).a);
        return;
    L6:
        if ((r5 instanceof o0.d) == false) goto L12;
        o0.d r6 = (o0.d) r5;
        if (r6.getType() != TOAST_TYPE.TOAST_TYPE_WARNING) goto L10;
        t19.s r0 = t19.s.a;
        Application r1 = AppHost.a.getApplication();
        String r7 = r6.a;
        r0.getClass();
        t19.s.t(r1, r7);
        return;
    L10:
        t19.s r2 = t19.s.a;
        Application r3 = AppHost.a.getApplication();
        String r8 = r6.a;
        r2.getClass();
        t19.s.c(r3, r8);
        return;
    L12:
        if (Intrinsics.areEqual(r5, o0.a.a) == false) goto L26;
        boolean r4 = false;
        if (this.g != null) goto L16;
        CommonDialog.a r9 = new CommonDialog.a();
        r9.i(getString(2131903645));
        r9.g(getString(2131903644));
        CommonDialog.a.f(r9, new f(this), getString(2131902851), false, 12);
        this.g = r9.a();
    L16:
        CommonDialog r10 = this.g;
        if (r10 != null) goto L19;
    L21:
        if (r4 == true) goto L34;
        CommonDialog r11 = this.g;
        if (r11 == null) goto L35;
        T90(r11, getChildFragmentManager());
        return;
    L35:
        return;
    L34:
        return;
    L19:
        if (r10.isVisible() != true) goto L21;
        r4 = true;
        goto L21
    L26:
        if ((r5 instanceof o0.b) == false) goto L30;
        ba0(((o0.b) r5).a);
        return;
    L30:
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public Object fa0(q0 r5) {
        Intrinsics.checkNotNullParameter(r5, "state");
        LarusDoraGOnboardingDialogBinding r0 = this.d;
        if (r0 == null) goto L35;
        g49.d.d("DoraOnboardingDialogFragment", "handleUiState: " + r5);
        ea0(r5);
        da0(r5);
        if (Intrinsics.areEqual(r5, q0.e.a) == false) goto L8;
        r0.k.setText(2131902189);
        e1.o(r0.j);
        e1.o(r0.f);
        e1.o(r0.g);
        return Unit.INSTANCE;
    L8:
        if (Intrinsics.areEqual(r5, q0.f.a) == false) goto L11;
        r0.k.setText(Z90(r5));
        e1.o(r0.j);
        e1.o(r0.f);
        e1.o(r0.g);
        return Unit.INSTANCE;
    L11:
        if ((r5 instanceof q0.d) == false) goto L14;
        qa0(r5, ((q0.d) r5).a);
        return Unit.INSTANCE;
    L14:
        if ((r5 instanceof q0.c) == false) goto L17;
        r0.k.setText(Z90(r5));
        e1.x(r0.j);
        r0.j.setText(ma0(((q0.c) r5).a));
        e1.o(r0.f);
        e1.x(r0.g);
        return Unit.INSTANCE;
    L17:
        if ((r5 instanceof q0.b) == false) goto L31;
        o5.a(this, "fragment_request_key_onboarding_start", com.larus.utils.f.c(new Pair[0]));
        CommonDialog r1 = this.e;
        if (r1 == null) goto L27;
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L22
    L22:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L27;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L27:
        if (oa0() == false) goto L29;
        X90().authDevice(((q0.b) r5).a);
        return Unit.INSTANCE;
    L29:
        Handler r3 = new Handler(Looper.getMainLooper());
        b r4 = new b(this, r5);
        r3.postDelayed(r4, 200);
        return r4;
    L31:
        if ((r5 instanceof q0.a) == false) goto L34;
        qa0(r5, ((q0.a) r5).a);
        return Unit.INSTANCE;
    L34:
        throw new NoWhenBranchMatchedException();
    L35:
        return null;
    }

    public void ga0(final DoraDevice r7) {
        Intrinsics.checkNotNullParameter(r7, "device");
        boolean r1 = false;
        if (this.f != null) goto L5;
        String r0 = la0();
        String r2 = AppHost.a.getApplication().getString(2131903934, new Object[]{r0});
        CommonDialog.a r3 = new CommonDialog.a();
        r3.i(getString(2131902447));
        r3.g(r2);
        CommonDialog.a.f(r3, new i(this, r7), getString(2131902418), false, 12);
        CommonDialog.a.e(r3, new j(this, r7), getString(2131902465), 4);
        r3.z = false;
        Function0<Boolean> r4 = new com.larus.dora.impl.onboarding.g.v2.base.d(this, r7);
        Intrinsics.checkNotNullParameter(r4, "callback");
        r3.B = r4;
        this.f = r3.a();
    L5:
        CommonDialog r8 = this.f;
        if (r8 != null) goto L8;
    L10:
        if (r1 == true) goto L15;
        CommonDialog r9 = this.f;
        if (r9 == null) goto L16;
        T90(r9, getChildFragmentManager());
        return;
    L16:
        return;
    L15:
        return;
    L8:
        if (r8.isVisible() != true) goto L10;
        r1 = true;
        goto L10
    }

    public final void ha0(boolean r20) {
        Bundle r1 = getArguments();
        if (r1 == null) goto L5;
        String r2 = r1.getString("bury_point_source");
    L6:
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        this.i = r2;
        if (aa0() == true) goto L20;
        BottomSheetDialog r3 = getDialog();
        if ((r3 instanceof BottomSheetDialog) == false) goto L13;
        BottomSheetDialog r4 = r3;
    L14:
        if (r4 == null) goto L16;
        View r5 = r4.findViewById(2131368870);
    L17:
        int r6 = m0.a;
        int r7 = m0.a(getContext());
        i0.a.getClass();
        int r8 = ((r7 - i0.g()) - i0.e()) - i5.c0();
        if (r5 == null) goto L20;
        r5.setLayoutParams(r5.getLayoutParams());
        BottomSheetBehavior r9 = BottomSheetBehavior.from(r5);
        r5.setBackgroundResource(R.color.transparent);
        r9.setState(3);
        r9.setPeekHeight(r8);
        goto L20
    L16:
        r5 = null;
        goto L17
    L13:
        r4 = null;
    L20:
        if (r20 == false) goto L22;
        Lifecycle.State r10 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraGOnboardingDialogBaseFragment$initializeOnboardingContent$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r10, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraGOnboardingDialogBaseFragment$initializeOnboardingContent$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r10, null, this), 3, null);
    L23:
        LarusDoraGOnboardingDialogBinding r11 = this.d;
        if (r11 == null) goto L27;
        e1.d(r11.e, new com.larus.dora.impl.onboarding.g.v2.base.b(this));
        e1.d(r11.f, new com.larus.dora.impl.onboarding.g.v2.base.c(this));
        return;
    L27:
        return;
    L22:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DoraGOnboardingDialogBaseFragment$initializeOnboardingContent$4(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DoraGOnboardingDialogBaseFragment$initializeOnboardingContent$5(this, null), 3, null);
        goto L23
    L5:
        r2 = null;
        goto L6
    }

    public final Dialog onCreateDialog(Bundle r3) {
        if (aa0() == true) goto L7;
        return super.onCreateDialog(r3);
    L7:
        if (ia0() == true) goto L13;
        g49.d.d("DoraOnboardingDialogFragment", "Dora G is disabled, block G onboarding dialog");
        S90(this);
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L12;
        r0.finish();
    L12:
        return super.onCreateDialog(r3);
    L13:
        LarusDoraGOnboardingDialogBinding r4 = LarusDoraGOnboardingDialogBinding.a(LayoutInflater.from(requireContext()), null);
        this.d = r4;
        FrameLayout r5 = r4.a;
        if (r5 == null) goto L22;
        Dialog r6 = U90(r5);
        if (r6 == null) goto L20;
        ha0(false);
        ja0();
        return r6;
    L20:
        throw new IllegalArgumentException("Custom onboarding dialog container must provide a Dialog.".toString());
    L22:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static void T90(CommonDialog r2, FragmentManager r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, null, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.show(r3, null);
    }

    public void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r2, r3);
        ha0(true);
        ja0();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void qa0(q0 r3, DoraDevice r4) {
        Intrinsics.checkNotNullParameter(r3, "state");
        Intrinsics.checkNotNullParameter(r4, "device");
        LarusDoraGOnboardingDialogBinding r0 = this.d;
        if (r0 == null) goto L6;
        r0.k.setText(Z90(r3));
        e1.x(r0.j);
        r0.j.setText(ma0(r4));
        e1.x(r0.f);
        r0.f.setText(2131903671);
        e1.o(r0.g);
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        if (aa0() == false) goto L6;
        return null;
    L6:
        if (ia0() == true) goto L11;
        g49.d.d("DoraOnboardingDialogFragment", "Dora G is disabled, block G onboarding dialog");
        S90(this);
        FragmentActivity r5 = getActivity();
        if (r5 == null) goto L10;
        r5.finish();
    L10:
        return null;
    L11:
        LarusDoraGOnboardingDialogBinding r6 = LarusDoraGOnboardingDialogBinding.a(r2, r3);
        this.d = r6;
        return r6.a;
    }
}
