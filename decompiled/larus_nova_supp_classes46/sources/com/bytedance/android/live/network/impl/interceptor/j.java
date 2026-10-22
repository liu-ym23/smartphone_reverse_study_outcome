package com.bytedance.android.live.network.impl.interceptor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j implements t80.a {
    public final /* synthetic */ t80.a a;

    public j() {
        this.a = null;
    }

    public final void onVerifyResult(int r2) {
        t80.a r0 = this.a;
        if (r0 == null) goto L6;
        r0.onVerifyResult(r2);
        return;
    }
}
