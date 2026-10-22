package hw0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.recharge.exchange.jsbridge.GetMemAutoExchangeStatusResultModel;
import com.bytedance.android.live.recharge.platform.business.IExchangeStatusService;
import com.bytedance.android.live.recharge.utils.RechargeFacadeUtilsKt;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e extends a<JsonObject, GetMemAutoExchangeStatusResultModel> {
    public e() {
    }

    public final void invoke(Object r3, CallContext r4) {
        Intrinsics.checkNotNullParameter((JsonObject) r3, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        RechargeFacadeUtilsKt.a().getClass();
        IExchangeStatusService r5 = (IExchangeStatusService) ((dy0.d) com.bytedance.android.live.revenue.core.util.f.d(j.C0.a(), IExchangeStatusService.class));
        if (r5 == null) goto L5;
        Integer r6 = Integer.valueOf(r5.getAutoExchangeStatus());
    L6:
        GetMemAutoExchangeStatusResultModel r7 = new GetMemAutoExchangeStatusResultModel();
        GetMemAutoExchangeStatusResultModel.a r0 = new GetMemAutoExchangeStatusResultModel.a();
        r0.a(r6);
        Unit r1 = Unit.INSTANCE;
        r7.b(r0);
        r7.a(GetMemAutoExchangeStatusResultModel.Code.Success);
        finishWithResult(r7);
        ALogger.i("GetAutoExchangeStatusMethod", "return autoExchangeStatus: " + r6);
        return;
    L5:
        r6 = null;
        goto L6
    }
}
