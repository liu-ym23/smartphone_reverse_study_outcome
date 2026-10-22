package com.obric.aiagent.assistant.idl;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class AgentSettingsIDLStubWrapper extends IAgentSettingsIDL.Stub {
    boolean log;
    final IAgentSettingsIDL.Stub origin;

    public boolean isAutoGuiInstall() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        h.b("AgentSettingsIDLStub", "isAutoGuiInstall()", e);
        IPCException r2 = new IPCException(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r14 = Math.max(0, r16 - r5) / 1000;
        com.obric.aiagent.ipc.utils.i.c("AgentSettingsIDLStub", "isAutoGuiInstall() = fail", r2, r14);
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentSettingsIDLStub", "isAutoGuiInstall", r2, r14, r16);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        h.c("AgentSettingsIDLStub", "isAutoGuiInstall()");     // Catch: Exception -> L11
    L6:
        boolean r11 = this.origin.isAutoGuiInstall();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r12 = h.a;     // Catch: Exception -> L11
        h.d("AgentSettingsIDLStub", "isAutoGuiInstall = " + r11);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r15 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentSettingsIDLStub", "isAutoGuiInstall() = " + r11, r15);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentSettingsIDLStub", "isAutoGuiInstall", r15, r17);     // Catch: Exception -> L11
        return r11;
    }

    public boolean isMemoryRecommendActivityEnabled() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        h.b("AgentSettingsIDLStub", "isMemoryRecommendActivityEnabled()", e);
        IPCException r2 = new IPCException(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r14 = Math.max(0, r16 - r5) / 1000;
        com.obric.aiagent.ipc.utils.i.c("AgentSettingsIDLStub", "isMemoryRecommendActivityEnabled() = fail", r2, r14);
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentSettingsIDLStub", "isMemoryRecommendActivityEnabled", r2, r14, r16);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        h.c("AgentSettingsIDLStub", "isMemoryRecommendActivityEnabled()");     // Catch: Exception -> L11
    L6:
        boolean r11 = this.origin.isMemoryRecommendActivityEnabled();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r12 = h.a;     // Catch: Exception -> L11
        h.d("AgentSettingsIDLStub", "isMemoryRecommendActivityEnabled = " + r11);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r15 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentSettingsIDLStub", "isMemoryRecommendActivityEnabled() = " + r11, r15);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentSettingsIDLStub", "isMemoryRecommendActivityEnabled", r15, r17);     // Catch: Exception -> L11
        return r11;
    }

    public AgentSettingsIDLStubWrapper(IAgentSettingsIDL.Stub r2) throws RemoteException {
        this(r2, true);
    }

    public AgentSettingsIDLStubWrapper(IAgentSettingsIDL.Stub r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }

    public void setSystemProperty(String r22, String r23) throws RemoteException {
        long r8 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        int r10 = h.a;
        h.b("AgentSettingsIDLStub", "setSystemProperty(" + r22 + ", " + r23 + ")", e);
        IPCException r4 = new IPCException(e);
        long r19 = SystemClock.elapsedRealtimeNanos();
        long r9 = Math.max(0, r19 - r8) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentSettingsIDLStub", "setSystemProperty(" + r22 + ", " + r23 + ") = fail", r4, r9);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentSettingsIDLStub", "setSystemProperty", r4, r9, r19);
        throw r4;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L11
        h.c("AgentSettingsIDLStub", "setSystemProperty(" + r22 + ", " + r23 + ")");     // Catch: Exception -> L11
    L6:
        this.origin.setSystemProperty(r22, r23);     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        h.d("AgentSettingsIDLStub", "setSystemProperty = void");     // Catch: Exception -> L11
    L9:
        long r110 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r14 = Math.max(0, r110 - r8) / 1000;     // Catch: Exception -> L11
        int r3 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentSettingsIDLStub", "setSystemProperty(" + r22 + ", " + r23 + ") = void", r14);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentSettingsIDLStub", "setSystemProperty", r14, r110);     // Catch: Exception -> L11
    }
}
