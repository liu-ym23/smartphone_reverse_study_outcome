package com.bytedance.android.live.browser.service;

import com.bytedance.android.annie.bridge.JSBridgeManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g0 implements da.b {
    public final com.bytedance.android.live.browser.v a;

    public g0(com.bytedance.android.live.browser.v r2) {
        Intrinsics.checkNotNullParameter(r2, "jsBridgeService");
        this.a = r2;
    }

    public final void J(JSBridgeManager r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "jsBridgeManager");
        Intrinsics.checkNotNullParameter(r3, "xBridgeRegisterStrategy");
        this.a.registerXBridgeMethods(r2, r3);
    }
}
