package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public interface IDownloadNetworkService {

    public static class DefaultDownloadNetworkService implements IDownloadNetworkService {
        public DefaultDownloadNetworkService() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadNetworkService
        public final IDownloadHttpConnection a(boolean r5, int r10, String r11, String r12, ArrayList r13, int r14, boolean r15, DownloadInfo r16) {
            return null;
        }
    }

    IDownloadHttpConnection a(boolean r5, int r10, String r11, String r12, ArrayList r13, int r14, boolean r15, DownloadInfo r16);
}
