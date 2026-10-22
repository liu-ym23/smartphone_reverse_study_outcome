package com.bytedance.bdlocation.provider;

import com.bytedance.bdlocation.api.IRegionDataCore;
import com.bytedance.bdlocation.callback.RegionUploadCallback;
import com.bytedance.bdlocation.entity.region.RegionBean;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class DefaultRegionDataCore implements IRegionDataCore {
    public DefaultRegionDataCore() {
    }

    @Override // com.bytedance.bdlocation.api.IRegionDataCore
    public RegionBean getRegion(boolean r1) {
        return null;
    }

    @Override // com.bytedance.bdlocation.api.IRegionDataCore
    public RegionBean getRegion(boolean r1, boolean r2) {
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
    public void uploadRegionInfoAsync(RegionUploadCallback r2) {
        RegionUploadCallback r1 = (RegionUploadCallback) ZeusTransformUtils.wrapperContextForParams(r2, RegionUploadCallback.class, "com.obric.memorydata.plugin");
    }
}
