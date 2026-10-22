package com.ss.android.socialbase.downloader.service;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.IDownloadIdGenerator;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class DownloadIdGeneratorService implements IDownloadIdGeneratorService {
    private IDownloadIdGenerator mDownloadIdGenerator;

    public DownloadIdGeneratorService() {
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadIdGeneratorService, com.ss.android.socialbase.downloader.downloader.IDownloadIdGenerator
    public boolean isDefaultIdGenerator() {
        if (this.mDownloadIdGenerator != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadIdGeneratorService
    public int generate(DownloadInfo r3) {
        if (r3 != null) goto L5;
        return 0;
    L5:
        String r0 = r3.getTaskKey();
        if (TextUtils.isEmpty(r0) == false) goto L9;
        r0 = r3.getUrl();
    L9:
        return generate(r0, r3.getSavePath());
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadIdGeneratorService
    public void setDownloadIdGenerator(IDownloadIdGenerator r1) {
        this.mDownloadIdGenerator = r1;
    }

    private int generateImpl(String r3, String r4) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
    L15:
        return 0;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L15;
        if (DownloadFileUtils.isMediaUri(r4) == false) goto L10;
        r4 = DownloadFileUtils.getContentUriString(r4);
    L10:
        String r5 = DownloadUtils.md5Hex(r3 + "_" + r4);
        if (TextUtils.isEmpty(r5) == false) goto L14;
        return 0;
    L14:
        return r5.hashCode();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadIdGenerator
    public int generate(String r2, String r3) {
        IDownloadIdGenerator r0 = this.mDownloadIdGenerator;
        if (r0 == null) goto L7;
        return r0.generate(r2, r3);
    L7:
        return generateImpl(r2, r3);
    }
}
