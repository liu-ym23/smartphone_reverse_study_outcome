package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "isTeenMode")
public final class u5 extends com.bytedance.ies.web.jsbridge2.g<Object, JSONObject> {
    public u5() {
    }

    public final Object invoke(Object r3, CallContext r4) throws Exception {
        JSONObject r5 = new JSONObject();
        Boolean r6 = Boolean.valueOf(jc1.k.f(IMiddleWareHostContext.class).isNeedProtectUnderage());
        ALogger.i("isTeenMode", "AnnieParamUtil is_teen_mode = " + r6);
        r5.put("is_teen_mode", r6);
        return r5;
    }
}
