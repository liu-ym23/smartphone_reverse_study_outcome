package com.bytedance.android.live.browser.jsbridge;

import com.bytedance.common.utility.Logger;
import com.bytedance.ies.xbridge.XBridgeMethod;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class v implements XBridgeMethod.Callback {
    public final /* synthetic */ w a;

    public v(w r1) {
        this.a = r1;
    }

    public final void invoke(Map<String, Object> r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        Object r0 = r5.get("data");
        if ((r0 instanceof Map) == false) goto L5;
        w r1 = this.a;
        int r3 = i0.a;
        JSONObject r4 = new JSONObject((Map) r0);
        i0.a(r4, r5.get("code"));
        r1.finishWithResult(r4);
        Logger.d("XbridgeManager", "xbridge end,fun name:" + this.a.a.a);
        return;
    L5:
        w r2 = this.a;
        int r6 = i0.a;
        JSONObject r7 = new JSONObject(r5);
        i0.a(r7, null);
        r2.finishWithResult(r7);
        Logger.d("XbridgeManager", "xbridge data is error,fun name:" + this.a.a.a);
    }
}
