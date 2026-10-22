package com.larus.bmhome.music.save_video;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import kotlin.Result;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class p extends AbsDownloadListener {
    public final /* synthetic */ String a;
    public final /* synthetic */ kotlinx.coroutines.i<String> b;
    public final /* synthetic */ Ref.ObjectRef<Job> c;
    public final /* synthetic */ String d;
    public final /* synthetic */ Context e;
    public final /* synthetic */ Ref.IntRef f;

    public final void onCanceled(DownloadInfo r3) {
        super.onCanceled(r3);
        FLogger.a.i("save_music_video", "Download audio canceled, downloadTaskKey " + this.a);
        Job r4 = (Job) this.c.element;
        if (r4 == null) goto L6;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
        return;
    }

    public final void onProgress(DownloadInfo r5) {
        super.onProgress(r5);
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("Download audio progress: ");
        if (r5 == null) goto L5;
        Integer r6 = Integer.valueOf(r5.getDownloadProcess());
    L6:
        r1.append(r6);
        r0.i("save_music_video", r1.toString());
        MusicVideoSaver.a(this.c, this.b, this.a, this.e, this.f);
        return;
    L5:
        r6 = null;
        goto L6
    }

    public final void onStart(DownloadInfo r5) {
        super.onStart(r5);
        FLogger.a.i("save_music_video", "Download audio start");
        MusicVideoSaver.a(this.c, this.b, this.a, this.e, this.f);
    }

    public final void onSuccessed(DownloadInfo r5) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("Download audio success, path is ");
        if (r5 == null) goto L5;
        String r3 = r5.getTargetFilePath();
    L6:
        r1.append(r3);
        r1.append(", downloadTaskKey is ");
        r1.append(this.a);
        r0.i("save_music_video", r1.toString());
        if (this.b.isActive() == false) goto L13;
        kotlinx.coroutines.i<String> r2 = this.b;
        Result.Companion r4 = Result.Companion;
        if (r5 == null) goto L11;
        String r6 = r5.getTargetFilePath();
    L12:
        r2.resumeWith(Result.constructor-impl(r6));
        goto L13
    L11:
        r6 = null;
    L13:
        Job r7 = (Job) this.c.element;
        if (r7 == null) goto L16;
        Job.DefaultImpls.cancel$default(r7, null, 1, null);
    L16:
        MusicVideoSaver r8 = MusicVideoSaver.a;
        MusicVideoSaver.h(this.a, this.d, true, null);
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void onFailed(DownloadInfo r4, BaseException r5) {
        FLogger r6 = FLogger.a;
        StringBuilder r0 = new StringBuilder("Download audio failed: ");
        String r1 = null;
        if (r5 == null) goto L5;
        String r2 = r5.getMessage();
    L6:
        r0.append(r2);
        r0.append(", downloadTaskKey is ");
        r0.append(this.a);
        r6.e("save_music_video", r0.toString());
        if (this.b.isActive() == false) goto L9;
        this.b.resumeWith(Result.constructor-impl(null));
    L9:
        Job r7 = (Job) this.c.element;
        if (r7 == null) goto L12;
        Job.DefaultImpls.cancel$default(r7, null, 1, null);
    L12:
        MusicVideoSaver r8 = MusicVideoSaver.a;
        String r9 = this.a;
        String r3 = this.d;
        if (r5 == null) goto L15;
        r1 = r5.getMessage();
    L15:
        MusicVideoSaver.h(r9, r3, false, r1);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void onRetry(DownloadInfo r4, BaseException r5) {
        super.onRetry(r4, r5);
        FLogger r6 = FLogger.a;
        StringBuilder r0 = new StringBuilder("Download audio retry: ");
        if (r4 == null) goto L5;
        Integer r7 = Integer.valueOf(r4.getRetryCount());
    L6:
        r0.append(r7);
        r6.i("save_music_video", r0.toString());
        MusicVideoSaver.a(this.c, this.b, this.a, this.e, this.f);
        return;
    L5:
        r7 = null;
        goto L6
    }

    public p(String r1, kotlinx.coroutines.j r2, Ref.ObjectRef r3, String r4, Context r5, Ref.IntRef r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
