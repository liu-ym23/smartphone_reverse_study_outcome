package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "handleSharedKv")
public final class rc extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {
    public final String a;

    public rc() {
        this.a = "live_share_js_kv_methods";
    }

    public static JSONObject j(int r2) {
        JSONObject r0 = new JSONObject();
        r0.put("code", r2);
        return r0;
    }

    public final Object invoke(Object r6, CallContext r7) {
        JSONObject r8 = (JSONObject) r6;
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r7, "context");
        String r0 = r8.optString("key");
        if (r0 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L22;
        int r4 = r8.optInt("action");
        if (r4 != 1) goto L14;
        String r9 = r8.optString("value");
        r7.getContext().getSharedPreferences(this.a, 0).edit().putString(r0, r9).commit();
        return j(1);
    L14:
        if (r4 != 2) goto L16;
        JSONObject r11 = j(1);
        r11.put("value", r7.getContext().getSharedPreferences(this.a, 0).getString(r0, ""));
        return r11;
    L16:
        if (r4 != 3) goto L23;
        r7.getContext().getSharedPreferences(this.a, 0).edit().remove(r0).commit();
        return j(1);
    L23:
        return j(0);
    L22:
        return j(0);
    L5:
        if (r0.length() == 0) goto L8;
        r3 = false;
        goto L9
    }
}
