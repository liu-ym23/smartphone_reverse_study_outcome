package com.bytedance.bdlocation.entity;

import com.bytedance.bdlocation.scan.bluetooth.BDBleInfo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LocationExtraBean {
    private List<BDBleInfo> bleInfoList;
    private LogIdCacheEntity logIdCacheEntity;

    public LocationExtraBean() {
    }

    public List<BDBleInfo> getBleInfoList() {
        return this.bleInfoList;
    }

    public LogIdCacheEntity getLogIdCacheEntity() {
        return this.logIdCacheEntity;
    }

    public void setBleInfoList(List<BDBleInfo> r8) {
        this.bleInfoList = r8;
    }

    public void setLogIdCacheEntity(LogIdCacheEntity r8) {
        this.logIdCacheEntity = r8;
    }
}
