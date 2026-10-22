package com.obric.aiagent.assistant.idl;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class FlowFindMessageCallbackIDLStubWrapper extends IFlowFindMessageCallbackIDL.Stub {
    boolean log;
    final IFlowFindMessageCallbackIDL.Stub origin;

    @Override // com.obric.aiagent.assistant.idl.IFlowFindMessageCallbackIDL
    public void onFail() throws RemoteException {
        long r4 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        h.b("FlowFindMessageCallbackIDLStub", "onFail()", e);
        IPCException r2 = new IPCException(e);
        long r15 = SystemClock.elapsedRealtimeNanos();
        long r13 = Math.max(0, r15 - r4) / 1000;
        com.obric.aiagent.ipc.utils.i.c("FlowFindMessageCallbackIDLStub", "onFail() = fail", r2, r13);
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("FlowFindMessageCallbackIDLStub", "onFail", r2, r13, r15);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        h.c("FlowFindMessageCallbackIDLStub", "onFail()");     // Catch: Exception -> L11
    L6:
        this.origin.onFail();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("FlowFindMessageCallbackIDLStub", "onFail = void");     // Catch: Exception -> L11
    L9:
        long r16 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r16 - r4) / 1000;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowFindMessageCallbackIDLStub", "onFail() = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("FlowFindMessageCallbackIDLStub", "onFail", r14, r16);     // Catch: Exception -> L11
    }

    public FlowFindMessageCallbackIDLStubWrapper(IFlowFindMessageCallbackIDL.Stub r2) throws RemoteException {
        this(r2, true);
    }

    @Override // com.obric.aiagent.assistant.idl.IFlowFindMessageCallbackIDL
    public void onSuccess(IMMessage r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("FlowFindMessageCallbackIDLStub", "onSuccess(" + r20 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("FlowFindMessageCallbackIDLStub", "onSuccess(" + r20 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("FlowFindMessageCallbackIDLStub", "onSuccess", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("FlowFindMessageCallbackIDLStub", "onSuccess(" + r20 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onSuccess(r20);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("FlowFindMessageCallbackIDLStub", "onSuccess = void");     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("FlowFindMessageCallbackIDLStub", "onSuccess(" + r20 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("FlowFindMessageCallbackIDLStub", "onSuccess", r14, r18);     // Catch: Exception -> L11
    }

    public FlowFindMessageCallbackIDLStubWrapper(IFlowFindMessageCallbackIDL.Stub r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }
}
