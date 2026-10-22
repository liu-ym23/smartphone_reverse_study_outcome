package com.bytedance.android.ec.core.vmsdk;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.xbridge.ReadableMapImpl;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class r extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {
    public final /* synthetic */ com.bytedance.ies.xbridge.n a;
    public final /* synthetic */ String b;

    public final void onTerminate() {
        this.a.a().release();
    }

    public r(com.bytedance.ies.xbridge.n r1, String r10) {
        this.a = r1;
        this.b = r10;
    }

    public final void invoke(Object r10, CallContext r11) throws Exception {
        JSONObject r12 = (JSONObject) r10;
        if ((this.a.a() instanceof XCoreBridgeMethod) == false) goto L7;
        g66.c r0 = this.a.a().getContextProviderFactory();
        if (r0 == null) goto L7;
        r0.f(CallContext.class, r11);
    L7:
        r12.put("func", this.b);
        this.a.a().handle(new ReadableMapImpl(r12), new q(this), XBridgePlatformType.LYNX);
    }
}
