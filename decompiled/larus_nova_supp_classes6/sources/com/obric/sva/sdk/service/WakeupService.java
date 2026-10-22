package com.obric.sva.sdk.service;

import android.app.AppOpsManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.ParcelFileDescriptor;
import android.os.PowerManager;
import android.os.Process;
import android.os.SystemClock;
import android.os.Trace;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import com.bytedance.mira.plugin.hook.flipped.Flipped;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.common.apphost.AppHost;
import com.larus.common.mssdk.api.ISecPrivacyService;
import com.mammon.audiosdk.structures.SAMICoreFirstWakeupProperty;
import com.obric.assistant.common.AndroidLogcat;
import com.obric.sva.framework.api.ISvaFrameworkKt;
import com.obric.sva.framework.wrapper.SoundTriggerWrapper;
import com.obric.sva.sdk.ahm.AhmClient;
import com.obric.sva.sdk.audio.AecModel;
import com.obric.sva.sdk.audio.WakeupAudioRecordingGuard;
import com.obric.sva.sdk.audio.WakeupAudioServerMonitor;
import com.obric.sva.sdk.audio.WakeupStreamVolumeProvider;
import com.obric.sva.sdk.bluetooth.BluetoothDeviceManager;
import com.obric.sva.sdk.boost.BoostFrameworkHelper;
import com.obric.sva.sdk.boost.JniUtils;
import com.obric.sva.sdk.config.ConfigManager;
import com.obric.sva.sdk.controller.BreathUtils;
import com.obric.sva.sdk.controller.ExtendedSmMgr;
import com.obric.sva.sdk.controller.Global;
import com.obric.sva.sdk.controller.HotwordRecorderMgr;
import com.obric.sva.sdk.controller.HotwordUtils;
import com.obric.sva.sdk.controller.ManufactureFeatures;
import com.obric.sva.sdk.controller.SoundModelManager;
import com.obric.sva.sdk.controller.SvaSdkGlobal;
import com.obric.sva.sdk.data.IExtendedSmModel;
import com.obric.sva.sdk.data.SettingsDAO;
import com.obric.sva.sdk.data.SettingsModel;
import com.obric.sva.sdk.db.SvaSdkDatabase;
import com.obric.sva.sdk.db.SvaVoicePrintControl;
import com.obric.sva.sdk.ipc.MainProcessKeepAliveBinder;
import com.obric.sva.sdk.ipc.TemporaryWakeupGateManager;
import com.obric.sva.sdk.ipc.TrackAPI;
import com.obric.sva.sdk.ipc.TrackerManager;
import com.obric.sva.sdk.ipc.WakeupSettingBus;
import com.obric.sva.sdk.lightup.LightUpManager;
import com.obric.sva.sdk.logger.InteractorReportInitializer;
import com.obric.sva.sdk.logger.SpecialCategory;
import com.obric.sva.sdk.logger.WakeupMetricAttributionEmitter;
import com.obric.sva.sdk.nonstream.KWSScore;
import com.obric.sva.sdk.notification.SvaNotificationListenerService;
import com.obric.sva.sdk.ohr.OhrHandStateBridge;
import com.obric.sva.sdk.sami.SamiBreathWakeupEngine;
import com.obric.sva.sdk.sami.SamiPhoneEnrollManager;
import com.obric.sva.sdk.sami.SamiVoiceWakeupEngine;
import com.obric.sva.sdk.sami.SamiWakeupParamProvider;
import com.obric.sva.sdk.session.BreathWakeupSession;
import com.obric.sva.sdk.session.IWakeupSession;
import com.obric.sva.sdk.session.IWakeupSessionConstant;
import com.obric.sva.sdk.session.OpaqueDataHelper;
import com.obric.sva.sdk.session.SessionType;
import com.obric.sva.sdk.session.VoiceWakeupSession;
import com.obric.sva.sdk.session.legacy.IWakeupListener;
import com.obric.sva.sdk.upload.WakeupUploadManager;
import com.obric.sva.sdk.utils.DetectionEventContainer;
import com.obric.sva.sdk.utils.KtUtils;
import com.obric.sva.sdk.utils.LogUtils;
import com.obric.sva.sdk.utils.Utils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import sna.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class WakeupService extends Service implements IWakeupListener {
    private static final int DISPLAY_ON_DURATION = 5000;
    private static final KWSScore EMPTY_SCORE = null;
    private static final String KEY_CAPTURE_HANDLE = "capture_handle";
    private static final String KEY_CONFIDENCE = "confidence";
    private static final String KEY_DETECTION_LEVEL = "detection_level";
    private static final String KEY_DETECTION_SUCCESS = "detection_success";
    private static final String KEY_EVENT_HASH = "event_hash";
    private static final String KEY_FIRST_WAKEUP_AFTER_BOOT = "first_wakeup_after_boot";
    private static final String KEY_FKConfidenceLevel = "FKConfidenceLevel";
    private static final String KEY_FUsrConfidenceLevel = "FUsrConfidenceLevel";
    private static final String KEY_GROUP_ID = "group_id";
    private static final String KEY_KW_LENGTH = "kw_length";
    private static final String KEY_OHR_HAND = "ohr_hand";
    private static final String KEY_SESSION_TYPE = "session_type";
    private static final String KEY_SID_BARGIN_STATUS = "sid_bargin_status";
    private static final String KEY_SID_VOLUME = "sid_volume";
    private static final String KEY_SM_HANDLE = "sm_handle";
    private static final String KEY_SM_NAME = "sm_name";
    private static final String KEY_STAGE1_CONFIDENCE = "stage1_confidence";
    private static final String KEY_STAGE1_KEYWORD = "stage1_keyword";
    private static final String KEY_STAGE1_MODEL_VERSION = "stage1_model_version";
    private static final String KEY_STAGE1_START_TIME = "stage1_start_time";
    private static final String KEY_STAGE1_THRESHOLD = "stage1_threshold";
    private static final String KEY_STAGE1_TRACE_BACK = "stage1_trace_back";
    private static final String KEY_STAGE2_ENGINE_VERSION = "stage2_engine_version";
    private static final String KEY_STAGE2_KWS_RAW_MD5 = "stage2_kws_raw_md5";
    private static final String KEY_STAGE2_MODEL_MD5 = "stage2_model_md5";
    private static final String KEY_STAGE2_MODEL_VERSION = "stage2_model_version";
    private static final String KEY_STAGE2_SID_RAW_MD5 = "stage2_sid_raw_md5";
    private static final int MAX_DURATION_SHOW_LENGTH = 100;
    private static final int MAX_RECORDER_BUSY_RETRY_COUNT = 6;
    private static final long NO_RECORD_AUDIO_PERMISSION_TOAST_INTERVAL_MS = 2000;
    private static final int POWER_SCREEN_MODE_NORMAL = 2;
    private static final long RECORDER_BUSY_RETRY_DELAY_MS = 500;
    private static final int SCREEN_POWER_UP_DURATION = 1000;
    private static final boolean SUPPORT_CAL_SAMPLE = false;
    private static final boolean SUPPORT_VIP_THREAD = false;
    private static final long SUPPRESS_IN_CALL_TOAST_INTERVAL_MS = 3000;
    private static final String TAG = null;
    private static final String TAG_WAKEUP_DURATION = "WakeupDuration";
    private static final long UNBIND_STOP_GRACE_MS = 1500;
    private static volatile WakeupService sCurrentService;
    private long breathStartTime;
    private final Runnable destroyBreathSamiCoreRunnable;
    private volatile IExtendedSmModel extendedBreathSmModel;
    private volatile IExtendedSmModel extendedVoiceSmModel;
    private final AecModel mAecModel;
    private AppOpsManager mAppOpsManager;
    private volatile WakeupAudioRecordingGuard mAudioRecordingGuard;
    private WakeupAudioServerMonitor mAudioServerMonitor;
    private int mBindGeneration;
    private BoostFrameworkHelper mBooster;
    private SettingsModel mBreathSettingModel;
    private IWakeupSession mBreathWakeupSession;
    private final Runnable mDelayedStopRunnable;
    private volatile boolean mDestroyed;
    private String mDeviceId;
    private long mEndTime;
    private ExtendedSmMgr mExtendedSmMgr;
    private final Handler mH;
    private Handler mHandler;
    private final AtomicBoolean mHasVoiceStage1AfterBoot;
    private LookAheadBufferTask mLABTask;
    private volatile long mLastNoRecordAudioPermissionToastTimeMs;
    private volatile long mLastSuppressInCallToastTimeMs;
    private Object mLock;
    private int mPendingStopGeneration;
    private boolean mPendingTerminateRequest;
    private String mPhoneModel;
    private PowerManager mPowerManager;
    private AppOpsManager.OnOpChangedListener mRecordAudioOpChangedListener;
    private int mRecorderBusyRetryCount;
    private int mRecorderBusyRetryGeneration;
    private String mRecorderBusyRetrySmName;
    private int mReleaseSidExecutorGeneration;
    private Runnable mReleaseSidExecutorRunnable;
    private RestartRecognitionTask mRestartRecognitionTask;
    private boolean mSamiCoreInited;
    private Messenger mServerMessenger;
    private List<IWakeupSession> mSessions;
    private Handler mSettingChangeHandler;
    private HandlerThread mSettingChangeHandlerThread;
    private SharedPreferences mSharedPreferences;
    private final AtomicBoolean mSidRecoveryInProgress;
    private volatile boolean mSidReloadAfterReEnrollPending;
    private SoundModelManager mSoundModelManager;
    private final List<Pair<String, Long>> mStage1WakeupDuration;
    private final List<Pair<String, String>> mStage2WakeupDetail;
    private final List<Pair<String, Long>> mStage2WakeupDuration;
    private long mStartTime;
    private final WakeupSettingBus.Listener mStatusChangeListener;
    private boolean mSupportStage2Bypass;
    private String mUUIDCached;
    private volatile int mVoiceRequest;
    private SettingsModel mVoiceSettingModel;
    private final AtomicInteger mVoiceStage2InFlight;
    private IWakeupSession mVoiceWakeupSession;
    private VoiceWakeupSidThresholdManager mVoiceWakeupSidThresholdManager;
    private PowerManager.WakeLock mWakeLock;
    private boolean mWakeWordSourceBusy;
    private final WakeupClientRegistry mWakeupClientRegistry;
    private WakeupDisplayController mWakeupDisplayController;
    private WakeupToken mWakeupToken;
    private final WakeupTraceCollector mWakeupTraceCollector;
    private TrackerManager.MessageCallback messageCallback;
    private final Map<String, Object> miscMap;
    private boolean needBreathRestart;
    private boolean needVoiceRestart;

    public static /* synthetic */ void A(WakeupService r0, WakeupSettingBus.Property r1, boolean r2) {
        r0.lambda$new$4(r1, r2);
    }

    public static /* synthetic */ void B(WakeupService r0) {
        r0.destroyBreathSamiCore();
    }

    public static /* synthetic */ void C(WakeupService r0) {
        r0.lambda$showNoRecordAudioPermissionToastOnce$1();
    }

    public static /* synthetic */ void a(WakeupService r0, IWakeupSession r1) {
        r0.lambda$onDestroy$20(r1);
    }

    public static /* synthetic */ void b(SvaSdkDatabase r0) {
        lambda$onCreate$14(r0);
    }

    public static /* synthetic */ String c(WakeupService r0) {
        return r0.lambda$onCreate$15();
    }

    public static /* synthetic */ void d(WakeupService r0) {
        r0.lambda$showSuppressInCallToastOnce$2();
    }

    public static /* synthetic */ void e(WakeupService r0, String r1) {
        r0.lambda$initBreathSamiCoreAsync$22(r1);
    }

    private synchronized void ensureSettingChangeHandler() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.mDestroyed == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.mSettingChangeHandler == null) goto L11;
        monitor-exit(this);
        return;
    L11:
        PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2("WakeupSettingChange");     // Catch: Throwable -> L14
        this.mSettingChangeHandlerThread = r0;     // Catch: Throwable -> L14
        ThreadMethodProxy.start(r0);     // Catch: Throwable -> L14
        this.mSettingChangeHandler = new Handler(this.mSettingChangeHandlerThread.getLooper());     // Catch: Throwable -> L14
        monitor-exit(this);
    }

    public static /* synthetic */ void f(WakeupService r0) {
        r0.onAudioServerUp();
    }

    public static /* synthetic */ void g(SvaVoicePrintControl r0) {
        lambda$onCreate$13(r0);
    }

    public static /* synthetic */ void h(WakeupService r0) {
        r0.lambda$initVoiceSamiCore$21();
    }

    public static /* synthetic */ Boolean i(WakeupService r0, Boolean r1) {
        return r0.lambda$onCreate$10(r1);
    }

    private boolean isInCallMode() {
        AudioManager r1 = (AudioManager) getSystemService("audio");     // Catch: Exception -> L12
        if (r1 == null) goto L14;
        int r2 = r1.getMode();     // Catch: Exception -> L12
        if (r2 != 2) goto L9;
    L10:
        return true;
    L9:
        if (r2 == 3) goto L10;
        return false;
    L14:
        return false;
    L12:
        e = move-exception;
        LogUtils.e(TAG, "isInCallMode check failed: " + e.getMessage(), new Object[0]);
        goto L14
    }

    public static /* synthetic */ void j(WakeupService r0, Message r1) {
        r0.lambda$new$8(r1);
    }

    public static /* synthetic */ void k(WakeupService r0, WakeupSettingBus.Property r1, boolean r2) {
        r0.lambda$new$5(r1, r2);
    }

    public static /* synthetic */ void l(WakeupService r0) {
        r0.lambda$onBreathRecognition$18();
    }

    public static /* synthetic */ void m(WakeupService r0) {
        r0.triggerAssistantOnce();
    }

    public static /* synthetic */ void n(WakeupService r0, String r1) {
        r0.onAllAudioRecordersReleased(r1);
    }

    public static /* synthetic */ void o(WakeupService r0, SoundModelManager r1) {
        r0.lambda$onCreate$12(r1);
    }

    public static /* synthetic */ void p(WakeupService r0, int r1, String r2) {
        r0.lambda$scheduleEstablishSessionAfterRecorderReleased$3(r1, r2);
    }

    public static /* synthetic */ void q(WakeupService r0, String r1, boolean r2) {
        r0.lambda$postTruthCaptureSwitchChanged$7(r1, r2);
    }

    public static /* synthetic */ void r(WakeupService r0) {
        r0.destroySamiCore();
    }

    public static /* synthetic */ void s(WakeupService r0, SoundTriggerWrapper.RecognitionEventWrapper r1) {
        r0.lambda$onRecognition$17(r1);
    }

    public static /* synthetic */ void t(WakeupService r0, int r1, int r2, int r3, Bundle r4) {
        r0.lambda$postAccountEvent$6(r1, r2, r3, r4);
    }

    private synchronized void turnOnDisplay() {
        monitor-enter(this);
        LogUtils.d(TAG, "turnOnDisplay: enter - acquireWakelock", new Object[0]);     // Catch: Throwable -> L9
        Trace.beginSection("turnOnDisplay");     // Catch: Throwable -> L9
        WakeupDisplayController r0 = this.mWakeupDisplayController;     // Catch: Throwable -> L9
        if (r0 == null) goto L6;
        r0.turnOnDisplay();     // Catch: Throwable -> L9
    L6:
        this.mWakeupTraceCollector.insertTimeTrace("LookAheadBufferTask:turnOnDisplay");     // Catch: Throwable -> L9
        Trace.endSection();     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void u(WakeupService r0, int r1) {
        r0.lambda$postReleaseSidExecutor$0(r1);
    }

    public static /* synthetic */ void v(WakeupService r0) {
        r0.lambda$onWakewordBusyFailOpen$9();
    }

    public static /* synthetic */ ExtendedSmMgr w(WakeupService r0) {
        return r0.lambda$onCreate$11();
    }

    public static /* synthetic */ void x(WakeupService r0) {
        r0.onWakewordBusyFailOpen();
    }

    public static /* synthetic */ void y(WakeupService r0, SoundTriggerWrapper.KeyphraseRecognitionEventWrapper r1, OpaqueDataHelper.BreathStatistics r2, String r3) {
        r0.lambda$processBreathRecognitionEvent$19(r1, r2, r3);
    }

    public static /* synthetic */ void z(WakeupService r0) {
        r0.lambda$onStartCommand$16();
    }

    static {
        TAG = "WakeupService";
        EMPTY_SCORE = new KWSScore();
    }

    private void checkModelExist() {
        String r0 = new SettingsModel(getApplicationContext(), SettingsDAO.NAME_HEYSNAPDRAGON_VOICE_MODEL).getCurrentSoundModel();
        String r1 = Global.getInstance().PATH_ROOT + "/" + r0;
        String r2 = TAG;
        LogUtils.d(r2, "----- check model exist ----- " + r1, new Object[0]);
        Context r3 = f.a;
        f.d(Global.KEY_WAKEUP_MODEL_NAME, r1);
        if (TextUtils.isEmpty(r0) == false) goto L5;
    L6:
        LogUtils.d(r2, "----- model not exist ----- " + r1, new Object[0]);
        return;
    L5:
        if (rna.c.c(r1) == false) goto L6;
    }

    private void destroyBreathSamiCore() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        SamiBreathWakeupEngine.INSTANCE.destroyHandle();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void destroySamiCore() {
        LogUtils.d(TAG, "destroySamiCore start", new Object[0]);
        Object r0 = this.mLock;
        monitor-enter(r0);
        cancelReleaseSidExecutor("destroySamiCore");     // Catch: Throwable -> L10
        SamiVoiceWakeupEngine.INSTANCE.release();     // Catch: Throwable -> L10
        if (this.mAecModel.isModelInit() == false) goto L7;
        this.mAecModel.destroy();     // Catch: Throwable -> L10
    L7:
        JniUtils.INSTANCE.memoryPurge();     // Catch: Throwable -> L10
        this.mSamiCoreInited = false;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void establishDefaultSession() {
        String r0 = TAG;
        LogUtils.d(r0, "========= establishDefaultSession", new Object[0]);
        if (this.mDestroyed == false) goto L7;
        LogUtils.d(r0, "establishDefaultSession skip, service destroyed", new Object[0]);
        return;
    L7:
        if (this.mVoiceSettingModel != null) goto L9;
        this.mVoiceSettingModel = new SettingsModel(getApplicationContext(), SettingsDAO.NAME_HEYSNAPDRAGON_VOICE_MODEL);
    L9:
        String r2 = this.mVoiceSettingModel.getCurrentSoundModel();
        LogUtils.d(r0, "========= current voice sound model " + r2, new Object[0]);
        boolean r7 = true;
        if (TextUtils.isEmpty(r2) == false) goto L12;
    L11:
        boolean r3 = true;
    L23:
        if (this.mBreathSettingModel != null) goto L25;
        this.mBreathSettingModel = new SettingsModel(getApplicationContext(), SettingsDAO.NAME_HEYSNAPDRAGON_BREATH_MODEL);
    L25:
        String r8 = this.mBreathSettingModel.getCurrentSoundModel();
        LogUtils.d(r0, "========= current breath sound model " + r8, new Object[0]);
        if (TextUtils.isEmpty(r8) == true) goto L38;
        LogUtils.d(r0, "========= wakeup status is  " + Global.sWakeupStatus + " and breath is " + Global.getBreathStatus(), new Object[0]);
        if (Global.getBreathStatus() == true) goto L31;
        LogUtils.d(r0, "=========breath status is off or not set , just return , not loading the sound model , and status is :" + Global.getBreathStatus(), new Object[0]);
        goto L38
    L31:
        ArrayList<IExtendedSmModel> r5 = Global.getInstance().getExtendedSmMgr().getSingleKeyphraseSoundModelList();
        if (r5 != null) goto L34;
    L37:
        LogUtils.d(r0, "========= getSingleKeyphraseSoundModelList is empty , return ", new Object[0]);
        goto L38
    L34:
        if (r5.isEmpty() == true) goto L37;
        LogUtils.d(r0, "------- breath onQuerySoundModelDone --------" + r8, new Object[0]);
        r7 = false;
    L38:
        LogUtils.d(r0, "------- request release all ------------", new Object[0]);
        if (r3 == true) goto L41;
        LogUtils.d(r0, "------- request voice ------------", new Object[0]);
        handleEstablishSessionReq(r2);
        initVoiceSamiCore();
    L41:
        if (r7 == true) goto L44;
        LogUtils.d(r0, "------- request breath ------------", new Object[0]);
        handleEstablishSessionReq(r8);
        initBreathSamiCore();
        return;
    L44:
        return;
    L12:
        LogUtils.d(r0, "========= wakeup status is  " + Global.sWakeupStatus + " and breath is " + Global.getBreathStatus(), new Object[0]);
        if (Global.sWakeupStatus == true) goto L15;
        LogUtils.d(r0, "========= wakeup status is off or not set , just return , not loading the sound model , and status is :" + Global.sWakeupStatus, new Object[0]);
        goto L11
    L15:
        ArrayList<IExtendedSmModel> r4 = Global.getInstance().getExtendedSmMgr().getSingleKeyphraseSoundModelList();
        if (r4 != null) goto L18;
    L21:
        LogUtils.d(r0, "========= getSingleKeyphraseSoundModelList is empty , return ", new Object[0]);
        goto L11
    L18:
        if (r4.isEmpty() == true) goto L21;
        LogUtils.d(r0, "-------voice onQuerySoundModelDone --------" + r2, new Object[0]);
        r3 = false;
        goto L23
    }

    private IExtendedSmModel getBreathExtendedSmModel() {
        if (this.extendedBreathSmModel != null) goto L7;
    L4:
        this.extendedBreathSmModel = this.mExtendedSmMgr.getSoundModel(SettingsDAO.NAME_HEYSNAPDRAGON_BREATH_MODEL);
        if (this.extendedBreathSmModel == null) goto L4;
    L7:
        return this.extendedBreathSmModel;
    }

    private IExtendedSmModel getVoiceExtendedSmModel() {
        if (this.extendedVoiceSmModel != null) goto L7;
    L4:
        this.extendedVoiceSmModel = this.mExtendedSmMgr.getSoundModel(SettingsDAO.NAME_HEYSNAPDRAGON_VOICE_MODEL);
        if (this.extendedVoiceSmModel == null) goto L4;
    L7:
        return this.extendedVoiceSmModel;
    }

    private void initBreathSamiCore() {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L27:
        th = move-exception;
        throw th;
    L5:
        if (this.mDestroyed == false) goto L30;
        LogUtils.d(TAG, "initBreathSamiCore ignore, service destroyed", new Object[0]);     // Catch: Throwable -> L27
        monitor-exit(r1);     // Catch: Throwable -> L27
        return;
    L30:
        String r0 = rna.b.i(getApplicationContext());     // Catch: Exception -> L11 Throwable -> L27
    L14:
        if (r0.isEmpty() == false) goto L19;
        LogUtils.d(TAG, "initBreathSamiCore ERROR !!! , caused by get Uid and did empty", new Object[0]);     // Catch: Throwable -> L27
        monitor-exit(r1);     // Catch: Throwable -> L27
        return;
    L19:
        if (this.mUUIDCached.isEmpty() == false) goto L22;
        this.mUUIDCached = r0;     // Catch: Throwable -> L27
    L22:
        if (SamiBreathWakeupEngine.INSTANCE.createHandle(getApplicationContext()) == 0) goto L24;
        LogUtils.d(TAG, "initBreathSamiCore end failed", new Object[0]);     // Catch: Throwable -> L27
    L25:
        monitor-exit(r1);     // Catch: Throwable -> L27
        return;
    L24:
        LogUtils.d(TAG, "initBreathSamiCore end success", new Object[0]);     // Catch: Throwable -> L27
    L11:
        e = move-exception;
        LogUtils.e(TAG, "initBreathSamiCore exception when get uuid :" + e.getMessage(), new Object[0]);     // Catch: Throwable -> L27
        e.printStackTrace();     // Catch: Throwable -> L27
        r0 = "";
        goto L14
    }

    private void initSamiCoreLocked() {
        Object r5 = this.mLock;
        monitor-enter(r5);
    L40:
        th = move-exception;
        throw th;
    L5:
        if (this.mDestroyed == false) goto L10;
        LogUtils.d(TAG, "initVoiceSamiCore ignore, service destroyed", new Object[0]);     // Catch: Throwable -> L40
        monitor-exit(r5);     // Catch: Throwable -> L40
        return;
    L10:
        if (Global.sWakeupStatus == true) goto L14;
        LogUtils.d(TAG, "initVoiceSamiCore ignore, wakeup is off", new Object[0]);     // Catch: Throwable -> L40
        monitor-exit(r5);     // Catch: Throwable -> L40
        return;
    L14:
        String r6 = TAG;     // Catch: Throwable -> L40
        LogUtils.d(r6, "initVoiceSamiCore mSamiCoreInited: " + this.mSamiCoreInited, new Object[0]);     // Catch: Throwable -> L40
        if (this.mSamiCoreInited == true) goto L38;
        LogUtils.d(r6, "initVoiceSamiCore start", new Object[0]);     // Catch: Throwable -> L40
        String r3 = rna.b.i(getApplicationContext());     // Catch: Exception -> L19 Throwable -> L40
    L22:
        if (r3.isEmpty() == false) goto L26;
        LogUtils.d(TAG, "initVoiceSamiCore ERROR !!! , caused by get Uid and did empty", new Object[0]);     // Catch: Throwable -> L40
        monitor-exit(r5);     // Catch: Throwable -> L40
        return;
    L26:
        SamiWakeupParamProvider.INSTANCE.prepareBaseSnapshot(getApplicationContext(), r3);     // Catch: Throwable -> L40
        SamiPhoneEnrollManager r4 = SamiPhoneEnrollManager.INSTANCE;     // Catch: Throwable -> L40
        int r7 = r4.migrateLegacyPhoneEnrollIfNeeded(getApplicationContext(), r3);     // Catch: Throwable -> L40
        String r8 = TAG;     // Catch: Throwable -> L40
        LogUtils.i(r8, "initVoiceSamiCore migrateLegacyPhoneEnrollIfNeeded ret=" + r7, new Object[0]);     // Catch: Throwable -> L40
        SamiPhoneEnrollManager.PhoneEnrollQueryStatus r2 = r4.queryPhoneEnrollStatusFromLocalDb(getApplicationContext(), r3);     // Catch: Throwable -> L40
        if (r2 == SamiPhoneEnrollManager.PhoneEnrollQueryStatus.ENROLLED) goto L29;
        LogUtils.e(r8, "voiceprint init/query failed during initSamiCore, enrollStatus=" + r2 + ", suppress toast and continue init, please check voiceprint db/model/account state", new Object[0]);     // Catch: Throwable -> L40
    L29:
        this.mUUIDCached = r3;     // Catch: Throwable -> L40
        int r1 = SamiVoiceWakeupEngine.INSTANCE.createHandle(getApplicationContext());     // Catch: Throwable -> L40
        if (r1 == 0) goto L34;
        LogUtils.e(r8, "initVoiceSamiCore SamiVoiceWakeupEngine.createHandle failed, ret " + r1, new Object[0]);     // Catch: Throwable -> L40
        monitor-exit(r5);     // Catch: Throwable -> L40
        return;
    L34:
        LogUtils.i(r8, "initVoiceSamiCore SamiVoiceWakeupEngine.createHandle success", new Object[0]);     // Catch: Throwable -> L40
        VoiceWakeupSidThresholdManager r0 = this.mVoiceWakeupSidThresholdManager;     // Catch: Throwable -> L40
        if (r0 == null) goto L37;
        r0.syncAndApply();     // Catch: Throwable -> L40
    L37:
        LogUtils.d(r8, "initVoiceSamiCore end", new Object[0]);     // Catch: Throwable -> L40
        this.mSamiCoreInited = true;     // Catch: Throwable -> L40
        checkWakeupSidLoadAfterInitProbe("initSamiCoreLocked");     // Catch: Throwable -> L40
    L19:
        e = move-exception;
        LogUtils.e(TAG, "initVoiceSamiCore exception when get uuid :" + e.getMessage(), new Object[0]);     // Catch: Throwable -> L40
        e.printStackTrace();     // Catch: Throwable -> L40
        r3 = "";
    L38:
        monitor-exit(r5);     // Catch: Throwable -> L40
    }

    private void initVoiceRequestFlag() {
        this.mVoiceRequest = new SettingsModel(getApplicationContext(), SettingsDAO.NAME_HEYSNAPDRAGON_VOICE_MODEL).getVoiceRequestEnabled() ? 1 : 0;
    }

    private void initVoiceSamiCore() {
        ThreadMethodProxy.start(new PthreadThreadV2(new n(this), "WakeupService"));
    }

    private /* synthetic */ void lambda$onBreathRecognition$18() {
        LogUtils.d(TAG, "onRecognition[Breath] : restart recognition caused by pocketMode is true ", new Object[0]);
        restartRecognition(SessionType.BREATH);
    }

    private /* synthetic */ void lambda$onWakewordBusyFailOpen$9() {
        if (this.mDestroyed == false) goto L6;
        return;
    L6:
        if (f.a(Global.SETTINGS_VOICE_ASSISTANT_WAKEUP_STATUS, 0) == 0) goto L9;
        LogUtils.i(TAG, "onWakewordBusyFailOpen skip: wakeup switch is on", new Object[0]);
        return;
    L9:
        SettingsModel r0 = this.mVoiceSettingModel;
        if (r0 != null) goto L13;
        LogUtils.w(TAG, "onWakewordBusyFailOpen skip: voice model null", new Object[0]);
        return;
    L13:
        String r1 = r0.getCurrentSoundModel();
        if (TextUtils.isEmpty(r1) == false) goto L16;
        return;
    L16:
        ArrayList<IExtendedSmModel> r2 = Global.getInstance().getExtendedSmMgr().getSingleKeyphraseSoundModelList();
        if (r2 != null) goto L19;
        return;
    L19:
        if (r2.isEmpty() == true) goto L24;
        handleTerminateSessionReq(r1);
        destroySamiCore();
        this.mPendingTerminateRequest = false;
        LogUtils.w(TAG, "onWakewordBusyFailOpen terminate + destroySamiCore done", new Object[0]);
        return;
    }

    private void markVoiceStage2Finished() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mVoiceStage2InFlight.decrementAndGet();     // Catch: Throwable -> L12
        if (r1 >= 0) goto L7;
        this.mVoiceStage2InFlight.set(0);     // Catch: Throwable -> L12
        r1 = 0;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L12
        LogUtils.d(TAG, "markVoiceStage2Finished inFlight=" + r1, new Object[0]);
        if (r1 != 0) goto L17;
        postReleaseSidExecutor("voice_stage2_finished");
        return;
    L17:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private void markVoiceStage2Started() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mVoiceStage2InFlight.incrementAndGet();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        cancelReleaseSidExecutor("voice_stage2_started");
        LogUtils.d(TAG, "markVoiceStage2Started inFlight=" + r1, new Object[0]);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void onAssistantServiceCreated() {
        LogUtils.d(TAG, "onAssistantServiceCreated", new Object[0]);
        HotwordRecorderMgr.forceStopStream();
    }

    private void onAudioServerUp() {
        String r0 = TAG;
        LogUtils.d(r0, "Audio server is up switch voice:" + Global.sWakeupStatus + " breath:" + Global.getBreathStatus(), new Object[0]);
        SettingsModel r1 = this.mVoiceSettingModel;
        if (r1 != null) goto L6;
        LogUtils.d(r0, "onAudioServerUp mVoiceSettingModel is null , just return ", new Object[0]);
        return;
    L6:
        String r2 = r1.getCurrentSoundModel();
        LogUtils.d(r0, "onAudioServerUp current sound model " + r2, new Object[0]);
        if (TextUtils.isEmpty(r2) == false) goto L9;
        return;
    L9:
        ArrayList<IExtendedSmModel> r3 = Global.getInstance().getExtendedSmMgr().getSingleKeyphraseSoundModelList();
        LogUtils.d(r0, "onAudioServerUp mListData: " + r3, new Object[0]);
        if (r3 != null) goto L12;
        return;
    L12:
        if (r3.isEmpty() == true) goto L36;
        LogUtils.d(r0, "onAudioServerUp check sWakeupStatus: " + Global.sWakeupStatus, new Object[0]);
        if (Global.sWakeupStatus == false) goto L17;
        handleEstablishSessionReq(r2);
        initVoiceSamiCore();
    L17:
        SettingsModel r4 = this.mBreathSettingModel;
        if (r4 != null) goto L21;
        LogUtils.d(r0, "onAudioServerUp mBreathSettingModel is null , just return ", new Object[0]);
        return;
    L21:
        String r5 = r4.getCurrentSoundModel();
        LogUtils.d(r0, "onAudioServerUp current breath sound model " + r5, new Object[0]);
        if (TextUtils.isEmpty(r5) == false) goto L24;
        return;
    L24:
        ArrayList<IExtendedSmModel> r6 = Global.getInstance().getExtendedSmMgr().getSingleKeyphraseSoundModelList();
        LogUtils.d(r0, "onAudioServerUp mListData: " + r6, new Object[0]);
        if (r6 != null) goto L27;
        return;
    L27:
        if (r6.isEmpty() == true) goto L37;
        LogUtils.d(r0, "onAudioServerUp check sBreathStatus: " + Global.getBreathStatus(), new Object[0]);
        if (Global.getBreathStatus() == false) goto L35;
        handleEstablishSessionReq(r5);
        initBreathSamiCore();
        return;
    L35:
        return;
    L37:
        return;
    }

    private void onWakewordBusyFailOpen() {
        LogUtils.w(TAG, "onWakewordBusyFailOpen enter, pendingTerminate=" + this.mPendingTerminateRequest, new Object[0]);
        this.mWakeWordSourceBusy = false;
        if (this.mPendingTerminateRequest == true) goto L5;
        return;
    L5:
        Handler r0 = this.mSettingChangeHandler;
        g r1 = new g(this);
        if (r0 == null) goto L8;
        r0.post(r1);
        return;
    L8:
        r1.run();
    }

    private void reloadVoiceSamiCore() {
        String r0 = TAG;
        LogUtils.d(r0, "reloadVoiceSamiCore START due to model update ♻️", new Object[0]);
        int r2 = forceReEnrollWakeupSid("reloadVoiceSamiCore");
        if (r2 == 0) goto L6;
        LogUtils.e(r0, "reloadVoiceSamiCore skip reload: forceReEnroll failed ret=" + r2, new Object[0]);
        return;
    L6:
        destroySamiCore();
        initSamiCoreLocked();
        LogUtils.d(r0, "reloadVoiceSamiCore END due to model update", new Object[0]);
    }

    private void triggerAssistantOnce() {
        HotwordRecorderMgr r0 = HotwordRecorderMgr.INSTANCE;
        if (r0.isVoiceInUse() == false) goto L5;
    L9:
        LogUtils.d(TAG, "triggerAssistantOnce skipped because hotword recorder is in use", new Object[0]);
        return;
    L5:
        if (r0.isBreathInUse() == true) goto L9;
        LogUtils.d(TAG, "triggerAssistantOnce", new Object[0]);
        this.mWakeupClientRegistry.sendResponseToAllClients(4356, null, null);
    }

    @Override // android.app.Service
    public void onCreate() {
        String r0 = TAG;
        LogUtils.d(r0, "@@@@@@==onCreate of WakeupService Lifecycle==@@@@@@  userID:" + KtUtils.myUserId(), new Object[0]);
        if (t9a.b.a().e() == false) goto L6;
        LogUtils.w(r0, "WakeupService disabled, emulator os", new Object[0]);
        stopSelf();
        return;
    L6:
        sCurrentService = this;
        SvaNotificationListenerService.requestRebind(getApplicationContext());
        Flipped.invokeHiddenApiRestrictions();
        f.a = this;
        WakeupUploadManager.init(getApplicationContext());
        refreshReporterPrivacySnapshot("wakeup_service_create");
        InteractorReportInitializer.initIfNeeded();
        AhmClient.INSTANCE.open();     // Catch: Exception -> L9
    L11:
        this.mServerMessenger = new Messenger(this.mHandler);
        Global.getInstance().doWarmUp();
        BluetoothDeviceManager r1 = BluetoothDeviceManager.INSTANCE;
        r1.init(getApplicationContext());
        this.mSharedPreferences = getSharedPreferences(Global.SHARED_WAKEUP_PREFERENCES_NAME, 0);
        this.mVoiceWakeupSidThresholdManager = new VoiceWakeupSidThresholdManager(getApplicationContext());
        rna.c.a(Global.getInstance().PATH_ROOT);
        rna.c.a(Global.getInstance().PATH_TRAINING_RECORDINGS);
        rna.c.a(Global.getInstance().PATH_VOICE_REQUESTS);
        this.mExtendedSmMgr = Global.getInstance().getExtendedSmMgr();
        this.mPhoneModel = Build.MODEL;
        String r2 = TAG;
        LogUtils.d(r2, "onCreate: build model name = " + this.mPhoneModel, new Object[0]);
        Context r3 = getApplicationContext();
        VoiceWakeupSession r4 = new VoiceWakeupSession(r3);
        this.mVoiceWakeupSession = r4;
        r4.addWakeupListener(this);
        BreathWakeupSession r5 = new BreathWakeupSession(r3);
        this.mBreathWakeupSession = r5;
        r5.addWakeupListener(this);
        this.mSessions.clear();
        this.mSessions.add(this.mVoiceWakeupSession);
        this.mSessions.add(this.mBreathWakeupSession);
        checkModelExist();
        ensureSettingChangeHandler();
        final SoundModelManager r6 = new SoundModelManager(new a0(this), this, new b0(this));
        this.mSoundModelManager = r6;
        Handler r7 = this.mSettingChangeHandler;
        if (r7 == null) goto L14;
        r7.post(new c0(this, r6));
    L15:
        PowerManager r8 = (PowerManager) getSystemService("power");
        this.mPowerManager = r8;
        PowerManager.WakeLock r9 = r8.newWakeLock(268435466, "AssistantWakeLock:TurnOnScreen section 2");
        this.mWakeLock = r9;
        this.mWakeupDisplayController = new WakeupDisplayController(r2, this.mPowerManager, r9, DISPLAY_ON_DURATION);
        this.mSupportStage2Bypass = getResources().getBoolean(2131034127);
        PthreadHandlerThreadV2 r10 = new PthreadHandlerThreadV2("PowerUpScreen");
        ThreadMethodProxy.start(r10);
        ISvaFrameworkKt.getSvaFrameworkDelegate().setPowerUpHandler(new Handler(r10.getLooper()));
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 26) goto L18;
        HotwordUtils.prepare();
    L18:
        final SvaSdkDatabase r12 = SvaSdkDatabase.Companion.instance(getApplicationContext());
        if (r11 < 24) goto L21;
        ThreadMethodProxy.start(new PthreadThreadV2(new b(r12), "WakeupService"));
    L21:
        this.mBooster = new BoostFrameworkHelper(this);
        if (Global.sWakeupStatus == false) goto L24;
        initVoiceSamiCore();
    L24:
        WakeupAudioServerMonitor r13 = new WakeupAudioServerMonitor(getApplicationContext(), new c(this));
        this.mAudioServerMonitor = r13;
        r13.register();
        ensureSettingChangeHandler();
        WakeupSettingBus.INSTANCE.register(this.mStatusChangeListener);
        if (Global.getBreathStatus() == true) goto L27;
    L29:
        AppOpsManager r14 = (AppOpsManager) getSystemService("appops");
        this.mAppOpsManager = r14;
        if (r14 == null) goto L32;
        this.mRecordAudioOpChangedListener = new AnonymousClass3(this);
        this.mAppOpsManager.startWatchingMode("android:record_audio", getPackageName(), this.mRecordAudioOpChangedListener);
    L32:
        TrackerManager r15 = TrackerManager.INSTANCE;
        r15.initLocal(getApplicationContext());
        r15.registerMessengerCallback(this.messageCallback);
        MainProcessKeepAliveBinder.INSTANCE.init(getApplicationContext());
        TemporaryWakeupGateManager.INSTANCE.setWakewordBusyFailOpenCallback(new d(this));
        LightUpManager.INSTANCE.init(getApplicationContext());
        LogUtils.d(r2, "Support features :  [booster]:true [fingerPrint]:false [traceSection]:true [stage2-byPass]:" + this.mSupportStage2Bypass, new Object[0]);
        LogUtils.d(r2, "Manufacture Features :  [breathWakeup]:" + ManufactureFeatures.isFeatureBreathWakeupEnable() + " [voiceCommandFaster]:" + ManufactureFeatures.isFeatureVoiceCommandFasterFeatureEnable() + " [vipPid]:" + ManufactureFeatures.isFeatureVipPidEnable(), new Object[0]);
        StringBuilder r16 = new StringBuilder("Switch On/Off :  [wakeupStatus]:");
        r16.append(Global.sWakeupStatus);
        r16.append(" [breathStatus]:");
        r16.append(Global.getBreathStatus());
        LogUtils.d(r2, r16.toString(), new Object[0]);
        if (Global.sWakeupStatus == true) goto L35;
        SamiPhoneEnrollManager r17 = SamiPhoneEnrollManager.INSTANCE;
        SamiPhoneEnrollManager.triggerMigrationAsync(getApplicationContext(), new e(this));
    L35:
        LogUtils.d(r2, "onCreate End", new Object[0]);
        r1.start();
        return;
    L27:
        if (ManufactureFeatures.isFeatureBreathWakeupEnable() == false) goto L29;
        initBreathSamiCoreAsync("onCreate");
        goto L29
    L14:
        LogUtils.w(r2, "setting change handler unavailable, fallback initSoundModelAsync on current thread", new Object[0]);
        initVoiceRequestFlag();
        r6.initSoundModelAsync();
    L9:
        e = move-exception;
        LogUtils.e(TAG, "AhmClient open failed: " + e.getMessage(), new Object[0]);
        goto L11
    }

    @Override // android.app.Service
    public void onDestroy() {
        LogUtils.v(TAG, "onDestroy: enter of WakeupService Lifecycle userID:" + KtUtils.myUserId(), new Object[0]);
        this.mDestroyed = true;
        if (sCurrentService != this) goto L5;
        sCurrentService = null;
    L5:
        WakeupDisplayController r1 = this.mWakeupDisplayController;
        if (r1 == null) goto L8;
        r1.release();
        this.mWakeupDisplayController = null;
    L8:
        this.mWakeLock = null;
        LookAheadBufferTask r2 = this.mLABTask;
        if (r2 != null) goto L11;
    L13:
        SoundModelManager r3 = this.mSoundModelManager;
        if (r3 != null) goto L16;
    L18:
        RestartRecognitionTask r4 = this.mRestartRecognitionTask;
        if (r4 != null) goto L21;
    L23:
        cancelReleaseSidExecutor("WakeupService onDestroy");
        if (this.mSessions.isEmpty() == false) goto L26;
    L28:
        WakeupAudioServerMonitor r5 = this.mAudioServerMonitor;
        if (r5 == null) goto L31;
        r5.clear();
        this.mAudioServerMonitor = null;
    L31:
        monitor-enter(this);
        this.mDestroyed = true;     // Catch: Throwable -> L57
        this.mRecorderBusyRetrySmName = null;     // Catch: Throwable -> L57
        this.mRecorderBusyRetryCount = 0;     // Catch: Throwable -> L57
        this.mPendingStopGeneration = -1;     // Catch: Throwable -> L57
        if (this.mAudioRecordingGuard == null) goto L35;
        this.mAudioRecordingGuard.release();     // Catch: Throwable -> L57
        this.mAudioRecordingGuard = null;     // Catch: Throwable -> L57
    L35:
        Handler r0 = this.mSettingChangeHandler;     // Catch: Throwable -> L57
        if (r0 == null) goto L38;
        r0.removeCallbacksAndMessages(null);     // Catch: Throwable -> L57
        this.mSettingChangeHandler = null;     // Catch: Throwable -> L57
    L38:
        HandlerThread r6 = this.mSettingChangeHandlerThread;     // Catch: Throwable -> L57
        if (r6 == null) goto L41;
        r6.quitSafely();     // Catch: Throwable -> L57
        this.mSettingChangeHandlerThread = null;     // Catch: Throwable -> L57
    L41:
        monitor-exit(this);     // Catch: Throwable -> L57
        this.mH.removeCallbacks(this.mDelayedStopRunnable);
        this.mH.removeCallbacks(this.destroyBreathSamiCoreRunnable);
        AhmClient.INSTANCE.close();     // Catch: Exception -> L45
    L47:
        destroyBreathSamiCore();
        WakeupSettingBus.INSTANCE.unregister(this.mStatusChangeListener);
        TrackerManager.INSTANCE.unregisterMessengerCallback(this.messageCallback);
        MainProcessKeepAliveBinder.INSTANCE.release();
        TemporaryWakeupGateManager.INSTANCE.setWakewordBusyFailOpenCallback(null);
        AppOpsManager r7 = this.mAppOpsManager;
        if (r7 == null) goto L52;
        AppOpsManager.OnOpChangedListener r8 = this.mRecordAudioOpChangedListener;
        if (r8 == null) goto L52;
        r7.stopWatchingMode(r8);
        this.mRecordAudioOpChangedListener = null;
    L52:
        this.mAppOpsManager = null;
        Handler r9 = this.mHandler;
        if (r9 == null) goto L55;
        r9.removeCallbacksAndMessages(null);
    L55:
        this.mWakeupClientRegistry.clear();
        SamiVoiceWakeupEngine.INSTANCE.release();
        SamiPhoneEnrollManager.INSTANCE.releasePhoneEnrollHandle("WakeupService onDestroy");
        BluetoothDeviceManager.INSTANCE.stop();
        super.onDestroy();
        return;
    L45:
        e = move-exception;
        LogUtils.e(TAG, "AhmClient close failed: " + e.getMessage(), new Object[0]);
    L57:
        th = move-exception;
        throw th;
    L26:
        if (Build.VERSION.SDK_INT < 24) goto L28;
        this.mSessions.forEach(new u(this));
        goto L28
    L21:
        if (r4.isCancelled() == true) goto L23;
        this.mRestartRecognitionTask.cancel(true);
        this.mRestartRecognitionTask = null;
        goto L23
    L16:
        if (r3.isCanceled() == true) goto L18;
        this.mSoundModelManager.cancel();
        this.mSoundModelManager = null;
        goto L18
    L11:
        if (r2.isCancelled() == true) goto L13;
        this.mLABTask.cancel(true);
        this.mLABTask = null;
        goto L13
    }

    public WakeupService() {
        WakeupTraceCollector r0 = new WakeupTraceCollector();
        this.mWakeupTraceCollector = r0;
        this.mStage1WakeupDuration = r0.getStage1WakeupDuration();
        this.mStage2WakeupDuration = r0.getStage2WakeupDuration();
        this.mStage2WakeupDetail = r0.getStage2WakeupDetail();
        String r2 = TAG;
        this.mWakeupClientRegistry = new WakeupClientRegistry(r2);
        this.mHasVoiceStage1AfterBoot = new AtomicBoolean(false);
        this.mSessions = new ArrayList();
        this.needVoiceRestart = false;
        this.needBreathRestart = false;
        this.mPhoneModel = "";
        this.mH = new Handler(Looper.getMainLooper());
        this.mPendingStopGeneration = -1;
        this.mDelayedStopRunnable = new AnonymousClass1(this);
        this.mVoiceStage2InFlight = new AtomicInteger(0);
        this.miscMap = r0.getMiscMap();
        this.mAecModel = new AecModel();
        this.mVoiceRequest = -1;
        this.mLastNoRecordAudioPermissionToastTimeMs = 0;
        this.mLastSuppressInCallToastTimeMs = 0;
        this.mPendingTerminateRequest = false;
        this.mWakeWordSourceBusy = false;
        this.mUUIDCached = "";
        this.mDeviceId = "";
        this.mStatusChangeListener = new h(this);
        this.messageCallback = new i(this);
        this.mHandler = new Handler(new AnonymousClass2(this));
        this.mSamiCoreInited = false;
        this.mLock = new String("sami-core-lock");
        this.mSidReloadAfterReEnrollPending = false;
        this.mSidRecoveryInProgress = new AtomicBoolean(false);
        this.destroyBreathSamiCoreRunnable = new j(this);
        LogUtils.d(r2, "WakeupService constructor -----> test feedback broadcast", new Object[0]);
    }

    private void handleRecordAudioPermissionChanged() {
        boolean r1 = true;
        if (ContextCompat.checkSelfPermission(getApplicationContext(), "android.permission.RECORD_AUDIO") != 0) goto L5;
        boolean r0 = true;
    L6:
        String r3 = TAG;
        LogUtils.d(r3, "handleRecordAudioPermissionChanged granted=" + r0 + ", wakeupStatus=" + Global.sWakeupStatus + ", breathStatus=" + Global.getBreathStatus(), new Object[0]);
        if (this.mVoiceSettingModel != null) goto L10;
        this.mVoiceSettingModel = new SettingsModel(getApplicationContext(), SettingsDAO.NAME_HEYSNAPDRAGON_VOICE_MODEL);
    L10:
        if (this.mBreathSettingModel != null) goto L12;
        this.mBreathSettingModel = new SettingsModel(getApplicationContext(), SettingsDAO.NAME_HEYSNAPDRAGON_BREATH_MODEL);
    L12:
        String r4 = this.mVoiceSettingModel.getCurrentSoundModel();
        String r5 = this.mBreathSettingModel.getCurrentSoundModel();
        if (r0 == true) goto L26;
        if (Global.sWakeupStatus == false) goto L20;
        if (TextUtils.isEmpty(r4) == true) goto L20;
        handleTerminateSessionReq(r4);
        destroySamiCore();
    L20:
        if (Global.getBreathStatus() == true) goto L22;
        return;
    L22:
        if (TextUtils.isEmpty(r5) == true) goto L57;
        handleTerminateSessionReq(r5);
        destroyBreathSamiCore();
        return;
    L57:
        return;
    L26:
        if (this.mWakeWordSourceBusy == false) goto L30;
        LogUtils.d(r3, "handleRecordAudioPermissionChanged ignored by wakeWord busy", new Object[0]);
        return;
    L30:
        if (Global.sWakeupStatus == false) goto L43;
        if (TextUtils.isEmpty(r4) == true) goto L43;
        IExtendedSmModel r2 = Global.getInstance().getExtendedSmMgr().getSoundModel(r4);
        if (r2 != null) goto L36;
    L38:
        boolean r6 = false;
    L39:
        if (r6 == false) goto L41;
        LogUtils.d(r3, "handleRecordAudioPermissionChanged voice model already started", new Object[0]);
        goto L43
    L41:
        handleEstablishSessionReq(r4);
        initVoiceSamiCore();
        goto L43
    L36:
        if (r2.getSessionStatus() != IExtendedSmModel.SessionStatus.STARTED) goto L38;
        r6 = true;
    L43:
        if (Global.getBreathStatus() == true) goto L45;
        return;
    L45:
        if (TextUtils.isEmpty(r5) == true) goto L59;
        IExtendedSmModel r7 = Global.getInstance().getExtendedSmMgr().getSoundModel(r5);
        if (r7 != null) goto L49;
    L51:
        r1 = false;
    L52:
        if (r1 == false) goto L54;
        LogUtils.d(r3, "handleRecordAudioPermissionChanged breath model already started", new Object[0]);
        return;
    L54:
        handleEstablishSessionReq(r5);
        initBreathSamiCore();
        return;
    L49:
        if (r7.getSessionStatus() != IExtendedSmModel.SessionStatus.STARTED) goto L51;
    L59:
        return;
    L5:
        r0 = false;
        goto L6
    }

    private /* synthetic */ String lambda$onCreate$15() {
        return rna.b.i(getApplicationContext());
    }

    private /* synthetic */ void lambda$onStartCommand$16() {
        destroySamiCore();
        initVoiceSamiCore();
    }

    private /* synthetic */ void lambda$showNoRecordAudioPermissionToastOnce$1() {
        Toast.makeText(getApplicationContext(), getResources().getText(2131914222), 0).show();
    }

    private /* synthetic */ void lambda$showSuppressInCallToastOnce$2() {
        Toast.makeText(getApplicationContext(), getResources().getText(2131914242), 0).show();
    }

    private void showNoRecordAudioPermissionToastOnce() {
        long r0 = SystemClock.elapsedRealtime();
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L5:
        if ((r0 - this.mLastNoRecordAudioPermissionToastTimeMs) >= NO_RECORD_AUDIO_PERMISSION_TOAST_INTERVAL_MS) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L8:
        this.mLastNoRecordAudioPermissionToastTimeMs = r0;     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        this.mH.post(new p(this));
    }

    private void showSuppressInCallToastOnce() {
        long r0 = SystemClock.elapsedRealtime();
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L5:
        if ((r0 - this.mLastSuppressInCallToastTimeMs) >= 3000) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L8:
        this.mLastSuppressInCallToastTimeMs = r0;     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        this.mH.post(new l(this));
    }

    public static /* synthetic */ String access$100() {
        return TAG;
    }

    public static /* synthetic */ KWSScore access$3200() {
        return EMPTY_SCORE;
    }

    private /* synthetic */ void lambda$initVoiceSamiCore$21() {
        initSamiCoreLocked();
    }

    private /* synthetic */ ExtendedSmMgr lambda$onCreate$11() {
        return this.mExtendedSmMgr;
    }

    public static /* synthetic */ boolean access$000(WakeupService r0) {
        return r0.mDestroyed;
    }

    public static /* synthetic */ void access$1000(WakeupService r0) {
        r0.handleRecordAudioPermissionChanged();
    }

    public static /* synthetic */ void access$1100(WakeupService r0) {
        r0.markVoiceStage2Started();
    }

    public static /* synthetic */ void access$1200(WakeupService r0) {
        r0.initVoiceSamiCore();
    }

    public static /* synthetic */ PowerManager access$1300(WakeupService r0) {
        return r0.mPowerManager;
    }

    public static /* synthetic */ Map access$1400(WakeupService r0) {
        return r0.miscMap;
    }

    public static /* synthetic */ String access$1600(WakeupService r0) {
        return r0.mUUIDCached;
    }

    public static /* synthetic */ AtomicBoolean access$1700(WakeupService r0) {
        return r0.mHasVoiceStage1AfterBoot;
    }

    public static /* synthetic */ String access$1800(WakeupService r0) {
        return r0.mDeviceId;
    }

    public static /* synthetic */ boolean access$1900(WakeupService r0) {
        return r0.mSamiCoreInited;
    }

    public static /* synthetic */ Messenger access$200(WakeupService r0) {
        return r0.mServerMessenger;
    }

    public static /* synthetic */ void access$2000(WakeupService r0) {
        r0.initSamiCoreLocked();
    }

    public static /* synthetic */ BoostFrameworkHelper access$2100(WakeupService r0) {
        return r0.mBooster;
    }

    public static /* synthetic */ WakeupTraceCollector access$2200(WakeupService r0) {
        return r0.mWakeupTraceCollector;
    }

    public static /* synthetic */ IWakeupSession access$2300(WakeupService r0) {
        return r0.mVoiceWakeupSession;
    }

    public static /* synthetic */ WakeupToken access$2500(WakeupService r0) {
        return r0.mWakeupToken;
    }

    public static /* synthetic */ Object access$2600(WakeupService r0) {
        return r0.mLock;
    }

    public static /* synthetic */ AecModel access$2800(WakeupService r0) {
        return r0.mAecModel;
    }

    public static /* synthetic */ int access$300(WakeupService r0) {
        return r0.mPendingStopGeneration;
    }

    public static /* synthetic */ long access$3400(WakeupService r2) {
        return r2.mEndTime;
    }

    public static /* synthetic */ long access$3500(WakeupService r2) {
        return r2.mStartTime;
    }

    public static /* synthetic */ void access$3700(WakeupService r0) {
        r0.turnOnDisplay();
    }

    public static /* synthetic */ List access$3800(WakeupService r0) {
        return r0.mStage1WakeupDuration;
    }

    public static /* synthetic */ List access$3900(WakeupService r0) {
        return r0.mStage2WakeupDuration;
    }

    public static /* synthetic */ int access$400(WakeupService r0) {
        return r0.mBindGeneration;
    }

    public static /* synthetic */ List access$4000(WakeupService r0) {
        return r0.mStage2WakeupDetail;
    }

    public static /* synthetic */ RestartRecognitionTask access$4300(WakeupService r0) {
        return r0.mRestartRecognitionTask;
    }

    public static /* synthetic */ void access$4400(WakeupService r0) {
        r0.reloadVoiceSamiCore();
    }

    public static /* synthetic */ void access$4500(WakeupService r0) {
        r0.markVoiceStage2Finished();
    }

    public static /* synthetic */ IWakeupSession access$4600(WakeupService r0) {
        return r0.mBreathWakeupSession;
    }

    public static /* synthetic */ long access$4900(WakeupService r2) {
        return r2.breathStartTime;
    }

    public static /* synthetic */ WakeupClientRegistry access$600(WakeupService r0) {
        return r0.mWakeupClientRegistry;
    }

    public static /* synthetic */ Handler access$900(WakeupService r0) {
        return r0.mH;
    }

    private void cancelReleaseSidExecutor(String r4) {
        Handler r0 = this.mSettingChangeHandler;
        monitor-enter(this);
        this.mReleaseSidExecutorGeneration++;     // Catch: Throwable -> L11
        Runnable r1 = this.mReleaseSidExecutorRunnable;     // Catch: Throwable -> L11
        this.mReleaseSidExecutorRunnable = null;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        if (r0 == null) goto L9;
        if (r1 == null) goto L9;
        r0.removeCallbacks(r1);
    L9:
        LogUtils.d(TAG, "cancelReleaseSidExecutor reason=" + r4, new Object[0]);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private boolean checkWakeupSidLoadAfterInit(String r2) {
        return handleWakeupSidLoadAfterInit(r2, SamiVoiceWakeupEngine.INSTANCE.init());
    }

    private boolean checkWakeupSidLoadAfterInitProbe(String r3) {
        int r0 = SamiVoiceWakeupEngine.INSTANCE.init();
        boolean r1 = handleWakeupSidLoadAfterInit(r3, r0);
        if (r1 == false) goto L6;
        if (r0 != 0) goto L6;
        releaseSidExecutorAfterInitProbeIfVoiceIdle(r3);
    L6:
        return r1;
    }

    private void clearRecorderBusyRetryState(String r2) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (TextUtils.equals(this.mRecorderBusyRetrySmName, r2) == false) goto L6;
        this.mRecorderBusyRetrySmName = null;     // Catch: Throwable -> L8
        this.mRecorderBusyRetryCount = 0;     // Catch: Throwable -> L8
        this.mRecorderBusyRetryGeneration++;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
    }

    private long extractHostGeneration(Message r4) {
        if (r4 != null) goto L4;
        return 0;
    L4:
        if (r4.getData() != null) goto L7;
        return 0;
    L7:
        return r4.getData().getLong("ipc_generation", r4.arg2);
    }

    private int forceReEnrollWakeupSid(String r6) {
        String r0 = TAG;
        LogUtils.e(r0, "forceReEnrollWakeupSid reason=" + r6, new Object[0]);
        int r1 = SamiPhoneEnrollManager.INSTANCE.forceReEnrollWakeupSid(getApplicationContext(), this.mUUIDCached, r6);
        LogUtils.i(r0, "forceReEnrollWakeupSid end reason=" + r6 + " ret=" + r1, new Object[0]);
        return r1;
    }

    private void handleClientDeath(IBinder r3) {
        LogUtils.d(TAG, "handleClientDeath", new Object[0]);
        TrackAPI.trackWakeupInterrupted("stage2_entry", "binder_died");
        Process.killProcess(Process.myPid());
    }

    private void handleEstablishSessionReq(String r8) {
        String r0 = TAG;
        LogUtils.d(r0, "handleEstablishSessionReq: smFullName = " + r8, new Object[0]);
        if (r8 != null) goto L7;
        LogUtils.d(r0, "handleEstablishSessionReq: invalid params", new Object[0]);
        return;
    L7:
        if (this.mDestroyed == false) goto L10;
        LogUtils.d(r0, "handleEstablishSessionReq: service destroyed, skip", new Object[0]);
        return;
    L10:
        SessionType r1 = KtUtils.findSessionTypeBySmName(r8);
        SessionType r3 = SessionType.VOICE;
        if (r1 != r3) goto L13;
        IWakeupSession r4 = this.mVoiceWakeupSession;
    L14:
        r4.releaseSvaSession(r8);
        if (ContextCompat.checkSelfPermission(getApplicationContext(), "android.permission.RECORD_AUDIO") != 0) goto L17;
        boolean r5 = true;
    L18:
        if (r5 == true) goto L20;
        LogUtils.d(r0, "Try to set wakeup status on, but no record audio permission granted!", new Object[0]);
        int r6 = IWakeupSessionConstant.RC_PERMISSION_DENIED;
    L21:
        LogUtils.d(r0, "handleEstablishSessionReq: results = " + r6, new Object[0]);
        if (r6 == (-16)) goto L24;
        clearRecorderBusyRetryState(r8);
        if (IWakeupSessionConstant.RC_PERMISSION_DENIED != r6) goto L57;
        if (r1 != r3) goto L52;
        boolean r9 = Global.sWakeupStatus;
    L53:
        if (r9 == false) goto L58;
        showNoRecordAudioPermissionToastOnce();
        return;
    L58:
        return;
    L52:
        r9 = Global.getBreathStatus();
        goto L53
    L57:
        return;
    L24:
        if (increaseRecorderBusyRetryCount(r8) == true) goto L27;
        LogUtils.w(r0, "handleEstablishSessionReq: recorder busy retry exhausted, smFullName=" + r8, new Object[0]);
        clearRecorderBusyRetryState(r8);
        return;
    L27:
        monitor-enter(this);
    L45:
        th = move-exception;
        throw th;
    L29:
        if (this.mDestroyed == false) goto L34;
        LogUtils.d(r0, "handleEstablishSessionReq: service destroyed before guard create, skip", new Object[0]);     // Catch: Throwable -> L45
        monitor-exit(this);     // Catch: Throwable -> L45
        return;
    L34:
        if (this.mAudioRecordingGuard != null) goto L41;
        ensureSettingChangeHandler();     // Catch: Throwable -> L45
        if (this.mSettingChangeHandler != null) goto L40;
        LogUtils.w(r0, "handleEstablishSessionReq: setting change handler unavailable, skip", new Object[0]);     // Catch: Throwable -> L45
        monitor-exit(this);     // Catch: Throwable -> L45
        return;
    L40:
        this.mAudioRecordingGuard = new WakeupAudioRecordingGuard(getApplicationContext(), new q(this), this.mSettingChangeHandler);     // Catch: Throwable -> L45
    L41:
        WakeupAudioRecordingGuard r2 = this.mAudioRecordingGuard;     // Catch: Throwable -> L45
        monitor-exit(this);     // Catch: Throwable -> L45
        r2.waitUntilRecordingReleased(r8);
        return;
    L20:
        r6 = r4.establishSvaSession(r8);
        goto L21
    L17:
        r5 = false;
        goto L18
    L13:
        r4 = this.mBreathWakeupSession;
        goto L14
    }

    private void handleTerminateSessionReq(String r6) {
        String r0 = TAG;
        LogUtils.d(r0, "handleTerminateSessionReq: smFullName = " + r6, new Object[0]);
        if (r6 != null) goto L6;
        LogUtils.d(r0, "handleTerminateSessionReq: invalid params", new Object[0]);
        return;
    L6:
        clearRecorderBusyRetryState(r6);
        SessionType r1 = KtUtils.findSessionTypeBySmName(r6);
        LogUtils.d(r0, "handleTerminateSessionReq: release recorder", new Object[0]);
        if (Build.VERSION.SDK_INT < 26) goto L10;
        HotwordUtils.releaseRecorder();
    L10:
        if (r1 != SessionType.VOICE) goto L12;
        int r7 = this.mVoiceWakeupSession.terminateSvaSession(r6);
    L13:
        LogUtils.d(r0, "handleTerminateSessionReq: results = " + r7, new Object[0]);
        return;
    L12:
        r7 = this.mBreathWakeupSession.terminateSvaSession(r6);
        goto L13
    }

    private void handleUploadBreathDataOnFeedback(String r4) {
        if (f.a("breath_data_upload_status", -1) == 1) goto L6;
        LogUtils.i(TAG, "handleUploadBreathDataOnFeedback skipped, breath data upload switch is off, action = " + r4, new Object[0]);
        return;
    L6:
        SamiWakeupParamProvider.INSTANCE.triggerBreathFeedbackUpload("assistant_feedback:" + r4);
    }

    private boolean increaseRecorderBusyRetryCount(String r3) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (TextUtils.equals(this.mRecorderBusyRetrySmName, r3) == true) goto L6;
        this.mRecorderBusyRetrySmName = r3;     // Catch: Throwable -> L13
        this.mRecorderBusyRetryCount = 0;     // Catch: Throwable -> L13
    L6:
        int r4 = this.mRecorderBusyRetryCount;     // Catch: Throwable -> L13
        if (r4 < 6) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L13
        return false;
    L10:
        this.mRecorderBusyRetryCount = r4 + 1;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return true;
    }

    private void initBreathSamiCoreAsync(String r4) {
        ensureSettingChangeHandler();
        Handler r0 = this.mSettingChangeHandler;
        if (r0 != null) goto L6;
        LogUtils.w(TAG, "initBreathSamiCoreAsync ignored, handler is null reason=" + r4, new Object[0]);
        return;
    L6:
        r0.post(new a(this, r4));
    }

    private boolean isSessionSwitchOn(String r2) {
        if (KtUtils.findSessionTypeBySmName(r2) != SessionType.VOICE) goto L6;
        return Global.sWakeupStatus;
    L6:
        return Global.getBreathStatus();
    }

    private /* synthetic */ void lambda$initBreathSamiCoreAsync$22(String r4) {
        if (this.mDestroyed == false) goto L6;
        LogUtils.w(TAG, "initBreathSamiCoreAsync ignored, destroyed reason=" + r4, new Object[0]);
        return;
    L6:
        initBreathSamiCore();
    }

    private /* synthetic */ void lambda$new$8(Message r10) {
        String r0 = TAG;
        LogUtils.d(r0, "onTrackerManager.MessageCallback with " + r10.what, new Object[0]);
        switch(r10.what) {
            case 1: goto L34;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L14;
            case 7: goto L11;
            case 8: goto L45;
            case 9: goto L14;
            case 10: goto L10;
            case 11: goto L5;
            default: goto L45;
        };
    L5:
        WakeupMetricAttributionEmitter r1 = WakeupMetricAttributionEmitter.INSTANCE;
        String r2 = "";
        if (r10.getData() == null) goto L9;
        r2 = r10.getData().getString("data", "");
    L9:
        r1.onButtonWakeup(r2);
        return;
    L10:
        postTruthCaptureSwitchChanged(r10);
        return;
    L11:
        onAssistantServiceCreated();
        return;
    L12:
        onHandleWakeupSuppress(r10.arg1, extractHostGeneration(r10));
        return;
    L13:
        LogUtils.flushLog();
        return;
    L14:
        postAccountEvent(r10);
        return;
    L15:
        this.mWakeWordSourceBusy = false;
        TemporaryWakeupGateManager.INSTANCE.updateGate(TemporaryWakeupGateManager.Gate.WAKEWORD_SOURCE_BUSY, false, extractHostGeneration(r10), "messenger");
        if (this.mPendingTerminateRequest == false) goto L43;
        int r11 = f.a(Global.SETTINGS_VOICE_ASSISTANT_WAKEUP_STATUS, 0);
        LogUtils.d(r0, "release message received, wakeup status to " + r11, new Object[0]);
        SettingsModel r3 = this.mVoiceSettingModel;
        if (r3 != null) goto L21;
        LogUtils.d(r0, " mVoiceSettingModel is null , just return ", new Object[0]);
        return;
    L21:
        if (r11 == 0) goto L24;
        LogUtils.d(r0, " wakeup status is not zero , just return , not terminate the qualcomm wakeup engine", new Object[0]);
        return;
    L24:
        String r12 = r3.getCurrentSoundModel();
        LogUtils.d(r0, "========= current sound model setting changed " + r12, new Object[0]);
        if (TextUtils.isEmpty(r12) == false) goto L27;
        return;
    L27:
        ArrayList<IExtendedSmModel> r4 = Global.getInstance().getExtendedSmMgr().getSingleKeyphraseSoundModelList();
        if (r4 != null) goto L30;
        return;
    L30:
        if (r4.isEmpty() == true) goto L36;
        handleTerminateSessionReq(r12);
        destroySamiCore();
        LogUtils.d(r0, "------- MSG_TERMINATE_SESSION_REQ --------" + r12, new Object[0]);
        return;
    L36:
        return;
    L43:
        return;
    L34:
        this.mWakeWordSourceBusy = true;
        TemporaryWakeupGateManager.INSTANCE.updateGate(TemporaryWakeupGateManager.Gate.WAKEWORD_SOURCE_BUSY, true, extractHostGeneration(r10), "messenger");
        return;
    }

    private /* synthetic */ Boolean lambda$onCreate$10(Boolean r5) {
        String r0 = TAG;
        LogUtils.d(r0, "init sound model done, result: " + r5, new Object[0]);
        if (r5.booleanValue() == true) goto L5;
    L9:
        return r5;
    L5:
        if (this.mDestroyed == false) goto L8;
        LogUtils.d(r0, "skip establishDefaultSession, service destroyed", new Object[0]);
        return r5;
    L8:
        establishDefaultSession();
        goto L9
    }

    private /* synthetic */ void lambda$onCreate$12(SoundModelManager r3) {
        if (this.mDestroyed == false) goto L5;
    L9:
        LogUtils.d(TAG, "skip initSoundModelAsync, service destroyed or manager released", new Object[0]);
        return;
    L5:
        if (this.mSoundModelManager != r3) goto L9;
        initVoiceRequestFlag();
        r3.initSoundModelAsync();
    }

    private static /* synthetic */ void lambda$onCreate$13(SvaVoicePrintControl r3) {
        LogUtils.d(TAG, "getVoicePrintInfos " + r3, new Object[0]);
    }

    private static /* synthetic */ void lambda$onCreate$14(SvaSdkDatabase r1) {
        r1.VoicePrintDao().getVoicePrintInfos().forEach(new k());
    }

    private /* synthetic */ void lambda$onDestroy$20(IWakeupSession r1) {
        r1.removeWakeupListener(this);
        r1.releaseAllSvaSessions();
    }

    private /* synthetic */ void lambda$onRecognition$17(SoundTriggerWrapper.RecognitionEventWrapper r1) {
        onVoiceRecognition(r1);
    }

    private /* synthetic */ void lambda$postReleaseSidExecutor$0(int r1) {
        releaseSidExecutorIfVoiceIdle(r1);
    }

    private void onAllAudioRecordersReleased(String r4) {
        LogUtils.d(TAG, "onAllAudioRecordersReleased: all audio recorder released, re-establish again", new Object[0]);
        scheduleEstablishSessionAfterRecorderReleased(r4);
    }

    private int onSetFirstBreathWakeupInfo(OpaqueDataHelper.BreathStatistics r5) {
        return SamiBreathWakeupEngine.INSTANCE.setFirstBreathWakeupInfo(r5, this.mUUIDCached, this.mDeviceId, getApplicationContext());
    }

    private void onVoiceRecognitionFaster(Runnable r2) {
        if (Utils.SUPPORT_VIP_PROCESS == true) goto L10;
        r2.run();
        return;
    L10:
        Utils.enableProcessVIP(KtUtils.myPid());     // Catch: Exception -> L6
        r2.run();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    private void postAccountEvent(Message r8) {
        int r2 = r8.what;
        int r3 = r8.arg1;
        int r4 = r8.arg2;
        if (r8.getData() != null) goto L5;
        Bundle r5 = null;
    L6:
        ensureSettingChangeHandler();
        Handler r9 = this.mSettingChangeHandler;
        if (r9 != null) goto L10;
        LogUtils.w(TAG, "postAccountEvent handler is null, drop event what=" + r2, new Object[0]);
        return;
    L10:
        r9.post(new m(this, r2, r3, r4, r5));
        return;
    L5:
        r5 = new Bundle(r8.getData());
        goto L6
    }

    private void postReleaseSidExecutor(String r6) {
        ensureSettingChangeHandler();
        Handler r0 = this.mSettingChangeHandler;
        if (r0 != null) goto L6;
        LogUtils.w(TAG, "postReleaseSidExecutor skipped, handler is null reason=" + r6, new Object[0]);
        return;
    L6:
        monitor-enter(this);
        int r2 = this.mReleaseSidExecutorGeneration + 1;     // Catch: Throwable -> L13
        this.mReleaseSidExecutorGeneration = r2;     // Catch: Throwable -> L13
        Runnable r3 = this.mReleaseSidExecutorRunnable;     // Catch: Throwable -> L13
        o r4 = new o(this, r2);     // Catch: Throwable -> L13
        this.mReleaseSidExecutorRunnable = r4;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        if (r3 == null) goto L11;
        r0.removeCallbacks(r3);
    L11:
        r0.post(r4);
        LogUtils.i(TAG, "postReleaseSidExecutor generation=" + r2 + " reason=" + r6, new Object[0]);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private void postTruthCaptureSwitchChanged(Message r5) {
        boolean r2 = true;
        if (r5.arg1 == 1) goto L6;
        r2 = false;
    L6:
        String r3 = "";
        if (r5.getData() == null) goto L10;
        r3 = r5.getData().getString("data", "");
    L10:
        ensureSettingChangeHandler();
        Handler r6 = this.mSettingChangeHandler;
        if (r6 != null) goto L14;
        LogUtils.w(TAG, "postTruthCaptureSwitchChanged handler is null, drop event enabled=" + r2, new Object[0]);
        return;
    L14:
        r6.post(new f(this, r3, r2));
    }

    private void refreshReporterPrivacySnapshot(String r4) {
        ISecPrivacyService.a.getClass();
        ISecPrivacyService r0 = ISecPrivacyService.a.a();
        if (AppHost.a.isOversea() == true) goto L9;
        if (r0 != null) goto L6;
    L8:
        boolean r1 = false;
    L10:
        int r2 = sna.d.a;
        Intrinsics.checkNotNullParameter(r4, "reason");
        Context r5 = f.a;
        Intrinsics.checkNotNullParameter("reporter_privacy_agreed", "key");
        sna.c r3 = f.b();
        r3.getClass();
        Intrinsics.checkNotNullParameter("reporter_privacy_agreed", "key");
        r3.a().storeBoolean("reporter_privacy_agreed", r1);
        return;
    L6:
        if (r0.h() == false) goto L8;
    L9:
        r1 = true;
        goto L10
    }

    private void releaseSidExecutorAfterInitProbeIfVoiceIdle(String r7) {
        Object r2 = this.mLock;
        monitor-enter(r2);
        int r3 = this.mVoiceStage2InFlight.get();     // Catch: Throwable -> L12
        if (r3 <= 0) goto L9;
        LogUtils.d(TAG, "releaseSidExecutorAfterInitProbeIfVoiceIdle skipped, voice stage2 in flight reason=" + r7 + " inFlight=" + r3, new Object[0]);     // Catch: Throwable -> L12
        monitor-exit(r2);     // Catch: Throwable -> L12
        return;
    L9:
        int r1 = SamiVoiceWakeupEngine.INSTANCE.releaseSidExecutor();     // Catch: Throwable -> L12
        LogUtils.i(TAG, "releaseSidExecutorAfterInitProbeIfVoiceIdle done reason=" + r7 + " ret=" + r1, new Object[0]);     // Catch: Throwable -> L12
        monitor-exit(r2);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private void releaseSidExecutorIfVoiceIdle(int r7) {
        if (this.mDestroyed == false) goto L6;
        LogUtils.d(TAG, "releaseSidExecutorIfVoiceIdle ignored, service destroyed", new Object[0]);
        return;
    L6:
        monitor-enter(this);
    L31:
        th = move-exception;
        throw th;
    L8:
        if (r7 == this.mReleaseSidExecutorGeneration) goto L12;
        LogUtils.d(TAG, "releaseSidExecutorIfVoiceIdle ignored, generation changed from " + r7 + " to " + this.mReleaseSidExecutorGeneration, new Object[0]);     // Catch: Throwable -> L31
        monitor-exit(this);     // Catch: Throwable -> L31
        return;
    L12:
        this.mReleaseSidExecutorRunnable = null;     // Catch: Throwable -> L31
        monitor-exit(this);     // Catch: Throwable -> L31
        if (this.mVoiceStage2InFlight.get() <= 0) goto L18;
        LogUtils.d(TAG, "releaseSidExecutorIfVoiceIdle ignored, voice stage2 in flight", new Object[0]);
        return;
    L18:
        Object r1 = this.mLock;
        monitor-enter(r1);
    L28:
        th = move-exception;
        throw th;
    L21:
        if (this.mVoiceStage2InFlight.get() <= 0) goto L25;
        LogUtils.d(TAG, "releaseSidExecutorIfVoiceIdle ignored in lock, voice stage2 in flight", new Object[0]);     // Catch: Throwable -> L28
        monitor-exit(r1);     // Catch: Throwable -> L28
        return;
    L25:
        int r2 = SamiVoiceWakeupEngine.INSTANCE.releaseSidExecutor();     // Catch: Throwable -> L28
        LogUtils.i(TAG, "releaseSidExecutorIfVoiceIdle done generation=" + r7 + " ret=" + r2, new Object[0]);     // Catch: Throwable -> L28
        monitor-exit(r1);     // Catch: Throwable -> L28
    }

    private void restartRecognition(SessionType r4) {
        LogUtils.d(TAG, "restartRecognition session type = " + r4, new Object[0]);
        RestartRecognitionTask r0 = new RestartRecognitionTask(this, r4);
        this.mRestartRecognitionTask = r0;
        r0.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{""});
    }

    private void scheduleEstablishSessionAfterRecorderReleased(String r6) {
        Handler r0 = this.mSettingChangeHandler;
        if (r0 != null) goto L6;
        LogUtils.w(TAG, "scheduleEstablishSessionAfterRecorderReleased ignored, handler is null", new Object[0]);
        return;
    L6:
        monitor-enter(this);
        int r1 = this.mRecorderBusyRetryGeneration;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        r0.postDelayed(new y(this, r1, r6), RECORDER_BUSY_RETRY_DELAY_MS);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r4) {
        String r5 = TAG;
        LogUtils.d(r5, "onBind of WakeupService Lifecycle useID:" + KtUtils.myUserId(), new Object[0]);
        if (t9a.b.a().e() == false) goto L6;
        LogUtils.w(r5, "skip onBind, emulator os", new Object[0]);
        return null;
    L6:
        this.mH.removeCallbacks(this.mDelayedStopRunnable);
        this.mBindGeneration++;
        this.mPendingStopGeneration = -1;
        if (this.mServerMessenger != null) goto L10;
        this.mServerMessenger = new Messenger(this.mHandler);
    L10:
        return this.mServerMessenger.getBinder();
    }

    public void onBreathRecognition(SoundTriggerWrapper.RecognitionEventWrapper r8) {
        String r0 = TAG;
        LogUtils.d(r0, "onRecognition[Breath]: Stage1 event --->  recognitionEvent = " + r8 + " wakeup Status:" + Global.sWakeupStatus + " breath Status:" + Global.getBreathStatus(), new Object[0]);
        if (1 != r8.status()) goto L6;
        LogUtils.d(r0, "onRecognition[Breath]: abort status, discard recognition", new Object[0]);
        this.needBreathRestart = true;
        TrackAPI.trackWakeupInterrupted("stage1_entry", "abort status", "", SessionType.BREATH.getTag());
        return;
    L6:
        HotwordRecorderMgr r1 = HotwordRecorderMgr.INSTANCE;
        r1.dump("CHECK WAKEUP RECORDER USAGE STATUS");
        boolean r2 = r1.isVoiceInUse();
        LogUtils.d(r0, "onRecognition[Breath] check some switch breathStatus:" + Global.getBreathStatus() + " inEnroll:" + Global.sEnrollIgnore + " wakeupSid:" + Global.sWakeupSid + " hotwordRecorderBreathInUse :" + r2, new Object[0]);
        if (Global.getBreathStatus() == true) goto L9;
    L26:
        LogUtils.d(r0, "onRecognition[Breath] : [ ABORT!! ] abort going on , check switch " + Global.getBreathStatus() + " enroll activity:" + Global.sEnrollIgnore + " hotwordRecorderVoiceInUse:" + r2, new Object[0]);
        if (Global.sWakeupSupress == false) goto L29;
        LogUtils.s(r0, "onRecognition[Breath] abort , because the suppress is ON , means the dora has connected!", SpecialCategory.WAKEUP_FILE, new Object[0]);
    L29:
        if (r2 == false) goto L32;
        LogUtils.s(r0, "onRecognition[Breath] abort , because the voice is in use, means the hotword recorder is busy !", SpecialCategory.WAKEUP_FILE, new Object[0]);
    L32:
        if (Global.sEnrollIgnore == false) goto L35;
        LogUtils.s(r0, "onRecognition[Breath] abort , because is in enroll , activity might be showing now", SpecialCategory.WAKEUP_FILE, new Object[0]);
    L35:
        if (Global.sWakeupStatus == true) goto L38;
        String r9 = "status_off";
    L44:
        SessionType r3 = SessionType.BREATH;
        TrackAPI.trackWakeupInterrupted("stage1_entry", r9, "", r3.getTag());
        restartRecognition(r3);
        return;
    L38:
        if (Global.sWakeupSupress == false) goto L41;
        r9 = "suppressed";
        goto L44
    L41:
        if (Global.sEnrollIgnore == false) goto L43;
        r9 = "enrolling";
        goto L44
    L43:
        r9 = "breath_in_use";
        goto L44
    L9:
        if (Global.sEnrollIgnore == true) goto L26;
        if (r2 == true) goto L26;
        this.breathStartTime = System.currentTimeMillis();
        Trace.beginSection("onRecognition obric");
        LogUtils.d(r0, "onRecognition[Breath] getSmNameByHandle start ", new Object[0]);
        ExtendedSmMgr r4 = this.mExtendedSmMgr;
        if (r4 == null) goto L15;
        String r5 = r4.getSmNameByHandle(r8.soundModelHandle());
    L16:
        LogUtils.d(r0, "onRecognition[Breath] getSmNameByHandle done by model name : " + r5, new Object[0]);
        if (r5 == null) goto L23;
        Pair<Boolean, String> r6 = processBreathRecognitionEvent(r5, new SoundTriggerWrapper.KeyphraseRecognitionEventWrapper(r8), new s(this));
        boolean r7 = ((Boolean) r6.first).booleanValue();
        if (r8.captureAvailable() == true) goto L21;
        LogUtils.d(r0, "onRecognition[Breath] : restart recognition caused by the captureAvailable is false", new Object[0]);
        restartRecognition(SessionType.BREATH);
    L21:
        if (r7 == true) goto L24;
        String r10 = (String) r6.second;
        SessionType r11 = SessionType.BREATH;
        TrackAPI.trackWakeupInterrupted("stage1_entry", "labStart failed", r10, r11.getTag());
        LogUtils.d(r0, "onRecognition[Breath] : restart recognition caused by the processBreathRecognitionEvent got failed", new Object[0]);
        restartRecognition(r11);
    L24:
        Trace.endSection();
        return;
    L23:
        TrackAPI.trackWakeupInterrupted("stage1_entry", "smName null", "", SessionType.BREATH.getTag());
        goto L24
    L15:
        r5 = null;
        goto L16
    }

    @Override // com.obric.sva.sdk.session.legacy.IWakeupListener
    public void onResourcesAvailable(SessionType r10) {
        String r0 = TAG;
        LogUtils.d(r0, "onResourcesAvailable needVoiceRestart=" + this.needVoiceRestart + " needBreathRestart=" + this.needBreathRestart + " session=" + r10, new Object[0]);
        List<IExtendedSmModel> r1 = this.mExtendedSmMgr.getAllSoundModelList();
        StringBuilder r3 = new StringBuilder("onResourcesAvailable models = ");
        r3.append(r1.size());
        LogUtils.d(r0, r3.toString(), new Object[0]);
        if (r10 != SessionType.VOICE) goto L15;
        if (this.needVoiceRestart == false) goto L15;
        this.needVoiceRestart = false;
        Iterator<IExtendedSmModel> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L15;
        IExtendedSmModel r5 = r2.next();
        LogUtils.d(TAG, "onResourcesAvailable item model is " + r5 + " status is :" + r5.getSessionStatus(), new Object[0]);
        SessionType r6 = r5.getSessionType();
        SessionType r7 = SessionType.VOICE;
        if (r6 != r7) goto L8;
        if (IExtendedSmModel.SessionStatus.STARTED != r5.getSessionStatus()) goto L8;
        restartRecognition(r7);
    L15:
        if (r10 == SessionType.BREATH) goto L17;
        return;
    L17:
        if (this.needBreathRestart == false) goto L40;
        this.needBreathRestart = false;
        Iterator<IExtendedSmModel> r11 = r1.iterator();
    L20:
        if (r11.hasNext() == false) goto L41;
        IExtendedSmModel r4 = r11.next();
        LogUtils.d(TAG, "onResourcesAvailable item model is " + r4 + " status is :" + r4.getSessionStatus(), new Object[0]);
        SessionType r8 = r4.getSessionType();
        SessionType r9 = SessionType.BREATH;
        if (r8 != r9) goto L20;
        if (IExtendedSmModel.SessionStatus.STARTED != r4.getSessionStatus()) goto L20;
        restartRecognition(r9);
        return;
    L41:
        return;
    }

    @Override // com.obric.sva.sdk.session.legacy.IWakeupListener
    public void onServiceDied(SessionType r4) {
        LogUtils.d(TAG, "onServiceDied: enter " + r4 + " userID:" + KtUtils.myUserId(), new Object[0]);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent r5) {
        String r6 = TAG;
        LogUtils.d(r6, "onUnbind of WakeupService Lifecycle userID:" + KtUtils.myUserId() + " msger:" + this.mServerMessenger, new Object[0]);
        if (this.mServerMessenger == null) goto L5;
        this.mServerMessenger = null;
        LogUtils.d(r6, "onUnbind of WakeupService schedule stopSelf in 1500ms", new Object[0]);
        this.mH.removeCallbacks(this.mDelayedStopRunnable);
        this.mPendingStopGeneration = this.mBindGeneration;
        this.mH.postDelayed(this.mDelayedStopRunnable, UNBIND_STOP_GRACE_MS);
    L5:
        return false;
    }

    public void onVoiceRecognition(SoundTriggerWrapper.RecognitionEventWrapper r11) {
        String r0 = TAG;
        LogUtils.d(r0, "onRecognition[Voice]: Stage1 event --->  recognitionEvent = " + r11 + " wakeup Status:" + Global.sWakeupStatus, new Object[0]);
        int r4 = 1;
        if (1 != r11.status()) goto L6;
        LogUtils.d(r0, "onRecognition[Voice]: abort status, discard recognition", new Object[0]);
        this.needVoiceRestart = true;
        TrackAPI.trackWakeupInterrupted("stage1_entry", "abort status");
        return;
    L6:
        HotwordRecorderMgr r1 = HotwordRecorderMgr.INSTANCE;
        r1.dump("CHECK WAKEUP RECORDER USEAGE STATUS");
        boolean r2 = r1.isBreathInUse();
        LogUtils.d(r0, "onRecognition[Voice] check some switch wakeupSwitch:" + Global.sWakeupStatus + " surpress:" + Global.sWakeupSupress + " inEnroll:" + Global.sEnrollIgnore + " wakeupSid:" + Global.sWakeupSid + " hotwordRecorderInUse:" + r2, new Object[0]);
        if (Global.sWakeupStatus == true) goto L9;
    L40:
        LogUtils.d(r0, "onRecognition: [ ABORT!! ]  abort going on , check switch " + Global.sWakeupStatus + " surpress:" + Global.sWakeupSupress + " enroll activity:" + Global.sEnrollIgnore + " breathInUse :" + r2, new Object[0]);
    L45:
        e = move-exception;
        e.printStackTrace();
    L48:
        if (Global.sWakeupSupress == false) goto L52;
        String r12 = TAG;
        SpecialCategory r3 = SpecialCategory.WAKEUP_FILE;
        LogUtils.s(r12, "onRecognition[Voice] abort , because the suppress is ON , means the dora has connected! ", r3, new Object[0]);
        if (isInCallMode() == false) goto L52;
        LogUtils.s(r12, "onRecognition[Voice] suppress in call mode, show toast", r3, new Object[0]);
        showSuppressInCallToastOnce();
    L52:
        if (r2 == false) goto L55;
        LogUtils.s(TAG, "onRecognition[Voice] abort , because the breath is in use, means the hotword recorder is busy !", SpecialCategory.WAKEUP_FILE, new Object[0]);
    L55:
        if (Global.sWakeupStatus == true) goto L58;
        String r13 = "status_off";
    L64:
        TrackAPI.trackWakeupInterrupted("stage1_entry", r13);
        return;
    L58:
        if (Global.sWakeupSupress == false) goto L61;
        r13 = "suppressed";
        goto L64
    L61:
        if (Global.sEnrollIgnore == false) goto L63;
        r13 = "enrolling";
        goto L64
    L63:
        r13 = "breath_in_use";
        goto L64
    L42:
        if (this.mExtendedSmMgr.getSmNameByHandle(r11.soundModelHandle()) == null) goto L48;
        restartRecognition(SessionType.VOICE);     // Catch: Exception -> L45
        goto L48
    L9:
        if (Global.sWakeupSupress == true) goto L40;
        if (Global.sEnrollIgnore == true) goto L40;
        if (r2 == true) goto L40;
        if (this.mSamiCoreInited == true) goto L17;
        initVoiceSamiCore();
    L17:
        LightUpManager.INSTANCE.trackBluetoothAndSensor();
        this.mWakeupToken = new WakeupToken(r11);
        long r5 = System.currentTimeMillis();
        this.mStartTime = r5;
        this.mWakeupToken.setStartTime(r5);
        Trace.beginSection("onRecognition obric");
        this.mWakeupTraceCollector.resetWakeupStageData();
        this.mWakeupToken.inflate();
        int r6 = this.mWakeupToken.getKeywordLength();
        LogUtils.d(r0, "onRecognition[Voice]: createRecorderAsync with history length :" + r6 + " and ftrt data get way is " + this.mWakeupToken.getFtrtDataGetWay(), new Object[0]);
        int r7 = Build.VERSION.SDK_INT;
        if (r7 < 26) goto L20;
        HotwordUtils.createRecorderAsync(r11.captureSession(), r6);
    L20:
        LogUtils.d(r0, "onRecognition[Voice]: createRecorderAsync done", new Object[0]);
        this.mWakeupTraceCollector.insertTimeByUser("wakeup_stage2_0_init_time", this.mStartTime);
        this.mWakeupTraceCollector.insertTimeByUser("wakeup_stage2_1_on_recognition", 0);
        ISvaFrameworkKt.getSvaFrameworkDelegate().setPowerUpState(false);
        ISvaFrameworkKt.getSvaFrameworkDelegate().stopPowerUpTimer();
        boolean r8 = this.mPowerManager.isInteractive();
        LogUtils.d(r0, "check if the screen is turn-off or not ? interactive:" + r8 + " dozeOn:" + Global.sDozeOn, new Object[0]);
        if (r8 == true) goto L24;
        r4 = 2;
    L24:
        this.mWakeupTraceCollector.insertTimeValue("wakeup_stage2_screen_state", Integer.valueOf(r4));
        this.miscMap.put("wakeup_stage2_screen_state", Integer.valueOf(r4));
        LogUtils.d(r0, "getSmNameByHandle start ", new Object[0]);
        ExtendedSmMgr r9 = this.mExtendedSmMgr;
        if (r9 == null) goto L27;
        String r10 = r9.getSmNameByHandle(r11.soundModelHandle());
    L28:
        LogUtils.d(r0, "getSmNameByHandle done " + r10, new Object[0]);
        if (r10 == null) goto L37;
        Pair<Boolean, String> r14 = processVoiceRecognitionEvent(r10, "", new SoundTriggerWrapper.KeyphraseRecognitionEventWrapper(r11));
        boolean r15 = ((Boolean) r14.first).booleanValue();
        if (r11.captureAvailable() == true) goto L33;
        LogUtils.d(r0, "onRecognition: no LAB, restart recognition", new Object[0]);
        restartRecognition(SessionType.VOICE);
    L33:
        if (r15 == true) goto L38;
        if (r7 < 26) goto L36;
        HotwordUtils.releaseRecorder();
    L36:
        restartRecognition(SessionType.VOICE);
        TrackAPI.trackWakeupInterrupted("stage1_entry", "labStart failed", (String) r14.second);
    L38:
        Trace.endSection();
        return;
    L37:
        TrackAPI.trackWakeupInterrupted("stage1_entry", "smName null");
        goto L38
    L27:
        r10 = null;
        goto L28
    }

    public static /* synthetic */ boolean access$2402(WakeupService r0, boolean r1) {
        r0.needVoiceRestart = r1;
        return r1;
    }

    public static /* synthetic */ long access$3402(WakeupService r0, long r1) {
        r0.mEndTime = r1;
        return r1;
    }

    public static /* synthetic */ RestartRecognitionTask access$4302(WakeupService r0, RestartRecognitionTask r1) {
        r0.mRestartRecognitionTask = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$4702(WakeupService r0, boolean r1) {
        r0.needBreathRestart = r1;
        return r1;
    }

    public static /* synthetic */ String access$4800(int r0, int r1) {
        return matchPadding(r0, r1);
    }

    public static /* synthetic */ void access$500(WakeupService r0, IBinder r1) {
        r0.handleClientDeath(r1);
    }

    public static /* synthetic */ void access$5000(WakeupService r0, SessionType r1) {
        r0.restartRecognition(r1);
    }

    public static /* synthetic */ int access$5100(WakeupService r0, OpaqueDataHelper.BreathStatistics r1) {
        return r0.onSetFirstBreathWakeupInfo(r1);
    }

    private void handleDeregisterClientReq(Messenger r5, Integer r6) {
        String r0 = TAG;
        LogUtils.d(r0, "try handleDeregisterClientReq :" + r6, new Object[0]);
        if (this.mWakeupClientRegistry.deregisterClient(r5, r6.intValue()) == false) goto L8;
        LogUtils.d(r0, "handleDeregisterClientReq: clientId = " + r6, new Object[0]);
        if (1 != r6.intValue()) goto L9;
        Utils.forceStartVoiceInteractionService(this);
        return;
    L9:
        return;
    }

    private void handleRegisterClientReq(Messenger r4, Integer r5) {
        LogUtils.d(TAG, "handleRegisterClientReq: clientId = " + r5, new Object[0]);
        this.mWakeupClientRegistry.registerClient(r4, r5.intValue());
    }

    private void handleSettingChange(WakeupSettingBus.Property r8, boolean r9) {
        String r0 = TAG;
        LogUtils.d(r0, "handleSettingChange property=" + r8 + " status=" + r9, new Object[0]);
        if (r8 != WakeupSettingBus.Property.WAKEUP) goto L38;
        Global.sWakeupStatus = r9;
        SettingsModel r10 = this.mVoiceSettingModel;
        if (r10 != null) goto L8;
        LogUtils.d(r0, "handleSettingChange mVoiceSettingModel is null , just return ", new Object[0]);
        return;
    L8:
        String r11 = r10.getCurrentSoundModel();
        LogUtils.d(r0, "handleSettingChange current sound model setting changed " + r11, new Object[0]);
        if (TextUtils.isEmpty(r11) == false) goto L11;
        return;
    L11:
        ArrayList<IExtendedSmModel> r1 = Global.getInstance().getExtendedSmMgr().getSingleKeyphraseSoundModelList();
        if (r1 != null) goto L14;
        return;
    L14:
        if (r1.isEmpty() == true) goto L60;
        boolean r2 = true;
        if (r9 == false) goto L32;
        if (this.mPendingTerminateRequest == false) goto L28;
        this.mPendingTerminateRequest = false;
        ArrayList<IExtendedSmModel> r12 = Global.getInstance().getExtendedSmMgr().getSingleKeyphraseSoundModelList();
        if (r12.isEmpty() == true) goto L28;
        LogUtils.d(r0, "handleSettingChange switch on ,check model = " + ListProtector.get(r12, 0), new Object[0]);
        if (((IExtendedSmModel) ListProtector.get(r12, 0)).getSessionStatus() != IExtendedSmModel.SessionStatus.STARTED) goto L25;
        boolean r13 = true;
    L26:
        if (r13 == false) goto L28;
        r2 = false;
        goto L28
    L25:
        r13 = false;
    L28:
        if (r2 == false) goto L30;
        handleEstablishSessionReq(r11);
        initVoiceSamiCore();
    L30:
        LogUtils.d(r0, "------- MSG_ESTABLISH_SESSION_REQ --------" + r11 + " with request " + r2, new Object[0]);
        return;
    L32:
        if (this.mWakeWordSourceBusy == false) goto L34;
        this.mPendingTerminateRequest = true;
        LogUtils.d(r0, "------- MSG_TERMINATE_SESSION_REQ --------busy , not handle this change!!", new Object[0]);
    L35:
        LogUtils.d(r0, "------- MSG_TERMINATE_SESSION_REQ --------" + r11 + " busy? " + this.mWakeWordSourceBusy, new Object[0]);
        return;
    L34:
        handleTerminateSessionReq(r11);
        destroySamiCore();
        goto L35
    L60:
        return;
    L38:
        if (r8 != WakeupSettingBus.Property.BREATH) goto L63;
        LogUtils.d(r0, "currentStatus is " + f.a("breath_wakeup_status", -1), new Object[0]);
        Global.setBreathStatus(r9);
        if (this.mBreathSettingModel != null) goto L44;
        LogUtils.d(r0, "handleSettingChange mSettingModel is null , just return ", new Object[0]);
        return;
    L44:
        if (ManufactureFeatures.isFeatureBreathWakeupEnable() == true) goto L47;
        LogUtils.d(r0, "breath wakeup is not support on this device , just return", new Object[0]);
        return;
    L47:
        String r14 = this.mBreathSettingModel.getCurrentSoundModel();
        LogUtils.d(r0, "handleSettingChange current sound model setting changed " + r14, new Object[0]);
        if (TextUtils.isEmpty(r14) == false) goto L50;
        return;
    L50:
        ArrayList<IExtendedSmModel> r15 = Global.getInstance().getExtendedSmMgr().getSingleKeyphraseSoundModelList();
        if (r15 != null) goto L53;
        return;
    L53:
        if (r15.isEmpty() == false) goto L56;
        return;
    L56:
        if (Global.getBreathStatus() == false) goto L58;
        handleEstablishSessionReq(r14);
        initBreathSamiCore();
        LogUtils.d(r0, "------- MSG_ESTABLISH_SESSION_REQ --------" + r14, new Object[0]);
        return;
    L58:
        handleTerminateSessionReq(r14);
        destroyBreathSamiCore();
        LogUtils.d(r0, "------- MSG_TERMINATE_SESSION_REQ --------" + r14, new Object[0]);
        return;
    }

    private boolean handleWakeupSidLoadAfterInit(String r7, int r8) {
        String r1 = TAG;
        LogUtils.i(r1, "handleWakeupSidLoadAfterInit reason=" + r7 + " ret=" + r8 + " pending=" + this.mSidReloadAfterReEnrollPending, new Object[0]);
        if (r8 != 220011) goto L23;
        LogUtils.e(r1, "handleWakeupSidLoadAfterInit hit SID_LOAD_FAILED reason=" + r7 + " will forceReEnroll + reload samicore", new Object[0]);
        if (this.mSidReloadAfterReEnrollPending == false) goto L9;
        LogUtils.w(r1, "handleWakeupSidLoadAfterInit skip reload: already reloaded once after forceReEnroll reason=" + r7, new Object[0]);
        this.mSidReloadAfterReEnrollPending = false;
        return false;
    L9:
        if (this.mSidRecoveryInProgress.compareAndSet(false, true) == true) goto L12;
        LogUtils.w(r1, "handleWakeupSidLoadAfterInit skip reload: recovery already in progress reason=" + r7, new Object[0]);
        return false;
    L12:
        int r9 = forceReEnrollWakeupSid(r7);
        if (r9 == 0) goto L16;
        LogUtils.e(r1, "handleWakeupSidLoadAfterInit skip reload: forceReEnroll failed reason=" + r7 + " ret=" + r9, new Object[0]);
        this.mSidReloadAfterReEnrollPending = false;
        this.mSidRecoveryInProgress.set(false);
        return false;
    L16:
        this.mSidReloadAfterReEnrollPending = true;
        Intent r10 = new Intent(getApplicationContext(), WakeupService.class);     // Catch: Throwable -> L19
        r10.setAction(Global.RELOAD_SAMICORE_ACTIVITY_ACTION);     // Catch: Throwable -> L19
        startService(r10);     // Catch: Throwable -> L19
        LogUtils.i(r1, "handleWakeupSidLoadAfterInit trigger reload samicore reason=" + r7, new Object[0]);     // Catch: Throwable -> L19
    L21:
        return false;
    L19:
        th = move-exception;
        LogUtils.e(TAG, "handleWakeupSidLoadAfterInit trigger reload failed reason=" + r7 + " err=" + th.getMessage(), new Object[0]);
        this.mSidReloadAfterReEnrollPending = false;
        this.mSidRecoveryInProgress.set(false);
        goto L21
    L23:
        if (this.mSidReloadAfterReEnrollPending == false) goto L25;
        LogUtils.i(r1, "handleWakeupSidLoadAfterInit recovery success reason=" + r7 + " ret=" + r8 + ", clear reload-pending flag", new Object[0]);
    L25:
        this.mSidReloadAfterReEnrollPending = false;
        this.mSidRecoveryInProgress.set(false);
        return true;
    }

    private /* synthetic */ void lambda$new$4(WakeupSettingBus.Property r1, boolean r2) {
        handleSettingChange(r1, r2);
    }

    private /* synthetic */ void lambda$new$5(WakeupSettingBus.Property r5, boolean r6) {
        String r0 = TAG;
        LogUtils.d(r0, "mStatusChangeListener onSettingChanged property=" + r5 + " status=" + r6, new Object[0]);
        Handler r1 = this.mSettingChangeHandler;
        if (r1 != null) goto L6;
        LogUtils.w(r0, "mStatusChangeListener handler is null, drop event property=" + r5, new Object[0]);
        return;
    L6:
        r1.post(new t(this, r5, r6));
    }

    private void lambda$postTruthCaptureSwitchChanged$7(String r4, boolean r5) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        r4 = "truth_capture_switch_changed";
    L5:
        int r0 = sna.i.a;
        Intrinsics.checkNotNullParameter(r4, "reason");
        Context r1 = f.a;
        Intrinsics.checkNotNullParameter("wakeup_truth_capture_enabled", "key");
        sna.c r2 = f.b();
        r2.getClass();
        Intrinsics.checkNotNullParameter("wakeup_truth_capture_enabled", "key");
        r2.a().storeBoolean("wakeup_truth_capture_enabled", r5);
        OhrHandStateBridge.INSTANCE.switchStateAsync(getApplicationContext(), r5, r4);
    }

    private /* synthetic */ void lambda$scheduleEstablishSessionAfterRecorderReleased$3(int r3, String r4) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (r3 == this.mRecorderBusyRetryGeneration) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L17
        return;
    L7:
        monitor-exit(this);     // Catch: Throwable -> L17
        if (this.mDestroyed == false) goto L11;
    L15:
        LogUtils.d(TAG, "scheduleEstablishSessionAfterRecorderReleased skip, smFullName=" + r4, new Object[0]);
        clearRecorderBusyRetryState(r4);
        return;
    L11:
        if (isSessionSwitchOn(r4) == false) goto L15;
        handleEstablishSessionReq(r4);
    }

    private static String matchPadding(int r1, int r2) {
        if (r1 < r2) goto L5;
        return "";
    L5:
        int r3 = r2 - r1;
        StringBuilder r4 = new StringBuilder();
    L6:
        int r0 = r3 - 1;
        if (r3 <= 0) goto L10;
        r4.append(" ");
        r3 = r0;
        goto L6
    L10:
        return r4.toString();
    }

    private void onHandleWakeupSuppress(int r9, long r10) {
        if (r9 != 1) goto L5;
        boolean r4 = true;
    L6:
        LogUtils.s(TAG, "onHandleWakeupSuppress with suppress " + r4, SpecialCategory.WAKEUP_FILE, new Object[0]);
        TemporaryWakeupGateManager.INSTANCE.updateGate(TemporaryWakeupGateManager.Gate.DORA_SUPPRESS, r4, r10, "messenger");
        return;
    L5:
        r4 = false;
        goto L6
    }

    public static void requestUploadBreathDataOnFeedback(Context r3, String r4) {
        if (r3 != null) goto L6;
        LogUtils.w(TAG, "requestUploadBreathDataOnFeedback skipped, context is null", new Object[0]);
        return;
    L6:
        WakeupService r5 = sCurrentService;
        if (r5 != null) goto L10;
        LogUtils.w(TAG, "requestUploadBreathDataOnFeedback skipped, WakeupService is not running, action = " + r4, new Object[0]);
        return;
    L10:
        r5.handleUploadBreathDataOnFeedback(r4);
    }

    @Override // com.obric.sva.sdk.session.legacy.IWakeupListener
    public void onRecognition(SessionType r7, SoundTriggerWrapper.RecognitionEventWrapper r8) {
        String r0 = TAG;
        SpecialCategory r1 = SpecialCategory.WAKEUP_FILE;
        LogUtils.s(r0, "---------------------WAKEUP START------------------------", r1, new Object[0]);
        LogUtils.s(r0, "▲▲ onRecognition ▲▲ : Stage1 event --->  sessionType =  " + r7, r1, new Object[0]);
        int r2 = AndroidLogcat.a;
        AndroidLogcat.b(r0, "onRecognition from sessionType:" + r7);
        if (TemporaryWakeupGateManager.INSTANCE.sweepIfExpired() == false) goto L6;
        onWakewordBusyFailOpen();
    L6:
        if (KtUtils.isMainUser() == true) goto L9;
        LogUtils.d(r0, "onRecognition ABORT !! due to is NOT mainUser", new Object[0]);
        restartRecognition(r7);
        return;
    L9:
        VoiceWakeupSidThresholdManager r3 = this.mVoiceWakeupSidThresholdManager;
        if (r3 == null) goto L13;
        r3.syncAndApply();
    L13:
        if (this.mDeviceId.isEmpty() == false) goto L15;
    L16:
        Context r4 = getApplicationContext();
        String r5 = rna.b.a;
        Intrinsics.checkNotNullParameter(r4, "context");
        sna.h r6 = sna.h.a;
        String r9 = "";
        String r10 = sna.h.a().getString("os_device_id", "");
        if (r10 == null) goto L20;
        r9 = r10;
    L20:
        StringBuilder r11 = new StringBuilder("getOsDeviceId ");
        if (r9.length() != 0) goto L23;
        boolean r12 = true;
    L24:
        if (r12 == false) goto L26;
        String r13 = "cache miss";
    L27:
        r11.append(r13);
        r11.append(", valueLength=");
        r11.append(r9.length());
        sna.h.b(r11.toString());
        rna.b.q(r9);
        this.mDeviceId = r9;
        StringBuilder r14 = new StringBuilder("Load cached OS device id, cacheHit=");
        r14.append(!this.mDeviceId.isEmpty());
        LogUtils.i(r0, r14.toString(), new Object[0]);
    L29:
        if (r7 != SessionType.VOICE) goto L32;
        onVoiceRecognitionFaster(new r(this, r8));
        return;
    L32:
        if (r7 != SessionType.BREATH) goto L34;
        onBreathRecognition(r8);
        return;
    L34:
        TrackAPI.trackWakeupInterrupted("stage1_entry", "bad sessionType", "onRecognition with giving bad sessionType " + r7);
        LogUtils.e(r0, "onRecognition with giving bad sessionType " + r7, new Object[0]);
        return;
    L26:
        r13 = "success";
        goto L27
    L23:
        r12 = false;
        goto L24
    L15:
        if (this.mDeviceId.equals("0") == false) goto L29;
        goto L16
    }

    public static /* synthetic */ void access$700(WakeupService r0, Messenger r1, Integer r2) {
        r0.handleRegisterClientReq(r1, r2);
    }

    public static /* synthetic */ void access$800(WakeupService r0, Messenger r1, Integer r2) {
        r0.handleDeregisterClientReq(r1, r2);
    }

    private /* synthetic */ void lambda$processBreathRecognitionEvent$19(SoundTriggerWrapper.KeyphraseRecognitionEventWrapper r4, OpaqueDataHelper.BreathStatistics r5, String r6) {
        LogUtils.d(TAG, "processBreathRecognitionEvent skip PocketMode Sensor", new Object[0]);
        BreathUtils.createPipeThenWaitingForResp(this, r4.captureSession(), r5, new 4(this, r6, r4));
    }

    private Pair<Boolean, String> processBreathRecognitionEvent(String r7, SoundTriggerWrapper.KeyphraseRecognitionEventWrapper r8, Runnable r9) {
        String r10 = TAG;
        LogUtils.d(r10, "processBreathRecognitionEvent: event = " + r8 + " smName = " + r7, new Object[0]);
        getBreathExtendedSmModel().setSoundModelHandle(r8.soundModelHandle());
        LogUtils.d(r10, "get SettingModel with name " + r7 + " voiceReq:" + this.mVoiceRequest, new Object[0]);
        if (r8.status() == 0) goto L6;
        LogUtils.d(r10, "processBreathRecognitionEvent: not success status, return directly", new Object[0]);
        return Pair.create(Boolean.FALSE, "not success status:" + r8.status());
    L6:
        LogUtils.d(r10, "processBreathRecognitionEvent check if is Enroll Activity ? " + Global.sEnrollIgnore, new Object[0]);
        if (Global.sEnrollIgnore == false) goto L10;
        LogUtils.d(r10, "processBreathRecognitionEvent enroll , must return now!", new Object[0]);
        return Pair.create(Boolean.FALSE, "is Enroll Activity");
    L10:
        LogUtils.d(r10, "processBreathRecognitionEvent on Received detection wakeup status Switch ? : " + Global.getBreathStatus(), new Object[0]);
        if (Global.getBreathStatus() == true) goto L14;
        LogUtils.d(r10, "processBreathRecognitionEvent returned by the switch is OFF status", new Object[0]);
        return Pair.create(Boolean.FALSE, "breath status Switch off");
    L14:
        LogUtils.d(r10, "processBreathRecognitionEvent event.captureAvailable: " + r8.captureAvailable() + " mVoiceRequest:" + this.mVoiceRequest, new Object[0]);
        long r2 = System.currentTimeMillis();
        OpaqueDataHelper.BreathStatistics r11 = OpaqueDataHelper.parseBreath(r8.data());     // Catch: Exception -> L17
    L19:
        String r0 = TAG;
        LogUtils.d(r0, "processBreathRecognitionEvent breathStatistics :" + r11, new Object[0]);
        LogUtils.d(r0, "processBreathRecognitionEvent on parsing the opaque data using " + (System.currentTimeMillis() - r2) + " ms", new Object[0]);
        ThreadMethodProxy.start(new PthreadThreadV2(new z(this, r8, r11, r7), "WakeupService"));
        return Pair.create(Boolean.TRUE, "");
    L17:
        e = move-exception;
        LogUtils.e(TAG, "parseBreath error: " + e, new Object[0]);
        r11 = null;
        goto L19
    }

    private Pair<Boolean, String> processVoiceRecognitionEvent(String r19, String r20, SoundTriggerWrapper.KeyphraseRecognitionEventWrapper r21) {
        String r1 = TAG;
        LogUtils.d(r1, "processVoiceRecognitionEvent: event = " + r21 + " smName = " + r19, new Object[0]);
        this.mWakeupTraceCollector.insertTimeTrace("wakeup_stage2_2_process_event");
        getVoiceExtendedSmModel().setSoundModelHandle(r21.soundModelHandle());
        LogUtils.d(r1, "get SettingModel with name " + r19 + " voiceReq:" + this.mVoiceRequest, new Object[0]);
        if (this.mVoiceRequest != (-1)) goto L6;
        this.mVoiceRequest = new SettingsModel(getApplicationContext(), r19).getVoiceRequestEnabled() ? 1 : 0;
    L6:
        if (r21.status() == 0) goto L9;
        LogUtils.d(r1, "processVoiceRecognitionEvent: not success status, return directly", new Object[0]);
        return Pair.create(Boolean.FALSE, "not success status:" + r21.status());
    L9:
        LogUtils.d(r1, "check if is Enroll Activity ? " + Global.sEnrollIgnore, new Object[0]);
        if (Global.sEnrollIgnore == true) goto L12;
        LogUtils.d(r1, "on Received detection wakeup status Switch ? : " + Global.sWakeupStatus, new Object[0]);
        if (Global.sWakeupStatus == false) goto L16;
        LogUtils.d(r1, "processVoiceRecognitionEvent event.captureAvailable: " + r21.captureAvailable() + " mVoiceRequest:" + this.mVoiceRequest, new Object[0]);
        this.mWakeupTraceCollector.insertTimeTrace("wakeup_stage2_3_before_parse_opaque_data");
        if (r21.captureAvailable() == true) goto L20;
    L46:
        SessionType r2 = SessionType.VOICE;
        restartRecognition(r2);
        processRecognitionEventSuccess(r2, r19, -1, null, null);
        return Pair.create(Boolean.FALSE, "captureAvailable:" + r21.captureAvailable() + " or mVoiceRequest:" + this.mVoiceRequest);
    L20:
        if (this.mVoiceRequest <= 0) goto L46;
        boolean r3 = getVoiceExtendedSmModel().isSupportExtendedOpaqueData();
        LogUtils.d(r1, "processVoiceRecognitionEvent: LAB ? support opaqueData " + r3, new Object[0]);
        int r5 = r21.soundModelHandle();
        int r6 = r21.captureSession();
        if (r3 == false) goto L42;
        LogUtils.d(r1, "begin opaquedata parse", new Object[0]);
        OpaqueDataHelper.DetectionConfLevel r4 = OpaqueDataHelper.parseVoice(r21.data());
        if (r4 == null) goto L43;
        LogUtils.d(r1, "after opaquedata parse = " + r4, new Object[0]);
        int r8 = r4.getFKeywordLevel();     // Catch: Throwable -> L37
        int r9 = r4.getFUserLevel();     // Catch: Throwable -> L35
        int r10 = r4.getKwLength();     // Catch: Throwable -> L33
        LogUtils.i(r1, "Stage 1 credibility is :" + r4.getCredibility(), new Object[0]);     // Catch: Throwable -> L31
        float r0 = r4.getConfidence();     // Catch: Throwable -> L31
        float r7 = r4.getStage1Threshold();     // Catch: Throwable -> L31
        String r11 = r4.getModelVersion();     // Catch: Throwable -> L31
        this.mWakeupTraceCollector.insertStage1TimeByUser("raw_start_time", r4.getAdspStage1DetEventTime());     // Catch: Throwable -> L31
        this.mWakeupTraceCollector.insertStage1TimeByUser("wakeup_adsp_report_duration", r4.getApStage1DetEventTime() - r4.getAdspStage1DetEventTime());     // Catch: Throwable -> L31
        this.mWakeupTraceCollector.insertStage1TimeByUser("wakeup_native_process_duration", this.mStartTime - r4.getApStage1DetEventTime());     // Catch: Throwable -> L31
        this.mWakeupTraceCollector.insertStage1TimeByUser("wakeup_stage1_duration", this.mStartTime - r4.getAdspStage1DetEventTime());     // Catch: Throwable -> L31
        this.mWakeupTraceCollector.insertTimeValue(KEY_STAGE1_CONFIDENCE, Float.valueOf(r0));     // Catch: Throwable -> L31
        this.mWakeupTraceCollector.insertTimeValue(KEY_STAGE1_THRESHOLD, Float.valueOf(r7));     // Catch: Throwable -> L31
        this.mWakeupTraceCollector.insertTimeValue(KEY_STAGE1_MODEL_VERSION, r11);     // Catch: Throwable -> L31
        this.mWakeupTraceCollector.insertTimeValue(KEY_STAGE1_KEYWORD, r4.getStage1Keyword());     // Catch: Throwable -> L31
        this.mWakeupTraceCollector.insertTimeValue(KEY_STAGE1_TRACE_BACK, Float.valueOf(r4.getStage1Traceback()));     // Catch: Throwable -> L31
        this.mWakeupTraceCollector.insertStage1TimeByUser(KEY_STAGE1_START_TIME, r4.getAdspStage1DetEventTime() - ((long) (r4.getStage1Traceback() * 1000.0f)));     // Catch: Throwable -> L31
        this.mWakeupTraceCollector.insertTimeValue(KEY_STAGE2_MODEL_VERSION, ConfigManager.stage2Config.getKwsmodelVersion());     // Catch: Throwable -> L31
        this.mWakeupTraceCollector.insertTimeValue(KEY_STAGE2_ENGINE_VERSION, ConfigManager.stage2Config.getKwsengineVersion());     // Catch: Throwable -> L31
        this.mWakeupTraceCollector.insertTimeValue(KEY_STAGE2_MODEL_MD5, ConfigManager.stage2Config.getKwsmd5());     // Catch: Throwable -> L31
        this.mWakeupTraceCollector.insertTimeValue(KEY_STAGE2_KWS_RAW_MD5, ConfigManager.stage2Config.getKws_rawfile_md5());     // Catch: Throwable -> L31
        this.mWakeupTraceCollector.insertTimeValue(KEY_STAGE2_SID_RAW_MD5, ConfigManager.stage2Config.getVoiceprint_rawfile_md5());     // Catch: Throwable -> L31
        this.mWakeupTraceCollector.insertTimeValue(KEY_SID_BARGIN_STATUS, Integer.valueOf(r4.getAecState()));     // Catch: Throwable -> L31
        this.mWakeupTraceCollector.insertTimeValue(KEY_SESSION_TYPE, "VOICE");     // Catch: Throwable -> L31
        ConfigManager.INSTANCE.dump();     // Catch: Throwable -> L31
    L44:
        this.mWakeupTraceCollector.insertTimeTrace("wakeup_stage2_4_after_parse_opaque_data");
        LogUtils.d(TAG, "processRecognitionEvent: start LAB task", new Object[0]);
        HashMap r12 = new HashMap();
        r12.put(KEY_CAPTURE_HANDLE, Integer.valueOf(r6));
        r12.put(KEY_SM_HANDLE, Integer.valueOf(r5));
        r12.put(KEY_SM_NAME, r19);
        Boolean r13 = Boolean.TRUE;
        r12.put(KEY_DETECTION_SUCCESS, r13);
        r12.put(KEY_FKConfidenceLevel, Integer.valueOf(r8));
        r12.put(KEY_FUsrConfidenceLevel, Integer.valueOf(r9));
        r12.put(KEY_KW_LENGTH, Integer.valueOf(r10));
        r12.put(KEY_EVENT_HASH, r20);
        r12.put(KEY_DETECTION_LEVEL, r4);
        LookAheadBufferTask r14 = new LookAheadBufferTask(this);
        this.mLABTask = r14;
        r14.execute1(new Map[]{r12});
        return Pair.create(r13, "");
    L31:
        th = th;
    L41:
        th.printStackTrace();
    L33:
        th = th;
    L40:
        r10 = 0;
    L35:
        th = th;
    L39:
        r9 = 0;
    L37:
        th = th;
        r8 = 0;
    L43:
        r8 = 0;
        r9 = 0;
        r10 = 0;
        goto L44
    L42:
        r4 = null;
        goto L43
    L16:
        return Pair.create(Boolean.FALSE, "wakeup status Switch off");
    L12:
        return Pair.create(Boolean.FALSE, "is Enroll Activity");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r8, int r9, int r10) {
        String r11 = TAG;
        LogUtils.d(r11, "onStartCommand of WakeupService Lifecycle intent = " + r8, new Object[0]);
        if (t9a.b.a().e() == false) goto L7;
        LogUtils.w(r11, "skip onStartCommand, emulator os", new Object[0]);
        stopSelf(r10);
        return 2;
    L7:
        if (r8 != null) goto L9;
    L14:
        if (r8 != null) goto L16;
    L18:
        if (r8 != null) goto L20;
    L25:
        if (r8 != null) goto L27;
    L29:
        return 2;
    L27:
        if (Global.PULL_UP_ASSIST_ONCE_ACTION.equals(r8.getAction()) == false) goto L29;
        LogUtils.d(r11, "onStartCommand: pull up assist once", new Object[0]);
        this.mH.post(new x(this));
        goto L29
    L20:
        if (Global.RELOAD_VOICE_SID_MODEL_BY_UPDATE.equals(r8.getAction()) == false) goto L25;
        LogUtils.d(r11, "onStartCommand: RELOAD_VOICE_SID_MODEL_BY_UPDATE " + Global.sReloadSamiCoreByUpdate, new Object[0]);
        if (Global.sReloadSamiCoreByUpdate == false) goto L24;
        reloadVoiceSamiCore();
    L24:
        Global.sReloadSamiCoreByUpdate = false;
        LogUtils.d(r11, "update model and reload done !! cost " + (System.currentTimeMillis() - SvaSdkGlobal.INSTANCE.getModelStartDownloadTime()) + " ms", new Object[0]);
        goto L29
    L16:
        if (Global.DESTROY_SAMICORE_ACTIVITY_ACTION.equals(r8.getAction()) == false) goto L18;
        LogUtils.d(r11, "onStartCommand: destroy samicore", new Object[0]);
        Global.sWakeupStatus = false;
        f.c(Global.SETTINGS_VOICE_ASSISTANT_WAKEUP_STATUS, -1);
        ThreadMethodProxy.start(new PthreadThreadV2(new w(this), "WakeupService"));
        goto L29
    L9:
        if (Global.RELOAD_SAMICORE_ACTIVITY_ACTION.equals(r8.getAction()) == false) goto L14;
        if (Global.sWakeupStatus == false) goto L13;
        ThreadMethodProxy.start(new PthreadThreadV2(new v(this), "WakeupService"));
    L13:
        LogUtils.d(r11, "onStartCommand: try to reload, wakeupStatus = " + Global.sWakeupStatus, new Object[0]);
        goto L29
    }

    private void handleAccountEvent(int r5, int r6, int r7, Bundle r8) {
        String r0 = TAG;
        LogUtils.d(r0, "handleAccountEvent what=" + r5 + " arg1=" + r6 + " arg2=" + r7, new Object[0]);
        boolean r3 = true;
        if (r5 != 3) goto L5;
        if (r6 != 1) goto L33;
        handleSettingChange(WakeupSettingBus.Property.BREATH, false);
        destroyBreathSamiCore();
        KtUtils.onAccountLogout(this);
        return;
    L33:
        KtUtils.onEnterpriseAccountLogout(this);
        return;
    L5:
        if (r5 != 6) goto L7;
        KtUtils.onAccountLogin(this);
        return;
    L7:
        if (r5 == 9) goto L10;
        return;
    L10:
        if (r8 == null) goto L14;
        String r9 = r8.getString("data");
        if (r9 == null) goto L14;
    L15:
        if (r6 != 1) goto L29;
        boolean r10 = Global.sWakeupStatus;
        if (r7 == 1) goto L20;
        r3 = false;
    L20:
        KtUtils.onAccountBecomeActive(this, r9);
        String r11 = rna.b.i(getApplicationContext());
        if (TextUtils.isEmpty(r9) == false) goto L23;
    L25:
        LogUtils.w(r0, "account changed identity mismatch, clear service uuid cache", new Object[0]);
        this.mUUIDCached = "";
    L26:
        if (r10 == false) goto L35;
        if (r3 == false) goto L36;
        LogUtils.i(r0, "account changed with wakeup on->on, reload voice samicore", new Object[0]);
        destroySamiCore();
        initVoiceSamiCore();
        return;
    L36:
        return;
    L35:
        return;
    L23:
        if (r11.startsWith(r9.concat("-")) == false) goto L25;
        this.mUUIDCached = r11;
        goto L26
    L29:
        KtUtils.onAccountSwitchAway(this);
        return;
    L14:
        r9 = "";
        goto L15
    }

    private /* synthetic */ void lambda$postAccountEvent$6(int r1, int r2, int r3, Bundle r4) {
        handleAccountEvent(r1, r2, r3, r4);
    }

    private void processRecognitionEventSuccess(SessionType r14, String r15, int r16, ParcelFileDescriptor r17, Map<String, ?> r18) {
        String r10 = TAG;
        LogUtils.d(r10, "wait final result end =========== processRecognitionEventSuccess session-ID " + r16 + " and sessionType :" + r14, new Object[0]);
        DetectionEventContainer r12 = new DetectionEventContainer(r14, 0, r16, r15, r17, DetectionEventContainer.mapToBundle(r18));
        Bundle r1 = new Bundle();
        r1.putInt("sessionid", 0);
        LogUtils.d(r10, "processRecognitionEventSuccess A section", new Object[0]);
        r1.putString(IWakeupSessionConstant.KEY_EXTRA_SM_NAME, r12.getSmFullName());
        r1.putParcelable("pipe", r12.getAudioStream());
        r1.putString("REQUEST_FROM", "VOICE_ASSIST");
        r1.putLong("REQUEST_TIME", r12.getStage2EndTime());
        SessionType r2 = SessionType.VOICE;
        if (r14 != r2) goto L5;
        long r3 = this.mStartTime;
    L6:
        r1.putLong("WAKEUP_START_TIME", r3);
        r1.putBundle("REQUEST_TRACK_DURATION", r12.getTrackerBundle());
        r1.putInt("screen_state", r12.getScreenState());
        r1.putString("keyword", r12.getOneshotKeyword());
        if (r14 != r2) goto L9;
        long r4 = r12.getOneshotOffset();
    L10:
        if (r14 == r2) goto L15;
        if (r18 == null) goto L15;
        Object r5 = r18.get("oneshot_offset");
        if ((r5 instanceof Number) == false) goto L15;
        r4 = ((Number) r5).longValue();
    L15:
        LogUtils.d(r10, "processRecognitionEventSuccess B section", new Object[0]);
        r1.putLong("offsetTime", r4);
        r1.putInt("sessionType", r14.ordinal());
        r1.putString("sessionName", r14.getTag());
        if (r18 == null) goto L23;
        Object r6 = r18.get("unique_wakeup_id");
        if ((r6 instanceof Integer) == false) goto L20;
        r1.putInt("wakeupId", ((Integer) r6).intValue());
    L20:
        Object r7 = r18.get(KEY_STAGE1_START_TIME);
        if ((r7 instanceof Long) == false) goto L23;
        r1.putLong(KEY_STAGE1_START_TIME, ((Long) r7).longValue());
    L23:
        LogUtils.d(r10, "processRecognitionEventSuccess C section", new Object[0]);
        r1.putInt("userHandleId", KtUtils.myUserId());
        this.mWakeupClientRegistry.sendResponseToAllClients(4353, r1, r14);
        return;
    L9:
        r4 = 0;
        goto L10
    L5:
        r3 = this.breathStartTime;
        goto L6
    }

    public static /* synthetic */ void access$4200(WakeupService r0, SessionType r1, String r2, int r3, ParcelFileDescriptor r4, Map r5) {
        r0.processRecognitionEventSuccess(r1, r2, r3, r4, r5);
    }

    private boolean updateStage1Config(String r14, int r15, String r16, float r17, float r18, float r19, float r20, int r21, String r22, int r23) {
        SAMICoreFirstWakeupProperty r5 = new SAMICoreFirstWakeupProperty();
        r5.group_id = r14;
        if (r15 != MAX_DURATION_SHOW_LENGTH) goto L5;
        int r6 = 10;
    L6:
        r5.type = r6;
        r5.background = 0;
        r5.sn = this.mDeviceId;
        r5.version = r22;
        r5.keywords = r16;
        r5.confidence = r17;
        r5.threshold = r18;
        r5.traceback = r19;
        String r7 = this.mUUIDCached;
        if (r7 != null) goto L9;
        r7 = "";
    L9:
        r5.did = r7;
        r5.fallback_threshold = r20;
        r5.engine_version = r22;
        r5.wkr_id = r23;
        String r8 = TAG;
        LogUtils.i(r8, "updateStage1Config : [ group-id:" + r14 + " type :" + r5.type + " OS deviceId:" + r5.sn + " version:" + r5.version + " keyword:" + r5.keywords + " confidence:" + r5.confidence + " threshold:" + r5.threshold + " traceback:" + r5.traceback + " did:" + r5.did + " engine_version:" + r5.engine_version + " aecState:" + r21 + " wakeupId:" + r5.wkr_id + " ] ", new Object[0]);
        float r9 = WakeupStreamVolumeProvider.getMaxActiveStreamVolumePercent(getApplicationContext(), r21);
        this.mWakeupTraceCollector.insertTimeValue(KEY_SID_VOLUME, Float.valueOf(r9));
        this.miscMap.put(KEY_SID_VOLUME, Float.valueOf(r9));
        PowerManager r10 = this.mPowerManager;
        if (r10 != null) goto L12;
    L14:
        boolean r11 = false;
    L15:
        SamiWakeupParamProvider.INSTANCE.updateBeforeWakeup(r22, r14, r21, r9, r11);
        SamiVoiceWakeupEngine r1 = SamiVoiceWakeupEngine.INSTANCE;
        int r2 = r1.init();
        LogUtils.i(r8, "updateStage1Config init ret=" + r2 + " wakeupId=" + r23, new Object[0]);
        if (r2 == 0) goto L19;
        TrackAPI.trackWakeupInterrupted("stage2_entry", "audiosdk_init_failed", "reason=updateStage1Config,initRet=" + r2 + ",wakeupId=" + r23, SessionType.VOICE.getTag());
    L19:
        if (handleWakeupSidLoadAfterInit("updateStage1Config", r2) == true) goto L22;
        LogUtils.w(r8, "updateStage1Config aborted because wakeup sid init failed ret=" + r2 + " wakeupId=" + r23, new Object[0]);
        return false;
    L22:
        r1.setFirstWakeupInfo(r5);
        return true;
    L12:
        if (r10.isInteractive() == true) goto L14;
        r11 = true;
        goto L15
    L5:
        r6 = r15;
        goto L6
    }

    public static /* synthetic */ boolean access$1500(WakeupService r0, String r1, int r2, String r3, float r4, float r5, float r6, float r7, int r8, String r9, int r10) {
        return r0.updateStage1Config(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }
}
