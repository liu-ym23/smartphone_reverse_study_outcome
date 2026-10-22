package com.obric.aiagent.assistant.idl;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class AgentSkillManagerObserverIDLStubWrapper extends IAgentSkillManagerObserverIDL.Stub {
    boolean log;
    final IAgentSkillManagerObserverIDL.Stub origin;

    public AgentSkillManagerObserverIDLStubWrapper(IAgentSkillManagerObserverIDL.Stub r2) throws RemoteException {
        this(r2, true);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerObserverIDL
    public void onSkillListChanged(long r23) throws RemoteException {
        long r7 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r13 = h.a;
        h.b("AgentSkillManagerObserverIDLStub", "onSkillListChanged(" + r23 + ")", e);
        IPCException r4 = new IPCException(e);
        long r18 = SystemClock.elapsedRealtimeNanos();
        long r8 = Math.max(0, r18 - r7) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentSkillManagerObserverIDLStub", "onSkillListChanged(" + r23 + ") = fail", r4, r8);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentSkillManagerObserverIDLStub", "onSkillListChanged", r4, r8, r18);
        throw r4;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("AgentSkillManagerObserverIDLStub", "onSkillListChanged(" + r23 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.onSkillListChanged(r23);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentSkillManagerObserverIDLStub", "onSkillListChanged = void");     // Catch: Exception -> L11
    L9:
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r19 - r7) / 1000;     // Catch: Exception -> L11
        int r3 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentSkillManagerObserverIDLStub", "onSkillListChanged(" + r23 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentSkillManagerObserverIDLStub", "onSkillListChanged", r14, r19);     // Catch: Exception -> L11
    }

    public AgentSkillManagerObserverIDLStubWrapper(IAgentSkillManagerObserverIDL.Stub r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }
}
