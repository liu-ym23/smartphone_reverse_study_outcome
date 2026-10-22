package com.bytedance.android.bcm.bridge.method;

import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.inner.g$a;
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
import lc.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(name = "btm.getScopedBcmChain")
public final class GetScopedBcmChainMethod extends XCoreBridgeMethod implements h {
    public final String a;
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access b;

    public GetScopedBcmChainMethod() {
        this.a = "btm.getScopedBcmChain";
        this.b = com.bytedance.ies.xbridge.XBridgeMethod.Access.PROTECT;
    }

    public final com.bytedance.ies.xbridge.XBridgeMethod.Access getAccess() {
        return this.b;
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(final XReadableMap r10, com.bytedance.ies.xbridge.XBridgeMethod.Callback r11, XBridgePlatformType r12) {
        ALogger.c(ALogger.d, "FE_getScopedBcmChain", new AnonymousClass1(r10));
        int r13 = r10.getInt("chain_length");
        String r14 = r10.getString("scope");
        if (r14.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        j.a(this, r11, "scope is empty");
        return;
    L9:
        c r1 = getContextProviderFactory();
        JSONObject r15 = null;
        if (r1 == null) goto L12;
        View r16 = HybridContainerContextManager.c(r1);
    L13:
        if (r16 != null) goto L15;
        g$a.a(BtmSDK.INSTANCE.getService().getMonitor(), 2025, null, null, new AnonymousClass4(this), 30);
    L18:
        if (r15 != null) goto L20;
        j.a(this, r11, "chain is null");
        return;
    L20:
        int r17 = j.a;
        LinkedHashMap r18 = new LinkedHashMap();
        r18.put("content", r15);
        j.b(this, r11, r18);
        return;
    L15:
        kc.a r19 = e.a.getScope(r14).a(PageFinder.via(r16), r13);
        if (r19 == null) goto L18;
        r15 = r19.a();
        goto L18
    L12:
        r16 = null;
        goto L13
    L5:
        r0 = false;
        goto L6
    }
}
