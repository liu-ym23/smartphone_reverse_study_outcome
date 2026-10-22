package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.browser.jsbridge.base.OpenExplainCardSettingDialogResultModel;
import com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openExplainCardSettingDialog")
public final class g9 extends w20.i4<w20.hc, OpenExplainCardSettingDialogResultModel> {
    public g9() {
    }

    public final void invoke(Object r2, CallContext r3) {
        w20.hc r4 = (w20.hc) r2;
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        jc1.k.n(IOpenPlatformAnchorService.class).openExplainCardSettingDialog(com.bytedance.android.livesdk.utils.s2.a(GsonProtectorUtils.toJson(GsonHelper.get(), r4)));
        finishWithSuccess();
    }
}
