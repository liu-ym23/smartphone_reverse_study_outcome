package com.bytedance.android.live.browser.jsbridge;

import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XReadableMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class y implements XBridgeMethod.b {
    public final /* synthetic */ y6.c a;

    public y(y6.c r1) {
        this.a = r1;
    }

    public final void sendJsEvent(String r2, XReadableMap r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        if (r3 == null) goto L5;
        JSONObject r4 = com.bytedance.ies.xbridge.utils.j.d(r3);
    L6:
        this.a.sendJSEvent(r2, r4);
        return;
    L5:
        r4 = new JSONObject();
        goto L6
    }
}
