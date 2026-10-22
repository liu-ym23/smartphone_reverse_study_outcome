package jb;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static qb.m f9801e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private qb.t f9804c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private qb.l f9805d;

    static {
        f9801e = (qb.m) qb.k.a(qb.m.class);
    }

    b() {
        this.f9804c = (qb.t) qb.k.a(qb.t.class);
        this.f9805d = (qb.l) qb.k.a(qb.l.class);
    }

    private File e(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return null;
    L5:
        File r11 = new File(r10);
        if (com.ss.android.socialbase.downloader.utils.a.q(r11) == false) goto L8;
        return r11;
    L8:
        return null;
    }

    public static com.ss.android.socialbase.downloader.model.d s(Context r10) {
        f.u(r10);
        return new com.ss.android.socialbase.downloader.model.d();
    }

    public void a(int r10) {
        b(r10, true);
    }

    public void b(int r10, boolean r11) {
        this.f9804c.q(r10, r11);
    }

    @WorkerThread
    public DownloadInfo c(int r10) {
        return this.f9804c.a(r10);
    }

    public File d() {
        return e(this.f9802a);
    }

    public File f() {
        return e(this.f9803b);
    }

    public t g() {
        return this.f9805d.e();
    }

    @WorkerThread
    public int h(int r10) {
        return this.f9804c.n(r10);
    }

    @WorkerThread
    public boolean i(int r10) {
        return this.f9804c.o(r10);
    }

    public void j(int r10) {
        this.f9804c.b(r10);
    }

    public void k() {
        this.f9804c.u();
    }

    public void l(int r10) {
        this.f9804c.z(r10);
    }

    public void m(List<String> r10) {
        this.f9804c.w(r10);
    }

    public void n(List<String> r10) {
        this.f9804c.r(r10);
    }

    public void o(int r10) {
        this.f9804c.s(r10);
    }

    public void p(int r10, boolean r11) {
        this.f9804c.p(r10, r11);
    }

    public void q(int r10, long r11) {
        r(r10, r11, 0);
    }

    public void r(int r10, long r11, int r12) {
        this.f9804c.t(r10, r11, r12);
    }
}
