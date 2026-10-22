package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.livesdkapi.service.IHostCommerceServiceLive;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "switchFlashConfig")
public final class n4 extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {
    public final void onTerminate() {
    }

    public n4() {
    }

    public final void invoke(Object r2, CallContext r3) {
        JSONObject r4 = (JSONObject) r2;
        Intrinsics.checkNotNullParameter(r4, "p0");
        Intrinsics.checkNotNullParameter(r3, "p1");
        jc1.k.n(IHostCommerceServiceLive.class).switchFlashConfig(r4.optBoolean("is_open"));
    }
}
