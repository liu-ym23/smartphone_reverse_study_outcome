package gb;

import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private sb.d f9049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private jb.i f9050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private DownloadInfo f9051c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<Integer, b> f9052d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f9053e;

    static /* synthetic */ class a {
    }

    private class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f9054a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f9055b;

        private b(e r10) {
        }

        /* synthetic */ b(e r10, a r11) {
            this(r10);
        }

        static /* synthetic */ boolean a(b r10) {
            return r10.f9055b;
        }

        static /* synthetic */ boolean b(b r10, boolean r11) {
            r10.f9055b = r11;
            return r11;
        }

        static /* synthetic */ long c(b r10) {
            return r10.f9054a;
        }

        static /* synthetic */ long d(b r10, long r11) {
            r10.f9054a = r11;
            return r11;
        }
    }

    public e(sb.d r10, jb.i r11, DownloadInfo r12) {
        this.f9052d = new HashMap();
        this.f9049a = r10;
        this.f9050b = r11;
        this.f9051c = r12;
    }

    public void a(int r10) {
        monitor-enter(this);
        int r11 = this.f9053e;     // Catch: Throwable -> L28
        if (r10 != r11) goto L6;
        this.f9053e = r11 + 1;     // Catch: Throwable -> L28
        long r12 = 0;
    L11:
        b r13 = this.f9052d.get(Integer.valueOf(this.f9053e));     // Catch: Throwable -> L28
        if (r13 == null) goto L18;
        r12 = r12 + b.c(r13);     // Catch: Throwable -> L28
        if (b.a(r13) == false) goto L16;
        this.f9052d.remove(Integer.valueOf(this.f9053e));     // Catch: Throwable -> L28
        this.f9053e++;     // Catch: Throwable -> L28
        goto L11
    L16:
        b.d(r13, 0);     // Catch: Throwable -> L28
        this.f9052d.put(Integer.valueOf(this.f9053e), r13);     // Catch: Throwable -> L28
    L18:
        if (r12 > 0) goto L31;
        monitor-exit(this);     // Catch: Throwable -> L28
        return;
    L31:
        this.f9049a.j(r12);     // Catch: Throwable -> L23
        this.f9051c.updateRealDownloadTime(true);     // Catch: Throwable -> L23
        this.f9050b.b(this.f9051c);     // Catch: Throwable -> L23
    L25:
        monitor-exit(this);     // Catch: Throwable -> L28
        return;
    L23:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L28
        goto L25
    L6:
        if (this.f9052d.containsKey(Integer.valueOf(r10)) == false) goto L8;
        b r14 = this.f9052d.get(Integer.valueOf(r10));     // Catch: Throwable -> L28
        b.b(r14, true);     // Catch: Throwable -> L28
        this.f9052d.put(Integer.valueOf(r10), r14);     // Catch: Throwable -> L28
    L8:
        monitor-exit(this);     // Catch: Throwable -> L28
        return;
    L28:
        th = move-exception;
        throw th;
    }

    public boolean b(int r10, long r11) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (r10 != this.f9053e) goto L8;
        boolean r12 = this.f9049a.j(r11);     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        return r12;
    L8:
        b r13 = this.f9052d.get(Integer.valueOf(r10));     // Catch: Throwable -> L14
        if (r13 != null) goto L11;
        r13 = new b(this, null);     // Catch: Throwable -> L14
    L11:
        b.d(r13, b.c(r13) + r11);     // Catch: Throwable -> L14
        this.f9052d.put(Integer.valueOf(r10), r13);     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        return false;
    }
}
