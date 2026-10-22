package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "webcastSdk.pull_down_height")
public final class ce extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JsonObject> {
    public ce() {
    }

    public final Object invoke(Object r2, CallContext r3) {
        JSONObject r4 = (JSONObject) r2;
        Intrinsics.checkNotNullParameter(r4, "param");
        Intrinsics.checkNotNullParameter(r3, "callContext");
        JSONObject r5 = r4.optJSONObject("args");
        int r6 = 0;
        if (r5 == null) goto L5;
        r6 = r5.optInt("pull_down_height", 0);
    L5:
        xs2.b.a().post(new b30.a0(r6));
        return null;
    }
}
