package com.obric.cae.smartBluetooth.a2dpJitterML;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothCodecConfig;
import android.bluetooth.BluetoothCodecStatus;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothQualityReport;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.AudioPlaybackConfiguration;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import com.obric.cae.libs.location.poi.AoiBoard;
import com.obric.cae.libs.softap.j;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartBluetooth.SmartBluetoothBinderClient;
import com.obric.cae.smartBluetooth.SmartBluetoothDatabase;
import com.obric.cae.smartBluetooth.SmartBluetoothEventReceiver;
import com.obric.cae.smartBluetooth.SmartBluetoothManager;
import com.obric.cae.smartBluetooth.callback.SmartBluetoothEventCallback;
import com.obric.cae.smartNetwork.AppQoEManager.AIMediaEventSchema;
import com.obric.cae.utils.CaeUtil;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
import v0.d;

/* JADX INFO: loaded from: classes.dex */
public final class A2dpJitterMlBqrCallbackController implements SmartBluetoothEventCallback {
    private static final long AUTO_RECONNECT_WINDOW_MS = 120000;
    private static final String EXTRA_CODEC_STATUS = "android.bluetooth.extra.CODEC_STATUS";
    public static final String SETTINGS_GLOBAL_A2DP_JITTER_ML_ENABLED = "cae_a2dp_jitter_ml_enabled";
    private static final long SEVERE_JITTER_WINDOW_MS = 180000;
    private static final String TAG = "A2dpJitterMlBqrCb";
    private boolean mA2dpConnected;
    private final A2dpJitterAction mA2dpJitterAction;
    private boolean mA2dpPlaying;
    private final BluetoothAdapter mAdapter;
    private final A2dpJitterMlAoiBoardCallbackController mAoiBoardCallbackController;
    private final Context mAppContext;
    private final AudioManager mAudioManager;
    private final AudioManager.AudioPlaybackCallback mAudioPlaybackCallback;
    private final Handler mAudioPlaybackHandler;
    private long mAutoDisconnectElapsedMs;
    private boolean mAutoStrategyActive;
    private boolean mAutoStrategyByHistory;
    private final BluetoothAdapter.BluetoothQualityReportReadyCallback mBqrCallback;
    private final BroadcastReceiver mCodecConfigReceiver;
    private boolean mCodecReceiverRegistered;
    private BluetoothDevice mCurrentA2dpDevice;
    private String mCurrentAoiLocation;
    private boolean mCustomBqrParamApplied;
    private final Executor mExecutor;
    private boolean mFeatureEnabled;
    private final A2dpJitterMlFeatureExtractor mFeatureExtractor;
    private boolean mInAoi;
    private String mLastPolicyLocation;
    private String mLastPolicyOptimizeAction;
    private final Object mLock;
    private String mManualDisabledAddress;
    private String mManualDisabledAoiLocation;
    private boolean mManualDisabledInCurrentAoi;
    private boolean mMediaA2dpPlaying;
    private final PackageManager mPackageManager;
    private String mPendingAutoReconnectAddress;
    private String mPendingAutoReconnectAoiLocation;
    private int mPolicyActionDoCount;
    private int mPolicyActionUndoCount;
    private A2dpJitterMlPredictor mPredictor;
    private boolean mRegistered;
    private final ContentObserver mSettingsObserver;
    private final LinkedList<Long> mSevereJitterHistory;
    private boolean mStarted;

    public A2dpJitterMlBqrCallbackController(Context r8, Executor r10) {
        this.mLock = new Object();
        this.mFeatureExtractor = new A2dpJitterMlFeatureExtractor();
        this.mLastPolicyOptimizeAction = A2dpJitterAction.OPTIMIZE_ACTION_CODEC_OPTIMIZE;
        this.mSevereJitterHistory = new LinkedList();
        this.mAdapter = BluetoothAdapter.getDefaultAdapter();
        Context r11 = r8.getApplicationContext();
        this.mAppContext = r11;
        this.mPackageManager = r11.getPackageManager();
        this.mAudioManager = (AudioManager) r11.getSystemService(AIMediaEventSchema.MEDIA_TYPE_AUDIO);
        this.mAudioPlaybackHandler = new Handler(Looper.getMainLooper());
        if (r10 != null) goto L6;
        r10 = new d(2);
    L6:
        this.mExecutor = r10;
        this.mA2dpJitterAction = new A2dpJitterAction(r11);
        this.mAoiBoardCallbackController = new A2dpJitterMlAoiBoardCallbackController(new j(this));
        final Handler r12 = null;
        this.mSettingsObserver = new AnonymousClass1(this, r12);
        this.mCodecConfigReceiver = new AnonymousClass2(this);
        this.mAudioPlaybackCallback = new AnonymousClass3(this);
        this.mBqrCallback = new AnonymousClass4(this);
    }

    public static /* synthetic */ void a(A2dpJitterMlBqrCallbackController r8, BluetoothDevice r10, String r11, boolean r12, boolean r13, String r14) {
        r8.lambda$triggerA2dpJitterOptimizationLocked$0(r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ void access$000(A2dpJitterMlBqrCallbackController r8) {
        r8.onFeatureSwitchChanged();
    }

    public static /* synthetic */ void access$100(A2dpJitterMlBqrCallbackController r8, BluetoothDevice r10, BluetoothCodecStatus r11) {
        r8.onCodecConfigChanged(r10, r11);
    }

    public static /* synthetic */ void access$200(A2dpJitterMlBqrCallbackController r8) {
        r8.onAudioPlaybackConfigChanged();
    }

    public static /* synthetic */ void access$300(A2dpJitterMlBqrCallbackController r8, BluetoothDevice r10, BluetoothQualityReport r11) {
        r8.handleBqrReport(r10, r11);
    }

    private void applyCustomBqrParamLocked(boolean r8) {
        SmartBluetoothBinderClient r10 = SmartBluetoothManager.getInstance(this.mAppContext).getBluetoothBinderClient();
        if (r10 != null) goto L6;
        CaeLog.w(TAG, "binderClient is null, cannot set bqr param");
        return;
    L6:
        if (r8 == false) goto L8;
        CaeLog.i(TAG, "apply custom bqr param state: 1 (custom mask)");
        int r11 = 1;
    L9:
        r10.setBqrEventState(r11);
        return;
    L8:
        CaeLog.i(TAG, "restore default bqr param state: 0 (default mask)");
        r11 = 0;
        goto L9
    }

    public static /* synthetic */ void b(A2dpJitterMlBqrCallbackController r8, AoiBoard r10) {
        r8.onAoiBoardInfoChanged(r10);
    }

    private String buildAoiBoardLocation(AoiBoard r8) {
        return safeString(r8.getPoiName());
    }

    private void clearManualDisabledInCurrentAoiLocked() {
        this.mManualDisabledInCurrentAoi = false;
        this.mManualDisabledAddress = null;
        this.mManualDisabledAoiLocation = null;
    }

    private void clearPendingAutoReconnectLocked() {
        this.mPendingAutoReconnectAddress = null;
        this.mPendingAutoReconnectAoiLocation = null;
        this.mAutoDisconnectElapsedMs = 0;
    }

    private void completeA2dpJitterOptimizationLocked(BluetoothDevice r8, String r10, boolean r11, boolean r12, String r13) {
        if (this.mStarted == true) goto L5;
        return;
    L5:
        if (this.mFeatureEnabled == false) goto L28;
        if (r8 != null) goto L8;
        return;
    L8:
        if (r8.getAddress() != null) goto L10;
        return;
    L10:
        if (safeString(r10).isEmpty() == false) goto L13;
        return;
    L13:
        if (r10.equals(this.mCurrentAoiLocation) == true) goto L15;
    L24:
        String r14 = "optimization callback stale, skip. device=" + CaeUtil.maskMacOrBssid(r8.getAddress()) + ", aoi=" + r10 + ", currentAoi=" + this.mCurrentAoiLocation;
    L25:
        CaeLog.i(TAG, r14);
        return;
    L15:
        if (isCurrentDeviceLocked(r8) == false) goto L24;
        if (isManualDisabledInCurrentAoiLocked(r8.getAddress()) == false) goto L20;
        r14 = "manual disabled in current aoi, skip optimization callback.";
        goto L25
    L20:
        SmartBluetoothManager.getInstance(this.mAppContext).getDatabase().markA2dpJitterMlOptimized(r8, r10, r11, r12);
        this.mAutoStrategyActive = true;
        this.mAutoStrategyByHistory = r12;
        this.mLastPolicyLocation = r10;
        if (safeString(r13).isEmpty() == false) goto L23;
        r13 = A2dpJitterAction.OPTIMIZE_ACTION_CODEC_OPTIMIZE;
    L23:
        this.mLastPolicyOptimizeAction = r13;
        int r15 = this.mPolicyActionDoCount + 1;
        this.mPolicyActionDoCount = r15;
        A2dpJitterMlTeaReporter.reportA2dpJitterPolicyEvent(1, r13, r15, this.mPolicyActionUndoCount, r10);
        r14 = "a2dp jitter optimization executed, device=" + CaeUtil.maskMacOrBssid(r8.getAddress()) + ", aoi=" + r10 + ", severeTrigger=" + r11 + ", autoByHistory=" + r12 + ", optimizeAction=" + this.mLastPolicyOptimizeAction;
        goto L25
    }

    private void handleAoiEnteredLocked(BluetoothDevice r8) {
        if (this.mFeatureEnabled == true) goto L5;
        return;
    L5:
        if (this.mInAoi == true) goto L7;
        return;
    L7:
        if (this.mA2dpConnected == false) goto L31;
        if (r8 != null) goto L10;
        return;
    L10:
        if (r8.getAddress() != null) goto L12;
        return;
    L12:
        if (this.mCurrentAoiLocation != null) goto L15;
        return;
    L15:
        if (this.mMediaA2dpPlaying == true) goto L17;
    L21:
        SmartBluetoothDatabase r10 = SmartBluetoothManager.getInstance(this.mAppContext).getDatabase();
        if (isManualDisabledInCurrentAoiLocked(r8.getAddress()) == false) goto L24;
        String r11 = "manual disabled in current aoi, skip aoi enter optimization.";
    L19:
        CaeLog.i(TAG, r11);
        return;
    L24:
        CaeLog.i(TAG, "handleAoiEnteredLocked: " + CaeUtil.maskMacOrBssid(r8.getAddress()) + ", " + this.mCurrentAoiLocation);
        if (r10.shouldAutoOptimizeA2dpJitterMl(r8.getAddress(), this.mCurrentAoiLocation, CaeUtil.getA2dpJitterMlHistorySevereJitterOptimizeTriggerThreshold(this.mAppContext)) == false) goto L27;
        CaeLog.i(TAG, "history severe jitter threshold reached, auto optimize on aoi enter.");
        triggerA2dpJitterOptimizationLocked(r8, false, true);
        return;
    L27:
        CaeLog.i(TAG, "history severe jitter threshold not reached, skip aoi enter optimization.");
        resetMonitoringWindowLocked();
        return;
    L17:
        if (isMediaPlaybackActive(null) == false) goto L21;
        r11 = "media playback active, skip aoi enter optimization.";
        goto L19
    }

    private void handleBqrReport(BluetoothDevice r10, BluetoothQualityReport r11) {
        if (r11 != null) goto L5;
        return;
    L5:
        if (r10 == null) goto L7;
        r10.getAddress();
    L7:
        Object r8 = this.mLock;
        monitor-enter(r8);
        A2dpJitterMlPredictor r12 = this.mPredictor;     // Catch: Throwable -> L47
        boolean r13 = true;
        if (this.mMediaA2dpPlaying == true) goto L12;
    L14:
        boolean r14 = false;
    L15:
        boolean r15 = this.mFeatureEnabled;     // Catch: Throwable -> L47
        boolean r16 = this.mInAoi;     // Catch: Throwable -> L47
        if (r10 == null) goto L18;
        this.mCurrentA2dpDevice = r10;     // Catch: Throwable -> L47
    L18:
        monitor-exit(r8);     // Catch: Throwable -> L47
        if (r15 == false) goto L54;
        if (r12 == null) goto L55;
        if (r14 == false) goto L56;
        if (r16 == false) goto L60;
        A2dpJitterMlFeatureExtractor.ExtractResult r17 = this.mFeatureExtractor.extract(r10, r11);
        if (r17 != null) goto L27;
        return;
    L27:
        if (r17.mStandardized == null) goto L61;
        A2dpJitterMlPredictor.PredictionResult r18 = r12.addSample(System.currentTimeMillis(), r17.mStandardized);     // Catch: Throwable -> L44
        StringBuilder r19 = new StringBuilder("debug infer result ready=");     // Catch: Throwable -> L44
        if (r18 != null) goto L32;
    L34:
        r13 = false;
    L35:
        r19.append(r13);     // Catch: Throwable -> L44
        r19.append(", lastResult=");     // Catch: Throwable -> L44
        r19.append(A2dpJitterMlPredictor.getLastResultForDebug());     // Catch: Throwable -> L44
        CaeLog.i(TAG, r19.toString());     // Catch: Throwable -> L44
        if (r18 != null) goto L38;
        return;
    L38:
        if (r18.mReady == true) goto L40;
        return;
    L40:
        if (isSevereJitterProbability(r18.mProbability) == false) goto L42;
        A2dpJitterMlTeaReporter.reportA2dpJitterEvent(r17, r18.mProbability);     // Catch: Throwable -> L44
    L42:
        handlePrediction(r10, r18.mProbability);     // Catch: Throwable -> L44
        return;
    L32:
        if (r18.mReady == false) goto L34;
    L44:
        th = move-exception;
        android.aimedia.a.s(th, new StringBuilder("predict error: "), TAG);
        return;
    L61:
        return;
    L60:
        return;
    L56:
        return;
    L55:
        return;
    L54:
        return;
    L12:
        if (isMediaPlaybackActive(null) == false) goto L14;
        r14 = true;
    L47:
        th = move-exception;
        throw th;
    }

    private void handleDeviceConnected(BluetoothDevice r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        Object r10 = this.mLock;
        monitor-enter(r10);
        this.mCurrentA2dpDevice = r8;     // Catch: Throwable -> L23
        this.mA2dpConnected = true;     // Catch: Throwable -> L23
        if (this.mFeatureEnabled == true) goto L11;
        monitor-exit(r10);     // Catch: Throwable -> L23
        return;
    L11:
        if (shouldResumeAutoStrategyLocked(r8) == false) goto L16;
        CaeLog.i(TAG, "resume history auto optimization after quick reconnect.");     // Catch: Throwable -> L23
        triggerA2dpJitterOptimizationLocked(r8, false, true);     // Catch: Throwable -> L23
        clearPendingAutoReconnectLocked();     // Catch: Throwable -> L23
        monitor-exit(r10);     // Catch: Throwable -> L23
        return;
    L16:
        if (isExpiredAutoReconnectLocked(r8) == false) goto L20;
        CaeLog.i(TAG, "history auto reconnect expired, skip auto optimization.");     // Catch: Throwable -> L23
        clearPendingAutoReconnectLocked();     // Catch: Throwable -> L23
        resetMonitoringWindowLocked();     // Catch: Throwable -> L23
        monitor-exit(r10);     // Catch: Throwable -> L23
        return;
    L20:
        handleAoiEnteredLocked(r8);     // Catch: Throwable -> L23
        monitor-exit(r10);     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        throw th;
    }

    private void handleDeviceDisconnected(BluetoothDevice r8) {
        Object r10 = this.mLock;
        monitor-enter(r10);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (isCurrentDeviceLocked(r8) == true) goto L8;
        monitor-exit(r10);     // Catch: Throwable -> L22
        return;
    L8:
        resetMonitoringWindowLocked();     // Catch: Throwable -> L22
        this.mA2dpConnected = false;     // Catch: Throwable -> L22
        this.mA2dpPlaying = false;     // Catch: Throwable -> L22
        this.mMediaA2dpPlaying = false;     // Catch: Throwable -> L22
        updateBqrParamStateLocked();     // Catch: Throwable -> L22
        resetPredictorLocked();     // Catch: Throwable -> L22
        if (this.mAutoStrategyActive == true) goto L11;
    L18:
        clearPendingAutoReconnectLocked();     // Catch: Throwable -> L22
    L19:
        maybeRecoverOptimizedStateLocked();     // Catch: Throwable -> L22
        this.mCurrentA2dpDevice = null;     // Catch: Throwable -> L22
        monitor-exit(r10);     // Catch: Throwable -> L22
        return;
    L11:
        if (this.mInAoi == false) goto L18;
        if (this.mCurrentAoiLocation == null) goto L18;
        if (r8 == null) goto L18;
        if (r8.getAddress() == null) goto L18;
        this.mPendingAutoReconnectAddress = r8.getAddress();     // Catch: Throwable -> L22
        this.mPendingAutoReconnectAoiLocation = this.mCurrentAoiLocation;     // Catch: Throwable -> L22
        this.mAutoDisconnectElapsedMs = SystemClock.elapsedRealtime();     // Catch: Throwable -> L22
        goto L19
    }

    private void handlePrediction(BluetoothDevice r8, float r10) {
        if (isSevereJitterProbability(r10) == true) goto L5;
        return;
    L5:
        Object r11 = this.mLock;
        monitor-enter(r11);
        handleSevereJitterLocked(r8);     // Catch: Throwable -> L10
        CaeLog.i(TAG, "prob=" + r10 + ", severe jitter detected (severe jitter window count: " + this.mSevereJitterHistory.size() + ")");     // Catch: Throwable -> L10
        monitor-exit(r11);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void handleSevereJitterLocked(BluetoothDevice r8) {
        if (this.mFeatureEnabled == true) goto L5;
        return;
    L5:
        if (this.mInAoi == true) goto L7;
        return;
    L7:
        if (this.mCurrentAoiLocation == null) goto L30;
        if (r8 != null) goto L10;
        return;
    L10:
        if (r8.getAddress() != null) goto L13;
        return;
    L13:
        if (isManualDisabledInCurrentAoiLocked(r8.getAddress()) == false) goto L16;
        CaeLog.i(TAG, "manual disabled in current aoi, skip severe jitter optimization.");
        resetMonitoringWindowLocked();
        return;
    L16:
        long r10 = SystemClock.elapsedRealtime();
    L18:
        if (this.mSevereJitterHistory.isEmpty() == true) goto L22;
        if ((r10 - this.mSevereJitterHistory.peekFirst().longValue()) <= SEVERE_JITTER_WINDOW_MS) goto L22;
        this.mSevereJitterHistory.pollFirst();
    L22:
        this.mSevereJitterHistory.addLast(Long.valueOf(r10));
        if (this.mSevereJitterHistory.size() < CaeUtil.getA2dpJitterMlSevereJitterTriggerThreshold(this.mAppContext)) goto L32;
        triggerA2dpJitterOptimizationLocked(r8, true, false);
        resetMonitoringWindowLocked();
        return;
    L32:
        return;
    }

    private boolean isCurrentDeviceLocked(BluetoothDevice r8) {
        if (r8 == null) goto L15;
        if (r8.getAddress() == null) goto L15;
        if (this.mCurrentA2dpDevice == null) goto L13;
        if (r8.getAddress().equals(this.mCurrentA2dpDevice.getAddress()) == false) goto L13;
        return true;
    L13:
        return false;
    L15:
        if (this.mCurrentA2dpDevice != null) goto L18;
        return true;
    L18:
        return false;
    }

    private boolean isExpiredAutoReconnectLocked(BluetoothDevice r8) {
        if (r8 != null) goto L5;
        return false;
    L5:
        if (r8.getAddress() != null) goto L7;
        return false;
    L7:
        if (this.mPendingAutoReconnectAddress == null) goto L25;
        long r10 = SystemClock.elapsedRealtime();
        if (r8.getAddress().equals(this.mPendingAutoReconnectAddress) == false) goto L21;
        String r11 = this.mCurrentAoiLocation;
        if (r11 != null) goto L14;
        return false;
    L14:
        if (r11.equals(this.mPendingAutoReconnectAoiLocation) == true) goto L16;
        return false;
    L16:
        if ((r10 - this.mAutoDisconnectElapsedMs) <= 120000) goto L24;
        return true;
    L24:
        return false;
    L21:
        return false;
    L25:
        return false;
    }

    private boolean isManualDisabledInCurrentAoiLocked(String r8) {
        if (this.mManualDisabledInCurrentAoi == false) goto L12;
        if (r8 == null) goto L12;
        if (r8.equals(this.mManualDisabledAddress) == false) goto L12;
        String r10 = this.mCurrentAoiLocation;
        if (r10 == null) goto L12;
        if (r10.equals(this.mManualDisabledAoiLocation) == false) goto L12;
        return true;
    L12:
        return false;
    }

    private boolean isMediaPlaybackActive(List<AudioPlaybackConfiguration> r8) {
        AudioManager r10 = this.mAudioManager;
        if (r10 != null) goto L6;
        CaeLog.w(TAG, "audioManager is null, media playback inactive.");
        return false;
    L6:
        if (r8 == null) goto L26;
    L10:
        if (r8 != null) goto L12;
    L21:
        CaeLog.d(TAG, "no active playback config.");     // Catch: Throwable -> L8
        return false;
    L12:
        if (r8.isEmpty() == true) goto L21;
        Iterator<AudioPlaybackConfiguration> r11 = r8.iterator();     // Catch: Throwable -> L8
    L16:
        if (r11.hasNext() == false) goto L24;
        if (isMediaPlaybackConfig(r11.next()) == false) goto L16;
        return true;
    L24:
        CaeLog.i(TAG, "no media playback config active.");
        return false;
    L26:
        r8 = r10.getActivePlaybackConfigurations();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        android.aimedia.a.s(th, new StringBuilder("check media playback active failed: "), TAG);
        goto L24
    }

    private boolean isMediaPlaybackConfig(AudioPlaybackConfiguration r8) {
        if (r8 != null) goto L5;
        return false;
    L5:
        if (r8.isActive() == false) goto L25;
        AudioAttributes r10 = r8.getAudioAttributes();
        if (r10 != null) goto L10;
        return false;
    L10:
        int r11 = r10.getUsage();
        if (r11 != 13) goto L14;
        return false;
    L14:
        if (r11 == 1) goto L17;
        return false;
    L17:
        if (isSystemUiPlaybackConfig(r8) == false) goto L20;
        return false;
    L20:
        if (AudioAttributes.toLegacyStreamType(r10) != 1) goto L22;
        return false;
    L22:
        return true;
    L25:
        return false;
    }

    private boolean isSevereJitterProbability(float r8) {
        if (Float.isNaN(r8) == false) goto L5;
        return false;
    L5:
        if (Float.isInfinite(r8) == false) goto L8;
        return false;
    L8:
        if (r8 >= CaeUtil.getA2dpJitterMlProbHeavy(this.mAppContext)) goto L10;
        return false;
    L10:
        if (r8 > 1.0f) goto L15;
        return true;
    L15:
        return false;
    }

    private boolean isSystemUiPlaybackConfig(AudioPlaybackConfiguration r8) {
        if (r8 == null) goto L17;
        PackageManager r10 = this.mPackageManager;
        if (r10 == null) goto L17;
        String[] r11 = r10.getPackagesForUid(r8.getClientUid());
        if (r11 != null) goto L10;
        return false;
    L10:
        int r12 = r11.length;
        int r13 = 0;
    L11:
        if (r13 >= r12) goto L17;
        if ("com.android.systemui".equals(r11[r13]) == true) goto L14;
        r13 = r13 + 1;
        goto L11
    L14:
        return true;
    L17:
        return false;
    }

    private boolean isTargetTravelAoiBoard(AoiBoard r8) {
        AoiBoard.Type r10 = r8.getType();
        if (r10 != AoiBoard.Type.AIRPORT) goto L5;
    L8:
        return true;
    L5:
        if (r10 == AoiBoard.Type.TRAIN_STATION) goto L8;
        return false;
    }

    private boolean isUserRevertedOptimizedCodec(BluetoothCodecConfig r8) {
        if (r8.getCodecType() != 1) goto L7;
        return false;
    L7:
        return true;
    }

    private /* synthetic */ void lambda$triggerA2dpJitterOptimizationLocked$0(BluetoothDevice r8, String r10, boolean r11, boolean r12, String r13) {
        Object r14 = this.mLock;
        monitor-enter(r14);
        completeA2dpJitterOptimizationLocked(r8, r10, r11, r12, r13);     // Catch: Throwable -> L7
        monitor-exit(r14);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void markManualDisabledInCurrentAoiLocked(String r8) {
        this.mManualDisabledInCurrentAoi = true;
        this.mManualDisabledAddress = r8;
        this.mManualDisabledAoiLocation = this.mCurrentAoiLocation;
    }

    private void maybeRecoverOptimizedStateLocked() {
        if (this.mAutoStrategyActive == true) goto L5;
        return;
    L5:
        if (this.mInAoi == false) goto L7;
        return;
    L7:
        if (this.mMediaA2dpPlaying == false) goto L9;
        return;
    L9:
        if (this.mA2dpConnected == false) goto L15;
        recoverOptimizedStateLocked();
        return;
    }

    private void onAoiBoardInfoChanged(AoiBoard r8) {
        CaeLog.i(TAG, "onAoiBoardInfoChanged: " + r8);
        if (r8 != null) goto L5;
        return;
    L5:
        if (isTargetTravelAoiBoard(r8) == false) goto L23;
        Object r10 = this.mLock;
        monitor-enter(r10);
        AoiBoard.State r11 = r8.getCurState();     // Catch: Throwable -> L17
        if (r11 != AoiBoard.State.INSIDE) goto L13;
        clearManualDisabledInCurrentAoiLocked();     // Catch: Throwable -> L17
        this.mInAoi = true;     // Catch: Throwable -> L17
        this.mCurrentAoiLocation = buildAoiBoardLocation(r8);     // Catch: Throwable -> L17
        resetMonitoringWindowLocked();     // Catch: Throwable -> L17
        resetPredictorLocked();     // Catch: Throwable -> L17
        updateBqrParamStateLocked();     // Catch: Throwable -> L17
        handleAoiEnteredLocked(this.mCurrentA2dpDevice);     // Catch: Throwable -> L17
    L15:
        monitor-exit(r10);     // Catch: Throwable -> L17
        return;
    L13:
        if (r11 != AoiBoard.State.OUTSIDE) goto L15;
        this.mInAoi = false;     // Catch: Throwable -> L17
        clearManualDisabledInCurrentAoiLocked();     // Catch: Throwable -> L17
        this.mCurrentAoiLocation = null;     // Catch: Throwable -> L17
        resetMonitoringWindowLocked();     // Catch: Throwable -> L17
        resetPredictorLocked();     // Catch: Throwable -> L17
        updateBqrParamStateLocked();     // Catch: Throwable -> L17
        maybeRecoverOptimizedStateLocked();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    private void onAudioPlaybackConfigChanged() {
        Object r8 = this.mLock;
        monitor-enter(r8);
    L28:
        th = move-exception;
        throw th;
    L5:
        if (this.mStarted == true) goto L7;
    L26:
        monitor-exit(r8);     // Catch: Throwable -> L28
        return;
    L7:
        if (this.mFeatureEnabled == false) goto L26;
        if (this.mA2dpPlaying == false) goto L26;
        boolean r10 = this.mMediaA2dpPlaying;     // Catch: Throwable -> L28
        boolean r11 = isMediaPlaybackActive(null);     // Catch: Throwable -> L28
        this.mMediaA2dpPlaying = r11;     // Catch: Throwable -> L28
        if (r10 == r11) goto L14;
        resetMonitoringWindowLocked();     // Catch: Throwable -> L28
        resetPredictorLocked();     // Catch: Throwable -> L28
    L14:
        updateBqrParamStateLocked();     // Catch: Throwable -> L28
        maybeRecoverOptimizedStateLocked();     // Catch: Throwable -> L28
        if (this.mMediaA2dpPlaying == false) goto L24;
        if (r10 == true) goto L24;
        BluetoothDevice r12 = this.mCurrentA2dpDevice;     // Catch: Throwable -> L28
        if (r12 == null) goto L24;
        if (this.mInAoi == false) goto L24;
        String r13 = this.mCurrentAoiLocation;     // Catch: Throwable -> L28
        if (r13 == null) goto L24;
        A2dpJitterMlTeaReporter.reportA2dpStartEvent(r12, r13);     // Catch: Throwable -> L28
        handleAoiEnteredLocked(this.mCurrentA2dpDevice);     // Catch: Throwable -> L28
    L24:
        monitor-exit(r8);     // Catch: Throwable -> L28
    }

    private void onCodecConfigChanged(BluetoothDevice r8, BluetoothCodecStatus r10) {
        CaeLog.i(TAG, "onCodecConfigChanged: " + r10);
        Object r11 = this.mLock;
        monitor-enter(r11);
    L29:
        th = move-exception;
        throw th;
    L5:
        if (this.mFeatureEnabled == true) goto L7;
    L27:
        monitor-exit(r11);     // Catch: Throwable -> L29
        return;
    L7:
        if (this.mAutoStrategyActive == false) goto L27;
        if (isCurrentDeviceLocked(r8) == false) goto L27;
        if (r10 == null) goto L27;
        if (this.mCurrentAoiLocation == null) goto L27;
        BluetoothCodecConfig r12 = r10.getCodecConfig();     // Catch: Throwable -> L29
        if (r12 != null) goto L19;
        monitor-exit(r11);     // Catch: Throwable -> L29
        return;
    L19:
        if (isUserRevertedOptimizedCodec(r12) == false) goto L25;
        if (r8 != null) goto L22;
        String r13 = null;
    L23:
        if (r13 == null) goto L25;
        CaeLog.i(TAG, "user changed codec back after auto optimization, disable: " + r13 + ", aoi=" + this.mCurrentAoiLocation);     // Catch: Throwable -> L29
        markManualDisabledInCurrentAoiLocked(r13);     // Catch: Throwable -> L29
        this.mAutoStrategyActive = false;     // Catch: Throwable -> L29
        this.mAutoStrategyByHistory = false;     // Catch: Throwable -> L29
        resetMonitoringWindowLocked();     // Catch: Throwable -> L29
        goto L25
    L22:
        r13 = r8.getAddress();     // Catch: Throwable -> L29
    L25:
        monitor-exit(r11);     // Catch: Throwable -> L29
    }

    private void onFeatureSwitchChanged() {
        Object r8 = this.mLock;
        monitor-enter(r8);
        boolean r10 = readFeatureEnabled();     // Catch: Throwable -> L20
        if (this.mFeatureEnabled != r10) goto L8;
        monitor-exit(r8);     // Catch: Throwable -> L20
        return;
    L8:
        this.mFeatureEnabled = r10;     // Catch: Throwable -> L20
        CaeLog.i(TAG, "feature switch changed: " + r10);     // Catch: Throwable -> L20
        if (r10 == false) goto L16;
        BluetoothAdapter r11 = this.mAdapter;     // Catch: Throwable -> L20
        if (r11 != null) goto L13;
    L15:
        handleAoiEnteredLocked(this.mCurrentA2dpDevice);     // Catch: Throwable -> L20
    L17:
        updateBqrParamStateLocked();     // Catch: Throwable -> L20
        monitor-exit(r8);     // Catch: Throwable -> L20
        return;
    L13:
        if (r11.isEnabled() == false) goto L15;
        registerBqrLocked();     // Catch: Throwable -> L20
        goto L15
    L16:
        recoverOptimizedStateLocked();     // Catch: Throwable -> L20
        unregisterBqrLocked();     // Catch: Throwable -> L20
        resetRuntimeStateLocked();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    private boolean readFeatureEnabled() {
        if (Settings.Global.getInt(this.mAppContext.getContentResolver(), SETTINGS_GLOBAL_A2DP_JITTER_ML_ENABLED, 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private void recoverOptimizedStateLocked() {
        if (this.mAutoStrategyActive == true) goto L5;
        return;
    L5:
        CaeLog.i(TAG, "recover a2dp jitter optimization.");
        String r8 = this.mA2dpJitterAction.restoreA2dpJitterEvent();
        if (safeString(this.mCurrentAoiLocation).isEmpty() == false) goto L8;
        String r10 = this.mLastPolicyLocation;
    L9:
        int r11 = this.mPolicyActionUndoCount + 1;
        this.mPolicyActionUndoCount = r11;
        A2dpJitterMlTeaReporter.reportA2dpJitterPolicyEvent(0, r8, this.mPolicyActionDoCount, r11, r10);
        this.mAutoStrategyActive = false;
        this.mAutoStrategyByHistory = false;
        clearPendingAutoReconnectLocked();
        resetMonitoringWindowLocked();
        resetPredictorLocked();
        return;
    L8:
        r10 = this.mCurrentAoiLocation;
        goto L9
    }

    private void registerAudioPlaybackCallbackLocked() {
        AudioManager r8 = this.mAudioManager;
        if (r8 != null) goto L10;
        return;
    L10:
        r8.registerAudioPlaybackCallback(this.mAudioPlaybackCallback, this.mAudioPlaybackHandler);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        android.aimedia.a.s(th, new StringBuilder("register audio playback callback failed: "), TAG);
    }

    private void registerBqrLocked() {
        BluetoothAdapter r8 = this.mAdapter;
        if (r8 != null) goto L5;
        return;
    L5:
        if (this.mRegistered == false) goto L7;
        return;
    L7:
        if (this.mFeatureEnabled == false) goto L18;
        r8.registerBluetoothQualityReportReadyCallback(this.mExecutor, this.mBqrCallback);     // Catch: Throwable -> L11
        this.mRegistered = true;     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        android.aimedia.a.s(th, new StringBuilder("register bqr callback failed: "), TAG);
        this.mRegistered = false;
        return;
    }

    private void registerCodecReceiverLocked() {
        if (this.mCodecReceiverRegistered == false) goto L5;
        return;
    L5:
        IntentFilter r8 = new IntentFilter("android.bluetooth.a2dp.profile.action.CODEC_CONFIG_CHANGED");
        if (Build.VERSION.SDK_INT < 33) goto L8;
        this.mAppContext.registerReceiver(this.mCodecConfigReceiver, r8, 2);
    L9:
        this.mCodecReceiverRegistered = true;
        return;
    L8:
        this.mAppContext.registerReceiver(this.mCodecConfigReceiver, r8);
        goto L9
    }

    private void registerSettingsObserverLocked() {
        this.mAppContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor(SETTINGS_GLOBAL_A2DP_JITTER_ML_ENABLED), false, this.mSettingsObserver);
    }

    private void resetMonitoringWindowLocked() {
        this.mSevereJitterHistory.clear();
    }

    private void resetPredictorLocked() {
        A2dpJitterMlPredictor r8 = this.mPredictor;
        if (r8 == null) goto L6;
        r8.reset();
        return;
    }

    private void resetRuntimeStateLocked() {
        recoverOptimizedStateLocked();
        this.mA2dpConnected = false;
        this.mMediaA2dpPlaying = false;
        updateBqrParamStateLocked();
        this.mCurrentA2dpDevice = null;
        this.mAutoStrategyActive = false;
        this.mAutoStrategyByHistory = false;
        clearManualDisabledInCurrentAoiLocked();
        clearPendingAutoReconnectLocked();
        resetMonitoringWindowLocked();
        resetPredictorLocked();
    }

    private String safeString(String r8) {
        if (r8 != null) goto L5;
        return "";
    L5:
        return r8;
    }

    private boolean shouldResumeAutoStrategyLocked(BluetoothDevice r8) {
        if (r8 != null) goto L5;
        return false;
    L5:
        if (r8.getAddress() != null) goto L7;
        return false;
    L7:
        if (this.mPendingAutoReconnectAddress == null) goto L25;
        long r10 = SystemClock.elapsedRealtime();
        if (r8.getAddress().equals(this.mPendingAutoReconnectAddress) == false) goto L21;
        String r11 = this.mCurrentAoiLocation;
        if (r11 != null) goto L14;
        return false;
    L14:
        if (r11.equals(this.mPendingAutoReconnectAoiLocation) == true) goto L16;
        return false;
    L16:
        if ((r10 - this.mAutoDisconnectElapsedMs) > 120000) goto L24;
        return true;
    L24:
        return false;
    L21:
        return false;
    L25:
        return false;
    }

    private void triggerA2dpJitterOptimizationLocked(final BluetoothDevice r10, final boolean r11, final boolean r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.getAddress() != null) goto L6;
        return;
    L6:
        if (this.mCurrentAoiLocation != null) goto L9;
        return;
    L9:
        if (isManualDisabledInCurrentAoiLocked(r10.getAddress()) == false) goto L12;
        CaeLog.i(TAG, "manual disabled in current aoi, skip optimization.");
        return;
    L12:
        final String r8 = this.mCurrentAoiLocation;
        this.mA2dpJitterAction.triggerA2dpJitterEvent(new a(this, r10, r8, r11, r12));
    }

    private void unregisterAudioPlaybackCallbackLocked() {
        AudioManager r8 = this.mAudioManager;
        if (r8 != null) goto L10;
        return;
    L10:
        r8.unregisterAudioPlaybackCallback(this.mAudioPlaybackCallback);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        android.aimedia.a.s(th, new StringBuilder("unregister audio playback callback failed: "), TAG);
    }

    private void unregisterBqrLocked() {
        BluetoothAdapter r8 = this.mAdapter;
        if (r8 != null) goto L5;
        return;
    L5:
        if (this.mRegistered == true) goto L18;
        return;
    L18:
        r8.unregisterBluetoothQualityReportReadyCallback(this.mBqrCallback);     // Catch: Throwable -> L10
    L9:
        this.mRegistered = false;
        return;
    L10:
        th = move-exception;
        CaeLog.w(TAG, "unregister bqr callback failed: " + th.getMessage());     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        this.mRegistered = false;
        throw th;
    }

    private void unregisterCodecReceiverLocked() {
        if (this.mCodecReceiverRegistered == true) goto L15;
        return;
    L15:
        this.mAppContext.unregisterReceiver(this.mCodecConfigReceiver);     // Catch: Throwable -> L8
    L7:
        this.mCodecReceiverRegistered = false;
        return;
    L8:
        th = move-exception;
        CaeLog.w(TAG, "unregister codec receiver failed: " + th.getMessage());     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        this.mCodecReceiverRegistered = false;
        throw th;
    }

    private void unregisterSettingsObserverLocked() {
        this.mAppContext.getContentResolver().unregisterContentObserver(this.mSettingsObserver);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        android.aimedia.a.s(th, new StringBuilder("unregister settings observer failed: "), TAG);
    }

    private void updateBqrParamStateLocked() {
        if (this.mFeatureEnabled == true) goto L5;
    L9:
        boolean r8 = false;
    L10:
        if (r8 == true) goto L12;
    L14:
        if (r8 == false) goto L16;
        return;
    L16:
        if (this.mCustomBqrParamApplied == false) goto L21;
        applyCustomBqrParamLocked(false);
        this.mCustomBqrParamApplied = false;
        return;
    L21:
        return;
    L12:
        if (this.mCustomBqrParamApplied == true) goto L14;
        applyCustomBqrParamLocked(true);
        this.mCustomBqrParamApplied = true;
        return;
    L5:
        if (this.mInAoi == false) goto L9;
        if (this.mMediaA2dpPlaying == false) goto L9;
        r8 = true;
        goto L10
    }

    public boolean isA2dpJitterOptimizationActive() {
        Object r8 = this.mLock;
        monitor-enter(r8);
        boolean r10 = this.mAutoStrategyActive;     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.cae.smartBluetooth.callback.SmartBluetoothEventCallback
    public void onA2dpPlayingStateChangeEventCallback(BluetoothDevice r8, int r10) {
        defpackage.a.i("onA2dpPlayingStateChangeEventCallback: ", r10, TAG);
        Object r11 = this.mLock;
        monitor-enter(r11);
        boolean r12 = this.mMediaA2dpPlaying;     // Catch: Throwable -> L30
        boolean r13 = true;
        if (r10 != 10) goto L7;
        boolean r14 = true;
    L8:
        this.mA2dpPlaying = r14;     // Catch: Throwable -> L30
        if (r14 == true) goto L11;
    L13:
        r13 = false;
    L14:
        this.mMediaA2dpPlaying = r13;     // Catch: Throwable -> L30
        if (r12 == r13) goto L17;
        resetMonitoringWindowLocked();     // Catch: Throwable -> L30
        resetPredictorLocked();     // Catch: Throwable -> L30
    L17:
        updateBqrParamStateLocked();     // Catch: Throwable -> L30
        maybeRecoverOptimizedStateLocked();     // Catch: Throwable -> L30
        if (this.mMediaA2dpPlaying == false) goto L28;
        if (r8 == null) goto L28;
        this.mCurrentA2dpDevice = r8;     // Catch: Throwable -> L30
        if (r12 == false) goto L23;
    L27:
        handleAoiEnteredLocked(r8);     // Catch: Throwable -> L30
        goto L28
    L23:
        if (this.mInAoi == false) goto L27;
        String r15 = this.mCurrentAoiLocation;     // Catch: Throwable -> L30
        if (r15 == null) goto L27;
        A2dpJitterMlTeaReporter.reportA2dpStartEvent(r8, r15);     // Catch: Throwable -> L30
    L28:
        monitor-exit(r11);     // Catch: Throwable -> L30
        return;
    L11:
        if (isMediaPlaybackActive(null) == false) goto L13;
    L7:
        r14 = false;
    L30:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.cae.smartBluetooth.callback.SmartBluetoothEventCallback
    public void onA2dpStateChangeEventCallback(BluetoothDevice r8, int r10) {
        defpackage.a.i("onA2dpStateChangeEventCallback: ", r10, TAG);
        if (r10 != 2) goto L5;
        handleDeviceConnected(r8);
        return;
    L5:
        if (r10 != 0) goto L9;
        handleDeviceDisconnected(r8);
        return;
    }

    @Override // com.obric.cae.smartBluetooth.callback.SmartBluetoothEventCallback
    public void onAdapterStateChangeCallback(int r8) {
        defpackage.a.i("onAdapterStateChangeCallback: ", r8, TAG);
        Object r10 = this.mLock;
        monitor-enter(r10);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (this.mStarted == true) goto L7;
    L17:
        monitor-exit(r10);     // Catch: Throwable -> L19
        return;
    L7:
        if (this.mFeatureEnabled == false) goto L17;
        if (r8 != 12) goto L13;
        registerBqrLocked();     // Catch: Throwable -> L19
    L15:
        monitor-exit(r10);     // Catch: Throwable -> L19
        return;
    L13:
        if (r8 != 10) goto L15;
        unregisterBqrLocked();     // Catch: Throwable -> L19
        this.mA2dpConnected = false;     // Catch: Throwable -> L19
        this.mA2dpPlaying = false;     // Catch: Throwable -> L19
        this.mMediaA2dpPlaying = false;     // Catch: Throwable -> L19
        this.mCustomBqrParamApplied = false;     // Catch: Throwable -> L19
        resetMonitoringWindowLocked();     // Catch: Throwable -> L19
        resetPredictorLocked();     // Catch: Throwable -> L19
        goto L15
    }

    public void setPredictor(A2dpJitterMlPredictor r8) {
        Object r10 = this.mLock;
        monitor-enter(r10);
        this.mPredictor = r8;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void start() {
        Object r8 = this.mLock;
        monitor-enter(r8);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (this.mStarted == false) goto L8;
        monitor-exit(r8);     // Catch: Throwable -> L18
        return;
    L8:
        this.mStarted = true;     // Catch: Throwable -> L18
        SmartBluetoothEventReceiver.registerEventCallback(this);     // Catch: Throwable -> L18
        registerSettingsObserverLocked();     // Catch: Throwable -> L18
        registerCodecReceiverLocked();     // Catch: Throwable -> L18
        registerAudioPlaybackCallbackLocked();     // Catch: Throwable -> L18
        this.mAoiBoardCallbackController.start();     // Catch: Throwable -> L18
        boolean r10 = readFeatureEnabled();     // Catch: Throwable -> L18
        this.mFeatureEnabled = r10;     // Catch: Throwable -> L18
        if (r10 == false) goto L15;
        BluetoothAdapter r11 = this.mAdapter;     // Catch: Throwable -> L18
        if (r11 == null) goto L15;
        if (r11.isEnabled() == false) goto L15;
        registerBqrLocked();     // Catch: Throwable -> L18
    L15:
        CaeLog.i(TAG, "start, feature enabled=" + this.mFeatureEnabled);     // Catch: Throwable -> L18
        monitor-exit(r8);     // Catch: Throwable -> L18
    }

    public void stop() {
        Object r8 = this.mLock;
        monitor-enter(r8);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mStarted == true) goto L8;
        monitor-exit(r8);     // Catch: Throwable -> L11
        return;
    L8:
        SmartBluetoothEventReceiver.unRegisterEventCallback(this);     // Catch: Throwable -> L11
        unregisterBqrLocked();     // Catch: Throwable -> L11
        unregisterCodecReceiverLocked();     // Catch: Throwable -> L11
        unregisterAudioPlaybackCallbackLocked();     // Catch: Throwable -> L11
        unregisterSettingsObserverLocked();     // Catch: Throwable -> L11
        this.mAoiBoardCallbackController.stop();     // Catch: Throwable -> L11
        resetRuntimeStateLocked();     // Catch: Throwable -> L11
        this.mStarted = false;     // Catch: Throwable -> L11
        monitor-exit(r8);     // Catch: Throwable -> L11
    }
}
