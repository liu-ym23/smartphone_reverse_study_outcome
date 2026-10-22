package com.obric.aiagent.assistant.idl;

import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.bean.PicInfo;
import com.obric.aiagent.ipc.utils.IPCAnomalyTrace;
import com.obric.aiagent.ipc.utils.IPCException;
import com.obric.aiagent.ipc.utils.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class AgentMessageIDLStubWrapper extends IAgentMessageIDL.Stub {
    boolean log;
    final IAgentMessageIDL.Stub origin;

    public PicInfo getScreenPicInfo() throws RemoteException {
        long r5 = SystemClock.elapsedRealtimeNanos();
    L11:
        e = move-exception;
        h.b("AgentMessageIDLStub", "getScreenPicInfo()", e);
        IPCException r2 = new IPCException(e);
        long r16 = SystemClock.elapsedRealtimeNanos();
        long r14 = Math.max(0, r16 - r5) / 1000;
        com.obric.aiagent.ipc.utils.i.c("AgentMessageIDLStub", "getScreenPicInfo() = fail", r2, r14);
        IPCAnomalyTrace r0 = IPCAnomalyTrace.a;
        IPCAnomalyTrace.d("AgentMessageIDLStub", "getScreenPicInfo", r2, r14, r16);
        throw r2;
    L4:
        if (this.log == false) goto L6;
        h.c("AgentMessageIDLStub", "getScreenPicInfo()");     // Catch: Exception -> L11
    L6:
        PicInfo r11 = this.origin.getScreenPicInfo();     // Catch: Exception -> L11
        if (this.log == false) goto L9;
        int r12 = h.a;     // Catch: Exception -> L11
        h.d("AgentMessageIDLStub", "getScreenPicInfo = " + r11);     // Catch: Exception -> L11
    L9:
        long r17 = SystemClock.elapsedRealtimeNanos();     // Catch: Exception -> L11
        long r15 = Math.max(0, r17 - r5) / 1000;     // Catch: Exception -> L11
        int r4 = com.obric.aiagent.ipc.utils.i.a;     // Catch: Exception -> L11
        com.obric.aiagent.ipc.utils.i.d("AgentMessageIDLStub", "getScreenPicInfo() = " + r11, r15);     // Catch: Exception -> L11
        IPCAnomalyTrace.a.e("AgentMessageIDLStub", "getScreenPicInfo", r15, r17);     // Catch: Exception -> L11
        return r11;
    }

    public AgentMessageIDLStubWrapper(IAgentMessageIDL.Stub r2) throws RemoteException {
        this(r2, true);
    }

    public AgentMessageIDLStubWrapper(IAgentMessageIDL.Stub r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }
}
