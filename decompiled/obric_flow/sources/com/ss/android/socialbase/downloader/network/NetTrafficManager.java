package com.ss.android.socialbase.downloader.network;

import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService;

/* JADX INFO: loaded from: classes3.dex */
public class NetTrafficManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IDownloadNetTrafficManagerService f15963a;

    public static class ConnectionClassManagerHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NetTrafficManager f15964a = null;

        static {
            f15964a = new NetTrafficManager();
        }
    }

    public NetTrafficManager() {
        this.f15963a = (IDownloadNetTrafficManagerService) DownloadServiceManager.a(IDownloadNetTrafficManagerService.class);
    }
}
