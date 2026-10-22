package com.sdk.bwdl.AdapterLayer;

import com.sdk.bwdl.BWDLDevice;

/* JADX INFO: loaded from: classes2.dex */
public interface IBWDLAdapter {
    void accept();

    void close();

    boolean connect(BWDLDevice r8);

    boolean disconnect(BWDLDevice r8);

    void encrypt(BWDLDevice r8);

    Object getCapabilities();

    boolean init();

    int isAdapterReady();

    void listen();

    int recv(byte[] r8);

    void removeBWDLAdapterEventListener(IBWDLAdapterEventListener r8);

    void send(BWDLDevice r8, byte[] r10);

    void setBWDLAdapterEventListener(IBWDLAdapterEventListener r8);

    void setBWDLAdapterEventListener(BWDLDevice r8, IBWDLAdapterEventListener r10);
}
