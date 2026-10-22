package com.sdk.bwdl.AdapterLayer.GATT.GattAdapter;

import android.content.Context;
import com.sdk.bwdl.AdapterLayer.GATT.GATTEnhance.BluetoothLeManager;
import com.sdk.bwdl.AdapterLayer.IBWDLAdapter;
import com.sdk.bwdl.AdapterLayer.IBWDLAdapterEventListener;
import com.sdk.bwdl.BWDLDevice;

/* JADX INFO: loaded from: classes2.dex */
public class GattCustomized implements IBWDLAdapter, IGattInterface {
    private static volatile GattCustomized sInstance;
    private BluetoothLeManager mBluetoothLeManager;
    private Context mContext;

    public GattCustomized(Context r8) {
        this.mContext = r8;
    }

    public static GattCustomized getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(GattCustomized.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new GattCustomized(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(GattCustomized.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public void accept() {
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public void close() {
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public boolean connect(BWDLDevice r8) {
        return false;
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public boolean disconnect(BWDLDevice r8) {
        return false;
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public void encrypt(BWDLDevice r8) {
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public Object getCapabilities() {
        return null;
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public boolean init() {
        return false;
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public int isAdapterReady() {
        return 0;
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public void listen() {
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public int recv(byte[] r8) {
        return 0;
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public void removeBWDLAdapterEventListener(IBWDLAdapterEventListener r8) {
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public void send(BWDLDevice r8, byte[] r10) {
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public void setBWDLAdapterEventListener(IBWDLAdapterEventListener r8) {
    }

    @Override // com.sdk.bwdl.AdapterLayer.IBWDLAdapter
    public void setBWDLAdapterEventListener(BWDLDevice r8, IBWDLAdapterEventListener r10) {
    }
}
