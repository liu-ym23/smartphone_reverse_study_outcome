package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.obric.aiagent.ipc.idl.IFileIDL;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0011\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bH\u0096\u0001J\u0011\u0010\n\u001a\n \t*\u0004\u0018\u00010\u000b0\u000bH\u0096\u0001J\u0011\u0010\f\u001a\n \t*\u0004\u0018\u00010\r0\rH\u0096\u0001J\u0011\u0010\u000e\u001a\n \t*\u0004\u0018\u00010\u000f0\u000fH\u0096\u0001J\u0011\u0010\u0010\u001a\n \t*\u0004\u0018\u00010\u00110\u0011H\u0096\u0001J\u0011\u0010\u0012\u001a\n \t*\u0004\u0018\u00010\u00130\u0013H\u0096\u0001J\u0011\u0010\u0014\u001a\n \t*\u0004\u0018\u00010\u00150\u0015H\u0096\u0001J\u0011\u0010\u0016\u001a\n \t*\u0004\u0018\u00010\u00170\u0017H\u0096\u0001J\u0011\u0010\u0018\u001a\n \t*\u0004\u0018\u00010\u00190\u0019H\u0096\u0001J\u0011\u0010\u001a\u001a\n \t*\u0004\u0018\u00010\u001b0\u001bH\u0096\u0001J\u0011\u0010\u001c\u001a\n \t*\u0004\u0018\u00010\u001d0\u001dH\u0096\u0001J\u0011\u0010\u001e\u001a\n \t*\u0004\u0018\u00010\u001f0\u001fH\u0096\u0001J\u0019\u0010 \u001a\u00020!2\u000e\u0010\"\u001a\n \t*\u0004\u0018\u00010#0#H\u0096\u0001¨\u0006$"}, d2 = {"Lcom/obric/aiagent/assistant/idl/AgentIDLStub;", "Lcom/obric/aiagent/assistant/idl/IAgentIDL$Stub;", "Lcom/obric/aiagent/assistant/idl/IAgentIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "getAgentDMStateManagerIDL", "Lcom/obric/aiagent/assistant/idl/IAgentDMStateManagerIDL;", "kotlin.jvm.PlatformType", "getAgentNetworkIDL", "Lcom/obric/aiagent/assistant/idl/IAgentNetworkIDL;", "getAppIntentIDL", "Lcom/obric/aiagent/assistant/idl/IAgentAppIntentIDL;", "getAssistantStateIDL", "Lcom/obric/aiagent/assistant/idl/IAgentAssistantStateIDL;", "getFileIDL", "Lcom/obric/aiagent/ipc/idl/IFileIDL;", "getMessageIDL", "Lcom/obric/aiagent/assistant/idl/IAgentMessageIDL;", "getPlatformApiIDL", "Lcom/obric/aiagent/assistant/idl/IPlatformApiIDL;", "getPrivacyIDL", "Lcom/obric/aiagent/assistant/idl/IAgentPrivacyIDL;", "getSettingsIDL", "Lcom/obric/aiagent/assistant/idl/IAgentSettingsIDL;", "getSkillManagerIDL", "Lcom/obric/aiagent/assistant/idl/IAgentSkillManagerIDL;", "getTaskAppIDL", "Lcom/obric/aiagent/assistant/idl/IAgentTaskAppIDL;", "getVoiceInteractionIDL", "Lcom/obric/aiagent/assistant/idl/IAgentVoiceInteractionIDL;", "registerFlowIDL", "", "flowIDL", "Lcom/obric/aiagent/assistant/idl/IFlowIDL;", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
final class AgentIDLStub extends IAgentIDL.Stub {
    private final /* synthetic */ IAgentIDL $$delegate_0;

    public IAgentDMStateManagerIDL getAgentDMStateManagerIDL() {
        return this.$$delegate_0.getAgentDMStateManagerIDL();
    }

    public IAgentNetworkIDL getAgentNetworkIDL() {
        return this.$$delegate_0.getAgentNetworkIDL();
    }

    public IAgentAppIntentIDL getAppIntentIDL() {
        return this.$$delegate_0.getAppIntentIDL();
    }

    public IAgentAssistantStateIDL getAssistantStateIDL() {
        return this.$$delegate_0.getAssistantStateIDL();
    }

    public IFileIDL getFileIDL() {
        return this.$$delegate_0.getFileIDL();
    }

    public IAgentMessageIDL getMessageIDL() {
        return this.$$delegate_0.getMessageIDL();
    }

    public IPlatformApiIDL getPlatformApiIDL() {
        return this.$$delegate_0.getPlatformApiIDL();
    }

    public IAgentPrivacyIDL getPrivacyIDL() {
        return this.$$delegate_0.getPrivacyIDL();
    }

    public IAgentSettingsIDL getSettingsIDL() {
        return this.$$delegate_0.getSettingsIDL();
    }

    public IAgentSkillManagerIDL getSkillManagerIDL() {
        return this.$$delegate_0.getSkillManagerIDL();
    }

    public IAgentTaskAppIDL getTaskAppIDL() {
        return this.$$delegate_0.getTaskAppIDL();
    }

    public IAgentVoiceInteractionIDL getVoiceInteractionIDL() {
        return this.$$delegate_0.getVoiceInteractionIDL();
    }

    public void registerFlowIDL(IFlowIDL r2) {
        this.$$delegate_0.registerFlowIDL(r2);
    }

    public AgentIDLStub() {
        IAgentIDL r0 = (IAgentIDLSPI) ServiceManager.get().getService(IAgentIDLSPI.class);
        if (r0 != null) goto L6;
        r0 = new IAgentIDL$Default();
    L6:
        this.$$delegate_0 = r0;
    }

    public IBinder asBinder() {
        return super.asBinder();
    }
}
