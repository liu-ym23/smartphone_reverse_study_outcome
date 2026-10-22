package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\t\u0010\u0007\u001a\u00020\bH\u0096\u0001J\u0019\u0010\t\u001a\u00020\b2\u000e\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bH\u0096\u0001¨\u0006\r"}, d2 = {"Lcom/obric/aiagent/assistant/idl/FlowFindMessageCallbackIDLStub;", "Lcom/obric/aiagent/assistant/idl/IFlowFindMessageCallbackIDL$Stub;", "Lcom/obric/aiagent/assistant/idl/IFlowFindMessageCallbackIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "onFail", NameKeys.UnloadStrategy_No_Strategy, "onSuccess", "message", "Lcom/obric/aiagent/assistant/idl/bean/IMMessage;", "kotlin.jvm.PlatformType", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class FlowFindMessageCallbackIDLStub extends IFlowFindMessageCallbackIDL.Stub {
    private final /* synthetic */ IFlowFindMessageCallbackIDL $$delegate_0;

    public void onFail() {
        this.$$delegate_0.onFail();
    }

    public void onSuccess(IMMessage r2) {
        this.$$delegate_0.onSuccess(r2);
    }

    public FlowFindMessageCallbackIDLStub() {
        IFlowFindMessageCallbackIDL r0 = (IFlowFindMessageCallbackIDLSPI) ServiceManager.get().getService(IFlowFindMessageCallbackIDLSPI.class);
        if (r0 != null) goto L6;
        r0 = new IFlowFindMessageCallbackIDL$Default();
    L6:
        this.$$delegate_0 = r0;
    }

    public IBinder asBinder() {
        return super.asBinder();
    }
}
