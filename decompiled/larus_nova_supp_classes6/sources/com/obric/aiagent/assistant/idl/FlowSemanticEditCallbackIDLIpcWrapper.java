package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class FlowSemanticEditCallbackIDLIpcWrapper implements IFlowSemanticEditCallbackIDL {
    boolean log;
    final IFlowSemanticEditCallbackIDL origin;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSemanticEditCallbackIDL
    public void onSuccess() throws RemoteException {
        long r4 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        h.b("IFlowSemanticEditCallbackIDLIPC", "onSuccess()", e);     // Catch: Throwable -> L17
        IPCException r12 = new IPCException(e);     // Catch: Throwable -> L17
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r13 = Math.max(0, r15 - r4) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowSemanticEditCallbackIDLIPC", "onSuccess() = fail", r12, r13);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowSemanticEditCallbackIDLIPC", "onSuccess", r12, r13, r15);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        h.a("IFlowSemanticEditCallbackIDLIPC", "onSuccess()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IFlowSemanticEditCallbackIDLIPC", "onSuccess()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onSuccess();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowSemanticEditCallbackIDLIPC", "onSuccess = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r4) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowSemanticEditCallbackIDLIPC", "onSuccess() = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowSemanticEditCallbackIDLIPC", "onSuccess", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public FlowSemanticEditCallbackIDLIpcWrapper(IFlowSemanticEditCallbackIDL r2) throws RemoteException {
        this(r2, true);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSemanticEditCallbackIDL
    public void onFail(int r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowSemanticEditCallbackIDLIPC", "onFail(" + r20 + ")", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowSemanticEditCallbackIDLIPC", "onFail(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowSemanticEditCallbackIDLIPC", "onFail", r14, r7, r17);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowSemanticEditCallbackIDLIPC", "onFail(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowSemanticEditCallbackIDLIPC", "onFail(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onFail(r20);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowSemanticEditCallbackIDLIPC", "onFail = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowSemanticEditCallbackIDLIPC", "onFail(" + r20 + ") = void", r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowSemanticEditCallbackIDLIPC", "onFail", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public FlowSemanticEditCallbackIDLIpcWrapper(IFlowSemanticEditCallbackIDL r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }
}
