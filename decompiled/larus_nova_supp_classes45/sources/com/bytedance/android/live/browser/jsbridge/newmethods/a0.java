package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.AdTrackInfoFromCidResultModel;
import com.bytedance.android.livesdkapi.business.ILiveAdMiddleWareService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "adTrackInfoFromCid")
public final class a0 extends w20.c<w20.i7, AdTrackInfoFromCidResultModel> {
    public a0() {
    }

    public final void invoke(Object r2, CallContext r3) {
        w20.i7 r4 = (w20.i7) r2;
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        String r5 = r4.a();
        if (r5 != null) goto L5;
    L8:
        boolean r6 = true;
    L9:
        if (r6 == false) goto L11;
        finishWithFailure(new IllegalArgumentException("cid is empty"));
        return;
    L11:
        JSONObject r7 = jc1.k.n(ILiveAdMiddleWareService.class).getAdInfo(r5);
        if (r7 != null) goto L19;
        finishWithFailure(new IllegalArgumentException("adInfo is empty"));
        return;
    L19:
        AdTrackInfoFromCidResultModel r8 = new AdTrackInfoFromCidResultModel();     // Catch: Exception -> L16
        r8.a(r7.optString("cid"));     // Catch: Exception -> L16
        r8.c(r7.optString("log_extra"));     // Catch: Exception -> L16
        r8.b(AdTrackInfoFromCidResultModel.Code.Success);     // Catch: Exception -> L16
        Unit r9 = Unit.INSTANCE;     // Catch: Exception -> L16
        finishWithResult(r8);     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        finishWithFailure(e);
        return;
    L5:
        if (r5.length() == 0) goto L8;
        r6 = false;
        goto L9
    }
}
