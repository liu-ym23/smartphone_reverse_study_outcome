package com.obric.cae.userAware;

import com.obric.cae.libs.statemachine.d;
import com.obric.cae.log.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class WifiScanSpecDefaults {
    private static final long COMPANY_SCAN_DURATION_MS = 20000;
    private static final long CONNECTED_ACTIVE_SCAN_DURATION_MS = 30000;
    private static final int CONNECTED_DAILY_FULL_SCAN_LIMIT = 2;
    private static final long CONNECTED_ONCE_SCAN_DURATION_MS = 6000;
    private static final long CONNECTED_RECONNECT_FORCE_SCAN_WINDOW_MS = 10000;
    private static final long DISCONNECTED_ACTIVE_SCAN_DURATION_MS = 40000;
    public static final GlobalSpec GLOBAL_DEFAULT = null;
    private static final long HOME_SCAN_DURATION_MS = 60000;
    private static final Map<Integer, SceneSpec> SCENE_DEFAULTS = null;
    private static final long SIMPLE_SCAN_DURATION_MS = 60000;
    private static final long SIMPLE_SCAN_INTERVAL_MS = 2000;

    /* JADX INFO: renamed from: com.obric.cae.userAware.WifiScanSpecDefaults$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class ConnectedActiveSpec {
        public final int dailyFullScanLimit;
        public final Boolean ignoreMovementGate;
        public final long onceScanDurationMs;
        public final long reconnectForceScanWindowMs;
        public final Boolean respectThrottle;
        public final long scanDurationMsCompany;
        public final long scanDurationMsHome;
        public final long scanIntervalMs;

        private ConnectedActiveSpec(Boolean r1, Boolean r2, long r3, long r5, long r7, int r9, long r10, long r12) {
            this.respectThrottle = r1;
            this.ignoreMovementGate = r2;
            this.scanIntervalMs = r3;
            this.scanDurationMsHome = r5;
            this.scanDurationMsCompany = r7;
            this.dailyFullScanLimit = r9;
            this.onceScanDurationMs = r10;
            this.reconnectForceScanWindowMs = r12;
        }

        public /* synthetic */ ConnectedActiveSpec(Boolean r1, Boolean r2, long r3, long r5, long r7, int r9, long r10, long r12, AnonymousClass1 r14) {
            this(r1, r2, r3, r5, r7, r9, r10, r12);
        }
    }

    public static final class ElevatorSpec {
        public final long intervalMs;
        public final int scanTimes;
        public final long totalTimeoutMs;

        private ElevatorSpec(long r1, int r3, long r4) {
            this.intervalMs = r1;
            this.scanTimes = r3;
            this.totalTimeoutMs = r4;
        }

        public /* synthetic */ ElevatorSpec(long r1, int r3, long r4, AnonymousClass1 r6) {
            this(r1, r3, r4);
        }
    }

    public static final class GeoSpec {
        public final long geoDurationMs;
        public final long geoIntervalMs;
        public final long indoorDurationMs;
        public final long wifiDurationMs;

        private GeoSpec(long r1, long r3, long r5, long r7) {
            this.geoIntervalMs = r1;
            this.geoDurationMs = r3;
            this.wifiDurationMs = r5;
            this.indoorDurationMs = r7;
        }

        public /* synthetic */ GeoSpec(long r1, long r3, long r5, long r7, AnonymousClass1 r9) {
            this(r1, r3, r5, r7);
        }
    }

    public static final class GlobalSpec {
        public final long elevatorScanCallMinIntervalMs;
        public final long enterHomeRoomStopConnectedScanDelayMs;
        public final long fencePnoMaxDurationAfterLearningMs;
        public final long fencePnoMaxDurationMs;
        public final long pnoScanIntervalMs;
        public final int pnoScanIterations;
        public final long scanRetryBackoffMs;
        public final long scanRetryNoSuchDeviceBackoffMs;
        public final long scanTimeoutMs;
        public final long throttleLevel1IntervalMs;
        public final long throttleLevel2IntervalMs;
        public final long throttleLevel3IntervalMs;

        public GlobalSpec(long r4, long r6, long r8, long r10, long r12, long r14, long r16, long r18, int r20, long r21, long r23, long r25) {
            this.throttleLevel1IntervalMs = r4;
            this.throttleLevel2IntervalMs = r6;
            this.throttleLevel3IntervalMs = r8;
            this.fencePnoMaxDurationMs = r10;
            this.fencePnoMaxDurationAfterLearningMs = r12;
            this.scanTimeoutMs = r14;
            this.scanRetryBackoffMs = r16;
            this.scanRetryNoSuchDeviceBackoffMs = r18;
            this.pnoScanIterations = r20;
            this.pnoScanIntervalMs = r21;
            this.elevatorScanCallMinIntervalMs = r23;
            this.enterHomeRoomStopConnectedScanDelayMs = r25;
        }
    }

    public static final class HomeCompanySpec {
        public final Boolean ignoreMovementGate;
        public final Boolean respectThrottle;
        public final long scanDurationMsCompany;
        public final long scanDurationMsHome;
        public final long scanIntervalMs;

        private HomeCompanySpec(Boolean r1, Boolean r2, long r3, long r5, long r7) {
            this.respectThrottle = r1;
            this.ignoreMovementGate = r2;
            this.scanIntervalMs = r3;
            this.scanDurationMsHome = r5;
            this.scanDurationMsCompany = r7;
        }

        public /* synthetic */ HomeCompanySpec(Boolean r1, Boolean r2, long r3, long r5, long r7, AnonymousClass1 r9) {
            this(r1, r2, r3, r5, r7);
        }
    }

    public static final class RssiTriggerSpec {
        public final int fixedWindowSec;
        public final Boolean ignoreMovementGate;
        public final Boolean respectThrottle;
        public final long scanIntervalMs;
        public final int thresholdDb;

        private RssiTriggerSpec(Boolean r1, Boolean r2, long r3, int r5, int r6) {
            this.respectThrottle = r1;
            this.ignoreMovementGate = r2;
            this.scanIntervalMs = r3;
            this.fixedWindowSec = r5;
            this.thresholdDb = r6;
        }

        public /* synthetic */ RssiTriggerSpec(Boolean r1, Boolean r2, long r3, int r5, int r6, AnonymousClass1 r7) {
            this(r1, r2, r3, r5, r6);
        }
    }

    public static final class SceneSpec {
        public final ConnectedActiveSpec connectedActive;
        public final ElevatorSpec elevator;
        public final Boolean enabled;
        public final GeoSpec geo;
        public final HomeCompanySpec homeCompany;
        public final RssiTriggerSpec rssiTrigger;
        public final SimpleScanSpec simpleScan;

        private SceneSpec(Boolean r1, HomeCompanySpec r2, ConnectedActiveSpec r3, RssiTriggerSpec r4, SimpleScanSpec r5, ElevatorSpec r6, GeoSpec r7) {
            this.enabled = r1;
            this.homeCompany = r2;
            this.connectedActive = r3;
            this.rssiTrigger = r4;
            this.simpleScan = r5;
            this.elevator = r6;
            this.geo = r7;
        }

        public static SceneSpec connectedActive(Boolean r17, Boolean r18, Boolean r19, long r20, long r22, long r24, int r26, long r27, long r29) {
            return new SceneSpec(r17, null, new ConnectedActiveSpec(r18, r19, r20, r22, r24, r26, r27, r29, null), null, null, null, null);
        }

        public static SceneSpec elevator(Boolean r9, long r10, int r12, long r13) {
            return new SceneSpec(r9, null, null, null, null, new ElevatorSpec(r10, r12, r13, null), null);
        }

        public static SceneSpec empty() {
            return new SceneSpec(null, null, null, null, null, null, null);
        }

        public static SceneSpec geo(long r12, long r14, long r16, long r18) {
            return new SceneSpec(null, null, null, null, null, null, new GeoSpec(r12, r14, r16, r18, null));
        }

        public static SceneSpec homeCompany(Boolean r12, Boolean r13, Boolean r14, long r15, long r17, long r19) {
            return new SceneSpec(r12, new HomeCompanySpec(r13, r14, r15, r17, r19, null), null, null, null, null, null);
        }

        public static SceneSpec rssiTrigger(Boolean r10, Boolean r11, Boolean r12, long r13, int r15, int r16) {
            return new SceneSpec(r10, null, null, new RssiTriggerSpec(r11, r12, r13, r15, r16, null), null, null, null);
        }

        public static SceneSpec simpleScan(Boolean r9, long r10, long r12) {
            return new SceneSpec(r9, null, null, null, new SimpleScanSpec(r10, r12, null), null, null);
        }
    }

    public static final class SimpleScanSpec {
        public final long durationMs;
        public final long intervalMs;

        private SimpleScanSpec(long r1, long r3) {
            this.intervalMs = r1;
            this.durationMs = r3;
        }

        public /* synthetic */ SimpleScanSpec(long r1, long r3, AnonymousClass1 r5) {
            this(r1, r3);
        }
    }

    static {
        GLOBAL_DEFAULT = new GlobalSpec(2000, WifiScanStateMachine.SCAN_INTERVAL_WITH_THROTTLE_LEVEL_2_MS, 6000, 900000, 900000, 3500, 1000, 3000, 1, 5000, 3000, 5000);
        HashMap r0 = new HashMap();
        Boolean r4 = Boolean.FALSE;
        Boolean r13 = Boolean.TRUE;
        r0.put(3, SceneSpec.homeCompany(r4, r13, r4, 2000, 60000, 20000));
        r0.put(4, homeCompanyCycle(2000, DISCONNECTED_ACTIVE_SCAN_DURATION_MS, DISCONNECTED_ACTIVE_SCAN_DURATION_MS, r13, r13));
        r0.put(5, connectedActiveDefaults());
        r0.put(6, rssiFluctuation(2, 9, 2000));
        r0.put(7, rssiFluctuation(10, 10, 2000));
        r0.put(8, rssiFluctuation(5, 17, 2000));
        r0.put(101, SceneSpec.simpleScan(r13, 2000, 60000));
        r0.put(301, SceneSpec.simpleScan(r13, 2000, 60000));
        r0.put(201, elevator(true));
        r0.put(202, elevator(false));
        r0.put(401, geoNormalOrTraining(false));
        r0.put(402, geoNormalOrTraining(true));
        SCENE_DEFAULTS = Collections.unmodifiableMap(r0);
    }

    private WifiScanSpecDefaults() {
    }

    private static SceneSpec connectedActiveDefaults() {
        Boolean r1 = Boolean.TRUE;
        return SceneSpec.connectedActive(r1, r1, null, 2000, CONNECTED_ACTIVE_SCAN_DURATION_MS, CONNECTED_ACTIVE_SCAN_DURATION_MS, 2, 6000, 10000);
    }

    private static SceneSpec elevator(boolean r6) {
        Boolean r0 = Boolean.TRUE;
        if (r6 == false) goto L5;
        long r1 = 1500;
        int r3 = 3;
        long r4 = 6000;
    L7:
        return SceneSpec.elevator(r0, r1, r3, r4);
    L5:
        r1 = 2000;
        r3 = 1;
        r4 = 2000;
        goto L7
    }

    private static SceneSpec geoNormalOrTraining(boolean r10) {
        if (r10 == false) goto L4;
        long r0 = 2000;
    L5:
        long r2 = r0;
        long r1 = 600000;
        if (r10 == false) goto L8;
        long r4 = WifiScanStateMachine.DEFAULT_GEO_SCANNING_DURATION_TRAINING;
    L9:
        if (r10 == true) goto L12;
        r1 = 300000;
    L12:
        long r6 = r1;
        if (r10 == false) goto L15;
        long r3 = 120000;
    L17:
        return SceneSpec.geo(r2, r4, r6, r3);
    L15:
        r3 = 20000;
        goto L17
    L8:
        r4 = 600000;
        goto L9
    L4:
        r0 = 5000;
        goto L5
    }

    public static GlobalSpec getDefaultGlobalSpec() {
        return GLOBAL_DEFAULT;
    }

    public static SceneSpec getDefaultSceneSpec(int r3) {
        SceneSpec r0 = (SceneSpec) ZeusTransformUtils.preCheckCast(SCENE_DEFAULTS.get(Integer.valueOf(r3)), SceneSpec.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        a.g("CaeScanCfgDefaults", d.a("getDefaultSceneSpec: no default for sceneId=", r3, " (").append(WifiScanSceneType.sceneNameOf(r3)).append("), returning empty spec.").toString());
        return SceneSpec.empty();
    L6:
        return r0;
    }

    private static SceneSpec homeCompanyCycle(long r9, long r11, long r13, Boolean r15, Boolean r16) {
        return SceneSpec.homeCompany(Boolean.TRUE, r15, r16, r9, r11, r13);
    }

    private static SceneSpec rssiFluctuation(int r7, int r8, long r9) {
        Boolean r1 = Boolean.TRUE;
        return SceneSpec.rssiTrigger(r1, r1, Boolean.FALSE, r9, r7, r8);
    }
}
