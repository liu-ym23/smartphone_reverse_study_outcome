package com.bytedance.bdlocation.network;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.os.Build;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.entity.LogIdCacheEntity;
import com.bytedance.bdlocation.entity.NetworkAbilityEntity;
import com.bytedance.bdlocation.entity.gis.BdGisResult;
import com.bytedance.bdlocation.entity.gis.EncryptedBDGisResult;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.monitor.LocationTraceLogger;
import com.bytedance.bdlocation.network.model.DeviceLocation;
import com.bytedance.bdlocation.network.model.DeviceStatus;
import com.bytedance.bdlocation.network.model.InfoRequestExtraLite;
import com.bytedance.bdlocation.network.model.LocationInfo;
import com.bytedance.bdlocation.network.model.LocationResult;
import com.bytedance.bdlocation.network.model.LocationUploadExtra;
import com.bytedance.bdlocation.network.model.ShakeUploadInfo;
import com.bytedance.bdlocation.network.model.StationarySceneCacheInfo;
import com.bytedance.bdlocation.network.response.LocInfoRspData;
import com.bytedance.bdlocation.network.response.LocationResp;
import com.bytedance.bdlocation.permission.PermissionManager;
import com.bytedance.bdlocation.scan.gps.BDGnssInfo;
import com.bytedance.bdlocation.scan.gps.BDGpsInfo;
import com.bytedance.bdlocation.scan.gps.BDScanLocationInfo;
import com.bytedance.bdlocation.scan.strategy.ScanWifiStrategy;
import com.bytedance.bdlocation.scan.wifi.WifiUtil;
import com.bytedance.bdlocation.store.LocationCache;
import com.bytedance.bdlocation.store.ProcessScopedLocationCache;
import com.bytedance.bdlocation.utils.NetworkUtil;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ServerApi {
    private static final String GEOCODE_RELATIVE_PATH = "/location/geocode/";
    private static final String GIS_RELATIVE_PATH = "/location/gis/reverse_geolocation";
    private static final String INFO_RELATIVE_PATH = "/location/info/";
    private static final String LOCATION_CACHE_RELATIVE_PATH = "/location/submit-cache/";
    public static final String LOCATION_RELATIVE_PATH = "/location/submit-v2/";
    private static final String REVERSE_GEOLOCATION_PATH = "/location/reverse_geolocation/";
    private static final String SHAKE_REFRESH_RELATIVE_PATH = "/location/refresh-nearby-user-info/";
    private static final String SHAKE_RELATIVE_PATH = "/location/submit-nearby-user-info/";
    private static final AtomicInteger WAIT_GPS_INFO_THREAD_COUNT = null;
    private static boolean sIsFirstUpload;

    public static final class InfoRequestKeyParams {

        @SerializedName("device_status")
        final DeviceStatus deviceStatus;

        @SerializedName(WsConstants.KEY_EXTRA)
        final InfoRequestExtraLite extra;

        @SerializedName("timestamp")
        final long timestamp;

        public InfoRequestKeyParams(long r1, DeviceStatus r3, InfoRequestExtraLite r4) {
            this.timestamp = r1;
            this.deviceStatus = r3;
            this.extra = r4;
        }
    }

    static {
        WAIT_GPS_INFO_THREAD_COUNT = new AtomicInteger(0);
        sIsFirstUpload = true;
    }

    public ServerApi() {
    }

    private static LocationResp analysisLocationResult(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L11;
        String r4 = "analysisLocationResult networkResponse is null";
    L5:
        Logger.i(r4);
        return null;
    L11:
        return (LocationResp) ZeusTransformUtils.preCheckCast(JsonUtil.sGson.fromJson(r3, LocationResp.class), LocationResp.class, "com.obric.memorydata.plugin");
    L9:
        e = move-exception;
        r4 = "analysisLocationResult exception:" + e.toString();
        goto L5
    }

    private static void cacheLogId(String r3, long r4) {
        if (TextUtils.isEmpty(r3) == false) goto L7;
        String r5 = "cacheLogId setUploadLogEntity error";
    L5:
        Logger.i(r5);
        return;
    L7:
        LogIdCacheEntity r0 = BDLocationConfig.getLogIdCacheEntity();
        if (r0 != null) goto L10;
        r0 = new LogIdCacheEntity();
        r0.timestamp = r4;
    L13:
        r0.logId = r3;
        Logger.i("cacheLogId logId:" + r3 + "--startLocationTime：" + r4);
        BDLocationConfig.setLogIdCacheEntity(r0);
        r5 = "cacheLogId setUploadLogEntity success";
        goto L5
    L10:
        if (r4 == r0.timestamp) goto L13;
        r5 = "cacheLogId check time error startLocationTime:" + r4 + "--entityTIme:" + r0.timestamp;
        goto L5
    }

    private static boolean canSkipInfoRequest(DeviceStatus r8, InfoRequestExtraLite r9, InfoRequestQPSOptTraceLogger r10) {
        if (BDLocationConfig.enableInfoRequestOpt() == true) goto L6;
        r10.putCategoryData(InfoRequestQPSOptTraceLogger.REASON, "settings_not_enable");
        Logger.i("canSkipInfoRequest: false, info request opt not enabled.");
        return false;
    L6:
        String r3 = LocationUtil.allowUseLocation(true, true, false);
        if (TextUtils.equals("1", r3) == true) goto L10;
        Logger.i("canSkipInfoRequest: Location permission is not granted, continue to send info request. authorizationStatus: " + r3);
        r10.putCategoryData(InfoRequestQPSOptTraceLogger.REASON, "no_location_permission_" + r3);
        return false;
    L10:
        InfoRequestKeyParams r4 = readLastInfoRequestKeyParams();
        if (r4 != null) goto L26;
        Logger.i("canSkipInfoRequest: lastInfoRequestKeyParams == null, currentInfoRequestExtraLite: " + r9);
        StringBuilder r5 = new StringBuilder().append("lastInfoRequestKeyParams == null: true, currentDeviceStatus == null: ");
        if (r8 != null) goto L15;
        boolean r6 = true;
    L16:
        StringBuilder r7 = r5.append(r6).append(", currentInfoRequestExtraLite == null: ");
        if (r9 != null) goto L19;
        boolean r11 = true;
    L20:
        r10.putCategoryData(InfoRequestQPSOptTraceLogger.REASON, r7.append(r11).toString());
        if (r8 != null) goto L40;
        if (r9 == null) goto L24;
        return false;
    L24:
        return true;
    L40:
        return false;
    L19:
        r11 = false;
        goto L20
    L15:
        r6 = false;
        goto L16
    L26:
        if ((System.currentTimeMillis() - r4.timestamp) <= BDLocationConfig.getInfoRequestKeyParamsMaxCacheTime()) goto L29;
        Logger.i("canSkipInfoRequest: reach info request key params max cache time.");
        r10.putCategoryData(InfoRequestQPSOptTraceLogger.REASON, LocationMonitorConst.TIMEOUT);
        return false;
    L29:
        DeviceStatus r12 = r4.deviceStatus;
        if (r12 != null) goto L34;
        if (r8 == null) goto L38;
        Logger.i("canSkipInfoRequest: lastInfoRequestDeviceStatus == null && currentDeviceStatus != null");
        r10.putCategoryData(InfoRequestQPSOptTraceLogger.REASON, "lastInfoRequestDeviceStatus == null && currentDeviceStatus != null");
        return false;
    L38:
        Logger.i("canSkipInfoRequest: no device status diff, continue to compare scenes permissions");
        return !shouldSendInfoRequestBasedOnExtraDiff(r4.extra, r9, r10);
    L34:
        int r13 = r12.diffWith(r8);
        if (isDeviceStatusDiffEnoughToTriggerInfoRequest(r13) == false) goto L38;
        Logger.i("canSkipInfoRequest: diffResult: " + r13 + " enough to trigger info request.");
        r10.putCategoryData(InfoRequestQPSOptTraceLogger.REASON, "device status diff result: " + r13);
        return false;
    }

    private static boolean checkoutUploadRule(LocationUploadExtra r2) {
        if (BDLocationConfig.isRestrictedModeOn() == false) goto L8;
        String r3 = "The collection of data is allowed restricted mode off!";
    L5:
        Logger.i(r3);
        return false;
    L8:
        if (isBypassBackgroundUpload(r2) == true) goto L13;
        if (LocationUtil.checkBackground() == false) goto L13;
        r3 = "The collection of data is allowed enter foreground!";
    L13:
        if (BDLocationConfig.isPrivacyConfirmed() == true) goto L15;
        r3 = "The collection of data is allowed after user confirmed the privacy!";
        goto L5
    L15:
        return true;
    }

    public static LocInfoRspData doLightLocationSubmitV2(long r8, String r10, int r11, boolean r12, LBSLightLocationTraceLogger r13, List<ScanResult> r14, String r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder().append("doLightLocationSubmitV2 executed. uploadSource: ").append(r10).append(", triggerType: ").append(r11).append(", encryptLocInfo: ").append(r12).append(", traceLogger is null: ");
        boolean r2 = true;
        if (r13 != null) goto L5;
        boolean r4 = true;
    L6:
        StringBuilder r1 = r0.append(r4).append(", scanResults is empty: ");
        if (r16 != null) goto L9;
    L12:
        boolean r5 = true;
    L13:
        Logger.i(r1.append(r5).toString());
        if (r16 != null) goto L16;
    L44:
        StringBuilder r9 = new StringBuilder().append("doLightLocationSubmitV2 failed: invalid params, uploadSource: ").append(r10).append(", scanResults is empty: ");
        if (r16 != null) goto L47;
    L50:
        String r17 = r9.append(r2).toString();
        Logger.i(r17);
        throw new BDLocationException(r17, BuildConfig.BDLOCATION_VERSION, BDLocationException.ERROR_CODE_LBS_LIGHT_SUBMITV2_FAILED);
    L47:
        if (r16.isEmpty() == true) goto L50;
        r2 = false;
        goto L50
    L16:
        if (r16.isEmpty() == true) goto L44;
        if (TextUtils.isEmpty(r10) == true) goto L44;
        Logger.i("doLightLocationSubmitV2: start prepare lbs light submit-v2 params.");
        LocationMonitor.lbsLightLocationTraceMetricBegin(r13, LBSLightLocationTraceLogger.NETWORK_REQUEST_PARAMS_PREPARE);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r13, LBSLightLocationTraceLogger.NETWORK_REQUEST_PARAMS_PARSE);
        Logger.i("doLightLocationSubmitV2: before parseLocationJsonFromScanResults");
        JSONObject r18 = parseLocationJsonFromScanResults(r16);
        Logger.i("doLightLocationSubmitV2: after parseLocationJsonFromScanResults");
        LocationMonitor.lbsLightLocationTraceMetricEnd(r13, LBSLightLocationTraceLogger.NETWORK_REQUEST_PARAMS_PARSE);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r13, LBSLightLocationTraceLogger.NETWORK_REQUEST_LOC_INFO);
        JSONObject r6 = new JSONObject();
        r6.put("upload_source", r10 + "_lbslight");
        r6.put("locate_id", r15);
        if (r8 <= 0) goto L23;
        r6.put("start_timestamp_ms", r8);
        Logger.i("location-trace-core doLightLocationSubmitV2: add start_timestamp_ms field: " + r8);
    L23:
        r6.put("upload_sensors", "light_sensor_lbslight");
        r6.put("timestamp", System.currentTimeMillis() / 1000);
        r6.put("location", r18);
        JSONObject r19 = new JSONObject();
        r19.put("byte_location_group", BDLocationConfig.getByteLocationLibraParam());
        r6.put("ab_config", r19);
        String r20 = r6.toString();
        LocationMonitor.lbsLightLocationTraceMetricEnd(r13, LBSLightLocationTraceLogger.NETWORK_REQUEST_LOC_INFO);
        Logger.i("doLightLocationSubmitV2: prepare lbs light submit-v2 params finished.");
        LocationMonitor.lbsLightLocationTracePutCategoryData(r13, LBSLightLocationTraceLogger.ENCRYPT_SUBMIT_V2_BODY, Boolean.valueOf(r12));
        if (r12 == false) goto L26;
        LocationMonitor.lbsLightLocationTraceMetricBegin(r13, LBSLightLocationTraceLogger.ENCRYPT);
        r20 = packFingerprint(r20);
        LocationMonitor.lbsLightLocationTraceMetricEnd(r13, LBSLightLocationTraceLogger.ENCRYPT);
    L26:
        LinkedHashMap r21 = new LinkedHashMap();
        r21.put("locinfo", r20);
        LinkedHashMap r22 = new LinkedHashMap();
        r22.put("sdk_version", BuildConfig.BDLOCATION_VERSION);
        LocationMonitor.lbsLightLocationTraceMetricEnd(r13, LBSLightLocationTraceLogger.NETWORK_REQUEST_PARAMS_PREPARE);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r13, LBSLightLocationTraceLogger.SUBMIT_V2_REQUEST);
        SsResponse<String> r23 = NetworkRequestManager.submitPost(LOCATION_RELATIVE_PATH, r21, r22, r11, LocationAnnotation.SubmitSource.LIGHT_LOCATION_SUBMIT_V2);
        LocationMonitor.lbsLightLocationTraceMetricEnd(r13, LBSLightLocationTraceLogger.SUBMIT_V2_REQUEST);
        LocationMonitor.lbsLightLocationTraceMetricEnd(r13, LBSLightLocationTraceLogger.NETWORK_TOTAL);
        LocationMonitor.lbsLightLocationTraceMetricEnd(r13, LBSLightLocationTraceLogger.TOTAL);
        if (r23 == null) goto L43;
        String r110 = getLogId(r23);
        LocationMonitor.lbsLightLocationTracePutLogExtra(r13, LBSLightLocationTraceLogger.SUBMIT_V2_LOG_ID, r110);
        LocationResp r24 = analysisLocationResult((String) ZeusTransformUtils.preCheckCast(r23.body(), String.class, "com.obric.memorydata.plugin"));
        if (r24 == null) goto L36;
        r24.submitLogId = r110;
        if (r24.resultCode != 0) goto L36;
        Logger.i("doLightLocationSubmitV2 success.");
        LocInfoRspData r25 = LocationUtil.parseLocInfoRsp(r24);
        if (r13 == null) goto L35;
        r13.reportLBSLightLocationSuccess(r25);
    L35:
        return r25;
    L36:
        Logger.i("doLightLocationSubmitV2 failed: locationResp == null || locationResp.resultCode != 0, submitLogId: " + r110);
        StringBuilder r111 = new StringBuilder().append("lbs light submit-v2 failed: locationResp invalid: ");
        if (r24 != null) goto L39;
        String r26 = "null";
    L41:
        throw new BDLocationException(r111.append(r26).toString(), LocationInfoConst.BDLOCATION, BDLocationException.ERROR_CODE_LBS_LIGHT_SUBMITV2_FAILED);
    L39:
        r26 = r24.toMonitorString();
        goto L41
    L43:
        throw new BDLocationException("doLightLocationSubmitV2 failed: ssResponse == null", LocationInfoConst.BDLOCATION, BDLocationException.ERROR_CODE_LBS_LIGHT_SUBMITV2_FAILED);
    L9:
        if (r16.isEmpty() == true) goto L12;
        r5 = false;
        goto L13
    L5:
        r4 = false;
        goto L6
    }

    public static BdGisResult getGisResult(double r3, double r5, int r7, int r8) {
        if (checkoutUploadRule(null) == true) goto L7;
        String r4 = "The collection of data is allowed checkoutUploadRule!";
    L5:
        Logger.i(r4);
        return null;
    L7:
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("longitude", Double.valueOf(r5));
        r2.put("latitude", Double.valueOf(r3));
        Locale r6 = BDLocationConfig.getLocale();
        if (r6 != null) goto L10;
        r6 = Locale.getDefault();
    L10:
        r2.put(Api.KEY_LANGUAGE, LocationUtil.languageTag(r6));
        String r9 = BDLocationConfig.getWorldView();
        if (TextUtils.isEmpty(r9) == true) goto L13;
        r2.put("worldview", r9);
    L13:
        r2.put("extension", Integer.valueOf(r8));
        String r10 = packFingerprint(JsonUtil.sGson.toJson(r2));
        HashMap r11 = new HashMap();
        r11.put("resolve_gps", r10);
        long r12 = SystemClock.elapsedRealtime();
        EncryptedBDGisResult r13 = (EncryptedBDGisResult) ZeusTransformUtils.preCheckCast(JsonUtil.sGson.fromJson(NetworkRequestManager.post(REVERSE_GEOLOCATION_PATH, r11, null, r7), EncryptedBDGisResult.class), EncryptedBDGisResult.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L28
        if (r13 != null) goto L19;
        Logger.e("getGisResult failed: result == null");     // Catch: Exception -> L28
        return null;
    L19:
        if (r13.errorCode == 0) goto L22;
        Logger.i("getGisResult failed, errorCode: " + r13.errorCode + ", errorMessage: " + r13.errorMessage + ", errorTips: " + r13.errorTips);     // Catch: Exception -> L28
        return null;
    L22:
        BdGisResult r14 = (BdGisResult) ZeusTransformUtils.preCheckCast(JsonUtil.sGson.fromJson(unpackFingerprint(r13.data), BdGisResult.class), BdGisResult.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L28
        if (r14 != null) goto L25;
    L27:
        return r14;
    L25:
        if (r14.baseResp == null) goto L27;
        LocationMonitor.doGis(SystemClock.elapsedRealtime() - r12, r14.baseResp.statusCode, r14.baseResp.statusMessage, 1);     // Catch: Exception -> L28
    L28:
        e = move-exception;
        LocationMonitor.doGis(SystemClock.elapsedRealtime() - r12, -1, e.getMessage(), 1);
        r4 = "getGisResult Exception:" + e.toString();
        goto L5
    }

    public static BdGisResult getGisResultOld(double r3, double r5, int r7, int r8) {
        if (checkoutUploadRule(null) == true) goto L7;
        String r4 = "The collection of data is allowed checkoutUploadRule!";
    L5:
        Logger.i(r4);
        return null;
    L7:
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("longitude", String.valueOf(r5));
        r1.put("latitude", String.valueOf(r3));
        Locale r6 = BDLocationConfig.getLocale();
        if (r6 != null) goto L10;
        r6 = Locale.getDefault();
    L10:
        r1.put(Api.KEY_LANGUAGE, LocationUtil.languageTag(r6));
        String r9 = BDLocationConfig.getWorldView();
        if (TextUtils.isEmpty(r9) == true) goto L13;
        r1.put("worldview", r9);
    L13:
        r1.put("extension", String.valueOf(r8));
        long r10 = SystemClock.elapsedRealtime();
        BdGisResult r11 = (BdGisResult) ZeusTransformUtils.preCheckCast(JsonUtil.sGson.fromJson(NetworkRequestManager.get(GIS_RELATIVE_PATH, r1, r7), BdGisResult.class), BdGisResult.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L20
        if (r11 != null) goto L17;
    L19:
        return r11;
    L17:
        if (r11.baseResp == null) goto L19;
        LocationMonitor.doGis(SystemClock.elapsedRealtime() - r10, r11.baseResp.statusCode, r11.baseResp.statusMessage, 0);     // Catch: Exception -> L20
    L20:
        e = move-exception;
        LocationMonitor.doGis(SystemClock.elapsedRealtime() - r10, -1, e.getMessage(), 0);
        r4 = "getGisResult Exception:" + e.toString();
        goto L5
    }

    private static JsonObject getGpsAndBleUploadBody(LocationUploadExtra r7) {
        BDGpsInfo r0 = null;
        if (r7 != null) goto L6;
        Logger.i("getGpsAndBleUploadBody extra is null");
        return null;
    L6:
        JsonObject r1 = new JsonObject();
        r1.addProperty("upload_source", r7.getUploadSource());
        r1.addProperty("locate_id", r7.getLocateId());
        if (r7.locationOption != null) goto L9;
    L11:
        String r2 = r7.getGpsAndBleMark();
        r1.addProperty("upload_sensors", r2);
        LogIdCacheEntity r3 = r7.getLogIdCache();
        if (BDLocationConfig.enableUploadLastLogId() == false) goto L17;
        if (r3 != null) goto L15;
    L56:
        JsonObject r8 = new JsonObject();
        r8.addProperty("byte_location_group", BDLocationConfig.getByteLocationLibraParam());
        r1.add("ab_config", r8);
        r1.addProperty("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
        return r1;
    L15:
        if (TextUtils.isEmpty(r3.logId) == true) goto L56;
    L17:
        if (BDLocationConfig.enableUploadLastLogId() == false) goto L20;
        r1.addProperty("last_log_id", r3.logId);
    L20:
        if (BDLocationConfig.enableScanBle() == false) goto L29;
        if (TextUtils.isEmpty(r2) == true) goto L29;
        if ("ble".equals(r2) == false) goto L26;
    L27:
        r1.add("bluetooth_list", JsonUtil.safeToJsonTree(r7.getBleList()));
        goto L29
    L26:
        if ("ble_gps".equals(r2) == true) goto L27;
    L29:
        if (BDLocationConfig.isEnableGpsScan() == false) goto L56;
        if (TextUtils.isEmpty(r2) == true) goto L56;
        if ("gps".equals(r2) == false) goto L35;
    L36:
        r1.add("upload_gps", JsonUtil.safeToJsonTree(r7.getGpsInfo(BDScanLocationInfo.TakeStrategy.firstResult)));
        if (r7.isContinuousGpsInfo() == true) goto L39;
    L55:
        DeviceLocation r4 = new DeviceLocation();
        r4.sysLocation = r7.getSysLocation();
        r4.aMapLocation = r7.getAMapLocation();
        r1.add("location", JsonUtil.safeToJsonTree(r4));
        goto L56
    L39:
        if (BDLocationConfig.isCollectContinuousGpsOnlyLast() == false) goto L51;
        List<BDGpsInfo> r5 = r7.getGpsInfoList();
        ArrayList r6 = new ArrayList();
        if (r5.isEmpty() == true) goto L43;
        r0 = (BDGpsInfo) ZeusTransformUtils.preCheckCast(r5.get(r5.size() - 1), BDGpsInfo.class, "com.obric.memorydata.plugin");
        r6.add(r0);
    L43:
        r1.add("upload_gps_list", JsonUtil.safeToJsonTree(r6));
        if (BDLocationConfig.isCollectContinuousGpsDisableGnssUpload() == true) goto L55;
        ArrayList r9 = new ArrayList();
        if (r0 == null) goto L50;
        BDGnssInfo r10 = r7.findNearbyGnssInfo(r0);
        if (r10 == null) goto L50;
        r9.add(r10);
    L50:
        JsonElement r11 = JsonUtil.safeToJsonTree(r9);
    L54:
        r1.add("upload_gnss_list", r11);
        goto L55
    L51:
        r1.add("upload_gps_list", JsonUtil.safeToJsonTree(r7.getGpsInfoList()));
        if (BDLocationConfig.isCollectContinuousGpsDisableGnssUpload() == true) goto L55;
        r11 = JsonUtil.safeToJsonTree(r7.getGnssInfoList());
        goto L54
    L35:
        if ("ble_gps".equals(r2) == false) goto L56;
    L9:
        if (r7.locationOption.startLocationTimestampInMillis <= 0) goto L11;
        r1.addProperty("start_timestamp_ms", Long.valueOf(r7.locationOption.startLocationTimestampInMillis));
        Logger.i("location-trace-core getGpsAndBleUploadBody: add start_timestamp_ms property: " + r7.locationOption.startLocationTimestampInMillis);
        goto L11
    }

    public static LocationResult getIPResult(int r7) {
        if (checkoutUploadRule(null) == true) goto L6;
        Logger.i("The collection of data is allowed checkoutUploadRule!");
        return null;
    L6:
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("dwinfo", packFingerprint(new JsonObject()));
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("sdk_version", BuildConfig.BDLOCATION_VERSION);
        long r3 = SystemClock.elapsedRealtime();
        JSONObject r4 = new JSONObject(NetworkRequestManager.post(GEOCODE_RELATIVE_PATH, r1, r2, r7));     // Catch: Exception -> L11
        int r8 = r4.optInt("err_no");     // Catch: Exception -> L11
        String r5 = r4.optString(LocationMonitorConst.ERR_MSG);     // Catch: Exception -> L11
        LocationMonitor.doGeocode(SystemClock.elapsedRealtime() - r3, r8, r5);     // Catch: Exception -> L11
        if (r8 != 0) goto L13;
        String r9 = r4.getString("data");     // Catch: Exception -> L11
        return (LocationResult) ZeusTransformUtils.preCheckCast(JsonUtil.sGson.fromJson(unpackFingerprint(r9), LocationResult.class), LocationResult.class, "com.obric.memorydata.plugin");
    L13:
        return null;
    L11:
        e = move-exception;
        LocationMonitor.doGeocode(SystemClock.elapsedRealtime() - r3, -2, e.getMessage());
        e.printStackTrace();
        goto L13
    }

    private static JsonObject getLightUploadBody(DeviceLocation r3, DeviceStatus r4, LocationUploadExtra r5) {
        JsonObject r0 = new JsonObject();
        if (r5 == null) goto L5;
        r0.addProperty("upload_source", r5.getUploadSource());
        r0.addProperty("upload_sensors", "light_sensor");
    L5:
        r0.add("location", JsonUtil.safeToJsonTree(r3));
        r0.add("status", JsonUtil.safeToJsonTree(r4));
        r0.addProperty(Api.KEY_LANGUAGE, LocationUtil.getLanguage());
        r0.addProperty("world_view", BDLocationConfig.getWorldView());
        r0.addProperty("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
        return r0;
    }

    public static LocationResp getLocationInfoMustInNetworkIOThreadPool(DeviceLocation r19, DeviceStatus r20, LocationUploadExtra r21) {
        LocationTraceLogger r3 = r21.getLocationTraceLogger();
        LocationMonitor.locationTraceLogBegin(r3, LocationMonitorConst.SUBMIT_V2_DURATION);
        JsonObject r6 = getSubmitUploadBody(r19, r20, r21, true);
        LinkedHashMap r7 = new LinkedHashMap();
        r7.put("locinfo", packFingerprint(r6));
        LinkedHashMap r8 = new LinkedHashMap();
        r8.put("sdk_version", BuildConfig.BDLOCATION_VERSION);
        long r9 = SystemClock.elapsedRealtime();
        if (sIsFirstUpload == false) goto L5;
        LocationMonitor.doFirstSubmitDuration(r9 - BDLocationConfig.getInitStartTime());
        Logger.i("locationmonitor first submit duration is: " + (r9 - BDLocationConfig.getInitStartTime()) + "ms");
        sIsFirstUpload = false;
    L5:
        boolean r10 = LocationUtil.isBackground();
        SsResponse<String> r11 = NetworkRequestManager.submitPost(LOCATION_RELATIVE_PATH, r7, r8, r21.getTriggerType(), LocationAnnotation.SubmitSource.FULL_LOCATION);
        LocationMonitor.uploadAuthStatus(LocationMonitorConst.SUBMIT, PermissionManager.checkLocationPermissions((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), true), LocationUtil.getLocationMode((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), PermissionManager.checkBluetoothScanPermission((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), LocationUtil.getbluetoothSwitch() ? 1 : 0, false);
        if (r11 == null) goto L23;
        String r5 = getLogId(r11);
        cacheLogId(r5, r21.getStartLocationTime());
        if (BDLocationConfig.enableCheckLastLogId() == true) goto L17;
        LogIdCacheEntity r12 = r21.getLogIdCache();
        if (r12 == null) goto L12;
        r12.logId = r5;
        r12.timestamp = r21.getStartLocationTime();
    L12:
        StringBuilder r13 = new StringBuilder().append("getLocationInfo ");
        if (r12 != null) goto L15;
        String r14 = "logIdCacheEntity = null";
    L16:
        Logger.i(r13.append(r14).toString());
        goto L17
    L15:
        r14 = "logIdCacheEntity.logId: " + r12.logId + ", logIdCacheEntity.timestamp: " + r12.timestamp;
    L17:
        LocationResp r0 = analysisLocationResult((String) ZeusTransformUtils.preCheckCast(r11.body(), String.class, "com.obric.memorydata.plugin"));
        if (r0 == null) goto L20;
        r0.submitLogId = r5;
        LocationMonitor.doSubmit(SystemClock.elapsedRealtime() - r9, r0.resultCode, r0.resultMsg, r10);
        Logger.i("locationmonitor submit total duration is: " + (SystemClock.elapsedRealtime() - r9) + "ms");
    L21:
        LocationMonitor.locationTraceLogEnd(r3, LocationMonitorConst.SUBMIT_V2_DURATION);
        Logger.i("ServerApi", "end network duration is " + (System.currentTimeMillis() - r9));
        ScanWifiStrategy.INSTANCE.checkScanWifiStrategy(r0, r19, r20, r21);
        return r0;
    L20:
        LocationMonitor.doSubmit(SystemClock.elapsedRealtime() - r9, -2, "result is null", r10);
        goto L21
    L23:
        LocationMonitor.locationTraceLogEnd(r3, LocationMonitorConst.SUBMIT_V2_DURATION);
        return null;
    }

    private static String getLogId(SsResponse<String> r2) {
        if (r2 != null) goto L5;
    L14:
        String r3 = "getLogId ssResponse error";
    L10:
        Logger.i(r3);
        return "";
    L5:
        if (r2.raw() == null) goto L14;
        Header r4 = r2.raw().getFirstHeader("X-Tt-Logid");
        if (r4 != null) goto L13;
        r3 = "getLogId firstHeader error";
        goto L10
    L13:
        return r4.getValue();
    }

    private static JsonObject getSubmitCacheLocationUploadBody(DeviceLocation r7, DeviceStatus r8, LocationUploadExtra r9) {
        JsonObject r0 = new JsonObject();
        StationarySceneCacheInfo r1 = LocationCache.getInstance().getStationarySceneCacheInfo();
        if (r9 == null) goto L5;
        String r2 = r9.getUploadSource();
        r0.addProperty("upload_interval", Long.valueOf(r9.getUploadInterval()));
        r0.addProperty("upload_source", r2);
        r0.addProperty("locate_id", r9.getLocateId());
        r0.addProperty("start_timestamp_ms", Long.valueOf(r9.getStartLocationTimestampInMillis()));
        String r3 = r9.getExtra();
        String r4 = wrapSubmitExtra(r3);
        Logger.i("getSubmitCacheLocationUploadBody: originExtraStr: " + r3 + ", wrappedExtraStr: " + r4);
        r0.addProperty(WsConstants.KEY_EXTRA, r4);
        Logger.i("getLocationInfo upload_source:" + r2 + "-upload_interval:-extra:" + r9.getExtra());
    L5:
        if (r1 == null) goto L7;
        r0.add("upload_gps", JsonUtil.safeToJsonTree(r1.getGpsInfo()));
        r0.add("result_location_cache", JsonUtil.safeToJsonTree(r1.getLocationResult()));
    L7:
        r0.add("location", JsonUtil.safeToJsonTree(r7));
        r0.add("status", JsonUtil.safeToJsonTree(r8));
        r0.addProperty(Api.KEY_LANGUAGE, LocationUtil.getLanguage());
        r0.addProperty("world_view", BDLocationConfig.getWorldView());
        r0.addProperty("is_vpn", Boolean.valueOf(LocationUtil.checkVPN()));
        r0.addProperty("is_proxy", Boolean.valueOf(LocationUtil.isProxy()));
        if (BDLocationConfig.isEnableHARCollect() == false) goto L10;
        r0.add("har_status_list", JsonUtil.safeToJsonTree(LocationUtil.getHARStatusList()));
        r0.addProperty("har_status_max", Integer.valueOf(LocationUtil.getMaxHARStatus()));
    L10:
        r0.addProperty("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
        NetworkAbilityEntity r10 = new NetworkUtil().getNetworkAbility((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        if (r10 == null) goto L13;
        r0.add("network_capabilities", JsonUtil.safeToJsonTree(r10.netCapabilityList));
        r0.add("network_transports", JsonUtil.safeToJsonTree(r10.netTransportList));
    L13:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r9v22, types: [java.lang.StringBuilder] */
    private static JsonObject getSubmitUploadBody(DeviceLocation r31, DeviceStatus r32, LocationUploadExtra r33, boolean r34) {
        JsonObject r1 = new JsonObject();
        String r2 = "com.obric.memorydata.plugin";
        boolean r3 = true;
        if (r33 == null) goto L73;
        String r4 = r33.getLocateId();
        String r5 = r33.getUploadSource();
        boolean r6 = r33.isOnceLocation();
        r1.addProperty("upload_interval", Long.valueOf(r33.getUploadInterval()));
        r1.addProperty("upload_source", r5);
        r1.addProperty("locate_id", r4);
        long r7 = 0;
        if (r33.locationOption != null) goto L7;
    L9:
        r1.addProperty("latest_admin_version", Boolean.valueOf(r33.isLatestAdminVersion()));
        String r8 = r33.getExtra();
        String r9 = wrapSubmitExtra(r8);
        Logger.i("getSubmitUploadBody: originExtraStr: " + r8 + ", wrappedExtraStr: " + r9);
        r1.addProperty(WsConstants.KEY_EXTRA, r9);
        LogIdCacheEntity r10 = r33.getLogIdCache();
        if (r10 != null) goto L12;
    L16:
        Logger.i("getLocationInfo upload_source:" + r33.getUploadSource() + "-upload_interval:" + r33.getUploadInterval() + "-extra:" + r33.getExtra());
        if (LocationUtil.isUseByteLocationPolicyV2(r5) == false) goto L19;
    L22:
        LocationOption r11 = r33.locationOption;
        if (r11 != null) goto L25;
    L30:
        if (r11 != null) goto L32;
        long r12 = 0;
    L33:
        long r13 = 0;
    L34:
        long r14 = r12;
        Logger.i("location-trace-core before wait, time to start location: " + r14);
        long r15 = SystemClock.elapsedRealtime();
        int r16 = WAIT_GPS_INFO_THREAD_COUNT.getAndIncrement();
        if (r13 > 0) goto L37;
    L39:
        BDGpsInfo r17 = r33.waitGpsInfo(r7, BDScanLocationInfo.TakeStrategy.lastResult);
        if (r17 == null) goto L53;
        if (r11 == null) goto L45;
        StationarySceneCacheInfo r18 = r11.getStationarySceneCacheInfo();
        if (r18 == null) goto L45;
        r18.setGpsInfo(r17);
    L45:
        r1.add("upload_gps", JsonUtil.safeToJsonTree(r17));
        Logger.i("location-trace-core steal gps info success.");
        List<BDGpsInfo> r19 = r33.getGpsInfoList();
        int r110 = r19.size() - 1;
    L46:
        if (r110 < 0) goto L51;
        String r29 = r2;
        JsonObject r30 = r1;
        if (((BDGpsInfo) ZeusTransformUtils.preCheckCast(r19.get(r110), BDGpsInfo.class, r2)).realTimestamp == r17.realTimestamp) goto L49;
        r110 = r110 - 1;
        r3 = true;
        r2 = r29;
        r1 = r30;
        goto L46
    L49:
        boolean r0 = true;
        int r111 = r110 + 1;
    L52:
        boolean r22 = r0;
    L54:
        long r20 = SystemClock.elapsedRealtime() - r15;
        int r112 = WAIT_GPS_INFO_THREAD_COUNT.decrementAndGet();
        if (r11 != null) goto L57;
        ?? r21 = -1;
    L61:
        Logger.i("location-trace-core ServerApi.getSubmitUploadBody, realWaitTime: " + r20 + ", maxWaitTime: " + r7 + ", before wait count: " + r16 + ", after wait count: " + r112 + ", downgrade location: " + r21);
        LocationInfo r23 = r33.getSysLocation();
        if (r23 != null) goto L64;
    L66:
        boolean r24 = false;
    L67:
        long r113 = BDLocationConfig.maxWaitGPSTimeMillis();
        if (r11 == null) goto L70;
        boolean r25 = r0;
    L71:
        boolean r26 = r33.isContinuousGpsInfo();
        String r27 = r33.getContinuousGpsConfigCategory();
        long r28 = r111;
        LocationMonitor.monitorByteLocationStealGpsInfoAndSysLocation(r16, r112, r21 == true ? 1 : 0, r14, r113, r7, r20, r22, r24, r25, r26, r27, r28);
    L72:
        r3 = r6;
    L74:
        if (r3 == false) goto L76;
        JsonObject r35 = new JsonObject();
        r35.addProperty("byte_location_group", BDLocationConfig.getByteLocationLibraParam());
        JsonObject r36 = r30;
        r36.add("ab_config", r35);
    L77:
        r36.add("location", JsonUtil.safeToJsonTree(r31));
        r36.add("status", JsonUtil.safeToJsonTree(r32));
        r36.addProperty(Api.KEY_LANGUAGE, LocationUtil.getLanguage());
        r36.addProperty("world_view", BDLocationConfig.getWorldView());
        r36.addProperty("is_vpn", Boolean.valueOf(LocationUtil.checkVPN()));
        r36.addProperty("is_proxy", Boolean.valueOf(LocationUtil.isProxy()));
        if (BDLocationConfig.isEnableHARCollect() == false) goto L80;
        r36.add("har_status_list", JsonUtil.safeToJsonTree(LocationUtil.getHARStatusList()));
        r36.addProperty("har_status_max", Integer.valueOf(LocationUtil.getMaxHARStatus()));
    L80:
        r36.addProperty("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
        String r37 = r29;
        NetworkAbilityEntity r38 = new NetworkUtil().getNetworkAbility((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), r37), Context.class, r37));
        if (r38 == null) goto L83;
        r36.add("network_capabilities", JsonUtil.safeToJsonTree(r38.netCapabilityList));
        r36.add("network_transports", JsonUtil.safeToJsonTree(r38.netTransportList));
    L83:
        return r36;
    L76:
        r36 = r30;
        goto L77
    L70:
        r25 = false;
        goto L71
    L64:
        if (BDLocationConfig.isRevertToSystemLocation() == true) goto L66;
        r31.sysLocation = r23;
        r24 = r0;
        goto L67
    L57:
        if (r11.isDownGradeLocation() == false) goto L59;
        r21 = r0;
        goto L61
    L59:
        r21 = 0;
        goto L61
    L51:
        r30 = r1;
        r29 = r2;
        r0 = r3;
        r111 = 0;
        goto L52
    L53:
        r30 = r1;
        r29 = "com.obric.memorydata.plugin";
        r0 = true;
        Logger.i("location-trace-core steal gps info failed.");
        r111 = 0;
        r22 = false;
        goto L54
    L37:
        if (r13 > BDLocationConfig.maxWaitGPSTimeMillis()) goto L39;
        r7 = r13;
        goto L39
    L32:
        r12 = r11.timeToStartLocationInMillis();
        goto L33
    L25:
        if (r11.isDownGradeLocation() == true) goto L30;
        if (r34 == false) goto L30;
        if (Looper.myLooper() == Looper.getMainLooper()) goto L30;
        long r39 = BDLocationConfig.maxWaitGPSTimeMillis();
        r12 = r11.timeToStartLocationInMillis();
        r13 = r39 - r12;
        goto L34
    L19:
        if (BDLocationConfig.needRevertWifiOrStationInfoUpload(r33.locationOption) == true) goto L22;
        r30 = r1;
        r29 = "com.obric.memorydata.plugin";
        goto L72
    L12:
        if (TextUtils.isEmpty(r10.logId) == true) goto L16;
        r1.addProperty("last_log_id", r10.logId);
        if (BDLocationConfig.enableScanBle() == false) goto L16;
        r1.add("bluetooth_list", JsonUtil.safeToJsonTree(r33.getBleList()));
        goto L16
    L7:
        if (r33.locationOption.startLocationTimestampInMillis <= 0) goto L9;
        r1.addProperty("start_timestamp_ms", Long.valueOf(r33.locationOption.startLocationTimestampInMillis));
        Logger.i("location-trace-core getSubmitUploadBody: add start_timestamp_ms property: " + r33.locationOption.startLocationTimestampInMillis);
        goto L9
    L73:
        r30 = r1;
        r29 = "com.obric.memorydata.plugin";
        goto L74
    }

    private static boolean isBypassBackgroundUpload(LocationUploadExtra r3) {
        boolean r0 = false;
        if (r3 != null) goto L7;
        String r4 = "isBypassBackgroundUpload, extra == null, return false.";
    L5:
        Logger.i(r4);
        return r0;
    L7:
        LocationOption r5 = r3.locationOption;
        if (r5 != null) goto L11;
        r4 = "isBypassBackgroundUpload, option == null, return false.";
        goto L5
    L11:
        if (r5.isOnceLocation() == false) goto L13;
    L15:
        r4 = "isBypassBackgroundUpload, result: " + r0 + ", uploadSource: " + r5.getUploadSource();
        goto L5
    L13:
        if ("bpea-light_navigation".equals(r5.getUploadSource()) == false) goto L15;
        r0 = true;
        goto L15
    }

    private static boolean isDeviceStatusDiffEnoughToTriggerInfoRequest(int r1) {
        if ((r1 & 512) == 0) goto L5;
    L12:
        return true;
    L5:
        if ((r1 & 256) != 0) goto L12;
        if ((r1 & 1) != 0) goto L12;
        if ((r1 & 128) != 0) goto L12;
        return false;
    }

    public static String packFingerprint(JsonObject r0) {
        if (r0 != null) goto L6;
        return null;
    L6:
        return packFingerprint(r0.toString());
    }

    public static String packFingerprint(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L13;
        return null;
    L13:
        byte[] r5 = r4.getBytes("utf-8");     // Catch: Exception -> L10
        int r0 = r5.length;     // Catch: Exception -> L10
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L8;
        r5[r2] = (byte) (r5[r2] ^ (-99));     // Catch: Exception -> L10
        r2 = r2 + 1;     // Catch: Exception -> L10
        goto L6
    L8:
        return Base64.encodeToString(r5, 10);
    L10:
        e = move-exception;
        Logger.i("packFingerprint exception:" + e.toString());
        return null;
    }

    private static JSONObject parseLocationJsonFromScanResults(List<ScanResult> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        JSONObject r0 = new JSONObject();
        JSONArray r2 = new JSONArray();
        r0.put("wifi_info_list", r2);
        Iterator r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        ScanResult r3 = (ScanResult) ZeusTransformUtils.preCheckCast(r10.next(), ScanResult.class, "com.obric.memorydata.plugin");
        JSONObject r4 = new JSONObject();
        r4.put("frequency", r3.frequency);
        r4.put("is_current", 0);
        r4.put("rssi", r3.level);
        if (Build.VERSION.SDK_INT < 17) goto L8;
        r4.put("Timestamp", r3.timestamp);
    L8:
        r4.put("wifi_mac", WifiUtil.getScanResultBSSIDByReflect(r3));
        r4.put("wifi_name", WifiUtil.getScanResultSSIDByReflect(r3));
        r2.put(r4);
        goto L4
    L9:
        return r0;
    }

    public static InfoRequestKeyParams readLastInfoRequestKeyParams() {
        String r0 = ProcessScopedLocationCache.LAST_INFO_REQUEST_KEY_PARAMS_JSON_STR.getString((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "");
        Logger.i("readLastInfoRequestKeyParams, lastInfoRequestKeyParamsJsonStr: " + r0);
        return (InfoRequestKeyParams) ZeusTransformUtils.preCheckCast(JsonUtil.sGson.fromJson(r0, InfoRequestKeyParams.class), InfoRequestKeyParams.class, "com.obric.memorydata.plugin");
    L5:
        th = move-exception;
        th.printStackTrace();
        Logger.e("readLastInfoRequestDeviceStatus failed: " + th, th);
        return null;
    }

    private static void recordLastSuccessInfoRequestParamsIfNeed(LocationResp r5, DeviceStatus r6, InfoRequestExtraLite r7, InfoRequestQPSOptTraceLogger r8) {
        if (BDLocationConfig.enableInfoRequestOpt() == true) goto L8;
        Logger.i("recordLastSuccessInfoRequestParamsIfNeed: info request opt not enabled.");
        String r9 = "settings_not_enable";
    L5:
        r8.putCategoryData(InfoRequestQPSOptTraceLogger.CACHE_FAILED_REASON, r9);
        r8.putCategoryData(InfoRequestQPSOptTraceLogger.IS_CACHE_SUCCESS, false);
        return;
    L8:
        if (r5.resultCode == 0) goto L16;
        Logger.i("recordLastSuccessInfoRequestParamsIfNeed: info request failed, skip record.");
        r9 = "resultCode != 0";
        goto L5
    L16:
        String r10 = JsonUtil.sGson.toJson(new InfoRequestKeyParams(System.currentTimeMillis(), r6, r7));     // Catch: Throwable -> L13
        ProcessScopedLocationCache.LAST_INFO_REQUEST_KEY_PARAMS_JSON_STR.applyString((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r10);     // Catch: Throwable -> L13
        Logger.i("recordLastSuccessInfoRequestParamsIfNeed: " + r10);     // Catch: Throwable -> L13
        r8.putCategoryData(InfoRequestQPSOptTraceLogger.IS_CACHE_SUCCESS, true);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        th.printStackTrace();
        Logger.e("recordLastSuccessInfoRequestParamsIfNeed failed, " + th, th);
        r8.putLogExtra(InfoRequestQPSOptTraceLogger.ERROR_MESSAGE, th.getMessage());
        r8.putCategoryData(InfoRequestQPSOptTraceLogger.IS_CACHE_SUCCESS, false);
    }

    private static boolean shakeSubmitResult(String r6, String r7, String r8, long r9, boolean r11) {
        if (TextUtils.isEmpty(r6) == false) goto L24;
        return false;
    L24:
        LocationResp r10 = (LocationResp) ZeusTransformUtils.preCheckCast(JsonUtil.sGson.fromJson(r6, LocationResp.class), LocationResp.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L17
        if (r10 != null) goto L8;
        return true;
    L8:
        if (r11 == false) goto L10;
        LocationMonitor.doScanRefresh(SystemClock.elapsedRealtime() - r9, r10.resultCode, r10.resultMsg);     // Catch: Exception -> L17
    L12:
        if (r10.resultCode != 0) goto L15;
        Logger.d("BDLocationUPTest UploadSchedule: result", unpackFingerprint(r10.data) + "---end");     // Catch: Exception -> L17
        Logger.i(r7);     // Catch: Exception -> L17
        return true;
    L15:
        Logger.i(r8);     // Catch: Exception -> L17
        return false;
    L10:
        LocationMonitor.doScanUpload(SystemClock.elapsedRealtime() - r9, r10.resultCode, r10.resultMsg);     // Catch: Exception -> L17
    L17:
        e = move-exception;
        long r2 = SystemClock.elapsedRealtime() - r9;
        String r12 = e.getMessage();
        if (r11 == false) goto L21;
        LocationMonitor.doScanRefresh(r2, -1, r12);
    L22:
        e.printStackTrace();
        Logger.e("The exception was occurred when the response data was convert to LocInfoRspData ");
        return false;
    L21:
        LocationMonitor.doScanUpload(r2, -1, r12);
        goto L22
    }

    private static boolean shouldSendInfoRequestBasedOnExtraDiff(InfoRequestExtraLite r6, InfoRequestExtraLite r7, InfoRequestQPSOptTraceLogger r8) {
        Logger.i("shouldSendInfoRequestBasedOnExtraDiff: lastExtra: " + r6 + ", currentExtra: " + r7);
        boolean r1 = false;
        if (r6 != null) goto L8;
        if (r7 != null) goto L8;
        r8.putCategoryData(InfoRequestQPSOptTraceLogger.REASON, "no_diff");
        return false;
    L8:
        if (r6 != null) goto L11;
        r8.putCategoryData(InfoRequestQPSOptTraceLogger.REASON, "no_last_extra");
        return true;
    L11:
        if (r7 != null) goto L15;
        r8.putCategoryData(InfoRequestQPSOptTraceLogger.REASON, "device_status_no_diff_no_new_extra");
        return false;
    L15:
        if (r6.scenePermissionEnable == r7.scenePermissionEnable) goto L17;
    L18:
        r1 = true;
    L19:
        if (r1 == false) goto L21;
        r8.putCategoryData(InfoRequestQPSOptTraceLogger.REASON, "scene_changed");
    L22:
        return r1;
    L21:
        r8.putCategoryData(InfoRequestQPSOptTraceLogger.REASON, "no_diff");
        goto L22
    L17:
        if (Objects.equals(r6.scenes, r7.scenes) == true) goto L19;
        goto L18
    }

    public static String unpackFingerprint(String r4) {
        if (r4 != null) goto L5;
    L13:
        return null;
    L5:
        if (r4.isEmpty() == true) goto L13;
        byte[] r5 = Base64.decode(r4, 2);     // Catch: Exception -> L14
        int r1 = r5.length;     // Catch: Exception -> L14
        int r2 = 0;
    L9:
        if (r2 >= r1) goto L11;
        r5[r2] = (byte) (r5[r2] ^ (-99));     // Catch: Exception -> L14
        r2 = r2 + 1;     // Catch: Exception -> L14
        goto L9
    L11:
        return new String(r5);
    }

    public static LocationResp uploadCacheLocationInfo(DeviceLocation r5, DeviceStatus r6, LocationUploadExtra r7) {
        if (checkoutUploadRule(r7) == false) goto L5;
    L15:
        int r0 = 0;
        if (r7 == null) goto L18;
        r0 = r7.getTriggerType();
    L18:
        JsonObject r8 = getSubmitCacheLocationUploadBody(r5, r6, r7);
        LinkedHashMap r9 = new LinkedHashMap();
        r9.put("locinfo", packFingerprint(r8));
        LinkedHashMap r10 = new LinkedHashMap();
        r10.put("sdk_version", BuildConfig.BDLOCATION_VERSION);
        long r2 = SystemClock.elapsedRealtime();
        SsResponse<String> r11 = NetworkRequestManager.submitPost(LOCATION_CACHE_RELATIVE_PATH, r9, r10, r0, LocationAnnotation.SubmitSource.CACHE_LOCATION);
        if (r11 == null) goto L22;
        LocationResp r12 = analysisLocationResult((String) ZeusTransformUtils.preCheckCast(r11.body(), String.class, "com.obric.memorydata.plugin"));
        Logger.i("ServerApi", "submit cache end network duration is " + (System.currentTimeMillis() - r2));
        return r12;
    L22:
        return null;
    L5:
        if (BDLocationConfig.enableCheckUploadCompliance() == false) goto L10;
        String r13 = "The collection of data is allowed checkoutUploadRule!";
    L7:
        Logger.i(r13);
        return null;
    L10:
        if (BDLocationConfig.enableBackgroundUploadLocation() == true) goto L12;
        r13 = "The current app is in the background, and the upload is not allowed!";
        goto L7
    L12:
        if (r7 == null) goto L14;
        r7.setUploadSource(r7.getUploadSource() + LocationInfoConst.BACKGROUND_UPLOAD);
    L14:
        Logger.i("The current app is in the background, and the upload is allowed!");
        goto L15
    }

    public static LocationResp uploadGpsAndBleInfos(LocationUploadExtra r5) {
        if (LocationUtil.enableUseLocation(true) == false) goto L5;
    L12:
        JsonObject r0 = getGpsAndBleUploadBody(r5);
        if (r0 != null) goto L15;
        String r6 = "uploadGpsAndBleInfos locinfo is null";
    L7:
        Logger.i(r6);
        return null;
    L15:
        LinkedHashMap r2 = new LinkedHashMap();
        String r1 = packFingerprint(r0);
        if (TextUtils.isEmpty(r1) == false) goto L18;
        r6 = "uploadGpsAndBleInfos body is empty";
        goto L7
    L18:
        r2.put("locinfo", r1);
        LinkedHashMap r3 = new LinkedHashMap();
        r3.put("sdk_version", BuildConfig.BDLOCATION_VERSION);
        SsResponse<String> r7 = NetworkRequestManager.submitPost(LOCATION_RELATIVE_PATH, r2, r3, r5.getTriggerType(), LocationAnnotation.SubmitSource.UPLOAD_GPS_BLE);
        if (r7 == null) goto L22;
        LocationResp r8 = analysisLocationResult((String) ZeusTransformUtils.preCheckCast(r7.body(), String.class, "com.obric.memorydata.plugin"));
        Logger.i("uploadGpsAndBleInfos success");
        return r8;
    L22:
        return null;
    L5:
        if (BDLocationConfig.enableCheckUploadCompliance() == false) goto L9;
        r6 = "uploadGpsAndBleInfos locinfo is not allow";
        goto L7
    L9:
        if (r5 == null) goto L11;
        r5.setUploadSource(r5.getUploadSource() + LocationInfoConst.BACKGROUND_UPLOAD);
    L11:
        Logger.i("uploadGpsAndBleInfos background upload");
        goto L12
    }

    public static LocationResp uploadLightLocation(DeviceLocation r5, DeviceStatus r6, LocationUploadExtra r7) {
        JsonObject r8 = getLightUploadBody(r5, r6, r7);
        LinkedHashMap r9 = new LinkedHashMap();
        r9.put("locinfo", packFingerprint(r8));
        LinkedHashMap r10 = new LinkedHashMap();
        r10.put("sdk_version", BuildConfig.BDLOCATION_VERSION);
        long r0 = System.currentTimeMillis();
        SsResponse<String> r11 = NetworkRequestManager.submitPost(LOCATION_RELATIVE_PATH, r9, r10, r7.getTriggerType(), LocationAnnotation.SubmitSource.LIGHT_LOCATION);
        r7.setLightSubmitDuration(System.currentTimeMillis() - r0);
        Logger.i("ServerApi", "end network duration is " + (System.currentTimeMillis() - r0));
        if (r11 != null) goto L5;
        return null;
    L5:
        return analysisLocationResult((String) ZeusTransformUtils.preCheckCast(r11.body(), String.class, "com.obric.memorydata.plugin"));
    }

    public static LocationResp uploadLocationInfoMustInNetworkIOThreadPool(DeviceLocation r2, DeviceStatus r3, LocationUploadExtra r4) {
        if (checkoutUploadRule(r4) == true) goto L16;
        if (BDLocationConfig.enableCheckUploadCompliance() == false) goto L10;
        String r5 = "The collection of data is allowed checkoutUploadRule!";
    L7:
        Logger.i(r5);
        return null;
    L10:
        if (BDLocationConfig.enableBackgroundUploadLocation() == true) goto L12;
        r5 = "The current app is in the background, and the upload is not allowed!";
        goto L7
    L12:
        if (r4 == null) goto L14;
        r4.setUploadSource(r4.getUploadSource() + LocationInfoConst.BACKGROUND_UPLOAD);
    L14:
        Logger.i("The current app is in the background, and the upload is allowed!");
    L16:
        return getLocationInfoMustInNetworkIOThreadPool(r2, r3, r4);
    }

    public static LocationResp uploadMccAndSystemRegionInfo(Context r19, String r20, int r21) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r19, Context.class, "com.obric.memorydata.plugin");
        if (checkoutUploadRule(null) == true) goto L6;
        Logger.i("The collection of data is allowed checkoutUploadRule!");
        return null;
    L6:
        String r5 = BDLocationConfig.getDeviceInfoExtra();
        InfoRequestExtraLite r0 = (InfoRequestExtraLite) ZeusTransformUtils.preCheckCast(JsonUtil.sGson.fromJson(r5, InfoRequestExtraLite.class), InfoRequestExtraLite.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
    L11:
        DeviceStatus r7 = LocationUtil.getDeviceStatus(r3, null);
        JsonElement r2 = JsonUtil.safeToJsonTree(r7);
        InfoRequestQPSOptTraceLogger r8 = new InfoRequestQPSOptTraceLogger();
        r8.begin(InfoRequestQPSOptTraceLogger.SKIP_CHECK_DURATION);
        boolean r9 = canSkipInfoRequest(r7, r0, r8);
        r8.end(InfoRequestQPSOptTraceLogger.SKIP_CHECK_DURATION);
        if (r9 == false) goto L15;
        Logger.i("skip info request, currentDeviceStatus: " + r2 + ", currentDeviceInfoExtra: " + r5);
        r8.putCategoryData("is_skip", true);
        r8.monitorInfoRequestQPSOptEvent();
        LocationMonitor.uploadAuthStatus("info", PermissionManager.checkLocationPermissions(r3, true), LocationUtil.getLocationMode(r3), PermissionManager.checkBluetoothScanPermission(r3), LocationUtil.getbluetoothSwitch() ? 1 : 0, true);
        return null;
    L15:
        r8.putCategoryData("is_skip", false);
        Logger.i("cannot skip info request, continue to send request.");
        JsonObject r4 = new JsonObject();
        if (r20 == null) goto L18;
        r4.addProperty("upload_source", r20);
        Logger.i("uploadMccAndSystemRegionInfo upload_source:" + r20);
    L18:
        r4.add("region_info", JsonUtil.safeToJsonTree(LocationUtil.getRegionInfo(r3)));
        r4.add("status", r2);
        r4.addProperty("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
        r4.addProperty("is_vpn", Boolean.valueOf(LocationUtil.checkVPN()));
        r4.addProperty("is_proxy", Boolean.valueOf(LocationUtil.isProxy()));
        r4.addProperty(WsConstants.KEY_EXTRA, r5);
        Logger.i("submit device:" + JsonUtil.sGson.toJson(r4));
        LinkedHashMap r6 = new LinkedHashMap();
        r6.put("locinfo", packFingerprint(r4));
        LinkedHashMap r10 = new LinkedHashMap();
        r10.put("sdk_version", BuildConfig.BDLOCATION_VERSION);
        boolean r11 = LocationUtil.isBackground();
        long r12 = SystemClock.elapsedRealtime();
        String r13 = NetworkRequestManager.post(INFO_RELATIVE_PATH, r6, r10, r21);
        Logger.i("info result:" + r13);
        LocationMonitor.uploadAuthStatus("info", PermissionManager.checkLocationPermissions(r3, true), LocationUtil.getLocationMode(r3), PermissionManager.checkBluetoothScanPermission(r3), LocationUtil.getbluetoothSwitch() ? 1 : 0, false);
        LocationResp r14 = analysisLocationResult(r13);
        long r15 = SystemClock.elapsedRealtime() - r12;
        if (r14 == null) goto L23;
        LocationMonitor.uploadBaseInfo(r20, r15, r14.resultCode, r14.resultMsg, r11);
        Logger.i("locationmonitor info total duration is: " + (SystemClock.elapsedRealtime() - r12) + "ms");
        if (BDLocationConfig.isRestrictedModeOn() == false) goto L24;
        LocationMonitor.uploadRestrictedInfo(SystemClock.elapsedRealtime() - r12, r14.resultCode, r14.resultMsg);
    L24:
        r8.begin("cache_duration");
        recordLastSuccessInfoRequestParamsIfNeed(r14, r7, r0, r8);
        r8.end("cache_duration");
        r8.monitorInfoRequestQPSOptEvent();
        return r14;
    L23:
        LocationMonitor.uploadBaseInfo(r20, r15, -2, "result is null", r11);
    L9:
        th = move-exception;
        th.printStackTrace();
        Logger.e("parse InfoRequestExtraStr to InfoRequestExtra.class failed, " + th, th);
        r0 = null;
        goto L11
    }

    public static LocationResp uploadRescanWifiInfoMustInNetworkIOThreadPool(DeviceLocation r2, DeviceStatus r3, LocationUploadExtra r4) {
        JsonObject r5 = getSubmitUploadBody(r2, r3, r4, true);
        r5.addProperty("upload_source", r4.getUploadSource());
        r5.addProperty("upload_sensors", LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI);
        LinkedHashMap r6 = new LinkedHashMap();
        r6.put("locinfo", packFingerprint(r5));
        LinkedHashMap r7 = new LinkedHashMap();
        r7.put("sdk_version", BuildConfig.BDLOCATION_VERSION);
        NetworkRequestManager.submitPost(LOCATION_RELATIVE_PATH, r6, r7, r4.getTriggerType(), LocationAnnotation.SubmitSource.RESCAN_WIFI);
        return null;
    }

    public static boolean uploadShakeInfo(ShakeUploadInfo r8, boolean r9, int r10) {
        if (checkoutUploadRule(null) == true) goto L6;
        Logger.i("The collection of data is allowed checkoutUploadRule!");
        return false;
    L6:
        String r11 = JsonUtil.sGson.toJson(r8);
        Logger.i("start submit uploadShakeInfo");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("userloc", packFingerprint(r11));
        LinkedHashMap r12 = new LinkedHashMap();
        r12.put("sdk_version", BuildConfig.BDLOCATION_VERSION);
        Logger.d("ServerApi uploadShakeInfo");
        if (r9 == false) goto L9;
        String r1 = SHAKE_REFRESH_RELATIVE_PATH;
    L10:
        long r5 = SystemClock.elapsedRealtime();
        return shakeSubmitResult(NetworkRequestManager.post(r1, r0, r12, r10), "upload location info success", "upload location info failed", r5, r9);
    L9:
        r1 = SHAKE_RELATIVE_PATH;
        goto L10
    }

    private static String wrapSubmitExtra(String r3) {
    L7:
        th = move-exception;
        th.printStackTrace();
        Logger.e("wrong JSON format, extra: " + r3);
        JSONObject r0 = new JSONObject();
    L9:
        JSONObject r1 = BDLocationConfig.getSubmitExtra();
        r0.put("bdlocation_submit_extra", r1);     // Catch: Throwable -> L12
        return r0.toString();
    L12:
        th = move-exception;
        th.printStackTrace();
        Logger.e("extra put submitExtra failed, submitExtra: " + r1);
        return r3;
    L3:
        if (TextUtils.isEmpty(r3) == false) goto L5;
        r0 = new JSONObject();     // Catch: Throwable -> L7
    L17:
        goto L9
    L5:
        r0 = new JSONObject(r3);     // Catch: Throwable -> L7
        goto L17
    }
}
