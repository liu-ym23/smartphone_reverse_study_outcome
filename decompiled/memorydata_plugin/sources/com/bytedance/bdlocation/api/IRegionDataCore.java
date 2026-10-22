package com.bytedance.bdlocation.api;

import com.bytedance.bdlocation.callback.RegionUploadCallback;
import com.bytedance.bdlocation.entity.region.RegionBean;

/* JADX INFO: loaded from: classes.dex */
public interface IRegionDataCore extends IManager {
    RegionBean getRegion(boolean r1);

    RegionBean getRegion(boolean r1, boolean r2);

    void init();

    boolean uploadRegionInfo();

    void uploadRegionInfoAsync(RegionUploadCallback r1);
}
