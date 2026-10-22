package com.bytedance.bdlocation_impl.shake;

import android.os.Handler;
import android.os.Looper;
import androidx.activity.d;
import androidx.room.k;
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
import com.bytedance.keva.KevaImpl;
import com.obric.cae.userAware.SubwayFusionAware.SubwayUtils;
import defpackage.c;
import ha.j;
import ha.m;
import ha.s;
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

    public static /* synthetic */ void a(BDShakeCollectService r8, String r10, JSONObject r11, ShakeUploadCallback r12, Object r13, String r14) {
        r8.lambda$startShakeUpload$0(r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ void b(ShakeUploadCallback r8) {
        lambda$shakeSuccess$1(r8);
    }

    public static /* synthetic */ void c(BDShakeCollectService r8, boolean r10) {
        r8.lambda$registerBackgroundCallback$3(r10);
    }

    public static /* synthetic */ void d(ShakeUploadCallback r8, BDLocationException r10) {
        lambda$shakeError$2(r8, r10);
    }

    private void executeShakeRefresh(String r8, JSONObject r10, ShakeUploadCallback r11) {
        if (refreshShake(r8, r10) == false) goto L5;
        Logger.d(BDShakeConfig.TAG, "BDShakeCollectService refreshShakeInfo success");
        shakeSuccess(r11);
        return;
    L5:
        Logger.d(BDShakeConfig.TAG, "BDShakeCollectService refreshShakeInfo error");
        shakeError(new BDLocationException("refresh shake info error", TAG, BDLocationException.ERROR_SHAKE_UPLOAD), r11);
    }

    private m getBleInfos() {
        if (this.shakeScanTask.isBlueToothEnabled() == true) goto L5;
        return null;
    L5:
        return BDShakeScanTask.mBleInfos;
    }

    private LocationInfo getGpsInfo(BDLocation r8) {
        return LocationUtil.bdLocationToLocationInfo(r8, BDLocationConfig.isUploadGPS());
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

    private LocationOption getShakeUploadOption(String r8, int r10, boolean r11, int r12, long r13, Object r14, String r15) {
        LocationOption r16 = new LocationOption();
        r16.setUploadSource(r8);
        r16.setCert(true);
        r16.setMaxCacheTime(r13);
        r16.setTriggerType(r10);
        r16.setLocateType(BDLocationConfig.getLocateType());
        r16.setUpload(r11);
        r16.setLocationTimeOutMs(r12);
        r16.setBpeaCert(r14);
        r16.setBpeaAction(r15);
        r16.setScanBle(false);
        return r16;
    }

    private long getSubdivisionId(BDLocation r8) {
        if (r8 != null) goto L6;
        return 0;
    L6:
        if (r8.getLocationResult() == null) goto L13;
        PlaceInfo[] r10 = r8.getLocationResult().subdivisions;
        if (r10 == null) goto L13;
        if (r10.length <= 0) goto L13;
        return r10[0].geoNameID;
    L13:
        return 0;
    }

    private m getWifiInfos() {
        if (this.shakeScanTask.isWifiEnabled() == true) goto L5;
        return null;
    L5:
        return BDShakeScanTask.mWifiInfos;
    }

    private /* synthetic */ void lambda$registerBackgroundCallback$3(boolean r8) {
        if (this.isStartScanTask == true) goto L5;
        return;
    L5:
        if (r8 == false) goto L7;
        Logger.i("enter background");
        this.shakeScanTask.stopScan();
        return;
    L7:
        Logger.i("enter foreground");
        this.shakeScanTask.startScan(this.scanBpeaCert, this.mScanBpeaAction);
    }

    private static /* synthetic */ void lambda$shakeError$2(ShakeUploadCallback r8, BDLocationException r10) {
        r8.onError(r10);
    }

    private static /* synthetic */ void lambda$shakeSuccess$1(ShakeUploadCallback r8) {
        r8.onSuccess();
    }

    private /* synthetic */ void lambda$startShakeUpload$0(String r17, JSONObject r18, ShakeUploadCallback r19, Object r20, String r21) {
        if ((System.currentTimeMillis() - this.mLastShakeUploadTime) >= BDShakeConfig.getShakeUploadInterval()) goto L18;
        Logger.d(BDShakeConfig.TAG, "BDShakeCollectService refresh data");
        executeShakeRefresh(r17, r18, r19);
        return;
    L18:
        Logger.d(BDShakeConfig.TAG, "BDShakeCollectService upload data");     // Catch: BDLocationException -> L15
        long r8 = BDShakeConfig.getGpsCacheTime() + SubwayUtils.OUTDOOR_PUNISH_DELAY_TIME;     // Catch: BDLocationException -> L15
        String r10 = "location_shake_upload";
        if (r20 == null) goto L9;
        r10 = BDLocationExtrasService.getBPEAManager().getBpeaToken(r20);     // Catch: BDLocationException -> L15
    L9:
        BDLocation r11 = c.J(getShakeUploadOption(r10, 1, true, KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD, r8, r20, r21));     // Catch: BDLocationException -> L15
        StringBuilder r12 = new StringBuilder("BDShakeCollectService upload location:");     // Catch: BDLocationException -> L15
        if (r11 != null) goto L12;
        String r13 = "";
    L13:
        r12.append(r13);     // Catch: BDLocationException -> L15
        Logger.d(BDShakeConfig.TAG, r12.toString());     // Catch: BDLocationException -> L15
        executeShakeUpload(r17, r11, r18, r19);     // Catch: BDLocationException -> L15
        return;
    L12:
        r13 = r11.toString();     // Catch: BDLocationException -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
        Logger.d(BDShakeConfig.TAG, "BDShakeCollectService getLocation error");
        executeShakeUpload(r17, null, r18, r19);
    }

    private boolean refreshShake(String r8, JSONObject r10) {
        ShakeUploadInfo r11 = new ShakeUploadInfo();     // Catch: Exception -> L8
        r11.busiName = r8;     // Catch: Exception -> L8
        if (r10 == null) goto L6;
        r11.extra = (s) new j().c(s.class, r10.toString());     // Catch: Exception -> L8
    L6:
        r11.timeStamp = System.currentTimeMillis();     // Catch: Exception -> L8
        Logger.d(BDShakeConfig.TAG, "BDShakeCollectService try to refreshShake");     // Catch: Exception -> L8
        return ServerApi.uploadShakeInfo(r11, true, 1);
    L8:
        e = move-exception;
        e.printStackTrace();
        Logger.d(BDShakeConfig.TAG, "BDShakeCollectService try to refreshShake error:" + e);
        return false;
    }

    private void registerBackgroundCallback() {
        BDLocationConfig.getAppBackgroundProvider().addCallback(new b(this));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Logger.e("", e);
    }

    private boolean shakeUpload(String r8, BDLocation r10, JSONObject r11) {
        ShakeUploadInfo r12 = new ShakeUploadInfo();     // Catch: Exception -> L17
        r12.busiName = r8;     // Catch: Exception -> L17
        if (r10 == null) goto L7;
        r12.subdivisionId = getSubdivisionId(r10);     // Catch: Exception -> L17
        r12.locationInfo = getGpsInfo(r10);     // Catch: Exception -> L17
    L7:
        if (BDShakeConfig.isShakeUploadWifi() == false) goto L10;
        r12.wifiInfo = getWifiInfos();     // Catch: Exception -> L17
    L10:
        if (BDShakeConfig.isShakeUploadBle() == false) goto L12;
        r12.bleInfo = getBleInfos();     // Catch: Exception -> L17
    L12:
        r12.timeStamp = System.currentTimeMillis();     // Catch: Exception -> L17
        if (r11 == null) goto L15;
        r12.extra = (s) new j().c(s.class, r11.toString());     // Catch: Exception -> L17
    L15:
        Logger.d(BDShakeConfig.TAG, "BDShakeCollectService try to upload");     // Catch: Exception -> L17
        return ServerApi.uploadShakeInfo(r12, false, 1);
    L17:
        e = move-exception;
        e.printStackTrace();
        Logger.d(BDShakeConfig.TAG, "BDShakeCollectService try to upload error:" + e);
        return false;
    }

    public void executeShakeUpload(String r8, BDLocation r10, JSONObject r11, ShakeUploadCallback r12) {
        if (shakeUpload(r8, r10, r11) == false) goto L5;
        this.mLastShakeUploadTime = System.currentTimeMillis();
        Logger.d(BDShakeConfig.TAG, "BDShakeCollectService uploadShakeInfo success");
        shakeSuccess(r12);
        return;
    L5:
        Logger.d(BDShakeConfig.TAG, "BDShakeCollectService uploadShakeInfo error");
        shakeError(new BDLocationException("upload shake info error", TAG, BDLocationException.ERROR_SHAKE_UPLOAD), r12);
    }

    public void setUploadSource(String r8) {
        this.shakeScanTask.setUploadSource(r8);
    }

    public void shakeError(BDLocationException r8, ShakeUploadCallback r10) {
        new Handler(Looper.getMainLooper()).post(new k(11, r10, r8));
    }

    public void shakeSuccess(ShakeUploadCallback r8) {
        new Handler(Looper.getMainLooper()).post(new d(r8, 11));
    }

    public synchronized boolean startScanTask(Object r8, String r10) {
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
        this.scanBpeaCert = r8;     // Catch: Throwable -> L12
        this.mScanBpeaAction = r10;     // Catch: Throwable -> L12
        boolean r11 = this.shakeScanTask.startScan(r8, r10);     // Catch: Throwable -> L12
        monitor-exit(this);
        return r11;
    }

    public synchronized void startShakeUpload(final Object r10, final String r11, final JSONObject r12, final ShakeUploadCallback r13) {
        monitor-enter(this);
        Logger.d(BDShakeConfig.TAG, "BDShakeCollectService startShakeUpload");     // Catch: Throwable -> L13
        if (r10 != null) goto L17;
    L7:
        AppExecutors.getInstance().networkIO().execute(new a(this, r11, r12, r13, r10));     // Catch: Exception -> L9 Throwable -> L13
    L11:
        monitor-exit(this);
        return;
    L9:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L13
        Logger.d(BDShakeConfig.TAG, "BDShakeCollectService uploadShakeInfo check cert error");     // Catch: Throwable -> L13
        shakeError(new BDLocationException("upload shake info check cert error", TAG, BDLocationException.ERROR_SHAKE_BPEA_CERT_CHECK), r13);     // Catch: Throwable -> L13
        goto L11
    L17:
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
