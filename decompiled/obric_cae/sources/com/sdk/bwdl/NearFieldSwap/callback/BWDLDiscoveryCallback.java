package com.sdk.bwdl.NearFieldSwap.callback;

import com.sdk.bwdl.ExternalAPI.BWDLDiscoveryData;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface BWDLDiscoveryCallback {
    void onDiscoveryConnected(int r8);

    void onDiscoveryDataChanged(short r8, byte r10, BWDLDiscoveryData r11);

    void onDiscoveryDevicesChanged(List<BWDLDiscoveryData> r8);
}
