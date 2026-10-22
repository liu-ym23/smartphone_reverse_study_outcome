package com.bytedance.android.live.browser.jsbridge;

import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.android.livesdkapi.hybridapi.ILiveHybridContainer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f0 implements p56.b {
    public final /* synthetic */ IJsBridgeManager a;

    public final String provideContainerID() {
        ILiveHybridContainer r0 = this.a.getContainer();
        if (r0 == null) goto L7;
        String r1 = r0.getContainerId();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return this.a.getJsBridge2().toString();
    }

    public f0(IJsBridgeManager r1) {
        this.a = r1;
    }
}
