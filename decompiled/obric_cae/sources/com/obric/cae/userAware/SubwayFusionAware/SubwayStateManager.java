package com.obric.cae.userAware.SubwayFusionAware;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import androidx.appcompat.app.r;
import com.obric.cae.cloud.applog.ByteIOUtils;
import com.obric.cae.libs.useraware.ICaeUserAwareCallback;
import com.obric.cae.log.CommSenseLog;
import com.obric.cae.userAware.InnerAwareInfoCallback;
import com.obric.cae.userAware.UserAwareManager;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class SubwayStateManager {
    private static final String EVENT_NAME_SUBWAY_POWER_CONSUMPTION = "subway_power_consumption";
    private static final String TAG = "SubwayStateManager";
    private final Context mAndroidContext;
    private SubwayState mCurrentState;
    private final DetectCycleStats mDetectCycleStats;
    private final StateTransitionListener mListener;
    private final SubwayContext mSubwayContext;
    private final File mSubwayLogFile;
    private Handler mWorkerHandler;

    /* JADX INFO: renamed from: com.obric.cae.userAware.SubwayFusionAware.SubwayStateManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$obric$cae$userAware$SubwayFusionAware$SubwayState = null;

        static {
            int[] r8 = new int[SubwayState.values().length];
            $SwitchMap$com$obric$cae$userAware$SubwayFusionAware$SubwayState = r8;
            r8[SubwayState.STATE_ENTER_PRE_FILTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$obric$cae$userAware$SubwayFusionAware$SubwayState[SubwayState.STATE_ENTER_CONFIDENCE_SCORING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$obric$cae$userAware$SubwayFusionAware$SubwayState[SubwayState.STATE_ON_SUBWAY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$com$obric$cae$userAware$SubwayFusionAware$SubwayState[SubwayState.STATE_EXIT_CONFIDENCE_SCORING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$com$obric$cae$userAware$SubwayFusionAware$SubwayState[SubwayState.STATE_IDLE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static final class DetectCycleStats {
        boolean activeCycle;
        long currentStateEnterTs;
        int indoorOutdoorTriggerCnt;
        long stateEnterConfidenceScoringDurationMs;
        long stateEnterPreFilterDurationMs;
        long stateExitConfidenceScoringDurationMs;
        long stateNonIdleDurationMs;
        long stateOnSubwayDurationMs;
        long wakeLockExpectedReleaseTs;
        long wakeLockHoldStartTs;
        long wakeLockTotalMs;

        private DetectCycleStats() {
        }

        public /* synthetic */ DetectCycleStats(AnonymousClass1 r8) {
            this();
        }

        public void reset() {
            this.stateNonIdleDurationMs = 0;
            this.stateEnterPreFilterDurationMs = 0;
            this.stateEnterConfidenceScoringDurationMs = 0;
            this.stateOnSubwayDurationMs = 0;
            this.stateExitConfidenceScoringDurationMs = 0;
            this.wakeLockTotalMs = 0;
            this.indoorOutdoorTriggerCnt = 0;
            this.activeCycle = false;
            this.currentStateEnterTs = 0;
            this.wakeLockHoldStartTs = 0;
            this.wakeLockExpectedReleaseTs = 0;
        }
    }

    public interface StateTransitionListener {
        void onStateEnter(SubwayState r8);

        void onStateExit(SubwayState r8);

        void onSubwayEvent(boolean r8);
    }

    public SubwayStateManager(Context r8, SubwayContext r10, StateTransitionListener r11, File r12) {
        this.mCurrentState = SubwayState.STATE_IDLE;
        this.mDetectCycleStats = new DetectCycleStats(null);
        this.mAndroidContext = r8;
        this.mSubwayContext = r10;
        this.mListener = r11;
        this.mSubwayLogFile = r12;
    }

    public static /* synthetic */ void a(int r8, String r10, InnerAwareInfoCallback r11, Object r12) {
        lambda$notifyInSubWay$2(r8, r10, r11, r12);
    }

    public static /* synthetic */ void b(SubwayStateManager r8, String r10) {
        r8.lambda$showToast$0(r10);
    }

    public static /* synthetic */ void c(int r8, String r10, ICaeUserAwareCallback r11, Object r12) {
        lambda$notifyInSubWay$1(r8, r10, r11, r12);
    }

    private void enterNewState() {
        StateTransitionListener r8 = this.mListener;
        if (r8 == null) goto L5;
        r8.onStateEnter(this.mCurrentState);
    L5:
        int r10 = AnonymousClass1.$SwitchMap$com$obric$cae$userAware$SubwayFusionAware$SubwayState[this.mCurrentState.ordinal()];
        boolean r11 = true;
        if (r10 != 1) goto L8;
        Handler r12 = this.mWorkerHandler;
        if (r12 == null) goto L55;
        r12.sendEmptyMessageDelayed(100, 20000);
        return;
    L55:
        return;
    L8:
        if (r10 != 2) goto L10;
        Handler r13 = this.mWorkerHandler;
        if (r13 == null) goto L36;
        r13.sendEmptyMessageDelayed(101, 240000);
        this.mWorkerHandler.sendEmptyMessageDelayed(103, 2500);
    L36:
        SubwayContext r14 = this.mSubwayContext;
        r14.latestPressure = -1.0f;
        r14.inElevatorPressure = -1.0f;
        int r15 = r14.curHarStatus;
        if (r15 == 2) goto L41;
        if (r15 == 1) goto L41;
        r11 = false;
    L41:
        if (r11 == false) goto L43;
        r14.lastWalkingStartTime = System.currentTimeMillis();
    L43:
        SubwayContext r16 = this.mSubwayContext;
        int r17 = r16.latestStepCount;
        if (r17 <= 0) goto L46;
        r16.lastTriggeredStepCount = r17;
    L46:
        r16.checkAndApplySharedBikeScore(this.mSubwayLogFile);
        return;
    L10:
        if (r10 != 3) goto L12;
        SubwayContext r18 = this.mSubwayContext;
        r18.latestPressure = -1.0f;
        r18.inElevatorPressure = -1.0f;
        return;
    L12:
        if (r10 != 4) goto L14;
        Handler r19 = this.mWorkerHandler;
        if (r19 == null) goto L20;
        r19.sendEmptyMessageDelayed(102, 240000);
        this.mWorkerHandler.sendEmptyMessageDelayed(104, 2500);
    L20:
        SubwayContext r20 = this.mSubwayContext;
        int r21 = r20.latestStepCount;
        if (r21 <= 0) goto L23;
        r20.exitScoringStartStepCount = r21;
        r20.exitLastTriggeredStepCount = r21;
    L23:
        int r22 = r20.curHarStatus;
        if (r22 == 2) goto L28;
        if (r22 == 1) goto L28;
        r11 = false;
    L28:
        r20.consecutiveExitOutdoorCount = 0;
        long r23 = 0;
        r20.lastExitIndoorOutdoorCheckTime = 0;
        r20.exitAccumulatedWalkingOrRunningDurationMs = 0;
        if (r11 == false) goto L31;
        r23 = System.currentTimeMillis();
    L31:
        r20.exitWalkingOrRunningStartTime = r23;
        this.mSubwayContext.exitHasPendingCheckRequest = false;
        return;
    L14:
        if (r10 != 5) goto L56;
        this.mSubwayContext.recentBikeScanCounts.clear();
        return;
    }

    private void exitCurrentState() {
        StateTransitionListener r8 = this.mListener;
        if (r8 == null) goto L5;
        r8.onStateExit(this.mCurrentState);
    L5:
        int r10 = AnonymousClass1.$SwitchMap$com$obric$cae$userAware$SubwayFusionAware$SubwayState[this.mCurrentState.ordinal()];
        if (r10 != 1) goto L8;
        Handler r11 = this.mWorkerHandler;
        if (r11 == null) goto L34;
        r11.removeMessages(100);
        return;
    L34:
        return;
    L8:
        if (r10 != 2) goto L10;
        Handler r12 = this.mWorkerHandler;
        if (r12 == null) goto L25;
        r12.removeMessages(101);
        this.mWorkerHandler.removeMessages(103);
    L25:
        SubwayContext r13 = this.mSubwayContext;
        r13.consecutiveIndoorCount = 0;
        r13.consecutiveOutdoorCount = 0;
        r13.confidenceScore = 0.0f;
        r13.enterTempScore = 0.0f;
        r13.accumulatedWalkingDurationMs = 0;
        r13.lastWalkingStartTime = 0;
        r13.lastIndoorCheckTime = 0;
        r13.lastIndoorCheckPressure = -1.0f;
        r13.lastTriggeredStepCount = -1;
        r13.exitLastTriggeredStepCount = -1;
        r13.continuousPressureStartTime = 0;
        r13.continuousPressureScoreAdded = 0.0f;
        r13.latestPressure = -1.0f;
        r13.inElevatorPressure = -1.0f;
        r13.baselinePressure = -1.0f;
        r13.baselinePressures.clear();
        SubwayContext r14 = this.mSubwayContext;
        r14.sharedBikeScoreAdded = 0.0f;
        r14.hasExtendedWakeLock = false;
        return;
    L10:
        if (r10 != 3) goto L12;
        SubwayContext r15 = this.mSubwayContext;
        r15.latestPressure = -1.0f;
        r15.inElevatorPressure = -1.0f;
        return;
    L12:
        if (r10 != 4) goto L14;
        Handler r16 = this.mWorkerHandler;
        if (r16 == null) goto L20;
        r16.removeMessages(102);
        this.mWorkerHandler.removeMessages(104);
    L20:
        SubwayContext r17 = this.mSubwayContext;
        r17.confidenceScore = 0.0f;
        r17.consecutiveExitOutdoorCount = 0;
        r17.lastExitIndoorOutdoorCheckTime = 0;
        r17.exitAccumulatedWalkingOrRunningDurationMs = 0;
        r17.exitWalkingOrRunningStartTime = 0;
        r17.exitHasPendingCheckRequest = false;
        r17.inElevatorPressure = -1.0f;
        r17.sharedBikeScoreAdded = 0.0f;
        r17.exitScoringStartStepCount = -1;
        r17.exitLastTriggeredStepCount = -1;
        return;
    L14:
        if (r10 != 5) goto L35;
        this.mSubwayContext.isInSubwayGeofence = false;
        return;
    }

    private void finalizeWakeLockDuration(long r8) {
        DetectCycleStats r10 = this.mDetectCycleStats;
        if (r10.activeCycle == true) goto L5;
        return;
    L5:
        if (r10.wakeLockHoldStartTs <= 0) goto L16;
        long r11 = r10.wakeLockExpectedReleaseTs;
        if (r11 <= 0) goto L10;
        r8 = Math.min(r8, r11);
    L10:
        DetectCycleStats r12 = this.mDetectCycleStats;
        long r13 = r12.wakeLockHoldStartTs;
        if (r8 <= r13) goto L13;
        long r14 = r8 - r13;
        r12.wakeLockTotalMs = r14 + r12.wakeLockTotalMs;
    L13:
        r12.wakeLockHoldStartTs = 0;
        r12.wakeLockExpectedReleaseTs = 0;
        return;
    }

    private void handleStatsAfterTransition(SubwayState r8, SubwayState r10) {
        SubwayState r11 = SubwayState.STATE_IDLE;
        if (r8 == r11) goto L7;
        if (r10 != r11) goto L8;
        finalizeWakeLockDuration(System.currentTimeMillis());
        reportCycleStats();
        this.mDetectCycleStats.reset();
        return;
    L8:
        return;
    }

    private void handleStatsBeforeTransition(SubwayState r8, SubwayState r10, long r11) {
        SubwayState r12 = SubwayState.STATE_IDLE;
        if (r8 != r12) goto L7;
        if (r10 == r12) goto L7;
        this.mDetectCycleStats.reset();
        DetectCycleStats r13 = this.mDetectCycleStats;
        r13.activeCycle = true;
        r13.currentStateEnterTs = r11;
        return;
    L7:
        if (r8 == r12) goto L14;
        settleStateDuration(r8, r11);
        if (r10 == r12) goto L15;
        DetectCycleStats r14 = this.mDetectCycleStats;
        if (r14.activeCycle == false) goto L16;
        r14.currentStateEnterTs = r11;
        return;
    L16:
        return;
    L15:
        return;
    }

    private static /* synthetic */ void lambda$notifyInSubWay$1(int r8, String r10, ICaeUserAwareCallback r11, Object r12) {
        r11.onInSubWayChange(r8, r10);
    }

    private static /* synthetic */ void lambda$notifyInSubWay$2(int r8, String r10, InnerAwareInfoCallback r11, Object r12) {
        r11.onInSubWayChange(r8, r10);
    }

    private /* synthetic */ void lambda$showToast$0(String r8) {
        Toast.makeText(this.mAndroidContext, r8, 0).show();
    }

    private void notifyInSubWay(final int r15) {
        final String r8 = this.mSubwayContext.lastSubwayStationName;
        if (r8 != null) goto L6;
        r8 = "NULL";
    L6:
        CommSenseLog.d(TAG, "notifyInSubWay stationName :" + r8 + " isInSubWay:" + r15);
        UserAwareManager r10 = UserAwareManager.getInstance();     // Catch: Exception -> L13
        boolean r11 = true;
        if (r15 == 1) goto L11;
        r11 = false;
    L11:
        SubwayContext r14 = this.mSubwayContext;     // Catch: Exception -> L13
        r10.notifySubwayEvaluationEvent(r11, r14.confidenceScore, r8, r14.lastSubwayCellId36, r14.lastSubwayRat, r14.lastSubwayTac, r14.latestPressure, r14.latestLightLux, r14.curHarStatus, r14.isWifiConnected, r14.locationState);     // Catch: Exception -> L13
    L22:
        UserAwareManager.getInstance().notifyCallbacks(new c(r15, r8), new Object());     // Catch: Exception -> L17
        UserAwareManager.getInstance().notifyInnerCallbacks(new d(r15, r8), new Object());     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        CommSenseLog.e(TAG, "Error calling inSubWay callback", e);
        return;
    L13:
        e = move-exception;
        CommSenseLog.e(TAG, "Error calling subway evaluation event", e);
        goto L22
    }

    private void reportCycleStats() {
        DetectCycleStats r8 = this.mDetectCycleStats;
        if (r8.activeCycle == true) goto L5;
        return;
    L5:
        r8.stateNonIdleDurationMs = ((r8.stateEnterPreFilterDurationMs + r8.stateEnterConfidenceScoringDurationMs) + r8.stateOnSubwayDurationMs) + r8.stateExitConfidenceScoringDurationMs;
        JSONObject r10 = new JSONObject();     // Catch: Exception -> L8
        r10.put("state_non_idle_duration_ms", this.mDetectCycleStats.stateNonIdleDurationMs);     // Catch: Exception -> L8
        r10.put("state_enter_pre_filter_duration_ms", this.mDetectCycleStats.stateEnterPreFilterDurationMs);     // Catch: Exception -> L8
        r10.put("state_enter_confidence_scoring_duration_ms", this.mDetectCycleStats.stateEnterConfidenceScoringDurationMs);     // Catch: Exception -> L8
        r10.put("state_on_subway_duration_ms", this.mDetectCycleStats.stateOnSubwayDurationMs);     // Catch: Exception -> L8
        r10.put("state_exit_confidence_scoring_duration_ms", this.mDetectCycleStats.stateExitConfidenceScoringDurationMs);     // Catch: Exception -> L8
        r10.put("wakelock_total_ms", this.mDetectCycleStats.wakeLockTotalMs);     // Catch: Exception -> L8
        r10.put("indoor_outdoor_trigger_cnt", this.mDetectCycleStats.indoorOutdoorTriggerCnt);     // Catch: Exception -> L8
        ByteIOUtils.trackEvent(EVENT_NAME_SUBWAY_POWER_CONSUMPTION, r10);     // Catch: Exception -> L8
        CommSenseLog.dumpI(TAG, "[TRACK_EVENT] subway_power_consumption: " + r10, this.mSubwayLogFile);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        CommSenseLog.e(TAG, "Failed to report subway detect power stats", e);
    }

    private void settleStateDuration(SubwayState r8, long r10) {
        DetectCycleStats r11 = this.mDetectCycleStats;
        if (r11.activeCycle == false) goto L21;
        long r12 = r11.currentStateEnterTs;
        if (r12 <= 0) goto L25;
        long r13 = Math.max(0, r10 - r12);
        int r14 = AnonymousClass1.$SwitchMap$com$obric$cae$userAware$SubwayFusionAware$SubwayState[r8.ordinal()];
        if (r14 != 1) goto L10;
        this.mDetectCycleStats.stateEnterPreFilterDurationMs += r13;
        return;
    L10:
        if (r14 != 2) goto L12;
        this.mDetectCycleStats.stateEnterConfidenceScoringDurationMs += r13;
        return;
    L12:
        if (r14 != 3) goto L14;
        this.mDetectCycleStats.stateOnSubwayDurationMs += r13;
        return;
    L14:
        if (r14 != 4) goto L26;
        this.mDetectCycleStats.stateExitConfidenceScoringDurationMs += r13;
        return;
    L26:
        return;
    L25:
        return;
    }

    public SubwayState getCurrentState() {
        return this.mCurrentState;
    }

    public void onIndoorOutdoorCheckTriggered() {
        DetectCycleStats r8 = this.mDetectCycleStats;
        if (r8.activeCycle == false) goto L6;
        r8.indoorOutdoorTriggerCnt++;
        return;
    }

    public void onWakeLockAcquired(long r8) {
        if (this.mDetectCycleStats.activeCycle == true) goto L5;
        return;
    L5:
        if (r8 <= 0) goto L10;
        long r10 = System.currentTimeMillis();
        finalizeWakeLockDuration(r10);
        DetectCycleStats r11 = this.mDetectCycleStats;
        r11.wakeLockHoldStartTs = r10;
        r11.wakeLockExpectedReleaseTs = r10 + r8;
        return;
    }

    public void onWakeLockReleased() {
        finalizeWakeLockDuration(System.currentTimeMillis());
    }

    public void reportSubwayEvent(boolean r8) {
        StateTransitionListener r10 = this.mListener;
        if (r10 == null) goto L6;
        r10.onSubwayEvent(r8);
    L6:
        if (r8 == false) goto L8;
        String r11 = String.format("[FINAL_RESULT] %s: %s", new Object[]{"ENTER_SUBWAY", "Subway entry detected"});
        int r12 = 1;
    L9:
        notifyInSubWay(r12);
        CommSenseLog.dumpI(TAG, r11, this.mSubwayLogFile);
        showToast(r11);
        return;
    L8:
        r11 = String.format("[FINAL_RESULT] %s: %s", new Object[]{"EXIT_SUBWAY", "Subway exit detected"});
        r12 = 0;
        goto L9
    }

    public void resetCycleStats() {
        this.mDetectCycleStats.reset();
    }

    public void setWorkerHandler(Handler r8) {
        this.mWorkerHandler = r8;
    }

    public void showToast(String r8) {
        if (this.mAndroidContext != null) goto L5;
        return;
    L5:
        if (this.mSubwayContext.isTestMode == false) goto L9;
        new Handler(Looper.getMainLooper()).post(new r(19, this, r8));
        return;
    }

    public void transitionToState(SubwayState r8) {
        SubwayState r10 = this.mCurrentState;
        long r11 = System.currentTimeMillis();
        CommSenseLog.dumpI(TAG, String.format("[STATE_TRANSITION] %s -> %s", new Object[]{this.mCurrentState, r8}), this.mSubwayLogFile);
        showToast("State Transition: " + this.mCurrentState + " -> " + r8);
        handleStatsBeforeTransition(r10, r8, r11);
        exitCurrentState();
        this.mCurrentState = r8;
        enterNewState();
        handleStatsAfterTransition(r10, r8);
    }
}
