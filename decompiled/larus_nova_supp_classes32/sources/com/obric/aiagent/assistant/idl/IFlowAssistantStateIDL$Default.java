package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class IFlowAssistantStateIDL$Default implements IFlowAssistantStateIDL {
    public IFlowAssistantStateIDL$Default() {
    }

    public IBinder asBinder() {
        return null;
    }

    public int getCurrentNightMode() throws RemoteException {
        return 0;
    }

    public boolean isActive() throws RemoteException {
        return false;
    }

    public boolean isBackgroundIntercepting() throws RemoteException {
        return false;
    }

    public void registerActiveStateListener(IFlowAssistantActiveStateListenerIDL r1) throws RemoteException {
    }

    public void registerBackgroundInterceptingListener(IFlowBackgroundInterceptStateListenerIDL r1) throws RemoteException {
    }

    public void registerNightModeListener(IFlowNightModeChangeListenerIDL r1) throws RemoteException {
    }

    public void registerTTSStateListener(IFlowAssistantTTSStateListenerIDL r1) throws RemoteException {
    }

    public void unregisterActiveStateListener(IFlowAssistantActiveStateListenerIDL r1) throws RemoteException {
    }

    public void unregisterBackgroundInterceptingListener(IFlowBackgroundInterceptStateListenerIDL r1) throws RemoteException {
    }

    public void unregisterNightModeListener(IFlowNightModeChangeListenerIDL r1) throws RemoteException {
    }

    public void unregisterTTSStateListener(IFlowAssistantTTSStateListenerIDL r1) throws RemoteException {
    }
}
