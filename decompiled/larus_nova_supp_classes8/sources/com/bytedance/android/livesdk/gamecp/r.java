package com.bytedance.android.livesdk.gamecp;

import com.bytedance.android.livesdkapi.service.gamecp.OnVerifyResultListenerProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r implements OnVerifyResultListenerProxy {
    public final /* synthetic */ bw.t a;

    public r(com.bytedance.android.gamecp.business.props.r r1) {
        this.a = r1;
    }

    public final void onVerifyResult(int r2) {
        bw.t r0 = this.a;
        if (r0 == null) goto L6;
        r0.onVerifyResult(r2);
        return;
    }
}
