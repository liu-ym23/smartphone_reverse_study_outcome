package com.bytedance.bdlocation.api;

import com.bytedance.bdlocation.callback.RegionUploadCallback;
import com.bytedance.bdlocation.entity.region.RegionBean;

/* JADX INFO: loaded from: classes.dex */
public interface IRegionDataCore extends IManager {
    RegionBean getRegion(boolean r8);

    RegionBean getRegion(boolean r8, boolean r10);

    void init();

    boolean uploadRegionInfo();

    void uploadRegionInfoAsync(RegionUploadCallback r8);
}
