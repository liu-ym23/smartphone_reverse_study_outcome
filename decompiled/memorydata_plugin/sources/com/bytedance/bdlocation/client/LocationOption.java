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
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.logging.log4j.message.StructuredDataId;

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
        this.mLocateId = StructuredDataId.RESERVED;
        this.mLightLocationWifiGap = -1;
        this.mSynchronizeUpload = true;
        this.mEnableUploadNetSignal = true;
    }

    public LocationOption(LocationOption r7) {
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
        this.mLocateId = StructuredDataId.RESERVED;
        this.mLightLocationWifiGap = -1;
        this.mSynchronizeUpload = true;
        this.mEnableUploadNetSignal = true;
        if (r7 != null) goto L5;
        return;
    L5:
        this.mLightLocationWifiGap = r7.mLightLocationWifiGap;
        this.mLastLocationEntity = r7.mLastLocationEntity;
        this.locationTimeOutMs = r7.locationTimeOutMs;
        this.interval = r7.interval;
        this.mHostSwitchThreadDuration = r7.mHostSwitchThreadDuration;
        this.mAMapGpsFirst = r7.mAMapGpsFirst;
        this.mAMapGpsFirstTimeoutMillis = r7.mAMapGpsFirstTimeoutMillis;
        this.mode = r7.mode;
        this.maxCacheTime = r7.maxCacheTime;
        this.geocodeMode = r7.geocodeMode;
        this.mIsIndoor = r7.mIsIndoor;
        this.uploadSource = r7.uploadSource;
        this.mBpeaCert = r7.mBpeaCert;
        this.mBpeaAction = r7.mBpeaAction;
        this.mAccuracyLevel = r7.mAccuracyLevel;
        this.enableAMapBackgroundContiLocation = r7.enableAMapBackgroundContiLocation;
        this.mTriggerType = r7.mTriggerType;
        this.mLocateType = r7.mLocateType;
        this.sIsUpload = r7.sIsUpload;
        this.onceLocation = r7.onceLocation;
        this.downGradeLocation = r7.downGradeLocation;
        this.mLatestAdminVersion = r7.mLatestAdminVersion;
        this.locationChanged = r7.locationChanged;
        this.mCert = r7.mCert;
        this.mUploadInterval = r7.mUploadInterval;
        this.startLocationTime = r7.startLocationTime;
        this.locationExtraBean = r7.locationExtraBean;
        this.scanBle = r7.scanBle;
        this.mChineseRegion = r7.mChineseRegion;
        this.mExtra = r7.mExtra;
        this.mLocationTraceLogger = r7.mLocationTraceLogger;
        this.mLocationExtraDataTraceLogger = r7.mLocationExtraDataTraceLogger;
        this.mSynchronizeUpload = r7.mSynchronizeUpload;
        this.mIsBackground = r7.mIsBackground;
        this.mLocateId = r7.mLocateId;
        this.mLBSLightLocationTraceLogger = r7.mLBSLightLocationTraceLogger;
        this.mLocationExtraDataServer = r7.mLocationExtraDataServer;
        this.mLightLocation = r7.mLightLocation;
        this.startLocationElapsedRealtimeMillis = r7.startLocationElapsedRealtimeMillis;
        this.startLocationTimestampInMillis = r7.startLocationTimestampInMillis;
        this.isCallbackThroughLocateTrace = r7.isCallbackThroughLocateTrace;
        this.alreadyCallback = r7.alreadyCallback;
        this.mHitStationaryScene = r7.mHitStationaryScene;
        this.mStationarySceneCacheInfo = r7.mStationarySceneCacheInfo;
        this.mMinUpdateDistance = r7.mMinUpdateDistance;
        this.mGpsTimeoutMs = r7.mGpsTimeoutMs;
        this.mEnableUploadNetSignal = r7.mEnableUploadNetSignal;
        this.backupIntervalMs = r7.backupIntervalMs;
        this.mBusinessId = r7.mBusinessId;
    }

    public boolean enableUploadNetSignal() {
        return this.mEnableUploadNetSignal;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, LocationOption.class) == true) goto L8;
        return false;
    L8:
        LocationOption r10 = (LocationOption) ZeusTransformUtils.preCheckCast(r9, LocationOption.class, "com.obric.memorydata.plugin");
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
        BDLocationExtraDataServer r2 = this.mLocationExtraDataServer;
        if (r2 != null) goto L5;
        return null;
    L5:
        GpsInfoManager r3 = r2.getGpsInfoManager();
        if (r3 != null) goto L8;
        return null;
    L8:
        BDScanLocationInfo r4 = r3.getScanLocationInfo();
        if (r4 != null) goto L11;
        return null;
    L11:
        BDGpsInfo r0 = r4.takeGpsInfo(BDScanLocationInfo.TakeStrategy.lastResult);
        BDGnssInfo r5 = r4.findNearbyGnssInfo(r0);
        if (r0 == null) goto L16;
        if (r5 == null) goto L16;
        return new BDGpsInfo(r0, r5);
    L16:
        return r0;
    }

    public BDLocation getGpsLocation() {
        BDLocationExtraDataServer r1 = this.mLocationExtraDataServer;
        if (r1 != null) goto L5;
        return null;
    L5:
        GpsInfoManager r2 = r1.getGpsInfoManager();
        if (r2 != null) goto L8;
        return null;
    L8:
        BDScanLocationInfo r3 = r2.getScanLocationInfo();
        if (r3 != null) goto L12;
        return null;
    L12:
        return r3.takeGpsLocation(BDScanLocationInfo.TakeStrategy.lastResult);
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
        BDLocationExtraDataServer r1 = this.mLocationExtraDataServer;
        if (r1 != null) goto L5;
        return null;
    L5:
        GpsInfoManager r2 = r1.getGpsInfoManager();
        if (r2 != null) goto L8;
        return null;
    L8:
        BDScanLocationInfo r3 = r2.getScanLocationInfo();
        if (r3 != null) goto L12;
        return null;
    L12:
        return r3.getSysLocation();
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
        long r0 = this.locationTimeOutMs;
        long r3 = this.interval;
        int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r4 = this.mHostSwitchThreadDuration;
        int r2 = (((((((((((r1 + ((int) (r4 ^ (r4 >>> 32)))) * 31) + this.mode) * 31) + this.mTriggerType) * 31) + this.mAccuracyLevel) * 31) + this.mLocateType) * 31) + this.geocodeMode) * 31;
        long r5 = this.maxCacheTime;
        int r6 = (((((((((((((r2 + ((int) (r5 ^ (r5 >>> 32)))) * 31) + (this.mIsIndoor ? 1 : 0)) * 31) + (this.sIsUpload ? 1 : 0)) * 31) + (this.mCert ? 1 : 0)) * 31) + (this.onceLocation ? 1 : 0)) * 31) + (this.downGradeLocation ? 1 : 0)) * 31) + (this.mLatestAdminVersion ? 1 : 0)) * 31;
        String r7 = this.uploadSource;
        int r8 = 0;
        if (r7 == null) goto L5;
        int r9 = r7.hashCode();
    L6:
        int r10 = (r6 + r9) * 31;
        Object r11 = this.mBpeaCert;
        if (r11 == null) goto L9;
        int r12 = r11.hashCode();
    L10:
        int r13 = (r10 + r12) * 31;
        String r14 = this.mBpeaAction;
        if (r14 == null) goto L13;
        int r15 = r14.hashCode();
    L14:
        int r16 = (r13 + r15) * 31;
        String r17 = this.mExtra;
        if (r17 == null) goto L17;
        int r18 = r17.hashCode();
    L18:
        long r19 = this.startLocationTime;
        int r20 = (((((((((((((r16 + r18) * 31) + ((int) ((r19 >>> 32) ^ r19))) * 31) + Long.hashCode(this.startLocationElapsedRealtimeMillis)) * 31) + Long.hashCode(this.startLocationTimestampInMillis)) * 31) + Boolean.hashCode(this.isCallbackThroughLocateTrace)) * 31) + Boolean.hashCode(this.alreadyCallback)) * 31) + Boolean.hashCode(this.mHitStationaryScene)) * 31;
        StationarySceneCacheInfo r21 = this.mStationarySceneCacheInfo;
        if (r21 == null) goto L22;
        r8 = r21.hashCode();
    L22:
        return ((((((((((((((((r20 + r8) * 31) + Boolean.hashCode(this.enableAMapBackgroundContiLocation)) * 31) + Boolean.hashCode(this.mSynchronizeUpload)) * 31) + Boolean.hashCode(this.mAMapGpsFirst)) * 31) + Long.hashCode(this.mAMapGpsFirstTimeoutMillis)) * 31) + Float.hashCode(this.mMinUpdateDistance)) * 31) + Long.hashCode(this.mGpsTimeoutMs)) * 31) + Long.hashCode(this.backupIntervalMs)) * 31) + Boolean.hashCode(this.mEnableUploadNetSignal);
    L17:
        r18 = 0;
        goto L18
    L13:
        r15 = 0;
        goto L14
    L9:
        r12 = 0;
        goto L10
    L5:
        r9 = 0;
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

    public void setAMapGpsFirst(boolean r1) {
        this.mAMapGpsFirst = r1;
    }

    public void setAMapGpsFirstTimeoutMillis(long r1) {
        this.mAMapGpsFirstTimeoutMillis = r1;
    }

    public void setAccuracyLevel(int r1) {
        this.mAccuracyLevel = r1;
    }

    public void setBackground(boolean r1) {
        this.mIsBackground = r1;
    }

    public void setBackupIntervalMs(long r1) {
        this.backupIntervalMs = r1;
    }

    public void setBpeaAction(String r1) {
        this.mBpeaAction = r1;
    }

    public void setBpeaCert(Object r1) {
        this.mBpeaCert = r1;
    }

    public void setBusinessId(String r1) {
        this.mBusinessId = r1;
    }

    public void setCert(boolean r1) {
        this.mCert = r1;
    }

    public void setChineseRegion(boolean r1) {
        this.mChineseRegion = r1;
    }

    public void setDownGradeLocation(boolean r1) {
        this.downGradeLocation = r1;
    }

    public void setEnableUploadNetSignal(boolean r1) {
        this.mEnableUploadNetSignal = r1;
    }

    public void setExtra(String r1) {
        this.mExtra = r1;
    }

    public void setGeocodeMode(int r1) {
        this.geocodeMode = r1;
    }

    public void setGpsTimeoutMs(long r1) {
        this.mGpsTimeoutMs = r1;
    }

    public void setHitStationaryScene(boolean r1) {
        this.mHitStationaryScene = r1;
    }

    public void setHostSwitchThreadDuration(long r1) {
        this.mHostSwitchThreadDuration = r1;
    }

    public void setIndoor(boolean r1) {
        this.mIsIndoor = r1;
    }

    public void setInterval(long r1) {
        this.interval = r1;
    }

    public void setLBSLightLocationTraceLogger(LBSLightLocationTraceLogger r1) {
        this.mLBSLightLocationTraceLogger = r1;
    }

    public void setLastLocationEntity(LastLocationEntity r1) {
        this.mLastLocationEntity = r1;
    }

    public void setLatestAdminVersion(boolean r1) {
        this.mLatestAdminVersion = r1;
    }

    public void setLightLocation(BDLocation r1) {
        this.mLightLocation = r1;
    }

    public void setLightLocationWifiGap(long r1) {
        this.mLightLocationWifiGap = r1;
    }

    public void setLocateId(String r1) {
        this.mLocateId = r1;
    }

    public void setLocateType(int r1) {
        this.mLocateType = r1;
    }

    public void setLocationChanged(boolean r1) {
        this.locationChanged = r1;
    }

    public void setLocationExtraBean(LocationExtraBean r1) {
        this.locationExtraBean = r1;
    }

    public void setLocationExtraDataServer(BDLocationExtraDataServer r1) {
        this.mLocationExtraDataServer = r1;
    }

    public void setLocationExtraDataTraceLogger(LocationExtraDataTraceLogger r1) {
        this.mLocationExtraDataTraceLogger = r1;
    }

    public void setLocationTimeOutMs(long r4) {
        if (r4 >= 5000) goto L5;
        r4 = 5000;
    L5:
        this.locationTimeOutMs = r4;
    }

    public void setLocationTraceLogger(LocationTraceLogger r1) {
        this.mLocationTraceLogger = r1;
    }

    public void setMaxCacheTime(long r1) {
        this.maxCacheTime = r1;
    }

    public void setMinUpdateDistance(float r1) {
        this.mMinUpdateDistance = r1;
    }

    public void setMode(int r1) {
        this.mode = r1;
    }

    public void setOnceLocation(boolean r1) {
        this.onceLocation = r1;
    }

    public void setScanBle(boolean r1) {
        this.scanBle = r1;
    }

    public void setStartLocationTime(long r1) {
        this.startLocationTime = r1;
    }

    public void setStationarySceneCacheInfo(StationarySceneCacheInfo r1) {
        this.mStationarySceneCacheInfo = r1;
    }

    public void setSynchronizeUpload(boolean r1) {
        this.mSynchronizeUpload = r1;
    }

    public void setTriggerType(int r1) {
        this.mTriggerType = r1;
    }

    public void setUpload(boolean r1) {
        this.sIsUpload = r1;
    }

    public void setUploadInterval(long r1) {
        this.mUploadInterval = r1;
    }

    public void setUploadSource(String r1) {
        this.uploadSource = r1;
    }

    public long timeToStartLocationInMillis() {
        return SystemClock.elapsedRealtime() - this.startLocationElapsedRealtimeMillis;
    }

    public String toString() {
        return "LocationOption{sIsUpload=" + this.sIsUpload + ", locationTimeOutMs=" + this.locationTimeOutMs + ", interval=" + this.interval + ", hostSwitchThreadDuration: " + this.mHostSwitchThreadDuration + ", amapGpsFirst: " + this.mAMapGpsFirst + ", amapGpsFirstTimeoutMillis: " + this.mAMapGpsFirstTimeoutMillis + ", mode=" + this.mode + ", triggerType=" + this.mTriggerType + ", triggerType=" + this.mLocateType + ", maxCacheTime=" + this.maxCacheTime + ", getGeocodeMode=" + this.geocodeMode + ", mIsIndoor=" + this.mIsIndoor + ", mCert=" + this.mCert + ", onceLocation=" + this.onceLocation + ", downGradeLocation=" + this.downGradeLocation + ", mLatestAdminVersion=" + this.mLatestAdminVersion + ", mBpeaAction=" + this.mBpeaAction + ", mExtra=" + this.mExtra + ", startLocationTime=" + this.startLocationTime + ", startLocationTimestampInMillis=" + this.startLocationElapsedRealtimeMillis + ", startLocationTimestampInMillis=" + this.startLocationTimestampInMillis + ", isCallbackThroughLocateTrace=" + this.isCallbackThroughLocateTrace + ", alreadyCallback=" + this.alreadyCallback + ", mHitStationaryScene=" + this.mHitStationaryScene + ", mStationarySceneCacheInfo=" + this.mStationarySceneCacheInfo + ", uploadSource=" + this.uploadSource + ", sync=" + this.mSynchronizeUpload + ", enableAMapBackgroundLocation=" + this.enableAMapBackgroundContiLocation + '}';
    }
}
