package com.bytedance.bdlocation_impl.shake;

import android.text.TextUtils;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.entity.bpea.BPEACertCheckResult;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationExtraDataTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BDShakeConfig {
    public static final String SHAKE_UPLOAD_SOURCE = "BDShake";
    public static final String TAG = "BDShakeTask";
    private static boolean isStartLocationTask = true;
    private static long sBleScanInterval = 20000;
    private static long sBleScanTime = 2000;
    private static int sBleUploadNum = 50;
    private static long sClassicScanTime = 2000;
    private static long sGetLocationInterval = 60000;
    private static long sGpsCacheTime = 60000;
    private static long sScanTimeoutMS = 1800000;
    private static boolean sShakeUploadBle = true;
    private static long sShakeUploadInterval = 60000;
    private static boolean sShakeUploadWifi = true;
    private static long sWifiScanInterval = 30000;
    private static int sWifiUploadNum = 30;
    public static final String startScanAction = "startScanTask";
    private static String userId = "";

    static {
    }

    public BDShakeConfig() {
    }

    public static long getBleScanInterval() {
        return sBleScanInterval;
    }

    public static long getBleScanTime() {
        return sBleScanTime;
    }

    public static int getBleUploadNum() {
        return sBleUploadNum;
    }

    public static long getClassicScanTime() {
        return sClassicScanTime;
    }

    public static long getGpsCacheTime() {
        return sGpsCacheTime;
    }

    public static long getLocationInterval() {
        return sGetLocationInterval;
    }

    public static long getScanTimeoutMS() {
        return sScanTimeoutMS;
    }

    public static long getShakeUploadInterval() {
        return sShakeUploadInterval;
    }

    public static String getTestUserId() {
        if (TextUtils.isEmpty(userId) == false) goto L5;
        String r0 = String.valueOf(System.currentTimeMillis()).substring(7);
        userId = r0;
        return r0;
    L5:
        return userId;
    }

    public static long getWifiScanInterval() {
        return sWifiScanInterval;
    }

    public static int getWifiUploadNum() {
        return sWifiUploadNum;
    }

    public static boolean isShakeUploadBle() {
        return sShakeUploadBle;
    }

    public static boolean isShakeUploadWifi() {
        return sShakeUploadWifi;
    }

    public static boolean isStartLocationTask() {
        return isStartLocationTask;
    }

    public static void setBleScanInterval(long r2) {
        if (r2 >= 2000) goto L5;
        return;
    L5:
        sBleScanInterval = r2;
    }

    public static void setBleScanTime(long r2) {
        if (r2 >= 2000) goto L5;
        return;
    L5:
        sBleScanTime = r2;
    }

    public static void setBleUploadNum(int r1) {
        if (r1 >= 10) goto L5;
        return;
    L5:
        sBleUploadNum = r1;
    }

    public static void setClassicScanTime(long r2) {
        if (r2 >= 2000) goto L5;
        return;
    L5:
        sClassicScanTime = r2;
    }

    public static void setGpsCacheTime(long r2) {
        if (r2 >= 60000) goto L5;
        return;
    L5:
        sGpsCacheTime = r2;
    }

    public static void setLocationInterval(long r2) {
        if (r2 >= 60000) goto L5;
        return;
    L5:
        sGetLocationInterval = r2;
    }

    public static void setScanTimeoutMS(long r2) {
        if (r2 >= 600000) goto L5;
        return;
    L5:
        sScanTimeoutMS = r2;
    }

    public static void setShakeParams(JSONObject r4) {
        if (r4 == null) goto L5;
        Logger.i("shake obj:" + r4.toString());
        setBleScanInterval(r4.optInt(LocationExtraDataTraceLogger.BLE_SCAN_INTERVAL, 2000));
        setWifiScanInterval(r4.optInt("wifi_scan_interval", 10000));
        setBleScanTime(r4.optInt("ble_scan_time", 2000));
        setClassicScanTime(r4.optInt("classic_scan_time", 2000));
        setBleUploadNum(r4.optInt("ble_upload_num", 50));
        setShakeUploadWifi(r4.optBoolean("shake_upload_wifi", true));
        setShakeUploadBle(r4.optBoolean("shake_upload_ble", true));
        setStartLocationTask(r4.optBoolean("start_location_task", true));
        setLocationInterval(r4.optInt(LocationMonitorConst.LOCATION_INTERVAL, 60000));
        setGpsCacheTime(r4.optInt("gps_cache_time", 60000));
        setScanTimeoutMS(r4.optInt("scan_timeout_ms", 1800000));
        return;
    }

    public static void setShakeUploadBle(boolean r0) {
        sShakeUploadBle = r0;
    }

    public static void setShakeUploadInterval(long r4) {
        if (sShakeUploadInterval >= 60000) goto L5;
        return;
    L5:
        sShakeUploadInterval = r4;
    }

    public static void setShakeUploadWifi(boolean r0) {
        sShakeUploadWifi = r0;
    }

    public static void setStartLocationTask(boolean r0) {
        isStartLocationTask = r0;
    }

    public static void setWifiScanInterval(long r2) {
        if (r2 >= 10000) goto L5;
        return;
    L5:
        sWifiScanInterval = r2;
    }

    public static void setWifiUploadNum(int r1) {
        if (r1 >= 10) goto L5;
        return;
    L5:
        sWifiUploadNum = r1;
    }

    public static void startScanTask(Object r3) {
        if (BDLocationConfig.initIfNeed() == true) goto L7;
        Logger.i("startShakeUpload Must be called after BDLocation initialization!");
        return;
    L7:
        if (LocationUtil.checkBackground() == false) goto L20;
        return;
    L20:
        BDShakeCollectService.getInstance().setUploadSource(SHAKE_UPLOAD_SOURCE);     // Catch: Exception -> L17
        LocationUtil.checkBpeaCertNull(startScanAction, r3);     // Catch: Exception -> L17
        if (r3 == null) goto L15;
        BPEACertCheckResult r1 = BDLocationExtrasService.getBPEAManager().checkAndTranslateCert(r3, startScanAction);     // Catch: Exception -> L17
        if (r1 == null) goto L14;
        setShakeParams(r1.getParams());     // Catch: Exception -> L17
    L14:
        BDShakeCollectService.getInstance().setUploadSource(BDLocationExtrasService.getBPEAManager().getBpeaToken(r3));     // Catch: Exception -> L17
    L15:
        Logger.d("ShakeTaskScan result:" + BDShakeCollectService.getInstance().startScanTask(r3, startScanAction));     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
        Logger.d("BDLocation" + e.getMessage());
    }

    public static void startShakeUpload(Object r2, String r3, JSONObject r4, ShakeUploadCallback r5) {
        ShakeUploadCallback r6 = (ShakeUploadCallback) ZeusTransformUtils.wrapperContextForParams(r5, ShakeUploadCallback.class, "com.obric.memorydata.plugin");
        if (BDLocationConfig.initIfNeed() == true) goto L11;
        Logger.i("startShakeUpload Must be called after BDLocation initialization!");
        return;
    L11:
        LocationUtil.checkBpeaCertNull("startShakeUpload", r2);     // Catch: BDLocationException -> L8
        BDShakeCollectService.getInstance().startShakeUpload(r2, r3, r4, r6);     // Catch: BDLocationException -> L8
        return;
    L8:
        e = move-exception;
        r6.onError(e);
    }

    public static void stopScanTask() {
        if (BDLocationConfig.initIfNeed() == true) goto L6;
        Logger.i("startShakeUpload Must be called after BDLocation initialization!");
        return;
    L6:
        BDShakeCollectService.getInstance().stopScanTask();
    }
}
