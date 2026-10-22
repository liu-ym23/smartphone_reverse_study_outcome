package com.obric.cae.smartNetwork.netAccel;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.net.Uri;
import android.provider.Settings;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.NetworkAccelerate.VipAppManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AccelConfigManager {
    public static final String CLOUD_CONFIG_ACCEL_CONFIG = "mult_net_accel_config";
    private static final boolean DEFAULT_APP_TRAFFIC_COLLECT_ENABLE = true;
    private static final List<String> DEFAULT_APP_TRAFFIC_COLLECT_PACKAGES = null;
    private static final boolean DEFAULT_AUTO_DUAL_WLAN_ENABLE = true;
    private static final boolean DEFAULT_CELLULAR_ACCEL_ENABLE = false;
    private static final int DEFAULT_FLOW_SCHED_INTERVAL_MS = 5000;
    private static final boolean DEFAULT_GLOBAL_ENABLE = true;
    private static final Map<String, PackageRule> DEFAULT_PACKAGE_RULES = null;
    private static final boolean DEFAULT_PRECEPTION_ENABLE = true;
    private static final int DEFAULT_PRECEPTION_GOOD_THRESHOLD = 5;
    private static final int DEFAULT_PRECEPTION_REDUCE_OFFLOAD_INTERVAL_MS = 10000;
    private static final int[] DEFAULT_PRECEPTION_REDUCE_OFFLOAD_PERCENT = null;
    private static final int DEFAULT_PRECEPTION_WEAK_THRESHOLD = 5;
    private static final int DEFAULT_QUOTA_CELLULAR = 1;
    private static final String DEFAULT_QUOTA_MODE = "speed_based";
    private static final float DEFAULT_QUOTA_SPEED_RATIO_THRESHOLD = 0.5f;
    private static final int DEFAULT_QUOTA_WIFI_24 = 1;
    private static final int DEFAULT_QUOTA_WIFI_5 = 1;
    private static final int DEFAULT_VALID_WIFI_RX_LINK_SPEED = 50;
    public static final String KEY_ACCEL_QUOTA = "multi_net_accel_quota";
    public static final String KEY_APP_TRAFFIC_COLLECT_ENABLE = "multi_net_app_traffic_collect_enable";
    public static final String KEY_APP_TRAFFIC_COLLECT_PACKAGES = "multi_net_app_traffic_collect_packages";
    public static final String KEY_AUTO_DUAL_WLAN_ENABLE = "multi_net_auto_dual_wlan_enable";
    public static final String KEY_CELLULAR_ACCEL_ENABLE = "multi_net_cellular_accel_enable";
    public static final String KEY_DUAL_WLAN_ACCEL_ENABLE = "multi_net_dual_wlan_accel_enable";
    public static final String KEY_FLOW_SCHED_INTERVAL = "multi_net_flow_sched_interval";
    public static final String KEY_GLOBAL_ENABLE = "multi_net_accel_global_enable";
    public static final String KEY_PACKAGE_RULES = "multi_net_accel_package_rules";
    public static final String KEY_PRECEPTION_ENABLE = "multi_net_preception_enable";
    public static final String KEY_PRECEPTION_GOOD_THRESHOLD = "multi_net_preception_good_threshold";
    public static final String KEY_PRECEPTION_REDUCE_OFFLOAD_INTERVAL = "multi_net_preception_reduce_offload_interval";
    public static final String KEY_PRECEPTION_REDUCE_OFFLOAD_PERCENT = "multi_net_preception_reduce_offload_percent";
    public static final String KEY_PRECEPTION_WEAK_THRESHOLD = "multi_net_preception_weak_threshold";
    public static final String MODULE_TAG = "MultiNetwork-";
    public static final String PREFS_NAME = "multi_net_accel_prefs";
    private static final String TAG = "MultiNetwork-AccelConfigManager";
    private static volatile AccelConfigManager instance;
    private final List<ConfigChangeCallback> mCallbacks;
    private final Context mContext;
    private final SharedPreferences mPrefs;
    private final ContentResolver mResolver;
    private final SettingsObserver mSettingObserver;

    public interface ConfigChangeCallback {
        void onAllPackagesRulesChanged();

        void onAppTrafficCollectEnableChanged(boolean r8);

        void onAppTrafficCollectPackagesChanged(List<String> r8);

        void onDualWlanAccelEnableChanged(boolean r8);

        void onGlobalAccelEnableChanged(boolean r8);
    }

    public static class PackageRule {
        public static final int AUTO_DUAL_WLAN_MODE_FOREGROUND = 1;
        public static final int AUTO_DUAL_WLAN_MODE_OFF = 0;
        public static final int AUTO_DUAL_WLAN_MODE_RATE = 2;
        private int autoDualWlanMode;
        private boolean cellularAccelEnable;
        private boolean enable;
        private boolean flowSchedEnable;

        public PackageRule() {
        }

        public PackageRule(PackageRule r8) {
            this.enable = r8.enable;
            this.autoDualWlanMode = r8.autoDualWlanMode;
            this.flowSchedEnable = r8.flowSchedEnable;
            this.cellularAccelEnable = r8.cellularAccelEnable;
        }

        public static /* synthetic */ boolean access$600(PackageRule r8) {
            return r8.enable;
        }

        public static /* synthetic */ boolean access$602(PackageRule r8, boolean r10) {
            r8.enable = r10;
            return r10;
        }

        public static /* synthetic */ int access$700(PackageRule r8) {
            return r8.autoDualWlanMode;
        }

        public static /* synthetic */ int access$702(PackageRule r8, int r10) {
            r8.autoDualWlanMode = r10;
            return r10;
        }

        public static /* synthetic */ boolean access$802(PackageRule r8, boolean r10) {
            r8.flowSchedEnable = r10;
            return r10;
        }

        public static PackageRule defaultRule() {
            PackageRule r8 = new PackageRule();
            r8.enable = false;
            r8.autoDualWlanMode = 0;
            r8.flowSchedEnable = true;
            r8.cellularAccelEnable = false;
            return r8;
        }

        public static PackageRule fromJson(JSONObject r8) {
            PackageRule r10 = defaultRule();
            if (r8 != null) goto L5;
            return r10;
        L5:
            boolean r11 = r8.optBoolean("enable", false);
            int r12 = r8.optInt("autoDualWlanMode", 0);
            boolean r13 = r8.optBoolean("flowSchedEnable", true);
            boolean r14 = r8.optBoolean("cellularAccelEnable", false);
            r10.enable = r11;
            r10.autoDualWlanMode = r12;
            r10.flowSchedEnable = r13;
            r10.cellularAccelEnable = r14;
            return r10;
        }

        public int getAutoDualWlanMode() {
            return this.autoDualWlanMode;
        }

        public boolean getCellularAccelEnable() {
            return this.cellularAccelEnable;
        }

        public boolean getFlowSchedEnable() {
            return this.flowSchedEnable;
        }

        public boolean isEnable() {
            return this.enable;
        }

        public PackageRule setAutoDualWlanMode(int r8) {
            this.autoDualWlanMode = r8;
            return this;
        }

        public PackageRule setCellularAccelEnable(boolean r8) {
            this.cellularAccelEnable = r8;
            return this;
        }

        public PackageRule setEnable(boolean r8) {
            this.enable = r8;
            return this;
        }

        public PackageRule setFlowSchedEnable(boolean r8) {
            this.flowSchedEnable = r8;
            return this;
        }

        public JSONObject toJson() {
            JSONObject r8 = new JSONObject();
            r8.put("enable", this.enable);
            r8.put("autoDualWlanMode", this.autoDualWlanMode);
            r8.put("flowSchedEnable", this.flowSchedEnable);
            r8.put("cellularAccelEnable", this.cellularAccelEnable);
            return r8;
        }
    }

    public static class QuotaCfg {
        public static final String FIXED = "fixed";
        public static final String SPEED_BASED = "speed_based";
        public int cellular;
        public String mode;
        public float speedRatioThreshold;
        public int wifi24;
        public int wifi5;

        public QuotaCfg() {
            this("speed_based", 1, 1, 1, AccelConfigManager.DEFAULT_QUOTA_SPEED_RATIO_THRESHOLD);
        }

        public static QuotaCfg defaultConfig() {
            return new QuotaCfg();
        }

        public static QuotaCfg fromJson(JSONObject r8) {
            if (r8 != null) goto L6;
            return defaultConfig();
        L6:
            return new QuotaCfg(r8.optString("mode", "speed_based"), r8.optInt("wifi_24", 1), r8.optInt("wifi_5", 1), r8.optInt("cellular", 1), (float) r8.optDouble("speed_ratio_threshold", 0.5d));
        }

        public JSONObject toJson() {
            JSONObject r8 = new JSONObject();
            String r10 = this.mode;
            if (r10 != null) goto L6;
            r10 = "speed_based";
        L6:
            r8.put("mode", r10);
            r8.put("wifi_24", this.wifi24);
            r8.put("wifi_5", this.wifi5);
            r8.put("cellular", this.cellular);
            r8.put("speed_ratio_threshold", this.speedRatioThreshold);
            return r8;
        }

        public String toString() {
            return toJson().toString();
        L5:
            return "QuotaCfg{mode=" + this.mode + ", wifi24=" + this.wifi24 + ", wifi5=" + this.wifi5 + ", cellular=" + this.cellular + ", speedRatioThreshold=" + this.speedRatioThreshold + "}";
        }

        public QuotaCfg(String r8, int r10, int r11, int r12, float r13) {
            if (r8 != null) goto L5;
            r8 = "speed_based";
        L5:
            this.mode = r8;
            this.wifi24 = r10;
            this.wifi5 = r11;
            this.cellular = r12;
            this.speedRatioThreshold = r13;
        }
    }

    public class SettingsObserver extends ContentObserver {
        private final List<Uri> mSettingUris;
        final /* synthetic */ AccelConfigManager this$0;

        public SettingsObserver(AccelConfigManager r14) {
            this.this$0 = r14;
            super(null);
            this.mSettingUris = Arrays.asList(new Uri[]{Settings.Global.getUriFor(AccelConfigManager.KEY_GLOBAL_ENABLE), Settings.Global.getUriFor(AccelConfigManager.KEY_CELLULAR_ACCEL_ENABLE), Settings.Global.getUriFor(AccelConfigManager.KEY_AUTO_DUAL_WLAN_ENABLE), Settings.Global.getUriFor(AccelConfigManager.KEY_DUAL_WLAN_ACCEL_ENABLE), Settings.Global.getUriFor(AccelConfigManager.KEY_APP_TRAFFIC_COLLECT_ENABLE), Settings.Global.getUriFor(AccelConfigManager.KEY_APP_TRAFFIC_COLLECT_PACKAGES), Settings.Global.getUriFor(AccelConfigManager.KEY_ACCEL_QUOTA), Settings.Global.getUriFor(AccelConfigManager.KEY_PRECEPTION_ENABLE), Settings.Global.getUriFor(AccelConfigManager.KEY_PRECEPTION_WEAK_THRESHOLD), Settings.Global.getUriFor(AccelConfigManager.KEY_PRECEPTION_GOOD_THRESHOLD), Settings.Global.getUriFor(AccelConfigManager.KEY_PRECEPTION_REDUCE_OFFLOAD_PERCENT), Settings.Global.getUriFor(AccelConfigManager.KEY_PRECEPTION_REDUCE_OFFLOAD_INTERVAL), Settings.Global.getUriFor(AccelConfigManager.KEY_FLOW_SCHED_INTERVAL)});
        }

        public List<Uri> getSettingUris() {
            return this.mSettingUris;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r8, Uri r10) {
            if (this.mSettingUris.contains(r10) == true) goto L6;
            AccelConfigManager.access$000("Unexpected settings observation: " + r10, null);
            return;
        L6:
            AccelConfigManager.access$100("Configuration changed: " + r10);
            if (r10.equals(Settings.Global.getUriFor(AccelConfigManager.KEY_GLOBAL_ENABLE)) == false) goto L10;
            AccelConfigManager r11 = this.this$0;
            AccelConfigManager.access$200(r11, r11.isGlobalAccelEnabled());
            return;
        L10:
            if (r10.equals(Settings.Global.getUriFor(AccelConfigManager.KEY_AUTO_DUAL_WLAN_ENABLE)) == false) goto L13;
            AccelConfigManager r12 = this.this$0;
            AccelConfigManager.access$300(r12, r12.isAutoDualWlanEnabled());
            return;
        L13:
            if (r10.equals(Settings.Global.getUriFor(AccelConfigManager.KEY_APP_TRAFFIC_COLLECT_ENABLE)) == false) goto L16;
            AccelConfigManager r13 = this.this$0;
            AccelConfigManager.access$400(r13, r13.isAppTrafficCollectEnabled());
            return;
        L16:
            if (r10.equals(Settings.Global.getUriFor(AccelConfigManager.KEY_APP_TRAFFIC_COLLECT_PACKAGES)) == false) goto L22;
            AccelConfigManager r14 = this.this$0;
            AccelConfigManager.access$500(r14, r14.getAppTrafficCollectPackages());
            return;
        }
    }

    static {
        ArrayList r8 = new ArrayList();
        DEFAULT_APP_TRAFFIC_COLLECT_PACKAGES = r8;
        r8.add("com.juqing.cesuwang");
        r8.add("cn.nokia.speedtest5g");
        r8.add("make.more.r2d2.cellular_z");
        r8.add("com.uusense.speed");
        r8.add(VipAppManager.PACKAGE_NAME_DOWNLOADSERVER);
        r8.add("zte.com.market");
        DEFAULT_PRECEPTION_REDUCE_OFFLOAD_PERCENT = new int[]{50, 100};
        HashMap r10 = new HashMap();
        DEFAULT_PACKAGE_RULES = r10;
        r10.put("com.juqing.cesuwang", PackageRule.defaultRule().setEnable(true).setAutoDualWlanMode(1));
        r10.put("cn.nokia.speedtest5g", PackageRule.defaultRule().setEnable(true).setAutoDualWlanMode(1));
        r10.put("make.more.r2d2.cellular_z", PackageRule.defaultRule().setEnable(true).setAutoDualWlanMode(1));
        r10.put("com.uusense.speed", PackageRule.defaultRule().setEnable(true).setAutoDualWlanMode(1));
        r10.put(VipAppManager.PACKAGE_NAME_DOWNLOADSERVER, PackageRule.defaultRule().setEnable(true).setAutoDualWlanMode(2));
        r10.put("zte.com.market", PackageRule.defaultRule().setEnable(true).setAutoDualWlanMode(2).setFlowSchedEnable(true).setCellularAccelEnable(true));
    }

    private AccelConfigManager(Context r8) {
        this.mCallbacks = new CopyOnWriteArrayList();
        Context r10 = r8.getApplicationContext();
        this.mContext = r10;
        this.mResolver = r10.getContentResolver();
        this.mPrefs = r10.getSharedPreferences(PREFS_NAME, 0);
        SettingsObserver r11 = new SettingsObserver(this);
        this.mSettingObserver = r11;
        Iterator<Uri> r12 = r11.getSettingUris().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        Uri r13 = r12.next();
        this.mResolver.registerContentObserver(r13, false, this.mSettingObserver);
        goto L4
    L6:
        logDebug("make AccelConfigManager");
        dumpSettings();
    }

    public static /* synthetic */ void access$000(String r8, Throwable r10) {
        logWarn(r8, r10);
    }

    public static /* synthetic */ void access$100(String r8) {
        logDebug(r8);
    }

    public static /* synthetic */ void access$200(AccelConfigManager r8, boolean r10) {
        r8.notifyGlobalAccelEnableChanged(r10);
    }

    public static /* synthetic */ void access$300(AccelConfigManager r8, boolean r10) {
        r8.notifyAutoDualWlanEnableChanged(r10);
    }

    public static /* synthetic */ void access$400(AccelConfigManager r8, boolean r10) {
        r8.notifyAppTrafficCollectEnableChanged(r10);
    }

    public static /* synthetic */ void access$500(AccelConfigManager r8, List r10) {
        r8.notifyAppTrafficCollectPackagesChanged(r10);
    }

    private boolean getGlobalBoolean(String r8, boolean r10) {
        ContentResolver r11 = this.mResolver;
        if (r11 != null) goto L15;
        logWarn(defpackage.b.c("getGlobalBoolean: resolver is null, key=", r8), null);
        return r10;
    L15:
        if (Settings.Global.getInt(r11, r8, r10 ? 1 : 0) == 0) goto L11;
        return true;
    L11:
        return false;
    L12:
        th = move-exception;
        logWarn(defpackage.b.c("getGlobalBoolean: fail, key=", r8), th);
        return r10;
    }

    private int getGlobalInt(String r8, int r10) {
        ContentResolver r11 = this.mResolver;
        if (r11 != null) goto L11;
        logWarn(defpackage.b.c("getGlobalInt: resolver is null, key=", r8), null);
        return r10;
    L11:
        return Settings.Global.getInt(r11, r8, r10);
    L8:
        th = move-exception;
        logWarn(defpackage.b.c("getGlobalInt: fail, key=", r8), th);
        return r10;
    }

    private String getGlobalString(String r8) {
        ContentResolver r10 = this.mResolver;
        if (r10 != null) goto L11;
        logWarn(defpackage.b.c("getGlobalString: resolver is null, key=", r8), null);
        return null;
    L11:
        return Settings.Global.getString(r10, r8);
    L8:
        th = move-exception;
        logWarn(defpackage.b.c("getGlobalString: fail, key=", r8), th);
        return null;
    }

    public static AccelConfigManager getInstance(Context r8) {
        if (instance != null) goto L15;
        monitor-enter(AccelConfigManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new AccelConfigManager(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(AccelConfigManager.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    private static boolean isNullOrEmpty(String r8) {
        if (r8 != null) goto L4;
    L7:
        return true;
    L4:
        if (r8.length() == 0) goto L7;
        return false;
    }

    private static void logDebug(String r8) {
        CaeLog.d(TAG, r8);     // Catch: Throwable -> L4
        return;
    }

    private static void logWarn(String r8, Throwable r10) {
        if (r10 != null) goto L8;
    L5:
        CaeLog.w(TAG, r8);     // Catch: Throwable -> L7
        return;
    L10:
        return;
    L8:
        r8 = r8 + ": " + r10.getMessage();     // Catch: Throwable -> L7
        goto L5
    }

    private void notifyAppTrafficCollectEnableChanged(boolean r8) {
        Iterator<ConfigChangeCallback> r10 = this.mCallbacks.iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        r10.next().onAppTrafficCollectEnableChanged(r8);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        logWarn("notifyAppTrafficCollectEnableChanged failed", e);
        goto L4
    }

    private void notifyAppTrafficCollectPackagesChanged(List<String> r8) {
        Iterator<ConfigChangeCallback> r10 = this.mCallbacks.iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        r10.next().onAppTrafficCollectPackagesChanged(r8);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        logWarn("notifyAppTrafficCollectPackagesChanged failed", e);
        goto L4
    }

    private void notifyAutoDualWlanEnableChanged(boolean r8) {
        Iterator<ConfigChangeCallback> r10 = this.mCallbacks.iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        r10.next().onDualWlanAccelEnableChanged(r8);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        logWarn("notifyAutoDualWlanEnableChanged failed", e);
        goto L4
    }

    private void notifyGlobalAccelEnableChanged(boolean r8) {
        Iterator<ConfigChangeCallback> r10 = this.mCallbacks.iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        r10.next().onGlobalAccelEnableChanged(r8);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        logWarn("notifyGlobalAccelEnableChanged failed", e);
        goto L4
    }

    private void notifyPackagesRulesChanged() {
        Iterator<ConfigChangeCallback> r8 = this.mCallbacks.iterator();
    L4:
        if (r8.hasNext() == false) goto L10;
        r8.next().onAllPackagesRulesChanged();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        logWarn("notifyPackagesRulesChanged failed", e);
        goto L4
    }

    private void setAllPackageRules(Map<String, PackageRule> r8) {
        if (this.mPrefs != null) goto L6;
        logWarn("setAllPackageRules: mPrefs is null", null);
        return;
    L6:
        if (r8 != null) goto L8;
    L12:
        this.mPrefs.edit().remove(KEY_PACKAGE_RULES).apply();
        return;
    L8:
        if (r8.isEmpty() == true) goto L12;
        setAllPackageRulesInternal(new HashMap(r8));
    }

    private void setAllPackageRulesInternal(Map<String, PackageRule> r8) {
        if (this.mPrefs != null) goto L18;
        return;
    L18:
        JSONObject r10 = new JSONObject();     // Catch: JSONException -> L15
        Iterator<Map.Entry<String, PackageRule>> r11 = r8.entrySet().iterator();     // Catch: JSONException -> L15
    L7:
        if (r11.hasNext() == false) goto L13;
        Map.Entry<String, PackageRule> r12 = r11.next();     // Catch: JSONException -> L15
        String r13 = r12.getKey();     // Catch: JSONException -> L15
        PackageRule r14 = r12.getValue();     // Catch: JSONException -> L15
        if (isNullOrEmpty(r13) == true) goto L7;
        if (r14 == null) goto L7;
        r10.put(r13, r14.toJson());     // Catch: JSONException -> L15
        goto L7
    L13:
        this.mPrefs.edit().putString(KEY_PACKAGE_RULES, r10.toString()).apply();     // Catch: JSONException -> L15
        return;
    L15:
        e = move-exception;
        logWarn("setAllPackageRulesInternal: build json failed", e);
    }

    private void setAppTrafficCollectEnabled(boolean r8) {
        setGlobalBoolean(KEY_APP_TRAFFIC_COLLECT_ENABLE, r8);
    }

    private void setAppTrafficCollectPackages(List<String> r8) {
        JSONArray r10 = new JSONArray();     // Catch: Exception -> L8
        Iterator<String> r11 = r8.iterator();     // Catch: Exception -> L8
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.put(r11.next());     // Catch: Exception -> L8
        goto L4
    L6:
        setGlobalString(KEY_APP_TRAFFIC_COLLECT_PACKAGES, r10.toString());     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        logWarn("setAppTrafficCollectPackages: error", e);
    }

    private void setAutoDualWlanEnabled(boolean r8) {
        setGlobalBoolean(KEY_AUTO_DUAL_WLAN_ENABLE, r8);
    }

    private void setCellularAccelEnabled(boolean r8) {
        setGlobalBoolean(KEY_CELLULAR_ACCEL_ENABLE, r8);
    }

    private void setDualWlanAccelEnabled(boolean r8) {
        setGlobalBoolean(KEY_DUAL_WLAN_ACCEL_ENABLE, r8);
    }

    private void setFlowSchedIntervalMs(int r8) {
        setGlobalInt(KEY_FLOW_SCHED_INTERVAL, r8);
    }

    private void setGlobalAccelEnabled(boolean r8) {
        setGlobalBoolean(KEY_GLOBAL_ENABLE, r8);
    }

    private void setGlobalBoolean(String r8, boolean r10) {
        ContentResolver r11 = this.mResolver;
        if (r11 != null) goto L11;
        logWarn(defpackage.b.c("setGlobalBoolean: resolver is null, key=", r8), null);
        return;
    L11:
        Settings.Global.putInt(r11, r8, r10 ? 1 : 0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        logWarn(defpackage.b.c("setGlobalBoolean: fail, key=", r8), th);
    }

    private void setGlobalInt(String r8, int r10) {
        ContentResolver r11 = this.mResolver;
        if (r11 != null) goto L11;
        logWarn(defpackage.b.c("setGlobalInt: resolver is null, key=", r8), null);
        return;
    L11:
        Settings.Global.putInt(r11, r8, r10);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        logWarn(defpackage.b.c("setGlobalInt: fail, key=", r8), th);
    }

    private void setGlobalString(String r8, String r10) {
        ContentResolver r11 = this.mResolver;
        if (r11 != null) goto L11;
        logWarn(defpackage.b.c("setGlobalString: resolver is null, key=", r8), null);
        return;
    L11:
        Settings.Global.putString(r11, r8, r10);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        logWarn(defpackage.b.c("setGlobalString: fail, key=", r8), th);
    }

    private void setNetworkPerceptionEnabled(boolean r8) {
        setGlobalBoolean(KEY_PRECEPTION_ENABLE, r8);
    }

    private void setNetworkPerceptionGoodThreshold(int r8) {
        setGlobalInt(KEY_PRECEPTION_GOOD_THRESHOLD, r8);
    }

    private void setNetworkPerceptionReduceOffloadIntervalMs(int r8) {
        setGlobalInt(KEY_PRECEPTION_REDUCE_OFFLOAD_INTERVAL, r8);
    }

    private void setNetworkPerceptionReduceOffloadPercent(int[] r8) {
        if (r8 != null) goto L4;
    L5:
        r8 = DEFAULT_PRECEPTION_REDUCE_OFFLOAD_PERCENT;
    L14:
        JSONArray r10 = new JSONArray();     // Catch: Exception -> L11
        int r11 = r8.length;     // Catch: Exception -> L11
        int r12 = 0;
    L7:
        if (r12 >= r11) goto L9;
        r10.put(r8[r12]);     // Catch: Exception -> L11
        r12 = r12 + 1;     // Catch: Exception -> L11
        goto L7
    L9:
        setGlobalString(KEY_PRECEPTION_REDUCE_OFFLOAD_PERCENT, r10.toString());     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        logWarn("setNetworkPerceptionReduceOffloadPercent: build json failed", e);
        return;
    L4:
        if (r8.length != 0) goto L14;
        goto L5
    }

    private void setNetworkPerceptionWeakThreshold(int r8) {
        setGlobalInt(KEY_PRECEPTION_WEAK_THRESHOLD, r8);
    }

    private void setQuotaConfig(QuotaCfg r8) {
        if (r8 != null) goto L10;
        r8 = QuotaCfg.defaultConfig();
    L10:
        setGlobalString(KEY_ACCEL_QUOTA, r8.toJson().toString());     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        logWarn("setQuotaConfig: toJson failed", e);
    }

    public void dumpSettings() {
        logDebug("dumpSettings:");
        logDebug("multi_net_accel_global_enable=" + isGlobalAccelEnabled());
        logDebug("multi_net_cellular_accel_enable=" + isCellularAccelEnabled());
        logDebug("multi_net_auto_dual_wlan_enable=" + isAutoDualWlanEnabled());
        logDebug("multi_net_dual_wlan_accel_enable=" + isDualWlanAccelEnabled());
        logDebug("multi_net_accel_quota=" + getQuotaConfig());
        logDebug("multi_net_preception_enable=" + isNetworkPerceptionEnabled());
        logDebug("multi_net_preception_weak_threshold=" + getNetworkPerceptionWeakThreshold());
        logDebug("multi_net_preception_good_threshold=" + getNetworkPerceptionGoodThreshold());
        logDebug("multi_net_preception_reduce_offload_percent=" + Arrays.toString(getNetworkPerceptionReduceOffloadPercent()));
        logDebug("multi_net_preception_reduce_offload_interval=" + getNetworkPerceptionReduceOffloadIntervalMs());
        logDebug("multi_net_flow_sched_interval=" + getFlowSchedIntervalMs());
    }

    public Map<String, PackageRule> getAllPackageRules() {
        HashMap r8 = new HashMap(DEFAULT_PACKAGE_RULES);
        SharedPreferences r10 = this.mPrefs;
        if (r10 != null) goto L6;
        logWarn("getAllPackageRules: mPrefs is null", null);
        return r8;
    L6:
        String r11 = r10.getString(KEY_PACKAGE_RULES, null);
        if (isNullOrEmpty(r11) == false) goto L27;
        return r8;
    L27:
        JSONObject r12 = new JSONObject(r11);     // Catch: JSONException -> L24
        Iterator<String> r13 = r12.keys();     // Catch: JSONException -> L24
    L10:
        if (r13.hasNext() == false) goto L23;
        String r14 = r13.next();     // Catch: JSONException -> L24
        if (isNullOrEmpty(r14) == true) goto L10;
        JSONObject r15 = r12.optJSONObject(r14);     // Catch: Exception -> L20
        if (r15 == null) goto L10;
        r8.put(r14, PackageRule.fromJson(r15));     // Catch: Exception -> L20
    L20:
        e = move-exception;
        logWarn("getAllPackageRules: parse rule failed for pkg=" + r14, e);     // Catch: JSONException -> L24
        goto L10
    L23:
        return r8;
    L24:
        e = move-exception;
        logWarn("getAllPackageRules: parse root json failed", e);
        return r8;
    }

    public List<String> getAppTrafficCollectPackages() {
        String r8 = getGlobalString(KEY_APP_TRAFFIC_COLLECT_PACKAGES);
        if (r8 == null) goto L5;
        JSONArray r10 = new JSONArray(r8);     // Catch: JSONException -> L12
        ArrayList r11 = new ArrayList();     // Catch: JSONException -> L12
        int r12 = 0;
    L8:
        if (r12 >= r10.length()) goto L11;
        r11.add(r10.optString(r12));     // Catch: JSONException -> L12
        r12 = r12 + 1;
        goto L8
    L11:
        return r11;
    L12:
        e = move-exception;
        logWarn("getAppTrafficCollectPackages: parse error", e);
        return DEFAULT_APP_TRAFFIC_COLLECT_PACKAGES;
    L5:
        return DEFAULT_APP_TRAFFIC_COLLECT_PACKAGES;
    }

    public int getFlowSchedIntervalMs() {
        return getGlobalInt(KEY_FLOW_SCHED_INTERVAL, 5000);
    }

    public int getNetworkPerceptionGoodThreshold() {
        return getGlobalInt(KEY_PRECEPTION_GOOD_THRESHOLD, 5);
    }

    public int getNetworkPerceptionReduceOffloadIntervalMs() {
        return getGlobalInt(KEY_PRECEPTION_REDUCE_OFFLOAD_INTERVAL, 10000);
    }

    public int[] getNetworkPerceptionReduceOffloadPercent() {
        String r8 = getGlobalString(KEY_PRECEPTION_REDUCE_OFFLOAD_PERCENT);
        if (isNullOrEmpty(r8) == false) goto L18;
        Object r10 = DEFAULT_PRECEPTION_REDUCE_OFFLOAD_PERCENT.clone();
    L6:
        return (int[]) r10;
    L18:
        JSONArray r11 = new JSONArray(r8);     // Catch: JSONException -> L16
        int r12 = r11.length();     // Catch: JSONException -> L16
        if (r12 <= 0) goto L10;
        int[] r13 = new int[r12];     // Catch: JSONException -> L16
        int r14 = 0;
    L12:
        if (r14 >= r12) goto L15;
        r13[r14] = r11.optInt(r14, DEFAULT_PRECEPTION_REDUCE_OFFLOAD_PERCENT[0]);     // Catch: JSONException -> L16
        r14 = r14 + 1;
        goto L12
    L15:
        return r13;
    L10:
        return (int[]) DEFAULT_PRECEPTION_REDUCE_OFFLOAD_PERCENT.clone();
    L16:
        e = move-exception;
        logWarn("getNetworkPerceptionReduceOffloadPercent: parse error, use default", e);
        r10 = DEFAULT_PRECEPTION_REDUCE_OFFLOAD_PERCENT.clone();
        goto L6
    }

    public int getNetworkPerceptionWeakThreshold() {
        return getGlobalInt(KEY_PRECEPTION_WEAK_THRESHOLD, 5);
    }

    public boolean getPackageAccelEnable(String r8) {
        if (isNullOrEmpty(r8) == false) goto L7;
        return false;
    L7:
        return PackageRule.access$600(getPackageRule(r8));
    }

    public int getPackageAutoDualWlanMode(String r8) {
        if (isNullOrEmpty(r8) == false) goto L7;
        return 0;
    L7:
        return PackageRule.access$700(getPackageRule(r8));
    }

    public PackageRule getPackageRule(String r8) {
        if (isNullOrEmpty(r8) == true) goto L5;
        PackageRule r10 = getAllPackageRules().get(r8);
        if (r10 == null) goto L10;
        return r10;
    L10:
        return PackageRule.defaultRule();
    L5:
        return PackageRule.defaultRule();
    }

    public QuotaCfg getQuotaConfig() {
        String r8 = getGlobalString(KEY_ACCEL_QUOTA);
        if (isNullOrEmpty(r8) == false) goto L11;
        logDebug("getQuotaConfig: use default, empty value");
    L6:
        return QuotaCfg.defaultConfig();
    L11:
        return QuotaCfg.fromJson(new JSONObject(r8));
    L9:
        e = move-exception;
        logWarn("getQuotaConfig: parse error, use default", e);
        goto L6
    }

    public int getValidWifiRxLinkSpeed() {
        return 50;
    }

    public boolean isAppTrafficCollectEnabled() {
        return getGlobalBoolean(KEY_APP_TRAFFIC_COLLECT_ENABLE, true);
    }

    public boolean isAutoDualWlanEnabled() {
        return getGlobalBoolean(KEY_AUTO_DUAL_WLAN_ENABLE, true);
    }

    public boolean isCellularAccelEnabled() {
        return getGlobalBoolean(KEY_CELLULAR_ACCEL_ENABLE, false);
    }

    public boolean isDualWlanAccelEnabled() {
        return getGlobalBoolean(KEY_DUAL_WLAN_ACCEL_ENABLE, false);
    }

    public boolean isGlobalAccelEnabled() {
        return getGlobalBoolean(KEY_GLOBAL_ENABLE, true);
    }

    public boolean isNetworkPerceptionEnabled() {
        return getGlobalBoolean(KEY_PRECEPTION_ENABLE, true);
    }

    public void registerConfigChangeCallback(ConfigChangeCallback r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (this.mCallbacks.contains(r8) == true) goto L8;
        this.mCallbacks.add(r8);
        return;
    }

    public void setPackageAccelEnable(String r8, boolean r10) {
        if (isNullOrEmpty(r8) == false) goto L6;
        logWarn("setPackageAccelEnable: empty packageName", null);
        return;
    L6:
        PackageRule r11 = new PackageRule(getPackageRule(r8));
        PackageRule.access$602(r11, r10);
        setPackageRule(r8, r11);
    }

    public void setPackageAutoDualWlanMode(String r8, int r10) {
        if (isNullOrEmpty(r8) == false) goto L6;
        logWarn("setPackageAutoDualWlanMode: empty packageName", null);
        return;
    L6:
        if (r10 != 0) goto L8;
    L13:
        PackageRule r11 = new PackageRule(getPackageRule(r8));
        PackageRule.access$702(r11, r10);
        setPackageRule(r8, r11);
        return;
    L8:
        if (r10 == 1) goto L13;
        if (r10 == 2) goto L13;
        logWarn(defpackage.a.d("setPackageAutoDualWlanMode: invalid mode ", r10), null);
    }

    public void setPackageFlowSched(String r8, boolean r10) {
        if (isNullOrEmpty(r8) == false) goto L6;
        logWarn("setPackageFlowSched: empty packageName", null);
        return;
    L6:
        PackageRule r11 = new PackageRule(getPackageRule(r8));
        PackageRule.access$802(r11, r10);
        setPackageRule(r8, r11);
    }

    public void setPackageRule(String r8, PackageRule r10) {
        if (this.mPrefs != null) goto L8;
        String r11 = "setPackageRule: mPrefs is null";
    L5:
        logWarn(r11, null);
        return;
    L8:
        if (isNullOrEmpty(r8) == false) goto L10;
        r11 = "setPackageRule: empty packageName";
        goto L5
    L10:
        HashMap r12 = new HashMap(getAllPackageRules());
        if (r10 != null) goto L13;
        r12.remove(r8);
    L14:
        setAllPackageRulesInternal(r12);
        return;
    L13:
        r12.put(r8, r10);
        goto L14
    }

    public void unregisterConfigChangeCallback(ConfigChangeCallback r8) {
        if (r8 == null) goto L5;
        this.mCallbacks.remove(r8);
        return;
    }

    public void updateSettings(String r19) {
        JSONObject r15 = new JSONObject(r19);     // Catch: JSONException -> L108
        if (r15.has(KEY_GLOBAL_ENABLE) == false) goto L6;
        setGlobalAccelEnabled(r15.optBoolean(KEY_GLOBAL_ENABLE, true));     // Catch: JSONException -> L108
    L6:
        int r14 = 0;
        if (r15.has(KEY_CELLULAR_ACCEL_ENABLE) == false) goto L10;
        setCellularAccelEnabled(r15.optBoolean(KEY_CELLULAR_ACCEL_ENABLE, false));     // Catch: JSONException -> L108
    L10:
        if (r15.has(KEY_AUTO_DUAL_WLAN_ENABLE) == false) goto L13;
        setAutoDualWlanEnabled(r15.optBoolean(KEY_AUTO_DUAL_WLAN_ENABLE, true));     // Catch: JSONException -> L108
    L13:
        if (r15.has(KEY_DUAL_WLAN_ACCEL_ENABLE) == false) goto L16;
        setDualWlanAccelEnabled(r15.optBoolean(KEY_DUAL_WLAN_ACCEL_ENABLE, false));     // Catch: JSONException -> L108
    L16:
        if (r15.has(KEY_APP_TRAFFIC_COLLECT_ENABLE) == false) goto L19;
        setAppTrafficCollectEnabled(r15.optBoolean(KEY_APP_TRAFFIC_COLLECT_ENABLE, true));     // Catch: JSONException -> L108
    L19:
        if (r15.has(KEY_APP_TRAFFIC_COLLECT_PACKAGES) == false) goto L31;
        String r8 = r15.optString(KEY_APP_TRAFFIC_COLLECT_PACKAGES);     // Catch: JSONException -> L108
        if (isNullOrEmpty(r8) == true) goto L31;
        JSONArray r10 = new JSONArray(r8);     // Catch: JSONException -> L28
        ArrayList r11 = new ArrayList();     // Catch: JSONException -> L28
        int r12 = 0;
    L24:
        if (r12 >= r10.length()) goto L26;
        r11.add(r10.optString(r12));     // Catch: JSONException -> L28
        r12 = r12 + 1;     // Catch: JSONException -> L28
        goto L24
    L26:
        setAppTrafficCollectPackages(r11);     // Catch: JSONException -> L28
    L28:
        e = move-exception;
        logWarn("updateSettings: parse app traffic collect packages error", e);     // Catch: JSONException -> L108
    L31:
        if (r15.has(KEY_ACCEL_QUOTA) == false) goto L39;
        String r13 = r15.optString(KEY_ACCEL_QUOTA);     // Catch: JSONException -> L108
        if (isNullOrEmpty(r13) == true) goto L39;
        setQuotaConfig(QuotaCfg.fromJson(new JSONObject(r13)));     // Catch: JSONException -> L36
    L36:
        e = move-exception;
        logWarn("updateSettings: parse quota config error", e);     // Catch: JSONException -> L108
    L39:
        if (r15.has(KEY_PRECEPTION_ENABLE) == false) goto L42;
        setNetworkPerceptionEnabled(r15.optBoolean(KEY_PRECEPTION_ENABLE, false));     // Catch: JSONException -> L108
    L42:
        if (r15.has(KEY_PRECEPTION_WEAK_THRESHOLD) == false) goto L45;
        setNetworkPerceptionWeakThreshold(r15.optInt(KEY_PRECEPTION_WEAK_THRESHOLD, 5));     // Catch: JSONException -> L108
    L45:
        if (r15.has(KEY_PRECEPTION_GOOD_THRESHOLD) == false) goto L48;
        setNetworkPerceptionGoodThreshold(r15.optInt(KEY_PRECEPTION_GOOD_THRESHOLD, 5));     // Catch: JSONException -> L108
    L48:
        if (r15.has(KEY_PRECEPTION_REDUCE_OFFLOAD_PERCENT) == false) goto L61;
        String r16 = r15.optString(KEY_PRECEPTION_REDUCE_OFFLOAD_PERCENT);     // Catch: JSONException -> L108
        if (isNullOrEmpty(r16) == true) goto L61;
        JSONArray r17 = new JSONArray(r16);     // Catch: JSONException -> L58
        int r18 = r17.length();     // Catch: JSONException -> L58
        if (r18 <= 0) goto L61;
        int[] r20 = new int[r18];     // Catch: JSONException -> L58
    L54:
        if (r14 >= r18) goto L56;
        r20[r14] = r17.optInt(r14);     // Catch: JSONException -> L58
        r14 = r14 + 1;     // Catch: JSONException -> L58
        goto L54
    L56:
        setNetworkPerceptionReduceOffloadPercent(r20);     // Catch: JSONException -> L58
    L58:
        e = move-exception;
        logWarn("updateSettings: parse reduce offload percent error", e);     // Catch: JSONException -> L108
    L61:
        if (r15.has(KEY_PRECEPTION_REDUCE_OFFLOAD_INTERVAL) == false) goto L64;
        setNetworkPerceptionReduceOffloadIntervalMs(r15.optInt(KEY_PRECEPTION_REDUCE_OFFLOAD_INTERVAL, 10000));     // Catch: JSONException -> L108
    L64:
        if (r15.has(KEY_FLOW_SCHED_INTERVAL) == false) goto L67;
        setFlowSchedIntervalMs(r15.optInt(KEY_FLOW_SCHED_INTERVAL, 5000));     // Catch: JSONException -> L108
    L67:
        if (r15.has(KEY_PACKAGE_RULES) == false) goto L110;
        String r21 = r15.optString(KEY_PACKAGE_RULES);     // Catch: JSONException -> L108
        if (isNullOrEmpty(r21) == true) goto L110;
        JSONObject r22 = new JSONObject(r21);     // Catch: JSONException -> L105
        HashMap r23 = new HashMap();     // Catch: JSONException -> L105
        SharedPreferences r24 = this.mPrefs;     // Catch: JSONException -> L105
        if (r24 == null) goto L90;
        String r25 = r24.getString(KEY_PACKAGE_RULES, null);     // Catch: JSONException -> L105
        if (isNullOrEmpty(r25) == true) goto L90;
        JSONObject r26 = new JSONObject(r25);     // Catch: JSONException -> L88
        Iterator<String> r27 = r26.keys();     // Catch: JSONException -> L88
    L75:
        if (r27.hasNext() == false) goto L90;
        String r28 = r27.next();     // Catch: JSONException -> L88
        if (isNullOrEmpty(r28) == true) goto L75;
        JSONObject r29 = r26.optJSONObject(r28);     // Catch: Exception -> L85
        if (r29 == null) goto L75;
        r23.put(r28, PackageRule.fromJson(r29));     // Catch: Exception -> L85
    L85:
        e = move-exception;
        logWarn("updateSettings: parse existing package rule failed for pkg=" + r28, e);     // Catch: JSONException -> L88
        goto L75
    L88:
        e = move-exception;
        logWarn("updateSettings: parse existing package rules error", e);     // Catch: JSONException -> L105
    L90:
        Iterator<String> r30 = r22.keys();     // Catch: JSONException -> L105
    L92:
        if (r30.hasNext() == false) goto L103;
        String r31 = r30.next();     // Catch: JSONException -> L105
        if (isNullOrEmpty(r31) == true) goto L92;
        JSONObject r32 = r22.optJSONObject(r31);     // Catch: Exception -> L101
        if (r32 == null) goto L92;
        r23.put(r31, PackageRule.fromJson(r32));     // Catch: Exception -> L101
    L101:
        e = move-exception;
        logWarn("updateSettings: parse package rule failed for pkg=" + r31, e);     // Catch: JSONException -> L105
        goto L92
    L103:
        setAllPackageRules(r23);     // Catch: JSONException -> L105
        notifyPackagesRulesChanged();     // Catch: JSONException -> L105
    L105:
        e = move-exception;
        logWarn("updateSettings: parse package rules error", e);     // Catch: JSONException -> L108
    L110:
        logDebug("updateSettings always");
        dumpSettings();
        return;
    L108:
        e = move-exception;
        logWarn("updateSettings: parse config error", e);
        goto L110
    }
}
