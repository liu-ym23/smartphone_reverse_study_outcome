package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.NotifyClearMountDataResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "notifyClearMountData")
public final class f9 extends w20.a4<w20.wb, NotifyClearMountDataResultModel> {
    public f9() {
    }

    public final void invoke(Object r4, CallContext r5) {
        Intrinsics.checkNotNullParameter((w20.wb) r4, "params");
        Intrinsics.checkNotNullParameter(r5, "context");
        com.bytedance.android.livesdk.widget.x0.b r6 = new com.bytedance.android.livesdk.widget.x0.b(r5.getContext(), 7);
        r6.m(2131921113);
        r6.j(1, com.bytedance.android.live.core.utils.s1.B(2131920892), new d9(this));
        r6.j(0, com.bytedance.android.live.core.utils.s1.B(2131920910), new e9(this));
        r6.k(0, true);
        r6.setCornerRadius(16.0f);
        r6.n();
    }
}
