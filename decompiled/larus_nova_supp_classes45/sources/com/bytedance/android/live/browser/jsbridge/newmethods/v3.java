package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.webview.config.LiveHybridSettingKeys;
import com.bytedance.android.livehostapi.platform.IHostWebView;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "getXTtToken")
public final class v3 extends com.bytedance.ies.web.jsbridge2.g<Object, JSONObject> {
    public v3() {
    }

    public final Object invoke(Object r4, CallContext r5) throws Exception {
        JSONObject r6 = new JSONObject();
        JSONObject r0 = new JSONObject();
        if (LiveHybridSettingKeys.ARGUS_DELETE_GET_XTT_TOKEN_JSB.getValue().booleanValue() == false) goto L5;
        r5.getContext();
        LocalTestManager.a(new Class[]{wy.a.class});
    L13:
        return r6;
    L5:
        Map r7 = jc1.k.f(IHostWebView.class).getHeaderMap("https://hotsoon.snssdk.com");
        if (r7 == null) goto L13;
        Iterator r8 = r7.entrySet().iterator();
    L10:
        if (r8.hasNext() == false) goto L12;
        Map.Entry r1 = (Map.Entry) r8.next();
        r0.put((String) r1.getKey(), r1.getValue());
        goto L10
    L12:
        r6.put("token", r0);
        goto L13
    }
}
