package com.obric.aiagent.flow.applog.idl;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;
import com.obric.aiagent.ipc.utils.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class FlowAppLogEventObserverIDLStubWrapper extends IFlowAppLogEventObserverIDL.Stub {
    boolean log;
    final IFlowAppLogEventObserverIDL.Stub origin;

    public FlowAppLogEventObserverIDLStubWrapper(IFlowAppLogEventObserverIDL.Stub r2) throws RemoteException {
        this(r2, true);
    }

    public FlowAppLogEventObserverIDLStubWrapper(IFlowAppLogEventObserverIDL.Stub r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }

    @Override // com.obric.aiagent.flow.applog.idl.IFlowAppLogEventObserverIDL
    public void onEventV3(String r22, String r23) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r10 = h.a;
        h.b("FlowAppLogEventObserverIDLStub", "onEventV3(" + r22 + ", " + r23 + ")", e);
        IPCException r4 = new IPCException(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r9 = Math.max(0, r19 - r8) / 1000;
        int r0 = i.a;
        i.c("FlowAppLogEventObserverIDLStub", "onEventV3(" + r22 + ", " + r23 + ") = fail", r4, r9);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("FlowAppLogEventObserverIDLStub", "onEventV3", r4, r9, r19);
        throw r4;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("FlowAppLogEventObserverIDLStub", "onEventV3(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onEventV3(r22, r23);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("FlowAppLogEventObserverIDLStub", "onEventV3 = void");     // Catch: Exception -> L11
    L9:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r110 - r8) / 1000;     // Catch: Exception -> L11
        int r3 = i.a;     // Catch: Exception -> L11
        i.d("FlowAppLogEventObserverIDLStub", "onEventV3(" + r22 + ", " + r23 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("FlowAppLogEventObserverIDLStub", "onEventV3", r14, r110);     // Catch: Exception -> L11
    }
}
