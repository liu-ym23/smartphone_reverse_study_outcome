package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h3 implements IMiddlewareHostBusiness.onLightLivePublishCallback {
    public h3() {
    }

    public final void response(int r3, String r4, String r5) {
        JSONObject r0 = new JSONObject();
        r0.put("code", r3);     // Catch: JSONException -> L5
        r0.put("type", r4);     // Catch: JSONException -> L5
        r0.put("status", r5);     // Catch: JSONException -> L5
    L7:
        jc1.k.f(IBrowserService.class).sendEventToAllJsBridges("H5_publishVideoStatusChange", r0);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }
}
