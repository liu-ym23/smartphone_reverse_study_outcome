package com.bytedance.bdlocation.provider;

import com.bytedance.bdlocation.api.IRegionDataCore;
import com.bytedance.bdlocation.callback.RegionUploadCallback;
import com.bytedance.bdlocation.entity.region.RegionBean;

/* JADX INFO: loaded from: classes.dex */
public class DefaultRegionDataCore implements IRegionDataCore {
    public DefaultRegionDataCore() {
    }

    @Override // com.bytedance.bdlocation.api.IRegionDataCore
    public RegionBean getRegion(boolean r8) {
        return null;
    }

    @Override // com.bytedance.bdlocation.api.IRegionDataCore
    public void init() {
    }

    @Override // com.bytedance.bdlocation.api.IRegionDataCore
    public boolean uploadRegionInfo() {
        return false;
    }

    @Override // com.bytedance.bdlocation.api.IRegionDataCore
    public void uploadRegionInfoAsync(RegionUploadCallback r8) {
    }

    @Override // com.bytedance.bdlocation.api.IRegionDataCore
    public RegionBean getRegion(boolean r8, boolean r10) {
        return null;
    }
}
