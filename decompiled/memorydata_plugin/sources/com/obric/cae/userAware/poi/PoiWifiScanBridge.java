package com.obric.cae.userAware.poi;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.security.dbcipher.utils.CipherConst;
import com.obric.cae.libs.statemachine.e;
import com.obric.cae.location.b;
import com.obric.cae.log.a;
import com.obric.cae.userAware.sensorbridge.SensorBridgeClient;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import vendor.aware.sensorbridge.SensorBridgeEvent;

/* JADX INFO: loaded from: classes3.dex */
public final class PoiWifiScanBridge {
    public static final int BAND_2G = 1;
    public static final int BAND_5G = 2;
    private static final int COMMAND_MESSAGE_ID = 1071;
    private static final int CONFIG_MESSAGE_ID = 1077;
    private static final long CONFIG_QUERY_RETRY_BASE_MS = 1000;
    private static final String CSV_SUFFIX = ".csv";
    private static final int DEBUG_MESSAGE_ID = 1074;
    private static final int DELIVERY_WAKEUP = 0;
    private static final int LEAVE_MESSAGE_ID = 1075;
    private static final String LEGACY_LOG_PREFIX = "poi-wifi-";
    private static final int MAX_CONFIG_QUERY_RETRIES = 3;
    private static final int MAX_LEGACY_LOG_DELETIONS = 100;
    private static final int MAX_LEGACY_VERIFY_IDS = 64;
    private static final int MAX_LOGS = 200;
    public static final int PREF_DEFAULT = 0;
    public static final int PREF_HIGH_ACCURACY = 3;
    public static final int PREF_LOW_LATENCY = 1;
    public static final int PREF_LOW_POWER = 2;
    private static final int RECORD_SIZE = 12;
    public static final int REPORT_FULL = 2;
    public static final int REPORT_OFF = 0;
    public static final int REPORT_SUMMARY = 1;
    private static final int REQUEST_SCOPE_COMMAND = 4;
    private static final int RESULT_MESSAGE_ID = 1073;
    public static final int SCAN_ACTIVE = 0;
    public static final int SCAN_ACTIVE_DFS = 1;
    public static final int SCAN_PASSIVE = 2;
    public static final int SCHEDULE_MONITOR = 2;
    public static final int SCHEDULE_REQUEST_PERIODIC = 1;
    private static final String SENSOR_NAME = "poi_wifi_scan";
    private static final int STATUS_ACK = 2;
    private static final int STATUS_ERROR = 3;
    private static final int STATUS_MESSAGE_ID = 1072;
    private static final int STATUS_READY = 1;
    private static final int STATUS_SCAN_COMPLETE = 4;
    public static final int STORE_SITTABLE = 1;
    public static final int STORE_UNKNOWN = 0;
    public static final int STORE_WALKABLE = 2;
    private static final String TAG = "PoiWifiScanBridge";
    public static final int TASK_DEBUG_PERIODIC = 1;
    public static final int TASK_LEAVE_DETECTION = 2;
    private static final String TOKENIZED_LOG_PREFIX = "poi-wifi-v2-tokenized-";
    private static final int VERIFY_MESSAGE_ID = 1076;
    private static PoiWifiScanBridge sInstance;
    private int mAcceptedEventConfigVersion;
    private int mAcceptedEventId;
    private int mAcceptedEventSessionEpoch;
    private int mAcceptedEventType;
    private boolean mActive;
    private int mActiveIdentityConfigVersion;
    private int mActiveIdentitySessionEpoch;
    private int mActiveIdentityStoreType;
    private int mActiveIdentityTaskType;
    private int mAnchorApMedian;
    private int mAnchorOverflowCount;
    private int mAnchorScanCount;
    private int mAnchorStableCount;
    private int mBackgroundAnchorCount;
    private int mBusyCount;
    private int mCandidateCount;
    private SensorBridgeClient mClient;
    private int mClientId;
    private Config mConfig;
    private boolean mConfigMutationRecoveryPending;
    private int mConfigOperationGeneration;
    private int mConfigQueryRetryCount;
    private int mConfigQueryRetryGeneration;
    private int mConfigVersion;
    private boolean mConnected;
    private final Context mContext;
    private int mContinuousMotionSeconds;
    private int mCoreAnchorCount;
    private int mCurrentApCount;
    private String mCurrentLogPath;
    private boolean mDbsCandidate;
    private boolean mDbsConfirmed;
    private int mDelta8Percent;
    private int mDensityPercent;
    private Bundle mEffectiveConfig;
    private boolean mExited;
    private int mFailureCount;
    private boolean mHasActiveIdentity;
    private boolean mHasExplicitAlgorithmConfig;
    private boolean mIdentityVerifySent;
    private int mLastDecodedTotal;
    private int mLastDurationMs;
    private int mLastError;
    private int mLastLeaveEventId;
    private int mLastLeaveReason;
    private int mLastResultTotal;
    private int mLastScanId;
    private int mLeavePhase;
    private final ArrayDeque<Integer> mLegacyVerifyEventIds;
    private final CopyOnWriteArrayList<Listener> mListeners;
    private final File mLogDirectory;
    private final ArrayDeque<String> mLogs;
    private final Handler mMainHandler;
    private int mMigrationReason;
    private final AtomicInteger mNextRequestId;
    private int mPendingConfigQueryGeneration;
    private int mPendingConfigQueryRequestId;
    private int mPendingIdentityCommand;
    private int mPendingIdentityConfigVersion;
    private int mPendingIdentityRequestId;
    private int mPendingIdentitySessionEpoch;
    private int mPendingIdentityStoreType;
    private int mPendingIdentityTaskType;
    private int mPendingRecoveryConfigQueryGeneration;
    private int mPendingRecoveryConfigQueryRequestId;
    private boolean mPendingResetConfig;
    private Config mPendingStartConfig;
    private Config mPendingUpdateConfig;
    private boolean mReady;
    private int mRecent40Steps;
    private int mRecent60Steps;
    private boolean mResetAwaitingConfig;
    private int mRssiMedianDeltaDb;
    private int mScanCount;
    private int mScannedBandMask;
    private boolean mScanning;
    private final int mSessionEpoch;
    private int mSharedBssidCount;
    private int mSharedStableCount;
    private boolean mSittableCandidateActive;
    private boolean mSittableLockout;
    private int mStableRetentionPercent;
    private int mStationaryAfterMotionSeconds;
    private int mStepsSinceStoreConfirmed;
    private int mStoreType;
    private boolean mStrongWifiExit;
    private boolean mSubscribed;
    private int mSuccessCount;
    private boolean mTimeoutRescuePending;
    private int mWifiCapabilities;
    private boolean mWifiMigrated;
    private int mWifiVersion;

    public static final class Config {
        public int algorithmVersion;
        public int anchorFrameCount;
        public int anchorIntervalSeconds;
        public int anchorMaxMadDb;
        public int anchorMinHits;
        public int anchorMinStableCount;
        public int backgroundWeightQuarters;
        public int bandMask;
        public int configVersion;
        public int coreRssiThresholdAbsDbm;
        public int coreWeightQuarters;
        public int delta8MinPercent;
        public int eventAckTimeoutSeconds;
        public int expectedConfigVersion;
        public int followUpIntervalSeconds;
        public int[] frequenciesMhz;
        public int gateCheckSeconds;
        public int identityHandoffStationary60sSteps;
        public int identityHandoffStepThreshold;
        public int intervalSeconds;
        public int lowRetainAnchorMinCount;
        public int lowRetainDensityMinPercent;
        public int lowRetainMaxPercent;
        public int maxScanAgeMs;
        public int migrationConfirmFrames;
        public int minimumAnchorCountForStrongExit;
        public int minimumStrongExitDensityPercent;
        public int monitorIntervalSeconds;
        public int radioChainPref;
        public int reportMode;
        public int retryBackoffInitialSeconds;
        public int retryBackoffMaxSeconds;
        public int rssiMedianDeltaMinDb;
        public int rssiShiftDensityMinPercent;
        public int scanType;
        public int scanWake60sMinSteps;
        public int scanWatchdogSeconds;
        public int scheduleMode;
        public int sharedStableMinCount;
        public int sittableKeep60sSteps;
        public int sittableStart60sSteps;
        public int storeConfirmedElapsedMs;
        public int storeType;
        public int strongExitMaxSharedBssid;
        public int taskType;
        public int walkableFirst40sSteps;
        public int walkableFirst60sSteps;

        public Config() {
            this.expectedConfigVersion = -1;
            this.algorithmVersion = 130;
            this.scanWatchdogSeconds = 30;
            this.eventAckTimeoutSeconds = 5;
            this.retryBackoffInitialSeconds = 5;
            this.retryBackoffMaxSeconds = 20;
            this.minimumAnchorCountForStrongExit = 8;
            this.minimumStrongExitDensityPercent = 25;
            this.anchorFrameCount = 5;
            this.anchorMinHits = 4;
            this.anchorMaxMadDb = 10;
            this.anchorMinStableCount = 8;
            this.coreWeightQuarters = 4;
            this.backgroundWeightQuarters = 3;
            this.anchorIntervalSeconds = 20;
            this.monitorIntervalSeconds = 60;
            this.followUpIntervalSeconds = 20;
            this.gateCheckSeconds = 5;
            this.scanWake60sMinSteps = 10;
            this.sittableStart60sSteps = 60;
            this.sittableKeep60sSteps = 30;
            this.walkableFirst40sSteps = 40;
            this.walkableFirst60sSteps = 60;
            this.migrationConfirmFrames = 2;
            this.sharedStableMinCount = 8;
            this.rssiMedianDeltaMinDb = 6;
            this.delta8MinPercent = 50;
            this.rssiShiftDensityMinPercent = 80;
            this.lowRetainAnchorMinCount = 8;
            this.lowRetainMaxPercent = 20;
            this.lowRetainDensityMinPercent = 50;
            this.coreRssiThresholdAbsDbm = 75;
            this.identityHandoffStepThreshold = TypedValues.TransitionType.TYPE_DURATION;
            this.identityHandoffStationary60sSteps = 20;
            this.taskType = 1;
            this.scheduleMode = 1;
            this.intervalSeconds = 20;
            this.reportMode = 0;
            this.scanType = 1;
            this.bandMask = 3;
            this.radioChainPref = 1;
            this.storeType = 0;
            this.frequenciesMhz = new int[0];
        }

        public Config copy() {
            Config r0 = new Config();
            r0.configVersion = this.configVersion;
            r0.expectedConfigVersion = this.expectedConfigVersion;
            r0.algorithmVersion = this.algorithmVersion;
            r0.storeConfirmedElapsedMs = this.storeConfirmedElapsedMs;
            r0.scanWatchdogSeconds = this.scanWatchdogSeconds;
            r0.eventAckTimeoutSeconds = this.eventAckTimeoutSeconds;
            r0.retryBackoffInitialSeconds = this.retryBackoffInitialSeconds;
            r0.retryBackoffMaxSeconds = this.retryBackoffMaxSeconds;
            r0.minimumAnchorCountForStrongExit = this.minimumAnchorCountForStrongExit;
            r0.minimumStrongExitDensityPercent = this.minimumStrongExitDensityPercent;
            r0.anchorFrameCount = this.anchorFrameCount;
            r0.anchorMinHits = this.anchorMinHits;
            r0.anchorMaxMadDb = this.anchorMaxMadDb;
            r0.anchorMinStableCount = this.anchorMinStableCount;
            r0.coreWeightQuarters = this.coreWeightQuarters;
            r0.backgroundWeightQuarters = this.backgroundWeightQuarters;
            r0.anchorIntervalSeconds = this.anchorIntervalSeconds;
            r0.monitorIntervalSeconds = this.monitorIntervalSeconds;
            r0.followUpIntervalSeconds = this.followUpIntervalSeconds;
            r0.gateCheckSeconds = this.gateCheckSeconds;
            r0.scanWake60sMinSteps = this.scanWake60sMinSteps;
            r0.sittableStart60sSteps = this.sittableStart60sSteps;
            r0.sittableKeep60sSteps = this.sittableKeep60sSteps;
            r0.walkableFirst40sSteps = this.walkableFirst40sSteps;
            r0.walkableFirst60sSteps = this.walkableFirst60sSteps;
            r0.migrationConfirmFrames = this.migrationConfirmFrames;
            r0.sharedStableMinCount = this.sharedStableMinCount;
            r0.rssiMedianDeltaMinDb = this.rssiMedianDeltaMinDb;
            r0.delta8MinPercent = this.delta8MinPercent;
            r0.rssiShiftDensityMinPercent = this.rssiShiftDensityMinPercent;
            r0.lowRetainAnchorMinCount = this.lowRetainAnchorMinCount;
            r0.lowRetainMaxPercent = this.lowRetainMaxPercent;
            r0.lowRetainDensityMinPercent = this.lowRetainDensityMinPercent;
            r0.strongExitMaxSharedBssid = this.strongExitMaxSharedBssid;
            r0.coreRssiThresholdAbsDbm = this.coreRssiThresholdAbsDbm;
            r0.identityHandoffStepThreshold = this.identityHandoffStepThreshold;
            r0.identityHandoffStationary60sSteps = this.identityHandoffStationary60sSteps;
            r0.taskType = this.taskType;
            r0.scheduleMode = this.scheduleMode;
            r0.intervalSeconds = this.intervalSeconds;
            r0.reportMode = this.reportMode;
            r0.scanType = this.scanType;
            r0.bandMask = this.bandMask;
            r0.maxScanAgeMs = this.maxScanAgeMs;
            r0.radioChainPref = this.radioChainPref;
            r0.storeType = this.storeType;
            int[] r2 = this.frequenciesMhz;
            r0.frequenciesMhz = Arrays.copyOf(r2, r2.length);
            return r0;
        }
    }

    public interface Listener {
        default void onWifiIdentityVerificationRequested(Bundle r1) {
        }

        default void onWifiLeaveDetected(Bundle r1) {
        }

        void onWifiScanStateChanged();
    }

    private PoiWifiScanBridge(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mNextRequestId = new AtomicInteger(1);
        this.mListeners = new CopyOnWriteArrayList();
        this.mLogs = new ArrayDeque();
        this.mSessionEpoch = (int) (System.currentTimeMillis() ^ SystemClock.elapsedRealtime());
        this.mConfig = new Config();
        this.mLegacyVerifyEventIds = new ArrayDeque();
        this.mCurrentLogPath = "";
        this.mEffectiveConfig = new Bundle();
        this.mContext = ZeusTransformUtils.wrapperContext(r8, "com.obric.memorydata.plugin");
        this.mLogDirectory = new File(r8.getFilesDir(), SENSOR_NAME);
    }

    public static /* synthetic */ int access$008(PoiWifiScanBridge r2) {
        int r0 = r2.mConfigOperationGeneration;
        r2.mConfigOperationGeneration = r0 + 1;
        return r0;
    }

    public static /* synthetic */ void access$100(PoiWifiScanBridge r0) {
        r0.clearProtocolIdentityLocked();
    }

    public static /* synthetic */ boolean access$1002(PoiWifiScanBridge r0, boolean r1) {
        r0.mSubscribed = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$1102(PoiWifiScanBridge r0, boolean r1) {
        r0.mReady = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$1202(PoiWifiScanBridge r0, boolean r1) {
        r0.mActive = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$1302(PoiWifiScanBridge r0, boolean r1) {
        r0.mScanning = r1;
        return r1;
    }

    public static /* synthetic */ void access$1400(PoiWifiScanBridge r0, SensorBridgeEvent[] r1) {
        r0.handleEvents(r1);
    }

    public static /* synthetic */ int access$1502(PoiWifiScanBridge r0, int r1) {
        r0.mLastError = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$202(PoiWifiScanBridge r0, boolean r1) {
        r0.mConfigMutationRecoveryPending = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$302(PoiWifiScanBridge r0, boolean r1) {
        r0.mConnected = r1;
        return r1;
    }

    public static /* synthetic */ int access$402(PoiWifiScanBridge r0, int r1) {
        r0.mClientId = r1;
        return r1;
    }

    public static /* synthetic */ void access$500(PoiWifiScanBridge r0, String r1) {
        r0.addLogLocked(r1);
    }

    public static /* synthetic */ void access$600(PoiWifiScanBridge r0) {
        r0.subscribeLocked();
    }

    public static /* synthetic */ void access$700(PoiWifiScanBridge r0) {
        r0.notifyChanged();
    }

    public static /* synthetic */ boolean access$800(PoiWifiScanBridge r0) {
        return r0.mResetAwaitingConfig;
    }

    public static /* synthetic */ boolean access$902(PoiWifiScanBridge r0, boolean r1) {
        r0.mPendingResetConfig = r1;
        return r1;
    }

    private void addLogLocked(String r4) {
        String r0 = System.currentTimeMillis() + " " + r4;
        if (this.mLogs.size() < 200) goto L5;
        this.mLogs.removeFirst();
    L5:
        this.mLogs.addLast(r0);
        a.e(TAG, r4);
    }

    private String apToken(byte[] r5, int r6) {
        MessageDigest r0 = MessageDigest.getInstance(CryptoConst.ALGORITHM_SHA256);     // Catch: NoSuchAlgorithmException -> L10
        r0.update((byte) this.mSessionEpoch);     // Catch: NoSuchAlgorithmException -> L10
        r0.update((byte) (this.mSessionEpoch >>> 8));     // Catch: NoSuchAlgorithmException -> L10
        r0.update((byte) (this.mSessionEpoch >>> 16));     // Catch: NoSuchAlgorithmException -> L10
        r0.update((byte) (this.mSessionEpoch >>> 24));     // Catch: NoSuchAlgorithmException -> L10
        r0.update(r5, r6, 6);     // Catch: NoSuchAlgorithmException -> L10
        byte[] r7 = r0.digest();     // Catch: NoSuchAlgorithmException -> L10
        StringBuilder r8 = new StringBuilder(12);     // Catch: NoSuchAlgorithmException -> L10
        int r1 = 0;
    L3:
        if (r1 >= 6) goto L8;
        int r2 = r7[r1] & 255;     // Catch: NoSuchAlgorithmException -> L10
        if (r2 >= 16) goto L7;
        r8.append('0');     // Catch: NoSuchAlgorithmException -> L10
    L7:
        r8.append(Integer.toHexString(r2));     // Catch: NoSuchAlgorithmException -> L10
        r1 = r1 + 1;     // Catch: NoSuchAlgorithmException -> L10
        goto L3
    L8:
        return r8.toString();
    L10:
        e = move-exception;
        throw new IllegalStateException("SHA-256 unavailable", e);
    }

    private void appendFileLocked(String r6) {
        if (this.mConfig.reportMode != 0) goto L5;
        return;
    L5:
        if (this.mCurrentLogPath.isEmpty() == true) goto L30;
        File r0 = new File(this.mCurrentLogPath);
        if (r0.length() <= 10485760) goto L26;
        addLogLocked("LOG_LIMIT_REACHED " + this.mCurrentLogPath);
        this.mCurrentLogPath = "";
        return;
    L26:
        FileWriter r5 = new FileWriter(r0, true);     // Catch: IOException -> L21
        r5.write(r6);     // Catch: Throwable -> L15
        r5.write(10);     // Catch: Throwable -> L15
        r5.close();     // Catch: IOException -> L21
        return;
    L15:
        th = move-exception;
        r5.close();     // Catch: Throwable -> L18
    L20:
        throw th;     // Catch: IOException -> L21
    L18:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L21
    L21:
        e = move-exception;
        a.a(TAG, "append log failed", e);
        return;
    }

    private void appendSummaryLocked() {
        appendFileLocked("#summary," + this.mLastScanId + "," + this.mLastResultTotal + "," + this.mLastDecodedTotal + "," + this.mLastDurationMs + ",0x" + Integer.toHexString(this.mScannedBandMask));
    }

    private void appendTraceRecordIfPresent(PoiWifiScanCodec.Event r14, Bundle r15) {
        if (r14.hasVarintField(51) == true) goto L5;
        return;
    L5:
        Bundle r1 = new Bundle(r15);
        int r16 = r14.intValue(52, 0);
        int r10 = r14.intValue(53, 0);
        int r12 = r14.intValue(54, 1);
        r1.putLong("adspTick", r14.longValue(48, 0));
        r1.putInt("sessionEpoch", r14.intValue(49, this.mSessionEpoch));
        r1.putInt("configVersion", r14.intValue(50, this.mConfig.configVersion));
        r1.putInt("traceRecordType", r14.intValue(51, 0));
        r1.putInt("dumpId", r16);
        r1.putInt("traceIndex", r10);
        r1.putInt("traceCount", r12);
        r1.putInt("traceDecision", r14.intValue(55, 0));
        r1.putInt("traceDecisionReason", r14.intValue(56, 0));
        PoiAdspTraceLogger r13 = PoiAdspTraceLogger.getInstance(this.mContext);
        if (r16 != 0) goto L8;
        String r17 = "LEAVE_EVENT";
    L9:
        if (r16 == 0) goto L12;
        if (r10 != 0) goto L12;
        r13.append("dump_begin", r17, SENSOR_NAME, "TRACE_DUMP_BEGIN", "NOOP", "MANUAL_DUMP", r1);
    L12:
        r13.append("trace", r17, SENSOR_NAME, "ADSP_DECISION_TRACE", "NOOP", "TRACE_RECORD", r1);
        if (r16 != 0) goto L15;
        return;
    L15:
        if ((r10 + 1) < r12) goto L19;
        r13.append("dump_end", r17, SENSOR_NAME, "TRACE_DUMP_END", "NOOP", "MANUAL_DUMP", r1);
        return;
    L19:
        return;
    L8:
        r17 = "MANUAL_DUMP";
        goto L9
    }

    private void cancelConfigQueryRetryLocked() {
        this.mConfigQueryRetryGeneration++;
        this.mConfigQueryRetryCount = 0;
    }

    private void clearAcceptedEventLocked() {
        this.mAcceptedEventType = 0;
        this.mAcceptedEventId = 0;
        this.mAcceptedEventSessionEpoch = 0;
        this.mAcceptedEventConfigVersion = 0;
    }

    private void clearLegacyVerifyLocked() {
        this.mLegacyVerifyEventIds.clear();
    }

    private void clearPendingIdentityLocked() {
        this.mPendingIdentityRequestId = 0;
        this.mPendingIdentityCommand = 0;
        this.mPendingIdentitySessionEpoch = 0;
        this.mPendingIdentityConfigVersion = 0;
        this.mPendingIdentityTaskType = 0;
        this.mPendingIdentityStoreType = 0;
    }

    private void clearProtocolIdentityLocked() {
        cancelConfigQueryRetryLocked();
        clearPendingIdentityLocked();
        this.mPendingConfigQueryRequestId = 0;
        this.mPendingRecoveryConfigQueryRequestId = 0;
        this.mPendingConfigQueryGeneration = 0;
        this.mPendingRecoveryConfigQueryGeneration = 0;
        this.mHasActiveIdentity = false;
        this.mActiveIdentitySessionEpoch = 0;
        this.mActiveIdentityConfigVersion = 0;
        this.mActiveIdentityTaskType = 0;
        this.mActiveIdentityStoreType = 0;
        clearAcceptedEventLocked();
    }

    private void deleteLegacyLogsLocked() {
        File[] r0 = this.mLogDirectory.listFiles();
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = r0.length;
        int r2 = 0;
        int r3 = 0;
    L6:
        if (r2 >= r1) goto L32;
        File r4 = r0[r2];
        String r5 = r4.getName();
        if (r4.isFile() == false) goto L22;
        if (r5.startsWith(LEGACY_LOG_PREFIX) == false) goto L22;
        if (r5.startsWith(TOKENIZED_LOG_PREFIX) == true) goto L22;
        if (r5.endsWith(CSV_SUFFIX) == false) goto L22;
        if (r3 >= 100) goto L18;
        r3 = r3 + 1;
        if (r4.delete() == true) goto L22;
        addLogLocked("LEGACY_LOG_DELETE_FAILED ".concat(r5));
        goto L22
    L18:
        addLogLocked("LEGACY_LOG_CLEANUP_LIMIT");
        return;
    L22:
        r2 = r2 + 1;
        goto L6
    }

    private Config desiredConfigLocked() {
        Config r0 = this.mPendingUpdateConfig;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return this.mConfig;
    }

    private void dispatchPendingResetLocked() {
        if (this.mPendingResetConfig == true) goto L5;
        return;
    L5:
        if (this.mConnected == true) goto L7;
        return;
    L7:
        if (this.mReady == true) goto L9;
        return;
    L9:
        if (this.mPendingStartConfig == null) goto L11;
        return;
    L11:
        if (this.mPendingUpdateConfig == null) goto L13;
        return;
    L13:
        if (this.mPendingIdentityRequestId == 0) goto L15;
        return;
    L15:
        if (this.mConfigMutationRecoveryPending == false) goto L17;
        return;
    L17:
        if (this.mPendingRecoveryConfigQueryRequestId != 0) goto L28;
        this.mPendingResetConfig = false;
        Config r0 = this.mConfig;
        int r1 = this.mConfigVersion;
        r0.expectedConfigVersion = r1;
        int r2 = r1 + 1;
        this.mConfigVersion = r2;
        r0.configVersion = r2;
        sendCommandLocked(8);
        return;
    }

    private void dispatchPendingUpdateLocked() {
        Config r0 = this.mPendingUpdateConfig;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mConnected == true) goto L7;
        return;
    L7:
        if (this.mReady == true) goto L9;
        return;
    L9:
        if (this.mPendingStartConfig == null) goto L11;
        return;
    L11:
        if (this.mPendingIdentityRequestId == 0) goto L13;
        return;
    L13:
        if (this.mConfigMutationRecoveryPending == false) goto L15;
        return;
    L15:
        if (this.mPendingRecoveryConfigQueryRequestId != 0) goto L25;
        this.mPendingUpdateConfig = null;
        sendUpdateLocked(r0);
        return;
    }

    public static synchronized PoiWifiScanBridge getInstance(Context r4) {
        monitor-enter(PoiWifiScanBridge.class);
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (sInstance != null) goto L7;
        sInstance = new PoiWifiScanBridge((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L10
    L7:
        PoiWifiScanBridge r6 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(PoiWifiScanBridge.class);
        return r6;
    L10:
        th = move-exception;
        throw th;
    }

    private synchronized void handleDebug(PoiWifiScanCodec.Event r11) {
        monitor-enter(this);
        this.mScannedBandMask = r11.intValue(7, this.mScannedBandMask);     // Catch: Throwable -> L13
        this.mWifiCapabilities = r11.intValue(9, this.mWifiCapabilities);     // Catch: Throwable -> L13
        this.mScanCount = r11.intValue(10, this.mScanCount);     // Catch: Throwable -> L13
        this.mSuccessCount = r11.intValue(11, this.mSuccessCount);     // Catch: Throwable -> L13
        this.mFailureCount = r11.intValue(12, this.mFailureCount);     // Catch: Throwable -> L13
        this.mBusyCount = r11.intValue(13, this.mBusyCount);     // Catch: Throwable -> L13
        this.mLastResultTotal = r11.intValue(14, this.mLastResultTotal);     // Catch: Throwable -> L13
        this.mLastDecodedTotal = r11.intValue(15, this.mLastDecodedTotal);     // Catch: Throwable -> L13
        this.mLastDurationMs = r11.intValue(16, this.mLastDurationMs);     // Catch: Throwable -> L13
        this.mActive = r11.boolValue(17, this.mActive);     // Catch: Throwable -> L13
        this.mScanning = r11.boolValue(18, this.mScanning);     // Catch: Throwable -> L13
        this.mDbsCandidate = r11.boolValue(19, false);     // Catch: Throwable -> L13
        this.mDbsConfirmed = r11.boolValue(20, false);     // Catch: Throwable -> L13
        this.mLastError = r11.intValue(21, this.mLastError);     // Catch: Throwable -> L13
        this.mLeavePhase = r11.intValue(22, this.mLeavePhase);     // Catch: Throwable -> L13
        this.mAnchorScanCount = r11.intValue(23, this.mAnchorScanCount);     // Catch: Throwable -> L13
        this.mAnchorStableCount = r11.intValue(24, this.mAnchorStableCount);     // Catch: Throwable -> L13
        this.mAnchorApMedian = r11.intValue(25, this.mAnchorApMedian);     // Catch: Throwable -> L13
        this.mCurrentApCount = r11.intValue(26, this.mCurrentApCount);     // Catch: Throwable -> L13
        this.mSharedStableCount = r11.intValue(27, this.mSharedStableCount);     // Catch: Throwable -> L13
        this.mStableRetentionPercent = r11.intValue(28, this.mStableRetentionPercent);     // Catch: Throwable -> L13
        this.mRssiMedianDeltaDb = r11.intValue(29, this.mRssiMedianDeltaDb);     // Catch: Throwable -> L13
        this.mDelta8Percent = r11.intValue(30, this.mDelta8Percent);     // Catch: Throwable -> L13
        this.mDensityPercent = r11.intValue(31, this.mDensityPercent);     // Catch: Throwable -> L13
        this.mRecent40Steps = r11.intValue(32, this.mRecent40Steps);     // Catch: Throwable -> L13
        this.mRecent60Steps = r11.intValue(33, this.mRecent60Steps);     // Catch: Throwable -> L13
        this.mContinuousMotionSeconds = r11.intValue(34, this.mContinuousMotionSeconds);     // Catch: Throwable -> L13
        this.mStationaryAfterMotionSeconds = r11.intValue(35, this.mStationaryAfterMotionSeconds);     // Catch: Throwable -> L13
        this.mCandidateCount = r11.intValue(36, this.mCandidateCount);     // Catch: Throwable -> L13
        this.mWifiMigrated = r11.boolValue(37, this.mWifiMigrated);     // Catch: Throwable -> L13
        this.mMigrationReason = r11.intValue(38, this.mMigrationReason);     // Catch: Throwable -> L13
        this.mStoreType = r11.intValue(39, this.mStoreType);     // Catch: Throwable -> L13
        this.mExited = r11.boolValue(40, this.mExited);     // Catch: Throwable -> L13
        this.mLastLeaveReason = r11.intValue(41, this.mLastLeaveReason);     // Catch: Throwable -> L13
        this.mCoreAnchorCount = r11.intValue(42, this.mCoreAnchorCount);     // Catch: Throwable -> L13
        this.mBackgroundAnchorCount = r11.intValue(43, this.mBackgroundAnchorCount);     // Catch: Throwable -> L13
        this.mAnchorOverflowCount = r11.intValue(44, this.mAnchorOverflowCount);     // Catch: Throwable -> L13
        this.mSittableCandidateActive = r11.boolValue(45, this.mSittableCandidateActive);     // Catch: Throwable -> L13
        this.mSittableLockout = r11.boolValue(46, this.mSittableLockout);     // Catch: Throwable -> L13
        this.mTimeoutRescuePending = r11.boolValue(47, this.mTimeoutRescuePending);     // Catch: Throwable -> L13
        this.mStepsSinceStoreConfirmed = r11.intValue(59, this.mStepsSinceStoreConfirmed);     // Catch: Throwable -> L13
        this.mIdentityVerifySent = r11.boolValue(60, this.mIdentityVerifySent);     // Catch: Throwable -> L13
        this.mSharedBssidCount = r11.intValue(57, this.mSharedBssidCount);     // Catch: Throwable -> L13
        this.mStrongWifiExit = r11.boolValue(58, this.mStrongWifiExit);     // Catch: Throwable -> L13
        addLogLocked("DEBUG scans=" + this.mScanCount + "/" + this.mSuccessCount + "/" + this.mFailureCount + " busy=" + this.mBusyCount + " bands=0x" + Integer.toHexString(this.mScannedBandMask) + " dbsCandidate=" + this.mDbsCandidate + " dbsConfirmed=" + this.mDbsConfirmed + " phase=" + this.mLeavePhase + " anchor=" + this.mAnchorScanCount + " retain=" + this.mStableRetentionPercent + "% d8=" + this.mDelta8Percent + "% steps=" + this.mRecent40Steps + "/" + this.mRecent60Steps + " candidate=" + this.mCandidateCount + " migrated=" + this.mWifiMigrated + " migrationReason=" + this.mMigrationReason + " sharedBssid=" + this.mSharedBssidCount + " strongWifiExit=" + this.mStrongWifiExit + " exited=" + this.mExited);     // Catch: Throwable -> L13
        Bundle r0 = new Bundle();     // Catch: Throwable -> L13
        r0.putInt("requestId", r11.intValue(1, 0));     // Catch: Throwable -> L13
        r0.putInt("sessionEpoch", this.mSessionEpoch);     // Catch: Throwable -> L13
        r0.putInt("configVersion", this.mConfig.configVersion);     // Catch: Throwable -> L13
        r0.putInt("scanId", this.mLastScanId);     // Catch: Throwable -> L13
        r0.putInt("leavePhase", this.mLeavePhase);     // Catch: Throwable -> L13
        r0.putInt("anchorScanCount", this.mAnchorScanCount);     // Catch: Throwable -> L13
        r0.putInt("anchorStableCount", this.mAnchorStableCount);     // Catch: Throwable -> L13
        r0.putInt("wifiTotalAp", this.mLastResultTotal);     // Catch: Throwable -> L13
        r0.putInt("wifiDecodedAp", this.mLastDecodedTotal);     // Catch: Throwable -> L13
        r0.putInt("sharedStableCount", this.mSharedStableCount);     // Catch: Throwable -> L13
        r0.putInt("sharedBssidCount", this.mSharedBssidCount);     // Catch: Throwable -> L13
        r0.putInt("stableRetentionPercent", this.mStableRetentionPercent);     // Catch: Throwable -> L13
        r0.putInt("rssiMedianDeltaDb", this.mRssiMedianDeltaDb);     // Catch: Throwable -> L13
        r0.putInt("delta8Percent", this.mDelta8Percent);     // Catch: Throwable -> L13
        r0.putInt("densityPercent", this.mDensityPercent);     // Catch: Throwable -> L13
        r0.putInt("recent40Steps", this.mRecent40Steps);     // Catch: Throwable -> L13
        r0.putInt("recent60Steps", this.mRecent60Steps);     // Catch: Throwable -> L13
        r0.putInt("candidateCount", this.mCandidateCount);     // Catch: Throwable -> L13
        r0.putBoolean("wifiMigrated", this.mWifiMigrated);     // Catch: Throwable -> L13
        r0.putBoolean("strongWifiExit", this.mStrongWifiExit);     // Catch: Throwable -> L13
        r0.putInt("migrationReason", this.mMigrationReason);     // Catch: Throwable -> L13
        r0.putInt("storeType", this.mStoreType);     // Catch: Throwable -> L13
        r0.putBoolean("exited", this.mExited);     // Catch: Throwable -> L13
        r0.putInt("lastError", this.mLastError);     // Catch: Throwable -> L13
        if (r11.hasVarintField(51) == true) goto L10;
        PoiAdspTraceLogger r2 = PoiAdspTraceLogger.getInstance(this.mContext);     // Catch: Throwable -> L13
        if (this.mWifiMigrated == false) goto L8;
        String r1 = "WIFI_MIGRATED";
    L9:
        r2.append("snapshot", "MANUAL_DUMP", SENSOR_NAME, "DEBUG_SNAPSHOT", "NOOP", r1, r0);     // Catch: Throwable -> L13
        goto L10
    L8:
        r1 = "WIFI_STABLE";
    L10:
        appendTraceRecordIfPresent(r11, r0);     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private void handleEvents(SensorBridgeEvent[] r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        int r0 = r5.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L11;
        SensorBridgeEvent r2 = r5[r1];
        if (r2 == null) goto L10;
        handleEvent(r2.messageId, r2.payload);
    L10:
        r1 = r1 + 1;
        goto L5
    L11:
        notifyChanged();
    }

    private synchronized Bundle handleLeave(PoiWifiScanCodec.Event r6) {
        monitor-enter(this);
        this.mLastLeaveEventId = r6.intValue(1, this.mLastLeaveEventId);     // Catch: Throwable -> L6
        this.mLastLeaveReason = r6.intValue(2, this.mLastLeaveReason);     // Catch: Throwable -> L6
        this.mStableRetentionPercent = r6.intValue(4, this.mStableRetentionPercent);     // Catch: Throwable -> L6
        this.mDelta8Percent = r6.intValue(5, this.mDelta8Percent);     // Catch: Throwable -> L6
        this.mRecent40Steps = r6.intValue(6, this.mRecent40Steps);     // Catch: Throwable -> L6
        this.mRecent60Steps = r6.intValue(7, this.mRecent60Steps);     // Catch: Throwable -> L6
        this.mCandidateCount = r6.intValue(8, this.mCandidateCount);     // Catch: Throwable -> L6
        this.mMigrationReason = r6.intValue(9, this.mMigrationReason);     // Catch: Throwable -> L6
        this.mStoreType = r6.intValue(10, this.mStoreType);     // Catch: Throwable -> L6
        int r0 = r6.intValue(11, 0);     // Catch: Throwable -> L6
        int r7 = r6.intValue(12, 0);     // Catch: Throwable -> L6
        this.mExited = true;     // Catch: Throwable -> L6
        this.mActive = false;     // Catch: Throwable -> L6
        this.mScanning = false;     // Catch: Throwable -> L6
        this.mLeavePhase = 4;     // Catch: Throwable -> L6
        addLogLocked("LEAVE_EVENT id=" + this.mLastLeaveEventId + " reason=" + this.mLastLeaveReason + " retain=" + this.mStableRetentionPercent + "% d8=" + this.mDelta8Percent + "% steps=" + this.mRecent40Steps + "/" + this.mRecent60Steps);     // Catch: Throwable -> L6
        Bundle r1 = new Bundle();     // Catch: Throwable -> L6
        r1.putInt("eventId", this.mLastLeaveEventId);     // Catch: Throwable -> L6
        r1.putInt(InfoRequestQPSOptTraceLogger.REASON, this.mLastLeaveReason);     // Catch: Throwable -> L6
        r1.putInt("stableRetentionPercent", this.mStableRetentionPercent);     // Catch: Throwable -> L6
        r1.putInt("delta8Percent", this.mDelta8Percent);     // Catch: Throwable -> L6
        r1.putInt("recent40Steps", this.mRecent40Steps);     // Catch: Throwable -> L6
        r1.putInt("recent60Steps", this.mRecent60Steps);     // Catch: Throwable -> L6
        r1.putInt("candidateCount", this.mCandidateCount);     // Catch: Throwable -> L6
        r1.putInt("migrationReason", this.mMigrationReason);     // Catch: Throwable -> L6
        r1.putInt("storeType", this.mStoreType);     // Catch: Throwable -> L6
        r1.putInt("sessionEpoch", r0);     // Catch: Throwable -> L6
        r1.putInt("configVersion", r7);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r1;
    L6:
        th = move-exception;
        throw th;
    }

    private void handleLegacyVerifyEvent(PoiWifiScanCodec.Event r11) {
        monitor-enter(this);
        boolean r2 = true;
        int r4 = r11.intValue(1, 0);     // Catch: Throwable -> L43
        int r6 = r11.intValue(4, 0);     // Catch: Throwable -> L43
        int r8 = r11.intValue(5, 0);     // Catch: Throwable -> L43
        if (r4 != 0) goto L8;
    L14:
        boolean r5 = false;
    L15:
        if (r5 == true) goto L17;
    L21:
        boolean r7 = false;
    L22:
        if (r7 == true) goto L24;
    L26:
        r2 = false;
    L27:
        if (r7 == false) goto L33;
        if (r2 == true) goto L33;
        if (this.mLegacyVerifyEventIds.size() < 64) goto L32;
        this.mLegacyVerifyEventIds.removeFirst();     // Catch: Throwable -> L43
    L32:
        this.mLegacyVerifyEventIds.addLast(Integer.valueOf(r4));     // Catch: Throwable -> L43
        Bundle r12 = handleVerify(r11);     // Catch: Throwable -> L43
    L38:
        monitor-exit(this);     // Catch: Throwable -> L43
        if (r12 == null) goto L41;
        PoiAdspTraceLogger.getInstance(this.mContext).append("snapshot", "VERIFY_EVENT", SENSOR_NAME, "ADSP_TO_AP_VERIFY_EVENT", "VERIFY_EVENT", "TIMEOUT_RESCUE", r12);
        notifyIdentityVerificationRequested(r12);
    L41:
        notifyChanged();
        return;
    L33:
        if (r2 == false) goto L36;
        String r13 = "DUPLICATE_VERIFY id=" + r4;     // Catch: Throwable -> L43
    L35:
        addLogLocked(r13);     // Catch: Throwable -> L43
        r12 = null;
        goto L38
    L36:
        r13 = "STALE_VERIFY id=" + r4 + " epoch=" + r6 + "/" + this.mSessionEpoch + " version=" + r8 + "/" + this.mConfig.configVersion;     // Catch: Throwable -> L43
        goto L35
    L24:
        if (this.mLegacyVerifyEventIds.contains(Integer.valueOf(r4)) == false) goto L26;
    L17:
        if (r6 != this.mSessionEpoch) goto L21;
        if (r8 != this.mConfig.configVersion) goto L21;
        r7 = true;
        goto L22
    L8:
        if (r11.hasVarintField(1) == false) goto L14;
        if (r11.hasVarintField(4) == false) goto L14;
        if (r11.hasVarintField(5) == false) goto L14;
        r5 = true;
    L43:
        th = move-exception;
        throw th;
    }

    private void handleReliableEvent(PoiWifiScanCodec.Event r21, int r22, int r23, int r24) {
        monitor-enter(this);
        int r6 = 1;
        int r9 = r21.intValue(1, 0);     // Catch: Throwable -> L60
        int r10 = r21.intValue(r23, 0);     // Catch: Throwable -> L60
        int r11 = r21.intValue(r24, 0);     // Catch: Throwable -> L60
        if (r22 != 1) goto L9;
        boolean r1 = r21.hasValidLeaveFields();     // Catch: Throwable -> L60
    L14:
        if (r9 == 0) goto L17;
        if (r1 == false) goto L17;
        boolean r2 = true;
    L18:
        if (r2 == true) goto L20;
    L24:
        boolean r3 = false;
    L26:
        if (r22 != 1) goto L41;
        if (r2 == false) goto L41;
        if (this.mClient == null) goto L41;
        if (this.mConnected == false) goto L41;
        if (this.mReady == false) goto L41;
        if (matchesActiveIdentityLocked(r10, r11) == false) goto L41;
        if (this.mActiveIdentityTaskType != 2) goto L41;
        if (r21.intValue(10, 0) != this.mActiveIdentityStoreType) goto L41;
        boolean r4 = true;
    L42:
        if (r3 == true) goto L46;
        if (r4 == true) goto L46;
        r6 = 2;
    L46:
        if (r4 == false) goto L49;
        if (r3 == true) goto L49;
        this.mAcceptedEventType = r22;     // Catch: Throwable -> L60
        this.mAcceptedEventId = r9;     // Catch: Throwable -> L60
        this.mAcceptedEventSessionEpoch = r10;     // Catch: Throwable -> L60
        this.mAcceptedEventConfigVersion = r11;     // Catch: Throwable -> L60
        Bundle r0 = handleLeave(r21);     // Catch: Throwable -> L60
    L54:
        sendEventAckLocked(r22, r9, r10, r11, r6);     // Catch: Throwable -> L60
        monitor-exit(this);     // Catch: Throwable -> L60
        if (r0 == null) goto L58;
        PoiAdspTraceLogger.getInstance(this.mContext).append("snapshot", "LEAVE_EVENT", SENSOR_NAME, "ADSP_TO_AP_LEAVE_EVENT", "LEAVE_EVENT", leaveReasonName(r0.getInt(InfoRequestQPSOptTraceLogger.REASON, 0)), r0);
        notifyLeaveDetected(r0);
    L58:
        notifyChanged();
        return;
    L49:
        if (r3 == false) goto L52;
        String r5 = "DUPLICATE_EVENT type=" + r22 + " id=" + r9;     // Catch: Throwable -> L60
    L51:
        addLogLocked(r5);     // Catch: Throwable -> L60
        r0 = null;
        goto L54
    L52:
        r5 = "STALE_TASK_EVENT type=" + r22 + " id=" + r9 + " epoch=" + r10 + "/" + this.mSessionEpoch + " version=" + r11 + "/" + this.mConfig.configVersion;     // Catch: Throwable -> L60
    L41:
        r4 = false;
        goto L42
    L20:
        if (matchesAcceptedEventLocked(r22, r9, r10, r11) == false) goto L24;
        if (matchesActiveIdentityLocked(r10, r11) == false) goto L24;
        r3 = true;
    L17:
        r2 = false;
        goto L18
    L9:
        if (r21.hasV2EventIdentity(r23, r24) == true) goto L11;
    L13:
        r1 = false;
        goto L14
    L11:
        if (r21.hasVarintField(3) == false) goto L13;
        r1 = true;
    L60:
        th = move-exception;
        throw th;
    }

    private synchronized void handleResult(PoiWifiScanCodec.Event r13) {
        monitor-enter(this);
        int r1 = 0;
        int r0 = r13.intValue(1, 0);     // Catch: Throwable -> L21
        int r2 = r13.intValue(3, 0);     // Catch: Throwable -> L21
        int r3 = r13.intValue(4, 0);     // Catch: Throwable -> L21
        int r4 = r13.intValue(5, 0);     // Catch: Throwable -> L21
        boolean r5 = r13.boolValue(6, false);     // Catch: Throwable -> L21
        this.mLastScanId = r0;     // Catch: Throwable -> L21
        this.mLastResultTotal = r3;     // Catch: Throwable -> L21
        this.mLastDurationMs = r13.intValue(8, this.mLastDurationMs);     // Catch: Throwable -> L21
        this.mScannedBandMask = r13.intValue(9, this.mScannedBandMask);     // Catch: Throwable -> L21
        byte[] r14 = r13.bytesValue(11);     // Catch: Throwable -> L21
        if (r14 != null) goto L7;
        int r6 = 0;
    L8:
        addLogLocked(e.a(b.a("RESULT id=", r0, " chunk=", r2, " count="), r4, " decoded=", r6, " total=").append(r3).append(" last=").append(r5).toString());     // Catch: Throwable -> L21
        if (r14 != null) goto L11;
    L19:
        monitor-exit(this);
        return;
    L11:
        if (this.mConfig.reportMode != 2) goto L19;
    L13:
        int r7 = r1 + 12;     // Catch: Throwable -> L21
        if (r7 > r14.length) goto L17;
        String r8 = apToken(r14, r1);     // Catch: Throwable -> L21
        byte r9 = r14[r1 + 6];     // Catch: Throwable -> L21
        int r10 = r14[r1 + 7] & 255;     // Catch: Throwable -> L21
        int r11 = (r14[r1 + 8] & 255) | ((r14[r1 + 9] & 255) << 8);     // Catch: Throwable -> L21
        String r12 = e.a(b.a("3,", r0, ",", r2, ",").append(r8).append(",").append(r9).append(","), r10, ",", r11, ",").append(((r14[r1 + 11] & 255) << 8) | (r14[r1 + 10] & 255)).toString();     // Catch: Throwable -> L21
        appendFileLocked(r12);     // Catch: Throwable -> L21
        a.c(TAG, "WIFI_AP " + r12);     // Catch: Throwable -> L21
        r1 = r7;
        goto L13
    L17:
        monitor-exit(this);
        return;
    L7:
        r6 = r14.length / 12;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    private synchronized void handleStatus(PoiWifiScanCodec.Event r20) {
        monitor-enter(this);
        int r4 = r20.intValue(2, 0);     // Catch: Throwable -> L79
        int r6 = r20.intValue(3, 0);     // Catch: Throwable -> L79
        this.mActive = r20.boolValue(16, this.mActive);     // Catch: Throwable -> L79
        this.mScanning = r20.boolValue(17, this.mScanning);     // Catch: Throwable -> L79
        this.mWifiVersion = r20.intValue(10, this.mWifiVersion);     // Catch: Throwable -> L79
        this.mWifiCapabilities = r20.intValue(11, this.mWifiCapabilities);     // Catch: Throwable -> L79
        this.mLastScanId = r20.intValue(12, this.mLastScanId);     // Catch: Throwable -> L79
        this.mLastResultTotal = r20.intValue(13, this.mLastResultTotal);     // Catch: Throwable -> L79
        this.mLastDecodedTotal = r20.intValue(14, this.mLastDecodedTotal);     // Catch: Throwable -> L79
        this.mLastDurationMs = r20.intValue(15, this.mLastDurationMs);     // Catch: Throwable -> L79
        this.mLastError = r20.intValue(18, r6);     // Catch: Throwable -> L79
        if (r4 != 1) goto L12;
        this.mReady = true;     // Catch: Throwable -> L79
        addLogLocked("READY");     // Catch: Throwable -> L79
        Config r0 = this.mPendingStartConfig;     // Catch: Throwable -> L79
        if (r0 == null) goto L10;
        this.mConfig = r0;     // Catch: Throwable -> L79
        this.mPendingStartConfig = null;     // Catch: Throwable -> L79
        sendCommandLocked(1);     // Catch: Throwable -> L79
    L77:
        monitor-exit(this);
        return;
    L10:
        dispatchPendingResetLocked();     // Catch: Throwable -> L79
        goto L77
    L12:
        if (r4 == 2) goto L14;
        if (r4 != 3) goto L75;
        addLogLocked(e.a(new StringBuilder("STATUS_ERROR request="), r20.intValue(1, 0), " code=", r6, " last=").append(this.mLastError).toString());     // Catch: Throwable -> L79
        Bundle r2 = new Bundle();     // Catch: Throwable -> L79
        r2.putInt("requestId", r20.intValue(1, 0));     // Catch: Throwable -> L79
        r2.putInt("sessionEpoch", r20.intValue(4, this.mSessionEpoch));     // Catch: Throwable -> L79
        r2.putInt("configVersion", r20.intValue(5, this.mConfig.configVersion));     // Catch: Throwable -> L79
        r2.putInt("lastError", this.mLastError);     // Catch: Throwable -> L79
        PoiAdspTraceLogger.getInstance(this.mContext).append("snapshot", CipherConst.LEVEL_ERROR, SENSOR_NAME, "STATUS_ERROR", CipherConst.LEVEL_ERROR, "ADSP_STATUS_ERROR", r2);     // Catch: Throwable -> L79
        int r1 = r20.intValue(1, 0);     // Catch: Throwable -> L79
        int r3 = this.mPendingIdentityCommand;     // Catch: Throwable -> L79
        int r5 = this.mPendingIdentityRequestId;     // Catch: Throwable -> L79
        if (r1 != r5) goto L47;
        if (r3 == 3) goto L46;
        if (r3 != 8) goto L47;
    L46:
        boolean r7 = true;
    L49:
        if (r1 == this.mPendingRecoveryConfigQueryRequestId) goto L51;
    L53:
        boolean r8 = false;
    L55:
        if (r1 == this.mPendingConfigQueryRequestId) goto L57;
    L59:
        boolean r9 = false;
    L60:
        if (r1 != r5) goto L62;
        clearPendingIdentityLocked();     // Catch: Throwable -> L79
    L62:
        if (r7 == false) goto L65;
        if (r3 != 8) goto L65;
        this.mPendingResetConfig = true;     // Catch: Throwable -> L79
    L65:
        if (r8 == false) goto L67;
        this.mPendingRecoveryConfigQueryRequestId = 0;     // Catch: Throwable -> L79
    L67:
        if (r9 == false) goto L69;
        this.mPendingConfigQueryRequestId = 0;     // Catch: Throwable -> L79
    L69:
        if (r7 == false) goto L71;
        this.mConfigMutationRecoveryPending = true;     // Catch: Throwable -> L79
        scheduleConfigQueryRetryLocked(true, true);     // Catch: Throwable -> L79
        goto L77
    L71:
        if (r8 == false) goto L73;
        scheduleConfigQueryRetryLocked(true, false);     // Catch: Throwable -> L79
        goto L77
    L73:
        if (r9 == false) goto L77;
        scheduleConfigQueryRetryLocked(false, false);     // Catch: Throwable -> L79
        goto L77
    L57:
        if (this.mPendingConfigQueryGeneration != this.mConfigOperationGeneration) goto L59;
        r9 = true;
        goto L60
    L51:
        if (this.mPendingRecoveryConfigQueryGeneration != this.mConfigOperationGeneration) goto L53;
        r8 = true;
    L47:
        r7 = false;
        goto L49
    L75:
        if (r4 != 4) goto L77;
        addLogLocked("SCAN_COMPLETE id=" + this.mLastScanId + " total=" + this.mLastResultTotal + " decoded=" + this.mLastDecodedTotal + " durationMs=" + this.mLastDurationMs);     // Catch: Throwable -> L79
        appendSummaryLocked();     // Catch: Throwable -> L79
        goto L77
    L14:
        if (r20.hasVarintField(1) == true) goto L16;
    L34:
        boolean r10 = false;
    L35:
        if (r10 == false) goto L40;
        int r11 = this.mPendingIdentityCommand;     // Catch: Throwable -> L79
        this.mHasActiveIdentity = true;     // Catch: Throwable -> L79
        this.mActiveIdentitySessionEpoch = this.mPendingIdentitySessionEpoch;     // Catch: Throwable -> L79
        this.mActiveIdentityConfigVersion = this.mPendingIdentityConfigVersion;     // Catch: Throwable -> L79
        this.mActiveIdentityTaskType = this.mPendingIdentityTaskType;     // Catch: Throwable -> L79
        this.mActiveIdentityStoreType = this.mPendingIdentityStoreType;     // Catch: Throwable -> L79
        clearPendingIdentityLocked();     // Catch: Throwable -> L79
        clearAcceptedEventLocked();     // Catch: Throwable -> L79
        addLogLocked("ACK request=" + r20.intValue(1, 0));     // Catch: Throwable -> L79
        if (r11 != 8) goto L39;
        sendCommandLocked(7);     // Catch: Throwable -> L79
    L39:
        dispatchPendingUpdateLocked();     // Catch: Throwable -> L79
        goto L10
    L40:
        addLogLocked("ACK_IGNORED request=" + r20.intValue(1, 0));     // Catch: Throwable -> L79
        goto L77
    L16:
        if (r20.hasVarintField(4) == false) goto L34;
        if (r20.hasVarintField(5) == false) goto L34;
        if (r20.hasVarintField(6) == false) goto L34;
        if (r20.intValue(1, 0) != this.mPendingIdentityRequestId) goto L34;
        int r12 = this.mPendingIdentityCommand;     // Catch: Throwable -> L79
        if (r12 == 1) goto L28;
        if (r12 == 3) goto L28;
        if (r12 != 8) goto L34;
    L28:
        if (r20.intValue(4, 0) != this.mPendingIdentitySessionEpoch) goto L34;
        if (r20.intValue(5, 0) != this.mPendingIdentityConfigVersion) goto L34;
        if (r20.intValue(6, 0) != this.mPendingIdentityTaskType) goto L34;
        r10 = true;
    L79:
        th = move-exception;
        throw th;
    }

    private synchronized Bundle handleVerify(PoiWifiScanCodec.Event r6) {
        monitor-enter(this);
        Bundle r0 = new Bundle();     // Catch: Throwable -> L6
        r0.putInt("eventId", r6.intValue(1, 0));     // Catch: Throwable -> L6
        r0.putInt(InfoRequestQPSOptTraceLogger.REASON, r6.intValue(3, 1));     // Catch: Throwable -> L6
        r0.putInt("sessionEpoch", r6.intValue(4, 0));     // Catch: Throwable -> L6
        r0.putInt("configVersion", r6.intValue(5, 0));     // Catch: Throwable -> L6
        addLogLocked("VERIFY_EVENT id=" + r0.getInt("eventId") + " reason=" + r0.getInt(InfoRequestQPSOptTraceLogger.REASON));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    private static String leaveReasonName(int r1) {
        if (r1 != 1) goto L5;
        return "WIFI_MOTION_CONFIRMED";
    L5:
        if (r1 == 2) goto L8;
        return "UNKNOWN";
    L8:
        return "SITTABLE_SUSTAINED_MOTION";
    }

    private boolean matchesAcceptedEventLocked(int r2, int r3, int r4, int r5) {
        if (r3 != 0) goto L4;
    L12:
        return false;
    L4:
        if (r2 != this.mAcceptedEventType) goto L12;
        if (r3 != this.mAcceptedEventId) goto L12;
        if (r4 != this.mAcceptedEventSessionEpoch) goto L12;
        if (r5 != this.mAcceptedEventConfigVersion) goto L12;
        return true;
    }

    private boolean matchesActiveIdentityLocked(int r2, int r3) {
        if (this.mHasActiveIdentity == true) goto L5;
    L9:
        return false;
    L5:
        if (r2 != this.mActiveIdentitySessionEpoch) goto L9;
        if (r3 != this.mActiveIdentityConfigVersion) goto L9;
        return true;
    }

    private Config mergeOperationalConfigLocked(Config r2) {
        if (this.mHasExplicitAlgorithmConfig == false) goto L5;
        Config r1 = desiredConfigLocked().copy();
        r1.taskType = r2.taskType;
        r1.scheduleMode = r2.scheduleMode;
        r1.intervalSeconds = r2.intervalSeconds;
        r1.reportMode = r2.reportMode;
        r1.scanType = r2.scanType;
        r1.bandMask = r2.bandMask;
        r1.maxScanAgeMs = r2.maxScanAgeMs;
        r1.radioChainPref = r2.radioChainPref;
        r1.storeType = r2.storeType;
        r1.storeConfirmedElapsedMs = r2.storeConfirmedElapsedMs;
        int[] r3 = r2.frequenciesMhz;
        r1.frequenciesMhz = Arrays.copyOf(r3, r3.length);
        return r1;
    L5:
        return r2.copy();
    }

    private void notifyChanged() {
        Iterator<Listener> r3 = this.mListeners.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((Listener) ZeusTransformUtils.preCheckCast(r3.next(), Listener.class, "com.obric.memorydata.plugin")).onWifiScanStateChanged();
        goto L4
    }

    private void notifyIdentityVerificationRequested(Bundle r4) {
        Iterator<Listener> r3 = this.mListeners.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((Listener) ZeusTransformUtils.preCheckCast(r3.next(), Listener.class, "com.obric.memorydata.plugin")).onWifiIdentityVerificationRequested(new Bundle(r4));
        goto L4
    }

    private void notifyLeaveDetected(Bundle r4) {
        Iterator<Listener> r3 = this.mListeners.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((Listener) ZeusTransformUtils.preCheckCast(r3.next(), Listener.class, "com.obric.memorydata.plugin")).onWifiLeaveDetected(new Bundle(r4));
        goto L4
    }

    private void openLogSessionLocked() {
        if (this.mLogDirectory.exists() == false) goto L5;
    L9:
        deleteLegacyLogsLocked();
        this.mCurrentLogPath = new File(this.mLogDirectory, TOKENIZED_LOG_PREFIX + System.currentTimeMillis() + CSV_SUFFIX).getAbsolutePath();
        appendFileLocked("schema_version,scan_id,chunk,ap_token,rssi,band,frequency_mhz,age_ms");
        StringBuilder r0 = new StringBuilder("LOG_FILE ").append(this.mCurrentLogPath);
    L7:
        addLogLocked(r0.toString());
        return;
    L5:
        if (this.mLogDirectory.mkdirs() == true) goto L9;
        r0 = new StringBuilder("LOG_DIR_ERROR ").append(this.mLogDirectory);
        goto L7
    }

    private void scheduleConfigQueryRetryLocked(final boolean r6, boolean r7) {
        if (r7 == false) goto L4;
        this.mConfigQueryRetryGeneration++;
        this.mConfigQueryRetryCount = 0;
    L4:
        int r8 = this.mConfigQueryRetryCount;
        if (r8 < 3) goto L8;
        addLogLocked("CONFIG_QUERY_RETRY_EXHAUSTED recovery=" + r6);
        return;
    L8:
        int r9 = r8 + 1;
        this.mConfigQueryRetryCount = r9;
        final int r0 = this.mConfigQueryRetryGeneration;
        long r1 = 1000 << (r9 - 1);
        addLogLocked("CONFIG_QUERY_RETRY_SCHEDULED attempt=" + r9 + " delayMs=" + r1 + " recovery=" + r6);
        this.mMainHandler.postDelayed(new $$Lambda$PoiWifiScanBridge$mHPjee3A46qcZ1w4ywNhR1nAYeE(this, r0, r6), r1);
    }

    private synchronized void sendCommandLocked(int r2) {
        monitor-enter(this);
        sendCommandLocked(r2, false);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private synchronized void sendCommandLocked(int r9, boolean r10) {
        monitor-enter(this);
    L30:
        th = move-exception;
        throw th;
    L4:
        if (this.mClient != null) goto L6;
    L27:
        addLogLocked("COMMAND_SKIPPED not connected type=" + r9);     // Catch: Throwable -> L30
        notifyChanged();     // Catch: Throwable -> L30
        monitor-exit(this);
        return;
    L6:
        if (this.mConnected == false) goto L27;
        int r0 = this.mNextRequestId.getAndIncrement();     // Catch: Throwable -> L30
        if (r9 != 8) goto L11;
        int r1 = this.mSessionEpoch;     // Catch: Throwable -> L30
        Config r2 = this.mConfig;     // Catch: Throwable -> L30
        byte[] r3 = PoiWifiScanCodec.encodeResetCommand(r0, r1, r2.configVersion, r2.expectedConfigVersion);     // Catch: Throwable -> L30
    L12:
        this.mClient.sendRequest(SENSOR_NAME, COMMAND_MESSAGE_ID, r3, r0, 4);     // Catch: Throwable -> L30
        if (r9 != 1) goto L15;
    L23:
        this.mPendingIdentityRequestId = r0;     // Catch: Throwable -> L30
        this.mPendingIdentityCommand = r9;     // Catch: Throwable -> L30
        this.mPendingIdentitySessionEpoch = this.mSessionEpoch;     // Catch: Throwable -> L30
        Config r11 = this.mConfig;     // Catch: Throwable -> L30
        this.mPendingIdentityConfigVersion = r11.configVersion;     // Catch: Throwable -> L30
        this.mPendingIdentityTaskType = r11.taskType;     // Catch: Throwable -> L30
        this.mPendingIdentityStoreType = r11.storeType;     // Catch: Throwable -> L30
    L24:
        addLogLocked(b.a("COMMAND_TX id=", r0, " type=", r9, " task=").append(this.mConfig.taskType).append(" schedule=").append(this.mConfig.scheduleMode).append(" interval=").append(this.mConfig.intervalSeconds).append(" report=").append(this.mConfig.reportMode).append(" scanType=").append(this.mConfig.scanType).append(" band=0x").append(Integer.toHexString(this.mConfig.bandMask)).append(" pref=").append(this.mConfig.radioChainPref).append(" freq=").append(Arrays.toString(this.mConfig.frequenciesMhz)).toString());     // Catch: Throwable -> L30
        notifyChanged();     // Catch: Throwable -> L30
        monitor-exit(this);
        return;
    L15:
        if (r9 == 3) goto L23;
        if (r9 == 8) goto L23;
        if (r9 != 7) goto L24;
        if (r10 == false) goto L22;
        this.mPendingRecoveryConfigQueryRequestId = r0;     // Catch: Throwable -> L30
        this.mPendingRecoveryConfigQueryGeneration = this.mConfigOperationGeneration;     // Catch: Throwable -> L30
        goto L24
    L22:
        this.mPendingConfigQueryRequestId = r0;     // Catch: Throwable -> L30
        this.mPendingConfigQueryGeneration = this.mConfigOperationGeneration;     // Catch: Throwable -> L30
        goto L24
    L11:
        r3 = PoiWifiScanCodec.encodeCommand(r0, r9, this.mSessionEpoch, this.mConfig);     // Catch: Throwable -> L30
        goto L12
    }

    private void sendEventAckLocked(int r8, int r9, int r10, int r11, int r12) {
        if (this.mClient != null) goto L5;
        return;
    L5:
        if (this.mConnected == false) goto L10;
        int r0 = this.mNextRequestId.getAndIncrement();
        byte[] r13 = PoiWifiScanCodec.encodeEventAck(r0, r10, r11, r8, r9, r12);
        this.mClient.sendRequest(SENSOR_NAME, COMMAND_MESSAGE_ID, r13, r0, 4);
        return;
    }

    private void sendUpdateLocked(Config r2) {
        int r0 = this.mConfigVersion;
        r2.expectedConfigVersion = r0;
        int r1 = r0 + 1;
        this.mConfigVersion = r1;
        r2.configVersion = r1;
        this.mConfig = r2;
        sendCommandLocked(3);
    }

    private synchronized void subscribeLocked() {
        monitor-enter(this);
        this.mClient.subscribe(SENSOR_NAME, new int[]{STATUS_MESSAGE_ID, RESULT_MESSAGE_ID, DEBUG_MESSAGE_ID, LEAVE_MESSAGE_ID, VERIFY_MESSAGE_ID, CONFIG_MESSAGE_ID}, 0, new int[]{STATUS_MESSAGE_ID, RESULT_MESSAGE_ID, DEBUG_MESSAGE_ID, CONFIG_MESSAGE_ID}, new byte[0]);     // Catch: Throwable -> L6
        this.mSubscribed = true;     // Catch: Throwable -> L6
        addLogLocked("SUBSCRIBE");     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private void updateTaskLocked(Config r4, boolean r5) {
        boolean r0 = this.mConfigMutationRecoveryPending;
        this.mConfigOperationGeneration++;
        if (r0 == false) goto L5;
        this.mPendingRecoveryConfigQueryRequestId = 0;
        scheduleConfigQueryRetryLocked(true, true);
    L6:
        if (r5 == false) goto L8;
        this.mHasExplicitAlgorithmConfig = true;
        this.mResetAwaitingConfig = false;
    L8:
        if (r5 == true) goto L10;
    L12:
        if (r5 == false) goto L14;
        Config r6 = r4.copy();
    L15:
        clearLegacyVerifyLocked();
        if (this.mPendingStartConfig == null) goto L18;
    L34:
        int r7 = this.mConfigVersion;
        r6.expectedConfigVersion = r7;
        int r8 = r7 + 1;
        this.mConfigVersion = r8;
        r6.configVersion = r8;
        this.mConfig = r6;
        this.mPendingStartConfig = r6.copy();
        StringBuilder r9 = new StringBuilder("UPDATE_DEFERRED connected=").append(this.mConnected).append(" ready=").append(this.mReady);
    L32:
        addLogLocked(r9.toString());
        return;
    L18:
        if (this.mConnected == false) goto L34;
        if (this.mReady == false) goto L34;
        if (this.mPendingIdentityRequestId == 0) goto L25;
    L31:
        this.mPendingUpdateConfig = r6;
        r9 = new StringBuilder("UPDATE_QUEUED pendingRequest=").append(this.mPendingIdentityRequestId);
        goto L32
    L25:
        if (this.mConfigMutationRecoveryPending == true) goto L31;
        if (this.mPendingRecoveryConfigQueryRequestId != 0) goto L31;
        sendUpdateLocked(r6);
        return;
    L14:
        r6 = mergeOperationalConfigLocked(r4);
        goto L15
    L10:
        if (this.mPendingResetConfig == false) goto L12;
        addLogLocked("RESET_SUPERSEDED_BY_UPDATE");
        this.mPendingResetConfig = false;
        goto L12
    L5:
        cancelConfigQueryRetryLocked();
        goto L6
    }

    public void addListener(Listener r3) {
        Listener r4 = (Listener) ZeusTransformUtils.wrapperContextForParams(r3, Listener.class, "com.obric.memorydata.plugin");
        this.mListeners.addIfAbsent(r4);
    }

    public synchronized void clearDebugLogs() {
        monitor-enter(this);
        this.mLogs.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized Config getConfig() {
        monitor-enter(this);
        Config r0 = this.mConfig.copy();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized Bundle getDebugInfo() {
        monitor-enter(this);
        Bundle r0 = new Bundle();     // Catch: Throwable -> L6
        r0.putBoolean("connected", this.mConnected);     // Catch: Throwable -> L6
        r0.putBoolean("subscribed", this.mSubscribed);     // Catch: Throwable -> L6
        r0.putBoolean("ready", this.mReady);     // Catch: Throwable -> L6
        r0.putBoolean("resetPending", this.mPendingResetConfig);     // Catch: Throwable -> L6
        r0.putBoolean("active", this.mActive);     // Catch: Throwable -> L6
        r0.putBoolean("scanning", this.mScanning);     // Catch: Throwable -> L6
        r0.putInt("clientId", this.mClientId);     // Catch: Throwable -> L6
        r0.putInt("wifiVersion", this.mWifiVersion);     // Catch: Throwable -> L6
        r0.putInt("wifiCapabilities", this.mWifiCapabilities);     // Catch: Throwable -> L6
        r0.putInt("lastError", this.mLastError);     // Catch: Throwable -> L6
        r0.putInt("scanId", this.mLastScanId);     // Catch: Throwable -> L6
        r0.putInt("resultTotal", this.mLastResultTotal);     // Catch: Throwable -> L6
        r0.putInt("decodedTotal", this.mLastDecodedTotal);     // Catch: Throwable -> L6
        r0.putInt("durationMs", this.mLastDurationMs);     // Catch: Throwable -> L6
        r0.putInt("scannedBandMask", this.mScannedBandMask);     // Catch: Throwable -> L6
        r0.putInt("scanCount", this.mScanCount);     // Catch: Throwable -> L6
        r0.putInt("successCount", this.mSuccessCount);     // Catch: Throwable -> L6
        r0.putInt("failureCount", this.mFailureCount);     // Catch: Throwable -> L6
        r0.putInt("busyCount", this.mBusyCount);     // Catch: Throwable -> L6
        r0.putBoolean("dbsCandidate", this.mDbsCandidate);     // Catch: Throwable -> L6
        r0.putBoolean("dbsConfirmed", this.mDbsConfirmed);     // Catch: Throwable -> L6
        r0.putInt("leavePhase", this.mLeavePhase);     // Catch: Throwable -> L6
        r0.putInt("anchorScanCount", this.mAnchorScanCount);     // Catch: Throwable -> L6
        r0.putInt("anchorStableCount", this.mAnchorStableCount);     // Catch: Throwable -> L6
        r0.putInt("anchorApMedian", this.mAnchorApMedian);     // Catch: Throwable -> L6
        r0.putInt("currentApCount", this.mCurrentApCount);     // Catch: Throwable -> L6
        r0.putInt("sharedStableCount", this.mSharedStableCount);     // Catch: Throwable -> L6
        r0.putInt("sharedBssidCount", this.mSharedBssidCount);     // Catch: Throwable -> L6
        r0.putInt("stableRetentionPercent", this.mStableRetentionPercent);     // Catch: Throwable -> L6
        r0.putInt("rssiMedianDeltaDb", this.mRssiMedianDeltaDb);     // Catch: Throwable -> L6
        r0.putInt("delta8Percent", this.mDelta8Percent);     // Catch: Throwable -> L6
        r0.putInt("densityPercent", this.mDensityPercent);     // Catch: Throwable -> L6
        r0.putInt("recent40Steps", this.mRecent40Steps);     // Catch: Throwable -> L6
        r0.putInt("recent60Steps", this.mRecent60Steps);     // Catch: Throwable -> L6
        r0.putInt("stepsSinceStoreConfirmed", this.mStepsSinceStoreConfirmed);     // Catch: Throwable -> L6
        r0.putBoolean("identityVerifySent", this.mIdentityVerifySent);     // Catch: Throwable -> L6
        r0.putInt("continuousMotionSeconds", this.mContinuousMotionSeconds);     // Catch: Throwable -> L6
        r0.putInt("stationaryAfterMotionSeconds", this.mStationaryAfterMotionSeconds);     // Catch: Throwable -> L6
        r0.putInt("candidateCount", this.mCandidateCount);     // Catch: Throwable -> L6
        r0.putBoolean("wifiMigrated", this.mWifiMigrated);     // Catch: Throwable -> L6
        r0.putBoolean("strongWifiExit", this.mStrongWifiExit);     // Catch: Throwable -> L6
        r0.putInt("migrationReason", this.mMigrationReason);     // Catch: Throwable -> L6
        r0.putInt("storeType", this.mStoreType);     // Catch: Throwable -> L6
        r0.putBoolean("exited", this.mExited);     // Catch: Throwable -> L6
        r0.putInt("leaveEventId", this.mLastLeaveEventId);     // Catch: Throwable -> L6
        r0.putInt("leaveReason", this.mLastLeaveReason);     // Catch: Throwable -> L6
        r0.putInt("coreAnchorCount", this.mCoreAnchorCount);     // Catch: Throwable -> L6
        r0.putInt("backgroundAnchorCount", this.mBackgroundAnchorCount);     // Catch: Throwable -> L6
        r0.putInt("anchorOverflowCount", this.mAnchorOverflowCount);     // Catch: Throwable -> L6
        r0.putBoolean("sittableCandidateActive", this.mSittableCandidateActive);     // Catch: Throwable -> L6
        r0.putBoolean("sittableLockout", this.mSittableLockout);     // Catch: Throwable -> L6
        r0.putBoolean("timeoutRescuePending", this.mTimeoutRescuePending);     // Catch: Throwable -> L6
        r0.putString("logPath", this.mCurrentLogPath);     // Catch: Throwable -> L6
        r0.putStringArrayList("logs", new ArrayList(this.mLogs));     // Catch: Throwable -> L6
        r0.putBundle("effectiveConfig", new Bundle(this.mEffectiveConfig));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized Bundle getEffectiveConfig() {
        monitor-enter(this);
        Bundle r0 = new Bundle(this.mEffectiveConfig);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public int getSessionEpoch() {
        return this.mSessionEpoch;
    }

    public void handleEvent(int r42, byte[] r43) {
        PoiWifiScanCodec.Event r5 = PoiWifiScanCodec.decodeEvent(r43);     // Catch: RuntimeException -> L88
        if (r5 != null) goto L7;
        return;
    L7:
        if (r42 != STATUS_MESSAGE_ID) goto L10;
        handleStatus(r5);     // Catch: RuntimeException -> L88
        return;
    L10:
        if (r42 != RESULT_MESSAGE_ID) goto L13;
        handleResult(r5);     // Catch: RuntimeException -> L88
        return;
    L13:
        if (r42 != DEBUG_MESSAGE_ID) goto L16;
        handleDebug(r5);     // Catch: RuntimeException -> L88
        return;
    L16:
        if (r42 != LEAVE_MESSAGE_ID) goto L19;
        handleReliableEvent(r5, 1, 11, 12);     // Catch: RuntimeException -> L88
        return;
    L19:
        if (r42 != VERIFY_MESSAGE_ID) goto L22;
        handleLegacyVerifyEvent(r5);     // Catch: RuntimeException -> L88
        return;
    L22:
        if (r42 != CONFIG_MESSAGE_ID) goto L99;
        monitor-enter(this);     // Catch: RuntimeException -> L88
        int r8 = r5.intValue(1, 0);     // Catch: Throwable -> L85
        int r9 = r5.intValue(4, 0);     // Catch: Throwable -> L85
        if (r8 != 0) goto L28;
    L30:
        boolean r10 = false;
    L31:
        if (r8 != 0) goto L33;
    L35:
        boolean r11 = false;
    L36:
        if (r10 == true) goto L41;
        if (r11 == true) goto L41;
        addLogLocked("CONFIG_IGNORED request=" + r8 + " expected=" + this.mPendingConfigQueryRequestId + "/" + this.mPendingRecoveryConfigQueryRequestId);     // Catch: Throwable -> L85
        monitor-exit(this);     // Catch: Throwable -> L85
        return;
    L41:
        if (r10 == false) goto L43;
        this.mPendingRecoveryConfigQueryRequestId = 0;     // Catch: Throwable -> L85
    L44:
        if (r10 == false) goto L46;
        int r4 = this.mPendingRecoveryConfigQueryGeneration;     // Catch: Throwable -> L85
    L48:
        if (r4 == this.mConfigOperationGeneration) goto L52;
        addLogLocked("CONFIG_STALE_GENERATION request=" + r8 + " response=" + r4 + " current=" + this.mConfigOperationGeneration);     // Catch: Throwable -> L85
        monitor-exit(this);     // Catch: Throwable -> L85
        return;
    L52:
        cancelConfigQueryRetryLocked();     // Catch: Throwable -> L85
        int r3 = this.mPendingIdentityCommand;     // Catch: Throwable -> L85
        if (r3 != 3) goto L55;
    L58:
        boolean r6 = true;
    L59:
        if (r10 == false) goto L61;
    L68:
        Bundle r0 = new Bundle();     // Catch: Throwable -> L85
        String[] r7 = (String[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(new String[]{"scanWatchdogSeconds", "eventAckTimeoutSeconds", "retryBackoffInitialSeconds", "retryBackoffMaxSeconds", "minimumAnchorCountForStrongExit", "minimumStrongExitDensityPercent", "anchorFrameCount", "anchorMinHits", "anchorMaxMadDb", "anchorMinStableCount", "coreWeightQuarters", "backgroundWeightQuarters", "anchorIntervalSeconds", "monitorIntervalSeconds", "followUpIntervalSeconds", "gateCheckSeconds", "scanWake60sMinSteps", "sittableStart60sSteps", "sittableKeep60sSteps", "walkableFirst40sSteps", "walkableFirst60sSteps", "migrationConfirmFrames", "sharedStableMinCount", "rssiMedianDeltaMinDb", "delta8MinPercent", "rssiShiftDensityMinPercent", "lowRetainAnchorMinCount", "lowRetainMaxPercent", "lowRetainDensityMinPercent", "strongExitMaxSharedBssid"}, 33), String[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L85
        r7[r7.length - 3] = "coreRssiThresholdAbsDbm";     // Catch: Throwable -> L85
        r7[r7.length - 2] = "identityHandoffStepThreshold";     // Catch: Throwable -> L85
        r7[r7.length - 1] = "identityHandoffStationary60sSteps";     // Catch: Throwable -> L85
        int r12 = 0;
    L70:
        if (r12 >= r7.length) goto L72;
        r0.putInt(r7[r12], r5.intValue(r12 + 8, 0));     // Catch: Throwable -> L85
        r12 = r12 + 1;     // Catch: Throwable -> L85
        goto L70
    L72:
        r0.putInt("protocolVersion", r5.intValue(2, 0));     // Catch: Throwable -> L85
        r0.putInt("algorithmVersion", r5.intValue(3, 0));     // Catch: Throwable -> L85
        r0.putInt("configVersion", r9);     // Catch: Throwable -> L85
        r0.putInt("configSource", r5.intValue(5, 0));     // Catch: Throwable -> L85
        this.mEffectiveConfig = r0;     // Catch: Throwable -> L85
        int r13 = r0.getInt("configVersion");     // Catch: Throwable -> L85
        this.mConfigVersion = r13;     // Catch: Throwable -> L85
        Config r14 = this.mConfig;     // Catch: Throwable -> L85
        r14.configVersion = r13;     // Catch: Throwable -> L85
        r14.expectedConfigVersion = -1;     // Catch: Throwable -> L85
        if (r10 == false) goto L75;
        this.mConfigMutationRecoveryPending = false;     // Catch: Throwable -> L85
    L75:
        r14.scanWatchdogSeconds = r0.getInt("scanWatchdogSeconds");     // Catch: Throwable -> L85
        this.mConfig.eventAckTimeoutSeconds = r0.getInt("eventAckTimeoutSeconds");     // Catch: Throwable -> L85
        this.mConfig.retryBackoffInitialSeconds = r0.getInt("retryBackoffInitialSeconds");     // Catch: Throwable -> L85
        this.mConfig.retryBackoffMaxSeconds = r0.getInt("retryBackoffMaxSeconds");     // Catch: Throwable -> L85
        this.mConfig.minimumAnchorCountForStrongExit = r0.getInt("minimumAnchorCountForStrongExit");     // Catch: Throwable -> L85
        this.mConfig.minimumStrongExitDensityPercent = r0.getInt("minimumStrongExitDensityPercent");     // Catch: Throwable -> L85
        this.mConfig.anchorFrameCount = r0.getInt("anchorFrameCount");     // Catch: Throwable -> L85
        this.mConfig.anchorMinHits = r0.getInt("anchorMinHits");     // Catch: Throwable -> L85
        this.mConfig.anchorMaxMadDb = r0.getInt("anchorMaxMadDb");     // Catch: Throwable -> L85
        this.mConfig.anchorMinStableCount = r0.getInt("anchorMinStableCount");     // Catch: Throwable -> L85
        this.mConfig.coreWeightQuarters = r0.getInt("coreWeightQuarters");     // Catch: Throwable -> L85
        this.mConfig.backgroundWeightQuarters = r0.getInt("backgroundWeightQuarters");     // Catch: Throwable -> L85
        this.mConfig.anchorIntervalSeconds = r0.getInt("anchorIntervalSeconds");     // Catch: Throwable -> L85
        this.mConfig.monitorIntervalSeconds = r0.getInt("monitorIntervalSeconds");     // Catch: Throwable -> L85
        this.mConfig.followUpIntervalSeconds = r0.getInt("followUpIntervalSeconds");     // Catch: Throwable -> L85
        this.mConfig.gateCheckSeconds = r0.getInt("gateCheckSeconds");     // Catch: Throwable -> L85
        this.mConfig.scanWake60sMinSteps = r0.getInt("scanWake60sMinSteps");     // Catch: Throwable -> L85
        this.mConfig.sittableStart60sSteps = r0.getInt("sittableStart60sSteps");     // Catch: Throwable -> L85
        this.mConfig.sittableKeep60sSteps = r0.getInt("sittableKeep60sSteps");     // Catch: Throwable -> L85
        this.mConfig.walkableFirst40sSteps = r0.getInt("walkableFirst40sSteps");     // Catch: Throwable -> L85
        this.mConfig.walkableFirst60sSteps = r0.getInt("walkableFirst60sSteps");     // Catch: Throwable -> L85
        this.mConfig.migrationConfirmFrames = r0.getInt("migrationConfirmFrames");     // Catch: Throwable -> L85
        this.mConfig.sharedStableMinCount = r0.getInt("sharedStableMinCount");     // Catch: Throwable -> L85
        this.mConfig.rssiMedianDeltaMinDb = r0.getInt("rssiMedianDeltaMinDb");     // Catch: Throwable -> L85
        this.mConfig.delta8MinPercent = r0.getInt("delta8MinPercent");     // Catch: Throwable -> L85
        this.mConfig.rssiShiftDensityMinPercent = r0.getInt("rssiShiftDensityMinPercent");     // Catch: Throwable -> L85
        this.mConfig.lowRetainAnchorMinCount = r0.getInt("lowRetainAnchorMinCount");     // Catch: Throwable -> L85
        this.mConfig.lowRetainMaxPercent = r0.getInt("lowRetainMaxPercent");     // Catch: Throwable -> L85
        this.mConfig.lowRetainDensityMinPercent = r0.getInt("lowRetainDensityMinPercent");     // Catch: Throwable -> L85
        this.mConfig.strongExitMaxSharedBssid = r0.getInt("strongExitMaxSharedBssid");     // Catch: Throwable -> L85
        this.mConfig.coreRssiThresholdAbsDbm = r0.getInt("coreRssiThresholdAbsDbm");     // Catch: Throwable -> L85
        this.mConfig.identityHandoffStepThreshold = r0.getInt("identityHandoffStepThreshold");     // Catch: Throwable -> L85
        this.mConfig.identityHandoffStationary60sSteps = r0.getInt("identityHandoffStationary60sSteps");     // Catch: Throwable -> L85
        if (r10 == true) goto L78;
    L80:
        if (r10 == true) goto L82;
        this.mResetAwaitingConfig = false;     // Catch: Throwable -> L85
    L82:
        addLogLocked("CONFIG_RX v=" + r0.getInt("configVersion"));     // Catch: Throwable -> L85
        dispatchPendingUpdateLocked();     // Catch: Throwable -> L85
        dispatchPendingResetLocked();     // Catch: Throwable -> L85
        monitor-exit(this);     // Catch: Throwable -> L85
        return;
    L78:
        if (this.mResetAwaitingConfig == false) goto L80;
        this.mPendingResetConfig = true;     // Catch: Throwable -> L85
        goto L82
    L61:
        if (r9 < this.mConfigVersion) goto L65;
        if (r6 == false) goto L68;
        if (r9 >= this.mPendingIdentityConfigVersion) goto L68;
    L65:
        addLogLocked("CONFIG_STALE v=" + r9 + " local=" + this.mConfigVersion);     // Catch: Throwable -> L85
        monitor-exit(this);     // Catch: Throwable -> L85
        return;
    L55:
        if (r3 == 8) goto L58;
        r6 = false;
        goto L59
    L46:
        r4 = this.mPendingConfigQueryGeneration;     // Catch: Throwable -> L85
        goto L48
    L43:
        this.mPendingConfigQueryRequestId = 0;     // Catch: Throwable -> L85
        goto L44
    L33:
        if (r8 != this.mPendingConfigQueryRequestId) goto L35;
        r11 = true;
        goto L36
    L28:
        if (r8 != this.mPendingRecoveryConfigQueryRequestId) goto L30;
        r10 = true;
    L85:
        th = move-exception;
        throw th;     // Catch: RuntimeException -> L88
    L99:
        return;
    L88:
        e = move-exception;
        a.a(TAG, "decode failed messageId=" + r42, e);
    }

    public /* synthetic */ void lambda$scheduleConfigQueryRetryLocked$0$PoiWifiScanBridge(int r2, boolean r3) {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L4:
        if (r2 == this.mConfigQueryRetryGeneration) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L18
        return;
    L8:
        if (this.mConnected == true) goto L10;
    L15:
        addLogLocked("CONFIG_QUERY_RETRY_CANCELLED not ready");     // Catch: Throwable -> L18
        cancelConfigQueryRetryLocked();     // Catch: Throwable -> L18
        notifyChanged();     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
        return;
    L10:
        if (this.mReady == false) goto L15;
        sendCommandLocked(7, r3);     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
    }

    public synchronized void queryConfig() {
        monitor-enter(this);
        cancelConfigQueryRetryLocked();     // Catch: Throwable -> L6
        sendCommandLocked(7);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void queryStatus() {
        monitor-enter(this);
        sendCommandLocked(5);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeListener(Listener r3) {
        Listener r4 = (Listener) ZeusTransformUtils.wrapperContextForParams(r3, Listener.class, "com.obric.memorydata.plugin");
        this.mListeners.remove(r4);
    }

    public synchronized void resetConfig() {
        monitor-enter(this);
        this.mConfigOperationGeneration++;     // Catch: Throwable -> L6
        cancelConfigQueryRetryLocked();     // Catch: Throwable -> L6
        this.mHasExplicitAlgorithmConfig = true;     // Catch: Throwable -> L6
        this.mResetAwaitingConfig = true;     // Catch: Throwable -> L6
        this.mPendingUpdateConfig = null;     // Catch: Throwable -> L6
        this.mPendingResetConfig = true;     // Catch: Throwable -> L6
        addLogLocked("RESET_REQUESTED connected=" + this.mConnected + " ready=" + this.mReady);     // Catch: Throwable -> L6
        dispatchPendingResetLocked();     // Catch: Throwable -> L6
        notifyChanged();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void start() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.mClient == null) goto L7;
        monitor-exit(this);
        return;
    L7:
        SensorBridgeClient r0 = new SensorBridgeClient(this.mContext, new AnonymousClass1(this));     // Catch: Throwable -> L10
        this.mClient = r0;     // Catch: Throwable -> L10
        r0.start();     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public synchronized void startTask(Config r5) {
        monitor-enter(this);
        this.mConfigOperationGeneration++;     // Catch: Throwable -> L18
        Config r0 = mergeOperationalConfigLocked(r5);     // Catch: Throwable -> L18
        this.mPendingUpdateConfig = null;     // Catch: Throwable -> L18
        this.mConfig = r0;     // Catch: Throwable -> L18
        r0.expectedConfigVersion = -1;     // Catch: Throwable -> L18
        int r3 = this.mConfigVersion + 1;     // Catch: Throwable -> L18
        this.mConfigVersion = r3;     // Catch: Throwable -> L18
        r0.configVersion = r3;     // Catch: Throwable -> L18
        clearProtocolIdentityLocked();     // Catch: Throwable -> L18
        this.mLeavePhase = 0;     // Catch: Throwable -> L18
        this.mAnchorScanCount = 0;     // Catch: Throwable -> L18
        this.mAnchorStableCount = 0;     // Catch: Throwable -> L18
        this.mAnchorApMedian = 0;     // Catch: Throwable -> L18
        this.mCurrentApCount = 0;     // Catch: Throwable -> L18
        this.mSharedStableCount = 0;     // Catch: Throwable -> L18
        this.mSharedBssidCount = 0;     // Catch: Throwable -> L18
        this.mStableRetentionPercent = 0;     // Catch: Throwable -> L18
        this.mRssiMedianDeltaDb = 0;     // Catch: Throwable -> L18
        this.mDelta8Percent = 0;     // Catch: Throwable -> L18
        this.mDensityPercent = 0;     // Catch: Throwable -> L18
        this.mRecent40Steps = 0;     // Catch: Throwable -> L18
        this.mRecent60Steps = 0;     // Catch: Throwable -> L18
        this.mStepsSinceStoreConfirmed = 0;     // Catch: Throwable -> L18
        this.mIdentityVerifySent = false;     // Catch: Throwable -> L18
        this.mContinuousMotionSeconds = 0;     // Catch: Throwable -> L18
        this.mStationaryAfterMotionSeconds = 0;     // Catch: Throwable -> L18
        this.mCandidateCount = 0;     // Catch: Throwable -> L18
        this.mWifiMigrated = false;     // Catch: Throwable -> L18
        this.mStrongWifiExit = false;     // Catch: Throwable -> L18
        this.mMigrationReason = 0;     // Catch: Throwable -> L18
        this.mStoreType = r5.storeType;     // Catch: Throwable -> L18
        this.mExited = false;     // Catch: Throwable -> L18
        this.mLastLeaveEventId = 0;     // Catch: Throwable -> L18
        this.mLastLeaveReason = 0;     // Catch: Throwable -> L18
        this.mCoreAnchorCount = 0;     // Catch: Throwable -> L18
        this.mBackgroundAnchorCount = 0;     // Catch: Throwable -> L18
        this.mAnchorOverflowCount = 0;     // Catch: Throwable -> L18
        this.mSittableCandidateActive = false;     // Catch: Throwable -> L18
        this.mSittableLockout = false;     // Catch: Throwable -> L18
        this.mTimeoutRescuePending = false;     // Catch: Throwable -> L18
        clearLegacyVerifyLocked();     // Catch: Throwable -> L18
        if (r5.reportMode == 0) goto L6;
        openLogSessionLocked();     // Catch: Throwable -> L18
    L8:
        if (this.mConnected == true) goto L10;
    L15:
        this.mPendingStartConfig = this.mConfig.copy();     // Catch: Throwable -> L18
        addLogLocked("START_DEFERRED connected=" + this.mConnected + " ready=" + this.mReady);     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L10:
        if (this.mReady == false) goto L15;
        this.mPendingStartConfig = null;     // Catch: Throwable -> L18
        sendCommandLocked(1);     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L6:
        this.mCurrentLogPath = "";     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public synchronized void stopTask() {
        monitor-enter(this);
        this.mConfigOperationGeneration++;     // Catch: Throwable -> L11
        this.mPendingStartConfig = null;     // Catch: Throwable -> L11
        this.mPendingUpdateConfig = null;     // Catch: Throwable -> L11
        if (this.mPendingResetConfig == false) goto L6;
        addLogLocked("RESET_CANCELLED_BY_STOP");     // Catch: Throwable -> L11
    L6:
        this.mPendingResetConfig = false;     // Catch: Throwable -> L11
        this.mResetAwaitingConfig = false;     // Catch: Throwable -> L11
        cancelConfigQueryRetryLocked();     // Catch: Throwable -> L11
        Config r0 = this.mConfig;     // Catch: Throwable -> L11
        int r1 = this.mConfigVersion + 1;     // Catch: Throwable -> L11
        this.mConfigVersion = r1;     // Catch: Throwable -> L11
        r0.configVersion = r1;     // Catch: Throwable -> L11
        clearProtocolIdentityLocked();     // Catch: Throwable -> L11
        clearLegacyVerifyLocked();     // Catch: Throwable -> L11
        if (this.mConnected == false) goto L9;
        sendCommandLocked(2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public synchronized void triggerOnce() {
        monitor-enter(this);
        sendCommandLocked(4);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void updateConfig(Bundle r3) {
        monitor-enter(this);
        Config r0 = desiredConfigLocked().copy();     // Catch: Throwable -> L105
        if (r3.containsKey("scanWatchdogSeconds") == false) goto L7;
        r0.scanWatchdogSeconds = r3.getInt("scanWatchdogSeconds");     // Catch: Throwable -> L105
    L7:
        if (r3.containsKey("eventAckTimeoutSeconds") == false) goto L10;
        r0.eventAckTimeoutSeconds = r3.getInt("eventAckTimeoutSeconds");     // Catch: Throwable -> L105
    L10:
        if (r3.containsKey("retryBackoffInitialSeconds") == false) goto L13;
        r0.retryBackoffInitialSeconds = r3.getInt("retryBackoffInitialSeconds");     // Catch: Throwable -> L105
    L13:
        if (r3.containsKey("retryBackoffMaxSeconds") == false) goto L16;
        r0.retryBackoffMaxSeconds = r3.getInt("retryBackoffMaxSeconds");     // Catch: Throwable -> L105
    L16:
        if (r3.containsKey("minimumAnchorCountForStrongExit") == false) goto L19;
        r0.minimumAnchorCountForStrongExit = r3.getInt("minimumAnchorCountForStrongExit");     // Catch: Throwable -> L105
    L19:
        if (r3.containsKey("minimumStrongExitDensityPercent") == false) goto L22;
        r0.minimumStrongExitDensityPercent = r3.getInt("minimumStrongExitDensityPercent");     // Catch: Throwable -> L105
    L22:
        if (r3.containsKey("anchorFrameCount") == false) goto L25;
        r0.anchorFrameCount = r3.getInt("anchorFrameCount");     // Catch: Throwable -> L105
    L25:
        if (r3.containsKey("anchorMinHits") == false) goto L28;
        r0.anchorMinHits = r3.getInt("anchorMinHits");     // Catch: Throwable -> L105
    L28:
        if (r3.containsKey("anchorMaxMadDb") == false) goto L31;
        r0.anchorMaxMadDb = r3.getInt("anchorMaxMadDb");     // Catch: Throwable -> L105
    L31:
        if (r3.containsKey("anchorMinStableCount") == false) goto L34;
        r0.anchorMinStableCount = r3.getInt("anchorMinStableCount");     // Catch: Throwable -> L105
    L34:
        if (r3.containsKey("coreWeightQuarters") == false) goto L37;
        r0.coreWeightQuarters = r3.getInt("coreWeightQuarters");     // Catch: Throwable -> L105
    L37:
        if (r3.containsKey("backgroundWeightQuarters") == false) goto L40;
        r0.backgroundWeightQuarters = r3.getInt("backgroundWeightQuarters");     // Catch: Throwable -> L105
    L40:
        if (r3.containsKey("anchorIntervalSeconds") == false) goto L43;
        r0.anchorIntervalSeconds = r3.getInt("anchorIntervalSeconds");     // Catch: Throwable -> L105
    L43:
        if (r3.containsKey("monitorIntervalSeconds") == false) goto L46;
        r0.monitorIntervalSeconds = r3.getInt("monitorIntervalSeconds");     // Catch: Throwable -> L105
    L46:
        if (r3.containsKey("followUpIntervalSeconds") == false) goto L49;
        r0.followUpIntervalSeconds = r3.getInt("followUpIntervalSeconds");     // Catch: Throwable -> L105
    L49:
        if (r3.containsKey("gateCheckSeconds") == false) goto L52;
        r0.gateCheckSeconds = r3.getInt("gateCheckSeconds");     // Catch: Throwable -> L105
    L52:
        if (r3.containsKey("scanWake60sMinSteps") == false) goto L55;
        r0.scanWake60sMinSteps = r3.getInt("scanWake60sMinSteps");     // Catch: Throwable -> L105
    L55:
        if (r3.containsKey("sittableStart60sSteps") == false) goto L58;
        r0.sittableStart60sSteps = r3.getInt("sittableStart60sSteps");     // Catch: Throwable -> L105
    L58:
        if (r3.containsKey("sittableKeep60sSteps") == false) goto L61;
        r0.sittableKeep60sSteps = r3.getInt("sittableKeep60sSteps");     // Catch: Throwable -> L105
    L61:
        if (r3.containsKey("walkableFirst40sSteps") == false) goto L64;
        r0.walkableFirst40sSteps = r3.getInt("walkableFirst40sSteps");     // Catch: Throwable -> L105
    L64:
        if (r3.containsKey("walkableFirst60sSteps") == false) goto L67;
        r0.walkableFirst60sSteps = r3.getInt("walkableFirst60sSteps");     // Catch: Throwable -> L105
    L67:
        if (r3.containsKey("migrationConfirmFrames") == false) goto L70;
        r0.migrationConfirmFrames = r3.getInt("migrationConfirmFrames");     // Catch: Throwable -> L105
    L70:
        if (r3.containsKey("sharedStableMinCount") == false) goto L73;
        r0.sharedStableMinCount = r3.getInt("sharedStableMinCount");     // Catch: Throwable -> L105
    L73:
        if (r3.containsKey("rssiMedianDeltaMinDb") == false) goto L76;
        r0.rssiMedianDeltaMinDb = r3.getInt("rssiMedianDeltaMinDb");     // Catch: Throwable -> L105
    L76:
        if (r3.containsKey("delta8MinPercent") == false) goto L79;
        r0.delta8MinPercent = r3.getInt("delta8MinPercent");     // Catch: Throwable -> L105
    L79:
        if (r3.containsKey("rssiShiftDensityMinPercent") == false) goto L82;
        r0.rssiShiftDensityMinPercent = r3.getInt("rssiShiftDensityMinPercent");     // Catch: Throwable -> L105
    L82:
        if (r3.containsKey("lowRetainAnchorMinCount") == false) goto L85;
        r0.lowRetainAnchorMinCount = r3.getInt("lowRetainAnchorMinCount");     // Catch: Throwable -> L105
    L85:
        if (r3.containsKey("lowRetainMaxPercent") == false) goto L88;
        r0.lowRetainMaxPercent = r3.getInt("lowRetainMaxPercent");     // Catch: Throwable -> L105
    L88:
        if (r3.containsKey("lowRetainDensityMinPercent") == false) goto L91;
        r0.lowRetainDensityMinPercent = r3.getInt("lowRetainDensityMinPercent");     // Catch: Throwable -> L105
    L91:
        if (r3.containsKey("strongExitMaxSharedBssid") == false) goto L94;
        r0.strongExitMaxSharedBssid = r3.getInt("strongExitMaxSharedBssid");     // Catch: Throwable -> L105
    L94:
        if (r3.containsKey("coreRssiThresholdAbsDbm") == false) goto L97;
        r0.coreRssiThresholdAbsDbm = r3.getInt("coreRssiThresholdAbsDbm");     // Catch: Throwable -> L105
    L97:
        if (r3.containsKey("identityHandoffStepThreshold") == false) goto L100;
        r0.identityHandoffStepThreshold = r3.getInt("identityHandoffStepThreshold");     // Catch: Throwable -> L105
    L100:
        if (r3.containsKey("identityHandoffStationary60sSteps") == false) goto L102;
        r0.identityHandoffStationary60sSteps = r3.getInt("identityHandoffStationary60sSteps");     // Catch: Throwable -> L105
    L102:
        updateTaskLocked(r0, true);     // Catch: Throwable -> L105
        monitor-exit(this);
        return;
    L105:
        th = move-exception;
        throw th;
    }

    public synchronized void updateTask(Config r2) {
        monitor-enter(this);
        updateTaskLocked(r2, false);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
