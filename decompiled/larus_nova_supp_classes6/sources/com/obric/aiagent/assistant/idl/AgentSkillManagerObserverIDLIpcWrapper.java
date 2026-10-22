package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class AgentSkillManagerObserverIDLIpcWrapper implements IAgentSkillManagerObserverIDL {
    boolean log;
    final IAgentSkillManagerObserverIDL origin;

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.origin.asBinder();
    }

    public AgentSkillManagerObserverIDLIpcWrapper(IAgentSkillManagerObserverIDL r2) throws RemoteException {
        this(r2, true);
    }

    @Override // com.obric.aiagent.assistant.idl.IAgentSkillManagerObserverIDL
    public void onSkillListChanged(long r23) throws RemoteException {
        long r7 = SystemClock.elapsedRealtimeNanos();
    L14:
        e = move-exception;
        int r13 = h.a;     // Catch: Throwable -> L17
        h.b("IAgentSkillManagerObserverIDLIPC", "onSkillListChanged(" + r23 + ")", e);     // Catch: Throwable -> L17
        IPCException r15 = new IPCException(e);     // Catch: Throwable -> L17
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Throwable -> L17
        long r8 = Math.max(0, r18 - r7) / 1000;     // Catch: Throwable -> L17
        int r0 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Throwable -> L17
        com.obric.aiagent.ipc.utils.i.a("IAgentSkillManagerObserverIDLIPC", "onSkillListChanged(" + r23 + ") = fail", r15, r8);     // Catch: Throwable -> L17
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;     // Catch: Throwable -> L17
        IPCAnomalyTrace.b("IAgentSkillManagerObserverIDLIPC", "onSkillListChanged", r15, r8, r18);     // Catch: Throwable -> L17
        return;
    L4:
        if (this.log == false) goto L7;
        int r2 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IAgentSkillManagerObserverIDLIPC", "onSkillListChanged(" + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L7:
        if (this.log == false) goto L9;
        int r3 = h.a;     // Catch: Exception -> L14 Throwable -> L17
        h.a("IAgentSkillManagerObserverIDLIPC", "onSkillListChanged(" + r23 + ")");     // Catch: Exception -> L14 Throwable -> L17
    L9:
        this.origin.onSkillListChanged(r23);     // Catch: Exception -> L14 Throwable -> L17
        if (this.log == false) goto L12;
        h.d("IAgentSkillManagerObserverIDLIPC", "onSkillListChanged = void");     // Catch: Exception -> L14 Throwable -> L17
    L12:
        long r19 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L14 Throwable -> L17
        long r14 = Math.max(0, r19 - r7) / 1000;     // Catch: Exception -> L14 Throwable -> L17
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L14 Throwable -> L17
        com.obric.aiagent.ipc.utils.i.b("IAgentSkillManagerObserverIDLIPC", "onSkillListChanged(" + r23 + ") = void", r14);     // Catch: Exception -> L14 Throwable -> L17
        IPCAnomalyTrace.a.c("IAgentSkillManagerObserverIDLIPC", "onSkillListChanged", r14, r19);     // Catch: Exception -> L14 Throwable -> L17
        return;
    }

    public AgentSkillManagerObserverIDLIpcWrapper(IAgentSkillManagerObserverIDL r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }
}
