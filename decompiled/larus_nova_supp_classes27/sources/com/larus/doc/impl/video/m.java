package com.larus.doc.impl.video;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class m implements Function1<Throwable, Unit> {
    public final /* synthetic */ DownloadTask a;
    public final /* synthetic */ Context b;

    public m(DownloadTask r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r3) {
        Throwable r4 = (Throwable) r3;
        FLogger.a.e("VideoDetailFragment", "Download video cancel, downloadId = " + this.a.getDownloadId());
        Downloader.getInstance(this.b).cancel(this.a.getDownloadId());
        return Unit.INSTANCE;
    }
}
