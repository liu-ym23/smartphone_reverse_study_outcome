package com.ss.android.socialbase.downloader.core.module.pcdn;

import com.ss.android.socialbase.downloader.core.DownloadSingleResponseHandler;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class PCDNStats {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DownloadInfo f15372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f15373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f15374c;
    public long d;
    public long e;
    public final int f;
    public final LinkedHashMap g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f15375h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f15376i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f15377j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f15378k;

    public class UrlStats {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f15379a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f15380b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f15381c;
        public long d;
        public long e;
        public int f;
        public int g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f15382h;

        public UrlStats() {
        }
    }

    public PCDNStats(DownloadInfo r5, int r10) {
        this.g = new LinkedHashMap();
        this.f15377j = 0;
        this.f15378k = 0;
        this.f15372a = r5;
        r5.R0 = null;
        this.f = r10;
    }

    public final void a(String r15, long r16, boolean r18, boolean r19, IDownloadHttpConnection r20, DownloadSingleResponseHandler r21, Throwable r22) {
        monitor-enter(this);
        if (r21 != null) goto L15;
        long r5 = 0;
    L6:
        long r10 = r5;
        long r12 = System.currentTimeMillis();     // Catch: Throwable -> L7
        a(r12, r15, r20, r22, r19, r10);     // Catch: Throwable -> L7
        a(r12, r18, r10);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    L15:
        r5 = r21.f - r16;     // Catch: Throwable -> L7
        goto L6
    }

    public final void a(long r5, String r10, IDownloadHttpConnection r11, Throwable r12, boolean r13, long r14) {
        UrlStats r15 = (UrlStats) this.g.get(r10);
        if (r15.f != 0) goto L8;
        if (r11 == null) goto L8;
        if ((r11 instanceof AbsDownloadHttpConnection) == false) goto L8;
        AbsDownloadHttpConnection r16 = (AbsDownloadHttpConnection) r11;
        r15.f = 1;
    L8:
        if (r12 == null) goto L15;
        if (r13 == true) goto L15;
        if ((r12 instanceof BaseException) == false) goto L13;
        r15.f15380b = ((BaseException) r12).f15601a;
    L14:
        r15.f15381c = r12.toString();
    L20:
        int r17 = r15.g - 1;
        r15.g = r17;
        r15.e = (r5 - r15.f15382h) + r15.e;
        if (r17 != 0) goto L23;
        r15.f15382h = 0;
    L24:
        r15.d += r14;
        this.g.put(r10, r15);
        return;
    L23:
        r15.f15382h = r5;
        goto L24
    L13:
        r15.f15380b = 1000;
    L15:
        if (r11 == null) goto L20;
        r15.f15380b = r11.b();     // Catch: Throwable -> L18
        r15.f15381c = "";     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        th.printStackTrace();
        goto L20
    }

    public final void a(long r5, boolean r10, long r11) {
        if (r10 == false) goto L10;
        int r12 = this.f15378k - 1;
        this.f15378k = r12;
        this.f15373b += r11;
        this.d = (r5 - this.f15375h) + this.d;
        if (r12 != 0) goto L8;
        this.f15375h = 0;
        return;
    L8:
        this.f15375h = r5;
        return;
    L10:
        int r13 = this.f15377j - 1;
        this.f15377j = r13;
        this.f15374c += r11;
        this.e = (r5 - this.f15376i) + this.e;
        if (r13 != 0) goto L14;
        this.f15376i = 0;
        return;
    L14:
        this.f15376i = r5;
    }
}
