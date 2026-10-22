package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.obric.aiagent.assistant.idl.bean.PicInfo;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0011\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bH\u0096\u0001¨\u0006\n"}, d2 = {"Lcom/obric/aiagent/assistant/idl/AgentMessageIDLStub;", "Lcom/obric/aiagent/assistant/idl/IAgentMessageIDL$Stub;", "Lcom/obric/aiagent/assistant/idl/IAgentMessageIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "getScreenPicInfo", "Lcom/obric/aiagent/assistant/idl/bean/PicInfo;", "kotlin.jvm.PlatformType", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
final class AgentMessageIDLStub extends IAgentMessageIDL.Stub {
    private final /* synthetic */ IAgentMessageIDL $$delegate_0;

    public PicInfo getScreenPicInfo() {
        return this.$$delegate_0.getScreenPicInfo();
    }

    public AgentMessageIDLStub() {
        IAgentMessageIDL r0 = (IAgentMessageIDLSPI) ServiceManager.get().getService(IAgentMessageIDLSPI.class);
        if (r0 != null) goto L6;
        r0 = new IAgentMessageIDL$Default();
    L6:
        this.$$delegate_0 = r0;
    }

    public IBinder asBinder() {
        return super.asBinder();
    }
}
