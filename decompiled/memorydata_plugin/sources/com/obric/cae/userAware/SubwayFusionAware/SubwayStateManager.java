package com.obric.cae.userAware.SubwayFusionAware;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.obric.cae.cloud.applog.b;
import com.obric.cae.libs.useraware.d;
import com.obric.cae.log.a;
import com.obric.cae.userAware.InnerAwareInfoCallback;
import com.obric.cae.userAware.UserAwareManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
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
            int[] r0 = new int[SubwayState.values().length];
            $SwitchMap$com$obric$cae$userAware$SubwayFusionAware$SubwayState = r0;
            r0[SubwayState.STATE_ENTER_PRE_FILTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
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

        public /* synthetic */ DetectCycleStats(AnonymousClass1 r1) {
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
        void onStateEnter(SubwayState r1);

        void onStateExit(SubwayState r1);

        void onSubwayEvent(boolean r1);
    }

    public SubwayStateManager(Context r4, SubwayContext r5, StateTransitionListener r6, File r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        StateTransitionListener r9 = (StateTransitionListener) ZeusTransformUtils.wrapperContextForParams(r6, StateTransitionListener.class, "com.obric.memorydata.plugin");
        this.mCurrentState = SubwayState.STATE_IDLE;
        this.mDetectCycleStats = new DetectCycleStats(null);
        this.mAndroidContext = ZeusTransformUtils.wrapperContext(r8, "com.obric.memorydata.plugin");
        this.mSubwayContext = r5;
        this.mListener = r9;
        this.mSubwayLogFile = r7;
    }

    private void enterNewState() {
        StateTransitionListener r0 = this.mListener;
        if (r0 == null) goto L5;
        r0.onStateEnter(this.mCurrentState);
    L5:
        int r1 = AnonymousClass1.$SwitchMap$com$obric$cae$userAware$SubwayFusionAware$SubwayState[this.mCurrentState.ordinal()];
        boolean r2 = true;
        if (r1 != 1) goto L8;
        Handler r10 = this.mWorkerHandler;
        if (r10 == null) goto L55;
        r10.sendEmptyMessageDelayed(100, 20000);
        return;
    L55:
        return;
    L8:
        if (r1 != 2) goto L10;
        Handler r3 = this.mWorkerHandler;
        if (r3 == null) goto L36;
        r3.sendEmptyMessageDelayed(101, 240000);
        this.mWorkerHandler.sendEmptyMessageDelayed(103, 2500);
    L36:
        SubwayContext r4 = this.mSubwayContext;
        r4.latestPressure = -1.0f;
        r4.inElevatorPressure = -1.0f;
        int r5 = r4.curHarStatus;
        if (r5 == 2) goto L41;
        if (r5 == 1) goto L41;
        r2 = false;
    L41:
        if (r2 == false) goto L43;
        r4.lastWalkingStartTime = System.currentTimeMillis();
    L43:
        SubwayContext r6 = this.mSubwayContext;
        int r7 = r6.latestStepCount;
        if (r7 <= 0) goto L46;
        r6.lastTriggeredStepCount = r7;
    L46:
        r6.checkAndApplySharedBikeScore(this.mSubwayLogFile);
        return;
    L10:
        if (r1 != 3) goto L12;
        SubwayContext r11 = this.mSubwayContext;
        r11.latestPressure = -1.0f;
        r11.inElevatorPressure = -1.0f;
        return;
    L12:
        if (r1 != 4) goto L14;
        Handler r8 = this.mWorkerHandler;
        if (r8 == null) goto L20;
        r8.sendEmptyMessageDelayed(102, 240000);
        this.mWorkerHandler.sendEmptyMessageDelayed(104, 2500);
    L20:
        SubwayContext r9 = this.mSubwayContext;
        int r12 = r9.latestStepCount;
        if (r12 <= 0) goto L23;
        r9.exitScoringStartStepCount = r12;
        r9.exitLastTriggeredStepCount = r12;
    L23:
        int r13 = r9.curHarStatus;
        if (r13 == 2) goto L28;
        if (r13 == 1) goto L28;
        r2 = false;
    L28:
        r9.consecutiveExitOutdoorCount = 0;
        long r14 = 0;
        r9.lastExitIndoorOutdoorCheckTime = 0;
        r9.exitAccumulatedWalkingOrRunningDurationMs = 0;
        if (r2 == false) goto L31;
        r14 = System.currentTimeMillis();
    L31:
        r9.exitWalkingOrRunningStartTime = r14;
        this.mSubwayContext.exitHasPendingCheckRequest = false;
        return;
    L14:
        if (r1 != 5) goto L56;
        this.mSubwayContext.recentBikeScanCounts.clear();
        return;
    }

    private void exitCurrentState() {
        StateTransitionListener r0 = this.mListener;
        if (r0 == null) goto L5;
        r0.onStateExit(this.mCurrentState);
    L5:
        int r1 = AnonymousClass1.$SwitchMap$com$obric$cae$userAware$SubwayFusionAware$SubwayState[this.mCurrentState.ordinal()];
        if (r1 != 1) goto L8;
        Handler r8 = this.mWorkerHandler;
        if (r8 == null) goto L34;
        r8.removeMessages(100);
        return;
    L34:
        return;
    L8:
        if (r1 != 2) goto L10;
        Handler r2 = this.mWorkerHandler;
        if (r2 == null) goto L25;
        r2.removeMessages(101);
        this.mWorkerHandler.removeMessages(103);
    L25:
        SubwayContext r3 = this.mSubwayContext;
        r3.consecutiveIndoorCount = 0;
        r3.consecutiveOutdoorCount = 0;
        r3.confidenceScore = 0.0f;
        r3.enterTempScore = 0.0f;
        r3.accumulatedWalkingDurationMs = 0;
        r3.lastWalkingStartTime = 0;
        r3.lastIndoorCheckTime = 0;
        r3.lastIndoorCheckPressure = -1.0f;
        r3.lastTriggeredStepCount = -1;
        r3.exitLastTriggeredStepCount = -1;
        r3.continuousPressureStartTime = 0;
        r3.continuousPressureScoreAdded = 0.0f;
        r3.latestPressure = -1.0f;
        r3.inElevatorPressure = -1.0f;
        r3.baselinePressure = -1.0f;
        r3.baselinePressures.clear();
        SubwayContext r9 = this.mSubwayContext;
        r9.sharedBikeScoreAdded = 0.0f;
        r9.hasExtendedWakeLock = false;
        return;
    L10:
        if (r1 != 3) goto L12;
        SubwayContext r10 = this.mSubwayContext;
        r10.latestPressure = -1.0f;
        r10.inElevatorPressure = -1.0f;
        return;
    L12:
        if (r1 != 4) goto L14;
        Handler r4 = this.mWorkerHandler;
        if (r4 == null) goto L20;
        r4.removeMessages(102);
        this.mWorkerHandler.removeMessages(104);
    L20:
        SubwayContext r11 = this.mSubwayContext;
        r11.confidenceScore = 0.0f;
        r11.consecutiveExitOutdoorCount = 0;
        r11.lastExitIndoorOutdoorCheckTime = 0;
        r11.exitAccumulatedWalkingOrRunningDurationMs = 0;
        r11.exitWalkingOrRunningStartTime = 0;
        r11.exitHasPendingCheckRequest = false;
        r11.inElevatorPressure = -1.0f;
        r11.sharedBikeScoreAdded = 0.0f;
        r11.exitScoringStartStepCount = -1;
        r11.exitLastTriggeredStepCount = -1;
        return;
    L14:
        if (r1 != 5) goto L35;
        this.mSubwayContext.isInSubwayGeofence = false;
        return;
    }

    private void finalizeWakeLockDuration(long r8) {
        DetectCycleStats r0 = this.mDetectCycleStats;
        if (r0.activeCycle == true) goto L5;
        return;
    L5:
        if (r0.wakeLockHoldStartTs <= 0) goto L16;
        long r1 = r0.wakeLockExpectedReleaseTs;
        if (r1 <= 0) goto L10;
        r8 = Math.min(r8, r1);
    L10:
        DetectCycleStats r7 = this.mDetectCycleStats;
        long r2 = r7.wakeLockHoldStartTs;
        if (r8 <= r2) goto L13;
        long r9 = r8 - r2;
        r7.wakeLockTotalMs = r9 + r7.wakeLockTotalMs;
    L13:
        r7.wakeLockHoldStartTs = 0;
        r7.wakeLockExpectedReleaseTs = 0;
        return;
    }

    private void handleStatsAfterTransition(SubwayState r2, SubwayState r3) {
        SubwayState r0 = SubwayState.STATE_IDLE;
        if (r2 == r0) goto L7;
        if (r3 != r0) goto L8;
        finalizeWakeLockDuration(System.currentTimeMillis());
        reportCycleStats();
        this.mDetectCycleStats.reset();
        return;
    L8:
        return;
    }

    private void handleStatsBeforeTransition(SubwayState r2, SubwayState r3, long r4) {
        SubwayState r0 = SubwayState.STATE_IDLE;
        if (r2 != r0) goto L7;
        if (r3 == r0) goto L7;
        this.mDetectCycleStats.reset();
        DetectCycleStats r1 = this.mDetectCycleStats;
        r1.activeCycle = true;
        r1.currentStateEnterTs = r4;
        return;
    L7:
        if (r2 == r0) goto L14;
        settleStateDuration(r2, r4);
        if (r3 == r0) goto L15;
        DetectCycleStats r5 = this.mDetectCycleStats;
        if (r5.activeCycle == false) goto L16;
        r5.currentStateEnterTs = r4;
        return;
    L16:
        return;
    L15:
        return;
    }

    static /* synthetic */ void lambda$notifyInSubWay$1(int r1, String r2, d r3, Object r4) {
        ((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin")).a(r1, r2);
    }

    static /* synthetic */ void lambda$notifyInSubWay$2(int r0, String r1, InnerAwareInfoCallback r2, Object r3) {
        r2.onInSubWayChange(r0, r1);
    }

    private void notifyInSubWay(final int r15) {
        final String r0 = this.mSubwayContext.lastSubwayStationName;
        if (r0 != null) goto L6;
        r0 = "NULL";
    L6:
        a.c(TAG, "notifyInSubWay stationName :" + r0 + " isInSubWay:" + r15);
        UserAwareManager r1 = UserAwareManager.getInstance();     // Catch: Exception -> L13
        boolean r2 = true;
        if (r15 == 1) goto L11;
        r2 = false;
    L11:
        SubwayContext r14 = this.mSubwayContext;     // Catch: Exception -> L13
        r1.notifySubwayEvaluationEvent(r2, r14.confidenceScore, r0, r14.lastSubwayCellId36, r14.lastSubwayRat, r14.lastSubwayTac, r14.latestPressure, r14.latestLightLux, r14.curHarStatus, r14.isWifiConnected, r14.locationState);     // Catch: Exception -> L13
    L22:
        UserAwareManager.getInstance().notifyCallbacks(new $$Lambda$SubwayStateManager$aBT4RT5LQzZ5WOUVbnbxxaC16Q(r15, r0), new Object());     // Catch: Exception -> L17
        UserAwareManager.getInstance().notifyInnerCallbacks(new $$Lambda$SubwayStateManager$AXbXPvLqcU0zDaIefSO8keJOgzU(r15, r0), new Object());     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        a.a(TAG, "Error calling inSubWay callback", e);
        return;
    L13:
        e = move-exception;
        a.a(TAG, "Error calling subway evaluation event", e);
        goto L22
    }

    private void reportCycleStats() {
        DetectCycleStats r1 = this.mDetectCycleStats;
        if (r1.activeCycle == true) goto L5;
        return;
    L5:
        r1.stateNonIdleDurationMs = ((r1.stateEnterPreFilterDurationMs + r1.stateEnterConfidenceScoringDurationMs) + r1.stateOnSubwayDurationMs) + r1.stateExitConfidenceScoringDurationMs;
        JSONObject r2 = new JSONObject();     // Catch: Exception -> L8
        r2.put("state_non_idle_duration_ms", this.mDetectCycleStats.stateNonIdleDurationMs);     // Catch: Exception -> L8
        r2.put("state_enter_pre_filter_duration_ms", this.mDetectCycleStats.stateEnterPreFilterDurationMs);     // Catch: Exception -> L8
        r2.put("state_enter_confidence_scoring_duration_ms", this.mDetectCycleStats.stateEnterConfidenceScoringDurationMs);     // Catch: Exception -> L8
        r2.put("state_on_subway_duration_ms", this.mDetectCycleStats.stateOnSubwayDurationMs);     // Catch: Exception -> L8
        r2.put("state_exit_confidence_scoring_duration_ms", this.mDetectCycleStats.stateExitConfidenceScoringDurationMs);     // Catch: Exception -> L8
        r2.put("wakelock_total_ms", this.mDetectCycleStats.wakeLockTotalMs);     // Catch: Exception -> L8
        r2.put("indoor_outdoor_trigger_cnt", this.mDetectCycleStats.indoorOutdoorTriggerCnt);     // Catch: Exception -> L8
        b.a(EVENT_NAME_SUBWAY_POWER_CONSUMPTION, r2);     // Catch: Exception -> L8
        a.c(TAG, "[TRACK_EVENT] subway_power_consumption: " + r2, this.mSubwayLogFile);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        a.a(TAG, "Failed to report subway detect power stats", e);
    }

    private void settleStateDuration(SubwayState r6, long r7) {
        DetectCycleStats r0 = this.mDetectCycleStats;
        if (r0.activeCycle == false) goto L21;
        long r1 = r0.currentStateEnterTs;
        if (r1 <= 0) goto L25;
        long r8 = Math.max(0, r7 - r1);
        int r9 = AnonymousClass1.$SwitchMap$com$obric$cae$userAware$SubwayFusionAware$SubwayState[r6.ordinal()];
        if (r9 != 1) goto L10;
        this.mDetectCycleStats.stateEnterPreFilterDurationMs += r8;
        return;
    L10:
        if (r9 != 2) goto L12;
        this.mDetectCycleStats.stateEnterConfidenceScoringDurationMs += r8;
        return;
    L12:
        if (r9 != 3) goto L14;
        this.mDetectCycleStats.stateOnSubwayDurationMs += r8;
        return;
    L14:
        if (r9 != 4) goto L26;
        this.mDetectCycleStats.stateExitConfidenceScoringDurationMs += r8;
        return;
    L26:
        return;
    L25:
        return;
    }

    public SubwayState getCurrentState() {
        return this.mCurrentState;
    }

    public /* synthetic */ void lambda$showToast$0$SubwayStateManager(String r2) {
        Toast.makeText(this.mAndroidContext, r2, 0).show();
    }

    public void onIndoorOutdoorCheckTriggered() {
        DetectCycleStats r1 = this.mDetectCycleStats;
        if (r1.activeCycle == false) goto L6;
        r1.indoorOutdoorTriggerCnt++;
        return;
    }

    public void onWakeLockAcquired(long r3) {
        if (this.mDetectCycleStats.activeCycle == true) goto L5;
        return;
    L5:
        if (r3 <= 0) goto L10;
        long r0 = System.currentTimeMillis();
        finalizeWakeLockDuration(r0);
        DetectCycleStats r2 = this.mDetectCycleStats;
        r2.wakeLockHoldStartTs = r0;
        r2.wakeLockExpectedReleaseTs = r0 + r3;
        return;
    }

    public void onWakeLockReleased() {
        finalizeWakeLockDuration(System.currentTimeMillis());
    }

    public void reportSubwayEvent(boolean r5) {
        StateTransitionListener r0 = this.mListener;
        if (r0 == null) goto L6;
        r0.onSubwayEvent(r5);
    L6:
        if (r5 == false) goto L8;
        String r6 = String.format("[FINAL_RESULT] %s: %s", new Object[]{"ENTER_SUBWAY", "Subway entry detected"});
        notifyInSubWay(1);
    L9:
        a.c(TAG, r6, this.mSubwayLogFile);
        showToast(r6);
        return;
    L8:
        r6 = String.format("[FINAL_RESULT] %s: %s", new Object[]{"EXIT_SUBWAY", "Subway exit detected"});
        notifyInSubWay(0);
        goto L9
    }

    public void resetCycleStats() {
        this.mDetectCycleStats.reset();
    }

    public void setWorkerHandler(Handler r1) {
        this.mWorkerHandler = r1;
    }

    public void showToast(final String r3) {
        if (this.mAndroidContext != null) goto L5;
        return;
    L5:
        if (this.mSubwayContext.isTestMode == false) goto L9;
        new Handler(Looper.getMainLooper()).post(new $$Lambda$SubwayStateManager$JdJkIiZj_rwYxaFnNGS6Ls2K4gA(this, r3));
        return;
    }

    public void transitionToState(SubwayState r7) {
        SubwayState r0 = this.mCurrentState;
        long r1 = System.currentTimeMillis();
        a.c(TAG, String.format("[STATE_TRANSITION] %s -> %s", new Object[]{this.mCurrentState, r7}), this.mSubwayLogFile);
        showToast("State Transition: " + this.mCurrentState + " -> " + r7);
        handleStatsBeforeTransition(r0, r7, r1);
        exitCurrentState();
        this.mCurrentState = r7;
        enterNewState();
        handleStatsAfterTransition(r0, r7);
    }
}
