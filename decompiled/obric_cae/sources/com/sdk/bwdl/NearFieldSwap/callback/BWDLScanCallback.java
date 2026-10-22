package com.sdk.bwdl.NearFieldSwap.callback;

import com.sdk.bwdl.ExternalAPI.BWDLDiscoveryData;

/* JADX INFO: loaded from: classes2.dex */
public interface BWDLScanCallback {
    void onScanConnected(int r8);

    void onScanDataChanged(short r8, byte r10, BWDLDiscoveryData r11);
}
