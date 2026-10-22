package com.bytedance.android.live.browser.jsbridge.newmethods;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.browser.jsbridge.base.GetStrategyFactorResultModel;
import com.bytedance.android.live.strategy.api.IStrategyService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "getStrategyFactor")
public final class h5 extends w20.u1<w20.s9, GetStrategyFactorResultModel> {
    public h5() {
    }

    public final void invoke(Object r6, CallContext r7) {
        w20.s9 r8 = (w20.s9) r6;
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r7, "context");
        GetStrategyFactorResultModel r9 = new GetStrategyFactorResultModel();
        r9.a(GetStrategyFactorResultModel.Code.Success);
        GetStrategyFactorResultModel.a r0 = new GetStrategyFactorResultModel.a();
        IStrategyService r1 = jc1.k.f(IStrategyService.class);
        String r2 = "";
        if (r1 == null) goto L13;
        String r11 = r8.a();
        if (r11 != null) goto L7;
        r11 = "";
    L7:
        LiveData r12 = IStrategyService.a.a(r1, r11, "", false, 12);
        if (r12 == null) goto L13;
        String r13 = (String) r12.getValue();
        if (r13 == null) goto L13;
        r2 = r13;
    L13:
        r0.a(r2);
        Unit r14 = Unit.INSTANCE;
        r9.b(r0);
        finishWithResult(r9);
    }
}
