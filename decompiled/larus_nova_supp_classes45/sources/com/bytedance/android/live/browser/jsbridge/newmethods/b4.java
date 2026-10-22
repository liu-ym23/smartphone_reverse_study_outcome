package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livesdkapi.hybridapi.ILiveHybridContainer;
import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b4 extends com.bytedance.ies.web.jsbridge2.f<JSONObject, Object> {
    public final ILiveHybridContainer a;

    public final void onTerminate() {
    }

    public b4(ILiveHybridContainer r1) {
        this.a = r1;
    }

    public final void invoke(Object r2, CallContext r3) {
        Intrinsics.checkNotNullParameter((JSONObject) r2, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        JSONObject r4 = new JSONObject();
        ILiveHybridContainer r5 = this.a;
        if (r5 == null) goto L6;
        String r6 = r5.getContainerId();
        if (r6 == null) goto L6;
    L7:
        r4.put("containerID", r6);
        finishWithResult(r4);
        return;
    L6:
        r6 = "";
        goto L7
    }
}
