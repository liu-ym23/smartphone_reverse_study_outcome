package com.bytedance.android.live.liveinteract.digitavatar.videoavatar;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f extends AbsDownloadListener {
    public final /* synthetic */ e a;

    public f(e r1) {
        this.a = r1;
    }

    public final void onCanceled(DownloadInfo r1) {
        super.onCanceled(r1);
    }

    public final void onSuccessed(DownloadInfo r3) {
        super.onSuccessed(r3);
        ALogger.i("KtvDigitAvatar", "download image success");
        if (r3 == null) goto L8;
        String r4 = r3.getTargetFilePath();
        if (r4 == null) goto L9;
        new PolarisFileWrapper(r4);
        this.a.getClass();
        this.a.getClass();
        return;
    L9:
        return;
    }

    public final void onFailed(DownloadInfo r2, BaseException r3) {
        super.onFailed(r2, r3);
        ALogger.e("KtvDigitAvatar", "download image fail", r3);
    }
}
