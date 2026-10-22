package com.bytedance.android.annie.bridge.method;

import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.annie.Annie;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "sendLogV3")
public final class b2 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {
    public b2() {
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object r1, CallContext r10) throws Exception {
        return j((JSONObject) r1, r10);
    }

    public final Object j(JSONObject r10, CallContext r11) throws Exception {
        String r0 = r10.optString("eventName");
        Integer r1 = Integer.valueOf(r10.optInt("no_prefix"));
        JSONObject r12 = r10.optJSONObject("params");
        HashMap r13 = new HashMap();
        if (r12 == null) goto L9;
        Iterator<String> r14 = r12.keys();
    L6:
        if (r14.hasNext() == false) goto L9;
        String r15 = r14.next();
        String r16 = r12.optString(r15);
        r14.remove();
        r13.put(r15, r16);
    L9:
        if (r11.f == false) goto L11;
        r13.put("is_open_anniex", "1");
    L13:
        if (r1.intValue() != 1) goto L15;
        ((x9.b) Annie.getService(x9.b.class, r11.a())).t(r0, r13);
    L16:
        JSONObject r17 = new JSONObject();
        r17.put("code", 1);
        r17.put(MessageIndication.MESSAGE_TYPE_MSG, "SUCCESS");
        return r17;
    L15:
        ((x9.b) Annie.getService(x9.b.class, r11.a())).logV3(r0, r13);
        goto L16
    L11:
        r13.put("is_open_anniex", "0");
        goto L13
    }
}
