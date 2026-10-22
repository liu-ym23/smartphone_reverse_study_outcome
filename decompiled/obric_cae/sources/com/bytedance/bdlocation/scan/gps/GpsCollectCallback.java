package com.bytedance.bdlocation.scan.gps;

/* JADX INFO: loaded from: classes.dex */
public interface GpsCollectCallback {
    void onFail(int r8);

    void onSuccess(BDScanLocationInfo r8);
}
