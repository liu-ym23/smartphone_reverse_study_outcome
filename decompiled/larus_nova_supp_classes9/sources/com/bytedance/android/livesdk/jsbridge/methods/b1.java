package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "getPushOpenType")
public final class b1 extends f<JsonObject, GetPushOpenTypeResultModel> {
    public b1() {
    }

    public final void invoke(Object r2, CallContext r3) {
        Intrinsics.checkNotNullParameter((JsonObject) r2, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        IHostBusiness r4 = jc1.k.f(IHostBusiness.class);
        if (r4 == null) goto L5;
        Pair r5 = r4.getLivePushOpenType();
    L6:
        if (r5 == null) goto L14;
        Integer r6 = (Integer) r5.getFirst();
        if (r6 != null) goto L11;
    L13:
        GetPushOpenTypeResultModel r7 = new GetPushOpenTypeResultModel();
        r7.a(GetPushOpenTypeResultModel.Code.Success);
        GetPushOpenTypeResultModel.a r0 = new GetPushOpenTypeResultModel.a();
        r0.a((Number) r5.getFirst());
        Unit r8 = Unit.INSTANCE;
        r7.b(r0);
        finishWithResult(r7);
        return;
    L11:
        if (r6.intValue() != (-1)) goto L13;
    L14:
        finishWithFailure();
        return;
    L5:
        r5 = null;
        goto L6
    }
}
