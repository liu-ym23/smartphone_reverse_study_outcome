package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.ss.android.socialbase.downloader.downloader.IDownloadStartCallback;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u implements IDownloadStartCallback {
    public final /* synthetic */ w a;
    public final /* synthetic */ String b;

    public u(w r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onStart(int r3) {
        this.a.a.put(this.b, Integer.valueOf(r3));
    }
}
