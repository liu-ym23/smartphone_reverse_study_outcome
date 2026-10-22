package com.larus.doc.impl.video;

import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import kotlin.Result;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class n extends AbsDownloadListener {
    public final /* synthetic */ kotlinx.coroutines.i<String> a;

    public n(kotlinx.coroutines.j r1) {
        this.a = r1;
    }

    public final void onSuccessed(DownloadInfo r3) {
        kotlinx.coroutines.i<String> r0 = this.a;
        Result.Companion r1 = Result.Companion;
        if (r3 == null) goto L5;
        String r4 = r3.getTargetFilePath();
    L6:
        r0.resumeWith(Result.constructor-impl(r4));
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void onFailed(DownloadInfo r3, BaseException r4) {
        FLogger r5 = FLogger.a;
        StringBuilder r0 = new StringBuilder("Download video failed: ");
        if (r4 == null) goto L5;
        String r6 = r4.getMessage();
    L6:
        r0.append(r6);
        r5.e("VideoDetailFragment", r0.toString());
        this.a.resumeWith(Result.constructor-impl(null));
        return;
    L5:
        r6 = null;
        goto L6
    }
}
