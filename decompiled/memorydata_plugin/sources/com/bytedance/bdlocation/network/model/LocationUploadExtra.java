package com.bytedance.bdlocation.network.model;

import android.os.SystemClock;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.entity.LogIdCacheEntity;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationTraceLogger;
import com.bytedance.bdlocation.scan.bluetooth.BDBleInfo;
import com.bytedance.bdlocation.scan.gps.BDGnssInfo;
import com.bytedance.bdlocation.scan.gps.BDGpsInfo;
import com.bytedance.bdlocation.scan.gps.BDScanLocationInfo;
import com.bytedance.bdlocation.scan.gps.GpsInfoManager;
import com.bytedance.bdlocation.service.BDLocationExtraDataServer;
import com.google.gson.JsonArray;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LocationUploadExtra {
    public volatile LocationOption locationOption;
    private LogIdCacheEntity logIdCacheEntity;
    private List<BDBleInfo> mBleInfoList;
    private Object mBpeaCert;
    private WifiInfo mConnectedWifiInfo;
    private long mCurrentStationDuration;
    private String mExtra;
    private String mGpsAndBleMark;
    private boolean mIsRecommendWifiResults;
    private boolean mLatestAdminVersion;
    private long mLightSubmitDuration;
    private String mLocateId;
    private BDLocationExtraDataServer mLocationExtraDataServer;
    private LocationTraceLogger mLocationTraceLogger;
    private boolean mOnceLocation;
    private BDScanLocationInfo mScanLocationInfo;
    private long mStartLocationTime;
    private long mStartLocationTimestampInMillis;
    private StationarySceneCacheInfo mStationarySceneCacheInfo;
    private boolean mWifiCache;
    private JsonArray mWifiInfoJson;
    private int triggerType;
    private long uploadInterval;
    private String uploadSource;

    public LocationUploadExtra() {
        this.mGpsAndBleMark = "";
        this.mOnceLocation = true;
        this.mIsRecommendWifiResults = true;
    }

    private BDScanLocationInfo waitGpsFinishForSteal(long r7) {
        BDLocationExtraDataServer r6 = this.mLocationExtraDataServer;
        if (r6 != null) goto L7;
        String r8 = "location-trace-core wait gps info, mLocationExtraDataServer == null, return null.";
    L5:
        Logger.i(r8);
        return null;
    L7:
        GpsInfoManager r9 = r6.getGpsInfoManager();
        if (r9 != null) goto L10;
        r8 = "location-trace-core wait gps info, gpsInfoManager == null, return null.";
        goto L5
    L10:
        BDScanLocationInfo r1 = r9.getScanLocationInfo();
        if (r1 != null) goto L14;
        r8 = "location-trace-core wait gps info, scanLocationInfo == null.";
        goto L5
    L14:
        if (r7 > 0) goto L16;
    L35:
        Logger.i("location-trace-core wait gps info, before get gps info, gps collect finished: " + r9.isCollectGpsFinishedForSteal());
        return r1;
    L16:
        if (r9.isCollectGpsFinishedForSteal() == true) goto L35;
        long r2 = SystemClock.elapsedRealtime();
        monitor-enter(r9);
    L39:
    L32:
        th = move-exception;
        throw th;
    L20:
        if (r9.isCollectGpsFinishedForSteal() == true) goto L29;
        long r4 = SystemClock.elapsedRealtime() - r2;
        if (r4 >= r7) goto L29;
        r9.wait(r7 - r4);     // Catch: InterruptedException -> L27 Throwable -> L32
    L27:
        e = move-exception;
        Logger.e("wait gps result error: " + e.getMessage(), e);     // Catch: Throwable -> L32
    L29:
        Logger.i("location-trace-core wait gps info, wait finished, isCollectedFinished: " + r9.isCollectGpsFinishedForSteal());     // Catch: Throwable -> L32
        monitor-exit(r9);     // Catch: Throwable -> L32
        goto L35
    }

    public BDGnssInfo findNearbyGnssInfo(BDGpsInfo r3) {
        BDScanLocationInfo r2 = waitGpsFinishForSteal(0);
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.findNearbyGnssInfo(r3);
    }

    public LocationInfo getAMapLocation() {
        BDLocationExtraDataServer r2 = this.mLocationExtraDataServer;
        if (r2 != null) goto L5;
        return null;
    L5:
        GpsInfoManager r3 = r2.getGpsInfoManager();
        if (r3 != null) goto L8;
        return null;
    L8:
        BDScanLocationInfo r4 = r3.getScanLocationInfo();
        if (r4 != null) goto L12;
        return null;
    L12:
        if (r4.getAMapLocation() != null) goto L15;
        return null;
    L15:
        return LocationUtil.bdLocationToLocationInfo(r4.getAMapLocation(), BDLocationConfig.isUploadGPS());
    }

    public List<BDBleInfo> getBleList() {
        return this.mBleInfoList;
    }

    public Object getBpeaCert() {
        return this.mBpeaCert;
    }

    public WifiInfo getConnectedWifiInfo() {
        return this.mConnectedWifiInfo;
    }

    public String getContinuousGpsConfigCategory() {
        BDLocationExtraDataServer r1 = this.mLocationExtraDataServer;
        if (r1 != null) goto L5;
        return "";
    L5:
        GpsInfoManager r2 = r1.getGpsInfoManager();
        if (r2 != null) goto L9;
        return "";
    L9:
        return r2.getContinuousGpsConfigCategory();
    }

    public long getCurrentStationDuration() {
        return this.mCurrentStationDuration;
    }

    public String getExtra() {
        return this.mExtra;
    }

    public List<BDGnssInfo> getGnssInfoList() {
        BDScanLocationInfo r2 = waitGpsFinishForSteal(0);
        if (r2 != null) goto L7;
        return new ArrayList();
    L7:
        return r2.getGnssInfoList();
    }

    public String getGpsAndBleMark() {
        return this.mGpsAndBleMark;
    }

    public BDGpsInfo getGpsInfo(BDScanLocationInfo.TakeStrategy r3) {
        return waitGpsInfo(0, r3);
    }

    public List<BDGpsInfo> getGpsInfoList() {
        BDScanLocationInfo r2 = waitGpsFinishForSteal(0);
        if (r2 != null) goto L7;
        return new ArrayList();
    L7:
        return r2.getGpsInfo();
    }

    public long getLightSubmitDuration() {
        return this.mLightSubmitDuration;
    }

    public String getLocateId() {
        return this.mLocateId;
    }

    public BDLocationExtraDataServer getLocationExtraDataServer() {
        return this.mLocationExtraDataServer;
    }

    public LocationTraceLogger getLocationTraceLogger() {
        return this.mLocationTraceLogger;
    }

    public LogIdCacheEntity getLogIdCache() {
        return this.logIdCacheEntity;
    }

    public long getStartLocationTime() {
        return this.mStartLocationTime;
    }

    public long getStartLocationTimestampInMillis() {
        return this.mStartLocationTimestampInMillis;
    }

    public StationarySceneCacheInfo getStationarySceneCacheInfo() {
        return this.mStationarySceneCacheInfo;
    }

    public LocationInfo getSysLocation() {
        BDLocationExtraDataServer r2 = this.mLocationExtraDataServer;
        if (r2 != null) goto L5;
        return null;
    L5:
        GpsInfoManager r3 = r2.getGpsInfoManager();
        if (r3 != null) goto L8;
        return null;
    L8:
        BDScanLocationInfo r4 = r3.getScanLocationInfo();
        if (r4 != null) goto L12;
        return null;
    L12:
        if (r4.getSysLocation() != null) goto L15;
        return null;
    L15:
        return LocationUtil.bdLocationToLocationInfo(r4.getSysLocation(), BDLocationConfig.isUploadGPS());
    }

    public int getTriggerType() {
        return this.triggerType;
    }

    public long getUploadInterval() {
        return this.uploadInterval;
    }

    public String getUploadSource() {
        return this.uploadSource;
    }

    public JsonArray getWifiData() {
        return this.mWifiInfoJson;
    }

    public boolean isContinuousGpsInfo() {
        BDScanLocationInfo r2 = waitGpsFinishForSteal(0);
        if (r2 != null) goto L7;
        return false;
    L7:
        return r2.isContinuousGps();
    }

    public boolean isLatestAdminVersion() {
        return this.mLatestAdminVersion;
    }

    public boolean isOnceLocation() {
        return this.mOnceLocation;
    }

    public boolean isRecommendWifiResults() {
        return this.mIsRecommendWifiResults;
    }

    public boolean isWifiCache() {
        return this.mWifiCache;
    }

    public void setBleList(List<BDBleInfo> r3) {
        this.mBleInfoList = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public void setBpeaCert(Object r1) {
        this.mBpeaCert = r1;
    }

    public void setConnectedWifiInfo(WifiInfo r1) {
        this.mConnectedWifiInfo = r1;
    }

    public void setCurrentStationDuration(long r1) {
        this.mCurrentStationDuration = r1;
    }

    public void setExtra(String r1) {
        this.mExtra = r1;
    }

    public void setGpsAndBleMark(String r1) {
        this.mGpsAndBleMark = r1;
    }

    public void setLatestAdminVersion(boolean r1) {
        this.mLatestAdminVersion = r1;
    }

    public void setLightSubmitDuration(long r1) {
        this.mLightSubmitDuration = r1;
    }

    public void setLocateId(String r1) {
        this.mLocateId = r1;
    }

    public void setLocationExtraDataServer(BDLocationExtraDataServer r1) {
        this.mLocationExtraDataServer = r1;
    }

    public void setLocationTraceLogger(LocationTraceLogger r1) {
        this.mLocationTraceLogger = r1;
    }

    public void setLogIdCache(LogIdCacheEntity r1) {
        this.logIdCacheEntity = r1;
    }

    public void setOnceLocation(boolean r1) {
        this.mOnceLocation = r1;
    }

    public void setRecommendWifiResults(boolean r1) {
        this.mIsRecommendWifiResults = r1;
    }

    public void setStartLocationTime(long r1) {
        this.mStartLocationTime = r1;
    }

    public void setStartLocationTimestampInMillis(long r1) {
        this.mStartLocationTimestampInMillis = r1;
    }

    public void setStationarySceneCacheInfo(StationarySceneCacheInfo r1) {
        this.mStationarySceneCacheInfo = r1;
    }

    public void setTriggerType(int r1) {
        this.triggerType = r1;
    }

    public void setUploadInterval(long r1) {
        this.uploadInterval = r1;
    }

    public void setUploadSource(String r1) {
        this.uploadSource = r1;
    }

    public void setWifiCache(boolean r1) {
        this.mWifiCache = r1;
    }

    public void setWifiDate(JsonArray r1) {
        this.mWifiInfoJson = r1;
    }

    public BDGpsInfo waitGpsInfo(long r1, BDScanLocationInfo.TakeStrategy r3) {
        BDScanLocationInfo r0 = waitGpsFinishForSteal(r1);
        if (r0 != null) goto L6;
        return null;
    L6:
        BDGpsInfo r2 = r0.takeGpsInfo(r3);
        BDGnssInfo r4 = r0.findNearbyGnssInfo(r2);
        if (r2 == null) goto L11;
        if (r4 == null) goto L11;
        return new BDGpsInfo(r2, r4);
    L11:
        return r2;
    }
}
