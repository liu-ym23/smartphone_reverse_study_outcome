package com.bytedance.bdlocation.entity.gis;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.network.model.BaseResp;
import com.bytedance.bdlocation.network.model.LocationResult;
import ia.b;

/* JADX INFO: loaded from: classes.dex */
public class BdGisResult {

    @b("BaseResp")
    public BaseResp baseResp;

    @b("IsDisputed")
    public boolean isDisputed;

    @b(LocationMonitorConst.LOCATION)
    public LocationResult location;

    public BdGisResult() {
    }

    public String toString() {
        return "BdGisResult{location=" + this.location + ", isDisputed=" + this.isDisputed + ", baseResp=" + this.baseResp + '}';
    }
}
