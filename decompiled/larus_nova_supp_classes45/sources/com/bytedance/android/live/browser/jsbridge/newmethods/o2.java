package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livehostapi.platform.TokenInfo;
import com.bytedance.android.livehostapi.platform.TokenRefreshCallback;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class o2 implements TokenRefreshCallback {
    public final /* synthetic */ p2 a;

    public o2(p2 r1) {
        this.a = r1;
    }

    public final void onFailed(Throwable r3) {
        this.a.finishWithResult(new p2.b(2));
    }

    public final void onSuccess(TokenInfo r3) {
        this.a.finishWithResult(new p2.b(1));
    }
}
