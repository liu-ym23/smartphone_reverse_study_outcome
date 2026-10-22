package com.obric.aiagent.flow.applog.idl;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class IFlowAppLogIDL$Default implements IFlowAppLogIDL {
    public IFlowAppLogIDL$Default() {
    }

    public void addDataObserver(IFlowAppLogDataObserverIDL r1) throws RemoteException {
    }

    public void addEventObserver(IFlowAppLogEventObserverIDL r1) throws RemoteException {
    }

    public void addSessionHook(IFlowAppLogSessionObserverIDL r1) throws RemoteException {
    }

    public IBinder asBinder() {
        return null;
    }

    public void clearLaunchService() throws RemoteException {
    }

    public String getDid() throws RemoteException {
        return null;
    }

    public String getIid() throws RemoteException {
        return null;
    }

    public String getSsid() throws RemoteException {
        return null;
    }

    public String getUserID() throws RemoteException {
        return null;
    }

    public String getUserUniqueID() throws RemoteException {
        return null;
    }

    public void onEventV3(String r1) throws RemoteException {
    }

    public void onEventV3Bundle(String r1, Bundle r2) throws RemoteException {
    }

    public void onEventV3Json(String r1, String r2) throws RemoteException {
    }

    public void onPause() throws RemoteException {
    }

    public void onResume(String r1, int r2) throws RemoteException {
    }

    public void onStop() throws RemoteException {
    }

    public void removeDataObserver(IFlowAppLogDataObserverIDL r1) throws RemoteException {
    }

    public void removeEventObserver(IFlowAppLogEventObserverIDL r1) throws RemoteException {
    }

    public void removeSessionHook(IFlowAppLogSessionObserverIDL r1) throws RemoteException {
    }

    public void setHeaderInfo(Map r1) throws RemoteException {
    }

    public void setLaunchService(String r1) throws RemoteException {
    }
}
