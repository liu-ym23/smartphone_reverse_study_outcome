package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "sendLogV1")
public final class ub extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {
    public ub() {
    }

    public final Object invoke(Object r6, CallContext r7) throws Exception {
        JSONObject r8 = (JSONObject) r6;
        String r9 = r8.optString("eventName");
        String r0 = r8.optString("labelName");
        JSONObject r11 = r8.optJSONObject("params");
        HashMap r1 = new HashMap();
        Iterator<String> r2 = r11.keys();
    L4:
        if (r2.hasNext() == false) goto L6;
        String r3 = r2.next();
        String r4 = r11.optString(r3);
        r2.remove();
        r1.put(r3, r4);
        goto L4
    L6:
        jc1.k.f(ILiveDouPlusService.class).logEvent(true, r9, r0, r1);
        return null;
    }
}
