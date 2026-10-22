package com.obric.aiagent.assistant.idl;

import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class IFlowFrontierIDL$Default implements IFlowFrontierIDL {
    public IFlowFrontierIDL$Default() {
    }

    public IBinder asBinder() {
        return null;
    }

    public void cacheScreenshot(int r1, Bitmap r2, Map r3) throws RemoteException {
    }

    public void cacheScreenshotFd(int r1, String r2, ParcelFileDescriptor r3, Map r4) throws RemoteException {
    }

    public int getState() throws RemoteException {
        return 0;
    }

    public void registerDataListener(int r1, IFlowFrontierDataListenerIDL r2) throws RemoteException {
    }

    public void registerStateListener(int r1, IFlowFrontierStateListenerIDL r2) throws RemoteException {
    }

    public void sendData(int r1, byte[] r2, Map r3) throws RemoteException {
    }

    public void unregisterDataListener(int r1, IFlowFrontierDataListenerIDL r2) throws RemoteException {
    }

    public void unregisterStateListener(int r1, IFlowFrontierStateListenerIDL r2) throws RemoteException {
    }
}
