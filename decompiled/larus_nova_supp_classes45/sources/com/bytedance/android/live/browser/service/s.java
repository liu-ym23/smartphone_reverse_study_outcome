package com.bytedance.android.live.browser.service;

import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s implements k9.c {
    public final com.bytedance.android.live.browser.w a;

    public s(com.bytedance.android.live.browser.w r1) {
        this.a = r1;
    }

    public final void a1(String r9, JSONObject r11) {
        com.bytedance.android.live.browser.w r0 = this.a;
        if (r0 == null) goto L8;
        n30.a r1 = r0.getHybridMonitor();
        if (r1 == null) goto L9;
        r1.a(null, "hybrid_state_observe_monitor", r9, null, null, r11, false);
        return;
    L9:
        return;
    }
}
