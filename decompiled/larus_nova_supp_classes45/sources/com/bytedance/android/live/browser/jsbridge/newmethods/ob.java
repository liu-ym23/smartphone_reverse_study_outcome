package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Context;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "scanCode")
public final class ob extends w20.p5<w20.sd, JSONObject> {
    public final void onTerminate() {
    }

    public ob() {
    }

    public final void onDestroy() {
        super.onDestroy();
    }

    public final void invoke(Object r5, CallContext r6) {
        w20.sd r7 = (w20.sd) r5;
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter(r6, "context");
        nb r0 = new nb(this, r7, r6);
        IHostAction r1 = jc1.k.n(IHostAction.class);
        Context r8 = r6.getContext();
        Boolean r2 = r7.a();
        boolean r3 = false;
        if (r2 == null) goto L5;
        boolean r4 = r2.booleanValue();
    L6:
        Boolean r9 = r7.b();
        if (r9 == null) goto L9;
        r3 = r9.booleanValue();
    L9:
        r1.startQrScanCode(r8, r4, r3, r0);
        return;
    L5:
        r4 = false;
        goto L6
    }
}
