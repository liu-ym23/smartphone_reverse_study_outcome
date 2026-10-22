package com.bytedance.android.live.ktv.common.music.download;

import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l extends AbsDownloadListener {
    public final /* synthetic */ WeakReference a;
    public final /* synthetic */ k.c b;
    public final /* synthetic */ Ref.IntRef c;

    public final void onSuccessed(DownloadInfo r5) {
        super.onSuccessed(r5);
        k.b r6 = (k.b) this.a.get();
        if (r6 == null) goto L6;
        k.c r0 = this.b;
        r6.a(r0.a, r0.c, this.c.element);
        return;
    }

    public final void onFailed(DownloadInfo r3, BaseException r4) {
        Intrinsics.checkNotNullParameter(r4, "e");
        super.onFailed(r3, r4);
        k.b r5 = (k.b) this.a.get();
        if (r5 == null) goto L9;
        long r0 = this.b.a;
        r4.getErrorCode();
        String r6 = r4.getErrorMessage();
        if (r6 != null) goto L7;
        r6 = "";
    L7:
        r5.onFailed(r6, this.c.element);
        return;
    }

    public l(WeakReference r1, k.c r2, Ref.IntRef r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
