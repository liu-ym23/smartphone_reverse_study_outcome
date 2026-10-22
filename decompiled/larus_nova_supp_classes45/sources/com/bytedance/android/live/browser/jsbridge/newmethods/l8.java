package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.OpenAnchorInputDialogResultModel;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openAnchorInputDialog")
public final class l8 extends w20.d4<w20.bc, OpenAnchorInputDialogResultModel> {
    public l8() {
    }

    public final void invoke(Object r3, CallContext r4) {
        w20.bc r5 = (w20.bc) r3;
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        LivePluginSPIManager.e.getClass();
        LivePluginSPIManager.a().addOnSuccess(new k8(r4, r5)).syncCallbackIfReady(true).callbackOnMainThread().requireByUser("OpenAnchorInputDialogMethod");
    }
}
