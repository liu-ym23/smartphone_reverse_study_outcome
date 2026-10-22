package com.obric.aiagent.flow.applog.idl;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;
import com.obric.aiagent.ipc.utils.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class FlowAppLogSessionObserverIDLIpcWrapper implements IFlowAppLogSessionObserverIDL {
    boolean log;
    final IFlowAppLogSessionObserverIDL origin;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    public FlowAppLogSessionObserverIDLIpcWrapper(IFlowAppLogSessionObserverIDL r2) throws RemoteException {
        this(r2, true);
    }

    public FlowAppLogSessionObserverIDLIpcWrapper(IFlowAppLogSessionObserverIDL r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogSessionObserverIDL
    public void onSessionBatchEvent(long r23, String r25) throws RemoteException {
        long r9 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r11 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowAppLogSessionObserverIDLIPC", "onSessionBatchEvent(" + r23 + ", " + r25 + ")", e);     // Catch: Throwable -> L17
        IPCException r5 = new IPCException(e);     // Catch: Throwable -> L17
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r10 = Math.max(0, r20 - r9) / 1000;     // Catch: Throwable -> L17
        int r0 = i.a;     // Catch: Throwable -> L17
        i.a("IFlowAppLogSessionObserverIDLIPC", "onSessionBatchEvent(" + r23 + ", " + r25 + ") = fail", r5, r10);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowAppLogSessionObserverIDLIPC", "onSessionBatchEvent", r5, r10, r20);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowAppLogSessionObserverIDLIPC", "onSessionBatchEvent(" + r23 + ", " + r25 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowAppLogSessionObserverIDLIPC", "onSessionBatchEvent(" + r23 + ", " + r25 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onSessionBatchEvent(r23, r25);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowAppLogSessionObserverIDLIPC", "onSessionBatchEvent = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r12 = Math.max(0, r21 - r9) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r4 = i.a;     // Catch: Exception -> L14 Throwable -> L17
        i.b("IFlowAppLogSessionObserverIDLIPC", "onSessionBatchEvent(" + r23 + ", " + r25 + ") = void", r12);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowAppLogSessionObserverIDLIPC", "onSessionBatchEvent", r12, r21);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogSessionObserverIDL
    public void onSessionStart(long r23, String r25) throws RemoteException {
        long r9 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r11 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowAppLogSessionObserverIDLIPC", "onSessionStart(" + r23 + ", " + r25 + ")", e);     // Catch: Throwable -> L17
        IPCException r5 = new IPCException(e);     // Catch: Throwable -> L17
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r10 = Math.max(0, r20 - r9) / 1000;     // Catch: Throwable -> L17
        int r0 = i.a;     // Catch: Throwable -> L17
        i.a("IFlowAppLogSessionObserverIDLIPC", "onSessionStart(" + r23 + ", " + r25 + ") = fail", r5, r10);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowAppLogSessionObserverIDLIPC", "onSessionStart", r5, r10, r20);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowAppLogSessionObserverIDLIPC", "onSessionStart(" + r23 + ", " + r25 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowAppLogSessionObserverIDLIPC", "onSessionStart(" + r23 + ", " + r25 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onSessionStart(r23, r25);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowAppLogSessionObserverIDLIPC", "onSessionStart = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r12 = Math.max(0, r21 - r9) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r4 = i.a;     // Catch: Exception -> L14 Throwable -> L17
        i.b("IFlowAppLogSessionObserverIDLIPC", "onSessionStart(" + r23 + ", " + r25 + ") = void", r12);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowAppLogSessionObserverIDLIPC", "onSessionStart", r12, r21);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogSessionObserverIDL
    public void onSessionTerminate(long r23, String r25) throws RemoteException {
        long r9 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r11 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowAppLogSessionObserverIDLIPC", "onSessionTerminate(" + r23 + ", " + r25 + ")", e);     // Catch: Throwable -> L17
        IPCException r5 = new IPCException(e);     // Catch: Throwable -> L17
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r10 = Math.max(0, r20 - r9) / 1000;     // Catch: Throwable -> L17
        int r0 = i.a;     // Catch: Throwable -> L17
        i.a("IFlowAppLogSessionObserverIDLIPC", "onSessionTerminate(" + r23 + ", " + r25 + ") = fail", r5, r10);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowAppLogSessionObserverIDLIPC", "onSessionTerminate", r5, r10, r20);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowAppLogSessionObserverIDLIPC", "onSessionTerminate(" + r23 + ", " + r25 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowAppLogSessionObserverIDLIPC", "onSessionTerminate(" + r23 + ", " + r25 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onSessionTerminate(r23, r25);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowAppLogSessionObserverIDLIPC", "onSessionTerminate = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r12 = Math.max(0, r21 - r9) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r4 = i.a;     // Catch: Exception -> L14 Throwable -> L17
        i.b("IFlowAppLogSessionObserverIDLIPC", "onSessionTerminate(" + r23 + ", " + r25 + ") = void", r12);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowAppLogSessionObserverIDLIPC", "onSessionTerminate", r12, r21);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }
}
