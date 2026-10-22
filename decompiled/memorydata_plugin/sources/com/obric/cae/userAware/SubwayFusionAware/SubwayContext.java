package com.obric.cae.userAware.SubwayFusionAware;

import com.obric.cae.log.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes3.dex */
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

        public BikeScanEvent(int r1, long r2) {
            this.count = r1;
            this.timestamp = r2;
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

    public void addBikeScanEvent(int r3, long r4) {
        if (this.recentBikeScanCounts.size() < 5) goto L5;
        this.recentBikeScanCounts.poll();
    L5:
        this.recentBikeScanCounts.offer(new BikeScanEvent(r3, r4));
    }

    public void checkAndApplySharedBikeScore(File r9) {
        long r0 = System.currentTimeMillis();
        Iterator<BikeScanEvent> r2 = this.recentBikeScanCounts.iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        BikeScanEvent r3 = (BikeScanEvent) ZeusTransformUtils.preCheckCast(r2.next(), BikeScanEvent.class, "com.obric.memorydata.plugin");
        if ((r0 - r3.timestamp) > 30000) goto L4;
        if (r3.count <= 3) goto L4;
        boolean r1 = true;
    L11:
        if (r1 == false) goto L27;
        float r4 = this.sharedBikeScoreAdded;
        if (r4 >= 10.0f) goto L28;
        float r5 = 3.0f;
        if ((r4 + 3.0f) <= 10.0f) goto L18;
        r5 = 10.0f - r4;
    L18:
        if (r5 <= 0.0f) goto L29;
        this.confidenceScore += r5;
        this.sharedBikeScoreAdded = r4 + r5;
        a.c("SubwayContext", "[CONFIDENCE_SCORE] " + ("Valid shared bike event in history. Score +" + r5 + ", total: " + this.confidenceScore), r9);
        return;
    L29:
        return;
    L28:
        return;
    L27:
        return;
    L10:
        r1 = false;
        goto L11
    }

    public int getExitAccumulatedSteps() {
        int r0 = this.latestStepCount;
        if (r0 < 0) goto L9;
        int r2 = this.exitScoringStartStepCount;
        if (r2 < 0) goto L9;
        return Math.max(0, r0 - r2);
    L9:
        return 0;
    }

    public String toString() {
        return "SubwayContext{confidenceScore=" + this.confidenceScore + ", curHarStatus=" + this.curHarStatus + ", previousHarStatus=" + this.previousHarStatus + ", isWifiConnected=" + this.isWifiConnected + ", locationState='" + this.locationState + "', lastIndoorCheckTime=" + this.lastIndoorCheckTime + ", lastIndoorCheckPressure=" + this.lastIndoorCheckPressure + ", accumulatedWalkingDurationMs=" + this.accumulatedWalkingDurationMs + ", lastWalkingStartTime=" + this.lastWalkingStartTime + ", consecutiveIndoorCount=" + this.consecutiveIndoorCount + ", consecutiveExitOutdoorCount=" + this.consecutiveExitOutdoorCount + ", continuousPressureStartTime=" + this.continuousPressureStartTime + ", latestPressure=" + this.latestPressure + ", inElevatorPressure=" + this.inElevatorPressure + ", baselinePressure=" + this.baselinePressure + ", baselinePressures=" + this.baselinePressures + ", latestLightLux=" + this.latestLightLux + ", lastHighLightUpdateTime=" + this.lastHighLightUpdateTime + ", recentBikeScanCounts=" + this.recentBikeScanCounts + ", isInSubwayGeofence=" + this.isInSubwayGeofence + ", subwayCellType=" + this.subwayCellType + ", subwayCellId=" + this.subwayCellId + ", subwayPci=" + this.subwayPci + ", subwayTac=" + this.subwayTac + '}';
    }

    public void updateBaselinePressure(File r6) {
        float r1 = 0.0f;
        if (this.latestPressure > 0.0f) goto L6;
        return;
    L6:
        if (this.baselinePressures.size() < 10) goto L8;
        this.baselinePressures.poll();
    L8:
        this.baselinePressures.offer(Float.valueOf(this.latestPressure));
        Iterator<Float> r0 = this.baselinePressures.iterator();
    L10:
        if (r0.hasNext() == false) goto L12;
        r1 = r1 + ((Float) ZeusTransformUtils.preCheckCast(r0.next(), Float.class, "com.obric.memorydata.plugin")).floatValue();
        goto L10
    L12:
        this.baselinePressure = r1 / this.baselinePressures.size();
        a.c("SubwayContext", "baselinePressures: " + this.baselinePressures, r6);
    }
}
