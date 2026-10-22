package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface r {

    public static class a implements r {
        public a() {
        }

        @Override // com.ss.android.socialbase.downloader.service.r
        public com.ss.android.socialbase.downloader.network.h a(boolean r1, int r2, String r3, String r4, List<HttpHeader> r5, int r6, boolean r7, DownloadInfo r8) {
            List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            return null;
        }
    }

    com.ss.android.socialbase.downloader.network.h a(boolean r1, int r2, String r3, String r4, List<HttpHeader> r5, int r6, boolean r7, DownloadInfo r8);
}
