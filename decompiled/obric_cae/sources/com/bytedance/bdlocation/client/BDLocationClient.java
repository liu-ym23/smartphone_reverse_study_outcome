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
import m5.a;
import o5.g;
import o5.i;
import o5.j;
import o5.k;

/* JADX INFO: loaded from: classes.dex */
public class BDLocationClient {
    public static String COMMON_UPLOAD_SOURCE = "from_client";
    private Context mContext;
    private LocationOption mOption;

    public BDLocationClient(Context r8) {
        this.mContext = r8;
    }

    private LocationOption getOption(BDLocationClientOption r8) {
        LocationOption r10 = new LocationOption();
        r10.setLocateType(r8.getLocateType());
        r10.setLocationTimeOutMs(r8.getLocationTimeOut());
        r10.setMaxCacheTime(r8.getMaxCacheTime());
        r10.setUploadSource(r8.getUploadSource());
        r10.setCert(r8.isCert());
        r10.setAccuracyLevel(r8.getAccuracyLevel());
        r10.setInterval(r8.getInterval());
        r10.setHostSwitchThreadDuration(r8.getHostSwitchThreadDuration());
        r10.setTriggerType(r8.getTriggerType());
        r10.setMode(r8.getLocationMode());
        r10.setBpeaCert(r8.getBpeaCert());
        r10.setLatestAdminVersion(r8.isLatestAdminVersion());
        r10.setUpload(r8.isUpload());
        r10.enableAMapBackgroundContiLocation = r8.isEnableAMapBackgroundContiLocation();
        r10.setSynchronizeUpload(r8.isSynchronizeUpload());
        r10.setAMapGpsFirst(r8.isAMapGpsFirst());
        r10.setAMapGpsFirstTimeoutMillis(r8.getAMapGpsFirstTimeoutMillis());
        if (TextUtils.isEmpty(r10.getUploadSource()) == false) goto L5;
        r10.setUploadSource(COMMON_UPLOAD_SOURCE);
    L5:
        r10.setExtra(r8.getExtra());
        r10.setGpsTimeoutMs(r8.getGpsTimeoutMs());
        r10.setBackupIntervalMs(r8.getBackupIntervalMs());
        r10.setBusinessId(r8.getBusinessId());
        return r10;
    }

    private long getPollUploadInterval() {
        return a.a().b();
    }

    public BDLocation getLocation() {
        Logger.d("BDLocationClient:getLocation synchronization");
        LocationTraceLogger r8 = new LocationTraceLogger();
        r8.begin("total_duration");
        r8.begin(LocationMonitorConst.LOCATION_RULE_CHECK_DURATION);
        LBSLightLocationTraceLogger r10 = new LBSLightLocationTraceLogger();
        r10.begin(LBSLightLocationTraceLogger.TOTAL);
        r10.begin(LBSLightLocationTraceLogger.PREPARE);
        if (initIfNeed() == true) goto L6;
        Logger.i("BDLocationClient:getLocation not init");
        r8.locationErrorReport(new BDLocationException(BDLocationExceptionMessage.NOT_INITIALIZATION, LocationInfoConst.BDLOCATION, BDLocationException.ERROR_INIT_LOCATION));
        return null;
    L6:
        LocationOption r11 = this.mOption;
        if (r11 == null) goto L10;
        r11.setLocationTraceLogger(r8);
        this.mOption.setLBSLightLocationTraceLogger(r10);
        this.mOption.setOnceLocation(true);
        this.mOption.setBpeaAction("getLocationCert");
        LocationUtil.checkBpeaCertNull("execLocation", this.mOption.getBpeaCert());
        return g.j().h(new LocationOption(this.mOption));
    L10:
        Logger.i("BDLocationClient:getLocation option is null");
        BDLocationException r12 = new BDLocationException(BDLocationExceptionMessage.LOCATION_OPTION_IS_NULL, "unknown", BDLocationException.ERROR_LOCATION_OPTION);
        r8.locationErrorReport(r12);
        throw r12;
    }

    public boolean initIfNeed() {
        if (BDLocationConfig.initIfNeed() == false) goto L6;
        return true;
    L6:
        Logger.i("Must be called after BDLocation initialization!");
        return false;
    }

    public void reportNotInitError(LocationTraceLogger r8, BDLocationCallback r10) {
        if (r10 != null) goto L9;
        return;
    L9:
        BDLocationException r11 = new BDLocationException(BDLocationExceptionMessage.NOT_INITIALIZATION, LocationInfoConst.BDLOCATION, BDLocationException.ERROR_INIT_LOCATION);     // Catch: Throwable -> L6
        r10.onError(r11);     // Catch: Throwable -> L6
        r8.locationErrorReport(r11);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        Logger.e("reportNotInitError error: " + th);
        th.printStackTrace();
    }

    public void setClientOption(BDLocationClientOption r8) {
        if (r8.getBpeaCert() != null) goto L5;
        Logger.i("setClientOption bpea cert is null");
    L5:
        LocationOption r10 = getOption(r8);
        this.mOption = r10;
        if (r10 != null) goto L8;
        return;
    L8:
        if (r10.getMaxCacheTime() > 0) goto L10;
        return;
    L10:
        if (BDLocationConfig.isPollingUpload() == false) goto L15;
        this.mOption.setMaxCacheTime(getPollUploadInterval());
        return;
    }

    public void startLocation(BDLocationCallback r8) {
        monitor-enter(this);
        Logger.d("BDLocationClient:startLocation");     // Catch: Throwable -> L25
        if (initIfNeed() == true) goto L9;
        if (r8 == null) goto L7;
        r8.onError(new BDLocationException(BDLocationExceptionMessage.NOT_INITIALIZATION, LocationInfoConst.BDLOCATION, BDLocationException.ERROR_INIT_LOCATION));     // Catch: Throwable -> L25
    L7:
        monitor-exit(this);     // Catch: Throwable -> L25
        return;
    L9:
        LocationOption r10 = this.mOption;     // Catch: Throwable -> L25
        if (r10 != null) goto L15;
        if (r8 == null) goto L15;
        r8.onError(new BDLocationException(BDLocationExceptionMessage.LOCATION_OPTION_IS_NULL, "unknown", BDLocationException.ERROR_LOCATION_OPTION));     // Catch: Throwable -> L25
        monitor-exit(this);     // Catch: Throwable -> L25
        return;
    L15:
        r10.setOnceLocation(false);     // Catch: Throwable -> L25
        this.mOption.setBpeaAction("startLocation");     // Catch: Throwable -> L25
        LocationUtil.checkBpeaCertNull("startLocation", this.mOption.getBpeaCert());     // Catch: BDLocationException -> L20 Throwable -> L25
        g.j().s(r8, new LocationOption(this.mOption));     // Catch: Throwable -> L25
        monitor-exit(this);     // Catch: Throwable -> L25
        return;
    L20:
        e = move-exception;
        if (r8 == null) goto L24;
        r8.onError(e);     // Catch: Throwable -> L25
    L24:
        return;
    L25:
        th = move-exception;
        throw th;
    }

    public void stopLocation() {
        monitor-enter(this);
        Logger.i("BDLocationClient:stopLocation");     // Catch: Throwable -> L6
        g r8 = g.j();     // Catch: Throwable -> L6
        r8.getClass();     // Catch: Throwable -> L6
        Logger.i("BDLocationService.stopLocation.");     // Catch: Throwable -> L6
        g.f9675m.post(new j(r8));     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void stopLocationBecauseEnterBackground() {
        monitor-enter(this);
        Logger.i("BDLocationClient:stopLocationBecauseEnterBackground");     // Catch: Throwable -> L6
        g r8 = g.j();     // Catch: Throwable -> L6
        r8.getClass();     // Catch: Throwable -> L6
        Logger.i("BDLocationService.stopLocationBecauseEnterBackground.");     // Catch: Throwable -> L6
        g.f9675m.post(new i(r8));     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void getLocation(BDLocationCallback r8) {
        Logger.d("BDLocationClient:getLocation asynchronous");
        LocationTraceLogger r10 = new LocationTraceLogger();
        r10.begin("total_duration");
        r10.begin(LocationMonitorConst.LOCATION_RULE_CHECK_DURATION);
        LBSLightLocationTraceLogger r11 = new LBSLightLocationTraceLogger();
        r11.begin(LBSLightLocationTraceLogger.TOTAL);
        r11.begin(LBSLightLocationTraceLogger.PREPARE);
        r11.begin(LBSLightLocationTraceLogger.SUB_PREPARE);
        if (initIfNeed() == true) goto L7;
        String r12 = "BDLocationClient:getLocation not init";
    L5:
        Logger.i(r12);
        reportNotInitError(r10, r8);
        return;
    L7:
        LocationOption r13 = this.mOption;
        if (r13 != null) goto L11;
        if (r8 == null) goto L11;
        r12 = "BDLocationClient:getLocation option is null";
    L11:
        r13.setLocationTraceLogger(r10);
        this.mOption.setLBSLightLocationTraceLogger(r11);
        this.mOption.setOnceLocation(true);
        this.mOption.setBpeaAction("getLocation");
        LocationUtil.checkBpeaCertNull("getLocation", this.mOption.getBpeaCert());     // Catch: BDLocationException -> L15
        g.j().s(r8, new LocationOption(this.mOption));
        return;
    L15:
        e = move-exception;
        if (r8 == null) goto L18;
        r8.onError(e);
    L18:
        r10.locationErrorReport(e);
    }

    public void stopLocation(String r8) {
        monitor-enter(this);
        if (r8 != null) goto L17;
    L11:
        Logger.i("BDLocationClient:stopLocationForBusiness with null/empty businessId, calling legacy stopLocation");     // Catch: Throwable -> L14
        stopLocation();     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L17:
    L14:
        th = move-exception;
        throw th;
    L6:
        if (r8.isEmpty() == true) goto L11;
        Logger.i("BDLocationClient:stopLocationForBusiness: ".concat(r8));     // Catch: Throwable -> L14
        g r10 = g.j();     // Catch: Throwable -> L14
        r10.getClass();     // Catch: Throwable -> L14
        Logger.i("BDLocationService.stopLocationForBusiness: ".concat(r8));     // Catch: Throwable -> L14
        g.f9675m.post(new k(r10, r8));     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
    }
}
