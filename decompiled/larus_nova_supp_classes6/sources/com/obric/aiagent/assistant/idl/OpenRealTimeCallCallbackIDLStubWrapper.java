package com.obric.aiagent.assistant.idl;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class OpenRealTimeCallCallbackIDLStubWrapper extends IOpenRealTimeCallCallbackIDL.Stub {
    boolean log;
    final IOpenRealTimeCallCallbackIDL.Stub origin;

    public OpenRealTimeCallCallbackIDLStubWrapper(IOpenRealTimeCallCallbackIDL.Stub r2) throws RemoteException {
        this(r2, true);
    }

    @Override // com.obric.aiagent.assistant.idl.IOpenRealTimeCallCallbackIDL
    public void onResult(int r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("OpenRealTimeCallCallbackIDLStub", "onResult(" + r20 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("OpenRealTimeCallCallbackIDLStub", "onResult(" + r20 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("OpenRealTimeCallCallbackIDLStub", "onResult", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("OpenRealTimeCallCallbackIDLStub", "onResult(" + r20 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onResult(r20);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("OpenRealTimeCallCallbackIDLStub", "onResult = void");     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("OpenRealTimeCallCallbackIDLStub", "onResult(" + r20 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("OpenRealTimeCallCallbackIDLStub", "onResult", r14, r18);     // Catch: Exception -> L11
    }

    public OpenRealTimeCallCallbackIDLStubWrapper(IOpenRealTimeCallCallbackIDL.Stub r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.assistant.idl.IOpenRealTimeCallCallbackIDL
    public void onResultWithMsg(int r22, String r23) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r10 = h.a;
        h.b("OpenRealTimeCallCallbackIDLStub", "onResultWithMsg(" + r22 + ", " + r23 + ")", e);
        IPCException r4 = new IPCException(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r9 = Math.max(0, r19 - r8) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("OpenRealTimeCallCallbackIDLStub", "onResultWithMsg(" + r22 + ", " + r23 + ") = fail", r4, r9);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("OpenRealTimeCallCallbackIDLStub", "onResultWithMsg", r4, r9, r19);
        throw r4;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("OpenRealTimeCallCallbackIDLStub", "onResultWithMsg(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onResultWithMsg(r22, r23);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("OpenRealTimeCallCallbackIDLStub", "onResultWithMsg = void");     // Catch: Exception -> L11
    L9:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r110 - r8) / 1000;     // Catch: Exception -> L11
        int r3 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("OpenRealTimeCallCallbackIDLStub", "onResultWithMsg(" + r22 + ", " + r23 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("OpenRealTimeCallCallbackIDLStub", "onResultWithMsg", r14, r110);     // Catch: Exception -> L11
    }
}
