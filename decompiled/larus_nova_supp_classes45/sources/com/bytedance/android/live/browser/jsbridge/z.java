package com.bytedance.android.live.browser.jsbridge;

import com.bytedance.android.annie.api.card.IHybridComponent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class z implements p56.b {
    public final /* synthetic */ y6.c a;

    public final String provideContainerID() {
        IHybridComponent r0 = this.a.c();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.containerId();
    }

    public z(y6.c r1) {
        this.a = r1;
    }
}
