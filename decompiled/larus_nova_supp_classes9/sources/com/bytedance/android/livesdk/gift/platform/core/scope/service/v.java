package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class v extends AbsDownloadListener {
    public final /* synthetic */ q a;
    public final /* synthetic */ String b;

    public final void onSuccessed(DownloadInfo r3) {
        super.onSuccessed(r3);
        if (r3 == null) goto L6;
        this.a.a(this.b, r3.getSavePath() + r3.getName());
        return;
    }

    public v(z3.a r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFailed(DownloadInfo r1, BaseException r2) {
        super.onFailed(r1, r2);
        q r3 = this.a;
        if (r2 == null) goto L6;
        String r4 = r2.getMessage();
        if (r4 == null) goto L6;
    L7:
        r3.error(r4);
        return;
    L6:
        r4 = "no error message";
        goto L7
    }
}
