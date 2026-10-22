package com.bytedance.android.live.ktv.common.music.download;

import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j extends AbsDownloadListener {
    public final /* synthetic */ ub0.c a;
    public final /* synthetic */ long b;
    public final /* synthetic */ i.a c;

    public final void onSuccessed(DownloadInfo r9) {
        super.onSuccessed(r9);
        ub0.c r11 = this.a;
        long r1 = r11.b;
        String r3 = r11.a;
        long r4 = System.currentTimeMillis() - this.b;
        mb0.c r12 = mb0.d.a;
        Intrinsics.checkNotNullParameter(r3, LiveSlardarConstants.EXTRA_KEY_URL);
        mb0.c r0 = mb0.d.a;
        if (r0 == null) goto L5;
        r0.g(r1, r3, r4);
    L5:
        this.c.b(this.a);
    }

    public final void onFailed(DownloadInfo r7, BaseException r8) {
        Intrinsics.checkNotNullParameter(r8, "e");
        super.onFailed(r7, r8);
        ub0.c r9 = this.a;
        long r1 = r9.b;
        String r3 = r9.a;
        int r4 = r8.getErrorCode();
        String r5 = r8.getErrorMessage();
        mb0.c r11 = mb0.d.a;
        Intrinsics.checkNotNullParameter(r3, LiveSlardarConstants.EXTRA_KEY_URL);
        Intrinsics.checkNotNullParameter(r5, "errorMsg");
        mb0.c r0 = mb0.d.a;
        if (r0 == null) goto L5;
        r0.c(r1, r3, r4, r5);
    L5:
        i.a r12 = this.c;
        long r2 = this.a.b;
        int r6 = r8.getErrorCode();
        String r13 = r8.getErrorMessage();
        if (r13 != null) goto L8;
        r13 = "";
    L8:
        r12.a(r2, r6, r13);
    }

    public j(ub0.c r1, long r2, i.a r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }
}
