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
import ha.m;
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
    private m mWifiInfoJson;
    private int triggerType;
    private long uploadInterval;
    private String uploadSource;

    public LocationUploadExtra() {
        this.mGpsAndBleMark = "";
        this.mOnceLocation = true;
        this.mIsRecommendWifiResults = true;
    }

    private BDScanLocationInfo waitGpsFinishForSteal(long r8) {
        BDLocationExtraDataServer r10 = this.mLocationExtraDataServer;
        if (r10 != null) goto L7;
        String r11 = "location-trace-core wait gps info, mLocationExtraDataServer == null, return null.";
    L5:
        Logger.i(r11);
        return null;
    L7:
        GpsInfoManager r12 = r10.getGpsInfoManager();
        if (r12 != null) goto L10;
        r11 = "location-trace-core wait gps info, gpsInfoManager == null, return null.";
        goto L5
    L10:
        BDScanLocationInfo r13 = r12.getScanLocationInfo();
        if (r13 != null) goto L14;
        r11 = "location-trace-core wait gps info, scanLocationInfo == null.";
        goto L5
    L14:
        if (r8 > 0) goto L16;
    L35:
        Logger.i("location-trace-core wait gps info, before get gps info, gps collect finished: " + r12.isCollectGpsFinishedForSteal());
        return r13;
    L16:
        if (r12.isCollectGpsFinishedForSteal() == true) goto L35;
        long r14 = SystemClock.elapsedRealtime();
        monitor-enter(r12);
    L39:
    L32:
        th = move-exception;
        throw th;
    L20:
        if (r12.isCollectGpsFinishedForSteal() == true) goto L29;
        long r15 = SystemClock.elapsedRealtime() - r14;
        if (r15 >= r8) goto L29;
        r12.wait(r8 - r15);     // Catch: InterruptedException -> L27 Throwable -> L32
    L27:
        e = move-exception;
        Logger.e("wait gps result error: " + e.getMessage(), e);     // Catch: Throwable -> L32
    L29:
        Logger.i("location-trace-core wait gps info, wait finished, isCollectedFinished: " + r12.isCollectGpsFinishedForSteal());     // Catch: Throwable -> L32
        monitor-exit(r12);     // Catch: Throwable -> L32
        goto L35
    }

    public BDGnssInfo findNearbyGnssInfo(BDGpsInfo r8) {
        BDScanLocationInfo r10 = waitGpsFinishForSteal(0);
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.findNearbyGnssInfo(r8);
    }

    public LocationInfo getAMapLocation() {
        BDLocationExtraDataServer r8 = this.mLocationExtraDataServer;
        if (r8 != null) goto L5;
        return null;
    L5:
        GpsInfoManager r10 = r8.getGpsInfoManager();
        if (r10 != null) goto L8;
        return null;
    L8:
        BDScanLocationInfo r11 = r10.getScanLocationInfo();
        if (r11 != null) goto L12;
        return null;
    L12:
        if (r11.getAMapLocation() != null) goto L15;
        return null;
    L15:
        return LocationUtil.bdLocationToLocationInfo(r11.getAMapLocation(), BDLocationConfig.isUploadGPS());
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
        BDLocationExtraDataServer r8 = this.mLocationExtraDataServer;
        if (r8 != null) goto L5;
        return "";
    L5:
        GpsInfoManager r10 = r8.getGpsInfoManager();
        if (r10 != null) goto L9;
        return "";
    L9:
        return r10.getContinuousGpsConfigCategory();
    }

    public long getCurrentStationDuration() {
        return this.mCurrentStationDuration;
    }

    public String getExtra() {
        return this.mExtra;
    }

    public List<BDGnssInfo> getGnssInfoList() {
        BDScanLocationInfo r8 = waitGpsFinishForSteal(0);
        if (r8 != null) goto L7;
        return new ArrayList();
    L7:
        return r8.getGnssInfoList();
    }

    public String getGpsAndBleMark() {
        return this.mGpsAndBleMark;
    }

    public BDGpsInfo getGpsInfo(BDScanLocationInfo.TakeStrategy r8) {
        return waitGpsInfo(0, r8);
    }

    public List<BDGpsInfo> getGpsInfoList() {
        BDScanLocationInfo r8 = waitGpsFinishForSteal(0);
        if (r8 != null) goto L7;
        return new ArrayList();
    L7:
        return r8.getGpsInfo();
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
        BDLocationExtraDataServer r8 = this.mLocationExtraDataServer;
        if (r8 != null) goto L5;
        return null;
    L5:
        GpsInfoManager r10 = r8.getGpsInfoManager();
        if (r10 != null) goto L8;
        return null;
    L8:
        BDScanLocationInfo r11 = r10.getScanLocationInfo();
        if (r11 != null) goto L12;
        return null;
    L12:
        if (r11.getSysLocation() != null) goto L15;
        return null;
    L15:
        return LocationUtil.bdLocationToLocationInfo(r11.getSysLocation(), BDLocationConfig.isUploadGPS());
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

    public m getWifiData() {
        return this.mWifiInfoJson;
    }

    public boolean isContinuousGpsInfo() {
        BDScanLocationInfo r8 = waitGpsFinishForSteal(0);
        if (r8 != null) goto L7;
        return false;
    L7:
        return r8.isContinuousGps();
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

    public void setBleList(List<BDBleInfo> r8) {
        this.mBleInfoList = r8;
    }

    public void setBpeaCert(Object r8) {
        this.mBpeaCert = r8;
    }

    public void setConnectedWifiInfo(WifiInfo r8) {
        this.mConnectedWifiInfo = r8;
    }

    public void setCurrentStationDuration(long r8) {
        this.mCurrentStationDuration = r8;
    }

    public void setExtra(String r8) {
        this.mExtra = r8;
    }

    public void setGpsAndBleMark(String r8) {
        this.mGpsAndBleMark = r8;
    }

    public void setLatestAdminVersion(boolean r8) {
        this.mLatestAdminVersion = r8;
    }

    public void setLightSubmitDuration(long r8) {
        this.mLightSubmitDuration = r8;
    }

    public void setLocateId(String r8) {
        this.mLocateId = r8;
    }

    public void setLocationExtraDataServer(BDLocationExtraDataServer r8) {
        this.mLocationExtraDataServer = r8;
    }

    public void setLocationTraceLogger(LocationTraceLogger r8) {
        this.mLocationTraceLogger = r8;
    }

    public void setLogIdCache(LogIdCacheEntity r8) {
        this.logIdCacheEntity = r8;
    }

    public void setOnceLocation(boolean r8) {
        this.mOnceLocation = r8;
    }

    public void setRecommendWifiResults(boolean r8) {
        this.mIsRecommendWifiResults = r8;
    }

    public void setStartLocationTime(long r8) {
        this.mStartLocationTime = r8;
    }

    public void setStartLocationTimestampInMillis(long r8) {
        this.mStartLocationTimestampInMillis = r8;
    }

    public void setStationarySceneCacheInfo(StationarySceneCacheInfo r8) {
        this.mStationarySceneCacheInfo = r8;
    }

    public void setTriggerType(int r8) {
        this.triggerType = r8;
    }

    public void setUploadInterval(long r8) {
        this.uploadInterval = r8;
    }

    public void setUploadSource(String r8) {
        this.uploadSource = r8;
    }

    public void setWifiCache(boolean r8) {
        this.mWifiCache = r8;
    }

    public void setWifiDate(m r8) {
        this.mWifiInfoJson = r8;
    }

    public BDGpsInfo waitGpsInfo(long r8, BDScanLocationInfo.TakeStrategy r10) {
        BDScanLocationInfo r11 = waitGpsFinishForSteal(r8);
        if (r11 != null) goto L6;
        return null;
    L6:
        BDGpsInfo r12 = r11.takeGpsInfo(r10);
        BDGnssInfo r13 = r11.findNearbyGnssInfo(r12);
        if (r12 == null) goto L11;
        if (r13 == null) goto L11;
        return new BDGpsInfo(r12, r13);
    L11:
        return r12;
    }
}
