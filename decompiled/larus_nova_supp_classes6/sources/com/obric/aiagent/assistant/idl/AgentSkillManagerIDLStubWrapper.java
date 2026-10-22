package com.obric.aiagent.assistant.idl;

import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.OSkill;
import com.obric.aiagent.assistant.idl.bean.OSkillManagerConfig;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class AgentSkillManagerIDLStubWrapper extends IAgentSkillManagerIDL.Stub {
    boolean log;
    final IAgentSkillManagerIDL.Stub origin;

    public long getSkillListVersion() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        h.b("AgentSkillManagerIDLStub", "getSkillListVersion()", e);
        IPCException r2 = new IPCException(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r14 = Math.max(0, r16 - r5) / 1000;
        com.obric.aiagent.ipc.utils.i.c("AgentSkillManagerIDLStub", "getSkillListVersion() = fail", r2, r14);
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentSkillManagerIDLStub", "getSkillListVersion", r2, r14, r16);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        h.c("AgentSkillManagerIDLStub", "getSkillListVersion()");     // Catch: Exception -> L11
    L6:
        long r11 = this.origin.getSkillListVersion();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r13 = h.a;     // Catch: Exception -> L11
        h.d("AgentSkillManagerIDLStub", "getSkillListVersion = " + r11);     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r15 = Math.max(0, r18 - r5) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentSkillManagerIDLStub", "getSkillListVersion() = " + r11, r15);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentSkillManagerIDLStub", "getSkillListVersion", r15, r18);     // Catch: Exception -> L11
        return r11;
    }

    public OSkillManagerConfig getSkillManagerConfig() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        h.b("AgentSkillManagerIDLStub", "getSkillManagerConfig()", e);
        IPCException r2 = new IPCException(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r14 = Math.max(0, r16 - r5) / 1000;
        com.obric.aiagent.ipc.utils.i.c("AgentSkillManagerIDLStub", "getSkillManagerConfig() = fail", r2, r14);
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentSkillManagerIDLStub", "getSkillManagerConfig", r2, r14, r16);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        h.c("AgentSkillManagerIDLStub", "getSkillManagerConfig()");     // Catch: Exception -> L11
    L6:
        OSkillManagerConfig r11 = this.origin.getSkillManagerConfig();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r12 = h.a;     // Catch: Exception -> L11
        h.d("AgentSkillManagerIDLStub", "getSkillManagerConfig = " + r11);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r15 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentSkillManagerIDLStub", "getSkillManagerConfig() = " + r11, r15);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentSkillManagerIDLStub", "getSkillManagerConfig", r15, r17);     // Catch: Exception -> L11
        return r11;
    }

    public List<OSkill> listSkills() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        h.b("AgentSkillManagerIDLStub", "listSkills()", e);
        IPCException r2 = new IPCException(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r14 = Math.max(0, r16 - r5) / 1000;
        com.obric.aiagent.ipc.utils.i.c("AgentSkillManagerIDLStub", "listSkills() = fail", r2, r14);
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentSkillManagerIDLStub", "listSkills", r2, r14, r16);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        h.c("AgentSkillManagerIDLStub", "listSkills()");     // Catch: Exception -> L11
    L6:
        List<OSkill> r11 = this.origin.listSkills();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r12 = h.a;     // Catch: Exception -> L11
        h.d("AgentSkillManagerIDLStub", "listSkills = " + r11);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r15 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentSkillManagerIDLStub", "listSkills() = " + r11, r15);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentSkillManagerIDLStub", "listSkills", r15, r17);     // Catch: Exception -> L11
        return r11;
    }

    public AgentSkillManagerIDLStubWrapper(IAgentSkillManagerIDL.Stub r2) throws RemoteException {
        this(r2, true);
    }

    public String getSkillManagerStatus(String r23) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentSkillManagerIDLStub", "getSkillManagerStatus(" + r23 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentSkillManagerIDLStub", "getSkillManagerStatus(" + r23 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentSkillManagerIDLStub", "getSkillManagerStatus", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r13 = h.a;     // Catch: Exception -> L11
        h.c("AgentSkillManagerIDLStub", "getSkillManagerStatus(" + r23 + ")");     // Catch: Exception -> L11
    L6:
        String r14 = this.origin.getSkillManagerStatus(r23);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r15 = h.a;     // Catch: Exception -> L11
        h.d("AgentSkillManagerIDLStub", "getSkillManagerStatus = " + r14);     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r16 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        int r2 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentSkillManagerIDLStub", "getSkillManagerStatus(" + r23 + ") = " + r14, r16);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentSkillManagerIDLStub", "getSkillManagerStatus", r16, r18);     // Catch: Exception -> L11
        return r14;
    }

    public void registerSkillObserver(IAgentSkillManagerObserverIDL r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentSkillManagerIDLStub", "registerSkillObserver(" + r20 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentSkillManagerIDLStub", "registerSkillObserver(" + r20 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentSkillManagerIDLStub", "registerSkillObserver", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L24
        h.c("AgentSkillManagerIDLStub", "registerSkillObserver(" + r20 + ")");     // Catch: Exception -> L24
    L6:
        IAgentSkillManagerIDL.Stub r4 = this.origin;     // Catch: Exception -> L24
        if (r20 != null) goto L10;
    L18:
        IAgentSkillManagerObserverIDL r13 = r20;
    L19:
        r4.registerSkillObserver(r13);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        h.d("AgentSkillManagerIDLStub", "registerSkillObserver = void");     // Catch: Exception -> L24
    L22:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L24
        int r5 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("AgentSkillManagerIDLStub", "registerSkillObserver(" + r20 + ") = void", r14);     // Catch: Exception -> L24
        IPCAnomalyTrace.a.e("AgentSkillManagerIDLStub", "registerSkillObserver", r14, r18);     // Catch: Exception -> L24
        return;
    L10:
        if ((r20 instanceof AgentSkillManagerObserverIDLIpcWrapper) == true) goto L18;
        if ((r20 instanceof AgentSkillManagerObserverIDLStubWrapper) == true) goto L18;
        if ((r20 instanceof IAgentSkillManagerObserverIDL.Stub) == false) goto L17;
        r13 = q.a((IAgentSkillManagerObserverIDL.Stub) r20);     // Catch: Exception -> L24
        goto L19
    L17:
        r13 = q.b(r20);     // Catch: Exception -> L24
        goto L19
    }

    public boolean setSkillManagerConfigValues(Bundle r23) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentSkillManagerIDLStub", "setSkillManagerConfigValues(" + r23 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentSkillManagerIDLStub", "setSkillManagerConfigValues(" + r23 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentSkillManagerIDLStub", "setSkillManagerConfigValues", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r13 = h.a;     // Catch: Exception -> L11
        h.c("AgentSkillManagerIDLStub", "setSkillManagerConfigValues(" + r23 + ")");     // Catch: Exception -> L11
    L6:
        boolean r14 = this.origin.setSkillManagerConfigValues(r23);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r15 = h.a;     // Catch: Exception -> L11
        h.d("AgentSkillManagerIDLStub", "setSkillManagerConfigValues = " + r14);     // Catch: Exception -> L11
    L9:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r16 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L11
        int r2 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentSkillManagerIDLStub", "setSkillManagerConfigValues(" + r23 + ") = " + r14, r16);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentSkillManagerIDLStub", "setSkillManagerConfigValues", r16, r18);     // Catch: Exception -> L11
        return r14;
    }

    public AgentSkillManagerIDLStubWrapper(IAgentSkillManagerIDL.Stub r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }
}
