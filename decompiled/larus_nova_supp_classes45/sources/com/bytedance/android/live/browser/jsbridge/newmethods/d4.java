package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.GetCurrentDegradeInfoResultModel;
import com.bytedance.android.live.browser.utils.DegradeUtils;
import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "getCurrentDegradeInfo")
public final class d4 extends w20.g1<JsonObject, GetCurrentDegradeInfoResultModel> {
    public d4() {
    }

    public final void invoke(Object r4, CallContext r5) {
        JsonObject r6 = (JsonObject) r4;
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r5, "context");
        GetCurrentDegradeInfoResultModel r7 = new GetCurrentDegradeInfoResultModel();
        GetCurrentDegradeInfoResultModel.a r0 = new GetCurrentDegradeInfoResultModel.a();
        Object r1 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L9
        JsonElement r8 = r6.get("scene");     // Catch: Throwable -> L9
        if (r8 == null) goto L6;
        String r9 = r8.getAsString();     // Catch: Throwable -> L9
    L7:
        Object r11 = Result.constructor-impl(r9);     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r11) == true) goto L15;
        r1 = r11;
    L15:
        String r3 = (String) r1;
        Lazy r12 = DegradeUtils.a;
        if (((Boolean) com.bytedance.android.live.core.setting.g4.a.getValue()).booleanValue() == true) goto L18;
        IPerformanceStrategyManager r13 = (IPerformanceStrategyManager) DegradeUtils.a.getValue();
        if (r13 == null) goto L23;
        int r14 = r13.getCurrentPerformanceLevel();
    L24:
        r0.a(Integer.valueOf(r14));
        r0.b(0);
        Unit r15 = Unit.INSTANCE;
        r7.a(r0);
        finishWithResult(r7);
        return;
    L23:
        r14 = 0;
        goto L24
    L18:
        if (Intrinsics.areEqual(r3, "live_resource_hour_rank_anim") == false) goto L23;
        r14 = n20.a.a;
        goto L24
    L6:
        r9 = null;
    L9:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }
}
