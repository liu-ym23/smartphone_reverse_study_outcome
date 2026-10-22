package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface IDownloadProcessDispatcherService {

    public static class DefaultDownloadProcessDispatcherService implements IDownloadProcessDispatcherService {
        public DefaultDownloadProcessDispatcherService() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public final DownloadInfo a(int r5) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public final List b(String r5) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public final void e(int r5) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public final boolean f(int r5) {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public final void g(int r5) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public final DownloadInfo a(String r5, String r10) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public final void b() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public final Map a(String r5) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public final void b(int r5) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public final void a(int r5, AbsDownloadListener r10, ListenerType r11) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public final void b(ArrayList r5) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public final void a(int r5, IDownloadListener r10, ListenerType r11) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public final void a(DownloadTask r5) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public final void a(ArrayList r5) {
        }
    }

    DownloadInfo a(int r5);

    DownloadInfo a(String r5, String r10);

    Map a(String r5);

    void a(int r5, AbsDownloadListener r10, ListenerType r11);

    void a(int r5, IDownloadListener r10, ListenerType r11);

    void a(DownloadTask r5);

    void a(ArrayList r5);

    List b(String r5);

    void b();

    void b(int r5);

    void b(ArrayList r5);

    void e(int r5);

    boolean f(int r5);

    void g(int r5);
}
