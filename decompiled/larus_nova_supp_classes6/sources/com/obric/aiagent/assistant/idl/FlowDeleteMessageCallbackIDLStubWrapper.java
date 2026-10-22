package com.obric.aiagent.assistant.idl;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class FlowDeleteMessageCallbackIDLStubWrapper extends IFlowDeleteMessageCallbackIDL.Stub {
    boolean log;
    final IFlowDeleteMessageCallbackIDL.Stub origin;

    @Override // com.obric.aiagent.assistant.idl.IFlowDeleteMessageCallbackIDL
    public void onFail() throws RemoteException {
        long r4 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        h.b("FlowDeleteMessageCallbackIDLStub", "onFail()", e);
        IPCException r2 = new IPCException(e);
        long r15 = SystemClock.elapsedRealtimeNanos();
        long r13 = Math.max(0, r15 - r4) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowDeleteMessageCallbackIDLStub", "onFail() = fail", r2, r13);
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("FlowDeleteMessageCallbackIDLStub", "onFail", r2, r13, r15);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        h.c("FlowDeleteMessageCallbackIDLStub", "onFail()");     // Catch: Exception -> L11
    L6:
        this.origin.onFail();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("FlowDeleteMessageCallbackIDLStub", "onFail = void");     // Catch: Exception -> L11
    L9:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r16 - r4) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowDeleteMessageCallbackIDLStub", "onFail() = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("FlowDeleteMessageCallbackIDLStub", "onFail", r14, r16);     // Catch: Exception -> L11
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowDeleteMessageCallbackIDL
    public void onSuccess() throws RemoteException {
        long r4 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        h.b("FlowDeleteMessageCallbackIDLStub", "onSuccess()", e);
        IPCException r2 = new IPCException(e);
        long r15 = SystemClock.elapsedRealtimeNanos();
        long r13 = Math.max(0, r15 - r4) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowDeleteMessageCallbackIDLStub", "onSuccess() = fail", r2, r13);
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("FlowDeleteMessageCallbackIDLStub", "onSuccess", r2, r13, r15);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        h.c("FlowDeleteMessageCallbackIDLStub", "onSuccess()");     // Catch: Exception -> L11
    L6:
        this.origin.onSuccess();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("FlowDeleteMessageCallbackIDLStub", "onSuccess = void");     // Catch: Exception -> L11
    L9:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r16 - r4) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowDeleteMessageCallbackIDLStub", "onSuccess() = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("FlowDeleteMessageCallbackIDLStub", "onSuccess", r14, r16);     // Catch: Exception -> L11
    }

    public FlowDeleteMessageCallbackIDLStubWrapper(IFlowDeleteMessageCallbackIDL.Stub r2) throws RemoteException {
        this(r2, true);
    }

    public FlowDeleteMessageCallbackIDLStubWrapper(IFlowDeleteMessageCallbackIDL.Stub r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }
}
