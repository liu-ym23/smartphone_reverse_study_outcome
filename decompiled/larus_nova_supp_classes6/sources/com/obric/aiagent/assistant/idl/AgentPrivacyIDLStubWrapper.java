package com.obric.aiagent.assistant.idl;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class AgentPrivacyIDLStubWrapper extends IAgentPrivacyIDL.Stub {
    boolean log;
    final IAgentPrivacyIDL.Stub origin;

    public AgentPrivacyIDLStubWrapper(IAgentPrivacyIDL.Stub r2) throws RemoteException {
        this(r2, true);
    }

    public AgentPrivacyIDLStubWrapper(IAgentPrivacyIDL.Stub r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }

    public String getPemCertChain(String r23, String r24) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r10 = h.a;
        h.b("AgentPrivacyIDLStub", "getPemCertChain(" + r23 + ", " + r24 + ")", e);
        IPCException r4 = new IPCException(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r9 = Math.max(0, r19 - r8) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentPrivacyIDLStub", "getPemCertChain(" + r23 + ", " + r24 + ") = fail", r4, r9);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentPrivacyIDLStub", "getPemCertChain", r4, r9, r19);
        throw r4;
    L4:
        if (this.log == false) goto L6;
        int r14 = h.a;     // Catch: Exception -> L11
        h.c("AgentPrivacyIDLStub", "getPemCertChain(" + r23 + ", " + r24 + ")");     // Catch: Exception -> L11
    L6:
        String r15 = this.origin.getPemCertChain(r23, r24);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r16 = h.a;     // Catch: Exception -> L11
        h.d("AgentPrivacyIDLStub", "getPemCertChain = " + r15);     // Catch: Exception -> L11
    L9:
        long r20 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r11 = Math.max(0, r20 - r8) / 1000;     // Catch: Exception -> L11
        int r2 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentPrivacyIDLStub", "getPemCertChain(" + r23 + ", " + r24 + ") = " + r15, r11);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentPrivacyIDLStub", "getPemCertChain", r11, r20);     // Catch: Exception -> L11
        return r15;
    }
}
