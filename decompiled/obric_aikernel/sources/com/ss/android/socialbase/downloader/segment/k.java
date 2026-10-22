package com.ss.android.socialbase.downloader.segment;

import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
class k implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i f8280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.model.h f8281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e f8282c;

    public k(DownloadInfo r10, b r11, i r12) {
        this.f8280a = r12;
        this.f8281b = c(r10, r12);
        this.f8282c = new h(r11, this);
    }

    private com.ss.android.socialbase.downloader.model.h c(DownloadInfo r10, i r11) {
        com.ss.android.socialbase.downloader.model.h r12 = com.ss.android.socialbase.downloader.utils.c.k(r10, r10.getTempPath(), r10.getTempName(), rb.a.g(r10.getId()).o("flush_buffer_size_byte", -1), false);
        long r13 = r10.getStartOffset();
        if (r13 >= 0) goto L10;
        r13 = 0;
    L10:
        r12.a(r11.d() - r13);     // Catch: IOException -> L7
        return r12;
    L7:
        e = move-exception;
        throw new BaseException(1054, e);
    }

    public void a() {
        com.ss.android.socialbase.downloader.utils.g.b0(new Closeable[]{this.f8281b});
    }

    @Override // com.ss.android.socialbase.downloader.segment.e
    public void b(@NonNull a r10) {
        this.f8281b.write(r10.f8205a, 0, r10.f8207c);
        this.f8280a.k(r10.f8207c);
    }

    public void d() {
        this.f8281b.flush();
    }

    public i e() {
        return this.f8280a;
    }

    public e f() {
        return this.f8282c;
    }

    public void g() {
        this.f8281b.c();
    }
}
