package gb;

import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DownloadInfo f9045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f9046b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9047c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f9048d;

    public d(DownloadInfo r10, long r11) {
        this.f9045a = r10;
        this.f9046b = r11;
        this.f9048d = com.ss.android.socialbase.downloader.utils.c.p(r10) + r10.getStartOffset();
    }

    public c a() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.f9048d >= this.f9045a.getTotalBytes()) goto L6;
        c r10 = new c();     // Catch: Throwable -> L15
        r10.f9042a = this.f9047c;     // Catch: Throwable -> L15
        long r11 = this.f9048d;     // Catch: Throwable -> L15
        r10.f9043b = r11;     // Catch: Throwable -> L15
        long r12 = (r11 + this.f9046b) - 1;     // Catch: Throwable -> L15
        if (r12 >= this.f9045a.getTotalBytes()) goto L11;
        r10.f9044c = r12;     // Catch: Throwable -> L15
    L12:
        this.f9048d += this.f9046b;     // Catch: Throwable -> L15
        this.f9047c++;     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        return r10;
    L11:
        r10.f9044c = (this.f9045a.getStartOffset() + this.f9045a.getTotalBytes()) - 1;     // Catch: Throwable -> L15
        goto L12
    L6:
        monitor-exit(this);     // Catch: Throwable -> L15
        return null;
    }
}
