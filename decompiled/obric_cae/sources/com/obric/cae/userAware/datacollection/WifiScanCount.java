package com.obric.cae.userAware.datacollection;

import android.aimedia.a;

/* JADX INFO: loaded from: classes2.dex */
public class WifiScanCount {
    private int mDateScanCount;
    private int mDateScanDropCount;
    private int mScanType;
    private int mSceneType;
    private long mTimeStamp;

    public WifiScanCount() {
        this.mSceneType = -1;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 != null) goto L8;
    L23:
        return false;
    L8:
        if (getClass() != r8.getClass()) goto L23;
        WifiScanCount r10 = (WifiScanCount) r8;
        if (this.mTimeStamp != r10.mTimeStamp) goto L22;
        if (this.mScanType != r10.mScanType) goto L22;
        if (this.mDateScanCount != r10.mDateScanCount) goto L22;
        if (this.mSceneType != r10.mSceneType) goto L22;
        if (this.mDateScanDropCount != r10.mDateScanDropCount) goto L22;
        return true;
    L22:
        return false;
    }

    public int getDateScanCount() {
        return this.mDateScanCount;
    }

    public int getDateScanDropCount() {
        return this.mDateScanDropCount;
    }

    public int getScanType() {
        return this.mScanType;
    }

    public int getSceneType() {
        return this.mSceneType;
    }

    public long getTimeStamp() {
        return this.mTimeStamp;
    }

    public int hashCode() {
        long r8 = (((((this.mTimeStamp * 31) + ((long) this.mScanType)) * 31) + ((long) this.mDateScanDropCount)) * 31) + ((long) this.mDateScanCount);
        return (int) (r8 ^ (r8 >>> 32));
    }

    public void setDateScanCount(int r8) {
        this.mDateScanCount = r8;
    }

    public void setDateScanDropCount(int r8) {
        this.mDateScanDropCount = r8;
    }

    public void setScanType(int r8) {
        this.mScanType = r8;
    }

    public void setSceneType(int r8) {
        this.mSceneType = r8;
    }

    public void setTimeStamp(long r8) {
        this.mTimeStamp = r8;
    }

    public String toString() {
        StringBuilder r8 = new StringBuilder("WifiScanCount{mTimeStamp=");
        r8.append(this.mTimeStamp);
        r8.append(", mSceneType=");
        r8.append(this.mSceneType);
        r8.append(", mScanType=");
        r8.append(this.mScanType);
        r8.append(", mDateScanCount=");
        r8.append(this.mDateScanCount);
        r8.append(", mDateScanDropCount=");
        return a.f(r8, this.mDateScanDropCount, '}');
    }

    public WifiScanCount(WifiScanCount r8) {
        this.mSceneType = -1;
        if (r8 != null) goto L5;
        return;
    L5:
        this.mTimeStamp = r8.mTimeStamp;
        this.mSceneType = r8.mSceneType;
        this.mScanType = r8.mScanType;
        this.mDateScanCount = r8.mDateScanCount;
        this.mDateScanDropCount = r8.mDateScanDropCount;
    }
}
