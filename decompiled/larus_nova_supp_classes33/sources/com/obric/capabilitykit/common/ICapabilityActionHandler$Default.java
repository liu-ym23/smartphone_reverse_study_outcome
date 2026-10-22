package com.obric.capabilitykit.common;

import android.net.Uri;
import android.os.IBinder;
import android.os.RemoteException;
import com.obric.capabilitykit.common.execution.IntentCalling;
import com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class ICapabilityActionHandler$Default implements ICapabilityActionHandler {
    public ICapabilityActionHandler$Default() {
    }

    public IBinder asBinder() {
        return null;
    }

    public int getVersion() throws RemoteException {
        return 0;
    }

    public boolean handleAction(String r1) throws RemoteException {
        return false;
    }

    public boolean handleIntentCalling(IntentCalling r1) throws RemoteException {
        return false;
    }

    public int isTaskRunning(String r1, String r2) throws RemoteException {
        return 0;
    }

    public boolean openUriFile(Uri r1, IUriFileReceiver r2, String r3) throws RemoteException {
        return false;
    }

    public boolean stopAction(String r1, String r2) throws RemoteException {
        return false;
    }

    public boolean stopComplexTask(String r1) throws RemoteException {
        return false;
    }
}
