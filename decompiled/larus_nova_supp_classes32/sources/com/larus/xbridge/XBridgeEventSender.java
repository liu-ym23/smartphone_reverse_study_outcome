package com.larus.xbridge;

import com.larus.platform.api.IXBridgeEventSender;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\f"}, d2 = {"Lcom/larus/xbridge/XBridgeEventSender;", "Lcom/larus/platform/api/IXBridgeEventSender;", "<init>", "()V", "sendEvent", NameKeys.UnloadStrategy_No_Strategy, "eventName", NameKeys.UnloadStrategy_No_Strategy, LynxResourceModule.PARAMS_KEY, NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, "containerID", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class XBridgeEventSender implements IXBridgeEventSender {
    public XBridgeEventSender() {
    }

    public final void sendEvent(String r3, Map r4) {
        Intrinsics.checkNotNullParameter(r3, "eventName");
        IXBridgeApi.a.b(r3, r4, null);
    }
}
