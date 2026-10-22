package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public interface o {

    public static class a implements o {
        public a() {
        }

        @Override // com.ss.android.socialbase.downloader.service.o
        public void a(IDownloadMonitorDepend r1, DownloadInfo r2, BaseException r3, int r4) {
            IDownloadMonitorDepend r0 = (IDownloadMonitorDepend) ZeusTransformUtils.wrapperContextForParams(r1, IDownloadMonitorDepend.class, "com.obric.memorydata.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.service.o
        public void a(DownloadTask r1, BaseException r2, int r3) {
        }
    }

    void a(IDownloadMonitorDepend r1, DownloadInfo r2, BaseException r3, int r4);

    void a(DownloadTask r1, BaseException r2, int r3);
}
