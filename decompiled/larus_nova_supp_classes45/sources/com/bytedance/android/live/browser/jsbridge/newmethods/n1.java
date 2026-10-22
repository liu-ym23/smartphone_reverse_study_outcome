package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.CanIUseResultModel;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.ies.web.jsbridge2.CallContext;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n1 extends w20.k<w20.s7, CanIUseResultModel> {
    public final IJsBridgeManager a;

    public final void onTerminate() {
    }

    public n1(IJsBridgeManager r1) {
        this.a = r1;
    }

    public final void invoke(Object r2, CallContext r3) {
        w20.s7 r4 = (w20.s7) r2;
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        String r5 = r4.a();
        CanIUseResultModel r6 = new CanIUseResultModel();
        IJsBridgeManager r0 = this.a;
        if (r0 == null) goto L9;
        List r1 = r0.getMethodNameList();
        if (r1 == null) goto L9;
        if (CollectionsKt.contains(r1, r5) != true) goto L9;
        int r7 = 1;
    L10:
        r6.a(r7);
        r6.b(CanIUseResultModel.Code.Success);
        finishWithResult(r6);
        return;
    L9:
        r7 = 0;
        goto L10
    }
}
