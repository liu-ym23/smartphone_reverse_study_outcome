package com.ss.bduploader;

/* JADX INFO: loaded from: classes6.dex */
public interface BDNetworkSpeedTestListener {
    public static final int ContextTypeSpeedTestFailed = 1;
    public static final int ContextTypeSpeedTestSuccess = 0;

    void onSpeedTestContext(int r1, int r2, String r3);

    int speedTestCheckNetState(int r1, int r2);
}
