package com.obric.aiagent.assistant.idl;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class FlowSemanticEditCallbackIDLStubWrapper extends IFlowSemanticEditCallbackIDL.Stub {
    boolean log;
    final IFlowSemanticEditCallbackIDL.Stub origin;

    @Override // com.obric.aiagent.assistant.idl.IFlowSemanticEditCallbackIDL
    public void onSuccess() throws RemoteException {
        long r4 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        h.b("FlowSemanticEditCallbackIDLStub", "onSuccess()", e);
        IPCException r2 = new IPCException(e);
        long r15 = SystemClock.elapsedRealtimeNanos();
        long r13 = Math.max(0, r15 - r4) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowSemanticEditCallbackIDLStub", "onSuccess() = fail", r2, r13);
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("FlowSemanticEditCallbackIDLStub", "onSuccess", r2, r13, r15);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        h.c("FlowSemanticEditCallbackIDLStub", "onSuccess()");     // Catch: Exception -> L11
    L6:
        this.origin.onSuccess();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("FlowSemanticEditCallbackIDLStub", "onSuccess = void");     // Catch: Exception -> L11
    L9:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r16 - r4) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowSemanticEditCallbackIDLStub", "onSuccess() = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("FlowSemanticEditCallbackIDLStub", "onSuccess", r14, r16);     // Catch: Exception -> L11
    }

    public FlowSemanticEditCallbackIDLStubWrapper(IFlowSemanticEditCallbackIDL.Stub r2) throws RemoteException {
        this(r2, true);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowSemanticEditCallbackIDL
    public void onFail(int r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("FlowSemanticEditCallbackIDLStub", "onFail(" + r20 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("FlowSemanticEditCallbackIDLStub", "onFail(" + r20 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("FlowSemanticEditCallbackIDLStub", "onFail", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("FlowSemanticEditCallbackIDLStub", "onFail(" + r20 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onFail(r20);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("FlowSemanticEditCallbackIDLStub", "onFail = void");     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowSemanticEditCallbackIDLStub", "onFail(" + r20 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("FlowSemanticEditCallbackIDLStub", "onFail", r14, r18);     // Catch: Exception -> L11
    }

    public FlowSemanticEditCallbackIDLStubWrapper(IFlowSemanticEditCallbackIDL.Stub r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }
}
