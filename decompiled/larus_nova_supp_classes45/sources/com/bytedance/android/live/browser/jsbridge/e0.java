package com.bytedance.android.live.browser.jsbridge;

import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XReadableMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e0 implements XBridgeMethod.b {
    public final /* synthetic */ IJsBridgeManager a;

    public e0(IJsBridgeManager r1) {
        this.a = r1;
    }

    public final void sendJsEvent(String r2, XReadableMap r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        if (r3 == null) goto L5;
        JSONObject r4 = com.bytedance.ies.xbridge.utils.j.d(r3);
    L6:
        this.a.getJsBridge2().f(r2, r4);
        return;
    L5:
        r4 = new JSONObject();
        goto L6
    }
}
