package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "hideLiveFloatWindow")
public final class k5 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {
    public final com.bytedance.android.live.browser.webview.fragment.l a;

    public k5(m16.b r2) {
        Intrinsics.checkNotNullParameter(r2, "contextProviderFactory");
        this.a = (com.bytedance.android.live.browser.webview.fragment.l) r2.c(com.bytedance.android.live.browser.webview.fragment.l.class);
    }

    public k5(com.bytedance.android.live.browser.webview.fragment.l r2) {
        Intrinsics.checkNotNullParameter(r2, "control");
        this.a = r2;
    }

    public final Object invoke(Object r2, CallContext r3) {
        Intrinsics.checkNotNullParameter((JSONObject) r2, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        com.bytedance.android.live.browser.webview.fragment.l r4 = this.a;
        if (r4 == null) goto L5;
        r4.hideLiveFloatWindow();
    L5:
        int r5 = a6.a;
        JSONObject r6 = new JSONObject();
        r6.put("code", 0);
        return r6;
    }
}
