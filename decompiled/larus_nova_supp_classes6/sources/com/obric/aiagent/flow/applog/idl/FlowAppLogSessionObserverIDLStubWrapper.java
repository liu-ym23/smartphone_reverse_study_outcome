package com.obric.aiagent.flow.applog.idl;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;
import com.obric.aiagent.ipc.utils.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class FlowAppLogSessionObserverIDLStubWrapper extends IFlowAppLogSessionObserverIDL.Stub {
    boolean log;
    final IFlowAppLogSessionObserverIDL.Stub origin;

    public FlowAppLogSessionObserverIDLStubWrapper(IFlowAppLogSessionObserverIDL.Stub r2) throws RemoteException {
        this(r2, true);
    }

    public FlowAppLogSessionObserverIDLStubWrapper(IFlowAppLogSessionObserverIDL.Stub r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogSessionObserverIDL
    public void onSessionBatchEvent(long r23, String r25) throws RemoteException {
        long r9 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r11 = h.a;
        h.b("FlowAppLogSessionObserverIDLStub", "onSessionBatchEvent(" + r23 + ", " + r25 + ")", e);
        IPCException r5 = new IPCException(e);
        long r20 = SystemClock.elapsedRealtimeNanos();
        long r10 = Math.max(0, r20 - r9) / 1000;
        int r0 = i.a;
        i.c("FlowAppLogSessionObserverIDLStub", "onSessionBatchEvent(" + r23 + ", " + r25 + ") = fail", r5, r10);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("FlowAppLogSessionObserverIDLStub", "onSessionBatchEvent", r5, r10, r20);
        throw r5;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("FlowAppLogSessionObserverIDLStub", "onSessionBatchEvent(" + r23 + ", " + r25 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onSessionBatchEvent(r23, r25);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("FlowAppLogSessionObserverIDLStub", "onSessionBatchEvent = void");     // Catch: Exception -> L11
    L9:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r12 = Math.max(0, r21 - r9) / 1000;     // Catch: Exception -> L11
        int r3 = i.a;     // Catch: Exception -> L11
        i.d("FlowAppLogSessionObserverIDLStub", "onSessionBatchEvent(" + r23 + ", " + r25 + ") = void", r12);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("FlowAppLogSessionObserverIDLStub", "onSessionBatchEvent", r12, r21);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogSessionObserverIDL
    public void onSessionStart(long r23, String r25) throws RemoteException {
        long r9 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r11 = h.a;
        h.b("FlowAppLogSessionObserverIDLStub", "onSessionStart(" + r23 + ", " + r25 + ")", e);
        IPCException r5 = new IPCException(e);
        long r20 = SystemClock.elapsedRealtimeNanos();
        long r10 = Math.max(0, r20 - r9) / 1000;
        int r0 = i.a;
        i.c("FlowAppLogSessionObserverIDLStub", "onSessionStart(" + r23 + ", " + r25 + ") = fail", r5, r10);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("FlowAppLogSessionObserverIDLStub", "onSessionStart", r5, r10, r20);
        throw r5;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("FlowAppLogSessionObserverIDLStub", "onSessionStart(" + r23 + ", " + r25 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onSessionStart(r23, r25);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("FlowAppLogSessionObserverIDLStub", "onSessionStart = void");     // Catch: Exception -> L11
    L9:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r12 = Math.max(0, r21 - r9) / 1000;     // Catch: Exception -> L11
        int r3 = i.a;     // Catch: Exception -> L11
        i.d("FlowAppLogSessionObserverIDLStub", "onSessionStart(" + r23 + ", " + r25 + ") = void", r12);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("FlowAppLogSessionObserverIDLStub", "onSessionStart", r12, r21);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogSessionObserverIDL
    public void onSessionTerminate(long r23, String r25) throws RemoteException {
        long r9 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r11 = h.a;
        h.b("FlowAppLogSessionObserverIDLStub", "onSessionTerminate(" + r23 + ", " + r25 + ")", e);
        IPCException r5 = new IPCException(e);
        long r20 = SystemClock.elapsedRealtimeNanos();
        long r10 = Math.max(0, r20 - r9) / 1000;
        int r0 = i.a;
        i.c("FlowAppLogSessionObserverIDLStub", "onSessionTerminate(" + r23 + ", " + r25 + ") = fail", r5, r10);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("FlowAppLogSessionObserverIDLStub", "onSessionTerminate", r5, r10, r20);
        throw r5;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("FlowAppLogSessionObserverIDLStub", "onSessionTerminate(" + r23 + ", " + r25 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onSessionTerminate(r23, r25);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("FlowAppLogSessionObserverIDLStub", "onSessionTerminate = void");     // Catch: Exception -> L11
    L9:
        long r21 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r12 = Math.max(0, r21 - r9) / 1000;     // Catch: Exception -> L11
        int r3 = i.a;     // Catch: Exception -> L11
        i.d("FlowAppLogSessionObserverIDLStub", "onSessionTerminate(" + r23 + ", " + r25 + ") = void", r12);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("FlowAppLogSessionObserverIDLStub", "onSessionTerminate", r12, r21);     // Catch: Exception -> L11
    }
}
