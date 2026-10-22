package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.RemoteException;
import com.obric.aiagent.assistant.idl.bean.Permission;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class IFlowPermissionIDL$Default implements IFlowPermissionIDL {
    public IFlowPermissionIDL$Default() {
    }

    public IBinder asBinder() {
        return null;
    }

    public Map isAppletPermissionGranted(String r1, List<String> r2) throws RemoteException {
        return null;
    }

    public Map isPermissionGranted(List<String> r1) throws RemoteException {
        return null;
    }

    public Map isPersonalPermissionGranted(String r1, List<String> r2) throws RemoteException {
        return null;
    }

    public boolean requestPermission(String r1, String r2) throws RemoteException {
        return false;
    }

    public void updateAppletPermissions(List<Permission> r1) throws RemoteException {
    }

    public void updatePersonalPermissions(List<Permission> r1) throws RemoteException {
    }
}
