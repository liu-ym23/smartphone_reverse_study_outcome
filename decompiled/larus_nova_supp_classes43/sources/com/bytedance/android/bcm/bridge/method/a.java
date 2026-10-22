package com.bytedance.android.bcm.bridge.method;

import android.view.View;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.btm.bridge.HybridContainerContextManager;
import com.bytedance.android.btm.bridge.method.j;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import g66.c;
import java.util.LinkedHashMap;
import java.util.Map;
import jc.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(name = "setBcmParams")
public final class a extends XCoreBridgeMethod implements h {
    public final String a;
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access b;

    public a() {
        this.a = "setBcmParams";
        this.b = com.bytedance.ies.xbridge.XBridgeMethod.Access.PROTECT;
    }

    public final com.bytedance.ies.xbridge.XBridgeMethod.Access getAccess() {
        return this.b;
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(XReadableMap r10, com.bytedance.ies.xbridge.XBridgeMethod.Callback r11, XBridgePlatformType r12) {
        c r13 = getContextProviderFactory();
        if (r13 == null) goto L5;
        View r14 = HybridContainerContextManager.c(r13);
    L6:
        b r0 = com.bytedance.android.bcm.api.b.a;
        PageFinder r15 = PageFinder.via(r14);
        Map r16 = r10.toMap();
        if (com.bytedance.android.bcm.api.b.a.setBcmParams(r15, r16) == false) goto L9;
        int r17 = j.a;
        j.b(this, r11, new LinkedHashMap());
        return;
    L9:
        j.a(this, r11, MessageIndication.STATUS_FAILED);
        return;
    L5:
        r14 = null;
        goto L6
    }
}
