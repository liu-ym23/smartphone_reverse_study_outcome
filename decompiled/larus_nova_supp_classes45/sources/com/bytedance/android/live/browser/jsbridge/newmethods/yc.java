package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "showLiveFloatWindow")
public final class yc extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {
    public final com.bytedance.android.live.browser.webview.fragment.l a;

    public yc(m16.b r2) {
        Intrinsics.checkNotNullParameter(r2, "contextProviderFactory");
        this.a = (com.bytedance.android.live.browser.webview.fragment.l) r2.c(com.bytedance.android.live.browser.webview.fragment.l.class);
    }

    public yc(com.bytedance.android.live.browser.webview.fragment.l r2) {
        Intrinsics.checkNotNullParameter(r2, "control");
        this.a = r2;
    }

    public final Object invoke(Object r2, CallContext r3) {
        JSONObject r4 = (JSONObject) r2;
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        com.bytedance.android.live.browser.webview.fragment.l r5 = this.a;
        if (r5 == null) goto L5;
        r5.showLiveFloatWindow(r4);
    L5:
        int r6 = a6.a;
        JSONObject r7 = new JSONObject();
        r7.put("code", 0);
        return r7;
    }
}
