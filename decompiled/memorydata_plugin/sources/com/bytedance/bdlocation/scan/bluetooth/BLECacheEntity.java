package com.bytedance.bdlocation.scan.bluetooth;

import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    public void setBleInfoList(List<BDBleInfo> r3) {
        this.bleInfoList = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public void setTimeStamp(long r1) {
        this.timeStamp = r1;
    }
}
