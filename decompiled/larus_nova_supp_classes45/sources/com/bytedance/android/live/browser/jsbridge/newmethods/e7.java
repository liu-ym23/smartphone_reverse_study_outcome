package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Context;
import com.bytedance.android.livesdk.utils.MdnsServiceManager;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "live.stopDiscoveryService")
public final class e7 extends m<f7, LiveStopDiscoveryServiceResultModel> {
    public e7() {
    }

    public final void invoke(Object r3, CallContext r4) {
        f7 r5 = (f7) r3;
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        String r0 = r5.a();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        LiveStopDiscoveryServiceResultModel r6 = new LiveStopDiscoveryServiceResultModel();
        r6.a(LiveStopDiscoveryServiceResultModel.Code.Failed);
        r6.b("serviceType is null");
        Unit r7 = Unit.INSTANCE;
        finishWithResult(r6);
        return;
    L11:
        MdnsServiceManager r2 = MdnsServiceManager.c;
        Context r8 = r4.getContext();
        String r9 = r5.a();
        Intrinsics.checkNotNull(r9);
        if (r2.c(r8, r9) == false) goto L14;
        LiveStopDiscoveryServiceResultModel r11 = new LiveStopDiscoveryServiceResultModel();
        r11.a(LiveStopDiscoveryServiceResultModel.Code.Success);
        Unit r12 = Unit.INSTANCE;
        finishWithResult(r11);
        return;
    L14:
        LiveStopDiscoveryServiceResultModel r13 = new LiveStopDiscoveryServiceResultModel();
        r13.a(LiveStopDiscoveryServiceResultModel.Code.Failed);
        r13.b("not found " + r5.a() + " service");
        Unit r14 = Unit.INSTANCE;
        finishWithResult(r13);
        return;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }
}
