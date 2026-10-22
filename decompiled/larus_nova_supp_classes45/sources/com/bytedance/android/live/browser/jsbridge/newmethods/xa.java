package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.text.TextUtils;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.common.lib.MobClickCombiner;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "reportADLog")
public final class xa extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {
    public xa() {
    }

    public final Object invoke(Object r11, CallContext r12) throws Exception {
        JSONObject r13 = (JSONObject) r11;
        String r2 = r13.optString("tag");
        String r3 = r13.optString("label");
        String r4 = r13.optString("refer");
        String r5 = r13.optString("logExtra");
        String r6 = r13.optString("groupID");
        String r7 = r13.optString("creativeID");
        JSONObject r14 = r13.optJSONObject("extraParams");
        if (r14 != null) goto L5;
        r14 = new JSONObject();
    L5:
        JSONObject r8 = r14;
        r8.put("refer", r4);
        r8.put("log_extra", r5);
        r8.put("is_ad_event", GamePromoteDataContext.GAME_TYPE_MOBILE);
        HashMap r15 = new HashMap();
        Iterator<String> r9 = r8.keys();
    L7:
        if (r9.hasNext() == false) goto L9;
        String r16 = r9.next();
        r15.put(r16, r8.optString(r16));
        goto L7
    L9:
        r15.put("category", "umeng");
        r15.put("tag", r2);
        r15.put("value", r7);
        r15.put("ext_value", r6);
        if (TextUtils.equals("click", r3) == false) goto L16;
        com.bytedance.android.livesdk.log.j0.l().sendLog("realtime_click", r15, new Object[0]);
        r8.put("has_v3", GamePromoteDataContext.GAME_TYPE_MOBILE);
        MobClickCombiner.onEvent(r12.getContext(), r2, r3, CastLongProtector.parseLong(r7), CastLongProtector.parseLong(r6), r8);     // Catch: Exception -> L14
        return null;
    L14:
        e = move-exception;
        e.printStackTrace();
        return null;
    L16:
        r15.put("ad_event_version", "3");
        com.bytedance.android.livesdk.log.j0.l().sendLog(r3, r15, new Object[0]);
        return null;
    }
}
