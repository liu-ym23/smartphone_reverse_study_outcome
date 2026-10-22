package com.obric.assistant.dora;

import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class IDoraPrivateProtocolService$Default implements IDoraPrivateProtocolService {
    public IDoraPrivateProtocolService$Default() {
    }

    public IBinder asBinder() {
        return null;
    }

    public int getConnectionState() throws RemoteException {
        return 0;
    }

    public DoraDeviceInfo getCurrentDeviceInfo() throws RemoteException {
        return null;
    }

    public void registerCallback(IDoraPrivateProtocolCallback r1) throws RemoteException {
    }

    public void registerCallbackWithExtra(IDoraPrivateProtocolCallback r1, String r2) throws RemoteException {
    }

    public void syncBatteryChanged(DoraDeviceInfo r1) throws RemoteException {
    }

    public void syncChargeStateChanged(DoraDeviceInfo r1) throws RemoteException {
    }

    public void syncConnectionState(int r1, DoraDeviceInfo r2) throws RemoteException {
    }

    public void unregisterCallback(IDoraPrivateProtocolCallback r1) throws RemoteException {
    }
}
