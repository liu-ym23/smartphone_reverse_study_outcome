package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.AdLiveUpdateFeedResultModel;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "adLiveUpdateFeed")
public final class z extends w20.b<w20.h7, AdLiveUpdateFeedResultModel> {
    public z() {
    }

    public final void invoke(Object r2, CallContext r3) {
        Intrinsics.checkNotNullParameter((w20.h7) r2, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        if (jc1.k.f(ILiveDouPlusService.class) == null) goto L6;
        jc1.k.n(ILiveDouPlusService.class).notifyAdxCoinTaskCompleted();
        return;
    }
}
