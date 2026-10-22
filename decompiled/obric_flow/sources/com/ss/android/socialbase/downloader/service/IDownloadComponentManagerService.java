package com.ss.android.socialbase.downloader.service;

import android.content.Context;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.downloader.DownloaderBuilder;
import com.ss.android.socialbase.downloader.downloader.ITTNetHandler;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface IDownloadComponentManagerService {

    public static class DefaultDownloadComponentManagerService implements IDownloadComponentManagerService {
        public DefaultDownloadComponentManagerService() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public final void a(Context r5) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public final boolean b() {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public final JSONObject c() {
            return DownloadConstants.f15276b;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public final void d() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public final Context e() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public final IDownloadInterceptor f() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public final void a(DownloaderBuilder r5) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public final void a(Runnable r5) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public final ITTNetHandler a() {
            return new ITTNetHandler.DefaultTTNetHandler();
        }
    }

    ITTNetHandler a();

    void a(Context r5);

    void a(DownloaderBuilder r5);

    void a(Runnable r5);

    boolean b();

    JSONObject c();

    void d();

    Context e();

    IDownloadInterceptor f();
}
