package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "setFansStatus")
public final class dc extends com.bytedance.ies.web.jsbridge2.f<JSONObject, Object> {
    public final void onTerminate() {
    }

    public dc() {
    }

    public final void invoke(Object r1, CallContext r2) throws Exception {
        JSONObjectProtectorUtils.getInt((JSONObject) r1, "status");
        b30.d r3 = new b30.d();
        xs2.b.a().post(r3);
    }
}
