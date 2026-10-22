package com.larus.caijing_pay.impl.config;

import com.android.ttcjpaysdk.base.service.ICJExternalEventCenterCallback;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XReadableMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class CJExternalEventServiceImpl$b implements XBridgeMethod.b {
    public final /* synthetic */ ICJExternalEventCenterCallback a;

    public CJExternalEventServiceImpl$b(ICJExternalEventCenterCallback r1) {
        this.a = r1;
    }

    public final void sendJsEvent(String r2, XReadableMap r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        ICJExternalEventCenterCallback r0 = this.a;
        if (r3 == null) goto L5;
        Map r4 = r3.toMap();
    L6:
        r0.onReceiveEvent(r2, r4);
        return;
    L5:
        r4 = null;
        goto L6
    }
}
