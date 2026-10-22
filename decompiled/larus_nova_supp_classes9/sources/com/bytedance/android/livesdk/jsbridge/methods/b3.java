package com.bytedance.android.livesdk.jsbridge.methods;

import android.content.Context;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdkapi.service.IHostCommerceServiceLive;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "openProductList")
public final class b3 extends com.bytedance.ies.web.jsbridge2.f<JSONObject, Object> {
    public final void onTerminate() {
    }

    public b3() {
    }

    public final void invoke(Object r4, CallContext r5) {
        Intrinsics.checkNotNullParameter((JSONObject) r4, "params");
        Intrinsics.checkNotNullParameter(r5, "context");
        IHostCommerceServiceLive r6 = TTLiveSDKContext.getHostService().c();
        if (r6 == null) goto L6;
        Context r7 = r5.getContext();
        JSONObject r0 = new JSONObject();
        r0.put("entry_name", "from_webview");
        Unit r1 = Unit.INSTANCE;
        r6.showLivePromotionListFragment(r7, r0);
        return;
    }
}
