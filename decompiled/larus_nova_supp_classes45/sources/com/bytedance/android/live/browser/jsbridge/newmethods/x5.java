package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.AddAnchorResultModel;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "addAnchor")
public final class x5 extends w20.d<JsonObject, AddAnchorResultModel> {

    public static final class a {
    }

    static {
    }

    public final void onTerminate() {
    }

    public x5() {
    }

    public final void invoke(Object r2, CallContext r3) {
        JsonObject r4 = (JsonObject) r2;
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        IHostBusiness r5 = jc1.k.f(IHostBusiness.class);
        if (r5 == null) goto L5;
        r5.addAnchorToPublishVideo(r4);
    L5:
        finishWithSuccess();
    }
}
