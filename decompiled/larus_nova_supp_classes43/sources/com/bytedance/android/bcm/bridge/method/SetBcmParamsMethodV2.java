package com.bytedance.android.bcm.bridge.method;

import android.view.View;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.bcm.api.b;
import com.bytedance.android.btm.api.inner.ALogger;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(name = "setBcmPageParamsV2")
public final class SetBcmParamsMethodV2 extends XCoreBridgeMethod implements h {
    public final String a;
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access b;

    public SetBcmParamsMethodV2() {
        this.a = "setBcmPageParamsV2";
        this.b = com.bytedance.ies.xbridge.XBridgeMethod.Access.PROTECT;
    }

    public final com.bytedance.ies.xbridge.XBridgeMethod.Access getAccess() {
        return this.b;
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(final XReadableMap r10, com.bytedance.ies.xbridge.XBridgeMethod.Callback r11, XBridgePlatformType r12) {
        ALogger.c(ALogger.d, "FE_SetBcmParamsMethodV2", new AnonymousClass1(r10));
        c r13 = getContextProviderFactory();
        if (r13 == null) goto L5;
        View r14 = HybridContainerContextManager.c(r13);
    L7:
        if (b.a.setBcmParamsV2(PageFinder.via(r14), r10.toMap()) == false) goto L9;
        int r15 = j.a;
        j.b(this, r11, new LinkedHashMap());
        return;
    L9:
        j.a(this, r11, MessageIndication.STATUS_FAILED);
        return;
    L5:
        r14 = null;
        goto L7
    }
}
