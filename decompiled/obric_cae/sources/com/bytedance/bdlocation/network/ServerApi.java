package com.bytedance.bdlocation.network;

import android.aimedia.a;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
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
import com.bytedance.bdlocation.network.model.BaseResp;
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
import com.obric.cae.BWDL.BwdlDrop.provider.BwdlDropProvider;
import com.obric.cae.cloud.CloudServiceConstants;
import com.obric.cae.location.database.StarCellDbManager;
import com.obric.cae.wifi.WiFiDBHelper;
import ha.p;
import ha.s;
import ia.b;
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

        @b("device_status")
        final DeviceStatus deviceStatus;

        @b(WsConstants.KEY_EXTRA)
        final InfoRequestExtraLite extra;

        @b("timestamp")
        final long timestamp;

        public InfoRequestKeyParams(long r8, DeviceStatus r10, InfoRequestExtraLite r11) {
            this.timestamp = r8;
            this.deviceStatus = r10;
            this.extra = r11;
        }
    }

    static {
        WAIT_GPS_INFO_THREAD_COUNT = new AtomicInteger(0);
        sIsFirstUpload = true;
    }

    public ServerApi() {
    }

    private static LocationResp analysisLocationResult(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L11;
        String r10 = "analysisLocationResult networkResponse is null";
    L5:
        Logger.i(r10);
        return null;
    L11:
        return (LocationResp) JsonUtil.sGson.c(LocationResp.class, r8);
    L9:
        e = move-exception;
        r10 = "analysisLocationResult exception:" + e.toString();
        goto L5
    }

    private static void cacheLogId(String r8, long r10) {
        if (TextUtils.isEmpty(r8) == false) goto L7;
        String r11 = "cacheLogId setUploadLogEntity error";
    L5:
        Logger.i(r11);
        return;
    L7:
        LogIdCacheEntity r12 = BDLocationConfig.getLogIdCacheEntity();
        if (r12 != null) goto L10;
        r12 = new LogIdCacheEntity();
        r12.timestamp = r10;
    L13:
        r12.logId = r8;
        Logger.i("cacheLogId logId:" + r8 + "--startLocationTime：" + r10);
        BDLocationConfig.setLogIdCacheEntity(r12);
        r11 = "cacheLogId setUploadLogEntity success";
        goto L5
    L10:
        if (r10 == r12.timestamp) goto L13;
        r11 = "cacheLogId check time error startLocationTime:" + r10 + "--entityTIme:" + r12.timestamp;
        goto L5
    }

    private static boolean canSkipInfoRequest(DeviceStatus r8, InfoRequestExtraLite r10, InfoRequestQPSOptTraceLogger r11) {
        if (BDLocationConfig.enableInfoRequestOpt() == true) goto L6;
        r11.putCategoryData("reason", "settings_not_enable");
        Logger.i("canSkipInfoRequest: false, info request opt not enabled.");
        return false;
    L6:
        String r12 = LocationUtil.allowUseLocation(true, true, false);
        if (TextUtils.equals("1", r12) == true) goto L10;
        Logger.i("canSkipInfoRequest: Location permission is not granted, continue to send info request. authorizationStatus: " + r12);
        r11.putCategoryData("reason", "no_location_permission_" + r12);
        return false;
    L10:
        InfoRequestKeyParams r13 = readLastInfoRequestKeyParams();
        if (r13 != null) goto L26;
        Logger.i("canSkipInfoRequest: lastInfoRequestKeyParams == null, currentInfoRequestExtraLite: " + r10);
        StringBuilder r14 = new StringBuilder("lastInfoRequestKeyParams == null: true, currentDeviceStatus == null: ");
        if (r8 != null) goto L15;
        boolean r15 = true;
    L16:
        r14.append(r15);
        r14.append(", currentInfoRequestExtraLite == null: ");
        if (r10 != null) goto L19;
        boolean r16 = true;
    L20:
        r14.append(r16);
        r11.putCategoryData("reason", r14.toString());
        if (r8 != null) goto L40;
        if (r10 == null) goto L24;
        return false;
    L24:
        return true;
    L40:
        return false;
    L19:
        r16 = false;
        goto L20
    L15:
        r15 = false;
        goto L16
    L26:
        if ((System.currentTimeMillis() - r13.timestamp) <= BDLocationConfig.getInfoRequestKeyParamsMaxCacheTime()) goto L29;
        Logger.i("canSkipInfoRequest: reach info request key params max cache time.");
        r11.putCategoryData("reason", "timeout");
        return false;
    L29:
        DeviceStatus r17 = r13.deviceStatus;
        if (r17 != null) goto L34;
        if (r8 == null) goto L38;
        Logger.i("canSkipInfoRequest: lastInfoRequestDeviceStatus == null && currentDeviceStatus != null");
        r11.putCategoryData("reason", "lastInfoRequestDeviceStatus == null && currentDeviceStatus != null");
        return false;
    L38:
        Logger.i("canSkipInfoRequest: no device status diff, continue to compare scenes permissions");
        return !shouldSendInfoRequestBasedOnExtraDiff(r13.extra, r10, r11);
    L34:
        int r18 = r17.diffWith(r8);
        if (isDeviceStatusDiffEnoughToTriggerInfoRequest(r18) == false) goto L38;
        Logger.i("canSkipInfoRequest: diffResult: " + r18 + " enough to trigger info request.");
        StringBuilder r19 = new StringBuilder("device status diff result: ");
        r19.append(r18);
        r11.putCategoryData("reason", r19.toString());
        return false;
    }

    private static boolean checkoutUploadRule(LocationUploadExtra r8) {
        if (BDLocationConfig.isRestrictedModeOn() == false) goto L8;
        String r10 = "The collection of data is allowed restricted mode off!";
    L5:
        Logger.i(r10);
        return false;
    L8:
        if (isBypassBackgroundUpload(r8) == true) goto L13;
        if (LocationUtil.checkBackground() == false) goto L13;
        r10 = "The collection of data is allowed enter foreground!";
    L13:
        if (BDLocationConfig.isPrivacyConfirmed() == true) goto L15;
        r10 = "The collection of data is allowed after user confirmed the privacy!";
        goto L5
    L15:
        return true;
    }

    public static LocInfoRspData doLightLocationSubmitV2(long r8, String r10, int r11, boolean r12, LBSLightLocationTraceLogger r13, List<ScanResult> r14, String r15) {
        StringBuilder r16 = new StringBuilder("doLightLocationSubmitV2 executed. uploadSource: ");
        r16.append(r10);
        r16.append(", triggerType: ");
        r16.append(r11);
        r16.append(", encryptLocInfo: ");
        r16.append(r12);
        r16.append(", traceLogger is null: ");
        boolean r17 = true;
        if (r13 != null) goto L5;
        boolean r18 = true;
    L6:
        r16.append(r18);
        r16.append(", scanResults is empty: ");
        if (r14 != null) goto L9;
    L12:
        boolean r19 = true;
    L13:
        r16.append(r19);
        Logger.i(r16.toString());
        if (r14 != null) goto L16;
    L44:
        StringBuilder r20 = defpackage.b.h("doLightLocationSubmitV2 failed: invalid params, uploadSource: ", r10, ", scanResults is empty: ");
        if (r14 != null) goto L47;
    L50:
        r20.append(r17);
        String r21 = r20.toString();
        Logger.i(r21);
        throw new BDLocationException(r21, BuildConfig.BDLOCATION_VERSION, BDLocationException.ERROR_CODE_LBS_LIGHT_SUBMITV2_FAILED);
    L47:
        if (r14.isEmpty() == true) goto L50;
        r17 = false;
        goto L50
    L16:
        if (r14.isEmpty() == true) goto L44;
        if (TextUtils.isEmpty(r10) == true) goto L44;
        Logger.i("doLightLocationSubmitV2: start prepare lbs light submit-v2 params.");
        LocationMonitor.lbsLightLocationTraceMetricBegin(r13, LBSLightLocationTraceLogger.NETWORK_REQUEST_PARAMS_PREPARE);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r13, LBSLightLocationTraceLogger.NETWORK_REQUEST_PARAMS_PARSE);
        Logger.i("doLightLocationSubmitV2: before parseLocationJsonFromScanResults");
        JSONObject r110 = parseLocationJsonFromScanResults(r14);
        Logger.i("doLightLocationSubmitV2: after parseLocationJsonFromScanResults");
        LocationMonitor.lbsLightLocationTraceMetricEnd(r13, LBSLightLocationTraceLogger.NETWORK_REQUEST_PARAMS_PARSE);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r13, LBSLightLocationTraceLogger.NETWORK_REQUEST_LOC_INFO);
        JSONObject r22 = new JSONObject();
        r22.put("upload_source", r10 + "_lbslight");
        r22.put("locate_id", r15);
        if (r8 <= 0) goto L23;
        r22.put("start_timestamp_ms", r8);
        Logger.i("location-trace-core doLightLocationSubmitV2: add start_timestamp_ms field: " + r8);
    L23:
        r22.put("upload_sensors", "light_sensor_lbslight");
        r22.put("timestamp", System.currentTimeMillis() / 1000);
        r22.put(LocationMonitorConst.LOCATION, r110);
        JSONObject r23 = new JSONObject();
        r23.put("byte_location_group", BDLocationConfig.getByteLocationLibraParam());
        r22.put("ab_config", r23);
        String r24 = r22.toString();
        LocationMonitor.lbsLightLocationTraceMetricEnd(r13, LBSLightLocationTraceLogger.NETWORK_REQUEST_LOC_INFO);
        Logger.i("doLightLocationSubmitV2: prepare lbs light submit-v2 params finished.");
        LocationMonitor.lbsLightLocationTracePutCategoryData(r13, LBSLightLocationTraceLogger.ENCRYPT_SUBMIT_V2_BODY, Boolean.valueOf(r12));
        if (r12 == false) goto L26;
        LocationMonitor.lbsLightLocationTraceMetricBegin(r13, LBSLightLocationTraceLogger.ENCRYPT);
        r24 = packFingerprint(r24);
        LocationMonitor.lbsLightLocationTraceMetricEnd(r13, LBSLightLocationTraceLogger.ENCRYPT);
    L26:
        LinkedHashMap r25 = new LinkedHashMap();
        r25.put("locinfo", r24);
        LinkedHashMap r26 = new LinkedHashMap();
        r26.put("sdk_version", BuildConfig.BDLOCATION_VERSION);
        LocationMonitor.lbsLightLocationTraceMetricEnd(r13, LBSLightLocationTraceLogger.NETWORK_REQUEST_PARAMS_PREPARE);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r13, LBSLightLocationTraceLogger.SUBMIT_V2_REQUEST);
        SsResponse<String> r27 = NetworkRequestManager.submitPost(LOCATION_RELATIVE_PATH, r25, r26, r11, LocationAnnotation.SubmitSource.LIGHT_LOCATION_SUBMIT_V2);
        LocationMonitor.lbsLightLocationTraceMetricEnd(r13, LBSLightLocationTraceLogger.SUBMIT_V2_REQUEST);
        LocationMonitor.lbsLightLocationTraceMetricEnd(r13, LBSLightLocationTraceLogger.NETWORK_TOTAL);
        LocationMonitor.lbsLightLocationTraceMetricEnd(r13, LBSLightLocationTraceLogger.TOTAL);
        if (r27 == null) goto L43;
        String r28 = getLogId(r27);
        LocationMonitor.lbsLightLocationTracePutLogExtra(r13, LBSLightLocationTraceLogger.SUBMIT_V2_LOG_ID, r28);
        LocationResp r29 = analysisLocationResult(r27.body());
        if (r29 == null) goto L36;
        r29.submitLogId = r28;
        if (r29.resultCode != 0) goto L36;
        Logger.i("doLightLocationSubmitV2 success.");
        LocInfoRspData r30 = LocationUtil.parseLocInfoRsp(r29);
        if (r13 == null) goto L35;
        r13.reportLBSLightLocationSuccess(r30);
    L35:
        return r30;
    L36:
        Logger.i("doLightLocationSubmitV2 failed: locationResp == null || locationResp.resultCode != 0, submitLogId: " + r28);
        StringBuilder r111 = new StringBuilder("lbs light submit-v2 failed: locationResp invalid: ");
        if (r29 != null) goto L39;
        String r31 = "null";
    L40:
        r111.append(r31);
        throw new BDLocationException(r111.toString(), LocationInfoConst.BDLOCATION, BDLocationException.ERROR_CODE_LBS_LIGHT_SUBMITV2_FAILED);
    L39:
        r31 = r29.toMonitorString();
        goto L40
    L43:
        throw new BDLocationException("doLightLocationSubmitV2 failed: ssResponse == null", LocationInfoConst.BDLOCATION, BDLocationException.ERROR_CODE_LBS_LIGHT_SUBMITV2_FAILED);
    L9:
        if (r14.isEmpty() == true) goto L12;
        r19 = false;
        goto L13
    L5:
        r18 = false;
        goto L6
    }

    public static BdGisResult getGisResult(double r8, double r10, int r11, int r12) {
        if (checkoutUploadRule(null) == true) goto L7;
        String r13 = "The collection of data is allowed checkoutUploadRule!";
    L5:
        Logger.i(r13);
        return null;
    L7:
        LinkedHashMap r14 = new LinkedHashMap();
        r14.put(StarCellDbManager.CellInfoEntry.LONGITUDE, Double.valueOf(r10));
        r14.put("latitude", Double.valueOf(r8));
        Locale r15 = BDLocationConfig.getLocale();
        if (r15 != null) goto L10;
        r15 = Locale.getDefault();
    L10:
        r14.put("language", LocationUtil.languageTag(r15));
        String r16 = BDLocationConfig.getWorldView();
        if (TextUtils.isEmpty(r16) == true) goto L13;
        r14.put("worldview", r16);
    L13:
        r14.put("extension", Integer.valueOf(r12));
        String r17 = packFingerprint(JsonUtil.sGson.j(r14));
        HashMap r18 = new HashMap();
        r18.put("resolve_gps", r17);
        long r19 = SystemClock.elapsedRealtime();
        EncryptedBDGisResult r20 = (EncryptedBDGisResult) JsonUtil.sGson.c(EncryptedBDGisResult.class, NetworkRequestManager.post(REVERSE_GEOLOCATION_PATH, r18, null, r11));     // Catch: Exception -> L28
        if (r20 != null) goto L19;
        Logger.e("getGisResult failed: result == null");     // Catch: Exception -> L28
        return null;
    L19:
        if (r20.errorCode == 0) goto L22;
        Logger.i("getGisResult failed, errorCode: " + r20.errorCode + ", errorMessage: " + r20.errorMessage + ", errorTips: " + r20.errorTips);     // Catch: Exception -> L28
        return null;
    L22:
        BdGisResult r21 = (BdGisResult) JsonUtil.sGson.c(BdGisResult.class, unpackFingerprint(r20.data));     // Catch: Exception -> L28
        if (r21 != null) goto L25;
    L27:
        return r21;
    L25:
        if (r21.baseResp == null) goto L27;
        long r22 = SystemClock.elapsedRealtime() - r19;     // Catch: Exception -> L28
        BaseResp r23 = r21.baseResp;     // Catch: Exception -> L28
        LocationMonitor.doGis(r22, r23.statusCode, r23.statusMessage, 1);     // Catch: Exception -> L28
    L28:
        e = move-exception;
        LocationMonitor.doGis(SystemClock.elapsedRealtime() - r19, -1, e.getMessage(), 1);
        r13 = "getGisResult Exception:" + e.toString();
        goto L5
    }

    public static BdGisResult getGisResultOld(double r8, double r10, int r11, int r12) {
        if (checkoutUploadRule(null) == true) goto L7;
        String r13 = "The collection of data is allowed checkoutUploadRule!";
    L5:
        Logger.i(r13);
        return null;
    L7:
        LinkedHashMap r14 = new LinkedHashMap();
        r14.put(StarCellDbManager.CellInfoEntry.LONGITUDE, String.valueOf(r10));
        r14.put("latitude", String.valueOf(r8));
        Locale r15 = BDLocationConfig.getLocale();
        if (r15 != null) goto L10;
        r15 = Locale.getDefault();
    L10:
        r14.put("language", LocationUtil.languageTag(r15));
        String r16 = BDLocationConfig.getWorldView();
        if (TextUtils.isEmpty(r16) == true) goto L13;
        r14.put("worldview", r16);
    L13:
        r14.put("extension", String.valueOf(r12));
        long r17 = SystemClock.elapsedRealtime();
        BdGisResult r18 = (BdGisResult) JsonUtil.sGson.c(BdGisResult.class, NetworkRequestManager.get(GIS_RELATIVE_PATH, r14, r11));     // Catch: Exception -> L20
        if (r18 != null) goto L17;
    L19:
        return r18;
    L17:
        if (r18.baseResp == null) goto L19;
        long r19 = SystemClock.elapsedRealtime() - r17;     // Catch: Exception -> L20
        BaseResp r20 = r18.baseResp;     // Catch: Exception -> L20
        LocationMonitor.doGis(r19, r20.statusCode, r20.statusMessage, 0);     // Catch: Exception -> L20
    L20:
        e = move-exception;
        LocationMonitor.doGis(SystemClock.elapsedRealtime() - r17, -1, e.getMessage(), 0);
        r13 = "getGisResult Exception:" + e.toString();
        goto L5
    }

    private static s getGpsAndBleUploadBody(LocationUploadExtra r8) {
        BDGpsInfo r10 = null;
        if (r8 != null) goto L6;
        Logger.i("getGpsAndBleUploadBody extra is null");
        return null;
    L6:
        s r11 = new s();
        r11.n("upload_source", r8.getUploadSource());
        r11.n("locate_id", r8.getLocateId());
        if (r8.locationOption != null) goto L9;
    L11:
        String r12 = r8.getGpsAndBleMark();
        r11.n("upload_sensors", r12);
        LogIdCacheEntity r13 = r8.getLogIdCache();
        if (BDLocationConfig.enableUploadLastLogId() == false) goto L17;
        if (r13 != null) goto L15;
    L56:
        s r14 = new s();
        r14.n("byte_location_group", BDLocationConfig.getByteLocationLibraParam());
        r11.k("ab_config", r14);
        r11.m("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
        return r11;
    L15:
        if (TextUtils.isEmpty(r13.logId) == true) goto L56;
    L17:
        if (BDLocationConfig.enableUploadLastLogId() == false) goto L20;
        r11.n("last_log_id", r13.logId);
    L20:
        if (BDLocationConfig.enableScanBle() == false) goto L29;
        if (TextUtils.isEmpty(r12) == true) goto L29;
        if (CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_LE.equals(r12) == false) goto L26;
    L27:
        r11.k("bluetooth_list", JsonUtil.safeToJsonTree(r8.getBleList()));
        goto L29
    L26:
        if ("ble_gps".equals(r12) == true) goto L27;
    L29:
        if (BDLocationConfig.isEnableGpsScan() == false) goto L56;
        if (TextUtils.isEmpty(r12) == true) goto L56;
        if (CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS.equals(r12) == false) goto L35;
    L36:
        r11.k("upload_gps", JsonUtil.safeToJsonTree(r8.getGpsInfo(BDScanLocationInfo.TakeStrategy.firstResult)));
        if (r8.isContinuousGpsInfo() == true) goto L39;
    L55:
        DeviceLocation r15 = new DeviceLocation();
        r15.sysLocation = r8.getSysLocation();
        r15.aMapLocation = r8.getAMapLocation();
        r11.k(LocationMonitorConst.LOCATION, JsonUtil.safeToJsonTree(r15));
        goto L56
    L39:
        if (BDLocationConfig.isCollectContinuousGpsOnlyLast() == false) goto L51;
        List<BDGpsInfo> r16 = r8.getGpsInfoList();
        ArrayList r17 = new ArrayList();
        if (r16.isEmpty() == true) goto L43;
        r10 = r16.get(r16.size() - 1);
        r17.add(r10);
    L43:
        r11.k("upload_gps_list", JsonUtil.safeToJsonTree(r17));
        if (BDLocationConfig.isCollectContinuousGpsDisableGnssUpload() == true) goto L55;
        ArrayList r18 = new ArrayList();
        if (r10 == null) goto L50;
        BDGnssInfo r19 = r8.findNearbyGnssInfo(r10);
        if (r19 == null) goto L50;
        r18.add(r19);
    L50:
        p r20 = JsonUtil.safeToJsonTree(r18);
    L54:
        r11.k("upload_gnss_list", r20);
        goto L55
    L51:
        r11.k("upload_gps_list", JsonUtil.safeToJsonTree(r8.getGpsInfoList()));
        if (BDLocationConfig.isCollectContinuousGpsDisableGnssUpload() == true) goto L55;
        r20 = JsonUtil.safeToJsonTree(r8.getGnssInfoList());
        goto L54
    L35:
        if ("ble_gps".equals(r12) == false) goto L56;
    L9:
        if (r8.locationOption.startLocationTimestampInMillis <= 0) goto L11;
        r11.m("start_timestamp_ms", Long.valueOf(r8.locationOption.startLocationTimestampInMillis));
        Logger.i("location-trace-core getGpsAndBleUploadBody: add start_timestamp_ms property: " + r8.locationOption.startLocationTimestampInMillis);
        goto L11
    }

    public static LocationResult getIPResult(int r8) {
        if (checkoutUploadRule(null) == true) goto L6;
        Logger.i("The collection of data is allowed checkoutUploadRule!");
        return null;
    L6:
        LinkedHashMap r10 = new LinkedHashMap();
        r10.put("dwinfo", packFingerprint(new s()));
        LinkedHashMap r11 = new LinkedHashMap();
        r11.put("sdk_version", BuildConfig.BDLOCATION_VERSION);
        long r12 = SystemClock.elapsedRealtime();
        JSONObject r13 = new JSONObject(NetworkRequestManager.post(GEOCODE_RELATIVE_PATH, r10, r11, r8));     // Catch: Exception -> L11
        int r14 = r13.optInt("err_no");     // Catch: Exception -> L11
        String r15 = r13.optString(LocationMonitorConst.ERR_MSG);     // Catch: Exception -> L11
        LocationMonitor.doGeocode(SystemClock.elapsedRealtime() - r12, r14, r15);     // Catch: Exception -> L11
        if (r14 != 0) goto L13;
        String r16 = r13.getString("data");     // Catch: Exception -> L11
        return (LocationResult) JsonUtil.sGson.c(LocationResult.class, unpackFingerprint(r16));
    L13:
        return null;
    L11:
        e = move-exception;
        LocationMonitor.doGeocode(SystemClock.elapsedRealtime() - r12, -2, e.getMessage());
        e.printStackTrace();
        goto L13
    }

    private static s getLightUploadBody(DeviceLocation r8, DeviceStatus r10, LocationUploadExtra r11) {
        s r12 = new s();
        if (r11 == null) goto L5;
        r12.n("upload_source", r11.getUploadSource());
        r12.n("upload_sensors", "light_sensor");
    L5:
        r12.k(LocationMonitorConst.LOCATION, JsonUtil.safeToJsonTree(r8));
        r12.k("status", JsonUtil.safeToJsonTree(r10));
        r12.n("language", LocationUtil.getLanguage());
        r12.n("world_view", BDLocationConfig.getWorldView());
        r12.m("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
        return r12;
    }

    public static LocationResp getLocationInfoMustInNetworkIOThreadPool(DeviceLocation r18, DeviceStatus r19, LocationUploadExtra r20) {
        LocationTraceLogger r8 = r20.getLocationTraceLogger();
        LocationMonitor.locationTraceLogBegin(r8, LocationMonitorConst.SUBMIT_V2_DURATION);
        s r10 = getSubmitUploadBody(r18, r19, r20, true);
        LinkedHashMap r11 = new LinkedHashMap();
        r11.put("locinfo", packFingerprint(r10));
        LinkedHashMap r12 = new LinkedHashMap();
        r12.put("sdk_version", BuildConfig.BDLOCATION_VERSION);
        long r13 = SystemClock.elapsedRealtime();
        if (sIsFirstUpload == false) goto L5;
        LocationMonitor.doFirstSubmitDuration(r13 - BDLocationConfig.getInitStartTime());
        Logger.i("locationmonitor first submit duration is: " + (r13 - BDLocationConfig.getInitStartTime()) + "ms");
        sIsFirstUpload = false;
    L5:
        boolean r14 = LocationUtil.isBackground();
        SsResponse<String> r15 = NetworkRequestManager.submitPost(LOCATION_RELATIVE_PATH, r11, r12, r20.getTriggerType(), LocationAnnotation.SubmitSource.FULL_LOCATION);
        LocationMonitor.uploadAuthStatus(LocationMonitorConst.SUBMIT, PermissionManager.checkLocationPermissions(BDLocationConfig.getContext(), true), LocationUtil.getLocationMode(BDLocationConfig.getContext()), PermissionManager.checkBluetoothScanPermission(BDLocationConfig.getContext()), LocationUtil.getbluetoothSwitch() ? 1 : 0, false);
        if (r15 == null) goto L23;
        String r16 = getLogId(r15);
        cacheLogId(r16, r20.getStartLocationTime());
        if (BDLocationConfig.enableCheckLastLogId() == true) goto L17;
        LogIdCacheEntity r17 = r20.getLogIdCache();
        if (r17 == null) goto L12;
        r17.logId = r16;
        r17.timestamp = r20.getStartLocationTime();
    L12:
        StringBuilder r110 = new StringBuilder("getLocationInfo ");
        if (r17 != null) goto L15;
        String r21 = "logIdCacheEntity = null";
    L16:
        r110.append(r21);
        Logger.i(r110.toString());
        goto L17
    L15:
        r21 = "logIdCacheEntity.logId: " + r17.logId + ", logIdCacheEntity.timestamp: " + r17.timestamp;
    L17:
        LocationResp r22 = analysisLocationResult(r15.body());
        if (r22 == null) goto L20;
        r22.submitLogId = r16;
        LocationMonitor.doSubmit(SystemClock.elapsedRealtime() - r13, r22.resultCode, r22.resultMsg, r14);
        Logger.i("locationmonitor submit total duration is: " + (SystemClock.elapsedRealtime() - r13) + "ms");
    L21:
        LocationMonitor.locationTraceLogEnd(r8, LocationMonitorConst.SUBMIT_V2_DURATION);
        Logger.i("ServerApi", "end network duration is " + (System.currentTimeMillis() - r13));
        ScanWifiStrategy.INSTANCE.checkScanWifiStrategy(r22, r18, r19, r20);
        return r22;
    L20:
        LocationMonitor.doSubmit(SystemClock.elapsedRealtime() - r13, -2, "result is null", r14);
        goto L21
    L23:
        LocationMonitor.locationTraceLogEnd(r8, LocationMonitorConst.SUBMIT_V2_DURATION);
        return null;
    }

    private static String getLogId(SsResponse<String> r8) {
        if (r8 != null) goto L5;
    L14:
        String r10 = "getLogId ssResponse error";
    L10:
        Logger.i(r10);
        return "";
    L5:
        if (r8.raw() == null) goto L14;
        Header r11 = r8.raw().getFirstHeader("X-Tt-Logid");
        if (r11 != null) goto L13;
        r10 = "getLogId firstHeader error";
        goto L10
    L13:
        return r11.getValue();
    }

    private static s getSubmitCacheLocationUploadBody(DeviceLocation r8, DeviceStatus r10, LocationUploadExtra r11) {
        s r12 = new s();
        StationarySceneCacheInfo r13 = LocationCache.getInstance().getStationarySceneCacheInfo();
        if (r11 == null) goto L5;
        String r14 = r11.getUploadSource();
        r12.m("upload_interval", Long.valueOf(r11.getUploadInterval()));
        r12.n("upload_source", r14);
        r12.n("locate_id", r11.getLocateId());
        r12.m("start_timestamp_ms", Long.valueOf(r11.getStartLocationTimestampInMillis()));
        String r15 = r11.getExtra();
        String r16 = wrapSubmitExtra(r15);
        Logger.i("getSubmitCacheLocationUploadBody: originExtraStr: " + r15 + ", wrappedExtraStr: " + r16);
        r12.n(WsConstants.KEY_EXTRA, r16);
        Logger.i("getLocationInfo upload_source:" + r14 + "-upload_interval:-extra:" + r11.getExtra());
    L5:
        if (r13 == null) goto L7;
        r12.k("upload_gps", JsonUtil.safeToJsonTree(r13.getGpsInfo()));
        r12.k("result_location_cache", JsonUtil.safeToJsonTree(r13.getLocationResult()));
    L7:
        r12.k(LocationMonitorConst.LOCATION, JsonUtil.safeToJsonTree(r8));
        r12.k("status", JsonUtil.safeToJsonTree(r10));
        r12.n("language", LocationUtil.getLanguage());
        r12.n("world_view", BDLocationConfig.getWorldView());
        r12.l("is_vpn", Boolean.valueOf(LocationUtil.checkVPN()));
        r12.l("is_proxy", Boolean.valueOf(LocationUtil.isProxy()));
        if (BDLocationConfig.isEnableHARCollect() == false) goto L10;
        r12.k("har_status_list", JsonUtil.safeToJsonTree(LocationUtil.getHARStatusList()));
        r12.m("har_status_max", Integer.valueOf(LocationUtil.getMaxHARStatus()));
    L10:
        r12.m("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
        NetworkAbilityEntity r17 = new NetworkUtil().getNetworkAbility(BDLocationConfig.getContext());
        if (r17 == null) goto L13;
        r12.k("network_capabilities", JsonUtil.safeToJsonTree(r17.netCapabilityList));
        r12.k("network_transports", JsonUtil.safeToJsonTree(r17.netTransportList));
    L13:
        return r12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2, types: [int] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r3v17, types: [java.lang.StringBuilder] */
    private static s getSubmitUploadBody(DeviceLocation r28, DeviceStatus r29, LocationUploadExtra r30, boolean r31) {
        s r8 = new s();
        boolean r10 = true;
        if (r30 == null) goto L73;
        String r11 = r30.getLocateId();
        String r12 = r30.getUploadSource();
        boolean r13 = r30.isOnceLocation();
        r8.m("upload_interval", Long.valueOf(r30.getUploadInterval()));
        r8.n("upload_source", r12);
        r8.n("locate_id", r11);
        long r14 = 0;
        if (r30.locationOption != null) goto L7;
    L9:
        r8.l("latest_admin_version", Boolean.valueOf(r30.isLatestAdminVersion()));
        String r15 = r30.getExtra();
        String r16 = wrapSubmitExtra(r15);
        Logger.i("getSubmitUploadBody: originExtraStr: " + r15 + ", wrappedExtraStr: " + r16);
        r8.n(WsConstants.KEY_EXTRA, r16);
        LogIdCacheEntity r17 = r30.getLogIdCache();
        if (r17 != null) goto L12;
    L16:
        Logger.i("getLocationInfo upload_source:" + r30.getUploadSource() + "-upload_interval:" + r30.getUploadInterval() + "-extra:" + r30.getExtra());
        if (LocationUtil.isUseByteLocationPolicyV2(r12) == false) goto L19;
    L22:
        LocationOption r18 = r30.locationOption;
        if (r18 != null) goto L25;
    L30:
        if (r18 != null) goto L32;
        long r19 = 0;
    L33:
        long r20 = 0;
    L34:
        long r110 = r19;
        Logger.i("location-trace-core before wait, time to start location: " + r110);
        long r111 = SystemClock.elapsedRealtime();
        int r21 = WAIT_GPS_INFO_THREAD_COUNT.getAndIncrement();
        if (r20 > 0) goto L37;
    L39:
        BDGpsInfo r22 = r30.waitGpsInfo(r14, BDScanLocationInfo.TakeStrategy.lastResult);
        if (r22 == null) goto L53;
        if (r18 == null) goto L45;
        StationarySceneCacheInfo r112 = r18.getStationarySceneCacheInfo();
        if (r112 == null) goto L45;
        r112.setGpsInfo(r22);
    L45:
        r8.k("upload_gps", JsonUtil.safeToJsonTree(r22));
        Logger.i("location-trace-core steal gps info success.");
        List<BDGpsInfo> r113 = r30.getGpsInfoList();
        int r114 = r113.size() - 1;
    L46:
        if (r114 < 0) goto L51;
        LocationOption r115 = r18;
        s r23 = r8;
        if (r113.get(r114).realTimestamp == r22.realTimestamp) goto L49;
        r114 = r114 - 1;
        r10 = true;
        r8 = r23;
        r18 = r115;
        goto L46
    L49:
        boolean r24 = true;
        int r116 = r114 + 1;
    L52:
        boolean r25 = r24;
    L54:
        long r26 = SystemClock.elapsedRealtime() - r111;
        int r117 = WAIT_GPS_INFO_THREAD_COUNT.decrementAndGet();
        if (r115 != null) goto L57;
        ?? r118 = -1;
    L61:
        Logger.i("location-trace-core ServerApi.getSubmitUploadBody, realWaitTime: " + r26 + ", maxWaitTime: " + r14 + ", before wait count: " + r21 + ", after wait count: " + r117 + ", downgrade location: " + r118);
        LocationInfo r27 = r30.getSysLocation();
        if (r27 != null) goto L64;
    L66:
        boolean r210 = false;
    L67:
        long r119 = BDLocationConfig.maxWaitGPSTimeMillis();
        if (r115 == null) goto L70;
        boolean r211 = r24;
    L71:
        s r32 = r23;
        LocationMonitor.monitorByteLocationStealGpsInfoAndSysLocation(r21, r117, r118, r110, r119, r14, r26, r25, r210, r211, r30.isContinuousGpsInfo(), r30.getContinuousGpsConfigCategory(), r116);
    L72:
        r10 = r13;
    L74:
        if (r10 == false) goto L76;
        s r33 = new s();
        r33.n("byte_location_group", BDLocationConfig.getByteLocationLibraParam());
        r32.k("ab_config", r33);
    L76:
        r32.k(LocationMonitorConst.LOCATION, JsonUtil.safeToJsonTree(r28));
        r32.k("status", JsonUtil.safeToJsonTree(r29));
        r32.n("language", LocationUtil.getLanguage());
        r32.n("world_view", BDLocationConfig.getWorldView());
        r32.l("is_vpn", Boolean.valueOf(LocationUtil.checkVPN()));
        r32.l("is_proxy", Boolean.valueOf(LocationUtil.isProxy()));
        if (BDLocationConfig.isEnableHARCollect() == false) goto L79;
        r32.k("har_status_list", JsonUtil.safeToJsonTree(LocationUtil.getHARStatusList()));
        r32.m("har_status_max", Integer.valueOf(LocationUtil.getMaxHARStatus()));
    L79:
        r32.m("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
        NetworkAbilityEntity r34 = new NetworkUtil().getNetworkAbility(BDLocationConfig.getContext());
        if (r34 == null) goto L82;
        r32.k("network_capabilities", JsonUtil.safeToJsonTree(r34.netCapabilityList));
        r32.k("network_transports", JsonUtil.safeToJsonTree(r34.netTransportList));
    L82:
        return r32;
    L70:
        r211 = false;
        goto L71
    L64:
        if (BDLocationConfig.isRevertToSystemLocation() == true) goto L66;
        r28.sysLocation = r27;
        r210 = r24;
        goto L67
    L57:
        if (r115.isDownGradeLocation() == false) goto L59;
        r118 = r24;
        goto L61
    L59:
        r118 = 0;
        goto L61
    L51:
        r23 = r8;
        r24 = r10;
        r115 = r18;
        r116 = 0;
        goto L52
    L53:
        r23 = r8;
        r24 = true;
        r115 = r18;
        Logger.i("location-trace-core steal gps info failed.");
        r116 = 0;
        r25 = false;
        goto L54
    L37:
        if (r20 > BDLocationConfig.maxWaitGPSTimeMillis()) goto L39;
        r14 = r20;
        goto L39
    L32:
        r19 = r18.timeToStartLocationInMillis();
        goto L33
    L25:
        if (r18.isDownGradeLocation() == true) goto L30;
        if (r31 == false) goto L30;
        if (Looper.myLooper() == Looper.getMainLooper()) goto L30;
        long r35 = BDLocationConfig.maxWaitGPSTimeMillis();
        r19 = r18.timeToStartLocationInMillis();
        r20 = r35 - r19;
        goto L34
    L19:
        if (BDLocationConfig.needRevertWifiOrStationInfoUpload(r30.locationOption) == true) goto L22;
        r32 = r8;
        goto L72
    L12:
        if (TextUtils.isEmpty(r17.logId) == true) goto L16;
        r8.n("last_log_id", r17.logId);
        if (BDLocationConfig.enableScanBle() == false) goto L16;
        r8.k("bluetooth_list", JsonUtil.safeToJsonTree(r30.getBleList()));
        goto L16
    L7:
        if (r30.locationOption.startLocationTimestampInMillis <= 0) goto L9;
        r8.m("start_timestamp_ms", Long.valueOf(r30.locationOption.startLocationTimestampInMillis));
        Logger.i("location-trace-core getSubmitUploadBody: add start_timestamp_ms property: " + r30.locationOption.startLocationTimestampInMillis);
        goto L9
    L73:
        r32 = r8;
        goto L74
    }

    private static boolean isBypassBackgroundUpload(LocationUploadExtra r8) {
        boolean r10 = false;
        if (r8 != null) goto L5;
        String r11 = "isBypassBackgroundUpload, extra == null, return false.";
    L14:
        Logger.i(r11);
        return r10;
    L5:
        LocationOption r12 = r8.locationOption;
        if (r12 != null) goto L9;
        r11 = "isBypassBackgroundUpload, option == null, return false.";
        goto L14
    L9:
        if (r12.isOnceLocation() == false) goto L11;
    L13:
        StringBuilder r13 = a.l("isBypassBackgroundUpload, result: ", r10, ", uploadSource: ");
        r13.append(r12.getUploadSource());
        r11 = r13.toString();
        goto L14
    L11:
        if ("bpea-light_navigation".equals(r12.getUploadSource()) == false) goto L13;
        r10 = true;
        goto L13
    }

    private static boolean isDeviceStatusDiffEnoughToTriggerInfoRequest(int r8) {
        if ((r8 & 512) == 0) goto L5;
    L12:
        return true;
    L5:
        if ((r8 & 256) != 0) goto L12;
        if ((r8 & 1) != 0) goto L12;
        if ((r8 & 128) != 0) goto L12;
        return false;
    }

    public static String packFingerprint(s r8) {
        if (r8 != null) goto L6;
        return null;
    L6:
        return packFingerprint(r8.toString());
    }

    private static JSONObject parseLocationJsonFromScanResults(List<ScanResult> r8) {
        JSONObject r10 = new JSONObject();
        JSONArray r11 = new JSONArray();
        r10.put("wifi_info_list", r11);
        Iterator<ScanResult> r12 = r8.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        ScanResult r13 = r12.next();
        JSONObject r14 = new JSONObject();
        r14.put("frequency", r13.frequency);
        r14.put("is_current", 0);
        r14.put(WiFiDBHelper.COL_RSSI, r13.level);
        r14.put(BwdlDropProvider.BwdlDropEntry.TIMESTAMP, r13.timestamp);
        r14.put("wifi_mac", WifiUtil.getScanResultBSSIDByReflect(r13));
        r14.put("wifi_name", WifiUtil.getScanResultSSIDByReflect(r13));
        r11.put(r14);
        goto L4
    L6:
        return r10;
    }

    public static InfoRequestKeyParams readLastInfoRequestKeyParams() {
        String r8 = ProcessScopedLocationCache.LAST_INFO_REQUEST_KEY_PARAMS_JSON_STR.getString(BDLocationConfig.getContext(), "");
        Logger.i("readLastInfoRequestKeyParams, lastInfoRequestKeyParamsJsonStr: " + r8);
        return (InfoRequestKeyParams) JsonUtil.sGson.c(InfoRequestKeyParams.class, r8);
    L5:
        th = move-exception;
        th.printStackTrace();
        Logger.e("readLastInfoRequestDeviceStatus failed: " + th, th);
        return null;
    }

    private static void recordLastSuccessInfoRequestParamsIfNeed(LocationResp r8, DeviceStatus r10, InfoRequestExtraLite r11, InfoRequestQPSOptTraceLogger r12) {
        if (BDLocationConfig.enableInfoRequestOpt() == true) goto L8;
        Logger.i("recordLastSuccessInfoRequestParamsIfNeed: info request opt not enabled.");
        String r13 = "settings_not_enable";
    L5:
        r12.putCategoryData(InfoRequestQPSOptTraceLogger.CACHE_FAILED_REASON, r13);
        r12.putCategoryData(InfoRequestQPSOptTraceLogger.IS_CACHE_SUCCESS, Boolean.FALSE);
        return;
    L8:
        if (r8.resultCode == 0) goto L16;
        Logger.i("recordLastSuccessInfoRequestParamsIfNeed: info request failed, skip record.");
        r13 = "resultCode != 0";
        goto L5
    L16:
        String r14 = JsonUtil.sGson.j(new InfoRequestKeyParams(System.currentTimeMillis(), r10, r11));     // Catch: Throwable -> L13
        ProcessScopedLocationCache.LAST_INFO_REQUEST_KEY_PARAMS_JSON_STR.applyString(BDLocationConfig.getContext(), r14);     // Catch: Throwable -> L13
        Logger.i("recordLastSuccessInfoRequestParamsIfNeed: " + r14);     // Catch: Throwable -> L13
        r12.putCategoryData(InfoRequestQPSOptTraceLogger.IS_CACHE_SUCCESS, Boolean.TRUE);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        th.printStackTrace();
        Logger.e("recordLastSuccessInfoRequestParamsIfNeed failed, " + th, th);
        r12.putLogExtra("error_message", th.getMessage());
        r12.putCategoryData(InfoRequestQPSOptTraceLogger.IS_CACHE_SUCCESS, Boolean.FALSE);
    }

    private static boolean shakeSubmitResult(String r8, String r10, String r11, long r12, boolean r13) {
        if (TextUtils.isEmpty(r8) == false) goto L24;
        return false;
    L24:
        LocationResp r14 = (LocationResp) JsonUtil.sGson.c(LocationResp.class, r8);     // Catch: Exception -> L17
        if (r14 != null) goto L8;
        return true;
    L8:
        if (r13 == false) goto L10;
        LocationMonitor.doScanRefresh(SystemClock.elapsedRealtime() - r12, r14.resultCode, r14.resultMsg);     // Catch: Exception -> L17
    L12:
        if (r14.resultCode != 0) goto L15;
        Logger.d("BDLocationUPTest UploadSchedule: result", unpackFingerprint(r14.data) + "---end");     // Catch: Exception -> L17
        Logger.i(r10);     // Catch: Exception -> L17
        return true;
    L15:
        Logger.i(r11);     // Catch: Exception -> L17
        return false;
    L10:
        LocationMonitor.doScanUpload(SystemClock.elapsedRealtime() - r12, r14.resultCode, r14.resultMsg);     // Catch: Exception -> L17
    L17:
        e = move-exception;
        long r15 = SystemClock.elapsedRealtime() - r12;
        String r16 = e.getMessage();
        if (r13 == false) goto L21;
        LocationMonitor.doScanRefresh(r15, -1, r16);
    L22:
        e.printStackTrace();
        Logger.e("The exception was occurred when the response data was convert to LocInfoRspData ");
        return false;
    L21:
        LocationMonitor.doScanUpload(r15, -1, r16);
        goto L22
    }

    private static boolean shouldSendInfoRequestBasedOnExtraDiff(InfoRequestExtraLite r8, InfoRequestExtraLite r10, InfoRequestQPSOptTraceLogger r11) {
        Logger.i("shouldSendInfoRequestBasedOnExtraDiff: lastExtra: " + r8 + ", currentExtra: " + r10);
        boolean r12 = false;
        if (r8 != null) goto L8;
        if (r10 != null) goto L8;
        r11.putCategoryData("reason", "no_diff");
        return false;
    L8:
        if (r8 != null) goto L11;
        r11.putCategoryData("reason", "no_last_extra");
        return true;
    L11:
        if (r10 != null) goto L15;
        r11.putCategoryData("reason", "device_status_no_diff_no_new_extra");
        return false;
    L15:
        if (r8.scenePermissionEnable == r10.scenePermissionEnable) goto L17;
    L18:
        r12 = true;
    L19:
        if (r12 == false) goto L21;
        r11.putCategoryData("reason", "scene_changed");
    L22:
        return r12;
    L21:
        r11.putCategoryData("reason", "no_diff");
        goto L22
    L17:
        if (Objects.equals(r8.scenes, r10.scenes) == true) goto L19;
        goto L18
    }

    public static String unpackFingerprint(String r8) {
        if (r8 != null) goto L5;
    L13:
        return null;
    L5:
        if (r8.isEmpty() == true) goto L13;
        byte[] r10 = Base64.decode(r8, 2);     // Catch: Exception -> L14
        int r11 = r10.length;     // Catch: Exception -> L14
        int r12 = 0;
    L9:
        if (r12 >= r11) goto L11;
        r10[r12] = (byte) (r10[r12] ^ (-99));     // Catch: Exception -> L14
        r12 = r12 + 1;     // Catch: Exception -> L14
        goto L9
    L11:
        return new String(r10);
    }

    public static LocationResp uploadCacheLocationInfo(DeviceLocation r8, DeviceStatus r10, LocationUploadExtra r11) {
        if (checkoutUploadRule(r11) == false) goto L5;
    L15:
        if (r11 == null) goto L17;
        int r12 = r11.getTriggerType();
    L18:
        s r13 = getSubmitCacheLocationUploadBody(r8, r10, r11);
        LinkedHashMap r14 = new LinkedHashMap();
        r14.put("locinfo", packFingerprint(r13));
        LinkedHashMap r15 = new LinkedHashMap();
        r15.put("sdk_version", BuildConfig.BDLOCATION_VERSION);
        long r16 = SystemClock.elapsedRealtime();
        SsResponse<String> r17 = NetworkRequestManager.submitPost(LOCATION_CACHE_RELATIVE_PATH, r14, r15, r12, LocationAnnotation.SubmitSource.CACHE_LOCATION);
        if (r17 == null) goto L22;
        LocationResp r18 = analysisLocationResult(r17.body());
        Logger.i("ServerApi", "submit cache end network duration is " + (System.currentTimeMillis() - r16));
        return r18;
    L22:
        return null;
    L17:
        r12 = 0;
        goto L18
    L5:
        if (BDLocationConfig.enableCheckUploadCompliance() == false) goto L10;
        String r19 = "The collection of data is allowed checkoutUploadRule!";
    L7:
        Logger.i(r19);
        return null;
    L10:
        if (BDLocationConfig.enableBackgroundUploadLocation() == true) goto L12;
        r19 = "The current app is in the background, and the upload is not allowed!";
        goto L7
    L12:
        if (r11 == null) goto L14;
        r11.setUploadSource(r11.getUploadSource() + LocationInfoConst.BACKGROUND_UPLOAD);
    L14:
        Logger.i("The current app is in the background, and the upload is allowed!");
        goto L15
    }

    public static LocationResp uploadGpsAndBleInfos(LocationUploadExtra r8) {
        if (LocationUtil.enableUseLocation(true) == false) goto L5;
    L12:
        s r10 = getGpsAndBleUploadBody(r8);
        if (r10 != null) goto L15;
        String r11 = "uploadGpsAndBleInfos locinfo is null";
    L7:
        Logger.i(r11);
        return null;
    L15:
        LinkedHashMap r12 = new LinkedHashMap();
        String r13 = packFingerprint(r10);
        if (TextUtils.isEmpty(r13) == false) goto L18;
        r11 = "uploadGpsAndBleInfos body is empty";
        goto L7
    L18:
        r12.put("locinfo", r13);
        LinkedHashMap r14 = new LinkedHashMap();
        r14.put("sdk_version", BuildConfig.BDLOCATION_VERSION);
        SsResponse<String> r15 = NetworkRequestManager.submitPost(LOCATION_RELATIVE_PATH, r12, r14, r8.getTriggerType(), LocationAnnotation.SubmitSource.UPLOAD_GPS_BLE);
        if (r15 == null) goto L22;
        LocationResp r16 = analysisLocationResult(r15.body());
        Logger.i("uploadGpsAndBleInfos success");
        return r16;
    L22:
        return null;
    L5:
        if (BDLocationConfig.enableCheckUploadCompliance() == false) goto L9;
        r11 = "uploadGpsAndBleInfos locinfo is not allow";
        goto L7
    L9:
        if (r8 == null) goto L11;
        r8.setUploadSource(r8.getUploadSource() + LocationInfoConst.BACKGROUND_UPLOAD);
    L11:
        Logger.i("uploadGpsAndBleInfos background upload");
        goto L12
    }

    public static LocationResp uploadLightLocation(DeviceLocation r8, DeviceStatus r10, LocationUploadExtra r11) {
        s r12 = getLightUploadBody(r8, r10, r11);
        LinkedHashMap r13 = new LinkedHashMap();
        r13.put("locinfo", packFingerprint(r12));
        LinkedHashMap r14 = new LinkedHashMap();
        r14.put("sdk_version", BuildConfig.BDLOCATION_VERSION);
        long r15 = System.currentTimeMillis();
        SsResponse<String> r16 = NetworkRequestManager.submitPost(LOCATION_RELATIVE_PATH, r13, r14, r11.getTriggerType(), LocationAnnotation.SubmitSource.LIGHT_LOCATION);
        r11.setLightSubmitDuration(System.currentTimeMillis() - r15);
        Logger.i("ServerApi", "end network duration is " + (System.currentTimeMillis() - r15));
        if (r16 != null) goto L5;
        return null;
    L5:
        return analysisLocationResult(r16.body());
    }

    public static LocationResp uploadLocationInfoMustInNetworkIOThreadPool(DeviceLocation r8, DeviceStatus r10, LocationUploadExtra r11) {
        if (checkoutUploadRule(r11) == true) goto L16;
        if (BDLocationConfig.enableCheckUploadCompliance() == false) goto L10;
        String r12 = "The collection of data is allowed checkoutUploadRule!";
    L7:
        Logger.i(r12);
        return null;
    L10:
        if (BDLocationConfig.enableBackgroundUploadLocation() == true) goto L12;
        r12 = "The current app is in the background, and the upload is not allowed!";
        goto L7
    L12:
        if (r11 == null) goto L14;
        r11.setUploadSource(r11.getUploadSource() + LocationInfoConst.BACKGROUND_UPLOAD);
    L14:
        Logger.i("The current app is in the background, and the upload is allowed!");
    L16:
        return getLocationInfoMustInNetworkIOThreadPool(r8, r10, r11);
    }

    public static LocationResp uploadMccAndSystemRegionInfo(Context r18, String r19, int r20) {
        if (checkoutUploadRule(null) == true) goto L6;
        Logger.i("The collection of data is allowed checkoutUploadRule!");
        return null;
    L6:
        String r8 = BDLocationConfig.getDeviceInfoExtra();
        InfoRequestExtraLite r10 = (InfoRequestExtraLite) JsonUtil.sGson.c(InfoRequestExtraLite.class, r8);     // Catch: Throwable -> L9
    L11:
        DeviceStatus r11 = LocationUtil.getDeviceStatus(r18, null);
        p r12 = JsonUtil.safeToJsonTree(r11);
        InfoRequestQPSOptTraceLogger r13 = new InfoRequestQPSOptTraceLogger();
        r13.begin(InfoRequestQPSOptTraceLogger.SKIP_CHECK_DURATION);
        boolean r14 = canSkipInfoRequest(r11, r10, r13);
        r13.end(InfoRequestQPSOptTraceLogger.SKIP_CHECK_DURATION);
        if (r14 == false) goto L15;
        Logger.i("skip info request, currentDeviceStatus: " + r12 + ", currentDeviceInfoExtra: " + r8);
        r13.putCategoryData("is_skip", Boolean.TRUE);
        r13.monitorInfoRequestQPSOptEvent();
        LocationMonitor.uploadAuthStatus(LocationMonitorConst.INFO, PermissionManager.checkLocationPermissions(r18, true), LocationUtil.getLocationMode(r18), PermissionManager.checkBluetoothScanPermission(r18), LocationUtil.getbluetoothSwitch() ? 1 : 0, true);
        return null;
    L15:
        r13.putCategoryData("is_skip", Boolean.FALSE);
        Logger.i("cannot skip info request, continue to send request.");
        s r15 = new s();
        if (r19 == null) goto L18;
        r15.n("upload_source", r19);
        Logger.i("uploadMccAndSystemRegionInfo upload_source:".concat(r19));
    L18:
        r15.k("region_info", JsonUtil.safeToJsonTree(LocationUtil.getRegionInfo(r18)));
        r15.k("status", r12);
        r15.m("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
        r15.l("is_vpn", Boolean.valueOf(LocationUtil.checkVPN()));
        r15.l("is_proxy", Boolean.valueOf(LocationUtil.isProxy()));
        r15.n(WsConstants.KEY_EXTRA, r8);
        Logger.i("submit device:" + JsonUtil.sGson.i(r15));
        LinkedHashMap r16 = new LinkedHashMap();
        r16.put("locinfo", packFingerprint(r15));
        LinkedHashMap r17 = new LinkedHashMap();
        r17.put("sdk_version", BuildConfig.BDLOCATION_VERSION);
        boolean r21 = LocationUtil.isBackground();
        long r110 = SystemClock.elapsedRealtime();
        String r22 = NetworkRequestManager.post(INFO_RELATIVE_PATH, r16, r17, r20);
        Logger.i("info result:" + r22);
        LocationMonitor.uploadAuthStatus(LocationMonitorConst.INFO, PermissionManager.checkLocationPermissions(r18, true), LocationUtil.getLocationMode(r18), PermissionManager.checkBluetoothScanPermission(r18), LocationUtil.getbluetoothSwitch() ? 1 : 0, false);
        LocationResp r111 = analysisLocationResult(r22);
        long r23 = SystemClock.elapsedRealtime() - r110;
        if (r111 == null) goto L23;
        LocationMonitor.uploadBaseInfo(r19, r23, r111.resultCode, r111.resultMsg, r21);
        Logger.i("locationmonitor info total duration is: " + (SystemClock.elapsedRealtime() - r110) + "ms");
        if (BDLocationConfig.isRestrictedModeOn() == false) goto L24;
        LocationMonitor.uploadRestrictedInfo(SystemClock.elapsedRealtime() - r110, r111.resultCode, r111.resultMsg);
    L24:
        r13.begin("cache_duration");
        recordLastSuccessInfoRequestParamsIfNeed(r111, r11, r10, r13);
        r13.end("cache_duration");
        r13.monitorInfoRequestQPSOptEvent();
        return r111;
    L23:
        LocationMonitor.uploadBaseInfo(r19, r23, -2, "result is null", r21);
    L9:
        th = move-exception;
        th.printStackTrace();
        Logger.e("parse InfoRequestExtraStr to InfoRequestExtra.class failed, " + th, th);
        r10 = null;
        goto L11
    }

    public static LocationResp uploadRescanWifiInfoMustInNetworkIOThreadPool(DeviceLocation r8, DeviceStatus r10, LocationUploadExtra r11) {
        s r12 = getSubmitUploadBody(r8, r10, r11, true);
        r12.n("upload_source", r11.getUploadSource());
        r12.n("upload_sensors", "wifi");
        LinkedHashMap r13 = new LinkedHashMap();
        r13.put("locinfo", packFingerprint(r12));
        LinkedHashMap r14 = new LinkedHashMap();
        r14.put("sdk_version", BuildConfig.BDLOCATION_VERSION);
        NetworkRequestManager.submitPost(LOCATION_RELATIVE_PATH, r13, r14, r11.getTriggerType(), LocationAnnotation.SubmitSource.RESCAN_WIFI);
        return null;
    }

    public static boolean uploadShakeInfo(ShakeUploadInfo r10, boolean r11, int r12) {
        if (checkoutUploadRule(null) == true) goto L6;
        Logger.i("The collection of data is allowed checkoutUploadRule!");
        return false;
    L6:
        String r13 = JsonUtil.sGson.j(r10);
        Logger.i("start submit uploadShakeInfo");
        LinkedHashMap r8 = new LinkedHashMap();
        r8.put("userloc", packFingerprint(r13));
        LinkedHashMap r14 = new LinkedHashMap();
        r14.put("sdk_version", BuildConfig.BDLOCATION_VERSION);
        Logger.d("ServerApi uploadShakeInfo");
        if (r11 == false) goto L9;
        String r15 = SHAKE_REFRESH_RELATIVE_PATH;
    L10:
        long r16 = SystemClock.elapsedRealtime();
        return shakeSubmitResult(NetworkRequestManager.post(r15, r8, r14, r12), "upload location info success", "upload location info failed", r16, r11);
    L9:
        r15 = SHAKE_RELATIVE_PATH;
        goto L10
    }

    private static String wrapSubmitExtra(String r8) {
    L7:
        th = move-exception;
        th.printStackTrace();
        Logger.e("wrong JSON format, extra: " + r8);
        JSONObject r10 = new JSONObject();
    L9:
        JSONObject r11 = BDLocationConfig.getSubmitExtra();
        r10.put("bdlocation_submit_extra", r11);     // Catch: Throwable -> L12
        return r10.toString();
    L12:
        th = move-exception;
        th.printStackTrace();
        Logger.e("extra put submitExtra failed, submitExtra: " + r11);
        return r8;
    L3:
        if (TextUtils.isEmpty(r8) == false) goto L5;
        r10 = new JSONObject();     // Catch: Throwable -> L7
    L15:
        goto L9
    L5:
        r10 = new JSONObject(r8);     // Catch: Throwable -> L7
        goto L15
    }

    public static String packFingerprint(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L13;
        return null;
    L13:
        byte[] r10 = r8.getBytes("utf-8");     // Catch: Exception -> L10
        int r11 = r10.length;     // Catch: Exception -> L10
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L8;
        r10[r12] = (byte) (r10[r12] ^ (-99));     // Catch: Exception -> L10
        r12 = r12 + 1;     // Catch: Exception -> L10
        goto L6
    L8:
        return Base64.encodeToString(r10, 10);
    L10:
        e = move-exception;
        Logger.i("packFingerprint exception:" + e.toString());
        return null;
    }
}
