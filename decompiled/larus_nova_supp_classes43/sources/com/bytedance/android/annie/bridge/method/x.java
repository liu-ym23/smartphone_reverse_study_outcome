package com.bytedance.android.annie.bridge.method;

import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "getContainerID")
public final class x extends com.bytedance.ies.web.jsbridge2.f<JSONObject, Object> {
    public final IHybridComponent a;

    public final void onTerminate() {
    }

    public x(m16.b r10) {
        Intrinsics.checkNotNullParameter(r10, "contextProviderFactory");
        IHybridComponent r11 = (IHybridComponent) r10.c(IHybridComponent.class);
        if (r11 == null) goto L6;
        this.a = r11;
        return;
    }

    public x(IHybridComponent r1) {
        this.a = r1;
    }

    public final void invoke(Object r10, CallContext r11) {
        Intrinsics.checkNotNullParameter((JSONObject) r10, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        JSONObject r12 = new JSONObject();
        IHybridComponent r13 = this.a;
        if (r13 == null) goto L6;
        String r14 = r13.containerId();
        if (r14 == null) goto L6;
    L7:
        r12.put("containerID", r14);
        r12.put(MessageIndication.MESSAGE_TYPE_MSG, "SUCCESS");
        finishWithResult(r12);
        return;
    L6:
        r14 = "";
        goto L7
    }
}
