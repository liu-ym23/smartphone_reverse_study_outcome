package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.HideLoadingResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "hideLoading")
public final class l5 extends w20.c2<JsonObject, HideLoadingResultModel> {
    public l5() {
    }

    public final void invoke(Object r2, CallContext r3) {
        Intrinsics.checkNotNullParameter((JsonObject) r2, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        com.bytedance.android.livesdk.widget.e1 r4 = l30.f.a;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L9
        com.bytedance.android.livesdk.widget.e1 r6 = l30.f.a;     // Catch: Throwable -> L9
        if (r6 == null) goto L6;
        l30.f.a(r6);     // Catch: Throwable -> L9
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Result.constructor-impl(r7);     // Catch: Throwable -> L9
    L11:
        l30.f.a = null;
        HideLoadingResultModel r8 = new HideLoadingResultModel();
        r8.a(HideLoadingResultModel.Code.Success);
        r8.b("SUCCESS");
        Unit r9 = Unit.INSTANCE;
        finishWithResult(r8);
        return;
    L6:
        r7 = null;
    L9:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }
}
