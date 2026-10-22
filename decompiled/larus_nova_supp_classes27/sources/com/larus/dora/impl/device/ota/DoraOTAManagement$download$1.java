package com.larus.dora.impl.device.ota;

import com.bytedance.dora.device.DoraDevice;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraOTAManagement$download$1 implements IDownloadListener {
    public final /* synthetic */ z39.a a;
    public final /* synthetic */ DoraDevice b;
    public final /* synthetic */ String c;

    public final void onCanceled(DownloadInfo r3) {
        g49.d.d("DoraOTAManagement", "download: onCanceled " + r3);
    }

    public final void onFirstStart(DownloadInfo r3) {
        g49.d.d("DoraOTAManagement", "download: onFirstStart " + r3);
    }

    public final void onFirstSuccess(DownloadInfo r3) {
        g49.d.d("DoraOTAManagement", "download: onFirstSuccess " + r3);
    }

    public final void onPause(DownloadInfo r3) {
        g49.d.d("DoraOTAManagement", "download: onPause " + r3);
    }

    public final void onPrepare(DownloadInfo r3) {
        g49.d.d("DoraOTAManagement", "download: onPrepare " + r3);
    }

    public final void onProgress(DownloadInfo r3) {
        StringBuilder r0 = new StringBuilder("download: onProgress ");
        r0.append(r3);
        r0.append(' ');
        if (r3 == null) goto L5;
        Integer r1 = Integer.valueOf(r3.getDownloadProcess());
    L6:
        r0.append(r1);
        g49.d.d("DoraOTAManagement", r0.toString());
        if (r3 != null) goto L9;
        int r4 = 0;
    L10:
        DoraOTAManagement r2 = DoraOTAManagement.a;
        DoraOTAManagement.e(0, this.a, r4);
        return;
    L9:
        r4 = Math.min(r3.getDownloadProcess(), 1);
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public final void onStart(DownloadInfo r3) {
        g49.d.d("DoraOTAManagement", "download: onStart " + r3);
        DoraOTAReporter.a.f.d = EventTypeOTAStatus.START_DOWNLOAD.getCode();
        DoraOTAReporter.d();
    }

    public final void onSuccessed(DownloadInfo r8) {
        g49.d.d("DoraOTAManagement", "download: onSuccess " + r8);
        BuildersKt.launch$default(DoraOTAManagement.d, null, null, new DoraOTAManagement$download$1$onSuccessed$1(this.b, this.c, this.a, null), 3, null);
    }

    public final void onFailed(DownloadInfo r8, BaseException r9) {
        g49.d.c("DoraOTAManagement", "download: onFailed " + r8 + ' ' + r9, r9);
        BuildersKt.launch$default(DoraOTAManagement.d, null, null, new DoraOTAManagement$download$1$onFailed$1(r9, this.a, this.b, null), 3, null);
    }

    public final void onRetry(DownloadInfo r3, BaseException r4) {
        g49.d.c("DoraOTAManagement", "download: onRetry " + r3 + ' ' + r4, r4);
        k0 r5 = DoraOTAReporter.a;
        l0 r6 = DoraOTAReporter.a.f;
        r6.c = r6.c + 1;
    }

    public final void onRetryDelay(DownloadInfo r3, BaseException r4) {
        g49.d.c("DoraOTAManagement", "download: onRetryDelay " + r3 + ' ' + r4, r4);
    }

    public DoraOTAManagement$download$1(z39.a r1, DoraDevice r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
