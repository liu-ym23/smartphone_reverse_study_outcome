package com.ss.android.socialbase.downloader.b.a.d;

import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes6.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DownloadInfo f15257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f15258b;
    private int c;
    private long d;

    public d(DownloadInfo r3, long r4) {
        this.f15257a = r3;
        this.f15258b = r4;
        this.d = com.ss.android.socialbase.downloader.utils.c.a(r3) + r3.getStartOffset();
    }

    public c a() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.d >= this.f15257a.getTotalBytes()) goto L6;
        c r0 = new c();     // Catch: Throwable -> L15
        r0.f15255a = this.c;     // Catch: Throwable -> L15
        r0.f15256b = this.d;     // Catch: Throwable -> L15
        long r1 = (this.d + this.f15258b) - 1;     // Catch: Throwable -> L15
        if (r1 >= this.f15257a.getTotalBytes()) goto L11;
        r0.c = r1;     // Catch: Throwable -> L15
    L12:
        this.d += this.f15258b;     // Catch: Throwable -> L15
        this.c++;     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        return r0;
    L11:
        r0.c = (this.f15257a.getStartOffset() + this.f15257a.getTotalBytes()) - 1;     // Catch: Throwable -> L15
        goto L12
    L6:
        monitor-exit(this);     // Catch: Throwable -> L15
        return null;
    }
}
