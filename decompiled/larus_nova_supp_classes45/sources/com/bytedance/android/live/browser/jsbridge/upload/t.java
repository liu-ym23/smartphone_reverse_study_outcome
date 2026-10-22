package com.bytedance.android.live.browser.jsbridge.upload;

import com.bytedance.android.livesdkapi.listener.UploadProgressListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class t implements UploadProgressListener {
    public final /* synthetic */ q a;

    public t(q r1) {
        this.a = r1;
    }

    public final void onProgress(long r1, long r3) {
        int r2 = (((int) ((r1 / r3) * 100.0d)) / 2) + 50;
        q r4 = this.a;
        if (r2 == r4.N) goto L6;
        r4.E(r2);
        this.a.N = r2;
        return;
    }
}
