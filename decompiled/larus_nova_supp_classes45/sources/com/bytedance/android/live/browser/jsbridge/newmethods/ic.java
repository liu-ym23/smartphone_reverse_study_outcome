package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "setRoomInfoBannerSize")
public final class ic extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {
    public ic() {
    }

    public final Object invoke(Object r3, CallContext r4) {
        JSONObject r5 = (JSONObject) r3;
        Intrinsics.checkNotNullParameter(r5, "size");
        Intrinsics.checkNotNullParameter(r4, "p1");
        int r6 = r5.optInt("width");
        int r7 = r5.optInt("height");
        xs2.b.a().post(new com.bytedance.android.livesdk.event.f0(r6, r7));
        return Unit.INSTANCE;
    }
}
