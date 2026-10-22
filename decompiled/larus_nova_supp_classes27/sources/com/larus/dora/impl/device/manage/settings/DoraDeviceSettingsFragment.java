package com.larus.dora.impl.device.manage.settings;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.crash.Npth;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.databinding.LarusDoraPageDeviceSettingsBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.dynamic.DslCardAdapter;
import com.larus.dora.impl.model.DoraBuryPointSource;
import com.larus.dora.impl.onboarding.dialog.DoraOnboardingAudioSettingDialog;
import com.larus.dora.impl.util.DoraConnectChecker;
import com.larus.dora.impl.util.b0;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0002&)\u0018\u0000 ^2\u00020\u0001:\u0001^B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u001a\u00103\u001a\u0002042\u0006\u00105\u001a\u00020,2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u00106\u001a\u000204H\u0002J\b\u00107\u001a\u000204H\u0002J\"\u00108\u001a\u0002042\u0006\u0010\u0006\u001a\u00020\u00072\b\u00109\u001a\u0004\u0018\u00010\u001e2\u0006\u0010:\u001a\u00020;H\u0002J\b\u0010<\u001a\u000204H\u0002J\b\u0010=\u001a\u000204H\u0002J\u001c\u0010>\u001a\u0002042\b\u0010\u0015\u001a\u0004\u0018\u00010?2\b\u0010@\u001a\u0004\u0018\u00010AH\u0002J\u0010\u0010B\u001a\u0002042\u0006\u00109\u001a\u00020\u001eH\u0002J\u0010\u0010C\u001a\u0002042\u0006\u00109\u001a\u00020\u001eH\u0002J\u0010\u0010D\u001a\u0002042\u0006\u00109\u001a\u00020\u001eH\u0002J\u0010\u0010E\u001a\u0002042\u0006\u00109\u001a\u00020\u001eH\u0002J\u0010\u0010F\u001a\u0002042\u0006\u0010G\u001a\u00020\u000fH\u0002J\u000e\u0010H\u001a\u0002042\u0006\u0010I\u001a\u00020JJ\u0016\u0010K\u001a\u0002042\u0006\u0010L\u001a\u00020M2\u0006\u0010I\u001a\u00020JJ\u001c\u0010N\u001a\u0002042\b\u0010O\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010P\u001a\u00020\u0011H\u0002J\b\u0010Q\u001a\u000204H\u0016J0\u0010R\u001a\u0002042\b\b\u0002\u0010S\u001a\u00020\u00112\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u000f2\u0010\b\u0002\u0010T\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010UH\u0002J\b\u0010V\u001a\u00020\u000fH\u0016J\b\u0010W\u001a\u000204H\u0016J\b\u0010X\u001a\u000204H\u0016J\b\u0010Y\u001a\u000204H\u0016J\b\u0010Z\u001a\u000204H\u0016J\u0010\u0010[\u001a\u0002042\u0006\u0010\\\u001a\u00020]H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u0010'R\u0010\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0004\n\u0002\u0010*¨\u0006_"}, d2 = {"Lcom/larus/dora/impl/device/manage/settings/DoraDeviceSettingsFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageDeviceSettingsBinding;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/device/manage/settings/DoraDeviceSettingsViewModel;", "getModel", "()Lcom/larus/dora/impl/device/manage/settings/DoraDeviceSettingsViewModel;", "model$delegate", "Lkotlin/Lazy;", "aboveTabAdapter", "Lcom/larus/dora/impl/dynamic/DslCardAdapter;", "mPageKey", "", "isFirst", "", "isInitialLoad", "connectFailedDialog", "Lcom/larus/dora/impl/device/manage/settings/DoraDeviceSettingsConnectFailedDialog;", "unbindDialog", "Lcom/larus/common_ui/dialog/CommonDialog;", "dynamicHandler", "Landroid/os/Handler;", "handlerThread", "Landroid/os/HandlerThread;", "connectChecker", "Lcom/larus/dora/impl/util/DoraConnectChecker;", "selectedDevice", "Lcom/bytedance/dora/device/DoraDevice;", "btSwitch", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "lastCardContextDeviceMac", "buryPointSource", "pendingReconnectMac", "localReceiver", "com/larus/dora/impl/device/manage/settings/DoraDeviceSettingsFragment$localReceiver$1", "Lcom/larus/dora/impl/device/manage/settings/DoraDeviceSettingsFragment$localReceiver$1;", "sysReceiver", "com/larus/dora/impl/device/manage/settings/DoraDeviceSettingsFragment$sysReceiver$1", "Lcom/larus/dora/impl/device/manage/settings/DoraDeviceSettingsFragment$sysReceiver$1;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "showAudioSettingDialogIfNeeded", "setupListener", "showConnectFailedDialog", "device", "fragment", "Landroidx/fragment/app/Fragment;", "dismissConnectFailedDialog", "dismissUnbindDialog", "showUnbindConfirmDialog", "Lcom/larus/dora/impl/dynamic/dsl/DslDialog;", "cardContext", "Lcom/larus/dora/impl/dynamic/entity/CardContext;", "handleUnbind", "showGUnbindDialog", "showNotGUnbindDialog", "unbindAndDisconnect", "setupAdapter", "pageTitle", "setUpPageView", "pageInfo", "Lcom/larus/dora/impl/dynamic/dsl/DslDeviceManagementPage;", "updatePageByConnectionState", "connectionState", "Lcom/larus/dora/impl/dynamic/event/DeviceConnectionState;", "loadDeviceData", "mac", "forceRefresh", "onPause", "checkReady", "isReconnect", "onReady", "Lkotlin/Function0;", "getCurrentPageName", "onDestroyView", "onStart", "onResume", "onStop", "onAttach", "context", "Landroid/content/Context;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraDeviceSettingsFragment extends DoraBaseFragment {
    public static final /* synthetic */ int w = 0;
    public LarusDoraPageDeviceSettingsBinding f;
    public final Lazy g;
    public DslCardAdapter h;
    public String i;
    public boolean j;
    public DoraDeviceSettingsConnectFailedDialog k;
    public CommonDialog l;
    public Handler m;
    public PthreadHandlerThreadV2 n;
    public final DoraConnectChecker o;
    public volatile DoraDevice p;
    public ActivityResultLauncher<Intent> q;
    public String r;
    public String s;
    public String t;
    public final DoraDeviceSettingsFragment$localReceiver$1 u;
    public final DoraDeviceSettingsFragment$sysReceiver$1 v;

    public static final class a {
    }

    public static final class b<T> implements FlowCollector {
        public final /* synthetic */ DoraDeviceSettingsFragment a;

        public b(DoraDeviceSettingsFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r3, Continuation r4) {
            DoraDeviceSettingsViewModel.e r5 = (DoraDeviceSettingsViewModel.e) r3;
            g49.d.d("DoraDeviceSettingsFragment", "deviceStateFlow collect " + r5);
            if (Intrinsics.areEqual(r5, DoraDeviceSettingsViewModel.e.d.a) == true) goto L17;
            if ((r5 instanceof DoraDeviceSettingsViewModel.e.a) == false) goto L10;
            DoraDeviceSettingsFragment r6 = this.a;
            Handler r0 = r6.m;
            if (r0 == null) goto L17;
            Boxing.boxBoolean(r0.post(new r(r5, r6)));
            goto L17
        L10:
            if ((r5 instanceof DoraDeviceSettingsViewModel.e.b) == true) goto L17;
            if ((r5 instanceof DoraDeviceSettingsViewModel.e.c) == false) goto L17;
            DoraDeviceSettingsFragment r7 = this.a;
            Handler r1 = r7.m;
            if (r1 == null) goto L17;
            Boxing.boxBoolean(r1.post(new s(r5, r7)));
        L17:
            return Unit.INSTANCE;
        }
    }

    public static final class c implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public c(Function1 r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    public final String k() {
        return "dora_setting_detail";
    }

    public final void X90() {
        CommonDialog r0 = this.l;
        if (r0 == null) goto L15;
        if (r0 != null) goto L13;
    L11:
        this.l = null;
        return;
    L13:
        r0.dismissAllowingStateLoss();     // Catch: Exception -> L7
    L7:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r1 = DialogFragmentLancet.sLastShowStack;
        if (r1 == null) goto L11;
        com.bytedance.crash.d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L11
    }

    public final DoraDeviceSettingsViewModel Y90() {
        return (DoraDeviceSettingsViewModel) this.g.getValue();
    }

    public final void aa0() {
        b0.a.getClass();
        if (b0.j().getBoolean("dora_need_show_audio_settings_dialog", false) == true) goto L5;
        return;
    L5:
        if (DoraAdapterExtKt.t(kj4.a.g()) == false) goto L16;
        b0.j().storeBoolean("dora_need_show_audio_settings_dialog", false);
        DoraOnboardingAudioSettingDialog r0 = new DoraOnboardingAudioSettingDialog();
        FragmentManager r1 = getChildFragmentManager();
        LandscapeRestrictionOperation r2 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, "OnboardingAudioSetting", r2);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r1, r0, r2) == true) goto L17;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r0.show(r1, "OnboardingAudioSetting");
        return;
    L17:
        return;
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.larus.dora.impl.device.manage.settings.DoraDeviceSettingsFragment$sysReceiver$1] */
    public DoraDeviceSettingsFragment() {
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraDeviceSettingsViewModel.class), new DoraDeviceSettingsFragment$special$$inlined$activityViewModels$default$1(this), new DoraDeviceSettingsFragment$special$$inlined$activityViewModels$default$2(this));
        this.j = true;
        PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2("dora_dynamic");
        ThreadMethodProxy.start(r0);
        this.m = new Handler(r0.getLooper());
        this.n = r0;
        this.o = new DoraConnectChecker(this);
        this.s = "";
        this.u = new DoraDeviceSettingsFragment$localReceiver$1(this);
        this.v = new DoraDeviceSettingsFragment$sysReceiver$1(this);
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        LocalBroadcastManager.getInstance(AppHost.a.getApplication()).unregisterReceiver(this.u);
        Handler r0 = this.m;
        if (r0 == null) goto L5;
        r0.removeCallbacksAndMessages(null);
    L5:
        this.m = null;
        PthreadHandlerThreadV2 r1 = this.n;
        if (r1 == null) goto L8;
        r1.quitSafely();
    L8:
        this.n = null;
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        Application r0 = AppHost.a.getApplication();
        DoraDeviceSettingsFragment$sysReceiver$1 r1 = this.v;
        ReceiverRegisterLancet.loge(r1, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L14;
        r0.unregisterReceiver(r1);
        return;
    L14:
    L8:
        e = move-exception;
        if (r1 == null) goto L11;
        Npth.addTag("unregisterReceiver", r1.toString());
    L11:
        e.printStackTrace();
        return;
    L5:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r1, r0) == false) goto L16;
        r0.unregisterReceiver(r1);     // Catch: Exception -> L8
        return;
    }

    public final void onResume() {
        super.onResume();
        if (this.j == false) goto L5;
        this.j = false;
    L10:
        IntentFilter r0 = new IntentFilter("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
        r0.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        r0.addAction("android.bluetooth.device.action.ACL_CONNECTED");
        r0.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        r0.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
        r0.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
        Application r10 = AppHost.a.getApplication();
        DoraDeviceSettingsFragment$sysReceiver$1 r11 = this.v;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L41;
        ReceiverRegisterCrashOptimizer.registerReceiver(r11, r0);
        return;
    L41:
        throw e;
    L14:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L27;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r0) == false) goto L27;
        int r2 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r11, r0, 0, null, null, 2, r10).result;     // Catch: Exception -> L36
        if (r2 != 1) goto L20;
        r10.registerReceiver(r11, r0);     // Catch: Exception -> L36
        return;
    L20:
        if (r2 != 2) goto L22;
        new Intent();     // Catch: Exception -> L36
        return;
    L22:
        if (r2 == 3) goto L43;
        r10.registerReceiver(r11, r0);     // Catch: Exception -> L36
        return;
    L43:
        return;
    L27:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L30;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        r10.registerReceiver(r11, r0, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L36
        return;
    L30:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L32;
    L34:
        r10.registerReceiver(r11, r0);     // Catch: Exception -> L36
        return;
    L32:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r0) == false) goto L34;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        ContextCompat.registerReceiver(r10, r11, r0, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L36
        return;
    L5:
        g49.d.d("DoraDeviceSettingsFragment", "onResume: refresh device data");
        DoraDevice r1 = this.p;
        if (r1 == null) goto L8;
        String r3 = r1.mac;
    L9:
        Z90(r3, true);
        goto L10
    L8:
        r3 = null;
        goto L9
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void onStart() {
        super.onStart();
        aa0();
        DoraDeviceSettingsViewModel.checkLocalBindState$default(Y90(), this.p, 0, 2, null);
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void onStop() {
        super.onStop();
    }

    public final void ba0(DoraDevice r8) {
        String r6 = null;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DoraDeviceSettingsFragment$unbindAndDisconnect$1(r8, null), 3, null);
        Intent r0 = new Intent("action.DEVICE_UNBIND");
        Context r1 = getContext();
        if (r1 == null) goto L5;
        r6 = r1.getPackageName();
    L5:
        r0.setPackage(r6);
        if (TextUtils.isEmpty(r8.mac) == true) goto L8;
        r0.putExtra("mac", r8.mac);
    L8:
        LocalBroadcastManager.getInstance(AppHost.a.getApplication()).sendBroadcast(r0);
    }

    public final void onAttach(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super/*androidx.fragment.app.Fragment*/.onAttach(r5);
        DoraConnectChecker r6 = this.o;
        String r0 = this.s;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r0, "buryPointSource");
        r6.b = r6.a.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new com.larus.dora.impl.util.j(r6, r0));
        this.q = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new k(this));
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

    public final synchronized void Z90(String r2, boolean r3) {
        monitor-enter(this);
        if (r2 != null) goto L39;
    L10:
        boolean r0 = true;
    L11:
        if (r0 == false) goto L13;
        g49.d.d("DoraDeviceSettingsFragment", "load device data failed. mac is empty!!");     // Catch: Throwable -> L8
    L35:
        monitor-exit(this);
        return;
    L13:
        DoraDevice r4 = com.larus.dora.impl.dynamic.i.a(r2);     // Catch: Throwable -> L8
        if (r4 == null) goto L25;
        if (r3 == true) goto L24;
        DoraDevice r5 = this.p;     // Catch: Throwable -> L8
        if (r5 == null) goto L19;
        String r6 = r5.mac;     // Catch: Throwable -> L8
    L21:
        if (Intrinsics.areEqual(r6, r4.mac) == false) goto L24;
        monitor-exit(this);
        return;
    L19:
        r6 = null;
    L24:
        this.p = r4;     // Catch: Throwable -> L8
    L25:
        final DoraDevice r7 = this.p;     // Catch: Throwable -> L8
        if (r7 == null) goto L35;
        Handler r8 = this.m;     // Catch: Throwable -> L8
        if (r8 == null) goto L31;
        r8.post(new d(this, r7));     // Catch: Throwable -> L8
    L31:
        if (kj4.a.g().getDoraLinkState(this.p) != 2) goto L35;
        DoraDevice r9 = this.p;     // Catch: Throwable -> L8
        if (r9 == null) goto L35;
        Y90().checkBindState(r9);     // Catch: Throwable -> L8
        goto L35
    L39:
    L8:
        th = move-exception;
        throw th;
    L5:
        if (r2.length() == 0) goto L10;
        r0 = false;
        goto L11
    }

    public final synchronized void ca0(e59.b r4, c59.m r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r4, "connectionState");     // Catch: Throwable -> L25
        Intrinsics.checkNotNullParameter(r5, "pageInfo");     // Catch: Throwable -> L25
        g49.d.d("DoraDeviceSettingsFragment", "updatePageByConnectionState, connectionState = " + r4);     // Catch: Throwable -> L25
        if (this.f == null) goto L23;
        int r1 = 1;
        if ((r4 instanceof e59.b.a) == false) goto L15;
        String r6 = ((e59.b.a) r4).a;     // Catch: Throwable -> L25
        DoraDevice r0 = this.p;     // Catch: Throwable -> L25
        if (r0 == null) goto L11;
        String r2 = r0.mac;     // Catch: Throwable -> L25
    L13:
        if (Intrinsics.areEqual(r6, r2) == false) goto L15;
        boolean r7 = true;
    L16:
        if (r7 == false) goto L18;
        r1 = 0;
    L18:
        c59.n r8 = (c59.n) CollectionsKt.getOrNull(r5.b, r1);     // Catch: Throwable -> L25
        if (r8 == null) goto L23;
        List<c59.i> r9 = r8.a;     // Catch: Throwable -> L25
        DslCardAdapter r10 = this.h;     // Catch: Throwable -> L25
        if (r10 == null) goto L23;
        r10.B2(r9);     // Catch: Throwable -> L25
        goto L23
    L11:
        r2 = null;
    L15:
        r7 = false;
    L23:
        monitor-exit(this);
        return;
    L25:
        th = move-exception;
        throw th;
    }

    public final void onViewCreated(View r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r14, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r14, r15);
        Bundle r16 = getArguments();
        if (r16 == null) goto L5;
        r16.getString("page_title");
    L5:
        Bundle r17 = getArguments();
        if (r17 == null) goto L8;
        String r18 = r17.getString("bury_point_source", DoraBuryPointSource.DEVICE_PAGE);
    L9:
        String r0 = "";
        if (r18 != null) goto L12;
        r18 = "";
    L12:
        this.s = r18;
        Bundle r110 = getArguments();
        if (r110 == null) goto L15;
        String r111 = r110.getString(DoraObricDeviceHomeViewModel.PARAM_PREVIOUS_PAGE);
    L16:
        if (r111 == null) goto L19;
        r0 = r111;
    L19:
        this.i = r0;
        IntentFilter r112 = new IntentFilter("action.DEVICE_UNBIND");
        r112.addAction("action.DEVICE_UPDATE_DYNAMIC");
        r112.addAction("action.DEVICE_UPDATE_NAME");
        r112.addAction("action.DEVICE_ENTER_SIMUL_INTERPRET");
        LocalBroadcastManager.getInstance(AppHost.a.getApplication()).registerReceiver(this.u, r112);
        LarusDoraPageDeviceSettingsBinding r113 = this.f;
        if (r113 == null) goto L24;
        NovaTitleBarEx r1 = r113.c;
        if (r1 == null) goto L24;
        NovaTitleBarEx.Y5(r1, "设置", null, null, 6);
        NovaTitleBarEx.b6(r1, 2131240517, false, null, null, new h(this), 14);
    L24:
        this.h = new DslCardAdapter(Y90());
        LarusDoraPageDeviceSettingsBinding r114 = this.f;
        if (r114 == null) goto L30;
        RecyclerView r115 = r114.b;
        if (r115 == null) goto L30;
        r115.setLayoutManager(new LinearLayoutManager(r115.getContext()));
    L30:
        if (this.f == null) goto L37;
        Y90().getCardContextData().observe(getViewLifecycleOwner(), new c(new o(this)));
        Y90().getPageInfoData().observe(getViewLifecycleOwner(), new c(new p(this)));
        LarusDoraPageDeviceSettingsBinding r116 = this.f;
        if (r116 == null) goto L36;
        RecyclerView r117 = r116.b;
        if (r117 == null) goto L36;
        r117.setLayoutManager(new LinearLayoutManager(r117.getContext()));
        r117.setAdapter(this.h);
    L36:
        Y90().getViewHolderEvent().observe(getViewLifecycleOwner(), new c(new e()));
        Y90().getConnectionState().observe(getViewLifecycleOwner(), new c(new f(this)));
    L37:
        Bundle r118 = getArguments();
        if (r118 == null) goto L40;
        String r119 = r118.getString(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MAC);
    L41:
        List r2 = DoraAdapterExtKt.k(kj4.a.g());
        if (r119 != null) goto L44;
    L47:
        boolean r3 = true;
    L48:
        if (r3 == true) goto L57;
        Iterator r4 = r2.iterator();
    L51:
        if (r4.hasNext() == false) goto L55;
        Object r5 = r4.next();
        if (Intrinsics.areEqual(((DoraDevice) r5).mac, r119) == false) goto L51;
    L56:
        DoraDevice r6 = (DoraDevice) r5;
    L60:
        if (r6 == null) goto L62;
        String r120 = r6.mac;
    L63:
        Z90(r120, false);
        Y90().getDialogEvent().observe(getViewLifecycleOwner(), new c(new n(this)));
        Lifecycle.State r121 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraDeviceSettingsFragment$setupListener$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r121, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraDeviceSettingsFragment$setupListener$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r121, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraDeviceSettingsFragment$setupListener$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r121, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraDeviceSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r121, null, this), 3, null);
        return;
    L62:
        r120 = null;
        goto L63
    L55:
        r5 = null;
        goto L56
    L57:
        r6 = DoraAdapterExtKt.h(kj4.a.g());
        if (r6 != null) goto L60;
        r6 = (DoraDevice) CollectionsKt.firstOrNull(r2);
        goto L60
    L44:
        if (r119.length() == 0) goto L47;
        r3 = false;
        goto L48
    L40:
        r119 = null;
        goto L41
    L15:
        r111 = null;
        goto L16
    L8:
        r18 = null;
        goto L9
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        ConstraintLayout r5 = r2.inflate(2131562261, r3, false);
        int r6 = 2131384076;
        RecyclerView r7 = ViewBindings.findChildViewById(r5, 2131384076);
        if (r7 == null) goto L9;
        r6 = 2131388772;
        NovaTitleBarEx r0 = ViewBindings.findChildViewById(r5, 2131388772);
        if (r0 == null) goto L9;
        ConstraintLayout r8 = r5;
        this.f = new LarusDoraPageDeviceSettingsBinding(r8, r7, r0);
        return r8;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}
