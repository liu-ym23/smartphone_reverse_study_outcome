package com.bytedance.android.live.core.verify.interceptor;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements com.bytedance.android.live.core.verify.utils.a.g {
    public final /* synthetic */ t80.a a;

    public d(b r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.core.verify.utils.a.g
    public final void onVerify(boolean r1, Map<String, ? extends Object> r2) {
        t80.a r3 = this.a;
        if (r3 == null) goto L9;
        if (r1 == false) goto L6;
        int r4 = 3;
    L7:
        r3.onVerifyResult(r4);
        return;
    L6:
        r4 = 1;
        goto L7
    }
}
