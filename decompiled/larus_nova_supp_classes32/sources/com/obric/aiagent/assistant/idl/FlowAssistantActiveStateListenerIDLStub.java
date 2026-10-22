package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0011\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001¨\u0006\u000b"}, d2 = {"Lcom/obric/aiagent/assistant/idl/FlowAssistantActiveStateListenerIDLStub;", "Lcom/obric/aiagent/assistant/idl/IFlowAssistantActiveStateListenerIDL$Stub;", "Lcom/obric/aiagent/assistant/idl/IFlowAssistantActiveStateListenerIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "onChanged", NameKeys.UnloadStrategy_No_Strategy, "active", NameKeys.UnloadStrategy_No_Strategy, "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class FlowAssistantActiveStateListenerIDLStub extends IFlowAssistantActiveStateListenerIDL.Stub {
    private final /* synthetic */ IFlowAssistantActiveStateListenerIDL $$delegate_0;

    public void onChanged(boolean r2) {
        this.$$delegate_0.onChanged(r2);
    }

    public FlowAssistantActiveStateListenerIDLStub() {
        IFlowAssistantActiveStateListenerIDL r0 = (IFlowAssistantActiveStateListenerIDLSPI) ServiceManager.get().getService(IFlowAssistantActiveStateListenerIDLSPI.class);
        if (r0 != null) goto L6;
        r0 = new IFlowAssistantActiveStateListenerIDL$Default();
    L6:
        this.$$delegate_0 = r0;
    }

    public IBinder asBinder() {
        return super.asBinder();
    }
}
