package com.obric.aiagent.assistant.idl;

import android.os.RemoteException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class AgentAssistantStateIDLStubWrapper extends IAgentAssistantStateIDL.Stub {
    boolean log;
    final IAgentAssistantStateIDL.Stub origin;

    public AgentAssistantStateIDLStubWrapper(IAgentAssistantStateIDL.Stub r2) throws RemoteException {
        this(r2, true);
    }

    public AgentAssistantStateIDLStubWrapper(IAgentAssistantStateIDL.Stub r1, boolean r2) throws RemoteException {
        this.origin = r1;
        this.log = r2;
    }
}
