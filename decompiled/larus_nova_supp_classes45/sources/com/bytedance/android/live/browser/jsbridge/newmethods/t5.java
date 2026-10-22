package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "isLiveFloatWindowShow")
public final class t5 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {
    public final com.bytedance.android.live.browser.webview.fragment.l a;

    public t5(m16.b r2) {
        Intrinsics.checkNotNullParameter(r2, "contextProviderFactory");
        this.a = (com.bytedance.android.live.browser.webview.fragment.l) r2.c(com.bytedance.android.live.browser.webview.fragment.l.class);
    }

    public t5(com.bytedance.android.live.browser.webview.fragment.l r2) {
        Intrinsics.checkNotNullParameter(r2, "control");
        this.a = r2;
    }

    public final Object invoke(Object r2, CallContext r3) {
        Intrinsics.checkNotNullParameter((JSONObject) r2, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        int r4 = a6.a;
        JSONObject r5 = new JSONObject();
        boolean r0 = false;
        r5.put("code", 0);
        com.bytedance.android.live.browser.webview.fragment.l r6 = this.a;
        if (r6 == null) goto L5;
        r0 = r6.isShowLiveFloatWindow();
    L5:
        r5.put("value", r0);
        return r5;
    }
}
