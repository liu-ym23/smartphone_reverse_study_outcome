package com.bytedance.android.annie.bridge.method;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "reportAppLog")
public final class c2 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {
    public c2() {
    }

    public final Object invoke(Object r10, CallContext r11) throws Exception {
        b2 r0 = new b2();
        return r0.j((JSONObject) r10, r11);
    }
}
