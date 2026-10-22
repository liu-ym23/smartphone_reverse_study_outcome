package com.obric.aiagent.flow.applog.idl;

import android.os.IBinder;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J9\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u000e\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u000e\u0010\r\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001Jq\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u000e\u0010\u0012\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u000e\u0010\u0013\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u000e\u0010\u0014\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u000e\u0010\u0015\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u000e\u0010\u0016\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001¨\u0006\u0017"}, d2 = {"Lcom/obric/aiagent/flow/applog/idl/FlowAppLogDataObserverIDLStub;", "Lcom/obric/aiagent/flow/applog/idl/IFlowAppLogDataObserverIDL$Stub;", "Lcom/obric/aiagent/flow/applog/idl/IFlowAppLogDataObserverIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "onIdLoaded", NameKeys.UnloadStrategy_No_Strategy, "did", NameKeys.UnloadStrategy_No_Strategy, "kotlin.jvm.PlatformType", "iid", "ssid", "onRemoteIdGet", "changed", NameKeys.UnloadStrategy_No_Strategy, "oldDid", "newDid", "oldIid", "newIid", "oldSsid", "newSsid", "flow-applog_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class FlowAppLogDataObserverIDLStub extends IFlowAppLogDataObserverIDL.Stub {
    private final /* synthetic */ IFlowAppLogDataObserverIDL $$delegate_0;

    public void onIdLoaded(String r2, String r3, String r4) {
        this.$$delegate_0.onIdLoaded(r2, r3, r4);
    }

    public void onRemoteIdGet(boolean r9, String r10, String r11, String r12, String r13, String r14, String r15) {
        this.$$delegate_0.onRemoteIdGet(r9, r10, r11, r12, r13, r14, r15);
    }

    public FlowAppLogDataObserverIDLStub() {
        IFlowAppLogDataObserverIDL r0 = (IFlowAppLogDataObserverIDLSPI) ServiceManager.get().getService(IFlowAppLogDataObserverIDLSPI.class);
        if (r0 != null) goto L6;
        r0 = new IFlowAppLogDataObserverIDL$Default();
    L6:
        this.$$delegate_0 = r0;
    }

    public IBinder asBinder() {
        return super.asBinder();
    }
}
