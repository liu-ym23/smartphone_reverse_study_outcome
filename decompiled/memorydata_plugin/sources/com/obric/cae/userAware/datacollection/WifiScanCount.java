package com.obric.cae.userAware.datacollection;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public class WifiScanCount {
    private int mDateScanCount;
    private int mDateScanDropCount;
    private int mScanType;
    private int mSceneType;
    private long mTimeStamp;

    public WifiScanCount() {
        this.mSceneType = -1;
    }

    public WifiScanCount(WifiScanCount r3) {
        this.mSceneType = -1;
        if (r3 != null) goto L5;
        return;
    L5:
        this.mTimeStamp = r3.mTimeStamp;
        this.mSceneType = r3.mSceneType;
        this.mScanType = r3.mScanType;
        this.mDateScanCount = r3.mDateScanCount;
        this.mDateScanDropCount = r3.mDateScanDropCount;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (r7 != null) goto L8;
    L23:
        return false;
    L8:
        if (getClass() != r7.getClass()) goto L23;
        WifiScanCount r8 = (WifiScanCount) ZeusTransformUtils.preCheckCast(r7, WifiScanCount.class, "com.obric.memorydata.plugin");
        if (this.mTimeStamp != r8.mTimeStamp) goto L22;
        if (this.mScanType != r8.mScanType) goto L22;
        if (this.mDateScanCount != r8.mDateScanCount) goto L22;
        if (this.mSceneType != r8.mSceneType) goto L22;
        if (this.mDateScanDropCount != r8.mDateScanDropCount) goto L22;
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
        long r0 = (((((this.mTimeStamp * 31) + ((long) this.mScanType)) * 31) + ((long) this.mDateScanDropCount)) * 31) + ((long) this.mDateScanCount);
        return (int) (r0 ^ (r0 >>> 32));
    }

    public void setDateScanCount(int r1) {
        this.mDateScanCount = r1;
    }

    public void setDateScanDropCount(int r1) {
        this.mDateScanDropCount = r1;
    }

    public void setScanType(int r1) {
        this.mScanType = r1;
    }

    public void setSceneType(int r1) {
        this.mSceneType = r1;
    }

    public void setTimeStamp(long r1) {
        this.mTimeStamp = r1;
    }

    public String toString() {
        return "WifiScanCount{mTimeStamp=" + this.mTimeStamp + ", mSceneType=" + this.mSceneType + ", mScanType=" + this.mScanType + ", mDateScanCount=" + this.mDateScanCount + ", mDateScanDropCount=" + this.mDateScanDropCount + '}';
    }
}
