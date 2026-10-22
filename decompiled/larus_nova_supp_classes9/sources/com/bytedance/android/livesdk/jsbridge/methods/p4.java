package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.livesdk.chatroom.event.TopRightBannerAdjustEvent;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "setTopRightBannerWidth")
public final class p4 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {
    public p4() {
    }

    public final Object invoke(Object r3, CallContext r4) {
        JSONObject r5 = (JSONObject) r3;
        Intrinsics.checkNotNullParameter(r5, "p0");
        Intrinsics.checkNotNullParameter(r4, "p1");
        Integer r6 = Integer.valueOf(r5.optInt(sz1.a.KEY_WIDTH));
        if (r6.intValue() < 0) goto L5;
        boolean r7 = true;
    L7:
        if (r7 == true) goto L10;
        r6 = null;
    L10:
        if (r6 == null) goto L12;
        xs2.b.a().post(new TopRightBannerAdjustEvent(r6.intValue()));
    L12:
        return null;
    L5:
        r7 = false;
        goto L7
    }
}
