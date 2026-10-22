package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "isHomeSideBarSupport")
public final class s5 extends i<JsonObject, IsHomeSideBarSupportResultModel> {
    public s5() {
    }

    public final void invoke(Object r2, CallContext r3) {
        Intrinsics.checkNotNullParameter((JsonObject) r2, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        IsHomeSideBarSupportResultModel r4 = new IsHomeSideBarSupportResultModel();
        r4.a(Boolean.valueOf(jc1.k.n(IHostAction.class).isSideBarPageInMain()));
        finishWithResult(r4);
    }
}
