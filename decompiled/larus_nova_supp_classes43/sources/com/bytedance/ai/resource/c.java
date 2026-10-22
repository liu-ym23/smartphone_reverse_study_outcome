package com.bytedance.ai.resource;

import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c extends AbsDownloadListener {
    public final /* synthetic */ a.InterfaceC0047a a;

    public c(b r1) {
        this.a = r1;
    }

    public final void onProgress(DownloadInfo r10) {
        a.InterfaceC0047a r0 = this.a;
        if (r10 == null) goto L5;
        r10.getDownloadProcess();
    L5:
        if (r10 == null) goto L7;
        r10.getUrl();
    L7:
        r0.a();
    }

    public final void onSuccessed(DownloadInfo r10) {
        if (r10 == null) goto L5;
        String r11 = r10.getUrl();
        if (r11 == null) goto L5;
    L6:
        this.a.onSuccess();
        com.bytedance.ai.utils.g.a.i("AIDownloadManager", "download successes, url = ".concat(r11));
        return;
    L5:
        r11 = "";
        goto L6
    }

    public final void onFailed(DownloadInfo r10, BaseException r11) {
        String r12 = null;
        if (r10 == null) goto L5;
        BaseException r0 = r10.getFailedException();
    L6:
        a.InterfaceC0047a r1 = this.a;
        if (r0 == null) goto L9;
        r0.getErrorMessage();
    L9:
        if (r10 == null) goto L11;
        r10.getUrl();
    L11:
        r1.onFailed();
        com.bytedance.ai.utils.g r13 = com.bytedance.ai.utils.g.a;
        StringBuilder r14 = new StringBuilder("Failed to download , status=");
        if (r10 == null) goto L14;
        Integer r15 = Integer.valueOf(r10.getStatus());
    L15:
        r14.append(r15);
        r14.append(", code=");
        if (r0 == null) goto L18;
        Integer r16 = Integer.valueOf(r0.getErrorCode());
    L19:
        r14.append(r16);
        r14.append(", msg=");
        if (r0 == null) goto L22;
        r12 = r0.getErrorMessage();
    L22:
        r14.append(r12);
        r13.w("AIDownloadManager", r14.toString());
        return;
    L18:
        r16 = null;
        goto L19
    L14:
        r15 = null;
        goto L15
    L5:
        r0 = null;
        goto L6
    }
}
