package com.bytedance.android.bcm.bridge.method;

import android.view.View;
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
import java.util.Map;
import lc.d;
import lc.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(name = "btm.setScopedBcmPageParams")
public final class SetScopedBcmPageParamsMethod extends XCoreBridgeMethod implements h {
    public final String a;
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access b;

    public SetScopedBcmPageParamsMethod() {
        this.a = "btm.setScopedBcmPageParams";
        this.b = com.bytedance.ies.xbridge.XBridgeMethod.Access.PROTECT;
    }

    public final com.bytedance.ies.xbridge.XBridgeMethod.Access getAccess() {
        return this.b;
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(final XReadableMap r10, com.bytedance.ies.xbridge.XBridgeMethod.Callback r11, XBridgePlatformType r12) {
        ALogger.c(ALogger.d, "FE_setScopedBcmPageParams", new AnonymousClass1(r10));
        c r13 = getContextProviderFactory();
        Object r0 = null;
        if (r13 == null) goto L5;
        View r14 = HybridContainerContextManager.c(r13);
    L6:
        Map r15 = r10.toMap();
        Object r1 = r15.get("scope");
        Object r16 = r15.get("content");
        if ((r16 instanceof Map) == false) goto L10;
        r0 = r16;
    L10:
        Map<String, ? extends Object> r17 = (Map) r0;
        if (r1 != null) goto L13;
    L31:
        j.a(this, r11, "scope must not be empty");
        return;
    L13:
        if ((r1 instanceof String) == false) goto L31;
        if (((CharSequence) r1).length() != 0) goto L17;
        boolean r18 = true;
    L18:
        if (r18 == true) goto L31;
        if (r17 != null) goto L22;
    L29:
        j.a(this, r11, "scoped bcm page params content not be empty");
        return;
    L22:
        if (r17.isEmpty() == true) goto L29;
        d r19 = e.a;
        if (e.a.getScope((String) r1).c(PageFinder.via(r14), r17) == false) goto L27;
        int r20 = j.a;
        j.b(this, r11, new LinkedHashMap());
        return;
    L27:
        j.a(this, r11, "failed to set scoped bcm page params");
        return;
    L17:
        r18 = false;
        goto L18
    L5:
        r14 = null;
        goto L6
    }
}
