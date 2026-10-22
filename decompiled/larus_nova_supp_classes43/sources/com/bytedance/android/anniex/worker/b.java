package com.bytedance.android.anniex.worker;

import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XReadableMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements XBridgeMethod.b {
    public final /* synthetic */ JSWorkerBDXBridge a;

    public b(JSWorkerBDXBridge r1) {
        this.a = r1;
    }

    public final void sendJsEvent(String r10, XReadableMap r11) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        JSWorkerBDXBridge r0 = this.a;
        if (r11 == null) goto L5;
        Map<String, ? extends Object> r12 = r11.toMap();
    L6:
        r0.a(r10, r12);
        return;
    L5:
        r12 = null;
        goto L6
    }
}
