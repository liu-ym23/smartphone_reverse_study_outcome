package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils;

import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e extends AbsDownloadListener {
    public final /* synthetic */ d.a a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public final void onSuccessed(DownloadInfo r3) {
        super.onSuccessed(r3);
        d.a r0 = this.a;
        if (r0 == null) goto L11;
        String r1 = this.b;
        if (r3 == null) goto L8;
        String r4 = r3.getTargetFilePath();
        if (r4 == null) goto L8;
    L9:
        r0.a(r1, r4);
        return;
    L8:
        r4 = this.c;
        goto L9
    }

    public final void onFailed(DownloadInfo r2, BaseException r3) {
        super.onFailed(r2, r3);
        d.a r4 = this.a;
        if (r4 == null) goto L11;
        String r0 = this.b;
        if (r2 == null) goto L8;
        String r5 = r2.getTargetFilePath();
        if (r5 == null) goto L8;
    L9:
        r4.onFail(r0, r5);
        return;
    L8:
        r5 = this.c;
        goto L9
    }

    public e(d.a r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
