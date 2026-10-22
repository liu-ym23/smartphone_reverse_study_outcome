package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "cancelLoading")
public final class e extends com.bytedance.ies.web.jsbridge2.f<Object, Object> {
    public final HybridFragment a;

    public final void onTerminate() {
    }

    public e(m16.b r10) {
        Intrinsics.checkNotNullParameter(r10, "providerFactory");
        HybridFragment r11 = (HybridFragment) r10.c(HybridFragment.class);
        if (r11 == null) goto L6;
        this.a = r11;
        return;
    }

    public e(HybridFragment r10) {
        Intrinsics.checkNotNullParameter(r10, "hybridFragment");
        this.a = r10;
    }

    public final void invoke(Object r10, CallContext r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        HybridFragment r12 = this.a;
        if (r12 == null) goto L6;
        r12.cancelLoading();
        return;
    }
}
