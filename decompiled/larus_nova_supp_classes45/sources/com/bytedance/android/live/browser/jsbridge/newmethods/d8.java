package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.text.TextUtils;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "statusNotification")
public final class d8 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {
    public d8() {
    }

    public final Object invoke(Object r3, CallContext r4) throws Exception {
        JSONObject r5 = (JSONObject) r3;
        String r6 = r5.optString("type");
        JSONObject r7 = r5.optJSONObject("args");
        r6.getClass();
        if (r6.equals("recharge") == true) goto L6;
        return null;
    L6:
        if (TextUtils.equals(r7.optString("status"), GamePromoteDataContext.GAME_TYPE_MOBILE) == false) goto L10;
        xs2.b.a().post(new com.bytedance.android.livesdk.event.v(1, 0));
        return null;
    L10:
        return null;
    }
}
