package com.obric.aiagent.assistant.idl;

import android.os.IBinder;
import com.obric.aiagent.assistant.idl.bean.OLocationInfo;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J!\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fH\u0096\u0001¨\u0006\u000e"}, d2 = {"Lcom/obric/aiagent/assistant/idl/FlowGetLocationCallbackIDLStub;", "Lcom/obric/aiagent/assistant/idl/IFlowGetLocationCallbackIDL$Stub;", "Lcom/obric/aiagent/assistant/idl/IFlowGetLocationCallbackIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "onLocationResult", NameKeys.UnloadStrategy_No_Strategy, "success", NameKeys.UnloadStrategy_No_Strategy, "location", "Lcom/obric/aiagent/assistant/idl/bean/OLocationInfo;", "kotlin.jvm.PlatformType", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class FlowGetLocationCallbackIDLStub extends IFlowGetLocationCallbackIDL.Stub {
    private final /* synthetic */ IFlowGetLocationCallbackIDL $$delegate_0;

    public void onLocationResult(boolean r2, OLocationInfo r3) {
        this.$$delegate_0.onLocationResult(r2, r3);
    }

    public FlowGetLocationCallbackIDLStub() {
        IFlowGetLocationCallbackIDL r0 = (IFlowGetLocationCallbackIDLSPI) ServiceManager.get().getService(IFlowGetLocationCallbackIDLSPI.class);
        if (r0 != null) goto L6;
        r0 = new IFlowGetLocationCallbackIDL$Default();
    L6:
        this.$$delegate_0 = r0;
    }

    public IBinder asBinder() {
        return super.asBinder();
    }
}
