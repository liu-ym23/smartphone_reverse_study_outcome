package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public interface n extends com.ss.android.socialbase.downloader.downloader.i {

    public static class a implements n {
        public a() {
        }

        @Override // com.ss.android.socialbase.downloader.service.n
        public int a(DownloadInfo r1) {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.i
        public int a(String r1, String r2) {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.service.n
        public void a(com.ss.android.socialbase.downloader.downloader.i r2) {
            com.ss.android.socialbase.downloader.downloader.i r1 = (com.ss.android.socialbase.downloader.downloader.i) ZeusTransformUtils.wrapperContextForParams(r2, com.ss.android.socialbase.downloader.downloader.i.class, "com.obric.memorydata.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.service.n
        public boolean a() {
            return true;
        }
    }

    int a(DownloadInfo r1);

    void a(com.ss.android.socialbase.downloader.downloader.i r1);

    boolean a();
}
