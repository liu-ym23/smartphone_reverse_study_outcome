package com.bytedance.bdlocation_impl.shake;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.network.ServerApi;
import com.bytedance.bdlocation.network.model.LocationInfo;
import com.bytedance.bdlocation.network.model.PlaceInfo;
import com.bytedance.bdlocation.network.model.ShakeUploadInfo;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation.thread.AppExecutors;
import com.bytedance.bdlocation_impl.d.a;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.obric.cae.userAware.SubwayFusionAware.SubwayUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BDShakeCollectService {
    private static final String TAG = "UG_LOCATION_SHAKE";
    private static BDShakeCollectService collectService;
    private boolean isStartScanTask;
    private long mLastShakeUploadTime;
    private String mScanBpeaAction;
    private Object scanBpeaCert;
    private BDShakeScanTask shakeScanTask;

    public BDShakeCollectService() {
        this.isStartScanTask = false;
        this.mLastShakeUploadTime = 0;
        this.scanBpeaCert = null;
        this.mScanBpeaAction = "";
        this.shakeScanTask = new BDShakeScanTask();
        registerBackgroundCallback();
    }

    private void executeShakeRefresh(String r3, JSONObject r4, ShakeUploadCallback r5) {
        ShakeUploadCallback r6 = (ShakeUploadCallback) ZeusTransformUtils.wrapperContextForParams(r5, ShakeUploadCallback.class, "com.obric.memorydata.plugin");
        if (refreshShake(r3, r4) == false) goto L5;
        Logger.d(BDShakeConfig.TAG, "BDShakeCollectService refreshShakeInfo success");
        shakeSuccess(r6);
        return;
    L5:
        Logger.d(BDShakeConfig.TAG, "BDShakeCollectService refreshShakeInfo error");
        shakeError(new BDLocationException("refresh shake info error", TAG, BDLocationException.ERROR_SHAKE_UPLOAD), r6);
    }

    private JsonArray getBleInfos() {
        if (this.shakeScanTask.isBlueToothEnabled() == true) goto L5;
        return null;
    L5:
        return BDShakeScanTask.mBleInfos;
    }

    private LocationInfo getGpsInfo(BDLocation r1) {
        return LocationUtil.bdLocationToLocationInfo(r1, BDLocationConfig.isUploadGPS());
    }

    public static BDShakeCollectService getInstance() {
        if (collectService != null) goto L15;
        monitor-enter(BDShakeCollectService.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (collectService != null) goto L9;
        collectService = new BDShakeCollectService();     // Catch: Throwable -> L11
    L9:
        monitor-exit(BDShakeCollectService.class);     // Catch: Throwable -> L11
    L15:
        return collectService;
    }

    private LocationOption getShakeUploadOption(String r1, int r2, boolean r3, int r4, long r5, Object r7, String r8) {
        LocationOption r0 = new LocationOption();
        r0.setUploadSource(r1);
        r0.setCert(true);
        r0.setMaxCacheTime(r5);
        r0.setTriggerType(r2);
        r0.setLocateType(BDLocationConfig.getLocateType());
        r0.setUpload(r3);
        r0.setLocationTimeOutMs(r4);
        r0.setBpeaCert(r7);
        r0.setBpeaAction(r8);
        r0.setScanBle(false);
        return r0;
    }

    private long getSubdivisionId(BDLocation r3) {
        if (r3 != null) goto L6;
        return 0;
    L6:
        if (r3.getLocationResult() == null) goto L13;
        PlaceInfo[] r2 = r3.getLocationResult().subdivisions;
        if (r2 == null) goto L13;
        if (r2.length <= 0) goto L13;
        return r2[0].geoNameID;
    L13:
        return 0;
    }

    private JsonArray getWifiInfos() {
        if (this.shakeScanTask.isWifiEnabled() == true) goto L5;
        return null;
    L5:
        return BDShakeScanTask.mWifiInfos;
    }

    static /* synthetic */ void lambda$shakeError$2(ShakeUploadCallback r2, BDLocationException r3) {
        ((ShakeUploadCallback) ZeusTransformUtils.wrapperContextForParams(r2, ShakeUploadCallback.class, "com.obric.memorydata.plugin")).onError(r3);
    }

    static /* synthetic */ void lambda$shakeSuccess$1(ShakeUploadCallback r2) {
        ((ShakeUploadCallback) ZeusTransformUtils.wrapperContextForParams(r2, ShakeUploadCallback.class, "com.obric.memorydata.plugin")).onSuccess();
    }

    private boolean refreshShake(String r3, JSONObject r4) {
        ShakeUploadInfo r0 = new ShakeUploadInfo();     // Catch: Exception -> L8
        r0.busiName = r3;     // Catch: Exception -> L8
        if (r4 == null) goto L6;
        r0.extra = (JsonObject) ZeusTransformUtils.preCheckCast(new Gson().fromJson(r4.toString(), JsonObject.class), JsonObject.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L8
    L6:
        r0.timeStamp = System.currentTimeMillis();     // Catch: Exception -> L8
        Logger.d(BDShakeConfig.TAG, "BDShakeCollectService try to refreshShake");     // Catch: Exception -> L8
        return ServerApi.uploadShakeInfo(r0, true, 1);
    L8:
        e = move-exception;
        e.printStackTrace();
        Logger.d(BDShakeConfig.TAG, "BDShakeCollectService try to refreshShake error:" + e);
        return false;
    }

    private void registerBackgroundCallback() {
        BDLocationConfig.getAppBackgroundProvider().addCallback(new $$Lambda$BDShakeCollectService$KPvdjdHVS3hCuUurWHe0cSeXrA(this));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Logger.e("", e);
    }

    private boolean shakeUpload(String r6, BDLocation r7, JSONObject r8) {
        ShakeUploadInfo r2 = new ShakeUploadInfo();     // Catch: Exception -> L17
        r2.busiName = r6;     // Catch: Exception -> L17
        if (r7 == null) goto L7;
        r2.subdivisionId = getSubdivisionId(r7);     // Catch: Exception -> L17
        r2.locationInfo = getGpsInfo(r7);     // Catch: Exception -> L17
    L7:
        if (BDShakeConfig.isShakeUploadWifi() == false) goto L10;
        r2.wifiInfo = getWifiInfos();     // Catch: Exception -> L17
    L10:
        if (BDShakeConfig.isShakeUploadBle() == false) goto L12;
        r2.bleInfo = getBleInfos();     // Catch: Exception -> L17
    L12:
        r2.timeStamp = System.currentTimeMillis();     // Catch: Exception -> L17
        if (r8 == null) goto L15;
        r2.extra = (JsonObject) ZeusTransformUtils.preCheckCast(new Gson().fromJson(r8.toString(), JsonObject.class), JsonObject.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L17
    L15:
        Logger.d(BDShakeConfig.TAG, "BDShakeCollectService try to upload");     // Catch: Exception -> L17
        return ServerApi.uploadShakeInfo(r2, false, 1);
    L17:
        e = move-exception;
        e.printStackTrace();
        Logger.d(BDShakeConfig.TAG, "BDShakeCollectService try to upload error:" + e);
        return false;
    }

    public void executeShakeUpload(String r3, BDLocation r4, JSONObject r5, ShakeUploadCallback r6) {
        ShakeUploadCallback r7 = (ShakeUploadCallback) ZeusTransformUtils.wrapperContextForParams(r6, ShakeUploadCallback.class, "com.obric.memorydata.plugin");
        if (shakeUpload(r3, r4, r5) == false) goto L5;
        this.mLastShakeUploadTime = System.currentTimeMillis();
        Logger.d(BDShakeConfig.TAG, "BDShakeCollectService uploadShakeInfo success");
        shakeSuccess(r7);
        return;
    L5:
        Logger.d(BDShakeConfig.TAG, "BDShakeCollectService uploadShakeInfo error");
        shakeError(new BDLocationException("upload shake info error", TAG, BDLocationException.ERROR_SHAKE_UPLOAD), r7);
    }

    public /* synthetic */ void lambda$registerBackgroundCallback$3$BDShakeCollectService(boolean r2) {
        if (this.isStartScanTask == true) goto L5;
        return;
    L5:
        if (r2 == false) goto L7;
        Logger.i("enter background");
        this.shakeScanTask.stopScan();
        return;
    L7:
        Logger.i("enter foreground");
        this.shakeScanTask.startScan(this.scanBpeaCert, this.mScanBpeaAction);
    }

    public /* synthetic */ void lambda$startShakeUpload$0$BDShakeCollectService(String r16, JSONObject r17, ShakeUploadCallback r18, Object r19, String r20) {
        ShakeUploadCallback r13 = (ShakeUploadCallback) ZeusTransformUtils.wrapperContextForParams(r18, ShakeUploadCallback.class, "com.obric.memorydata.plugin");
        if ((System.currentTimeMillis() - this.mLastShakeUploadTime) >= BDShakeConfig.getShakeUploadInterval()) goto L18;
        Logger.d(BDShakeConfig.TAG, "BDShakeCollectService refresh data");
        executeShakeRefresh(r16, r17, r13);
        return;
    L18:
        Logger.d(BDShakeConfig.TAG, "BDShakeCollectService upload data");     // Catch: BDLocationException -> L15
        long r6 = BDShakeConfig.getGpsCacheTime() + SubwayUtils.OUTDOOR_PUNISH_DELAY_TIME;     // Catch: BDLocationException -> L15
        String r1 = "location_shake_upload";
        if (r19 == null) goto L9;
        r1 = BDLocationExtrasService.getBPEAManager().getBpeaToken(r19);     // Catch: BDLocationException -> L15
    L9:
        BDLocation r0 = a.a(getShakeUploadOption(r1, 1, true, 10000, r6, r19, r20));     // Catch: BDLocationException -> L15
        StringBuilder r2 = new StringBuilder().append("BDShakeCollectService upload location:");     // Catch: BDLocationException -> L15
        if (r0 != null) goto L12;
        String r3 = "";
    L13:
        Logger.d(BDShakeConfig.TAG, r2.append(r3).toString());     // Catch: BDLocationException -> L15
        executeShakeUpload(r16, r0, r17, r13);     // Catch: BDLocationException -> L15
        return;
    L12:
        r3 = r0.toString();     // Catch: BDLocationException -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
        Logger.d(BDShakeConfig.TAG, "BDShakeCollectService getLocation error");
        executeShakeUpload(r16, null, r17, r13);
    }

    public void setUploadSource(String r1) {
        this.shakeScanTask.setUploadSource(r1);
    }

    public void shakeError(final BDLocationException r2, ShakeUploadCallback r3) {
        final ShakeUploadCallback r1 = (ShakeUploadCallback) ZeusTransformUtils.wrapperContextForParams(r3, ShakeUploadCallback.class, "com.obric.memorydata.plugin");
        new Handler(Looper.getMainLooper()).post(new $$Lambda$BDShakeCollectService$tIBVPG5Xy8Tio03y54mA336BTVM(r1, r2));
    }

    public void shakeSuccess(ShakeUploadCallback r2) {
        final ShakeUploadCallback r1 = (ShakeUploadCallback) ZeusTransformUtils.wrapperContextForParams(r2, ShakeUploadCallback.class, "com.obric.memorydata.plugin");
        new Handler(Looper.getMainLooper()).post(new $$Lambda$BDShakeCollectService$IXzTzRHIuQ9oNNcuKAMlTVAOen0(r1));
    }

    public synchronized boolean startScanTask(Object r2, String r3) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (LocationUtil.checkBackground() == false) goto L9;
        monitor-exit(this);
        return false;
    L9:
        this.isStartScanTask = true;     // Catch: Throwable -> L12
        this.scanBpeaCert = r2;     // Catch: Throwable -> L12
        this.mScanBpeaAction = r3;     // Catch: Throwable -> L12
        boolean r4 = this.shakeScanTask.startScan(r2, r3);     // Catch: Throwable -> L12
        monitor-exit(this);
        return r4;
    }

    public synchronized void startShakeUpload(final Object r10, final String r11, final JSONObject r12, ShakeUploadCallback r13) {
        monitor-enter(this);
        final ShakeUploadCallback r14 = (ShakeUploadCallback) ZeusTransformUtils.wrapperContextForParams(r13, ShakeUploadCallback.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        Logger.d(BDShakeConfig.TAG, "BDShakeCollectService startShakeUpload");     // Catch: Throwable -> L13
        final String r6 = "startShakeUpload";
        if (r10 != null) goto L16;
    L7:
        AppExecutors.getInstance().networkIO().execute(new $$Lambda$BDShakeCollectService$5d0ixVKm_vvLYsNW3E3tgjDKwM(this, r11, r12, r14, r10, r6));     // Catch: Exception -> L9 Throwable -> L13
    L11:
        monitor-exit(this);
        return;
    L9:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L13
        Logger.d(BDShakeConfig.TAG, "BDShakeCollectService uploadShakeInfo check cert error");     // Catch: Throwable -> L13
        shakeError(new BDLocationException("upload shake info check cert error", TAG, BDLocationException.ERROR_SHAKE_BPEA_CERT_CHECK), r14);     // Catch: Throwable -> L13
        goto L11
    L16:
        BDLocationExtrasService.getBPEAManager().checkAndTranslateCert(r10, "startShakeUpload");     // Catch: Exception -> L9 Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public synchronized void stopScanTask() {
        monitor-enter(this);
        this.isStartScanTask = false;     // Catch: Throwable -> L7
        this.shakeScanTask.stopScan();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
