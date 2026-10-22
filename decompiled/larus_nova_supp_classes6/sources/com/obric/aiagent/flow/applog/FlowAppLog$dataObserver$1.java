package com.obric.aiagent.flow.applog;

import com.obric.aiagent.flow.applog.idl.IFlowAppLogDataObserverIDL;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016JL\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0011"}, d2 = {"com/obric/aiagent/flow/applog/FlowAppLog$dataObserver$1", "Lcom/obric/aiagent/flow/applog/idl/IFlowAppLogDataObserverIDL$Stub;", "onIdLoaded", "", "did", "", "iid", "ssid", "onRemoteIdGet", "changed", "", "oldDid", "newDid", "oldIid", "newIid", "oldSsid", "newSsid", "flow-applog_release"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class FlowAppLog$dataObserver$1 extends IFlowAppLogDataObserverIDL.Stub {
    public FlowAppLog$dataObserver$1() {
    }

    public void onIdLoaded(String r4, String r5, String r6) {
        ISecureLogDepend.b.i("FlowAppLog", "addDataObserver onIdLoaded, did: " + r4 + ", iid: " + r5 + ", ssid: " + r6);
        FlowAppLog r7 = FlowAppLog.a;
    }

    public void onRemoteIdGet(boolean r4, String r5, String r6, String r7, String r8, String r9, String r10) {
        ISecureLogDepend.b.i("FlowAppLog", "addDataObserver onRemoteIdGet, changed: " + r4 + ", oldDid: " + r5 + ", newDid: " + r6 + ", oldIid: " + r7 + ", newIid: " + r8 + ", oldSsid: " + r9 + ", newSsid: " + r10);
        if (r4 == false) goto L6;
        FlowAppLog r11 = FlowAppLog.a;
        return;
    }
}
