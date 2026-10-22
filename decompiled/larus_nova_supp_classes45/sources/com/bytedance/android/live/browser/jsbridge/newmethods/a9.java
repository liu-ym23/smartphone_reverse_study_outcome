package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openPKPanel")
public final class a9 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {
    public a9() {
    }

    public final Object invoke(Object r2, CallContext r3) throws Exception {
        b30.o r4 = new b30.o(((JSONObject) r2).optString("source", "activity"));
        xs2.b.a().post(r4);
        return null;
    }
}
