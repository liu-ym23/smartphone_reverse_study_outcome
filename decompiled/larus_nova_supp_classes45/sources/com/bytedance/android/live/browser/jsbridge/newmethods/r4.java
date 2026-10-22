package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r4 extends g<JsonObject, GetInteractGameLiveSceneResultModel> {
    public r4(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
    }

    public final void invoke(Object r2, CallContext r3) {
        Intrinsics.checkNotNullParameter((JsonObject) r2, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        GetInteractGameLiveSceneResultModel r4 = new GetInteractGameLiveSceneResultModel();
        r4.a(GetInteractGameLiveSceneResultModel.Code.Success);
        GetInteractGameLiveSceneResultModel.a r5 = new GetInteractGameLiveSceneResultModel.a();
        r5.a(String.valueOf(com.bytedance.android.live.broadcastgame.api.interactgame.j.a()));
        Unit r0 = Unit.INSTANCE;
        r4.b(r5);
        finishWithResult(r4);
    }
}
