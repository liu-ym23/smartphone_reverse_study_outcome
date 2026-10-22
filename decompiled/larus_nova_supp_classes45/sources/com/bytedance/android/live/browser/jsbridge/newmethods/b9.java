package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.CloseShelfManagementPageResultModel;
import com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "closeShelfManagementPage")
public final class b9 extends w20.z<JsonObject, CloseShelfManagementPageResultModel> {
    public b9() {
    }

    public final void invoke(Object r2, CallContext r3) {
        Intrinsics.checkNotNullParameter((JsonObject) r2, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        jc1.k.n(IOpenPlatformAnchorService.class).closeShelfManagementPage();
        finishWithSuccess();
    }
}
