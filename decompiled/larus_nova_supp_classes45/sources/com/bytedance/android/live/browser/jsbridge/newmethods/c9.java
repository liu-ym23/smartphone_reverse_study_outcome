package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.GetStarInfoResultModel;
import com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "getStarInfo")
public final class c9 extends w20.t1<JsonObject, GetStarInfoResultModel> {
    public c9() {
    }

    public final void invoke(Object r3, CallContext r4) {
        Intrinsics.checkNotNullParameter((JsonObject) r3, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        GetStarInfoResultModel r5 = new GetStarInfoResultModel();
        GetStarInfoResultModel.a r6 = new GetStarInfoResultModel.a();
        GetStarInfoResultModel.b r0 = new GetStarInfoResultModel.b();
        r0.a(jc1.k.n(IOpenPlatformAnchorService.class).getPreviewStarOrderId());
        Unit r1 = Unit.INSTANCE;
        r6.a(r0);
        r5.a(r6);
        finishWithResult(r5);
    }
}
