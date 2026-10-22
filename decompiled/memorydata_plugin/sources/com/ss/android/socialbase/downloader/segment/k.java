package com.ss.android.socialbase.downloader.segment;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
class k implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i f15626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.model.g f15627b;
    private final e c;

    public k(DownloadInfo r1, b r2, i r3) {
        this.f15626a = r3;
        this.f15627b = a(r1, r3);
        this.c = new h(r2, this);
    }

    private com.ss.android.socialbase.downloader.model.g a(DownloadInfo r5, i r6) {
        com.ss.android.socialbase.downloader.model.g r4 = com.ss.android.socialbase.downloader.utils.c.a(r5, r5.getTempPath(), r5.getTempName(), com.ss.android.socialbase.downloader.g.a.a(r5.getId()).a("flush_buffer_size_byte", -1), false);
        long r0 = r5.getStartOffset();
        if (r0 >= 0) goto L10;
        r0 = 0;
    L10:
        r4.a(r6.e() - r0);     // Catch: IOException -> L7
        return r4;
    L7:
        e = move-exception;
        throw new BaseException(1054, e);
    }

    public e a() {
        return this.c;
    }

    public void b() {
        this.f15627b.a();
    }

    @Override // com.ss.android.socialbase.downloader.segment.e
    public void b(a r5) {
        this.f15627b.a(r5.f15611a, 0, r5.c);
        this.f15626a.b(r5.c);
    }

    public void c() {
        this.f15627b.b();
    }

    public void d() {
        com.ss.android.socialbase.downloader.utils.g.a(new Closeable[]{this.f15627b});
    }

    public i e() {
        return this.f15626a;
    }
}
