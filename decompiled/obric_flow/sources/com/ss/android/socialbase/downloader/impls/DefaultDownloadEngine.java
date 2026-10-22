package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.core.DownloadRunnable;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.DownloadTimingInfo;
import com.ss.android.socialbase.downloader.thread.DownloadThreadPool;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultDownloadEngine extends AbsDownloadEngine {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static DownloadThreadPool f15686l;

    public DefaultDownloadEngine() {
        f15686l = new DownloadThreadPool();
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public final void a(DownloadRunnable r5) {
        Iterator r10 = f15686l.f16114a.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L12;
        if (((Map.Entry) r10.next()).getValue() != r5) goto L4;
        r10.remove();
        return;
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public final void b(int r5) {
        f15686l.b(r5);
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public final boolean i(int r5) {
        DownloadRunnable r10 = (DownloadRunnable) f15686l.f16114a.get(Integer.valueOf(r5));
        if (r10 != null) goto L5;
    L14:
        return false;
    L5:
        if (r10.f15294a.g == false) goto L14;
        DownloadInfo r11 = d(r5);
        if (r11 != null) goto L10;
        return false;
    L10:
        if (DownloadStatus.a(r11.o()) == true) goto L12;
        return false;
    L12:
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public final DownloadRunnable a(int r5) {
        return f15686l.a(r5);
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public final ArrayList a() {
        DownloadThreadPool r5 = f15686l;
        r5.a();
        return new ArrayList(r5.f16114a.keySet());
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public final void a(int r5, long r10, int r11) {
        DownloadRunnable r12 = (DownloadRunnable) f15686l.f16114a.get(Integer.valueOf(r5));
        if (r12 == null) goto L6;
        r12.f15295b.a(r10, r11);
        return;
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public final Future a(DownloadTask r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if (Logger.a(r5.f15878a) == false) goto L8;
        Logger.a("DefaultDownloadEngine", r5.f15878a, "doDownload", "start doDownload for task");
    L8:
        DownloadTimingInfo r10 = r5.s;
        r10.d = System.currentTimeMillis();
        return f15686l.a(new DownloadRunnable(r5, this.f15626k));
    }
}
