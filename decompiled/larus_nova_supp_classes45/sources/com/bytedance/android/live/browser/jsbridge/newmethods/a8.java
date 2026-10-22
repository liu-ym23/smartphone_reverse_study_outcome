package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "sendMonitor")
public final class a8 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {
    public a8() {
    }

    public final Object invoke(Object r8, CallContext r9) throws Exception {
        JSONObject r11 = (JSONObject) r8;
        String r12 = r11.optString("type");
        JSONObject r13 = JSONObjectProtectorUtils.getJSONObject(r11, "args");
        r12.getClass();
        switch(r12.hashCode()) {
            case -1853762817: goto L18;
            case -858688242: goto L14;
            case 1708461408: goto L10;
            case 1821543916: goto L6;
            default: goto L21;
        };
    L21:
        byte r14 = -1;
    L23:
        if (r14 == 0) goto L31;
        if (r14 == 1) goto L30;
        if (r14 == 2) goto L29;
        if (r14 != 3) goto L37;
        LiveSlardarMonitor.monitorStatus(r13.optString("service"), r13.optInt("status"), r13.optJSONObject("ext_json"));
        return null;
    L37:
        return null;
    L29:
        LiveSlardarMonitor.monitorEvent(r13.optString("service"), r13.optJSONObject("category"), r13.optJSONObject("metric"), r13.optJSONObject("extra"));
        return null;
    L30:
        LiveSlardarMonitor.monitorDuration(r13.optString("service"), r13.optLong("duration"), r13.optJSONObject("ext_json"));
        return null;
    L31:
        LiveSlardarMonitor.monitorStatusAndDuration(r13.optString("service"), r13.optInt("status"), r13.optLong("duration"), r13.optJSONObject("ext_json"));
        return null;
    L6:
        if (r12.equals("monitorStatus") == false) goto L21;
        r14 = 3;
        goto L23
    L10:
        if (r12.equals("monitorEvent") == false) goto L21;
        r14 = 2;
        goto L23
    L14:
        if (r12.equals("monitorDuration") == false) goto L21;
        r14 = 1;
        goto L23
    L18:
        if (r12.equals("monitorStatusAndDuration") == false) goto L21;
        r14 = 0;
        goto L23
    }
}
