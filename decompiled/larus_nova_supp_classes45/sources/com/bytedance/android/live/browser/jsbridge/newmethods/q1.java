package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.ChangePpeEnvResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "changePpeEnv")
public final class q1 extends w20.o<w20.x7, ChangePpeEnvResultModel> {
    public q1() {
    }

    public final void invoke(Object r2, CallContext r3) {
        w20.x7 r4 = (w20.x7) r2;
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        String r5 = r4.a();
        if (r5 != null) goto L5;
    L8:
        boolean r6 = true;
    L9:
        if (r6 == false) goto L11;
        ChangePpeEnvResultModel r7 = new ChangePpeEnvResultModel();
        r7.a(ChangePpeEnvResultModel.Code.Failed);
        Unit r8 = Unit.INSTANCE;
        finishWithResult(r7);
        return;
    L11:
        la0.a r9 = (la0.a) jc1.k.f(la0.a.class);
        if (r9 == null) goto L14;
        r9.G4();
    L14:
        ChangePpeEnvResultModel r11 = new ChangePpeEnvResultModel();
        r11.a(ChangePpeEnvResultModel.Code.Success);
        Unit r12 = Unit.INSTANCE;
        finishWithResult(r11);
        return;
    L5:
        if (r5.length() == 0) goto L8;
        r6 = false;
        goto L9
    }
}
