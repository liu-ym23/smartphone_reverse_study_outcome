package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.GetPersonCardInfoResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "getPersonCardInfo")
public final class e5 extends w20.q1<w20.q9, GetPersonCardInfoResultModel> {
    public e5() {
    }

    public final void invoke(Object r3, CallContext r4) {
        w20.q9 r5 = (w20.q9) r3;
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        String r6 = r5.a();
        String r7 = "";
        if (r6 != null) goto L5;
        r6 = "";
    L5:
        ns0.a r0 = ns0.c.a();
        if (r0 == null) goto L8;
        ps0.c r8 = r0.getPersonCardData(r6);
    L9:
        if (r8 == null) goto L12;
        String r1 = r8.b;
        if (r1 == null) goto L12;
    L13:
        if (r8 == null) goto L18;
        String r9 = r8.a;
        if (r9 == null) goto L18;
        r7 = r9;
    L18:
        GetPersonCardInfoResultModel r11 = new GetPersonCardInfoResultModel();
        GetPersonCardInfoResultModel.a r2 = new GetPersonCardInfoResultModel.a();
        r2.b(r7);
        r2.a(r1);
        Unit r12 = Unit.INSTANCE;
        r11.a(r2);
        finishWithResult(r11);
        return;
    L12:
        r1 = "";
        goto L13
    L8:
        r8 = null;
        goto L9
    }
}
