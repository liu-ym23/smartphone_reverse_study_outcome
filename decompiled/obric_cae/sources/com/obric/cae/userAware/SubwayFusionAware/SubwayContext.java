package com.obric.cae.userAware.SubwayFusionAware;

import com.obric.cae.log.CommSenseLog;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
public class SubwayContext {
    public static final int MAX_BASELINE_PRESSURE_HISTORY = 10;
    public static final int MAX_BIKE_SCAN_HISTORY = 5;
    public long accumulatedWalkingDurationMs;
    public float baselinePressure;
    public final Queue<Float> baselinePressures;
    public float confidenceScore;
    public int consecutiveExitOutdoorCount;
    public int consecutiveIndoorCount;
    public int consecutiveOutdoorCount;
    public float continuousPressureScoreAdded;
    public long continuousPressureStartTime;
    public int curHarStatus;
    public long enterStateEnterScoringTime;
    public long enterStateExitScoringTime;
    public long enterStateIdleTime;
    public long enterStateOnSubwayTime;
    public float enterTempScore;
    public long exitAccumulatedWalkingOrRunningDurationMs;
    public boolean exitHasPendingCheckRequest;
    public int exitLastTriggeredStepCount;
    public int exitScoringStartStepCount;
    public long exitWalkingOrRunningStartTime;
    public boolean hasExtendedWakeLock;
    public float inElevatorPressure;
    public boolean isInSubwayGeofence;
    public boolean isTestMode;
    public boolean isWifiConnected;
    public long lastExitIndoorOutdoorCheckTime;
    public long lastHighLightUpdateTime;
    public float lastIndoorCheckPressure;
    public long lastIndoorCheckTime;
    public long lastNonZeroUpDownTime;
    public int lastNonZeroUpDownType;
    public long lastSubwayCellId36;
    public int lastSubwayRat;
    public String lastSubwayStationName;
    public int lastSubwayTac;
    public int lastTriggeredStepCount;
    public long lastWalkingStartTime;
    public float latestLightLux;
    public float latestPressure;
    public int latestStepCount;
    public String locationState;
    public long nextAllowedEnterTime;
    public long nextAllowedExitTime;
    public long outdoorPunishTimeout;
    public int previousHarStatus;
    public final Queue<BikeScanEvent> recentBikeScanCounts;
    public float sharedBikeScoreAdded;
    public long subwayCellId;
    public int subwayCellType;
    public int subwayPci;
    public String subwayStationName;
    public int subwayTac;

    public static class BikeScanEvent {
        public final int count;
        public final long timestamp;

        public BikeScanEvent(int r8, long r10) {
            this.count = r8;
            this.timestamp = r10;
        }

        public String toString() {
            return "{" + this.count + "@" + this.timestamp + "}";
        }
    }

    public SubwayContext() {
        this.confidenceScore = 0.0f;
        this.enterTempScore = 0.0f;
        this.curHarStatus = -1;
        this.previousHarStatus = -1;
        this.isWifiConnected = false;
        this.locationState = "";
        this.lastIndoorCheckTime = 0;
        this.lastIndoorCheckPressure = -1.0f;
        this.accumulatedWalkingDurationMs = 0;
        this.lastWalkingStartTime = 0;
        this.exitAccumulatedWalkingOrRunningDurationMs = 0;
        this.lastTriggeredStepCount = -1;
        this.exitLastTriggeredStepCount = -1;
        this.latestStepCount = -1;
        this.exitScoringStartStepCount = -1;
        this.consecutiveExitOutdoorCount = 0;
        this.lastExitIndoorOutdoorCheckTime = 0;
        this.exitWalkingOrRunningStartTime = 0;
        this.exitHasPendingCheckRequest = false;
        this.outdoorPunishTimeout = 0;
        this.enterStateEnterScoringTime = 0;
        this.hasExtendedWakeLock = false;
        this.enterStateIdleTime = 0;
        this.enterStateOnSubwayTime = 0;
        this.enterStateExitScoringTime = 0;
        this.lastNonZeroUpDownType = 0;
        this.lastNonZeroUpDownTime = 0;
        this.consecutiveIndoorCount = 0;
        this.consecutiveOutdoorCount = 0;
        this.continuousPressureStartTime = 0;
        this.continuousPressureScoreAdded = 0.0f;
        this.latestPressure = -1.0f;
        this.inElevatorPressure = -1.0f;
        this.baselinePressure = -1.0f;
        this.baselinePressures = new LinkedList();
        this.latestLightLux = -1.0f;
        this.lastHighLightUpdateTime = 0;
        this.recentBikeScanCounts = new LinkedList();
        this.sharedBikeScoreAdded = 0.0f;
        this.isInSubwayGeofence = false;
        this.subwayCellType = -1;
        this.subwayCellId = -1;
        this.subwayPci = -1;
        this.subwayTac = -1;
        this.subwayStationName = null;
        this.lastSubwayStationName = null;
        this.lastSubwayCellId36 = -1;
        this.lastSubwayRat = -1;
        this.lastSubwayTac = -1;
        this.nextAllowedEnterTime = 0;
        this.nextAllowedExitTime = 0;
        this.isTestMode = false;
    }

    public void addBikeScanEvent(int r8, long r10) {
        if (this.recentBikeScanCounts.size() < 5) goto L5;
        this.recentBikeScanCounts.poll();
    L5:
        this.recentBikeScanCounts.offer(new BikeScanEvent(r8, r10));
    }

    public void checkAndApplySharedBikeScore(File r10) {
        long r8 = System.currentTimeMillis();
        Iterator<BikeScanEvent> r11 = this.recentBikeScanCounts.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        BikeScanEvent r12 = r11.next();
        if ((r8 - r12.timestamp) > 30000) goto L4;
        if (r12.count <= 3) goto L4;
        boolean r13 = true;
    L11:
        if (r13 == false) goto L27;
        float r14 = this.sharedBikeScoreAdded;
        if (r14 >= 10.0f) goto L28;
        float r15 = 3.0f;
        if ((r14 + 3.0f) <= 10.0f) goto L18;
        r15 = 10.0f - r14;
    L18:
        if (r15 <= 0.0f) goto L29;
        this.confidenceScore += r15;
        this.sharedBikeScoreAdded = r14 + r15;
        CommSenseLog.dumpI("SubwayContext", "[CONFIDENCE_SCORE] " + ("Valid shared bike event in history. Score +" + r15 + ", total: " + this.confidenceScore), r10);
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L10:
        r13 = false;
        goto L11
    }

    public int getExitAccumulatedSteps() {
        int r8 = this.latestStepCount;
        if (r8 < 0) goto L9;
        int r10 = this.exitScoringStartStepCount;
        if (r10 < 0) goto L9;
        return Math.max(0, r8 - r10);
    L9:
        return 0;
    }

    public String toString() {
        StringBuilder r8 = new StringBuilder("SubwayContext{confidenceScore=");
        r8.append(this.confidenceScore);
        r8.append(", curHarStatus=");
        r8.append(this.curHarStatus);
        r8.append(", previousHarStatus=");
        r8.append(this.previousHarStatus);
        r8.append(", isWifiConnected=");
        r8.append(this.isWifiConnected);
        r8.append(", locationState='");
        r8.append(this.locationState);
        r8.append("', lastIndoorCheckTime=");
        r8.append(this.lastIndoorCheckTime);
        r8.append(", lastIndoorCheckPressure=");
        r8.append(this.lastIndoorCheckPressure);
        r8.append(", accumulatedWalkingDurationMs=");
        r8.append(this.accumulatedWalkingDurationMs);
        r8.append(", lastWalkingStartTime=");
        r8.append(this.lastWalkingStartTime);
        r8.append(", consecutiveIndoorCount=");
        r8.append(this.consecutiveIndoorCount);
        r8.append(", consecutiveExitOutdoorCount=");
        r8.append(this.consecutiveExitOutdoorCount);
        r8.append(", continuousPressureStartTime=");
        r8.append(this.continuousPressureStartTime);
        r8.append(", latestPressure=");
        r8.append(this.latestPressure);
        r8.append(", inElevatorPressure=");
        r8.append(this.inElevatorPressure);
        r8.append(", baselinePressure=");
        r8.append(this.baselinePressure);
        r8.append(", baselinePressures=");
        r8.append(this.baselinePressures);
        r8.append(", latestLightLux=");
        r8.append(this.latestLightLux);
        r8.append(", lastHighLightUpdateTime=");
        r8.append(this.lastHighLightUpdateTime);
        r8.append(", recentBikeScanCounts=");
        r8.append(this.recentBikeScanCounts);
        r8.append(", isInSubwayGeofence=");
        r8.append(this.isInSubwayGeofence);
        r8.append(", subwayCellType=");
        r8.append(this.subwayCellType);
        r8.append(", subwayCellId=");
        r8.append(this.subwayCellId);
        r8.append(", subwayPci=");
        r8.append(this.subwayPci);
        r8.append(", subwayTac=");
        return android.aimedia.a.f(r8, this.subwayTac, '}');
    }

    public void updateBaselinePressure(File r8) {
        float r10 = 0.0f;
        if (this.latestPressure > 0.0f) goto L6;
        return;
    L6:
        if (this.baselinePressures.size() < 10) goto L8;
        this.baselinePressures.poll();
    L8:
        this.baselinePressures.offer(Float.valueOf(this.latestPressure));
        Iterator<Float> r11 = this.baselinePressures.iterator();
    L10:
        if (r11.hasNext() == false) goto L12;
        r10 = r10 + r11.next().floatValue();
        goto L10
    L12:
        this.baselinePressure = r10 / this.baselinePressures.size();
        CommSenseLog.dumpI("SubwayContext", "baselinePressures: " + this.baselinePressures, r8);
    }
}
