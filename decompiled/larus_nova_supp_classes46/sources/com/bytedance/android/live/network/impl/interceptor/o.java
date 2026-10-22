package com.bytedance.android.live.network.impl.interceptor;

import android.app.Activity;
import android.content.Intent;
import com.bytedance.android.livesdkapi.ILiveActivityResultListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o implements ILiveActivityResultListener.OnLiveActivityResultListener {
    public final /* synthetic */ Activity a;
    public final /* synthetic */ t80.a b;

    public o(Activity r1, j r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onActivityResult(int r2, int r3, Intent r4) {
        ILiveActivityResultListener r5 = this.a;
        if (r5 == null) goto L15;
        r5.setOnLiveActivityResultListener(null);
        if (this.b != null) goto L7;
        return;
    L7:
        if (r3 != (-1)) goto L12;
        if (r4 == null) goto L12;
        if (r4.getIntExtra("key_verify_result", 0) != 2) goto L12;
        this.b.onVerifyResult(2);
        return;
    L12:
        this.b.onVerifyResult(0);
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.ILiveActivityResultListener");
    }
}
