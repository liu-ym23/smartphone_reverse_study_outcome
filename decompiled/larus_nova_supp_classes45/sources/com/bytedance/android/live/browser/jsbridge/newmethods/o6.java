package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "reportStarEvent")
public final class o6 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {

    public static final class a {
    }

    static {
    }

    public o6() {
    }

    public final Object invoke(Object r3, CallContext r4) {
        JSONObject r5 = (JSONObject) r3;
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        String r6 = r5.optString("event", "");     // Catch: Throwable -> L5
        JSONObject r7 = r5.optJSONObject("args");     // Catch: Throwable -> L5
        Map r8 = (Map) GsonHelper.getDefault().fromJson(r7.toString(), new p6().getType());     // Catch: Throwable -> L5
        com.bytedance.android.livesdk.log.u.l().sendLog(r6, r8, new Object[0]);     // Catch: Throwable -> L5
    L8:
        return new JSONObject();
    L5:
        th = move-exception;
        ALogger.d("LiveLoggerMethod", String.valueOf(th.getMessage()));
        goto L8
    }
}
