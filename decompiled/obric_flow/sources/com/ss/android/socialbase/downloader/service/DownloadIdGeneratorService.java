package com.ss.android.socialbase.downloader.service;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadIdGeneratorService implements IDownloadIdGeneratorService {
    public DownloadIdGeneratorService() {
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadIdGeneratorService
    public final boolean a() {
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadIdGenerator
    public final int a(String r5, String r10) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
    L15:
        return 0;
    L5:
        if (TextUtils.isEmpty(r10) == true) goto L15;
        if (DownloadFileUtils.e(r10) == false) goto L10;
        r10 = DownloadFileUtils.a(r10);
    L10:
        String r11 = DownloadUtils.c(r5 + "_" + r10);
        if (TextUtils.isEmpty(r11) == false) goto L14;
        return 0;
    L14:
        return r11.hashCode();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadIdGeneratorService
    public final int a(DownloadInfo r5) {
        if (r5 != null) goto L5;
        return 0;
    L5:
        r5.d();
        String r10 = r5.T0.optString("task_key");
        if (TextUtils.isEmpty(r10) == false) goto L9;
        r10 = r5.d;
    L9:
        return a(r10, r5.e);
    }
}
