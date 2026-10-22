package com.larus.share.impl.sdk.special;

import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d extends AbsDownloadListener {
    public final /* synthetic */ ShareImageSpecialHandler a;
    public final /* synthetic */ Ref.IntRef b;

    public final void onSuccessed(DownloadInfo r4) {
        FLogger.a.i("ShareImageSpecialHandler", "Download video success");
        ShareImageSpecialHandler r0 = this.a;
        int r1 = this.b.element;
        if (r4 == null) goto L5;
        String r5 = r4.getTargetFilePath();
    L6:
        ShareImageSpecialHandler.d(r0, r1, r5);
        return;
    L5:
        r5 = null;
        goto L6
    }

    public d(ShareImageSpecialHandler r1, Ref.IntRef r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFailed(DownloadInfo r3, BaseException r4) {
        FLogger r5 = FLogger.a;
        StringBuilder r0 = new StringBuilder("Download video failed: ");
        if (r4 == null) goto L5;
        String r6 = r4.getMessage();
    L6:
        r0.append(r6);
        r5.e("ShareImageSpecialHandler", r0.toString());
        ShareImageSpecialHandler.d(this.a, this.b.element, null);
        return;
    L5:
        r6 = null;
        goto L6
    }
}
