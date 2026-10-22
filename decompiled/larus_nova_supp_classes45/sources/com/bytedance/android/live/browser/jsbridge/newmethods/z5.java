package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.LiveCloseProfileResultModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "live.closeProfile")
public final class z5 extends me7.a<me7.k, LiveCloseProfileResultModel> {
    public z5() {
    }

    public final void invoke(Object r2, CallContext r3) {
        me7.k r4 = (me7.k) r2;
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        xs2.b r5 = xs2.b.a();
        Boolean r6 = r4.a();
        if (r6 == null) goto L5;
        boolean r7 = r6.booleanValue();
    L6:
        r5.post(new ps0.a(r7));
        finishWithSuccess();
        return;
    L5:
        r7 = false;
        goto L6
    }
}
