package com.bytedance.bdlocation.network.model;

import com.bytedance.bdlocation.scan.gps.BDGpsInfo;

/* JADX INFO: loaded from: classes.dex */
public class StationarySceneCacheInfo {
    private BDGpsInfo gpsInfo;
    private String locateId;
    private LocationResult locationResult;

    public StationarySceneCacheInfo() {
    }

    public BDGpsInfo getGpsInfo() {
        return this.gpsInfo;
    }

    public String getLocateId() {
        return this.locateId;
    }

    public LocationResult getLocationResult() {
        return this.locationResult;
    }

    public void setGpsInfo(BDGpsInfo r8) {
        this.gpsInfo = r8;
    }

    public void setLocateId(String r8) {
        this.locateId = r8;
    }

    public void setLocationResult(LocationResult r8) {
        this.locationResult = r8;
    }
}
