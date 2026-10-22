package com.bytedance.android.live.browser.jsbridge;

import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class w extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {
    public final /* synthetic */ x a;

    public final void onTerminate() {
        ((com.bytedance.ies.xbridge.n) this.a.b.getValue()).a().release();
    }

    public w(x r1) {
        this.a = r1;
    }

    public final void invoke(Object r4, CallContext r5) {
        JSONObject r6 = (JSONObject) r4;
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r5, "context");
        Logger.d("XbridgeManager", "xbridge start,fun name:" + this.a.a);
        if ((((com.bytedance.ies.xbridge.n) this.a.b.getValue()).a() instanceof XCoreBridgeMethod) == false) goto L11;
        XCoreBridgeMethod r0 = ((com.bytedance.ies.xbridge.n) this.a.b.getValue()).a();
        if (r0 == null) goto L10;
        g66.c r1 = r0.getContextProviderFactory();
        if (r1 == null) goto L11;
        r1.f(CallContext.class, r5);
        goto L11
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod");
    L11:
        r6.put("func", this.a.a);
        XBridgeMethod r7 = ((com.bytedance.ies.xbridge.n) this.a.b.getValue()).a();
        m30.g r2 = new m30.g(r6);
        v r8 = new v(this);
        IHybridComponent r3 = this.a.c.c();
        if (r3 == null) goto L14;
        IHybridComponent.HybridType r9 = r3.hybridType();
    L16:
        if (r9 != IHybridComponent.HybridType.LYNX) goto L18;
        XBridgePlatformType r11 = XBridgePlatformType.LYNX;
    L19:
        r7.handle(r2, r8, r11);
        return;
    L18:
        r11 = XBridgePlatformType.WEB;
        goto L19
    L14:
        r9 = null;
        goto L16
    }
}
