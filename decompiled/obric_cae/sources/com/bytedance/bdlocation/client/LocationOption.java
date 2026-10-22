package com.bytedance.bdlocation.client;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.entity.LastLocationEntity;
import com.bytedance.bdlocation.entity.LocationExtraBean;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.bdlocation.monitor.LocationExtraDataTraceLogger;
import com.bytedance.bdlocation.monitor.LocationTraceLogger;
import com.bytedance.bdlocation.network.model.StationarySceneCacheInfo;
import com.bytedance.bdlocation.scan.gps.BDGnssInfo;
import com.bytedance.bdlocation.scan.gps.BDGpsInfo;
import com.bytedance.bdlocation.scan.gps.BDScanLocationInfo;
import com.bytedance.bdlocation.scan.gps.GpsInfoManager;
import com.bytedance.bdlocation.service.BDLocationExtraDataServer;

/* JADX INFO: loaded from: classes.dex */
public class LocationOption {
    public boolean alreadyCallback;
    private long backupIntervalMs;
    private boolean downGradeLocation;
    public boolean enableAMapBackgroundContiLocation;
    private int geocodeMode;
    private long interval;
    public volatile boolean isCallbackThroughLocateTrace;
    private boolean locationChanged;
    private LocationExtraBean locationExtraBean;
    private long locationTimeOutMs;
    private boolean mAMapGpsFirst;
    private long mAMapGpsFirstTimeoutMillis;
    private int mAccuracyLevel;
    private String mBpeaAction;
    private Object mBpeaCert;
    private String mBusinessId;
    private boolean mCert;
    private boolean mChineseRegion;
    private boolean mEnableUploadNetSignal;
    private String mExtra;
    private long mGpsTimeoutMs;
    private boolean mHitStationaryScene;
    private long mHostSwitchThreadDuration;
    private boolean mIsBackground;
    private boolean mIsIndoor;
    private LBSLightLocationTraceLogger mLBSLightLocationTraceLogger;
    private volatile LastLocationEntity mLastLocationEntity;
    private boolean mLatestAdminVersion;
    private volatile BDLocation mLightLocation;
    private volatile long mLightLocationWifiGap;
    private String mLocateId;
    private int mLocateType;
    private BDLocationExtraDataServer mLocationExtraDataServer;
    private LocationExtraDataTraceLogger mLocationExtraDataTraceLogger;
    private LocationTraceLogger mLocationTraceLogger;
    private float mMinUpdateDistance;
    private StationarySceneCacheInfo mStationarySceneCacheInfo;
    private boolean mSynchronizeUpload;
    private int mTriggerType;
    private long mUploadInterval;
    private long maxCacheTime;
    private int mode;
    private boolean onceLocation;
    private boolean sIsUpload;
    private boolean scanBle;
    public long startLocationElapsedRealtimeMillis;
    private long startLocationTime;
    public long startLocationTimestampInMillis;
    private String uploadSource;

    public LocationOption() {
        this.enableAMapBackgroundContiLocation = false;
        this.alreadyCallback = false;
        this.isCallbackThroughLocateTrace = false;
        this.mAccuracyLevel = 4;
        this.uploadSource = "";
        this.mBpeaAction = "";
        this.mLocateType = -1;
        this.sIsUpload = true;
        this.mTriggerType = 1;
        this.locationTimeOutMs = 30000;
        this.mCert = false;
        this.locationChanged = false;
        this.onceLocation = true;
        this.downGradeLocation = false;
        this.mHostSwitchThreadDuration = -1;
        this.mode = 2;
        this.maxCacheTime = 600000;
        this.geocodeMode = 1;
        this.mLatestAdminVersion = false;
        this.scanBle = true;
        this.mChineseRegion = true;
        this.mLocateId = "-1";
        this.mLightLocationWifiGap = -1;
        this.mSynchronizeUpload = true;
        this.mEnableUploadNetSignal = true;
    }

    public boolean enableUploadNetSignal() {
        return this.mEnableUploadNetSignal;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof LocationOption) == true) goto L8;
        return false;
    L8:
        LocationOption r10 = (LocationOption) r8;
        if (this.locationTimeOutMs == r10.locationTimeOutMs) goto L12;
        return false;
    L12:
        if (this.interval == r10.interval) goto L15;
        return false;
    L15:
        if (this.mHostSwitchThreadDuration == r10.mHostSwitchThreadDuration) goto L18;
        return false;
    L18:
        if (this.mAMapGpsFirst == r10.mAMapGpsFirst) goto L21;
        return false;
    L21:
        if (this.mAMapGpsFirstTimeoutMillis == r10.mAMapGpsFirstTimeoutMillis) goto L24;
        return false;
    L24:
        if (this.geocodeMode == r10.geocodeMode) goto L27;
        return false;
    L27:
        if (this.mIsIndoor == r10.mIsIndoor) goto L30;
        return false;
    L30:
        if (this.sIsUpload == r10.sIsUpload) goto L33;
        return false;
    L33:
        if (this.onceLocation == r10.onceLocation) goto L36;
        return false;
    L36:
        if (this.downGradeLocation == r10.downGradeLocation) goto L39;
        return false;
    L39:
        if (this.mLatestAdminVersion == r10.mLatestAdminVersion) goto L42;
        return false;
    L42:
        if (this.mCert == r10.mCert) goto L45;
        return false;
    L45:
        if (this.mTriggerType == r10.mTriggerType) goto L48;
        return false;
    L48:
        if (this.mLocateType == r10.mLocateType) goto L51;
        return false;
    L51:
        if (this.mAccuracyLevel == r10.mAccuracyLevel) goto L54;
        return false;
    L54:
        if (this.enableAMapBackgroundContiLocation == r10.enableAMapBackgroundContiLocation) goto L57;
        return false;
    L57:
        if (TextUtils.equals(this.uploadSource, r10.uploadSource) == true) goto L60;
        return false;
    L60:
        if (this.mBpeaCert == r10.mBpeaCert) goto L63;
        return false;
    L63:
        if (TextUtils.equals(this.mBpeaAction, r10.mBpeaAction) == true) goto L66;
        return false;
    L66:
        if (TextUtils.equals(this.mExtra, r10.mExtra) == true) goto L69;
        return false;
    L69:
        if (this.startLocationTime == r10.startLocationTime) goto L72;
        return false;
    L72:
        if (this.mLastLocationEntity == r10.mLastLocationEntity) goto L75;
        return false;
    L75:
        if (this.mLightLocationWifiGap == r10.mLightLocationWifiGap) goto L78;
        return false;
    L78:
        if (this.mSynchronizeUpload == r10.mSynchronizeUpload) goto L81;
        return false;
    L81:
        if (this.startLocationElapsedRealtimeMillis == r10.startLocationElapsedRealtimeMillis) goto L84;
        return false;
    L84:
        if (this.startLocationTimestampInMillis == r10.startLocationTimestampInMillis) goto L87;
        return false;
    L87:
        if (this.isCallbackThroughLocateTrace == r10.isCallbackThroughLocateTrace) goto L90;
        return false;
    L90:
        if (this.alreadyCallback == r10.alreadyCallback) goto L93;
        return false;
    L93:
        if (this.mHitStationaryScene == r10.mHitStationaryScene) goto L96;
        return false;
    L96:
        if (this.mStationarySceneCacheInfo == r10.mStationarySceneCacheInfo) goto L99;
        return false;
    L99:
        if (this.mMinUpdateDistance == r10.mMinUpdateDistance) goto L102;
        return false;
    L102:
        if (this.mGpsTimeoutMs == r10.mGpsTimeoutMs) goto L105;
        return false;
    L105:
        if (this.backupIntervalMs == r10.backupIntervalMs) goto L108;
        return false;
    L108:
        if (this.mEnableUploadNetSignal == r10.mEnableUploadNetSignal) goto L111;
        return false;
    L111:
        if (this.mode != r10.mode) goto L114;
        return true;
    L114:
        return false;
    }

    public long getAMapGpsFirstTimeoutMillis() {
        return this.mAMapGpsFirstTimeoutMillis;
    }

    public int getAccuracyLevel() {
        return this.mAccuracyLevel;
    }

    public long getBackupIntervalMs() {
        return this.backupIntervalMs;
    }

    public String getBpeaAction() {
        return this.mBpeaAction;
    }

    public Object getBpeaCert() {
        return this.mBpeaCert;
    }

    public String getBusinessId() {
        return this.mBusinessId;
    }

    public String getExtra() {
        return this.mExtra;
    }

    public int getGeocodeMode() {
        return this.geocodeMode;
    }

    public BDGpsInfo getGpsInfo() {
        BDLocationExtraDataServer r8 = this.mLocationExtraDataServer;
        if (r8 != null) goto L5;
        return null;
    L5:
        GpsInfoManager r10 = r8.getGpsInfoManager();
        if (r10 != null) goto L8;
        return null;
    L8:
        BDScanLocationInfo r11 = r10.getScanLocationInfo();
        if (r11 != null) goto L11;
        return null;
    L11:
        BDGpsInfo r12 = r11.takeGpsInfo(BDScanLocationInfo.TakeStrategy.lastResult);
        BDGnssInfo r13 = r11.findNearbyGnssInfo(r12);
        if (r12 == null) goto L16;
        if (r13 == null) goto L16;
        return new BDGpsInfo(r12, r13);
    L16:
        return r12;
    }

    public BDLocation getGpsLocation() {
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
        return r11.takeGpsLocation(BDScanLocationInfo.TakeStrategy.lastResult);
    }

    public long getGpsTimeoutMs() {
        return this.mGpsTimeoutMs;
    }

    public long getHostSwitchThreadDuration() {
        return this.mHostSwitchThreadDuration;
    }

    public long getInterval() {
        return this.interval;
    }

    public LBSLightLocationTraceLogger getLBSLightLocationTraceLogger() {
        return this.mLBSLightLocationTraceLogger;
    }

    public LastLocationEntity getLastLocationEntity() {
        return this.mLastLocationEntity;
    }

    public BDLocation getLightLocation() {
        return this.mLightLocation;
    }

    public long getLightLocationWifiGap() {
        return this.mLightLocationWifiGap;
    }

    public String getLocateId() {
        return this.mLocateId;
    }

    public int getLocateType() {
        return this.mLocateType;
    }

    public LocationExtraBean getLocationExtraBean() {
        return this.locationExtraBean;
    }

    public BDLocationExtraDataServer getLocationExtraDataServer() {
        return this.mLocationExtraDataServer;
    }

    public LocationExtraDataTraceLogger getLocationExtraDataTraceLogger() {
        return this.mLocationExtraDataTraceLogger;
    }

    public long getLocationTimeOutMs() {
        return this.locationTimeOutMs;
    }

    public LocationTraceLogger getLocationTraceLogger() {
        return this.mLocationTraceLogger;
    }

    public long getMaxCacheTime() {
        return this.maxCacheTime;
    }

    public float getMinUpdateDistance() {
        return this.mMinUpdateDistance;
    }

    public int getMode() {
        return this.mode;
    }

    public long getStartLocationTime() {
        return this.startLocationTime;
    }

    public StationarySceneCacheInfo getStationarySceneCacheInfo() {
        return this.mStationarySceneCacheInfo;
    }

    public BDLocation getSysLocation() {
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
        return r11.getSysLocation();
    }

    public int getTriggerType() {
        return this.mTriggerType;
    }

    public long getUploadInterval() {
        return this.mUploadInterval;
    }

    public String getUploadSource() {
        return this.uploadSource;
    }

    public int hashCode() {
        long r8 = this.locationTimeOutMs;
        long r10 = this.interval;
        int r11 = ((((int) (r8 ^ (r8 >>> 32))) * 31) + ((int) (r10 ^ (r10 >>> 32)))) * 31;
        long r12 = this.mHostSwitchThreadDuration;
        int r13 = (((((((((((r11 + ((int) (r12 ^ (r12 >>> 32)))) * 31) + this.mode) * 31) + this.mTriggerType) * 31) + this.mAccuracyLevel) * 31) + this.mLocateType) * 31) + this.geocodeMode) * 31;
        long r14 = this.maxCacheTime;
        int r15 = (((((((((((((r13 + ((int) (r14 ^ (r14 >>> 32)))) * 31) + (this.mIsIndoor ? 1 : 0)) * 31) + (this.sIsUpload ? 1 : 0)) * 31) + (this.mCert ? 1 : 0)) * 31) + (this.onceLocation ? 1 : 0)) * 31) + (this.downGradeLocation ? 1 : 0)) * 31) + (this.mLatestAdminVersion ? 1 : 0)) * 31;
        String r16 = this.uploadSource;
        int r17 = 0;
        if (r16 == null) goto L5;
        int r18 = r16.hashCode();
    L6:
        int r19 = (r15 + r18) * 31;
        Object r20 = this.mBpeaCert;
        if (r20 == null) goto L9;
        int r21 = r20.hashCode();
    L10:
        int r22 = (r19 + r21) * 31;
        String r23 = this.mBpeaAction;
        if (r23 == null) goto L13;
        int r24 = r23.hashCode();
    L14:
        int r25 = (r22 + r24) * 31;
        String r26 = this.mExtra;
        if (r26 == null) goto L17;
        int r27 = r26.hashCode();
    L18:
        long r28 = this.startLocationTime;
        int r29 = (Boolean.hashCode(this.mHitStationaryScene) + ((Boolean.hashCode(this.alreadyCallback) + ((Boolean.hashCode(this.isCallbackThroughLocateTrace) + ((Long.hashCode(this.startLocationTimestampInMillis) + ((Long.hashCode(this.startLocationElapsedRealtimeMillis) + ((((r25 + r27) * 31) + ((int) ((r28 >>> 32) ^ r28))) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        StationarySceneCacheInfo r30 = this.mStationarySceneCacheInfo;
        if (r30 == null) goto L22;
        r17 = r30.hashCode();
    L22:
        return Boolean.hashCode(this.mEnableUploadNetSignal) + ((Long.hashCode(this.backupIntervalMs) + ((Long.hashCode(this.mGpsTimeoutMs) + ((Float.hashCode(this.mMinUpdateDistance) + ((Long.hashCode(this.mAMapGpsFirstTimeoutMillis) + ((Boolean.hashCode(this.mAMapGpsFirst) + ((Boolean.hashCode(this.mSynchronizeUpload) + ((Boolean.hashCode(this.enableAMapBackgroundContiLocation) + ((r29 + r17) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    L17:
        r27 = 0;
        goto L18
    L13:
        r24 = 0;
        goto L14
    L9:
        r21 = 0;
        goto L10
    L5:
        r18 = 0;
        goto L6
    }

    public boolean isAMapGpsFirst() {
        return this.mAMapGpsFirst;
    }

    public boolean isBackground() {
        return this.mIsBackground;
    }

    public boolean isCert() {
        return this.mCert;
    }

    public boolean isChineseRegion() {
        return this.mChineseRegion;
    }

    public boolean isDownGradeLocation() {
        return this.downGradeLocation;
    }

    public boolean isHitStationaryScene() {
        return this.mHitStationaryScene;
    }

    public boolean isIndoor() {
        return this.mIsIndoor;
    }

    public boolean isLatestAdminVersion() {
        return this.mLatestAdminVersion;
    }

    public boolean isLocationChanged() {
        return this.locationChanged;
    }

    public boolean isOnceLocation() {
        return this.onceLocation;
    }

    public boolean isSynchronizeUpload() {
        return this.mSynchronizeUpload;
    }

    public boolean isUpload() {
        return this.sIsUpload;
    }

    public boolean scanBle() {
        return this.scanBle;
    }

    public void setAMapGpsFirst(boolean r8) {
        this.mAMapGpsFirst = r8;
    }

    public void setAMapGpsFirstTimeoutMillis(long r8) {
        this.mAMapGpsFirstTimeoutMillis = r8;
    }

    public void setAccuracyLevel(int r8) {
        this.mAccuracyLevel = r8;
    }

    public void setBackground(boolean r8) {
        this.mIsBackground = r8;
    }

    public void setBackupIntervalMs(long r8) {
        this.backupIntervalMs = r8;
    }

    public void setBpeaAction(String r8) {
        this.mBpeaAction = r8;
    }

    public void setBpeaCert(Object r8) {
        this.mBpeaCert = r8;
    }

    public void setBusinessId(String r8) {
        this.mBusinessId = r8;
    }

    public void setCert(boolean r8) {
        this.mCert = r8;
    }

    public void setChineseRegion(boolean r8) {
        this.mChineseRegion = r8;
    }

    public void setDownGradeLocation(boolean r8) {
        this.downGradeLocation = r8;
    }

    public void setEnableUploadNetSignal(boolean r8) {
        this.mEnableUploadNetSignal = r8;
    }

    public void setExtra(String r8) {
        this.mExtra = r8;
    }

    public void setGeocodeMode(int r8) {
        this.geocodeMode = r8;
    }

    public void setGpsTimeoutMs(long r8) {
        this.mGpsTimeoutMs = r8;
    }

    public void setHitStationaryScene(boolean r8) {
        this.mHitStationaryScene = r8;
    }

    public void setHostSwitchThreadDuration(long r8) {
        this.mHostSwitchThreadDuration = r8;
    }

    public void setIndoor(boolean r8) {
        this.mIsIndoor = r8;
    }

    public void setInterval(long r8) {
        this.interval = r8;
    }

    public void setLBSLightLocationTraceLogger(LBSLightLocationTraceLogger r8) {
        this.mLBSLightLocationTraceLogger = r8;
    }

    public void setLastLocationEntity(LastLocationEntity r8) {
        this.mLastLocationEntity = r8;
    }

    public void setLatestAdminVersion(boolean r8) {
        this.mLatestAdminVersion = r8;
    }

    public void setLightLocation(BDLocation r8) {
        this.mLightLocation = r8;
    }

    public void setLightLocationWifiGap(long r8) {
        this.mLightLocationWifiGap = r8;
    }

    public void setLocateId(String r8) {
        this.mLocateId = r8;
    }

    public void setLocateType(int r8) {
        this.mLocateType = r8;
    }

    public void setLocationChanged(boolean r8) {
        this.locationChanged = r8;
    }

    public void setLocationExtraBean(LocationExtraBean r8) {
        this.locationExtraBean = r8;
    }

    public void setLocationExtraDataServer(BDLocationExtraDataServer r8) {
        this.mLocationExtraDataServer = r8;
    }

    public void setLocationExtraDataTraceLogger(LocationExtraDataTraceLogger r8) {
        this.mLocationExtraDataTraceLogger = r8;
    }

    public void setLocationTimeOutMs(long r8) {
        if (r8 >= 5000) goto L5;
        r8 = 5000;
    L5:
        this.locationTimeOutMs = r8;
    }

    public void setLocationTraceLogger(LocationTraceLogger r8) {
        this.mLocationTraceLogger = r8;
    }

    public void setMaxCacheTime(long r8) {
        this.maxCacheTime = r8;
    }

    public void setMinUpdateDistance(float r8) {
        this.mMinUpdateDistance = r8;
    }

    public void setMode(int r8) {
        this.mode = r8;
    }

    public void setOnceLocation(boolean r8) {
        this.onceLocation = r8;
    }

    public void setScanBle(boolean r8) {
        this.scanBle = r8;
    }

    public void setStartLocationTime(long r8) {
        this.startLocationTime = r8;
    }

    public void setStationarySceneCacheInfo(StationarySceneCacheInfo r8) {
        this.mStationarySceneCacheInfo = r8;
    }

    public void setSynchronizeUpload(boolean r8) {
        this.mSynchronizeUpload = r8;
    }

    public void setTriggerType(int r8) {
        this.mTriggerType = r8;
    }

    public void setUpload(boolean r8) {
        this.sIsUpload = r8;
    }

    public void setUploadInterval(long r8) {
        this.mUploadInterval = r8;
    }

    public void setUploadSource(String r8) {
        this.uploadSource = r8;
    }

    public long timeToStartLocationInMillis() {
        return SystemClock.elapsedRealtime() - this.startLocationElapsedRealtimeMillis;
    }

    public String toString() {
        return "LocationOption{sIsUpload=" + this.sIsUpload + ", locationTimeOutMs=" + this.locationTimeOutMs + ", interval=" + this.interval + ", hostSwitchThreadDuration: " + this.mHostSwitchThreadDuration + ", amapGpsFirst: " + this.mAMapGpsFirst + ", amapGpsFirstTimeoutMillis: " + this.mAMapGpsFirstTimeoutMillis + ", mode=" + this.mode + ", triggerType=" + this.mTriggerType + ", triggerType=" + this.mLocateType + ", maxCacheTime=" + this.maxCacheTime + ", getGeocodeMode=" + this.geocodeMode + ", mIsIndoor=" + this.mIsIndoor + ", mCert=" + this.mCert + ", onceLocation=" + this.onceLocation + ", downGradeLocation=" + this.downGradeLocation + ", mLatestAdminVersion=" + this.mLatestAdminVersion + ", mBpeaAction=" + this.mBpeaAction + ", mExtra=" + this.mExtra + ", startLocationTime=" + this.startLocationTime + ", startLocationTimestampInMillis=" + this.startLocationElapsedRealtimeMillis + ", startLocationTimestampInMillis=" + this.startLocationTimestampInMillis + ", isCallbackThroughLocateTrace=" + this.isCallbackThroughLocateTrace + ", alreadyCallback=" + this.alreadyCallback + ", mHitStationaryScene=" + this.mHitStationaryScene + ", mStationarySceneCacheInfo=" + this.mStationarySceneCacheInfo + ", uploadSource=" + this.uploadSource + ", sync=" + this.mSynchronizeUpload + ", enableAMapBackgroundLocation=" + this.enableAMapBackgroundContiLocation + '}';
    }

    public LocationOption(LocationOption r8) {
        this.enableAMapBackgroundContiLocation = false;
        this.alreadyCallback = false;
        this.isCallbackThroughLocateTrace = false;
        this.mAccuracyLevel = 4;
        this.uploadSource = "";
        this.mBpeaAction = "";
        this.mLocateType = -1;
        this.sIsUpload = true;
        this.mTriggerType = 1;
        this.locationTimeOutMs = 30000;
        this.mCert = false;
        this.locationChanged = false;
        this.onceLocation = true;
        this.downGradeLocation = false;
        this.mHostSwitchThreadDuration = -1;
        this.mode = 2;
        this.maxCacheTime = 600000;
        this.geocodeMode = 1;
        this.mLatestAdminVersion = false;
        this.scanBle = true;
        this.mChineseRegion = true;
        this.mLocateId = "-1";
        this.mLightLocationWifiGap = -1;
        this.mSynchronizeUpload = true;
        this.mEnableUploadNetSignal = true;
        if (r8 != null) goto L5;
        return;
    L5:
        this.mLightLocationWifiGap = r8.mLightLocationWifiGap;
        this.mLastLocationEntity = r8.mLastLocationEntity;
        this.locationTimeOutMs = r8.locationTimeOutMs;
        this.interval = r8.interval;
        this.mHostSwitchThreadDuration = r8.mHostSwitchThreadDuration;
        this.mAMapGpsFirst = r8.mAMapGpsFirst;
        this.mAMapGpsFirstTimeoutMillis = r8.mAMapGpsFirstTimeoutMillis;
        this.mode = r8.mode;
        this.maxCacheTime = r8.maxCacheTime;
        this.geocodeMode = r8.geocodeMode;
        this.mIsIndoor = r8.mIsIndoor;
        this.uploadSource = r8.uploadSource;
        this.mBpeaCert = r8.mBpeaCert;
        this.mBpeaAction = r8.mBpeaAction;
        this.mAccuracyLevel = r8.mAccuracyLevel;
        this.enableAMapBackgroundContiLocation = r8.enableAMapBackgroundContiLocation;
        this.mTriggerType = r8.mTriggerType;
        this.mLocateType = r8.mLocateType;
        this.sIsUpload = r8.sIsUpload;
        this.onceLocation = r8.onceLocation;
        this.downGradeLocation = r8.downGradeLocation;
        this.mLatestAdminVersion = r8.mLatestAdminVersion;
        this.locationChanged = r8.locationChanged;
        this.mCert = r8.mCert;
        this.mUploadInterval = r8.mUploadInterval;
        this.startLocationTime = r8.startLocationTime;
        this.locationExtraBean = r8.locationExtraBean;
        this.scanBle = r8.scanBle;
        this.mChineseRegion = r8.mChineseRegion;
        this.mExtra = r8.mExtra;
        this.mLocationTraceLogger = r8.mLocationTraceLogger;
        this.mLocationExtraDataTraceLogger = r8.mLocationExtraDataTraceLogger;
        this.mSynchronizeUpload = r8.mSynchronizeUpload;
        this.mIsBackground = r8.mIsBackground;
        this.mLocateId = r8.mLocateId;
        this.mLBSLightLocationTraceLogger = r8.mLBSLightLocationTraceLogger;
        this.mLocationExtraDataServer = r8.mLocationExtraDataServer;
        this.mLightLocation = r8.mLightLocation;
        this.startLocationElapsedRealtimeMillis = r8.startLocationElapsedRealtimeMillis;
        this.startLocationTimestampInMillis = r8.startLocationTimestampInMillis;
        this.isCallbackThroughLocateTrace = r8.isCallbackThroughLocateTrace;
        this.alreadyCallback = r8.alreadyCallback;
        this.mHitStationaryScene = r8.mHitStationaryScene;
        this.mStationarySceneCacheInfo = r8.mStationarySceneCacheInfo;
        this.mMinUpdateDistance = r8.mMinUpdateDistance;
        this.mGpsTimeoutMs = r8.mGpsTimeoutMs;
        this.mEnableUploadNetSignal = r8.mEnableUploadNetSignal;
        this.backupIntervalMs = r8.backupIntervalMs;
        this.mBusinessId = r8.mBusinessId;
    }
}
