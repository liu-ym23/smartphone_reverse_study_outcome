package com.bytedance.android.live.browser.jsbridge;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class x implements com.bytedance.android.annie.bridge.q {
    public final /* synthetic */ String a;
    public final /* synthetic */ Map.Entry b;
    public final /* synthetic */ y6.c c;

    public final com.bytedance.ies.web.jsbridge2.f a() {
        return new w(this);
    }

    public final void release() {
        ((com.bytedance.ies.xbridge.n) this.b.getValue()).a().release();
    }

    public x(String r1, Map.Entry r2, y6.c r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
