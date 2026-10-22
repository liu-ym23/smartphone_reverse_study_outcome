package com.obric.aiagent.assistant.idl;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.DMStateInfo;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class AgentDMStateManagerIDLStubWrapper extends IAgentDMStateManagerIDL.Stub {
    boolean log;
    final IAgentDMStateManagerIDL.Stub origin;

    public DMStateInfo getCurrentDMSteate() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        h.b("AgentDMStateManagerIDLStub", "getCurrentDMSteate()", e);
        IPCException r2 = new IPCException(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r14 = Math.max(0, r16 - r5) / 1000;
        com.obric.aiagent.ipc.utils.i.c("AgentDMStateManagerIDLStub", "getCurrentDMSteate() = fail", r2, r14);
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentDMStateManagerIDLStub", "getCurrentDMSteate", r2, r14, r16);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        h.c("AgentDMStateManagerIDLStub", "getCurrentDMSteate()");     // Catch: Exception -> L11
    L6:
        DMStateInfo r11 = this.origin.getCurrentDMSteate();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r12 = h.a;     // Catch: Exception -> L11
        h.d("AgentDMStateManagerIDLStub", "getCurrentDMSteate = " + r11);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r15 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentDMStateManagerIDLStub", "getCurrentDMSteate() = " + r11, r15);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentDMStateManagerIDLStub", "getCurrentDMSteate", r15, r17);     // Catch: Exception -> L11
        return r11;
    }

    public AgentDMStateManagerIDLStubWrapper(IAgentDMStateManagerIDL.Stub r2) throws RemoteException {
        this(r2, true);
    }

    public void registerDMStateListener(IAgentDMStateListenerIDL r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentDMStateManagerIDLStub", "registerDMStateListener(" + r20 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentDMStateManagerIDLStub", "registerDMStateListener(" + r20 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentDMStateManagerIDLStub", "registerDMStateListener", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L24
        h.c("AgentDMStateManagerIDLStub", "registerDMStateListener(" + r20 + ")");     // Catch: Exception -> L24
    L6:
        IAgentDMStateManagerIDL.Stub r4 = this.origin;     // Catch: Exception -> L24
        if (r20 != null) goto L10;
    L18:
        IAgentDMStateListenerIDL r13 = r20;
    L19:
        r4.registerDMStateListener(r13);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        h.d("AgentDMStateManagerIDLStub", "registerDMStateListener = void");     // Catch: Exception -> L24
    L22:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L24
        int r5 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("AgentDMStateManagerIDLStub", "registerDMStateListener(" + r20 + ") = void", r14);     // Catch: Exception -> L24
        IPCAnomalyTrace.a.e("AgentDMStateManagerIDLStub", "registerDMStateListener", r14, r18);     // Catch: Exception -> L24
        return;
    L10:
        if ((r20 instanceof AgentDMStateListenerIDLIpcWrapper) == true) goto L18;
        if ((r20 instanceof AgentDMStateListenerIDLStubWrapper) == true) goto L18;
        if ((r20 instanceof IAgentDMStateListenerIDL.Stub) == false) goto L17;
        r13 = e.a((IAgentDMStateListenerIDL.Stub) r20);     // Catch: Exception -> L24
        goto L19
    L17:
        r13 = e.b(r20);     // Catch: Exception -> L24
        goto L19
    }

    public void unRegisterDMStateListener(IAgentDMStateListenerIDL r20) throws RemoteException {
        long r6 = SystemClock.elapsedRealtimeNanos();
    L24:
        e = move-exception;
        int r12 = h.a;
        h.b("AgentDMStateManagerIDLStub", "unRegisterDMStateListener(" + r20 + ")", e);
        IPCException r3 = new IPCException(e);
        long r17 = SystemClock.elapsedRealtimeNanos();
        long r7 = Math.max(0, r17 - r6) / 1000;
        int r0 = com.obric.aiagent.ipc.utils.i.a;
        com.obric.aiagent.ipc.utils.i.c("AgentDMStateManagerIDLStub", "unRegisterDMStateListener(" + r20 + ") = fail", r3, r7);
        IPCAnomalyTrace r1 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentDMStateManagerIDLStub", "unRegisterDMStateListener", r3, r7, r17);
        throw r3;
    L4:
        if (this.log == false) goto L6;
        int r2 = h.a;     // Catch: Exception -> L24
        h.c("AgentDMStateManagerIDLStub", "unRegisterDMStateListener(" + r20 + ")");     // Catch: Exception -> L24
    L6:
        IAgentDMStateManagerIDL.Stub r4 = this.origin;     // Catch: Exception -> L24
        if (r20 != null) goto L10;
    L18:
        IAgentDMStateListenerIDL r13 = r20;
    L19:
        r4.unRegisterDMStateListener(r13);     // Catch: Exception -> L24
        if (this.log == false) goto L22;
        h.d("AgentDMStateManagerIDLStub", "unRegisterDMStateListener = void");     // Catch: Exception -> L24
    L22:
        long r18 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L24
        long r14 = Math.max(0, r18 - r6) / 1000;     // Catch: Exception -> L24
        int r5 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L24
        com.obric.aiagent.ipc.utils.i.d("AgentDMStateManagerIDLStub", "unRegisterDMStateListener(" + r20 + ") = void", r14);     // Catch: Exception -> L24
        IPCAnomalyTrace.a.e("AgentDMStateManagerIDLStub", "unRegisterDMStateListener", r14, r18);     // Catch: Exception -> L24
        return;
    L10:
        if ((r20 instanceof AgentDMStateListenerIDLIpcWrapper) == true) goto L18;
        if ((r20 instanceof AgentDMStateListenerIDLStubWrapper) == true) goto L18;
        if ((r20 instanceof IAgentDMStateListenerIDL.Stub) == false) goto L17;
        r13 = e.a((IAgentDMStateListenerIDL.Stub) r20);     // Catch: Exception -> L24
        goto L19
    L17:
        r13 = e.b(r20);     // Catch: Exception -> L24
        goto L19
    }

    public AgentDMStateManagerIDLStubWrapper(IAgentDMStateManagerIDL.Stub r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }
}
