package com.obric.capabilitykit.common;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import android.os.RemoteException;
import com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver;
import com.obric.capabilitykit.common.intent.IntentResult;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class ICapabilityManager$Default implements ICapabilityManager {
    public ICapabilityManager$Default() {
    }

    public IBinder asBinder() {
        return null;
    }

    public void finishFloatingActivity(long r1) throws RemoteException {
    }

    public PendingIntent getFloatingPendingIntent(long r1, Intent r3, FloatingIntentParams r4) throws RemoteException {
        return null;
    }

    public int getVersion() throws RemoteException {
        return 0;
    }

    public void hideIntentResultCard(long r1) throws RemoteException {
    }

    public boolean isCardViewVisible(long r1) throws RemoteException {
        return false;
    }

    public boolean isKeyguardReallyLocked() throws RemoteException {
        return false;
    }

    public void registerFunction(String r1) throws RemoteException {
    }

    public void registerIntent(String r1, String r2, String r3) throws RemoteException {
    }

    public void registerResultCallback(IErrorCodeCallback r1) throws RemoteException {
    }

    public void requestCloseFile(String r1, Uri r2) throws RemoteException {
    }

    public boolean requestOpenFile(IUriFileReceiver r1, Uri r2, String r3) throws RemoteException {
        return false;
    }

    public void requestStateChanged(String r1, TaskStateInfo r2, ITaskStateChangeCallback r3, long r4) throws RemoteException {
    }

    public void sendActionExecuteResult(String r1) throws RemoteException {
    }

    public void sendIntentExecutionResult(IntentResult r1, String r2) throws RemoteException {
    }

    public void unregisterFunction(String r1) throws RemoteException {
    }

    public void unregisterIntent(String r1, String r2) throws RemoteException {
    }

    public void unregisterResultCallback(IErrorCodeCallback r1) throws RemoteException {
    }

    public void updateIntentResult(IntentResult r1, long r2, boolean r4, Map r5) throws RemoteException {
    }
}
