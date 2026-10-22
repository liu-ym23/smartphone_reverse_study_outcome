package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.browser.jsbridge.event.RoomBannerBarEvent;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "activityNameBar")
public final class r3 extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {
    public final void onTerminate() {
    }

    public r3() {
    }

    public final void invoke(Object r2, CallContext r3) {
        JSONObject r4 = (JSONObject) r2;
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        Logger.i("RoomBannerBarMethod", r4.toString());
        RoomBannerBarEvent r5 = (RoomBannerBarEvent) GsonProtectorUtils.fromJson(GsonHelper.getDefault(), r4.toString(), RoomBannerBarEvent.class);
        if (r5 == null) goto L6;
        xs2.b.a().post(r5);
        return;
    }
}
