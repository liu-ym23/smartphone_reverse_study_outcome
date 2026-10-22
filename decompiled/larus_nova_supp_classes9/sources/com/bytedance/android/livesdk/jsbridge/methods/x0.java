package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostLiveLocalLife;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "getLiveLifeCouponInfo")
public final class x0 extends d<y0, GetLiveLifeCouponInfoResultModel> {
    public x0() {
    }

    public final void invoke(Object r3, CallContext r4) {
        Intrinsics.checkNotNullParameter((y0) r3, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        GetLiveLifeCouponInfoResultModel r5 = new GetLiveLifeCouponInfoResultModel();
        IHostLiveLocalLife r6 = TTLiveSDK.hostService().hostLiveLocalLife();
        List<? extends Object> r0 = null;
        if (r6 == null) goto L5;
        List<? extends Object> r1 = r6.getInvalidCouponInfo();
    L6:
        if (r6 == null) goto L8;
        r0 = r6.getFullCouponInfo();
    L8:
        GetLiveLifeCouponInfoResultModel.a r7 = new GetLiveLifeCouponInfoResultModel.a();
        r7.b(r1);
        r7.a(r0);
        r5.a(GetLiveLifeCouponInfoResultModel.Code.Success);
        r5.b(r7);
        Unit r8 = Unit.INSTANCE;
        finishWithResult(r5);
        return;
    L5:
        r1 = null;
        goto L6
    }
}
