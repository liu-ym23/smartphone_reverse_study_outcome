package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class IFlowAppStateIDL$Default implements IFlowAppStateIDL {
    public IFlowAppStateIDL$Default() {
    }

    public IBinder asBinder() {
        return null;
    }

    public String getCurrentActivity() throws RemoteException {
        return null;
    }

    public boolean isAppBackground() throws RemoteException {
        return false;
    }

    public boolean isAppPaused() throws RemoteException {
        return false;
    }

    public void registerAppStateListener(IFlowOnAppStateChangedListenerIDL r1) throws RemoteException {
    }

    public void unregisterAppStateListener(IFlowOnAppStateChangedListenerIDL r1) throws RemoteException {
    }
}
