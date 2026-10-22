package com.obric.aiagent.assistant.idl;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.idl.IFileIDL;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class AgentIDLStubWrapper extends IAgentIDL.Stub {
    boolean log;
    final IAgentIDL.Stub origin;

    public IAgentDMStateManagerIDL getAgentDMStateManagerIDL() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        h.b("AgentIDLStub", "getAgentDMStateManagerIDL()", e);
        IPCException r2 = new IPCException(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r14 = Math.max(0, r16 - r5) / 1000;
        com.obric.aiagent.ipc.utils.i.c("AgentIDLStub", "getAgentDMStateManagerIDL() = fail", r2, r14);
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentIDLStub", "getAgentDMStateManagerIDL", r2, r14, r16);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        h.c("AgentIDLStub", "getAgentDMStateManagerIDL()");     // Catch: Exception -> L11
    L6:
        IAgentDMStateManagerIDL r11 = this.origin.getAgentDMStateManagerIDL();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r12 = h.a;     // Catch: Exception -> L11
        h.d("AgentIDLStub", "getAgentDMStateManagerIDL = " + r11);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r15 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentIDLStub", "getAgentDMStateManagerIDL() = " + r11, r15);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentIDLStub", "getAgentDMStateManagerIDL", r15, r17);     // Catch: Exception -> L11
        return r11;
    }

    public IAgentNetworkIDL getAgentNetworkIDL() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        h.b("AgentIDLStub", "getAgentNetworkIDL()", e);
        IPCException r2 = new IPCException(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r14 = Math.max(0, r16 - r5) / 1000;
        com.obric.aiagent.ipc.utils.i.c("AgentIDLStub", "getAgentNetworkIDL() = fail", r2, r14);
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentIDLStub", "getAgentNetworkIDL", r2, r14, r16);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        h.c("AgentIDLStub", "getAgentNetworkIDL()");     // Catch: Exception -> L11
    L6:
        IAgentNetworkIDL r11 = this.origin.getAgentNetworkIDL();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r12 = h.a;     // Catch: Exception -> L11
        h.d("AgentIDLStub", "getAgentNetworkIDL = " + r11);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r15 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentIDLStub", "getAgentNetworkIDL() = " + r11, r15);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentIDLStub", "getAgentNetworkIDL", r15, r17);     // Catch: Exception -> L11
        return r11;
    }

    public IAgentAppIntentIDL getAppIntentIDL() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        h.b("AgentIDLStub", "getAppIntentIDL()", e);
        IPCException r2 = new IPCException(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r14 = Math.max(0, r16 - r5) / 1000;
        com.obric.aiagent.ipc.utils.i.c("AgentIDLStub", "getAppIntentIDL() = fail", r2, r14);
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentIDLStub", "getAppIntentIDL", r2, r14, r16);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        h.c("AgentIDLStub", "getAppIntentIDL()");     // Catch: Exception -> L11
    L6:
        IAgentAppIntentIDL r11 = this.origin.getAppIntentIDL();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r12 = h.a;     // Catch: Exception -> L11
        h.d("AgentIDLStub", "getAppIntentIDL = " + r11);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r15 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentIDLStub", "getAppIntentIDL() = " + r11, r15);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentIDLStub", "getAppIntentIDL", r15, r17);     // Catch: Exception -> L11
        return r11;
    }

    public IAgentAssistantStateIDL getAssistantStateIDL() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        h.b("AgentIDLStub", "getAssistantStateIDL()", e);
        IPCException r2 = new IPCException(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r14 = Math.max(0, r16 - r5) / 1000;
        com.obric.aiagent.ipc.utils.i.c("AgentIDLStub", "getAssistantStateIDL() = fail", r2, r14);
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentIDLStub", "getAssistantStateIDL", r2, r14, r16);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        h.c("AgentIDLStub", "getAssistantStateIDL()");     // Catch: Exception -> L11
    L6:
        IAgentAssistantStateIDL r11 = this.origin.getAssistantStateIDL();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r12 = h.a;     // Catch: Exception -> L11
        h.d("AgentIDLStub", "getAssistantStateIDL = " + r11);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r15 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentIDLStub", "getAssistantStateIDL() = " + r11, r15);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentIDLStub", "getAssistantStateIDL", r15, r17);     // Catch: Exception -> L11
        return r11;
    }

    public IFileIDL getFileIDL() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        h.b("AgentIDLStub", "getFileIDL()", e);
        IPCException r2 = new IPCException(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r14 = Math.max(0, r16 - r5) / 1000;
        com.obric.aiagent.ipc.utils.i.c("AgentIDLStub", "getFileIDL() = fail", r2, r14);
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentIDLStub", "getFileIDL", r2, r14, r16);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        h.c("AgentIDLStub", "getFileIDL()");     // Catch: Exception -> L11
    L6:
        IFileIDL r11 = this.origin.getFileIDL();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r12 = h.a;     // Catch: Exception -> L11
        h.d("AgentIDLStub", "getFileIDL = " + r11);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r15 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentIDLStub", "getFileIDL() = " + r11, r15);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentIDLStub", "getFileIDL", r15, r17);     // Catch: Exception -> L11
        return r11;
    }

    public IAgentMessageIDL getMessageIDL() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        h.b("AgentIDLStub", "getMessageIDL()", e);
        IPCException r2 = new IPCException(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r14 = Math.max(0, r16 - r5) / 1000;
        com.obric.aiagent.ipc.utils.i.c("AgentIDLStub", "getMessageIDL() = fail", r2, r14);
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentIDLStub", "getMessageIDL", r2, r14, r16);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        h.c("AgentIDLStub", "getMessageIDL()");     // Catch: Exception -> L11
    L6:
        IAgentMessageIDL r11 = this.origin.getMessageIDL();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r12 = h.a;     // Catch: Exception -> L11
        h.d("AgentIDLStub", "getMessageIDL = " + r11);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r15 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentIDLStub", "getMessageIDL() = " + r11, r15);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentIDLStub", "getMessageIDL", r15, r17);     // Catch: Exception -> L11
        return r11;
    }

    public IPlatformApiIDL getPlatformApiIDL() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        h.b("AgentIDLStub", "getPlatformApiIDL()", e);
        IPCException r2 = new IPCException(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r14 = Math.max(0, r16 - r5) / 1000;
        com.obric.aiagent.ipc.utils.i.c("AgentIDLStub", "getPlatformApiIDL() = fail", r2, r14);
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentIDLStub", "getPlatformApiIDL", r2, r14, r16);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        h.c("AgentIDLStub", "getPlatformApiIDL()");     // Catch: Exception -> L11
    L6:
        IPlatformApiIDL r11 = this.origin.getPlatformApiIDL();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r12 = h.a;     // Catch: Exception -> L11
        h.d("AgentIDLStub", "getPlatformApiIDL = " + r11);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r15 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentIDLStub", "getPlatformApiIDL() = " + r11, r15);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentIDLStub", "getPlatformApiIDL", r15, r17);     // Catch: Exception -> L11
        return r11;
    }

    public IAgentPrivacyIDL getPrivacyIDL() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        h.b("AgentIDLStub", "getPrivacyIDL()", e);
        IPCException r2 = new IPCException(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r14 = Math.max(0, r16 - r5) / 1000;
        com.obric.aiagent.ipc.utils.i.c("AgentIDLStub", "getPrivacyIDL() = fail", r2, r14);
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentIDLStub", "getPrivacyIDL", r2, r14, r16);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        h.c("AgentIDLStub", "getPrivacyIDL()");     // Catch: Exception -> L11
    L6:
        IAgentPrivacyIDL r11 = this.origin.getPrivacyIDL();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r12 = h.a;     // Catch: Exception -> L11
        h.d("AgentIDLStub", "getPrivacyIDL = " + r11);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r15 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentIDLStub", "getPrivacyIDL() = " + r11, r15);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentIDLStub", "getPrivacyIDL", r15, r17);     // Catch: Exception -> L11
        return r11;
    }

    public IAgentSettingsIDL getSettingsIDL() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        h.b("AgentIDLStub", "getSettingsIDL()", e);
        IPCException r2 = new IPCException(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r14 = Math.max(0, r16 - r5) / 1000;
        com.obric.aiagent.ipc.utils.i.c("AgentIDLStub", "getSettingsIDL() = fail", r2, r14);
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentIDLStub", "getSettingsIDL", r2, r14, r16);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        h.c("AgentIDLStub", "getSettingsIDL()");     // Catch: Exception -> L11
    L6:
        IAgentSettingsIDL r11 = this.origin.getSettingsIDL();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r12 = h.a;     // Catch: Exception -> L11
        h.d("AgentIDLStub", "getSettingsIDL = " + r11);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r15 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentIDLStub", "getSettingsIDL() = " + r11, r15);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentIDLStub", "getSettingsIDL", r15, r17);     // Catch: Exception -> L11
        return r11;
    }

    public IAgentSkillManagerIDL getSkillManagerIDL() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        h.b("AgentIDLStub", "getSkillManagerIDL()", e);
        IPCException r2 = new IPCException(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r14 = Math.max(0, r16 - r5) / 1000;
        com.obric.aiagent.ipc.utils.i.c("AgentIDLStub", "getSkillManagerIDL() = fail", r2, r14);
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentIDLStub", "getSkillManagerIDL", r2, r14, r16);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        h.c("AgentIDLStub", "getSkillManagerIDL()");     // Catch: Exception -> L11
    L6:
        IAgentSkillManagerIDL r11 = this.origin.getSkillManagerIDL();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r12 = h.a;     // Catch: Exception -> L11
        h.d("AgentIDLStub", "getSkillManagerIDL = " + r11);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r15 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentIDLStub", "getSkillManagerIDL() = " + r11, r15);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentIDLStub", "getSkillManagerIDL", r15, r17);     // Catch: Exception -> L11
        return r11;
    }

    public IAgentTaskAppIDL getTaskAppIDL() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        h.b("AgentIDLStub", "getTaskAppIDL()", e);
        IPCException r2 = new IPCException(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r14 = Math.max(0, r16 - r5) / 1000;
        com.obric.aiagent.ipc.utils.i.c("AgentIDLStub", "getTaskAppIDL() = fail", r2, r14);
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentIDLStub", "getTaskAppIDL", r2, r14, r16);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        h.c("AgentIDLStub", "getTaskAppIDL()");     // Catch: Exception -> L11
    L6:
        IAgentTaskAppIDL r11 = this.origin.getTaskAppIDL();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r12 = h.a;     // Catch: Exception -> L11
        h.d("AgentIDLStub", "getTaskAppIDL = " + r11);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r15 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentIDLStub", "getTaskAppIDL() = " + r11, r15);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentIDLStub", "getTaskAppIDL", r15, r17);     // Catch: Exception -> L11
        return r11;
    }

    public IAgentVoiceInteractionIDL getVoiceInteractionIDL() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        h.b("AgentIDLStub", "getVoiceInteractionIDL()", e);
        IPCException r2 = new IPCException(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r14 = Math.max(0, r16 - r5) / 1000;
        com.obric.aiagent.ipc.utils.i.c("AgentIDLStub", "getVoiceInteractionIDL() = fail", r2, r14);
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentIDLStub", "getVoiceInteractionIDL", r2, r14, r16);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        h.c("AgentIDLStub", "getVoiceInteractionIDL()");     // Catch: Exception -> L11
    L6:
        IAgentVoiceInteractionIDL r11 = this.origin.getVoiceInteractionIDL();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r12 = h.a;     // Catch: Exception -> L11
        h.d("AgentIDLStub", "getVoiceInteractionIDL = " + r11);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r15 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentIDLStub", "getVoiceInteractionIDL() = " + r11, r15);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentIDLStub", "getVoiceInteractionIDL", r15, r17);     // Catch: Exception -> L11
        return r11;
    }

    public AgentIDLStubWrapper(IAgentIDL.Stub r2) throws RemoteException {
        this(r2, true);
    }

    public void registerFlowIDL(IFlowIDL r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentIDLStub", "registerFlowIDL(" + r20 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentIDLStub", "registerFlowIDL(" + r20 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentIDLStub", "registerFlowIDL", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L24
        h.c("AgentIDLStub", "registerFlowIDL(" + r20 + ")");     // Catch: Exception -> L24
    L6:
        IAgentIDL.Stub r4 = this.origin;     // Catch: Exception -> L24
        if (r20 != null) goto L10;
    L18:
        IFlowIDL r13 = r20;
    L19:
        r4.registerFlowIDL(r13);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        h.d("AgentIDLStub", "registerFlowIDL = void");     // Catch: Exception -> L24
    L22:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L24
        int r5 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("AgentIDLStub", "registerFlowIDL(" + r20 + ") = void", r14);     // Catch: Exception -> L24
        IPCAnomalyTrace.a.e("AgentIDLStub", "registerFlowIDL", r14, r18);     // Catch: Exception -> L24
        return;
    L10:
        if ((r20 instanceof FlowIDLIpcWrapper) == true) goto L18;
        if ((r20 instanceof FlowIDLStubWrapper) == true) goto L18;
        if ((r20 instanceof IFlowIDL.Stub) == false) goto L17;
        r13 = c2.b((IFlowIDL.Stub) r20, true);     // Catch: Exception -> L24
        goto L19
    L17:
        r13 = c2.c(r20);     // Catch: Exception -> L24
        goto L19
    }

    public AgentIDLStubWrapper(IAgentIDL.Stub r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }
}
