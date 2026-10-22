package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.browser.jsbridge.base.CommunityGetEnableLiveHistoryResultModel;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "community.getEnableLiveHistory")
public final class l0 extends w20.d0<JsonObject, CommunityGetEnableLiveHistoryResultModel> {
    public l0() {
    }

    public final /* bridge */ /* synthetic */ void invoke(Object r1, CallContext r2) {
        j((JsonObject) r1, r2);
    }

    public final void j(JsonObject r2, CallContext r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        CommunityGetEnableLiveHistoryResultModel r4 = new CommunityGetEnableLiveHistoryResultModel();
        r4.b(CommunityGetEnableLiveHistoryResultModel.Code.Success);
        CommunityGetEnableLiveHistoryResultModel.a r5 = new CommunityGetEnableLiveHistoryResultModel.a();
        IHostBusiness r0 = jc1.k.f(IHostBusiness.class);
        if (r0 == null) goto L5;
        boolean r1 = r0.hasLiveHistoryPermission();
    L6:
        r5.b(Boolean.valueOf(r1));
        Unit r6 = Unit.INSTANCE;
        r4.c(r5);
        finishWithResult(r4);
        return;
    L5:
        r1 = false;
        goto L6
    }
}
