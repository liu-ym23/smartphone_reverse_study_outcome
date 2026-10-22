package com.bytedance.bdlocation.scan.gps;

/* JADX INFO: loaded from: classes.dex */
public interface GpsCollectCallback {
    void onFail(int r1);

    void onSuccess(BDScanLocationInfo r1);
}
