package com.larus.dora.obric.device_management.setting.g;

import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.config.IDoraPageConfig;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.core.OnlyBindResult;
import com.larus.dora.impl.core.OnlyConnectResult;
import com.larus.dora.impl.device.manage.x0;
import com.larus.dora.impl.dynamic.dsl.DslRedDotAdapter;
import com.larus.dora.impl.network.DoraNetworkApi;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.serviceimpl.SessionService;
import com.larus.dora.obric.device_management.setting.common.name.DoraObricDeviceNameViewModel;
import com.larus.utils.j0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000³\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003*\u0001,\b\u0000\u0018\u0000 v2\u00020\u0001:\u0001vB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0006\u00102\u001a\u00020/J\b\u00103\u001a\u0004\u0018\u00010\u0017J\u0006\u00104\u001a\u00020/J\u0010\u00105\u001a\u00020/2\b\u00106\u001a\u0004\u0018\u00010\u0017J\u0006\u00107\u001a\u000208J\u0010\u00109\u001a\u00020/2\u0006\u0010:\u001a\u000208H\u0002J\u0010\u0010;\u001a\u00020/2\u0006\u0010<\u001a\u00020\u0011H\u0002J\b\u0010=\u001a\u00020/H\u0002J\b\u0010>\u001a\u00020/H\u0002J\b\u0010?\u001a\u00020\u0017H\u0002J\b\u0010@\u001a\u000208H\u0002J\b\u0010A\u001a\u000208H\u0002J\u0006\u0010B\u001a\u00020\u0017J\u0014\u0010C\u001a\b\u0012\u0004\u0012\u00020E0D2\u0006\u0010F\u001a\u00020\u0017J\n\u0010G\u001a\u0004\u0018\u00010EH\u0002J\u0014\u0010H\u001a\b\u0012\u0004\u0012\u00020E0D2\u0006\u0010F\u001a\u00020\u0017J\u0006\u0010I\u001a\u00020/J\u0016\u0010J\u001a\u00020/2\u0006\u0010K\u001a\u00020LH\u0086@¢\u0006\u0002\u0010MJ\u0012\u0010N\u001a\u00020/2\b\u00106\u001a\u0004\u0018\u00010\u0017H\u0002J\u000e\u0010O\u001a\u00020/2\u0006\u0010K\u001a\u00020LJ\u0016\u0010P\u001a\u00020/2\u0006\u00106\u001a\u00020\u0017H\u0082@¢\u0006\u0002\u0010QJ\u0016\u0010R\u001a\u00020/2\u0006\u0010K\u001a\u00020LH\u0082@¢\u0006\u0002\u0010MJ\u0018\u0010S\u001a\u00020/2\b\u0010K\u001a\u0004\u0018\u00010LH\u0082@¢\u0006\u0002\u0010MJ\"\u0010T\u001a\u0004\u0018\u00010L2\u0006\u0010K\u001a\u00020L2\b\b\u0002\u0010U\u001a\u00020VH\u0082@¢\u0006\u0002\u0010WJ\u000e\u0010X\u001a\u00020/H\u0082@¢\u0006\u0002\u0010YJ\u0018\u0010Z\u001a\u0002082\b\u00106\u001a\u0004\u0018\u00010\u0017H\u0082@¢\u0006\u0002\u0010QJ\u0018\u0010[\u001a\u00020/2\b\b\u0001\u0010\\\u001a\u00020]H\u0082@¢\u0006\u0002\u0010^J\u0016\u0010[\u001a\u00020/2\u0006\u0010_\u001a\u00020\u0017H\u0082@¢\u0006\u0002\u0010QJ\f\u0010`\u001a\u000208*\u00020LH\u0002J\u000e\u0010a\u001a\u00020/2\u0006\u0010b\u001a\u00020cJ\b\u0010d\u001a\u0004\u0018\u00010LJ\b\u0010e\u001a\u00020/H\u0002J\b\u0010f\u001a\u00020/H\u0002J\b\u0010g\u001a\u00020/H\u0002J\b\u0010h\u001a\u00020/H\u0002J\b\u0010i\u001a\u00020/H\u0002J\b\u0010j\u001a\u00020/H\u0002J\b\u0010k\u001a\u00020/H\u0002J\b\u0010l\u001a\u00020/H\u0002J\b\u0010m\u001a\u00020/H\u0002J\b\u0010n\u001a\u00020/H\u0002J\b\u0010o\u001a\u00020/H\u0002J\u0010\u0010p\u001a\u00020/2\u0006\u0010q\u001a\u00020\u0017H\u0002J\u001a\u0010r\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010t0s*\u00020LH\u0002J\b\u0010u\u001a\u00020/H\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010!\u001a\u0004\u0018\u00010\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010 \u001a\u0004\b#\u0010$R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010 \u001a\u0004\b(\u0010)R\u0010\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0004\n\u0002\u0010-¨\u0006w"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/g/DoraObricGSettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_navigation", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/larus/dora/obric/device_management/setting/g/DoraObricGSettingsNavigation;", "navigation", "Lkotlinx/coroutines/flow/SharedFlow;", "getNavigation", "()Lkotlinx/coroutines/flow/SharedFlow;", "_effect", "Lcom/larus/dora/obric/device_management/setting/g/DoraObricGSettingsEffect;", "effect", "getEffect", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/dora/obric/device_management/setting/g/DoraObricGSettingsUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "targetDeviceMac", "", "reconnectJob", "Lkotlinx/coroutines/Job;", "connectingDeviceMac", "doraServiceImpl", "Lcom/larus/dora/api/IDoraService;", "getDoraServiceImpl", "()Lcom/larus/dora/api/IDoraService;", "doraServiceImpl$delegate", "Lkotlin/Lazy;", "doraPageConfig", "Lcom/larus/dora/api/config/IDoraPageConfig;", "getDoraPageConfig", "()Lcom/larus/dora/api/config/IDoraPageConfig;", "doraPageConfig$delegate", "featureConfigRepository", "Lcom/larus/dora/impl/dynamic/repository/DoraFeatureConfigRepository;", "getFeatureConfigRepository", "()Lcom/larus/dora/impl/dynamic/repository/DoraFeatureConfigRepository;", "featureConfigRepository$delegate", "doraVoiceCallback", "com/larus/dora/obric/device_management/setting/g/DoraObricGSettingsViewModel$doraVoiceCallback$1", "Lcom/larus/dora/obric/device_management/setting/g/DoraObricGSettingsViewModel$doraVoiceCallback$1;", "initialize", "", "arguments", "Landroid/os/Bundle;", "refreshConnectionState", "onReconnectClicked", "stopReconnect", "startReconnect", "mac", "isTargetDeviceConnected", "", "updateReconnectState", "isReconnecting", "updateUiState", "state", "refreshDeviceInfoRedDot", "refreshEnvironmentMemoryStatus", "resolveEnvObserveStatusText", "curEnvObserveState", "shouldShowDeviceInfoRedDot", "currentDeviceName", "connected", "", "Lcom/larus/dora/obric/device_management/setting/g/DoraObricGSettingsSection;", "deviceName", "buildMemorySection", "disconnected", "onlyLocalUnbindDisconnectedDevice", "unbindAndDisconnect", "device", "Lcom/bytedance/dora/device/DoraDevice;", "(Lcom/bytedance/dora/device/DoraDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendDeviceUnbindBroadcast", "replaceBind", "handleConnectRequest", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleGConnectRequest", "onlyConnect", "scanBleInfo", "timeout", "", "(Lcom/bytedance/dora/device/DoraDevice;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onConnectRequestFailed", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isDeviceConnected", "emitToast", "resId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "text", "isV2BleAdvertisementDevice", "onItemClicked", "item", "Lcom/larus/dora/obric/device_management/setting/g/DoraObricGSettingsItem;", "targetDevice", "navigateToDeviceName", "navigateToGestureSettings", "navigateToDoubaoConversationSettings", "navigateToSoundSettings", "navigateToVideoRecordSettings", "navigateToGeneralSettings", "navigateToDeviceInfo", "navigateToMemoryData", "navigateToEnvObserve", "navigateToPrivacySettings", "navigateToFeedback", "navigateTo", "route", "toRouteParams", "", "", "onCleared", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricGSettingsViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String PARAM_PRODUCT_ID = "product_id";
    private static final String PARAM_PRODUCT_MAC = "product_mac";
    private static final String PARAM_PRODUCT_MODEL = "model";
    private static final String PARAM_VENDOR_ID = "vendor_id";
    private static final long SCAN_BLE_INFO_TIMEOUT_MS = 10000;
    private static final String TAG = "DoraObricGSettingsVM";
    private final MutableSharedFlow<com.larus.dora.obric.device_management.setting.g.a> _effect;
    private final MutableSharedFlow<s> _navigation;
    private final z0<u> _uiState;
    private String connectingDeviceMac;
    private final Lazy doraPageConfig$delegate;
    private final Lazy doraServiceImpl$delegate;
    private final c doraVoiceCallback;
    private final d1<com.larus.dora.obric.device_management.setting.g.a> effect;
    private final Lazy featureConfigRepository$delegate;
    private final d1<s> navigation;
    private Job reconnectJob;
    private String targetDeviceMac;
    private final i1<u> uiState;

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.setting.g.DoraObricGSettingsViewModel$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.setting.g.DoraObricGSettingsViewModel$1", f = "DoraObricGSettingsViewModel.kt", i = {}, l = {162}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraObricGSettingsViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.obric.device_management.setting.g.DoraObricGSettingsViewModel$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ DoraObricGSettingsViewModel a;

            public a(DoraObricGSettingsViewModel r1) {
                this.a = r1;
            }

            public final Object emit(Object r1, Continuation r2) {
                Map r3 = (Map) r1;
                DoraObricGSettingsViewModel.access$refreshDeviceInfoRedDot(this.a);
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(DoraObricGSettingsViewModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r5);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            b1 r6 = com.larus.dora.impl.ota.b.c;
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[OnlyConnectResult.values().length];
            r0[OnlyConnectResult.CONNECT_FAILED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L23
        L54:
            r0[OnlyConnectResult.CONNECT_TIMEOUT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L24
        L64:
            r0[OnlyConnectResult.SUCCESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L25
        L8:
            a = r0;
            int[] r1 = new int[DoraObricGSettingsAction.values().length];
            r1[DoraObricGSettingsAction.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L26
        L58:
            r1[DoraObricGSettingsAction.DEVICE_NAME.ordinal()] = 2;     // Catch: NoSuchFieldError -> L27
        L66:
            r1[DoraObricGSettingsAction.GESTURE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L28
        L38:
            r1[DoraObricGSettingsAction.DOUBAO_CONVERSATION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L29
        L42:
            r1[DoraObricGSettingsAction.SOUND.ordinal()] = 5;     // Catch: NoSuchFieldError -> L30
        L50:
            r1[DoraObricGSettingsAction.VIDEO_RECORD.ordinal()] = 6;     // Catch: NoSuchFieldError -> L31
        L62:
            r1[DoraObricGSettingsAction.GENERAL.ordinal()] = 7;     // Catch: NoSuchFieldError -> L32
        L46:
            r1[DoraObricGSettingsAction.DEVICE_INFO.ordinal()] = 8;     // Catch: NoSuchFieldError -> L33
        L56:
            r1[DoraObricGSettingsAction.ENV_OBSERVE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L34
        L60:
            r1[DoraObricGSettingsAction.MEMORY_DATA.ordinal()] = 10;     // Catch: NoSuchFieldError -> L35
        L40:
            r1[DoraObricGSettingsAction.PRIVACY_AND_PERMISSION.ordinal()] = 11;     // Catch: NoSuchFieldError -> L36
        L52:
            r1[DoraObricGSettingsAction.FEEDBACK.ordinal()] = 12;     // Catch: NoSuchFieldError -> L37
        L21:
            b = r1;
        }
    }

    public static final class c implements f49.b {
        public final /* synthetic */ DoraObricGSettingsViewModel a;

        @Override // f49.b
        public final void b() {
        }

        @Override // f49.b
        public final void d(int r1) {
        }

        @Override // f49.b
        public final void h(int r1) {
        }

        @Override // f49.b
        public final void i() {
        }

        @Override // f49.b
        public final void j(byte[] r1, byte[] r2) {
        }

        @Override // f49.b
        public final void k() {
        }

        @Override // f49.b
        public final void m() {
        }

        @Override // f49.b
        public final void n() {
        }

        @Override // f49.b
        public final void o() {
        }

        @Override // f49.b
        public final void p() {
        }

        public c(DoraObricGSettingsViewModel r1) {
            this.a = r1;
        }

        @Override // f49.b
        public final void l(int r1, int r2, int r3) {
            g49.d.d(DoraObricGSettingsViewModel.TAG, "onVoiceWakeUp wakeMode=" + r2);
            if (r2 != 11) goto L6;
            DoraObricGSettingsViewModel.access$refreshEnvironmentMemoryStatus(this.a);
            return;
        }
    }

    public static final class d extends ScanCallback {
        public final /* synthetic */ CompletableDeferred<Unit> a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Ref.ObjectRef<DoraDevice> d;

        @Override // android.bluetooth.le.ScanCallback
        public final void onScanFailed(int r3) {
            g49.d.d(DoraObricGSettingsViewModel.TAG, "connect request, scan failed, err=" + r3);
            this.a.complete(Unit.INSTANCE);
        }

        @Override // android.bluetooth.le.ScanCallback
        public final void onScanResult(int r3, ScanResult r4) {
            if (this.b == false) goto L5;
            DoraDevice r5 = kj4.a.g().convertScanResultToDoraDeviceV2(r4);
        L6:
            if (r5 == null) goto L8;
            String r6 = r5.mac;
        L9:
            boolean r7 = Intrinsics.areEqual(r6, this.c);
            StringBuilder r0 = new StringBuilder("connect request, new scan result, hasDevice=");
            if (r5 == null) goto L12;
            boolean r1 = true;
        L13:
            r0.append(r1);
            r0.append(", matchesTarget=");
            r0.append(r7);
            g49.d.d(DoraObricGSettingsViewModel.TAG, r0.toString());
            if (r7 == false) goto L17;
            this.d.element = r5;
            kj4.a.g().stopScan(this);
            this.a.complete(Unit.INSTANCE);
            return;
        L17:
            return;
        L12:
            r1 = false;
            goto L13
        L8:
            r6 = null;
            goto L9
        L5:
            r5 = kj4.a.g().convertScanResultToDoraDevice(r4);
            goto L6
        }

        public d(CompletableDeferred<Unit> r1, boolean r2, String r3, Ref.ObjectRef<DoraDevice> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.setting.g.DoraObricGSettingsViewModel$handleConnectRequest$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.setting.g.DoraObricGSettingsViewModel", f = "DoraObricGSettingsViewModel.kt", i = {}, l = {524, 528, 529, 533, 535, 539, 540}, m = "handleConnectRequest", n = {}, s = {})
    public static final class C04881 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraObricGSettingsViewModel this$0;

        public C04881(DoraObricGSettingsViewModel r1, Continuation<? super C04881> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return DoraObricGSettingsViewModel.access$handleConnectRequest(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.setting.g.DoraObricGSettingsViewModel$handleGConnectRequest$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.setting.g.DoraObricGSettingsViewModel", f = "DoraObricGSettingsViewModel.kt", i = {0}, l = {546, 550, 551, 555, 561, 566, 571, 596, 597}, m = "handleGConnectRequest", n = {"device"}, s = {"L$0"})
    public static final class C04891 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraObricGSettingsViewModel this$0;

        public C04891(DoraObricGSettingsViewModel r1, Continuation<? super C04891> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return DoraObricGSettingsViewModel.access$handleGConnectRequest(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.setting.g.DoraObricGSettingsViewModel$handleGConnectRequest$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.setting.g.DoraObricGSettingsViewModel$handleGConnectRequest$2", f = "DoraObricGSettingsViewModel.kt", i = {}, l = {572, 575, 583, 591}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DoraDevice $device;
        int label;
        final /* synthetic */ DoraObricGSettingsViewModel this$0;

        public AnonymousClass2(DoraObricGSettingsViewModel r1, DoraDevice r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$device = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.this$0, this.$device, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L13;
            if (r1 == 2) goto L12;
            if (r1 == 3) goto L11;
            if (r1 != 4) goto L10;
            ResultKt.throwOnFailure(r13);
        L38:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r13);
        L30:
            return Unit.INSTANCE;
        L12:
            ResultKt.throwOnFailure(r13);
        L23:
            return Unit.INSTANCE;
        L13:
            ResultKt.throwOnFailure(r13);
        L17:
            DoraDevice r14 = (DoraDevice) r13;
            if (r14 != null) goto L24;
            g49.d.d(DoraObricGSettingsViewModel.TAG, "connect request, scan new device info error");
            DoraObricGSettingsViewModel r15 = this.this$0;
            this.label = 2;
            if (DoraObricGSettingsViewModel.access$onConnectRequestFailed(r15, this) != r0) goto L23;
            return r0;
        L24:
            DoraDevice r4 = this.$device;
            r4.mode = r14.mode;
            r4.version = r14.version;
            if (o59.a.v(r4) == true) goto L32;
            g49.d.d(DoraObricGSettingsViewModel.TAG, "connect request, this device don't support factory, connect spp");
            DoraObricGSettingsViewModel r16 = this.this$0;
            DoraDevice r2 = this.$device;
            this.label = 3;
            if (DoraObricGSettingsViewModel.access$onlyConnect(r16, r2, this) != r0) goto L30;
            return r0;
        L32:
            if (this.$device.isFactory() == false) goto L34;
            g49.d.d(DoraObricGSettingsViewModel.TAG, "connect request, device is factory, replace bind");
            this.this$0.replaceBind(this.$device);
            goto L38
        L34:
            MutableSharedFlow r17 = DoraObricGSettingsViewModel.access$get_effect$p(this.this$0);
            com.larus.dora.obric.device_management.setting.g.a.C0105a r3 = new com.larus.dora.obric.device_management.setting.g.a.C0105a(this.$device);
            this.label = 4;
            if (r17.emit(r3, this) != r0) goto L38;
            return r0;
        L14:
            ResultKt.throwOnFailure(r13);
            DoraObricGSettingsViewModel r18 = this.this$0;
            DoraDevice r6 = this.$device;
            this.label = 1;
            r13 = DoraObricGSettingsViewModel.scanBleInfo$default(r18, r6, 0, this, 2, null);
            if (r13 != r0) goto L17;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.setting.g.DoraObricGSettingsViewModel$isDeviceConnected$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.setting.g.DoraObricGSettingsViewModel", f = "DoraObricGSettingsViewModel.kt", i = {}, l = {717, 720}, m = "isDeviceConnected", n = {}, s = {})
    public static final class C04901 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraObricGSettingsViewModel this$0;

        public C04901(DoraObricGSettingsViewModel r1, Continuation<? super C04901> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return DoraObricGSettingsViewModel.access$isDeviceConnected(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.setting.g.DoraObricGSettingsViewModel$isDeviceConnected$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.setting.g.DoraObricGSettingsViewModel$isDeviceConnected$2", f = "DoraObricGSettingsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04912 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ DoraDevice $device;
        int label;

        public C04912(DoraDevice r1, Continuation<? super C04912> r2) {
            this.$device = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C04912(this.$device, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r2);
            if (kj4.a.g().getDoraLinkState(this.$device) != 2) goto L7;
            boolean r3 = true;
        L9:
            return Boxing.boxBoolean(r3);
        L7:
            r3 = false;
            goto L9
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.setting.g.DoraObricGSettingsViewModel$navigateTo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.setting.g.DoraObricGSettingsViewModel$navigateTo$1", f = "DoraObricGSettingsViewModel.kt", i = {}, l = {856}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04921 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map<String, Object> $params;
        final /* synthetic */ String $route;
        int label;
        final /* synthetic */ DoraObricGSettingsViewModel this$0;

        public C04921(DoraObricGSettingsViewModel r1, String r2, Map<String, ? extends Object> r3, Continuation<? super C04921> r4) {
            this.this$0 = r1;
            this.$route = r2;
            this.$params = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new C04921(this.this$0, this.$route, this.$params, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            MutableSharedFlow r7 = DoraObricGSettingsViewModel.access$get_navigation$p(this.this$0);
            s.a r2 = new s.a(this.$route, this.$params);
            this.label = 1;
            if (r7.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.setting.g.DoraObricGSettingsViewModel$navigateToDeviceName$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.setting.g.DoraObricGSettingsViewModel$navigateToDeviceName$1", f = "DoraObricGSettingsViewModel.kt", i = {}, l = {780}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04931 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DoraDevice $device;
        int label;
        final /* synthetic */ DoraObricGSettingsViewModel this$0;

        public C04931(DoraObricGSettingsViewModel r1, DoraDevice r2, Continuation<? super C04931> r3) {
            this.this$0 = r1;
            this.$device = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C04931(this.this$0, this.$device, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L19:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            MutableSharedFlow r9 = DoraObricGSettingsViewModel.access$get_navigation$p(this.this$0);
            Pair[] r3 = new Pair[6];
            int r4 = com.larus.dora.impl.util.o.a;
            DoraDevice r5 = this.$device;
            String r6 = r5.mac;
            String r7 = r5.name;
            String r10 = "";
            if (r7 != null) goto L11;
            r7 = "";
        L11:
            r3[0] = TuplesKt.to(DoraObricDeviceNameViewModel.KEY_DEVICE_NAME, com.larus.dora.impl.util.o.b(r6, r7));
            r3[1] = TuplesKt.to(DoraObricDeviceNameViewModel.KEY_MAC_ADDRESS, this.$device.mac);
            r3[2] = TuplesKt.to(DoraObricDeviceNameViewModel.KEY_DOUBLE_CONFIRM, Boxing.boxBoolean(true));
            r3[3] = TuplesKt.to("mac", this.$device.mac);
            r3[4] = TuplesKt.to("product_mac", this.$device.mac);
            String r11 = this.$device.name;
            if (r11 == null) goto L15;
            r10 = r11;
        L15:
            r3[5] = TuplesKt.to("device_name", r10);
            s.a r2 = new s.a("//flow/dora/obric_device_name", MapsKt.mapOf(r3));
            this.label = 1;
            if (r9.emit(r2, this) != r0) goto L19;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.setting.g.DoraObricGSettingsViewModel$navigateToEnvObserve$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.setting.g.DoraObricGSettingsViewModel$navigateToEnvObserve$1", f = "DoraObricGSettingsViewModel.kt", i = {}, l = {836}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04941 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map<String, Object> $params;
        int label;
        final /* synthetic */ DoraObricGSettingsViewModel this$0;

        public C04941(DoraObricGSettingsViewModel r1, Map<String, ? extends Object> r2, Continuation<? super C04941> r3) {
            this.this$0 = r1;
            this.$params = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C04941(this.this$0, this.$params, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            MutableSharedFlow r7 = DoraObricGSettingsViewModel.access$get_navigation$p(this.this$0);
            s.a r2 = new s.a("//flow/dora/obric_g_env_observe", this.$params);
            this.label = 1;
            if (r7.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.setting.g.DoraObricGSettingsViewModel$onConnectRequestFailed$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.setting.g.DoraObricGSettingsViewModel", f = "DoraObricGSettingsViewModel.kt", i = {0}, l = {696}, m = "onConnectRequestFailed", n = {"targetMac"}, s = {"L$0"})
    public static final class C04951 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraObricGSettingsViewModel this$0;

        public C04951(DoraObricGSettingsViewModel r1, Continuation<? super C04951> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return DoraObricGSettingsViewModel.access$onConnectRequestFailed(this.this$0, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.setting.g.DoraObricGSettingsViewModel$onlyConnect$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.setting.g.DoraObricGSettingsViewModel", f = "DoraObricGSettingsViewModel.kt", i = {2}, l = {605, 606, 609, 616, 617, 620, 634, 640}, m = "onlyConnect", n = {"device"}, s = {"L$0"})
    public static final class C04961 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraObricGSettingsViewModel this$0;

        public C04961(DoraObricGSettingsViewModel r1, Continuation<? super C04961> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return DoraObricGSettingsViewModel.access$onlyConnect(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.setting.g.DoraObricGSettingsViewModel$onlyLocalUnbindDisconnectedDevice$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.setting.g.DoraObricGSettingsViewModel$onlyLocalUnbindDisconnectedDevice$1", f = "DoraObricGSettingsViewModel.kt", i = {3}, l = {462, 465, 470, 474, 481}, m = "invokeSuspend", n = {"device"}, s = {"L$0"})
    public static final class C04971 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ DoraObricGSettingsViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.obric.device_management.setting.g.DoraObricGSettingsViewModel$onlyLocalUnbindDisconnectedDevice$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.dora.obric.device_management.setting.g.DoraObricGSettingsViewModel$onlyLocalUnbindDisconnectedDevice$1$1", f = "DoraObricGSettingsViewModel.kt", i = {}, l = {475}, m = "invokeSuspend", n = {}, s = {})
        public static final class C01041 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
            final /* synthetic */ DoraDevice $device;
            int label;

            public C01041(DoraDevice r1, Continuation<? super C01041> r2) {
                this.$device = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new C01041(this.$device, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r4) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r4);
            L11:
                return r4;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r4);
                kj4.a r5 = kj4.a.g();
                DoraDevice r2 = this.$device;
                this.label = 1;
                r4 = DoraAdapterExtKt.f(r5, r2);
                if (r4 != r0) goto L11;
                return r0;
            }
        }

        public C04971(DoraObricGSettingsViewModel r1, Continuation<? super C04971> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C04971(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L16;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L13;
            if (r1 == 4) goto L12;
            if (r1 != 5) goto L11;
            ResultKt.throwOnFailure(r10);
        L46:
            return Unit.INSTANCE;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            DoraDevice r2 = (DoraDevice) this.L$0;
            ResultKt.throwOnFailure(r10);
        L42:
            DoraObricGSettingsViewModel.access$sendDeviceUnbindBroadcast(this.this$0, r2.mac);
            MutableSharedFlow r11 = DoraObricGSettingsViewModel.access$get_effect$p(this.this$0);
            com.larus.dora.obric.device_management.setting.g.a.e r3 = com.larus.dora.obric.device_management.setting.g.a.e.a;
            this.L$0 = null;
            this.label = 5;
            if (r11.emit(r3, this) != r0) goto L46;
            return r0;
        L13:
            ResultKt.throwOnFailure(r10);
        L38:
            return Unit.INSTANCE;
        L14:
            ResultKt.throwOnFailure(r10);
        L32:
            r2 = (DoraDevice) r10;
            if (r2 != null) goto L39;
            MutableSharedFlow r12 = DoraObricGSettingsViewModel.access$get_effect$p(this.this$0);
            com.larus.dora.obric.device_management.setting.g.a.c r4 = new com.larus.dora.obric.device_management.setting.g.a.c(2131904036);
            this.label = 3;
            if (r12.emit(r4, this) != r0) goto L38;
            return r0;
        L39:
            CoroutineDispatcher r13 = Dispatchers.getIO();
            C01041 r5 = new C01041(r2, null);
            this.L$0 = r2;
            this.label = 4;
            if (BuildersKt.withContext(r13, r5, this) != r0) goto L42;
            return r0;
        L15:
            ResultKt.throwOnFailure(r10);
        L28:
            return Unit.INSTANCE;
        L16:
            ResultKt.throwOnFailure(r10);
            String r14 = DoraObricGSettingsViewModel.access$getTargetDeviceMac$p(this.this$0);
            if (r14 != null) goto L19;
        L22:
            boolean r6 = true;
        L23:
            if (r6 == false) goto L29;
            MutableSharedFlow r15 = DoraObricGSettingsViewModel.access$get_effect$p(this.this$0);
            com.larus.dora.obric.device_management.setting.g.a.c r7 = new com.larus.dora.obric.device_management.setting.g.a.c(2131904036);
            this.label = 1;
            if (r15.emit(r7, this) != r0) goto L28;
            return r0;
        L29:
            CoroutineDispatcher r8 = Dispatchers.getIO();
            DoraObricGSettingsViewModel$onlyLocalUnbindDisconnectedDevice$1$device$1 r9 = new DoraObricGSettingsViewModel$onlyLocalUnbindDisconnectedDevice$1$device$1(r14, null);
            this.label = 2;
            r10 = BuildersKt.withContext(r8, r9, this);
            if (r10 != r0) goto L32;
            return r0;
        L19:
            if (r14.length() == 0) goto L22;
            r6 = false;
            goto L23
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.setting.g.DoraObricGSettingsViewModel$replaceBind$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.setting.g.DoraObricGSettingsViewModel$replaceBind$1", f = "DoraObricGSettingsViewModel.kt", i = {}, l = {505, 508, 511, 512, 516, 517}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04981 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DoraDevice $device;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ DoraObricGSettingsViewModel this$0;

        public C04981(DoraDevice r1, DoraObricGSettingsViewModel r2, Continuation<? super C04981> r3) {
            this.$device = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C04981(this.$device, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch(this.label) {
                case 0: goto L12;
                case 1: goto L11;
                case 2: goto L10;
                case 3: goto L9;
                case 4: goto L8;
                case 5: goto L7;
                case 6: goto L6;
                default: goto L5;
            };
        L6:
            ResultKt.throwOnFailure(r10);
        L41:
            return Unit.INSTANCE;
        L7:
            DoraObricGSettingsViewModel r1 = (DoraObricGSettingsViewModel) this.L$1;
            Object r3 = this.L$0;
            ResultKt.throwOnFailure(r10);
        L37:
            this.L$0 = r3;
            this.L$1 = null;
            this.label = 6;
            if (DoraObricGSettingsViewModel.access$onConnectRequestFailed(r1, this) != r0) goto L41;
            return r0;
        L8:
            Object r2 = this.L$0;
            ResultKt.throwOnFailure(r10);
        L29:
            Unit r11 = Unit.INSTANCE;
        L31:
            DoraObricGSettingsViewModel r12 = this.this$0;
            Throwable r4 = Result.exceptionOrNull-impl(r2);
            if (r4 == null) goto L41;
            g49.d.c(DoraObricGSettingsViewModel.TAG, "replaceBind: failure exception", r4);
            this.L$0 = r2;
            this.L$1 = r12;
            this.label = 5;
            if (DoraObricGSettingsViewModel.access$emitToast(r12, 2131908080, this) != r0) goto L36;
            return r0;
        L36:
            r3 = r2;
            r1 = r12;
            goto L37
        L9:
            DoraObricGSettingsViewModel r5 = (DoraObricGSettingsViewModel) this.L$1;
            Object r6 = this.L$0;
            ResultKt.throwOnFailure(r10);
            DoraObricGSettingsViewModel r13 = r5;
            r2 = r6;
        L26:
            this.L$0 = r2;
            this.L$1 = null;
            this.label = 4;
            if (DoraObricGSettingsViewModel.access$onConnectRequestFailed(r13, this) != r0) goto L29;
            return r0;
        L10:
            r2 = this.L$0;
            ResultKt.throwOnFailure(r10);
            goto L31
        L11:
            ResultKt.throwOnFailure(r10);
            Object r14 = ((Result) r10).unbox-impl();
        L15:
            DoraObricGSettingsViewModel r7 = this.this$0;
            if (Result.isSuccess-impl(r14) == false) goto L30;
            int r8 = ((Number) r14).intValue();
            g49.d.d(DoraObricGSettingsViewModel.TAG, "replaceBind: replaceBindCode=" + r8);
            if (r8 != 1) goto L22;
            kj4.a r9 = kj4.a.g();
            this.L$0 = r14;
            this.label = 2;
            if (DoraAdapterExtKt.b(r9) != r0) goto L30;
            return r0;
        L22:
            g49.d.b(DoraObricGSettingsViewModel.TAG, "replaceBind: failure replaceBindCode=" + r8);
            this.L$0 = r14;
            this.L$1 = r7;
            this.label = 3;
            if (DoraObricGSettingsViewModel.access$emitToast(r7, 2131904024, this) != r0) goto L25;
            return r0;
        L25:
            r2 = r14;
            r13 = r7;
        L30:
            r2 = r14;
            goto L31
        L12:
            ResultKt.throwOnFailure(r10);
            DoraNetworkApi r15 = DoraNetworkApi.a;
            DoraDevice r16 = this.$device;
            this.label = 1;
            r14 = r15.w(r16, this);
            if (r14 != r0) goto L15;
            return r0;
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.setting.g.DoraObricGSettingsViewModel$scanBleInfo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.setting.g.DoraObricGSettingsViewModel", f = "DoraObricGSettingsViewModel.kt", i = {0, 0, 0}, l = {687}, m = "scanBleInfo", n = {"newDevice", "scanCallback", "startScanTs"}, s = {"L$0", "L$1", "J$0"})
    public static final class C04991 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraObricGSettingsViewModel this$0;

        public C04991(DoraObricGSettingsViewModel r1, Continuation<? super C04991> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r4) {
            this.result = r4;
            this.label |= Integer.MIN_VALUE;
            return DoraObricGSettingsViewModel.access$scanBleInfo(this.this$0, null, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.setting.g.DoraObricGSettingsViewModel$scanBleInfo$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.setting.g.DoraObricGSettingsViewModel$scanBleInfo$2", f = "DoraObricGSettingsViewModel.kt", i = {}, l = {687}, m = "invokeSuspend", n = {}, s = {})
    public static final class C05002 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CompletableDeferred<Unit> $done;
        int label;

        public C05002(CompletableDeferred<Unit> r1, Continuation<? super C05002> r2) {
            this.$done = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C05002(this.$done, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            CompletableDeferred<Unit> r5 = this.$done;
            this.label = 1;
            if (r5.await(this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.setting.g.DoraObricGSettingsViewModel$startReconnect$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.setting.g.DoraObricGSettingsViewModel$startReconnect$1", f = "DoraObricGSettingsViewModel.kt", i = {}, l = {216}, m = "invokeSuspend", n = {}, s = {})
    public static final class C05011 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $mac;
        int label;
        final /* synthetic */ DoraObricGSettingsViewModel this$0;

        public C05011(DoraObricGSettingsViewModel r1, String r2, Continuation<? super C05011> r3) {
            this.this$0 = r1;
            this.$mac = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C05011(this.this$0, this.$mac, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            DoraObricGSettingsViewModel r5 = this.this$0;
            String r2 = this.$mac;
            this.label = 1;
            if (DoraObricGSettingsViewModel.access$handleConnectRequest(r5, r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.setting.g.DoraObricGSettingsViewModel$unbindAndDisconnect$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.setting.g.DoraObricGSettingsViewModel", f = "DoraObricGSettingsViewModel.kt", i = {0}, l = {486}, m = "unbindAndDisconnect", n = {"device"}, s = {"L$0"})
    public static final class C05021 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DoraObricGSettingsViewModel this$0;

        public C05021(DoraObricGSettingsViewModel r1, Continuation<? super C05021> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.unbindAndDisconnect(null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.obric.device_management.setting.g.DoraObricGSettingsViewModel$unbindAndDisconnect$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.obric.device_management.setting.g.DoraObricGSettingsViewModel$unbindAndDisconnect$2", f = "DoraObricGSettingsViewModel.kt", i = {}, l = {487}, m = "invokeSuspend", n = {}, s = {})
    public static final class C05032 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ DoraDevice $device;
        int label;

        public C05032(DoraDevice r1, Continuation<? super C05032> r2) {
            this.$device = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C05032(this.$device, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L11:
            return r4;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            kj4.a r5 = kj4.a.g();
            DoraDevice r2 = this.$device;
            this.label = 1;
            r4 = DoraAdapterExtKt.f(r5, r2);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ IDoraPageConfig Mo() {
        return doraPageConfig_delegate$lambda$1();
    }

    public static /* synthetic */ IDoraService No() {
        return doraServiceImpl_delegate$lambda$0();
    }

    public static /* synthetic */ g59.c yo() {
        return featureConfigRepository_delegate$lambda$2();
    }

    public final void stopReconnect() {
        this.connectingDeviceMac = null;
        updateReconnectState(false);
    }

    private final t buildMemorySection() {
        String r1 = this.targetDeviceMac;
        if (r1 != null) goto L5;
        return null;
    L5:
        IDoraService r3 = getDoraServiceImpl();
        boolean r4 = false;
        if (r3 == null) goto L12;
        DeviceService r5 = r3.device();
        if (r5 == null) goto L12;
        if (r5.m0("env_obser", r1) != true) goto L12;
        boolean r2 = true;
    L13:
        d59.f r6 = getFeatureConfigRepository().a();
        if (r6 == null) goto L16;
        Map<String, d59.i> r7 = r6.a();
    L17:
        if (r2 == false) goto L25;
        if (r7 != null) goto L20;
    L22:
        boolean r8 = false;
    L23:
        if (r8 == false) goto L25;
        boolean r9 = true;
    L26:
        if (r2 == false) goto L34;
        if (r7 != null) goto L29;
    L31:
        boolean r10 = false;
    L32:
        if (r10 == false) goto L34;
        r4 = true;
        goto L34
    L29:
        if (r7.containsKey("memory_data") != true) goto L31;
        r10 = true;
    L34:
        List r11 = CollectionsKt.createListBuilder();
        if (r9 == false) goto L37;
        int r12 = j0.a;
        r11.add(new r(j0.d(2131903632), DoraObricGSettingsAction.ENV_OBSERVE, ((u) this._uiState.getValue()).d, false, 24));
    L37:
        if (r4 == false) goto L39;
        int r13 = j0.a;
        r11.add(new r(j0.d(2131903062), DoraObricGSettingsAction.MEMORY_DATA, null, false, 28));
    L39:
        List r14 = CollectionsKt.build(r11);
        if ((!r14.isEmpty()) == true) goto L43;
        r14 = null;
    L43:
        if (r14 == null) goto L46;
        int r15 = j0.a;
        return new t(j0.d(2131903635), r14);
    L46:
        return null;
    L20:
        if (r7.containsKey("environmental_observation") != true) goto L22;
        r8 = true;
    L25:
        r9 = false;
        goto L26
    L16:
        r7 = null;
    L12:
        r2 = false;
        goto L13
    }

    private static final IDoraPageConfig doraPageConfig_delegate$lambda$1() {
        return (IDoraPageConfig) ServiceManager.get().getService(IDoraPageConfig.class);
    }

    private static final IDoraService doraServiceImpl_delegate$lambda$0() {
        return (IDoraService) ServiceManager.get().getService(IDoraService.class);
    }

    private static final g59.c featureConfigRepository_delegate$lambda$2() {
        return new g59.c();
    }

    private final IDoraPageConfig getDoraPageConfig() {
        return (IDoraPageConfig) this.doraPageConfig$delegate.getValue();
    }

    private final IDoraService getDoraServiceImpl() {
        return (IDoraService) this.doraServiceImpl$delegate.getValue();
    }

    private final g59.c getFeatureConfigRepository() {
        return (g59.c) this.featureConfigRepository$delegate.getValue();
    }

    private final void navigateToDeviceInfo() {
        navigateTo("//flow/dora/obric_g_device_info");
    }

    private final void navigateToDoubaoConversationSettings() {
        navigateTo("//flow/dora/obric_doubao_conversation_settings");
    }

    private final void navigateToFeedback() {
        navigateTo("//flow/dora/obric_g_feedback");
    }

    private final void navigateToGeneralSettings() {
        navigateTo("//flow/dora/obric_g_general_settings");
    }

    private final void navigateToGestureSettings() {
        navigateTo("//flow/dora/obric_g_gesture_settings");
    }

    private final void navigateToMemoryData() {
        navigateTo("//flow/dora/o/memory_data");
    }

    private final void navigateToPrivacySettings() {
        navigateTo("//flow/dora/obric_privacy_settings");
    }

    private final void navigateToSoundSettings() {
        navigateTo("//flow/dora/obric_sound_settings");
    }

    private final void navigateToVideoRecordSettings() {
        navigateTo("//flow/dora/obric_g_video_record_settings");
    }

    private final void refreshDeviceInfoRedDot() {
        u r0 = (u) this._uiState.getValue();
        if (((u) this._uiState.getValue()).a == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        updateUiState(u.a(r0, false, r1, null, 11));
        return;
    L5:
        if (shouldShowDeviceInfoRedDot() == false) goto L7;
        r1 = true;
        goto L8
    }

    private final void refreshEnvironmentMemoryStatus() {
        u r0 = (u) this._uiState.getValue();
        if (((u) this._uiState.getValue()).a == false) goto L5;
        String r1 = resolveEnvObserveStatusText();
    L6:
        updateUiState(u.a(r0, false, false, r1, 7));
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final boolean shouldShowDeviceInfoRedDot() {
        String r0 = this.targetDeviceMac;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return false;
    L11:
        int r2 = DslRedDotAdapter.a;
        return DslRedDotAdapter.a(DslRedDotAdapter.RedDotType.FIRMWARE_UPGRADE.getValue(), targetDevice());
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final String onReconnectClicked() {
        String r0 = this.targetDeviceMac;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L12;
        g49.d.e(TAG, "onReconnectClicked skipped, targetDeviceMac is empty");
        updateReconnectState(false);
        return null;
    L12:
        return r0;
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public final DoraDevice targetDevice() {
        String r0 = this.targetDeviceMac;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L8:
        boolean r3 = true;
    L10:
        if (r3 == false) goto L13;
        g49.d.e(TAG, "targetDevice skipped, targetDeviceMac is empty");
        return null;
    L13:
        kj4.a r4 = kj4.a.g();
        Intrinsics.checkNotNull(r4);
        DoraDevice r5 = DoraAdapterExtKt.h(r4);
        if (r5 != null) goto L16;
    L26:
        Iterator r6 = DoraAdapterExtKt.k(r4).iterator();
    L28:
        if (r6.hasNext() == false) goto L37;
        Object r7 = r6.next();
        DoraDevice r8 = (DoraDevice) r7;
        if (Intrinsics.areEqual(r8.mac, r0) == true) goto L32;
    L34:
        boolean r9 = false;
    L35:
        if (r9 == false) goto L28;
    L38:
        r5 = (DoraDevice) r7;
        if (r5 != null) goto L51;
        x0.a.getClass();
        DoraDevice r10 = x0.a();
        if (r10 != null) goto L43;
        return null;
    L43:
        if (Intrinsics.areEqual(r10.mac, r0) == true) goto L45;
    L47:
        r1 = false;
    L48:
        if (r1 == true) goto L59;
        return null;
    L59:
        return r10;
    L45:
        if (o59.a.p(r10) == false) goto L47;
    L51:
        return r5;
    L32:
        if (o59.a.p(r8) == false) goto L34;
        r9 = true;
        goto L35
    L37:
        r7 = null;
        goto L38
    L16:
        if (Intrinsics.areEqual(r5.mac, r0) == true) goto L18;
    L20:
        boolean r11 = false;
    L21:
        if (r11 == true) goto L24;
        r5 = null;
    L24:
        if (r5 == null) goto L26;
    L18:
        if (o59.a.p(r5) == false) goto L20;
        r11 = true;
        goto L21
    L5:
        if (r0.length() == 0) goto L8;
        r3 = false;
        goto L10
    }

    public DoraObricGSettingsViewModel() {
        MutableSharedFlow<s> r3 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._navigation = r3;
        this.navigation = kotlinx.coroutines.flow.e.a(r3);
        MutableSharedFlow<com.larus.dora.obric.device_management.setting.g.a> r2 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._effect = r2;
        this.effect = kotlinx.coroutines.flow.e.a(r2);
        StateFlowImpl r0 = j1.a(new u(false, false, null, 15));
        this._uiState = r0;
        this.uiState = kotlinx.coroutines.flow.e.b(r0);
        this.doraServiceImpl$delegate = LazyKt.lazy(new v());
        this.doraPageConfig$delegate = LazyKt.lazy(new w());
        this.featureConfigRepository$delegate = LazyKt.lazy(new x());
        c r1 = new c(this);
        this.doraVoiceCallback = r1;
        IDoraService r4 = getDoraServiceImpl();
        if (r4 == null) goto L7;
        SessionService r5 = r4.d();
        if (r5 == null) goto L7;
        r5.i(r1);
    L7:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
    }

    private final boolean curEnvObserveState() {
        IDoraService r0 = getDoraServiceImpl();
        if (r0 == null) goto L18;
        SessionService r1 = r0.d();
        if (r1 != null) goto L8;
        return false;
    L8:
        if (r1.c == 11) goto L10;
        return false;
    L10:
        int r2 = r1.d;
        if (r2 != 2) goto L13;
    L16:
        return true;
    L13:
        if (r2 == 7) goto L16;
        if (r2 == 8) goto L16;
        return false;
    L18:
        return false;
    }

    private final void navigateToDeviceName() {
        DoraDevice r0 = targetDevice();
        if (r0 != null) goto L6;
        g49.d.e(TAG, "navigateToDeviceName skipped, target device not found");
        return;
    L6:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04931(this, r0, null), 3, null);
    }

    private final void navigateToEnvObserve() {
        DoraDevice r0 = targetDevice();
        if (r0 == null) goto L5;
        Map r1 = MapsKt.plus(toRouteParams(r0), MapsKt.mapOf(TuplesKt.to("key_dora_onboarding_device", com.larus.dora.impl.onboarding.x.c(r0))));
    L6:
        if (r1 != null) goto L8;
        r1 = MapsKt.emptyMap();
    L8:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04941(this, r1, null), 3, null);
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final String resolveEnvObserveStatusText() {
        IDoraPageConfig r0 = getDoraPageConfig();
        boolean r1 = false;
        if (r0 == null) goto L5;
        boolean r2 = r0.d("dora_g_config_key_env_observe_enable", false);
    L7:
        if (curEnvObserveState() == true) goto L9;
    L11:
        if (r2 == true) goto L13;
        int r3 = j0.a;
        return j0.d(2131902543);
    L13:
        if (r1 == false) goto L15;
        int r4 = j0.a;
        return j0.d(2131902545);
    L15:
        int r5 = j0.a;
        return j0.d(2131902544);
    L9:
        if (DoraAdapterExtKt.t(kj4.a.g()) == false) goto L11;
        r1 = true;
        goto L11
    L5:
        r2 = false;
        goto L7
    }

    public final String currentDeviceName() {
        DoraDevice r0 = targetDevice();
        int r1 = com.larus.dora.impl.util.o.a;
        String r2 = null;
        if (r0 == null) goto L5;
        String r3 = r0.mac;
    L6:
        if (r0 == null) goto L8;
        r2 = r0.name;
    L8:
        if (r2 != null) goto L11;
        r2 = "";
    L11:
        return com.larus.dora.impl.util.o.b(r3, r2);
    L5:
        r3 = null;
        goto L6
    }

    public final boolean isTargetDeviceConnected() {
        DoraDevice r0 = targetDevice();
        if (r0 != null) goto L6;
        return false;
    L6:
        if (kj4.a.g().getDoraLinkState(r0) != 2) goto L9;
        return true;
    L9:
        return false;
    }

    public void onCleared() {
        IDoraService r0 = getDoraServiceImpl();
        if (r0 == null) goto L7;
        SessionService r1 = r0.d();
        if (r1 == null) goto L7;
        r1.x(this.doraVoiceCallback);
    L7:
        Job r2 = this.reconnectJob;
        if (r2 == null) goto L10;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L10:
        super.onCleared();
    }

    public final void onlyLocalUnbindDisconnectedDevice() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04971(this, null), 3, null);
    }

    public final void refreshConnectionState() {
        boolean r0 = isTargetDeviceConnected();
        u r1 = (u) this._uiState.getValue();
        boolean r2 = false;
        if (r0 == false) goto L5;
        boolean r3 = false;
    L6:
        if (r0 == false) goto L8;
        r2 = shouldShowDeviceInfoRedDot();
    L8:
        if (r0 == false) goto L10;
        String r4 = resolveEnvObserveStatusText();
    L11:
        r1.getClass();
        updateUiState(new u(r0, r3, r2, r4));
        return;
    L10:
        r4 = null;
        goto L11
    L5:
        r3 = ((u) this._uiState.getValue()).b;
        goto L6
    }

    public final d1<com.larus.dora.obric.device_management.setting.g.a> getEffect() {
        return this.effect;
    }

    public final d1<s> getNavigation() {
        return this.navigation;
    }

    public final i1<u> getUiState() {
        return this.uiState;
    }

    public final String targetDeviceMac() {
        return this.targetDeviceMac;
    }

    public static final /* synthetic */ String access$getTargetDeviceMac$p(DoraObricGSettingsViewModel r0) {
        return r0.targetDeviceMac;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_effect$p(DoraObricGSettingsViewModel r0) {
        return r0._effect;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_navigation$p(DoraObricGSettingsViewModel r0) {
        return r0._navigation;
    }

    public static final /* synthetic */ void access$refreshDeviceInfoRedDot(DoraObricGSettingsViewModel r0) {
        r0.refreshDeviceInfoRedDot();
    }

    public static final /* synthetic */ void access$refreshEnvironmentMemoryStatus(DoraObricGSettingsViewModel r0) {
        r0.refreshEnvironmentMemoryStatus();
    }

    private final boolean isV2BleAdvertisementDevice(DoraDevice r3) {
        int r0 = r3.productId;
        if (r0 != ProductNameType.DORA_G2.id) goto L5;
    L12:
        return true;
    L5:
        if (r0 == ProductNameType.DORA_G_AIR.id) goto L12;
        int r4 = r3.type;
        if (r4 == 17) goto L12;
        if (r4 == 18) goto L12;
        return false;
    }

    private final void navigateTo(String r9) {
        DoraDevice r0 = targetDevice();
        if (r0 == null) goto L5;
        Map<String, Object> r1 = toRouteParams(r0);
    L6:
        if (r1 != null) goto L8;
        r1 = MapsKt.emptyMap();
    L8:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C04921(this, r9, r1, null), 3, null);
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final Object onConnectRequestFailed(Continuation<? super Unit> r6) {
        if ((r6 instanceof C04951) == false) goto L7;
        C04951 r0 = (C04951) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        String r4 = (String) r0.L$0;
        ResultKt.throwOnFailure(r7);
    L21:
        boolean r5 = false;
        if (((Boolean) r7).booleanValue() == false) goto L30;
        StringBuilder r8 = new StringBuilder("onConnectRequestFailed: skip reset because device already connected, macEmpty=");
        if (r4 != null) goto L26;
    L27:
        r5 = true;
    L28:
        r8.append(r5);
        g49.d.d(TAG, r8.toString());
        updateUiState(new u(true, shouldShowDeviceInfoRedDot(), resolveEnvObserveStatusText(), 2));
        return Unit.INSTANCE;
    L26:
        if (r4.length() != 0) goto L28;
    L30:
        updateReconnectState(false);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        String r9 = this.connectingDeviceMac;
        if (r9 != null) goto L17;
        r9 = this.targetDeviceMac;
    L17:
        this.connectingDeviceMac = null;
        r0.L$0 = r9;
        r0.label = 1;
        Object r10 = isDeviceConnected(r9, r0);
        if (r10 != r2) goto L20;
        return r2;
    L20:
        r4 = r9;
        r7 = r10;
    L7:
        r0 = new C04951(this, r6);
        goto L8
    }

    private final void sendDeviceUnbindBroadcast(String r3) {
        Intent r0 = new Intent("action.DEVICE_UNBIND");
        if (TextUtils.isEmpty(r3) == true) goto L7;
        if (r3 != null) goto L6;
        r3 = "";
    L6:
        r0.putExtra("mac", r3);
    L7:
        LocalBroadcastManager.getInstance(AppHost.a.getApplication()).sendBroadcast(r0);
    }

    private final Map<String, Object> toRouteParams(DoraDevice r4) {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("product_mac", r4.mac), TuplesKt.to("mac", r4.mac), TuplesKt.to("product_id", Integer.valueOf(r4.productId)), TuplesKt.to("model", r4.model), TuplesKt.to("vendor_id", Integer.valueOf(r4.vendorId))});
    }

    private final void updateReconnectState(boolean r5) {
        updateUiState(u.a((u) this._uiState.getValue(), r5, false, null, 13));
    }

    private final void updateUiState(u r2) {
        if (Intrinsics.areEqual(this._uiState.getValue(), r2) == true) goto L6;
        this._uiState.setValue(r2);
        return;
    }

    public final List<t> connected(String r28) {
        Intrinsics.checkNotNullParameter(r28, "deviceName");
        int r1 = j0.a;
        return CollectionsKt.listOfNotNull(new t[]{new t(null, CollectionsKt.listOf(new r(j0.d(2131902445), DoraObricGSettingsAction.DEVICE_NAME, r28, false, 24))), new t(j0.d(2131903633), CollectionsKt.listOf(new r[]{new r(j0.d(2131902423), DoraObricGSettingsAction.GESTURE, null, false, 28), new r(j0.d(2131903629), DoraObricGSettingsAction.DOUBAO_CONVERSATION, null, false, 28)})), new t(j0.d(2131903634), CollectionsKt.listOf(new r[]{new r(j0.d(2131902677), DoraObricGSettingsAction.SOUND, null, false, 28), new r(j0.d(2131902693), DoraObricGSettingsAction.VIDEO_RECORD, null, false, 28)})), new t(j0.d(2131903631), CollectionsKt.listOf(new r[]{new r(j0.d(2131902422), DoraObricGSettingsAction.GENERAL, null, false, 28), new r(j0.d(2131903630), DoraObricGSettingsAction.DEVICE_INFO, null, ((u) this._uiState.getValue()).c, 20)})), buildMemorySection(), new t(null, CollectionsKt.listOf(new r(j0.d(2131903929), DoraObricGSettingsAction.PRIVACY_AND_PERMISSION, null, false, 28))), new t(null, CollectionsKt.listOf(new r(j0.d(2131902729), DoraObricGSettingsAction.FEEDBACK, null, false, 28)))});
    }

    public final List<t> disconnected(String r23) {
        Intrinsics.checkNotNullParameter(r23, "deviceName");
        DoraDevice r0 = targetDevice();
        if (r0 == null) goto L10;
        String r4 = com.larus.dora.impl.util.o.a(r0);
        if ((!StringsKt.isBlank(r4)) == true) goto L8;
        r4 = null;
    L8:
        if (r4 == null) goto L10;
        String r8 = r4;
    L11:
        t[] r1 = new t[4];
        int r5 = j0.a;
        String r6 = j0.d(2131902445);
        DoraObricGSettingsAction r15 = DoraObricGSettingsAction.NONE;
        r1[0] = new t(null, CollectionsKt.listOf(new r(r6, r15, r8, false, 8)));
        r[] r7 = new r[2];
        String r10 = j0.d(2131902649);
        if (r0 == null) goto L14;
        String r9 = r0.softVersion;
    L16:
        if (r9 != null) goto L18;
        String r12 = "";
    L19:
        r7[0] = new r(r10, r15, r12, false, 8);
        String r11 = j0.d(2131902648);
        if (r0 == null) goto L22;
        String r2 = r0.sn;
    L23:
        if (r2 != null) goto L25;
        String r13 = "";
    L26:
        r7[1] = new r(r11, r15, r13, false, 8);
        r1[1] = new t(null, CollectionsKt.listOf(r7));
        r1[2] = new t(null, CollectionsKt.listOf(new r(j0.d(2131903929), DoraObricGSettingsAction.PRIVACY_AND_PERMISSION, null, false, 28)));
        r1[3] = new t(null, CollectionsKt.listOf(new r(j0.d(2131902729), DoraObricGSettingsAction.FEEDBACK, null, false, 28)));
        return CollectionsKt.listOf(r1);
    L25:
        r13 = r2;
        goto L26
    L22:
        r2 = null;
        goto L23
    L18:
        r12 = r9;
        goto L19
    L14:
        r9 = null;
    L10:
        r8 = r23;
        goto L11
    }

    public final void initialize(Bundle r5) {
        boolean r0 = true;
        String r1 = null;
        if (r5 == null) goto L12;
        String r2 = r5.getString("product_mac");
        if (r2 == null) goto L12;
        if ((!StringsKt.isBlank(r2)) == true) goto L10;
        r2 = null;
    L10:
        if (r2 == null) goto L12;
        r1 = r2;
    L18:
        this.targetDeviceMac = r1;
        StringBuilder r6 = new StringBuilder("initialize targetDeviceMacEmpty=");
        String r3 = this.targetDeviceMac;
        if (r3 != null) goto L21;
    L24:
        r6.append(r0);
        g49.d.d(TAG, r6.toString());
        refreshDeviceInfoRedDot();
        return;
    L21:
        if (r3.length() == 0) goto L24;
        r0 = false;
    L12:
        if (r5 == null) goto L18;
        String r7 = r5.getString("mac");
        if (r7 == null) goto L18;
        if ((!StringsKt.isBlank(r7)) == false) goto L18;
        r1 = r7;
        goto L18
    }

    public final void onItemClicked(r r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        DoraObricGSettingsAction r3 = r2.b;
        switch(b.b[r3.ordinal()]) {
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            case 10: goto L7;
            case 11: goto L6;
            case 12: goto L5;
            default: goto L27;
        };
    L5:
        navigateToFeedback();
        return;
    L6:
        navigateToPrivacySettings();
        return;
    L7:
        navigateToMemoryData();
        return;
    L8:
        navigateToEnvObserve();
        return;
    L9:
        navigateToDeviceInfo();
        return;
    L10:
        navigateToGeneralSettings();
        return;
    L11:
        navigateToVideoRecordSettings();
        return;
    L12:
        navigateToSoundSettings();
        return;
    L13:
        navigateToDoubaoConversationSettings();
        return;
    L14:
        navigateToGestureSettings();
        return;
    L15:
        navigateToDeviceName();
        return;
    }

    public final void replaceBind(DoraDevice r8) {
        Intrinsics.checkNotNullParameter(r8, "device");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C04981(r8, this, null), 2, null);
    }

    public final void startReconnect(String r10) {
        if (r10 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        g49.d.e(TAG, "startReconnect skipped, mac is empty");
        stopReconnect();
        return;
    L12:
        this.connectingDeviceMac = r10;
        updateReconnectState(true);
        Job r2 = this.reconnectJob;
        if (r2 == null) goto L15;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L15:
        this.reconnectJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C05011(this, r10, null), 3, null);
        return;
    L5:
        if (r10.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public static final /* synthetic */ Object access$onConnectRequestFailed(DoraObricGSettingsViewModel r0, Continuation r1) {
        return r0.onConnectRequestFailed(r1);
    }

    public static final /* synthetic */ void access$sendDeviceUnbindBroadcast(DoraObricGSettingsViewModel r0, String r1) {
        r0.sendDeviceUnbindBroadcast(r1);
    }

    private final Object emitToast(int r3, Continuation<? super Unit> r4) {
        Object r5 = this._effect.emit(new com.larus.dora.obric.device_management.setting.g.a.c(r3), r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r5;
    L6:
        return Unit.INSTANCE;
    }

    private final Object handleConnectRequest(String r6, Continuation<? super Unit> r7) {
        if ((r7 instanceof C04881) == false) goto L7;
        C04881 r0 = (C04881) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r0.label) {
            case 0: goto L21;
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            default: goto L11;
        };
    L12:
        ResultKt.throwOnFailure(r8);
    L50:
        return Unit.INSTANCE;
    L13:
        ResultKt.throwOnFailure(r8);
    L46:
        r0.label = 7;
        if (onConnectRequestFailed(r0) != r2) goto L50;
        return r2;
    L14:
        ResultKt.throwOnFailure(r8);     // Catch: Exception -> L19
        goto L50
    L15:
        ResultKt.throwOnFailure(r8);     // Catch: Exception -> L19
    L34:
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r8);     // Catch: Exception -> L19
    L30:
        r0.label = 3;     // Catch: Exception -> L19
        if (onConnectRequestFailed(r0) != r2) goto L34;
        return r2;
    L17:
        ResultKt.throwOnFailure(r8);     // Catch: Exception -> L19
    L25:
        DoraDevice r9 = (DoraDevice) r8;     // Catch: Exception -> L19
        if (r9 != null) goto L36;
        r0.label = 2;     // Catch: Exception -> L19
        if (emitToast(2131902626, r0) != r2) goto L30;
        return r2;
    L36:
        if (o59.a.p(r9) == false) goto L40;
        r0.label = 4;     // Catch: Exception -> L19
        if (handleGConnectRequest(r9, r0) != r2) goto L50;
        return r2;
    L40:
        r0.label = 5;     // Catch: Exception -> L19
        if (onConnectRequestFailed(r0) != r2) goto L50;
        return r2;
    L21:
        ResultKt.throwOnFailure(r8);
        CoroutineDispatcher r10 = Dispatchers.getIO();     // Catch: Exception -> L19
        DoraObricGSettingsViewModel$handleConnectRequest$device$1 r3 = new DoraObricGSettingsViewModel$handleConnectRequest$device$1(r6, null);     // Catch: Exception -> L19
        r0.label = 1;     // Catch: Exception -> L19
        r8 = BuildersKt.withContext(r10, r3, r0);     // Catch: Exception -> L19
        if (r8 != r2) goto L25;
        return r2;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        e = move-exception;
        g49.d.b(TAG, "handleConnectRequest: Exception=" + e);
        r0.label = 6;
        if (emitToast(2131902626, r0) != r2) goto L46;
        return r2;
    L7:
        r0 = new C04881(this, r7);
        goto L8
    }

    private final Object handleGConnectRequest(DoraDevice r10, Continuation<? super Unit> r11) {
        if ((r11 instanceof C04891) == false) goto L7;
        C04891 r0 = (C04891) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r0.label) {
            case 0: goto L26;
            case 1: goto L23;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            case 8: goto L13;
            case 9: goto L12;
            default: goto L11;
        };
    L12:
        ResultKt.throwOnFailure(r12);
    L67:
        return Unit.INSTANCE;
    L13:
        ResultKt.throwOnFailure(r12);
    L63:
        r0.label = 9;
        if (onConnectRequestFailed(r0) != r2) goto L67;
        return r2;
    L14:
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L21
        goto L67
    L15:
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L21
    L56:
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L21
    L49:
        return Unit.INSTANCE;
    L17:
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L21
    L45:
        r0.label = 5;     // Catch: Throwable -> L21
        if (onConnectRequestFailed(r0) != r2) goto L49;
        return r2;
    L18:
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L21
    L39:
        return Unit.INSTANCE;
    L19:
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L21
    L35:
        r0.label = 3;     // Catch: Throwable -> L21
        if (onConnectRequestFailed(r0) != r2) goto L39;
        return r2;
    L23:
        r10 = (DoraDevice) r0.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L21
    L30:
        OnlyBindResult r13 = (OnlyBindResult) r12;     // Catch: Throwable -> L21
        if (CollectionsKt.listOf(new OnlyBindResult[]{OnlyBindResult.SERVER_BIND_NETWORK_ERROR, OnlyBindResult.SERVER_BIND_UNKNOWN}).contains(r13) == false) goto L41;
        r0.L$0 = null;     // Catch: Throwable -> L21
        r0.label = 2;     // Catch: Throwable -> L21
        if (emitToast(2131908080, r0) != r2) goto L35;
        return r2;
    L41:
        if (r13 != OnlyBindResult.SERVER_BIND_FAILED) goto L51;
        String r14 = AppHost.a.getApplication().getString(2131903938, new Object[]{o59.a.g(r10)});     // Catch: Throwable -> L21
        r0.L$0 = null;     // Catch: Throwable -> L21
        r0.label = 4;     // Catch: Throwable -> L21
        if (emitToast(r14, r0) != r2) goto L45;
        return r2;
    L51:
        if (r13 != OnlyBindResult.SUCCESS) goto L57;
        g49.d.d(TAG, "connect request, bind success, connect spp");     // Catch: Throwable -> L21
        r0.L$0 = null;     // Catch: Throwable -> L21
        r0.label = 6;     // Catch: Throwable -> L21
        if (onlyConnect(r10, r0) != r2) goto L56;
        return r2;
    L57:
        g49.d.d(TAG, "connect request, current device need unbind");     // Catch: Throwable -> L21
        CoroutineDispatcher r15 = Dispatchers.getIO();     // Catch: Throwable -> L21
        AnonymousClass2 r3 = new AnonymousClass2(this, r10, null);     // Catch: Throwable -> L21
        r0.L$0 = null;     // Catch: Throwable -> L21
        r0.label = 7;     // Catch: Throwable -> L21
        if (BuildersKt.withContext(r15, r3, r0) != r2) goto L67;
        return r2;
    L26:
        ResultKt.throwOnFailure(r12);
        CoroutineDispatcher r16 = Dispatchers.getIO();     // Catch: Throwable -> L21
        DoraObricGSettingsViewModel$handleGConnectRequest$bindResult$1 r4 = new DoraObricGSettingsViewModel$handleGConnectRequest$bindResult$1(r10, null);     // Catch: Throwable -> L21
        r0.L$0 = r10;     // Catch: Throwable -> L21
        r0.label = 1;     // Catch: Throwable -> L21
        r12 = BuildersKt.withContext(r16, r4, r0);     // Catch: Throwable -> L21
        if (r12 != r2) goto L30;
        return r2;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L21:
        th = move-exception;
        g49.d.d(TAG, "handleGConnectRequest: Exception=" + th);
        r0.L$0 = null;
        r0.label = 8;
        if (emitToast(2131902626, r0) != r2) goto L63;
        return r2;
    L7:
        r0 = new C04891(this, r11);
        goto L8
    }

    private final Object isDeviceConnected(String r8, Continuation<? super Boolean> r9) {
        if ((r9 instanceof C04901) == false) goto L7;
        C04901 r0 = (C04901) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r10);
    L36:
        return r10;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r10);
    L29:
        DoraDevice r11 = (DoraDevice) r10;
        if (r11 == null) goto L32;
        CoroutineDispatcher r12 = Dispatchers.getIO();
        C04912 r4 = new C04912(r11, null);
        r0.label = 2;
        r10 = BuildersKt.withContext(r12, r4, r0);
        if (r10 != r2) goto L36;
        return r2;
    L32:
        return Boxing.boxBoolean(false);
    L16:
        ResultKt.throwOnFailure(r10);
        if (r8 != null) goto L19;
    L22:
        boolean r13 = true;
    L23:
        if (r13 == true) goto L25;
        CoroutineDispatcher r14 = Dispatchers.getIO();
        DoraObricGSettingsViewModel$isDeviceConnected$device$1 r5 = new DoraObricGSettingsViewModel$isDeviceConnected$device$1(r8, null);
        r0.label = 1;
        r10 = BuildersKt.withContext(r14, r5, r0);
        if (r10 != r2) goto L29;
        return r2;
    L25:
        return Boxing.boxBoolean(false);
    L19:
        if (r8.length() == 0) goto L22;
        r13 = false;
    L7:
        r0 = new C04901(this, r9);
        goto L8
    }

    private final Object onlyConnect(DoraDevice r12, Continuation<? super Unit> r13) {
        if ((r13 instanceof C04961) == false) goto L7;
        C04961 r3 = (C04961) r13;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r14 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r3.label) {
            case 0: goto L24;
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L17;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L14;
            case 8: goto L12;
            default: goto L11;
        };
    L12:
        ResultKt.throwOnFailure(r14);
    L67:
        return Unit.INSTANCE;
    L13:
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L22
    L49:
        int r15 = ((Number) r14).intValue();     // Catch: Throwable -> L22
        g49.d.d(TAG, "onlyConnect: state=" + r15);     // Catch: Throwable -> L22
        if (r15 != 2) goto L52;
        this.connectingDeviceMac = null;     // Catch: Throwable -> L22
        updateUiState(new u(true, shouldShowDeviceInfoRedDot(), resolveEnvObserveStatusText(), 2));     // Catch: Throwable -> L22
        goto L67
    L52:
        r3.label = 7;     // Catch: Throwable -> L22
        if (onConnectRequestFailed(r3) != r5) goto L67;
        return r5;
    L14:
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L22
        goto L67
    L15:
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L22
    L60:
        r3.label = 5;     // Catch: Throwable -> L22
        if (onConnectRequestFailed(r3) != r5) goto L67;
        return r5;
    L17:
        r12 = (DoraDevice) r3.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L22
    L42:
        OnlyConnectResult r16 = (OnlyConnectResult) r14;     // Catch: Throwable -> L22
        g49.d.d(TAG, "only connect: result=" + r16);     // Catch: Throwable -> L22
        int r17 = b.a[r16.ordinal()];     // Catch: Throwable -> L22
        if (r17 == 1) goto L57;
        if (r17 == 2) goto L57;
        if (r17 != 3) goto L56;
        CoroutineDispatcher r18 = Dispatchers.getIO();     // Catch: Throwable -> L22
        DoraObricGSettingsViewModel$onlyConnect$state$1 r1 = new DoraObricGSettingsViewModel$onlyConnect$state$1(r12, null);     // Catch: Throwable -> L22
        r3.L$0 = null;     // Catch: Throwable -> L22
        r3.label = 6;     // Catch: Throwable -> L22
        r14 = BuildersKt.withContext(r18, r1, r3);     // Catch: Throwable -> L22
        if (r14 != r5) goto L49;
        return r5;
    L56:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L22
    L57:
        MutableSharedFlow<com.larus.dora.obric.device_management.setting.g.a> r110 = this._effect;     // Catch: Throwable -> L22
        com.larus.dora.obric.device_management.setting.g.a.b r0 = new com.larus.dora.obric.device_management.setting.g.a.b(r12);     // Catch: Throwable -> L22
        r3.L$0 = null;     // Catch: Throwable -> L22
        r3.label = 4;     // Catch: Throwable -> L22
        if (r110.emit(r0, r3) != r5) goto L60;
        return r5;
    L19:
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L22
    L38:
        return Unit.INSTANCE;
    L20:
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L22
    L34:
        r3.label = 2;     // Catch: Throwable -> L22
        if (onConnectRequestFailed(r3) != r5) goto L38;
        return r5;
    L24:
        ResultKt.throwOnFailure(r14);
        StringBuilder r111 = new StringBuilder("start only connect, hasDevice=");     // Catch: Throwable -> L22
        if (r12 == null) goto L28;
        boolean r2 = true;
    L29:
        r111.append(r2);     // Catch: Throwable -> L22
        g49.d.d(TAG, r111.toString());     // Catch: Throwable -> L22
        if (r12 != null) goto L39;
        r3.label = 1;     // Catch: Throwable -> L22
        if (emitToast(2131902626, r3) != r5) goto L34;
        return r5;
    L39:
        CoroutineDispatcher r112 = Dispatchers.getIO();     // Catch: Throwable -> L22
        DoraObricGSettingsViewModel$onlyConnect$connectResult$1 r6 = new DoraObricGSettingsViewModel$onlyConnect$connectResult$1(r12, null);     // Catch: Throwable -> L22
        r3.L$0 = r12;     // Catch: Throwable -> L22
        r3.label = 3;     // Catch: Throwable -> L22
        r14 = BuildersKt.withContext(r112, r6, r3);     // Catch: Throwable -> L22
        if (r14 != r5) goto L42;
        return r5;
    L28:
        r2 = false;
        goto L29
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L22:
        th = move-exception;
        g49.d.b(TAG, "onlyConnect: exception=" + th);
        r3.L$0 = null;
        r3.label = 8;
        if (onConnectRequestFailed(r3) != r5) goto L67;
        return r5;
    L7:
        r3 = new C04961(this, r13);
        goto L8
    }

    public final Object unbindAndDisconnect(DoraDevice r6, Continuation<? super Unit> r7) {
        if ((r7 instanceof C05021) == false) goto L7;
        C05021 r0 = (C05021) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r6 = (DoraDevice) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L17:
        sendDeviceUnbindBroadcast(r6.mac);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        CoroutineDispatcher r9 = Dispatchers.getIO();
        C05032 r4 = new C05032(r6, null);
        r0.L$0 = r6;
        r0.label = 1;
        if (BuildersKt.withContext(r9, r4, r0) != r2) goto L17;
        return r2;
    L7:
        r0 = new C05021(this, r7);
        goto L8
    }

    private final Object emitToast(String r3, Continuation<? super Unit> r4) {
        Object r5 = this._effect.emit(new com.larus.dora.obric.device_management.setting.g.a.d(r3), r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r5;
    L6:
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Object access$emitToast(DoraObricGSettingsViewModel r0, int r1, Continuation r2) {
        return r0.emitToast(r1, r2);
    }

    public static final /* synthetic */ Object access$handleConnectRequest(DoraObricGSettingsViewModel r0, String r1, Continuation r2) {
        return r0.handleConnectRequest(r1, r2);
    }

    public static final /* synthetic */ Object access$handleGConnectRequest(DoraObricGSettingsViewModel r0, DoraDevice r1, Continuation r2) {
        return r0.handleGConnectRequest(r1, r2);
    }

    public static final /* synthetic */ Object access$isDeviceConnected(DoraObricGSettingsViewModel r0, String r1, Continuation r2) {
        return r0.isDeviceConnected(r1, r2);
    }

    public static final /* synthetic */ Object access$onlyConnect(DoraObricGSettingsViewModel r0, DoraDevice r1, Continuation r2) {
        return r0.onlyConnect(r1, r2);
    }

    private final Object scanBleInfo(DoraDevice r16, long r17, Continuation<? super DoraDevice> r110) {
        if ((r110 instanceof C04991) == false) goto L7;
        C04991 r1 = (C04991) r110;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        long r5 = r1.J$0;
        d r6 = (d) r1.L$1;
        Ref.ObjectRef r7 = (Ref.ObjectRef) r1.L$0;
        ResultKt.throwOnFailure(r0);
    L26:
        g49.d.d(TAG, "scan ble info cost=" + (System.currentTimeMillis() - r5));
        kj4.a.g().stopScan(r6);
        return r7.element;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        String r8 = r16.mac;
        boolean r9 = isV2BleAdvertisementDevice(r16);
        if (r9 == false) goto L17;
        List r10 = CollectionsKt.mutableListOf(new String[]{"00002010-0000-1000-8000-00805F9B34FB"});
    L18:
        long r11 = System.currentTimeMillis();
        CompletableDeferred r12 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        Ref.ObjectRef r13 = new Ref.ObjectRef();
        StringBuilder r14 = new StringBuilder("connect request, start scan ble info, macEmpty=");
        Intrinsics.checkNotNull(r8);
        if (r8.length() != 0) goto L21;
        boolean r15 = true;
    L22:
        r14.append(r15);
        r14.append(", isV2BleDevice=");
        r14.append(r9);
        r14.append(", scanUuidCount=");
        r14.append(r10.size());
        g49.d.d(TAG, r14.toString());
        d r18 = new d(r12, r9, r8, r13);
        kj4.a.g().scan(r10, r18);
        C05002 r20 = new C05002(r12, null);
        r1.L$0 = r13;
        r1.L$1 = r18;
        r1.J$0 = r11;
        r1.label = 1;
        if (TimeoutKt.c(r17, r20, r1) != r3) goto L25;
        return r3;
    L25:
        r5 = r11;
        r7 = r13;
        r6 = r18;
        goto L26
    L21:
        r15 = false;
        goto L22
    L17:
        r10 = CollectionsKt.mutableListOf(new String[]{"0000FD7B-0000-1000-8000-00805F9B34FB"});
    L7:
        r1 = new C04991(this, r110);
        goto L8
    }

    public static final /* synthetic */ Object access$emitToast(DoraObricGSettingsViewModel r0, String r1, Continuation r2) {
        return r0.emitToast(r1, r2);
    }

    public static final /* synthetic */ Object access$scanBleInfo(DoraObricGSettingsViewModel r0, DoraDevice r1, long r2, Continuation r4) {
        return r0.scanBleInfo(r1, r2, r4);
    }

    public static /* synthetic */ Object scanBleInfo$default(DoraObricGSettingsViewModel r0, DoraDevice r1, long r2, Continuation r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = SCAN_BLE_INFO_TIMEOUT_MS;
    L6:
        return r0.scanBleInfo(r1, r2, r4);
    }
}
