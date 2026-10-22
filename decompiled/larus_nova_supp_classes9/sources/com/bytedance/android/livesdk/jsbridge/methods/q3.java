package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.browser.jsbridge.event.RoomTopRightBannerEvent;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "roomBannerAnimation")
public final class q3 extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {
    public final void onTerminate() {
    }

    public q3() {
    }

    public final void invoke(Object r2, CallContext r3) {
        JSONObject r4 = (JSONObject) r2;
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        Logger.i("RoomBannerAnimationMethod", r4.toString());
        RoomTopRightBannerEvent r5 = (RoomTopRightBannerEvent) GsonProtectorUtils.fromJson(GsonHelper.getDefault(), r4.toString(), RoomTopRightBannerEvent.class);
        if (r5 == null) goto L6;
        xs2.b.a().post(r5);
        return;
    }
}
