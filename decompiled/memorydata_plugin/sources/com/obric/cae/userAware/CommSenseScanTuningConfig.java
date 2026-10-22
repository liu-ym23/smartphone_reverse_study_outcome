package com.obric.cae.userAware;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import com.obric.cae.log.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
final class CommSenseScanTuningConfig {
    private static final int MAX_ADAPTIVE_DWELL_MODE = 4;
    private static final int MAX_BURST_MS = 10000;
    private static final int MAX_DWELL_MS = 10000;
    private static final int MAX_IDLE_MS = 10000;
    private static final int MAX_PROBE_COUNT = 10;
    private static final int MAX_REST_MS = 10000;
    private static final int MIN_ADAPTIVE_DWELL_MODE = 0;
    private static final int MIN_DWELL_MS = 1;
    private static final int MIN_PASSIVE_DWELL_MS = 110;
    private static final int MIN_PROBE_COUNT = 1;
    private static final int NEFI_SCENARIO_GENERAL = 0;
    private static final String PREFS_SCAN_TUNING = "cae_user_aware_scan_tuning";
    static final CommSenseScanTuningConfig SCAN_TIME_OPTIMIZED_CONFIG = null;
    private static final int SCAN_TUNING_DISABLED = 0;
    private static final int SCAN_TUNING_ENABLED = 1;
    static final String SCAN_TUNING_ENABLE_KEY = "cae_user_aware_scan_tuning_enable";
    static final String SCAN_TUNING_PROFILE_KEY = "cae_user_aware_scan_tuning_profile";
    static final String SETTINGS_GLOBAL_NEFI_SCENARIO = "nefid_low_latency";
    private static final String TAG = "CommSenseScanTuningConfig";
    final Profile dbsProfile;
    final Profile nonDbsProfile;

    public static final class Profile {
        final int activeDwell2gMs;
        final int activeDwellMs;
        final int adaptiveDwellMode;
        final int burstDurationMs;
        final int connectedActiveDwell2gMs;
        final int connectedActiveDwellMs;
        final int idleMs;
        final int maxRestMs;
        final int minRestMs;
        final int passiveDwellMs;
        final int probeCount;

        public Profile(int r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11) {
            this.activeDwellMs = r1;
            this.activeDwell2gMs = r2;
            this.connectedActiveDwellMs = r3;
            this.connectedActiveDwell2gMs = r4;
            this.passiveDwellMs = r5;
            this.minRestMs = r6;
            this.maxRestMs = r7;
            this.idleMs = r8;
            this.burstDurationMs = r9;
            this.adaptiveDwellMode = r10;
            this.probeCount = r11;
        }
    }

    static {
        SCAN_TIME_OPTIMIZED_CONFIG = new CommSenseScanTuningConfig(new Profile(40, 40, 40, 40, 110, 50, 100, 25, 160, 4, 3), new Profile(20, 20, 40, 40, 110, 50, 100, 25, 160, 4, 3));
    }

    private CommSenseScanTuningConfig(Profile r1, Profile r2) {
        this.dbsProfile = r1;
        this.nonDbsProfile = r2;
    }

    public static void clearScanTuningProfile(Context r2) {
        getPreferences((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).edit().remove(SCAN_TUNING_ENABLE_KEY).remove(SCAN_TUNING_PROFILE_KEY).apply();
    }

    private static CommSenseScanTuningConfig fromJson(JSONObject r4, CommSenseScanTuningConfig r5) {
        return new CommSenseScanTuningConfig(parseProfile(optProfile(r4, new String[]{"dbs", "dbsProfile"}), r5.dbsProfile), parseProfile(optProfile(r4, new String[]{"nonDbs", "non_dbs", "nonDbsProfile"}), r5.nonDbsProfile));
    }

    public static CommSenseScanTuningConfig getCurrent(Context r2, boolean r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L7;
        return SCAN_TIME_OPTIMIZED_CONFIG;
    L7:
        if (isScanTuningEnabled(r4) == true) goto L9;
        return null;
    L9:
        if (r3 == true) goto L11;
    L13:
        String r5 = getSavedScanTuningProfile(r4);
        if (r5 == null) goto L23;
        if (r5.trim().isEmpty() == true) goto L23;
        return fromJson(new JSONObject(r5), SCAN_TIME_OPTIMIZED_CONFIG);
    L20:
        a.g(TAG, "Invalid scan tuning profile, use scan time optimized config");
        return SCAN_TIME_OPTIMIZED_CONFIG;
    L23:
        return SCAN_TIME_OPTIMIZED_CONFIG;
    L11:
        if (isGeneralScenario(r4) == true) goto L13;
        return null;
    }

    private static int getInt(JSONObject r2, String r3) {
        Object r4 = r2.opt(r3);
        if (r4 == null) goto L24;
        if (r4 == JSONObject.NULL) goto L24;
        if (ZeusTransformUtils.instanceOf(r4, Number.class) == false) goto L11;
        return numberToInt(r3, (Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin"));
    L11:
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L22;
        String r5 = ((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin")).trim();
        if (r5.isEmpty() == true) goto L20;
        return Integer.parseInt(r5);
    L16:
        e = move-exception;
        throw new IllegalArgumentException(r3 + " is not an integer", e);
    L20:
        throw new IllegalArgumentException(r3 + " is empty");
    L22:
        throw new IllegalArgumentException(r3 + " has unsupported type");
    L24:
        throw new IllegalArgumentException(r3 + " is null");
    }

    private static SharedPreferences getPreferences(Context r2) {
        return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSharedPreferences(PREFS_SCAN_TUNING, 0);
    }

    public static String getSavedScanTuningProfile(Context r2) {
        return getPreferences((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getString(SCAN_TUNING_PROFILE_KEY, null);
    }

    private static boolean isGeneralScenario(Context r2) {
        String r3 = Settings.Global.getString(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getContentResolver(), SETTINGS_GLOBAL_NEFI_SCENARIO);
        if (r3 != null) goto L5;
    L13:
        return true;
    L5:
        if (r3.trim().isEmpty() == true) goto L13;
        if (Integer.parseInt(r3.trim()) == 0) goto L16;
        return false;
    L16:
        return true;
    L12:
        a.g(TAG, "Invalid NEFI scenario, allow scan tuning");
        goto L13
    }

    private static boolean isScanTuningEnabled(Context r2) {
        if (getPreferences((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getInt(SCAN_TUNING_ENABLE_KEY, 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean isValidScanTuningEnable(int r1) {
        if (r1 == 0) goto L8;
        if (r1 == 1) goto L9;
        return false;
    L9:
        return true;
    L8:
        return true;
    }

    private static int numberToInt(String r4, Number r5) {
        if (ZeusTransformUtils.instanceOf(r5, Float.class) == false) goto L5;
    L15:
        double r0 = r5.doubleValue();
        if (Double.isNaN(r0) == true) goto L28;
        if (Double.isInfinite(r0) == true) goto L28;
        if (r0 != Math.rint(r0)) goto L28;
        if (r0 < (-2.147483648E9d)) goto L28;
        if (r0 > 2.147483647E9d) goto L28;
        return (int) r0;
    L28:
        throw new IllegalArgumentException(r4 + " is not an integer");
    L5:
        if (ZeusTransformUtils.instanceOf(r5, Double.class) == true) goto L15;
        long r1 = r5.longValue();
        if (r1 < (-2147483648L)) goto L14;
        if (r1 > 2147483647L) goto L14;
        return (int) r1;
    L14:
        throw new IllegalArgumentException(r4 + " out of int range");
    }

    private static int optInt(JSONObject r4, int r5, String... r6) {
        int r0 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        String r2 = r6[r1];
        if (r4.has(r2) == true) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        return getInt(r4, r2);
    L9:
        return r5;
    }

    private static JSONObject optProfile(JSONObject r3, String... r4) {
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        JSONObject r2 = r3.optJSONObject(r4[r1]);
        if (r2 != null) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r2;
    L8:
        return null;
    }

    private static Profile parseProfile(JSONObject r26, Profile r27) {
        if (r26 != null) goto L5;
        return r27;
    L5:
        int r6 = optInt(r26, r27.activeDwellMs, new String[]{"activeDwellMs", "active"});
        int r7 = optInt(r26, r27.activeDwell2gMs, new String[]{"activeDwell2gMs", "active2g", "active_2g"});
        int r8 = optInt(r26, r27.connectedActiveDwellMs, new String[]{"connectedActiveDwellMs", "connectedActive", "activeConnected", "active_connected"});
        int r2 = optInt(r26, r27.connectedActiveDwell2gMs, new String[]{"connectedActiveDwell2gMs", "connectedActive2g", "active2gConnected", "active_2g_connected"});
        int r10 = optInt(r26, r27.passiveDwellMs, new String[]{"passiveDwellMs", "passive"});
        int r12 = optInt(r26, r27.minRestMs, new String[]{"minRestMs", "minRest"});
        int r13 = optInt(r26, r27.maxRestMs, new String[]{"maxRestMs", "maxRest"});
        int r14 = optInt(r26, r27.idleMs, new String[]{"idleMs", "idleTimeMs", "idle"});
        int r15 = optInt(r26, r27.burstDurationMs, new String[]{"burstDurationMs", "burst"});
        int r16 = optInt(r26, r27.adaptiveDwellMode, new String[]{"adaptiveDwellMode", "adaptive"});
        int r0 = optInt(r26, r27.probeCount, new String[]{"probeCount", "probes", "nProbes", "n_probes"});
        validateRange("activeDwellMs", r6, 1, 10000);
        validateRange("activeDwell2gMs", r7, 1, 10000);
        validateRange("connectedActiveDwellMs", r8, 1, 10000);
        validateRange("connectedActiveDwell2gMs", r2, 1, 10000);
        validateRange("passiveDwellMs", r10, 110, 10000);
        validateRange("minRestMs", r12, 0, 10000);
        validateRange("maxRestMs", r13, 0, 10000);
        if (r12 > r13) goto L10;
        validateRange("idleMs", r14, 0, 10000);
        validateRange("burstDurationMs", r15, 0, 10000);
        validateRange("adaptiveDwellMode", r16, 0, 4);
        validateRange("probeCount", r0, 1, 10);
        return new Profile(r6, r7, r8, r2, r10, r12, r13, r14, r15, r16, r0);
    L10:
        throw new IllegalArgumentException("minRestMs > maxRestMs");
    }

    public static void saveScanTuningEnable(Context r2, int r3) {
        getPreferences((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).edit().putInt(SCAN_TUNING_ENABLE_KEY, r3).apply();
    }

    public static void saveScanTuningProfile(Context r2, String r3) {
        getPreferences((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).edit().putString(SCAN_TUNING_PROFILE_KEY, r3).apply();
    }

    private static void validateRange(String r0, int r1, int r2, int r3) {
        if (r1 < r2) goto L6;
        if (r1 > r3) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(r0 + " out of range");
    }
}
