package com.larus.dora.impl.dynamic;

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
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.crash.Npth;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.router.SmartRouter;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.google.android.material.tabs.TabLayout;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.widget.CircleSimpleDraweeView;
import com.larus.dora.api.IDoraGuideService;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.databinding.LarusDoraPageDynamicListBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.device_v2.DoraDeviceConnectFailedV2Dialog;
import com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2;
import com.larus.dora.impl.dynamic.widget.HistoryDeviceNavigationBar;
import com.larus.dora.impl.dynamic.widget.NestedDynamicPageView;
import com.larus.dora.impl.dynamic.widget.NewcomerGuideWidget;
import com.larus.dora.impl.guide.common.DoraGuideMeta;
import com.larus.dora.impl.model.DoraBuryPointSource;
import com.larus.dora.impl.onboarding.dialog.DoraOnboardingAudioSettingDialog;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.util.DoraConnectChecker;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.model.NewcomerGuideItem;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.assistant.spi.dora.IObricDoraService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0002/2\u0018\u0000 \u0082\u00012\u00020\u0001:\u0002\u0082\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\u001a\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u0002052\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\b\u0010?\u001a\u00020=H\u0002J\b\u0010@\u001a\u00020=H\u0002J\b\u0010A\u001a\u00020=H\u0002J\"\u0010B\u001a\u00020=2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010C\u001a\u0004\u0018\u00010\u001d2\u0006\u0010D\u001a\u00020EH\u0002J\b\u0010F\u001a\u00020=H\u0002J\b\u0010G\u001a\u00020=H\u0002J\u001c\u0010H\u001a\u00020=2\b\u0010\u0014\u001a\u0004\u0018\u00010I2\b\u0010J\u001a\u0004\u0018\u00010KH\u0002J\u0010\u0010L\u001a\u00020=2\u0006\u0010C\u001a\u00020\u001dH\u0002J\u0010\u0010M\u001a\u00020=2\u0006\u0010C\u001a\u00020\u001dH\u0002J\u0010\u0010N\u001a\u00020=2\u0006\u0010C\u001a\u00020\u001dH\u0002J\u0010\u0010O\u001a\u00020=2\u0006\u0010C\u001a\u00020\u001dH\u0002J\b\u0010P\u001a\u00020=H\u0002J\u0016\u0010Q\u001a\u00020*2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001fH\u0002J\u0010\u0010S\u001a\u00020=2\u0006\u0010J\u001a\u00020KH\u0002J\u0010\u0010T\u001a\u00020=2\u0006\u0010U\u001a\u00020\u0011H\u0002J\u000e\u0010V\u001a\u00020=2\u0006\u0010W\u001a\u00020XJ\u0010\u0010Y\u001a\u00020=2\u0006\u0010C\u001a\u00020\u001dH\u0002J\u0016\u0010Z\u001a\u00020=2\u0006\u0010[\u001a\u00020\\2\u0006\u0010W\u001a\u00020XJ\u001f\u0010]\u001a\u0004\u0018\u00010&2\u0006\u0010[\u001a\u00020\\2\u0006\u0010^\u001a\u00020*H\u0002¢\u0006\u0002\u0010_J\u0010\u0010`\u001a\u00020*2\u0006\u0010[\u001a\u00020\\H\u0002J\u000f\u0010a\u001a\u0004\u0018\u00010&H\u0002¢\u0006\u0002\u0010bJ\b\u0010c\u001a\u00020=H\u0002J\b\u0010d\u001a\u00020=H\u0002J\u001a\u0010e\u001a\u00020=2\b\u0010f\u001a\u0004\u0018\u00010\u00112\u0006\u0010g\u001a\u00020\u0011H\u0002J\b\u0010h\u001a\u00020=H\u0016J\b\u0010i\u001a\u00020=H\u0002J\b\u0010j\u001a\u00020\u0011H\u0016J\b\u0010o\u001a\u00020=H\u0002J\b\u0010p\u001a\u00020=H\u0002J\u0018\u0010q\u001a\u00020=2\u0006\u0010r\u001a\u00020s2\u0006\u0010t\u001a\u00020\u0011H\u0002J\b\u0010u\u001a\u00020=H\u0016J\b\u0010v\u001a\u00020=H\u0016J\b\u0010w\u001a\u00020=H\u0016J\b\u0010x\u001a\u00020=H\u0016J\u0010\u0010y\u001a\u00020=2\u0006\u0010z\u001a\u00020{H\u0016J\u000e\u0010|\u001a\u00020=2\u0006\u0010}\u001a\u00020;J\u000e\u0010~\u001a\u00020=2\u0006\u0010}\u001a\u00020;J\u0017\u0010\u007f\u001a\u00020=*\u00030\u0080\u00012\b\u0010\u0081\u0001\u001a\u00030\u0080\u0001H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0004\n\u0002\u0010'R\u0010\u0010(\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010+\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0004\n\u0002\u0010,R\u000e\u0010-\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0004\n\u0002\u00100R\u0010\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103R\u0010\u0010k\u001a\u0004\u0018\u00010lX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010m\u001a\u0004\u0018\u00010nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0083\u0001"}, d2 = {"Lcom/larus/dora/impl/dynamic/DoraDynamicFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageDynamicListBinding;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/dynamic/viewmodel/DoraDynamicViewModelV2;", "getModel", "()Lcom/larus/dora/impl/dynamic/viewmodel/DoraDynamicViewModelV2;", "model$delegate", "Lkotlin/Lazy;", "aboveTabAdapter", "Lcom/larus/dora/impl/dynamic/DslCardAdapter;", "dynamicPagerAdapter", "Lcom/larus/dora/impl/dynamic/DoraDynamicPagerAdapter;", "mPageKey", "", "connectFailedDialog", "Lcom/larus/dora/impl/device_v2/DoraDeviceConnectFailedV2Dialog;", "unbindDialog", "Lcom/larus/common_ui/dialog/CommonDialog;", "dynamicHandler", "Landroid/os/Handler;", "handlerThread", "Landroid/os/HandlerThread;", "connectChecker", "Lcom/larus/dora/impl/util/DoraConnectChecker;", "selectedDevice", "Lcom/bytedance/dora/device/DoraDevice;", "currentHistoryDeviceList", "", "btSwitch", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "lastCardContextDeviceMac", "buryPointSource", "keepAliveGuideSessionId", "", "Ljava/lang/Integer;", "pendingLandingTab", "shouldApplyInitialDisconnectedTab", "", "lastCurrentDeviceConnected", "Ljava/lang/Boolean;", "isClickTriggeredWakeup", "localReceiver", "com/larus/dora/impl/dynamic/DoraDynamicFragment$localReceiver$1", "Lcom/larus/dora/impl/dynamic/DoraDynamicFragment$localReceiver$1;", "sysReceiver", "com/larus/dora/impl/dynamic/DoraDynamicFragment$sysReceiver$1", "Lcom/larus/dora/impl/dynamic/DoraDynamicFragment$sysReceiver$1;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "launchKeepAliveGuideSession", "showAudioSettingDialogIfNeeded", "setupListenter", "showConnectFailedDialog", "device", "fragment", "Landroidx/fragment/app/Fragment;", "dismissConnectFailedDialog", "dismissUnbindDialog", "showUnbindConfirmDialog", "Lcom/larus/dora/impl/dynamic/dsl/DslDialog;", "cardContext", "Lcom/larus/dora/impl/dynamic/entity/CardContext;", "handleUnbind", "showGUnbindDialog", "showNotGUnbindDialog", "unbindAndDisconnect", "setNavBar", "isHistoryDeviceListChanged", "newDeviceList", "refreshHistoryDeviceList", "setupAdapter", "pageTitle", "setUpPageView", "pageInfo", "Lcom/larus/dora/impl/dynamic/dsl/DslDeviceManagementPage;", "openDoraGManagementPage", "updatePageByConnectionState", "connectionState", "Lcom/larus/dora/impl/dynamic/event/DeviceConnectionState;", "resolveTargetTabIndex", "curSelectConnect", "(Lcom/larus/dora/impl/dynamic/event/DeviceConnectionState;Z)Ljava/lang/Integer;", "shouldSwitchToSettingTabOnDisconnected", "consumeLandingTabIndex", "()Ljava/lang/Integer;", "resetInitialTabSelectionState", "resetStatus", "loadDeviceData", "mac", "fromTag", "onPause", "checkReady", "getCurrentPageName", "doraVoiceCallback", "Lcom/bytedance/dora/voice/IDoraVoiceCallback;", "activeGuideTimer", "Lkotlinx/coroutines/Job;", "registerWakeupListener", "unregisterWakeupListener", "handleGuideItemClick", "item", "Lcom/larus/platform/model/NewcomerGuideItem;", "text", "onDestroyView", "onStart", "onResume", "onStop", "onAttach", "context", "Landroid/content/Context;", "onIndividualToneResult", "bundle", "onAutoStopTimeConfigResult", "updateBotInfo", "Lcom/larus/im/bean/bot/BotModel;", "newBotInfo", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraDynamicFragment extends DoraBaseFragment {
    public static final /* synthetic */ int C = 0;
    public final DoraDynamicFragment$sysReceiver$1 A;
    public DoraDynamicFragment$registerWakeupListener$1 B;
    public LarusDoraPageDynamicListBinding f;
    public final Lazy g;
    public DslCardAdapter h;
    public DoraDynamicPagerAdapter i;
    public String j;
    public DoraDeviceConnectFailedV2Dialog k;
    public CommonDialog l;
    public Handler m;
    public PthreadHandlerThreadV2 n;
    public final DoraConnectChecker o;
    public volatile DoraDevice p;
    public List<? extends DoraDevice> q;
    public ActivityResultLauncher<Intent> r;
    public String s;
    public String t;
    public Integer u;
    public String v;
    public boolean w;
    public Boolean x;
    public boolean y;
    public final DoraDynamicFragment$localReceiver$1 z;

    public static final class a {
    }

    public static final class b<T> implements FlowCollector {
        public final /* synthetic */ DoraDynamicFragment a;

        public b(DoraDynamicFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r3, Continuation r4) {
            DoraDynamicViewModelV2.f r5 = (DoraDynamicViewModelV2.f) r3;
            g49.d.d("DoraDynamicFragment", "deviceStateFlow collect " + r5);
            if (Intrinsics.areEqual(r5, DoraDynamicViewModelV2.f.d.a) == true) goto L17;
            if ((r5 instanceof DoraDynamicViewModelV2.f.a) == false) goto L10;
            DoraDynamicFragment r6 = this.a;
            Handler r0 = r6.m;
            if (r0 == null) goto L17;
            Boxing.boxBoolean(r0.post(new i0(r6, r5)));
            goto L17
        L10:
            if ((r5 instanceof DoraDynamicViewModelV2.f.b) == true) goto L17;
            if ((r5 instanceof DoraDynamicViewModelV2.f.c) == false) goto L17;
            DoraDynamicFragment r7 = this.a;
            Handler r1 = r7.m;
            if (r1 == null) goto L17;
            Boxing.boxBoolean(r1.post(new j0(r5, r7)));
        L17:
            return Unit.INSTANCE;
        }
    }

    public static final class c<T> implements FlowCollector {
        public final /* synthetic */ DoraDynamicFragment a;

        public c(DoraDynamicFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            DoraDynamicViewModelV2.a r4 = (DoraDynamicViewModelV2.a) r2;
            g49.d.d("DoraDynamicFragment", "deviceBatteryStateFlow collect " + r4);
            DoraDevice r5 = r4.b;
            String r6 = null;
            if (r5 == null) goto L5;
            String r7 = r5.mac;
        L6:
            DoraDevice r0 = this.a.p;
            if (r0 == null) goto L10;
            r6 = r0.mac;
        L10:
            if (Intrinsics.areEqual(r7, r6) == false) goto L17;
            DoraDynamicFragment r8 = this.a;
            LarusDoraPageDynamicListBinding r9 = r8.f;
            if (r9 == null) goto L17;
            ConstraintLayout r10 = r9.a;
            if (r10 == null) goto L17;
            Boxing.boxBoolean(r10.post(new k0(r8)));
        L17:
            return Unit.INSTANCE;
        L5:
            r7 = null;
            goto L6
        }
    }

    public static final class d<T> implements FlowCollector {
        public final /* synthetic */ DoraDynamicFragment a;

        public d(DoraDynamicFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            g49.d.d("DoraDynamicFragment", "headphoneModeStateFlow collect state:" + ((Boolean) r2).booleanValue());
            DoraDevice r4 = kj4.a.g().c();
            String r5 = null;
            if (r4 == null) goto L5;
            String r6 = r4.mac;
        L6:
            DoraDevice r0 = this.a.p;
            if (r0 == null) goto L10;
            r5 = r0.mac;
        L10:
            if (Intrinsics.areEqual(r6, r5) == false) goto L17;
            DoraDynamicFragment r7 = this.a;
            LarusDoraPageDynamicListBinding r8 = r7.f;
            if (r8 == null) goto L17;
            ConstraintLayout r9 = r8.a;
            if (r9 == null) goto L17;
            Boxing.boxBoolean(r9.post(new l0(r7)));
        L17:
            return Unit.INSTANCE;
        L5:
            r6 = null;
            goto L6
        }
    }

    public static final class e<T> implements FlowCollector {
        public final /* synthetic */ DoraDynamicFragment a;

        public e(DoraDynamicFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            Map r4 = (Map) r2;
            DoraDevice r5 = this.a.p;
            if (r5 == null) goto L5;
            String r6 = r5.sn;
        L6:
            if (r6 != null) goto L9;
            r6 = "";
        L9:
            if (r6.length() <= 0) goto L11;
            boolean r0 = true;
        L12:
            if (r0 == false) goto L21;
            if (r4.containsKey(r6) == false) goto L21;
            DoraDynamicFragment r7 = this.a;
            LarusDoraPageDynamicListBinding r8 = r7.f;
            if (r8 == null) goto L21;
            ConstraintLayout r9 = r8.a;
            if (r9 == null) goto L21;
            Boxing.boxBoolean(r9.post(new m0(r7)));
        L21:
            return Unit.INSTANCE;
        L11:
            r0 = false;
            goto L12
        L5:
            r6 = null;
            goto L6
        }
    }

    public static final class f<T> implements FlowCollector {
        public final /* synthetic */ DoraDynamicFragment a;

        public f(DoraDynamicFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r11, Continuation r12) {
            Triple r13 = (Triple) r11;
            com.larus.dora.impl.network.w r14 = (com.larus.dora.impl.network.w) r13.component1();
            List<NewcomerGuideItem> r0 = (List) r13.component2();
            e59.b r15 = (e59.b) r13.component3();
            IDoraService r1 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r1 == null) goto L7;
            DeviceService r2 = r1.device();
            if (r2 == null) goto L7;
            Boolean r3 = Boxing.boxBoolean(r2.n0("vox_ais"));
        L8:
            StringBuilder r4 = new StringBuilder("onboardingStatusFlow collect: showGuide=");
            if (r14 == null) goto L11;
            Boolean r5 = Boxing.boxBoolean(r14.a());
        L12:
            r4.append(r5);
            r4.append(", configSize=");
            r4.append(r0.size());
            r4.append(", connectionState=");
            r4.append(r15);
            r4.append(", supportAIS=");
            r4.append(r3);
            g49.d.d("DoraDynamicFragment", r4.toString());
            if ((r15 instanceof e59.b.a) == false) goto L23;
            String r16 = ((e59.b.a) r15).a;
            DoraDevice r6 = this.a.p;
            if (r6 == null) goto L17;
            String r7 = r6.mac;
        L19:
            if (Intrinsics.areEqual(r16, r7) == false) goto L23;
            if (Intrinsics.areEqual(r3, Boxing.boxBoolean(true)) == false) goto L23;
            boolean r17 = true;
        L24:
            if (r14 != null) goto L26;
        L28:
            boolean r8 = false;
        L29:
            if (r8 == true) goto L31;
        L34:
            boolean r18 = false;
        L35:
            LarusDoraPageDynamicListBinding r9 = this.a.f;
            if (r9 == null) goto L60;
            NestedDynamicPageView r10 = r9.c;
            if (r10 == null) goto L60;
            if (r14 == null) goto L43;
            Integer r110 = r14.b();
            if (r110 == null) goto L43;
            String r111 = r110.toString();
        L45:
            if (r18 == true) goto L47;
        L55:
            r10.h.setVisibility(8);
            Job r112 = r10.h.b;
            if (r112 == null) goto L58;
            Job.DefaultImpls.cancel$default(r112, null, 1, null);
        L58:
            r10.g.setVisibility(0);
        L59:
            r10.m = r18;
            goto L60
        L47:
            if (r0.isEmpty() == true) goto L55;
            if (r10.m == true) goto L54;
            DoraBuryPointManager r20 = DoraBuryPointManager.a;
            int r21 = r0.size();
            r20.getClass();
            g49.d.d(DoraBuryPointManager.b, "reportNewcomerGuideBannerShow: size=" + r21 + ", type=" + r111);
            Pair[] r22 = new Pair[2];
            r22[0] = TuplesKt.to("config_size", Integer.valueOf(r21));
            if (r111 != null) goto L53;
            r111 = "";
        L53:
            r22[1] = TuplesKt.to("guide_type", r111);
            r20.L("dora_guide_banner_show", MapsKt.mapOf(r22));
        L54:
            r10.h.setVisibility(0);
            r10.h.setData(r0);
            r10.g.setVisibility(8);
        L43:
            r111 = null;
        L60:
            if (r18 == false) goto L69;
            LarusDoraPageDynamicListBinding r113 = this.a.f;
            if (r113 == null) goto L69;
            NestedDynamicPageView r114 = r113.c;
            if (r114 == null) goto L69;
            NewcomerGuideWidget r115 = r114.getNewcomerGuideWidget();
            if (r115 == null) goto L69;
            r115.setOnItemClickListener(new n0(this.a));
        L69:
            return Unit.INSTANCE;
        L31:
            if ((!r0.isEmpty()) == false) goto L34;
            if (r17 == false) goto L34;
            r18 = true;
            goto L35
        L26:
            if (r14.a() != true) goto L28;
            r8 = true;
            goto L29
        L17:
            r7 = null;
        L23:
            r17 = false;
            goto L24
        L11:
            r5 = null;
        L7:
            r3 = null;
            goto L8
        }
    }

    public static final class g<T> implements FlowCollector {
        public final /* synthetic */ DoraDynamicFragment a;

        public g(DoraDynamicFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r9, Continuation r10) {
            String r11 = (String) r9;
            g49.d.d("DoraDynamicFragment", "avatarUrlFlow collect: " + r11);
            boolean r0 = true;
            if (r11 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == true) goto L25;
            LarusDoraPageDynamicListBinding r2 = this.a.f;
            if (r2 == null) goto L25;
            NestedDynamicPageView r3 = r2.c;
            if (r3 == null) goto L25;
            NewcomerGuideWidget r4 = r3.getNewcomerGuideWidget();
            if (r4 == null) goto L25;
            if (r11 != null) goto L18;
        L21:
            if (r0 == true) goto L25;
            CircleSimpleDraweeView.f(r4.a.b, com.larus.image.loader.b0.a(r11, "chat.user_avatar", false, false, 6), null, null, 0, 0, 62);
            goto L25
        L18:
            if (r11.length() == 0) goto L21;
            r0 = false;
        L25:
            return Unit.INSTANCE;
        L5:
            if (r11.length() == 0) goto L8;
            r1 = false;
            goto L9
        }
    }

    public static final class h implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public h(Function1 r2) {
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
        return "DoraDynamicActivity";
    }

    public final void aa0() {
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

    public final DoraDynamicViewModelV2 ba0() {
        return (DoraDynamicViewModelV2) this.g.getValue();
    }

    public final void ea0() {
        com.larus.dora.impl.util.b0.a.getClass();
        if (com.larus.dora.impl.util.b0.j().getBoolean("dora_need_show_audio_settings_dialog", false) == true) goto L5;
        return;
    L5:
        if (DoraAdapterExtKt.t(kj4.a.g()) == false) goto L16;
        com.larus.dora.impl.util.b0.j().storeBoolean("dora_need_show_audio_settings_dialog", false);
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

    public final void onDestroyView() {
        Integer r0 = this.u;
        if (r0 == null) goto L7;
        int r1 = r0.intValue();
        IDoraGuideService r2 = (IDoraGuideService) ServiceManager.get().getService(IDoraGuideService.class);
        if (r2 == null) goto L7;
        r2.a(r1);
    L7:
        this.u = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        StringBuilder r3 = new StringBuilder("unregisterWakeupListener called, doraVoiceCallback is null = ");
        if (this.B != null) goto L10;
        boolean r4 = true;
    L11:
        r3.append(r4);
        g49.d.d("DoraDynamicFragment", r3.toString());
        DoraDynamicFragment$registerWakeupListener$1 r5 = this.B;
        if (r5 == null) goto L14;
        kj4.a.g().unRegisterDoraVoiceCallback(r5);
        g49.d.d("DoraDynamicFragment", "unregisterWakeupListener: unregistering callback " + r5.hashCode());
    L14:
        this.B = null;
        LocalBroadcastManager.getInstance(AppHost.a.getApplication()).unregisterReceiver(this.z);
        Handler r6 = this.m;
        if (r6 == null) goto L17;
        r6.removeCallbacksAndMessages(null);
    L17:
        this.m = null;
        PthreadHandlerThreadV2 r7 = this.n;
        if (r7 == null) goto L20;
        r7.quitSafely();
    L20:
        this.n = null;
        LarusDoraPageDynamicListBinding r8 = this.f;
        if (r8 == null) goto L27;
        NestedDynamicPageView r9 = r8.c;
        r9.getClass();
        r9.a = CollectionsKt.emptyList();
        r9.g.setAdapter(null);
        Job r10 = r9.h.b;
        if (r10 == null) goto L25;
        Job.DefaultImpls.cancel$default(r10, null, 1, null);
    L25:
        TabLayout r11 = r9.i;
        r11.clearOnTabSelectedListeners();
        r11.removeAllTabs();
        ViewPager2 r12 = r9.k;
        r12.unregisterOnPageChangeCallback(r9.j);
        r12.setAdapter(null);
        return;
    L27:
        return;
    L10:
        r4 = false;
        goto L11
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.larus.dora.impl.dynamic.DoraDynamicFragment$sysReceiver$1] */
    public DoraDynamicFragment() {
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraDynamicViewModelV2.class), new DoraDynamicFragment$special$$inlined$activityViewModels$default$1(this), new DoraDynamicFragment$special$$inlined$activityViewModels$default$2(this));
        PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2("dora_dynamic");
        ThreadMethodProxy.start(r0);
        this.m = new Handler(r0.getLooper());
        this.n = r0;
        this.o = new DoraConnectChecker(this);
        this.t = "";
        this.w = true;
        this.z = new DoraDynamicFragment$localReceiver$1(this);
        this.A = new DoraDynamicFragment$sysReceiver$1(this);
    }

    public final void Z90() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DoraDynamicFragment$checkReady$1(this, null), 3, null);
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        Application r0 = AppHost.a.getApplication();     // Catch: Exception -> L15
        DoraDynamicFragment$sysReceiver$1 r1 = this.A;     // Catch: Exception -> L15
        ReceiverRegisterLancet.loge(r1, false);     // Catch: Exception -> L15
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L18;
        r0.unregisterReceiver(r1);     // Catch: Exception -> L15
        return;
    L18:
    L9:
        e = move-exception;
        if (r1 == null) goto L12;
        Npth.addTag("unregisterReceiver", r1.toString());     // Catch: Exception -> L15
    L12:
        e.printStackTrace();     // Catch: Exception -> L15
        return;
    L6:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r1, r0) == false) goto L21;
        r0.unregisterReceiver(r1);     // Catch: Exception -> L9
    L23:
        return;
    L21:
        return;
    L15:
        e = move-exception;
        g49.d.c("DoraDynamicFragment", "unregister sysReceiver error", e);
    }

    public final void onResume() {
        super.onResume();
        IntentFilter r7 = new IntentFilter("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
        r7.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        r7.addAction("android.bluetooth.device.action.ACL_CONNECTED");
        r7.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        r7.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
        r7.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
        Application r8 = AppHost.a.getApplication();
        DoraDynamicFragment$sysReceiver$1 r9 = this.A;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L43;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L43:
    L29:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L41;
        ReceiverRegisterCrashOptimizer.registerReceiver(r9, r7);
    L33:
        DoraDynamicPagerAdapter r0 = this.i;
        if (r0 == null) goto L45;
        DoraDynamicListFragment r1 = r0.y2(1);
        if (r1 == null) goto L46;
        DslCardAdapter r2 = r1.g;
        if (r2 == null) goto L47;
        r2.y2(DslCardAdapter.a.InterfaceC0061a.d.a);
        return;
    L47:
        return;
    L46:
        return;
    L45:
        return;
    L41:
        throw e;
    L7:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L20;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r7) == false) goto L20;
        int r3 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r7, 0, null, null, 2, r8).result;     // Catch: Exception -> L29
        if (r3 != 1) goto L13;
        r8.registerReceiver(r9, r7);     // Catch: Exception -> L29
    L42:
        goto L33
    L13:
        if (r3 != 2) goto L15;
        new Intent();     // Catch: Exception -> L29
        goto L42
    L15:
        if (r3 == 3) goto L42;
        r8.registerReceiver(r9, r7);     // Catch: Exception -> L29
    L20:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L23;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L29
        r8.registerReceiver(r9, r7, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L29
        goto L42
    L23:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L25;
    L27:
        r8.registerReceiver(r9, r7);     // Catch: Exception -> L29
        goto L42
    L25:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r7) == false) goto L27;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L29
        ContextCompat.registerReceiver(r8, r9, r7, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L29
        goto L42
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void onStart() {
        super.onStart();
        ea0();
        Z90();
        DoraDynamicViewModelV2.checkLocalBindState$default(ba0(), this.p, 0, 2, null);
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void onStop() {
        super.onStop();
    }

    public final boolean ca0(List<? extends DoraDevice> r9) {
        List<? extends DoraDevice> r0 = this.q;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L10;
        return true;
    L10:
        Iterator<T> r10 = r9.iterator();
        int r2 = 0;
    L12:
        if (r10.hasNext() == false) goto L34;
        Object r3 = r10.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        DoraDevice r5 = (DoraDevice) r3;
        String r6 = r5.mac;
        List<? extends DoraDevice> r7 = this.q;
        String r8 = null;
        if (r7 == null) goto L21;
        DoraDevice r11 = (DoraDevice) ListProtector.get(r7, r2);
        if (r11 == null) goto L21;
        String r12 = r11.mac;
    L23:
        if (Intrinsics.areEqual(r6, r12) == false) goto L33;
        String r13 = r5.name;
        List<? extends DoraDevice> r14 = this.q;
        if (r14 == null) goto L30;
        DoraDevice r15 = (DoraDevice) ListProtector.get(r14, r2);
        if (r15 == null) goto L30;
        r8 = r15.name;
    L30:
        if (Intrinsics.areEqual(r13, r8) == false) goto L33;
        r2 = r4;
    L33:
        return true;
    L21:
        r12 = null;
        goto L23
    L34:
        return false;
    L5:
        if (r9.size() != r0.size()) goto L7;
        r1 = true;
        goto L8
    }

    public final void fa0(DoraDevice r8) {
        String r6 = null;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DoraDynamicFragment$unbindAndDisconnect$1(r8, null), 3, null);
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
        String r0 = this.t;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r0, "buryPointSource");
        r6.b = r6.a.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new com.larus.dora.impl.util.j(r6, r0));
        this.r = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new p());
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

    public static final void X90(DoraDynamicFragment r4, DoraDevice r5) {
        int r0 = com.larus.dora.impl.util.s.a;
        if (com.larus.dora.impl.util.s.c(Integer.valueOf(r5.productId)) == true) goto L5;
    L13:
        FragmentActivity r6 = r4.getActivity();
        if (r6 == null) goto L19;
        r6.finish();
        return;
    L19:
        return;
    L5:
        if (o59.a.l(r5) == false) goto L13;
        g49.d.d("DoraDynamicFragment", "openDoraGManagementPage mac=" + r5.mac);
        Context r1 = r4.getContext();
        if (r1 != null) goto L10;
        r1 = AppHost.a.getApplication();
    L10:
        com.bytedance.router.i r2 = SmartRouter.buildRoute(r1, "//dora_g_device_management");
        r2.d = 2130772401;
        r2.e = 2130772399;
        r2.c.putExtra("product_id", n1.c(r5));
        r2.c.putExtra(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, r5.model);
        r2.c.putExtra(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MAC, r5.mac);
        r2.c.putExtra(DoraObricDeviceHomeViewModel.PARAM_PAGE_KEY, "device_manage_v3");
        r2.d();
        FragmentActivity r7 = r4.getActivity();
        if (r7 == null) goto L17;
        r7.finish();
        return;
    }

    public static final void Y90(DoraDynamicFragment r6, BotModel r7) {
        r6.getClass();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r6), null, null, new DoraDynamicFragment$updateBotInfo$1(r7, null), 3, null);
    }

    public final synchronized void da0(String r5, String r6) {
        monitor-enter(this);
        if (r5 != null) goto L40;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == false) goto L15;
        g49.d.d("DoraDynamicFragment", "load device data failed. mac is empty!! fromTag=".concat(r6));     // Catch: Throwable -> L10
    L36:
        monitor-exit(this);
        return;
    L15:
        DoraDevice r7 = i.a(r5);     // Catch: Throwable -> L10
        g49.d.d("DoraDynamicFragment", "load device : " + r7 + ", fromTag=" + r6);     // Catch: Throwable -> L10
        if (r7 == null) goto L26;
        DoraDevice r8 = this.p;     // Catch: Throwable -> L10
        if (r8 == null) goto L20;
        String r9 = r8.mac;     // Catch: Throwable -> L10
    L22:
        if (Intrinsics.areEqual(r9, r7.mac) == false) goto L25;
        monitor-exit(this);
        return;
    L25:
        this.w = true;     // Catch: Throwable -> L10
        this.x = null;     // Catch: Throwable -> L10
        this.p = r7;     // Catch: Throwable -> L10
        goto L26
    L20:
        r9 = null;
    L26:
        final DoraDevice r10 = this.p;     // Catch: Throwable -> L10
        if (r10 == null) goto L36;
        Handler r11 = this.m;     // Catch: Throwable -> L10
        if (r11 == null) goto L32;
        r11.post(new c0(this, r10));     // Catch: Throwable -> L10
    L32:
        if (kj4.a.g().getDoraLinkState(this.p) != 2) goto L36;
        DoraDevice r12 = this.p;     // Catch: Throwable -> L10
        if (r12 == null) goto L36;
        ba0().checkBindState(r12);     // Catch: Throwable -> L10
        goto L36
    L40:
    L10:
        th = move-exception;
        throw th;
    L7:
        if (r5.length() == 0) goto L12;
        r3 = false;
        goto L13
    }

    public final synchronized void ga0(e59.b r9, c59.m r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r9, "connectionState");     // Catch: Throwable -> L59
        Intrinsics.checkNotNullParameter(r10, "pageInfo");     // Catch: Throwable -> L59
        g49.d.d("DoraDynamicFragment", "updatePageByConnectionState, connectionState = " + r9);     // Catch: Throwable -> L59
        LarusDoraPageDynamicListBinding r1 = this.f;     // Catch: Throwable -> L59
        if (r1 == null) goto L57;
        Integer r3 = null;
        if ((r9 instanceof e59.b.a) == false) goto L15;
        String r2 = ((e59.b.a) r9).a;     // Catch: Throwable -> L59
        DoraDevice r6 = this.p;     // Catch: Throwable -> L59
        if (r6 == null) goto L11;
        String r7 = r6.mac;     // Catch: Throwable -> L59
    L13:
        if (Intrinsics.areEqual(r2, r7) == false) goto L15;
        boolean r4 = true;
    L16:
        List<c59.n> r11 = r10.b;     // Catch: Throwable -> L59
        if (r4 == false) goto L19;
        int r8 = 0;
    L20:
        c59.n r12 = (c59.n) CollectionsKt.getOrNull(r11, r8);     // Catch: Throwable -> L59
        if (r12 == null) goto L57;
        DslCardAdapter r13 = this.h;     // Catch: Throwable -> L59
        if (r13 == null) goto L25;
        r13.B2(r12.a);     // Catch: Throwable -> L59
    L25:
        DoraDynamicPagerAdapter r14 = this.i;     // Catch: Throwable -> L59
        if (r14 == null) goto L28;
        r14.z2(r12.b);     // Catch: Throwable -> L59
    L28:
        if (r4 == false) goto L30;
    L44:
        String r15 = this.v;     // Catch: Throwable -> L59
        if (r15 == null) goto L50;
        this.v = null;     // Catch: Throwable -> L59
        if (Intrinsics.areEqual(r15, "explore") == false) goto L50;
        r3 = 0;     // Catch: Throwable -> L59
    L50:
        Integer r16 = r3;
    L51:
        this.w = false;     // Catch: Throwable -> L59
        this.x = Boolean.valueOf(r4);     // Catch: Throwable -> L59
        if (r16 == null) goto L57;
        NestedDynamicPageView r17 = r1.c;     // Catch: Exception -> L55 Throwable -> L59
        r17.k.setCurrentItem(r16.intValue());     // Catch: Exception -> L55 Throwable -> L59
    L55:
        e = move-exception;
        g49.d.d("DoraDynamicFragment", "updatePageByConnectionState, onTabSelected error: " + e.getMessage());     // Catch: Throwable -> L59
        goto L57
    L30:
        if (this.w == false) goto L32;
    L37:
        boolean r18 = true;
    L38:
        if (r18 == false) goto L44;
        String r20 = this.v;     // Catch: Throwable -> L59
        if (r20 == null) goto L43;
        this.v = null;     // Catch: Throwable -> L59
        Intrinsics.areEqual(r20, "explore");     // Catch: Throwable -> L59
    L43:
        r16 = 1;     // Catch: Throwable -> L59
        goto L51
    L32:
        if ((r9 instanceof e59.b.c) == true) goto L34;
    L36:
        r18 = false;
        goto L38
    L34:
        if (Intrinsics.areEqual(this.x, Boolean.TRUE) == false) goto L36;
    L19:
        r8 = 1;
        goto L20
    L11:
        r7 = null;
    L15:
        r4 = false;
    L57:
        monitor-exit(this);
        return;
    L59:
        th = move-exception;
        throw th;
    }

    public final void onViewCreated(View r22, Bundle r23) {
        Intrinsics.checkNotNullParameter(r22, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r22, r23);
        Bundle r1 = getArguments();
        if (r1 == null) goto L5;
        r1.getString("page_title");
    L5:
        Bundle r2 = getArguments();
        if (r2 == null) goto L8;
        String r3 = r2.getString("bury_point_source", DoraBuryPointSource.DEVICE_PAGE);
    L9:
        String r4 = "";
        if (r3 != null) goto L12;
        r3 = "";
    L12:
        this.t = r3;
        Bundle r5 = getArguments();
        if (r5 == null) goto L15;
        String r6 = r5.getString(DoraObricDeviceHomeViewModel.PARAM_PAGE_KEY);
    L16:
        if (r6 == null) goto L19;
        r4 = r6;
    L19:
        this.j = r4;
        Bundle r7 = getArguments();
        if (r7 == null) goto L22;
        String r8 = r7.getString("landing_tab");
    L23:
        this.v = r8;
        IntentFilter r9 = new IntentFilter("action.DEVICE_UNBIND");
        r9.addAction("action.DEVICE_UPDATE_DYNAMIC");
        r9.addAction("action.DEVICE_UPDATE_NAME");
        r9.addAction("action.DEVICE_ENTER_SIMUL_INTERPRET");
        LocalBroadcastManager.getInstance(AppHost.a.getApplication()).registerReceiver(this.z, r9);
        LarusDoraPageDynamicListBinding r10 = this.f;
        if (r10 == null) goto L28;
        ConstraintLayout r11 = r10.a;
        if (r11 == null) goto L28;
        r11.post(new r(this));
    L28:
        this.h = new DslCardAdapter(ba0());
        LarusDoraPageDynamicListBinding r12 = this.f;
        if (r12 == null) goto L36;
        com.larus.utils.e1.x(r12.b);
        ba0().getCardContextData().observe(getViewLifecycleOwner(), new h(new y(this)));
        ba0().getPageInfoData().observe(getViewLifecycleOwner(), new h(new z(this)));
        DoraDynamicPagerAdapter r13 = new DoraDynamicPagerAdapter(this);
        DoraDynamicViewModelV2 r14 = ba0();
        Intrinsics.checkNotNullParameter(r14, "actionHandler");
        r13.e = r14;
        this.i = r13;
        LarusDoraPageDynamicListBinding r15 = this.f;
        if (r15 == null) goto L35;
        NestedDynamicPageView r16 = r15.c;
        if (r16 == null) goto L35;
        r16.setAboveAdapter(this.h);
        r16.setPagerAdapter(this.i);
    L35:
        ba0().getViewHolderEvent().observe(getViewLifecycleOwner(), new h(new a0(this)));
        ba0().getConnectionState().observe(getViewLifecycleOwner(), new h(new b0(this)));
    L36:
        Bundle r17 = getArguments();
        if (r17 == null) goto L39;
        String r18 = r17.getString(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MAC);
    L40:
        List r20 = kj4.a.g().getDoraBindList();
        if (r20 == null) goto L48;
        ArrayList r21 = new ArrayList();
        Iterator r24 = r20.iterator();
    L44:
        if (r24.hasNext() == false) goto L49;
        Object r25 = r24.next();
        if (Intrinsics.areEqual(((DoraDevice) r25).mac, r18) == false) goto L44;
        r21.add(r25);
    L49:
        if (r21 == null) goto L53;
        DoraDevice r26 = (DoraDevice) CollectionsKt.firstOrNull(r21);
        if (r26 == null) goto L53;
        String r27 = r26.mac;
    L54:
        da0(r27, "exec:setupAdapter");
        ba0().getDialogEvent().observe(getViewLifecycleOwner(), new h(new q(this)));
        Lifecycle.State r28 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraDynamicFragment$setupListenter$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r28, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraDynamicFragment$setupListenter$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r28, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraDynamicFragment$setupListenter$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r28, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraDynamicFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r28, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraDynamicFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r28, null, this), 3, null);
        IObricDoraService r30 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        boolean r31 = false;
        if (r30 != null) goto L57;
    L59:
        boolean r32 = false;
    L60:
        if (r32 == true) goto L75;
        final IDoraGuideService r33 = (IDoraGuideService) ServiceManager.get().getService(IDoraGuideService.class);
        if (r33 == null) goto L75;
        final LifecycleCoroutineScope r110 = LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner());
        Integer r34 = this.u;
        if (r34 == null) goto L67;
        r33.a(r34.intValue());
    L67:
        Integer r35 = Integer.valueOf(r33.e("DoraDynamicActivity", requireContext(), CollectionsKt.listOf(Integer.valueOf(DoraGuideMeta.DoraKeepAliveGuide.getGuideId())), r110, new s(this, r33, r110)));
        if (r35.intValue() <= 0) goto L70;
        boolean r36 = true;
    L71:
        if (r36 == true) goto L74;
        r35 = null;
    L74:
        this.u = r35;
        goto L75
    L70:
        r36 = false;
    L75:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraDynamicFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r28, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraDynamicFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$4(this, r28, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraDynamicFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$5(this, r28, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraDynamicFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$6(this, r28, null, this), 3, null);
        StringBuilder r37 = new StringBuilder("registerWakeupListener called, doraVoiceCallback is null = ");
        if (this.B != null) goto L78;
        r31 = true;
    L78:
        r37.append(r31);
        g49.d.d("DoraDynamicFragment", r37.toString());
        if (this.B == null) goto L81;
        g49.d.d("DoraDynamicFragment", "registerWakeupListener: already registered, skip");
        return;
    L81:
        sk4.d r38 = new DoraDynamicFragment$registerWakeupListener$1(this);
        this.B = r38;
        g49.d.d("DoraDynamicFragment", "registerWakeupListener: registering callback " + r38.hashCode());
        kj4.a.g().registerDoraVoiceCallback(r38);
        return;
    L57:
        if (r30.t() != true) goto L59;
        r32 = true;
    L53:
        r27 = null;
        goto L54
    L48:
        r21 = null;
        goto L49
    L39:
        r18 = null;
        goto L40
    L22:
        r8 = null;
        goto L23
    L15:
        r6 = null;
        goto L16
    L8:
        r3 = null;
        goto L9
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        ConstraintLayout r5 = r2.inflate(2131562263, r3, false);
        int r6 = 2131368926;
        HistoryDeviceNavigationBar r7 = (HistoryDeviceNavigationBar) ViewBindings.findChildViewById(r5, 2131368926);
        if (r7 == null) goto L9;
        r6 = 2131381812;
        NestedDynamicPageView r0 = (NestedDynamicPageView) ViewBindings.findChildViewById(r5, 2131381812);
        if (r0 == null) goto L9;
        ConstraintLayout r8 = r5;
        this.f = new LarusDoraPageDynamicListBinding(r8, r7, r0);
        return r8;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}
