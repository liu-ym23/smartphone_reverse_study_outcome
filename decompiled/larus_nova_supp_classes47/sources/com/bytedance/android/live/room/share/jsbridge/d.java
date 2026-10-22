package com.bytedance.android.live.room.share.jsbridge;

import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@XBridgeMethod(biz = "webcast", name = "shareInfo")
public final class d extends com.bytedance.ies.web.jsbridge2.f<i81.c, Object> {
    public y6.d a;

    public final void onTerminate() {
        this.a = null;
    }

    public d(m16.b r2) {
        JSBridgeManager r3 = (JSBridgeManager) r2.c(JSBridgeManager.class);
        if (r3 == null) goto L6;
        this.a = r3.t;
        return;
    }

    public d(y6.d r1) {
        this.a = r1;
    }

    public final void invoke(Object r5, CallContext r6) throws Exception {
        i81.c r7 = (i81.c) r5;
        this.a.DY(new y6.e(r7.title, r7.desc, r7.image, r7.url));
        finishWithSuccess();
    }
}
