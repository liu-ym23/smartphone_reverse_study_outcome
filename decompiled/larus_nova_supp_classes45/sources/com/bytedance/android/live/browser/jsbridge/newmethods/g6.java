package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "sendPokemon")
public final class g6 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {
    public g6() {
    }

    public final Object invoke(Object r3, CallContext r4) throws Exception {
        xs2.b r5 = xs2.b.a();
        JSONObjectProtectorUtils.getLong((JSONObject) r3, "gift_id");
        r5.post(new b30.x());
        return null;
    }
}
