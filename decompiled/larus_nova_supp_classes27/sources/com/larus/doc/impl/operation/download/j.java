package com.larus.doc.impl.operation.download;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.ss.android.socialbase.appdownloader.AppDownloader;
import com.ss.android.socialbase.appdownloader.AppTaskBuilder;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class j {
    public boolean a;

    public static final class a implements IDownloadListener {
        public final /* synthetic */ j a;
        public final /* synthetic */ k b;
        public final /* synthetic */ Context c;

        public final void onCanceled(DownloadInfo r4) {
            FLogger r0 = FLogger.a;
            this.a.getClass();
            r0.i("DocDownloader", "[onCanceled]");
            this.a.a = false;
            this.b.d.a(null, "cancel");
            if (r4 == null) goto L6;
            int r5 = r4.getId();
            j r1 = this.a;
            Context r2 = this.c;
            r1.getClass();
            t0.a(new i(r2, r5, this));
            return;
        }

        public final void onFirstStart(DownloadInfo r3) {
            FLogger r4 = FLogger.a;
            this.a.getClass();
            r4.i("DocDownloader", "[onFirstStart]");
        }

        public final void onFirstSuccess(DownloadInfo r3) {
            FLogger r4 = FLogger.a;
            this.a.getClass();
            r4.i("DocDownloader", "[onFirstSuccess]");
        }

        public final void onPause(DownloadInfo r3) {
            FLogger r4 = FLogger.a;
            this.a.getClass();
            r4.i("DocDownloader", "[onPause]");
        }

        public final void onPrepare(DownloadInfo r3) {
            FLogger r4 = FLogger.a;
            this.a.getClass();
            r4.i("DocDownloader", "[onPrepare]");
        }

        public final void onProgress(DownloadInfo r3) {
            FLogger r4 = FLogger.a;
            this.a.getClass();
            r4.i("DocDownloader", "[onProgress]");
        }

        public final void onStart(DownloadInfo r3) {
            FLogger r4 = FLogger.a;
            this.a.getClass();
            r4.i("DocDownloader", "[onStart]");
        }

        public final void onSuccessed(DownloadInfo r4) {
            FLogger r0 = FLogger.a;
            this.a.getClass();
            r0.i("DocDownloader", "[onSuccessed] entity:" + r4);
            this.a.a = false;
            this.b.d.onSuccess(this.b.c + this.b.b);
            if (r4 == null) goto L6;
            int r5 = r4.getId();
            j r1 = this.a;
            Context r2 = this.c;
            r1.getClass();
            t0.a(new i(r2, r5, this));
            return;
        }

        public final void onFailed(DownloadInfo r4, BaseException r5) {
            FLogger r0 = FLogger.a;
            this.a.getClass();
            StringBuilder r1 = new StringBuilder("[onFailed] error:");
            if (r5 == null) goto L5;
            String r6 = r5.getMessage();
        L6:
            r1.append(r6);
            r0.i("DocDownloader", r1.toString());
            this.a.a = false;
            this.b.d.a(null, "download failed");
            if (r4 == null) goto L10;
            int r7 = r4.getId();
            j r8 = this.a;
            Context r2 = this.c;
            r8.getClass();
            t0.a(new i(r2, r7, this));
            return;
        L10:
            return;
        L5:
            r6 = null;
            goto L6
        }

        public final void onRetry(DownloadInfo r2, BaseException r3) {
            FLogger r4 = FLogger.a;
            this.a.getClass();
            r4.i("DocDownloader", "[onRetry]");
        }

        public final void onRetryDelay(DownloadInfo r2, BaseException r3) {
            FLogger r4 = FLogger.a;
            this.a.getClass();
            r4.i("DocDownloader", "[onRetryDelay]");
        }

        public a(j r1, k r2, Context r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public j() {
    }

    public final void a(Context r6, k r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "task");
        FLogger.a.i("DocDownloader", "[startDownload] isDownloading:" + this.a + ", name:" + r7 + ' ');
        if (this.a == false) goto L6;
        r7.d.a(null, "current is downloading");
        return;
    L6:
        this.a = true;
        String r1 = r7.a;
        String r2 = r7.c;
        String r3 = r7.b;
        AppDownloader.getInstance().addDownloadTask(new AppTaskBuilder(r6, r1).saveName(r3).savePath(r2).taskKey(r1 + ':' + r2 + ':' + r3).needWifi(false).showNotification(false).needDefaultHttpServiceBackUp(true).ignoreInterceptor(true).retryCount(3).mainThreadListener(new a(this, r7, r6)));
    }
}
