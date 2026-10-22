package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "setTitle")
public final class i0 extends com.bytedance.ies.web.jsbridge2.f<JSONObject, Object> {
    public final HybridFragment a;

    public final void onTerminate() {
    }

    public i0(m16.b r10) {
        Intrinsics.checkNotNullParameter(r10, "providerFactory");
        HybridFragment r11 = (HybridFragment) r10.c(HybridFragment.class);
        if (r11 == null) goto L6;
        this.a = r11;
        return;
    }

    public i0(HybridFragment r10) {
        Intrinsics.checkNotNullParameter(r10, "hybridFragment");
        this.a = r10;
    }

    public final void invoke(Object r10, CallContext r11) {
        JSONObject r12 = (JSONObject) r10;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        String r13 = r12.optString("title");
        HybridFragment r14 = this.a;
        if (r14 == null) goto L5;
        r14.setHybridTitle(r13);
    L5:
        finishWithResult(null);
    }
}
