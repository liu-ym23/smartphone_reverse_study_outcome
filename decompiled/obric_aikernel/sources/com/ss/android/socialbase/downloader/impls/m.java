package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.model.DownloadInfo;
import qb.u;

/* JADX INFO: loaded from: classes2.dex */
public class m implements u {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile m f8058b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private u f8059a;

    public interface a {
        void a(DownloadInfo r10, long r11, boolean r12, int r13);
    }

    private m() {
        this.f8059a = (u) qb.k.a(u.class);
    }

    public static m d() {
        if (f8058b != null) goto L15;
        monitor-enter(m.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f8058b != null) goto L9;
        f8058b = new m();     // Catch: Throwable -> L11
    L9:
        monitor-exit(m.class);     // Catch: Throwable -> L11
    L15:
        return f8058b;
    }

    @Override // qb.u
    public void a() {
        this.f8059a.a();
    }

    @Override // qb.u
    public void b(DownloadInfo r10) {
        this.f8059a.b(r10);
    }

    @Override // qb.u
    public void c() {
        this.f8059a.c();
    }
}
