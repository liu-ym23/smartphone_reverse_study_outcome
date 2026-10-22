package com.ss.android.socialbase.downloader.core.module.pcdn;

import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class PCDNChunkProgressManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DownloadPCDNSegmentModule f15350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IDownloadCache f15351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DownloadInfo f15352c;
    public final HashMap d;
    public int e;

    public class ChunkCacheItem {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f15353a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f15354b;

        public ChunkCacheItem() {
        }
    }

    public PCDNChunkProgressManager(DownloadPCDNSegmentModule r5, IDownloadCache r10, DownloadInfo r11) {
        this.d = new HashMap();
        this.f15350a = r5;
        this.f15351b = r10;
        this.f15352c = r11;
    }

    public final void a(int r10) {
        monitor-enter(this);
        int r5 = this.e;     // Catch: Throwable -> L8
        if (r10 != r5) goto L6;
        this.e = r5 + 1;     // Catch: Throwable -> L8
        long r11 = 0;
    L13:
        ChunkCacheItem r12 = (ChunkCacheItem) this.d.get(Integer.valueOf(this.e));     // Catch: Throwable -> L8
        if (r12 == null) goto L20;
        r11 = r11 + r12.f15353a;     // Catch: Throwable -> L8
        if (r12.f15354b == false) goto L18;
        this.d.remove(Integer.valueOf(this.e));     // Catch: Throwable -> L8
        this.e++;     // Catch: Throwable -> L8
        goto L13
    L18:
        r12.f15353a = 0;     // Catch: Throwable -> L8
        this.d.put(Integer.valueOf(this.e), r12);     // Catch: Throwable -> L8
    L20:
        if (r11 > 0) goto L32;
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L32:
        this.f15350a.a(r11);     // Catch: Throwable -> L25
        this.f15352c.a(true);     // Catch: Throwable -> L25
        this.f15351b.a(this.f15352c);     // Catch: Throwable -> L25
    L27:
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L25:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L8
        goto L27
    L6:
        if (this.d.containsKey(Integer.valueOf(r10)) == false) goto L10;
        ChunkCacheItem r13 = (ChunkCacheItem) this.d.get(Integer.valueOf(r10));     // Catch: Throwable -> L8
        r13.f15354b = true;     // Catch: Throwable -> L8
        this.d.put(Integer.valueOf(r10), r13);     // Catch: Throwable -> L8
    L10:
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
