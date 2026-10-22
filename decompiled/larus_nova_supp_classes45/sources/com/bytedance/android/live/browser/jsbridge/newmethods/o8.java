package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.livehostapi.business.IHostVerify;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openCashVerify")
public final class o8 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {
    public o8() {
    }

    public final Object invoke(Object r7, CallContext r8) throws Exception {
        JSONObject r9 = (JSONObject) r7;
        Activity r1 = ContextUtil.contextToActivity(r8.getContext());
        jc1.k.f(IHostVerify.class).verifyForStartLive(r1, 0, "4", null, null);
        return null;
    }
}
