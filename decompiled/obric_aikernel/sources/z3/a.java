package z3;

import androidx.annotation.NonNull;
import com.bytedance.monitor.util.thread.AsyncTaskType;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public class a implements z3.c {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Object f13783l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Object f13784m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final Object f13785n = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile a4.b f13786c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile a4.b f13787g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile a4.b f13788h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Map<AsyncTaskType, Long> f13789i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private e f13790j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private z3.c.a f13791k;

    /* JADX INFO: renamed from: z3.a$a, reason: collision with other inner class name */
    class C0323a implements a4.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f13792a;

        C0323a(a r10) {
            this.f13792a = r10;
        }

        @Override // a4.a.b
        public void a(long r10) {
            a.k(this.f13792a).put(AsyncTaskType.IO, Long.valueOf(r10));
        }
    }

    class b implements a4.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f13793a;

        b(a r10) {
            this.f13793a = r10;
        }

        @Override // a4.a.b
        public void a(long r10) {
            a.k(this.f13793a).put(AsyncTaskType.LIGHT_WEIGHT, Long.valueOf(r10));
        }
    }

    class c implements a4.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f13794a;

        c(a r10) {
            this.f13794a = r10;
        }

        @Override // a4.a.b
        public void a(long r10) {
            a.k(this.f13794a).put(AsyncTaskType.TIME_SENSITIVE, Long.valueOf(r10));
        }
    }

    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final a f13795a = null;

        static {
            f13795a = new a();
        }
    }

    static {
        f13783l = new Object();
        f13784m = new Object();
        f13785n = new Object();
    }

    public a() {
        this.f13789i = new ConcurrentHashMap(3);
    }

    static /* synthetic */ Map k(a r10) {
        return r10.f13789i;
    }

    @NonNull
    private a4.c l(z3.d r10) {
        AsyncTaskType r11 = r10.J();
        if (r11 != AsyncTaskType.IO) goto L7;
        return m();
    L7:
        if (r11 != AsyncTaskType.TIME_SENSITIVE) goto L11;
        return p();
    L11:
        return o();
    }

    public static a n() {
        return d.f13795a;
    }

    private void q(e r10) {
        Object r11 = f13783l;
        monitor-enter(r11);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f13786c != null) goto L7;
        a4.a r12 = new a4.a("io-task");     // Catch: Throwable -> L9
        r12.c(r10);     // Catch: Throwable -> L9
        r12.d(new C0323a(this));     // Catch: Throwable -> L9
        a4.b r13 = new a4.b(1, r12);     // Catch: Throwable -> L9
        r13.w(r10);     // Catch: Throwable -> L9
        this.f13786c = r13;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r11);     // Catch: Throwable -> L9
    }

    private void r(e r10) {
        Object r11 = f13784m;
        monitor-enter(r11);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f13787g != null) goto L7;
        a4.a r12 = new a4.a("light-weight-task");     // Catch: Throwable -> L9
        r12.c(r10);     // Catch: Throwable -> L9
        r12.d(new b(this));     // Catch: Throwable -> L9
        a4.b r13 = new a4.b(1, r12);     // Catch: Throwable -> L9
        r13.w(r10);     // Catch: Throwable -> L9
        this.f13787g = r13;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r11);     // Catch: Throwable -> L9
    }

    private void s(e r10) {
        Object r11 = f13785n;
        monitor-enter(r11);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f13788h != null) goto L7;
        a4.a r12 = new a4.a("time-sensitive-task");     // Catch: Throwable -> L9
        r12.c(r10);     // Catch: Throwable -> L9
        r12.d(new c(this));     // Catch: Throwable -> L9
        a4.b r13 = new a4.b(1, r12);     // Catch: Throwable -> L9
        r13.w(r10);     // Catch: Throwable -> L9
        this.f13788h = r13;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r11);     // Catch: Throwable -> L9
    }

    @Override // z3.c
    public void a(Throwable r10, String r11) {
        z3.c.a r12 = this.f13791k;
        if (r12 == null) goto L6;
        r12.a(r10, r11);
        return;
    }

    @Override // a4.c
    public void b(z3.d r10, long r11) {
        if (r10 != null) goto L9;
        return;
    L9:
        l(r10).b(r10, r11);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        a(th, "Apm-Async-task-postDelayed");
    }

    @Override // z3.c
    public void c(z3.c.a r10) {
        this.f13791k = r10;
    }

    @Override // a4.c
    public void d(z3.d r10) {
        if (r10 != null) goto L9;
        return;
    L9:
        l(r10).d(r10);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        a(th, "Apm-Async-task-post");
    }

    @Override // z3.c
    public void e(ExecutorService r10) {
        m().v(r10);
    }

    @Override // a4.c
    public void f(z3.d r10) {
        if (r10 != null) goto L9;
        return;
    L9:
        l(r10).f(r10);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        a(th, "Apm-Async-task-removeTask");
    }

    @Override // a4.c
    public void g(z3.d r10, long r11, long r12) {
        if (r10 != null) goto L9;
        return;
    L9:
        l(r10).g(r10, r11, r12);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        a(th, "Apm-Async-task-removeTask");
    }

    @Override // z3.c
    public ExecutorService h() {
        return m();
    }

    @Override // z3.c
    public long i(AsyncTaskType r10) {
        Long r11 = this.f13789i.get(r10);
        if (r11 != null) goto L5;
        return -1;
    L5:
        return r11.longValue();
    }

    @Override // z3.c
    public e j() {
        return this.f13790j;
    }

    public a4.b m() {
        if (this.f13786c != null) goto L15;
        Object r10 = f13783l;
        monitor-enter(r10);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.f13786c != null) goto L9;
        q(this.f13790j);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r10);     // Catch: Throwable -> L11
    L15:
        return this.f13786c;
    }

    public a4.b o() {
        if (this.f13787g != null) goto L15;
        Object r10 = f13784m;
        monitor-enter(r10);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.f13787g != null) goto L9;
        r(this.f13790j);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r10);     // Catch: Throwable -> L11
    L15:
        return this.f13787g;
    }

    public a4.b p() {
        if (this.f13788h != null) goto L15;
        Object r10 = f13785n;
        monitor-enter(r10);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.f13788h != null) goto L9;
        s(this.f13790j);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r10);     // Catch: Throwable -> L11
    L15:
        return this.f13788h;
    }
}
