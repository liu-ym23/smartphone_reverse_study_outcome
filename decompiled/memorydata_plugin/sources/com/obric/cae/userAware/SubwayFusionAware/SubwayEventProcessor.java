package com.obric.cae.userAware.SubwayFusionAware;

import android.content.Context;
import android.hardware.SensorEvent;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.obric.cae.libs.utils.h;
import com.obric.cae.log.a;
import com.obric.cae.userAware.InnerAwareInfoCallback;
import com.obric.cae.userAware.utils.CellPoiUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
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
            int[] r0 = new int[SubwayState.values().length];
            $SwitchMap$com$obric$cae$userAware$SubwayFusionAware$SubwayState = r0;
            r0[SubwayState.STATE_IDLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
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
        void onIndoorCheckNeeded(String r1);
    }

    public SubwayEventProcessor(Context r3, SubwayContext r4, SubwayStateManager r5, EventProcessorListener r6, File r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        EventProcessorListener r9 = (EventProcessorListener) ZeusTransformUtils.wrapperContextForParams(r6, EventProcessorListener.class, "com.obric.memorydata.plugin");
        this.mAndroidContext = ZeusTransformUtils.wrapperContext(r8, "com.obric.memorydata.plugin");
        this.mSubwayContext = r4;
        this.mStateManager = r5;
        this.mListener = r9;
        this.mSubwayLogFile = r7;
    }

    private boolean canTriggerIndoorOutdoorCheck(long r1, long r3, long r5) {
        if ((r1 - r3) < r5) goto L5;
        return true;
    L5:
        return false;
    }

    private void checkConfidenceScore() {
        if (this.mStateManager.getCurrentState() != SubwayState.STATE_ENTER_CONFIDENCE_SCORING) goto L16;
        SubwayContext r0 = this.mSubwayContext;
        if (r0.consecutiveIndoorCount < 2) goto L7;
        boolean r1 = true;
    L9:
        if (SubwayUtils.isConfirmed(r0.confidenceScore) == false) goto L17;
        if (r1 == false) goto L18;
        this.mSubwayContext.nextAllowedEnterTime = System.currentTimeMillis() + 300000;
        SubwayContext r2 = this.mSubwayContext;
        if (r2.isTestMode == false) goto L14;
        r2.nextAllowedEnterTime = System.currentTimeMillis() + SubwayUtils.WAKELOCK_EXIT_CONFIDENCE_SCORING_MS;
    L14:
        a.c(TAG, "Subway enter confirmed! Score: " + this.mSubwayContext.confidenceScore, this.mSubwayLogFile);
        this.mStateManager.reportSubwayEvent(true);
        this.mStateManager.transitionToState(SubwayState.STATE_IDLE);
        return;
    L18:
        return;
    L17:
        return;
    L7:
        r1 = false;
        goto L9
    }

    private void checkExitRulesAfterOutdoorResult() {
        int r0 = this.mSubwayContext.getExitAccumulatedSteps();
        if (SubwayUtils.shouldConfirmExit(this.mSubwayContext.consecutiveExitOutdoorCount, r0) == false) goto L6;
        confirmExit("two outdoor checks and enough steps");
        return;
    }

    private void confirmExit(String r6) {
        a.c(TAG, "Subway exit confirmed via " + r6 + "!", this.mSubwayLogFile);
        this.mStateManager.reportSubwayEvent(false);
        this.mSubwayContext.nextAllowedExitTime = System.currentTimeMillis() + 300000;
        this.mSubwayContext.isInSubwayGeofence = false;
        this.mStateManager.transitionToState(SubwayState.STATE_IDLE);
    }

    private void dispatchIndoorOutdoorCheck(String r5, String r6) {
        String r0 = h.a("Triggering indoor/outdoor check. Reason: ", r6);
        a.c(TAG, "[" + r5 + "] " + r0, this.mSubwayLogFile);
        showToast(r0);
        EventProcessorListener r4 = this.mListener;
        if (r4 == null) goto L6;
        r4.onIndoorCheckNeeded(r6);
        return;
    }

    private void evaluateEnterConfidenceScoringState() {
        if ((System.currentTimeMillis() - this.mSubwayContext.enterStateEnterScoringTime) <= 240000) goto L6;
        a.c(TAG, "[TIMEOUT] Enter confidence scoring 240s timeout via event processor check. Returning to IDLE.", this.mSubwayLogFile);
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
        SubwayContext r0 = this.mSubwayContext;
        if (r0.curHarStatus != 5) goto L11;
        long r1 = System.currentTimeMillis();
        long r5 = this.mSubwayContext.nextAllowedExitTime;
        if (r1 >= r5) goto L8;
        a.c(TAG, new StringBuilder("On subway, but skipped transition to STATE_ON_SUBWAY due to cooldown. Remaining: ").append((r5 - r1) / 1000).append("s").toString());
        return;
    L8:
        a.c(TAG, "HAR state: non-subway -> subway, transitioning to STATE_ON_SUBWAY", this.mSubwayLogFile);
        SubwayStateManager r8 = this.mStateManager;
        SubwayState r2 = SubwayState.STATE_ON_SUBWAY;
    L9:
        r8.transitionToState(r2);
        return;
    L11:
        if (r0.isInSubwayGeofence == false) goto L18;
        long r3 = System.currentTimeMillis();
        long r6 = this.mSubwayContext.nextAllowedEnterTime;
        if (r3 >= r6) goto L16;
        long r7 = (r6 - r3) / 1000;
        a.c(TAG, "In subway geofence, but skipped transition to STATE_ENTER_PRE_FILTER due to cooldown. Remaining: " + r7 + "s", this.mSubwayLogFile);
        showToast("Subway enter skipped (Cooldown: " + r7 + "s)");
        this.mSubwayContext.isInSubwayGeofence = false;
        return;
    L16:
        a.c(TAG, "In subway geofence, transitioning to STATE_ENTER_PRE_FILTER", this.mSubwayLogFile);
        r8 = this.mStateManager;
        r2 = SubwayState.STATE_ENTER_PRE_FILTER;
        goto L9
    }

    private void evaluateOnSubwayState() {
        int r0 = this.mSubwayContext.curHarStatus;
        if (r0 != 2) goto L5;
    L11:
        a.c(TAG, "HAR state: subway -> walk/run/stationary, transitioning to STATE_EXIT_CONFIDENCE_SCORING", this.mSubwayLogFile);
        SubwayStateManager r3 = this.mStateManager;
        SubwayState r1 = SubwayState.STATE_EXIT_CONFIDENCE_SCORING;
    L12:
        r3.transitionToState(r1);
        return;
    L5:
        if (r0 == 1) goto L11;
        if (r0 == 0) goto L11;
        if (r0 == 5) goto L14;
        a.c(TAG, "HAR state: subway -> other, transitioning to STATE_IDLE", this.mSubwayLogFile);
        this.mSubwayContext.isInSubwayGeofence = false;
        r3 = this.mStateManager;
        r1 = SubwayState.STATE_IDLE;
        goto L12
    }

    private boolean isWalkingOrRunning(int r2) {
        if (r2 == 2) goto L8;
        if (r2 == 1) goto L9;
        return false;
    L9:
        return true;
    L8:
        return true;
    }

    private void markExitCheckTrigger(String r3) {
        this.mSubwayContext.exitHasPendingCheckRequest = true;
        a.c(TAG, h.a("[EXIT_TRIGGER] ", r3), this.mSubwayLogFile);
    }

    private void processElevatorEvent(boolean r4, boolean r5) {
        SubwayState r0 = this.mStateManager.getCurrentState();
        if (r0 != SubwayState.STATE_ENTER_CONFIDENCE_SCORING) goto L11;
        String r1 = "[CONFIDENCE_SCORE] ";
        if (r4 == false) goto L9;
        SubwayContext r6 = this.mSubwayContext;
        r6.confidenceScore += 15.0f;
        r6.enterTempScore += 15.0f;
        StringBuilder r7 = new StringBuilder("Down elevator in enter scoring. Score +15.0, total: ");
    L7:
        String r8 = r7.append(this.mSubwayContext.confidenceScore).toString();
        String r9 = TAG;
    L8:
        a.c(r9, h.a(r1, r8), this.mSubwayLogFile);
        showToast(r8);
        return;
    L9:
        if (r5 == false) goto L27;
        this.mSubwayContext.confidenceScore -= 5.0f;
        r7 = new StringBuilder("Up elevator in enter scoring. Score -5.0, total: ");
        goto L7
    L27:
        return;
    L11:
        SubwayState r2 = SubwayState.STATE_ON_SUBWAY;
        if (r0 != r2) goto L14;
    L15:
        if (r5 == true) goto L17;
        if (r4 == true) goto L17;
        return;
    L17:
        if (r0 != r2) goto L19;
        this.mStateManager.transitionToState(SubwayState.STATE_EXIT_CONFIDENCE_SCORING);
    L19:
        if (r5 == false) goto L21;
        String r10 = "ELEVATOR_UP";
    L22:
        if (r5 == false) goto L24;
        String r11 = "Up";
    L25:
        markExitCheckTrigger(r10);
        r8 = r11.concat(" elevator in exit scoring. Trigger exit check.");
        r9 = TAG;
        r1 = "[EXIT_TRIGGER] ";
        goto L8
    L24:
        r11 = "Down";
        goto L25
    L21:
        r10 = "ELEVATOR_DOWN";
        goto L22
    L14:
        if (r0 == SubwayState.STATE_EXIT_CONFIDENCE_SCORING) goto L15;
    }

    private void showToast(final String r3) {
        if (this.mAndroidContext != null) goto L5;
        return;
    L5:
        if (this.mSubwayContext.isTestMode == false) goto L9;
        new Handler(Looper.getMainLooper()).post(new $$Lambda$SubwayEventProcessor$zBvs_uC7spPxfQUYQMHJrs5Z00(this, r3));
        return;
    }

    private boolean tryTriggerExitIndoorOutdoorCheck(String r10) {
        long r7 = System.currentTimeMillis();
        if (canTriggerIndoorOutdoorCheck(r7, this.mSubwayContext.lastExitIndoorOutdoorCheckTime, 10000) == true) goto L6;
        a.c(TAG, "Exit indoor/outdoor check skipped due to cool down. Trigger reason was: " + r10);
        return false;
    L6:
        dispatchIndoorOutdoorCheck("EXIT_CHECK", r10);
        SubwayContext r11 = this.mSubwayContext;
        r11.lastExitIndoorOutdoorCheckTime = r7;
        r11.exitHasPendingCheckRequest = false;
        r11.exitAccumulatedWalkingOrRunningDurationMs = 0;
        if (isWalkingOrRunning(r11.curHarStatus) == false) goto L9;
        this.mSubwayContext.exitWalkingOrRunningStartTime = r7;
    L10:
        SubwayContext r9 = this.mSubwayContext;
        int r12 = r9.latestStepCount;
        if (r12 <= 0) goto L15;
        r9.exitLastTriggeredStepCount = r12;
        return true;
    L15:
        return true;
    L9:
        this.mSubwayContext.exitWalkingOrRunningStartTime = 0;
        goto L10
    }

    private void tryTriggerIndoorCheck(String r10) {
        long r7 = System.currentTimeMillis();
        if (canTriggerIndoorOutdoorCheck(r7, this.mSubwayContext.lastIndoorCheckTime, 10000) == true) goto L6;
        a.c(TAG, "Indoor check skipped due to cool down. Trigger reason was: " + r10);
        return;
    L6:
        dispatchIndoorOutdoorCheck("INDOOR_CHECK", r10);
        SubwayContext r11 = this.mSubwayContext;
        r11.lastIndoorCheckTime = r7;
        float r0 = r11.latestPressure;
        if (r0 <= 0.0f) goto L9;
        r11.lastIndoorCheckPressure = r0;
    L9:
        r11.accumulatedWalkingDurationMs = 0;
        if (isWalkingOrRunning(r11.curHarStatus) == false) goto L12;
        this.mSubwayContext.lastWalkingStartTime = r7;
    L13:
        SubwayContext r9 = this.mSubwayContext;
        int r12 = r9.latestStepCount;
        if (r12 <= 0) goto L17;
        r9.lastTriggeredStepCount = r12;
        return;
    L17:
        return;
    L12:
        this.mSubwayContext.lastWalkingStartTime = 0;
        goto L13
    }

    public void evaluateCurrentState() {
        SubwayState r0 = this.mStateManager.getCurrentState();
        int r1 = AnonymousClass1.$SwitchMap$com$obric$cae$userAware$SubwayFusionAware$SubwayState[r0.ordinal()];
        if (r1 != 1) goto L5;
        evaluateIdleState();
        return;
    L5:
        if (r1 != 2) goto L7;
        evaluateOnSubwayState();
        return;
    L7:
        if (r1 != 3) goto L9;
        evaluateEnterPreFilterState();
        return;
    L9:
        if (r1 != 4) goto L11;
        evaluateEnterConfidenceScoringState();
        return;
    L11:
        if (r1 != 5) goto L23;
        evaluateExitConfidenceScoringState();
        return;
    }

    public void evaluateEnterPeriodicIndoorCheck() {
        long r4 = System.currentTimeMillis();
        SubwayContext r0 = this.mSubwayContext;
        boolean r6 = true;
        if (r0.consecutiveIndoorCount < 2) goto L12;
        if ((r4 - r0.lastIndoorCheckTime) >= 20000) goto L8;
        r6 = false;
    L8:
        if (r6 == false) goto L18;
        tryTriggerIndoorCheck("PERIODIC_CONFIRMED_INDOOR");
        return;
    L18:
        return;
    L12:
        if (SubwayUtils.getAccumulatedDurationMs(r0.accumulatedWalkingDurationMs, r0.lastWalkingStartTime, r4) >= 5000) goto L15;
        r6 = false;
    L15:
        if (r6 == false) goto L19;
        tryTriggerIndoorCheck("WALKING");
        return;
    }

    public void evaluateExitCheckTriggerConditions() {
        long r4 = System.currentTimeMillis();
        SubwayContext r0 = this.mSubwayContext;
        if (SubwayUtils.getAccumulatedDurationMs(r0.exitAccumulatedWalkingOrRunningDurationMs, r0.exitWalkingOrRunningStartTime, r4) < 10000) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        tryTriggerExitIndoorOutdoorCheck("WALKING_OR_RUNNING_10S");
    L9:
        if (this.mSubwayContext.exitHasPendingCheckRequest == false) goto L12;
        tryTriggerExitIndoorOutdoorCheck("EVENT_TRIGGER");
        return;
    L12:
        return;
    L5:
        r1 = false;
        goto L6
    }

    public /* synthetic */ void lambda$showToast$0$SubwayEventProcessor(String r2) {
        Toast.makeText(this.mAndroidContext, r2, 0).show();
    }

    public void processHarStatusChanged(int r13) {
        SubwayContext r0 = this.mSubwayContext;
        int r1 = r0.curHarStatus;
        if (r1 == r13) goto L24;
        r0.previousHarStatus = r1;
        r0.curHarStatus = r13;
        String r2 = String.format("[EVENT_RECEIVED] %s: %s", new Object[]{"HAR_STATUS", "previous=" + this.mSubwayContext.previousHarStatus + ", current=" + this.mSubwayContext.curHarStatus});
        String r3 = TAG;
        a.c(r3, r2, this.mSubwayLogFile);
        SubwayState r4 = this.mStateManager.getCurrentState();
        if (r4 != SubwayState.STATE_ENTER_CONFIDENCE_SCORING) goto L16;
        if (isWalkingOrRunning(r13) == false) goto L10;
        this.mSubwayContext.lastWalkingStartTime = System.currentTimeMillis();
        String r12 = "HAR changed to walking/running, started walking timer.";
    L9:
        a.e(r3, r12);
        return;
    L10:
        SubwayContext r14 = this.mSubwayContext;
        if (r14.lastWalkingStartTime <= 0) goto L13;
        r14.accumulatedWalkingDurationMs = (System.currentTimeMillis() - this.mSubwayContext.lastWalkingStartTime) + r14.accumulatedWalkingDurationMs;
    L13:
        this.mSubwayContext.lastWalkingStartTime = 0;
        StringBuilder r15 = new StringBuilder("HAR changed to stationary, stopped walking timer. Accumulated: ");
        long r5 = this.mSubwayContext.accumulatedWalkingDurationMs;
    L14:
        r12 = r15.append(r5).append("ms").toString();
        goto L9
    L16:
        if (r4 == SubwayState.STATE_EXIT_CONFIDENCE_SCORING) goto L18;
        return;
    L18:
        if (isWalkingOrRunning(r13) == false) goto L20;
        this.mSubwayContext.exitWalkingOrRunningStartTime = System.currentTimeMillis();
        r12 = "HAR changed to walking/running in exit scoring, started walking timer.";
        goto L9
    L20:
        SubwayContext r16 = this.mSubwayContext;
        if (r16.exitWalkingOrRunningStartTime <= 0) goto L23;
        r16.exitAccumulatedWalkingOrRunningDurationMs = (System.currentTimeMillis() - this.mSubwayContext.exitWalkingOrRunningStartTime) + r16.exitAccumulatedWalkingOrRunningDurationMs;
    L23:
        this.mSubwayContext.exitWalkingOrRunningStartTime = 0;
        r15 = new StringBuilder("HAR changed to non-walking in exit scoring, stopped walking timer. Accumulated: ");
        r5 = this.mSubwayContext.exitAccumulatedWalkingOrRunningDurationMs;
        goto L14
    }

    public void processIndoorOutdoorStatus(int r8) {
        int r0 = 0;
        if (r8 != 1) goto L5;
        boolean r2 = true;
    L6:
        String r9 = String.format("[EVENT_RECEIVED] %s: %s", new Object[]{"INDOOR_OUTDOOR", "status=" + r8 + ", isIndoor=" + r2});
        String r4 = TAG;
        a.c(r4, r9, this.mSubwayLogFile);
        if (r2 == false) goto L9;
        String r10 = "Indoor";
    L10:
        showToast("IndoorOutdoorStatus: ".concat(r10));
        SubwayState r11 = this.mStateManager.getCurrentState();
        if (r11 != SubwayState.STATE_ENTER_CONFIDENCE_SCORING) goto L24;
        SubwayContext r12 = this.mSubwayContext;
        if (r2 == false) goto L16;
        r12.consecutiveIndoorCount++;
        r12.consecutiveOutdoorCount = 0;
        a.c(r4, "Indoor confirmed count: " + this.mSubwayContext.consecutiveIndoorCount, this.mSubwayLogFile);
        StringBuilder r13 = new StringBuilder("Indoor confirmed count: ").append(this.mSubwayContext.consecutiveIndoorCount);
    L15:
        showToast(r13.toString());
        return;
    L16:
        r12.consecutiveOutdoorCount++;
        r12.consecutiveIndoorCount = 0;
        r12.updateBaselinePressure(this.mSubwayLogFile);
        a.c(r4, "Updated baseline pressure average: " + this.mSubwayContext.baselinePressure + ", reason: outdoor", this.mSubwayLogFile);
        if (this.mSubwayContext.consecutiveOutdoorCount < 2) goto L31;
        long r1 = System.currentTimeMillis();
        SubwayContext r14 = this.mSubwayContext;
        if (r1 <= r14.outdoorPunishTimeout) goto L32;
        float r15 = r14.enterTempScore;
        if (r15 <= 0.0f) goto L33;
        float r16 = Math.min(r15, 4.0f);
        this.mSubwayContext.confidenceScore -= r16;
        String r17 = "Outdoor -" + r16 + ", total: " + this.mSubwayContext.confidenceScore;
        a.c(r4, h.a("[CONFIDENCE_SCORE] ", r17), this.mSubwayLogFile);
        r13 = new StringBuilder("[CONFIDENCE_SCORE] ").append(r17);
        goto L15
    L33:
        return;
    L32:
        return;
    L31:
        return;
    L24:
        if (r11 != SubwayState.STATE_EXIT_CONFIDENCE_SCORING) goto L34;
        SubwayContext r18 = this.mSubwayContext;
        if (r2 == true) goto L28;
        r0 = r18.consecutiveExitOutdoorCount + 1;
    L28:
        r18.consecutiveExitOutdoorCount = r0;
        checkExitRulesAfterOutdoorResult();
        return;
    L34:
        return;
    L9:
        r10 = "Outdoor";
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    public void processSensorEvent(SensorEvent r17) {
        boolean r13 = true;
        if (r17.sensor.getType() != 6) goto L45;
        SubwayContext r2 = this.mSubwayContext;
        float r1 = r17.values[0];
        r2.latestPressure = r1;
        String r3 = String.format("[SENSOR_DATA] %s: %s", new Object[]{"PRESSURE", Float.valueOf(r1)});
        String r4 = TAG;
        a.c(r4, r3);
        if (this.mStateManager.getCurrentState() == SubwayState.STATE_ENTER_CONFIDENCE_SCORING) goto L7;
        return;
    L7:
        if (this.mSubwayContext.baselinePressures.isEmpty() == false) goto L9;
        this.mSubwayContext.updateBaselinePressure(this.mSubwayLogFile);
        a.c(r4, "Updated baseline pressure average: " + this.mSubwayContext.baselinePressure + ", reason: 1st pressure of STATE_ENTER_CONFIDENCE_SCORING", this.mSubwayLogFile);
    L9:
        SubwayContext r5 = this.mSubwayContext;
        if (r5.consecutiveIndoorCount >= 2) goto L18;
        float r7 = r5.lastIndoorCheckPressure;
        if (r7 <= 0.0f) goto L18;
        float r6 = r5.latestPressure;
        if (r6 <= 0.0f) goto L18;
        if (Math.abs(r6 - r7) <= 0.25f) goto L18;
        tryTriggerIndoorCheck("PRESSURE_CHANGE");
    L18:
        SubwayContext r8 = this.mSubwayContext;
        if (r8.consecutiveIndoorCount < 1) goto L140;
        float r9 = r8.baselinePressure;
        if (r9 <= 0.0f) goto L141;
        float r10 = r8.latestPressure;
        if (r10 > 0.0f) goto L25;
        return;
    L25:
        if ((r10 - r9) > 0.4f) goto L27;
        r8.continuousPressureStartTime = 0;
        return;
    L27:
        if (r8.continuousPressureStartTime != 0) goto L29;
        r8.continuousPressureStartTime = System.currentTimeMillis();
        return;
    L29:
        long r12 = System.currentTimeMillis();
        SubwayContext r11 = this.mSubwayContext;
        if ((r12 - r11.continuousPressureStartTime) > 5000) goto L32;
        return;
    L32:
        if (r11.baselinePressures.size() < 5.0f) goto L34;
        float r14 = 20.0f;
    L35:
        float r15 = 4.0f;
        SubwayContext r16 = this.mSubwayContext;
        float r18 = r16.continuousPressureScoreAdded;
        if ((r18 + 4.0f) <= r14) goto L39;
        r15 = r14 - r18;
    L39:
        if (r15 <= 0.0f) goto L41;
        r16.continuousPressureScoreAdded = r18 + r15;
        r16.confidenceScore += r15;
        r16.enterTempScore += r15;
        String r19 = "Pressure continuously higher than ground for 5s. Score +" + r15 + ", total: " + this.mSubwayContext.confidenceScore;
        a.c(r4, h.a("[CONFIDENCE_SCORE] ", r19), this.mSubwayLogFile);
        showToast(r19);
    L42:
        this.mSubwayContext.continuousPressureStartTime = System.currentTimeMillis();
        return;
    L41:
        a.e(r4, "[CONFIDENCE_SCORE] " + ("Pressure continuously higher than ground for 5s, but max score limit reached (" + r14 + ")"));
        goto L42
    L34:
        r14 = 10.0f;
        goto L35
    L141:
        return;
    L140:
        return;
    L45:
        if (r17.sensor.getType() != 33171014) goto L81;
        int r20 = (int) r17.values[0];
        String r21 = String.format("[SENSOR_DATA] %s: %s", new Object[]{"ELEVATOR", Integer.valueOf(r20)});
        String r22 = TAG;
        a.c(r22, r21, this.mSubwayLogFile);
        if (r20 != 1) goto L49;
        String r23 = "In";
    L50:
        showToast("Elevator Event: ".concat(r23));
        if (r20 != 1) goto L56;
        SubwayContext r24 = this.mSubwayContext;
        float r25 = r24.latestPressure;
        if (r25 <= 0.0f) goto L55;
        r24.inElevatorPressure = r25;
        a.c(r22, "Entered elevator. Baseline pressure: " + this.mSubwayContext.inElevatorPressure, this.mSubwayLogFile);
        return;
    L55:
        r24.inElevatorPressure = -1.0f;
        a.g(r22, "Entered elevator but no pressure baseline available.");
        return;
    L56:
        if (r20 != 2) goto L149;
        SubwayContext r26 = this.mSubwayContext;
        float r27 = r26.inElevatorPressure;
        if (r27 <= 0.0f) goto L78;
        float r28 = r26.latestPressure;
        if (r28 <= 0.0f) goto L78;
        float r29 = r28 - r27;
        a.c(r22, "Exited elevator. Pressure diff: " + r29 + " (In: " + this.mSubwayContext.inElevatorPressure + ", Out: " + this.mSubwayContext.latestPressure + ")", this.mSubwayLogFile);
        if (r29 <= 0.4f) goto L64;
        boolean r30 = true;
    L66:
        if (r29 < (-0.4f)) goto L69;
        r13 = false;
    L69:
        if (r30 == true) goto L73;
        if (r13 == true) goto L73;
        a.e(r22, "Elevator movement not significant, ignored.");
    L79:
        this.mSubwayContext.inElevatorPressure = -1.0f;
        return;
    L73:
        processElevatorEvent(r30, r13);
        if (this.mStateManager.getCurrentState() != SubwayState.STATE_ENTER_CONFIDENCE_SCORING) goto L79;
        if (this.mSubwayContext.consecutiveIndoorCount >= 2) goto L79;
        tryTriggerIndoorCheck("ELEVATOR");
        goto L79
    L64:
        r30 = false;
    L78:
        a.g(r22, "Exited elevator but missing pressure baseline or latest pressure.");
        goto L79
    L149:
        return;
    L49:
        r23 = "Out";
        goto L50
    L81:
        if (r17.sensor.getType() != 33171019) goto L127;
        int r31 = (int) r17.values[0];
        String r32 = String.format("[SENSOR_DATA] %s: %s", new Object[]{"UP_DOWN", Integer.valueOf(r31)});
        String r33 = TAG;
        a.c(r33, r32, this.mSubwayLogFile);
        if (r31 == 0) goto L91;
        long r110 = System.currentTimeMillis();
        SubwayContext r34 = this.mSubwayContext;
        if (r31 == r34.lastNonZeroUpDownType) goto L87;
    L90:
        r34.lastNonZeroUpDownType = r31;
        r34.lastNonZeroUpDownTime = r110;
        goto L91
    L87:
        if ((r110 - r34.lastNonZeroUpDownTime) >= 5000) goto L90;
        a.c(r33, "Ignored duplicate UP_DOWN event: " + r31 + " within 5s", this.mSubwayLogFile);
        return;
    L91:
        SubwayState r35 = this.mStateManager.getCurrentState();
        if (r35 != SubwayState.STATE_ENTER_CONFIDENCE_SCORING) goto L102;
        if (r31 == 4) goto L99;
        if (r31 == 2) goto L99;
        if (r31 == 3) goto L98;
        if (r31 == 1) goto L98;
        return;
    L98:
        this.mSubwayContext.confidenceScore -= 10.0f;
        StringBuilder r36 = new StringBuilder("Going up (stairs/escalator) in enter scoring. Score -10.0, total: ");
    L100:
        String r37 = r36.append(this.mSubwayContext.confidenceScore).toString();
        String r38 = h.a("[CONFIDENCE_SCORE] ", r37);
    L101:
        a.c(r33, r38, this.mSubwayLogFile);
        showToast(r37);
        return;
    L99:
        SubwayContext r39 = this.mSubwayContext;
        r39.confidenceScore += 20.0f;
        r39.enterTempScore += 20.0f;
        r39.outdoorPunishTimeout = System.currentTimeMillis() + SubwayUtils.OUTDOOR_PUNISH_DELAY_TIME;
        r36 = new StringBuilder("Going down (stairs/escalator) in enter scoring. Score +20.0, total: ");
        goto L100
    L102:
        SubwayState r40 = SubwayState.STATE_ON_SUBWAY;
        if (r35 != r40) goto L105;
    L106:
        if (r31 == 3) goto L110;
        if (r31 == 1) goto L110;
        boolean r41 = false;
    L111:
        if (r31 == 4) goto L115;
        if (r31 == 2) goto L115;
        r13 = false;
    L115:
        if (r41 == true) goto L117;
        if (r13 == true) goto L117;
        return;
    L117:
        if (r35 != r40) goto L119;
        this.mStateManager.transitionToState(SubwayState.STATE_EXIT_CONFIDENCE_SCORING);
    L119:
        if (r41 == false) goto L121;
        String r42 = "UP_DOWN_UP";
    L122:
        if (r41 == false) goto L124;
        String r43 = "up";
    L125:
        markExitCheckTrigger(r42);
        r37 = "Going " + r43 + " (stairs/escalator) in exit scoring. Trigger exit check.";
        r38 = h.a("[EXIT_TRIGGER] ", r37);
        goto L101
    L124:
        r43 = "down";
        goto L125
    L121:
        r42 = "UP_DOWN_DOWN";
    L110:
        r41 = true;
        goto L111
    L105:
        if (r35 == SubwayState.STATE_EXIT_CONFIDENCE_SCORING) goto L106;
        return;
    L127:
        if (r17.sensor.getType() != 5) goto L155;
        this.mSubwayContext.latestLightLux = r17.values[0];
        SubwayState r44 = this.mStateManager.getCurrentState();
        if (this.mSubwayContext.latestLightLux > 6000.0f) goto L131;
        return;
    L131:
        if (r44 != SubwayState.STATE_ENTER_CONFIDENCE_SCORING) goto L136;
        long r45 = System.currentTimeMillis();
        SubwayContext r46 = this.mSubwayContext;
        if ((r45 - r46.lastHighLightUpdateTime) < 3000) goto L157;
        r46.lastHighLightUpdateTime = r45;
        r46.consecutiveIndoorCount = 0;
        r46.updateBaselinePressure(this.mSubwayLogFile);
        a.c(TAG, "Updated baseline pressure average: " + this.mSubwayContext.baselinePressure + ", reason: high light lux", this.mSubwayLogFile);
        return;
    L157:
        return;
    L136:
        if (r44 != SubwayState.STATE_EXIT_CONFIDENCE_SCORING) goto L159;
        confirmExit("high light lux");
        return;
    L159:
        return;
    }

    public void processSharedBikeEvent(int r9) {
        if (r9 <= 0) goto L25;
        String r0 = String.format("[EVENT_RECEIVED] %s: %s", new Object[]{"SHARED_BIKE", "count=" + r9});
        String r1 = TAG;
        a.c(r1, r0, this.mSubwayLogFile);
        showToast("Shared Bike Event: count=" + r9);
        this.mSubwayContext.addBikeScanEvent(r9, System.currentTimeMillis());
        SubwayState r2 = this.mStateManager.getCurrentState();
        if (r2 != SubwayState.STATE_ENTER_CONFIDENCE_SCORING) goto L7;
        float r3 = 3.0f;
        float r4 = 10.0f;
    L14:
        if (r3 <= 0.0f) goto L26;
        SubwayContext r5 = this.mSubwayContext;
        float r6 = r5.sharedBikeScoreAdded;
        if ((r6 + r3) <= r4) goto L19;
        r3 = r4 - r6;
    L19:
        if (r3 <= 0.0f) goto L21;
        r5.sharedBikeScoreAdded = r6 + r3;
        r5.confidenceScore += r3;
        StringBuilder r10 = new StringBuilder("Shared bike scanned (").append(r9).append("), score +").append(r3).append(", total: ").append(this.mSubwayContext.confidenceScore);
    L22:
        a.c(r1, h.a("[CONFIDENCE_SCORE] ", r10.toString()), this.mSubwayLogFile);
        return;
    L21:
        r10 = new StringBuilder("Shared bike scanned (").append(r9).append("), but max score limit reached (").append(r4).append(")");
        goto L22
    L26:
        return;
    L7:
        if (r2 == SubwayState.STATE_EXIT_CONFIDENCE_SCORING) goto L9;
        r3 = 0.0f;
        r4 = 0.0f;
        goto L14
    L9:
        if (SubwayUtils.shouldTriggerExitSharedBikeCheck(r9) == false) goto L24;
        this.mSubwayContext.exitHasPendingCheckRequest = true;
        String r11 = "Shared bike scanned (" + r9 + "), trigger exit check.";
        a.c(r1, h.a("[EXIT_TRIGGER] ", r11), this.mSubwayLogFile);
        showToast(r11);
        return;
    L24:
        return;
    }

    public void processStepsCounterChanged(int r4) {
        this.mSubwayContext.latestStepCount = r4;
        SubwayState r0 = this.mStateManager.getCurrentState();
        if (r0 != SubwayState.STATE_ENTER_CONFIDENCE_SCORING) goto L16;
        SubwayContext r1 = this.mSubwayContext;
        int r2 = r1.lastTriggeredStepCount;
        if (r2 < 0) goto L13;
        if (r4 < r2) goto L13;
        if (r1.consecutiveIndoorCount >= 2) goto L30;
        int r3 = r4 - r2;
        if (SubwayUtils.shouldTriggerStepBasedCheck(r2, r4, 10) == false) goto L31;
        a.c(TAG, "Step count increased by " + r3 + " (threshold: 10), triggering indoor check.");
        tryTriggerIndoorCheck("STEP_COUNT_INCREASE");
        return;
    L31:
        return;
    L30:
        return;
    L13:
        r1.lastTriggeredStepCount = r4;
        return;
    L16:
        if (r0 != SubwayState.STATE_EXIT_CONFIDENCE_SCORING) goto L33;
        SubwayContext r5 = this.mSubwayContext;
        if (r5.exitScoringStartStepCount >= 0) goto L20;
        r5.exitScoringStartStepCount = r4;
    L20:
        int r6 = r5.exitLastTriggeredStepCount;
        if (r6 < 0) goto L28;
        if (r4 < r6) goto L28;
        int r7 = r4 - r6;
        if (SubwayUtils.shouldTriggerStepBasedCheck(r6, r4, 20) == false) goto L27;
        a.c(TAG, "Exit step count increased by " + r7 + " (threshold: 20), requesting exit check.");
        this.mSubwayContext.exitHasPendingCheckRequest = true;
    L27:
        checkExitRulesAfterOutdoorResult();
        return;
    L28:
        r5.exitLastTriggeredStepCount = r4;
        return;
    }

    public void processSubwayCellPoiStatusChange(InnerAwareInfoCallback.CellPoiStatus r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        SubwayContext r0 = this.mSubwayContext;
        int r1 = r8.rat;
        r0.subwayCellType = r1;
        r0.subwayCellId = r8.cellId;
        r0.subwayPci = r8.pci;
        r0.subwayTac = r8.tac;
        if ((r8.cellPoiType & 1) == 0) goto L7;
        boolean r2 = true;
    L8:
        r0.isInSubwayGeofence = r2;
        String r3 = String.format("[SENSOR_DATA] %s: cellType=%d, cellId(36bit)=%d, pci=%d, tac=%d, cellPoiType=%b", new Object[]{"SUBWAY", Integer.valueOf(r1), Long.valueOf(this.mSubwayContext.subwayCellId), Integer.valueOf(this.mSubwayContext.subwayPci), Integer.valueOf(this.mSubwayContext.subwayTac), Boolean.valueOf(this.mSubwayContext.isInSubwayGeofence)});
        String r4 = TAG;
        a.c(r4, r3, this.mSubwayLogFile);
        showToast("Subway Geofence: " + this.mSubwayContext.isInSubwayGeofence);
        SubwayContext r5 = this.mSubwayContext;
        if (r5.isInSubwayGeofence == false) goto L14;
        String r6 = r8.stationName;
        if (r6 != null) goto L13;
        r6 = CellPoiUtils.getStationName(1, r8.rat, r8.tac, r8.cellId);
    L13:
        SubwayContext r7 = this.mSubwayContext;
        r7.subwayStationName = r6;
        r7.lastSubwayStationName = r6;
        r7.lastSubwayCellId36 = r8.cellId;
        r7.lastSubwayRat = r8.rat;
        r7.lastSubwayTac = r8.tac;
        String r9 = String.format("SubwayStationName = %s", new Object[]{r6});
        a.c(r4, r9, this.mSubwayLogFile);
        showToast(r9);
        return;
    L14:
        r5.subwayStationName = null;
        return;
    L7:
        r2 = false;
        goto L8
    }
}
