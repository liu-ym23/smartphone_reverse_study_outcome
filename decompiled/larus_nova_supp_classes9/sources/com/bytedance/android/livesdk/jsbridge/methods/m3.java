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
@XBridgeMethod(biz = "webcast", name = "localLife.registerBtmPage")
public final class m3 extends l<v1, LocalLifeRegisterBtmPageResultModel> {
    public m3() {
    }

    public final void invoke(Object r7, CallContext r8) {
        v1 r9 = (v1) r7;
        Intrinsics.checkNotNullParameter(r9, "params");
        Intrinsics.checkNotNullParameter(r8, "context");
        IHostLiveLocalLife r0 = jc1.k.f(IHostLiveLocalLife.class);
        if (r0 != null) goto L5;
        finishWithFailure();
        return;
    L5:
        View r10 = r8.d;
        if (r10 != null) goto L8;
        finishWithFailure();
        return;
    L8:
        String r1 = r9.b();
        if (r1 != null) goto L11;
        finishWithFailure();
        return;
    L11:
        JsonObject r2 = r9.a();
        if (r2 == null) goto L22;
        GsonMap r3 = UtilsKt.i(r2);
        LinkedHashMap r4 = new LinkedHashMap();
        Iterator r5 = r3.entrySet().iterator();
    L15:
        if (r5.hasNext() == false) goto L24;
        Map.Entry r6 = (Map.Entry) r5.next();
        if (r6.getValue() == null) goto L19;
        boolean r11 = true;
    L20:
        if (r11 == false) goto L15;
        r4.put(r6.getKey(), r6.getValue());
        goto L15
    L19:
        r11 = false;
    L24:
        if (r0.registerBtmPage(r10, r1, r9.c(), r4) == false) goto L26;
        LocalLifeRegisterBtmPageResultModel r13 = new LocalLifeRegisterBtmPageResultModel();
        r13.a(LocalLifeRegisterBtmPageResultModel.Code.Success);
        Unit r14 = Unit.INSTANCE;
        finishWithResult(r13);
        return;
    L26:
        finishWithFailure(new Throwable("register btm page failed"));
        return;
    L22:
        r4 = null;
        goto L24
    }
}
