package com.bytedance.android.live.browser.service;

import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.ttnet.TTNetInit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i implements y8.c {
    public i() {
    }

    public final float getScreenFps() {
        IPerformanceManager r0 = jc1.k.f(IPerformanceManager.class);
        if (r0 != null) goto L7;
        return -1.0f;
    L7:
        return r0.getFps();
    }

    public final float v0() {
        IPerformanceManager r0 = jc1.k.f(IPerformanceManager.class);
        if (r0 != null) goto L7;
        return -1.0f;
    L7:
        return r0.getFpsInMin();
    }

    public final int getEffectiveConnectionType() {
        return TTNetInit.getEffectiveConnectionType();
    }
}
