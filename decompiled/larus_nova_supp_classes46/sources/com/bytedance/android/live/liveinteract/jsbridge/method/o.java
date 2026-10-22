package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.browser.jsbridge.base.GetFansClubStatusResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@XBridgeMethod(biz = "webcast", name = "getFansClubStatus")
public final class o extends w20.h1<JsonObject, GetFansClubStatusResultModel> {
    public o() {
    }

    public final void invoke(Object r2, CallContext r3) {
        Intrinsics.checkNotNullParameter((JsonObject) r2, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        GetFansClubStatusResultModel r4 = new GetFansClubStatusResultModel();
        com.bytedance.android.live.profit.fansclub.o r5 = yt0.c.c();
        if (r5 == null) goto L9;
        com.bytedance.live.datacontext.m r6 = r5.getProfile();
        if (r6 == null) goto L9;
        com.bytedance.android.live.profit.fansclub.g r7 = (com.bytedance.android.live.profit.fansclub.g) r6.getValue();
        if (r7 == null) goto L9;
        int r8 = r7.b();
    L10:
        r4.b(Integer.valueOf(r8));
        r4.a(GetFansClubStatusResultModel.Code.Success);
        finishWithResult(r4);
        StringBuilder r9 = new StringBuilder("status: ");
        com.bytedance.android.live.profit.fansclub.o r10 = yt0.c.c();
        if (r10 == null) goto L17;
        com.bytedance.live.datacontext.m r11 = r10.getProfile();
        if (r11 == null) goto L17;
        com.bytedance.android.live.profit.fansclub.g r12 = (com.bytedance.android.live.profit.fansclub.g) r11.getValue();
        if (r12 == null) goto L17;
        String r13 = String.valueOf(r12.b());
    L18:
        r9.append(r13);
        ALogger.d("GetFansClubStatusMethod", r9.toString());
        return;
    L17:
        r13 = null;
    L9:
        r8 = 0;
        goto L10
    }
}
