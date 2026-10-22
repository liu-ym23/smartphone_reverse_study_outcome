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
@XBridgeMethod(biz = "webcast", name = "localLife.createBtmSourceToken")
public final class m0 extends i<t1, LocalLifeCreateBtmSourceTokenResultModel> {
    public m0() {
    }

    public final void invoke(Object r6, CallContext r7) {
        t1 r8 = (t1) r6;
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r7, "context");
        IHostLiveLocalLife r0 = jc1.k.f(IHostLiveLocalLife.class);
        if (r0 != null) goto L5;
        finishWithFailure();
        return;
    L5:
        View r9 = r7.d;
        if (r9 != null) goto L8;
        finishWithFailure();
        return;
    L8:
        String r1 = r8.b();
        if (r1 != null) goto L11;
        finishWithFailure();
        return;
    L11:
        JsonObject r10 = r8.a();
        if (r10 == null) goto L22;
        GsonMap r11 = UtilsKt.i(r10);
        LinkedHashMap r2 = new LinkedHashMap();
        Iterator r13 = r11.entrySet().iterator();
    L15:
        if (r13.hasNext() == false) goto L23;
        Map.Entry r3 = (Map.Entry) r13.next();
        if (r3.getValue() == null) goto L19;
        boolean r4 = true;
    L20:
        if (r4 == false) goto L15;
        r2.put(r3.getKey(), r3.getValue());
        goto L15
    L19:
        r4 = false;
    L23:
        String r14 = r0.createBtmSourceToken(r9, r1, r2);
        LocalLifeCreateBtmSourceTokenResultModel r15 = new LocalLifeCreateBtmSourceTokenResultModel();
        r15.a(LocalLifeCreateBtmSourceTokenResultModel.Code.Success);
        LocalLifeCreateBtmSourceTokenResultModel.a r5 = new LocalLifeCreateBtmSourceTokenResultModel.a();
        r5.a(r14);
        Unit r16 = Unit.INSTANCE;
        r15.b(r5);
        finishWithResult(r15);
        return;
    L22:
        r2 = null;
        goto L23
    }
}
