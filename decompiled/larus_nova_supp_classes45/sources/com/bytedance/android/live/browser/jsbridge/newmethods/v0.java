package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.BrowserServiceImpl;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import javax.inject.Inject;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "webcastBroadcast")
public final class v0 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {

    @Inject
    public com.bytedance.android.live.browser.v a;

    public v0() {
        BrowserServiceImpl.Companion.getClass();
        this.a = (com.bytedance.android.live.browser.v) ((s20.b) BrowserServiceImpl.access$getDiComponent$cp()).a().a.e.get();
    }

    public final Object invoke(Object r2, CallContext r3) throws Exception {
        JSONObject r4 = (JSONObject) r2;
        this.a.sendEventToAllJsBridges("H5_webcastNotification", r4);
        com.bytedance.android.livesdk.event.o r5 = new com.bytedance.android.livesdk.event.o(r4);
        xs2.b.a().post(r5);
        return null;
    }
}
