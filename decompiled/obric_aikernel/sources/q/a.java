package q;

import android.os.SystemClock;
import r.b;

/* JADX WARN: Unexpected interfaces in signature: [q.l] */
/* JADX INFO: loaded from: classes.dex */
public abstract class a<T extends r.b> extends c<T> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Object f12385j = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile int f12386f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile long f12387g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f12388h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f12389i;

    /* JADX INFO: renamed from: q.a$a, reason: collision with other inner class name */
    class RunnableC0277a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f12390c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f12391g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ a f12392h;

        RunnableC0277a(a r10, long r11, boolean r12) {
            this.f12392h = r10;
            this.f12390c = r11;
            this.f12391g = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.j(this.f12392h, this.f12390c, this.f12391g, k.a.G().E());
        }
    }

    static {
        f12385j = new Object();
    }

    a(String r10) {
        super(r10);
        this.f12386f = 0;
    }

    static /* synthetic */ void j(a r10, long r11, boolean r12, String r13) {
        r10.m(r11, r12, r13);
    }

    private void l(boolean r10) {
        Object r11 = f12385j;
        monitor-enter(r11);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.f12386f > 0) goto L7;
    L12:
        monitor-exit(r11);     // Catch: Throwable -> L14
        return;
    L7:
        if (this.f12387g <= 0) goto L12;
        long r12 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L14
        if (r10 == false) goto L11;
        m(r12 - this.f12387g, this.f12399c, k.a.G().E());     // Catch: Throwable -> L14
    L11:
        this.f12387g = r12;     // Catch: Throwable -> L14
        goto L12
    }

    private void m(long r11, boolean r13, String r14) {
        b0.a r10 = new b0.a(r13, System.currentTimeMillis(), h(), this.f12400d, r11, r14);
        p.a.h().l(r10);
    }

    @Override // q.c, q.l
    public void b(boolean r10) {
        l(r10);
        super.b(r10);
    }

    @Override // q.l
    public void d(boolean r10, boolean r11) {
        l(r11);
        this.f12400d = r10;
    }

    @Override // q.c, q.l
    public void f(boolean r10) {
        l(r10);
        super.f(r10);
    }

    @Override // q.c
    protected void g(T r10, long r11, long r12) {
        this.f12389i++;
        long r13 = r10.f12510a;
        if (r13 < r11) goto L6;
        r11 = r13;
    L6:
        long r14 = r10.f12511b;
        if (r14 > 0) goto L9;
    L12:
        p(r10, r12 - r13);
        long r15 = r12 - r11;
        if (r15 <= 0) goto L16;
        this.f12388h += r15;
        return;
    L16:
        return;
    L9:
        if (r12 < r14) goto L12;
        r12 = r14;
        goto L12
    }

    @Override // q.c
    protected void i(long r10, long r11, boolean r13) {
        this.f12389i = 0;
        this.f12388h = 0;
        l(r13);
        super.i(r10, r11, r13);
        long r12 = System.currentTimeMillis();
        o(((this.f12388h / (r12 - this.f12398b)) * 60000.0d) * 10.0d, ((((double) this.f12389i) / (r12 - this.f12398b)) * 60000.0d) * 10.0d);
    }

    void k() {
        Object r10 = f12385j;
        monitor-enter(r10);
        e0.a.d("APM-Battery", "addHolderCount:" + this.f12386f + " type:" + h());     // Catch: Throwable -> L9
        this.f12386f = this.f12386f + 1;     // Catch: Throwable -> L9
        if (this.f12386f != 1) goto L7;
        this.f12387g = SystemClock.elapsedRealtime();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r10);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    void n() {
        Object r10 = f12385j;
        monitor-enter(r10);
        e0.a.d("APM-Battery", "reduceHolderCount:" + this.f12386f + " type:" + h());     // Catch: Throwable -> L13
        if (this.f12386f != 0) goto L8;
        monitor-exit(r10);     // Catch: Throwable -> L13
        return;
    L8:
        this.f12386f--;     // Catch: Throwable -> L13
        if (this.f12386f != 0) goto L11;
        boolean r11 = this.f12399c;     // Catch: Throwable -> L13
        q0.b.f().i(new RunnableC0277a(this, SystemClock.elapsedRealtime() - this.f12387g, r11));     // Catch: Throwable -> L13
        this.f12387g = -1;     // Catch: Throwable -> L13
    L11:
        monitor-exit(r10);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    abstract void o(double r10, double r11);

    protected abstract void p(T r10, long r11);
}
