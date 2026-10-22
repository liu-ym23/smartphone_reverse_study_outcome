package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class FlowDeleteMessageCallbackIDLIpcWrapper implements IFlowDeleteMessageCallbackIDL {
    boolean log;
    final IFlowDeleteMessageCallbackIDL origin;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowDeleteMessageCallbackIDL
    public void onFail() throws RemoteException {
        long r4 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        h.b("IFlowDeleteMessageCallbackIDLIPC", "onFail()", e);     // Catch: Throwable -> L17
        IPCException r12 = new IPCException(e);     // Catch: Throwable -> L17
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r13 = Math.max(0, r15 - r4) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowDeleteMessageCallbackIDLIPC", "onFail() = fail", r12, r13);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowDeleteMessageCallbackIDLIPC", "onFail", r12, r13, r15);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        h.a("IFlowDeleteMessageCallbackIDLIPC", "onFail()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IFlowDeleteMessageCallbackIDLIPC", "onFail()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onFail();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowDeleteMessageCallbackIDLIPC", "onFail = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r4) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowDeleteMessageCallbackIDLIPC", "onFail() = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowDeleteMessageCallbackIDLIPC", "onFail", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowDeleteMessageCallbackIDL
    public void onSuccess() throws RemoteException {
        long r4 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        h.b("IFlowDeleteMessageCallbackIDLIPC", "onSuccess()", e);     // Catch: Throwable -> L17
        IPCException r12 = new IPCException(e);     // Catch: Throwable -> L17
        long r15 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r13 = Math.max(0, r15 - r4) / 1000;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowDeleteMessageCallbackIDLIPC", "onSuccess() = fail", r12, r13);     // Catch: Throwable -> L17
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowDeleteMessageCallbackIDLIPC", "onSuccess", r12, r13, r15);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        h.a("IFlowDeleteMessageCallbackIDLIPC", "onSuccess()");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        h.a("IFlowDeleteMessageCallbackIDLIPC", "onSuccess()");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onSuccess();     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowDeleteMessageCallbackIDLIPC", "onSuccess = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r16 - r4) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowDeleteMessageCallbackIDLIPC", "onSuccess() = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowDeleteMessageCallbackIDLIPC", "onSuccess", r14, r16);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public FlowDeleteMessageCallbackIDLIpcWrapper(IFlowDeleteMessageCallbackIDL r2) throws RemoteException {
        this(r2, true);
    }

    public FlowDeleteMessageCallbackIDLIpcWrapper(IFlowDeleteMessageCallbackIDL r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }
}
