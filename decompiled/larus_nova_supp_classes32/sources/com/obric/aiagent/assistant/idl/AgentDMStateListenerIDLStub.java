package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.obric.aiagent.assistant.idl.bean.DMStateInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0019\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001J\u0019\u0010\f\u001a\u00020\b2\u000e\u0010\r\u001a\n \u000b*\u0004\u0018\u00010\u000e0\u000eH\u0096\u0001J\u0019\u0010\u000f\u001a\u00020\b2\u000e\u0010\r\u001a\n \u000b*\u0004\u0018\u00010\u000e0\u000eH\u0096\u0001J9\u0010\u0010\u001a\u00020\b2\u000e\u0010\r\u001a\n \u000b*\u0004\u0018\u00010\u000e0\u000e2\u000e\u0010\u0011\u001a\n \u000b*\u0004\u0018\u00010\u00120\u00122\u000e\u0010\u0013\u001a\n \u000b*\u0004\u0018\u00010\u00120\u0012H\u0096\u0001¨\u0006\u0014"}, d2 = {"Lcom/obric/aiagent/assistant/idl/AgentDMStateListenerIDLStub;", "Lcom/obric/aiagent/assistant/idl/IAgentDMStateListenerIDL$Stub;", "Lcom/obric/aiagent/assistant/idl/IAgentDMStateListenerIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "onDMStateChanged", NameKeys.UnloadStrategy_No_Strategy, "dmState", "Lcom/obric/aiagent/assistant/idl/bean/DMStateInfo;", "kotlin.jvm.PlatformType", "onTaskAdded", "taskInfo", "Lcom/obric/aiagent/assistant/idl/bean/DMTaskInfo;", "onTaskEnd", "onTaskStateChanged", "previousState", "Lcom/obric/aiagent/assistant/idl/bean/DMTaskState;", "newState", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class AgentDMStateListenerIDLStub extends IAgentDMStateListenerIDL.Stub {
    private final /* synthetic */ IAgentDMStateListenerIDL $$delegate_0;

    public void onDMStateChanged(DMStateInfo r2) {
        this.$$delegate_0.onDMStateChanged(r2);
    }

    public void onTaskAdded(DMTaskInfo r2) {
        this.$$delegate_0.onTaskAdded(r2);
    }

    public void onTaskEnd(DMTaskInfo r2) {
        this.$$delegate_0.onTaskEnd(r2);
    }

    public void onTaskStateChanged(DMTaskInfo r2, DMTaskState r3, DMTaskState r4) {
        this.$$delegate_0.onTaskStateChanged(r2, r3, r4);
    }

    public AgentDMStateListenerIDLStub() {
        IAgentDMStateListenerIDL r0 = (IAgentDMStateListenerIDLSPI) ServiceManager.get().getService(IAgentDMStateListenerIDLSPI.class);
        if (r0 != null) goto L6;
        r0 = new IAgentDMStateListenerIDL$Default();
    L6:
        this.$$delegate_0 = r0;
    }

    public IBinder asBinder() {
        return super.asBinder();
    }
}
