package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.livesdkapi.service.IHostCommerceServiceLive;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "directFlashPurchaseCategories")
public final class e0 extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {
    public final void onTerminate() {
    }

    public e0() {
    }

    public final void invoke(Object r5, CallContext r6) {
        JSONObject r7 = (JSONObject) r5;
        Intrinsics.checkNotNullParameter(r7, "p0");
        Intrinsics.checkNotNullParameter(r6, "p1");
        IHostCommerceServiceLive r8 = jc1.k.n(IHostCommerceServiceLive.class);
        JSONObject r1 = r7.optJSONObject("data");
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.optString("categoriesName");
    L6:
        JSONObject r9 = r7.optJSONObject("data");
        if (r9 == null) goto L9;
        r2 = r9.optString("categoriesIds");
    L9:
        r8.chooseCategory(r3, r2);
        return;
    L5:
        r3 = null;
        goto L6
    }
}
