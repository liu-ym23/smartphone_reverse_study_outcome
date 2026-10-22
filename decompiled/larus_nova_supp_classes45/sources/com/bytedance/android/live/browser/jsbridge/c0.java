package com.bytedance.android.live.browser.jsbridge;

import com.bytedance.common.utility.Logger;
import com.bytedance.ies.xbridge.XBridgeMethod;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c0 implements XBridgeMethod.Callback {
    public final /* synthetic */ d0.a a;

    public c0(d0.a r1) {
        this.a = r1;
    }

    public final void invoke(Map<String, Object> r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        Object r0 = r4.get("data");
        if ((r0 instanceof Map) == false) goto L5;
        this.a.finishWithResult(new JSONObject((Map) r0));
        Logger.d("XbridgeManager", "xbridge end,fun name:" + this.a.a.a);
        return;
    L5:
        this.a.finishWithResult(new JSONObject(r4));
        Logger.d("XbridgeManager", "xbridge data is error,fun name:" + this.a.a.a);
    }
}
