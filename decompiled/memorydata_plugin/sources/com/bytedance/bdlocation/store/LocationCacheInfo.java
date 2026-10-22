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

    public void setLatestLocation(BDLocation r1) {
        this.mLatestLocation = r1;
    }

    public void setLatestLocationCacheCondition(int r1) {
        this.mLatestLocationCacheCondition = r1;
    }

    public void setLatestLocationCacheTime(long r1) {
        this.mLatestLocationCacheTime = r1;
    }

    public void setMockLocation(BDLocation r1) {
        this.mMockLocation = r1;
    }

    public void setNextGpsScanInterval(long r1) {
        this.mNextGpsScanInterval = r1;
    }

    public void setRecommendLocation(boolean r1) {
        this.mIsRecommendLocation = r1;
    }

    public String toString() {
        return "LocationCacheInfo{, mLatestLocation=" + this.mLatestLocation + ", mMockLocation=" + this.mMockLocation + '}';
    }
}
