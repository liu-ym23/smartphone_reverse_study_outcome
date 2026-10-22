package com.larus.dora.impl.ota.g2;

import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class m5 implements IDownloadListener {
    final /* synthetic */ o$a $callback;

    public final void onFirstStart(DownloadInfo r1) {
    }

    public final void onFirstSuccess(DownloadInfo r1) {
    }

    public final void onPrepare(DownloadInfo r1) {
    }

    public final void onRetry(DownloadInfo r1, BaseException r2) {
    }

    @Deprecated(message = "")
    public final void onRetryDelay(DownloadInfo r1, BaseException r2) {
    }

    public final void onStart(DownloadInfo r1) {
    }

    public m5(AndroidG2OtaRuntime$startLocked$1 r1) {
        this.$callback = r1;
    }

    public final void onCanceled(DownloadInfo r2) {
        this.$callback.a(false);
    }

    public final void onPause(DownloadInfo r1) {
        this.$callback.z();
    }

    public final void onProgress(DownloadInfo r4) {
        if (r4 == null) goto L5;
        this.$callback.b(r4.getCurBytes());
        return;
    }

    public final void onSuccessed(DownloadInfo r1) {
        this.$callback.c();
    }

    public final void onFailed(DownloadInfo r2, BaseException r3) {
        o$a r4 = this.$callback;
        l5.a().getClass();
        Set r0 = l5.d();
        if (r3 == null) goto L5;
        Integer r5 = Integer.valueOf(r3.getErrorCode());
    L6:
        r4.a(CollectionsKt.contains(r0, r5));
        return;
    L5:
        r5 = null;
        goto L6
    }
}
