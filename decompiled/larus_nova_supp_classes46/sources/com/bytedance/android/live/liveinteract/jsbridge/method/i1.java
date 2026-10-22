package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.browser.jsbridge.base.StartGuestBattleResultModel;
import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import w20.af;
import w20.q6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@XBridgeMethod(biz = "webcast", name = "startGuestBattle")
public final class i1 extends q6<af, StartGuestBattleResultModel> {
    public i1() {
    }

    public final void invoke(Object r2, CallContext r3) {
        af r4 = (af) r2;
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.revenuebase.a r5 = MultiRevenueDataContext.a.a();
        if (r5 == null) goto L6;
        r5.d0(ji0.g.b, r4);
        return;
    }
}
