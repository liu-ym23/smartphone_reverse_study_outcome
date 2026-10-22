package com.ss.android.socialbase.downloader.downloader;

import com.ss.android.socialbase.downloader.exception.DownloadTTNetException;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes6.dex */
public interface t {

    public static class a implements t {
        public a() {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.t
        public int a(Throwable r1) {
            return -1;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.t
        public DownloadTTNetException a(Throwable r1, String r2) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.t
        public void a(String[] r1) {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.t
        public void a(String[] r1, long r2) {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.t
        public boolean a() {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.t
        public com.ss.android.socialbase.downloader.network.i b() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.t
        public void c() {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.t
        public JSONArray d() {
            return null;
        }
    }

    int a(Throwable r1);

    DownloadTTNetException a(Throwable r1, String r2);

    void a(String[] r1);

    void a(String[] r1, long r2);

    boolean a();

    com.ss.android.socialbase.downloader.network.i b();

    void c();

    JSONArray d();
}
