package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.RemoteException;
import com.obric.aiagent.assistant.idl.bean.OTaskTimeoutConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class IFlowAppIntentIDL$Default implements IFlowAppIntentIDL {
    public IFlowAppIntentIDL$Default() {
    }

    public IBinder asBinder() {
        return null;
    }

    public boolean checkPermission(String r1, boolean r2, long r3) throws RemoteException {
        return false;
    }

    public long currentTimeMillis() throws RemoteException {
        return 0;
    }

    public void getLocation(IFlowGetLocationCallbackIDL r1) throws RemoteException {
    }

    public OTaskTimeoutConfig getObricTaskTimeoutConfig() throws RemoteException {
        return null;
    }

    public String getUserId() throws RemoteException {
        return null;
    }

    public boolean isDoraConnected() throws RemoteException {
        return false;
    }

    public boolean isEnterpriseAccount() throws RemoteException {
        return false;
    }

    public boolean isLogin() throws RemoteException {
        return false;
    }

    public void jumpDoraPage() throws RemoteException {
    }

    public boolean openMiniApp(String r1) throws RemoteException {
        return false;
    }

    public void setAppIntentActive(boolean r1) throws RemoteException {
    }

    public void stopComplexTask(String r1) throws RemoteException {
    }

    public boolean syncAppletData(String r1) throws RemoteException {
        return false;
    }
}
