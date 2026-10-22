package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "reportAppLog")
public final class ya extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {
    public ya() {
    }

    public final Object invoke(Object r2, CallContext r3) throws Exception {
        tb r0 = new tb();
        return r0.j((JSONObject) r2, r3);
    }
}
