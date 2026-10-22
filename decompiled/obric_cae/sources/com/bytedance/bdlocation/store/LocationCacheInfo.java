package com.bytedance.bdlocation.store;

import com.bytedance.bdlocation.BDLocation;

/* JADX INFO: loaded from: classes.dex */
public class LocationCacheInfo {
    private boolean mIsRecommendLocation;
    private volatile BDLocation mLatestLocation;
    private int mLatestLocationCacheCondition;
    private long mLatestLocationCacheTime;
    private BDLocation mMockLocation;
    private long mNextGpsScanInterval;

    public LocationCacheInfo() {
        this.mLatestLocationCacheCondition = -1;
        this.mLatestLocationCacheTime = -1;
        this.mNextGpsScanInterval = 0;
        this.mIsRecommendLocation = true;
    }

    public BDLocation getLatestLocation() {
        return this.mLatestLocation;
    }

    public int getLatestLocationCacheCondition() {
        return this.mLatestLocationCacheCondition;
    }

    public long getLatestLocationCacheTime() {
        return this.mLatestLocationCacheTime;
    }

    public BDLocation getMockLocation() {
        return this.mMockLocation;
    }

    public long getNextGpsScanInterval() {
        return this.mNextGpsScanInterval;
    }

    public boolean isRecommendLocation() {
        return this.mIsRecommendLocation;
    }

    public void setLatestLocation(BDLocation r8) {
        this.mLatestLocation = r8;
    }

    public void setLatestLocationCacheCondition(int r8) {
        this.mLatestLocationCacheCondition = r8;
    }

    public void setLatestLocationCacheTime(long r8) {
        this.mLatestLocationCacheTime = r8;
    }

    public void setMockLocation(BDLocation r8) {
        this.mMockLocation = r8;
    }

    public void setNextGpsScanInterval(long r8) {
        this.mNextGpsScanInterval = r8;
    }

    public void setRecommendLocation(boolean r8) {
        this.mIsRecommendLocation = r8;
    }

    public String toString() {
        return "LocationCacheInfo{, mLatestLocation=" + this.mLatestLocation + ", mMockLocation=" + this.mMockLocation + '}';
    }
}
