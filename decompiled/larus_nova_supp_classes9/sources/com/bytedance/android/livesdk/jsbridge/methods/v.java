package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.livehostapi.business.IHostAliYunVerifyProxy;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "getAliCloudMetaInfo")
public final class v extends com.bytedance.ies.web.jsbridge2.f<Object, JSONObject> {
    public final void onTerminate() {
    }

    public v() {
    }

    public final void invoke(Object r4, CallContext r5) throws Exception {
        if (com.bytedance.android.live.core.verify.utils.a.j() == false) goto L6;
        finishWithResult(com.bytedance.android.live.browser.jsbridge.s.a(-1000, "aliyun service proxy is unavaliable"));
        return;
    L6:
        IHostAliYunVerifyProxy r6 = jc1.k.f(IHostAliYunVerifyProxy.class);
        r6.install(r5.getContext());
        String r0 = r6.getMetaInfos(r5.getContext());
        JSONObject r7 = r6.getSession(r5.getContext());
        JSONObject r8 = new JSONObject();
        r8.put("status_code", 0);
        r8.put("meta_info", r0);
        r8.put("device_token", r7);
        finishWithResult(r8);
    }
}
