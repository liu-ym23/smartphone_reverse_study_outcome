package com.bytedance.android.livesdk.jsbridge.methods.draft;

import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g extends AbsDownloadListener {
    public final /* synthetic */ e a;

    public g(e r1) {
        this.a = r1;
    }

    public final void onProgress(DownloadInfo r2) {
        super.onProgress(r2);
        if (r2 == null) goto L6;
        this.a.a.invoke(Integer.valueOf(r2.getDownloadProcess()));
        return;
    }

    public final void onSuccessed(DownloadInfo r1) {
        super.onSuccessed(r1);
        this.a.b.invoke();
    }

    public final void onFailed(DownloadInfo r1, BaseException r2) {
        super.onFailed(r1, r2);
        this.a.c.invoke(r2);
    }
}
