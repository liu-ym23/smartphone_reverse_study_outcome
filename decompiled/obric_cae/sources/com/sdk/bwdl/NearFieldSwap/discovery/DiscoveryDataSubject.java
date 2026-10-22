package com.sdk.bwdl.NearFieldSwap.discovery;

import com.sdk.bwdl.ExternalAPI.BWDLDiscoveryData;
import com.sdk.bwdl.NearFieldSwap.callback.BWDLDiscoveryCallback;

/* JADX INFO: loaded from: classes2.dex */
public interface DiscoveryDataSubject {
    void notifyDiscoveryConnect(int r8);

    void notifyDiscoveryResult(short r8, byte r10, BWDLDiscoveryData r11);

    void registerObserver(int r8, BWDLDiscoveryCallback r10);

    void registerObserver(short r8, int r10, BWDLDiscoveryCallback r11);

    void registerObserver(short r8, BWDLDiscoveryCallback r10);

    void unregisterObserver(BWDLDiscoveryCallback r8);

    void unregisterObserver(short r8, int r10, BWDLDiscoveryCallback r11);

    void unregisterObserver(short r8, BWDLDiscoveryCallback r10);
}
