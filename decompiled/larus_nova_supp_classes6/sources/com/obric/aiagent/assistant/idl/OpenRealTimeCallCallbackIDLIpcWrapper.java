package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class OpenRealTimeCallCallbackIDLIpcWrapper implements IOpenRealTimeCallCallbackIDL {
    boolean log;
    final IOpenRealTimeCallCallbackIDL origin;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    public OpenRealTimeCallCallbackIDLIpcWrapper(IOpenRealTimeCallCallbackIDL r2) throws RemoteException {
        this(r2, true);
    }

    @Override // com.obric.aiagent.assistant.idl.IOpenRealTimeCallCallbackIDL
    public void onResult(int r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r12 = h.a;     // Catch: Throwable -> L17
        h.b("IOpenRealTimeCallCallbackIDLIPC", "onResult(" + r20 + ")", e);     // Catch: Throwable -> L17
        IPCException r14 = new IPCException(e);     // Catch: Throwable -> L17
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r7 = Math.max(0, r17 - r6) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IOpenRealTimeCallCallbackIDLIPC", "onResult(" + r20 + ") = fail", r14, r7);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IOpenRealTimeCallCallbackIDLIPC", "onResult", r14, r7, r17);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IOpenRealTimeCallCallbackIDLIPC", "onResult(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IOpenRealTimeCallCallbackIDLIPC", "onResult(" + r20 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onResult(r20);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IOpenRealTimeCallCallbackIDLIPC", "onResult = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r15 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IOpenRealTimeCallCallbackIDLIPC", "onResult(" + r20 + ") = void", r15);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IOpenRealTimeCallCallbackIDLIPC", "onResult", r15, r18);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public OpenRealTimeCallCallbackIDLIpcWrapper(IOpenRealTimeCallCallbackIDL r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.assistant.idl.IOpenRealTimeCallCallbackIDL
    public void onResultWithMsg(int r22, String r23) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r10 = h.a;     // Catch: Throwable -> L17
        h.b("IOpenRealTimeCallCallbackIDLIPC", "onResultWithMsg(" + r22 + ", " + r23 + ")", e);     // Catch: Throwable -> L17
        IPCException r4 = new IPCException(e);     // Catch: Throwable -> L17
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r9 = Math.max(0, r19 - r8) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IOpenRealTimeCallCallbackIDLIPC", "onResultWithMsg(" + r22 + ", " + r23 + ") = fail", r4, r9);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IOpenRealTimeCallCallbackIDLIPC", "onResultWithMsg", r4, r9, r19);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IOpenRealTimeCallCallbackIDLIPC", "onResultWithMsg(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IOpenRealTimeCallCallbackIDLIPC", "onResultWithMsg(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onResultWithMsg(r22, r23);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IOpenRealTimeCallCallbackIDLIPC", "onResultWithMsg = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r110 - r8) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r5 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IOpenRealTimeCallCallbackIDLIPC", "onResultWithMsg(" + r22 + ", " + r23 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IOpenRealTimeCallCallbackIDLIPC", "onResultWithMsg", r14, r110);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }
}
