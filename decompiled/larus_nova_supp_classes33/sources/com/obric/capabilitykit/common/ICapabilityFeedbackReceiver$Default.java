package com.obric.capabilitykit.common;

import android.os.IBinder;
import android.os.RemoteException;
import com.obric.capabilitykit.common.execution.JobResult;
import com.obric.capabilitykit.common.intent.IntentResult;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class ICapabilityFeedbackReceiver$Default implements ICapabilityFeedbackReceiver {
    public ICapabilityFeedbackReceiver$Default() {
    }

    public IBinder asBinder() {
        return null;
    }

    public boolean isCardViewVisible(long r1) throws RemoteException {
        return false;
    }

    public boolean isKeyguardReallyLocked() throws RemoteException {
        return false;
    }

    public void onActionResultRecv(String r1, String r2, boolean r3) throws RemoteException {
    }

    public void onFinishFloatingActivity(long r1) throws RemoteException {
    }

    public void onHideIntentResultCard(long r1) throws RemoteException {
    }

    public void onJobResultRecv(String r1, String r2, boolean r3, JobResult r4) throws RemoteException {
    }

    public void onUpdateIntentResult(long r1, IntentResult r3, boolean r4, Map r5) throws RemoteException {
    }

    public void onUpdateIntentResultWithRequest(String r1, IntentResult r2, boolean r3, Map r4) throws RemoteException {
    }
}
