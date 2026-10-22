package com.obric.cae.userAware.SubwayFusionAware;

import android.content.Context;
import android.hardware.SensorEvent;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import androidx.appcompat.app.r;
import com.obric.cae.log.CommSenseLog;
import com.obric.cae.userAware.InnerAwareInfoCallback;
import com.obric.cae.userAware.utils.CellPoiUtils;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class SubwayEventProcessor {
    private static final String TAG = "SubwayEventProcessor";
    private final Context mAndroidContext;
    private final EventProcessorListener mListener;
    private final SubwayStateManager mStateManager;
    private final SubwayContext mSubwayContext;
    private final File mSubwayLogFile;

    /* JADX INFO: renamed from: com.obric.cae.userAware.SubwayFusionAware.SubwayEventProcessor$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$obric$cae$userAware$SubwayFusionAware$SubwayState = null;

        static {
            int[] r8 = new int[SubwayState.values().length];
            $SwitchMap$com$obric$cae$userAware$SubwayFusionAware$SubwayState = r8;
            r8[SubwayState.STATE_IDLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$obric$cae$userAware$SubwayFusionAware$SubwayState[SubwayState.STATE_ON_SUBWAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$obric$cae$userAware$SubwayFusionAware$SubwayState[SubwayState.STATE_ENTER_PRE_FILTER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$com$obric$cae$userAware$SubwayFusionAware$SubwayState[SubwayState.STATE_ENTER_CONFIDENCE_SCORING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$com$obric$cae$userAware$SubwayFusionAware$SubwayState[SubwayState.STATE_EXIT_CONFIDENCE_SCORING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public interface EventProcessorListener {
        void onIndoorCheckNeeded();
    }

    public SubwayEventProcessor(Context r8, SubwayContext r10, SubwayStateManager r11, EventProcessorListener r12, File r13) {
        this.mAndroidContext = r8;
        this.mSubwayContext = r10;
        this.mStateManager = r11;
        this.mListener = r12;
        this.mSubwayLogFile = r13;
    }

    public static /* synthetic */ void a(SubwayEventProcessor r8, String r10) {
        r8.lambda$showToast$0(r10);
    }

    private boolean canTriggerIndoorOutdoorCheck(long r8, long r10, long r11) {
        if ((r8 - r10) < r11) goto L5;
        return true;
    L5:
        return false;
    }

    private void checkConfidenceScore() {
        if (this.mStateManager.getCurrentState() != SubwayState.STATE_ENTER_CONFIDENCE_SCORING) goto L16;
        SubwayContext r8 = this.mSubwayContext;
        if (r8.consecutiveIndoorCount < 2) goto L7;
        boolean r10 = true;
    L9:
        if (SubwayUtils.isConfirmed(r8.confidenceScore) == false) goto L17;
        if (r10 == false) goto L18;
        this.mSubwayContext.nextAllowedEnterTime = System.currentTimeMillis() + 300000;
        SubwayContext r11 = this.mSubwayContext;
        if (r11.isTestMode == false) goto L14;
        r11.nextAllowedEnterTime = System.currentTimeMillis() + SubwayUtils.WAKELOCK_EXIT_CONFIDENCE_SCORING_MS;
    L14:
        CommSenseLog.dumpI(TAG, "Subway enter confirmed! Score: " + this.mSubwayContext.confidenceScore, this.mSubwayLogFile);
        this.mStateManager.reportSubwayEvent(true);
        this.mStateManager.transitionToState(SubwayState.STATE_IDLE);
        return;
    L18:
        return;
    L17:
        return;
    L7:
        r10 = false;
        goto L9
    }

    private void checkExitRulesAfterOutdoorResult() {
        int r8 = this.mSubwayContext.getExitAccumulatedSteps();
        if (SubwayUtils.shouldConfirmExit(this.mSubwayContext.consecutiveExitOutdoorCount, r8) == false) goto L6;
        confirmExit("two outdoor checks and enough steps");
        return;
    }

    private void confirmExit(String r8) {
        CommSenseLog.dumpI(TAG, defpackage.b.d("Subway exit confirmed via ", r8, "!"), this.mSubwayLogFile);
        this.mStateManager.reportSubwayEvent(false);
        SubwayContext r10 = this.mSubwayContext;
        r10.nextAllowedExitTime = System.currentTimeMillis() + 300000;
        this.mSubwayContext.isInSubwayGeofence = false;
        this.mStateManager.transitionToState(SubwayState.STATE_IDLE);
    }

    private void dispatchIndoorOutdoorCheck(String r8, String r10) {
        String r11 = defpackage.b.c("Triggering indoor/outdoor check. Reason: ", r10);
        CommSenseLog.dumpI(TAG, defpackage.b.e("[", r8, "] ", r11), this.mSubwayLogFile);
        showToast(r11);
        EventProcessorListener r12 = this.mListener;
        if (r12 == null) goto L6;
        r12.onIndoorCheckNeeded();
        return;
    }

    private void evaluateEnterConfidenceScoringState() {
        if ((System.currentTimeMillis() - this.mSubwayContext.enterStateEnterScoringTime) <= 240000) goto L6;
        CommSenseLog.dumpI(TAG, "[TIMEOUT] Enter confidence scoring 240s timeout via event processor check. Returning to IDLE.", this.mSubwayLogFile);
        this.mStateManager.transitionToState(SubwayState.STATE_IDLE);
        return;
    L6:
        checkConfidenceScore();
    }

    private void evaluateEnterPreFilterState() {
        if (SubwayUtils.checkPreFilterConditions(this.mSubwayContext) == false) goto L6;
        this.mStateManager.transitionToState(SubwayState.STATE_ENTER_CONFIDENCE_SCORING);
        return;
    }

    private void evaluateExitConfidenceScoringState() {
        evaluateExitCheckTriggerConditions();
    }

    private void evaluateIdleState() {
        SubwayContext r8 = this.mSubwayContext;
        if (r8.curHarStatus != 5) goto L11;
        long r10 = System.currentTimeMillis();
        long r11 = this.mSubwayContext.nextAllowedExitTime;
        if (r10 >= r11) goto L8;
        CommSenseLog.d(TAG, "On subway, but skipped transition to STATE_ON_SUBWAY due to cooldown. Remaining: " + ((r11 - r10) / 1000) + "s");
        return;
    L8:
        CommSenseLog.dumpI(TAG, "HAR state: non-subway -> subway, transitioning to STATE_ON_SUBWAY", this.mSubwayLogFile);
        SubwayStateManager r12 = this.mStateManager;
        SubwayState r13 = SubwayState.STATE_ON_SUBWAY;
    L9:
        r12.transitionToState(r13);
        return;
    L11:
        if (r8.isInSubwayGeofence == false) goto L18;
        long r14 = System.currentTimeMillis();
        long r15 = this.mSubwayContext.nextAllowedEnterTime;
        if (r14 >= r15) goto L16;
        long r16 = (r15 - r14) / 1000;
        CommSenseLog.dumpI(TAG, "In subway geofence, but skipped transition to STATE_ENTER_PRE_FILTER due to cooldown. Remaining: " + r16 + "s", this.mSubwayLogFile);
        showToast("Subway enter skipped (Cooldown: " + r16 + "s)");
        this.mSubwayContext.isInSubwayGeofence = false;
        return;
    L16:
        CommSenseLog.dumpI(TAG, "In subway geofence, transitioning to STATE_ENTER_PRE_FILTER", this.mSubwayLogFile);
        r12 = this.mStateManager;
        r13 = SubwayState.STATE_ENTER_PRE_FILTER;
        goto L9
    }

    private void evaluateOnSubwayState() {
        int r8 = this.mSubwayContext.curHarStatus;
        if (r8 != 2) goto L5;
    L11:
        CommSenseLog.dumpI(TAG, "HAR state: subway -> walk/run/stationary, transitioning to STATE_EXIT_CONFIDENCE_SCORING", this.mSubwayLogFile);
        SubwayStateManager r10 = this.mStateManager;
        SubwayState r11 = SubwayState.STATE_EXIT_CONFIDENCE_SCORING;
    L12:
        r10.transitionToState(r11);
        return;
    L5:
        if (r8 == 1) goto L11;
        if (r8 == 0) goto L11;
        if (r8 == 5) goto L14;
        CommSenseLog.dumpI(TAG, "HAR state: subway -> other, transitioning to STATE_IDLE", this.mSubwayLogFile);
        this.mSubwayContext.isInSubwayGeofence = false;
        r10 = this.mStateManager;
        r11 = SubwayState.STATE_IDLE;
        goto L12
    }

    private boolean isWalkingOrRunning(int r8) {
        if (r8 == 2) goto L8;
        if (r8 == 1) goto L9;
        return false;
    L9:
        return true;
    L8:
        return true;
    }

    private /* synthetic */ void lambda$showToast$0(String r8) {
        Toast.makeText(this.mAndroidContext, r8, 0).show();
    }

    private void markExitCheckTrigger(String r8) {
        this.mSubwayContext.exitHasPendingCheckRequest = true;
        CommSenseLog.dumpI(TAG, defpackage.b.c("[EXIT_TRIGGER] ", r8), this.mSubwayLogFile);
    }

    private void processElevatorEvent(boolean r8, boolean r10) {
        SubwayState r11 = this.mStateManager.getCurrentState();
        if (r11 == SubwayState.STATE_ENTER_CONFIDENCE_SCORING) goto L5;
        SubwayState r12 = SubwayState.STATE_ON_SUBWAY;
        if (r11 != r12) goto L13;
    L14:
        if (r10 == true) goto L16;
        if (r8 == true) goto L16;
        return;
    L16:
        if (r11 != r12) goto L18;
        this.mStateManager.transitionToState(SubwayState.STATE_EXIT_CONFIDENCE_SCORING);
    L18:
        if (r10 == false) goto L20;
        String r13 = "ELEVATOR_UP";
    L21:
        if (r10 == false) goto L23;
        String r14 = "Up";
    L24:
        markExitCheckTrigger(r13);
        String r15 = r14.concat(" elevator in exit scoring. Trigger exit check.");
        String r16 = TAG;
        String r17 = defpackage.b.c("[EXIT_TRIGGER] ", r15);
    L25:
        CommSenseLog.dumpI(r16, r17, this.mSubwayLogFile);
        showToast(r15);
        return;
    L23:
        r14 = "Down";
        goto L24
    L20:
        r13 = "ELEVATOR_DOWN";
        goto L21
    L13:
        if (r11 == SubwayState.STATE_EXIT_CONFIDENCE_SCORING) goto L14;
        return;
    L5:
        if (r8 == false) goto L7;
        SubwayContext r18 = this.mSubwayContext;
        r18.confidenceScore += 15.0f;
        r18.enterTempScore += 15.0f;
        r15 = "Down elevator in enter scoring. Score +15.0, total: " + this.mSubwayContext.confidenceScore;
        r16 = TAG;
        StringBuilder r19 = new StringBuilder("[CONFIDENCE_SCORE] ");
    L9:
        r19.append(r15);
        r17 = r19.toString();
        goto L25
    L7:
        if (r10 == false) goto L27;
        this.mSubwayContext.confidenceScore -= 5.0f;
        r15 = "Up elevator in enter scoring. Score -5.0, total: " + this.mSubwayContext.confidenceScore;
        r16 = TAG;
        r19 = new StringBuilder("[CONFIDENCE_SCORE] ");
        goto L9
    }

    private void showToast(String r8) {
        if (this.mAndroidContext != null) goto L5;
        return;
    L5:
        if (this.mSubwayContext.isTestMode == false) goto L9;
        new Handler(Looper.getMainLooper()).post(new r(18, this, r8));
        return;
    }

    private boolean tryTriggerExitIndoorOutdoorCheck(String r10) {
        long r8 = System.currentTimeMillis();
        if (canTriggerIndoorOutdoorCheck(r8, this.mSubwayContext.lastExitIndoorOutdoorCheckTime, 10000) == true) goto L6;
        CommSenseLog.d(TAG, "Exit indoor/outdoor check skipped due to cool down. Trigger reason was: " + r10);
        return false;
    L6:
        dispatchIndoorOutdoorCheck("EXIT_CHECK", r10);
        SubwayContext r11 = this.mSubwayContext;
        r11.lastExitIndoorOutdoorCheckTime = r8;
        r11.exitHasPendingCheckRequest = false;
        r11.exitAccumulatedWalkingOrRunningDurationMs = 0;
        if (isWalkingOrRunning(r11.curHarStatus) == false) goto L9;
        this.mSubwayContext.exitWalkingOrRunningStartTime = r8;
    L10:
        SubwayContext r12 = this.mSubwayContext;
        int r13 = r12.latestStepCount;
        if (r13 <= 0) goto L15;
        r12.exitLastTriggeredStepCount = r13;
        return true;
    L15:
        return true;
    L9:
        this.mSubwayContext.exitWalkingOrRunningStartTime = 0;
        goto L10
    }

    private void tryTriggerIndoorCheck(String r10) {
        long r8 = System.currentTimeMillis();
        if (canTriggerIndoorOutdoorCheck(r8, this.mSubwayContext.lastIndoorCheckTime, 10000) == true) goto L6;
        CommSenseLog.d(TAG, "Indoor check skipped due to cool down. Trigger reason was: " + r10);
        return;
    L6:
        dispatchIndoorOutdoorCheck("INDOOR_CHECK", r10);
        SubwayContext r11 = this.mSubwayContext;
        r11.lastIndoorCheckTime = r8;
        float r12 = r11.latestPressure;
        if (r12 <= 0.0f) goto L9;
        r11.lastIndoorCheckPressure = r12;
    L9:
        r11.accumulatedWalkingDurationMs = 0;
        if (isWalkingOrRunning(r11.curHarStatus) == false) goto L12;
        this.mSubwayContext.lastWalkingStartTime = r8;
    L13:
        SubwayContext r13 = this.mSubwayContext;
        int r14 = r13.latestStepCount;
        if (r14 <= 0) goto L17;
        r13.lastTriggeredStepCount = r14;
        return;
    L17:
        return;
    L12:
        this.mSubwayContext.lastWalkingStartTime = 0;
        goto L13
    }

    public void evaluateCurrentState() {
        SubwayState r8 = this.mStateManager.getCurrentState();
        int r10 = AnonymousClass1.$SwitchMap$com$obric$cae$userAware$SubwayFusionAware$SubwayState[r8.ordinal()];
        if (r10 != 1) goto L5;
        evaluateIdleState();
        return;
    L5:
        if (r10 != 2) goto L7;
        evaluateOnSubwayState();
        return;
    L7:
        if (r10 != 3) goto L9;
        evaluateEnterPreFilterState();
        return;
    L9:
        if (r10 != 4) goto L11;
        evaluateEnterConfidenceScoringState();
        return;
    L11:
        if (r10 != 5) goto L23;
        evaluateExitConfidenceScoringState();
        return;
    }

    public void evaluateEnterPeriodicIndoorCheck() {
        long r8 = System.currentTimeMillis();
        SubwayContext r10 = this.mSubwayContext;
        boolean r11 = true;
        if (r10.consecutiveIndoorCount < 2) goto L12;
        if ((r8 - r10.lastIndoorCheckTime) >= 20000) goto L8;
        r11 = false;
    L8:
        if (r11 == false) goto L18;
        tryTriggerIndoorCheck("PERIODIC_CONFIRMED_INDOOR");
        return;
    L18:
        return;
    L12:
        if (SubwayUtils.getAccumulatedDurationMs(r10.accumulatedWalkingDurationMs, r10.lastWalkingStartTime, r8) >= 5000) goto L15;
        r11 = false;
    L15:
        if (r11 == false) goto L19;
        tryTriggerIndoorCheck("WALKING");
        return;
    }

    public void evaluateExitCheckTriggerConditions() {
        long r8 = System.currentTimeMillis();
        SubwayContext r10 = this.mSubwayContext;
        if (SubwayUtils.getAccumulatedDurationMs(r10.exitAccumulatedWalkingOrRunningDurationMs, r10.exitWalkingOrRunningStartTime, r8) < 10000) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L9;
        tryTriggerExitIndoorOutdoorCheck("WALKING_OR_RUNNING_10S");
    L9:
        if (this.mSubwayContext.exitHasPendingCheckRequest == false) goto L12;
        tryTriggerExitIndoorOutdoorCheck("EVENT_TRIGGER");
        return;
    L12:
        return;
    L5:
        r11 = false;
        goto L6
    }

    public void processHarStatusChanged(int r13) {
        SubwayContext r8 = this.mSubwayContext;
        int r10 = r8.curHarStatus;
        if (r10 == r13) goto L24;
        r8.previousHarStatus = r10;
        r8.curHarStatus = r13;
        String r11 = String.format("[EVENT_RECEIVED] %s: %s", new Object[]{"HAR_STATUS", "previous=" + this.mSubwayContext.previousHarStatus + ", current=" + this.mSubwayContext.curHarStatus});
        String r12 = TAG;
        CommSenseLog.dumpI(r12, r11, this.mSubwayLogFile);
        SubwayState r14 = this.mStateManager.getCurrentState();
        if (r14 != SubwayState.STATE_ENTER_CONFIDENCE_SCORING) goto L14;
        if (isWalkingOrRunning(r13) == false) goto L9;
        this.mSubwayContext.lastWalkingStartTime = System.currentTimeMillis();
        String r15 = "HAR changed to walking/running, started walking timer.";
    L18:
        CommSenseLog.i(r12, r15);
        return;
    L9:
        SubwayContext r16 = this.mSubwayContext;
        if (r16.lastWalkingStartTime <= 0) goto L12;
        r16.accumulatedWalkingDurationMs = (System.currentTimeMillis() - this.mSubwayContext.lastWalkingStartTime) + r16.accumulatedWalkingDurationMs;
    L12:
        this.mSubwayContext.lastWalkingStartTime = 0;
        StringBuilder r17 = new StringBuilder("HAR changed to stationary, stopped walking timer. Accumulated: ");
        long r18 = this.mSubwayContext.accumulatedWalkingDurationMs;
    L23:
        r17.append(r18);
        r17.append("ms");
        r15 = r17.toString();
        goto L18
    L14:
        if (r14 == SubwayState.STATE_EXIT_CONFIDENCE_SCORING) goto L16;
        return;
    L16:
        if (isWalkingOrRunning(r13) == false) goto L19;
        this.mSubwayContext.exitWalkingOrRunningStartTime = System.currentTimeMillis();
        r15 = "HAR changed to walking/running in exit scoring, started walking timer.";
        goto L18
    L19:
        SubwayContext r19 = this.mSubwayContext;
        if (r19.exitWalkingOrRunningStartTime <= 0) goto L22;
        r19.exitAccumulatedWalkingOrRunningDurationMs = (System.currentTimeMillis() - this.mSubwayContext.exitWalkingOrRunningStartTime) + r19.exitAccumulatedWalkingOrRunningDurationMs;
    L22:
        this.mSubwayContext.exitWalkingOrRunningStartTime = 0;
        r17 = new StringBuilder("HAR changed to non-walking in exit scoring, stopped walking timer. Accumulated: ");
        r18 = this.mSubwayContext.exitAccumulatedWalkingOrRunningDurationMs;
        goto L23
    }

    public void processIndoorOutdoorStatus(int r8) {
        int r10 = 0;
        if (r8 != 1) goto L5;
        boolean r11 = true;
    L6:
        String r12 = String.format("[EVENT_RECEIVED] %s: %s", new Object[]{"INDOOR_OUTDOOR", "status=" + r8 + ", isIndoor=" + r11});
        String r13 = TAG;
        CommSenseLog.dumpI(r13, r12, this.mSubwayLogFile);
        if (r11 == false) goto L9;
        String r14 = "Indoor";
    L10:
        showToast("IndoorOutdoorStatus: ".concat(r14));
        SubwayState r15 = this.mStateManager.getCurrentState();
        if (r15 != SubwayState.STATE_ENTER_CONFIDENCE_SCORING) goto L24;
        SubwayContext r16 = this.mSubwayContext;
        if (r11 == false) goto L15;
        r16.consecutiveIndoorCount++;
        r16.consecutiveOutdoorCount = 0;
        CommSenseLog.dumpI(r13, "Indoor confirmed count: " + this.mSubwayContext.consecutiveIndoorCount, this.mSubwayLogFile);
        String r17 = "Indoor confirmed count: " + this.mSubwayContext.consecutiveIndoorCount;
    L22:
        showToast(r17);
        return;
    L15:
        r16.consecutiveOutdoorCount++;
        r16.consecutiveIndoorCount = 0;
        r16.updateBaselinePressure(this.mSubwayLogFile);
        CommSenseLog.dumpI(r13, "Updated baseline pressure average: " + this.mSubwayContext.baselinePressure + ", reason: outdoor", this.mSubwayLogFile);
        if (this.mSubwayContext.consecutiveOutdoorCount < 2) goto L30;
        long r18 = System.currentTimeMillis();
        SubwayContext r19 = this.mSubwayContext;
        if (r18 <= r19.outdoorPunishTimeout) goto L31;
        float r20 = r19.enterTempScore;
        if (r20 <= 0.0f) goto L32;
        float r21 = Math.min(r20, 4.0f);
        this.mSubwayContext.confidenceScore -= r21;
        String r22 = "Outdoor -" + r21 + ", total: " + this.mSubwayContext.confidenceScore;
        CommSenseLog.dumpI(r13, defpackage.b.c("[CONFIDENCE_SCORE] ", r22), this.mSubwayLogFile);
        r17 = "[CONFIDENCE_SCORE] " + r22;
        goto L22
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L24:
        if (r15 != SubwayState.STATE_EXIT_CONFIDENCE_SCORING) goto L34;
        SubwayContext r23 = this.mSubwayContext;
        if (r11 == true) goto L28;
        r10 = r23.consecutiveExitOutdoorCount + 1;
    L28:
        r23.consecutiveExitOutdoorCount = r10;
        checkExitRulesAfterOutdoorResult();
        return;
    L34:
        return;
    L9:
        r14 = "Outdoor";
        goto L10
    L5:
        r11 = false;
        goto L6
    }

    public void processSensorEvent(SensorEvent r14) {
        boolean r11 = true;
        if (r14.sensor.getType() != 6) goto L45;
        SubwayContext r8 = this.mSubwayContext;
        float r15 = r14.values[0];
        r8.latestPressure = r15;
        String r16 = String.format("[SENSOR_DATA] %s: %s", new Object[]{"PRESSURE", Float.valueOf(r15)});
        String r10 = TAG;
        CommSenseLog.d(r10, r16);
        if (this.mStateManager.getCurrentState() == SubwayState.STATE_ENTER_CONFIDENCE_SCORING) goto L7;
        return;
    L7:
        if (this.mSubwayContext.baselinePressures.isEmpty() == false) goto L9;
        this.mSubwayContext.updateBaselinePressure(this.mSubwayLogFile);
        CommSenseLog.dumpI(r10, "Updated baseline pressure average: " + this.mSubwayContext.baselinePressure + ", reason: 1st pressure of STATE_ENTER_CONFIDENCE_SCORING", this.mSubwayLogFile);
    L9:
        SubwayContext r17 = this.mSubwayContext;
        if (r17.consecutiveIndoorCount >= 2) goto L18;
        float r12 = r17.lastIndoorCheckPressure;
        if (r12 <= 0.0f) goto L18;
        float r18 = r17.latestPressure;
        if (r18 <= 0.0f) goto L18;
        if (Math.abs(r18 - r12) <= 0.25f) goto L18;
        tryTriggerIndoorCheck("PRESSURE_CHANGE");
    L18:
        SubwayContext r19 = this.mSubwayContext;
        if (r19.consecutiveIndoorCount < 1) goto L141;
        float r13 = r19.baselinePressure;
        if (r13 <= 0.0f) goto L142;
        float r20 = r19.latestPressure;
        if (r20 > 0.0f) goto L25;
        return;
    L25:
        if ((r20 - r13) > 0.4f) goto L27;
        r19.continuousPressureStartTime = 0;
        return;
    L27:
        if (r19.continuousPressureStartTime != 0) goto L29;
        r19.continuousPressureStartTime = System.currentTimeMillis();
        return;
    L29:
        long r21 = System.currentTimeMillis();
        SubwayContext r110 = this.mSubwayContext;
        if ((r21 - r110.continuousPressureStartTime) > 5000) goto L32;
        return;
    L32:
        if (r110.baselinePressures.size() < 5.0f) goto L34;
        float r111 = 20.0f;
    L35:
        SubwayContext r22 = this.mSubwayContext;
        float r23 = r22.continuousPressureScoreAdded;
        float r24 = 4.0f;
        if ((r23 + 4.0f) <= r111) goto L39;
        r24 = r111 - r23;
    L39:
        if (r24 <= 0.0f) goto L41;
        r22.continuousPressureScoreAdded = r23 + r24;
        r22.confidenceScore += r24;
        r22.enterTempScore += r24;
        String r112 = "Pressure continuously higher than ground for 5s. Score +" + r24 + ", total: " + this.mSubwayContext.confidenceScore;
        CommSenseLog.dumpI(r10, defpackage.b.c("[CONFIDENCE_SCORE] ", r112), this.mSubwayLogFile);
        showToast(r112);
    L42:
        this.mSubwayContext.continuousPressureStartTime = System.currentTimeMillis();
        return;
    L41:
        CommSenseLog.i(r10, "[CONFIDENCE_SCORE] " + ("Pressure continuously higher than ground for 5s, but max score limit reached (" + r111 + ")"));
        goto L42
    L34:
        r111 = 10.0f;
        goto L35
    L142:
        return;
    L141:
        return;
    L45:
        if (r14.sensor.getType() != 33171014) goto L81;
        int r113 = (int) r14.values[0];
        String r25 = String.format("[SENSOR_DATA] %s: %s", new Object[]{"ELEVATOR", Integer.valueOf(r113)});
        String r26 = TAG;
        CommSenseLog.dumpI(r26, r25, this.mSubwayLogFile);
        if (r113 != 1) goto L49;
        String r27 = "In";
    L50:
        showToast("Elevator Event: ".concat(r27));
        if (r113 != 1) goto L56;
        SubwayContext r114 = this.mSubwayContext;
        float r28 = r114.latestPressure;
        if (r28 <= 0.0f) goto L55;
        r114.inElevatorPressure = r28;
        CommSenseLog.dumpI(r26, "Entered elevator. Baseline pressure: " + this.mSubwayContext.inElevatorPressure, this.mSubwayLogFile);
        return;
    L55:
        r114.inElevatorPressure = -1.0f;
        CommSenseLog.w(r26, "Entered elevator but no pressure baseline available.");
        return;
    L56:
        if (r113 != 2) goto L150;
        SubwayContext r115 = this.mSubwayContext;
        float r29 = r115.inElevatorPressure;
        if (r29 <= 0.0f) goto L78;
        float r116 = r115.latestPressure;
        if (r116 <= 0.0f) goto L78;
        float r117 = r116 - r29;
        CommSenseLog.dumpI(r26, "Exited elevator. Pressure diff: " + r117 + " (In: " + this.mSubwayContext.inElevatorPressure + ", Out: " + this.mSubwayContext.latestPressure + ")", this.mSubwayLogFile);
        if (r117 <= 0.4f) goto L64;
        boolean r30 = true;
    L66:
        if (r117 < (-0.4f)) goto L69;
        r11 = false;
    L69:
        if (r30 == true) goto L73;
        if (r11 == true) goto L73;
        CommSenseLog.i(r26, "Elevator movement not significant, ignored.");
    L79:
        this.mSubwayContext.inElevatorPressure = -1.0f;
        return;
    L73:
        processElevatorEvent(r30, r11);
        if (this.mStateManager.getCurrentState() != SubwayState.STATE_ENTER_CONFIDENCE_SCORING) goto L79;
        if (this.mSubwayContext.consecutiveIndoorCount >= 2) goto L79;
        tryTriggerIndoorCheck("ELEVATOR");
        goto L79
    L64:
        r30 = false;
    L78:
        CommSenseLog.w(r26, "Exited elevator but missing pressure baseline or latest pressure.");
        goto L79
    L150:
        return;
    L49:
        r27 = "Out";
        goto L50
    L81:
        if (r14.sensor.getType() != 33171019) goto L128;
        int r118 = (int) r14.values[0];
        String r31 = String.format("[SENSOR_DATA] %s: %s", new Object[]{"UP_DOWN", Integer.valueOf(r118)});
        String r32 = TAG;
        CommSenseLog.dumpI(r32, r31, this.mSubwayLogFile);
        if (r118 == 0) goto L91;
        long r33 = System.currentTimeMillis();
        SubwayContext r34 = this.mSubwayContext;
        if (r118 == r34.lastNonZeroUpDownType) goto L87;
    L90:
        r34.lastNonZeroUpDownType = r118;
        r34.lastNonZeroUpDownTime = r33;
        goto L91
    L87:
        if ((r33 - r34.lastNonZeroUpDownTime) >= 5000) goto L90;
        CommSenseLog.dumpI(r32, android.aimedia.a.c("Ignored duplicate UP_DOWN event: ", r118, " within 5s"), this.mSubwayLogFile);
        return;
    L91:
        SubwayState r35 = this.mStateManager.getCurrentState();
        if (r35 != SubwayState.STATE_ENTER_CONFIDENCE_SCORING) goto L101;
        if (r118 == 4) goto L100;
        if (r118 == 2) goto L100;
        if (r118 != 3) goto L98;
    L99:
        this.mSubwayContext.confidenceScore -= 10.0f;
        String r119 = "Going up (stairs/escalator) in enter scoring. Score -10.0, total: " + this.mSubwayContext.confidenceScore;
        StringBuilder r36 = new StringBuilder("[CONFIDENCE_SCORE] ");
    L126:
        r36.append(r119);
        CommSenseLog.dumpI(r32, r36.toString(), this.mSubwayLogFile);
        showToast(r119);
        return;
    L98:
        if (r118 == 1) goto L99;
        return;
    L100:
        SubwayContext r120 = this.mSubwayContext;
        r120.confidenceScore += 20.0f;
        r120.enterTempScore += 20.0f;
        r120.outdoorPunishTimeout = System.currentTimeMillis() + SubwayUtils.OUTDOOR_PUNISH_DELAY_TIME;
        r119 = "Going down (stairs/escalator) in enter scoring. Score +20.0, total: " + this.mSubwayContext.confidenceScore;
        r36 = new StringBuilder("[CONFIDENCE_SCORE] ");
        goto L126
    L101:
        SubwayState r37 = SubwayState.STATE_ON_SUBWAY;
        if (r35 != r37) goto L104;
    L105:
        boolean r38 = true;
        if (r118 == 3) goto L110;
        if (r118 == 1) goto L110;
        boolean r39 = false;
    L111:
        if (r118 == 4) goto L115;
        if (r118 == 2) goto L115;
        r38 = false;
    L115:
        if (r39 == true) goto L117;
        if (r38 == true) goto L117;
        return;
    L117:
        if (r35 != r37) goto L119;
        this.mStateManager.transitionToState(SubwayState.STATE_EXIT_CONFIDENCE_SCORING);
    L119:
        if (r39 == false) goto L121;
        String r121 = "UP_DOWN_UP";
    L122:
        if (r39 == false) goto L124;
        String r40 = "up";
    L125:
        markExitCheckTrigger(r121);
        r119 = defpackage.b.d("Going ", r40, " (stairs/escalator) in exit scoring. Trigger exit check.");
        r36 = new StringBuilder("[EXIT_TRIGGER] ");
        goto L126
    L124:
        r40 = "down";
        goto L125
    L121:
        r121 = "UP_DOWN_DOWN";
    L110:
        r39 = true;
        goto L111
    L104:
        if (r35 == SubwayState.STATE_EXIT_CONFIDENCE_SCORING) goto L105;
        return;
    L128:
        if (r14.sensor.getType() != 5) goto L156;
        this.mSubwayContext.latestLightLux = r14.values[0];
        SubwayState r122 = this.mStateManager.getCurrentState();
        if (this.mSubwayContext.latestLightLux > 6000.0f) goto L132;
        return;
    L132:
        if (r122 != SubwayState.STATE_ENTER_CONFIDENCE_SCORING) goto L137;
        long r41 = System.currentTimeMillis();
        SubwayContext r123 = this.mSubwayContext;
        if ((r41 - r123.lastHighLightUpdateTime) < 3000) goto L158;
        r123.lastHighLightUpdateTime = r41;
        r123.consecutiveIndoorCount = 0;
        r123.updateBaselinePressure(this.mSubwayLogFile);
        CommSenseLog.dumpI(TAG, "Updated baseline pressure average: " + this.mSubwayContext.baselinePressure + ", reason: high light lux", this.mSubwayLogFile);
        return;
    L158:
        return;
    L137:
        if (r122 != SubwayState.STATE_EXIT_CONFIDENCE_SCORING) goto L160;
        confirmExit("high light lux");
        return;
    L160:
        return;
    }

    public void processSharedBikeEvent(int r10) {
        if (r10 <= 0) goto L25;
        String r8 = String.format("[EVENT_RECEIVED] %s: %s", new Object[]{"SHARED_BIKE", defpackage.a.d("count=", r10)});
        String r11 = TAG;
        CommSenseLog.dumpI(r11, r8, this.mSubwayLogFile);
        showToast("Shared Bike Event: count=" + r10);
        this.mSubwayContext.addBikeScanEvent(r10, System.currentTimeMillis());
        SubwayState r12 = this.mStateManager.getCurrentState();
        if (r12 != SubwayState.STATE_ENTER_CONFIDENCE_SCORING) goto L7;
        float r13 = 3.0f;
        float r14 = 10.0f;
    L14:
        if (r13 <= 0.0f) goto L26;
        SubwayContext r15 = this.mSubwayContext;
        float r16 = r15.sharedBikeScoreAdded;
        if ((r16 + r13) <= r14) goto L19;
        r13 = r14 - r16;
    L19:
        if (r13 <= 0.0f) goto L21;
        r15.sharedBikeScoreAdded = r16 + r13;
        r15.confidenceScore += r13;
        String r17 = "Shared bike scanned (" + r10 + "), score +" + r13 + ", total: " + this.mSubwayContext.confidenceScore;
        StringBuilder r18 = new StringBuilder("[CONFIDENCE_SCORE] ");
    L22:
        r18.append(r17);
        CommSenseLog.dumpI(r11, r18.toString(), this.mSubwayLogFile);
        return;
    L21:
        r17 = "Shared bike scanned (" + r10 + "), but max score limit reached (" + r14 + ")";
        r18 = new StringBuilder("[CONFIDENCE_SCORE] ");
        goto L22
    L26:
        return;
    L7:
        if (r12 == SubwayState.STATE_EXIT_CONFIDENCE_SCORING) goto L9;
        r13 = 0.0f;
        r14 = 0.0f;
        goto L14
    L9:
        if (SubwayUtils.shouldTriggerExitSharedBikeCheck(r10) == false) goto L24;
        this.mSubwayContext.exitHasPendingCheckRequest = true;
        String r19 = android.aimedia.a.c("Shared bike scanned (", r10, "), trigger exit check.");
        CommSenseLog.dumpI(r11, defpackage.b.c("[EXIT_TRIGGER] ", r19), this.mSubwayLogFile);
        showToast(r19);
        return;
    L24:
        return;
    }

    public void processStepsCounterChanged(int r8) {
        this.mSubwayContext.latestStepCount = r8;
        SubwayState r10 = this.mStateManager.getCurrentState();
        if (r10 != SubwayState.STATE_ENTER_CONFIDENCE_SCORING) goto L16;
        SubwayContext r11 = this.mSubwayContext;
        int r12 = r11.lastTriggeredStepCount;
        if (r12 < 0) goto L13;
        if (r8 < r12) goto L13;
        if (r11.consecutiveIndoorCount >= 2) goto L30;
        int r13 = r8 - r12;
        if (SubwayUtils.shouldTriggerStepBasedCheck(r12, r8, 10) == false) goto L31;
        CommSenseLog.d(TAG, "Step count increased by " + r13 + " (threshold: 10), triggering indoor check.");
        tryTriggerIndoorCheck("STEP_COUNT_INCREASE");
        return;
    L31:
        return;
    L30:
        return;
    L13:
        r11.lastTriggeredStepCount = r8;
        return;
    L16:
        if (r10 != SubwayState.STATE_EXIT_CONFIDENCE_SCORING) goto L33;
        SubwayContext r14 = this.mSubwayContext;
        if (r14.exitScoringStartStepCount >= 0) goto L20;
        r14.exitScoringStartStepCount = r8;
    L20:
        int r15 = r14.exitLastTriggeredStepCount;
        if (r15 < 0) goto L28;
        if (r8 < r15) goto L28;
        int r16 = r8 - r15;
        if (SubwayUtils.shouldTriggerStepBasedCheck(r15, r8, 20) == false) goto L27;
        CommSenseLog.d(TAG, "Exit step count increased by " + r16 + " (threshold: 20), requesting exit check.");
        this.mSubwayContext.exitHasPendingCheckRequest = true;
    L27:
        checkExitRulesAfterOutdoorResult();
        return;
    L28:
        r14.exitLastTriggeredStepCount = r8;
        return;
    }

    public void processSubwayCellPoiStatusChange(InnerAwareInfoCallback.CellPoiStatus r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        SubwayContext r8 = this.mSubwayContext;
        int r10 = r11.rat;
        r8.subwayCellType = r10;
        r8.subwayCellId = r11.cellId;
        r8.subwayPci = r11.pci;
        r8.subwayTac = r11.tac;
        if ((r11.cellPoiType & 1) == 0) goto L7;
        boolean r12 = true;
    L8:
        r8.isInSubwayGeofence = r12;
        String r13 = String.format("[SENSOR_DATA] %s: cellType=%d, cellId(36bit)=%d, pci=%d, tac=%d, cellPoiType=%b", new Object[]{"SUBWAY", Integer.valueOf(r10), Long.valueOf(this.mSubwayContext.subwayCellId), Integer.valueOf(this.mSubwayContext.subwayPci), Integer.valueOf(this.mSubwayContext.subwayTac), Boolean.valueOf(this.mSubwayContext.isInSubwayGeofence)});
        String r14 = TAG;
        CommSenseLog.dumpI(r14, r13, this.mSubwayLogFile);
        showToast("Subway Geofence: " + this.mSubwayContext.isInSubwayGeofence);
        SubwayContext r15 = this.mSubwayContext;
        if (r15.isInSubwayGeofence == false) goto L14;
        String r16 = r11.stationName;
        if (r16 != null) goto L13;
        r16 = CellPoiUtils.getStationName(1, r11.rat, r11.tac, r11.cellId);
    L13:
        SubwayContext r17 = this.mSubwayContext;
        r17.subwayStationName = r16;
        r17.lastSubwayStationName = r16;
        r17.lastSubwayCellId36 = r11.cellId;
        r17.lastSubwayRat = r11.rat;
        r17.lastSubwayTac = r11.tac;
        String r18 = String.format("SubwayStationName = %s", new Object[]{r16});
        CommSenseLog.dumpI(r14, r18, this.mSubwayLogFile);
        showToast(r18);
        return;
    L14:
        r15.subwayStationName = null;
        return;
    L7:
        r12 = false;
        goto L8
    }
}
