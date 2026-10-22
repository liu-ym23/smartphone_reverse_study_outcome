package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.browser.jsbridge.base.FinishGuestBattleResultModel;
import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@XBridgeMethod(biz = "webcast", name = "finishGuestBattle")
public final class n extends w20.p0<JsonObject, FinishGuestBattleResultModel> {
    public n() {
    }

    public final void invoke(Object r2, CallContext r3) {
        JsonObject r4 = (JsonObject) r2;
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.revenuebase.a r5 = MultiRevenueDataContext.a.a();
        if (r5 == null) goto L5;
        r5.d0(ji0.a.b, r4);
    L5:
        finishWithSuccess();
    }
}
