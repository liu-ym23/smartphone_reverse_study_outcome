package com.bytedance.bdlocation.scan.bluetooth;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BLECacheEntity {
    private List<BDBleInfo> bleInfoList;
    private long timeStamp;

    public BLECacheEntity() {
    }

    public List<BDBleInfo> getBleInfoList() {
        return this.bleInfoList;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public void setBleInfoList(List<BDBleInfo> r8) {
        this.bleInfoList = r8;
    }

    public void setTimeStamp(long r8) {
        this.timeStamp = r8;
    }
}
