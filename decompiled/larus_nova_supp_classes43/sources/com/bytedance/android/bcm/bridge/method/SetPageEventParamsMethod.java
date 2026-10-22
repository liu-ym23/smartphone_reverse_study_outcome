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
import com.bytedance.ies.xbridge.s;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import g66.c;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(name = "btm.setBTMPageShowEventParams")
public final class SetPageEventParamsMethod extends XCoreBridgeMethod implements h {
    public final String a;
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access b;

    public SetPageEventParamsMethod() {
        this.a = "btm.setBTMPageShowEventParams";
        this.b = com.bytedance.ies.xbridge.XBridgeMethod.Access.PROTECT;
    }

    public final com.bytedance.ies.xbridge.XBridgeMethod.Access getAccess() {
        return this.b;
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(final XReadableMap r10, com.bytedance.ies.xbridge.XBridgeMethod.Callback r11, XBridgePlatformType r12) {
        ALogger.c(ALogger.d, "FE_setBTMPageShowEventParams", new AnonymousClass1(r10));
        c r13 = getContextProviderFactory();
        if (r13 == null) goto L5;
        View r14 = HybridContainerContextManager.c(r13);
    L13:
        XReadableMap r15 = s.e(r10, "params");     // Catch: Throwable -> L11
        if (r15 == null) goto L9;
        b.a.setPageEventParams(PageFinder.via(r14), r15.toMap());     // Catch: Throwable -> L11
    L9:
        int r16 = j.a;     // Catch: Throwable -> L11
        j.b(this, r11, new LinkedHashMap());     // Catch: Throwable -> L11
        return;
    L11:
        j.a(this, r11, MessageIndication.STATUS_FAILED);
        return;
    L5:
        r14 = null;
        goto L13
    }
}
