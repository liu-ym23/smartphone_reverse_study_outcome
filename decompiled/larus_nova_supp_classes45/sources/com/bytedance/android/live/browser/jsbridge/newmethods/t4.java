package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.GetLiveFoldStateResultModel;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "getLiveFoldState")
public final class t4 extends w20.m1<JsonObject, GetLiveFoldStateResultModel> {
    public t4() {
        new GetLiveFoldStateResultModel();
    }

    public final void invoke(Object r2, CallContext r3) {
        Intrinsics.checkNotNullParameter((JsonObject) r2, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        GetLiveFoldStateResultModel r4 = new GetLiveFoldStateResultModel();
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L5
        r4.a(GetLiveFoldStateResultModel.Code.Success);     // Catch: Throwable -> L5
        GetLiveFoldStateResultModel.a r6 = new GetLiveFoldStateResultModel.a();     // Catch: Throwable -> L5
        r6.a(Integer.valueOf(FoldScreenUtils.a()));     // Catch: Throwable -> L5
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L5
        r4.b(r6);     // Catch: Throwable -> L5
        Object r7 = Result.constructor-impl(r4);     // Catch: Throwable -> L5
    L8:
        if (Result.exceptionOrNull-impl(r7) == null) goto L10;
        r4.a(GetLiveFoldStateResultModel.Code.Failed);
        GetLiveFoldStateResultModel.a r8 = new GetLiveFoldStateResultModel.a();
        r8.a(-2);
        Unit r1 = Unit.INSTANCE;
        r4.b(r8);
    L10:
        finishWithResult(r4);
        return;
    L5:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }
}
