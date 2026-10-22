package com.obric.aiagent.assistant.idl;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.RequestRestrictRule;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class AgentNetworkIDLStubWrapper extends IAgentNetworkIDL.Stub {
    boolean log;
    final IAgentNetworkIDL.Stub origin;

    public AgentNetworkIDLStubWrapper(IAgentNetworkIDL.Stub r2) throws RemoteException {
        this(r2, true);
    }

    public void updateExcludeRules(RequestRestrictRule r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentNetworkIDLStub", "updateExcludeRules(" + r20 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentNetworkIDLStub", "updateExcludeRules(" + r20 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentNetworkIDLStub", "updateExcludeRules", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("AgentNetworkIDLStub", "updateExcludeRules(" + r20 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.updateExcludeRules(r20);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentNetworkIDLStub", "updateExcludeRules = void");     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentNetworkIDLStub", "updateExcludeRules(" + r20 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentNetworkIDLStub", "updateExcludeRules", r14, r18);     // Catch: Exception -> L11
    }

    public AgentNetworkIDLStubWrapper(IAgentNetworkIDL.Stub r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }

    public void notifyRequestStatus(boolean r22, Map r23) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r10 = h.a;
        h.b("AgentNetworkIDLStub", "notifyRequestStatus(" + r22 + ", " + r23 + ")", e);
        IPCException r4 = new IPCException(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r9 = Math.max(0, r19 - r8) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentNetworkIDLStub", "notifyRequestStatus(" + r22 + ", " + r23 + ") = fail", r4, r9);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentNetworkIDLStub", "notifyRequestStatus", r4, r9, r19);
        throw r4;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("AgentNetworkIDLStub", "notifyRequestStatus(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.notifyRequestStatus(r22, r23);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentNetworkIDLStub", "notifyRequestStatus = void");     // Catch: Exception -> L11
    L9:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r110 - r8) / 1000;     // Catch: Exception -> L11
        int r3 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentNetworkIDLStub", "notifyRequestStatus(" + r22 + ", " + r23 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentNetworkIDLStub", "notifyRequestStatus", r14, r110);     // Catch: Exception -> L11
    }
}
