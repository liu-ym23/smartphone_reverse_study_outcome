package com.bytedance.bdlocation.settings;

import android.text.TextUtils;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.bdlocation.monitor.LocationExtraDataTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.cae.userAware.WifiScanStateMachine;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class LocationSettingModel {
    public static final String LOCATION_BEACON_SETTINGS_KEY = "locationsdk_beacon_config_android";
    public static final String LOCATION_SETTINGS_KEY = "locationsdk_config_android";
    public static final String LOCATION_SHAKE_SETTINGS_KEY = "locationsdk_shake_config_android";
    public boolean amapGPSCollectAlwaysUseNewAMapClient;
    public boolean asyncScanWifi;
    public int baseStationInfoType;
    public JSONObject beaconConfig;
    public String byteLocationLibraParam;
    public String byteLocationWhiteList;
    public int checkConnectWifiRssi;
    public boolean checkLocationBpea;
    public long checkWifiCacheDuration;
    public boolean coldBootABTest;
    public boolean coldBootCollectGps;
    public int coldBootCollectGpsStrategy;
    public boolean collectConfig;
    public boolean collectContinuousGpsDisableGnssUpload;
    public long collectContinuousGpsDuration;
    public long collectContinuousGpsInterval;
    public String collectContinuousGpsLocTokenBlacklist;
    public boolean collectContinuousGpsOnlyLast;
    public int collectGpsType;
    public boolean collectLightInfo;
    public long defaultGpsScanInterval;
    public String disableCollectAMapLocationSource;
    public String disableTailLocateOptimizeSource;
    public boolean enableBackgroundLocation;
    public boolean enableBackgroundUploadLocation;
    public boolean enableBlePassiveName;
    public boolean enableBleTruncateOnTimeout;
    public boolean enableByteContinuousLocation;
    public boolean enableCheckConnectWifi;
    public boolean enableCheckLastLogId;
    public boolean enableCheckUploadCompliance;
    public boolean enableCheckWifiCache;
    public boolean enableCollectAMapLocationInBatterySavingMode;
    public boolean enableCollectBleInBatterySavingMode;
    public boolean enableCollectContinuousGps;
    public boolean enableCollectContinuousGpsForTest;
    public boolean enableCollectGPSLocationInBatterySavingMode;
    public boolean enableCollectNetworkLocationInBatterySavingMode;
    public boolean enableContinueLocateUploadCell;
    public boolean enableContinueLocateUploadWifi;
    public boolean enableDestroyAMapContinuousClient;
    public boolean enableDestroyAMapSingleClient;
    public boolean enableDimLocationCheck;
    public boolean enableGpsScan;
    public boolean enableInfoRequestOpt;
    public boolean enableLightLocation;
    public boolean enableLightLocationNewPolicy;
    public boolean enableLocationCacheTokenWhiteList;
    public String enableLocationOptBpeaList;
    public boolean enableLocationOptEncrypt;
    public boolean enableMonitor;
    public boolean enableNoLocReqCgi;
    public boolean enableScanGnss;
    public boolean enableScanWifi;
    public boolean enableStationaryScenePolicy;
    public boolean enableSysNetworkLoc;
    public boolean enableTailLocateOptimize;
    public boolean enableTraceroute;
    public boolean enableUploadLastLocationInfo;
    public boolean enableUploadLastLogId;
    public boolean enableUseCoarseLocation;
    public long firstLocationTimeoutMs;
    public long freshBaseStationTimeout;
    public int hotBootCacheTime;
    public String hotBootLocToken;
    public long inOutDoorStatusCacheTime;
    public boolean independentThreadGetScanResults;
    public long infoRequestKeyParamsMaxCacheTime;
    public boolean isUploadFreshBaseStation;
    public boolean isUseQuickGPS;
    public int lightInfoInterval;
    public int locateType;
    public String locationCacheTokenWhiteList;
    public long locationExpiredInterval;
    public int locationMode;
    public int maxLightCount;
    public long maxLightDuration;
    public long maxWaitGPSTimeMillis;
    public List<String> monitorBusinessStartLocationClassMember;
    public List<String> monitorBusinessStopLocationClassMember;
    public int monitorStrategy;
    public List<String> monitorStrategyClassMember;
    public long monitorStrategyInterval;
    public boolean needDowngradeLocationInOverseas;
    public boolean needUploadLastContinuousLocation;
    public String networkSignatureMode;
    public boolean openWifiListMonitor;
    public long overseasGetLocationFailedCacheValidityTime;
    public boolean pollingUpload;
    public boolean preLocationCallback;
    public String redGeoNameIds;
    public boolean reportAtStart;
    public boolean reportBss;
    public int reportBssMax;
    public boolean reportGps;
    public boolean reportHar;
    public int reportHarRange;
    public int reportIntervalSeconds;
    public boolean reportLocationAtStart;
    public boolean reportWifi;
    public int reportWifiMax;
    public boolean revertToSystemLocation;
    public boolean sEnableRescanWifi;
    public int sRescanWifiCount;
    public boolean scanBle;
    public long scanBleInterval;
    public long searchLocationCacheTime;
    public JSONObject shakeConfig;
    public int stationarySceneMaxDistance;
    public int stationarySceneMaxGpsAccuracy;
    public long stationarySceneMaxInterval;
    public String stationarySceneTokenWhiteList;
    public String stationarySceneWifiWhiteList;
    public float tailAccuracyThreshold;
    public long tailWifiTimeThreshold;
    public int uploadBleNum;
    public long uploadNetSignalInterval;
    public boolean useCacheCondition;
    public boolean useGpsCheckRegion;
    public boolean useNewCacheStrategy;
    public boolean useNewReverseGeoLocationApi;
    public long wifiScanInterval;

    public LocationSettingModel() {
        this.collectConfig = true;
        this.reportAtStart = true;
        this.reportLocationAtStart = false;
        this.pollingUpload = false;
        this.independentThreadGetScanResults = false;
        this.amapGPSCollectAlwaysUseNewAMapClient = true;
        this.enableLocationOptBpeaList = "";
        this.enableLocationOptEncrypt = false;
        this.locateType = 3;
        this.reportIntervalSeconds = 300;
        this.reportWifiMax = 30;
        this.reportBssMax = 10;
        this.reportGps = true;
        this.reportWifi = true;
        this.reportBss = true;
        this.reportHar = false;
        this.reportHarRange = 64;
        this.enableTraceroute = false;
        this.openWifiListMonitor = false;
        this.coldBootABTest = false;
        this.uploadBleNum = 30;
        this.scanBleInterval = 1000;
        this.scanBle = false;
        this.enableBlePassiveName = true;
        this.enableBleTruncateOnTimeout = true;
        this.checkLocationBpea = false;
        this.locationMode = 2;
        this.useNewCacheStrategy = false;
        this.collectLightInfo = false;
        this.revertToSystemLocation = false;
        this.lightInfoInterval = 3;
        this.maxLightCount = 30;
        this.maxLightDuration = 5000;
        this.enableGpsScan = false;
        this.checkConnectWifiRssi = -60;
        this.checkWifiCacheDuration = 10000;
        this.enableScanWifi = true;
        this.useNewReverseGeoLocationApi = false;
        this.enableNoLocReqCgi = false;
        this.enableSysNetworkLoc = true;
        this.enableMonitor = false;
        this.monitorStrategy = 0;
        this.monitorStrategyInterval = 3000;
        this.monitorStrategyClassMember = new ArrayList();
        this.monitorBusinessStartLocationClassMember = new ArrayList();
        this.monitorBusinessStopLocationClassMember = new ArrayList();
        this.infoRequestKeyParamsMaxCacheTime = WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS;
        this.maxWaitGPSTimeMillis = 0;
        this.preLocationCallback = false;
        this.byteLocationLibraParam = LocationInfoConst.LIBRA_PARAM_V2;
        this.byteLocationWhiteList = "";
        this.collectGpsType = 0;
        this.sEnableRescanWifi = false;
        this.sRescanWifiCount = 60;
        this.useCacheCondition = false;
        this.disableCollectAMapLocationSource = LocationInfoConst.UNKNOWN_SOURCE;
        this.enableLocationCacheTokenWhiteList = false;
        this.locationCacheTokenWhiteList = "";
        this.hotBootLocToken = "";
        this.hotBootCacheTime = -1;
        this.coldBootCollectGpsStrategy = 0;
        this.coldBootCollectGps = false;
        this.enableUploadLastLogId = true;
        this.networkSignatureMode = "";
        this.defaultGpsScanInterval = 0;
        this.enableCheckUploadCompliance = true;
        this.enableBackgroundUploadLocation = false;
        this.enableCheckLastLogId = true;
        this.enableDimLocationCheck = false;
        this.enableTailLocateOptimize = false;
        this.tailAccuracyThreshold = 100.0f;
        this.tailWifiTimeThreshold = 300000;
        this.disableTailLocateOptimizeSource = LocationInfoConst.UNKNOWN_SOURCE;
        this.isUploadFreshBaseStation = false;
        this.freshBaseStationTimeout = 0;
        this.enableUploadLastLocationInfo = false;
        this.enableCollectContinuousGps = false;
        this.collectContinuousGpsInterval = 1000;
        this.collectContinuousGpsDuration = 5000;
        this.collectContinuousGpsLocTokenBlacklist = "";
        this.collectContinuousGpsDisableGnssUpload = false;
        this.collectContinuousGpsOnlyLast = true;
        this.inOutDoorStatusCacheTime = 600000;
        this.enableScanGnss = true;
        this.stationarySceneMaxDistance = 50;
        this.stationarySceneMaxInterval = 1800000;
        this.stationarySceneMaxGpsAccuracy = 50;
        this.stationarySceneWifiWhiteList = "";
        this.stationarySceneTokenWhiteList = "";
        this.enableCollectContinuousGpsForTest = false;
        this.enableContinueLocateUploadWifi = true;
        this.enableContinueLocateUploadCell = true;
        this.enableByteContinuousLocation = true;
        this.locationExpiredInterval = 100000;
        this.uploadNetSignalInterval = 30000;
        this.firstLocationTimeoutMs = 10000;
        this.needUploadLastContinuousLocation = true;
        this.isUseQuickGPS = false;
    }

    public static LocationSettingModel toModel(String r16) {
        if (TextUtils.isEmpty(r16) == false) goto L6;
        return null;
    L6:
        LocationSettingModel r2 = new LocationSettingModel();
        JSONObject r3 = new JSONObject(r16);     // Catch: JSONException -> L45
        JSONObject r4 = r3.optJSONObject(LOCATION_SETTINGS_KEY);     // Catch: JSONException -> L45
        if (r4 == null) goto L43;
        r2.collectConfig = r4.optBoolean("collect_config", true);     // Catch: JSONException -> L45
        r2.pollingUpload = r4.optBoolean("polling_upload", false);     // Catch: JSONException -> L45
        r2.independentThreadGetScanResults = r4.optBoolean(LBSLightLocationTraceLogger.INDEPENDENT_THREAD_GET_SCAN_RESULTS, false);     // Catch: JSONException -> L45
        r2.amapGPSCollectAlwaysUseNewAMapClient = r4.optBoolean("amap_gps_collect_always_use_new_amap_client", true);     // Catch: JSONException -> L45
        r2.enableLocationOptBpeaList = r4.optString(LBSLightLocationTraceLogger.ENABLE_LOCATION_OPT_BPEA_LIST, "");     // Catch: JSONException -> L45
        r2.enableLocationOptEncrypt = r4.optBoolean("enable_location_opt_encrypt", false);     // Catch: JSONException -> L45
        r2.locateType = r4.optInt(LocationMonitorConst.LOCATE_TYPE, 3);     // Catch: JSONException -> L45
        r2.reportIntervalSeconds = r4.optInt("report_interval_seconds", 300);     // Catch: JSONException -> L45
        r2.reportAtStart = r4.optBoolean("report_at_start", true);     // Catch: JSONException -> L45
        r2.reportLocationAtStart = r4.optBoolean("report_location_at_start", false);     // Catch: JSONException -> L45
        r2.reportGps = r4.optBoolean("report_gps", true);     // Catch: JSONException -> L45
        r2.reportWifi = r4.optBoolean("report_wifi", true);     // Catch: JSONException -> L45
        r2.reportBss = r4.optBoolean("report_bss", true);     // Catch: JSONException -> L45
        r2.reportHar = r4.optBoolean("report_har", false);     // Catch: JSONException -> L45
        r2.reportHarRange = r4.optInt("report_har_range", 64);     // Catch: JSONException -> L45
        r2.enableTraceroute = r4.optBoolean("enable_traceroute", false);     // Catch: JSONException -> L45
        r2.reportBssMax = r4.optInt("report_bss_max", 10);     // Catch: JSONException -> L45
        r2.reportWifiMax = r4.optInt("report_wifi_max", 30);     // Catch: JSONException -> L45
        r2.coldBootABTest = r4.optBoolean(SettingsConstants.COLD_BOOT_AB_TEST, false);     // Catch: JSONException -> L45
        r2.uploadBleNum = r4.optInt("upload_ble_num", 30);     // Catch: JSONException -> L45
        r2.scanBleInterval = r4.optLong("scan_ble_interval", 1000);     // Catch: JSONException -> L45
        r2.scanBle = r4.optBoolean("scan_ble", false);     // Catch: JSONException -> L45
        r2.enableBlePassiveName = r4.optBoolean(SettingsConstants.ENABLE_BLE_PASSIVE_NAME, true);     // Catch: JSONException -> L45
        r2.enableBleTruncateOnTimeout = r4.optBoolean(SettingsConstants.ENABLE_BLE_TRUNCATE_ON_TIMEOUT, true);     // Catch: JSONException -> L45
        r2.checkLocationBpea = r4.optBoolean("check_location_bpea", false);     // Catch: JSONException -> L45
        r2.locationMode = r4.optInt(LocationMonitorConst.LOCATION_MODE, 2);     // Catch: JSONException -> L45
        r2.openWifiListMonitor = r4.optBoolean("open_wifi_list_monitor", false);     // Catch: JSONException -> L45
        r2.useGpsCheckRegion = r4.optBoolean("use_gps_check_region", false);     // Catch: JSONException -> L45
        r2.overseasGetLocationFailedCacheValidityTime = r4.optLong("overseas_get_location_failed_cache_validity_time", LocationInfoConst.defaultsOverseasCacheValidity);     // Catch: JSONException -> L45
        r2.redGeoNameIds = r4.optString("red_geo_name_ids", LocationInfoConst.defaultRedGeoNameIds);     // Catch: JSONException -> L45
        r2.needDowngradeLocationInOverseas = r4.optBoolean("need_downgrade_location_in_overseas", false);     // Catch: JSONException -> L45
        r2.useNewCacheStrategy = r4.optBoolean("use_new_cache_strategy", false);     // Catch: JSONException -> L45
        r2.enableLightLocation = r4.optBoolean(SettingsConstants.ENABLE_LIGHT_LOCATION, false);     // Catch: JSONException -> L45
        r2.collectLightInfo = r4.optBoolean("collect_light_info", false);     // Catch: JSONException -> L45
        r2.revertToSystemLocation = r4.optBoolean("revert_to_system_location", false);     // Catch: JSONException -> L45
        r2.lightInfoInterval = r4.optInt("light_info_interval", 3);     // Catch: JSONException -> L45
        r2.maxLightCount = r4.optInt("max_light_count", 30);     // Catch: JSONException -> L45
        r2.maxLightDuration = r4.optLong("max_light_duration", 5000);     // Catch: JSONException -> L45
        r2.enableGpsScan = r4.optBoolean("enable_gps_scan", false);     // Catch: JSONException -> L45
        r2.asyncScanWifi = r4.optBoolean("async_scan_wifi", false);     // Catch: JSONException -> L45
        r2.enableCheckConnectWifi = r4.optBoolean("enable_check_connect_wifi", false);     // Catch: JSONException -> L45
        r2.checkConnectWifiRssi = r4.optInt("check_connect_wifi_rssi", -60);     // Catch: JSONException -> L45
        r2.enableCheckWifiCache = r4.optBoolean("enable_check_wifi_cache", false);     // Catch: JSONException -> L45
        r2.checkWifiCacheDuration = r4.optLong("check_wifi_cache_duration", 10000);     // Catch: JSONException -> L45
        r2.enableScanWifi = r4.optBoolean("enable_scan_wifi", true);     // Catch: JSONException -> L45
        r2.useNewReverseGeoLocationApi = r4.optBoolean("use_new_reverse_geolocation_api", false);     // Catch: JSONException -> L45
        r2.enableNoLocReqCgi = r4.optBoolean("enable_no_loc_reqcgi", false);     // Catch: JSONException -> L45
        r2.enableSysNetworkLoc = r4.optBoolean("enable_sys_network_loc", true);     // Catch: JSONException -> L45
        r2.enableLightLocationNewPolicy = r4.optBoolean("enable_light_location_new_policy", false);     // Catch: JSONException -> L45
        r2.enableBackgroundLocation = r4.optBoolean("enable_background_location", false);     // Catch: JSONException -> L45
        r2.enableInfoRequestOpt = r4.optBoolean("enable_info_request_opt", false);     // Catch: JSONException -> L45
        r2.maxWaitGPSTimeMillis = r4.optLong(LocationMonitorConst.MAX_WAIT_GPS_TIME_MILLIS, 0);     // Catch: JSONException -> L45
        r2.preLocationCallback = r4.optBoolean(LocationMonitorConst.PRE_LOCATION_CALLBACK, false);     // Catch: JSONException -> L45
        r2.infoRequestKeyParamsMaxCacheTime = r4.optLong("info_request_key_params_max_cache_time", WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS);     // Catch: JSONException -> L45
        r2.byteLocationLibraParam = r4.optString("byte_location_libra_param", LocationInfoConst.LIBRA_PARAM_V2);     // Catch: JSONException -> L45
        r2.searchLocationCacheTime = r4.optLong(SettingsConstants.SEARCH_LOCATION_CACHE_TIME, -1);     // Catch: JSONException -> L45
        r2.byteLocationWhiteList = r4.optString(SettingsConstants.BYTE_LOCATION_WHITE_LIST, "");     // Catch: JSONException -> L45
        r2.collectGpsType = r4.optInt("collect_gps_type", 0);     // Catch: JSONException -> L45
        r2.disableCollectAMapLocationSource = r4.optString("disable_collect_amap_location_source", LocationInfoConst.UNKNOWN_SOURCE);     // Catch: JSONException -> L45
        r2.wifiScanInterval = r4.optLong(SettingsConstants.SCAN_WIFI_INTERVAL, 0);     // Catch: JSONException -> L45
        r2.enableCollectGPSLocationInBatterySavingMode = r4.optBoolean("enable_collect_gps_location_in_battery_saving_mode", false);     // Catch: JSONException -> L45
        r2.enableCollectNetworkLocationInBatterySavingMode = r4.optBoolean(SettingsConstants.ENABLE_COLLECT_NETWORK_LOCATION_IN_BATTERY_SAVING_MODE, false);     // Catch: JSONException -> L45
        r2.enableCollectAMapLocationInBatterySavingMode = r4.optBoolean(SettingsConstants.ENABLE_COLLECT_AMAP_LOCATION_IN_BATTERY_SAVING_MODE, false);     // Catch: JSONException -> L45
        r2.enableCollectBleInBatterySavingMode = r4.optBoolean("enable_collect_ble_in_battery_saving_mode", false);     // Catch: JSONException -> L45
        r2.enableUploadLastLogId = r4.optBoolean(SettingsConstants.ENABLE_UPLOAD_LAST_LOG_ID, true);     // Catch: JSONException -> L45
        r2.enableDestroyAMapSingleClient = r4.optBoolean(SettingsConstants.ENABLE_DESTROY_AMAP_SINGLE_CLIENT, false);     // Catch: JSONException -> L45
        r2.enableDestroyAMapContinuousClient = r4.optBoolean(SettingsConstants.ENABLE_DESTROY_AMAP_CONTINUOUS_CLIENT, false);     // Catch: JSONException -> L45
        r2.enableByteContinuousLocation = r4.optBoolean("enable_byte_continuous_location", true);     // Catch: JSONException -> L45
        r2.locationExpiredInterval = r4.optLong("location_expired_interval", 100000);     // Catch: JSONException -> L45
        r2.uploadNetSignalInterval = r4.optLong("upload_net_signal_interval", 30000);     // Catch: JSONException -> L45
        r2.firstLocationTimeoutMs = r4.optLong("first_location_timeout_ms", 10000);     // Catch: JSONException -> L45
        r2.needUploadLastContinuousLocation = r4.optBoolean("need_upload_last_continuous_location", true);     // Catch: JSONException -> L45
        r2.isUseQuickGPS = r4.optBoolean("is_use_quick_gps", false);     // Catch: JSONException -> L45
        r2.enableMonitor = r4.optBoolean("enable_monitor", false);     // Catch: JSONException -> L45
        r2.monitorStrategy = r4.optInt("monitor_strategy", 0);     // Catch: JSONException -> L45
        r2.monitorStrategyInterval = r4.optLong("monitor_strategy_interval", 3000);     // Catch: JSONException -> L45
        JSONArray r5 = r4.optJSONArray("monitor_strategy_class_member");     // Catch: JSONException -> L45
        if (r5 != null) goto L12;
    L20:
        JSONArray r6 = r4.optJSONArray("monitor_business_start_location_class_member");     // Catch: JSONException -> L45
        if (r6 != null) goto L23;
    L31:
        JSONArray r7 = r4.optJSONArray("monitor_business_stop_location_class_member");     // Catch: JSONException -> L45
        if (r7 != null) goto L34;
    L42:
        r2.sEnableRescanWifi = r4.optBoolean("enable_rescan_wifi", false);     // Catch: JSONException -> L45
        r2.sRescanWifiCount = r4.optInt("rescan_wifi_count", 60);     // Catch: JSONException -> L45
        r2.useCacheCondition = r4.optBoolean("use_cache_condition", false);     // Catch: JSONException -> L45
        r2.enableLocationCacheTokenWhiteList = r4.optBoolean("enable_location_cache_token_white_list", false);     // Catch: JSONException -> L45
        r2.locationCacheTokenWhiteList = r4.optString("location_cache_token_white_list", "");     // Catch: JSONException -> L45
        r2.hotBootLocToken = r4.optString("hot_boot_loc_token", "");     // Catch: JSONException -> L45
        r2.hotBootCacheTime = r4.optInt("hot_boot_cache_time", -1);     // Catch: JSONException -> L45
        r2.coldBootCollectGpsStrategy = r4.optInt("cold_boot_collect_gps_strategy", 0);     // Catch: JSONException -> L45
        r2.coldBootCollectGps = r4.optBoolean("cold_boot_collect_gps", false);     // Catch: JSONException -> L45
        r2.networkSignatureMode = r4.optString(LocationMonitorConst.NETWORK_SIGNATURE_MODE, "");     // Catch: JSONException -> L45
        r2.defaultGpsScanInterval = r4.optLong(LocationExtraDataTraceLogger.DEFAULT_GPS_SCAN_INTERVAL, 0);     // Catch: JSONException -> L45
        r2.enableCheckUploadCompliance = r4.optBoolean(LocationExtraDataTraceLogger.ENABLE_CHECK_UPLOAD_COMPLIANCE, true);     // Catch: JSONException -> L45
        r2.enableBackgroundUploadLocation = r4.optBoolean(LocationExtraDataTraceLogger.ENABLE_BACKGROUND_UPLOAD_LOCATION, false);     // Catch: JSONException -> L45
        r2.enableCheckLastLogId = r4.optBoolean(LocationExtraDataTraceLogger.ENABLE_CHECK_LAST_LOG_ID, true);     // Catch: JSONException -> L45
        r2.enableUseCoarseLocation = r4.optBoolean(SettingsConstants.ENABLE_USE_COARSE_LOCATION, false);     // Catch: JSONException -> L45
        r2.enableCollectContinuousGps = r4.optBoolean("collect_continuous_gps_enable", false);     // Catch: JSONException -> L45
        r2.collectContinuousGpsInterval = r4.optLong("collect_continuous_gps_interval", 1000);     // Catch: JSONException -> L45
        r2.collectContinuousGpsDuration = r4.optLong("collect_continuous_gps_duration", 5000);     // Catch: JSONException -> L45
        r2.collectContinuousGpsDisableGnssUpload = r4.optBoolean("collect_continuous_gps_disable_gnss_upload", false);     // Catch: JSONException -> L45
        r2.collectContinuousGpsOnlyLast = r4.optBoolean("collect_continuous_gps_only_last", true);     // Catch: JSONException -> L45
        r2.collectContinuousGpsLocTokenBlacklist = r4.optString("collect_continuous_gps_loc_token_blacklist");     // Catch: JSONException -> L45
        r2.enableDimLocationCheck = r4.optBoolean("enable_dim_location_check", false);     // Catch: JSONException -> L45
        r2.enableTailLocateOptimize = r4.optBoolean(LocationMonitorConst.ENABLE_TAIL_LOCATE_OPTIMIZE, false);     // Catch: JSONException -> L45
        r2.tailAccuracyThreshold = (float) r4.optDouble("tail_accuracy_threshold", 100.0d);     // Catch: JSONException -> L45
        r2.tailWifiTimeThreshold = r4.optLong("tail_wifi_time_threshold", 300000);     // Catch: JSONException -> L45
        r2.disableTailLocateOptimizeSource = r4.optString("disable_tail_locate_optimize_source", LocationInfoConst.UNKNOWN_SOURCE);     // Catch: JSONException -> L45
        r2.isUploadFreshBaseStation = r4.optBoolean("upload_fresh_base_station", false);     // Catch: JSONException -> L45
        r2.freshBaseStationTimeout = r4.optLong(LocationMonitorConst.FRESH_BASE_STATION_TIMEOUT, 0);     // Catch: JSONException -> L45
        r2.baseStationInfoType = r4.optInt(SettingsConstants.BASE_STATION_INFO_TYPE, 0);     // Catch: JSONException -> L45
        r2.enableUploadLastLocationInfo = r4.optBoolean("enable_upload_last_location_info", false);     // Catch: JSONException -> L45
        r2.inOutDoorStatusCacheTime = r4.optLong(SettingsConstants.IN_OUT_DOOR_STATUS_CACHE_TIME, 600000);     // Catch: JSONException -> L45
        r2.enableScanGnss = r4.optBoolean(SettingsConstants.ENABLE_SCAN_GNSS, true);     // Catch: JSONException -> L45
        r2.stationarySceneMaxDistance = r4.optInt(SettingsConstants.STATIONARY_SCENE_MAX_DISTANCE, 50);     // Catch: JSONException -> L45
        r2.stationarySceneMaxInterval = r4.optLong(SettingsConstants.STATIONARY_SCENE_MAX_INTERVAL, 1800000);     // Catch: JSONException -> L45
        r2.stationarySceneMaxGpsAccuracy = r4.optInt(SettingsConstants.STATIONARY_SCENE_MAX_GPS_ACCURACY, 50);     // Catch: JSONException -> L45
        r2.stationarySceneWifiWhiteList = r4.optString(SettingsConstants.STATIONARY_SCENE_WIFI_WHITE_LIST, "");     // Catch: JSONException -> L45
        r2.stationarySceneTokenWhiteList = r4.optString(SettingsConstants.STATIONARY_SCENE_TOKEN_WHITE_LIST, "");     // Catch: JSONException -> L45
        r2.enableStationaryScenePolicy = r4.optBoolean(SettingsConstants.ENABLE_STATIONARY_SCENE_POLICY, false);     // Catch: JSONException -> L45
        r2.enableCollectContinuousGpsForTest = r4.optBoolean(SettingsConstants.ENABLE_COLLECT_CONTINUOUS_GPS_FOR_TEST, false);     // Catch: JSONException -> L45
        r2.enableContinueLocateUploadWifi = r4.optBoolean(SettingsConstants.ENABLE_CONTINUE_LOCATE_UPLOAD_WIFI, true);     // Catch: JSONException -> L45
        r2.enableContinueLocateUploadCell = r4.optBoolean(SettingsConstants.ENABLE_CONTINUE_LOCATE_UPLOAD_CELL, true);     // Catch: JSONException -> L45
        goto L43
    L34:
        if (r7.length() <= 0) goto L42;
        int r8 = 0;
    L37:
        if (r8 >= r7.length()) goto L42;
        String r9 = r7.optString(r8);     // Catch: JSONException -> L45
        if (TextUtils.isEmpty(r9) == true) goto L41;
        r2.monitorBusinessStopLocationClassMember.add(r9);     // Catch: JSONException -> L45
    L41:
        r8 = r8 + 1;     // Catch: JSONException -> L45
        goto L37
    L23:
        if (r6.length() <= 0) goto L31;
        int r10 = 0;
    L26:
        if (r10 >= r6.length()) goto L31;
        String r11 = r6.optString(r10);     // Catch: JSONException -> L45
        if (TextUtils.isEmpty(r11) == true) goto L30;
        r2.monitorBusinessStartLocationClassMember.add(r11);     // Catch: JSONException -> L45
    L30:
        r10 = r10 + 1;     // Catch: JSONException -> L45
        goto L26
    L12:
        if (r5.length() <= 0) goto L20;
        int r12 = 0;
    L15:
        if (r12 >= r5.length()) goto L20;
        String r13 = r5.optString(r12);     // Catch: JSONException -> L45
        if (TextUtils.isEmpty(r13) == true) goto L19;
        r2.monitorStrategyClassMember.add(r13);     // Catch: JSONException -> L45
    L19:
        r12 = r12 + 1;     // Catch: JSONException -> L45
    L43:
        r2.shakeConfig = r3.optJSONObject(LOCATION_SHAKE_SETTINGS_KEY);     // Catch: JSONException -> L45
        r2.beaconConfig = r3.optJSONObject(LOCATION_BEACON_SETTINGS_KEY);     // Catch: JSONException -> L45
    L46:
        return r2;
    L45:
        Logger.i("LocationSettingModel parseLocationSettingModel error");
        goto L46
    }
}
