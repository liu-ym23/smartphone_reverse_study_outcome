package com.bytedance.bdlocation.network.model;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
public class RefreshBaseStationInfo {
    public static final int NOT_REFRESH_BASE_STATION = 0;
    public static final int REFRESH_BASE_STATION_FAILED = 2;
    public static final int REFRESH_BASE_STATION_SUCCESS = 1;
    public static final int SDK_VERSION_CAN_NOT_REFRESH = 3;
    public CountDownLatch downLatch;
    private BaseStation mBaseStation;
    private int mRequestCellInfoResult;

    public RefreshBaseStationInfo() {
        this.downLatch = new CountDownLatch(1);
        this.mRequestCellInfoResult = 0;
    }

    public BaseStation getBaseStation() {
        return this.mBaseStation;
    }

    public int getRequestCellInfoResult() {
        return this.mRequestCellInfoResult;
    }

    public void setBaseStation(BaseStation r8) {
        this.mBaseStation = r8;
    }

    public void setRequestCellInfoResult(int r8) {
        this.mRequestCellInfoResult = r8;
    }
}
