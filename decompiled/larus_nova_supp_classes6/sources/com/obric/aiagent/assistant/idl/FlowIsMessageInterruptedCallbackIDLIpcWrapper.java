package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class FlowIsMessageInterruptedCallbackIDLIpcWrapper implements IFlowIsMessageInterruptedCallbackIDL {
    boolean log;
    final IFlowIsMessageInterruptedCallbackIDL origin;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    public FlowIsMessageInterruptedCallbackIDLIpcWrapper(IFlowIsMessageInterruptedCallbackIDL r2) throws RemoteException {
        this(r2, true);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowIsMessageInterruptedCallbackIDL
    public void onResult(boolean r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L17
        h.b("IFlowIsMessageInterruptedCallbackIDLIPC", "onResult(" + r20 + ")", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IFlowIsMessageInterruptedCallbackIDLIPC", "onResult(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IFlowIsMessageInterruptedCallbackIDLIPC", "onResult", r14, r7, r17);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowIsMessageInterruptedCallbackIDLIPC", "onResult(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IFlowIsMessageInterruptedCallbackIDLIPC", "onResult(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onResult(r20);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IFlowIsMessageInterruptedCallbackIDLIPC", "onResult = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IFlowIsMessageInterruptedCallbackIDLIPC", "onResult(" + r20 + ") = void", r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IFlowIsMessageInterruptedCallbackIDLIPC", "onResult", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public FlowIsMessageInterruptedCallbackIDLIpcWrapper(IFlowIsMessageInterruptedCallbackIDL r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }
}
