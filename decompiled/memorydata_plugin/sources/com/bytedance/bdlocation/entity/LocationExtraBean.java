package com.bytedance.bdlocation.entity;

import com.bytedance.bdlocation.scan.bluetooth.BDBleInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    public void setBleInfoList(List<BDBleInfo> r3) {
        this.bleInfoList = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public void setLogIdCacheEntity(LogIdCacheEntity r1) {
        this.logIdCacheEntity = r1;
    }
}
