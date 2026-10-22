package com.bytedance.bdlocation.monitor;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.permission.PermissionManager;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation.store.BDLightLocationCache;
import com.bytedance.bdlocation.thread.AppExecutors;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import com.bytedance.frameworks.baselib.network.http.util.g;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.logging.log4j.message.StructuredDataId;
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

    private static void addCellMonitorData(JSONObject r8, boolean r9, JSONObject r10, JSONObject r11, JSONObject r12) {
        if (r8 == null) goto L9;
        boolean r0 = r8.optBoolean(LocationMonitorConst.IS_SUCCESS);
        boolean r1 = r8.optBoolean(LocationMonitorConst.IS_COLD_BOOT);
        boolean r2 = r8.optBoolean("is_downgrade");
        JsonUtil.safePutLong(r11, LocationMonitorConst.CELL_EXECUTE_CALLBACK_DURATION, r8.optLong(LocationMonitorConst.EXECUTE_CALLBACK_DURATION));
        JsonUtil.safePutBoolean(r10, LocationMonitorConst.IS_CELL_COLD_BOOT, r1);
        JsonUtil.safePutBoolean(r10, LocationMonitorConst.IS_CELL_DOWNGRADE, r2);
        JsonUtil.safePutBoolean(r10, LocationMonitorConst.IS_CELL_SUCCESS, r0);
        if (r0 == false) goto L6;
        long r3 = r8.optLong(LocationMonitorConst.CACHE_DATA_INTERVAL);
        long r4 = r8.optLong(LocationMonitorConst.COLD_BOOT_TO_START_REQUEST);
        long r5 = r8.optLong(LocationMonitorConst.COLD_BOOT_TO_END_REQUEST);
        long r6 = r8.optLong("total_duration");
        JsonUtil.safePutBoolean(r10, LocationMonitorConst.REQUEST_HAS_CELL_LIGHT_LOCATION_INFO, r9);
        JsonUtil.safePutLong(r11, LocationMonitorConst.CACHE_CELL_DATA_INTERVAL, r3);
        JsonUtil.safePutLong(r11, LocationMonitorConst.CELL_TOTAL_DURATION, r6);
        JsonUtil.safePutLong(r11, LocationMonitorConst.CELL_COLD_BOOT_TO_START_REQUEST, r4);
        JsonUtil.safePutLong(r11, LocationMonitorConst.CELL_COLD_BOOT_TO_END_REQUEST, r5);
    L7:
        JsonUtil.safePutString(r10, LocationMonitorConst.REQUEST_CELL_ERR_CODE, r8.optString(LocationMonitorConst.ERR_CODE, StructuredDataId.RESERVED));
        return;
    L6:
        JsonUtil.safePutString(r12, LocationMonitorConst.REQUEST_CELL_ERR_MSG, r8.optString(LocationMonitorConst.ERR_MSG));
        goto L7
    }

    private static void addGetMonitorData(JSONObject r21, JSONObject r22, JSONObject r23, JSONObject r24) {
        if (r21 == null) goto L11;
        boolean r2 = r21.optBoolean(LocationMonitorConst.HAS_CELL_LOCATION_INFO);
        boolean r3 = r21.optBoolean(LocationMonitorConst.HAS_WIFI_LOCATION_INFO);
        long r5 = r21.optLong(LocationMonitorConst.COLD_BOOT_TO_GET_LIGHT_LOCATION_INFO_DURATION);
        boolean r7 = r21.optBoolean(LocationMonitorConst.HAS_LIGHT_LOCATION_INFO);
        boolean r9 = r21.optBoolean(LocationMonitorConst.IS_START_CELL_LIGHT_REQUEST);
        boolean r11 = r21.optBoolean(LocationMonitorConst.IS_END_CELL_LIGHT_REQUEST);
        boolean r13 = r21.optBoolean(LocationMonitorConst.IS_START_WIFI_LIGHT_REQUEST);
        boolean r15 = r21.optBoolean(LocationMonitorConst.IS_END_WIFI_LIGHT_REQUEST);
        boolean r4 = r21.optBoolean(LocationMonitorConst.IS_ACTIVITY_COMPONENT_TYPE);
        int r6 = r21.optInt(LocationMonitorConst.FEED_HAS_AVAILABLE_DATA);
        int r8 = r21.optInt(LocationMonitorConst.FEED_CALL_TYPE);
        JsonUtil.safePutBoolean(r22, LocationMonitorConst.GET_HAS_CELL_LOCATION_INFO, r2);
        JsonUtil.safePutBoolean(r22, LocationMonitorConst.GET_HAS_WIFI_LOCATION_INFO, r3);
        JsonUtil.safePutBoolean(r22, LocationMonitorConst.GET_HAS_LIGHT_LOCATION_INFO, r7);
        JsonUtil.safePutBoolean(r22, LocationMonitorConst.IS_START_CELL_LIGHT_REQUEST, r9);
        JsonUtil.safePutBoolean(r22, LocationMonitorConst.IS_END_CELL_LIGHT_REQUEST, r11);
        JsonUtil.safePutBoolean(r22, LocationMonitorConst.IS_START_WIFI_LIGHT_REQUEST, r13);
        JsonUtil.safePutBoolean(r22, LocationMonitorConst.IS_END_WIFI_LIGHT_REQUEST, r15);
        JsonUtil.safePutBoolean(r22, LocationMonitorConst.GET_IS_ACTIVITY_COMPONENT_TYPE, r4);
        JsonUtil.safePutInt(r22, LocationMonitorConst.FEED_HAS_AVAILABLE_DATA, r6);
        JsonUtil.safePutInt(r22, LocationMonitorConst.FEED_CALL_TYPE, r8);
        if (r5 == 0) goto L7;
        JsonUtil.safePutLong(r23, LocationMonitorConst.COLD_BOOT_TO_GET_LIGHT_LOCATION_INFO_DURATION, r5);
    L7:
        long r10 = r21.optLong(LocationMonitorConst.APP_BOOT_TIME);
        if (r10 <= 0) goto L12;
        JsonUtil.safePutLong(r24, LocationMonitorConst.APP_BOOT_TIME, r10);
        return;
    L12:
        return;
    }

    private static void addWifiMonitorData(JSONObject r8, boolean r9, JSONObject r10, JSONObject r11, JSONObject r12) {
        if (r8 == null) goto L9;
        boolean r0 = r8.optBoolean(LocationMonitorConst.IS_SUCCESS);
        boolean r1 = r8.optBoolean(LocationMonitorConst.IS_COLD_BOOT);
        boolean r2 = r8.optBoolean("is_downgrade");
        JsonUtil.safePutLong(r11, LocationMonitorConst.WIFI_EXECUTE_CALLBACK_DURATION, r8.optLong(LocationMonitorConst.EXECUTE_CALLBACK_DURATION));
        JsonUtil.safePutBoolean(r10, LocationMonitorConst.IS_WIFI_COLD_BOOT, r1);
        JsonUtil.safePutBoolean(r10, LocationMonitorConst.IS_WIFI_DOWNGRADE, r2);
        JsonUtil.safePutBoolean(r10, LocationMonitorConst.IS_WIFI_SUCCESS, r0);
        if (r0 == false) goto L6;
        long r3 = r8.optLong(LocationMonitorConst.CACHE_DATA_INTERVAL);
        long r4 = r8.optLong(LocationMonitorConst.COLD_BOOT_TO_START_REQUEST);
        long r5 = r8.optLong(LocationMonitorConst.COLD_BOOT_TO_END_REQUEST);
        long r6 = r8.optLong("total_duration");
        JsonUtil.safePutBoolean(r10, LocationMonitorConst.REQUEST_HAS_WIFI_LIGHT_LOCATION_INFO, r9);
        JsonUtil.safePutLong(r11, LocationMonitorConst.CACHE_WIFI_DATA_INTERVAL, r3);
        JsonUtil.safePutLong(r11, LocationMonitorConst.WIFI_TOTAL_DURATION, r6);
        JsonUtil.safePutLong(r11, LocationMonitorConst.WIFI_COLD_BOOT_TO_START_REQUEST, r4);
        JsonUtil.safePutLong(r11, LocationMonitorConst.WIFI_COLD_BOOT_TO_END_REQUEST, r5);
    L7:
        JsonUtil.safePutString(r10, LocationMonitorConst.REQUEST_WIFI_ERR_CODE, r8.optString(LocationMonitorConst.ERR_CODE, StructuredDataId.RESERVED));
        return;
    L6:
        JsonUtil.safePutString(r12, LocationMonitorConst.REQUEST_WIFI_ERR_MSG, r8.optString(LocationMonitorConst.ERR_MSG));
        goto L7
    }

    public static void certNullCheck(String r6, Object r7) {
        if (r7 == null) goto L4;
        return;
    L4:
        Logger.i("bpea cert is null:" + r6);
        long r0 = System.currentTimeMillis();
        StackTraceElement[] r8 = Thread.currentThread().getStackTrace();
        StringBuilder r2 = new StringBuilder();
        if (r8 != null) goto L7;
    L12:
        doBpeaCertIsNull(r6, System.currentTimeMillis() - r0, r2.toString());
        return;
    L7:
        if (r8.length <= 0) goto L12;
        int r3 = 0;
    L10:
        if (r3 >= r8.length) goto L12;
        r2.append(r8[r3].toString() + "\n");
        r3 = r3 + 1;
        goto L10
    }

    public static void checkLocationProviderEnabledError(Exception r2, String r3) {
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutString(r0, LocationMonitorConst.LOCATION_PROVIDER, r3);
        JSONObject r4 = new JSONObject();
        if (r2 == null) goto L5;
        JsonUtil.safePutString(r4, LocationMonitorConst.DETAIL_ERR_MSG, r2.getMessage());
    L5:
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_CHECK_LOCATION_PROVIDER_ENABLED_ERROR, r0, null, r4);
    }

    public static void dimLocationCheckMonitor(String r2, int r3, long r4, Throwable r6) {
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutString(r0, "device_brand", r2);
        JsonUtil.safePutInt(r0, LocationMonitorConst.CHECK_RESULT, r3);
        JSONObject r5 = new JSONObject();
        JsonUtil.safePutLong(r5, LocationMonitorConst.DIM_LOCATION_CHECK_DURATION, r4);
        JSONObject r7 = new JSONObject();
        if (r6 == null) goto L5;
        JsonUtil.safePutString(r7, LocationMonitorConst.DETAIL_ERR_MSG, r6.getMessage());
    L5:
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_BD_DIM_LOCATION_CHECK, r0, r5, r7);
    }

    public static void doBpeaCertCheck(String r2, boolean r3, String r4, long r5) {
        Logger.i("bpea check " + r3 + ",token is:" + r4);
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutString(r0, LocationMonitorConst.METHOD_NAME, r2);
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_VALID, r3);
        JsonUtil.safePutString(r0, LocationMonitorConst.CERT_TOKEN, r4);
        JSONObject r6 = new JSONObject();
        JsonUtil.safePutLong(r6, LocationMonitorConst.BPEA_CHECK_DURATION, r5);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_BPEA_CERT_CHECK, r0, r6, null);
    }

    private static void doBpeaCertIsNull(String r2, long r3, String r5) {
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutString(r0, LocationMonitorConst.METHOD_NAME, r2);
        JSONObject r4 = new JSONObject();
        JsonUtil.safePutLong(r4, LocationMonitorConst.STACKTRACE_DURATION, r3);
        JSONObject r6 = new JSONObject();
        JsonUtil.safePutString(r6, LocationMonitorConst.STACK_TRACE, r5);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_BPEA_CERT_NULL, r0, r4, r6);
    }

    public static void doBpeaCertParamsNull(String r2, String r3) {
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutString(r0, LocationMonitorConst.BPEA_ACTION, r3);
        JSONObject r4 = new JSONObject();
        JsonUtil.safePutString(r4, LocationMonitorConst.CERT_TOKEN, r2);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_BPEA_CHECK_PARAMS_NULL, r0, null, r4);
    }

    public static void doColdBootLocateDuration(boolean r2, boolean r3, String r4, long r5, long r7) {
        Logger.i("LocationMonitor doColdBootLocateDuration isSuccess: " + r2 + ", isMainProcess: " + r3 + ", coldBootLocateTag: " + r4 + ", startColdBootLocateDuration: " + r5 + ", totalDuration: " + r7);
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_SUCCESS, r2);
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_MAIN_PROCESS, r3);
        JsonUtil.safePutString(r0, LocationMonitorConst.COLD_BOOT_LOCATE_TAG, r4);
        JSONObject r6 = new JSONObject();
        JsonUtil.safePutLong(r6, LocationMonitorConst.START_COLD_BOOT_LOCATE_DURATION, r5);
        JsonUtil.safePutLong(r6, "total_duration", r7);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_COLD_BOOT_LOCATE_DURATION, r0, r6);
    }

    public static void doConnectWifiInfo(boolean r3, String r4) {
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_WIFI_OPEN, LocationUtil.isWifiOpen());
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_WIFI_CACHE, r3);
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_WIFI_NULL, TextUtils.isEmpty(r4));
        JSONObject r5 = new JSONObject();
        JsonUtil.safePutString(r5, LocationMonitorConst.CONNECT_WIFI_INFO, r4);
        JsonUtil.safePutString(r5, LocationMonitorConst.STACK_TRACE, Log.getStackTraceString(new Throwable()));
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_CONNECT_WIFI_INFO, r0, null, r5);
    }

    public static void doContinueLocation(String r2, String r3, String r4, boolean r5, int r6, String r7, long r8, boolean r10, String r11, String r12) {
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_CN, r5);
        JsonUtil.safePutInt(r0, LocationMonitorConst.LOCATE_TYPE, r6);
        JsonUtil.safePutString(r0, "sdk_version", r7);
        JsonUtil.safePutString(r0, LocationMonitorConst.LOCATION_NAME, r2);
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_CODE, r3);
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_MSG, r4);
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_FIRST_LOCATION, r10);
        JsonUtil.safePutString(r0, "upload_source", r11);
        JsonUtil.safePutInt(r0, LocationMonitorConst.BACKGROUND_LOCATION_PERMISSION_STATUS, LocationUtil.getBackgroundLocationPermissionStatus());
        JsonUtil.safePutBoolean(r0, "is_background", LocationUtil.isBackground());
        JSONObject r9 = new JSONObject();
        JsonUtil.safePutLong(r9, "total_duration", r8);
        JSONObject r13 = new JSONObject();
        JsonUtil.safePutString(r13, LocationMonitorConst.DETAIL_ERR_MSG, r12);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_CONTINUE, r0, r9, r13);
    }

    public static void doDesiredLocationDuration(String r2, long r3, String r5, String r6, String r7, boolean r8, int r9, String r10, boolean r11) {
        Logger.i("locationmonitor location only duration is: " + r3 + "ms");
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutString(r0, LocationMonitorConst.LOCATION_NAME, r2);
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_CODE, r5);
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_MSG, r6);
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_CN, r8);
        JsonUtil.safePutInt(r0, LocationMonitorConst.LOCATE_TYPE, r9);
        JsonUtil.safePutInt(r0, LocationMonitorConst.BACKGROUND_LOCATION_PERMISSION_STATUS, LocationUtil.getBackgroundLocationPermissionStatus());
        JsonUtil.safePutBoolean(r0, "is_background", r11);
        JSONObject r4 = new JSONObject();
        JsonUtil.safePutLong(r4, "total_duration", r3);
        JSONObject r12 = new JSONObject();
        JsonUtil.safePutString(r12, LocationMonitorConst.DETAIL_ERR_MSG, r7);
        JsonUtil.safePutString(r12, "sdk_version", r10);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_DESIRED_LOCATION_DURATION, r0, r4, r12);
    }

    public static void doDesiredLocationDuration(String r10, long r11, String r13, String r14, String r15, boolean r16, int r17, boolean r18) {
        doDesiredLocationDuration(r10, r11, r13, r14, r15, r16, r17, "", r18);
    }

    public static void doDesiredLocationFail(long r7, BDLocationException r9, LocationOption r10) {
        JSONObject r0 = new JSONObject();
        if (r9 == null) goto L5;
        JsonUtil.safePutString(r0, LocationMonitorConst.LOCATION_NAME, r9.getSdkName());
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_TIMEOUT, r9.getCode().equals("0"));
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_CODE, r9.getCode());
        String r11 = r9.getMessage();
    L6:
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_MSG, r11);
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_SUCCESS, false);
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_CACHE, false);
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_CN, r10.isChineseRegion());
        JsonUtil.safePutBoolean(r0, "is_background", r10.isBackground());
        JsonUtil.safePutInt(r0, LocationMonitorConst.BACKGROUND_LOCATION_PERMISSION_STATUS, LocationUtil.getBackgroundLocationPermissionStatus());
        JsonUtil.safePutString(r0, LocationMonitorConst.BPEA_CERT_TOKEN, BDLocationExtrasService.getBPEAManager().getBpeaToken(r10.getBpeaCert()));     // Catch: Exception -> L9
    L10:
        JSONObject r12 = new JSONObject();
        JsonUtil.safePutLong(r12, "total_duration", r7);
        JSONObject r8 = new JSONObject();
        JsonUtil.safePutDouble(r8, LocationMonitorConst.ACCURACY, 0.0d);
        JsonUtil.safePutLong(r8, "cache_time", r10.getMaxCacheTime());
        JsonUtil.safePutLong(r8, LocationMonitorConst.TIMEOUT, r10.getLocationTimeOutMs());
        JsonUtil.safePutString(r8, "upload_source", r10.getUploadSource());
        JsonUtil.safePutLong(r8, LocationMonitorConst.INTEL_UPLOAD_INTERVAL, r10.getUploadInterval());
        JsonUtil.safePutLong(r8, LocationMonitorConst.CACHE_TIMESTAMP, 0);
        JsonUtil.safePutLong(r8, "cache_duration", 0);
        JsonUtil.safePutLong(r8, "timestamp", System.currentTimeMillis());
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_DESIRED_LOCATION, r0, r12, r8);
        return;
    L9:
        Logger.i("doDesiredLocationSuccess monitor put bpea_cert_token error");
        goto L10
    L5:
        JsonUtil.safePutString(r0, LocationMonitorConst.LOCATION_NAME, "");
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_TIMEOUT, false);
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_CODE, "-2");
        r11 = "exception is null";
        goto L6
    }

    public static void doDesiredLocationSuccess(long r5, BDLocation r7, LocationOption r8) {
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutString(r0, LocationMonitorConst.LOCATION_NAME, r7.getLocationSDKName());
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_CODE, BDLocationException.SUCCESS);
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_MSG, "success");
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_SUCCESS, true);
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_TIMEOUT, false);
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_CACHE, r7.isCache());
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_CN, r8.isChineseRegion());
        JsonUtil.safePutBoolean(r0, "is_background", r8.isBackground());
        JsonUtil.safePutInt(r0, LocationMonitorConst.LOCATE_TYPE, r7.getLocationType());
        JsonUtil.safePutString(r0, LocationMonitorConst.SERVER_LOCATE_METHOD, r7.getServerLocateMethod());
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.HAS_SERVER_LATLNG, r7.hasServerLatLng());
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_SERVER_LOCATE_SUCCESS, r7.isServerLocateSuccess());
        JsonUtil.safePutInt(r0, LocationMonitorConst.BACKGROUND_LOCATION_PERMISSION_STATUS, LocationUtil.getBackgroundLocationPermissionStatus());
        JsonUtil.safePutString(r0, LocationMonitorConst.BPEA_CERT_TOKEN, BDLocationExtrasService.getBPEAManager().getBpeaToken(r8.getBpeaCert()));     // Catch: Exception -> L5
    L6:
        JSONObject r1 = new JSONObject();
        JsonUtil.safePutLong(r1, "total_duration", r5);
        JsonUtil.safePutDouble(r1, LocationMonitorConst.ACCURACY, r7.getAccuracy());
        JSONObject r6 = new JSONObject();
        JsonUtil.safePutLong(r6, "cache_time", r8.getMaxCacheTime());
        JsonUtil.safePutLong(r6, LocationMonitorConst.TIMEOUT, r8.getLocationTimeOutMs());
        JsonUtil.safePutString(r6, "upload_source", r8.getUploadSource());
        JsonUtil.safePutLong(r6, LocationMonitorConst.INTEL_UPLOAD_INTERVAL, r8.getUploadInterval());
        if (r7.isCache() == false) goto L9;
        JsonUtil.safePutLong(r6, LocationMonitorConst.CACHE_TIMESTAMP, r7.getLocationMs());
        JsonUtil.safePutLong(r6, "cache_duration", System.currentTimeMillis() - r7.getLocationMs());
    L10:
        JsonUtil.safePutLong(r6, "timestamp", System.currentTimeMillis());
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_DESIRED_LOCATION, r0, r1, r6);
        return;
    L9:
        JsonUtil.safePutLong(r6, LocationMonitorConst.CACHE_TIMESTAMP, 0);
        JsonUtil.safePutLong(r6, "cache_duration", 0);
    L5:
        Logger.i("doDesiredLocationSuccess monitor put bpea_cert_token error");
        goto L6
    }

    public static void doFirstLocationDuration(long r3, boolean r5) {
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_CACHE, r5);
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_MAIN_PROCESS, g.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")));
        JSONObject r6 = new JSONObject();
        JsonUtil.safePutLong(r6, "total_duration", r3);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_FIRST_LOCATION_DURATION, r0, r6);
    }

    public static void doFirstSubmitDuration(long r4) {
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_MAIN_PROCESS, g.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")));
        JSONObject r1 = new JSONObject();
        JsonUtil.safePutLong(r1, "total_duration", r4);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_FIRST_SUBMIT_DURATION, r0, r1);
    }

    public static void doGeocode(long r3, int r5, String r6) {
        JSONObject r0 = new JSONObject();
        if (r5 != 0) goto L5;
        int r1 = 0;
    L6:
        JsonUtil.safePutInt(r0, "status", r1);
        JsonUtil.safePutInt(r0, LocationMonitorConst.ERR_CODE, r5);
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_MSG, r6);
        JsonUtil.safePutString(r0, LocationMonitorConst.NETWORK_SIGNATURE_MODE, BDLocationConfig.getNetworkSignatureMode());
        JSONObject r7 = new JSONObject();
        JsonUtil.safePutLong(r7, "total_duration", r3);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_GEOCODE, r0, r7);
        return;
    L5:
        r1 = 1;
        goto L6
    }

    public static void doGis(long r3, int r5, String r6, int r7) {
        JSONObject r0 = new JSONObject();
        if (r5 != 0) goto L5;
        int r1 = 0;
    L6:
        JsonUtil.safePutInt(r0, "status", r1);
        JsonUtil.safePutInt(r0, LocationMonitorConst.ERR_CODE, r5);
        JsonUtil.safePutInt(r0, LocationMonitorConst.API_VERSION, r7);
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_MSG, r6);
        JsonUtil.safePutString(r0, LocationMonitorConst.NETWORK_SIGNATURE_MODE, BDLocationConfig.getNetworkSignatureMode());
        JSONObject r8 = new JSONObject();
        JsonUtil.safePutLong(r8, "total_duration", r3);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_GIS, r0, r8);
        return;
    L5:
        r1 = 1;
        goto L6
    }

    public static void doLightLocation(long r3, long r5, long r7, long r9, boolean r11, String r12, String r13, boolean r14, boolean r15) {
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_SUCCESS, r11);
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_COLD_BOOT, r14);
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_CODE, r12);
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_MSG, r13);
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.EXECUTE_SUBMIT_NOTIFICATION, r15);
        JSONObject r16 = new JSONObject();
        if (r11 == true) goto L5;
    L8:
        JSONObject r4 = new JSONObject();
        JsonUtil.safePutLong(r4, LocationMonitorConst.APP_BOOT_TIME, BDLocationConfig.getAppBootTime());
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_BD_LOCATION_LIGHT_LOCATION, r0, r16, r4);
        return;
    L5:
        if (BDLocationConfig.getAppBootTime() == 0) goto L7;
        JsonUtil.safePutLong(r16, LocationMonitorConst.APP_COLD_BOOT_TO_START_LOCATION_DURATION, r3);
    L7:
        JsonUtil.safePutLong(r16, "total_duration", r5);
        JsonUtil.safePutLong(r16, LocationMonitorConst.GET_CELL_DURATION, r7);
        JsonUtil.safePutLong(r16, LocationMonitorConst.SUBMIT_DURATION, r9);
        goto L8
    }

    public static void doLightLocationError(String r13, String r14, boolean r15, boolean r16) {
        doLightLocation(0, 0, 0, 0, false, r13, r14, r15, r16);
    }

    public static void doScanRefresh(long r3, int r5, String r6) {
        JSONObject r0 = new JSONObject();
        if (r5 != 0) goto L5;
        int r1 = 0;
    L6:
        JsonUtil.safePutInt(r0, "status", r1);
        JsonUtil.safePutInt(r0, LocationMonitorConst.ERR_CODE, r5);
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_MSG, r6);
        JsonUtil.safePutString(r0, LocationMonitorConst.NETWORK_SIGNATURE_MODE, BDLocationConfig.getNetworkSignatureMode());
        JSONObject r7 = new JSONObject();
        JsonUtil.safePutLong(r7, "total_duration", r3);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_SCAN_REFRESH, r0, r7);
        return;
    L5:
        r1 = 1;
        goto L6
    }

    public static void doScanUpload(long r3, int r5, String r6) {
        JSONObject r0 = new JSONObject();
        if (r5 != 0) goto L5;
        int r1 = 0;
    L6:
        JsonUtil.safePutInt(r0, "status", r1);
        JsonUtil.safePutInt(r0, LocationMonitorConst.ERR_CODE, r5);
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_MSG, r6);
        JsonUtil.safePutString(r0, LocationMonitorConst.NETWORK_SIGNATURE_MODE, BDLocationConfig.getNetworkSignatureMode());
        JSONObject r7 = new JSONObject();
        JsonUtil.safePutLong(r7, "total_duration", r3);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_SCAN_UPLOAD, r0, r7);
        return;
    L5:
        r1 = 1;
        goto L6
    }

    public static void doScanWiFiList(boolean r3, String r4) {
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_WIFI_OPEN, LocationUtil.isWifiOpen());
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_WIFI_CACHE, r3);
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_WIFI_NULL, TextUtils.isEmpty(r4));
        JSONObject r5 = new JSONObject();
        JsonUtil.safePutString(r5, LocationMonitorConst.SCAN_WIFI_LIST, r4);
        JsonUtil.safePutString(r5, LocationMonitorConst.STACK_TRACE, Log.getStackTraceString(new Throwable()));
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_SCAN_WIFI_LIST, r0, null, r5);
    }

    public static void doSubmit(long r3, int r5, String r6, boolean r7) {
        JSONObject r0 = new JSONObject();
        if (r5 != 0) goto L5;
        int r1 = 0;
    L6:
        JsonUtil.safePutInt(r0, "status", r1);
        JsonUtil.safePutInt(r0, LocationMonitorConst.ERR_CODE, r5);
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_MSG, r6);
        JsonUtil.safePutBoolean(r0, "is_background", r7);
        JsonUtil.safePutString(r0, LocationMonitorConst.NETWORK_SIGNATURE_MODE, BDLocationConfig.getNetworkSignatureMode());
        JSONObject r8 = new JSONObject();
        JsonUtil.safePutLong(r8, "total_duration", r3);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_SUBMIT_V2, r0, r8);
        return;
    L5:
        r1 = 1;
        goto L6
    }

    public static void doSubmitSource(long r2, int r4, String r5, boolean r6, String r7) {
        JSONObject r0 = new JSONObject();
        if (r4 != 0) goto L5;
        int r8 = 0;
    L6:
        JsonUtil.safePutInt(r0, "status", r8);
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_MSG, r5);
        JsonUtil.safePutBoolean(r0, "is_background", r6);
        JsonUtil.safePutString(r0, LocationMonitorConst.NETWORK_SIGNATURE_MODE, BDLocationConfig.getNetworkSignatureMode());
        JsonUtil.safePutString(r0, LocationMonitorConst.SUBMIT_SOURCE, r7);
        JSONObject r9 = new JSONObject();
        JsonUtil.safePutLong(r9, "total_duration", r2);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_SUBMIT_SOURCE, r0, r9);
        return;
    L5:
        r8 = 1;
        goto L6
    }

    public static void fetchStationDuration(long r2) {
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutLong(r0, "total_duration", r2);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_FETCH_STATION_DURATION, null, r0);
    }

    public static void fetchTracerouteConfig(long r3, int r5, String r6) {
        JSONObject r0 = new JSONObject();
        if (r5 != 0) goto L5;
        int r1 = 0;
    L6:
        JsonUtil.safePutInt(r0, "status", r1);
        JsonUtil.safePutInt(r0, LocationMonitorConst.ERR_CODE, r5);
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_MSG, r6);
        JSONObject r7 = new JSONObject();
        JsonUtil.safePutLong(r7, "total_duration", r3);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_TRACEROUTE_FETCH_CONFIG, r0, r7);
        return;
    L5:
        r1 = 1;
        goto L6
    }

    public static void fetchWifiDuration(long r2, boolean r4) {
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_CACHE, r4);
        JSONObject r5 = new JSONObject();
        JsonUtil.safePutLong(r5, "total_duration", r2);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_FETCH_WIFI_DURATION, r0, r5);
    }

    private static void getLightLocationInfoMonitor(JSONObject r38) {
        if (r38 != null) goto L5;
        return;
    L5:
        boolean r2 = r38.optBoolean(LocationMonitorConst.IS_COLD_BOOT);
        boolean r4 = r38.optBoolean("is_downgrade");
        long r6 = r38.optLong(LocationMonitorConst.APP_BOOT_TIME);
        String r9 = r38.optString(LocationMonitorConst.LIGHT_LOCATION_TYPE);
        boolean r11 = r38.optBoolean(LocationMonitorConst.HAS_CELL_LOCATION_INFO);
        boolean r13 = r38.optBoolean(LocationMonitorConst.HAS_WIFI_LOCATION_INFO);
        long r5 = r38.optLong(LocationMonitorConst.COLD_BOOT_TO_GET_LIGHT_LOCATION_INFO_DURATION);
        boolean r15 = r38.optBoolean(LocationMonitorConst.HAS_LIGHT_LOCATION_INFO);
        boolean r7 = r38.optBoolean(LocationMonitorConst.IS_START_CELL_LIGHT_REQUEST);
        boolean r8 = r38.optBoolean(LocationMonitorConst.IS_END_CELL_LIGHT_REQUEST);
        boolean r10 = r38.optBoolean(LocationMonitorConst.IS_START_WIFI_LIGHT_REQUEST);
        boolean r12 = r38.optBoolean(LocationMonitorConst.IS_END_WIFI_LIGHT_REQUEST);
        int r14 = r38.optInt(LocationMonitorConst.HAS_LOCATION_PERMISSION);
        boolean r16 = r38.optBoolean(LocationMonitorConst.IS_ACTIVITY_COMPONENT_TYPE);
        int r17 = r38.optInt(LocationMonitorConst.FEED_HAS_AVAILABLE_DATA);
        int r18 = r38.optInt(LocationMonitorConst.FEED_CALL_TYPE);
        long r19 = r38.optLong(LocationMonitorConst.LIGHT_LOCATION_CACHE_INTERVAL);
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_COLD_BOOT, r2);
        JsonUtil.safePutBoolean(r0, "is_downgrade", r4);
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.HAS_CELL_LOCATION_INFO, r11);
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.HAS_WIFI_LOCATION_INFO, r13);
        JsonUtil.safePutString(r0, LocationMonitorConst.LIGHT_LOCATION_TYPE, r9);
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.HAS_LIGHT_LOCATION_INFO, r15);
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_START_CELL_LIGHT_REQUEST, r7);
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_END_CELL_LIGHT_REQUEST, r8);
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_START_WIFI_LIGHT_REQUEST, r10);
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_END_WIFI_LIGHT_REQUEST, r12);
        JsonUtil.safePutInt(r0, LocationMonitorConst.HAS_LOCATION_PERMISSION, r14);
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_ACTIVITY_COMPONENT_TYPE, r16);
        JsonUtil.safePutInt(r0, LocationMonitorConst.FEED_HAS_AVAILABLE_DATA, r17);
        JsonUtil.safePutInt(r0, LocationMonitorConst.FEED_CALL_TYPE, r18);
        JsonUtil.safePutLong(r0, LocationMonitorConst.LIGHT_LOCATION_CACHE_INTERVAL, r19);
        JSONObject r1 = new JSONObject();
        if (r5 == 0) goto L8;
        JsonUtil.safePutLong(r1, LocationMonitorConst.COLD_BOOT_TO_GET_LIGHT_LOCATION_INFO_DURATION, r5);
    L8:
        JSONObject r20 = new JSONObject();
        if (r6 <= 0) goto L11;
        JsonUtil.safePutLong(r20, LocationMonitorConst.APP_BOOT_TIME, r6);
    L11:
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.BD_LOCATION_COLD_BOOT_GET_LIGHT_LOCATION_DURATION, r0, r1, r20);
    }

    public static void getLightLocationMonitor() {
        if (isUploadLightLocationMonitor.getAndSet(true) == false) goto L5;
        return;
    L5:
        JSONObject r0 = BDLightLocationCache.getAndClearRequestCellUpdateMonitorData();
        JSONObject r1 = BDLightLocationCache.getAndClearRequestWifiCacheUpdateMonitorData();
        JSONObject r2 = BDLightLocationCache.getAndClearLightLocationMonitorData();
        requestLightLocationInfoUpdateMonitor(r0, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        requestLightLocationInfoUpdateMonitor(r1, LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI);
        getLightLocationInfoMonitor(r2);
        lightLocationInfoUpdateWholeMonitor(r0, r1, r2);
    }

    public static void gpsCheckRegion(boolean r2, boolean r3) {
        if (r2 == r3) goto L5;
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_GPS_CHINESE_CHANNEL, r2);
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_REGION_IN_CHINESECHANNEL, r3);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_GPS_CHECK_REGION, r0, null, null);
        return;
    }

    public static void gpsCollectMonitor(long r5, String r7, boolean r8, String r9, long r10, long r12, List<Double> r14, List<Long> r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        List r17 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutString(r0, LocationMonitorConst.GPS_PROVIDER, r7);
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_CONTINUOUS_LOCATE, r8);
        if (r8 == false) goto L5;
        JsonUtil.safePutString(r0, "gps_continuous_conf", r9);
    L5:
        JSONObject r11 = new JSONObject();
        JsonUtil.safePutLong(r11, LocationMonitorConst.GPS_COLLECT_DURATION, r5);
        JsonUtil.safePutLong(r11, LocationMonitorConst.GPS_COLLECT_DURATION_FULL, r10);
        JsonUtil.safePutLong(r11, LocationMonitorConst.GPS_COLLECT_CNT, r12);
        if (r16 == null) goto L11;
        Iterator r13 = r16.iterator();
        long r18 = 0;
    L9:
        if (r13.hasNext() == false) goto L11;
        JsonUtil.safePutDouble(r11, LocationMonitorConst.GPS_ACCURACY_STEP_ + r18, ((Double) ZeusTransformUtils.preCheckCast(r13.next(), Double.class, "com.obric.memorydata.plugin")).doubleValue());
        r18 = r18 + 1;
    L11:
        if (r17 == null) goto L20;
        Iterator r19 = r17.iterator();
        long r110 = 0;
        long r111 = 0;
    L14:
        if (r19.hasNext() == false) goto L20;
        Long r112 = (Long) ZeusTransformUtils.preCheckCast(r19.next(), Long.class, "com.obric.memorydata.plugin");
        JsonUtil.safePutLong(r11, LocationMonitorConst.GPS_COLLECT_DURATION_STEP_ + r110, r112.longValue());
        if (r110 != 0) goto L18;
        r111 = r112.longValue();
    L19:
        r110 = r110 + 1;
        goto L14
    L18:
        JsonUtil.safePutLong(r11, LocationMonitorConst.GPS_COLLECT_DURATION_APPEND_ + r110, r112.longValue() - r111);
    L20:
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_GPS_INFO_COLLECT, r0, r11, null);
    }

    public static void lbsLightLocationTraceMetricBegin(LBSLightLocationTraceLogger r1, String r2) {
        lbsLightLocationTraceMetricBegin(r1, r2, false);
    }

    public static void lbsLightLocationTraceMetricBegin(LBSLightLocationTraceLogger r0, String r1, boolean r2) {
        if (r2 == true) goto L7;
        if (r0 == null) goto L8;
        r0.begin(r1);
        return;
    L8:
        return;
    }

    public static void lbsLightLocationTraceMetricEnd(LBSLightLocationTraceLogger r1, String r2) {
        lbsLightLocationTraceMetricEnd(r1, r2, false);
    }

    public static void lbsLightLocationTraceMetricEnd(LBSLightLocationTraceLogger r0, String r1, boolean r2) {
        if (r2 == true) goto L7;
        if (r0 == null) goto L8;
        r0.end(r1);
        return;
    L8:
        return;
    }

    public static void lbsLightLocationTracePutCategoryData(LBSLightLocationTraceLogger r0, String r1, Object r2) {
        if (r0 != null) goto L4;
        return;
    L4:
        r0.putCategoryData(r1, r2);
    }

    public static void lbsLightLocationTracePutLogExtra(LBSLightLocationTraceLogger r0, String r1, Object r2) {
        if (r0 != null) goto L4;
        return;
    L4:
        r0.putLogExtra(r1, r2);
    }

    public static void lbsLightLocationTracePutMetricData(LBSLightLocationTraceLogger r0, String r1, long r2) {
        if (r0 != null) goto L4;
        return;
    L4:
        r0.putReportMetricData(r1, r2);
    }

    private static void lightLocationInfoUpdateWholeMonitor(JSONObject r8, JSONObject r9, JSONObject r10) {
        JSONObject r0 = new JSONObject();
        JSONObject r1 = new JSONObject();
        JSONObject r2 = new JSONObject();
        boolean r3 = true;
        if (r8 == null) goto L5;
        boolean r5 = true;
    L6:
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.HAS_REQUEST_CELL_MONITOR, r5);
        if (r9 == null) goto L9;
        boolean r6 = true;
    L10:
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.HAS_REQUEST_WIFI_MONITOR, r6);
        if (r10 == null) goto L13;
        boolean r7 = true;
    L14:
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.HAS_GET_LIGHT_MONITOR, r7);
        int r11 = PermissionManager.LOCATION_PERMISSION_UNKNOWN;
        if (r8 == null) goto L17;
        r11 = r8.optInt(LocationMonitorConst.HAS_LOCATION_PERMISSION);
    L17:
        if (r9 == null) goto L19;
        r11 = r9.optInt(LocationMonitorConst.HAS_LOCATION_PERMISSION);
    L19:
        JsonUtil.safePutInt(r0, LocationMonitorConst.HAS_LOCATION_PERMISSION, r11);
        if (r8 != null) goto L22;
    L24:
        boolean r12 = false;
    L25:
        if (r9 != null) goto L27;
    L29:
        boolean r13 = false;
    L30:
        if (r12 == true) goto L34;
        if (r13 == true) goto L34;
        r3 = false;
    L34:
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.REQUEST_HAS_LIGHT_LOCATION_INFO, r3);
        JsonUtil.safePutLong(r0, LocationMonitorConst.LIGHT_LOCATION_CACHE_INTERVAL, BDLightLocationCache.getLightLocationCacheInterval());
        addCellMonitorData(r8, r12, r0, r1, r2);
        addWifiMonitorData(r9, r13, r0, r1, r2);
        addGetMonitorData(r10, r0, r1, r2);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.BD_LOCATION_COLD_BOOT_REQUEST_LIGHT_LOCATION_WHOLE_INFO, r0, r1, r2);
        return;
    L27:
        if (r9.optBoolean(LocationMonitorConst.HAS_LIGHT_LOCATION_INFO) == false) goto L29;
        r13 = true;
        goto L30
    L22:
        if (r8.optBoolean(LocationMonitorConst.HAS_LIGHT_LOCATION_INFO) == false) goto L24;
        r12 = true;
        goto L25
    L13:
        r7 = false;
        goto L14
    L9:
        r6 = false;
        goto L10
    L5:
        r5 = false;
        goto L6
    }

    public static void locationExtraDataTraceLogBegin(LocationExtraDataTraceLogger r0, String r1) {
        if (r0 != null) goto L4;
        return;
    L4:
        r0.begin(r1);
    }

    public static void locationExtraDataTraceLogEnd(LocationExtraDataTraceLogger r0, String r1) {
        if (r0 != null) goto L4;
        return;
    L4:
        r0.end(r1);
    }

    public static void locationExtraDataTraceLogErrorReport(LocationOption r0, BDLocationException r1) {
        if (r0 != null) goto L4;
        return;
    L4:
        LocationExtraDataTraceLogger r2 = r0.getLocationExtraDataTraceLogger();
        if (r2 != null) goto L7;
        return;
    L7:
        r2.locationExtraDataErrorReport(r1);
    }

    public static void locationExtraDataTraceLogSuccessReport(LocationOption r0) {
        if (r0 != null) goto L4;
        return;
    L4:
        LocationExtraDataTraceLogger r1 = r0.getLocationExtraDataTraceLogger();
        if (r1 != null) goto L7;
        return;
    L7:
        r1.locationExtraDataSuccessReport();
    }

    public static void locationExtraDataTracePutCategoryData(LocationExtraDataTraceLogger r0, String r1, Object r2) {
        if (r0 != null) goto L4;
        return;
    L4:
        r0.putCategoryData(r1, r2);
    }

    public static void locationExtraDataTracePutExtraData(LocationExtraDataTraceLogger r0, String r1, Object r2) {
        if (r0 != null) goto L4;
        return;
    L4:
        r0.putLogExtra(r1, r2);
    }

    public static void locationExtraDataTracePutMetricData(LocationExtraDataTraceLogger r0, String r1, long r2) {
        if (r0 != null) goto L4;
        return;
    L4:
        r0.putReportMetricData(r1, r2);
    }

    public static void locationFrequencyMonitor(LocationOption r4, int r5, long r6, long r8, int r10, long r11) {
        if (r4 != null) goto L4;
        return;
    L4:
        JSONObject r0 = new JSONObject();
        JSONObject r1 = new JSONObject();
        JsonUtil.safePutString(r0, LocationMonitorConst.BPEA_CERT_TOKEN, r4.getUploadSource());
        JsonUtil.safePutInt(r0, LocationMonitorConst.LOCATION_REASON_CODE, r5);
        JsonUtil.safePutLong(r1, LocationMonitorConst.CACHE_AVAILABLE_TIME, r4.getMaxCacheTime());
        if (r8 == (-1)) goto L8;
        JsonUtil.safePutLong(r1, LocationMonitorConst.LOCATION_INTERVAL, r8);
    L8:
        if (r11 == (-1)) goto L10;
        JsonUtil.safePutLong(r1, LocationMonitorConst.LAST_LOCATION_CACHE_TIME, r11);
        JsonUtil.safePutInt(r0, LocationMonitorConst.LAST_LOCATION_CACHE_CONDITION, r10);
        JsonUtil.safePutLong(r1, LocationMonitorConst.REAL_CACHE_INTERVAL, r6 - r11);
    L10:
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_DOWN_GRADE_LOCATION, r4.isDownGradeLocation());
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_LOCATION_FREQUENCY, r0, r1, null);
    }

    public static void locationTraceLogBegin(LocationTraceLogger r0, String r1) {
        if (r0 != null) goto L4;
        return;
    L4:
        r0.begin(r1);
    }

    public static void locationTraceLogEnd(LocationTraceLogger r0, String r1) {
        if (r0 != null) goto L4;
        return;
    L4:
        r0.end(r1);
    }

    public static void locationTraceLogErrorReport(LocationOption r0, BDLocationException r1) {
        if (r0 != null) goto L4;
        return;
    L4:
        LocationTraceLogger r2 = r0.getLocationTraceLogger();
        if (r2 != null) goto L7;
        return;
    L7:
        r2.locationErrorReport(r1);
    }

    public static void locationTraceLogSuccessReport(BDLocation r1, LocationOption r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        LocationTraceLogger r0 = r2.getLocationTraceLogger();
        if (r0 != null) goto L7;
        return;
    L7:
        r0.locationSuccessReport(r1, r2);
    }

    public static void locationTracePutCategoryData(LocationTraceLogger r0, String r1, Object r2) {
        if (r0 != null) goto L4;
        return;
    L4:
        r0.putCategoryData(r1, r2);
    }

    public static void locationTracePutLogExtra(LocationTraceLogger r0, String r1, Object r2) {
        if (r0 != null) goto L4;
        return;
    L4:
        r0.putLogExtra(r1, r2);
    }

    public static void locationTracePutMetricData(LocationTraceLogger r0, String r1, long r2) {
        if (r0 != null) goto L4;
        return;
    L4:
        r0.putReportMetricData(r1, r2);
    }

    public static void monitorByteLocationStealGpsInfoAndSysLocation(int r5, int r6, int r7, long r8, long r10, long r12, long r14, boolean r16, boolean r17, boolean r18, boolean r19, String r20, long r21) {
        JSONObject r1 = new JSONObject();
        JsonUtil.safePutInt(r1, "before_wait_count", r5);
        JsonUtil.safePutInt(r1, "after_wait_count", r6);
        JsonUtil.safePutInt(r1, "downgrade_location", r7);
        JsonUtil.safePutLong(r1, "max_wait_time", r10);
        JsonUtil.safePutBoolean(r1, "steal_gps_success", r16);
        JsonUtil.safePutBoolean(r1, "steal_sys_loc_success", r17);
        JsonUtil.safePutBoolean(r1, "has_option", r18);
        JsonUtil.safePutBoolean(r1, LocationExtraDataTraceLogger.USE_CONTINUOUS_GPS, r19);
        if (r19 == false) goto L5;
        JsonUtil.safePutString(r1, "gps_continuous_conf", r20);
    L5:
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutLong(r0, "real_wait_time", r14);
        JsonUtil.safePutLong(r0, "time_to_locate_start", r8);
        JsonUtil.safePutLong(r0, "real_max_wait_time", r12);
        JsonUtil.safePutLong(r0, LocationMonitorConst.GPS_COLLECT_CNT, r21);
        Logger.i("location-trace-core monitorByteLocationStealGpsInfoAndSysLocation, category: " + r1 + ", metric: " + r0);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_STEAL_GPS_INFO_AND_SYS_LOCATION, r1, r0);
    }

    public static void monitorLocationApiStatistics(int r3, String r4, String r5, boolean r6, boolean r7) {
        JSONObject r0 = new JSONObject();
        JSONObject r1 = new JSONObject();
        r0.put("method_id", r3);     // Catch: JSONException -> L6
        r0.put("class_name", r4);     // Catch: JSONException -> L6
        r0.put("member_name", r5);     // Catch: JSONException -> L6
        r0.put(MemoryInfoSectionEditActivity.KIND_SCENE, r6);     // Catch: JSONException -> L6
        r0.put("intercept", r7);     // Catch: JSONException -> L6
        r1.put(CommonConsts.COUNT_TYPE, 1);     // Catch: JSONException -> L6
    L4:
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_LOCATION_API_ACTION, r0, r1);
    }

    public static void monitorPassiveInit(final boolean r12, final long r13, final boolean r15, final boolean r16, final boolean r17, final String r18, final Throwable r19) {
        final RuntimeException r8 = new RuntimeException();
        AppExecutors.getInstance().diskIO().execute(new AnonymousClass1(r12, r15, r16, r17, r18, r13, r8, r19));
    }

    public static void monitorReflectScanResultFailed(int r2, int r3, String r4) {
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutInt(r0, LocationMonitorConst.ERR_CODE, r2);
        JsonUtil.safePutInt(r0, "type", r3);
        JSONObject r5 = new JSONObject();
        JsonUtil.safePutString(r5, LocationMonitorConst.ERR_MSG, r4);
        Logger.i("monitorReflectScanResultFailed, categories: " + r0 + ", logExtras: " + r5);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_REFLECT_SCAN_RESULT_FAILED, r0, null, r5);
    }

    public static void nonLocationSceneException(int r6, String r7, String r8, long r9, boolean r11) {
        Throwable r0 = new Throwable("" + r7 + "_" + r8 + " LocationException");
        JSONObject r1 = new JSONObject();
        JSONObject r3 = new JSONObject();
        r1.put("method_id", "" + r6);     // Catch: JSONException -> L5
        r1.put("class_name", r7);     // Catch: JSONException -> L5
        r1.put("member_name", r8);     // Catch: JSONException -> L5
        r1.put("biz_class_member", r11);     // Catch: JSONException -> L5
        r1.put("is_background", LocationUtil.isBackground());     // Catch: JSONException -> L5
        r3.put("stop_locate_interval", "" + (System.currentTimeMillis() - r9));     // Catch: JSONException -> L5
        r3.put(CommonConsts.COUNT_TYPE, 1);     // Catch: JSONException -> L5
        LocationMonitorUtil.monitorEventWithException(LocationMonitorConst.EVENT_LOCATION_API_ACTION_WITH_EXCEPTION, r1, r3, null, r0);     // Catch: JSONException -> L5
        return;
    }

    public static void overseasLocationFailedGetCache(boolean r3) {
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.OVERSEAS_GET_LOCATION_FAILED_CACHE_IS_VALIDITY, r3);
        JsonUtil.safePutLong(r0, "cache_time", BDLocationConfig.getOverseasGetLocationFailedUseCacheValidity());
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_OVERSEAS_GET_LOCATION_FAILED_CACHE_VALIDITY, r0, null, null);
    }

    public static void registerNetworkCallbackError(String r2, Exception r3) {
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutString(r0, LocationMonitorConst.REGISTER_NETWORK_ACTION, r2);
        JSONObject r4 = new JSONObject();
        if (r3 == null) goto L5;
        JsonUtil.safePutString(r4, LocationMonitorConst.DETAIL_ERR_MSG, r3.getMessage());
    L5:
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_CHECK_LOCATION_PROVIDER_ENABLED_ERROR, r0, null, r4);
    }

    public static void requestCellInfoUpdateMonitor(long r2, boolean r4, int r5, Throwable r6) {
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.REQUEST_CELL_INFO_UPDATE_SUCCESS, r4);
        JsonUtil.safePutInt(r0, LocationMonitorConst.ERR_CODE, r5);
        JSONObject r7 = new JSONObject();
        JsonUtil.safePutLong(r7, LocationMonitorConst.REQUEST_CELL_INFO_UPDATE_DURATION, r2);
        JSONObject r3 = new JSONObject();
        if (r6 == null) goto L5;
        JsonUtil.safePutString(r3, LocationMonitorConst.DETAIL_ERR_MSG, r6.getMessage());
    L5:
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_REQUEST_CELL_INFO_UPDATE, r0, r7, r3);
    }

    private static void requestLightLocationInfoUpdateMonitor(JSONObject r14, String r15) {
        if (r14 != null) goto L4;
        return;
    L4:
        boolean r0 = r14.optBoolean(LocationMonitorConst.IS_SUCCESS);
        boolean r5 = r14.optBoolean(LocationMonitorConst.IS_COLD_BOOT);
        boolean r10 = r14.optBoolean("is_downgrade");
        if (r0 == false) goto L7;
        boolean r4 = r14.optBoolean(LocationMonitorConst.HAS_LIGHT_LOCATION_INFO);
        long r2 = r14.optLong("total_duration");
        long r11 = r14.optLong(LocationMonitorConst.CACHE_DATA_INTERVAL);
        requestLightLocationUpdateSuccess(r2, r4, r5, r14.optLong(LocationMonitorConst.COLD_BOOT_TO_START_REQUEST), r14.optLong(LocationMonitorConst.COLD_BOOT_TO_END_REQUEST), r10, r11, r15);
        return;
    L7:
        requestLightLocationUpdateError(r14.optString(LocationMonitorConst.ERR_MSG), r5, r10, r15);
    }

    private static void requestLightLocationUpdateError(String r2, boolean r3, boolean r4, String r5) {
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_COLD_BOOT, r3);
        JsonUtil.safePutBoolean(r0, "is_downgrade", r4);
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_SUCCESS, false);
        JsonUtil.safePutString(r0, LocationMonitorConst.LIGHT_LOCATION_TYPE, r5);
        JsonUtil.safePutLong(r0, LocationMonitorConst.LIGHT_LOCATION_CACHE_INTERVAL, BDLightLocationCache.getLightLocationCacheInterval());
        JSONObject r6 = new JSONObject();
        JsonUtil.safePutString(r6, LocationMonitorConst.ERR_MSG, r2);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.BD_LOCATION_COLD_BOOT_REQUEST_LIGHT_LOCATION_INFO, r0, null, r6);
    }

    private static void requestLightLocationUpdateSuccess(long r2, boolean r4, boolean r5, long r6, long r8, boolean r10, long r11, String r13) {
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_COLD_BOOT, r5);
        JsonUtil.safePutBoolean(r0, "is_downgrade", r10);
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.IS_SUCCESS, true);
        JsonUtil.safePutBoolean(r0, LocationMonitorConst.HAS_LIGHT_LOCATION_INFO, r4);
        JsonUtil.safePutString(r0, LocationMonitorConst.LIGHT_LOCATION_TYPE, r13);
        JsonUtil.safePutLong(r0, LocationMonitorConst.LIGHT_LOCATION_CACHE_INTERVAL, BDLightLocationCache.getLightLocationCacheInterval());
        JSONObject r7 = new JSONObject();
        JsonUtil.safePutLong(r7, LocationMonitorConst.CACHE_DATA_INTERVAL, r11);
        JsonUtil.safePutLong(r7, "total_duration", r2);
        JsonUtil.safePutLong(r7, LocationMonitorConst.COLD_BOOT_TO_START_REQUEST, r6);
        JsonUtil.safePutLong(r7, LocationMonitorConst.COLD_BOOT_TO_END_REQUEST, r8);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.BD_LOCATION_COLD_BOOT_REQUEST_LIGHT_LOCATION_INFO, r0, r7, null);
    }

    public static void uploadAllStackTraces(String r2, String r3) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L10;
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutString(r0, LocationMonitorConst.METHOD_NAME, r2);
        JSONObject r4 = new JSONObject();
        JsonUtil.safePutString(r4, LocationMonitorConst.STACK_TRACE, r3);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_BD_LOCATION_ALL_TRACES, r0, null, r4);
        return;
    }

    public static void uploadAuthStatus(String r2, int r3, int r4, int r5, int r6, boolean r7) {
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutString(r0, LocationMonitorConst.TAG, r2);
        JsonUtil.safePutInt(r0, LocationMonitorConst.AUTH_STATUS, r3);
        JsonUtil.safePutInt(r0, LocationMonitorConst.LOCATION_MODE, r4);
        JsonUtil.safePutInt(r0, LocationMonitorConst.BLUETOOTH_AUTH_STATUS, r5);
        JsonUtil.safePutInt(r0, LocationMonitorConst.BLUETOOTH_SWITCH_STATUS, r6);
        JsonUtil.safePutInt(r0, "target_sdk_version", LocationUtil.getTargetSdkVersion());
        JsonUtil.safePutBoolean(r0, "is_skip", r7);
        Logger.i("LocationMonitor.uploadAuthStatus, categories: " + r0);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_AUTH_STATUS, r0, null);
    }

    public static void uploadBaseInfo(String r2, long r3, int r5, String r6, boolean r7) {
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutString(r0, "upload_source", r2);
        if (r5 != 0) goto L5;
        int r4 = 0;
    L6:
        JsonUtil.safePutInt(r0, "status", r4);
        JsonUtil.safePutInt(r0, LocationMonitorConst.ERR_CODE, r5);
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_MSG, r6);
        JsonUtil.safePutBoolean(r0, "is_background", r7);
        JsonUtil.safePutString(r0, LocationMonitorConst.NETWORK_SIGNATURE_MODE, BDLocationConfig.getNetworkSignatureMode());
        JSONObject r8 = new JSONObject();
        JsonUtil.safePutLong(r8, "total_duration", r3);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_BASE_INFO, r0, r8);
        return;
    L5:
        r4 = 1;
        goto L6
    }

    public static void uploadInitInfo(long r3, long r5, long r7) {
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutInt(r0, LocationMonitorConst.INVOKER_API_INIT_STATUS, BDLocationConfig.getInvokerApiInitStatus());
        JSONObject r1 = new JSONObject();
        JsonUtil.safePutLong(r1, "total_duration", r7);
        if (r3 <= 0) goto L5;
        JsonUtil.safePutLong(r1, LocationMonitorConst.APP_COLD_BOOT_TO_END_INIT_DURATION, r3);
    L5:
        JSONObject r4 = new JSONObject();
        JsonUtil.safePutLong(r4, LocationMonitorConst.APP_BOOT_TIME, r5);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_INIT, r0, r1, r4);
    }

    public static void uploadRestrictedInfo(long r3, int r5, String r6) {
        JSONObject r0 = new JSONObject();
        if (r5 != 0) goto L5;
        int r1 = 0;
    L6:
        JsonUtil.safePutInt(r0, "status", r1);
        JsonUtil.safePutInt(r0, LocationMonitorConst.ERR_CODE, r5);
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_MSG, r6);
        JSONObject r7 = new JSONObject();
        JsonUtil.safePutLong(r7, "total_duration", r3);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_RESTRICTED_INFO, r0, r7);
        return;
    L5:
        r1 = 1;
        goto L6
    }

    public static void uploadTraceroute(long r2, int r4, int r5, String r6) {
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutInt(r0, "status", r4);
        JsonUtil.safePutInt(r0, LocationMonitorConst.ERR_CODE, r5);
        JsonUtil.safePutString(r0, LocationMonitorConst.ERR_MSG, r6);
        JSONObject r7 = new JSONObject();
        JsonUtil.safePutLong(r7, "total_duration", r2);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_TRACEROUTE_UPLOAD, r0, r7);
    }

    public static void withoutCert(String r3) {
        JSONObject r0 = new JSONObject();
        JsonUtil.safePutString(r0, LocationMonitorConst.METHOD_NAME, r3);
        JSONObject r4 = new JSONObject();
        JsonUtil.safePutString(r4, LocationMonitorConst.STACK_TRACE, Log.getStackTraceString(new Throwable()));
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_BPEA_WITHOUT_CERT_CHECK, r0, null, r4);
    }
}
