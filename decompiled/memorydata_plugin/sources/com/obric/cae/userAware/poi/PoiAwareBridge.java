package com.obric.cae.userAware.poi;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.obric.cae.libs.statemachine.d;
import com.obric.cae.log.a;
import com.obric.cae.userAware.sensorbridge.SensorBridgeClient;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import vendor.aware.sensorbridge.SensorBridgeEvent;

/* JADX INFO: loaded from: classes3.dex */
public final class PoiAwareBridge {
    private static final int COMMAND_MESSAGE_ID = 1061;
    private static final int CONFIG_EVENT_MESSAGE_ID = 1065;
    private static final long CONFIG_QUERY_RETRY_BASE_MS = 1000;
    private static final int DEBUG_EVENT_MESSAGE_ID = 1064;
    private static final int DELIVERY_WAKEUP = 0;
    private static final int MAX_CONFIG_QUERY_RETRIES = 3;
    private static final int MAX_LOGS = 100;
    public static final int MODE_ADSP_ONLY = 1;
    public static final int MODE_AP_ONLY = 0;
    public static final int MODE_DUAL_COMPARE = 2;
    private static final int REQUEST_SCOPE_COMMAND = 4;
    private static final String SENSOR_NAME = "poi_aware";
    private static final int STATUS_EVENT_MESSAGE_ID = 1063;
    private static final String TAG = "PoiAdspBridge";
    private static final int TRIGGER_TRANSPORT = 3;
    private static final int WAKEUP_EVENT_MESSAGE_ID = 1062;
    private int mAcceptedConfigVersion;
    private int mAcceptedRequestId;
    private int mAcceptedSessionEpoch;
    private int mAcceptedState;
    private int mAcceptedStateVersion;
    private int mActiveConfigVersion;
    private int mActiveSessionEpoch;
    private int mActiveState;
    private int mActiveStateVersion;
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
    private Bundle mDebugSnapshot;
    private Bundle mEffectiveConfig;
    private boolean mHasActiveIdentity;
    private boolean mHasExplicitConfigIntent;
    private int mLastAckStateVersion;
    private int mLastCompletedRequestId;
    private int mLastError;
    private long mLastEventElapsedMs;
    private int mLastRequestId;
    private int mLastTriggerReason;
    private final Listener mListener;
    private final ArrayDeque<String> mLogs;
    private final Handler mMainHandler;
    private final AtomicInteger mNextCommandId;
    private int mPendingConfigQueryGeneration;
    private int mPendingConfigQueryRequestId;
    private int mPendingConfigVersion;
    private int mPendingIdentityCommand;
    private int mPendingIdentityRequestId;
    private int mPendingRecoveryConfigQueryGeneration;
    private int mPendingRecoveryConfigQueryRequestId;
    private boolean mPendingResetConfig;
    private int mPendingSessionEpoch;
    private int mPendingState;
    private int mPendingStateVersion;
    private Config mPendingUpdateConfig;
    private boolean mReady;
    private boolean mResetAwaitingConfig;
    private final int mSessionEpoch;
    private int mState;
    private int mStateVersion;
    private boolean mSubscribed;

    public static final class Config {
        public int algorithmVersion;
        public int configVersion;
        public int entryStepThreshold;
        public int eventAckTimeoutSeconds;
        public int expectedConfigVersion;
        public int harGuardStepThreshold;
        public int harHoldSeconds;
        public int requiredLowChecks;
        public int retryBackoffInitialSeconds;
        public int retryBackoffMaxSeconds;
        public int stationaryCheckIntervalMs;
        public int stationaryDelaySeconds;
        public int stationaryStepDeltaThreshold;
        public int stepWindowBucketCount;
        public int stepWindowSeconds;
        public int upDownSuppressSeconds;
        public int walkStepThreshold;

        public Config() {
            this.expectedConfigVersion = -1;
            this.algorithmVersion = 130;
            this.stationaryDelaySeconds = 20;
            this.walkStepThreshold = TypedValues.TransitionType.TYPE_DURATION;
            this.stationaryStepDeltaThreshold = 15;
            this.stationaryCheckIntervalMs = AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH;
            this.upDownSuppressSeconds = 20;
            this.stepWindowBucketCount = 3;
            this.entryStepThreshold = 20;
            this.requiredLowChecks = 1;
            this.harHoldSeconds = 20;
            this.harGuardStepThreshold = 50;
            this.eventAckTimeoutSeconds = 5;
            this.retryBackoffInitialSeconds = 5;
            this.retryBackoffMaxSeconds = 20;
            this.stepWindowSeconds = 60;
        }

        public Config copy() {
            Config r0 = new Config();
            r0.configVersion = this.configVersion;
            r0.expectedConfigVersion = this.expectedConfigVersion;
            r0.algorithmVersion = this.algorithmVersion;
            r0.stationaryDelaySeconds = this.stationaryDelaySeconds;
            r0.walkStepThreshold = this.walkStepThreshold;
            r0.stationaryStepDeltaThreshold = this.stationaryStepDeltaThreshold;
            r0.stationaryCheckIntervalMs = this.stationaryCheckIntervalMs;
            r0.upDownSuppressSeconds = this.upDownSuppressSeconds;
            r0.stepWindowBucketCount = this.stepWindowBucketCount;
            r0.entryStepThreshold = this.entryStepThreshold;
            r0.requiredLowChecks = this.requiredLowChecks;
            r0.harHoldSeconds = this.harHoldSeconds;
            r0.harGuardStepThreshold = this.harGuardStepThreshold;
            r0.eventAckTimeoutSeconds = this.eventAckTimeoutSeconds;
            r0.retryBackoffInitialSeconds = this.retryBackoffInitialSeconds;
            r0.retryBackoffMaxSeconds = this.retryBackoffMaxSeconds;
            r0.stepWindowSeconds = this.stepWindowSeconds;
            return r0;
        }
    }

    public interface Listener {
        void onBridgeStateChanged();

        void onDisconnected();

        void onPoiRequest(int r1, int r2, Bundle r3);

        void onReady();

        void onStateSynchronized(int r1);

        void onTransportDetected(Bundle r1);
    }

    public PoiAwareBridge(Context r7, Listener r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Listener r10 = (Listener) ZeusTransformUtils.wrapperContextForParams(r8, Listener.class, "com.obric.memorydata.plugin");
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mNextCommandId = new AtomicInteger(1);
        this.mLogs = new ArrayDeque();
        this.mSessionEpoch = (int) (System.currentTimeMillis() ^ SystemClock.elapsedRealtime());
        this.mConfig = new Config();
        this.mDebugSnapshot = new Bundle();
        this.mEffectiveConfig = new Bundle();
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r9), Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        r9 = r0;
    L5:
        this.mContext = ZeusTransformUtils.wrapperContext(r9, "com.obric.memorydata.plugin");
        this.mListener = (Listener) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r10), Listener.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ int access$008(PoiAwareBridge r2) {
        int r0 = r2.mConfigOperationGeneration;
        r2.mConfigOperationGeneration = r0 + 1;
        return r0;
    }

    public static /* synthetic */ void access$100(PoiAwareBridge r0) {
        r0.clearProtocolIdentityLocked();
    }

    public static /* synthetic */ boolean access$1002(PoiAwareBridge r0, boolean r1) {
        r0.mSubscribed = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$1102(PoiAwareBridge r0, boolean r1) {
        r0.mReady = r1;
        return r1;
    }

    public static /* synthetic */ Listener access$1200(PoiAwareBridge r0) {
        return r0.mListener;
    }

    public static /* synthetic */ Handler access$1300(PoiAwareBridge r0) {
        return r0.mMainHandler;
    }

    public static /* synthetic */ void access$1400(PoiAwareBridge r0, SensorBridgeEvent[] r1) {
        r0.handleEvents(r1);
    }

    public static /* synthetic */ int access$1502(PoiAwareBridge r0, int r1) {
        r0.mLastError = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$202(PoiAwareBridge r0, boolean r1) {
        r0.mConfigMutationRecoveryPending = r1;
        return r1;
    }

    public static /* synthetic */ boolean access$302(PoiAwareBridge r0, boolean r1) {
        r0.mConnected = r1;
        return r1;
    }

    public static /* synthetic */ int access$402(PoiAwareBridge r0, int r1) {
        r0.mClientId = r1;
        return r1;
    }

    public static /* synthetic */ void access$500(PoiAwareBridge r0, String r1) {
        r0.addLog(r1);
    }

    public static /* synthetic */ void access$600(PoiAwareBridge r0) {
        r0.subscribeLocked();
    }

    public static /* synthetic */ void access$700(PoiAwareBridge r0) {
        r0.notifyChanged();
    }

    public static /* synthetic */ boolean access$800(PoiAwareBridge r0) {
        return r0.mResetAwaitingConfig;
    }

    public static /* synthetic */ boolean access$902(PoiAwareBridge r0, boolean r1) {
        r0.mPendingResetConfig = r1;
        return r1;
    }

    private synchronized void addLog(String r4) {
        monitor-enter(this);
        String r0 = System.currentTimeMillis() + " " + r4;     // Catch: Throwable -> L9
        if (this.mLogs.size() < 100) goto L6;
        this.mLogs.removeFirst();     // Catch: Throwable -> L9
    L6:
        this.mLogs.addLast(r0);     // Catch: Throwable -> L9
        a.e(TAG, r4);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void appendTraceRecordIfPresent(PoiAwareCodec.Event r14, Bundle r15) {
        if (r14.hasVarintField(18) == true) goto L5;
        return;
    L5:
        Bundle r1 = new Bundle(r15);
        int r16 = r14.intValue(19, 0);
        int r10 = r14.intValue(20, 0);
        int r12 = r14.intValue(21, 1);
        r1.putInt("traceRecordType", r14.intValue(18, 0));
        r1.putInt("dumpId", r16);
        r1.putInt("traceIndex", r10);
        r1.putInt("traceCount", r12);
        r1.putInt("traceDecision", r14.intValue(22, 0));
        r1.putInt("traceDecisionReason", r14.intValue(23, 0));
        r1.putInt("configVersion", r14.intValue(24, this.mConfig.configVersion));
        r1.putInt("step20s", r14.intValue(25, 0));
        r1.putInt("step60s", r14.intValue(26, 0));
        PoiAdspTraceLogger r13 = PoiAdspTraceLogger.getInstance(this.mContext);
        if (r16 != 0) goto L8;
        String r17 = "REQUEST_POI";
    L9:
        if (r16 == 0) goto L12;
        if (r10 != 0) goto L12;
        Bundle r9 = new Bundle(r1);
        r9.putInt("traceCount", r12);
        r13.append("dump_begin", r17, SENSOR_NAME, "TRACE_DUMP_BEGIN", "NOOP", "MANUAL_DUMP", r9);
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

    private void applyConfigLocked(Config r4, boolean r5) {
        boolean r0 = this.mConfigMutationRecoveryPending;
        this.mConfigOperationGeneration++;
        if (r0 == false) goto L5;
        this.mPendingRecoveryConfigQueryRequestId = 0;
        scheduleConfigQueryRetryLocked(true, true);
    L6:
        if (r5 == false) goto L9;
        this.mHasExplicitConfigIntent = true;
        this.mResetAwaitingConfig = false;
    L9:
        if (this.mPendingResetConfig == false) goto L11;
        addLog("RESET_SUPERSEDED_BY_UPDATE");
    L11:
        this.mPendingResetConfig = false;
        this.mPendingUpdateConfig = r4.copy();
        dispatchPendingUpdateLocked();
        return;
    L5:
        cancelConfigQueryRetryLocked();
        goto L6
    }

    private void cancelConfigQueryRetryLocked() {
        this.mConfigQueryRetryGeneration++;
        this.mConfigQueryRetryCount = 0;
    }

    private synchronized void clearAcceptedWakeupLocked() {
        monitor-enter(this);
        this.mAcceptedRequestId = 0;     // Catch: Throwable -> L7
        this.mAcceptedSessionEpoch = 0;     // Catch: Throwable -> L7
        this.mAcceptedStateVersion = 0;     // Catch: Throwable -> L7
        this.mAcceptedState = 0;     // Catch: Throwable -> L7
        this.mAcceptedConfigVersion = 0;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void clearPendingIdentityLocked() {
        this.mPendingIdentityRequestId = 0;
        this.mPendingIdentityCommand = 0;
        this.mPendingSessionEpoch = 0;
        this.mPendingStateVersion = 0;
        this.mPendingState = 0;
        this.mPendingConfigVersion = 0;
    }

    private void clearProtocolIdentityLocked() {
        cancelConfigQueryRetryLocked();
        clearPendingIdentityLocked();
        this.mPendingConfigQueryRequestId = 0;
        this.mPendingRecoveryConfigQueryRequestId = 0;
        this.mPendingConfigQueryGeneration = 0;
        this.mPendingRecoveryConfigQueryGeneration = 0;
        this.mHasActiveIdentity = false;
        this.mActiveSessionEpoch = 0;
        this.mActiveStateVersion = 0;
        this.mActiveState = 0;
        this.mActiveConfigVersion = 0;
        this.mLastAckStateVersion = 0;
        clearAcceptedWakeupLocked();
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
        if (this.mPendingIdentityRequestId == 0) goto L11;
        return;
    L11:
        if (this.mPendingUpdateConfig == null) goto L13;
        return;
    L13:
        if (this.mConfigMutationRecoveryPending == false) goto L15;
        return;
    L15:
        if (isStateSynchronized() == false) goto L25;
        this.mPendingResetConfig = false;
        Config r1 = this.mConfig;
        int r2 = this.mConfigVersion;
        r1.expectedConfigVersion = r2;
        int r3 = r2 + 1;
        this.mConfigVersion = r3;
        r1.configVersion = r3;
        sendCommandLocked(7, 0, 0, true);
        return;
    }

    private void dispatchPendingUpdateLocked() {
        if (this.mPendingUpdateConfig != null) goto L5;
        return;
    L5:
        if (this.mConnected == true) goto L7;
        return;
    L7:
        if (this.mReady == true) goto L9;
        return;
    L9:
        if (this.mPendingIdentityRequestId == 0) goto L11;
        return;
    L11:
        if (this.mConfigMutationRecoveryPending == false) goto L13;
        return;
    L13:
        if (this.mPendingRecoveryConfigQueryRequestId == 0) goto L15;
        return;
    L15:
        if (isStateSynchronized() == false) goto L25;
        Config r0 = this.mPendingUpdateConfig;
        this.mPendingUpdateConfig = null;
        int r1 = this.mConfigVersion;
        r0.expectedConfigVersion = r1;
        int r2 = r1 + 1;
        this.mConfigVersion = r2;
        r0.configVersion = r2;
        this.mConfig = r0;
        sendCommandLocked(3, 0, 0, true);
        return;
    }

    private void handleDebug(PoiAwareCodec.Event r18) {
        monitor-enter(this);
    L62:
        th = move-exception;
        throw th;
    L6:
        if (r18.hasVarintField(27) == true) goto L8;
    L10:
        boolean r3 = false;
    L12:
        if (r18.hasVarintField(31) == true) goto L14;
    L16:
        boolean r4 = false;
    L17:
        Bundle r15 = new Bundle();     // Catch: Throwable -> L62
        r15.putLong("timestampTicks", r18.value2);     // Catch: Throwable -> L62
        r15.putInt("sessionEpoch", (int) r18.value3);     // Catch: Throwable -> L62
        r15.putInt("stateVersion", (int) r18.value4);     // Catch: Throwable -> L62
        r15.putInt("state", (int) r18.value5);     // Catch: Throwable -> L62
        r15.putInt("har", (int) r18.value6);     // Catch: Throwable -> L62
        r15.putInt("steps", (int) r18.value7);     // Catch: Throwable -> L62
        r15.putInt("stationaryBaseline", (int) r18.value8);     // Catch: Throwable -> L62
        r15.putInt("walkBaseline", (int) r18.value9);     // Catch: Throwable -> L62
        r15.putInt("stepDelta", (int) r18.value10);     // Catch: Throwable -> L62
        if (r18.value11 == 0) goto L20;
        boolean r8 = true;
    L21:
        r15.putBoolean("stationary", r8);     // Catch: Throwable -> L62
        if (r18.value12 == 0) goto L24;
        boolean r9 = true;
    L25:
        r15.putBoolean("walkPending", r9);     // Catch: Throwable -> L62
        if (r18.value13 == 0) goto L28;
        boolean r10 = true;
    L29:
        r15.putBoolean("requestPending", r10);     // Catch: Throwable -> L62
        r15.putInt("pendingRequestId", (int) r18.value14);     // Catch: Throwable -> L62
        r15.putLong("suppressUntilTicks", r18.value15);     // Catch: Throwable -> L62
        r15.putLong("timerDeadlineTicks", r18.value16);     // Catch: Throwable -> L62
        r15.putInt("lastError", (int) r18.value17);     // Catch: Throwable -> L62
        r15.putBoolean("harConfirmed", r3);     // Catch: Throwable -> L62
        r15.putInt("stationaryWindowStepSum", r18.intValue(28, -1));     // Catch: Throwable -> L62
        r15.putInt("stationaryWindowBucketCount", r18.intValue(29, -1));     // Catch: Throwable -> L62
        r15.putInt("lowCheckStreak", r18.intValue(30, -1));     // Catch: Throwable -> L62
        r15.putBoolean("stepStationaryEvidence", r4);     // Catch: Throwable -> L62
        r15.putInt("step20s", r18.intValue(25, -1));     // Catch: Throwable -> L62
        r15.putInt("step60s", r18.intValue(26, r18.intValue(28, -1)));     // Catch: Throwable -> L62
        long r6 = r18.value16;     // Catch: Throwable -> L62
        long r13 = r18.value2;     // Catch: Throwable -> L62
        if (r6 <= r13) goto L32;
        long r7 = r6 - r13;     // Catch: Throwable -> L62
    L33:
        String r14 = stationarySource(r3, r4);     // Catch: Throwable -> L62
        if (r18.value13 == 0) goto L38;
        String r11 = "REQUEST_PENDING";
    L36:
        String r12 = r11;
        r15.putLong("timerRemainingTicks", r7);     // Catch: Throwable -> L62
        r15.putString("stationarySource", r14);     // Catch: Throwable -> L62
        r15.putString("timerPhase", r12);     // Catch: Throwable -> L62
        StringBuilder r16 = new StringBuilder("DEBUG_SNAPSHOT eventTicks=").append(r18.value2).append(" epoch=").append(r18.value3).append(" stateVersion=").append(r18.value4).append(" state=").append(r18.value5).append(" har=").append(r18.value6).append(" steps=").append(r18.value7).append(" stationaryBaseline=").append(r18.value8).append(" walkBaseline=").append(r18.value9).append(" stepDelta=").append(r18.value10).append(" stationary=");     // Catch: Throwable -> L62
        if (r18.value11 == 0) goto L46;
        boolean r17 = true;
    L47:
        StringBuilder r5 = r16.append(r17).append(" stationarySource=").append(r14).append(" harConfirmed=").append(r3).append(" stepStationaryEvidence=").append(r4).append(" stationaryWindow=").append(r18.intValue(28, -1)).append("/").append(r18.intValue(29, -1)).append(" lowCheckStreak=").append(r18.intValue(30, -1)).append(" walkPending=");     // Catch: Throwable -> L62
        if (r18.value12 == 0) goto L50;
        boolean r19 = true;
    L51:
        StringBuilder r20 = r5.append(r19).append(" requestPending=");     // Catch: Throwable -> L62
        if (r18.value13 == 0) goto L54;
        boolean r21 = true;
    L55:
        addLog(r20.append(r21).append(" pendingRequestId=").append(r18.value14).append(" timerPhase=").append(r12).append(" timerDeadlineTicks=").append(r18.value16).append(" timerRemainingTicks=").append(r7).append(" suppressUntilTicks=").append(r18.value15).append(" lastError=").append((int) r18.value17).toString());     // Catch: Throwable -> L62
        if (r18.hasVarintField(18) == true) goto L58;
        this.mDebugSnapshot = r15;     // Catch: Throwable -> L62
        PoiAdspTraceLogger.getInstance(this.mContext).append("snapshot", "MANUAL_DUMP", SENSOR_NAME, "DEBUG_SNAPSHOT", "NOOP", r12, r15);     // Catch: Throwable -> L62
    L58:
        appendTraceRecordIfPresent(r18, r15);     // Catch: Throwable -> L62
        monitor-exit(this);     // Catch: Throwable -> L62
        notifyChanged();
        return;
    L54:
        r21 = false;
        goto L55
    L50:
        r19 = false;
        goto L51
    L46:
        r17 = false;
        goto L47
    L38:
        if (r18.value11 != 0) goto L40;
    L42:
        r11 = "STEP_CHECK";
        goto L36
    L40:
        if (r7 <= 0) goto L42;
        r11 = "STATIONARY_DELAY";
        goto L36
    L32:
        r7 = 0;
        goto L33
    L28:
        r10 = false;
        goto L29
    L24:
        r9 = false;
        goto L25
    L20:
        r8 = false;
        goto L21
    L14:
        if (r18.intValue(31, 0) == 0) goto L16;
        r4 = true;
        goto L17
    L8:
        if (r18.intValue(27, 0) == 0) goto L10;
        r3 = true;
        goto L12
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
    }

    private void handleStatus(PoiAwareCodec.Event r11) {
        monitor-enter(this);
        this.mLastEventElapsedMs = SystemClock.elapsedRealtime();     // Catch: Throwable -> L77
        int r3 = r11.typeOrReason;     // Catch: Throwable -> L77
        boolean r5 = false;
        if (r3 != 1) goto L8;
        boolean r12 = !this.mReady;     // Catch: Throwable -> L77
        this.mReady = true;     // Catch: Throwable -> L77
        addLog("READY");     // Catch: Throwable -> L77
        boolean r2 = false;
        final int r4 = 0;
        r5 = r12;
    L70:
        monitor-exit(this);     // Catch: Throwable -> L77
        if (r5 == false) goto L73;
        Handler r13 = this.mMainHandler;
        final Listener r0 = this.mListener;
        Objects.requireNonNull(r0);
        r13.post(new $$Lambda$wDhPKHceCdv3eEFBdyEEcxjYKZc(r0));
    L73:
        if (r2 == false) goto L75;
        this.mMainHandler.post(new $$Lambda$PoiAwareBridge$1f4lBDKsu8KwcPyJqAE7pwTHI8(this, r4));
    L75:
        notifyChanged();
        return;
    L8:
        if (r3 == 2) goto L10;
        this.mLastError = (int) r11.value3;     // Catch: Throwable -> L77
        addLog("STATUS_ERROR code=" + this.mLastError);     // Catch: Throwable -> L77
        int r14 = r11.requestId;     // Catch: Throwable -> L77
        int r1 = this.mPendingIdentityCommand;     // Catch: Throwable -> L77
        int r6 = this.mPendingIdentityRequestId;     // Catch: Throwable -> L77
        if (r14 != r6) goto L41;
        if (r1 == 3) goto L40;
        if (r1 != 7) goto L41;
    L40:
        boolean r7 = true;
    L43:
        if (r14 == this.mPendingRecoveryConfigQueryRequestId) goto L45;
    L47:
        boolean r8 = false;
    L49:
        if (r14 == this.mPendingConfigQueryRequestId) goto L51;
    L53:
        boolean r9 = false;
    L54:
        if (r14 != r6) goto L56;
        clearPendingIdentityLocked();     // Catch: Throwable -> L77
    L56:
        if (r7 == false) goto L59;
        if (r1 != 7) goto L59;
        this.mPendingResetConfig = true;     // Catch: Throwable -> L77
    L59:
        if (r8 == false) goto L61;
        this.mPendingRecoveryConfigQueryRequestId = 0;     // Catch: Throwable -> L77
    L61:
        if (r9 == false) goto L63;
        this.mPendingConfigQueryRequestId = 0;     // Catch: Throwable -> L77
    L63:
        if (r7 == false) goto L65;
        this.mConfigMutationRecoveryPending = true;     // Catch: Throwable -> L77
        scheduleConfigQueryRetryLocked(true, true);     // Catch: Throwable -> L77
    L69:
        r2 = false;
        r4 = 0;
        goto L70
    L65:
        if (r8 == false) goto L67;
        scheduleConfigQueryRetryLocked(true, false);     // Catch: Throwable -> L77
        goto L69
    L67:
        if (r9 == false) goto L69;
        scheduleConfigQueryRetryLocked(false, false);     // Catch: Throwable -> L77
        goto L69
    L51:
        if (this.mPendingConfigQueryGeneration != this.mConfigOperationGeneration) goto L53;
        r9 = true;
        goto L54
    L45:
        if (this.mPendingRecoveryConfigQueryGeneration != this.mConfigOperationGeneration) goto L47;
        r8 = true;
    L41:
        r7 = false;
        goto L43
    L10:
        if (r11.hasVarintField(1) == true) goto L12;
    L30:
        boolean r10 = false;
    L31:
        if (r10 == false) goto L35;
        int r15 = this.mPendingIdentityCommand;     // Catch: Throwable -> L77
        this.mHasActiveIdentity = true;     // Catch: Throwable -> L77
        this.mActiveSessionEpoch = this.mPendingSessionEpoch;     // Catch: Throwable -> L77
        int r16 = this.mPendingStateVersion;     // Catch: Throwable -> L77
        this.mActiveStateVersion = r16;     // Catch: Throwable -> L77
        this.mActiveState = this.mPendingState;     // Catch: Throwable -> L77
        this.mActiveConfigVersion = this.mPendingConfigVersion;     // Catch: Throwable -> L77
        this.mLastAckStateVersion = r16;     // Catch: Throwable -> L77
        clearPendingIdentityLocked();     // Catch: Throwable -> L77
        clearAcceptedWakeupLocked();     // Catch: Throwable -> L77
        dispatchPendingUpdateLocked();     // Catch: Throwable -> L77
        dispatchPendingResetLocked();     // Catch: Throwable -> L77
        r2 = isStateSynchronized();     // Catch: Throwable -> L77
        r4 = this.mLastAckStateVersion;     // Catch: Throwable -> L77
        addLog("ACK command=" + r11.requestId + " v=" + this.mLastAckStateVersion);     // Catch: Throwable -> L77
        if (r15 != 7) goto L70;
        sendCommandLocked(6, 0, 0, false);     // Catch: Throwable -> L77
        goto L70
    L35:
        addLog("ACK_IGNORED command=" + r11.requestId);     // Catch: Throwable -> L77
        goto L69
    L12:
        if (r11.hasVarintField(5) == false) goto L30;
        if (r11.hasVarintField(6) == false) goto L30;
        if (r11.hasVarintField(7) == false) goto L30;
        if (r11.requestId != this.mPendingIdentityRequestId) goto L30;
        int r17 = this.mPendingIdentityCommand;     // Catch: Throwable -> L77
        if (r17 == 2) goto L24;
        if (r17 == 3) goto L24;
        if (r17 != 7) goto L30;
    L24:
        if (((int) r11.value5) != this.mPendingSessionEpoch) goto L30;
        if (((int) r11.value6) != this.mPendingStateVersion) goto L30;
        if (((int) r11.value7) != this.mPendingState) goto L30;
        r10 = true;
    L77:
        th = move-exception;
        throw th;
    }

    private void handleWakeup(final PoiAwareCodec.Event r20) {
        final Bundle r15 = new Bundle();
        r15.putInt("requestId", r20.requestId);
        r15.putInt(InfoRequestQPSOptTraceLogger.REASON, r20.typeOrReason);
        r15.putLong("timestampTicks", r20.value3);
        r15.putInt("sessionEpoch", (int) r20.value4);
        r15.putInt("stateVersion", (int) r20.value5);
        r15.putInt("state", (int) r20.value6);
        r15.putInt("steps", (int) r20.value7);
        r15.putInt("baseline", (int) r20.value8);
        r15.putInt("stepDelta", (int) r20.value9);
        r15.putInt("har", (int) r20.value10);
        r15.putInt("configVersion", (int) r20.value11);
        monitor-enter(this);
        int r11 = (int) r20.value4;     // Catch: Throwable -> L57
        int r12 = (int) r20.value5;     // Catch: Throwable -> L57
        int r13 = (int) r20.value6;     // Catch: Throwable -> L57
        int r14 = (int) r20.value11;     // Catch: Throwable -> L57
        if (r20.requestId != 0) goto L7;
    L9:
        boolean r18 = false;
    L10:
        if (r18 == true) goto L12;
    L16:
        boolean r1 = false;
    L17:
        if (r18 == true) goto L19;
    L27:
        boolean r2 = false;
    L28:
        if (r1 == true) goto L32;
        if (r2 == true) goto L32;
        int r3 = 2;
    L33:
        if (r2 == false) goto L36;
        if (r1 == true) goto L36;
        int r4 = r20.requestId;     // Catch: Throwable -> L57
        this.mAcceptedRequestId = r4;     // Catch: Throwable -> L57
        this.mAcceptedSessionEpoch = r11;     // Catch: Throwable -> L57
        this.mAcceptedStateVersion = r12;     // Catch: Throwable -> L57
        this.mAcceptedState = r13;     // Catch: Throwable -> L57
        this.mAcceptedConfigVersion = r14;     // Catch: Throwable -> L57
        this.mLastRequestId = r4;     // Catch: Throwable -> L57
        this.mLastTriggerReason = r20.typeOrReason;     // Catch: Throwable -> L57
        this.mLastEventElapsedMs = SystemClock.elapsedRealtime();     // Catch: Throwable -> L57
        addLog("TRIGGER id=" + r20.requestId + " reason=" + r20.typeOrReason + " eventTicks=" + r20.value3 + " state=" + r20.value6 + " har=" + r20.value10 + " steps=" + r20.value7 + " baseline=" + r20.value8 + " delta=" + r20.value9);     // Catch: Throwable -> L57
        boolean r5 = true;
    L41:
        sendCompletionLocked(r20, r3);     // Catch: Throwable -> L57
        monitor-exit(this);     // Catch: Throwable -> L57
        PoiAdspTraceLogger r16 = PoiAdspTraceLogger.getInstance(this.mContext);
        if (r5 == false) goto L46;
        String r6 = "REQUEST_POI";
    L47:
        r16.append("snapshot", "REQUEST_POI", SENSOR_NAME, "ADSP_TO_AP_REQUEST_POI", r6, triggerReasonName(r20.typeOrReason), r15);
        if (r5 == true) goto L52;
        notifyChanged();
        return;
    L52:
        if (r20.typeOrReason != 3) goto L54;
        this.mMainHandler.post(new $$Lambda$PoiAwareBridge$OJSgcsp5kXpOyPaoWgip8GKh_DA(this, r15));
    L55:
        notifyChanged();
        return;
    L54:
        this.mMainHandler.post(new $$Lambda$PoiAwareBridge$nwRGBmQfx5S4yRxc6D_odxXxk(this, r20, r15));
        goto L55
    L46:
        r6 = "REJECTED";
    L36:
        if (r1 == false) goto L39;
        String r7 = "DUPLICATE_TRIGGER id=" + r20.requestId;     // Catch: Throwable -> L57
    L38:
        addLog(r7);     // Catch: Throwable -> L57
        r5 = false;
        goto L41
    L39:
        r7 = "STALE_TRIGGER id=" + r20.requestId + " epoch=" + r11 + "/" + this.mSessionEpoch + " version=" + r12 + "/" + this.mStateVersion + " state=" + r13 + "/" + this.mState + " config=" + r14 + "/" + this.mConfig.configVersion;     // Catch: Throwable -> L57
    L32:
        r3 = 1;
        goto L33
    L19:
        if (this.mClient == null) goto L27;
        if (this.mConnected == false) goto L27;
        if (this.mReady == false) goto L27;
        if (matchesActiveIdentityLocked(r11, r12, r13, r14) == false) goto L27;
        r2 = true;
        goto L28
    L12:
        if (matchesAcceptedWakeupLocked(r20.requestId, r11, r12, r13, r14) == false) goto L16;
        if (matchesActiveIdentityLocked(r11, r12, r13, r14) == false) goto L16;
        r1 = true;
        goto L17
    L7:
        if (r20.hasValidWakeupFields() == false) goto L9;
        r18 = true;
    L57:
        th = move-exception;
        throw th;
    }

    private synchronized boolean matchesAcceptedWakeupLocked(int r2, int r3, int r4, int r5, int r6) {
        monitor-enter(this);
        if (r2 != 0) goto L21;
    L18:
        boolean r7 = false;
    L19:
        monitor-exit(this);
        return r7;
    L21:
    L15:
        th = move-exception;
        throw th;
    L5:
        if (r2 != this.mAcceptedRequestId) goto L18;
        if (r3 != this.mAcceptedSessionEpoch) goto L18;
        if (r4 != this.mAcceptedStateVersion) goto L18;
        if (r5 != this.mAcceptedState) goto L18;
        if (r6 != this.mAcceptedConfigVersion) goto L18;
        r7 = true;
        goto L19
    }

    private boolean matchesActiveIdentityLocked(int r2, int r3, int r4, int r5) {
        if (this.mHasActiveIdentity == true) goto L5;
    L13:
        return false;
    L5:
        if (r2 != this.mActiveSessionEpoch) goto L13;
        if (r3 != this.mActiveStateVersion) goto L13;
        if (r4 != this.mActiveState) goto L13;
        if (r5 != this.mActiveConfigVersion) goto L13;
        return true;
    }

    private void notifyChanged() {
        Handler r0 = this.mMainHandler;
        final Listener r2 = this.mListener;
        Objects.requireNonNull(r2);
        r0.post(new $$Lambda$Fm8Iy2eWBWM9KyaIwhjLXpYvKcs(r2));
    }

    public static int resolveReportedAdspState(boolean r0, int r1, int r2) {
        if (r0 == false) goto L5;
        return r1;
    L5:
        return r2;
    }

    private void scheduleConfigQueryRetryLocked(final boolean r6, boolean r7) {
        if (r7 == false) goto L4;
        this.mConfigQueryRetryGeneration++;
        this.mConfigQueryRetryCount = 0;
    L4:
        int r8 = this.mConfigQueryRetryCount;
        if (r8 < 3) goto L8;
        addLog("CONFIG_QUERY_RETRY_EXHAUSTED recovery=" + r6);
        return;
    L8:
        int r9 = r8 + 1;
        this.mConfigQueryRetryCount = r9;
        final int r0 = this.mConfigQueryRetryGeneration;
        long r1 = 1000 << (r9 - 1);
        addLog("CONFIG_QUERY_RETRY_SCHEDULED attempt=" + r9 + " delayMs=" + r1 + " recovery=" + r6);
        this.mMainHandler.postDelayed(new $$Lambda$PoiAwareBridge$Kfz0Tgduw1vVUXrAlS3IE6qKjE(this, r0, r6), r1);
    }

    private void sendCommandLocked(int r7, int r8, int r9, boolean r10) {
        sendCommandLocked(r7, r8, r9, r10, false);
    }

    private void sendCommandLocked(int r11, int r12, int r13, boolean r14, boolean r15) {
        if (this.mClient != null) goto L5;
        return;
    L5:
        if (this.mConnected == false) goto L33;
        int r0 = this.mNextCommandId.getAndIncrement();
        if (r11 != 7) goto L11;
        int r2 = this.mSessionEpoch;
        int r3 = this.mStateVersion;
        int r4 = this.mState;
        Config r16 = this.mConfig;
        byte[] r17 = PoiAwareCodec.encodeResetCommand(r0, r2, r3, r4, r16.configVersion, r16.expectedConfigVersion);
    L10:
        byte[] r5 = r17;
        this.mClient.sendRequest(SENSOR_NAME, COMMAND_MESSAGE_ID, r5, r0, 4);
        if (r11 != 2) goto L19;
    L27:
        this.mPendingIdentityRequestId = r0;
        this.mPendingIdentityCommand = r11;
        this.mPendingSessionEpoch = this.mSessionEpoch;
        this.mPendingStateVersion = this.mStateVersion;
        this.mPendingState = this.mState;
        this.mPendingConfigVersion = this.mConfig.configVersion;
        return;
    L19:
        if (r11 == 3) goto L27;
        if (r11 == 7) goto L27;
        if (r11 != 6) goto L30;
        if (r15 == false) goto L26;
        this.mPendingRecoveryConfigQueryRequestId = r0;
        this.mPendingRecoveryConfigQueryGeneration = this.mConfigOperationGeneration;
        return;
    L26:
        this.mPendingConfigQueryRequestId = r0;
        this.mPendingConfigQueryGeneration = this.mConfigOperationGeneration;
        return;
    L30:
        return;
    L11:
        int r6 = this.mSessionEpoch;
        int r7 = this.mStateVersion;
        int r8 = this.mState;
        if (r14 == false) goto L14;
        Config r18 = this.mConfig;
    L15:
        r17 = PoiAwareCodec.encodeCommand(r0, r11, r6, r7, r8, r12, r13, r18);
        goto L10
    L14:
        r18 = null;
        goto L15
    }

    private void sendCompletionLocked(PoiAwareCodec.Event r10, int r11) {
        if (this.mClient != null) goto L5;
        return;
    L5:
        if (this.mConnected == false) goto L10;
        int r0 = this.mNextCommandId.getAndIncrement();
        Config r8 = this.mConfig.copy();
        r8.configVersion = (int) r10.value11;
        byte[] r4 = PoiAwareCodec.encodeCommand(r0, 4, (int) r10.value4, (int) r10.value5, (int) r10.value6, r10.requestId, r11, r8);
        this.mClient.sendRequest(SENSOR_NAME, COMMAND_MESSAGE_ID, r4, r0, 4);
        return;
    }

    private static String stationarySource(boolean r0, boolean r1) {
        if (r0 == false) goto L6;
        if (r1 == false) goto L6;
        return "HAR+STEP";
    L6:
        if (r0 == false) goto L9;
        return "HAR";
    L9:
        if (r1 == false) goto L11;
        return "STEP";
    L11:
        return "NONE";
    }

    private synchronized void subscribeLocked() {
        monitor-enter(this);
        SensorBridgeClient r0 = this.mClient;     // Catch: Throwable -> L11
        if (r0 != null) goto L8;
        monitor-exit(this);
        return;
    L8:
        r0.subscribe(SENSOR_NAME, new int[]{WAKEUP_EVENT_MESSAGE_ID, STATUS_EVENT_MESSAGE_ID, DEBUG_EVENT_MESSAGE_ID, CONFIG_EVENT_MESSAGE_ID}, 0, new int[]{STATUS_EVENT_MESSAGE_ID, DEBUG_EVENT_MESSAGE_ID, CONFIG_EVENT_MESSAGE_ID}, new byte[0]);     // Catch: Throwable -> L11
        this.mSubscribed = true;     // Catch: Throwable -> L11
        addLog("SUBSCRIBE");     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private static String triggerReasonName(int r1) {
        if (r1 != 1) goto L5;
        return "STATIONARY_DELAY";
    L5:
        if (r1 != 2) goto L7;
        return "STEP_ROLLING_60S_LOW_ONCE";
    L7:
        if (r1 == 3) goto L10;
        return "UNKNOWN";
    L10:
        return "TRANSPORT_DETECTED";
    }

    public synchronized void applyDefaultConfig(Config r2) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.mHasExplicitConfigIntent == false) goto L9;
        addLog("DEFAULT_CONFIG_SKIPPED explicit generation=" + this.mConfigOperationGeneration);     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L9:
        applyConfigLocked(r2, false);     // Catch: Throwable -> L12
        monitor-exit(this);
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

    public synchronized Bundle getDebugInfo() {
        monitor-enter(this);
        Bundle r0 = new Bundle();     // Catch: Throwable -> L6
        r0.putBoolean("bridgeConnected", this.mConnected);     // Catch: Throwable -> L6
        r0.putBoolean("bridgeSubscribed", this.mSubscribed);     // Catch: Throwable -> L6
        r0.putBoolean("adspReady", this.mReady);     // Catch: Throwable -> L6
        r0.putBoolean("resetPending", this.mPendingResetConfig);     // Catch: Throwable -> L6
        r0.putInt("bridgeClientId", this.mClientId);     // Catch: Throwable -> L6
        r0.putInt("sessionEpoch", this.mSessionEpoch);     // Catch: Throwable -> L6
        r0.putInt("stateVersion", this.mStateVersion);     // Catch: Throwable -> L6
        r0.putInt("lastAckStateVersion", this.mLastAckStateVersion);     // Catch: Throwable -> L6
        int r1 = this.mDebugSnapshot.getInt("state", -1);     // Catch: Throwable -> L6
        r0.putInt("adspState", resolveReportedAdspState(this.mHasActiveIdentity, this.mActiveState, r1));     // Catch: Throwable -> L6
        r0.putInt("adspSnapshotState", r1);     // Catch: Throwable -> L6
        r0.putBoolean("adspStateFromAck", this.mHasActiveIdentity);     // Catch: Throwable -> L6
        r0.putInt("adspHar", this.mDebugSnapshot.getInt("har", -1));     // Catch: Throwable -> L6
        r0.putInt("adspSteps", this.mDebugSnapshot.getInt("steps", -1));     // Catch: Throwable -> L6
        r0.putInt("adspStationaryBaseline", this.mDebugSnapshot.getInt("stationaryBaseline", -1));     // Catch: Throwable -> L6
        r0.putInt("adspWalkBaseline", this.mDebugSnapshot.getInt("walkBaseline", -1));     // Catch: Throwable -> L6
        r0.putInt("adspStepDelta", this.mDebugSnapshot.getInt("stepDelta", -1));     // Catch: Throwable -> L6
        r0.putBoolean("adspStationary", this.mDebugSnapshot.getBoolean("stationary", false));     // Catch: Throwable -> L6
        r0.putBoolean("adspWalkPending", this.mDebugSnapshot.getBoolean("walkPending", false));     // Catch: Throwable -> L6
        r0.putBoolean("adspRequestPending", this.mDebugSnapshot.getBoolean("requestPending", false));     // Catch: Throwable -> L6
        r0.putInt("adspPendingRequestId", this.mDebugSnapshot.getInt("pendingRequestId", 0));     // Catch: Throwable -> L6
        r0.putLong("adspSuppressUntilTicks", this.mDebugSnapshot.getLong("suppressUntilTicks", 0));     // Catch: Throwable -> L6
        r0.putLong("adspTimerDeadlineTicks", this.mDebugSnapshot.getLong("timerDeadlineTicks", 0));     // Catch: Throwable -> L6
        r0.putLong("adspTimestampTicks", this.mDebugSnapshot.getLong("timestampTicks", 0));     // Catch: Throwable -> L6
        r0.putLong("adspTimerRemainingTicks", this.mDebugSnapshot.getLong("timerRemainingTicks", 0));     // Catch: Throwable -> L6
        r0.putString("adspStationarySource", this.mDebugSnapshot.getString("stationarySource", "NONE"));     // Catch: Throwable -> L6
        r0.putBoolean("adspHarConfirmed", this.mDebugSnapshot.getBoolean("harConfirmed", false));     // Catch: Throwable -> L6
        r0.putBoolean("adspStepStationaryEvidence", this.mDebugSnapshot.getBoolean("stepStationaryEvidence", false));     // Catch: Throwable -> L6
        r0.putInt("adspStationaryWindowStepSum", this.mDebugSnapshot.getInt("stationaryWindowStepSum", -1));     // Catch: Throwable -> L6
        r0.putInt("adspStationaryWindowBucketCount", this.mDebugSnapshot.getInt("stationaryWindowBucketCount", -1));     // Catch: Throwable -> L6
        r0.putInt("adspLowCheckStreak", this.mDebugSnapshot.getInt("lowCheckStreak", -1));     // Catch: Throwable -> L6
        r0.putInt("adspStep20s", this.mDebugSnapshot.getInt("step20s", -1));     // Catch: Throwable -> L6
        r0.putInt("adspStep60s", this.mDebugSnapshot.getInt("step60s", -1));     // Catch: Throwable -> L6
        r0.putString("adspTimerPhase", this.mDebugSnapshot.getString("timerPhase", "UNKNOWN"));     // Catch: Throwable -> L6
        r0.putInt("lastRequestId", this.mLastRequestId);     // Catch: Throwable -> L6
        r0.putInt("lastTriggerReason", this.mLastTriggerReason);     // Catch: Throwable -> L6
        r0.putInt("lastCompletedRequestId", this.mLastCompletedRequestId);     // Catch: Throwable -> L6
        r0.putInt("bridgeLastError", this.mLastError);     // Catch: Throwable -> L6
        r0.putLong("lastBridgeEventElapsedMs", this.mLastEventElapsedMs);     // Catch: Throwable -> L6
        r0.putStringArrayList("poiAdspLogs", new ArrayList(this.mLogs));     // Catch: Throwable -> L6
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

    public synchronized int getSessionEpoch() {
        monitor-enter(this);
        int r0 = this.mSessionEpoch;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int getStateVersion() {
        monitor-enter(this);
        int r0 = this.mStateVersion;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public void handleEvent(int r22, byte[] r23) {
        PoiAwareCodec.Event r5 = PoiAwareCodec.decodeEvent(r23);     // Catch: RuntimeException -> L81
        if (r5 != null) goto L7;
        return;
    L7:
        if (r22 != STATUS_EVENT_MESSAGE_ID) goto L10;
        handleStatus(r5);     // Catch: RuntimeException -> L81
        return;
    L10:
        if (r22 != WAKEUP_EVENT_MESSAGE_ID) goto L13;
        handleWakeup(r5);     // Catch: RuntimeException -> L81
        return;
    L13:
        if (r22 != DEBUG_EVENT_MESSAGE_ID) goto L16;
        handleDebug(r5);     // Catch: RuntimeException -> L81
        return;
    L16:
        if (r22 != CONFIG_EVENT_MESSAGE_ID) goto L90;
        monitor-enter(this);     // Catch: RuntimeException -> L81
        int r6 = r5.requestId;     // Catch: Throwable -> L78
        int r7 = r5.intValue(4, 0);     // Catch: Throwable -> L78
        if (r6 != 0) goto L21;
    L23:
        boolean r10 = false;
    L24:
        if (r6 != 0) goto L26;
    L28:
        boolean r11 = false;
    L29:
        if (r10 == true) goto L34;
        if (r11 == true) goto L34;
        addLog("CONFIG_IGNORED request=" + r6 + " expected=" + this.mPendingConfigQueryRequestId + "/" + this.mPendingRecoveryConfigQueryRequestId);     // Catch: Throwable -> L78
        monitor-exit(this);     // Catch: Throwable -> L78
        return;
    L34:
        if (r10 == false) goto L36;
        this.mPendingRecoveryConfigQueryRequestId = 0;     // Catch: Throwable -> L78
    L37:
        if (r10 == false) goto L39;
        int r4 = this.mPendingRecoveryConfigQueryGeneration;     // Catch: Throwable -> L78
    L41:
        if (r4 == this.mConfigOperationGeneration) goto L45;
        addLog("CONFIG_STALE_GENERATION request=" + r6 + " response=" + r4 + " current=" + this.mConfigOperationGeneration);     // Catch: Throwable -> L78
        monitor-exit(this);     // Catch: Throwable -> L78
        return;
    L45:
        cancelConfigQueryRetryLocked();     // Catch: Throwable -> L78
        int r3 = this.mPendingIdentityCommand;     // Catch: Throwable -> L78
        if (r3 != 3) goto L48;
    L51:
        boolean r8 = true;
    L52:
        if (r10 == false) goto L54;
    L61:
        Bundle r0 = new Bundle();     // Catch: Throwable -> L78
        String[] r9 = {"stepBucketIntervalMs", "bucketCount", "entryStepThreshold", "requiredLowChecks", "harHoldSeconds", "harGuardStepThreshold", "eventAckTimeoutSeconds", "retryBackoffInitialSeconds", "retryBackoffMaxSeconds", "effectiveStepWindowSeconds"};     // Catch: Throwable -> L78
        int r12 = 0;
    L62:
        if (r12 >= 10) goto L64;
        r0.putInt(r9[r12], r5.intValue(r12 + 8, 0));     // Catch: Throwable -> L78
        r12 = r12 + 1;     // Catch: Throwable -> L78
        goto L62
    L64:
        r0.putInt("protocolVersion", r5.intValue(2, 0));     // Catch: Throwable -> L78
        r0.putInt("algorithmVersion", r5.intValue(3, 0));     // Catch: Throwable -> L78
        r0.putInt("configVersion", r7);     // Catch: Throwable -> L78
        r0.putInt("configSource", r5.intValue(5, 0));     // Catch: Throwable -> L78
        this.mEffectiveConfig = r0;     // Catch: Throwable -> L78
        int r13 = r0.getInt("configVersion");     // Catch: Throwable -> L78
        this.mConfigVersion = r13;     // Catch: Throwable -> L78
        Config r14 = this.mConfig;     // Catch: Throwable -> L78
        r14.configVersion = r13;     // Catch: Throwable -> L78
        r14.expectedConfigVersion = -1;     // Catch: Throwable -> L78
        if (r10 == false) goto L67;
        this.mConfigMutationRecoveryPending = false;     // Catch: Throwable -> L78
    L67:
        r14.stationaryCheckIntervalMs = r0.getInt("stepBucketIntervalMs");     // Catch: Throwable -> L78
        this.mConfig.stepWindowBucketCount = r0.getInt("bucketCount");     // Catch: Throwable -> L78
        this.mConfig.entryStepThreshold = r0.getInt("entryStepThreshold");     // Catch: Throwable -> L78
        this.mConfig.requiredLowChecks = r0.getInt("requiredLowChecks");     // Catch: Throwable -> L78
        this.mConfig.harHoldSeconds = r0.getInt("harHoldSeconds");     // Catch: Throwable -> L78
        this.mConfig.harGuardStepThreshold = r0.getInt("harGuardStepThreshold");     // Catch: Throwable -> L78
        this.mConfig.eventAckTimeoutSeconds = r0.getInt("eventAckTimeoutSeconds");     // Catch: Throwable -> L78
        this.mConfig.retryBackoffInitialSeconds = r0.getInt("retryBackoffInitialSeconds");     // Catch: Throwable -> L78
        this.mConfig.retryBackoffMaxSeconds = r0.getInt("retryBackoffMaxSeconds");     // Catch: Throwable -> L78
        this.mConfig.stepWindowSeconds = r0.getInt("effectiveStepWindowSeconds");     // Catch: Throwable -> L78
        if (r10 == true) goto L70;
    L72:
        if (r10 == true) goto L74;
        this.mResetAwaitingConfig = false;     // Catch: Throwable -> L78
    L74:
        addLog("CONFIG_RX v=" + r0.getInt("configVersion"));     // Catch: Throwable -> L78
        dispatchPendingUpdateLocked();     // Catch: Throwable -> L78
        dispatchPendingResetLocked();     // Catch: Throwable -> L78
        monitor-exit(this);     // Catch: Throwable -> L78
        notifyChanged();     // Catch: RuntimeException -> L81
        return;
    L70:
        if (this.mResetAwaitingConfig == false) goto L72;
        this.mPendingResetConfig = true;     // Catch: Throwable -> L78
        goto L74
    L54:
        if (r7 < this.mConfigVersion) goto L58;
        if (r8 == false) goto L61;
        if (r7 >= this.mPendingConfigVersion) goto L61;
    L58:
        addLog("CONFIG_STALE v=" + r7 + " local=" + this.mConfigVersion);     // Catch: Throwable -> L78
        monitor-exit(this);     // Catch: Throwable -> L78
        return;
    L48:
        if (r3 == 7) goto L51;
        r8 = false;
        goto L52
    L39:
        r4 = this.mPendingConfigQueryGeneration;     // Catch: Throwable -> L78
        goto L41
    L36:
        this.mPendingConfigQueryRequestId = 0;     // Catch: Throwable -> L78
        goto L37
    L26:
        if (r6 != this.mPendingConfigQueryRequestId) goto L28;
        r11 = true;
        goto L29
    L21:
        if (r6 != this.mPendingRecoveryConfigQueryRequestId) goto L23;
        r10 = true;
    L78:
        th = move-exception;
        throw th;     // Catch: RuntimeException -> L81
    L90:
        return;
    L81:
        e = move-exception;
        a.a(TAG, "decode event failed messageId=" + r22, e);
    }

    public synchronized boolean isReady() {
        monitor-enter(this);
        boolean r0 = this.mReady;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean isStateSynchronized() {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        if (this.mReady == true) goto L6;
    L16:
        boolean r0 = false;
    L17:
        monitor-exit(this);
        return r0;
    L6:
        if (this.mHasActiveIdentity == false) goto L16;
        if (this.mActiveSessionEpoch != this.mSessionEpoch) goto L16;
        if (this.mActiveStateVersion != this.mStateVersion) goto L16;
        if (this.mActiveState != this.mState) goto L16;
        if (this.mActiveConfigVersion != this.mConfig.configVersion) goto L16;
        r0 = true;
        goto L17
    }

    public /* synthetic */ void lambda$handleStatus$0$PoiAwareBridge(int r1) {
        this.mListener.onStateSynchronized(r1);
    }

    public /* synthetic */ void lambda$handleWakeup$1$PoiAwareBridge(Bundle r1) {
        this.mListener.onTransportDetected(r1);
    }

    public /* synthetic */ void lambda$handleWakeup$2$PoiAwareBridge(PoiAwareCodec.Event r2, Bundle r3) {
        this.mListener.onPoiRequest(r2.requestId, r2.typeOrReason, r3);
    }

    public /* synthetic */ void lambda$scheduleConfigQueryRetryLocked$3$PoiAwareBridge(int r7, boolean r8) {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L4:
        if (r7 == this.mConfigQueryRetryGeneration) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L18
        return;
    L8:
        if (this.mConnected == true) goto L10;
    L15:
        addLog("CONFIG_QUERY_RETRY_CANCELLED not ready");     // Catch: Throwable -> L18
        cancelConfigQueryRetryLocked();     // Catch: Throwable -> L18
        notifyChanged();     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
        return;
    L10:
        if (this.mReady == false) goto L15;
        sendCommandLocked(6, 0, 0, false, r8);     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
    }

    public synchronized void requestConfigSnapshot() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mReady == false) goto L6;
        cancelConfigQueryRetryLocked();     // Catch: Throwable -> L8
        sendCommandLocked(6, 0, 0, false);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    public synchronized void requestDebugSnapshot() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mReady == false) goto L6;
        sendCommandLocked(5, 0, 0, false);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    public synchronized void resetConfig() {
        monitor-enter(this);
        boolean r0 = this.mConfigMutationRecoveryPending;     // Catch: Throwable -> L10
        this.mConfigOperationGeneration++;     // Catch: Throwable -> L10
        if (r0 == false) goto L6;
        this.mPendingRecoveryConfigQueryRequestId = 0;     // Catch: Throwable -> L10
        scheduleConfigQueryRetryLocked(true, true);     // Catch: Throwable -> L10
    L7:
        this.mHasExplicitConfigIntent = true;     // Catch: Throwable -> L10
        this.mResetAwaitingConfig = true;     // Catch: Throwable -> L10
        this.mPendingUpdateConfig = null;     // Catch: Throwable -> L10
        this.mPendingResetConfig = true;     // Catch: Throwable -> L10
        addLog("RESET_REQUESTED connected=" + this.mConnected + " ready=" + this.mReady);     // Catch: Throwable -> L10
        dispatchPendingResetLocked();     // Catch: Throwable -> L10
        notifyChanged();     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L6:
        cancelConfigQueryRetryLocked();     // Catch: Throwable -> L10
    L10:
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

    public synchronized void stop() {
        monitor-enter(this);
        SensorBridgeClient r0 = this.mClient;     // Catch: Throwable -> L9
        if (r0 == null) goto L6;
        r0.stop();     // Catch: Throwable -> L9
        this.mClient = null;     // Catch: Throwable -> L9
    L6:
        this.mConnected = false;     // Catch: Throwable -> L9
        this.mSubscribed = false;     // Catch: Throwable -> L9
        this.mReady = false;     // Catch: Throwable -> L9
        clearProtocolIdentityLocked();     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public synchronized void syncState(int r4, int r5) {
        monitor-enter(this);
        this.mState = r4;     // Catch: Throwable -> L18
        if (r5 != 0) goto L6;
        this.mStateVersion++;     // Catch: Throwable -> L18
    L6:
        this.mLastCompletedRequestId = r5;     // Catch: Throwable -> L18
        if (this.mReady == false) goto L15;
        if (r5 != 0) goto L10;
        int r1 = 2;
    L11:
        if (r5 != 0) goto L13;
        int r2 = 0;
    L14:
        sendCommandLocked(r1, r5, r2, true);     // Catch: Throwable -> L18
        goto L15
    L13:
        r2 = 1;
        goto L14
    L10:
        r1 = 4;
    L15:
        addLog(d.a("STATE_TX state=", r4, " v=").append(this.mStateVersion).append(" completed=").append(r5).toString());     // Catch: Throwable -> L18
        notifyChanged();     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public synchronized void updateConfig(Bundle r3) {
        monitor-enter(this);
        Config r0 = desiredConfigLocked().copy();     // Catch: Throwable -> L33
        if (r3.containsKey("stepBucketIntervalMs") == false) goto L7;
        r0.stationaryCheckIntervalMs = r3.getInt("stepBucketIntervalMs");     // Catch: Throwable -> L33
    L7:
        if (r3.containsKey("bucketCount") == false) goto L10;
        r0.stepWindowBucketCount = r3.getInt("bucketCount");     // Catch: Throwable -> L33
    L10:
        if (r3.containsKey("entryStepThreshold") == false) goto L13;
        r0.entryStepThreshold = r3.getInt("entryStepThreshold");     // Catch: Throwable -> L33
    L13:
        if (r3.containsKey("requiredLowChecks") == false) goto L16;
        r0.requiredLowChecks = r3.getInt("requiredLowChecks");     // Catch: Throwable -> L33
    L16:
        if (r3.containsKey("harHoldSeconds") == false) goto L19;
        r0.harHoldSeconds = r3.getInt("harHoldSeconds");     // Catch: Throwable -> L33
    L19:
        if (r3.containsKey("harGuardStepThreshold") == false) goto L22;
        r0.harGuardStepThreshold = r3.getInt("harGuardStepThreshold");     // Catch: Throwable -> L33
    L22:
        if (r3.containsKey("eventAckTimeoutSeconds") == false) goto L25;
        r0.eventAckTimeoutSeconds = r3.getInt("eventAckTimeoutSeconds");     // Catch: Throwable -> L33
    L25:
        if (r3.containsKey("retryBackoffInitialSeconds") == false) goto L28;
        r0.retryBackoffInitialSeconds = r3.getInt("retryBackoffInitialSeconds");     // Catch: Throwable -> L33
    L28:
        if (r3.containsKey("retryBackoffMaxSeconds") == false) goto L30;
        r0.retryBackoffMaxSeconds = r3.getInt("retryBackoffMaxSeconds");     // Catch: Throwable -> L33
    L30:
        int r4 = r0.stepWindowBucketCount;     // Catch: Throwable -> L33
        r0.stepWindowSeconds = (r0.stationaryCheckIntervalMs / 1000) * r4;     // Catch: Throwable -> L33
        updateConfig(r0);     // Catch: Throwable -> L33
        monitor-exit(this);
        return;
    L33:
        th = move-exception;
        throw th;
    }

    public synchronized void updateConfig(Config r2) {
        monitor-enter(this);
        applyConfigLocked(r2, true);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
