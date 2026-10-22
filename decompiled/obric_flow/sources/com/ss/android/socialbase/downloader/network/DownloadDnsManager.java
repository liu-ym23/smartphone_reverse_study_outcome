package com.ss.android.socialbase.downloader.network;

import android.os.Handler;
import android.os.HandlerThread;
import com.ss.android.socialbase.downloader.segment.SegmentDispatcher;
import com.ss.android.socialbase.downloader.thread.DownloadWatchDog;
import com.ss.android.socialbase.downloader.utils.LruCache;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadDnsManager {
    public static volatile DownloadDnsManager d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LruCache f15949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f15950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f15951c;

    public static class DnsRecord {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List f15958a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f15959b;

        public DnsRecord() {
        }
    }

    public DownloadDnsManager() {
        this.f15949a = new LruCache();
        HandlerThread r5 = new HandlerThread("Network-Handler");
        r5.start();
        this.f15950b = new Handler(r5.getLooper());
        this.f15951c = new Handler(DownloadWatchDog.a());
    }

    public final void a(final String r5, final SegmentDispatcher r10) {
        this.f15950b.post(new AnonymousClass1(this, r5, r10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(String r5, List r10) {
        LruCache r11 = this.f15949a;
        monitor-enter(r11);
        DnsRecord r12 = (DnsRecord) this.f15949a.get(r5);     // Catch: Throwable -> L7
        if (r12 != null) goto L9;
        r12 = new DnsRecord();     // Catch: Throwable -> L7
        this.f15949a.put(r5, r12);     // Catch: Throwable -> L7
    L9:
        r12.f15958a = r10;     // Catch: Throwable -> L7
        r12.f15959b = System.currentTimeMillis();     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
