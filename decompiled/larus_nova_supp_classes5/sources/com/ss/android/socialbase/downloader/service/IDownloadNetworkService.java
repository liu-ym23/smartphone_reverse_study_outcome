package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface IDownloadNetworkService {
    IDownloadHttpConnection downloadWithConnection(boolean r1, int r2, String r3, String r4, List<HttpHeader> r5, int r6, boolean r7, DownloadInfo r8) throws Exception;

    IDownloadHttpConnection downloadWithConnection(boolean r1, int r2, String r3, List<HttpHeader> r4) throws Exception;
}
