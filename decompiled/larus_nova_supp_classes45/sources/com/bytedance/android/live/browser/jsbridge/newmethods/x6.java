package com.bytedance.android.live.browser.jsbridge.newmethods;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class x6 implements com.bytedance.android.live.core.log.c {
    public final /* synthetic */ Map a;

    public x6(Map r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.core.log.c
    public final String generate() {
        return "JSB 发送 " + this.a.toString();
    }
}
