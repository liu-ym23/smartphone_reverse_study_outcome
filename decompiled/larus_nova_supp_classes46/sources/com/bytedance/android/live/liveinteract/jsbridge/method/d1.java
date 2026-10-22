package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;
import w20.l5;
import w20.ld;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@XBridgeMethod(biz = "webcast", name = "resumeGuestBattle")
public final class d1 extends l5<JsonObject, ld> {
    public d1() {
    }

    public final void invoke(Object r2, CallContext r3) {
        JsonObject r4 = (JsonObject) r2;
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.revenuebase.a r5 = MultiRevenueDataContext.a.a();
        if (r5 == null) goto L6;
        r5.d0(ji0.e.b, r4);
        return;
    }
}
