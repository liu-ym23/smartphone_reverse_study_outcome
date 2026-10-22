package com.ss.android.socialbase.downloader.downloader;

import com.ss.android.socialbase.downloader.exception.DownloadTTNetException;
import nb.i;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public interface b {

    public static class a implements b {
        public a() {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.b
        public boolean a() {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.b
        public int b(Throwable r10) {
            return -1;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.b
        public void c() {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.b
        public i d() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.b
        public JSONArray e() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.b
        public DownloadTTNetException f(Throwable r10, String r11) {
            return null;
        }
    }

    boolean a();

    int b(Throwable r10);

    void c();

    i d();

    JSONArray e();

    DownloadTTNetException f(Throwable r10, String r11);
}
