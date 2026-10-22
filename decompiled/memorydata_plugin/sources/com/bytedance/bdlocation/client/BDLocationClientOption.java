package com.bytedance.bdlocation.client;

/* JADX INFO: loaded from: classes.dex */
public class BDLocationClientOption {
    private boolean mAMapGpsFirst;
    private long mAMapGpsFirstTimeoutMillis;
    private int mAccuracyLevel;
    private long mBackupIntervalMs;
    private Object mBpeaCert;
    private String mBusinessId;
    private boolean mCert;
    private boolean mEnableAMapBackgroundContiLocation;
    private String mExtra;
    private long mGpsTimeoutMs;
    private long mHostSwitchThreadDuration;
    private long mInterval;
    private boolean mLatestAdminVersion;
    private int mLocateType;
    private int mLocationMode;
    private long mLocationTimeOut;
    private long mMaxCacheTime;
    private boolean mSynchronizeUpload;
    private int mTriggerType;
    private boolean mUpload;
    private String mUploadSource;

    public BDLocationClientOption() {
        this.mEnableAMapBackgroundContiLocation = false;
        this.mTriggerType = 1;
        this.mAccuracyLevel = 4;
        this.mLocationMode = 2;
        this.mLocateType = 3;
        this.mMaxCacheTime = 600000;
        this.mLocationTimeOut = 30000;
        this.mUploadSource = "";
        this.mInterval = 0;
        this.mCert = false;
        this.mLatestAdminVersion = false;
        this.mUpload = true;
        this.mHostSwitchThreadDuration = -1;
        this.mSynchronizeUpload = true;
    }

    public long getAMapGpsFirstTimeoutMillis() {
        return this.mAMapGpsFirstTimeoutMillis;
    }

    public int getAccuracyLevel() {
        return this.mAccuracyLevel;
    }

    public long getBackupIntervalMs() {
        return this.mBackupIntervalMs;
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

    public long getGpsTimeoutMs() {
        return this.mGpsTimeoutMs;
    }

    public long getHostSwitchThreadDuration() {
        return this.mHostSwitchThreadDuration;
    }

    public long getInterval() {
        return this.mInterval;
    }

    public int getLocateType() {
        return this.mLocateType;
    }

    public int getLocationMode() {
        return this.mLocationMode;
    }

    public long getLocationTimeOut() {
        return this.mLocationTimeOut;
    }

    public long getMaxCacheTime() {
        return this.mMaxCacheTime;
    }

    public int getTriggerType() {
        return this.mTriggerType;
    }

    public String getUploadSource() {
        return this.mUploadSource;
    }

    public boolean isAMapGpsFirst() {
        return this.mAMapGpsFirst;
    }

    public boolean isCert() {
        return this.mCert;
    }

    public boolean isEnableAMapBackgroundContiLocation() {
        return this.mEnableAMapBackgroundContiLocation;
    }

    public boolean isLatestAdminVersion() {
        return this.mLatestAdminVersion;
    }

    public boolean isSynchronizeUpload() {
        return this.mSynchronizeUpload;
    }

    public boolean isUpload() {
        return this.mUpload;
    }

    public BDLocationClientOption setAMapGpsFirst(boolean r1) {
        this.mAMapGpsFirst = r1;
        return this;
    }

    public BDLocationClientOption setAMapGpsFirstTimeoutMillis(long r1) {
        this.mAMapGpsFirstTimeoutMillis = r1;
        return this;
    }

    public BDLocationClientOption setAccuracyLevel(int r1) {
        this.mAccuracyLevel = r1;
        return this;
    }

    public BDLocationClientOption setBackupIntervalMs(long r1) {
        this.mBackupIntervalMs = r1;
        return this;
    }

    public BDLocationClientOption setBpeaCert(Object r1) {
        this.mBpeaCert = r1;
        return this;
    }

    public BDLocationClientOption setBusinessId(String r1) {
        this.mBusinessId = r1;
        return this;
    }

    public BDLocationClientOption setCert(boolean r1) {
        this.mCert = r1;
        return this;
    }

    public BDLocationClientOption setEnableAMapBackgroundContiLocation(boolean r1) {
        this.mEnableAMapBackgroundContiLocation = r1;
        return this;
    }

    public void setExtra(String r1) {
        this.mExtra = r1;
    }

    public BDLocationClientOption setGpsTimeoutMs(long r1) {
        this.mGpsTimeoutMs = r1;
        return this;
    }

    public BDLocationClientOption setHostSwitchThreadDuration(long r1) {
        this.mHostSwitchThreadDuration = r1;
        return this;
    }

    public BDLocationClientOption setInterval(long r1) {
        this.mInterval = r1;
        return this;
    }

    public BDLocationClientOption setLatestAdminVersion(boolean r1) {
        this.mLatestAdminVersion = r1;
        return this;
    }

    public BDLocationClientOption setLocateType(int r1) {
        this.mLocateType = r1;
        return this;
    }

    public BDLocationClientOption setLocationMode(int r1) {
        this.mLocationMode = r1;
        return this;
    }

    public BDLocationClientOption setLocationTimeOut(long r1) {
        this.mLocationTimeOut = r1;
        return this;
    }

    public BDLocationClientOption setMaxCacheTime(long r1) {
        this.mMaxCacheTime = r1;
        return this;
    }

    public BDLocationClientOption setSynchronizeUpload(boolean r1) {
        this.mSynchronizeUpload = r1;
        return this;
    }

    public BDLocationClientOption setTriggerType(int r1) {
        this.mTriggerType = r1;
        return this;
    }

    public void setUpload(boolean r1) {
        this.mUpload = r1;
    }

    public BDLocationClientOption setUploadSource(String r1) {
        this.mUploadSource = r1;
        return this;
    }
}
