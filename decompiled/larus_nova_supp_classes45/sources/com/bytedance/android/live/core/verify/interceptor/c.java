package com.bytedance.android.live.core.verify.interceptor;

import android.app.Activity;
import android.content.Intent;
import com.bytedance.android.livesdkapi.ILiveActivityResultListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements ILiveActivityResultListener.OnLiveActivityResultListener {
    public final /* synthetic */ Activity a;
    public final /* synthetic */ t80.a b;

    public c(Activity r1, b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onActivityResult(int r3, int r4, Intent r5) {
        ILiveActivityResultListener r6 = this.a;
        if (r6 == null) goto L19;
        r6.setOnLiveActivityResultListener(null);
        if (this.b != null) goto L7;
        return;
    L7:
        if (r4 != (-1)) goto L12;
        if (r5 == null) goto L12;
        if (r5.getIntExtra("key_verify_result", 0) != 3) goto L12;
        this.b.onVerifyResult(3);
        return;
    L12:
        if (r5 != null) goto L14;
    L16:
        this.b.onVerifyResult(0);
        return;
    L14:
        if (r5.getIntExtra("key_verify_result", 0) != 2) goto L16;
        this.b.onVerifyResult(2);
        return;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.ILiveActivityResultListener");
    }
}
