package com.obric.aiagent.flow.applog.idl;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;
import com.obric.aiagent.ipc.utils.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class FlowAppLogEventObserverIDLIpcWrapper implements IFlowAppLogEventObserverIDL {
    boolean log;
    final IFlowAppLogEventObserverIDL origin;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    public FlowAppLogEventObserverIDLIpcWrapper(IFlowAppLogEventObserverIDL r2) throws RemoteException {
        this(r2, true);
    }

    public FlowAppLogEventObserverIDLIpcWrapper(IFlowAppLogEventObserverIDL r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogEventObserverIDL
    public void onEventV3(String r22, String r23) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r10 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowAppLogEventObserverIDLIPC", "onEventV3(" + r22 + ", " + r23 + ")", e);     // Catch: Throwable -> L17
        IPCException r4 = new IPCException(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r9 = Math.max(0, r19 - r8) / 1000;     // Catch: Throwable -> L17
        int r0 = i.a;     // Catch: Throwable -> L17
        i.a("IFlowAppLogEventObserverIDLIPC", "onEventV3(" + r22 + ", " + r23 + ") = fail", r4, r9);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowAppLogEventObserverIDLIPC", "onEventV3", r4, r9, r19);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowAppLogEventObserverIDLIPC", "onEventV3(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowAppLogEventObserverIDLIPC", "onEventV3(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onEventV3(r22, r23);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowAppLogEventObserverIDLIPC", "onEventV3 = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r110 - r8) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r5 = i.a;     // Catch: Exception -> L14 Throwable -> L17
        i.b("IFlowAppLogEventObserverIDLIPC", "onEventV3(" + r22 + ", " + r23 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowAppLogEventObserverIDLIPC", "onEventV3", r14, r110);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }
}
