package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J5\u0010\u0007\u001a\u00020\b2*\u0010\t\u001a&\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b \f*\u0012\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010\r0\nH\u0096\u0001J\u0019\u0010\u000e\u001a\u00020\b2\u000e\u0010\u000f\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bH\u0096\u0001J\u0019\u0010\u0010\u001a\u00020\b2\u000e\u0010\u000f\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bH\u0096\u0001J\u0019\u0010\u0011\u001a\u00020\b2\u000e\u0010\u000f\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bH\u0096\u0001J\u0019\u0010\u0012\u001a\u00020\b2\u000e\u0010\u000f\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bH\u0096\u0001¨\u0006\u0013"}, d2 = {"Lcom/obric/aiagent/assistant/idl/FlowMessageCallbackIDLStub;", "Lcom/obric/aiagent/assistant/idl/IFlowMessageCallbackIDL$Stub;", "Lcom/obric/aiagent/assistant/idl/IFlowMessageCallbackIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "onInsertMessageList", NameKeys.UnloadStrategy_No_Strategy, "messageList", NameKeys.UnloadStrategy_No_Strategy, "Lcom/obric/aiagent/assistant/idl/bean/IMMessage;", "kotlin.jvm.PlatformType", NameKeys.UnloadStrategy_No_Strategy, "onReceiveMessage", "message", "onRegenMessage", "onSendMessage", "onUpdateMessage", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class FlowMessageCallbackIDLStub extends IFlowMessageCallbackIDL.Stub {
    private final /* synthetic */ IFlowMessageCallbackIDL $$delegate_0;

    public void onInsertMessageList(List<IMMessage> r2) {
        this.$$delegate_0.onInsertMessageList(r2);
    }

    public void onReceiveMessage(IMMessage r2) {
        this.$$delegate_0.onReceiveMessage(r2);
    }

    public void onRegenMessage(IMMessage r2) {
        this.$$delegate_0.onRegenMessage(r2);
    }

    public void onSendMessage(IMMessage r2) {
        this.$$delegate_0.onSendMessage(r2);
    }

    public void onUpdateMessage(IMMessage r2) {
        this.$$delegate_0.onUpdateMessage(r2);
    }

    public FlowMessageCallbackIDLStub() {
        IFlowMessageCallbackIDL r0 = (IFlowMessageCallbackIDLSPI) ServiceManager.get().getService(IFlowMessageCallbackIDLSPI.class);
        if (r0 != null) goto L6;
        r0 = new IFlowMessageCallbackIDL$Default();
    L6:
        this.$$delegate_0 = r0;
    }

    public IBinder asBinder() {
        return super.asBinder();
    }
}
