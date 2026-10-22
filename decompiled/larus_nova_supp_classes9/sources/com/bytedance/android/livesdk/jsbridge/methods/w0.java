package com.bytedance.android.livesdk.jsbridge.methods;

import android.view.View;
import com.bytedance.android.livehostapi.business.IHostLiveLocalLife;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "localLife.getBcmChain")
public final class w0 extends j<u1, LocalLifeGetBcmChainResultModel> {
    public w0() {
    }

    public final void invoke(Object r3, CallContext r4) {
        u1 r5 = (u1) r3;
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        IHostLiveLocalLife r0 = jc1.k.f(IHostLiveLocalLife.class);
        if (r0 != null) goto L5;
        finishWithFailure();
        return;
    L5:
        View r6 = r4.d;
        if (r6 != null) goto L8;
        finishWithFailure();
        return;
    L8:
        Integer r1 = r5.a();
        if (r1 == null) goto L11;
        int r2 = r1.intValue();
    L12:
        Boolean r7 = r5.b();
        if (r7 == null) goto L15;
        boolean r8 = r7.booleanValue();
    L16:
        JsonObject r9 = r0.getBcmChain(r6, r2, r8);
        LocalLifeGetBcmChainResultModel r10 = new LocalLifeGetBcmChainResultModel();
        r10.a(LocalLifeGetBcmChainResultModel.Code.Success);
        LocalLifeGetBcmChainResultModel.a r11 = new LocalLifeGetBcmChainResultModel.a();
        r11.a(r9);
        Unit r13 = Unit.INSTANCE;
        r10.b(r11);
        finishWithResult(r10);
        return;
    L15:
        r8 = false;
        goto L16
    L11:
        r2 = 20;
        goto L12
    }
}
