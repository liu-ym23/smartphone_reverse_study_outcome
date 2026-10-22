package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "open_webview_action")
public final class o9 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {
    public o9() {
    }

    public final Object invoke(Object r1, CallContext r2) throws Exception {
        JSONObject r3 = (JSONObject) r1;
        r3.optString("type");
        r3.optString(LiveSlardarConstants.EXTRA_KEY_URL);
        r3.optInt("level");
        xs2.b.a().post(new zg1.f2());
        return null;
    }
}
