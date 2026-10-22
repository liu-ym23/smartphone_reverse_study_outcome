package com.ss.android.socialbase.downloader.db;

import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class EmptySqlDownloadCache implements ISqlDownloadCache {
    public EmptySqlDownloadCache() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final DownloadInfo a(int r5) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final DownloadInfo b(int r5, long r10) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final DownloadInfo c(int r5, long r10) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final DownloadInfo d(int r5, long r10) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final DownloadInfo e(int r5) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final DownloadInfo h(int r5) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final DownloadInfo j(int r5) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final DownloadInfo k(int r5) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final List o(int r5) {
        return new ArrayList();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final void q(int r5) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final Map r(int r5) {
        return new HashMap();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final DownloadInfo a(int r5, long r10) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final void b(DownloadInfo r5) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final void c(int r5) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final boolean d(int r5) {
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final boolean e() {
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final DownloadInfo a(int r5, long r10, String r11, String r12) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final boolean b(int r5) {
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final boolean c() {
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final List d(String r5) {
        return new ArrayList();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final void a() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final List b(String r5) {
        return new ArrayList();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final List c(String r5) {
        return new ArrayList();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final List d() {
        return new ArrayList();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final boolean a(int r5, Map r10) {
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final boolean a(DownloadInfo r5) {
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final List a(String r5) {
        return new ArrayList();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final List a(String r5, String r10) {
        return new ArrayList();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache
    public final void a(SparseArray r5, HashMap r10, List r11, List r12, SqlCacheLoadCompleteCallback r13) {
        r13.a(true);
    }
}
