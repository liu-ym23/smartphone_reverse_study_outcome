package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "isBizEntryInHomeSideBar")
public final class q5 extends h<r5, IsBizEntryInHomeSideBarResultModel> {
    public q5() {
    }

    public final void invoke(Object r2, CallContext r3) {
        r5 r4 = (r5) r2;
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        String r5 = r4.a();
        if (r5 != null) goto L5;
        IsBizEntryInHomeSideBarResultModel r6 = new IsBizEntryInHomeSideBarResultModel();
        r6.a(Boolean.FALSE);
        Unit r7 = Unit.INSTANCE;
        finishWithResult(r6);
        return;
    L5:
        jc1.k.n(IHostAction.class).businessInHomeSideBar(r5, new p5(this));
    }
}
