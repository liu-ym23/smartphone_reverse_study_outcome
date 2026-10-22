package com.bytedance.bdlocation.monitor;

import android.aimedia.a;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.permission.PermissionManager;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation.store.BDLightLocationCache;
import com.bytedance.bdlocation.thread.AppExecutors;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import l7.e;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class LocationMonitor {
    private static AtomicBoolean isUploadLightLocationMonitor;

    static {
        isUploadLightLocationMonitor = new AtomicBoolean(false);
    }

    public LocationMonitor() {
    }

    private static void addCellMonitorData(JSONObject r8, boolean r10, JSONObject r11, JSONObject r12, JSONObject r13) {
        if (r8 == null) goto L9;
        boolean r14 = r8.optBoolean(LocationMonitorConst.IS_SUCCESS);
        boolean r15 = r8.optBoolean(LocationMonitorConst.IS_COLD_BOOT);
        boolean r16 = r8.optBoolean("is_downgrade");
        JsonUtil.safePutLong(r12, LocationMonitorConst.CELL_EXECUTE_CALLBACK_DURATION, r8.optLong(LocationMonitorConst.EXECUTE_CALLBACK_DURATION));
        JsonUtil.safePutBoolean(r11, LocationMonitorConst.IS_CELL_COLD_BOOT, r15);
        JsonUtil.safePutBoolean(r11, LocationMonitorConst.IS_CELL_DOWNGRADE, r16);
        JsonUtil.safePutBoolean(r11, LocationMonitorConst.IS_CELL_SUCCESS, r14);
        if (r14 == false) goto L6;
        long r17 = r8.optLong(LocationMonitorConst.CACHE_DATA_INTERVAL);
        long r18 = r8.optLong(LocationMonitorConst.COLD_BOOT_TO_START_REQUEST);
        long r19 = r8.optLong(LocationMonitorConst.COLD_BOOT_TO_END_REQUEST);
        long r20 = r8.optLong("total_duration");
        JsonUtil.safePutBoolean(r11, LocationMonitorConst.REQUEST_HAS_CELL_LIGHT_LOCATION_INFO, r10);
        JsonUtil.safePutLong(r12, LocationMonitorConst.CACHE_CELL_DATA_INTERVAL, r17);
        JsonUtil.safePutLong(r12, LocationMonitorConst.CELL_TOTAL_DURATION, r20);
        JsonUtil.safePutLong(r12, LocationMonitorConst.CELL_COLD_BOOT_TO_START_REQUEST, r18);
        JsonUtil.safePutLong(r12, LocationMonitorConst.CELL_COLD_BOOT_TO_END_REQUEST, r19);
    L7:
        JsonUtil.safePutString(r11, LocationMonitorConst.REQUEST_CELL_ERR_CODE, r8.optString(LocationMonitorConst.ERR_CODE, "-1"));
        return;
    L6:
        JsonUtil.safePutString(r13, LocationMonitorConst.REQUEST_CELL_ERR_MSG, r8.optString(LocationMonitorConst.ERR_MSG));
        goto L7
    }

    private static void addGetMonitorData(JSONObject r21, JSONObject r22, JSONObject r23, JSONObject r24) {
        if (r21 == null) goto L11;
        boolean r8 = r21.optBoolean(LocationMonitorConst.HAS_CELL_LOCATION_INFO);
        boolean r10 = r21.optBoolean(LocationMonitorConst.HAS_WIFI_LOCATION_INFO);
        long r11 = r21.optLong(LocationMonitorConst.COLD_BOOT_TO_GET_LIGHT_LOCATION_INFO_DURATION);
        boolean r12 = r21.optBoolean(LocationMonitorConst.HAS_LIGHT_LOCATION_INFO);
        boolean r13 = r21.optBoolean(LocationMonitorConst.IS_START_CELL_LIGHT_REQUEST);
        boolean r14 = r21.optBoolean(LocationMonitorConst.IS_END_CELL_LIGHT_REQUEST);
        boolean r15 = r21.optBoolean(LocationMonitorConst.IS_START_WIFI_LIGHT_REQUEST);
        boolean r16 = r21.optBoolean(LocationMonitorConst.IS_END_WIFI_LIGHT_REQUEST);
        boolean r17 = r21.optBoolean(LocationMonitorConst.IS_ACTIVITY_COMPONENT_TYPE);
        int r18 = r21.optInt(LocationMonitorConst.FEED_HAS_AVAILABLE_DATA);
        int r19 = r21.optInt(LocationMonitorConst.FEED_CALL_TYPE);
        JsonUtil.safePutBoolean(r22, LocationMonitorConst.GET_HAS_CELL_LOCATION_INFO, r8);
        JsonUtil.safePutBoolean(r22, LocationMonitorConst.GET_HAS_WIFI_LOCATION_INFO, r10);
        JsonUtil.safePutBoolean(r22, LocationMonitorConst.GET_HAS_LIGHT_LOCATION_INFO, r12);
        JsonUtil.safePutBoolean(r22, LocationMonitorConst.IS_START_CELL_LIGHT_REQUEST, r13);
        JsonUtil.safePutBoolean(r22, LocationMonitorConst.IS_END_CELL_LIGHT_REQUEST, r14);
        JsonUtil.safePutBoolean(r22, LocationMonitorConst.IS_START_WIFI_LIGHT_REQUEST, r15);
        JsonUtil.safePutBoolean(r22, LocationMonitorConst.IS_END_WIFI_LIGHT_REQUEST, r16);
        JsonUtil.safePutBoolean(r22, LocationMonitorConst.GET_IS_ACTIVITY_COMPONENT_TYPE, r17);
        JsonUtil.safePutInt(r22, LocationMonitorConst.FEED_HAS_AVAILABLE_DATA, r18);
        JsonUtil.safePutInt(r22, LocationMonitorConst.FEED_CALL_TYPE, r19);
        if (r11 == 0) goto L7;
        JsonUtil.safePutLong(r23, LocationMonitorConst.COLD_BOOT_TO_GET_LIGHT_LOCATION_INFO_DURATION, r11);
    L7:
        long r20 = r21.optLong(LocationMonitorConst.APP_BOOT_TIME);
        if (r20 <= 0) goto L12;
        JsonUtil.safePutLong(r24, LocationMonitorConst.APP_BOOT_TIME, r20);
        return;
    L12:
        return;
    }

    private static void addWifiMonitorData(JSONObject r8, boolean r10, JSONObject r11, JSONObject r12, JSONObject r13) {
        if (r8 == null) goto L9;
        boolean r14 = r8.optBoolean(LocationMonitorConst.IS_SUCCESS);
        boolean r15 = r8.optBoolean(LocationMonitorConst.IS_COLD_BOOT);
        boolean r16 = r8.optBoolean("is_downgrade");
        JsonUtil.safePutLong(r12, LocationMonitorConst.WIFI_EXECUTE_CALLBACK_DURATION, r8.optLong(LocationMonitorConst.EXECUTE_CALLBACK_DURATION));
        JsonUtil.safePutBoolean(r11, LocationMonitorConst.IS_WIFI_COLD_BOOT, r15);
        JsonUtil.safePutBoolean(r11, LocationMonitorConst.IS_WIFI_DOWNGRADE, r16);
        JsonUtil.safePutBoolean(r11, LocationMonitorConst.IS_WIFI_SUCCESS, r14);
        if (r14 == false) goto L6;
        long r17 = r8.optLong(LocationMonitorConst.CACHE_DATA_INTERVAL);
        long r18 = r8.optLong(LocationMonitorConst.COLD_BOOT_TO_START_REQUEST);
        long r19 = r8.optLong(LocationMonitorConst.COLD_BOOT_TO_END_REQUEST);
        long r20 = r8.optLong("total_duration");
        JsonUtil.safePutBoolean(r11, LocationMonitorConst.REQUEST_HAS_WIFI_LIGHT_LOCATION_INFO, r10);
        JsonUtil.safePutLong(r12, LocationMonitorConst.CACHE_WIFI_DATA_INTERVAL, r17);
        JsonUtil.safePutLong(r12, LocationMonitorConst.WIFI_TOTAL_DURATION, r20);
        JsonUtil.safePutLong(r12, LocationMonitorConst.WIFI_COLD_BOOT_TO_START_REQUEST, r18);
        JsonUtil.safePutLong(r12, LocationMonitorConst.WIFI_COLD_BOOT_TO_END_REQUEST, r19);
    L7:
        JsonUtil.safePutString(r11, LocationMonitorConst.REQUEST_WIFI_ERR_CODE, r8.optString(LocationMonitorConst.ERR_CODE, "-1"));
        return;
    L6:
        JsonUtil.safePutString(r13, LocationMonitorConst.REQUEST_WIFI_ERR_MSG, r8.optString(LocationMonitorConst.ERR_MSG));
        goto L7
    }

    public static void certNullCheck(String r8, Object r10) {
        if (r10 == null) goto L4;
        return;
    L4:
        Logger.i("bpea cert is null:" + r8);
        long r11 = System.currentTimeMillis();
        StackTraceElement[] r12 = Thread.currentThread().getStackTrace();
        StringBuilder r13 = new StringBuilder();
        if (r12 != null) goto L7;
    L12:
        doBpeaCertIsNull(r8, System.currentTimeMillis() - r11, r13.toString());
        return;
    L7:
        if (r12.length <= 0) goto L12;
        int r14 = 0;
    L10:
        if (r14 >= r12.length) goto L12;
        r13.append(r12[r14].toString() + "\n");
        r14 = r14 + 1;
        goto L10
    }

    public static void checkLocationProviderEnabledError(Exception r8, String r10) {
        JSONObject r11 = new JSONObject();
        JsonUtil.safePutString(r11, LocationMonitorConst.LOCATION_PROVIDER, r10);
        JSONObject r12 = new JSONObject();
        if (r8 == null) goto L5;
        JsonUtil.safePutString(r12, LocationMonitorConst.DETAIL_ERR_MSG, r8.getMessage());
    L5:
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_CHECK_LOCATION_PROVIDER_ENABLED_ERROR, r11, null, r12);
    }

    public static void dimLocationCheckMonitor(String r8, int r10, long r11, Throwable r12) {
        JSONObject r13 = new JSONObject();
        JsonUtil.safePutString(r13, LocationMonitorConst.DEVICE_BRAND, r8);
        JsonUtil.safePutInt(r13, LocationMonitorConst.CHECK_RESULT, r10);
        JSONObject r14 = new JSONObject();
        JsonUtil.safePutLong(r14, LocationMonitorConst.DIM_LOCATION_CHECK_DURATION, r11);
        JSONObject r15 = new JSONObject();
        if (r12 == null) goto L5;
        JsonUtil.safePutString(r15, LocationMonitorConst.DETAIL_ERR_MSG, r12.getMessage());
    L5:
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_BD_DIM_LOCATION_CHECK, r13, r14, r15);
    }

    public static void doBpeaCertCheck(String r8, boolean r10, String r11, long r12) {
        Logger.i("bpea check " + r10 + ",token is:" + r11);
        JSONObject r13 = new JSONObject();
        JsonUtil.safePutString(r13, LocationMonitorConst.METHOD_NAME, r8);
        JsonUtil.safePutBoolean(r13, LocationMonitorConst.IS_VALID, r10);
        JsonUtil.safePutString(r13, LocationMonitorConst.CERT_TOKEN, r11);
        JSONObject r14 = new JSONObject();
        JsonUtil.safePutLong(r14, LocationMonitorConst.BPEA_CHECK_DURATION, r12);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_BPEA_CERT_CHECK, r13, r14, null);
    }

    private static void doBpeaCertIsNull(String r8, long r10, String r11) {
        JSONObject r12 = new JSONObject();
        JsonUtil.safePutString(r12, LocationMonitorConst.METHOD_NAME, r8);
        JSONObject r13 = new JSONObject();
        JsonUtil.safePutLong(r13, LocationMonitorConst.STACKTRACE_DURATION, r10);
        JSONObject r14 = new JSONObject();
        JsonUtil.safePutString(r14, LocationMonitorConst.STACK_TRACE, r11);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_BPEA_CERT_NULL, r12, r13, r14);
    }

    public static void doBpeaCertParamsNull(String r8, String r10) {
        JSONObject r11 = new JSONObject();
        JsonUtil.safePutString(r11, LocationMonitorConst.BPEA_ACTION, r10);
        JSONObject r12 = new JSONObject();
        JsonUtil.safePutString(r12, LocationMonitorConst.CERT_TOKEN, r8);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_BPEA_CHECK_PARAMS_NULL, r11, null, r12);
    }

    public static void doColdBootLocateDuration(boolean r8, boolean r10, String r11, long r12, long r13) {
        Logger.i("LocationMonitor doColdBootLocateDuration isSuccess: " + r8 + ", isMainProcess: " + r10 + ", coldBootLocateTag: " + r11 + ", startColdBootLocateDuration: " + r12 + ", totalDuration: " + r13);
        JSONObject r14 = new JSONObject();
        JsonUtil.safePutBoolean(r14, LocationMonitorConst.IS_SUCCESS, r8);
        JsonUtil.safePutBoolean(r14, LocationMonitorConst.IS_MAIN_PROCESS, r10);
        JsonUtil.safePutString(r14, LocationMonitorConst.COLD_BOOT_LOCATE_TAG, r11);
        JSONObject r15 = new JSONObject();
        JsonUtil.safePutLong(r15, LocationMonitorConst.START_COLD_BOOT_LOCATE_DURATION, r12);
        JsonUtil.safePutLong(r15, "total_duration", r13);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_COLD_BOOT_LOCATE_DURATION, r14, r15);
    }

    public static void doConnectWifiInfo(boolean r8, String r10) {
        JSONObject r11 = new JSONObject();
        JsonUtil.safePutBoolean(r11, LocationMonitorConst.IS_WIFI_OPEN, LocationUtil.isWifiOpen());
        JsonUtil.safePutBoolean(r11, LocationMonitorConst.IS_WIFI_CACHE, r8);
        JsonUtil.safePutBoolean(r11, LocationMonitorConst.IS_WIFI_NULL, TextUtils.isEmpty(r10));
        JSONObject r12 = new JSONObject();
        JsonUtil.safePutString(r12, LocationMonitorConst.CONNECT_WIFI_INFO, r10);
        JsonUtil.safePutString(r12, LocationMonitorConst.STACK_TRACE, Log.getStackTraceString(new Throwable()));
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_CONNECT_WIFI_INFO, r11, null, r12);
    }

    public static void doContinueLocation(String r8, String r10, String r11, boolean r12, int r13, String r14, long r15, boolean r16, String r17, String r18) {
        JSONObject r19 = new JSONObject();
        JsonUtil.safePutBoolean(r19, LocationMonitorConst.IS_CN, r12);
        JsonUtil.safePutInt(r19, LocationMonitorConst.LOCATE_TYPE, r13);
        JsonUtil.safePutString(r19, "sdk_version", r14);
        JsonUtil.safePutString(r19, LocationMonitorConst.LOCATION_NAME, r8);
        JsonUtil.safePutString(r19, LocationMonitorConst.ERR_CODE, r10);
        JsonUtil.safePutString(r19, LocationMonitorConst.ERR_MSG, r11);
        JsonUtil.safePutBoolean(r19, LocationMonitorConst.IS_FIRST_LOCATION, r16);
        JsonUtil.safePutString(r19, "upload_source", r17);
        JsonUtil.safePutInt(r19, LocationMonitorConst.BACKGROUND_LOCATION_PERMISSION_STATUS, LocationUtil.getBackgroundLocationPermissionStatus());
        JsonUtil.safePutBoolean(r19, LocationMonitorConst.IS_BACKGROUND, LocationUtil.isBackground());
        JSONObject r20 = new JSONObject();
        JsonUtil.safePutLong(r20, "total_duration", r15);
        JSONObject r21 = new JSONObject();
        JsonUtil.safePutString(r21, LocationMonitorConst.DETAIL_ERR_MSG, r18);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_CONTINUE, r19, r20, r21);
    }

    public static void doDesiredLocationDuration(String r8, long r10, String r11, String r12, String r13, boolean r14, int r15, String r16, boolean r17) {
        Logger.i("locationmonitor location only duration is: " + r10 + "ms");
        JSONObject r18 = new JSONObject();
        JsonUtil.safePutString(r18, LocationMonitorConst.LOCATION_NAME, r8);
        JsonUtil.safePutString(r18, LocationMonitorConst.ERR_CODE, r11);
        JsonUtil.safePutString(r18, LocationMonitorConst.ERR_MSG, r12);
        JsonUtil.safePutBoolean(r18, LocationMonitorConst.IS_CN, r14);
        JsonUtil.safePutInt(r18, LocationMonitorConst.LOCATE_TYPE, r15);
        JsonUtil.safePutInt(r18, LocationMonitorConst.BACKGROUND_LOCATION_PERMISSION_STATUS, LocationUtil.getBackgroundLocationPermissionStatus());
        JsonUtil.safePutBoolean(r18, LocationMonitorConst.IS_BACKGROUND, r17);
        JSONObject r19 = new JSONObject();
        JsonUtil.safePutLong(r19, "total_duration", r10);
        JSONObject r20 = new JSONObject();
        JsonUtil.safePutString(r20, LocationMonitorConst.DETAIL_ERR_MSG, r13);
        JsonUtil.safePutString(r20, "sdk_version", r16);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_DESIRED_LOCATION_DURATION, r18, r19, r20);
    }

    public static void doDesiredLocationFail(long r8, BDLocationException r10, LocationOption r11) {
        JSONObject r12 = new JSONObject();
        if (r10 == null) goto L5;
        JsonUtil.safePutString(r12, LocationMonitorConst.LOCATION_NAME, r10.getSdkName());
        JsonUtil.safePutBoolean(r12, LocationMonitorConst.IS_TIMEOUT, r10.getCode().equals("0"));
        JsonUtil.safePutString(r12, LocationMonitorConst.ERR_CODE, r10.getCode());
        String r13 = r10.getMessage();
    L6:
        JsonUtil.safePutString(r12, LocationMonitorConst.ERR_MSG, r13);
        JsonUtil.safePutBoolean(r12, LocationMonitorConst.IS_SUCCESS, false);
        JsonUtil.safePutBoolean(r12, LocationMonitorConst.IS_CACHE, false);
        JsonUtil.safePutBoolean(r12, LocationMonitorConst.IS_CN, r11.isChineseRegion());
        JsonUtil.safePutBoolean(r12, LocationMonitorConst.IS_BACKGROUND, r11.isBackground());
        JsonUtil.safePutInt(r12, LocationMonitorConst.BACKGROUND_LOCATION_PERMISSION_STATUS, LocationUtil.getBackgroundLocationPermissionStatus());
        JsonUtil.safePutString(r12, LocationMonitorConst.BPEA_CERT_TOKEN, BDLocationExtrasService.getBPEAManager().getBpeaToken(r11.getBpeaCert()));     // Catch: Exception -> L9
    L10:
        JSONObject r14 = new JSONObject();
        JsonUtil.safePutLong(r14, "total_duration", r8);
        JSONObject r15 = new JSONObject();
        JsonUtil.safePutDouble(r15, LocationMonitorConst.ACCURACY, 0.0d);
        JsonUtil.safePutLong(r15, "cache_time", r11.getMaxCacheTime());
        JsonUtil.safePutLong(r15, "timeout", r11.getLocationTimeOutMs());
        JsonUtil.safePutString(r15, "upload_source", r11.getUploadSource());
        JsonUtil.safePutLong(r15, LocationMonitorConst.INTEL_UPLOAD_INTERVAL, r11.getUploadInterval());
        JsonUtil.safePutLong(r15, LocationMonitorConst.CACHE_TIMESTAMP, 0);
        JsonUtil.safePutLong(r15, "cache_duration", 0);
        JsonUtil.safePutLong(r15, "timestamp", System.currentTimeMillis());
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_DESIRED_LOCATION, r12, r14, r15);
        return;
    L9:
        Logger.i("doDesiredLocationSuccess monitor put bpea_cert_token error");
        goto L10
    L5:
        JsonUtil.safePutString(r12, LocationMonitorConst.LOCATION_NAME, "");
        JsonUtil.safePutBoolean(r12, LocationMonitorConst.IS_TIMEOUT, false);
        JsonUtil.safePutString(r12, LocationMonitorConst.ERR_CODE, "-2");
        r13 = "exception is null";
        goto L6
    }

    public static void doDesiredLocationSuccess(long r8, BDLocation r10, LocationOption r11) {
        JSONObject r12 = new JSONObject();
        JsonUtil.safePutString(r12, LocationMonitorConst.LOCATION_NAME, r10.getLocationSDKName());
        JsonUtil.safePutString(r12, LocationMonitorConst.ERR_CODE, BDLocationException.SUCCESS);
        JsonUtil.safePutString(r12, LocationMonitorConst.ERR_MSG, "success");
        JsonUtil.safePutBoolean(r12, LocationMonitorConst.IS_SUCCESS, true);
        JsonUtil.safePutBoolean(r12, LocationMonitorConst.IS_TIMEOUT, false);
        JsonUtil.safePutBoolean(r12, LocationMonitorConst.IS_CACHE, r10.isCache());
        JsonUtil.safePutBoolean(r12, LocationMonitorConst.IS_CN, r11.isChineseRegion());
        JsonUtil.safePutBoolean(r12, LocationMonitorConst.IS_BACKGROUND, r11.isBackground());
        JsonUtil.safePutInt(r12, LocationMonitorConst.LOCATE_TYPE, r10.getLocationType());
        JsonUtil.safePutString(r12, LocationMonitorConst.SERVER_LOCATE_METHOD, r10.getServerLocateMethod());
        JsonUtil.safePutBoolean(r12, LocationMonitorConst.HAS_SERVER_LATLNG, r10.hasServerLatLng());
        JsonUtil.safePutBoolean(r12, LocationMonitorConst.IS_SERVER_LOCATE_SUCCESS, r10.isServerLocateSuccess());
        JsonUtil.safePutInt(r12, LocationMonitorConst.BACKGROUND_LOCATION_PERMISSION_STATUS, LocationUtil.getBackgroundLocationPermissionStatus());
        JsonUtil.safePutString(r12, LocationMonitorConst.BPEA_CERT_TOKEN, BDLocationExtrasService.getBPEAManager().getBpeaToken(r11.getBpeaCert()));     // Catch: Exception -> L5
    L6:
        JSONObject r13 = new JSONObject();
        JsonUtil.safePutLong(r13, "total_duration", r8);
        JsonUtil.safePutDouble(r13, LocationMonitorConst.ACCURACY, r10.getAccuracy());
        JSONObject r14 = new JSONObject();
        JsonUtil.safePutLong(r14, "cache_time", r11.getMaxCacheTime());
        JsonUtil.safePutLong(r14, "timeout", r11.getLocationTimeOutMs());
        JsonUtil.safePutString(r14, "upload_source", r11.getUploadSource());
        JsonUtil.safePutLong(r14, LocationMonitorConst.INTEL_UPLOAD_INTERVAL, r11.getUploadInterval());
        if (r10.isCache() == false) goto L9;
        JsonUtil.safePutLong(r14, LocationMonitorConst.CACHE_TIMESTAMP, r10.getLocationMs());
        JsonUtil.safePutLong(r14, "cache_duration", System.currentTimeMillis() - r10.getLocationMs());
    L10:
        JsonUtil.safePutLong(r14, "timestamp", System.currentTimeMillis());
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_DESIRED_LOCATION, r12, r13, r14);
        return;
    L9:
        JsonUtil.safePutLong(r14, LocationMonitorConst.CACHE_TIMESTAMP, 0);
        JsonUtil.safePutLong(r14, "cache_duration", 0);
    L5:
        Logger.i("doDesiredLocationSuccess monitor put bpea_cert_token error");
        goto L6
    }

    public static void doFirstLocationDuration(long r8, boolean r10) {
        JSONObject r11 = new JSONObject();
        JsonUtil.safePutBoolean(r11, LocationMonitorConst.IS_CACHE, r10);
        JsonUtil.safePutBoolean(r11, LocationMonitorConst.IS_MAIN_PROCESS, e.b(BDLocationConfig.getContext()));
        JSONObject r12 = new JSONObject();
        JsonUtil.safePutLong(r12, "total_duration", r8);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_FIRST_LOCATION_DURATION, r11, r12);
    }

    public static void doFirstSubmitDuration(long r8) {
        JSONObject r10 = new JSONObject();
        JsonUtil.safePutBoolean(r10, LocationMonitorConst.IS_MAIN_PROCESS, e.b(BDLocationConfig.getContext()));
        JSONObject r11 = new JSONObject();
        JsonUtil.safePutLong(r11, "total_duration", r8);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_FIRST_SUBMIT_DURATION, r10, r11);
    }

    public static void doGeocode(long r8, int r10, String r11) {
        JSONObject r12 = new JSONObject();
        if (r10 != 0) goto L5;
        int r13 = 0;
    L6:
        JsonUtil.safePutInt(r12, "status", r13);
        JsonUtil.safePutInt(r12, LocationMonitorConst.ERR_CODE, r10);
        JsonUtil.safePutString(r12, LocationMonitorConst.ERR_MSG, r11);
        JsonUtil.safePutString(r12, LocationMonitorConst.NETWORK_SIGNATURE_MODE, BDLocationConfig.getNetworkSignatureMode());
        JSONObject r14 = new JSONObject();
        JsonUtil.safePutLong(r14, "total_duration", r8);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_GEOCODE, r12, r14);
        return;
    L5:
        r13 = 1;
        goto L6
    }

    public static void doGis(long r8, int r10, String r11, int r12) {
        JSONObject r13 = new JSONObject();
        if (r10 != 0) goto L5;
        int r14 = 0;
    L6:
        JsonUtil.safePutInt(r13, "status", r14);
        JsonUtil.safePutInt(r13, LocationMonitorConst.ERR_CODE, r10);
        JsonUtil.safePutInt(r13, LocationMonitorConst.API_VERSION, r12);
        JsonUtil.safePutString(r13, LocationMonitorConst.ERR_MSG, r11);
        JsonUtil.safePutString(r13, LocationMonitorConst.NETWORK_SIGNATURE_MODE, BDLocationConfig.getNetworkSignatureMode());
        JSONObject r15 = new JSONObject();
        JsonUtil.safePutLong(r15, "total_duration", r8);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_GIS, r13, r15);
        return;
    L5:
        r14 = 1;
        goto L6
    }

    public static void doLightLocation(long r8, long r10, long r11, long r12, boolean r13, String r14, String r15, boolean r16, boolean r17) {
        JSONObject r18 = new JSONObject();
        JsonUtil.safePutBoolean(r18, LocationMonitorConst.IS_SUCCESS, r13);
        JsonUtil.safePutBoolean(r18, LocationMonitorConst.IS_COLD_BOOT, r16);
        JsonUtil.safePutString(r18, LocationMonitorConst.ERR_CODE, r14);
        JsonUtil.safePutString(r18, LocationMonitorConst.ERR_MSG, r15);
        JsonUtil.safePutBoolean(r18, LocationMonitorConst.EXECUTE_SUBMIT_NOTIFICATION, r17);
        JSONObject r19 = new JSONObject();
        if (r13 == true) goto L5;
    L8:
        JSONObject r20 = new JSONObject();
        JsonUtil.safePutLong(r20, LocationMonitorConst.APP_BOOT_TIME, BDLocationConfig.getAppBootTime());
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_BD_LOCATION_LIGHT_LOCATION, r18, r19, r20);
        return;
    L5:
        if (BDLocationConfig.getAppBootTime() == 0) goto L7;
        JsonUtil.safePutLong(r19, LocationMonitorConst.APP_COLD_BOOT_TO_START_LOCATION_DURATION, r8);
    L7:
        JsonUtil.safePutLong(r19, "total_duration", r10);
        JsonUtil.safePutLong(r19, LocationMonitorConst.GET_CELL_DURATION, r11);
        JsonUtil.safePutLong(r19, LocationMonitorConst.SUBMIT_DURATION, r12);
        goto L8
    }

    public static void doLightLocationError(String r13, String r14, boolean r15, boolean r16) {
        doLightLocation(0, 0, 0, 0, false, r13, r14, r15, r16);
    }

    public static void doScanRefresh(long r8, int r10, String r11) {
        JSONObject r12 = new JSONObject();
        if (r10 != 0) goto L5;
        int r13 = 0;
    L6:
        JsonUtil.safePutInt(r12, "status", r13);
        JsonUtil.safePutInt(r12, LocationMonitorConst.ERR_CODE, r10);
        JsonUtil.safePutString(r12, LocationMonitorConst.ERR_MSG, r11);
        JsonUtil.safePutString(r12, LocationMonitorConst.NETWORK_SIGNATURE_MODE, BDLocationConfig.getNetworkSignatureMode());
        JSONObject r14 = new JSONObject();
        JsonUtil.safePutLong(r14, "total_duration", r8);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_SCAN_REFRESH, r12, r14);
        return;
    L5:
        r13 = 1;
        goto L6
    }

    public static void doScanUpload(long r8, int r10, String r11) {
        JSONObject r12 = new JSONObject();
        if (r10 != 0) goto L5;
        int r13 = 0;
    L6:
        JsonUtil.safePutInt(r12, "status", r13);
        JsonUtil.safePutInt(r12, LocationMonitorConst.ERR_CODE, r10);
        JsonUtil.safePutString(r12, LocationMonitorConst.ERR_MSG, r11);
        JsonUtil.safePutString(r12, LocationMonitorConst.NETWORK_SIGNATURE_MODE, BDLocationConfig.getNetworkSignatureMode());
        JSONObject r14 = new JSONObject();
        JsonUtil.safePutLong(r14, "total_duration", r8);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_SCAN_UPLOAD, r12, r14);
        return;
    L5:
        r13 = 1;
        goto L6
    }

    public static void doScanWiFiList(boolean r8, String r10) {
        JSONObject r11 = new JSONObject();
        JsonUtil.safePutBoolean(r11, LocationMonitorConst.IS_WIFI_OPEN, LocationUtil.isWifiOpen());
        JsonUtil.safePutBoolean(r11, LocationMonitorConst.IS_WIFI_CACHE, r8);
        JsonUtil.safePutBoolean(r11, LocationMonitorConst.IS_WIFI_NULL, TextUtils.isEmpty(r10));
        JSONObject r12 = new JSONObject();
        JsonUtil.safePutString(r12, LocationMonitorConst.SCAN_WIFI_LIST, r10);
        JsonUtil.safePutString(r12, LocationMonitorConst.STACK_TRACE, Log.getStackTraceString(new Throwable()));
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_SCAN_WIFI_LIST, r11, null, r12);
    }

    public static void doSubmit(long r8, int r10, String r11, boolean r12) {
        JSONObject r13 = new JSONObject();
        if (r10 != 0) goto L5;
        int r14 = 0;
    L6:
        JsonUtil.safePutInt(r13, "status", r14);
        JsonUtil.safePutInt(r13, LocationMonitorConst.ERR_CODE, r10);
        JsonUtil.safePutString(r13, LocationMonitorConst.ERR_MSG, r11);
        JsonUtil.safePutBoolean(r13, LocationMonitorConst.IS_BACKGROUND, r12);
        JsonUtil.safePutString(r13, LocationMonitorConst.NETWORK_SIGNATURE_MODE, BDLocationConfig.getNetworkSignatureMode());
        JSONObject r15 = new JSONObject();
        JsonUtil.safePutLong(r15, "total_duration", r8);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_SUBMIT_V2, r13, r15);
        return;
    L5:
        r14 = 1;
        goto L6
    }

    public static void doSubmitSource(long r8, int r10, String r11, boolean r12, String r13) {
        JSONObject r14 = new JSONObject();
        if (r10 != 0) goto L5;
        int r15 = 0;
    L6:
        JsonUtil.safePutInt(r14, "status", r15);
        JsonUtil.safePutString(r14, LocationMonitorConst.ERR_MSG, r11);
        JsonUtil.safePutBoolean(r14, LocationMonitorConst.IS_BACKGROUND, r12);
        JsonUtil.safePutString(r14, LocationMonitorConst.NETWORK_SIGNATURE_MODE, BDLocationConfig.getNetworkSignatureMode());
        JsonUtil.safePutString(r14, LocationMonitorConst.SUBMIT_SOURCE, r13);
        JSONObject r16 = new JSONObject();
        JsonUtil.safePutLong(r16, "total_duration", r8);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_SUBMIT_SOURCE, r14, r16);
        return;
    L5:
        r15 = 1;
        goto L6
    }

    public static void fetchStationDuration(long r8) {
        JSONObject r10 = new JSONObject();
        JsonUtil.safePutLong(r10, "total_duration", r8);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_FETCH_STATION_DURATION, null, r10);
    }

    public static void fetchTracerouteConfig(long r8, int r10, String r11) {
        JSONObject r12 = new JSONObject();
        if (r10 != 0) goto L5;
        int r13 = 0;
    L6:
        JsonUtil.safePutInt(r12, "status", r13);
        JsonUtil.safePutInt(r12, LocationMonitorConst.ERR_CODE, r10);
        JsonUtil.safePutString(r12, LocationMonitorConst.ERR_MSG, r11);
        JSONObject r14 = new JSONObject();
        JsonUtil.safePutLong(r14, "total_duration", r8);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_TRACEROUTE_FETCH_CONFIG, r12, r14);
        return;
    L5:
        r13 = 1;
        goto L6
    }

    public static void fetchWifiDuration(long r8, boolean r10) {
        JSONObject r11 = new JSONObject();
        JsonUtil.safePutBoolean(r11, LocationMonitorConst.IS_CACHE, r10);
        JSONObject r12 = new JSONObject();
        JsonUtil.safePutLong(r12, "total_duration", r8);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_FETCH_WIFI_DURATION, r11, r12);
    }

    private static void getLightLocationInfoMonitor(JSONObject r38) {
        if (r38 != null) goto L5;
        return;
    L5:
        boolean r8 = r38.optBoolean(LocationMonitorConst.IS_COLD_BOOT);
        boolean r10 = r38.optBoolean("is_downgrade");
        long r11 = r38.optLong(LocationMonitorConst.APP_BOOT_TIME);
        String r12 = r38.optString(LocationMonitorConst.LIGHT_LOCATION_TYPE);
        boolean r13 = r38.optBoolean(LocationMonitorConst.HAS_CELL_LOCATION_INFO);
        boolean r14 = r38.optBoolean(LocationMonitorConst.HAS_WIFI_LOCATION_INFO);
        long r15 = r38.optLong(LocationMonitorConst.COLD_BOOT_TO_GET_LIGHT_LOCATION_INFO_DURATION);
        boolean r16 = r38.optBoolean(LocationMonitorConst.HAS_LIGHT_LOCATION_INFO);
        boolean r17 = r38.optBoolean(LocationMonitorConst.IS_START_CELL_LIGHT_REQUEST);
        boolean r18 = r38.optBoolean(LocationMonitorConst.IS_END_CELL_LIGHT_REQUEST);
        boolean r19 = r38.optBoolean(LocationMonitorConst.IS_START_WIFI_LIGHT_REQUEST);
        boolean r20 = r38.optBoolean(LocationMonitorConst.IS_END_WIFI_LIGHT_REQUEST);
        int r21 = r38.optInt(LocationMonitorConst.HAS_LOCATION_PERMISSION);
        boolean r22 = r38.optBoolean(LocationMonitorConst.IS_ACTIVITY_COMPONENT_TYPE);
        int r23 = r38.optInt(LocationMonitorConst.FEED_HAS_AVAILABLE_DATA);
        int r24 = r38.optInt(LocationMonitorConst.FEED_CALL_TYPE);
        long r25 = r38.optLong(LocationMonitorConst.LIGHT_LOCATION_CACHE_INTERVAL);
        JSONObject r26 = new JSONObject();
        JsonUtil.safePutBoolean(r26, LocationMonitorConst.IS_COLD_BOOT, r8);
        JsonUtil.safePutBoolean(r26, "is_downgrade", r10);
        JsonUtil.safePutBoolean(r26, LocationMonitorConst.HAS_CELL_LOCATION_INFO, r13);
        JsonUtil.safePutBoolean(r26, LocationMonitorConst.HAS_WIFI_LOCATION_INFO, r14);
        JsonUtil.safePutString(r26, LocationMonitorConst.LIGHT_LOCATION_TYPE, r12);
        JsonUtil.safePutBoolean(r26, LocationMonitorConst.HAS_LIGHT_LOCATION_INFO, r16);
        JsonUtil.safePutBoolean(r26, LocationMonitorConst.IS_START_CELL_LIGHT_REQUEST, r17);
        JsonUtil.safePutBoolean(r26, LocationMonitorConst.IS_END_CELL_LIGHT_REQUEST, r18);
        JsonUtil.safePutBoolean(r26, LocationMonitorConst.IS_START_WIFI_LIGHT_REQUEST, r19);
        JsonUtil.safePutBoolean(r26, LocationMonitorConst.IS_END_WIFI_LIGHT_REQUEST, r20);
        JsonUtil.safePutInt(r26, LocationMonitorConst.HAS_LOCATION_PERMISSION, r21);
        JsonUtil.safePutBoolean(r26, LocationMonitorConst.IS_ACTIVITY_COMPONENT_TYPE, r22);
        JsonUtil.safePutInt(r26, LocationMonitorConst.FEED_HAS_AVAILABLE_DATA, r23);
        JsonUtil.safePutInt(r26, LocationMonitorConst.FEED_CALL_TYPE, r24);
        JsonUtil.safePutLong(r26, LocationMonitorConst.LIGHT_LOCATION_CACHE_INTERVAL, r25);
        JSONObject r27 = new JSONObject();
        if (r15 == 0) goto L8;
        JsonUtil.safePutLong(r27, LocationMonitorConst.COLD_BOOT_TO_GET_LIGHT_LOCATION_INFO_DURATION, r15);
    L8:
        JSONObject r28 = new JSONObject();
        if (r11 <= 0) goto L11;
        JsonUtil.safePutLong(r28, LocationMonitorConst.APP_BOOT_TIME, r11);
    L11:
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.BD_LOCATION_COLD_BOOT_GET_LIGHT_LOCATION_DURATION, r26, r27, r28);
    }

    public static void getLightLocationMonitor() {
        if (isUploadLightLocationMonitor.getAndSet(true) == false) goto L5;
        return;
    L5:
        JSONObject r8 = BDLightLocationCache.getAndClearRequestCellUpdateMonitorData();
        JSONObject r10 = BDLightLocationCache.getAndClearRequestWifiCacheUpdateMonitorData();
        JSONObject r11 = BDLightLocationCache.getAndClearLightLocationMonitorData();
        requestLightLocationInfoUpdateMonitor(r8, "cell");
        requestLightLocationInfoUpdateMonitor(r10, "wifi");
        getLightLocationInfoMonitor(r11);
        lightLocationInfoUpdateWholeMonitor(r8, r10, r11);
    }

    public static void gpsCheckRegion(boolean r8, boolean r10) {
        if (r8 == r10) goto L5;
        JSONObject r11 = new JSONObject();
        JsonUtil.safePutBoolean(r11, LocationMonitorConst.IS_GPS_CHINESE_CHANNEL, r8);
        JsonUtil.safePutBoolean(r11, LocationMonitorConst.IS_REGION_IN_CHINESECHANNEL, r10);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_GPS_CHECK_REGION, r11, null, null);
        return;
    }

    public static void gpsCollectMonitor(long r8, String r10, boolean r11, String r12, long r13, long r14, List<Double> r15, List<Long> r16) {
        JSONObject r17 = new JSONObject();
        JsonUtil.safePutString(r17, LocationMonitorConst.GPS_PROVIDER, r10);
        JsonUtil.safePutBoolean(r17, LocationMonitorConst.IS_CONTINUOUS_LOCATE, r11);
        if (r11 == false) goto L5;
        JsonUtil.safePutString(r17, "gps_continuous_conf", r12);
    L5:
        JSONObject r18 = new JSONObject();
        JsonUtil.safePutLong(r18, LocationMonitorConst.GPS_COLLECT_DURATION, r8);
        JsonUtil.safePutLong(r18, LocationMonitorConst.GPS_COLLECT_DURATION_FULL, r13);
        JsonUtil.safePutLong(r18, LocationMonitorConst.GPS_COLLECT_CNT, r14);
        if (r15 == null) goto L11;
        Iterator<Double> r19 = r15.iterator();
        long r110 = 0;
    L9:
        if (r19.hasNext() == false) goto L11;
        JsonUtil.safePutDouble(r18, a.d(LocationMonitorConst.GPS_ACCURACY_STEP_, r110), r19.next().doubleValue());
        r110 = r110 + 1;
    L11:
        if (r16 == null) goto L20;
        Iterator<Long> r20 = r16.iterator();
        long r111 = 0;
        long r112 = 0;
    L14:
        if (r20.hasNext() == false) goto L20;
        Long r113 = r20.next();
        JsonUtil.safePutLong(r18, a.d(LocationMonitorConst.GPS_COLLECT_DURATION_STEP_, r111), r113.longValue());
        if (r111 != 0) goto L18;
        r112 = r113.longValue();
    L19:
        r111 = r111 + 1;
        goto L14
    L18:
        JsonUtil.safePutLong(r18, a.d(LocationMonitorConst.GPS_COLLECT_DURATION_APPEND_, r111), r113.longValue() - r112);
    L20:
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_GPS_INFO_COLLECT, r17, r18, null);
    }

    public static void lbsLightLocationTraceMetricBegin(LBSLightLocationTraceLogger r8, String r10) {
        lbsLightLocationTraceMetricBegin(r8, r10, false);
    }

    public static void lbsLightLocationTraceMetricEnd(LBSLightLocationTraceLogger r8, String r10) {
        lbsLightLocationTraceMetricEnd(r8, r10, false);
    }

    public static void lbsLightLocationTracePutCategoryData(LBSLightLocationTraceLogger r8, String r10, Object r11) {
        if (r8 != null) goto L4;
        return;
    L4:
        r8.putCategoryData(r10, r11);
    }

    public static void lbsLightLocationTracePutLogExtra(LBSLightLocationTraceLogger r8, String r10, Object r11) {
        if (r8 != null) goto L4;
        return;
    L4:
        r8.putLogExtra(r10, r11);
    }

    public static void lbsLightLocationTracePutMetricData(LBSLightLocationTraceLogger r8, String r10, long r11) {
        if (r8 != null) goto L4;
        return;
    L4:
        r8.putReportMetricData(r10, r11);
    }

    private static void lightLocationInfoUpdateWholeMonitor(JSONObject r10, JSONObject r11, JSONObject r12) {
        JSONObject r8 = new JSONObject();
        JSONObject r13 = new JSONObject();
        JSONObject r14 = new JSONObject();
        boolean r15 = true;
        if (r10 == null) goto L5;
        boolean r16 = true;
    L6:
        JsonUtil.safePutBoolean(r8, LocationMonitorConst.HAS_REQUEST_CELL_MONITOR, r16);
        if (r11 == null) goto L9;
        boolean r17 = true;
    L10:
        JsonUtil.safePutBoolean(r8, LocationMonitorConst.HAS_REQUEST_WIFI_MONITOR, r17);
        if (r12 == null) goto L13;
        boolean r18 = true;
    L14:
        JsonUtil.safePutBoolean(r8, LocationMonitorConst.HAS_GET_LIGHT_MONITOR, r18);
        int r19 = PermissionManager.LOCATION_PERMISSION_UNKNOWN;
        if (r10 == null) goto L17;
        r19 = r10.optInt(LocationMonitorConst.HAS_LOCATION_PERMISSION);
    L17:
        if (r11 == null) goto L19;
        r19 = r11.optInt(LocationMonitorConst.HAS_LOCATION_PERMISSION);
    L19:
        JsonUtil.safePutInt(r8, LocationMonitorConst.HAS_LOCATION_PERMISSION, r19);
        if (r10 != null) goto L22;
    L24:
        boolean r20 = false;
    L25:
        if (r11 != null) goto L27;
    L29:
        boolean r21 = false;
    L30:
        if (r20 == true) goto L34;
        if (r21 == true) goto L34;
        r15 = false;
    L34:
        JsonUtil.safePutBoolean(r8, LocationMonitorConst.REQUEST_HAS_LIGHT_LOCATION_INFO, r15);
        JsonUtil.safePutLong(r8, LocationMonitorConst.LIGHT_LOCATION_CACHE_INTERVAL, BDLightLocationCache.getLightLocationCacheInterval());
        addCellMonitorData(r10, r20, r8, r13, r14);
        addWifiMonitorData(r11, r21, r8, r13, r14);
        addGetMonitorData(r12, r8, r13, r14);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.BD_LOCATION_COLD_BOOT_REQUEST_LIGHT_LOCATION_WHOLE_INFO, r8, r13, r14);
        return;
    L27:
        if (r11.optBoolean(LocationMonitorConst.HAS_LIGHT_LOCATION_INFO) == false) goto L29;
        r21 = true;
        goto L30
    L22:
        if (r10.optBoolean(LocationMonitorConst.HAS_LIGHT_LOCATION_INFO) == false) goto L24;
        r20 = true;
        goto L25
    L13:
        r18 = false;
        goto L14
    L9:
        r17 = false;
        goto L10
    L5:
        r16 = false;
        goto L6
    }

    public static void locationExtraDataTraceLogBegin(LocationExtraDataTraceLogger r8, String r10) {
        if (r8 != null) goto L4;
        return;
    L4:
        r8.begin(r10);
    }

    public static void locationExtraDataTraceLogEnd(LocationExtraDataTraceLogger r8, String r10) {
        if (r8 != null) goto L4;
        return;
    L4:
        r8.end(r10);
    }

    public static void locationExtraDataTraceLogErrorReport(LocationOption r8, BDLocationException r10) {
        if (r8 != null) goto L4;
        return;
    L4:
        LocationExtraDataTraceLogger r11 = r8.getLocationExtraDataTraceLogger();
        if (r11 != null) goto L7;
        return;
    L7:
        r11.locationExtraDataErrorReport(r10);
    }

    public static void locationExtraDataTraceLogSuccessReport(LocationOption r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        LocationExtraDataTraceLogger r10 = r8.getLocationExtraDataTraceLogger();
        if (r10 != null) goto L7;
        return;
    L7:
        r10.locationExtraDataSuccessReport();
    }

    public static void locationExtraDataTracePutCategoryData(LocationExtraDataTraceLogger r8, String r10, Object r11) {
        if (r8 != null) goto L4;
        return;
    L4:
        r8.putCategoryData(r10, r11);
    }

    public static void locationExtraDataTracePutExtraData(LocationExtraDataTraceLogger r8, String r10, Object r11) {
        if (r8 != null) goto L4;
        return;
    L4:
        r8.putLogExtra(r10, r11);
    }

    public static void locationExtraDataTracePutMetricData(LocationExtraDataTraceLogger r8, String r10, long r11) {
        if (r8 != null) goto L4;
        return;
    L4:
        r8.putReportMetricData(r10, r11);
    }

    public static void locationFrequencyMonitor(LocationOption r8, int r10, long r11, long r12, int r13, long r14) {
        if (r8 != null) goto L4;
        return;
    L4:
        JSONObject r15 = new JSONObject();
        JSONObject r16 = new JSONObject();
        JsonUtil.safePutString(r15, LocationMonitorConst.BPEA_CERT_TOKEN, r8.getUploadSource());
        JsonUtil.safePutInt(r15, LocationMonitorConst.LOCATION_REASON_CODE, r10);
        JsonUtil.safePutLong(r16, LocationMonitorConst.CACHE_AVAILABLE_TIME, r8.getMaxCacheTime());
        if (r12 == (-1)) goto L8;
        JsonUtil.safePutLong(r16, LocationMonitorConst.LOCATION_INTERVAL, r12);
    L8:
        if (r14 == (-1)) goto L10;
        JsonUtil.safePutLong(r16, LocationMonitorConst.LAST_LOCATION_CACHE_TIME, r14);
        JsonUtil.safePutInt(r15, LocationMonitorConst.LAST_LOCATION_CACHE_CONDITION, r13);
        JsonUtil.safePutLong(r16, LocationMonitorConst.REAL_CACHE_INTERVAL, r11 - r14);
    L10:
        JsonUtil.safePutBoolean(r15, LocationMonitorConst.IS_DOWN_GRADE_LOCATION, r8.isDownGradeLocation());
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_LOCATION_FREQUENCY, r15, r16, null);
    }

    public static void locationTraceLogBegin(LocationTraceLogger r8, String r10) {
        if (r8 != null) goto L4;
        return;
    L4:
        r8.begin(r10);
    }

    public static void locationTraceLogEnd(LocationTraceLogger r8, String r10) {
        if (r8 != null) goto L4;
        return;
    L4:
        r8.end(r10);
    }

    public static void locationTraceLogErrorReport(LocationOption r8, BDLocationException r10) {
        if (r8 != null) goto L4;
        return;
    L4:
        LocationTraceLogger r11 = r8.getLocationTraceLogger();
        if (r11 != null) goto L7;
        return;
    L7:
        r11.locationErrorReport(r10);
    }

    public static void locationTraceLogSuccessReport(BDLocation r8, LocationOption r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        LocationTraceLogger r11 = r10.getLocationTraceLogger();
        if (r11 != null) goto L7;
        return;
    L7:
        r11.locationSuccessReport(r8, r10);
    }

    public static void locationTracePutCategoryData(LocationTraceLogger r8, String r10, Object r11) {
        if (r8 != null) goto L4;
        return;
    L4:
        r8.putCategoryData(r10, r11);
    }

    public static void locationTracePutLogExtra(LocationTraceLogger r8, String r10, Object r11) {
        if (r8 != null) goto L4;
        return;
    L4:
        r8.putLogExtra(r10, r11);
    }

    public static void locationTracePutMetricData(LocationTraceLogger r8, String r10, long r11) {
        if (r8 != null) goto L4;
        return;
    L4:
        r8.putReportMetricData(r10, r11);
    }

    public static void monitorByteLocationStealGpsInfoAndSysLocation(int r8, int r10, int r11, long r12, long r13, long r14, long r15, boolean r16, boolean r17, boolean r18, boolean r19, String r20, long r21) {
        JSONObject r22 = new JSONObject();
        JsonUtil.safePutInt(r22, "before_wait_count", r8);
        JsonUtil.safePutInt(r22, "after_wait_count", r10);
        JsonUtil.safePutInt(r22, "downgrade_location", r11);
        JsonUtil.safePutLong(r22, "max_wait_time", r13);
        JsonUtil.safePutBoolean(r22, "steal_gps_success", r16);
        JsonUtil.safePutBoolean(r22, "steal_sys_loc_success", r17);
        JsonUtil.safePutBoolean(r22, "has_option", r18);
        JsonUtil.safePutBoolean(r22, LocationExtraDataTraceLogger.USE_CONTINUOUS_GPS, r19);
        if (r19 == false) goto L5;
        JsonUtil.safePutString(r22, "gps_continuous_conf", r20);
    L5:
        JSONObject r23 = new JSONObject();
        JsonUtil.safePutLong(r23, "real_wait_time", r15);
        JsonUtil.safePutLong(r23, "time_to_locate_start", r12);
        JsonUtil.safePutLong(r23, "real_max_wait_time", r14);
        JsonUtil.safePutLong(r23, LocationMonitorConst.GPS_COLLECT_CNT, r21);
        Logger.i("location-trace-core monitorByteLocationStealGpsInfoAndSysLocation, category: " + r22 + ", metric: " + r23);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_STEAL_GPS_INFO_AND_SYS_LOCATION, r22, r23);
    }

    public static void monitorLocationApiStatistics(int r8, String r10, String r11, boolean r12, boolean r13) {
        JSONObject r14 = new JSONObject();
        JSONObject r15 = new JSONObject();
        r14.put("method_id", r8);     // Catch: JSONException -> L6
        r14.put("class_name", r10);     // Catch: JSONException -> L6
        r14.put("member_name", r11);     // Catch: JSONException -> L6
        r14.put("scene", r12);     // Catch: JSONException -> L6
        r14.put("intercept", r13);     // Catch: JSONException -> L6
        r15.put("count", 1);     // Catch: JSONException -> L6
    L4:
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_LOCATION_API_ACTION, r14, r15);
    }

    public static void monitorPassiveInit(final boolean r12, final long r13, final boolean r15, final boolean r16, final boolean r17, final String r18, final Throwable r19) {
        final RuntimeException r8 = new RuntimeException();
        AppExecutors.getInstance().diskIO().execute(new AnonymousClass1(r12, r15, r16, r17, r18, r13, r8, r19));
    }

    public static void monitorReflectScanResultFailed(int r8, int r10, String r11) {
        JSONObject r12 = new JSONObject();
        JsonUtil.safePutInt(r12, LocationMonitorConst.ERR_CODE, r8);
        JsonUtil.safePutInt(r12, "type", r10);
        JSONObject r13 = new JSONObject();
        JsonUtil.safePutString(r13, LocationMonitorConst.ERR_MSG, r11);
        Logger.i("monitorReflectScanResultFailed, categories: " + r12 + ", logExtras: " + r13);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_REFLECT_SCAN_RESULT_FAILED, r12, null, r13);
    }

    public static void nonLocationSceneException(int r8, String r10, String r11, long r12, boolean r13) {
        Throwable r14 = new Throwable("" + r10 + "_" + r11 + " LocationException");
        JSONObject r15 = new JSONObject();
        JSONObject r16 = new JSONObject();
        r15.put("method_id", "" + r8);     // Catch: JSONException -> L5
        r15.put("class_name", r10);     // Catch: JSONException -> L5
        r15.put("member_name", r11);     // Catch: JSONException -> L5
        r15.put("biz_class_member", r13);     // Catch: JSONException -> L5
        r15.put(LocationMonitorConst.IS_BACKGROUND, LocationUtil.isBackground());     // Catch: JSONException -> L5
        r16.put("stop_locate_interval", "" + (System.currentTimeMillis() - r12));     // Catch: JSONException -> L5
        r16.put("count", 1);     // Catch: JSONException -> L5
        LocationMonitorUtil.monitorEventWithException(LocationMonitorConst.EVENT_LOCATION_API_ACTION_WITH_EXCEPTION, r15, r16, null, r14);     // Catch: JSONException -> L5
        return;
    }

    public static void overseasLocationFailedGetCache(boolean r8) {
        JSONObject r10 = new JSONObject();
        JsonUtil.safePutBoolean(r10, LocationMonitorConst.OVERSEAS_GET_LOCATION_FAILED_CACHE_IS_VALIDITY, r8);
        JsonUtil.safePutLong(r10, "cache_time", BDLocationConfig.getOverseasGetLocationFailedUseCacheValidity());
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_OVERSEAS_GET_LOCATION_FAILED_CACHE_VALIDITY, r10, null, null);
    }

    public static void registerNetworkCallbackError(String r8, Exception r10) {
        JSONObject r11 = new JSONObject();
        JsonUtil.safePutString(r11, LocationMonitorConst.REGISTER_NETWORK_ACTION, r8);
        JSONObject r12 = new JSONObject();
        if (r10 == null) goto L5;
        JsonUtil.safePutString(r12, LocationMonitorConst.DETAIL_ERR_MSG, r10.getMessage());
    L5:
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_CHECK_LOCATION_PROVIDER_ENABLED_ERROR, r11, null, r12);
    }

    public static void requestCellInfoUpdateMonitor(long r8, boolean r10, int r11, Throwable r12) {
        JSONObject r13 = new JSONObject();
        JsonUtil.safePutBoolean(r13, LocationMonitorConst.REQUEST_CELL_INFO_UPDATE_SUCCESS, r10);
        JsonUtil.safePutInt(r13, LocationMonitorConst.ERR_CODE, r11);
        JSONObject r14 = new JSONObject();
        JsonUtil.safePutLong(r14, LocationMonitorConst.REQUEST_CELL_INFO_UPDATE_DURATION, r8);
        JSONObject r15 = new JSONObject();
        if (r12 == null) goto L5;
        JsonUtil.safePutString(r15, LocationMonitorConst.DETAIL_ERR_MSG, r12.getMessage());
    L5:
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_REQUEST_CELL_INFO_UPDATE, r13, r14, r15);
    }

    private static void requestLightLocationInfoUpdateMonitor(JSONObject r14, String r15) {
        if (r14 != null) goto L4;
        return;
    L4:
        boolean r8 = r14.optBoolean(LocationMonitorConst.IS_SUCCESS);
        boolean r10 = r14.optBoolean(LocationMonitorConst.IS_COLD_BOOT);
        boolean r11 = r14.optBoolean("is_downgrade");
        if (r8 == false) goto L7;
        boolean r12 = r14.optBoolean(LocationMonitorConst.HAS_LIGHT_LOCATION_INFO);
        long r13 = r14.optLong("total_duration");
        long r16 = r14.optLong(LocationMonitorConst.CACHE_DATA_INTERVAL);
        requestLightLocationUpdateSuccess(r13, r12, r10, r14.optLong(LocationMonitorConst.COLD_BOOT_TO_START_REQUEST), r14.optLong(LocationMonitorConst.COLD_BOOT_TO_END_REQUEST), r11, r16, r15);
        return;
    L7:
        requestLightLocationUpdateError(r14.optString(LocationMonitorConst.ERR_MSG), r10, r11, r15);
    }

    private static void requestLightLocationUpdateError(String r8, boolean r10, boolean r11, String r12) {
        JSONObject r13 = new JSONObject();
        JsonUtil.safePutBoolean(r13, LocationMonitorConst.IS_COLD_BOOT, r10);
        JsonUtil.safePutBoolean(r13, "is_downgrade", r11);
        JsonUtil.safePutBoolean(r13, LocationMonitorConst.IS_SUCCESS, false);
        JsonUtil.safePutString(r13, LocationMonitorConst.LIGHT_LOCATION_TYPE, r12);
        JsonUtil.safePutLong(r13, LocationMonitorConst.LIGHT_LOCATION_CACHE_INTERVAL, BDLightLocationCache.getLightLocationCacheInterval());
        JSONObject r14 = new JSONObject();
        JsonUtil.safePutString(r14, LocationMonitorConst.ERR_MSG, r8);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.BD_LOCATION_COLD_BOOT_REQUEST_LIGHT_LOCATION_INFO, r13, null, r14);
    }

    private static void requestLightLocationUpdateSuccess(long r8, boolean r10, boolean r11, long r12, long r13, boolean r14, long r15, String r16) {
        JSONObject r17 = new JSONObject();
        JsonUtil.safePutBoolean(r17, LocationMonitorConst.IS_COLD_BOOT, r11);
        JsonUtil.safePutBoolean(r17, "is_downgrade", r14);
        JsonUtil.safePutBoolean(r17, LocationMonitorConst.IS_SUCCESS, true);
        JsonUtil.safePutBoolean(r17, LocationMonitorConst.HAS_LIGHT_LOCATION_INFO, r10);
        JsonUtil.safePutString(r17, LocationMonitorConst.LIGHT_LOCATION_TYPE, r16);
        JsonUtil.safePutLong(r17, LocationMonitorConst.LIGHT_LOCATION_CACHE_INTERVAL, BDLightLocationCache.getLightLocationCacheInterval());
        JSONObject r18 = new JSONObject();
        JsonUtil.safePutLong(r18, LocationMonitorConst.CACHE_DATA_INTERVAL, r15);
        JsonUtil.safePutLong(r18, "total_duration", r8);
        JsonUtil.safePutLong(r18, LocationMonitorConst.COLD_BOOT_TO_START_REQUEST, r12);
        JsonUtil.safePutLong(r18, LocationMonitorConst.COLD_BOOT_TO_END_REQUEST, r13);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.BD_LOCATION_COLD_BOOT_REQUEST_LIGHT_LOCATION_INFO, r17, r18, null);
    }

    public static void uploadAllStackTraces(String r8, String r10) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r10) == true) goto L10;
        JSONObject r11 = new JSONObject();
        JsonUtil.safePutString(r11, LocationMonitorConst.METHOD_NAME, r8);
        JSONObject r12 = new JSONObject();
        JsonUtil.safePutString(r12, LocationMonitorConst.STACK_TRACE, r10);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_BD_LOCATION_ALL_TRACES, r11, null, r12);
        return;
    }

    public static void uploadAuthStatus(String r8, int r10, int r11, int r12, int r13, boolean r14) {
        JSONObject r15 = new JSONObject();
        JsonUtil.safePutString(r15, LocationMonitorConst.TAG, r8);
        JsonUtil.safePutInt(r15, LocationMonitorConst.AUTH_STATUS, r10);
        JsonUtil.safePutInt(r15, LocationMonitorConst.LOCATION_MODE, r11);
        JsonUtil.safePutInt(r15, LocationMonitorConst.BLUETOOTH_AUTH_STATUS, r12);
        JsonUtil.safePutInt(r15, LocationMonitorConst.BLUETOOTH_SWITCH_STATUS, r13);
        JsonUtil.safePutInt(r15, "target_sdk_version", LocationUtil.getTargetSdkVersion());
        JsonUtil.safePutBoolean(r15, "is_skip", r14);
        Logger.i("LocationMonitor.uploadAuthStatus, categories: " + r15);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_AUTH_STATUS, r15, null);
    }

    public static void uploadBaseInfo(String r8, long r10, int r11, String r12, boolean r13) {
        JSONObject r14 = new JSONObject();
        JsonUtil.safePutString(r14, "upload_source", r8);
        if (r11 != 0) goto L5;
        int r15 = 0;
    L6:
        JsonUtil.safePutInt(r14, "status", r15);
        JsonUtil.safePutInt(r14, LocationMonitorConst.ERR_CODE, r11);
        JsonUtil.safePutString(r14, LocationMonitorConst.ERR_MSG, r12);
        JsonUtil.safePutBoolean(r14, LocationMonitorConst.IS_BACKGROUND, r13);
        JsonUtil.safePutString(r14, LocationMonitorConst.NETWORK_SIGNATURE_MODE, BDLocationConfig.getNetworkSignatureMode());
        JSONObject r16 = new JSONObject();
        JsonUtil.safePutLong(r16, "total_duration", r10);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_BASE_INFO, r14, r16);
        return;
    L5:
        r15 = 1;
        goto L6
    }

    public static void uploadInitInfo(long r8, long r10, long r11) {
        JSONObject r12 = new JSONObject();
        JsonUtil.safePutInt(r12, LocationMonitorConst.INVOKER_API_INIT_STATUS, BDLocationConfig.getInvokerApiInitStatus());
        JSONObject r13 = new JSONObject();
        JsonUtil.safePutLong(r13, "total_duration", r11);
        if (r8 <= 0) goto L5;
        JsonUtil.safePutLong(r13, LocationMonitorConst.APP_COLD_BOOT_TO_END_INIT_DURATION, r8);
    L5:
        JSONObject r14 = new JSONObject();
        JsonUtil.safePutLong(r14, LocationMonitorConst.APP_BOOT_TIME, r10);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_INIT, r12, r13, r14);
    }

    public static void uploadRestrictedInfo(long r8, int r10, String r11) {
        JSONObject r12 = new JSONObject();
        if (r10 != 0) goto L5;
        int r13 = 0;
    L6:
        JsonUtil.safePutInt(r12, "status", r13);
        JsonUtil.safePutInt(r12, LocationMonitorConst.ERR_CODE, r10);
        JsonUtil.safePutString(r12, LocationMonitorConst.ERR_MSG, r11);
        JSONObject r14 = new JSONObject();
        JsonUtil.safePutLong(r14, "total_duration", r8);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_RESTRICTED_INFO, r12, r14);
        return;
    L5:
        r13 = 1;
        goto L6
    }

    public static void uploadTraceroute(long r8, int r10, int r11, String r12) {
        JSONObject r13 = new JSONObject();
        JsonUtil.safePutInt(r13, "status", r10);
        JsonUtil.safePutInt(r13, LocationMonitorConst.ERR_CODE, r11);
        JsonUtil.safePutString(r13, LocationMonitorConst.ERR_MSG, r12);
        JSONObject r14 = new JSONObject();
        JsonUtil.safePutLong(r14, "total_duration", r8);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_TRACEROUTE_UPLOAD, r13, r14);
    }

    public static void withoutCert(String r8) {
        JSONObject r10 = new JSONObject();
        JsonUtil.safePutString(r10, LocationMonitorConst.METHOD_NAME, r8);
        JSONObject r11 = new JSONObject();
        JsonUtil.safePutString(r11, LocationMonitorConst.STACK_TRACE, Log.getStackTraceString(new Throwable()));
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_BPEA_WITHOUT_CERT_CHECK, r10, null, r11);
    }

    public static void doDesiredLocationDuration(String r10, long r11, String r13, String r14, String r15, boolean r16, int r17, boolean r18) {
        doDesiredLocationDuration(r10, r11, r13, r14, r15, r16, r17, "", r18);
    }

    public static void lbsLightLocationTraceMetricBegin(LBSLightLocationTraceLogger r8, String r10, boolean r11) {
        if (r11 == true) goto L7;
        if (r8 == null) goto L8;
        r8.begin(r10);
        return;
    L8:
        return;
    }

    public static void lbsLightLocationTraceMetricEnd(LBSLightLocationTraceLogger r8, String r10, boolean r11) {
        if (r11 == true) goto L7;
        if (r8 == null) goto L8;
        r8.end(r10);
        return;
    L8:
        return;
    }
}
