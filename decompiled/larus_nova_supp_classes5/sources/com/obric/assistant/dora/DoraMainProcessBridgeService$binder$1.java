package com.obric.assistant.dora;

import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J&\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"com/obric/assistant/dora/DoraMainProcessBridgeService$binder$1", "Lcom/obric/assistant/dora/IDoraMainProcessBridgeService$Stub;", "getStateSnapshot", "Lcom/obric/assistant/dora/DoraMainProcessStateSnapshot;", "checkBindAndConnectIfNecessaryAsync", "", "deviceInfo", "Lcom/obric/assistant/dora/DoraDeviceInfo;", "requestId", "", "callback", "Lcom/obric/assistant/dora/IDoraMainProcessConnectCallback;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraMainProcessBridgeService$binder$1 extends IDoraMainProcessBridgeService$Stub {
    final /* synthetic */ DoraMainProcessBridgeService this$0;

    public DoraMainProcessStateSnapshot getStateSnapshot() {
        DoraMainProcessBridgeService r0 = this.this$0;
        int r1 = DoraMainProcessBridgeService.i;
        r0.d();
        return this.this$0.d;
    }

    public DoraMainProcessBridgeService$binder$1(DoraMainProcessBridgeService r1) {
        this.this$0 = r1;
    }

    public void checkBindAndConnectIfNecessaryAsync(DoraDeviceInfo r21, String r22, IDoraMainProcessConnectCallback r23) {
        if (r21 != null) goto L4;
        DoraDeviceInfo r16 = new DoraDeviceInfo(null, null, null, null, 0, 0, null, 0, 0, 0, 0, 16383);
    L5:
        DoraMainProcessBridgeService r15 = this.this$0;
        BuildersKt.launch$default(r15.a, null, null, new checkBindAndConnectIfNecessaryAsync.1(r15, r16, r22, r23, null), 3, null);
        return;
    L4:
        r16 = r21;
        goto L5
    }
}
