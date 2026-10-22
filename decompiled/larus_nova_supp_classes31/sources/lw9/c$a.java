package lw9;

import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import in7.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c$a implements IDownloadListener {
    public final /* synthetic */ d a;

    public final void onFirstStart(DownloadInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "entity");
    }

    public final void onFirstSuccess(DownloadInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "entity");
    }

    public final void onPrepare(DownloadInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "entity");
    }

    public final void onRetry(DownloadInfo r2, BaseException r3) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        Intrinsics.checkNotNullParameter(r3, "e");
    }

    public final void onRetryDelay(DownloadInfo r2, BaseException r3) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        Intrinsics.checkNotNullParameter(r3, "e");
    }

    public c$a(d r1) {
        this.a = r1;
    }

    public final void onCanceled(DownloadInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        this.a.onCanceled();
    }

    public final void onPause(DownloadInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        this.a.onStart();
    }

    public final void onProgress(DownloadInfo r8) {
        Intrinsics.checkNotNullParameter(r8, "entity");
        Long r0 = Long.valueOf(r8.getTotalBytes());
        if (r0.longValue() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L9;
        r0 = null;
    L9:
        if (r0 == null) goto L12;
        long r2 = r0.longValue();
        this.a.onProgress((int) ((r8.getCurBytes() * ((long) 100)) / r2));
        return;
    L12:
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final void onStart(DownloadInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        this.a.onStart();
    }

    public final void onSuccessed(DownloadInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        this.a.a();
    }

    public final void onFailed(DownloadInfo r2, BaseException r3) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        Intrinsics.checkNotNullParameter(r3, "e");
        this.a.onFailed();
    }
}
