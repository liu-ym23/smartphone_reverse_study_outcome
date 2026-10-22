package com.bytedance.android.live.browser.service;

import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.bytedance.android.live.browser.jsbridge.IJsBridgeAssistService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class w implements com.bytedance.android.annie.xbridge.mix.f {
    public w() {
    }

    public final void B(JSBridgeManager r2, IHybridComponent r3) {
        Intrinsics.checkNotNullParameter(r2, "jsBridgeManager");
        Intrinsics.checkNotNullParameter(r3, "hybridComponent");
        ((IJsBridgeAssistService) jc1.k.n(IJsBridgeAssistService.class)).registerSpecialMethod(r2, r3);
    }
}
