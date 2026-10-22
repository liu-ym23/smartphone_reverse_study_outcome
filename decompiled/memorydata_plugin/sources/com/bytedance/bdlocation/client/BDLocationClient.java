package com.bytedance.bdlocation.client;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.exception.BDLocationExceptionMessage;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.monitor.LocationTraceLogger;
import com.bytedance.bdlocation_impl.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class BDLocationClient {
    public static String COMMON_UPLOAD_SOURCE = "from_client";
    private Context mContext;
    private LocationOption mOption;

    static {
    }

    public BDLocationClient(Context r3) {
        this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    private LocationOption getOption(BDLocationClientOption r3) {
        LocationOption r2 = new LocationOption();
        r2.setLocateType(r3.getLocateType());
        r2.setLocationTimeOutMs(r3.getLocationTimeOut());
        r2.setMaxCacheTime(r3.getMaxCacheTime());
        r2.setUploadSource(r3.getUploadSource());
        r2.setCert(r3.isCert());
        r2.setAccuracyLevel(r3.getAccuracyLevel());
        r2.setInterval(r3.getInterval());
        r2.setHostSwitchThreadDuration(r3.getHostSwitchThreadDuration());
        r2.setTriggerType(r3.getTriggerType());
        r2.setMode(r3.getLocationMode());
        r2.setBpeaCert(r3.getBpeaCert());
        r2.setLatestAdminVersion(r3.isLatestAdminVersion());
        r2.setUpload(r3.isUpload());
        r2.enableAMapBackgroundContiLocation = r3.isEnableAMapBackgroundContiLocation();
        r2.setSynchronizeUpload(r3.isSynchronizeUpload());
        r2.setAMapGpsFirst(r3.isAMapGpsFirst());
        r2.setAMapGpsFirstTimeoutMillis(r3.getAMapGpsFirstTimeoutMillis());
        if (TextUtils.isEmpty(r2.getUploadSource()) == false) goto L5;
        r2.setUploadSource(COMMON_UPLOAD_SOURCE);
    L5:
        r2.setExtra(r3.getExtra());
        r2.setGpsTimeoutMs(r3.getGpsTimeoutMs());
        r2.setBackupIntervalMs(r3.getBackupIntervalMs());
        r2.setBusinessId(r3.getBusinessId());
        return r2;
    }

    private long getPollUploadInterval() {
        return a.a().c();
    }

    public BDLocation getLocation() {
        Logger.d("BDLocationClient:getLocation synchronization");
        LocationTraceLogger r0 = new LocationTraceLogger();
        r0.begin("total_duration");
        r0.begin(LocationMonitorConst.LOCATION_RULE_CHECK_DURATION);
        LBSLightLocationTraceLogger r1 = new LBSLightLocationTraceLogger();
        r1.begin(LBSLightLocationTraceLogger.TOTAL);
        r1.begin(LBSLightLocationTraceLogger.PREPARE);
        if (initIfNeed() == true) goto L6;
        Logger.i("BDLocationClient:getLocation not init");
        r0.locationErrorReport(new BDLocationException(BDLocationExceptionMessage.NOT_INITIALIZATION, LocationInfoConst.BDLOCATION, BDLocationException.ERROR_INIT_LOCATION));
        return null;
    L6:
        LocationOption r2 = this.mOption;
        if (r2 == null) goto L10;
        r2.setLocationTraceLogger(r0);
        this.mOption.setLBSLightLocationTraceLogger(r1);
        this.mOption.setOnceLocation(true);
        this.mOption.setBpeaAction("getLocationCert");
        LocationUtil.checkBpeaCertNull("execLocation", this.mOption.getBpeaCert());
        return com.bytedance.bdlocation_impl.c.a.a().a(new LocationOption(this.mOption));
    L10:
        Logger.i("BDLocationClient:getLocation option is null");
        BDLocationException r4 = new BDLocationException(BDLocationExceptionMessage.LOCATION_OPTION_IS_NULL, "unknown", BDLocationException.ERROR_LOCATION_OPTION);
        r0.locationErrorReport(r4);
        throw r4;
    }

    public void getLocation(BDLocationCallback r4) {
        BDLocationCallback r5 = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r4, BDLocationCallback.class, "com.obric.memorydata.plugin");
        Logger.d("BDLocationClient:getLocation asynchronous");
        LocationTraceLogger r0 = new LocationTraceLogger();
        r0.begin("total_duration");
        r0.begin(LocationMonitorConst.LOCATION_RULE_CHECK_DURATION);
        LBSLightLocationTraceLogger r1 = new LBSLightLocationTraceLogger();
        r1.begin(LBSLightLocationTraceLogger.TOTAL);
        r1.begin(LBSLightLocationTraceLogger.PREPARE);
        r1.begin(LBSLightLocationTraceLogger.SUB_PREPARE);
        if (initIfNeed() == true) goto L6;
        Logger.i("BDLocationClient:getLocation not init");
        reportNotInitError(r0, r5);
        return;
    L6:
        LocationOption r2 = this.mOption;
        if (r2 != null) goto L11;
        if (r5 == null) goto L11;
        Logger.i("BDLocationClient:getLocation option is null");
        reportNotInitError(r0, r5);
        return;
    L11:
        r2.setLocationTraceLogger(r0);
        this.mOption.setLBSLightLocationTraceLogger(r1);
        this.mOption.setOnceLocation(true);
        this.mOption.setBpeaAction("getLocation");
        LocationUtil.checkBpeaCertNull("getLocation", this.mOption.getBpeaCert());     // Catch: BDLocationException -> L15
        com.bytedance.bdlocation_impl.c.a.a().a(r5, new LocationOption(this.mOption));
        return;
    L15:
        e = move-exception;
        if (r5 == null) goto L18;
        r5.onError(e);
    L18:
        r0.locationErrorReport(e);
    }

    public boolean initIfNeed() {
        if (BDLocationConfig.initIfNeed() == false) goto L6;
        return true;
    L6:
        Logger.i("Must be called after BDLocation initialization!");
        return false;
    }

    public void reportNotInitError(LocationTraceLogger r4, BDLocationCallback r5) {
        BDLocationCallback r3 = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r5, BDLocationCallback.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L10;
        return;
    L10:
        BDLocationException r6 = new BDLocationException(BDLocationExceptionMessage.NOT_INITIALIZATION, LocationInfoConst.BDLOCATION, BDLocationException.ERROR_INIT_LOCATION);     // Catch: Throwable -> L7
        r3.onError(r6);     // Catch: Throwable -> L7
        r4.locationErrorReport(r6);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Logger.e("reportNotInitError error: " + th);
        th.printStackTrace();
    }

    public void setClientOption(BDLocationClientOption r5) {
        if (r5.getBpeaCert() != null) goto L5;
        Logger.i("setClientOption bpea cert is null");
    L5:
        LocationOption r6 = getOption(r5);
        this.mOption = r6;
        if (r6 != null) goto L8;
        return;
    L8:
        if (r6.getMaxCacheTime() > 0) goto L10;
        return;
    L10:
        if (BDLocationConfig.isPollingUpload() == false) goto L15;
        this.mOption.setMaxCacheTime(getPollUploadInterval());
        return;
    }

    public void startLocation(BDLocationCallback r5) {
        BDLocationCallback r6 = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r5, BDLocationCallback.class, "com.obric.memorydata.plugin");
        monitor-enter(this);
        Logger.d("BDLocationClient:startLocation");     // Catch: Throwable -> L26
        if (initIfNeed() == true) goto L10;
        if (r6 == null) goto L8;
        r6.onError(new BDLocationException(BDLocationExceptionMessage.NOT_INITIALIZATION, LocationInfoConst.BDLOCATION, BDLocationException.ERROR_INIT_LOCATION));     // Catch: Throwable -> L26
    L8:
        monitor-exit(this);     // Catch: Throwable -> L26
        return;
    L10:
        LocationOption r0 = this.mOption;     // Catch: Throwable -> L26
        if (r0 != null) goto L16;
        if (r6 == null) goto L16;
        r6.onError(new BDLocationException(BDLocationExceptionMessage.LOCATION_OPTION_IS_NULL, "unknown", BDLocationException.ERROR_LOCATION_OPTION));     // Catch: Throwable -> L26
        monitor-exit(this);     // Catch: Throwable -> L26
        return;
    L16:
        r0.setOnceLocation(false);     // Catch: Throwable -> L26
        this.mOption.setBpeaAction("startLocation");     // Catch: Throwable -> L26
        LocationUtil.checkBpeaCertNull("startLocation", this.mOption.getBpeaCert());     // Catch: BDLocationException -> L21 Throwable -> L26
        com.bytedance.bdlocation_impl.c.a.a().b(r6, new LocationOption(this.mOption));     // Catch: Throwable -> L26
        monitor-exit(this);     // Catch: Throwable -> L26
        return;
    L21:
        e = move-exception;
        if (r6 == null) goto L25;
        r6.onError(e);     // Catch: Throwable -> L26
    L25:
        return;
    L26:
        th = move-exception;
        throw th;
    }

    public void stopLocation() {
        monitor-enter(this);
        Logger.i("BDLocationClient:stopLocation");     // Catch: Throwable -> L6
        com.bytedance.bdlocation_impl.c.a.a().d();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void stopLocation(String r3) {
        monitor-enter(this);
        if (r3 != null) goto L16;
    L10:
        Logger.i("BDLocationClient:stopLocationForBusiness with null/empty businessId, calling legacy stopLocation");     // Catch: Throwable -> L13
        stopLocation();     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L16:
    L13:
        th = move-exception;
        throw th;
    L5:
        if (r3.isEmpty() == true) goto L10;
        Logger.i("BDLocationClient:stopLocationForBusiness: " + r3);     // Catch: Throwable -> L13
        com.bytedance.bdlocation_impl.c.a.a().a(r3);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
    }

    public void stopLocationBecauseEnterBackground() {
        monitor-enter(this);
        Logger.i("BDLocationClient:stopLocationBecauseEnterBackground");     // Catch: Throwable -> L6
        com.bytedance.bdlocation_impl.c.a.a().c();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
