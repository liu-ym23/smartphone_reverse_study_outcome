package com.sdk.bwdl.AdapterLayer;

import com.sdk.bwdl.BWDLDevice;

/* JADX INFO: loaded from: classes2.dex */
public interface IBWDLAdapterEventListener {
    void onBondStateChanged(BWDLDevice r8, int r10);

    void onConnectTimeOut(IBWDLAdapter r8);

    void onConnected(IBWDLAdapter r8);

    void onConnectionStateChanged(BWDLDevice r8, int r10);

    void onDataReceived(byte[] r8);

    void onDisconnected(IBWDLAdapter r8);

    void onWriteComplete(int r8);
}
