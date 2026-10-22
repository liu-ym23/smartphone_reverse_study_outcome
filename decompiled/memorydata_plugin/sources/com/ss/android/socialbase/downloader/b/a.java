package com.ss.android.socialbase.downloader.b;

import com.ss.android.socialbase.downloader.b.a.i;
import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.downloader.h;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;

/* JADX INFO: loaded from: classes6.dex */
public abstract class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected h f15249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected DownloadTask f15250b;
    protected DownloadInfo c;
    protected com.ss.android.socialbase.downloader.g.a d;
    protected com.ss.android.socialbase.downloader.downloader.e e;
    protected i f;

    public a() {
    }

    @Override // com.ss.android.socialbase.downloader.b.e
    public e a(i r2) {
        this.f = r2;
        this.f15249a = r2.f15271a;
        this.f15250b = r2.f15272b;
        this.c = r2.c;
        this.d = r2.d;
        this.e = r2.e;
        return this;
    }

    @Override // com.ss.android.socialbase.downloader.b.e
    public void a() {
    }

    @Override // com.ss.android.socialbase.downloader.b.e
    public void a(long r1, int r3) {
    }

    @Override // com.ss.android.socialbase.downloader.b.e
    public void b() {
    }

    public boolean j_() {
        if (this.f.c.getStatus() != (-2)) goto L9;
        if (this.f.f == RunStatus.RUN_STATUS_PAUSE) goto L7;
        i r3 = this.f;
        r3.f = RunStatus.RUN_STATUS_PAUSE;
    L7:
        return true;
    L9:
        if (this.f.c.getStatus() != (-4)) goto L15;
        if (this.f.f == RunStatus.RUN_STATUS_CANCELED) goto L13;
        i r4 = this.f;
        r4.f = RunStatus.RUN_STATUS_CANCELED;
    L13:
        return true;
    L15:
        if (this.f.f != RunStatus.RUN_STATUS_CANCELED) goto L17;
        return true;
    L17:
        if (this.f.f == RunStatus.RUN_STATUS_PAUSE) goto L22;
        return false;
    L22:
        return true;
    }
}
