package com.bytedance.android.livesdk.config;

import android.content.Context;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.privacy.av.api.PrivacyConfig;
import com.bytedance.android.live.feature.config.LiveFeatureConfig;
import com.bytedance.android.livehostapi.LiveSdkInitHelper;
import com.bytedance.android.livesdk.config.ai.LiveAIConfig;
import com.bytedance.android.livesdkapi.model.PlayerRoiSrConfig;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class LiveInitSettingKeys {
    public static final String CJ_SCHEMA_RISK_INFO_HOSTS = "cj_schema_risk_info_hosts";
    public static final String ENABLE_ASSET_DOWNLOAD_INFO_LOG = "enable_record_download_info";
    public static final String LIVE_AI_CONFIG = "live_ai_config";
    public static final String LIVE_AUDIO_AND_VIDEO_PRIVACY_CONFIG = "live_audio_and_video_privacy_config";
    public static final String LIVE_DEGRADE_STRATEGY_SDK_ENABLE = "live_degrade_strategy_sdk_enable";
    public static final String LIVE_ENABLE_DOWNLOAD_BMF_SO_PLUGIN = "live_enable_download_bmf_so_plugin";
    public static final String LIVE_ENABLE_HOST_REFLECT_OPT = "live_enable_host_reflect_opt";
    public static final String LIVE_ENABLE_PULL_STREAM_SO_PLUGIN = "live_enable_pull_stream_so_plugin";
    public static final String LIVE_EQUAL_TALK_ROOM_TOP_MARGIN_RATIO = "live_equal_talk_room_top_margin_ratio";
    public static final String LIVE_FEATURE_CONFIG = "live_feature_config";
    public static final String LIVE_GIFT_PANEL_STYLE = "live_gift_panel_style";
    public static final String LIVE_HEADSET_SERVICE_USE_SWITCH = "live_headset_service_use_switch";
    public static final String LIVE_HOT_ROOM_PERFORMANCE_SETTING = "live_hot_room_performance_setting";
    public static final String LIVE_IO_PRE_START = "live_io_pre_start";
    public static final String LIVE_LITE_ENABLE_PLUGIN_ENV_LOAD = "live_lite_enable_plugin_env_load";
    public static final String LIVE_LOGSDK_CONFIG = "live_logsdk_config";
    public static final String LIVE_LOG_SDK_SPM_BLACK_LIST = "live_log_sdk_spm_black_list";
    public static final String LIVE_PAD_BACKUP_DISABLE_OPT = "ttlive_pad_opt_disable_control";
    public static final String LIVE_PAD_SETTING_MOCK = "ttlive_pad_setting_mock";
    public static final String LIVE_PERFORMANCE_RESOURCE_CONFIG = "live_performance_resource_config";
    public static final String LIVE_PERFORMANCE_SETTING = "live_performance_setting";
    public static final String LIVE_PLAYER_LAYOUT_FIX_STATUSBAR = "live_player_layout_fix_statusbar";
    public static final String LIVE_PLAYER_LAYOUT_OPT_V1 = "live_player_layout_opt_v1";
    public static final String LIVE_PLAYER_ROI_SR_CONFIG = "live_player_roi_sr_config";
    public static final String LIVE_PLAYER_STRATEGY_SERVICE_SWITCH = "live_player_strategy_service_switch";
    public static final String LIVE_SETTINGS_MONITOR = "live_enable_setting_monitor";
    public static final String LIVE_SKIN_PULL_TIMES_EVERY_DAY = "live_skin_pull_times_every_day";
    public static final String LIVE_STREAM_STRATEGY_OPTIMIZER = "live_stream_strategy_sdk_enable";
    public static final String LIVE_WEBVIEW_USE_MONITOR = "live_webview_use_monitor";
    public static final String LIVW_WEBVIEW_MONITOR_CONFIG = "webcast_monitor_config";
    public static final String WEBVIEW_MONITOR_SLARDAR_SWITCH_SET = "tt_live_webview_monitor_config_slardar_android";
    private static Boolean useLivePlayerLayoutV1;

    public LiveInitSettingKeys() {
    }

    private static boolean isSettingOpt() {
        return false;
    }

    public static Boolean enableInitFeedOpt() {
        return Boolean.valueOf(xq0.a.getValue().c());
    }

    public static Boolean enableInitLauncherOpt() {
        return Boolean.valueOf(xq0.a.getValue().d());
    }

    public static Boolean enableInitServiceOpt() {
        return Boolean.valueOf(xq0.a.getValue().e());
    }

    public static Boolean enableInitSettingOpt() {
        return Boolean.valueOf(xq0.a.getValue().f());
    }

    public static Boolean get_LIVE_DEGRADE_STRATEGY_SDK_ENABLE() {
        if (tb1.c.a == true) goto L7;
        return Boolean.FALSE;
    L7:
        return zm.a.getValue();
    }

    public static Boolean get_LIVE_HYBRID_USE_MONITOR_SAMPLE_RATE() {
        if (tb1.c.c == false) goto L9;
        if (isSettingOpt() == false) goto L9;
        return Boolean.TRUE;
    L9:
        return (Boolean) AnnieConfigSettingKeys.LIVE_HYBRID_USE_MONITOR_SAMPLE_RATE.a();
    }

    public static boolean get_LIVE_PLAYER_LAYOUT_V1_ENABLE() {
        Boolean r0 = useLivePlayerLayoutV1;
        if (r0 == null) goto L7;
        return r0.booleanValue();
    L7:
        if (isSettingOpt() == false) goto L9;
        useLivePlayerLayoutV1 = Boolean.valueOf(getBooleanValue(LIVE_PLAYER_LAYOUT_OPT_V1, false));
    L11:
        return useLivePlayerLayoutV1.booleanValue();
    L9:
        useLivePlayerLayoutV1 = (Boolean) yh0.a.getValue();
        goto L11
    }

    public static long launchTaskDelayTime() {
        return xq0.a.getValue().a();
    }

    public static List<c81.a> noDelayTaskTimeInfos() {
        return xq0.a.getValue().b();
    }

    public static List<String> get_CJ_SCHEMA_RISK_INFO_HOSTS() {
        if (isSettingOpt() == false) goto L7;
        return (List) getJsonConfig(CJ_SCHEMA_RISK_INFO_HOSTS, ArrayList.class, new ArrayList());
    L7:
        return (List) b1.a.getValue();
    }

    public static boolean get_ENABLE_ASSET_DOWNLOAD_INFO_LOG() {
        if (isSettingOpt() == false) goto L7;
        return getBooleanValue(ENABLE_ASSET_DOWNLOAD_INFO_LOG, false);
    L7:
        return g3.a.getValue().booleanValue();
    }

    public static LiveAIConfig get_LIVE_AI_CONFIG() {
        if (isSettingOpt() == false) goto L7;
        return (LiveAIConfig) getJsonConfig(LIVE_AI_CONFIG, LiveAIConfig.class, new LiveAIConfig());
    L7:
        return ca.a.getValue();
    }

    public static PrivacyConfig get_LIVE_AUDIO_AND_VIDEO_PRIVACY_CONFIG() {
        if (isSettingOpt() == false) goto L7;
        return (PrivacyConfig) getJsonConfig(LIVE_AUDIO_AND_VIDEO_PRIVACY_CONFIG, PrivacyConfig.class, new PrivacyConfig());
    L7:
        return df.a.getValue();
    }

    public static String get_LIVE_CERT_CAMERA_EXPLAIN() {
        if (isSettingOpt() == false) goto L7;
        return (String) LiveConfigSimplifySettingKeys.LIVE_CERT_CAMERA_EXPLAIN.getValue();
    L7:
        return (String) LiveConfigSimplifySettingKeys.LIVE_CERT_CAMERA_EXPLAIN.getValue();
    }

    public static boolean get_LIVE_CERT_ENABLE_SHOW_MASK() {
        if (isSettingOpt() == false) goto L7;
        return ((Boolean) LiveConfigSimplifySettingKeys.LIVE_CERT_ENABLE_SHOW_MASK.getValue()).booleanValue();
    L7:
        return ((Boolean) LiveConfigSimplifySettingKeys.LIVE_CERT_ENABLE_SHOW_MASK.getValue()).booleanValue();
    }

    public static String get_LIVE_CERT_MICROPHONE_EXPLAIN() {
        if (isSettingOpt() == false) goto L7;
        return (String) LiveConfigSimplifySettingKeys.LIVE_CERT_MICROPHONE_EXPLAIN.getValue();
    L7:
        return (String) LiveConfigSimplifySettingKeys.LIVE_CERT_MICROPHONE_EXPLAIN.getValue();
    }

    public static String get_LIVE_CERT_STORAGW_EXPLAIN() {
        if (isSettingOpt() == false) goto L7;
        return (String) LiveConfigSimplifySettingKeys.LIVE_CERT_STORAGW_EXPLAIN.getValue();
    L7:
        return (String) LiveConfigSimplifySettingKeys.LIVE_CERT_STORAGW_EXPLAIN.getValue();
    }

    public static b3 get_LIVE_DRAWER_ENTRANCE_REDESIGN() {
        if (isSettingOpt() == false) goto L7;
        return (b3) LiveSimplifySettingKeys.LIVE_DRAWER_ENTRANCE_REDESIGN.getValue();
    L7:
        return (b3) LiveSimplifySettingKeys.LIVE_DRAWER_ENTRANCE_REDESIGN.getValue();
    }

    public static boolean get_LIVE_ENABLE_BMF_PLUGIN() {
        if (isSettingOpt() == false) goto L7;
        return getBooleanValue(LIVE_ENABLE_DOWNLOAD_BMF_SO_PLUGIN, false);
    L7:
        return ir.a.getValue().booleanValue();
    }

    public static boolean get_LIVE_ENABLE_PULL_STREAM_SO_PLUGIN() {
        if (isSettingOpt() == false) goto L7;
        return getBooleanValue(LIVE_ENABLE_PULL_STREAM_SO_PLUGIN, false);
    L7:
        return qs.a.getValue().booleanValue();
    }

    public static float get_LIVE_EQUAL_TALK_ROOM_TOP_MARGIN_RATIO() {
        if (isSettingOpt() == false) goto L7;
        return getFloatValue(LIVE_EQUAL_TALK_ROOM_TOP_MARGIN_RATIO, 0.2019f);
    L7:
        return wu.a.getValue().floatValue();
    }

    public static LiveFeatureConfig get_LIVE_FEATURE_CONFIG() {
        if (isSettingOpt() == false) goto L7;
        return (LiveFeatureConfig) getJsonConfig(LIVE_FEATURE_CONFIG, LiveFeatureConfig.class, new LiveFeatureConfig());
    L7:
        return (LiveFeatureConfig) e81.a.getValue();
    }

    public static int get_LIVE_GIFT_PANEL_STYLE() {
        if (isSettingOpt() == false) goto L7;
        return getIntValue(LIVE_GIFT_PANEL_STYLE, 2);
    L7:
        return cz.a.getValue().intValue();
    }

    public static int get_LIVE_HEADSET_SWITCH() {
        if (isSettingOpt() == false) goto L7;
        return getIntValue(LIVE_HEADSET_SERVICE_USE_SWITCH, 0);
    L7:
        return a00.a.getValue().intValue();
    }

    public static com.bytedance.android.livesdk.performance.k get_LIVE_HOT_ROOM_PERFORMANCE_SETTING() {
        if (isSettingOpt() == false) goto L7;
        return (com.bytedance.android.livesdk.performance.k) getJsonConfig(LIVE_HOT_ROOM_PERFORMANCE_SETTING, com.bytedance.android.livesdk.performance.k.class, new com.bytedance.android.livesdk.performance.k());
    L7:
        return n00.a.getValue();
    }

    public static boolean get_LIVE_IO_PRE_START() {
        if (isSettingOpt() == false) goto L7;
        return getBooleanValue(LIVE_IO_PRE_START, false);
    L7:
        return q30.a.getValue().booleanValue();
    }

    public static boolean get_LIVE_LITE_ENABLE_PLUGIN_ENV_LOAD() {
        if (isSettingOpt() == false) goto L7;
        return getBooleanValue(LIVE_LITE_ENABLE_PLUGIN_ENV_LOAD, false);
    L7:
        return y60.a.getValue().booleanValue();
    }

    public static am2.v get_LIVE_LOGSDK_CONFIG() {
        if (isSettingOpt() == false) goto L11;
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L7;
        am2.v r1 = am2.v.f();
    L9:
        return (am2.v) getJsonConfig(LIVE_LOGSDK_CONFIG, am2.v.class, r1);
    L7:
        r1 = new am2.v();
        goto L9
    L11:
        return f70.a.getValue();
    }

    public static List<String> get_LIVE_LOG_SDK_SPM_BLACK_LIST() {
        if (isSettingOpt() == false) goto L7;
        return (List) getJsonConfig(LIVE_LOG_SDK_SPM_BLACK_LIST, ArrayList.class, new ArrayList());
    L7:
        return (List) j70.a.getValue();
    }

    public static boolean get_LIVE_PAD_BACKUP_DISABLE_OPT() {
        if (isSettingOpt() == false) goto L7;
        return getBooleanValue(LIVE_PAD_BACKUP_DISABLE_OPT, false);
    L7:
        return xe0.a.getValue().booleanValue();
    }

    public static com.bytedance.android.livesdk.performance.q0 get_LIVE_PERFORMANCE_RESOURCE_CONFIG() {
        if (isSettingOpt() == false) goto L7;
        return (com.bytedance.android.livesdk.performance.q0) getJsonConfig(LIVE_PERFORMANCE_RESOURCE_CONFIG, com.bytedance.android.livesdk.performance.q0.class, new com.bytedance.android.livesdk.performance.q0());
    L7:
        return ag0.a.getValue();
    }

    public static com.bytedance.android.livesdk.performance.r0 get_LIVE_PERFORMANCE_SETTING() {
        if (isSettingOpt() == false) goto L7;
        return (com.bytedance.android.livesdk.performance.r0) getJsonConfig(LIVE_PERFORMANCE_SETTING, com.bytedance.android.livesdk.performance.r0.class, new com.bytedance.android.livesdk.performance.r0());
    L7:
        return bg0.a.getValue();
    }

    public static boolean get_LIVE_PLAYER_LAYOUT_FIX_STATUSBAR() {
        if (isSettingOpt() == false) goto L7;
        return getBooleanValue(LIVE_PLAYER_LAYOUT_FIX_STATUSBAR, false);
    L7:
        return ((Boolean) j40.w1.a.getValue()).booleanValue();
    }

    public static boolean get_LIVE_PLAYER_STRATEGY_SWITCH() {
        if (isSettingOpt() == false) goto L7;
        return getBooleanValue("LIVE_PLAYER_STRATEGY_SERVICE_SWITCH", false);
    L7:
        return mi0.a.getValue().booleanValue();
    }

    public static boolean get_LIVE_ROI_SR_ENABLE() {
        if (isSettingOpt() == false) goto L7;
        return ((PlayerRoiSrConfig) getJsonConfig(LIVE_PLAYER_ROI_SR_CONFIG, PlayerRoiSrConfig.class, new PlayerRoiSrConfig())).enable;
    L7:
        return gi0.a.getValue().enable;
    }

    public static boolean get_LIVE_SETTINGS_MONITOR() {
        if (isSettingOpt() == false) goto L7;
        return getBooleanValue(LIVE_SETTINGS_MONITOR, false);
    L7:
        return or0.a.getValue().booleanValue();
    }

    public static int get_LIVE_STREAM_STRATEGY_OPTIMIZER() {
        if (isSettingOpt() == false) goto L7;
        return getIntValue(LIVE_STREAM_STRATEGY_OPTIMIZER, 0);
    L7:
        return st0.a.getValue().intValue();
    }

    public static boolean get_LIVE_WEBVIEW_USE_MONITOR() {
        if (isSettingOpt() == false) goto L7;
        return getBooleanValue(LIVE_WEBVIEW_USE_MONITOR, true);
    L7:
        return my0.a.getValue().booleanValue();
    }

    public static g91 get_LIVW_WEBVIEW_MONITOR_CONFIG() {
        if (isSettingOpt() == false) goto L7;
        return (g91) getJsonConfig(LIVW_WEBVIEW_MONITOR_CONFIG, g91.class, new g91());
    L7:
        return b01.a.getValue();
    }

    public static boolean get_ROOM_INJECT_FRAMEWORK_DEBUG() {
        if (isSettingOpt() == false) goto L7;
        return ((Boolean) LiveConfigSimplifySettingKeys.ROOM_INJECT_FRAMEWORK_DEBUG.getValue()).booleanValue();
    L7:
        return ((Boolean) LiveConfigSimplifySettingKeys.ROOM_INJECT_FRAMEWORK_DEBUG.getValue()).booleanValue();
    }

    public static String get_WEBVIEW_MONITOR_SLARDAR_SWITCH_SET() {
        if (isSettingOpt() == false) goto L7;
        return getStringValue(WEBVIEW_MONITOR_SLARDAR_SWITCH_SET, "");
    L7:
        return vj1.a.getValue();
    }

    private static boolean getBooleanValue(String r3, boolean r4) {
        Context r0 = LiveSdkInitHelper.getContext();     // Catch: Exception -> L6
        if (r0 == null) goto L8;
        return r0.getSharedPreferences("ttlive_sdk_shared_pref_cache", 0).getBoolean(r3, r4);
    L8:
        return r4;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    private static float getFloatValue(String r3, float r4) {
        Context r0 = LiveSdkInitHelper.getContext();     // Catch: Exception -> L6
        if (r0 == null) goto L8;
        return r0.getSharedPreferences("ttlive_sdk_shared_pref_cache", 0).getFloat(r3, r4);
    L8:
        return r4;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    private static int getIntValue(String r3, int r4) {
        Context r0 = LiveSdkInitHelper.getContext();     // Catch: Exception -> L6
        if (r0 == null) goto L8;
        return r0.getSharedPreferences("ttlive_sdk_shared_pref_cache", 0).getInt(r3, r4);
    L8:
        return r4;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    private static String getStringValue(String r3, String r4) {
        Context r0 = LiveSdkInitHelper.getContext();     // Catch: Exception -> L6
        if (r0 == null) goto L8;
        return r0.getSharedPreferences("ttlive_sdk_shared_pref_cache", 0).getString(r3, r4);
    L8:
        return r4;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    private static <T> T getJsonConfig(String r3, Class<T> r4, T r5) {
        Context r0 = LiveSdkInitHelper.getContext();     // Catch: Exception -> L8
        if (r0 == null) goto L10;
        String r6 = r0.getSharedPreferences("ttlive_sdk_shared_pref_cache", 0).getString(r3, "");     // Catch: Exception -> L8
        T r7 = (T) GsonHelper.get().fromJson(r6, r4);
        if (r7 != null) goto L7;
        return r5;
    L7:
        return r7;
    L10:
        return r5;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }
}
