package com.obric.cae.smartNetwork;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import com.obric.cae.cloud.CloudServiceConstants;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.L4NetEvaluate.L4NetEvaluateObserver;
import com.obric.cae.smartNetwork.multipath.MPASettingsObserver;
import com.obric.cae.smartNetwork.nefid.NefidInterface;
import com.obric.cae.smartNetwork.netAccel.AccelConfigManager;
import com.obric.cae.smartNetwork.networkHandover.HandoverParameterManager;
import com.obric.cae.smartNetwork.networkHandoverRL.ModelSettingObserver;
import com.obric.cae.smartNetwork.qoe.CellularQoeEvaluateObserver;
import com.obric.cae.smartNetwork.trafficMonitor.TrafficThreshold;
import com.obric.cae.utils.CaeUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class CloudConfigParseAndSave {
    public static final String BACKGROUD_SCAN_BACK_LIST = "background_scan_back_list";
    public static final String CAPTIVE_PORTAL_CN_HTTPS_URL = "captive_portal_cn_https_url";
    public static final String CAPTIVE_PORTAL_CN_HTTP_URL = "captive_portal_cn_http_url";
    public static final String CAPTIVE_PORTAL_GLOBAL_HTTPS_URL = "captive_portal_global_https_url";
    public static final String CAPTIVE_PORTAL_GLOBAL_HTTP_URL = "captive_portal_global_http_url";
    public static final String CAPTIVE_PORTAL_HTTPS_URL = "captive_portal_https_url";
    public static final String CAPTIVE_PORTAL_HTTP_URL = "captive_portal_http_url";
    public static final String CAPTIVE_PORTAL_USE_HTTPS = "captive_portal_cloud_use_https";
    private static final String CLOUD_CONFIG_ASSOCIATION_REJECT_FAIL_COOLDOWN_MS = "association_reject_fail_cooldown_ms";
    private static final String CLOUD_CONFIG_ASSOCIATION_REJECT_REASON_CODES = "association_reject_reason_codes";
    private static final String CLOUD_CONFIG_ASSOCIATION_REJECT_RSSI_THRESHOLD = "association_reject_rssi_threshold";
    private static final String CLOUD_CONFIG_ASSOCIATION_REJECT_SELF_CURE_ENABLED = "association_reject_self_cure_enabled";
    private static final String CLOUD_CONFIG_DELAYED_DISCONNECT_ABNORMAL_REASON_CODES = "delayed_disconnect_abnormal_reason_codes";
    private static final String CLOUD_CONFIG_DELAYED_DISCONNECT_RSSI_THRESHOLD = "delayed_disconnect_rssi_threshold";
    private static final String CLOUD_CONFIG_DELAYED_DISCONNECT_SELF_CURE_ENABLED = "delayed_disconnect_self_cure_enabled";
    private static final String CLOUD_CONFIG_DELAYED_DISCONNECT_SELF_CURE_FAIL_COOLDOWN_MS = "delayed_disconnect_self_cure_fail_cooldown_ms";
    private static final String CLOUD_CONFIG_DELAYED_DISCONNECT_SELF_CURE_SUCCESS_COOLDOWN_MS = "delayed_disconnect_self_cure_success_cooldown_ms";
    private static final String CLOUD_CONFIG_DELAYED_DISCONNECT_TIMEOUT_MS = "delayed_disconnect_timeout_ms";
    private static final String CLOUD_CONFIG_GATEWAY_CONFLICT_ARP_CHECK_TIME_WINDOW_MS = "gateway_conflict_arp_check_time_window_ms";
    private static final String CLOUD_CONFIG_GATEWAY_CONFLICT_ARP_RESPONSE_ADDRESS_COUNT_THRESHOLD = "gateway_conflict_arp_response_address_count_threshold";
    private static final String CLOUD_CONFIG_GATEWAY_CONFLICT_FAIL_COOLDOWN_MS = "gateway_conflict_fail_cooldown_ms";
    private static final String CLOUD_CONFIG_GATEWAY_CONFLICT_RSSI_THRESHOLD = "gateway_conflict_rssi_threshold";
    private static final String CLOUD_CONFIG_GATEWAY_CONFLICT_SELF_CURE_ENABLED = "gateway_conflict_self_cure_enabled";
    private static final String CLOUD_CONFIG_HANDOVER_MODEL_TOGGLE = "handover_model_toggle";
    private static final String CLOUD_CONFIG_MPA_SETTINGS = "mpa_settings";
    private static final String CLOUD_CONFIG_NETWORK_HANDOVER_SETTINGS = "network_handover_settings";
    private static final String CLOUD_CONFIG_NUD_FAIL_FAIL_COOLDOWN_MS = "nud_fail_fail_cooldown_ms";
    private static final String CLOUD_CONFIG_NUD_FAIL_PROBE_DELAY_MS = "nud_fail_probe_delay_ms";
    private static final String CLOUD_CONFIG_NUD_FAIL_PROBE_TIMEOUT_MS = "nud_fail_probe_timeout_ms";
    private static final String CLOUD_CONFIG_NUD_FAIL_REPORT_COUNT_THRESHOLD = "nud_fail_report_count_threshold";
    private static final String CLOUD_CONFIG_NUD_FAIL_REPORT_TIME_WINDOW_MS = "nud_fail_report_time_window_ms";
    private static final String CLOUD_CONFIG_NUD_FAIL_RSSI_THRESHOLD = "nud_fail_rssi_threshold";
    private static final String CLOUD_CONFIG_NUD_FAIL_SELF_CURE_ENABLED = "nud_fail_self_cure_enabled";
    private static final String CLOUD_CONFIG_THROUGHPUT_FORMLA = "throughput_prediction_formula";
    private static final String CLOUD_CONFIG_THROUGHPUT_FORMLA_2 = "throughput_prediction_formula_2";
    private static final String CLOUD_CONFIG_THROUGHPUT_JITTER_FORMLA = "throughput_prediction_jitter_formula";
    private static final String CLOUD_CONFIG_THROUGHPUT_JITTER_WEIGHT = "throughput_jitter_weight_proportion";
    private static final String CLOUD_CONFIG_TRAFFIC_THRESHOLD = "traffic_threshold";
    private static final String CLOUD_CONFIG_WIFI_ASSOCIATION_REJECT = "wifi_association_reject_config";
    private static final String CLOUD_CONFIG_WIFI_DELAYED_DISCONNECT = "wifi_delayed_disconnect_config";
    private static final String CLOUD_CONFIG_WIFI_GATEWAY_CONFLICT = "wifi_gateway_conflict_config";
    private static final String CLOUD_CONFIG_WIFI_NUD_FAIL = "wifi_nud_fail_config";
    private static final String CLOUD_CONFIG_WIFI_TPUT_THRESHOLDS = "wifi_tput_thresholds";
    private static final String CLOUD_WIFI_AI_QOS_FILES = "wifi_ai_qos_config_files";
    private static final String CLOUD_WLAN_POWER_PRED_MODEL_FILES = "wlan_power_pred_model_files";
    private static final String DEST_BASE_DIR = "/data/misc/caed/";
    private static final String FILE_ORIGINAL_NAME = "original_name";
    public static final String LOW_LATENCY_AC_PRIORITY = "AC_PRIORITY";
    public static final String LOW_LATENCY_AC_PRIORITY_BE = "AC_PRIORITY_BE";
    public static final String LOW_LATENCY_AC_PRIORITY_BG = "AC_PRIORITY_BG";
    public static final String LOW_LATENCY_AC_PRIORITY_VI = "AC_PRIORITY_VI";
    public static final String LOW_LATENCY_AC_PRIORITY_VO = "AC_PRIORITY_VO";
    public static final String LOW_LATENCY_ALIMIT_AMPDU = "LIMIT_AMPDU";
    public static final String LOW_LATENCY_ALWAYS_ACTIVE = "LOW_LATENCY";
    private static final int MSG_UPDATE_CONFIG = 1;
    public static final String NEFID_MODE = "NEFID_MODE";
    public static final String NEFID_MODE_GENERAL = "NEFID_MODE_GENERAL";
    public static final String NEFID_MODE_HIGH_TX_THPUT = "NEFID_MODE_HIGH_TX_THPUT";
    public static final String NEFID_MODE_MAX = "NEFID_MODE_MAX";
    public static final String NEFID_MODE_ONLINE_GAME = "NEFID_MODE_ONLINE_GAME";
    public static final String NEFID_MODE_STREAMING = "NEFID_MODE_STREAMING";
    public static final String NEFID_MODE_TICKETS = "NEFID_MODE_TICKETS";
    private static final String PREF_NAME = "LowLatencyPrefs";
    private static final String PREF_NAME_NEFID_MODE = "NefidModePrefs";
    public static final String SCAN_RESTRICTION_LIST = "scan_restriction_list";
    public static final String SETTINGS_GLOBAL_AOI_COLLECT_DAILY_MAX_AOI_COUNT = "cae_aoi_collect_daily_max_aoi_count";
    public static final String SETTINGS_GLOBAL_AOI_COLLECT_DAILY_MAX_REPORT_COUNT = "cae_aoi_collect_daily_max_report_count";
    public static final String SETTINGS_GLOBAL_AOI_COLLECT_ENABLE = "cae_aoi_collect_enable";
    public static final String SETTINGS_GLOBAL_AOI_COLLECT_INTERVAL_MS = "cae_aoi_collect_interval_ms";
    public static final String SETTINGS_GLOBAL_AOI_COLLECT_MAX_COUNT_PER_AOI = "cae_aoi_collect_max_count_per_aoi";
    public static final String SETTINGS_GLOBAL_AOI_COLLECT_MAX_DURATION_MS = "cae_aoi_collect_max_duration_ms";
    public static final String SETTINGS_GLOBAL_AOI_COLLECT_MAX_ENTER_COUNT_PER_AOI = "cae_aoi_collect_max_enter_count_per_aoi";
    public static final String SETTINGS_GLOBAL_AOI_COLLECT_STILL_MAX_COUNT = "cae_aoi_collect_still_max_count";
    public static final String SETTINGS_GLOBAL_CAE_WIFI_DISCONNECT_COOLDOWN_MS = "cae_wifi_disconnect_cooldown_ms";
    public static final String SETTINGS_GLOBAL_CAE_WIFI_DISCONNECT_RSSI_24G = "cae_wifi_disconnect_rssi_24g";
    public static final String SETTINGS_GLOBAL_CAE_WIFI_DISCONNECT_RSSI_5G = "cae_wifi_disconnect_rssi_5g";
    public static final String SETTINGS_GLOBAL_CAE_WIFI_DISCONNECT_TPUT_KBPS = "cae_wifi_disconnect_tput_kbps";
    public static final String SETTINGS_GLOBAL_ENABLE_CAE_POOR_LINK_DISCONNECT = "enable_cae_poor_link_disconnect";
    public static final String SETTINGS_GLOBAL_THROUGHPUT_JITTER_WEIGHT_SAVE_KEY = "throughput_prediction_formula";
    public static final String SETTINGS_GLOBAL_THROUGHPUT_SAVE_KEY = "throughput_prediction_formula";
    public static final String SETTINGS_GLOBAL_THROUGHPUT_SAVE_KEY_2 = "throughput_prediction_formula_2";
    public static final String SETTINGS_GLOBAL_WIFI_ASSOCIATION_REJECT_FAIL_COOLDOWN_MS = "cae_wifi_association_reject_fail_cooldown_ms";
    public static final String SETTINGS_GLOBAL_WIFI_ASSOCIATION_REJECT_REASON_CODES = "cae_wifi_association_reject_reason_codes";
    public static final String SETTINGS_GLOBAL_WIFI_ASSOCIATION_REJECT_RSSI_THRESHOLD = "cae_wifi_association_reject_rssi_threshold";
    public static final String SETTINGS_GLOBAL_WIFI_ASSOCIATION_REJECT_SELF_CURE_ENABLED = "cae_wifi_association_reject_self_cure_enabled";
    public static final String SETTINGS_GLOBAL_WIFI_DELAYED_DISCONNECT_ABNORMAL_REASON_CODES = "cae_wifi_delayed_disconnect_abnormal_reason_codes";
    public static final String SETTINGS_GLOBAL_WIFI_DELAYED_DISCONNECT_RSSI_THRESHOLD = "cae_wifi_delayed_disconnect_rssi_threshold";
    public static final String SETTINGS_GLOBAL_WIFI_DELAYED_DISCONNECT_SELF_CURE_ENABLED = "cae_wifi_delayed_disconnect_self_cure_enabled";
    public static final String SETTINGS_GLOBAL_WIFI_DELAYED_DISCONNECT_SELF_CURE_FAIL_COOLDOWN_MS = "cae_wifi_delayed_disconnect_self_cure_fail_cooldown_ms";
    public static final String SETTINGS_GLOBAL_WIFI_DELAYED_DISCONNECT_SELF_CURE_SUCCESS_COOLDOWN_MS = "cae_wifi_delayed_disconnect_self_cure_success_cooldown_ms";
    public static final String SETTINGS_GLOBAL_WIFI_DELAYED_DISCONNECT_TIMEOUT_MS = "cae_wifi_delayed_disconnect_timeout_ms";
    public static final String SETTINGS_GLOBAL_WIFI_GATEWAY_CONFLICT_ARP_CHECK_TIME_WINDOW_MS = "cae_wifi_gateway_conflict_arp_check_time_window_ms";
    public static final String SETTINGS_GLOBAL_WIFI_GATEWAY_CONFLICT_ARP_RESPONSE_ADDRESS_COUNT_THRESHOLD = "cae_wifi_gateway_conflict_arp_response_address_count_threshold";
    public static final String SETTINGS_GLOBAL_WIFI_GATEWAY_CONFLICT_FAIL_COOLDOWN_MS = "cae_wifi_gateway_conflict_fail_cooldown_ms";
    public static final String SETTINGS_GLOBAL_WIFI_GATEWAY_CONFLICT_RSSI_THRESHOLD = "cae_wifi_gateway_conflict_rssi_threshold";
    public static final String SETTINGS_GLOBAL_WIFI_GATEWAY_CONFLICT_SELF_CURE_ENABLED = "cae_wifi_gateway_conflict_self_cure_enabled";
    public static final String SETTINGS_GLOBAL_WIFI_METERED_MINUTES = "wifi_metered_minutes";
    public static final String SETTINGS_GLOBAL_WIFI_NOT_METERED_MINUTES = "wifi_no_metered_minutes";
    public static final String SETTINGS_GLOBAL_WIFI_NUD_FAIL_FAIL_COOLDOWN_MS = "cae_wifi_nud_fail_fail_cooldown_ms";
    public static final String SETTINGS_GLOBAL_WIFI_NUD_FAIL_PROBE_DELAY_MS = "cae_wifi_nud_fail_probe_delay_ms";
    public static final String SETTINGS_GLOBAL_WIFI_NUD_FAIL_PROBE_TIMEOUT_MS = "cae_wifi_nud_fail_probe_timeout_ms";
    public static final String SETTINGS_GLOBAL_WIFI_NUD_FAIL_REPORT_COUNT_THRESHOLD = "cae_wifi_nud_fail_report_count_threshold";
    public static final String SETTINGS_GLOBAL_WIFI_NUD_FAIL_REPORT_TIME_WINDOW_MS = "cae_wifi_nud_fail_report_time_window_ms";
    public static final String SETTINGS_GLOBAL_WIFI_NUD_FAIL_RSSI_THRESHOLD = "cae_wifi_nud_fail_rssi_threshold";
    public static final String SETTINGS_GLOBAL_WIFI_NUD_FAIL_SELF_CURE_ENABLED = "cae_wifi_nud_fail_self_cure_enabled";
    public static final String SETTINGS_GLOBAL_WIFI_QOE_MONITOR_ENABLED = "wifi_qoe_monitor_enabled";
    public static final String SETTINGS_GLOBAL_WIFI_TPUT_COUNT_THRESHOLD = "wifi_tput_count_threshold";
    public static final String SETTINGS_GLOBAL_WIFI_TPUT_EMA_WEIGHT = "wifi_tput_ema_weight";
    public static final String SETTINGS_GLOBAL_WIFI_TPUT_HIGH_WEIGHT = "wifi_tput_high_weight";
    public static final String SETTINGS_GLOBAL_WIFI_TPUT_LOW_WEIGHT = "wifi_tput_low_weight";
    public static final String SETTINGS_GLOBAL_WIFI_TRIGGER_SCAN_TPUT_THRESHOLD = "wifi_trigger_scan_tput_threshold";
    public static final String SETTINGS_GLOBAL_WIFI_USE_AI_QOS_SCORER = "wifi_use_ai_qos_scorer";
    public static final String SETTINGS_GLOBAL_WIFI_VENDOR_CMD_BOOST5G = "cae_wifi_vendor_cmd_boost5g";
    public static final String SETTINGS_GLOBAL_WIFI_VENDOR_CMD_PENALIZE5G = "cae_wifi_vendor_cmd_penalize5g";
    public static final String SETTINGS_GLOBAL_WIFI_VENDOR_CMD_TOGGLE = "cae_wifi_vendor_cmd_enabled";
    private static final String SRC_BASE_DIR = "/data/syslog/settings/";
    private static final String TAG = "CloudConfigParseAndSave";
    private final Context mContext;
    private NefidInterface mNefidInterface;
    private final SmartNetworkService mSmartNetworkService;
    private SolutionUpdateHandler mUpdateHandler;

    public class SolutionUpdateHandler extends Handler {
        final /* synthetic */ CloudConfigParseAndSave this$0;

        public SolutionUpdateHandler(CloudConfigParseAndSave r8, Looper r10) {
            this.this$0 = r8;
            super(r10);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r8) {
            if (r8.what != 1) goto L7;
            CloudConfigParseAndSave.access$000(this.this$0, (String) r8.obj);
            CloudConfigParseAndSave r10 = this.this$0;
            CloudConfigParseAndSave.access$200(r10, CloudConfigParseAndSave.access$100(r10), (String) r8.obj);
            CloudConfigParseAndSave r11 = this.this$0;
            CloudConfigParseAndSave.access$300(r11, CloudConfigParseAndSave.access$100(r11), (String) r8.obj);
            CloudConfigParseAndSave.access$400(this.this$0, (String) r8.obj);
            CloudConfigParseAndSave.access$500(this.this$0, (String) r8.obj);
            CloudConfigParseAndSave.access$600(this.this$0, (String) r8.obj);
            CloudConfigParseAndSave.access$700(this.this$0, (String) r8.obj);
            CloudConfigParseAndSave.access$800(this.this$0, (String) r8.obj);
            CloudConfigParseAndSave.access$900(this.this$0, (String) r8.obj);
            CloudConfigParseAndSave.access$1000(this.this$0, (String) r8.obj);
            CloudConfigParseAndSave.access$1100(this.this$0, (String) r8.obj);
            CloudConfigParseAndSave.access$1200(this.this$0, (String) r8.obj);
            CloudConfigParseAndSave.access$1300(this.this$0, (String) r8.obj);
            CloudConfigParseAndSave.access$1400(this.this$0, (String) r8.obj);
            CloudConfigParseAndSave.access$1500(this.this$0, (String) r8.obj);
            CloudConfigParseAndSave.access$1600(this.this$0, (String) r8.obj);
            CloudConfigParseAndSave.access$1700(this.this$0, (String) r8.obj);
            CloudConfigParseAndSave.access$1800(this.this$0, (String) r8.obj);
            CloudConfigParseAndSave.access$1900(this.this$0, (String) r8.obj);
            CloudConfigParseAndSave.access$2000(this.this$0, (String) r8.obj);
            CloudConfigParseAndSave.access$2100(this.this$0, (String) r8.obj);
            CloudConfigParseAndSave.access$2200(this.this$0, (String) r8.obj);
            CloudConfigParseAndSave.access$2300(this.this$0, (String) r8.obj);
            CloudConfigParseAndSave.access$2400(this.this$0, (String) r8.obj);
            CloudConfigParseAndSave.access$2500(this.this$0).updateUrl();
            return;
        }
    }

    public CloudConfigParseAndSave(Context r8, SmartNetworkService r10) {
        this.mContext = r8;
        HandlerThread r11 = new HandlerThread("solution update thread");
        r11.start();
        this.mUpdateHandler = new SolutionUpdateHandler(this, r11.getLooper());
        this.mSmartNetworkService = r10;
    }

    public static /* synthetic */ void access$000(CloudConfigParseAndSave r8, String r10) {
        r8.parseAndStoreNetworkDetectionUrl(r10);
    }

    public static /* synthetic */ Context access$100(CloudConfigParseAndSave r8) {
        return r8.mContext;
    }

    public static /* synthetic */ void access$1000(CloudConfigParseAndSave r8, String r10) {
        r8.parseAndStoreTrafficThreshold(r10);
    }

    public static /* synthetic */ void access$1100(CloudConfigParseAndSave r8, String r10) {
        r8.parseAndStoreL4NetEvaluateSettings(r10);
    }

    public static /* synthetic */ void access$1200(CloudConfigParseAndSave r8, String r10) {
        r8.parseAndStoreCelluarQoeEvaluateSettings(r10);
    }

    public static /* synthetic */ void access$1300(CloudConfigParseAndSave r8, String r10) {
        r8.parseAndPullWifiAiQosConfigFiles(r10);
    }

    public static /* synthetic */ void access$1400(CloudConfigParseAndSave r8, String r10) {
        r8.parseAndPullPowerPredModelFiles(r10);
    }

    public static /* synthetic */ void access$1500(CloudConfigParseAndSave r8, String r10) {
        r8.parseAndStoreHandoverModelToggle(r10);
    }

    public static /* synthetic */ void access$1600(CloudConfigParseAndSave r8, String r10) {
        r8.parseAndStoreAccelConfig(r10);
    }

    public static /* synthetic */ void access$1700(CloudConfigParseAndSave r8, String r10) {
        r8.parseAndStoreWifiVendorCmdToggle(r10);
    }

    public static /* synthetic */ void access$1800(CloudConfigParseAndSave r8, String r10) {
        r8.parseAndStoreWifiTputThresholds(r10);
    }

    public static /* synthetic */ void access$1900(CloudConfigParseAndSave r8, String r10) {
        r8.parseAndStorePoorLinkDisconnectConfig(r10);
    }

    public static /* synthetic */ void access$200(CloudConfigParseAndSave r8, Context r10, String r11) {
        r8.parseAndStoreLowLatencyWhitelist(r10, r11);
    }

    public static /* synthetic */ void access$2000(CloudConfigParseAndSave r8, String r10) {
        r8.parseAndStoreWifiDelayedDisconnectConfig(r10);
    }

    public static /* synthetic */ void access$2100(CloudConfigParseAndSave r8, String r10) {
        r8.parseAndStoreWifiNudFailConfig(r10);
    }

    public static /* synthetic */ void access$2200(CloudConfigParseAndSave r8, String r10) {
        r8.parseAndStoreWifiGatewayConflictConfig(r10);
    }

    public static /* synthetic */ void access$2300(CloudConfigParseAndSave r8, String r10) {
        r8.parseAndStoreWifiAssociationRejectConfig(r10);
    }

    public static /* synthetic */ void access$2400(CloudConfigParseAndSave r8, String r10) {
        r8.parseAndStoreAoiCollectConfig(r10);
    }

    public static /* synthetic */ SmartNetworkService access$2500(CloudConfigParseAndSave r8) {
        return r8.mSmartNetworkService;
    }

    public static /* synthetic */ void access$300(CloudConfigParseAndSave r8, Context r10, String r11) {
        r8.parseAndStoreNefidWhitelist(r10, r11);
    }

    public static /* synthetic */ void access$400(CloudConfigParseAndSave r8, String r10) {
        r8.parseAndStoreScanRestrictionAppList(r10);
    }

    public static /* synthetic */ void access$500(CloudConfigParseAndSave r8, String r10) {
        r8.parseAndStoreThroughputPredictionFormula(r10);
    }

    public static /* synthetic */ void access$600(CloudConfigParseAndSave r8, String r10) {
        r8.parseAndStoreThroughputPredictionFormula2(r10);
    }

    public static /* synthetic */ void access$700(CloudConfigParseAndSave r8, String r10) {
        r8.parseAndStoreThroughputJitterPredictionFormula(r10);
    }

    public static /* synthetic */ void access$800(CloudConfigParseAndSave r8, String r10) {
        r8.parseAndStoreMPASettings(r10);
    }

    public static /* synthetic */ void access$900(CloudConfigParseAndSave r8, String r10) {
        r8.parseAndStoreNetworkHandoverSettings(r10);
    }

    private void copyFile(File r8, File r10) {
        File r11 = r10.getParentFile();     // Catch: Exception -> L42
        if (r11 == null) goto L12;
        if (r11.exists() == true) goto L12;
        if (r11.mkdirs() == true) goto L12;
        CaeLog.e(TAG, "Failed to create target directory: " + r11.getAbsolutePath());     // Catch: Exception -> L42
        return;
    L12:
        if (r10.exists() == true) goto L14;
    L16:
        FileInputStream r12 = new FileInputStream(r8);     // Catch: Exception -> L42
        FileOutputStream r13 = new FileOutputStream(r10);     // Catch: Throwable -> L36
        byte[] r14 = new byte[4096];     // Catch: Throwable -> L30
    L20:
        int r15 = r12.read(r14);     // Catch: Throwable -> L30
        if (r15 == (-1)) goto L24;
        r13.write(r14, 0, r15);     // Catch: Throwable -> L30
    L24:
        r13.close();     // Catch: Throwable -> L36
        r12.close();     // Catch: Exception -> L42
        if (r10.setReadable(true, false) == false) goto L28;
        CaeLog.i(TAG, "Set world-readable permission for: " + r10.getName());     // Catch: Exception -> L42
        return;
    L28:
        CaeLog.e(TAG, "Failed to set world-readable permission for: " + r10.getName());     // Catch: Exception -> L42
        return;
    L30:
        th = move-exception;
        r13.close();     // Catch: Throwable -> L33
    L35:
        throw th;     // Catch: Throwable -> L36
    L33:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        r12.close();     // Catch: Throwable -> L39
    L41:
        throw th;     // Catch: Exception -> L42
    L39:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L42
        goto L41
    L14:
        if (r10.delete() == true) goto L16;
        CaeLog.w(TAG, "Failed to delete existing file: " + r10.getName());     // Catch: Exception -> L42
    L42:
        e = move-exception;
        CaeLog.e(TAG, "File copy failed: " + r8.getName() + ", reason: " + e.getMessage(), e);
    }

    public static String getLowlatencyWhitelist(Context r8, String r10) {
        return r8.getSharedPreferences(PREF_NAME, 0).getString(r10, "");
    }

    public static String getNefidModeWhitelist(Context r8, String r10) {
        return r8.getSharedPreferences(PREF_NAME_NEFID_MODE, 0).getString(r10, "");
    }

    private String normalizeReasonCodes(Object r11) {
        if (r11 != null) goto L5;
        return null;
    L5:
        String r8 = String.valueOf(r11).trim();
        if (r8.isEmpty() == false) goto L8;
        return null;
    L8:
        String[] r10 = r8.split(",");
        ArrayList r12 = new ArrayList();
        int r13 = r10.length;
        int r14 = 0;
    L9:
        if (r14 >= r13) goto L19;
        String r15 = r10[r14].trim();
        if (r15.isEmpty() == true) goto L17;
        Integer.parseInt(r15);     // Catch: NumberFormatException -> L15
        r12.add(r15);     // Catch: NumberFormatException -> L15
    L15:
        e = move-exception;
        CaeLog.w(TAG, "normalizeReasonCodes: ignore invalid code=" + r15 + ", error=" + e);
    L17:
        r14 = r14 + 1;
        goto L9
    L19:
        if (r12.isEmpty() == false) goto L23;
        CaeLog.w(TAG, "normalizeReasonCodes: no valid reason code in=" + r11);
        return null;
    L23:
        return String.join(",", r12);
    }

    private Object optValue(JSONObject r8, String r10) {
        if (r8 != null) goto L5;
        return null;
    L5:
        if (r8.has(r10) == false) goto L13;
        Object r11 = r8.opt(r10);
        if (JSONObject.NULL.equals(r11) == false) goto L11;
        return null;
    L11:
        return r11;
    L13:
        return null;
    }

    private void parseAndPullPowerPredModelFiles(String r8) {
        CaeLog.i(TAG, "parseAndPullPowerPredModelFiles");     // Catch: Exception -> L10
        JSONArray r10 = new JSONObject(r8).getJSONArray(CLOUD_WLAN_POWER_PRED_MODEL_FILES);     // Catch: Exception -> L10
        int r11 = 0;
    L3:
        if (r11 >= r10.length()) goto L18;
        String r12 = r10.getJSONObject(r11).getString(FILE_ORIGINAL_NAME);     // Catch: Exception -> L10
        File r13 = new File(SRC_BASE_DIR + r12);     // Catch: Exception -> L10
        File r14 = new File(DEST_BASE_DIR + r12);     // Catch: Exception -> L10
        if (r13.exists() == false) goto L8;
        CaeLog.i(TAG, "parseAndPullPowerPredModelFiles: pull " + r12);     // Catch: Exception -> L10
        copyFile(r13, r14);     // Catch: Exception -> L10
    L9:
        r11 = r11 + 1;
        goto L3
    L8:
        CaeLog.w(TAG, "parseAndPullPowerPredModelFiles: source file not found: " + r12);     // Catch: Exception -> L10
        goto L9
    L18:
        return;
    L10:
        e = move-exception;
        CaeLog.e(TAG, "parse/pull power prediction model files failed", e);
    }

    private void parseAndPullWifiAiQosConfigFiles(String r8) {
        CaeLog.i(TAG, "parseAndPullWifiAiQosConfigFiles");     // Catch: Exception -> L12
        JSONArray r10 = new JSONObject(r8).getJSONArray(CLOUD_WIFI_AI_QOS_FILES);     // Catch: Exception -> L12
        int r11 = 0;
    L4:
        if (r11 >= r10.length()) goto L21;
        String r12 = r10.getJSONObject(r11).getString(FILE_ORIGINAL_NAME);     // Catch: Exception -> L12
        if (r12.endsWith(".conf") == false) goto L11;
        File r13 = new File(SRC_BASE_DIR + r12);     // Catch: Exception -> L12
        File r14 = new File(DEST_BASE_DIR + r12);     // Catch: Exception -> L12
        if (r13.exists() == false) goto L11;
        CaeLog.i(TAG, "parseAndPullWifiAiQosConfigFiles: pull " + r12);     // Catch: Exception -> L12
        copyFile(r13, r14);     // Catch: Exception -> L12
    L11:
        r11 = r11 + 1;
        goto L4
    L21:
        return;
    L12:
        e = move-exception;
        CaeLog.e(TAG, "parse/pull config files failed", e);
    }

    private void parseAndStoreAccelConfig(String r8) {
        JSONObject r10 = new JSONObject(r8);     // Catch: JSONException -> L7
        if (r10.has(AccelConfigManager.CLOUD_CONFIG_ACCEL_CONFIG) == false) goto L12;
        String r11 = r10.getString(AccelConfigManager.CLOUD_CONFIG_ACCEL_CONFIG);     // Catch: JSONException -> L7
        CaeLog.d(TAG, "accel_config: " + r11);     // Catch: JSONException -> L7
        AccelConfigManager.getInstance(this.mContext).updateSettings(r11);     // Catch: JSONException -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        CaeLog.e(TAG, "parseAndStoreAccelConfig error: " + e);
    }

    private void parseAndStoreAoiCollectConfig(String r12) {
        JSONObject r8 = new JSONObject(r12);     // Catch: JSONException -> L48
        if (r8.has("aoi_collect_enable") == false) goto L13;
        Boolean r13 = parseBoolean(optValue(r8, "aoi_collect_enable"));     // Catch: JSONException -> L48
        if (r13 == null) goto L13;
        ContentResolver r10 = this.mContext.getContentResolver();     // Catch: JSONException -> L48
        if (r13.booleanValue() == false) goto L10;
        int r14 = 1;
    L11:
        Settings.Global.putInt(r10, SETTINGS_GLOBAL_AOI_COLLECT_ENABLE, r14);     // Catch: JSONException -> L48
        goto L13
    L10:
        r14 = 0;
    L13:
        if (r8.has("aoi_collect_interval_ms") == false) goto L18;
        Long r15 = parseNonNegativeLong(optValue(r8, "aoi_collect_interval_ms"));     // Catch: JSONException -> L48
        if (r15 == null) goto L18;
        Settings.Global.putLong(this.mContext.getContentResolver(), SETTINGS_GLOBAL_AOI_COLLECT_INTERVAL_MS, r15.longValue());     // Catch: JSONException -> L48
    L18:
        if (r8.has("aoi_collect_max_duration_ms") == false) goto L23;
        Long r16 = parseNonNegativeLong(optValue(r8, "aoi_collect_max_duration_ms"));     // Catch: JSONException -> L48
        if (r16 == null) goto L23;
        Settings.Global.putLong(this.mContext.getContentResolver(), SETTINGS_GLOBAL_AOI_COLLECT_MAX_DURATION_MS, r16.longValue());     // Catch: JSONException -> L48
    L23:
        if (r8.has("aoi_collect_still_max_count") == false) goto L28;
        Integer r17 = parseNonNegativeInt(optValue(r8, "aoi_collect_still_max_count"));     // Catch: JSONException -> L48
        if (r17 == null) goto L28;
        Settings.Global.putInt(this.mContext.getContentResolver(), SETTINGS_GLOBAL_AOI_COLLECT_STILL_MAX_COUNT, r17.intValue());     // Catch: JSONException -> L48
    L28:
        if (r8.has("aoi_collect_daily_max_report_count") == false) goto L33;
        Integer r18 = parseNonNegativeInt(optValue(r8, "aoi_collect_daily_max_report_count"));     // Catch: JSONException -> L48
        if (r18 == null) goto L33;
        Settings.Global.putInt(this.mContext.getContentResolver(), SETTINGS_GLOBAL_AOI_COLLECT_DAILY_MAX_REPORT_COUNT, r18.intValue());     // Catch: JSONException -> L48
    L33:
        if (r8.has("aoi_collect_max_count_per_aoi") == false) goto L38;
        Integer r19 = parseNonNegativeInt(optValue(r8, "aoi_collect_max_count_per_aoi"));     // Catch: JSONException -> L48
        if (r19 == null) goto L38;
        Settings.Global.putInt(this.mContext.getContentResolver(), SETTINGS_GLOBAL_AOI_COLLECT_MAX_COUNT_PER_AOI, r19.intValue());     // Catch: JSONException -> L48
    L38:
        if (r8.has("aoi_collect_max_enter_count_per_aoi") == false) goto L43;
        Integer r110 = parseNonNegativeInt(optValue(r8, "aoi_collect_max_enter_count_per_aoi"));     // Catch: JSONException -> L48
        if (r110 == null) goto L43;
        Settings.Global.putInt(this.mContext.getContentResolver(), SETTINGS_GLOBAL_AOI_COLLECT_MAX_ENTER_COUNT_PER_AOI, r110.intValue());     // Catch: JSONException -> L48
    L43:
        if (r8.has("aoi_collect_daily_max_aoi_count") == false) goto L53;
        Integer r111 = parseNonNegativeInt(optValue(r8, "aoi_collect_daily_max_aoi_count"));     // Catch: JSONException -> L48
        if (r111 == null) goto L54;
        Settings.Global.putInt(this.mContext.getContentResolver(), SETTINGS_GLOBAL_AOI_COLLECT_DAILY_MAX_AOI_COUNT, r111.intValue());     // Catch: JSONException -> L48
        return;
    L54:
        return;
    L53:
        return;
    L48:
        e = move-exception;
        CaeLog.e(TAG, "parseAndStoreAoiCollectConfig error: " + e);
    }

    private void parseAndStoreCelluarQoeEvaluateSettings(String r8) {
        String r10 = new JSONObject(r8).getString(CellularQoeEvaluateObserver.CLOUD_CONFIG_CELLUAR_QOE_EVALUATE_SETTINGS);     // Catch: JSONException -> L5
        CaeLog.d(TAG, "CelluarQoeEvaluateSettings: " + r10);     // Catch: JSONException -> L5
        CellularQoeEvaluateObserver.getInstance(this.mContext).updateSettings(r10);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        CaeLog.e(TAG, "parseAndStoreCelluarQoeEvaluateSettings error: " + e);
    }

    private void parseAndStoreHandoverModelToggle(String r8) {
        JSONObject r10 = new JSONObject(r8).getJSONObject(CLOUD_CONFIG_HANDOVER_MODEL_TOGGLE);     // Catch: JSONException -> L5
        CaeLog.i(TAG, "handoverModelToggle: " + r10.toString());     // Catch: JSONException -> L5
        ModelSettingObserver.getInstance(this.mContext).updateHandoverModelToggle(r10);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        CaeLog.e(TAG, "parseAndStoreHandoverModelToggle error: " + e);
    }

    private void parseAndStoreL4NetEvaluateSettings(String r8) {
        String r10 = new JSONObject(r8).getString(L4NetEvaluateObserver.CLOUD_CONFIG_L4NET_EVALUATE_SETTINGS);     // Catch: JSONException -> L5
        CaeLog.d(TAG, "L4NetEvaluateSettings: " + r10);     // Catch: JSONException -> L5
        L4NetEvaluateObserver.getInstance(this.mContext).updateSettings(r10);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        CaeLog.e(TAG, "parseAndStoreL4NetEvaluateSettings error: " + e);
    }

    private void parseAndStoreLowLatencyWhitelist(Context r8, String r10) {
        CaeLog.i(TAG, "parseAndStoreLowLatencyWhitelist");
        JSONArray r11 = new JSONObject(r10).optJSONArray("lowlatency_whitelist");     // Catch: Exception -> L16
        if (r11 != null) goto L6;
        return;
    L6:
        SharedPreferences.Editor r12 = r8.getSharedPreferences(PREF_NAME, 0).edit();     // Catch: Exception -> L16
        r12.clear();     // Catch: Exception -> L16
        int r13 = 0;
    L8:
        if (r13 >= r11.length()) goto L14;
        JSONObject r14 = r11.getJSONObject(r13);     // Catch: Exception -> L16
        String r15 = r14.getString("package_name");     // Catch: Exception -> L16
        JSONArray r16 = r14.getJSONArray("value");     // Catch: Exception -> L16
        String[] r17 = new String[r16.length()];     // Catch: Exception -> L16
        int r18 = 0;
    L11:
        if (r18 >= r16.length()) goto L13;
        r17[r18] = r16.getString(r18);     // Catch: Exception -> L16
        r18 = r18 + 1;     // Catch: Exception -> L16
        goto L11
    L13:
        r12.putString(r15, String.join(",", r17));     // Catch: Exception -> L16
        r13 = r13 + 1;     // Catch: Exception -> L16
        goto L8
    L14:
        r12.apply();     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
    }

    private void parseAndStoreMPASettings(String r8) {
        String r10 = new JSONObject(r8).getString(CLOUD_CONFIG_MPA_SETTINGS);     // Catch: JSONException -> L5
        CaeLog.d(TAG, "mpa settings config: " + r10);     // Catch: JSONException -> L5
        MPASettingsObserver.getInstance(this.mContext).updateMPASettings(r10);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    private void parseAndStoreNefidWhitelist(Context r10, String r11) {
        CaeLog.i(TAG, "parseAndStoreNefidWhitelist");
        JSONObject r8 = new JSONObject(r11);     // Catch: Exception -> L27
        JSONArray r12 = r8.optJSONArray("nefid_mode_whitelist");     // Catch: Exception -> L27
        if (r12 == null) goto L15;
        SharedPreferences.Editor r13 = r10.getSharedPreferences(PREF_NAME_NEFID_MODE, 0).edit();     // Catch: Exception -> L27
        r13.clear();     // Catch: Exception -> L27
        int r14 = 0;
    L8:
        if (r14 >= r12.length()) goto L14;
        JSONObject r15 = r12.getJSONObject(r14);     // Catch: Exception -> L27
        String r16 = r15.getString("package_name");     // Catch: Exception -> L27
        JSONArray r17 = r15.getJSONArray("value");     // Catch: Exception -> L27
        CaeLog.d(TAG, "parse nefid nefid_mode_whitelist packageName: " + r16 + " valuesArray: " + r17);     // Catch: Exception -> L27
        String[] r18 = new String[r17.length()];     // Catch: Exception -> L27
        int r19 = 0;
    L11:
        if (r19 >= r17.length()) goto L13;
        r18[r19] = r17.getString(r19);     // Catch: Exception -> L27
        r19 = r19 + 1;     // Catch: Exception -> L27
        goto L11
    L13:
        r13.putString(r16, String.join(",", r18));     // Catch: Exception -> L27
        r14 = r14 + 1;     // Catch: Exception -> L27
        goto L8
    L14:
        r13.apply();     // Catch: Exception -> L27
    L15:
        JSONObject r110 = r8.optJSONObject("nefid_config");     // Catch: Exception -> L27
        if (r110 != null) goto L18;
        return;
    L18:
        String r111 = r110.getString("version");     // Catch: Exception -> L27
        String r112 = r110.getString("value");     // Catch: Exception -> L27
        CaeLog.d(TAG, "parse nefid config version: " + r111 + " value: " + r112);     // Catch: Exception -> L27
        if (TextUtils.isEmpty(r111) == false) goto L21;
        return;
    L21:
        if (TextUtils.isEmpty(r112) == false) goto L23;
        return;
    L23:
        if (this.mNefidInterface != null) goto L25;
        this.mNefidInterface = NefidInterface.getInstance(this.mContext);     // Catch: Exception -> L27
    L25:
        this.mNefidInterface.setNefidConfig(r111, r112);     // Catch: Exception -> L27
        return;
    L27:
        e = move-exception;
        e.printStackTrace();
    }

    private void parseAndStoreNetworkDetectionUrl(String r12) {
        JSONObject r8 = new JSONObject(r12);     // Catch: JSONException -> L9
        boolean r13 = r8.getBoolean(CloudServiceConstants.OWifiSettingsConfig.CAE_WIFI_CONFIG_USE_HTTPS);     // Catch: JSONException -> L9
        JSONObject r10 = r8.getJSONObject(CloudServiceConstants.OWifiSettingsConfig.CAE_WIFI_CONFIG_CN_URL);     // Catch: JSONException -> L9
        String r11 = r10.getString("http_url");     // Catch: JSONException -> L9
        String r14 = r10.getString("https_url");     // Catch: JSONException -> L9
        JSONObject r15 = r8.getJSONObject(CloudServiceConstants.OWifiSettingsConfig.CAE_WIFI_CONFIG_GLOBAL_URL);     // Catch: JSONException -> L9
        String r16 = r15.getString("http_url");     // Catch: JSONException -> L9
        String r17 = r15.getString("https_url");     // Catch: JSONException -> L9
        String r18 = TAG;     // Catch: JSONException -> L9
        CaeLog.i(r18, "use_https: " + r13);     // Catch: JSONException -> L9
        CaeLog.i(r18, "cn_url http_url: " + r11);     // Catch: JSONException -> L9
        CaeLog.i(r18, "cn_url https_url: " + r14);     // Catch: JSONException -> L9
        CaeLog.i(r18, "global_url http_url: " + r16);     // Catch: JSONException -> L9
        CaeLog.i(r18, "global_url https_url: " + r17);     // Catch: JSONException -> L9
        ContentResolver r19 = this.mContext.getContentResolver();     // Catch: JSONException -> L9
        if (r13 == false) goto L6;
        int r110 = 1;
    L7:
        Settings.Global.putInt(r19, CAPTIVE_PORTAL_USE_HTTPS, r110);     // Catch: JSONException -> L9
        Settings.Global.putString(this.mContext.getContentResolver(), CAPTIVE_PORTAL_CN_HTTP_URL, r11);     // Catch: JSONException -> L9
        Settings.Global.putString(this.mContext.getContentResolver(), CAPTIVE_PORTAL_CN_HTTPS_URL, r14);     // Catch: JSONException -> L9
        Settings.Global.putString(this.mContext.getContentResolver(), CAPTIVE_PORTAL_GLOBAL_HTTP_URL, r16);     // Catch: JSONException -> L9
        Settings.Global.putString(this.mContext.getContentResolver(), CAPTIVE_PORTAL_GLOBAL_HTTPS_URL, r17);     // Catch: JSONException -> L9
        return;
    L6:
        r110 = 0;
    L9:
        e = move-exception;
        e.printStackTrace();
    }

    private void parseAndStoreNetworkHandoverSettings(String r8) {
        JSONObject r10 = new JSONObject(r8).getJSONObject(CLOUD_CONFIG_NETWORK_HANDOVER_SETTINGS);     // Catch: JSONException -> L5
        CaeLog.d(TAG, "network_handover_settings: " + r10.toString());     // Catch: JSONException -> L5
        HandoverParameterManager.getInstance(this.mContext).updateParameter(r10);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        CaeLog.e(TAG, "parseAndStoreNetworkHandoverSettings error: " + e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    private void parseAndStorePoorLinkDisconnectConfig(String r8) {
        JSONObject r10 = new JSONObject(r8);     // Catch: Exception -> L25
        if (r10.has(SETTINGS_GLOBAL_CAE_WIFI_DISCONNECT_RSSI_24G) == false) goto L7;
        Settings.Global.putInt(this.mContext.getContentResolver(), SETTINGS_GLOBAL_CAE_WIFI_DISCONNECT_RSSI_24G, r10.getInt(SETTINGS_GLOBAL_CAE_WIFI_DISCONNECT_RSSI_24G));     // Catch: Exception -> L25
    L7:
        if (r10.has(SETTINGS_GLOBAL_CAE_WIFI_DISCONNECT_RSSI_5G) == false) goto L10;
        Settings.Global.putInt(this.mContext.getContentResolver(), SETTINGS_GLOBAL_CAE_WIFI_DISCONNECT_RSSI_5G, r10.getInt(SETTINGS_GLOBAL_CAE_WIFI_DISCONNECT_RSSI_5G));     // Catch: Exception -> L25
    L10:
        if (r10.has(SETTINGS_GLOBAL_CAE_WIFI_DISCONNECT_TPUT_KBPS) == false) goto L13;
        Settings.Global.putInt(this.mContext.getContentResolver(), SETTINGS_GLOBAL_CAE_WIFI_DISCONNECT_TPUT_KBPS, r10.getInt(SETTINGS_GLOBAL_CAE_WIFI_DISCONNECT_TPUT_KBPS));     // Catch: Exception -> L25
    L13:
        if (r10.has(SETTINGS_GLOBAL_CAE_WIFI_DISCONNECT_COOLDOWN_MS) == false) goto L16;
        Settings.Global.putLong(this.mContext.getContentResolver(), SETTINGS_GLOBAL_CAE_WIFI_DISCONNECT_COOLDOWN_MS, r10.getLong(SETTINGS_GLOBAL_CAE_WIFI_DISCONNECT_COOLDOWN_MS));     // Catch: Exception -> L25
    L16:
        if (r10.has(SETTINGS_GLOBAL_ENABLE_CAE_POOR_LINK_DISCONNECT) == false) goto L30;
        Object r11 = r10.get(SETTINGS_GLOBAL_ENABLE_CAE_POOR_LINK_DISCONNECT);     // Catch: Exception -> L25
        ?? r12 = 0;
        if ((r11 instanceof Boolean) == false) goto L21;
        r12 = ((Boolean) r11).booleanValue();     // Catch: Exception -> L25
    L23:
        Settings.Global.putInt(this.mContext.getContentResolver(), SETTINGS_GLOBAL_ENABLE_CAE_POOR_LINK_DISCONNECT, r12);     // Catch: Exception -> L25
        return;
    L21:
        if (r10.optInt(SETTINGS_GLOBAL_ENABLE_CAE_POOR_LINK_DISCONNECT, 1) != 1) goto L23;
        r12 = 1;
        goto L23
    L30:
        return;
    L25:
        e = move-exception;
        android.aimedia.a.q("parseAndStorePoorLinkDisconnectConfig error: ", e, TAG);
    }

    private void parseAndStoreScanRestrictionAppList(String r8) {
        JSONObject r10 = new JSONObject(r8);     // Catch: JSONException -> L5
        String r11 = r10.getString("background_scan_backlist");     // Catch: JSONException -> L5
        String r12 = r10.getString("scan_restrictionlist");     // Catch: JSONException -> L5
        String r13 = TAG;     // Catch: JSONException -> L5
        CaeLog.d(r13, "background_scan_backlist: " + r11);     // Catch: JSONException -> L5
        CaeLog.d(r13, "scanRestriction: " + r12);     // Catch: JSONException -> L5
        Settings.Global.putString(this.mContext.getContentResolver(), BACKGROUD_SCAN_BACK_LIST, r11);     // Catch: JSONException -> L5
        Settings.Global.putString(this.mContext.getContentResolver(), SCAN_RESTRICTION_LIST, r12);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    private void parseAndStoreThroughputJitterPredictionFormula(String r8) {
        JSONObject r10 = new JSONObject(r8);     // Catch: JSONException -> L5
        float r11 = (float) r10.getDouble(CLOUD_CONFIG_THROUGHPUT_JITTER_WEIGHT);     // Catch: JSONException -> L5
        Settings.Global.putFloat(this.mContext.getContentResolver(), "throughput_prediction_formula", r11);     // Catch: JSONException -> L5
        String r12 = TAG;     // Catch: JSONException -> L5
        CaeLog.d(r12, "throughput_jitter_weight_proportion: " + r11);     // Catch: JSONException -> L5
        this.mSmartNetworkService.updateThroughputJitterWeightProportion(r11);     // Catch: JSONException -> L5
        String r13 = r10.getString(CLOUD_CONFIG_THROUGHPUT_JITTER_FORMLA);     // Catch: JSONException -> L5
        CaeLog.d(r12, "throughput_jitter_prediction_formula: " + r13);     // Catch: JSONException -> L5
        this.mSmartNetworkService.updateThroughputJitterPredictionFormula(r13);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    private void parseAndStoreThroughputPredictionFormula(String r8) {
        String r10 = new JSONObject(r8).getString("throughput_prediction_formula");     // Catch: JSONException -> L5
        CaeLog.d(TAG, "throughput_prediction_formula: " + r10);     // Catch: JSONException -> L5
        this.mSmartNetworkService.updateThroughputPredictionFormula(r10);     // Catch: JSONException -> L5
        Settings.Global.putString(this.mContext.getContentResolver(), "throughput_prediction_formula", r10);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    private void parseAndStoreThroughputPredictionFormula2(String r8) {
        String r10 = new JSONObject(r8).getString("throughput_prediction_formula_2");     // Catch: JSONException -> L5
        CaeLog.d(TAG, "throughput_prediction_formula_2: " + r10);     // Catch: JSONException -> L5
        this.mSmartNetworkService.updateThroughputPredictionFormula2(r10);     // Catch: JSONException -> L5
        Settings.Global.putString(this.mContext.getContentResolver(), "throughput_prediction_formula_2", r10);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    private void parseAndStoreTrafficThreshold(String r8) {
        String r10 = new JSONObject(r8).getString(CLOUD_CONFIG_TRAFFIC_THRESHOLD);     // Catch: JSONException -> L5
        CaeLog.d(TAG, "trafficThreshold: " + r10);     // Catch: JSONException -> L5
        TrafficThreshold.getInstance(this.mContext).updateThreshold(r10);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        CaeLog.e(TAG, "parseAndStoreTrafficThreshold error: " + e);
    }

    private void parseAndStoreWifiAssociationRejectConfig(String r8) {
        JSONObject r10 = new JSONObject(r8).optJSONObject(CLOUD_CONFIG_WIFI_ASSOCIATION_REJECT);     // Catch: JSONException -> L22
        if (r10 != null) goto L5;
        return;
    L5:
        Boolean r11 = parseBoolean(optValue(r10, CLOUD_CONFIG_ASSOCIATION_REJECT_SELF_CURE_ENABLED));     // Catch: JSONException -> L22
        if (r11 == null) goto L12;
        ContentResolver r12 = this.mContext.getContentResolver();     // Catch: JSONException -> L22
        if (r11.booleanValue() == false) goto L10;
        int r13 = 1;
    L11:
        Settings.Global.putInt(r12, SETTINGS_GLOBAL_WIFI_ASSOCIATION_REJECT_SELF_CURE_ENABLED, r13);     // Catch: JSONException -> L22
        goto L12
    L10:
        r13 = 0;
    L12:
        String r14 = normalizeReasonCodes(optValue(r10, CLOUD_CONFIG_ASSOCIATION_REJECT_REASON_CODES));     // Catch: JSONException -> L22
        if (r14 == null) goto L15;
        Settings.Global.putString(this.mContext.getContentResolver(), SETTINGS_GLOBAL_WIFI_ASSOCIATION_REJECT_REASON_CODES, r14);     // Catch: JSONException -> L22
    L15:
        Integer r15 = parseRssiThreshold(optValue(r10, CLOUD_CONFIG_ASSOCIATION_REJECT_RSSI_THRESHOLD));     // Catch: JSONException -> L22
        if (r15 == null) goto L18;
        Settings.Global.putInt(this.mContext.getContentResolver(), SETTINGS_GLOBAL_WIFI_ASSOCIATION_REJECT_RSSI_THRESHOLD, r15.intValue());     // Catch: JSONException -> L22
    L18:
        Long r16 = parseNonNegativeLong(optValue(r10, CLOUD_CONFIG_ASSOCIATION_REJECT_FAIL_COOLDOWN_MS));     // Catch: JSONException -> L22
        if (r16 == null) goto L27;
        Settings.Global.putLong(this.mContext.getContentResolver(), SETTINGS_GLOBAL_WIFI_ASSOCIATION_REJECT_FAIL_COOLDOWN_MS, r16.longValue());     // Catch: JSONException -> L22
        return;
    L27:
        return;
    L22:
        e = move-exception;
        CaeLog.e(TAG, "parseAndStoreWifiAssociationRejectConfig error: " + e);
    }

    private void parseAndStoreWifiDelayedDisconnectConfig(String r8) {
        JSONObject r10 = new JSONObject(r8).optJSONObject(CLOUD_CONFIG_WIFI_DELAYED_DISCONNECT);     // Catch: JSONException -> L28
        if (r10 != null) goto L5;
        return;
    L5:
        Boolean r11 = parseBoolean(optValue(r10, CLOUD_CONFIG_DELAYED_DISCONNECT_SELF_CURE_ENABLED));     // Catch: JSONException -> L28
        if (r11 == null) goto L12;
        ContentResolver r12 = this.mContext.getContentResolver();     // Catch: JSONException -> L28
        if (r11.booleanValue() == false) goto L10;
        int r13 = 1;
    L11:
        Settings.Global.putInt(r12, SETTINGS_GLOBAL_WIFI_DELAYED_DISCONNECT_SELF_CURE_ENABLED, r13);     // Catch: JSONException -> L28
        goto L12
    L10:
        r13 = 0;
    L12:
        Long r14 = parseNonNegativeLong(optValue(r10, CLOUD_CONFIG_DELAYED_DISCONNECT_SELF_CURE_SUCCESS_COOLDOWN_MS));     // Catch: JSONException -> L28
        if (r14 == null) goto L15;
        Settings.Global.putLong(this.mContext.getContentResolver(), SETTINGS_GLOBAL_WIFI_DELAYED_DISCONNECT_SELF_CURE_SUCCESS_COOLDOWN_MS, r14.longValue());     // Catch: JSONException -> L28
    L15:
        Long r15 = parseNonNegativeLong(optValue(r10, CLOUD_CONFIG_DELAYED_DISCONNECT_SELF_CURE_FAIL_COOLDOWN_MS));     // Catch: JSONException -> L28
        if (r15 == null) goto L18;
        Settings.Global.putLong(this.mContext.getContentResolver(), SETTINGS_GLOBAL_WIFI_DELAYED_DISCONNECT_SELF_CURE_FAIL_COOLDOWN_MS, r15.longValue());     // Catch: JSONException -> L28
    L18:
        Long r16 = parseNonNegativeLong(optValue(r10, CLOUD_CONFIG_DELAYED_DISCONNECT_TIMEOUT_MS));     // Catch: JSONException -> L28
        if (r16 == null) goto L21;
        Settings.Global.putLong(this.mContext.getContentResolver(), SETTINGS_GLOBAL_WIFI_DELAYED_DISCONNECT_TIMEOUT_MS, r16.longValue());     // Catch: JSONException -> L28
    L21:
        String r17 = normalizeReasonCodes(optValue(r10, CLOUD_CONFIG_DELAYED_DISCONNECT_ABNORMAL_REASON_CODES));     // Catch: JSONException -> L28
        if (r17 == null) goto L24;
        Settings.Global.putString(this.mContext.getContentResolver(), SETTINGS_GLOBAL_WIFI_DELAYED_DISCONNECT_ABNORMAL_REASON_CODES, r17);     // Catch: JSONException -> L28
    L24:
        Integer r18 = parseRssiThreshold(optValue(r10, CLOUD_CONFIG_DELAYED_DISCONNECT_RSSI_THRESHOLD));     // Catch: JSONException -> L28
        if (r18 == null) goto L33;
        Settings.Global.putInt(this.mContext.getContentResolver(), SETTINGS_GLOBAL_WIFI_DELAYED_DISCONNECT_RSSI_THRESHOLD, r18.intValue());     // Catch: JSONException -> L28
        return;
    L33:
        return;
    L28:
        e = move-exception;
        CaeLog.e(TAG, "parseAndStoreWifiDelayedDisconnectConfig error: " + e);
    }

    private void parseAndStoreWifiGatewayConflictConfig(String r8) {
        JSONObject r10 = new JSONObject(r8).optJSONObject(CLOUD_CONFIG_WIFI_GATEWAY_CONFLICT);     // Catch: JSONException -> L25
        if (r10 != null) goto L5;
        return;
    L5:
        Boolean r11 = parseBoolean(optValue(r10, CLOUD_CONFIG_GATEWAY_CONFLICT_SELF_CURE_ENABLED));     // Catch: JSONException -> L25
        if (r11 == null) goto L12;
        ContentResolver r12 = this.mContext.getContentResolver();     // Catch: JSONException -> L25
        if (r11.booleanValue() == false) goto L10;
        int r13 = 1;
    L11:
        Settings.Global.putInt(r12, SETTINGS_GLOBAL_WIFI_GATEWAY_CONFLICT_SELF_CURE_ENABLED, r13);     // Catch: JSONException -> L25
        goto L12
    L10:
        r13 = 0;
    L12:
        Long r14 = parseNonNegativeLong(optValue(r10, CLOUD_CONFIG_GATEWAY_CONFLICT_ARP_CHECK_TIME_WINDOW_MS));     // Catch: JSONException -> L25
        if (r14 == null) goto L15;
        Settings.Global.putLong(this.mContext.getContentResolver(), SETTINGS_GLOBAL_WIFI_GATEWAY_CONFLICT_ARP_CHECK_TIME_WINDOW_MS, r14.longValue());     // Catch: JSONException -> L25
    L15:
        Integer r15 = parseNonNegativeInt(optValue(r10, CLOUD_CONFIG_GATEWAY_CONFLICT_ARP_RESPONSE_ADDRESS_COUNT_THRESHOLD));     // Catch: JSONException -> L25
        if (r15 == null) goto L18;
        Settings.Global.putInt(this.mContext.getContentResolver(), SETTINGS_GLOBAL_WIFI_GATEWAY_CONFLICT_ARP_RESPONSE_ADDRESS_COUNT_THRESHOLD, r15.intValue());     // Catch: JSONException -> L25
    L18:
        Long r16 = parseNonNegativeLong(optValue(r10, CLOUD_CONFIG_GATEWAY_CONFLICT_FAIL_COOLDOWN_MS));     // Catch: JSONException -> L25
        if (r16 == null) goto L21;
        Settings.Global.putLong(this.mContext.getContentResolver(), SETTINGS_GLOBAL_WIFI_GATEWAY_CONFLICT_FAIL_COOLDOWN_MS, r16.longValue());     // Catch: JSONException -> L25
    L21:
        Integer r17 = parseRssiThreshold(optValue(r10, CLOUD_CONFIG_GATEWAY_CONFLICT_RSSI_THRESHOLD));     // Catch: JSONException -> L25
        if (r17 == null) goto L30;
        Settings.Global.putInt(this.mContext.getContentResolver(), SETTINGS_GLOBAL_WIFI_GATEWAY_CONFLICT_RSSI_THRESHOLD, r17.intValue());     // Catch: JSONException -> L25
        return;
    L30:
        return;
    L25:
        e = move-exception;
        CaeLog.e(TAG, "parseAndStoreWifiGatewayConflictConfig error: " + e);
    }

    private void parseAndStoreWifiNudFailConfig(String r8) {
        JSONObject r10 = new JSONObject(r8).optJSONObject(CLOUD_CONFIG_WIFI_NUD_FAIL);     // Catch: JSONException -> L31
        if (r10 != null) goto L5;
        return;
    L5:
        Boolean r11 = parseBoolean(optValue(r10, CLOUD_CONFIG_NUD_FAIL_SELF_CURE_ENABLED));     // Catch: JSONException -> L31
        if (r11 == null) goto L12;
        ContentResolver r12 = this.mContext.getContentResolver();     // Catch: JSONException -> L31
        if (r11.booleanValue() == false) goto L10;
        int r13 = 1;
    L11:
        Settings.Global.putInt(r12, SETTINGS_GLOBAL_WIFI_NUD_FAIL_SELF_CURE_ENABLED, r13);     // Catch: JSONException -> L31
        goto L12
    L10:
        r13 = 0;
    L12:
        Long r14 = parseNonNegativeLong(optValue(r10, CLOUD_CONFIG_NUD_FAIL_REPORT_TIME_WINDOW_MS));     // Catch: JSONException -> L31
        if (r14 == null) goto L15;
        Settings.Global.putLong(this.mContext.getContentResolver(), SETTINGS_GLOBAL_WIFI_NUD_FAIL_REPORT_TIME_WINDOW_MS, r14.longValue());     // Catch: JSONException -> L31
    L15:
        Integer r15 = parseNonNegativeInt(optValue(r10, CLOUD_CONFIG_NUD_FAIL_REPORT_COUNT_THRESHOLD));     // Catch: JSONException -> L31
        if (r15 == null) goto L18;
        Settings.Global.putInt(this.mContext.getContentResolver(), SETTINGS_GLOBAL_WIFI_NUD_FAIL_REPORT_COUNT_THRESHOLD, r15.intValue());     // Catch: JSONException -> L31
    L18:
        Long r16 = parseNonNegativeLong(optValue(r10, CLOUD_CONFIG_NUD_FAIL_FAIL_COOLDOWN_MS));     // Catch: JSONException -> L31
        if (r16 == null) goto L21;
        Settings.Global.putLong(this.mContext.getContentResolver(), SETTINGS_GLOBAL_WIFI_NUD_FAIL_FAIL_COOLDOWN_MS, r16.longValue());     // Catch: JSONException -> L31
    L21:
        Integer r17 = parseRssiThreshold(optValue(r10, CLOUD_CONFIG_NUD_FAIL_RSSI_THRESHOLD));     // Catch: JSONException -> L31
        if (r17 == null) goto L24;
        Settings.Global.putInt(this.mContext.getContentResolver(), SETTINGS_GLOBAL_WIFI_NUD_FAIL_RSSI_THRESHOLD, r17.intValue());     // Catch: JSONException -> L31
    L24:
        Long r18 = parseNonNegativeLong(optValue(r10, CLOUD_CONFIG_NUD_FAIL_PROBE_DELAY_MS));     // Catch: JSONException -> L31
        if (r18 == null) goto L27;
        Settings.Global.putLong(this.mContext.getContentResolver(), SETTINGS_GLOBAL_WIFI_NUD_FAIL_PROBE_DELAY_MS, r18.longValue());     // Catch: JSONException -> L31
    L27:
        Long r19 = parseNonNegativeLong(optValue(r10, CLOUD_CONFIG_NUD_FAIL_PROBE_TIMEOUT_MS));     // Catch: JSONException -> L31
        if (r19 == null) goto L36;
        Settings.Global.putLong(this.mContext.getContentResolver(), SETTINGS_GLOBAL_WIFI_NUD_FAIL_PROBE_TIMEOUT_MS, r19.longValue());     // Catch: JSONException -> L31
        return;
    L36:
        return;
    L31:
        e = move-exception;
        CaeLog.e(TAG, "parseAndStoreWifiNudFailConfig error: " + e);
    }

    private void parseAndStoreWifiTputThresholds(String r18) {
        JSONObject r8 = new JSONObject(r18);     // Catch: Exception -> L8
        if (r8.has(CLOUD_CONFIG_WIFI_TPUT_THRESHOLDS) == true) goto L6;
        return;
    L6:
        JSONObject r10 = r8.getJSONObject(CLOUD_CONFIG_WIFI_TPUT_THRESHOLDS);     // Catch: Exception -> L8
        int r11 = r10.optInt("count_threshold", 0);     // Catch: Exception -> L8
        double r12 = r10.optDouble("tput_high_weight", 0.0d);     // Catch: Exception -> L8
        double r13 = r10.optDouble("tput_low_weight", 0.0d);     // Catch: Exception -> L8
        double r14 = r10.optDouble("ema_weight", 0.0d);     // Catch: Exception -> L8
        int r15 = r10.optInt("use_ai_qos_scorer", 0);     // Catch: Exception -> L8
        int r16 = r10.optInt("trigger_scan_tput_threshold", 0);     // Catch: Exception -> L8
        int r17 = r10.optInt("qoe_monitor_enabled", 0);     // Catch: Exception -> L8
        int r19 = r10.optInt(SETTINGS_GLOBAL_WIFI_NOT_METERED_MINUTES, 480);     // Catch: Exception -> L8
        int r20 = r10.optInt(SETTINGS_GLOBAL_WIFI_METERED_MINUTES, 120);     // Catch: Exception -> L8
        Settings.Global.putInt(this.mContext.getContentResolver(), SETTINGS_GLOBAL_WIFI_TPUT_COUNT_THRESHOLD, r11);     // Catch: Exception -> L8
        Settings.Global.putFloat(this.mContext.getContentResolver(), SETTINGS_GLOBAL_WIFI_TPUT_HIGH_WEIGHT, (float) r12);     // Catch: Exception -> L8
        Settings.Global.putFloat(this.mContext.getContentResolver(), SETTINGS_GLOBAL_WIFI_TPUT_LOW_WEIGHT, (float) r13);     // Catch: Exception -> L8
        Settings.Global.putFloat(this.mContext.getContentResolver(), SETTINGS_GLOBAL_WIFI_TPUT_EMA_WEIGHT, (float) r14);     // Catch: Exception -> L8
        Settings.Global.putInt(this.mContext.getContentResolver(), SETTINGS_GLOBAL_WIFI_USE_AI_QOS_SCORER, r15);     // Catch: Exception -> L8
        Settings.Global.putInt(this.mContext.getContentResolver(), SETTINGS_GLOBAL_WIFI_TRIGGER_SCAN_TPUT_THRESHOLD, r16);     // Catch: Exception -> L8
        Settings.Global.putInt(this.mContext.getContentResolver(), SETTINGS_GLOBAL_WIFI_QOE_MONITOR_ENABLED, r17);     // Catch: Exception -> L8
        Settings.Global.putInt(this.mContext.getContentResolver(), SETTINGS_GLOBAL_WIFI_NOT_METERED_MINUTES, r19);     // Catch: Exception -> L8
        Settings.Global.putInt(this.mContext.getContentResolver(), SETTINGS_GLOBAL_WIFI_METERED_MINUTES, r20);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        android.aimedia.a.q("parseAndStoreWifiTputThresholds error: ", e, TAG);
    }

    private void parseAndStoreWifiVendorCmdToggle(String r8) {
        JSONObject r10 = new JSONObject(r8);     // Catch: JSONException -> L17
        if (r10.has("enabled") == false) goto L11;
        boolean r11 = r10.getBoolean("enabled");     // Catch: JSONException -> L17
        ContentResolver r12 = this.mContext.getContentResolver();     // Catch: JSONException -> L17
        if (r11 == false) goto L8;
        int r13 = 1;
    L9:
        Settings.Global.putInt(r12, SETTINGS_GLOBAL_WIFI_VENDOR_CMD_TOGGLE, r13);     // Catch: JSONException -> L17
        goto L11
    L8:
        r13 = 0;
    L11:
        if (r10.has("boost5g") == false) goto L14;
        Settings.Global.putInt(this.mContext.getContentResolver(), SETTINGS_GLOBAL_WIFI_VENDOR_CMD_BOOST5G, r10.getInt("boost5g"));     // Catch: JSONException -> L17
    L14:
        if (r10.has("penalize5g") == false) goto L22;
        Settings.Global.putInt(this.mContext.getContentResolver(), SETTINGS_GLOBAL_WIFI_VENDOR_CMD_PENALIZE5G, r10.getInt("penalize5g"));     // Catch: JSONException -> L17
        return;
    L22:
        return;
    L17:
        e = move-exception;
        CaeLog.e(TAG, "parseAndStoreWifiVendorCmdToggle error: " + e);
    }

    private Boolean parseBoolean(Object r8) {
        if ((r8 instanceof Boolean) == false) goto L7;
        return (Boolean) r8;
    L7:
        if ((r8 instanceof Number) == false) goto L15;
        if (((Number) r8).intValue() == 0) goto L11;
        boolean r10 = true;
    L13:
        return Boolean.valueOf(r10);
    L11:
        r10 = false;
        goto L13
    L15:
        if ((r8 instanceof String) == false) goto L44;
        String r11 = ((String) r8).trim();
        if (r11.isEmpty() == false) goto L20;
        return null;
    L20:
        if ("1".equals(r11) == true) goto L43;
        if ("true".equalsIgnoreCase(r11) == true) goto L43;
        if ("on".equalsIgnoreCase(r11) == true) goto L43;
        if ("enable".equalsIgnoreCase(r11) == true) goto L43;
        if ("enabled".equalsIgnoreCase(r11) == true) goto L43;
        if ("0".equals(r11) == true) goto L41;
        if ("false".equalsIgnoreCase(r11) == true) goto L41;
        if ("off".equalsIgnoreCase(r11) == true) goto L41;
        if ("disable".equalsIgnoreCase(r11) == true) goto L41;
        if ("disabled".equalsIgnoreCase(r11) == false) goto L44;
    L41:
        return Boolean.FALSE;
    L43:
        return Boolean.TRUE;
    L44:
        CaeLog.w(TAG, "parseBoolean: unsupported value=" + r8);
        return null;
    }

    private Long parseLong(Object r8) {
        if ((r8 instanceof Number) == false) goto L7;
        return Long.valueOf(((Number) r8).longValue());
    L7:
        if ((r8 instanceof String) == false) goto L16;
        String r10 = ((String) r8).trim();
        if (r10.isEmpty() == false) goto L19;
        return null;
    L19:
        return Long.valueOf(Long.parseLong(r10));
    L13:
        e = move-exception;
        CaeLog.w(TAG, "parseLong: invalid value=" + r8 + ", error=" + e);
        return null;
    L16:
        if (r8 == null) goto L18;
        CaeLog.w(TAG, "parseLong: unsupported value=" + r8);
    L18:
        return null;
    }

    private Integer parseNonNegativeInt(Object r8) {
        Long r10 = parseLong(r8);
        if (r10 != null) goto L6;
        return null;
    L6:
        if (r10.longValue() >= 0) goto L8;
    L12:
        CaeLog.w(TAG, "parseNonNegativeInt: out of range=" + r8);
        return null;
    L8:
        if (r10.longValue() > 2147483647L) goto L12;
        return Integer.valueOf(r10.intValue());
    }

    private Long parseNonNegativeLong(Object r8) {
        Long r10 = parseLong(r8);
        if (r10 != null) goto L6;
        return null;
    L6:
        if (r10.longValue() >= 0) goto L9;
        CaeLog.w(TAG, "parseNonNegativeLong: negative value=" + r8);
        return null;
    L9:
        return r10;
    }

    private Integer parseRssiThreshold(Object r8) {
        Long r10 = parseLong(r8);
        if (r10 != null) goto L6;
        return null;
    L6:
        if (r10.longValue() >= (-127)) goto L8;
    L12:
        CaeLog.w(TAG, "parseRssiThreshold: out of range=" + r8);
        return null;
    L8:
        if (r10.longValue() > 0) goto L12;
        return Integer.valueOf(r10.intValue());
    }

    public void onCloudDataChange(String r8) {
        CaeUtil.sendMessageWithParam(this.mUpdateHandler, 1, r8);
    }
}
