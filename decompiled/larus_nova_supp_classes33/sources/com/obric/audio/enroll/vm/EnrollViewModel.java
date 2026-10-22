package com.obric.audio.enroll.vm;

import android.content.Context;
import com.bytedance.crash.Npth;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.utils.logger.FLogger;
import com.obric.audio.enroll.model.EnrollState;
import com.obric.audio.enroll.recorder.VoicePrintEnrollRecordingsMgr;
import com.obric.audio.enroll.recorder.VoicePrintEnrollRecordingsMgr$BluetoothScoController$ensureScoStateReceiverRegistered$receiver$1;
import com.obric.audio.enroll.ui.VoicePrintEnrollActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;
import kotlinx.coroutines.w1;
import qia.e;
import qia.f;
import qia.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u0092\u00012\u00020\u0001:\u0002\u0092\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000bJ\u0016\u0010G\u001a\u00020\u00122\u0006\u0010A\u001a\u00020B2\u0006\u0010H\u001a\u00020\u0005J\u0006\u0010I\u001a\u00020\u0012J\u0006\u0010J\u001a\u00020\u0012J\u0011\u0010\u008b\u0001\u001a\u00020\u00122\b\u0010\u008c\u0001\u001a\u00030\u0089\u0001J\u0010\u0010\u008d\u0001\u001a\u00020\u000b2\u0007\u0010\u008e\u0001\u001a\u00020SJ\u0007\u0010\u008f\u0001\u001a\u00020\u000bJ\u0010\u0010\u0090\u0001\u001a\u00020\u000b2\u0007\u0010\u0091\u0001\u001a\u00020SR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000e\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#R\u001a\u0010&\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010!\"\u0004\b'\u0010#R\u001a\u0010(\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010!\"\u0004\b*\u0010#R\u001a\u0010+\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010!\"\u0004\b-\u0010#R\u001a\u0010.\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010!\"\u0004\b0\u0010#R\u001a\u00101\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010!\"\u0004\b3\u0010#R \u00104\u001a\b\u0012\u0004\u0012\u00020\u000b05X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010:\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010!\"\u0004\b;\u0010#R\u001a\u0010<\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010!\"\u0004\b=\u0010#R\u001a\u0010>\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010!\"\u0004\b@\u0010#R\u001c\u0010A\u001a\u0004\u0018\u00010BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u000e\u0010K\u001a\u00020LX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010M\u001a\u00020N¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR \u0010Q\u001a\b\u0012\u0004\u0012\u00020S0RX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR \u0010X\u001a\b\u0012\u0004\u0012\u00020S0RX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010U\"\u0004\bZ\u0010WR\u0017\u0010[\u001a\b\u0012\u0004\u0012\u00020\\0R¢\u0006\b\n\u0000\u001a\u0004\b]\u0010UR\u0017\u0010^\u001a\b\u0012\u0004\u0012\u00020`0_¢\u0006\b\n\u0000\u001a\u0004\ba\u0010bR\u0017\u0010c\u001a\b\u0012\u0004\u0012\u00020S0R¢\u0006\b\n\u0000\u001a\u0004\bd\u0010UR#\u0010e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020g\u0012\u0004\u0012\u00020S0f0_¢\u0006\b\n\u0000\u001a\u0004\bh\u0010bR#\u0010i\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020S\u0012\u0004\u0012\u00020j0f0_¢\u0006\b\n\u0000\u001a\u0004\bk\u0010bR \u0010l\u001a\b\u0012\u0004\u0012\u00020n0mX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u00107\"\u0004\bp\u00109R\u001c\u0010q\u001a\u0004\u0018\u00010rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\u001a\u0010w\u001a\u00020SX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R\u001a\u0010|\u001a\u00020SX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b}\u0010y\"\u0004\b~\u0010{R\u001c\u0010\u007f\u001a\u00020SX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010y\"\u0005\b\u0081\u0001\u0010{R\u001d\u0010\u0082\u0001\u001a\u00020SX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u0010y\"\u0005\b\u0084\u0001\u0010{R\u001d\u0010\u0085\u0001\u001a\u00020SX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0086\u0001\u0010y\"\u0005\b\u0087\u0001\u0010{R\u001a\u0010\u0088\u0001\u001a\t\u0012\u0005\u0012\u00030\u0089\u00010_¢\u0006\t\n\u0000\u001a\u0005\b\u008a\u0001\u0010b¨\u0006\u0093\u0001"}, d2 = {"Lcom/obric/audio/enroll/vm/EnrollViewModel;", "Lcom/obric/audio/enroll/vm/BaseViewModel;", "<init>", "()V", "enrollDeviceType", "Lcom/obric/audio/enroll/ui/VoicePrintEnrollActivity$Companion$EnrollDeviceType;", "getEnrollDeviceType", "()Lcom/obric/audio/enroll/ui/VoicePrintEnrollActivity$Companion$EnrollDeviceType;", "setEnrollDeviceType", "(Lcom/obric/audio/enroll/ui/VoicePrintEnrollActivity$Companion$EnrollDeviceType;)V", "value", "", "enrollDeviceSn", "getEnrollDeviceSn", "()Ljava/lang/String;", "enrollDeviceName", "getEnrollDeviceName", "setEnrollDeviceInfo", "", "sn", "name", "recordingManager", "Lcom/obric/audio/enroll/recorder/VoicePrintEnrollRecordingsMgr;", "getRecordingManager", "()Lcom/obric/audio/enroll/recorder/VoicePrintEnrollRecordingsMgr;", "setRecordingManager", "(Lcom/obric/audio/enroll/recorder/VoicePrintEnrollRecordingsMgr;)V", "startFrom", "getStartFrom", "setStartFrom", "(Ljava/lang/String;)V", "isLeaveFromPrivacy", "", "()Z", "setLeaveFromPrivacy", "(Z)V", "isAlreadyEnroll", "setAlreadyEnroll", "isEnrollSuccess", "setEnrollSuccess", "voiceWakeupSwitch", "getVoiceWakeupSwitch", "setVoiceWakeupSwitch", "helpImproveVoiceWakeupSwitch", "getHelpImproveVoiceWakeupSwitch", "setHelpImproveVoiceWakeupSwitch", "helpImproveVoiceWakeupInitiallyEnabled", "getHelpImproveVoiceWakeupInitiallyEnabled", "setHelpImproveVoiceWakeupInitiallyEnabled", "lockVoiceprintSwitch", "getLockVoiceprintSwitch", "setLockVoiceprintSwitch", "currentSettingItems", "", "getCurrentSettingItems", "()Ljava/util/List;", "setCurrentSettingItems", "(Ljava/util/List;)V", "isInterruptEnhancedVoiceEnroll", "setInterruptEnhancedVoiceEnroll", "isRequestingRecordPermission", "setRequestingRecordPermission", "hasClickFinishButton", "getHasClickFinishButton", "setHasClickFinishButton", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "init", "deviceType", "release", "stop", "eventBusContext", "Lkotlin/coroutines/CoroutineContext;", "eventBusScope", "Lkotlinx/coroutines/CoroutineScope;", "getEventBusScope", "()Lkotlinx/coroutines/CoroutineScope;", "enrollIndex", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "getEnrollIndex", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "setEnrollIndex", "(Lkotlinx/coroutines/flow/MutableStateFlow;)V", "stageingIndex", "getStageingIndex", "setStageingIndex", "enrollState", "Lcom/obric/audio/enroll/model/EnrollState;", "getEnrollState", "recordingEvent", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/obric/audio/enroll/recorder/RecordToken;", "getRecordingEvent", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "asrState", "getAsrState", "audioData", "Lkotlin/Pair;", "", "getAudioData", "enrollProgress", "", "getEnrollProgress", "enrollSentences", "", "Lcom/obric/audio/enroll/model/EnrollTeam;", "getEnrollSentences", "setEnrollSentences", "enrollSentence", "Lcom/obric/audio/enroll/model/EnrollSentence;", "getEnrollSentence", "()Lcom/obric/audio/enroll/model/EnrollSentence;", "setEnrollSentence", "(Lcom/obric/audio/enroll/model/EnrollSentence;)V", "topGuideLine", "getTopGuideLine", "()I", "setTopGuideLine", "(I)V", "neckGuideLine", "getNeckGuideLine", "setNeckGuideLine", "footGuideLine", "getFootGuideLine", "setFootGuideLine", "leftBorderLine", "getLeftBorderLine", "setLeftBorderLine", "bottomGuideLine", "getBottomGuideLine", "setBottomGuideLine", "eventBus", "Lcom/obric/audio/enroll/model/EnrollEvent;", "getEventBus", "reportEvent", "event", "sentence", "index", "enterFrom", "getCurrentPageName", "position", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EnrollViewModel extends BaseViewModel {
    public static final String ASSISTANT_ONBOARDING = "obric_assistant_onboarding";
    public static final String ASSISTANT_SETTINGS = "obric_assistant_settings";
    public static final String CURRENT_SETTING_ITEMS = "current_setting_items";
    public static final a Companion = null;
    public static final String DORA_DEVICE_MANAGEMENT = "dora_device_management";
    public static final String DORA_ONBOARDING = "dora_onboarding";
    public static final String DOUBAO_GUIDE = "DoubaoGuide";
    public static final String FAILED_PAGE = "obric_record_voice_wakeup_failed";
    public static final String GUIDE_PAGE = "obric_onboarding_voice_wakeup";
    public static final String HAS_RECORD_PERMISSION = "hasRecordPermission";
    public static final String IS_VOICE_AUTHORIZATION_SWITCH_OPEN = "isVoiceAuthorizationSwitchOpen";
    public static final String NOISE_REDUCTION = "noise_reduction";
    public static final String OBRIC_DEVICE_SETTINGS = "obric_device_settings";
    public static final String OS_ONBOARDING = "obric_os_onboarding";
    public static final String PAGE_1 = "obric_record_voice_wakeup_1";
    public static final String PAGE_2 = "obric_record_voice_wakeup_2";
    public static final String PAGE_3 = "obric_record_voice_wakeup_3";
    public static final String PAGE_4 = "obric_record_voice_wakeup_4";
    public static final String PAGE_5 = "obric_record_voice_wakeup_5";
    public static final String SET_UP_WIZARD = "SetUpWizard";
    public static final String SUCCESS_PAGE = "obric_onboarding_voice_wakeup_complete";
    public static final String SYSTEM_SETTINGS = "SystemSetting";
    public static final String TAG = "EnrollViewModel";
    public static final String TIME_OUT_PAGE = "obric_record_voice_wakeup_timeout";
    public static final String VOICE_AUTHORIZATION = "VoiceAuthorization";
    public static final String VOICE_MANAGER = "VoiceManager";
    public static final String VOICE_WAKEUP = "VoiceWakeup";
    private final z0<Integer> asrState;
    private final MutableSharedFlow<Pair<byte[], Integer>> audioData;
    private int bottomGuideLine;
    private Context context;
    private List<String> currentSettingItems;
    private String enrollDeviceName;
    private String enrollDeviceSn;
    private VoicePrintEnrollActivity.Companion.EnrollDeviceType enrollDeviceType;
    private z0<Integer> enrollIndex;
    private final MutableSharedFlow<Pair<Integer, int[]>> enrollProgress;
    private f enrollSentence;
    private List<g> enrollSentences;
    private final z0<EnrollState> enrollState;
    private final MutableSharedFlow<e> eventBus;
    private final CoroutineContext eventBusContext;
    private final CoroutineScope eventBusScope;
    private int footGuideLine;
    private boolean hasClickFinishButton;
    private boolean helpImproveVoiceWakeupInitiallyEnabled;
    private boolean helpImproveVoiceWakeupSwitch;
    private boolean isAlreadyEnroll;
    private boolean isEnrollSuccess;
    private boolean isInterruptEnhancedVoiceEnroll;
    private boolean isLeaveFromPrivacy;
    private boolean isRequestingRecordPermission;
    private int leftBorderLine;
    private boolean lockVoiceprintSwitch;
    private int neckGuideLine;
    private final MutableSharedFlow<com.obric.audio.enroll.recorder.a> recordingEvent;
    public VoicePrintEnrollRecordingsMgr recordingManager;
    private z0<Integer> stageingIndex;
    private String startFrom;
    private int topGuideLine;
    private boolean voiceWakeupSwitch;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.obric.audio.enroll.vm.EnrollViewModel$reportEvent$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.audio.enroll.vm.EnrollViewModel$reportEvent$1", f = "EnrollViewModel.kt", i = {}, l = {144}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ e $event;
        int label;
        final /* synthetic */ EnrollViewModel this$0;

        public AnonymousClass1(EnrollViewModel r1, e r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$event = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$event, r4);
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
            MutableSharedFlow<e> r5 = this.this$0.getEventBus();
            e r2 = this.$event;
            this.label = 1;
            if (r5.emit(r2, this) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new a();
    }

    public final void release() {
        this.context = null;
        if (this.recordingManager == null) goto L56;
        VoicePrintEnrollRecordingsMgr r1 = getRecordingManager();
        r1.c();
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L11
        Future<?> r4 = r1.h;     // Catch: Throwable -> L11
        if (r4 == null) goto L8;
        Boolean r5 = Boolean.valueOf(r4.cancel(true));     // Catch: Throwable -> L11
    L9:
        Result.constructor-impl(r5);     // Catch: Throwable -> L11
    L54:
        Result.constructor-impl(r1.g.shutdownNow());     // Catch: Throwable -> L15
    L17:
        VoicePrintEnrollRecordingsMgr.BluetoothScoController r6 = r1.k;
        r6.getClass();
        FLogger.a.i("VoicePrintEnrollRecordingsMgr", "sco: release");
        Job r7 = r6.a;
        if (r7 == null) goto L20;
        Job.DefaultImpls.cancel$default(r7, null, 1, null);
    L20:
        r6.a = null;
        if (r6.g == false) goto L46;
        Context r2 = r6.j.getContext();
        if (r2 == null) goto L46;
        Context r8 = r2.getApplicationContext();
        if (r8 == null) goto L46;
        VoicePrintEnrollRecordingsMgr$BluetoothScoController$ensureScoStateReceiverRegistered$receiver$1 r9 = r6.f;
        if (r9 == null) goto L46;
        r6.g = false;
        r6.f = null;
        ReceiverRegisterLancet.loge(r9, false);     // Catch: Throwable -> L43
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L52;
        r8.unregisterReceiver(r9);     // Catch: Throwable -> L43
    L41:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L43
    L45:
        FLogger.a.i("VoicePrintEnrollRecordingsMgr", "sco: receiver unregistered");
        goto L46
    L52:
    L38:
        e = move-exception;
        Npth.addTag("unregisterReceiver", r9.toString());     // Catch: Throwable -> L43
        e.printStackTrace();     // Catch: Throwable -> L43
        goto L41
    L35:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r9, r8) == false) goto L41;
        r8.unregisterReceiver(r9);     // Catch: Exception -> L38 Throwable -> L43
    L43:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L46:
        r6.f(r6.b());
        r1.a = null;
        return;
    L15:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    L8:
        r5 = null;
    L11:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L54
    }

    public final String enterFrom() {
        if (Intrinsics.areEqual(this.startFrom, SET_UP_WIZARD) == false) goto L7;
        return OS_ONBOARDING;
    L7:
        if (Intrinsics.areEqual(this.startFrom, DOUBAO_GUIDE) == false) goto L11;
        return ASSISTANT_ONBOARDING;
    L11:
        if (Intrinsics.areEqual(this.startFrom, SYSTEM_SETTINGS) == false) goto L15;
        return OBRIC_DEVICE_SETTINGS;
    L15:
        if (Intrinsics.areEqual(this.startFrom, DORA_ONBOARDING) == false) goto L18;
        return DORA_ONBOARDING;
    L18:
        if (Intrinsics.areEqual(this.startFrom, DORA_DEVICE_MANAGEMENT) == false) goto L20;
        return DORA_DEVICE_MANAGEMENT;
    L20:
        return ASSISTANT_SETTINGS;
    }

    public final VoicePrintEnrollRecordingsMgr getRecordingManager() {
        VoicePrintEnrollRecordingsMgr r0 = this.recordingManager;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("recordingManager");
        return null;
    }

    public final void stop() {
        if (this.recordingManager == null) goto L6;
        getRecordingManager().c();
        return;
    }

    public EnrollViewModel() {
        this.enrollDeviceType = VoicePrintEnrollActivity.Companion.EnrollDeviceType.DEFAULT;
        this.enrollDeviceSn = "";
        this.enrollDeviceName = "";
        this.startFrom = "";
        this.currentSettingItems = CollectionsKt.emptyList();
        ExecutorCoroutineDispatcher r0 = w1.a(1, "eventBusContext");
        this.eventBusContext = r0;
        this.eventBusScope = CoroutineScopeKt.CoroutineScope(r0.plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.enrollIndex = j1.a(-1);
        this.stageingIndex = j1.a(-1);
        this.enrollState = j1.a(EnrollState.IDLE);
        BufferOverflow r3 = BufferOverflow.DROP_OLDEST;
        this.recordingEvent = SharedFlowKt.MutableSharedFlow$default(0, 8, r3, 1, null);
        this.asrState = j1.a(-1);
        this.audioData = SharedFlowKt.MutableSharedFlow$default(0, 32, r3, 1, null);
        this.enrollProgress = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.enrollSentences = new ArrayList();
        this.eventBus = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
    }

    public final z0<Integer> getAsrState() {
        return this.asrState;
    }

    public final MutableSharedFlow<Pair<byte[], Integer>> getAudioData() {
        return this.audioData;
    }

    public final int getBottomGuideLine() {
        return this.bottomGuideLine;
    }

    public final Context getContext() {
        return this.context;
    }

    public final List<String> getCurrentSettingItems() {
        return this.currentSettingItems;
    }

    public final String getEnrollDeviceName() {
        return this.enrollDeviceName;
    }

    public final String getEnrollDeviceSn() {
        return this.enrollDeviceSn;
    }

    public final VoicePrintEnrollActivity.Companion.EnrollDeviceType getEnrollDeviceType() {
        return this.enrollDeviceType;
    }

    public final z0<Integer> getEnrollIndex() {
        return this.enrollIndex;
    }

    public final MutableSharedFlow<Pair<Integer, int[]>> getEnrollProgress() {
        return this.enrollProgress;
    }

    public final f getEnrollSentence() {
        return this.enrollSentence;
    }

    public final List<g> getEnrollSentences() {
        return this.enrollSentences;
    }

    public final z0<EnrollState> getEnrollState() {
        return this.enrollState;
    }

    public final MutableSharedFlow<e> getEventBus() {
        return this.eventBus;
    }

    public final CoroutineScope getEventBusScope() {
        return this.eventBusScope;
    }

    public final int getFootGuideLine() {
        return this.footGuideLine;
    }

    public final boolean getHasClickFinishButton() {
        return this.hasClickFinishButton;
    }

    public final boolean getHelpImproveVoiceWakeupInitiallyEnabled() {
        return this.helpImproveVoiceWakeupInitiallyEnabled;
    }

    public final boolean getHelpImproveVoiceWakeupSwitch() {
        return this.helpImproveVoiceWakeupSwitch;
    }

    public final int getLeftBorderLine() {
        return this.leftBorderLine;
    }

    public final boolean getLockVoiceprintSwitch() {
        return this.lockVoiceprintSwitch;
    }

    public final int getNeckGuideLine() {
        return this.neckGuideLine;
    }

    public final MutableSharedFlow<com.obric.audio.enroll.recorder.a> getRecordingEvent() {
        return this.recordingEvent;
    }

    public final z0<Integer> getStageingIndex() {
        return this.stageingIndex;
    }

    public final String getStartFrom() {
        return this.startFrom;
    }

    public final int getTopGuideLine() {
        return this.topGuideLine;
    }

    public final boolean getVoiceWakeupSwitch() {
        return this.voiceWakeupSwitch;
    }

    public final boolean isAlreadyEnroll() {
        return this.isAlreadyEnroll;
    }

    public final boolean isEnrollSuccess() {
        return this.isEnrollSuccess;
    }

    public final boolean isInterruptEnhancedVoiceEnroll() {
        return this.isInterruptEnhancedVoiceEnroll;
    }

    public final boolean isLeaveFromPrivacy() {
        return this.isLeaveFromPrivacy;
    }

    public final boolean isRequestingRecordPermission() {
        return this.isRequestingRecordPermission;
    }

    public final String getCurrentPageName(int r4) {
        if (r4 != 1) goto L5;
        return PAGE_1;
    L5:
        if (r4 != 2) goto L7;
        return PAGE_2;
    L7:
        if (r4 != 3) goto L9;
        return PAGE_3;
    L9:
        if (r4 != 4) goto L11;
        return PAGE_4;
    L11:
        if (r4 == 5) goto L13;
        FLogger.a.i("EnrollingFragment", "getCurrentPageName: unknown position " + r4);
        return "unknown page";
    L13:
        return PAGE_5;
    }

    public final void reportEvent(e r8) {
        Intrinsics.checkNotNullParameter(r8, "event");
        BuildersKt.launch$default(this.eventBusScope, null, null, new AnonymousClass1(this, r8, null), 3, null);
    }

    public final String sentence(int r3) {
        if (r3 >= 0) goto L4;
        return "unknown";
    L4:
        if (r3 >= this.enrollSentences.size()) goto L21;
        g r4 = (g) ListProtector.get(this.enrollSentences, r3);
        String r0 = r4.b();
        if (r0 != null) goto L9;
    L13:
        String r1 = r4.c();
        if (r1 != null) goto L20;
        return "";
    L20:
        return r1;
    L9:
        if ((!StringsKt.isBlank(r0)) == true) goto L12;
        r0 = null;
    L12:
        if (r0 == null) goto L13;
        return r0;
    L21:
        return "unknown";
    }

    public final void setAlreadyEnroll(boolean r1) {
        this.isAlreadyEnroll = r1;
    }

    public final void setBottomGuideLine(int r1) {
        this.bottomGuideLine = r1;
    }

    public final void setContext(Context r1) {
        this.context = r1;
    }

    public final void setCurrentSettingItems(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.currentSettingItems = r2;
    }

    public final void setEnrollDeviceType(VoicePrintEnrollActivity.Companion.EnrollDeviceType r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.enrollDeviceType = r2;
    }

    public final void setEnrollIndex(z0<Integer> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.enrollIndex = r2;
    }

    public final void setEnrollSentence(f r1) {
        this.enrollSentence = r1;
    }

    public final void setEnrollSentences(List<g> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.enrollSentences = r2;
    }

    public final void setEnrollSuccess(boolean r1) {
        this.isEnrollSuccess = r1;
    }

    public final void setFootGuideLine(int r1) {
        this.footGuideLine = r1;
    }

    public final void setHasClickFinishButton(boolean r1) {
        this.hasClickFinishButton = r1;
    }

    public final void setHelpImproveVoiceWakeupInitiallyEnabled(boolean r1) {
        this.helpImproveVoiceWakeupInitiallyEnabled = r1;
    }

    public final void setHelpImproveVoiceWakeupSwitch(boolean r1) {
        this.helpImproveVoiceWakeupSwitch = r1;
    }

    public final void setInterruptEnhancedVoiceEnroll(boolean r1) {
        this.isInterruptEnhancedVoiceEnroll = r1;
    }

    public final void setLeaveFromPrivacy(boolean r1) {
        this.isLeaveFromPrivacy = r1;
    }

    public final void setLeftBorderLine(int r1) {
        this.leftBorderLine = r1;
    }

    public final void setLockVoiceprintSwitch(boolean r1) {
        this.lockVoiceprintSwitch = r1;
    }

    public final void setNeckGuideLine(int r1) {
        this.neckGuideLine = r1;
    }

    public final void setRecordingManager(VoicePrintEnrollRecordingsMgr r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.recordingManager = r2;
    }

    public final void setRequestingRecordPermission(boolean r1) {
        this.isRequestingRecordPermission = r1;
    }

    public final void setStageingIndex(z0<Integer> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.stageingIndex = r2;
    }

    public final void setStartFrom(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.startFrom = r2;
    }

    public final void setTopGuideLine(int r1) {
        this.topGuideLine = r1;
    }

    public final void setVoiceWakeupSwitch(boolean r1) {
        this.voiceWakeupSwitch = r1;
    }

    public final void init(Context r2, VoicePrintEnrollActivity.Companion.EnrollDeviceType r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "deviceType");
        this.enrollDeviceType = r3;
        this.context = r2;
        setRecordingManager(new VoicePrintEnrollRecordingsMgr(r2, this));
    }

    public final void setEnrollDeviceInfo(String r3, String r4) {
        String r0 = null;
        if (r3 == null) goto L5;
        String r5 = StringsKt.trim(r3).toString();
    L6:
        String r1 = "";
        if (r5 != null) goto L9;
        r5 = "";
    L9:
        this.enrollDeviceSn = r5;
        if (r4 == null) goto L12;
        r0 = StringsKt.trim(r4).toString();
    L12:
        if (r0 == null) goto L15;
        r1 = r0;
    L15:
        this.enrollDeviceName = r1;
        FLogger.a.i(TAG, "setEnrollDeviceInfo sn=" + this.enrollDeviceSn + " nameLen=" + this.enrollDeviceName.length());
        return;
    L5:
        r5 = null;
        goto L6
    }
}
