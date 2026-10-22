package com.bytedance.android.livesdk.jsbridge.methods;

import android.view.View;
import com.bytedance.android.live.browser.GsonMap;
import com.bytedance.android.live.browser.UtilsKt;
import com.bytedance.android.livehostapi.business.IHostLiveLocalLife;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@XBridgeMethod(biz = "webcast", name = "localLife.setBcmParam")
public final class b4 extends m<w1, LocalLifeSetBcmParamResultModel> {
    public b4() {
    }

    public final void invoke(Object r5, CallContext r6) {
        w1 r7 = (w1) r5;
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r6, "context");
        IHostLiveLocalLife r0 = jc1.k.f(IHostLiveLocalLife.class);
        if (r0 != null) goto L5;
        finishWithFailure();
        return;
    L5:
        View r8 = r6.d;
        if (r8 != null) goto L8;
        finishWithFailure();
        return;
    L8:
        JsonObject r9 = r7.a();
        if (r9 != null) goto L11;
        finishWithFailure();
        return;
    L11:
        GsonMap r10 = UtilsKt.i(r9);
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator r11 = r10.entrySet().iterator();
    L13:
        if (r11.hasNext() == false) goto L20;
        Map.Entry r2 = (Map.Entry) r11.next();
        if (r2.getValue() == null) goto L17;
        boolean r3 = true;
    L18:
        if (r3 == false) goto L13;
        r1.put(r2.getKey(), r2.getValue());
        goto L13
    L17:
        r3 = false;
        goto L18
    L20:
        r0.setBcmParams(r8, r1);
        LocalLifeSetBcmParamResultModel r13 = new LocalLifeSetBcmParamResultModel();
        r13.a(LocalLifeSetBcmParamResultModel.Code.Success);
        Unit r14 = Unit.INSTANCE;
        finishWithResult(r13);
    }
}
