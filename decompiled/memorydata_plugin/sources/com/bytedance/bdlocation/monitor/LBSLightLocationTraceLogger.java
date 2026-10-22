package com.bytedance.bdlocation.monitor;

import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.network.response.LocInfoRspData;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class LBSLightLocationTraceLogger extends AbstractTraceLogger {
    public static final String BPEA = "bpea";
    public static final String CHECK_ABLE_LOCATION = "check_able_location";
    public static final String CHECK_CACHE_VALIDITY = "check_cache_validity";
    public static final String CHECK_CERT = "check_cert";
    public static final String ENABLE_LOCATION_OPT_BPEA_LIST = "enable_location_opt_bpea_list";
    public static final String ENCRYPT = "encrypt";
    public static final String ENCRYPT_SUBMIT_V2_BODY = "encrypt_submit_v2_body";
    public static final String GET_BPEA_MANAGER = "get_bpea_manager";
    public static final String GET_SCAN_RESULTS = "get_scan_results";
    public static final String GET_SCAN_RESULTS_INNER = "get_scan_results_inner";
    public static final String GET_SUITABLE_CACHE = "get_suitable_cache";
    public static final String GET_WIFI_MODULE = "get_wifi_module";
    public static final String HAS_VALID_LOCATION = "has_valid_location";
    public static final String INDEPENDENT_THREAD_GET_SCAN_RESULTS = "independent_thread_get_scan_results";
    public static final String IS_64_BIT = "is_64_bit";
    public static final String IS_FULL_LOCATE_MERGE = "is_full_locate_merge";
    public static final String IS_GET_WIFI_SUCCESS = "is_get_wifi_success";
    public static final String LOCATION_CACHE = "location_cache";
    public static final String LOCATION_MERGE = "location_merge";
    public static final String LOCATION_MERGE_SYNC = "location_merge_sync";
    public static final String NETWORK_REQUEST_LOC_INFO = "network_request_loc_info";
    public static final String NETWORK_REQUEST_PARAMS_PARSE = "network_request_params_parse";
    public static final String NETWORK_REQUEST_PARAMS_PREPARE = "network_request_params_prepare";
    public static final String NETWORK_TOTAL = "network_total";
    public static final String PREPARE = "prepare";
    public static final String PRE_SCAN_RESULTS = "pre_scan_results";
    public static final String SORT = "sort";
    public static final String SUBMIT_V2_LOG_ID = "submit_v2_log_id";
    public static final String SUBMIT_V2_REQUEST = "submit_v2_request";
    public static final String SUB_PREPARE = "sub_prepare";
    public static final String SUB_SCAN_LIST = "sub_scan_list";
    public static final String SWITCH_THREAD = "switch_thread";
    public static final String SWITCH_THREAD_SECOND_TIME = "switch_thread_second_time";
    public static final String THREAD_NAME = "thread_name";
    public static final String TOTAL = "total";
    public static final String TRIM_SCAN_RESULTS = "trim_scan_results";
    public static final String WIFI_TIMELINESS = "wifi_timeliness";
    public static final String WRAP_LOCATION_OPTION = "wrap_location_option";

    public LBSLightLocationTraceLogger() {
    }

    private int isCurrentProcess64Bit() {
        return Process.is64Bit() ? 1 : 0;
    L4:
        return -1;
    }

    public void reportLBSLightLocationFailed(String r4, String r5) {
        JSONObject r0 = new JSONObject();
        dumpCategoriesTo(r0);
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_SUCCESS, false);
        JsonUtil.safePutString(r0, "sdk_version", BuildConfig.BDLOCATION_VERSION);
        if (TextUtils.isEmpty(r4) == false) goto L6;
        r4 = "-1002";
    L6:
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_CODE, r4);
        if (Build.VERSION.SDK_INT < 23) goto L9;
        JsonUtil.safePutInt(r0, IS_64_BIT, isCurrentProcess64Bit());
    L9:
        JSONObject r6 = new JSONObject();
        dumpLogExtrasTo(r6);
        JsonUtil.safePutString(r6, ENABLE_LOCATION_OPT_BPEA_LIST, BDLocationConfig.getEnableLocationOptBpeaList());
        if (TextUtils.isEmpty(r5) == true) goto L12;
        JsonUtil.safePutString(r6, LocationMonitorConst.DETAIL_ERR_MSG, r5);
    L13:
        Logger.i("reportLBSLightLocationFailed categories: " + r0);
        Logger.i("reportLBSLightLocationFailed logExtras: " + r6);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_LBS_LIGHT_LOCATION_TRACE_LOG, r0, null, r6);
        return;
    L12:
        JsonUtil.safePutString(r6, LocationMonitorConst.DETAIL_ERR_MSG, "empty");
        goto L13
    }

    public void reportLBSLightLocationSuccess(LocInfoRspData r6) {
        if (r6 != null) goto L5;
    L13:
        boolean r7 = false;
    L14:
        JSONObject r1 = new JSONObject();
        dumpMetricsTo(r1);
        JSONObject r2 = new JSONObject();
        dumpCategoriesTo(r2);
        JsonUtil.safePutBoolean(r2, LocationMonitorConst.IS_SUCCESS, true);
        JsonUtil.safePutString(r2, "sdk_version", BuildConfig.BDLOCATION_VERSION);
        JsonUtil.safePutString(r2, LocationMonitorConst.ERR_CODE, BDLocationException.SUCCESS);
        JsonUtil.safePutBoolean(r2, HAS_VALID_LOCATION, r7);
        if (Build.VERSION.SDK_INT < 23) goto L17;
        JsonUtil.safePutInt(r2, IS_64_BIT, isCurrentProcess64Bit());
    L17:
        JSONObject r8 = new JSONObject();
        dumpLogExtrasTo(r8);
        JsonUtil.safePutString(r8, ENABLE_LOCATION_OPT_BPEA_LIST, BDLocationConfig.getEnableLocationOptBpeaList());
        Logger.i("reportLBSLightLocationSuccess categories: " + r2);
        Logger.i("reportLBSLightLocationSuccess metrics: " + r1);
        Logger.i("reportLBSLightLocationSuccess logExtras: " + r8);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_LBS_LIGHT_LOCATION_TRACE_LOG, r2, r1, r8);
        return;
    L5:
        if (r6.location == null) goto L13;
        if (r6.location.gps == null) goto L13;
        if (r6.location.gps.latitude == 0.0d) goto L11;
    L12:
        r7 = true;
        goto L14
    L11:
        if (r6.location.gps.longitude == 0.0d) goto L13;
        goto L12
    }
}
