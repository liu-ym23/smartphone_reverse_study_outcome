package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class d implements o {
    public d() {
    }

    @Override // com.ss.android.socialbase.downloader.service.o
    public void a(IDownloadMonitorDepend r2, DownloadInfo r3, BaseException r4, int r5) {
        com.ss.android.socialbase.downloader.f.a.a((IDownloadMonitorDepend) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadMonitorDepend.class, "com.obric.memorydata.plugin"), r3, r4, r5);
    }

    @Override // com.ss.android.socialbase.downloader.service.o
    public void a(DownloadTask r1, BaseException r2, int r3) {
        com.ss.android.socialbase.downloader.f.a.a(r1, r2, r3);
    }
}
