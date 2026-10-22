package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "saveLocalData")
public final class mb extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {
    public final com.bytedance.android.tools.superkv.e a;

    public mb() {
        this.a = com.bytedance.android.live.core.utils.v1.a("webcast_jsb_local_data");
    }

    public final Object invoke(Object r2, CallContext r3) throws Exception {
        JSONObject r4 = (JSONObject) r2;
        String r5 = r4.optString("key");
        String r6 = r4.optString("data");
        com.bytedance.android.tools.superkv.e r0 = this.a;
        if (r0 == null) goto L7;
        r0.putString(r5, r6);
        return null;
    L7:
        return null;
    }
}
