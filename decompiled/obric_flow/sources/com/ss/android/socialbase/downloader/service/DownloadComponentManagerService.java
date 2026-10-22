package com.ss.android.socialbase.downloader.service;

import android.content.Context;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloaderBuilder;
import com.ss.android.socialbase.downloader.downloader.ITTNetHandler;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadComponentManagerService implements IDownloadComponentManagerService {
    public DownloadComponentManagerService() {
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public final void a(Context r5) {
        DownloadComponentManager.a(r5);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public final boolean b() {
        return DownloadComponentManager.H;
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public final JSONObject c() {
        Context r5 = DownloadComponentManager.f15515a;
        return DownloadConstants.f15276b;
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public final void d() {
        Context r5 = DownloadComponentManager.f15515a;
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public final Context e() {
        monitor-enter(DownloadComponentManager.class);
        Context r5 = DownloadComponentManager.f15515a;     // Catch: Throwable -> L7
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L7
        return r5;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public final IDownloadInterceptor f() {
        Context r5 = DownloadComponentManager.f15515a;
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public final void a(DownloaderBuilder r5) {
        DownloadComponentManager.a(r5);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public final ITTNetHandler a() {
        return DownloadComponentManager.s();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
    public final void a(Runnable r5) {
        DownloadComponentManager.b(r5);
    }
}
