package com.larus.bmhome.music.save_video;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class o implements Function1<Throwable, Unit> {
    public final /* synthetic */ DownloadTask a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ Ref.ObjectRef<Job> d;

    public o(DownloadTask r1, String r2, Context r3, Ref.ObjectRef<Job> r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final Object invoke(Object r3) {
        Throwable r4 = (Throwable) r3;
        FLogger.a.i("save_music_video", "Download audio cancel, downloadId = " + this.a.getDownloadId() + ", downloadTaskKey is " + this.b);
        Downloader.getInstance(this.c).cancel(this.a.getDownloadId());
        Job r5 = (Job) this.d.element;
        if (r5 == null) goto L6;
        Job.DefaultImpls.cancel$default(r5, null, 1, null);
    L6:
        return Unit.INSTANCE;
    }
}
