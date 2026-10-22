package com.larus.dora.impl.device.settings.lab;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.dora.device.DoraDevice;
import com.larus.account.base.api.ILoginService;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.IDoraService$b;
import com.larus.dora.api.config.IDoraPageConfig;
import com.larus.dora.api.protocol.FlowProtocolAbility;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.DoraServiceImpl;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.core.o0;
import com.larus.dora.impl.core.settingsconfig.DoraXLinkTransportMode;
import com.larus.dora.impl.core.wifi.DoraP2pRtcSwitchSync;
import com.larus.dora.impl.core.wifi.DoraWifiLinkWrapper;
import com.larus.dora.impl.core.x0;
import com.larus.dora.impl.device.settings.lab.env.DoraEnvObserveNetwork;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.serviceimpl.SessionService;
import com.larus.dora.impl.util.b0;
import com.larus.dora.impl.util.t0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\u0018\u0000 Q2\u00020\u0001:\u0001QB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u0004\u0018\u000100J\u0006\u00101\u001a\u00020.J\u0006\u00102\u001a\u00020.J\b\u00103\u001a\u000204H\u0002J\u000e\u00105\u001a\u00020.2\u0006\u00106\u001a\u000204J\u000e\u00107\u001a\u00020.2\u0006\u00108\u001a\u000209J \u0010:\u001a\u00020.2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u0002042\u0006\u0010>\u001a\u000204H\u0002J\u0016\u0010?\u001a\u00020\u00132\u0006\u00106\u001a\u000204H\u0082@¢\u0006\u0002\u0010@J\u0010\u0010A\u001a\u0002042\u0006\u0010B\u001a\u00020\u0013H\u0002J\u0016\u0010C\u001a\u00020\u00132\u0006\u00106\u001a\u000204H\u0082@¢\u0006\u0002\u0010@J\u000e\u0010D\u001a\u00020.2\u0006\u00106\u001a\u000204J\u000e\u0010E\u001a\u00020.2\u0006\u00106\u001a\u000204J\b\u0010F\u001a\u000204H\u0002J\u000e\u0010G\u001a\u00020.2\u0006\u00106\u001a\u000204J\u0006\u0010H\u001a\u000204J\u000e\u0010I\u001a\u00020.2\u0006\u00106\u001a\u000204J\u000e\u0010J\u001a\u00020.2\u0006\u00106\u001a\u000204J\b\u0010K\u001a\u00020.H\u0002J\b\u0010L\u001a\u000204H\u0002J\b\u0010M\u001a\u000204H\u0002J\f\u0010N\u001a\u00020\u0013*\u000204H\u0002J\b\u0010O\u001a\u00020.H\u0002J\b\u0010P\u001a\u00020.H\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0013X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0013X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010\"\u001a\u0004\u0018\u00010#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b$\u0010%R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lcom/larus/dora/impl/device/settings/lab/LabSettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_envStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/dora/impl/device/settings/lab/LabEnvSettings;", "envStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getEnvStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "_envActionSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/larus/dora/impl/device/settings/lab/LabEnvAction;", "envActionSharedFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getEnvActionSharedFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "ENV_OB_UVI_SUCCESS", "", "getENV_OB_UVI_SUCCESS", "()I", "ENV_OB_TX_TIMEOUT", "getENV_OB_TX_TIMEOUT", "ENV_OB_UVI_FAILED_WITH_REASON", "", "getENV_OB_UVI_FAILED_WITH_REASON", "()Ljava/util/List;", "doraServiceImpl", "Lcom/larus/dora/api/IDoraService;", "getDoraServiceImpl", "()Lcom/larus/dora/api/IDoraService;", "doraServiceImpl$delegate", "Lkotlin/Lazy;", "doraPageConfig", "Lcom/larus/dora/api/config/IDoraPageConfig;", "getDoraPageConfig", "()Lcom/larus/dora/api/config/IDoraPageConfig;", "doraPageConfig$delegate", "doraVoiceCallback", "Lcom/larus/dora/api/protocol/IFlowDoraVoiceCallBack;", "featureConfigRepository", "Lcom/larus/dora/impl/dynamic/repository/DoraFeatureConfigRepository;", "rtcTransportModeMutex", "Lkotlinx/coroutines/sync/Mutex;", "initData", "", "getFeatureConfig", "Lcom/larus/dora/impl/dynamic/entity/DoraLabFeatureConfig;", "onVoiceWakeUpState", "forceUpdateEnable", "curEnvObserveState", "", "setQuickContinuousConversationEnable", "isEnabled", "setRTCTransportMode", "mode", "Lcom/larus/dora/impl/device/settings/lab/RTCTransportMode;", "updateRTCTransportLocalState", "uid", "", "bluetoothRTCEnable", "p2pRTCEnable", "syncBluetoothRTCVideoCallSwitch", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isRTCSwitchSyncAccepted", "ret", "syncEffectiveP2PRTCVideoCallSwitch", "setBehaviorAwareEnable", "setNaturalInteractionBgmEnable", "isNaturalWakeupSettingBlocked", "setDataSavingEnable", "isDataSavingEntranceVisible", "setAllowDoubaoViewImagesEnable", "setRtosPlayerEnabled", "updateCacheAndUIState", "takeBehaviorAwareToggle", "isSupportBehaviorAware", "toToggleValue", "fetchData", "onCleared", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LabSettingsViewModel extends ViewModel {
    public static final b Companion = null;
    private static final int RET_FAILED = -1;
    private static final int SYNC_MAX_RETRIES = 3;
    private static final long SYNC_RETRY_DELAY_MS = 100;
    public static final String TAG = "LabSettingsViewModel";
    private static final int TOGGLE_OFF = 0;
    private static final int TOGGLE_ON = 1;
    private final int ENV_OB_TX_TIMEOUT;
    private final List<Integer> ENV_OB_UVI_FAILED_WITH_REASON;
    private final int ENV_OB_UVI_SUCCESS;
    private final MutableSharedFlow<com.larus.dora.impl.device.settings.lab.b> _envActionSharedFlow;
    private z0<c> _envStateFlow;
    private final Lazy doraPageConfig$delegate;
    private final Lazy doraServiceImpl$delegate;
    private f49.b doraVoiceCallback;
    private final d1<com.larus.dora.impl.device.settings.lab.b> envActionSharedFlow;
    private final i1<c> envStateFlow;
    private final g59.c featureConfigRepository;
    private final kotlinx.coroutines.sync.a rtcTransportModeMutex;

    public static final class a extends t0 {
        public final /* synthetic */ LabSettingsViewModel a;

        public a(LabSettingsViewModel r1) {
            this.a = r1;
        }

        public final void onDoraLinkStateChanged(DoraDevice r1, int r2, int r3) {
            g49.d.a(LabSettingsViewModel.TAG, "onDoraLinkStateChanged: state=" + r3);
            if (r3 != 2) goto L6;
            LabSettingsViewModel.access$initData(this.a);
            return;
        }
    }

    public static final class b {
        public b() {
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$fetchData$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$fetchData$1", f = "LabSettingsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            DoraEnvObserveNetwork.a();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$forceUpdateEnable$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$forceUpdateEnable$1", f = "LabSettingsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02621 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ LabSettingsViewModel this$0;

        public C02621(LabSettingsViewModel r1, Continuation<? super C02621> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02621(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r110) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L33;
            ResultKt.throwOnFailure(r110);
            if ((LabSettingsViewModel.access$get_envStateFlow$p(this.this$0).getValue() instanceof c.b) == false) goto L31;
            String r1 = ILoginService.a.getAccountInfo().c;
            if (r1 != null) goto L9;
            r1 = "";
        L9:
            DoraWifiLinkWrapper.a.getClass();
            DoraWifiLinkWrapper.a r2 = DoraWifiLinkWrapper.n();
            boolean r13 = r2.a();
            boolean r14 = r2.b;
            b0.a.getClass();
            boolean r3 = b0.p(r1);
            boolean r4 = b0.u(r1);
            com.larus.dora.impl.core.settingsconfig.c.a.getClass();
            DoraXLinkTransportMode r5 = com.larus.dora.impl.core.settingsconfig.c.d(r3, r4, r13);
            g49.d.d(LabSettingsViewModel.TAG, "forceUpdateEnable RTC transport: bluetooth=" + r3 + ", p2p=" + r4 + ", hasPermissions=" + r2.a + ", hasAbility=" + r2.b + ", runtimeSupported=" + r13 + ", effectiveMode=" + r5);
            if (LabSettingsViewModel.access$isSupportBehaviorAware(this.this$0) == false) goto L12;
            boolean r15 = LabSettingsViewModel.access$takeBehaviorAwareToggle(this.this$0);
        L13:
            z0 r6 = LabSettingsViewModel.access$get_envStateFlow$p(this.this$0);
            Object r7 = LabSettingsViewModel.access$get_envStateFlow$p(this.this$0).getValue();
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type com.larus.dora.impl.device.settings.lab.LabEnvSettings.Success");
            c.b r8 = (c.b) r7;
            IDoraPageConfig r9 = LabSettingsViewModel.access$getDoraPageConfig(this.this$0);
            if (r9 == null) goto L16;
            boolean r10 = r9.d("dora_g_config_key_env_observe_enable", false);
        L17:
            IDoraPageConfig r11 = LabSettingsViewModel.access$getDoraPageConfig(this.this$0);
            if (r11 == null) goto L20;
            boolean r12 = r11.d("dora_g_config_key_env_observe_auth_enable", false);
        L21:
            boolean r16 = b0.w();
            boolean r17 = b0.j().getBoolean("dora_natural_interaction_bgm_enabled", false);
            if (r5 == DoraXLinkTransportMode.OFF) goto L24;
            boolean r18 = true;
        L26:
            if (r5 != DoraXLinkTransportMode.WIFI) goto L28;
            boolean r111 = true;
        L29:
            r6.setValue(c.b.a(r8, r10, false, r12, r16, r17, false, false, r18, r111, r13, r14, r15, false, 3559221));
            goto L31
        L28:
            r111 = false;
            goto L29
        L24:
            r18 = false;
            goto L26
        L20:
            r12 = false;
            goto L21
        L16:
            r10 = false;
            goto L17
        L12:
            r15 = false;
        L31:
            return Unit.INSTANCE;
        L33:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$initData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$initData$1", f = "LabSettingsViewModel.kt", i = {0, 0, 0, 0}, l = {104, 131}, m = "invokeSuspend", n = {"isSupEnvObser", "envAuthEnable", "envEnable", "envState"}, s = {"Z$0", "I$0", "I$1", "I$2"})
    public static final class C02631 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        int I$2;
        boolean Z$0;
        int label;
        final /* synthetic */ LabSettingsViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$initData$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$initData$1$1", f = "LabSettingsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00451 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ boolean $allowDoubaoViewImagesEnable;
            final /* synthetic */ boolean $behaviorAwareEnable;
            final /* synthetic */ boolean $envAuthEnable;
            final /* synthetic */ boolean $envEnable;
            final /* synthetic */ boolean $envState;
            final /* synthetic */ boolean $isSupEnvObser;
            final /* synthetic */ boolean $isSupportBehaviorAware;
            final /* synthetic */ boolean $isSupportBluetoothRTC;
            final /* synthetic */ boolean $isSupportHeadGestureControl;
            final /* synthetic */ boolean $isSupportQuickContinuousConversation;
            final /* synthetic */ boolean $isSupportRecordMinutes;
            final /* synthetic */ boolean $isSupportRtosPlayer;
            final /* synthetic */ boolean $isSupportSimulInterpret;
            final /* synthetic */ boolean $naturalInteractionBgmEnable;
            final /* synthetic */ boolean $quickContinuousConversationEnable;
            final /* synthetic */ boolean $rtosPlayerEnable;
            final /* synthetic */ String $uid;
            int label;
            final /* synthetic */ LabSettingsViewModel this$0;

            public C00451(String r4, LabSettingsViewModel r5, boolean r6, boolean r7, boolean r8, boolean r9, boolean r10, boolean r11, boolean r12, boolean r13, boolean r14, boolean r15, boolean r16, boolean r17, boolean r18, boolean r110, boolean r20, boolean r21, Continuation<? super C00451> r22) {
                this.$uid = r4;
                this.this$0 = r5;
                this.$isSupEnvObser = r6;
                this.$envEnable = r7;
                this.$envState = r8;
                this.$envAuthEnable = r9;
                this.$isSupportSimulInterpret = r10;
                this.$isSupportQuickContinuousConversation = r11;
                this.$quickContinuousConversationEnable = r12;
                this.$naturalInteractionBgmEnable = r13;
                this.$isSupportRecordMinutes = r14;
                this.$allowDoubaoViewImagesEnable = r15;
                this.$rtosPlayerEnable = r16;
                this.$isSupportRtosPlayer = r17;
                this.$isSupportBluetoothRTC = r18;
                this.$isSupportHeadGestureControl = r110;
                this.$isSupportBehaviorAware = r20;
                this.$behaviorAwareEnable = r21;
                super(2, r22);
            }

            public final Continuation<Unit> create(Object r23, Continuation<?> r24) {
                return new C00451(this.$uid, this.this$0, this.$isSupEnvObser, this.$envEnable, this.$envState, this.$envAuthEnable, this.$isSupportSimulInterpret, this.$isSupportQuickContinuousConversation, this.$quickContinuousConversationEnable, this.$naturalInteractionBgmEnable, this.$isSupportRecordMinutes, this.$allowDoubaoViewImagesEnable, this.$rtosPlayerEnable, this.$isSupportRtosPlayer, this.$isSupportBluetoothRTC, this.$isSupportHeadGestureControl, this.$isSupportBehaviorAware, this.$behaviorAwareEnable, r24);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r27) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L19;
                ResultKt.throwOnFailure(r27);
                b0 r1 = b0.a;
                String r2 = this.$uid;
                r1.getClass();
                boolean r3 = b0.p(r2);
                DoraWifiLinkWrapper.a.getClass();
                DoraWifiLinkWrapper.a r4 = DoraWifiLinkWrapper.n();
                boolean r15 = r4.a();
                boolean r14 = r4.b;
                boolean r5 = b0.u(this.$uid);
                if (r15 == true) goto L8;
                if (r5 == false) goto L8;
                g49.d.e(LabSettingsViewModel.TAG, "initData: P2P RTC effective mode disabled because runtime is not supported, hasPermissions=" + r4.a + ", hasAbility=" + r4.b);
            L8:
                com.larus.dora.impl.core.settingsconfig.c.a.getClass();
                DoraXLinkTransportMode r6 = com.larus.dora.impl.core.settingsconfig.c.d(r3, r5, r15);
                g49.d.d(LabSettingsViewModel.TAG, "initData RTC transport: bluetooth=" + r3 + ", p2p=" + r5 + ", hasPermissions=" + r4.a + ", hasAbility=" + r4.b + ", runtimeSupported=" + r15 + ", effectiveMode=" + r6);
                z0 r7 = LabSettingsViewModel.access$get_envStateFlow$p(this.this$0);
                if (r6 == DoraXLinkTransportMode.OFF) goto L11;
                boolean r16 = true;
            L13:
                if (r6 != DoraXLinkTransportMode.WIFI) goto L15;
                boolean r17 = true;
            L16:
                r7.setValue(new c.b(this.$isSupEnvObser, this.$envEnable, this.$envState, this.$envAuthEnable, this.$isSupportSimulInterpret, this.$isSupportQuickContinuousConversation, this.$quickContinuousConversationEnable, this.$naturalInteractionBgmEnable, this.$isSupportRecordMinutes, this.$allowDoubaoViewImagesEnable, this.$rtosPlayerEnable, this.$isSupportRtosPlayer, r16, r17, this.$isSupportBluetoothRTC, r15, r14, this.$isSupportHeadGestureControl, this.$isSupportBehaviorAware, this.$behaviorAwareEnable, DoraWifiLinkWrapper.i(), DoraWifiLinkWrapper.h()));
                return Unit.INSTANCE;
            L15:
                r17 = false;
                goto L16
            L11:
                r16 = false;
                goto L13
            L19:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$initData$1$a */
        public static final class a implements f49.b {
            public final /* synthetic */ LabSettingsViewModel a;

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

            public a(LabSettingsViewModel r1) {
                this.a = r1;
            }

            @Override // f49.b
            public final void l(int r3, int r4, int r5) {
                g49.d.d(LabSettingsViewModel.TAG, "onVoiceWakeup state = " + r3 + ", wakeMode = " + r4 + ", query = " + r5);
                if (r4 != 11) goto L6;
                this.a.onVoiceWakeUpState();
                return;
            }
        }

        public C02631(LabSettingsViewModel r1, Continuation<? super C02631> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02631(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v10 */
        /* JADX WARN: Type inference failed for: r6v12 */
        /* JADX WARN: Type inference failed for: r6v13 */
        /* JADX WARN: Type inference failed for: r6v5 */
        /* JADX WARN: Type inference failed for: r6v6, types: [int] */
        /* JADX WARN: Type inference failed for: r6v8 */
        /* JADX WARN: Type inference failed for: r7v1 */
        /* JADX WARN: Type inference failed for: r7v2, types: [int] */
        /* JADX WARN: Type inference failed for: r7v3 */
        /* JADX WARN: Type inference failed for: r7v4 */
        /* JADX WARN: Type inference failed for: r7v6 */
        /* JADX WARN: Type inference failed for: r7v7 */
        public final Object invokeSuspend(Object r31) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L11;
            if (r2 == 1) goto L9;
            if (r2 != 2) goto L8;
            ResultKt.throwOnFailure(r31);
        L60:
            LabSettingsViewModel r3 = this.this$0;
            a r4 = new a(r3);
            IDoraService r5 = LabSettingsViewModel.access$getDoraServiceImpl(r3);
            if (r5 == null) goto L65;
            SessionService r6 = r5.d();
            if (r6 == null) goto L65;
            r6.i(r4);
        L65:
            LabSettingsViewModel.access$setDoraVoiceCallback$p(r3, r4);
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            int r7 = this.I$2;
            int r8 = this.I$1;
            int r9 = this.I$0;
            boolean r10 = this.Z$0;
            ResultKt.throwOnFailure(r31);
            Object r11 = r31;
            ?? r12 = r8;
            ?? r13 = r9;
        L10:
            boolean r14 = r10;
            boolean r18 = ((Boolean) r11).booleanValue();
            b0.a.getClass();
            boolean r110 = b0.w();
            boolean r20 = b0.j().getBoolean("dora_natural_interaction_bgm_enabled", false);
            IDoraService r15 = LabSettingsViewModel.access$getDoraServiceImpl(this.this$0);
            if (r15 == null) goto L35;
            DeviceService r16 = r15.device();
            if (r16 == null) goto L35;
            if (r16.j0() != true) goto L35;
            boolean r17 = true;
        L36:
            sk4.e r21 = o0.a;
            boolean r22 = o0.c("meeting_minutes");
            boolean r26 = o0.c("headGestureControl");
            boolean r27 = o0.c(FlowProtocolAbility.FEATURE_BEHAVIOR_AWARE);
            if (b0.j().getInt("dora_g_button_mode", 1) == 1) goto L39;
            boolean r23 = true;
        L40:
            boolean r24 = kj4.a.g().getRtosPlayerSwitchState();
            boolean r25 = DoraAdapterExtKt.w(kj4.a.g());
            boolean r28 = o0.c(FlowProtocolAbility.FEATURE_BLUETOOTH_RTC);
            String r30 = ILoginService.a.getAccountInfo().c;
            if (r30 != null) goto L43;
            r30 = "";
        L43:
            String r111 = r30;
            if (r27 == false) goto L46;
            boolean r210 = LabSettingsViewModel.access$takeBehaviorAwareToggle(this.this$0);
        L47:
            MainCoroutineDispatcher r32 = Dispatchers.getMain();
            LabSettingsViewModel r112 = this.this$0;
            if (r12 == 0) goto L50;
            boolean r113 = true;
        L51:
            if (r7 == 0) goto L53;
            boolean r114 = true;
        L54:
            if (r13 == 0) goto L56;
            boolean r115 = true;
        L57:
            C00451 r33 = new C00451(r111, r112, r14, r113, r114, r115, r17, r18, r110, r20, r22, r23, r24, r25, r28, r26, r27, r210, null);
            this.label = 2;
            if (BuildersKt.withContext(r32, r33, this) != r1) goto L60;
            return r1;
        L56:
            r115 = false;
            goto L57
        L53:
            r114 = false;
            goto L54
        L50:
            r113 = false;
            goto L51
        L46:
            r210 = false;
            goto L47
        L39:
            r23 = false;
        L35:
            r17 = false;
            goto L36
        L11:
            ResultKt.throwOnFailure(r31);
            boolean r34 = Intrinsics.areEqual(AppHost.a.getBuildChannel(), "dora_g_ut");
            sk4.e r35 = o0.a;
            r10 = o0.c("env_obser");
            g49.d.d(LabSettingsViewModel.TAG, "isUT: " + r34 + ", isSup: " + r10);
            IDoraPageConfig r36 = LabSettingsViewModel.access$getDoraPageConfig(this.this$0);
            if (r36 == null) goto L14;
            ?? r37 = r36.d("dora_g_config_key_env_observe_auth_enable", false);
        L15:
            IDoraPageConfig r38 = LabSettingsViewModel.access$getDoraPageConfig(this.this$0);
            if (r38 == null) goto L18;
            ?? r40 = r38.d("dora_g_config_key_env_observe_enable", false);
        L20:
            if (LabSettingsViewModel.access$curEnvObserveState(this.this$0) == true) goto L22;
        L24:
            r7 = 0;
        L25:
            this.Z$0 = r10;
            this.I$0 = r37;
            this.I$1 = r40;
            this.I$2 = r7;
            this.label = 1;
            boolean r41 = o0.c("lightEffectControl");
            g49.d.d("DoraProtocol", "isSupportQuickContinuousConversation: " + r41);
            r11 = Boxing.boxBoolean(r41);
            r12 = r40;
            r13 = r37;
            if (r11 != r1) goto L10;
            return r1;
        L22:
            if (DoraAdapterExtKt.t(kj4.a.g()) == false) goto L24;
            r7 = 1;
            goto L25
        L18:
            r40 = 0;
            goto L20
        L14:
            r37 = 0;
            goto L15
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$onVoiceWakeUpState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$onVoiceWakeUpState$1", f = "LabSettingsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02641 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ LabSettingsViewModel this$0;

        public C02641(LabSettingsViewModel r1, Continuation<? super C02641> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02641(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r20) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r20);
            if ((LabSettingsViewModel.access$get_envStateFlow$p(this.this$0).getValue() instanceof c.b) == false) goto L8;
            z0 r1 = LabSettingsViewModel.access$get_envStateFlow$p(this.this$0);
            Object r2 = LabSettingsViewModel.access$get_envStateFlow$p(this.this$0).getValue();
            Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.larus.dora.impl.device.settings.lab.LabEnvSettings.Success");
            r1.setValue(c.b.a((c.b) r2, false, LabSettingsViewModel.access$curEnvObserveState(this.this$0), false, false, false, false, false, false, false, false, false, false, false, 4194299));
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$setAllowDoubaoViewImagesEnable$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$setAllowDoubaoViewImagesEnable$1", f = "LabSettingsViewModel.kt", i = {}, l = {651}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02651 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isEnabled;
        int label;
        final /* synthetic */ LabSettingsViewModel this$0;

        public C02651(boolean r1, LabSettingsViewModel r2, Continuation<? super C02651> r3) {
            this.$isEnabled = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02651(this.$isEnabled, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r210) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            ResultKt.throwOnFailure(r210);
        L22:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r210);
            if (this.$isEnabled == true) goto L11;
            int r3 = 1;
        L12:
            int r5 = yj4.g.a;
            yj4.f r6 = yj4.f.a.a;
            r6.getClass();
            int r4 = yj4.h.C2.j(1, 4, new byte[]{22, 1, (byte) r3}, 5000);
            pk4.m.a(new yj4.c(r6));
            g49.d.d(LabSettingsViewModel.TAG, "setAllowDoubaoViewImagesEnable: " + this.$isEnabled + ", ret = " + r4);
            if (r4 == 0) goto L15;
            MutableSharedFlow r7 = LabSettingsViewModel.access$get_envActionSharedFlow$p(this.this$0);
            com.larus.dora.impl.device.settings.lab.b.a r8 = new com.larus.dora.impl.device.settings.lab.b.a();
            this.label = 1;
            if (r7.emit(r8, this) != r1) goto L22;
            return r1;
        L15:
            if ((LabSettingsViewModel.access$get_envStateFlow$p(this.this$0).getValue() instanceof c.b) == false) goto L17;
            b0.a.getClass();
            b0.j().storeInt("dora_g_button_mode", r3);
            z0 r9 = LabSettingsViewModel.access$get_envStateFlow$p(this.this$0);
            Object r10 = LabSettingsViewModel.access$get_envStateFlow$p(this.this$0).getValue();
            Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.larus.dora.impl.device.settings.lab.LabEnvSettings.Success");
            r9.setValue(c.b.a((c.b) r10, false, false, false, false, false, this.$isEnabled, false, false, false, false, false, false, false, 4193791));
        L17:
            DoraBuryPointManager.J(DoraBuryPointManager.a, "dora_photo_permission_settings_change", MapsKt.mapOf(TuplesKt.to("dora_g_photo_permission_switch", x0.b(this.$isEnabled))), false, 12);
            goto L22
        L11:
            r3 = 2;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$setBehaviorAwareEnable$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$setBehaviorAwareEnable$1", f = "LabSettingsViewModel.kt", i = {}, l = {550}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02661 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isEnabled;
        int label;
        final /* synthetic */ LabSettingsViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$setBehaviorAwareEnable$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$setBehaviorAwareEnable$1$1", f = "LabSettingsViewModel.kt", i = {0, 0}, l = {562, 573}, m = "invokeSuspend", n = {"ret", "retryIndex"}, s = {"I$0", "I$1"})
        public static final class C00461 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ boolean $isEnabled;
            int I$0;
            int I$1;
            int label;
            final /* synthetic */ LabSettingsViewModel this$0;

            public C00461(LabSettingsViewModel r1, boolean r2, Continuation<? super C00461> r3) {
                this.this$0 = r1;
                this.$isEnabled = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new C00461(this.this$0, this.$isEnabled, r4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0058 -> B:27:0x0069). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0066 -> B:27:0x0069). Please report as a decompilation issue!!! */
            public final Object invokeSuspend(Object r24) {
                Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r2 = this.label;
                if (r2 == 0) goto L10;
                if (r2 == 1) goto L9;
                if (r2 != 2) goto L8;
                ResultKt.throwOnFailure(r24);
            L37:
                return Unit.INSTANCE;
            L8:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L9:
                int r3 = this.I$1;
                int r7 = this.I$0;
                ResultKt.throwOnFailure(r24);
                int r8 = r7;
                C00461 r9 = this;
            L27:
                r3 = r3 + 1;
            L16:
                if (r3 >= 3) goto L28;
                zj4.a r10 = zj4.a.a.a;
                if (r10 == null) goto L20;
                r8 = r10.a(LabSettingsViewModel.access$toToggleValue(r9.this$0, r9.$isEnabled));
            L21:
                if (r8 == 0) goto L28;
                if (r3 >= 2) goto L27;
                r9.I$0 = r8;
                r9.I$1 = r3;
                r9.label = 1;
                if (DelayKt.delay(LabSettingsViewModel.SYNC_RETRY_DELAY_MS, r9) != r1) goto L27;
                return r1;
            L20:
                r8 = -1;
            L28:
                g49.d.d(LabSettingsViewModel.TAG, "setBehaviorAwareEnable: isEnabled=" + r9.$isEnabled + ", ret=" + r8);
                if (r8 == 0) goto L31;
                MutableSharedFlow r4 = LabSettingsViewModel.access$get_envActionSharedFlow$p(r9.this$0);
                com.larus.dora.impl.device.settings.lab.b.C0048b r5 = new com.larus.dora.impl.device.settings.lab.b.C0048b();
                r9.label = 2;
                if (r4.emit(r5, r9) != r1) goto L37;
                return r1;
            L31:
                if ((LabSettingsViewModel.access$get_envStateFlow$p(r9.this$0).getValue() instanceof c.b) == false) goto L37;
                z0 r6 = LabSettingsViewModel.access$get_envStateFlow$p(r9.this$0);
                Object r11 = LabSettingsViewModel.access$get_envStateFlow$p(r9.this$0).getValue();
                Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type com.larus.dora.impl.device.settings.lab.LabEnvSettings.Success");
                r6.setValue(c.b.a((c.b) r11, false, false, false, false, false, false, false, false, false, false, false, r9.$isEnabled, false, 3670015));
                goto L37
            L10:
                ResultKt.throwOnFailure(r24);
                if (LabSettingsViewModel.access$isSupportBehaviorAware(this.this$0) == true) goto L14;
                g49.d.e(LabSettingsViewModel.TAG, "setBehaviorAwareEnable skipped because ability is not supported");
                return Unit.INSTANCE;
            L14:
                r3 = 0;
                r9 = this;
                r8 = -1;
                goto L16
            }
        }

        public C02661(LabSettingsViewModel r1, boolean r2, Continuation<? super C02661> r3) {
            this.this$0 = r1;
            this.$isEnabled = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02661(this.this$0, this.$isEnabled, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            CoroutineDispatcher r8 = Dispatchers.getIO();
            C00461 r2 = new C00461(this.this$0, this.$isEnabled, null);
            this.label = 1;
            if (BuildersKt.withContext(r8, r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$setDataSavingEnable$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$setDataSavingEnable$1", f = "LabSettingsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02671 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C02671(Continuation<? super C02671> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new C02671(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            DoraP2pRtcSwitchSync.d();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$setNaturalInteractionBgmEnable$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$setNaturalInteractionBgmEnable$1", f = "LabSettingsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02681 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isEnabled;
        int label;
        final /* synthetic */ LabSettingsViewModel this$0;

        public C02681(LabSettingsViewModel r1, boolean r2, Continuation<? super C02681> r3) {
            this.this$0 = r1;
            this.$isEnabled = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02681(this.this$0, this.$isEnabled, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r20) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L14;
            ResultKt.throwOnFailure(r20);
            if (LabSettingsViewModel.access$isNaturalWakeupSettingBlocked(this.this$0) == false) goto L8;
            g49.d.e(LabSettingsViewModel.TAG, "setNaturalInteractionBgmEnable: in wakeup, can not operate");
            return Unit.INSTANCE;
        L8:
            b0 r1 = b0.a;
            boolean r2 = this.$isEnabled;
            r1.getClass();
            b0.j().storeBoolean("dora_natural_interaction_bgm_enabled", r2);
            boolean r3 = b0.w();
            if ((LabSettingsViewModel.access$get_envStateFlow$p(this.this$0).getValue() instanceof c.b) == false) goto L11;
            Object r4 = LabSettingsViewModel.access$get_envStateFlow$p(this.this$0).getValue();
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.larus.dora.impl.device.settings.lab.LabEnvSettings.Success");
            c.b r5 = (c.b) r4;
            LabSettingsViewModel.access$get_envStateFlow$p(this.this$0).setValue(c.b.a(r5, false, false, false, false, this.$isEnabled, false, false, false, false, false, false, false, false, 4194175));
        L11:
            DoraBuryPointManager.J(DoraBuryPointManager.a, "dora_natural_wakeup_settings_change", MapsKt.plus(x0.a(r3), MapsKt.mapOf(TuplesKt.to("dora_g_natural_setting_bgm_switch", x0.b(this.$isEnabled)))), false, 12);
            return Unit.INSTANCE;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$setQuickContinuousConversationEnable$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$setQuickContinuousConversationEnable$1", f = "LabSettingsViewModel.kt", i = {}, l = {297, 317}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02691 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isEnabled;
        int label;
        final /* synthetic */ LabSettingsViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$setQuickContinuousConversationEnable$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$setQuickContinuousConversationEnable$1$1", f = "LabSettingsViewModel.kt", i = {0}, l = {324, 342}, m = "invokeSuspend", n = {"ret"}, s = {"L$0"})
        public static final class C00471 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ boolean $isEnabled;
            int I$0;
            int I$1;
            Object L$0;
            boolean Z$0;
            int label;
            final /* synthetic */ LabSettingsViewModel this$0;

            public C00471(boolean r1, LabSettingsViewModel r2, Continuation<? super C00471> r3) {
                this.$isEnabled = r1;
                this.this$0 = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new C00471(this.$isEnabled, this.this$0, r4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0047 -> B:18:0x005d). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x005a -> B:18:0x005d). Please report as a decompilation issue!!! */
            public final Object invokeSuspend(Object r26) {
                Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r2 = this.label;
                if (r2 == 0) goto L10;
                if (r2 == 1) goto L9;
                if (r2 != 2) goto L8;
                ResultKt.throwOnFailure(r26);
            L29:
                return Unit.INSTANCE;
            L8:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L9:
                int r3 = this.I$1;
                boolean r6 = this.Z$0;
                int r7 = this.I$0;
                Ref.IntRef r8 = (Ref.IntRef) this.L$0;
                ResultKt.throwOnFailure(r26);
                C00471 r9 = this;
            L18:
                r3 = r3 + 1;
            L11:
                if (r3 >= r7) goto L19;
                int r10 = kj4.a.g().v(r6);
                r8.element = r10;
                if (r10 == 0) goto L18;
                r9.L$0 = r8;
                r9.I$0 = r7;
                r9.Z$0 = r6;
                r9.I$1 = r3;
                r9.label = 1;
                if (DelayKt.delay(LabSettingsViewModel.SYNC_RETRY_DELAY_MS, r9) != r1) goto L18;
                return r1;
            L19:
                g49.d.d(LabSettingsViewModel.TAG, "setQuickContinuousConversationEnable: " + r9.$isEnabled + ", ret = " + r8.element);
                if (r8.element != 0) goto L25;
                b0 r4 = b0.a;
                boolean r5 = r9.$isEnabled;
                r4.getClass();
                b0.M(r5);
                boolean r11 = b0.j().getBoolean("dora_natural_interaction_bgm_enabled", false);
                if ((LabSettingsViewModel.access$get_envStateFlow$p(r9.this$0).getValue() instanceof c.b) == false) goto L24;
                z0 r12 = LabSettingsViewModel.access$get_envStateFlow$p(r9.this$0);
                Object r13 = LabSettingsViewModel.access$get_envStateFlow$p(r9.this$0).getValue();
                Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.larus.dora.impl.device.settings.lab.LabEnvSettings.Success");
                r12.setValue(c.b.a((c.b) r13, false, false, false, r9.$isEnabled, false, false, false, false, false, false, false, false, false, 4194239));
            L24:
                DoraBuryPointManager.J(DoraBuryPointManager.a, "dora_natural_wakeup_settings_change", MapsKt.plus(x0.a(r9.$isEnabled), MapsKt.mapOf(TuplesKt.to("dora_g_natural_setting_bgm_switch", x0.b(r11)))), false, 12);
                goto L29
            L25:
                MutableSharedFlow r14 = LabSettingsViewModel.access$get_envActionSharedFlow$p(r9.this$0);
                com.larus.dora.impl.device.settings.lab.b.c r15 = new com.larus.dora.impl.device.settings.lab.b.c(2131904037);
                r9.L$0 = null;
                r9.label = 2;
                if (r14.emit(r15, r9) != r1) goto L29;
                return r1;
            L10:
                ResultKt.throwOnFailure(r26);
                Ref.IntRef r16 = new Ref.IntRef();
                r6 = this.$isEnabled;
                r7 = 3;
                r9 = this;
                r8 = r16;
                r3 = 0;
                goto L11
            }
        }

        public C02691(LabSettingsViewModel r1, boolean r2, Continuation<? super C02691> r3) {
            this.this$0 = r1;
            this.$isEnabled = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02691(this.this$0, this.$isEnabled, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r7);
        L21:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r7);
        L16:
            return Unit.INSTANCE;
        L10:
            ResultKt.throwOnFailure(r7);
            if (LabSettingsViewModel.access$isNaturalWakeupSettingBlocked(this.this$0) == false) goto L17;
            g49.d.e(LabSettingsViewModel.TAG, "setQuickContinuousConversationEnable: in wakeup, can not operate");
            MutableSharedFlow r8 = LabSettingsViewModel.access$get_envActionSharedFlow$p(this.this$0);
            com.larus.dora.impl.device.settings.lab.b.c r2 = new com.larus.dora.impl.device.settings.lab.b.c(2131904025);
            this.label = 1;
            if (r8.emit(r2, this) != r0) goto L16;
            return r0;
        L17:
            CoroutineDispatcher r9 = Dispatchers.getIO();
            C00471 r3 = new C00471(this.$isEnabled, this.this$0, null);
            this.label = 2;
            if (BuildersKt.withContext(r9, r3, this) != r0) goto L21;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$setRTCTransportMode$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$setRTCTransportMode$1", f = "LabSettingsViewModel.kt", i = {0, 1, 2}, l = {812, 355, 356}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0", "L$0"})
    public static final class C02701 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ RTCTransportMode $mode;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ LabSettingsViewModel this$0;

        public C02701(LabSettingsViewModel r1, RTCTransportMode r2, Continuation<? super C02701> r3) {
            this.this$0 = r1;
            this.$mode = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02701(this.this$0, this.$mode, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5, types: [kotlinx.coroutines.sync.a] */
        /* JADX WARN: Type inference failed for: r0v9 */
        /* JADX WARN: Type inference failed for: r4v1 */
        /* JADX WARN: Type inference failed for: r4v11, types: [kotlinx.coroutines.sync.a] */
        /* JADX WARN: Type inference failed for: r4v2, types: [kotlinx.coroutines.sync.a] */
        /* JADX WARN: Type inference failed for: r4v6 */
        /* JADX WARN: Type inference failed for: r9v14 */
        /* JADX WARN: Type inference failed for: r9v17 */
        /* JADX WARN: Type inference failed for: r9v7, types: [java.lang.Object] */
        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L20;
            if (r1 == 1) goto L19;
            if (r1 == 2) goto L14;
            if (r1 != 3) goto L13;
            kotlinx.coroutines.sync.a r2 = (kotlinx.coroutines.sync.a) this.L$0;
            ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L10
            ?? r3 = r2;
        L35:
            DoraP2pRtcSwitchSync.b();     // Catch: Throwable -> L38
            Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L38
            r3.unlock(null);
            return Unit.INSTANCE;
        L10:
            Throwable th = th;
        L42:
            DoraP2pRtcSwitchSync.b();     // Catch: Throwable -> L38
            throw th;     // Catch: Throwable -> L38
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            LabSettingsViewModel r4 = (LabSettingsViewModel) this.L$2;
            RTCTransportMode r5 = (RTCTransportMode) this.L$1;
            ?? r6 = (kotlinx.coroutines.sync.a) this.L$0;
            ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L17
            ?? r11 = r6;
        L55:
            CoroutineDispatcher r7 = Dispatchers.getIO();     // Catch: Throwable -> L40
            LabSettingsViewModel$setRTCTransportMode$1$1$1 r8 = new LabSettingsViewModel$setRTCTransportMode$1$1$1(r5, r4, null);     // Catch: Throwable -> L40
            this.L$0 = r11;     // Catch: Throwable -> L40
            this.L$1 = null;     // Catch: Throwable -> L40
            this.L$2 = null;     // Catch: Throwable -> L40
            this.label = 3;     // Catch: Throwable -> L40
            if (BuildersKt.withContext(r7, r8, this) != r0) goto L34;
            return r0;
        L34:
            r3 = r11;
        L40:
            th = move-exception;
            th = th;
        L17:
            th = th;
        L46:
            r6.unlock(null);
            throw th;
        L19:
            r4 = (LabSettingsViewModel) this.L$2;
            RTCTransportMode r12 = (RTCTransportMode) this.L$1;
            kotlinx.coroutines.sync.a r13 = (kotlinx.coroutines.sync.a) this.L$0;
            ResultKt.throwOnFailure(r9);
            kotlinx.coroutines.sync.a r14 = r13;
        L48:
            CoroutineScope r15 = DoraP2pRtcSwitchSync.a;     // Catch: Throwable -> L44
            this.L$0 = r14;     // Catch: Throwable -> L44
            this.L$1 = r12;     // Catch: Throwable -> L44
            this.L$2 = r4;     // Catch: Throwable -> L44
            this.label = 2;     // Catch: Throwable -> L44
            Object r16 = DoraP2pRtcSwitchSync.c.a(null, this);     // Catch: Throwable -> L44
            if (r16 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L28;
            r16 = Unit.INSTANCE;     // Catch: Throwable -> L44
        L28:
            if (r16 != r0) goto L30;
            return r0;
        L30:
            r5 = r12;
            r11 = r14;
        L44:
            th = move-exception;
            r6 = r14;
            th = th;
            goto L46
        L20:
            ResultKt.throwOnFailure(r9);
            kotlinx.coroutines.sync.a r17 = LabSettingsViewModel.access$getRtcTransportModeMutex$p(this.this$0);
            RTCTransportMode r18 = this.$mode;
            LabSettingsViewModel r20 = this.this$0;
            this.L$0 = r17;
            this.L$1 = r18;
            this.L$2 = r20;
            this.label = 1;
            if (r17.a(null, this) != r0) goto L23;
            return r0;
        L23:
            r12 = r18;
            r4 = r20;
            r14 = r17;
        L38:
            th = th;
            r6 = r0;
            goto L46
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$setRtosPlayerEnabled$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$setRtosPlayerEnabled$1", f = "LabSettingsViewModel.kt", i = {}, l = {662}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02711 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isEnabled;
        int label;
        final /* synthetic */ LabSettingsViewModel this$0;

        public C02711(boolean r1, LabSettingsViewModel r2, Continuation<? super C02711> r3) {
            this.$isEnabled = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C02711(this.$isEnabled, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r21) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            ResultKt.throwOnFailure(r21);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r21);
            kj4.a.g().setRtosPlayerSwitchState(this.$isEnabled);
            Object r3 = LabSettingsViewModel.access$get_envStateFlow$p(this.this$0).getValue();
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.larus.dora.impl.device.settings.lab.LabEnvSettings.Success");
            c.b r5 = (c.b) r3;
            z0 r4 = LabSettingsViewModel.access$get_envStateFlow$p(this.this$0);
            c.b r6 = c.b.a(r5, false, false, false, false, false, false, this.$isEnabled, false, false, false, false, false, false, 4193279);
            this.label = 1;
            if (r4.emit(r6, this) != r1) goto L12;
            return r1;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$syncBluetoothRTCVideoCallSwitch$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.LabSettingsViewModel", f = "LabSettingsViewModel.kt", i = {0, 0}, l = {521}, m = "syncBluetoothRTCVideoCallSwitch", n = {"ret", "isEnabled"}, s = {"L$0", "Z$0"})
    public static final class C02721 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ LabSettingsViewModel this$0;

        public C02721(LabSettingsViewModel r1, Continuation<? super C02721> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return LabSettingsViewModel.access$syncBluetoothRTCVideoCallSwitch(this.this$0, false, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$syncEffectiveP2PRTCVideoCallSwitch$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.LabSettingsViewModel", f = "LabSettingsViewModel.kt", i = {0, 0}, l = {538}, m = "syncEffectiveP2PRTCVideoCallSwitch", n = {"ret", "isEnabled"}, s = {"L$0", "Z$0"})
    public static final class C02731 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ LabSettingsViewModel this$0;

        public C02731(LabSettingsViewModel r1, Continuation<? super C02731> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return LabSettingsViewModel.access$syncEffectiveP2PRTCVideoCallSwitch(this.this$0, false, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$updateCacheAndUIState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$updateCacheAndUIState$1", f = "LabSettingsViewModel.kt", i = {}, l = {683}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02741 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ LabSettingsViewModel this$0;

        public C02741(LabSettingsViewModel r1, Continuation<? super C02741> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02741(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r22) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            ResultKt.throwOnFailure(r22);
        L25:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r22);
            int r3 = yj4.g.a;
            yj4.f r4 = yj4.f.a.a;
            r4.a(5000);
            int r5 = r4.f;
            g49.d.d(LabSettingsViewModel.TAG, "updateCacheAndUIState, buttonMode:" + r5);
            if (r5 != (-1)) goto L13;
            g49.d.d(LabSettingsViewModel.TAG, "updateCacheAndUIState, invalid buttonMode, skip update cache and ui state");
            return Unit.INSTANCE;
        L13:
            if ((LabSettingsViewModel.access$get_envStateFlow$p(this.this$0).getValue() instanceof c.b) == false) goto L23;
            Object r6 = LabSettingsViewModel.access$get_envStateFlow$p(this.this$0).getValue();
            Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type com.larus.dora.impl.device.settings.lab.LabEnvSettings.Success");
            c.b r7 = (c.b) r6;
            if (r5 == 1) goto L17;
            boolean r12 = true;
        L19:
            if (r7.j == r12) goto L25;
            b0.a.getClass();
            b0.j().storeInt("dora_g_button_mode", r5);
            z0 r8 = LabSettingsViewModel.access$get_envStateFlow$p(this.this$0);
            c.b r9 = c.b.a(r7, false, false, false, false, false, r12, false, false, false, false, false, false, false, 4193791);
            this.label = 1;
            if (r8.emit(r9, this) != r1) goto L25;
            return r1;
        L17:
            r12 = false;
            goto L19
        L23:
            g49.d.d(LabSettingsViewModel.TAG, "updateCacheAndUIState, _envStateFlow is not success");
            goto L25
        }
    }

    static {
        Companion = new b();
    }

    public static /* synthetic */ IDoraPageConfig Mo() {
        return doraPageConfig_delegate$lambda$1();
    }

    private final boolean isRTCSwitchSyncAccepted(int r2) {
        if (r2 != 0) goto L4;
    L7:
        return true;
    L4:
        if (r2 == (-3)) goto L7;
        return false;
    }

    private final int toToggleValue(boolean r1) {
        return r1 ? 1 : 0;
    }

    public static /* synthetic */ IDoraService yo() {
        return doraServiceImpl_delegate$lambda$0();
    }

    private static final IDoraPageConfig doraPageConfig_delegate$lambda$1() {
        return (IDoraPageConfig) ServiceManager.get().getService(IDoraPageConfig.class);
    }

    private static final IDoraService doraServiceImpl_delegate$lambda$0() {
        return (IDoraService) ServiceManager.get().getService(IDoraService.class);
    }

    private final IDoraPageConfig getDoraPageConfig() {
        return (IDoraPageConfig) this.doraPageConfig$delegate.getValue();
    }

    private final IDoraService getDoraServiceImpl() {
        return (IDoraService) this.doraServiceImpl$delegate.getValue();
    }

    private final boolean isNaturalWakeupSettingBlocked() {
        Object r0 = ServiceManager.get().getService(IDoraService.class);
        if ((r0 instanceof DoraServiceImpl) == false) goto L5;
        DoraServiceImpl r1 = (DoraServiceImpl) r0;
    L7:
        if (r1 != null) goto L9;
    L11:
        boolean r3 = false;
    L12:
        if (r3 == true) goto L14;
        return false;
    L14:
        SessionService r2 = r1.c;
        if (r2.c == 11) goto L17;
        return true;
    L17:
        if (r2.d == 7) goto L22;
        return false;
    L22:
        return true;
    L9:
        if (r1.A1() != true) goto L11;
        r3 = true;
        goto L12
    L5:
        r1 = null;
        goto L7
    }

    private final boolean isSupportBehaviorAware() {
        sk4.e r0 = o0.a;
        return o0.c(FlowProtocolAbility.FEATURE_BEHAVIOR_AWARE);
    }

    private final boolean takeBehaviorAwareToggle() {
        zj4.a r0 = zj4.a.a.a;
        if (r0 == null) goto L5;
        Integer r1 = Integer.valueOf(r0.g());
    L6:
        if (r1 == null) goto L11;
        boolean r2 = true;
        if (r1.intValue() != 1) goto L11;
    L12:
        g49.d.d(TAG, "takeBehaviorAwareToggle: toggle=" + r1 + ", isEnabled=" + r2);
        return r2;
    L11:
        r2 = false;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public final d59.f getFeatureConfig() {
        return this.featureConfigRepository.a();
    }

    public final boolean isDataSavingEntranceVisible() {
        DoraWifiLinkWrapper.a.getClass();
        return DoraWifiLinkWrapper.i();
    }

    public LabSettingsViewModel() {
        StateFlowImpl r0 = j1.a(c.a.a);
        this._envStateFlow = r0;
        this.envStateFlow = r0;
        MutableSharedFlow<com.larus.dora.impl.device.settings.lab.b> r1 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._envActionSharedFlow = r1;
        this.envActionSharedFlow = r1;
        this.ENV_OB_UVI_SUCCESS = 2;
        this.ENV_OB_TX_TIMEOUT = -1;
        this.ENV_OB_UVI_FAILED_WITH_REASON = CollectionsKt.listOf(new Integer[]{-1, 9, 10, 12, 13, 14, 15});
        this.doraServiceImpl$delegate = LazyKt.lazy(new r());
        this.doraPageConfig$delegate = LazyKt.lazy(new s());
        this.featureConfigRepository = new g59.c();
        this.rtcTransportModeMutex = kotlinx.coroutines.sync.b.a();
        initData();
        kj4.a.g().registerDoraLinkCallback(new a(this));
        fetchData();
        updateCacheAndUIState();
    }

    private final boolean curEnvObserveState() {
        IDoraService r0 = getDoraServiceImpl();
        if (r0 == null) goto L20;
        SessionService r1 = r0.d();
        if (r1 == null) goto L20;
        if (r1.c == 11) goto L10;
        return false;
    L10:
        int r2 = r1.d;
        if (r2 != 2) goto L13;
        return true;
    L13:
        if (r2 != 7) goto L15;
        return true;
    L15:
        if (r2 == 8) goto L22;
        return false;
    L22:
        return true;
    L20:
        return false;
    }

    private final void fetchData() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(null), 2, null);
    }

    private final void initData() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02631(this, null), 2, null);
    }

    private final void updateCacheAndUIState() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02741(this, null), 2, null);
    }

    public final void forceUpdateEnable() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02621(this, null), 2, null);
    }

    public void onCleared() {
        super.onCleared();
        f49.b r0 = this.doraVoiceCallback;
        if (r0 == null) goto L10;
        IDoraService r1 = getDoraServiceImpl();
        if (r1 == null) goto L11;
        SessionService r2 = r1.d();
        if (r2 == null) goto L12;
        r2.x(r0);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void onVoiceWakeUpState() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02641(this, null), 2, null);
    }

    public final int getENV_OB_TX_TIMEOUT() {
        return this.ENV_OB_TX_TIMEOUT;
    }

    public final List<Integer> getENV_OB_UVI_FAILED_WITH_REASON() {
        return this.ENV_OB_UVI_FAILED_WITH_REASON;
    }

    public final int getENV_OB_UVI_SUCCESS() {
        return this.ENV_OB_UVI_SUCCESS;
    }

    public final d1<com.larus.dora.impl.device.settings.lab.b> getEnvActionSharedFlow() {
        return this.envActionSharedFlow;
    }

    public final i1<c> getEnvStateFlow() {
        return this.envStateFlow;
    }

    public static final /* synthetic */ boolean access$curEnvObserveState(LabSettingsViewModel r0) {
        return r0.curEnvObserveState();
    }

    public static final /* synthetic */ IDoraPageConfig access$getDoraPageConfig(LabSettingsViewModel r0) {
        return r0.getDoraPageConfig();
    }

    public static final /* synthetic */ IDoraService access$getDoraServiceImpl(LabSettingsViewModel r0) {
        return r0.getDoraServiceImpl();
    }

    public static final /* synthetic */ kotlinx.coroutines.sync.a access$getRtcTransportModeMutex$p(LabSettingsViewModel r0) {
        return r0.rtcTransportModeMutex;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_envActionSharedFlow$p(LabSettingsViewModel r0) {
        return r0._envActionSharedFlow;
    }

    public static final /* synthetic */ z0 access$get_envStateFlow$p(LabSettingsViewModel r0) {
        return r0._envStateFlow;
    }

    public static final /* synthetic */ void access$initData(LabSettingsViewModel r0) {
        r0.initData();
    }

    public static final /* synthetic */ boolean access$isNaturalWakeupSettingBlocked(LabSettingsViewModel r0) {
        return r0.isNaturalWakeupSettingBlocked();
    }

    public static final /* synthetic */ boolean access$isSupportBehaviorAware(LabSettingsViewModel r0) {
        return r0.isSupportBehaviorAware();
    }

    public static final /* synthetic */ boolean access$takeBehaviorAwareToggle(LabSettingsViewModel r0) {
        return r0.takeBehaviorAwareToggle();
    }

    public final void setAllowDoubaoViewImagesEnable(boolean r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02651(r7, this, null), 2, null);
    }

    public final void setBehaviorAwareEnable(boolean r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02661(this, r7, null), 3, null);
    }

    public final void setDataSavingEnable(boolean r18) {
        String r1 = ILoginService.a.getAccountInfo().c;
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        b0.a.getClass();
        Intrinsics.checkNotNullParameter(r1, "uid");
        b0.j().storeBoolean("dora_enable_data_saving_".concat(r1), r18);
        g49.d.d(TAG, "setDataSavingEnable: " + r18);
        if ((this._envStateFlow.getValue() instanceof c.b) == false) goto L8;
        Object r2 = this._envStateFlow.getValue();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.larus.dora.impl.device.settings.lab.LabEnvSettings.Success");
        this._envStateFlow.setValue(c.b.a((c.b) r2, false, false, false, false, false, false, false, false, false, false, false, false, r18, 2097151));
    L8:
        DoraP2pRtcSwitchSync.e("set_data_saving");
        IDoraService.B1.getClass();
        BuildersKt.launch$default(IDoraService$b.b, null, null, new C02671(null), 3, null);
    }

    public final void setNaturalInteractionBgmEnable(boolean r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02681(this, r7, null), 2, null);
    }

    public final void setQuickContinuousConversationEnable(boolean r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02691(this, r7, null), 3, null);
    }

    public final void setRTCTransportMode(RTCTransportMode r8) {
        Intrinsics.checkNotNullParameter(r8, "mode");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C02701(this, r8, null), 3, null);
    }

    public final void setRtosPlayerEnabled(boolean r7) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C02711(r7, this, null), 2, null);
    }

    public static final /* synthetic */ boolean access$isRTCSwitchSyncAccepted(LabSettingsViewModel r0, int r1) {
        return r0.isRTCSwitchSyncAccepted(r1);
    }

    public static final /* synthetic */ void access$setDoraVoiceCallback$p(LabSettingsViewModel r0, f49.b r1) {
        r0.doraVoiceCallback = r1;
    }

    public static final /* synthetic */ int access$toToggleValue(LabSettingsViewModel r0, boolean r1) {
        return r0.toToggleValue(r1);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x006c -> B:23:0x006f). Please report as a decompilation issue!!! */
    private final Object syncBluetoothRTCVideoCallSwitch(boolean r9, Continuation<? super Integer> r10) {
        if ((r10 instanceof C02721) == false) goto L7;
        C02721 r0 = (C02721) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        int r12 = r0.I$1;
        int r4 = r0.I$0;
        boolean r5 = r0.Z$0;
        Ref.IntRef r6 = (Ref.IntRef) r0.L$0;
        ResultKt.throwOnFailure(r11);
        boolean r13 = r5;
    L23:
        r12 = r12 + 1;
    L15:
        if (r12 >= r4) goto L25;
        int r7 = kj4.a.g().w(r13);
        r6.element = r7;
        if (r7 == 0) goto L19;
        r0.L$0 = r6;
        r0.Z$0 = r13;
        r0.I$0 = r4;
        r0.I$1 = r12;
        r0.label = 1;
        if (DelayKt.delay(SYNC_RETRY_DELAY_MS, r0) != r2) goto L23;
        return r2;
    L19:
        return Boxing.boxInt(r7);
    L25:
        return Boxing.boxInt(r6.element);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        r4 = 3;
        r6 = new Ref.IntRef();
        r13 = r9;
        r12 = 0;
    L7:
        r0 = new C02721(this, r10);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0092 -> B:24:0x0095). Please report as a decompilation issue!!! */
    private final Object syncEffectiveP2PRTCVideoCallSwitch(boolean r9, Continuation<? super Integer> r10) {
        if ((r10 instanceof C02731) == false) goto L7;
        C02731 r0 = (C02731) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        int r12 = r0.I$1;
        int r4 = r0.I$0;
        boolean r5 = r0.Z$0;
        Ref.IntRef r6 = (Ref.IntRef) r0.L$0;
        ResultKt.throwOnFailure(r11);
        boolean r13 = r5;
    L24:
        r12 = r12 + 1;
    L16:
        if (r12 >= r4) goto L26;
        int r7 = DoraP2pRtcSwitchSync.g(r13, null);
        r6.element = r7;
        if (r7 != 0) goto L21;
        g49.d.d(TAG, "syncEffectiveP2PRTCVideoCallSwitch success: enabled=" + r13 + ", ret=" + r6.element + ", attempt=" + (r12 + 1));
        return Boxing.boxInt(r6.element);
    L21:
        r0.L$0 = r6;
        r0.Z$0 = r13;
        r0.I$0 = r4;
        r0.I$1 = r12;
        r0.label = 1;
        if (DelayKt.delay(SYNC_RETRY_DELAY_MS, r0) != r2) goto L24;
        return r2;
    L26:
        if (r6.element != (-3)) goto L28;
        g49.d.e(TAG, "syncEffectiveP2PRTCVideoCallSwitch timeout: enabled=" + r13 + ", result unconfirmed");
    L30:
        return Boxing.boxInt(r6.element);
    L28:
        g49.d.b(TAG, "syncEffectiveP2PRTCVideoCallSwitch failed: enabled=" + r13 + ", ret=" + r6.element);
        goto L30
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        r4 = 3;
        r6 = new Ref.IntRef();
        r13 = r9;
        r12 = 0;
    L7:
        r0 = new C02731(this, r10);
        goto L8
    }

    public static final /* synthetic */ Object access$syncBluetoothRTCVideoCallSwitch(LabSettingsViewModel r0, boolean r1, Continuation r2) {
        return r0.syncBluetoothRTCVideoCallSwitch(r1, r2);
    }

    public static final /* synthetic */ Object access$syncEffectiveP2PRTCVideoCallSwitch(LabSettingsViewModel r0, boolean r1, Continuation r2) {
        return r0.syncEffectiveP2PRTCVideoCallSwitch(r1, r2);
    }

    private final void updateRTCTransportLocalState(String r21, boolean r22, boolean r23) {
        b0.a.getClass();
        Intrinsics.checkNotNullParameter(r21, "uid");
        b0.j().storeBoolean("dora_enable_bluetooth_rtc_" + r21, r22);
        Intrinsics.checkNotNullParameter(r21, "uid");
        b0.j().storeBoolean("dora_enable_p2p_rtc_".concat(r21), r23);
        if ((this._envStateFlow.getValue() instanceof c.b) == false) goto L6;
        z0<c> r1 = this._envStateFlow;
        Object r2 = r1.getValue();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.larus.dora.impl.device.settings.lab.LabEnvSettings.Success");
        r1.setValue(c.b.a((c.b) r2, false, false, false, false, false, false, false, r22, r23, false, false, false, false, 4182015));
        return;
    }

    public static final /* synthetic */ void access$updateRTCTransportLocalState(LabSettingsViewModel r0, String r1, boolean r2, boolean r3) {
        r0.updateRTCTransportLocalState(r1, r2, r3);
    }
}
