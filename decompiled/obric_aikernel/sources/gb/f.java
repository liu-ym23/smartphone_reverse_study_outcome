package gb;

import android.os.Process;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import java.util.List;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes2.dex */
public class f extends cb.a implements Runnable, b.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Future f9056l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f9057m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private c f9058n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private bb.d f9059o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private nb.h f9060p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private e f9061q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private d f9062r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private b f9063s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private i f9064t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private g f9065u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f9066v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private a f9067w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private g f9068x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private h f9069y;

    public interface a {
        void onError(Throwable r10);
    }

    public f(e r10, d r11, b r12, i r13, g r14, int r15, a r16) {
        this.f9057m = false;
        this.f9061q = r10;
        this.f9062r = r11;
        this.f9063s = r12;
        r12.d(this);
        this.f9064t = r13;
        this.f9065u = r14;
        this.f9066v = r15;
        this.f9067w = r16;
    }

    private Throwable A(String r21, boolean r22) {
        if (lb.a.a() == false) goto L5;
        lb.a.g("PCDNChunkRunnableModule", this.f544h.getId(), "doDownload", "Before Url:" + r21 + " isPcdn:" + r22 + " index:" + this.f9058n.f9042a);
    L5:
        this.f9064t.e(r21, r22);
        c r10 = this.f9058n;
        List<HttpHeader> r11 = n(r10.f9043b, r10.f9044c, true);
        c r12 = this.f9058n;
        long r13 = r12.f9044c;
        long r14 = r12.f9043b;
        long r15 = 1 + (r13 - r14);
        Throwable r16 = null;
        this.f9060p = t(r21, r11, r14);     // Catch: Throwable -> L8
        bb.d r17 = new bb.d(this.f547k, this.f9060p, this.f9058n.f9043b, r15, this);     // Catch: Throwable -> L8
        this.f9059o = r17;     // Catch: Throwable -> L8
        r17.i();     // Catch: Throwable -> L8
        this.f9061q.a(this.f9058n.f9042a);     // Catch: Throwable -> L8
    L12:
        Throwable r18 = r16;
        this.f9064t.a(r21, this.f9058n.f9043b, r22, z(), this.f9060p, this.f9059o, r18);
        bb.d r19 = this.f9059o;
        if (r19 == null) goto L16;
        this.f9058n.f9043b = r19.h();
    L16:
        if (lb.a.a() == false) goto L18;
        lb.a.g("PCDNChunkRunnableModule", this.f544h.getId(), "doDownload", "After Url:" + r21 + " isPcdn:" + r22 + " index:" + this.f9058n.f9042a);
    L18:
        return r18;
    L8:
        th = move-exception;
        r16 = th;
        r16.printStackTrace();
        this.f9068x.d();
        if (lb.a.a() == false) goto L12;
        lb.a.g("PCDNChunkRunnableModule", this.f544h.getId(), "doDownload", "OnError index:" + this.f9058n.f9042a);
        goto L12
    }

    private void B() {
        g r10 = this.f9065u;
        if (r10 != null) goto L5;
    L7:
        g r11 = new g(this.f544h.getPcdnUrls(), this.f544h.getCdnUrls());
    L8:
        this.f9068x = r11;
        this.f9069y = new h(this.f9066v);
    L9:
        Throwable r12 = A(this.f9068x.c(), this.f9068x.b());
        if (r12 == null) goto L26;
        if (this.f9069y.a(true) == false) goto L15;
        if (z() == false) goto L9;
        return;
    L15:
        if (z() == true) goto L25;
        this.f9067w.onError(r12);
        return;
    L25:
        return;
    L26:
        return;
    L5:
        if (r10.b() == true) goto L7;
        r11 = this.f9065u.a();
        goto L8
    }

    private void y() {
        this.f9056l.cancel(true);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    private boolean z() {
        if (m() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f9057m == true) goto L8;
        return false;
    }

    public Future C() {
        return this.f9056l;
    }

    public void E(Future r10) {
        this.f9056l = r10;
    }

    @Override // gb.b.a
    public void b() {
        if (lb.a.a() == false) goto L5;
        lb.a.g("PCDNChunkRunnableModule", this.f544h.getId(), "onLowSpeed", "Run");
    L5:
        h r10 = this.f9069y;
        if (r10 != null) goto L8;
        return;
    L8:
        if (r10.a(false) == false) goto L19;
        g r11 = this.f9068x;
        if (r11 != null) goto L12;
        return;
    L12:
        if (r11.e() == true) goto L14;
        return;
    L14:
        if (lb.a.a() == false) goto L16;
        lb.a.g("PCDNChunkRunnableModule", this.f544h.getId(), "onLowSpeed", "Run switch cdn");
    L16:
        o(this.f9060p);
        return;
    }

    @Override // bb.a, bb.e
    public void cancel() {
        this.f9057m = true;
        bb.d r10 = this.f9059o;
        if (r10 == null) goto L5;
        r10.d();
    L6:
        y();
        return;
    L5:
        o(this.f9060p);
        goto L6
    }

    @Override // bb.a, bb.e
    public void f() {
        this.f9057m = true;
        bb.d r10 = this.f9059o;
        if (r10 == null) goto L5;
        r10.k();
    L6:
        y();
        return;
    L5:
        o(this.f9060p);
        goto L6
    }

    @Override // cb.a, sb.d
    public boolean j(long r10) {
        if (this.f9068x.b() == false) goto L6;
        this.f9063s.b(r10);
    L6:
        return this.f9061q.b(this.f9058n.f9042a, r10);
    }

    @Override // java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        if (lb.a.a() == false) goto L5;
        lb.a.g("PCDNChunkRunnableModule", this.f544h.getId(), "run", "Run");
    L5:
        this.f9063s.e();
    L7:
        if (z() == true) goto L13;
        c r10 = this.f9062r.a();
        this.f9058n = r10;
        if (r10 == null) goto L10;
        B();
        goto L7
    L10:
        return;
    L13:
        if (lb.a.a() == false) goto L18;
        lb.a.g("PCDNChunkRunnableModule", this.f544h.getId(), "run", "Run End");
        return;
    }
}
