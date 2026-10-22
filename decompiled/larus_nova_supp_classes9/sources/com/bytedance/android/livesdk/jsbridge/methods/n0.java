package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "destroyShortTouch")
public final class n0 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {
    public n0() {
    }

    public final Object invoke(Object r4, CallContext r5) {
        JSONObject r6 = (JSONObject) r4;
        Intrinsics.checkNotNullParameter(r6, "jsonObject");
        Intrinsics.checkNotNullParameter(r5, "callContext");
        xs2.b.a().post(new zg1.v(0, r6.optInt("type"), null));
        return null;
    }
}
