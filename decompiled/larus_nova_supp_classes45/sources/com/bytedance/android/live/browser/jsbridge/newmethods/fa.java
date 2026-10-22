package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.RefreshActivityBannerNumberResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "refreshActivityBannerNumber")
public final class fa extends w20.d5<w20.ed, RefreshActivityBannerNumberResultModel> {
    public fa() {
    }

    public final void invoke(Object r2, CallContext r3) {
        w20.ed r4 = (w20.ed) r2;
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        Integer r5 = r4.a();
        if (r5 == null) goto L6;
        b30.y r6 = new b30.y(r5.intValue());
        xs2.b.a().post(r6);
        return;
    }
}
