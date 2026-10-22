package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.os.Bundle;
import com.bytedance.android.live.browser.jsbridge.base.FormatOpenSchemaResultModel;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "format.openSchema")
public final class l3 extends w20.q0<w20.v8, FormatOpenSchemaResultModel> {
    public final void onTerminate() {
    }

    public l3() {
    }

    public final void invoke(Object r3, CallContext r4) {
        w20.v8 r5 = (w20.v8) r3;
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        String r0 = r5.a();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L13;
        jc1.k.n(IMiddlewareHostAction.class).handleSchema(r4.getContext(), r5.a(), new Bundle());
        return;
    L13:
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }
}
