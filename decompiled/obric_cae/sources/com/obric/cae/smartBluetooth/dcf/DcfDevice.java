package com.obric.cae.smartBluetooth.dcf;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DcfDevice {
    private static final long LIFE_TIME_THRESHOLD = 7000;
    private List<DcfDataElement> mDataElements;
    private String mDeviceId;
    private long mLastUpdateTime;
    private byte[] mRawData;

    public DcfDevice(String r8, List<DcfDataElement> r10, byte[] r11) {
        this.mLastUpdateTime = -1;
        this.mDeviceId = r8;
        this.mDataElements = r10;
        this.mRawData = r11;
        this.mLastUpdateTime = System.currentTimeMillis();
    }

    public boolean equals(Object r8) {
        if ((r8 instanceof DcfDevice) == true) goto L7;
        return false;
    L7:
        return Arrays.equals(this.mRawData, ((DcfDevice) r8).mRawData);
    }

    public List<DcfDataElement> getDataElements() {
        return this.mDataElements;
    }

    public String getDeviceId() {
        return this.mDeviceId;
    }

    public long getLastUpdateTime() {
        return this.mLastUpdateTime;
    }

    public byte[] getRawData() {
        return this.mRawData;
    }

    public int hashCode() {
        return Arrays.hashCode(this.mRawData);
    }

    public boolean isAlive() {
        return isAlive(0);
    }

    public void setDataElements(List<DcfDataElement> r8) {
        this.mDataElements = r8;
    }

    public void setDeviceId(String r8) {
        this.mDeviceId = r8;
    }

    public void updatePulseTime() {
        this.mLastUpdateTime = System.currentTimeMillis();
    }

    public boolean isAlive(long r8) {
        if ((System.currentTimeMillis() - this.mLastUpdateTime) > (r8 + LIFE_TIME_THRESHOLD)) goto L5;
        return true;
    L5:
        return false;
    }
}
