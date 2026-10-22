package com.obric.cae.userAware;

import android.content.Context;
import android.content.SharedPreferences;
import com.obric.cae.libs.statemachine.d;
import com.obric.cae.libs.useraware.RssiDropThreshold;
import com.obric.cae.log.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class WifiScanConfigProvider {
    private static final SceneSchema CONNECTED_ACTIVE_SCHEMA = null;
    private static final SceneSchema ELEVATOR_SCHEMA = null;
    private static final SceneSchema EMPTY_SCHEMA = null;
    private static final SceneSchema GEO_SCHEMA = null;
    private static final Set<String> GLOBAL_KEYS = null;
    private static final SceneSchema HOME_COMPANY_SCHEMA = null;
    private static final String KEY_SCAN_SPEC_CONFIG = "scan_spec_config";
    private static final String PREF_FILE = "cae_user_aware_scan_config";
    private static final SceneSchema RSSI_TRIGGER_SCHEMA = null;
    private static final String[] SCENE_BOOLEAN_KEYS = null;
    private static final IntRangeKey[] SCENE_INT_KEYS = null;
    private static final String[] SCENE_LONG_KEYS = null;
    private static final SceneSchema SIMPLE_SCAN_SCHEMA = null;
    private static final String TAG = "CaeScanCfg";
    private static final SceneSchema WIFI_FENCE_SCHEMA = null;
    private static volatile WifiScanConfigProvider sInstance;
    private volatile String mActiveJsonString;
    private volatile ActiveConfigSnapshot mActiveSnapshot;
    private final Context mAppContext;
    private final SharedPreferences.OnSharedPreferenceChangeListener mPreferenceChangeListener;
    private final SharedPreferences mSp;
    private final List<ScanSpecUpdateListener> mUpdateListeners;

    public static final class ActiveConfigSnapshot {
        private final Context mAppContext;
        private final WifiScanSpecDefaults.GlobalSpec mGlobalSpec;
        private final JSONObject mRoot;
        private final Map<Integer, WifiScanSpecDefaults.SceneSpec> mSceneSpecCache;

        private ActiveConfigSnapshot(Context r3, JSONObject r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            this.mSceneSpecCache = new HashMap();
            this.mAppContext = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
            this.mRoot = r4;
            this.mGlobalSpec = parseSnapshotGlobalSpec(r4);
        }

        public /* synthetic */ ActiveConfigSnapshot(Context r2, JSONObject r3, AnonymousClass1 r4) {
            this((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3);
        }

        private boolean hasSceneField(int r2, String r3) {
            JSONObject r1 = this.mRoot.optJSONObject("scenes");
            if (r1 != null) goto L5;
            return false;
        L5:
            String r4 = WifiScanSceneType.sceneNameOf(r2);
            if (r4 != null) goto L8;
            return false;
        L8:
            JSONObject r5 = r1.optJSONObject(r4);
            if (r5 != null) goto L11;
            return false;
        L11:
            if (r5.has(r3) == false) goto L15;
            return true;
        L15:
            return false;
        }

        private static WifiScanSpecDefaults.GlobalSpec parseSnapshotGlobalSpec(JSONObject r3) {
            WifiScanSpecDefaults.GlobalSpec r0 = WifiScanSpecDefaults.getDefaultGlobalSpec();
            JSONObject r4 = r3.optJSONObject("global");
            if (r4 != null) goto L10;
            return r0;
        L10:
            return WifiScanConfigProvider.access$1700(r4, r0);
        L7:
            e = move-exception;
            a.i(WifiScanConfigProvider.TAG, "parseSnapshotGlobalSpec failed: " + e + ". Falling back to SpecDefaults entirely.");
            return r0;
        }

        private static WifiScanSpecDefaults.SceneSpec parseSnapshotSceneSpec(int r3, JSONObject r4) {
            WifiScanSpecDefaults.SceneSpec r0 = WifiScanSpecDefaults.getDefaultSceneSpec(r3);
            JSONObject r5 = r4.optJSONObject("scenes");     // Catch: JSONException -> L17
            if (r5 != null) goto L6;
            return r0;
        L6:
            String r1 = WifiScanSceneType.sceneNameOf(r3);     // Catch: JSONException -> L17
            if (r1 != null) goto L9;
        L16:
            return r0;
        L9:
            if (r5.has(r1) == false) goto L16;
            JSONObject r6 = r5.optJSONObject(r1);     // Catch: JSONException -> L17
            if (r6 != null) goto L14;
            return r0;
        L14:
            return WifiScanConfigProvider.access$1800(r3, r6, r0);
        L17:
            e = move-exception;
            a.i(WifiScanConfigProvider.TAG, d.a("parseSnapshotSceneSpec(", r3, "/").append(WifiScanSceneType.sceneNameOf(r3)).append(") failed: ").append(e).append(". Falling back to SpecDefaults entirely.").toString());
            return r0;
        }

        public List<Integer> getAllConfiguredSceneIds() {
            JSONObject r4 = this.mRoot.optJSONObject("scenes");
            if (r4 == null) goto L5;
            ArrayList r0 = new ArrayList();
            Iterator<String> r5 = r4.keys();
        L8:
            if (r5.hasNext() == false) goto L12;
            int r1 = WifiScanSceneType.sceneIdOf((String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin"));
            if (r1 == (-1)) goto L8;
            r0.add(Integer.valueOf(r1));
            goto L8
        L12:
            return r0;
        L5:
            return Collections.emptyList();
        }

        public long getConfiguredSceneDurationMsOrDefault(int r2, long r3) {
            if (hasSceneField(r2, "duration_ms") == true) goto L6;
            return r3;
        L6:
            return WifiScanConfigProvider.access$400(WifiScanConfigProvider.access$500(getSceneSpec(r2)), r3);
        }

        public long getConfiguredSceneIntervalMsOrDefault(int r2, long r3) {
            if (hasSceneField(r2, "interval_ms") == true) goto L8;
            if (hasSceneField(r2, "scan_interval_ms") == true) goto L8;
            return r3;
        L8:
            return WifiScanConfigProvider.access$400(WifiScanConfigProvider.access$300(getSceneSpec(r2)), r3);
        }

        public long getConfiguredSceneTotalTimeoutMsOrDefault(int r2, long r3) {
            if (hasSceneField(r2, "total_timeout_ms") == true) goto L6;
            return r3;
        L6:
            return WifiScanConfigProvider.access$400(WifiScanConfigProvider.access$800(getSceneSpec(r2)), r3);
        }

        public int getConnectedDailyFullScanLimit() {
            WifiScanSpecDefaults.SceneSpec r1 = getSceneSpec(5);
            WifiScanSpecDefaults.SceneSpec r0 = WifiScanSpecDefaults.getDefaultSceneSpec(5);
            return WifiScanConfigProvider.access$700(WifiScanConfigProvider.access$1000(r1), WifiScanConfigProvider.access$1000(r0));
        }

        public long getConnectedOnceScanDurationMs() {
            WifiScanSpecDefaults.SceneSpec r5 = getSceneSpec(5);
            WifiScanSpecDefaults.SceneSpec r0 = WifiScanSpecDefaults.getDefaultSceneSpec(5);
            return WifiScanConfigProvider.access$400(WifiScanConfigProvider.access$1100(r5), WifiScanConfigProvider.access$1100(r0));
        }

        public long getConnectedReconnectWindowMs() {
            WifiScanSpecDefaults.SceneSpec r5 = getSceneSpec(5);
            WifiScanSpecDefaults.SceneSpec r0 = WifiScanSpecDefaults.getDefaultSceneSpec(5);
            return WifiScanConfigProvider.access$400(WifiScanConfigProvider.access$1200(r5), WifiScanConfigProvider.access$1200(r0));
        }

        public long getEffectiveIntervalMs(int r2) {
            return resolveEffectiveInterval(r2, getSceneSpec(r2));
        }

        public long getElevatorScanCallMinIntervalMs() {
            WifiScanSpecDefaults.GlobalSpec r0 = WifiScanSpecDefaults.getDefaultGlobalSpec();
            return WifiScanConfigProvider.access$400(this.mGlobalSpec.elevatorScanCallMinIntervalMs, r0.elevatorScanCallMinIntervalMs);
        }

        public long getEnterHomeRoomStopConnectedScanDelayMs() {
            WifiScanSpecDefaults.GlobalSpec r0 = WifiScanSpecDefaults.getDefaultGlobalSpec();
            return WifiScanConfigProvider.access$400(this.mGlobalSpec.enterHomeRoomStopConnectedScanDelayMs, r0.enterHomeRoomStopConnectedScanDelayMs);
        }

        public long getFencePnoMaxDurationMs(boolean r3) {
            WifiScanSpecDefaults.GlobalSpec r0 = WifiScanSpecDefaults.getDefaultGlobalSpec();
            WifiScanSpecDefaults.GlobalSpec r2 = this.mGlobalSpec;
            if (r3 == false) goto L7;
            long r4 = r2.fencePnoMaxDurationAfterLearningMs;
            long r1 = r0.fencePnoMaxDurationAfterLearningMs;
        L6:
            return WifiScanConfigProvider.access$400(r4, r1);
        L7:
            r4 = r2.fencePnoMaxDurationMs;
            r1 = r0.fencePnoMaxDurationMs;
            goto L6
        }

        public long getGeoDurationMs(int r1, long r2) {
            return WifiScanConfigProvider.access$400(WifiScanConfigProvider.access$1400(getSceneSpec(r1)), r2);
        }

        public long getGeoIntervalMs(int r1, long r2) {
            return WifiScanConfigProvider.access$400(WifiScanConfigProvider.access$1300(getSceneSpec(r1)), r2);
        }

        public WifiScanSpecDefaults.GlobalSpec getGlobalSpec() {
            return this.mGlobalSpec;
        }

        public long getHomeCompanyScanDurationMs(int r3, boolean r4) {
            WifiScanSpecDefaults.SceneSpec r2 = getSceneSpec(r3);
            WifiScanSpecDefaults.SceneSpec r5 = WifiScanSpecDefaults.getDefaultSceneSpec(r3);
            return WifiScanConfigProvider.access$400(WifiScanConfigProvider.access$900(r2, r4), WifiScanConfigProvider.access$900(r5, r4));
        }

        public long getIndoorDurationMs(int r1, long r2) {
            return WifiScanConfigProvider.access$400(WifiScanConfigProvider.access$1600(getSceneSpec(r1)), r2);
        }

        public int getPnoScanIntervalMs() {
            WifiScanSpecDefaults.GlobalSpec r0 = WifiScanSpecDefaults.getDefaultGlobalSpec();
            long r1 = WifiScanConfigProvider.access$400(this.mGlobalSpec.pnoScanIntervalMs, r0.pnoScanIntervalMs);
            if (r1 > 2147483647L) goto L6;
            return (int) r1;
        L6:
            return (int) r0.pnoScanIntervalMs;
        }

        public int getPnoScanIterations() {
            WifiScanSpecDefaults.GlobalSpec r0 = WifiScanSpecDefaults.getDefaultGlobalSpec();
            return WifiScanConfigProvider.access$700(this.mGlobalSpec.pnoScanIterations, r0.pnoScanIterations);
        }

        public List<RssiDropThreshold> getRssiDropThresholds() {
            ArrayList r0 = new ArrayList(3);
            int[] r1 = WifiScanSceneType.RSSI_FLUCTUATION_SCENE_IDS;
            int r2 = r1.length;
            int r3 = 0;
        L3:
            if (r3 >= r2) goto L12;
            WifiScanSpecDefaults.RssiTriggerSpec r4 = getSceneSpec(r1[r3]).rssiTrigger;
            if (r4 == null) goto L11;
            if (r4.fixedWindowSec <= 0) goto L11;
            if (r4.thresholdDb <= 0) goto L11;
            r0.add(new RssiDropThreshold(r4.fixedWindowSec, r4.thresholdDb));
        L11:
            r3 = r3 + 1;
            goto L3
        L12:
            return r0;
        }

        public long getScanRetryBackoffMs() {
            WifiScanSpecDefaults.GlobalSpec r0 = WifiScanSpecDefaults.getDefaultGlobalSpec();
            return WifiScanConfigProvider.access$400(this.mGlobalSpec.scanRetryBackoffMs, r0.scanRetryBackoffMs);
        }

        public long getScanRetryNoSuchDeviceBackoffMs() {
            WifiScanSpecDefaults.GlobalSpec r0 = WifiScanSpecDefaults.getDefaultGlobalSpec();
            return WifiScanConfigProvider.access$400(this.mGlobalSpec.scanRetryNoSuchDeviceBackoffMs, r0.scanRetryNoSuchDeviceBackoffMs);
        }

        public long getScanTimeoutMs() {
            WifiScanSpecDefaults.GlobalSpec r0 = WifiScanSpecDefaults.getDefaultGlobalSpec();
            return WifiScanConfigProvider.access$400(this.mGlobalSpec.scanTimeoutMs, r0.scanTimeoutMs);
        }

        public long getSceneDurationMs(int r3) {
            WifiScanSpecDefaults.SceneSpec r2 = getSceneSpec(r3);
            WifiScanSpecDefaults.SceneSpec r4 = WifiScanSpecDefaults.getDefaultSceneSpec(r3);
            return WifiScanConfigProvider.access$400(WifiScanConfigProvider.access$500(r2), WifiScanConfigProvider.access$500(r4));
        }

        public long getSceneIntervalMs(int r3) {
            WifiScanSpecDefaults.SceneSpec r2 = getSceneSpec(r3);
            WifiScanSpecDefaults.SceneSpec r4 = WifiScanSpecDefaults.getDefaultSceneSpec(r3);
            return WifiScanConfigProvider.access$400(WifiScanConfigProvider.access$300(r2), WifiScanConfigProvider.access$300(r4));
        }

        public int getSceneScanTimes(int r1) {
            WifiScanSpecDefaults.SceneSpec r0 = getSceneSpec(r1);
            WifiScanSpecDefaults.SceneSpec r2 = WifiScanSpecDefaults.getDefaultSceneSpec(r1);
            return WifiScanConfigProvider.access$700(WifiScanConfigProvider.access$600(r0), WifiScanConfigProvider.access$600(r2));
        }

        public WifiScanSpecDefaults.SceneSpec getSceneSpec(int r5) {
            Map<Integer, WifiScanSpecDefaults.SceneSpec> r0 = this.mSceneSpecCache;
            monitor-enter(r0);
            WifiScanSpecDefaults.SceneSpec r1 = (WifiScanSpecDefaults.SceneSpec) ZeusTransformUtils.preCheckCast(this.mSceneSpecCache.get(Integer.valueOf(r5)), WifiScanSpecDefaults.SceneSpec.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
            if (r1 == null) goto L8;
            monitor-exit(r0);     // Catch: Throwable -> L11
            return r1;
        L8:
            WifiScanSpecDefaults.SceneSpec r2 = parseSnapshotSceneSpec(r5, this.mRoot);     // Catch: Throwable -> L11
            this.mSceneSpecCache.put(Integer.valueOf(r5), r2);     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return r2;
        L11:
            th = move-exception;
            throw th;
        }

        public long getSceneTotalTimeoutMs(int r3) {
            WifiScanSpecDefaults.SceneSpec r2 = getSceneSpec(r3);
            WifiScanSpecDefaults.SceneSpec r4 = WifiScanSpecDefaults.getDefaultSceneSpec(r3);
            return WifiScanConfigProvider.access$400(WifiScanConfigProvider.access$800(r2), WifiScanConfigProvider.access$800(r4));
        }

        public long getWifiDurationMs(int r1, long r2) {
            return WifiScanConfigProvider.access$400(WifiScanConfigProvider.access$1500(getSceneSpec(r1)), r2);
        }

        public boolean isSceneEnabled(int r1) {
            return !Boolean.FALSE.equals(getSceneSpec(r1).enabled);
        }

        public long resolveEffectiveInterval(int r2, WifiScanSpecDefaults.SceneSpec r3) {
            return WifiScanConfigProvider.access$200(r2, r3, this.mAppContext, this.mGlobalSpec);
        }

        public boolean shouldIgnoreMovementGate(int r1, boolean r2) {
            Boolean r0 = WifiScanConfigProvider.access$100(getSceneSpec(r1));
            if (r0 != null) goto L6;
            return r2;
        L6:
            return r0.booleanValue();
        }
    }

    public static final class IntRangeKey {
        final int max;
        final int min;
        final String name;

        public IntRangeKey(String r1, int r2, int r3) {
            this.name = r1;
            this.min = r2;
            this.max = r3;
        }
    }

    public static final class Keys {
        static final String TOP_GLOBAL = "global";
        static final String TOP_SCENES = "scenes";
        static final String TOP_VERSION = "version";

        public static final class GlobalKey {
            static final String ELEVATOR_SCAN_CALL_MIN_INTERVAL_MS = "elevator_scan_call_min_interval_ms";
            static final String ENTER_HOME_ROOM_STOP_CONNECTED_SCAN_DELAY_MS = "enter_home_room_stop_connected_scan_delay_ms";
            static final String FENCE_PNO_MAX_DURATION_AFTER_LEARNING_MS = "fence_pno_max_duration_after_learning_ms";
            static final String FENCE_PNO_MAX_DURATION_MS = "fence_pno_max_duration_ms";
            static final String PNO_SCAN_INTERVAL_MS = "pno_scan_interval_ms";
            static final String PNO_SCAN_ITERATIONS = "pno_scan_iterations";
            static final String SCAN_RETRY_BACKOFF_MS = "scan_retry_backoff_ms";
            static final String SCAN_RETRY_NO_SUCH_DEVICE_BACKOFF_MS = "scan_retry_no_such_device_backoff_ms";
            static final String SCAN_TIMEOUT_MS = "scan_timeout_ms";
            static final String THROTTLE_LEVEL_1_INTERVAL_MS = "throttle_level_1_interval_ms";
            static final String THROTTLE_LEVEL_2_INTERVAL_MS = "throttle_level_2_interval_ms";
            static final String THROTTLE_LEVEL_3_INTERVAL_MS = "throttle_level_3_interval_ms";

            public GlobalKey() {
            }
        }

        public static final class SceneKey {
            static final String DAILY_FULL_SCAN_LIMIT = "daily_full_scan_limit";
            static final String DURATION_MS = "duration_ms";
            static final String ENABLED = "enabled";
            static final String GEO_DURATION_MS = "geo_duration_ms";
            static final String GEO_INTERVAL_MS = "geo_interval_ms";
            static final String IGNORE_MOVEMENT_GATE = "ignore_movement_gate";
            static final String INDOOR_DURATION_MS = "indoor_duration_ms";
            static final String INTERVAL_MS = "interval_ms";
            static final String ONCE_SCAN_DURATION_MS = "once_scan_duration_ms";
            static final String RECONNECT_FORCE_SCAN_WINDOW_MS = "reconnect_force_scan_window_ms";
            static final String RESPECT_THROTTLE = "respect_throttle";
            static final String SCAN_DURATION_MS_COMPANY = "scan_duration_ms_company";
            static final String SCAN_DURATION_MS_HOME = "scan_duration_ms_home";
            static final String SCAN_INTERVAL_MS = "scan_interval_ms";
            static final String SCAN_TIMES = "scan_times";
            static final String THRESHOLD_DB = "threshold_db";
            static final String TOTAL_TIMEOUT_MS = "total_timeout_ms";
            static final String WIFI_DURATION_MS = "wifi_duration_ms";

            public SceneKey() {
            }
        }

        public Keys() {
        }
    }

    public interface ScanSpecUpdateListener {
        void onScanSpecUpdated(ActiveConfigSnapshot r1);
    }

    public static final class SceneSchema {
        final Set<String> keys;
        final boolean rssiTrigger;

        public SceneSchema(boolean r3, Set<String> r4) {
            Set<String> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
            this.rssiTrigger = r3;
            this.keys = r5;
        }
    }

    static {
        GLOBAL_KEYS = createKeySet(new String[]{"throttle_level_1_interval_ms", "throttle_level_2_interval_ms", "throttle_level_3_interval_ms", "fence_pno_max_duration_ms", "fence_pno_max_duration_after_learning_ms", "scan_timeout_ms", "scan_retry_backoff_ms", "scan_retry_no_such_device_backoff_ms", "pno_scan_iterations", "pno_scan_interval_ms", "elevator_scan_call_min_interval_ms", "enter_home_room_stop_connected_scan_delay_ms"});
        SCENE_BOOLEAN_KEYS = new String[]{"enabled", "respect_throttle", "ignore_movement_gate"};
        SCENE_LONG_KEYS = new String[]{"scan_interval_ms", "scan_duration_ms_home", "scan_duration_ms_company", "once_scan_duration_ms", "reconnect_force_scan_window_ms", "interval_ms", "duration_ms", "total_timeout_ms", "geo_interval_ms", "geo_duration_ms", "wifi_duration_ms", "indoor_duration_ms"};
        SCENE_INT_KEYS = new IntRangeKey[]{new IntRangeKey("daily_full_scan_limit", 1, 1000000), new IntRangeKey("scan_times", 1, 1000)};
        HOME_COMPANY_SCHEMA = sceneSchema(false, new String[]{"enabled", "respect_throttle", "ignore_movement_gate", "scan_interval_ms", "scan_duration_ms_home", "scan_duration_ms_company"});
        WIFI_FENCE_SCHEMA = sceneSchema(false, new String[]{"enabled", "respect_throttle", "ignore_movement_gate", "scan_interval_ms"});
        CONNECTED_ACTIVE_SCHEMA = sceneSchema(false, new String[]{"enabled", "respect_throttle", "ignore_movement_gate", "scan_interval_ms", "scan_duration_ms_home", "scan_duration_ms_company", "daily_full_scan_limit", "once_scan_duration_ms", "reconnect_force_scan_window_ms"});
        RSSI_TRIGGER_SCHEMA = sceneSchema(true, new String[]{"enabled", "respect_throttle", "ignore_movement_gate", "scan_interval_ms", "threshold_db"});
        SIMPLE_SCAN_SCHEMA = sceneSchema(false, new String[]{"enabled", "interval_ms", "duration_ms"});
        ELEVATOR_SCHEMA = sceneSchema(false, new String[]{"enabled", "interval_ms", "scan_times", "total_timeout_ms"});
        GEO_SCHEMA = sceneSchema(false, new String[]{"geo_interval_ms", "geo_duration_ms", "wifi_duration_ms", "indoor_duration_ms"});
        EMPTY_SCHEMA = sceneSchema(false, new String[0]);
    }

    public WifiScanConfigProvider(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        this.mUpdateListeners = new CopyOnWriteArrayList();
        SharedPreferences.OnSharedPreferenceChangeListener r0 = new AnonymousClass1(this);
        this.mPreferenceChangeListener = r0;
        this.mActiveJsonString = "{}";
        if (r6 == null) goto L16;
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L7;
        r6 = r1;
    L7:
        this.mAppContext = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
        SharedPreferences r7 = r6.getSharedPreferences(PREF_FILE, 0);
        this.mSp = r7;
        refreshActiveConfigFromPreferences(false);
        r7.registerOnSharedPreferenceChangeListener(r0);
        monitor-enter(WifiScanConfigProvider.class);
        sInstance = this;     // Catch: Throwable -> L12
        monitor-exit(WifiScanConfigProvider.class);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    L16:
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static /* synthetic */ ActiveConfigSnapshot access$000(WifiScanConfigProvider r0, boolean r1) {
        return r0.refreshActiveConfigFromPreferences(r1);
    }

    public static /* synthetic */ Boolean access$100(WifiScanSpecDefaults.SceneSpec r0) {
        return ignoreMovementGate(r0);
    }

    public static /* synthetic */ int access$1000(WifiScanSpecDefaults.SceneSpec r0) {
        return connectedDailyFullScanLimit(r0);
    }

    public static /* synthetic */ long access$1100(WifiScanSpecDefaults.SceneSpec r2) {
        return connectedOnceScanDurationMs(r2);
    }

    public static /* synthetic */ long access$1200(WifiScanSpecDefaults.SceneSpec r2) {
        return connectedReconnectWindowMs(r2);
    }

    public static /* synthetic */ long access$1300(WifiScanSpecDefaults.SceneSpec r2) {
        return geoIntervalMs(r2);
    }

    public static /* synthetic */ long access$1400(WifiScanSpecDefaults.SceneSpec r2) {
        return geoDurationMs(r2);
    }

    public static /* synthetic */ long access$1500(WifiScanSpecDefaults.SceneSpec r2) {
        return wifiDurationMs(r2);
    }

    public static /* synthetic */ long access$1600(WifiScanSpecDefaults.SceneSpec r2) {
        return indoorDurationMs(r2);
    }

    public static /* synthetic */ WifiScanSpecDefaults.GlobalSpec access$1700(JSONObject r0, WifiScanSpecDefaults.GlobalSpec r1) {
        return parseGlobalSpecFromJson(r0, r1);
    }

    public static /* synthetic */ WifiScanSpecDefaults.SceneSpec access$1800(int r0, JSONObject r1, WifiScanSpecDefaults.SceneSpec r2) {
        return parseSceneSpecFromJson(r0, r1, r2);
    }

    public static /* synthetic */ long access$200(int r2, WifiScanSpecDefaults.SceneSpec r3, Context r4, WifiScanSpecDefaults.GlobalSpec r5) {
        return resolveEffectiveInterval(r2, r3, (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), r5);
    }

    public static /* synthetic */ long access$300(WifiScanSpecDefaults.SceneSpec r2) {
        return genericScanIntervalMs(r2);
    }

    public static /* synthetic */ long access$400(long r0, long r2) {
        return positiveOrDefault(r0, r2);
    }

    public static /* synthetic */ long access$500(WifiScanSpecDefaults.SceneSpec r2) {
        return simpleDurationMs(r2);
    }

    public static /* synthetic */ int access$600(WifiScanSpecDefaults.SceneSpec r0) {
        return elevatorScanTimes(r0);
    }

    public static /* synthetic */ int access$700(int r0, int r1) {
        return positiveOrDefault(r0, r1);
    }

    public static /* synthetic */ long access$800(WifiScanSpecDefaults.SceneSpec r2) {
        return elevatorTotalTimeoutMs(r2);
    }

    public static /* synthetic */ long access$900(WifiScanSpecDefaults.SceneSpec r0, boolean r1) {
        return homeCompanyScanDurationMs(r0, r1);
    }

    private static int connectedDailyFullScanLimit(WifiScanSpecDefaults.SceneSpec r0) {
        if (r0 == null) goto L7;
        WifiScanSpecDefaults.ConnectedActiveSpec r1 = r0.connectedActive;
        if (r1 == null) goto L7;
        return r1.dailyFullScanLimit;
    L7:
        return 0;
    }

    private static long connectedOnceScanDurationMs(WifiScanSpecDefaults.SceneSpec r2) {
        if (r2 == null) goto L7;
        WifiScanSpecDefaults.ConnectedActiveSpec r3 = r2.connectedActive;
        if (r3 == null) goto L7;
        return r3.onceScanDurationMs;
    L7:
        return 0;
    }

    private static long connectedReconnectWindowMs(WifiScanSpecDefaults.SceneSpec r2) {
        if (r2 == null) goto L7;
        WifiScanSpecDefaults.ConnectedActiveSpec r3 = r2.connectedActive;
        if (r3 == null) goto L7;
        return r3.reconnectForceScanWindowMs;
    L7:
        return 0;
    }

    private static Set<String> createKeySet(String... r1) {
        HashSet r0 = new HashSet();
        Collections.addAll(r0, r1);
        return Collections.unmodifiableSet(r0);
    }

    private static long elevatorIntervalMs(WifiScanSpecDefaults.SceneSpec r2) {
        if (r2 == null) goto L7;
        WifiScanSpecDefaults.ElevatorSpec r3 = r2.elevator;
        if (r3 == null) goto L7;
        return r3.intervalMs;
    L7:
        return 0;
    }

    private static int elevatorScanTimes(WifiScanSpecDefaults.SceneSpec r0) {
        if (r0 == null) goto L7;
        WifiScanSpecDefaults.ElevatorSpec r1 = r0.elevator;
        if (r1 == null) goto L7;
        return r1.scanTimes;
    L7:
        return 0;
    }

    private static long elevatorTotalTimeoutMs(WifiScanSpecDefaults.SceneSpec r2) {
        if (r2 == null) goto L7;
        WifiScanSpecDefaults.ElevatorSpec r3 = r2.elevator;
        if (r3 == null) goto L7;
        return r3.totalTimeoutMs;
    L7:
        return 0;
    }

    private static long genericScanIntervalMs(WifiScanSpecDefaults.SceneSpec r5) {
        if (r5 != null) goto L5;
        return 0;
    L5:
        long r2 = homeCompanyIntervalMs(r5);
        if (r2 <= 0) goto L8;
        return r2;
    L8:
        long r3 = simpleIntervalMs(r5);
        if (r3 <= 0) goto L12;
        return r3;
    L12:
        return elevatorIntervalMs(r5);
    }

    private static long geoDurationMs(WifiScanSpecDefaults.SceneSpec r2) {
        if (r2 == null) goto L7;
        WifiScanSpecDefaults.GeoSpec r3 = r2.geo;
        if (r3 == null) goto L7;
        return r3.geoDurationMs;
    L7:
        return 0;
    }

    private static long geoIntervalMs(WifiScanSpecDefaults.SceneSpec r2) {
        if (r2 == null) goto L7;
        WifiScanSpecDefaults.GeoSpec r3 = r2.geo;
        if (r3 == null) goto L7;
        return r3.geoIntervalMs;
    L7:
        return 0;
    }

    public static WifiScanConfigProvider getInstance(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        WifiScanConfigProvider r0 = sInstance;
        if (r0 == null) goto L5;
    L14:
        return r0;
    L5:
        monitor-enter(WifiScanConfigProvider.class);
        r0 = sInstance;     // Catch: Throwable -> L11
        if (r0 != null) goto L9;
        r0 = new WifiScanConfigProvider(r3);     // Catch: Throwable -> L11
        sInstance = r0;     // Catch: Throwable -> L11
    L9:
        monitor-exit(WifiScanConfigProvider.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private static long homeCompanyIntervalMs(WifiScanSpecDefaults.SceneSpec r3) {
        if (r3 != null) goto L5;
        return 0;
    L5:
        WifiScanSpecDefaults.HomeCompanySpec r2 = r3.homeCompany;
        if (r2 != null) goto L8;
        WifiScanSpecDefaults.ConnectedActiveSpec r4 = r3.connectedActive;
        if (r4 != null) goto L12;
        WifiScanSpecDefaults.RssiTriggerSpec r5 = r3.rssiTrigger;
        if (r5 != null) goto L17;
        return 0;
    L17:
        return r5.scanIntervalMs;
    L12:
        return r4.scanIntervalMs;
    L8:
        return r2.scanIntervalMs;
    }

    private static long homeCompanyScanDurationMs(WifiScanSpecDefaults.SceneSpec r3, boolean r4) {
        if (r3 != null) goto L5;
        return 0;
    L5:
        WifiScanSpecDefaults.HomeCompanySpec r2 = r3.homeCompany;
        if (r2 == null) goto L11;
        if (r4 == false) goto L10;
        return r2.scanDurationMsHome;
    L10:
        return r2.scanDurationMsCompany;
    L11:
        WifiScanSpecDefaults.ConnectedActiveSpec r5 = r3.connectedActive;
        if (r5 == null) goto L17;
        if (r4 == false) goto L16;
        return r5.scanDurationMsHome;
    L16:
        return r5.scanDurationMsCompany;
    L17:
        return 0;
    }

    private static Boolean ignoreMovementGate(WifiScanSpecDefaults.SceneSpec r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        WifiScanSpecDefaults.HomeCompanySpec r1 = r2.homeCompany;
        if (r1 != null) goto L8;
        WifiScanSpecDefaults.ConnectedActiveSpec r3 = r2.connectedActive;
        if (r3 != null) goto L12;
        WifiScanSpecDefaults.RssiTriggerSpec r4 = r2.rssiTrigger;
        if (r4 != null) goto L17;
        return null;
    L17:
        return r4.ignoreMovementGate;
    L12:
        return r3.ignoreMovementGate;
    L8:
        return r1.ignoreMovementGate;
    }

    private static long indoorDurationMs(WifiScanSpecDefaults.SceneSpec r2) {
        if (r2 == null) goto L7;
        WifiScanSpecDefaults.GeoSpec r3 = r2.geo;
        if (r3 == null) goto L7;
        return r3.indoorDurationMs;
    L7:
        return 0;
    }

    private static boolean isHomeCompanyCycleScene(int r1) {
        if (r1 != 4) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isRssiTriggerScene(int r1) {
        if (r1 != 6) goto L5;
    L10:
        return true;
    L5:
        if (r1 == 7) goto L10;
        if (r1 == 8) goto L10;
        return false;
    }

    private static boolean isSimpleScanScene(int r1) {
        if (r1 != 101) goto L5;
    L8:
        return true;
    L5:
        if (r1 == 301) goto L8;
        return false;
    }

    private void notifyScanSpecUpdated(ActiveConfigSnapshot r4) {
        Iterator<ScanSpecUpdateListener> r3 = this.mUpdateListeners.iterator();
    L4:
        if (r3.hasNext() == false) goto L10;
        ((ScanSpecUpdateListener) ZeusTransformUtils.preCheckCast(r3.next(), ScanSpecUpdateListener.class, "com.obric.memorydata.plugin")).onScanSpecUpdated(r4);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        a.i(TAG, "notifyScanSpecUpdated failed: " + th);
        goto L4
    }

    private static Boolean optBoolean(JSONObject r1, String r2, Boolean r3) {
        if (r1.has(r2) == true) goto L6;
        return r3;
    L6:
        return Boolean.valueOf(r1.getBoolean(r2));
    }

    private static int optInt(JSONObject r1, String r2, int r3) {
        if (r1.has(r2) == true) goto L5;
        return r3;
    L5:
        return r1.getInt(r2);
    }

    private static long optLong(JSONObject r1, String r2, long r3) {
        if (r1.has(r2) == true) goto L5;
        return r3;
    L5:
        return r1.getLong(r2);
    }

    private static WifiScanSpecDefaults.GlobalSpec parseGlobalSpecFromJson(JSONObject r30, WifiScanSpecDefaults.GlobalSpec r31) {
        return new WifiScanSpecDefaults.GlobalSpec(optLong(r30, "throttle_level_1_interval_ms", r31.throttleLevel1IntervalMs), optLong(r30, "throttle_level_2_interval_ms", r31.throttleLevel2IntervalMs), optLong(r30, "throttle_level_3_interval_ms", r31.throttleLevel3IntervalMs), optLong(r30, "fence_pno_max_duration_ms", r31.fencePnoMaxDurationMs), optLong(r30, "fence_pno_max_duration_after_learning_ms", r31.fencePnoMaxDurationAfterLearningMs), optLong(r30, "scan_timeout_ms", r31.scanTimeoutMs), optLong(r30, "scan_retry_backoff_ms", r31.scanRetryBackoffMs), optLong(r30, "scan_retry_no_such_device_backoff_ms", r31.scanRetryNoSuchDeviceBackoffMs), optInt(r30, "pno_scan_iterations", r31.pnoScanIterations), optLong(r30, "pno_scan_interval_ms", r31.pnoScanIntervalMs), optLong(r30, "elevator_scan_call_min_interval_ms", r31.elevatorScanCallMinIntervalMs), optLong(r30, "enter_home_room_stop_connected_scan_delay_ms", r31.enterHomeRoomStopConnectedScanDelayMs));
    }

    private static WifiScanSpecDefaults.SceneSpec parseSceneSpecFromJson(int r25, JSONObject r26, WifiScanSpecDefaults.SceneSpec r27) {
        if (r25 != 5) goto L7;
        return WifiScanSpecDefaults.SceneSpec.connectedActive(optBoolean(r26, "enabled", r27.enabled), optBoolean(r26, "respect_throttle", respectThrottle(r27)), optBoolean(r26, "ignore_movement_gate", ignoreMovementGate(r27)), optLong(r26, "scan_interval_ms", homeCompanyIntervalMs(r27)), optLong(r26, "scan_duration_ms_home", homeCompanyScanDurationMs(r27, true)), optLong(r26, "scan_duration_ms_company", homeCompanyScanDurationMs(r27, false)), optInt(r26, "daily_full_scan_limit", connectedDailyFullScanLimit(r27)), optLong(r26, "once_scan_duration_ms", connectedOnceScanDurationMs(r27)), optLong(r26, "reconnect_force_scan_window_ms", connectedReconnectWindowMs(r27)));
    L7:
        if (isRssiTriggerScene(r25) == false) goto L11;
        return WifiScanSpecDefaults.SceneSpec.rssiTrigger(optBoolean(r26, "enabled", r27.enabled), optBoolean(r26, "respect_throttle", respectThrottle(r27)), optBoolean(r26, "ignore_movement_gate", ignoreMovementGate(r27)), optLong(r26, "scan_interval_ms", homeCompanyIntervalMs(r27)), rssiFixedWindowSec(r27), optInt(r26, "threshold_db", rssiThresholdDb(r27)));
    L11:
        if (r25 != 3) goto L15;
        return WifiScanSpecDefaults.SceneSpec.homeCompany(optBoolean(r26, "enabled", r27.enabled), optBoolean(r26, "respect_throttle", respectThrottle(r27)), optBoolean(r26, "ignore_movement_gate", ignoreMovementGate(r27)), optLong(r26, "scan_interval_ms", homeCompanyIntervalMs(r27)), 0, 0);
    L15:
        if (isHomeCompanyCycleScene(r25) == false) goto L19;
        return WifiScanSpecDefaults.SceneSpec.homeCompany(optBoolean(r26, "enabled", r27.enabled), optBoolean(r26, "respect_throttle", respectThrottle(r27)), optBoolean(r26, "ignore_movement_gate", ignoreMovementGate(r27)), optLong(r26, "scan_interval_ms", homeCompanyIntervalMs(r27)), optLong(r26, "scan_duration_ms_home", homeCompanyScanDurationMs(r27, true)), optLong(r26, "scan_duration_ms_company", homeCompanyScanDurationMs(r27, false)));
    L19:
        if (isSimpleScanScene(r25) == false) goto L23;
        return WifiScanSpecDefaults.SceneSpec.simpleScan(optBoolean(r26, "enabled", r27.enabled), optLong(r26, "interval_ms", simpleIntervalMs(r27)), optLong(r26, "duration_ms", simpleDurationMs(r27)));
    L23:
        if (WifiScanSceneType.isElevatorScene(r25) == false) goto L27;
        return WifiScanSpecDefaults.SceneSpec.elevator(optBoolean(r26, "enabled", r27.enabled), optLong(r26, "interval_ms", elevatorIntervalMs(r27)), optInt(r26, "scan_times", elevatorScanTimes(r27)), optLong(r26, "total_timeout_ms", elevatorTotalTimeoutMs(r27)));
    L27:
        if (WifiScanSceneType.isGeoScene(r25) == true) goto L29;
        return r27;
    L29:
        return WifiScanSpecDefaults.SceneSpec.geo(optLong(r26, "geo_interval_ms", geoIntervalMs(r27)), optLong(r26, "geo_duration_ms", geoDurationMs(r27)), optLong(r26, "wifi_duration_ms", wifiDurationMs(r27)), optLong(r26, "indoor_duration_ms", indoorDurationMs(r27)));
    }

    private static int positiveOrDefault(int r0, int r1) {
        if (r0 <= 0) goto L5;
        return r0;
    L5:
        return r1;
    }

    private static long positiveOrDefault(long r2, long r4) {
        if (r2 <= 0) goto L6;
        return r2;
    L6:
        return r4;
    }

    private ActiveConfigSnapshot refreshActiveConfigFromPreferences(boolean r4) {
        String r0 = this.mSp.getString(KEY_SCAN_SPEC_CONFIG, "{}");
        ActiveConfigSnapshot r1 = this.mActiveSnapshot;
        ActiveConfigSnapshot r2 = resolveActiveConfigSnapshot(r0);
        if (r4 == false) goto L6;
        if (r2 == r1) goto L6;
        notifyScanSpecUpdated(r2);
    L6:
        return r2;
    }

    public static void resetInstanceForTest() {
        monitor-enter(WifiScanConfigProvider.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (sInstance == null) goto L7;
        sInstance.mSp.unregisterOnSharedPreferenceChangeListener(sInstance.mPreferenceChangeListener);     // Catch: Throwable -> L9
        sInstance = null;     // Catch: Throwable -> L9
    L7:
        monitor-exit(WifiScanConfigProvider.class);     // Catch: Throwable -> L9
    }

    private ActiveConfigSnapshot resolveActiveConfigSnapshot(String r6) {
        if (r6 != null) goto L5;
        r6 = "{}";
    L5:
        monitor-enter(this);
        ActiveConfigSnapshot r3 = this.mActiveSnapshot;     // Catch: Throwable -> L33
        if (r3 != null) goto L9;
    L12:
        String r4 = validate(r6);     // Catch: Throwable -> L33
        if (r4.contains("ERROR:") == false) goto L38;
        a.g(TAG, "resolveActiveConfigSnapshot: raw scan-spec is invalid. Active config falls back to defaults. Issues=\n".concat(r4));     // Catch: Throwable -> L33
        JSONObject r0 = new JSONObject("{}");     // Catch: JSONException -> L17 Throwable -> L33
    L27:
        this.mActiveJsonString = r6;     // Catch: Throwable -> L33
        this.mActiveSnapshot = new ActiveConfigSnapshot(this.mAppContext, r0, null);     // Catch: Throwable -> L33
        ActiveConfigSnapshot r7 = this.mActiveSnapshot;     // Catch: Throwable -> L33
        monitor-exit(this);     // Catch: Throwable -> L33
        return r7;
    L17:
        e = move-exception;
        throw new IllegalStateException(e);     // Catch: Throwable -> L33
    L38:
        JSONObject r1 = new JSONObject(r6);     // Catch: JSONException -> L24 Throwable -> L33
        if (r4.isEmpty() == true) goto L23;
        a.e(TAG, "resolveActiveConfigSnapshot: raw scan-spec accepted with warnings:\n".concat(r4));     // Catch: JSONException -> L24 Throwable -> L33
    L23:
        r0 = r1;
    L24:
        e = move-exception;
        a.i(TAG, "resolveActiveConfigSnapshot: unexpected parse failure: " + e + ". Active config falls back to defaults.");     // Catch: Throwable -> L33
        r0 = new JSONObject("{}");     // Catch: JSONException -> L30 Throwable -> L33
    L30:
        e = move-exception;
        throw new IllegalStateException(e);     // Catch: Throwable -> L33
    L9:
        if (r6.equals(this.mActiveJsonString) == false) goto L12;
        monitor-exit(this);     // Catch: Throwable -> L33
        return r3;
    L33:
        th = move-exception;
        throw th;
    }

    public static long resolveEffectiveInterval(int r2, WifiScanSpecDefaults.SceneSpec r3, Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        WifiScanSpecDefaults.GlobalSpec r0 = WifiScanSpecDefaults.getDefaultGlobalSpec();
    L7:
        return resolveEffectiveInterval(r2, r3, r5, r0);
    L5:
        r0 = getInstance(r5).getActiveConfigSnapshot().getGlobalSpec();
        goto L7
    }

    private static long resolveEffectiveInterval(int r7, WifiScanSpecDefaults.SceneSpec r8, Context r9, WifiScanSpecDefaults.GlobalSpec r10) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        if (WifiScanSceneType.isHomeCompanyAwareScene(r7) == false) goto L5;
        WifiScanSpecDefaults.SceneSpec r11 = WifiScanSpecDefaults.getDefaultSceneSpec(r7);
        if (r8 != null) goto L9;
    L12:
        WifiScanSpecDefaults.GlobalSpec r12 = WifiScanSpecDefaults.getDefaultGlobalSpec();
        long r13 = WifiScanStateMachine.getThrottledScanIntervalMs(r0, positiveOrDefault(r10.throttleLevel1IntervalMs, r12.throttleLevel1IntervalMs), positiveOrDefault(r10.throttleLevel2IntervalMs, r12.throttleLevel2IntervalMs), positiveOrDefault(r10.throttleLevel3IntervalMs, r12.throttleLevel3IntervalMs));
        return Math.max(homeCompanyIntervalMs(r8), r13);
    L9:
        if (Boolean.FALSE.equals(respectThrottle(r8)) == false) goto L12;
        return positiveOrDefault(homeCompanyIntervalMs(r8), homeCompanyIntervalMs(r11));
    L5:
        return genericScanIntervalMs(r8);
    }

    private static Boolean respectThrottle(WifiScanSpecDefaults.SceneSpec r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        WifiScanSpecDefaults.HomeCompanySpec r1 = r2.homeCompany;
        if (r1 != null) goto L8;
        WifiScanSpecDefaults.ConnectedActiveSpec r3 = r2.connectedActive;
        if (r3 != null) goto L12;
        WifiScanSpecDefaults.RssiTriggerSpec r4 = r2.rssiTrigger;
        if (r4 != null) goto L17;
        return null;
    L17:
        return r4.respectThrottle;
    L12:
        return r3.respectThrottle;
    L8:
        return r1.respectThrottle;
    }

    private static int rssiFixedWindowSec(WifiScanSpecDefaults.SceneSpec r0) {
        if (r0 == null) goto L7;
        WifiScanSpecDefaults.RssiTriggerSpec r1 = r0.rssiTrigger;
        if (r1 == null) goto L7;
        return r1.fixedWindowSec;
    L7:
        return 0;
    }

    private static int rssiThresholdDb(WifiScanSpecDefaults.SceneSpec r0) {
        if (r0 == null) goto L7;
        WifiScanSpecDefaults.RssiTriggerSpec r1 = r0.rssiTrigger;
        if (r1 == null) goto L7;
        return r1.thresholdDb;
    L7:
        return 0;
    }

    private static SceneSchema sceneSchema(boolean r1, String... r2) {
        return new SceneSchema(r1, createKeySet(r2));
    }

    private static SceneSchema schemaForScene(int r1) {
        if (r1 != 5) goto L7;
        return CONNECTED_ACTIVE_SCHEMA;
    L7:
        if (r1 != 3) goto L11;
        return WIFI_FENCE_SCHEMA;
    L11:
        if (isRssiTriggerScene(r1) == false) goto L15;
        return RSSI_TRIGGER_SCHEMA;
    L15:
        if (isHomeCompanyCycleScene(r1) == false) goto L19;
        return HOME_COMPANY_SCHEMA;
    L19:
        if (isSimpleScanScene(r1) == false) goto L23;
        return SIMPLE_SCAN_SCHEMA;
    L23:
        if (WifiScanSceneType.isElevatorScene(r1) == false) goto L27;
        return ELEVATOR_SCHEMA;
    L27:
        if (WifiScanSceneType.isGeoScene(r1) == false) goto L31;
        return GEO_SCHEMA;
    L31:
        return EMPTY_SCHEMA;
    }

    private static long simpleDurationMs(WifiScanSpecDefaults.SceneSpec r2) {
        if (r2 == null) goto L7;
        WifiScanSpecDefaults.SimpleScanSpec r3 = r2.simpleScan;
        if (r3 == null) goto L7;
        return r3.durationMs;
    L7:
        return 0;
    }

    private static long simpleIntervalMs(WifiScanSpecDefaults.SceneSpec r2) {
        if (r2 == null) goto L7;
        WifiScanSpecDefaults.SimpleScanSpec r3 = r2.simpleScan;
        if (r3 == null) goto L7;
        return r3.intervalMs;
    L7:
        return 0;
    }

    private void validateBoolean(StringBuilder r1, int r2, JSONObject r3, String r4) {
        if (r3.has(r4) == false) goto L12;
        Object r0 = r3.opt(r4);
        if (ZeusTransformUtils.instanceOf(r0, Boolean.class) == true) goto L13;
        StringBuilder r5 = r1.append("ERROR: scenes.").append(WifiScanSceneType.sceneNameOf(r2)).append('.').append(r4).append(" must be boolean, type given=");
        if (r0 != null) goto L9;
        String r6 = "null";
    L10:
        r5.append(r6).append('\n');
        return;
    L9:
        r6 = r0.getClass().getSimpleName();
        goto L10
    L13:
        return;
    }

    private void validateBooleanIfKnown(StringBuilder r3, int r4, JSONObject r5, Set<String> r6, String r7) {
        if (((Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin")).contains(r7) == false) goto L6;
        validateBoolean(r3, r4, r5, r7);
        return;
    }

    private void validateDurationMsGlobal(JSONObject r3, String r4, StringBuilder r5) {
        if (r3.has(r4) == false) goto L8;
        long r2 = r3.optLong(r4, -1);
        if (r2 >= 100) goto L9;
        r5.append("ERROR: global.").append(r4).append(" must be a long >= 100 ms (").append(r2).append(" given)\n");
        return;
    L9:
        return;
    }

    private void validateIntMin(StringBuilder r1, int r2, JSONObject r3, String r4, int r5, int r6) {
        if (r3.has(r4) == false) goto L9;
        int r0 = r3.optInt(r4, -1);
        if (r0 < r5) goto L7;
        if (r0 > r6) goto L7;
        return;
    L7:
        r1.append("ERROR: scenes.").append(WifiScanSceneType.sceneNameOf(r2)).append('.').append(r4).append(" must be int in [").append(r5).append(',').append(r6).append("] (").append(r0).append(" given)\n");
        return;
    }

    private void validateIntMinIfKnown(StringBuilder r8, int r9, JSONObject r10, Set<String> r11, String r12, int r13, int r14) {
        if (((Set) ZeusTransformUtils.wrapperContextForParams(r11, Set.class, "com.obric.memorydata.plugin")).contains(r12) == false) goto L6;
        validateIntMin(r8, r9, r10, r12, r13, r14);
        return;
    }

    private void validateIntervalMsGlobal(JSONObject r3, String r4, StringBuilder r5) {
        if (r3.has(r4) == false) goto L8;
        long r2 = r3.optLong(r4, -1);
        if (r2 >= 10) goto L9;
        r5.append("ERROR: global.").append(r4).append(" must be a long >= 10 ms (").append(r2).append(" given)\n");
        return;
    L9:
        return;
    }

    private void validateLongMin(StringBuilder r3, int r4, JSONObject r5, String r6, long r7, long r9) {
        if (r5.has(r6) == false) goto L10;
        long r0 = r5.optLong(r6, -1);
        if (r0 >= r7) goto L7;
    L8:
        r3.append("ERROR: scenes.").append(WifiScanSceneType.sceneNameOf(r4)).append('.').append(r6).append(" must be long in [").append(r7).append(',').append(r9).append("] (").append(r0).append(" given)\n");
        return;
    L7:
        if (r0 > r9) goto L8;
        return;
    }

    private void validateLongMinIfKnown(StringBuilder r11, int r12, JSONObject r13, Set<String> r14, String r15, long r16, long r18) {
        if (((Set) ZeusTransformUtils.wrapperContextForParams(r14, Set.class, "com.obric.memorydata.plugin")).contains(r15) == false) goto L6;
        validateLongMin(r11, r12, r13, r15, r16, r18);
        return;
    }

    private void validatePositiveIntGlobal(JSONObject r1, String r2, StringBuilder r3, int r4, int r5) {
        if (r1.has(r2) == false) goto L9;
        int r0 = r1.optInt(r2, -1);
        if (r0 < r4) goto L7;
        if (r0 > r5) goto L7;
        return;
    L7:
        r3.append("ERROR: global.").append(r2).append(" must be int in [").append(r4).append(',').append(r5).append("] (").append(r0).append(" given)\n");
        return;
    }

    private void validateSceneSpec(int r22, JSONObject r23, StringBuilder r24) {
        SceneSchema r0 = schemaForScene(r22);
        Set<String> r14 = r0.keys;
        warnUnknownSceneKeys(r24, r22, r23, r14);
        if (r0.rssiTrigger == false) goto L6;
        validateThresholdDb(r24, r22, r23);
    L6:
        if (r14.contains("enabled") == false) goto L8;
    L10:
        String[] r6 = SCENE_BOOLEAN_KEYS;
        int r7 = r6.length;
        int r15 = 0;
        int r8 = 0;
    L11:
        if (r8 >= r7) goto L13;
        validateBooleanIfKnown(r24, r22, r23, r14, r6[r8]);
        r8 = r8 + 1;
        goto L11
    L13:
        String[] r9 = SCENE_LONG_KEYS;
        int r10 = r9.length;
        int r11 = 0;
    L14:
        if (r11 >= r10) goto L16;
        validateLongMinIfKnown(r24, r22, r23, r14, r9[r11], 1, Long.MAX_VALUE);
        r11 = r11 + 1;
        r9 = r9;
        r10 = r10;
        goto L14
    L16:
        IntRangeKey[] r12 = SCENE_INT_KEYS;
        int r13 = r12.length;
    L17:
        if (r15 >= r13) goto L19;
        IntRangeKey r1 = r12[r15];
        validateIntMinIfKnown(r24, r22, r23, r14, r1.name, r1.min, r1.max);
        r15 = r15 + 1;
        goto L17
    L19:
        return;
    L8:
        if (r23.has("enabled") == false) goto L10;
        r24.append("WARNING: scenes.").append(WifiScanSceneType.sceneNameOf(r22)).append('.').append("enabled").append(" is ignored for GEO parameter scenes\n");
        goto L10
    }

    private void validateThresholdDb(StringBuilder r2, int r3, JSONObject r4) {
        if (r4.has("threshold_db") == false) goto L10;
        int r5 = r4.optInt("threshold_db", -1);
        if (r5 > 0) goto L7;
    L8:
        r2.append("ERROR: scenes.").append(WifiScanSceneType.sceneNameOf(r3)).append('.').append("threshold_db").append(" must be int dB>0 in (0,100]. RSSI drop DIFF (not absolute dBm): ").append(r5).append(" given)\n");
        return;
    L7:
        if (r5 > 100) goto L8;
        return;
    }

    private void warnUnknownSceneKeys(StringBuilder r4, int r5, JSONObject r6, Set<String> r7) {
        Set r3 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.memorydata.plugin");
        Iterator<String> r8 = r6.keys();
    L4:
        if (r8.hasNext() == false) goto L13;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");
        if (WifiScanSceneType.isGeoScene(r5) == false) goto L11;
        if ("enabled".equals(r9) == true) goto L4;
    L11:
        if (r3.contains(r9) == true) goto L4;
        r4.append("WARNING: scenes.").append(WifiScanSceneType.sceneNameOf(r5)).append(": unknown key '").append(r9).append("' will be ignored\n");
        goto L4
    }

    private static long wifiDurationMs(WifiScanSpecDefaults.SceneSpec r2) {
        if (r2 == null) goto L7;
        WifiScanSpecDefaults.GeoSpec r3 = r2.geo;
        if (r3 == null) goto L7;
        return r3.wifiDurationMs;
    L7:
        return 0;
    }

    public ActiveConfigSnapshot getActiveConfigSnapshot() {
        ActiveConfigSnapshot r0 = this.mActiveSnapshot;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return refreshActiveConfigFromPreferences(false);
    }

    public String getSpecConfigJson() {
        return this.mSp.getString(KEY_SCAN_SPEC_CONFIG, null);
    }

    public void registerUpdateListener(ScanSpecUpdateListener r3) {
        ScanSpecUpdateListener r4 = (ScanSpecUpdateListener) ZeusTransformUtils.wrapperContextForParams(r3, ScanSpecUpdateListener.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        if (this.mUpdateListeners.contains(r4) == true) goto L9;
        this.mUpdateListeners.add(r4);
        return;
    }

    public synchronized void resetToDefaults() {
        monitor-enter(this);
        this.mSp.edit().remove(KEY_SCAN_SPEC_CONFIG).commit();     // Catch: Throwable -> L6
        refreshActiveConfigFromPreferences(true);     // Catch: Throwable -> L6
        a.e(TAG, "resetToDefaults: SP scan_spec_config removed. All params will fall back to WifiScanSpecDefaults.");     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean saveSpecConfigJson(String r4) {
        monitor-enter(this);
        if (r4 != null) goto L22;
        a.i(TAG, "saveSpecConfigJson: jsonString is NULL. Reject.");     // Catch: Throwable -> L8
        monitor-exit(this);
        return false;
    L22:
        boolean r5 = this.mSp.edit().putString(KEY_SCAN_SPEC_CONFIG, r4).commit();     // Catch: Throwable -> L16
        if (r5 == false) goto L13;
        a.e(TAG, "saveSpecConfigJson: raw SP scan_spec_config updated. Active config will be refreshed in memory.");     // Catch: Throwable -> L16
        refreshActiveConfigFromPreferences(true);     // Catch: Throwable -> L16
    L14:
        monitor-exit(this);
        return r5;
    L13:
        a.i(TAG, "saveSpecConfigJson: raw SP commit returned false.");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        a.i(TAG, "saveSpecConfigJson: SP.edit.commit() threw: " + th);     // Catch: Throwable -> L8
        return false;
    L8:
        th = move-exception;
        throw th;
    }

    public void unregisterUpdateListener(ScanSpecUpdateListener r3) {
        ScanSpecUpdateListener r4 = (ScanSpecUpdateListener) ZeusTransformUtils.wrapperContextForParams(r3, ScanSpecUpdateListener.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        this.mUpdateListeners.remove(r4);
        return;
    }

    public String validate(String r11) {
        StringBuilder r6 = new StringBuilder();
        if (r11 != null) goto L43;
        r6.append("ERROR: jsonString is NULL\n");
    L6:
        return r6.toString().trim();
    L43:
        JSONObject r7 = new JSONObject(r11);     // Catch: JSONException -> L41
        if (r7.has("version") == false) goto L15;
        int r12 = r7.optInt("version", -1);
        if (r12 >= 1) goto L15;
        r6.append("ERROR: 'version' must be a positive int, got ").append(r12).append('\n');
    L15:
        if (r7.has("global") == false) goto L26;
        JSONObject r13 = r7.optJSONObject("global");
        if (r13 == null) goto L24;
        validateIntervalMsGlobal(r13, "throttle_level_1_interval_ms", r6);
        validateIntervalMsGlobal(r13, "throttle_level_2_interval_ms", r6);
        validateIntervalMsGlobal(r13, "throttle_level_3_interval_ms", r6);
        validateDurationMsGlobal(r13, "fence_pno_max_duration_ms", r6);
        validateDurationMsGlobal(r13, "fence_pno_max_duration_after_learning_ms", r6);
        validateDurationMsGlobal(r13, "scan_timeout_ms", r6);
        validateDurationMsGlobal(r13, "scan_retry_backoff_ms", r6);
        validateDurationMsGlobal(r13, "scan_retry_no_such_device_backoff_ms", r6);
        validatePositiveIntGlobal(r13, "pno_scan_iterations", r6, 1, 100);
        validateIntervalMsGlobal(r13, "pno_scan_interval_ms", r6);
        validateIntervalMsGlobal(r13, "elevator_scan_call_min_interval_ms", r6);
        validateDurationMsGlobal(r13, "enter_home_room_stop_connected_scan_delay_ms", r6);
        Iterator<String> r14 = r13.keys();
    L20:
        if (r14.hasNext() == false) goto L26;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin");
        if (GLOBAL_KEYS.contains(r0) == true) goto L20;
        r6.append("WARNING: global: unknown key '").append(r0).append("' will be ignored\n");
        goto L20
    L24:
        r6.append("ERROR: 'global' must be a JSON object when present\n");
    L26:
        if (r7.has("scenes") == false) goto L6;
        JSONObject r1 = r7.optJSONObject("scenes");
        if (r1 == null) goto L40;
        Iterator<String> r15 = r1.keys();
    L31:
        if (r15.hasNext() == false) goto L6;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.memorydata.plugin");
        int r3 = WifiScanSceneType.sceneIdOf(r2);
        if (r3 == (-1)) goto L34;
        JSONObject r4 = r1.optJSONObject(r2);
        if (r4 == null) goto L38;
        validateSceneSpec(r3, r4, r6);
        goto L31
    L38:
        StringBuilder r5 = r6.append("ERROR: scenes.").append(r2);
        String r8 = " is not a JSON object (null or scalar)\n";
    L35:
        r5.append(r8);
        goto L31
    L34:
        r5 = r6.append("WARNING: scenes: unknown sceneName='").append(r2).append("' (not found in WifiScanSceneType). ");
        r8 = "Will be ignored by parser.\n";
        goto L35
    L40:
        r6.append("ERROR: '").append("scenes").append("' must be a JSON object when present\n");
    L41:
        e = move-exception;
        r6.append("ERROR: Top-level JSON parse failed: ").append(e.getMessage()).append('\n');
        goto L6
    }
}
