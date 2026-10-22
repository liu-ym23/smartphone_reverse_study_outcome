package com.larus.dora.obric.device_management.device_bind;

import android.app.Application;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.router.SmartRouter;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.onboarding.DoraOnboardingDialogViewModel;
import com.larus.dora.impl.onboarding.DoraOnboardingPromptDialogFragment;
import com.larus.dora.impl.onboarding.TOAST_TYPE;
import com.larus.dora.impl.onboarding.o0;
import com.larus.dora.impl.onboarding.othersmart.DoraExternalDeviceOnboardingDialogFragment;
import com.larus.dora.impl.onboarding.p0;
import com.larus.dora.impl.onboarding.q0;
import com.larus.dora.impl.onboarding.x;
import com.larus.platform.api.g1;
import com.larus.platform.service.i2;
import com.larus.utils.j0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.oui.text.OTextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import v19.o5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 [2\u00020\u0001:\u0001[B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020&H\u0016J$\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u001a\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020(2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u00101\u001a\u00020\u0012H\u0016J\b\u00102\u001a\u00020\u0012H\u0016J\b\u00103\u001a\u00020\u0012H\u0016J\b\u00104\u001a\u00020\u0019H\u0016J\b\u00105\u001a\u000206H\u0002J\b\u00107\u001a\u00020(H\u0002J\b\u00108\u001a\u00020\u0012H\u0002J\u0010\u00109\u001a\u00020\u00122\u0006\u0010:\u001a\u00020;H\u0002J \u0010<\u001a\u00020\u00122\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u00192\u0006\u0010@\u001a\u00020\u000bH\u0002J\u0018\u0010A\u001a\u00020\u00122\u0006\u0010B\u001a\u00020\u00192\u0006\u0010@\u001a\u00020\u000bH\u0002J\b\u0010C\u001a\u00020\u0012H\u0002J\u0010\u0010D\u001a\u00020\u00122\u0006\u0010E\u001a\u00020FH\u0002J\u0010\u0010G\u001a\u00020\u00122\u0006\u0010H\u001a\u00020IH\u0002J\u0010\u0010J\u001a\u00020\u00122\u0006\u0010=\u001a\u00020>H\u0002J\b\u0010K\u001a\u00020\u0012H\u0002J\b\u0010L\u001a\u00020MH\u0002J\b\u0010N\u001a\u00020\u0012H\u0002J\u0010\u0010O\u001a\u00020\u00122\u0006\u0010=\u001a\u00020>H\u0002J\b\u0010P\u001a\u00020\u0012H\u0003J\f\u0010Q\u001a\u00020>*\u00020RH\u0002J\f\u0010S\u001a\u00020\u0019*\u00020RH\u0002J \u0010T\u001a\u00020\u00122\b\b\u0002\u0010U\u001a\u00020\u00192\f\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\u001e\u0010W\u001a\u00020\u00122\u0006\u0010U\u001a\u00020\u00192\f\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\b\u0010X\u001a\u00020\u0012H\u0002J\u0010\u0010Y\u001a\u00020\u00122\u0006\u0010Z\u001a\u00020\u0019H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\\"}, d2 = {"Lcom/larus/dora/obric/device_management/device_bind/DoraObricSmartDeviceBindFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "scanModel", "Lcom/larus/dora/impl/onboarding/DoraOnboardingDialogViewModel;", "getScanModel", "()Lcom/larus/dora/impl/onboarding/DoraOnboardingDialogViewModel;", "scanModel$delegate", "Lkotlin/Lazy;", "isChecking", "", "onboardingDialogFragment", "Lcom/larus/dora/impl/onboarding/DoraOnboardingDialogBaseFragment;", "gpsDialog", "Lcom/larus/common_ui/dialog/CommonDialog;", "pendingCheckAction", "Lkotlin/Function0;", "", "btSwitch", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "productId", "", "prePage", "", "buryPointSource", "mac", "sku", "vendorId", "bindButtonText", "needUnbindDialog", "connectFailedDialog", "Lcom/larus/dora/impl/onboarding/DoraOnboardingPromptDialogFragment;", "pageRenderer", "Lcom/larus/dora/obric/device_management/device_bind/DoraObricBindPageRenderer;", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onResume", "onStop", "onDestroyView", "getCurrentPageName", "buildNativePageContent", "Lcom/larus/dora/obric/device_management/device_bind/DoraObricBindPageRenderer$Content;", "buildContentView", "onBindButtonClicked", "handleUiState", "state", "Lcom/larus/dora/impl/onboarding/OnboardingUiState;", "renderFoundDevice", "device", "Lcom/bytedance/dora/device/DoraDevice;", "buttonText", "enabled", "renderBindButton", "text", "showScanLongTimeDialog", "showConnectFailedDialog", "uiState", "Lcom/larus/dora/impl/onboarding/OnboardingUiState$DeviceConnectFailed;", "handleAction", "action", "Lcom/larus/dora/impl/onboarding/OnboardingAction;", "showNeedUnbindDialog", "startBind", "resolveScanProductType", "Lcom/bytedance/dora/annotation/ProductNameType;", "launchOnboarding", "gotoOnboardingPage", "bindBondedDeviceIfNeeded", "toDoraDevice", "Landroid/bluetooth/BluetoothDevice;", "safeBluetoothName", "checkReady", "from", "doNext", "requestPermissions", "showGpsDialog", "handlePermissionDenied", "reason", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricSmartDeviceBindFragment extends DoraBaseFragment {
    public static final /* synthetic */ int v = 0;
    public final Lazy f;
    public boolean g;
    public DoraExternalDeviceOnboardingDialogFragment h;
    public CommonDialog i;
    public Function0<Unit> j;
    public ActivityResultLauncher<Intent> k;
    public int l;
    public String m;
    public String n;
    public String o;
    public String p;
    public int q;
    public String r;
    public CommonDialog s;
    public DoraOnboardingPromptDialogFragment t;
    public f u;

    public static final class a {
    }

    public /* synthetic */ class b implements FlowCollector, FunctionAdapter {
        public final /* synthetic */ DoraObricSmartDeviceBindFragment a;

        public b(DoraObricSmartDeviceBindFragment r1) {
            this.a = r1;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof FlowCollector) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return new AdaptedFunctionReference(2, this.a, DoraObricSmartDeviceBindFragment.class, "handleUiState", "handleUiState(Lcom/larus/dora/impl/onboarding/OnboardingUiState;)V", 4);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final Object emit(Object r10, Continuation r11) {
            q0 r12 = (q0) r10;
            DoraObricSmartDeviceBindFragment r13 = this.a;
            int r0 = DoraObricSmartDeviceBindFragment.v;
            r13.getClass();
            g49.d.d("DoraObricSmartDeviceBindFragment", "handleUiState: " + r12);
            boolean r2 = false;
            if (Intrinsics.areEqual(r12, q0.e.a) == false) goto L16;
            f r14 = r13.u;
            if (r14 == null) goto L9;
            OTextView r15 = r14.h;
            if (r15 == null) goto L9;
            r15.setVisibility(8);
        L9:
            String r16 = r13.r;
            if (r16.length() <= 0) goto L12;
            r2 = true;
        L12:
            f r17 = r13.u;
            if (r17 == null) goto L61;
            r17.g(r16, r2);
        L61:
            Unit r18 = Unit.INSTANCE;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return r18;
        L16:
            if (Intrinsics.areEqual(r12, q0.f.a) == false) goto L24;
            DoraOnboardingPromptDialogFragment r110 = new DoraOnboardingPromptDialogFragment(new w(r13), "scan_long_time");
            r110.setArguments(com.larus.utils.f.c(new Pair[]{TuplesKt.to("key_dora_onboarding_origin_from", r13.m)}));
            DoraObricSmartDeviceBindFragment.X90(r110, r13.getParentFragmentManager());
            r13.ba0().stopScan();
            String r111 = r13.r;
            if (r111.length() <= 0) goto L20;
            r2 = true;
        L20:
            f r112 = r13.u;
            if (r112 == null) goto L61;
            r112.g(r111, r2);
            goto L61
        L24:
            if ((r12 instanceof q0.d) == false) goto L27;
            r13.da0(((q0.d) r12).a, r13.getString(2131902385), true);
            goto L61
        L27:
            if ((r12 instanceof q0.c) == false) goto L30;
            r13.da0(((q0.c) r12).a, r13.getString(2131903844), false);
            goto L61
        L30:
            if ((r12 instanceof q0.b) == false) goto L54;
            o5.a(r13, "fragment_request_key_onboarding_start", com.larus.utils.f.c(new Pair[0]));
            DoraDevice r113 = ((q0.b) r12).a;
            Context r4 = r13.getContext();     // Catch: Throwable -> L51
            if (r4 == null) goto L61;
            LocalBroadcastManager r5 = LocalBroadcastManager.getInstance(AppHost.a.getApplication());     // Catch: Throwable -> L51
            Intent r6 = new Intent("action.DEVICE_UPDATE_DYNAMIC");     // Catch: Throwable -> L51
            r6.putExtra("mac", r113.mac);     // Catch: Throwable -> L51
            r5.sendBroadcast(r6);     // Catch: Throwable -> L51
            com.bytedance.router.i r7 = SmartRouter.buildRoute(r4, "//dora_onboarding_v2");     // Catch: Throwable -> L51
            r7.d = 2130772372;     // Catch: Throwable -> L51
            r7.e = 2130772399;     // Catch: Throwable -> L51
            r7.c.putExtra("key_dora_onboarding_device", x.c(r113));     // Catch: Throwable -> L51
            r7.c.putExtra("bury_point_source", r13.n);     // Catch: Throwable -> L51
            Bundle r114 = r13.getArguments();     // Catch: Throwable -> L51
            if (r114 == null) goto L47;
            String r115 = r114.getString("next_action");     // Catch: Throwable -> L51
            if (r115 == null) goto L47;
            if (r115.length() <= 0) goto L42;
            r2 = true;
        L42:
            if (r2 == true) goto L45;
            r115 = null;
        L45:
            if (r115 == null) goto L47;
            r7.j("next_action", r115);     // Catch: Throwable -> L51
        L47:
            r7.d();     // Catch: Throwable -> L51
            FragmentActivity r116 = r13.getActivity();     // Catch: Throwable -> L51
            if (r116 == null) goto L61;
            r116.finish();     // Catch: Throwable -> L51
        L51:
            th = move-exception;
            g49.d.c("DoraObricSmartDeviceBindFragment", "gotoOnboardingPage failed", th);
            goto L61
        L54:
            if ((r12 instanceof q0.a) == false) goto L64;
            r13.ba0().stopScan();
            if (r13.isResumed() == false) goto L58;
            r13.ea0((q0.a) r12);
        L58:
            String r117 = r13.getString(2131902385);
            f r118 = r13.u;
            if (r118 == null) goto L61;
            r118.g(r117, true);
            goto L61
        L64:
            throw new NoWhenBranchMatchedException();
        }
    }

    public /* synthetic */ class c implements FlowCollector, FunctionAdapter {
        public final /* synthetic */ DoraObricSmartDeviceBindFragment a;

        public c(DoraObricSmartDeviceBindFragment r1) {
            this.a = r1;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof FlowCollector) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return new AdaptedFunctionReference(2, this.a, DoraObricSmartDeviceBindFragment.class, "handleAction", "handleAction(Lcom/larus/dora/impl/onboarding/OnboardingAction;)V", 4);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final Object emit(Object r6, Continuation r7) {
            o0 r8 = (o0) r6;
            final DoraObricSmartDeviceBindFragment r9 = this.a;
            int r0 = DoraObricSmartDeviceBindFragment.v;
            r9.getClass();
            if ((r8 instanceof o0.c) == false) goto L17;
            final DoraDevice r10 = ((o0.c) r8).a;
            boolean r1 = false;
            if (r9.s != null) goto L7;
            CommonDialog.a r2 = new CommonDialog.a();
            r2.i(r9.getString(2131902447));
            r2.g(r9.getString(2131902446));
            CommonDialog.a.f(r2, new u(r9, r10), r9.getString(2131902418), false, 12);
            CommonDialog.a.e(r2, new v(r9, r10), r9.getString(2131902465), 4);
            r2.z = false;
            Function0<Boolean> r3 = new m(r9, r10);
            Intrinsics.checkNotNullParameter(r3, "callback");
            r2.B = r3;
            r9.s = r2.a();
        L7:
            CommonDialog r11 = r9.s;
            if (r11 != null) goto L10;
        L12:
            if (r1 == true) goto L29;
            CommonDialog r12 = r9.s;
            if (r12 == null) goto L29;
            DoraObricSmartDeviceBindFragment.W90(r12, r9.getChildFragmentManager());
        L29:
            Unit r13 = Unit.INSTANCE;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return r13;
        L10:
            if (r11.isVisible() != true) goto L12;
            r1 = true;
            goto L12
        L17:
            if ((r8 instanceof o0.d) == false) goto L23;
            o0.d r14 = (o0.d) r8;
            if (r14.getType() != TOAST_TYPE.TOAST_TYPE_WARNING) goto L21;
            t19.s r15 = t19.s.a;
            Application r4 = AppHost.a.getApplication();
            String r16 = r14.a;
            r15.getClass();
            t19.s.t(r4, r16);
            goto L29
        L21:
            t19.s r17 = t19.s.a;
            Application r5 = AppHost.a.getApplication();
            String r18 = r14.a;
            r17.getClass();
            t19.s.c(r5, r18);
            goto L29
        L23:
            if (Intrinsics.areEqual(r8, o0.a.a) == true) goto L29;
            if ((r8 instanceof o0.b) == true) goto L29;
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class d implements g1.c {
        public final /* synthetic */ Ref.BooleanRef a;
        public final /* synthetic */ DoraObricSmartDeviceBindFragment b;
        public final /* synthetic */ Function0<Unit> c;
        public final /* synthetic */ String d;

        public final void onSettingPageReturn() {
        }

        public final void onGoSettingsDialogShow() {
            this.a.element = true;
        }

        public final void onGoSettingsDialogDismiss(boolean r4) {
            DoraBuryPointManager.a.G(false, this.b.n);
            if (r4 == true) goto L6;
            this.b.ca0("go settings dialog dismissed");
            return;
        }

        public d(Ref.BooleanRef r1, DoraObricSmartDeviceBindFragment r2, Function0<Unit> r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void onResult(boolean r2, List<String> r3, List<String> r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r3, "grantedList");
            Intrinsics.checkNotNullParameter(r4, "deniedList");
            if (r5 == true) goto L5;
            DoraBuryPointManager.a.G(r2, this.b.n);
        L5:
            if (r2 == false) goto L7;
            DoraObricSmartDeviceBindFragment r6 = this.b;
            Function0<Unit> r7 = this.c;
            int r8 = DoraObricSmartDeviceBindFragment.v;
            r6.aa0("check_from_permission_granted", r7);
            return;
        L7:
            DoraObricSmartDeviceBindFragment r9 = this.b;
            r9.g = false;
            if (this.a.element == true) goto L12;
            r9.ca0("permission denied from " + this.d);
            return;
        }
    }

    public static final class e implements p0 {
        public final /* synthetic */ DoraObricSmartDeviceBindFragment a;
        public final /* synthetic */ q0.a b;

        @Override // com.larus.dora.impl.onboarding.p0
        public final void onCloseButtonClick() {
        }

        @Override // com.larus.dora.impl.onboarding.p0
        public final void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "promptType");
            DoraObricSmartDeviceBindFragment r3 = this.a;
            int r0 = DoraObricSmartDeviceBindFragment.v;
            r3.ba0().bindAndConnect(this.b.a);
        }

        public e(DoraObricSmartDeviceBindFragment r1, q0.a r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public final String k() {
        return "obric_smart_device_bind";
    }

    public final DoraOnboardingDialogViewModel ba0() {
        return (DoraOnboardingDialogViewModel) this.f.getValue();
    }

    public final void onDestroyView() {
        f r0 = this.u;
        if (r0 == null) goto L5;
        r0.e = null;
        r0.f = null;
        r0.g = null;
        r0.h = null;
        r0.i = null;
        r0.j = null;
        r0.k = null;
    L5:
        this.u = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public DoraObricSmartDeviceBindFragment() {
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraOnboardingDialogViewModel.class), new DoraObricSmartDeviceBindFragment$special$$inlined$activityViewModels$default$1(this), new DoraObricSmartDeviceBindFragment$special$$inlined$activityViewModels$default$2(this));
        this.j = new l();
        this.l = -1;
        this.n = "";
        this.o = "";
        this.p = "";
        this.q = 4096;
        this.r = "";
    }

    public final void onResume() {
        super.onResume();
        Object r0 = ba0().getUiStateFlow().getValue();
        if ((r0 instanceof q0.a) == false) goto L5;
        q0.a r1 = (q0.a) r0;
    L6:
        if (r1 == null) goto L9;
        ea0(r1);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void onStop() {
        ba0().stopScan();
        super.onStop();
    }

    public final void ca0(String r3) {
        g49.d.d("DoraObricSmartDeviceBindFragment", "handlePermissionDenied: " + r3);
    }

    public final void ea0(q0.a r4) {
        DoraOnboardingPromptDialogFragment r0 = this.t;
        if (r0 != null) goto L12;
    L10:
        DoraOnboardingPromptDialogFragment r1 = new DoraOnboardingPromptDialogFragment(new e(this, r4), "connect_failed");
        r1.setArguments(com.larus.utils.f.c(new Pair[]{TuplesKt.to("key_dora_onboarding_origin_from", this.m)}));
        this.t = r1;
        X90(r1, getParentFragmentManager());
        return;
    L12:
        r0.dismissAllowingStateLoss();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L10;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L10
    }

    public final void onAttach(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super/*androidx.fragment.app.Fragment*/.onAttach(r2);
        this.k = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new q(this));
    }

    public static void W90(CommonDialog r2, FragmentManager r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, null, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.show(r3, null);
    }

    public static void X90(DoraOnboardingPromptDialogFragment r2, FragmentManager r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "DoraObricSmartDeviceBindFragment", r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.show(r3, "DoraObricSmartDeviceBindFragment");
    }

    public static final DoraDevice Z90(DoraObricSmartDeviceBindFragment r10, BluetoothDevice r11) {
        if (Build.VERSION.SDK_INT >= 31) goto L5;
    L38:
        String r0 = r11.getName();     // Catch: SecurityException -> L10
        if (r0 == null) goto L12;
    L13:
        DoraDevice r12 = DoraDevice.from(r11);
        r12.productId = r10.l;
        ProductNameType r1 = ProductNameType.H_FREE_CLIP_2;
        r12.type = r1.deviceType;
        r12.vendorId = r10.q;
        boolean r3 = false;
        String r5 = null;
        if (StringsKt.startsWith$default(r0, "HUAWEI FreeClip 2 HE", false, 2, null) == false) goto L16;
    L27:
        r12.vendorId = 4096;
        ProductNameType r2 = ProductNameType.H_FREE_CLIP_2_HE;
        r12.productId = r2.id;
        r12.type = r2.deviceType;
        r12.sku = 0;
    L28:
        String r13 = r10.p;
        if (r13.length() <= 0) goto L31;
        r3 = true;
    L31:
        if (r3 == false) goto L33;
        r5 = r13;
    L33:
        if (r5 == null) goto L37;
        Integer r14 = StringsKt.toIntOrNull(r5, 16);
        if (r14 == null) goto L37;
        r12.sku = r14.intValue();
    L37:
        return r12;
    L16:
        if (StringsKt.startsWith$default(r0, "HUAWEI FreeClip 2 " + AppHost.a.getApplication().getString(2131903143), false, 2, null) == true) goto L27;
        if (StringsKt.startsWith$default(r0, "HUAWEI FreeClip 2", false, 2, null) == false) goto L21;
    L26:
        r12.vendorId = 4096;
        r12.productId = r1.id;
        r12.type = r1.deviceType;
        r12.sku = 1;
        goto L28
    L21:
        if (StringsKt.startsWith$default(r0, "Robin", false, 2, null) == true) goto L26;
        if (StringsKt.startsWith$default(r0, "HUAWEI FreeBuds Pro 5", false, 2, null) == false) goto L28;
        r12.vendorId = 4096;
        ProductNameType r4 = ProductNameType.H_FREE_BUDS_PRO_5;
        r12.productId = r4.id;
        r12.type = r4.deviceType;
        r12.sku = 1;
    L12:
        r0 = "";
    L10:
        e = move-exception;
        g49.d.c("DoraObricSmartDeviceBindFragment", "read bluetooth name failed", e);
        goto L12
    L5:
        if (l69.a.a("DoraObricSmartDeviceBindFragment") == true) goto L38;
        goto L12
    }

    private final void requestPermissions(String r10, Function0<Unit> r11) {
        ArrayList r1 = new ArrayList();
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 31) goto L5;
        r1.add("android.permission.BLUETOOTH_SCAN");
        r1.add("android.permission.BLUETOOTH_CONNECT");
        r1.add("android.permission.BLUETOOTH");
    L6:
        DoraBuryPointManager.a.H(this.n);
        Ref.BooleanRef r7 = new Ref.BooleanRef();
        i2 r8 = i2.b;
        d r9 = new d(r7, this, r11, r10);
        if (r0 < 31) goto L9;
        int r12 = j0.a;
        Map r13 = MapsKt.mapOf(TuplesKt.to("android.permission.BLUETOOTH_SCAN", j0.d(2131902335)));
    L10:
        g1.a.a(this, r1, r9, r13, null, 16);
        return;
    L9:
        int r2 = j0.a;
        r13 = MapsKt.mapOf(new Pair[]{TuplesKt.to("android.permission.BLUETOOTH", j0.d(2131902335)), TuplesKt.to("android.permission.ACCESS_FINE_LOCATION", j0.d(2131903928)), TuplesKt.to("android.permission.ACCESS_COARSE_LOCATION", j0.d(2131903928))});
        goto L10
    L5:
        r1.add("android.permission.BLUETOOTH");
        r1.add("android.permission.BLUETOOTH_ADMIN");
        r1.add("android.permission.ACCESS_FINE_LOCATION");
        r1.add("android.permission.ACCESS_COARSE_LOCATION");
        goto L6
    }

    public final void aa0(String r8, Function0<Unit> r9) {
        g49.d.d("DoraObricSmartDeviceBindFragment", "checkReady: " + r8 + " start");
        if (Intrinsics.areEqual(r8, "check_from_main") == true) goto L5;
    L7:
        this.g = true;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DoraObricSmartDeviceBindFragment$checkReady$1(r9, this, r8, null), 3, null);
        return;
    L5:
        if (this.g == false) goto L7;
    }

    public final void onViewCreated(View r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r14, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r14, r15);
        f r16 = this.u;
        boolean r17 = true;
        if (r16 == null) goto L9;
        String r2 = getString(2131903836);
        String r3 = getString(2131903834);
        String r6 = this.r;
        if (r6.length() <= 0) goto L7;
        boolean r7 = true;
    L8:
        r16.d(new f.b(r2, r3, 2131240543, null, r6, r7, null, null, false, 456));
        goto L9
    L7:
        r7 = false;
    L9:
        Lifecycle.State r18 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricSmartDeviceBindFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r18, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricSmartDeviceBindFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r18, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricSmartDeviceBindFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r18, null, this), 3, null);
        if (this.o.length() == 0) goto L13;
        r17 = false;
    L13:
        if (r17 == true) goto L17;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new DoraObricSmartDeviceBindFragment$bindBondedDeviceIfNeeded$1(this, null), 2, null);
        return;
    }

    public static final /* synthetic */ void Y90(DoraObricSmartDeviceBindFragment r0, String r1, Function0 r2) {
        r0.requestPermissions(r1, r2);
    }

    public final void da0(DoraDevice r4, String r5, boolean r6) {
        f r0 = this.u;
        if (r0 == null) goto L7;
        String r7 = getString(2131903845, new Object[]{o59.a.d(r4)});
        Intrinsics.checkNotNullParameter(r7, "text");
        OTextView r1 = r0.h;
        if (r1 == null) goto L7;
        r1.setText(r7);
        r1.setVisibility(0);
    L7:
        f r8 = this.u;
        if (r8 == null) goto L11;
        r8.g(r5, r6);
        return;
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Bundle r6 = getArguments();
        String r7 = null;
        if (r6 == null) goto L5;
        String r8 = r6.getString("device_manage");
    L6:
        String r9 = "";
        if (r8 != null) goto L9;
        r8 = "";
    L9:
        this.m = r8;
        Bundle r10 = getArguments();
        if (r10 == null) goto L16;
        String r11 = r10.getString("product_id");
        if (r11 == null) goto L16;
        Integer r12 = StringsKt.toIntOrNull(r11);
        if (r12 == null) goto L16;
        int r13 = r12.intValue();
    L17:
        this.l = r13;
        this.r = getString(2131902189);
        Bundle r14 = getArguments();
        if (r14 == null) goto L20;
        String r15 = r14.getString("extra_mac");
    L21:
        if (r15 != null) goto L23;
        r15 = "";
    L23:
        this.o = r15;
        Bundle r16 = getArguments();
        if (r16 == null) goto L26;
        String r17 = r16.getString("extra_sku");
    L27:
        if (r17 != null) goto L29;
        r17 = "";
    L29:
        this.p = r17;
        Bundle r18 = getArguments();
        int r0 = 4096;
        if (r18 == null) goto L32;
        r0 = r18.getInt("extra_vendor_id", 4096);
    L32:
        this.q = r0;
        Bundle r20 = getArguments();
        if (r20 == null) goto L35;
        r7 = r20.getString("bury_point_source");
    L35:
        if (r7 == null) goto L38;
        r9 = r7;
    L38:
        this.n = r9;
        f r21 = new f(requireContext(), new o(this), new DoraObricSmartDeviceBindFragment$buildContentView$2(this), new p());
        this.u = r21;
        return r21.b();
    L26:
        r17 = null;
        goto L27
    L20:
        r15 = null;
    L16:
        r13 = -1;
        goto L17
    L5:
        r8 = null;
        goto L6
    }
}
