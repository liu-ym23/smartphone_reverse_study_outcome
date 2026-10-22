package q0;

import android.annotation.SuppressLint;
import com.bytedance.monitor.util.thread.AsyncTaskType;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static long f12424h = 30000;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static long f12425i = 30000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile ExecutorService f12426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f12427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private z3.c f12428c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final z3.d f12429d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final z3.d f12430e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    CopyOnWriteArraySet<e> f12431f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    CopyOnWriteArraySet<e> f12432g;

    class a implements z3.d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f12433c;

        a(b r10) {
            this.f12433c = r10;
        }

        @Override // z3.d
        public AsyncTaskType J() {
            return AsyncTaskType.LIGHT_WEIGHT;
        }

        @Override // z3.d
        public String P() {
            return "AsyncEventManager-mTimerRunnable";
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator<e> r10 = this.f12433c.f12431f.iterator();
        L4:
            if (r10.hasNext() == false) goto L7;
            r10.next().onTimeEvent(System.currentTimeMillis());
            goto L4
        L7:
            if (b.a(this.f12433c) == false) goto L11;
            this.f12433c.k(this, b.f12424h);
            return;
        }
    }

    /* JADX INFO: renamed from: q0.b$b, reason: collision with other inner class name */
    class C0278b implements z3.d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f12434c;

        C0278b(b r10) {
            this.f12434c = r10;
        }

        @Override // z3.d
        public AsyncTaskType J() {
            return AsyncTaskType.LIGHT_WEIGHT;
        }

        @Override // z3.d
        public String P() {
            return "AsyncEventManager-mControlledTimerRunnable";
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator<e> r10 = this.f12434c.f12432g.iterator();
        L4:
            if (r10.hasNext() == false) goto L7;
            r10.next().onTimeEvent(System.currentTimeMillis());
            goto L4
        L7:
            if (b.a(this.f12434c) == false) goto L11;
            this.f12434c.k(this, b.b());
            return;
        }
    }

    class c implements ThreadFactory {
        c(b r10) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r10) {
            return new Thread(r10, "Apm_Normal");
        }
    }

    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final b f12435a = null;

        static {
            f12435a = new b(null);
        }
    }

    public interface e {
        void onTimeEvent(long r10);
    }

    static {
    }

    private b() {
        this.f12427b = true;
        this.f12429d = new a(this);
        this.f12430e = new C0278b(this);
        this.f12431f = new CopyOnWriteArraySet();
        this.f12432g = new CopyOnWriteArraySet();
        this.f12428c = z3.b.a();
    }

    /* synthetic */ b(a r10) {
        this();
    }

    static /* synthetic */ boolean a(b r10) {
        return r10.f12427b;
    }

    static /* synthetic */ long b() {
        return f12425i;
    }

    public static b f() {
        return d.f12435a;
    }

    private z3.d q(Runnable r10, String r11) {
        return z3.b.e("AsyncEventManager-" + r11, r10);
    }

    public void c(e r10) {
        if (r10 == null) goto L12;
        if (this.f12427b == true) goto L6;
        return;
    L6:
        if (this.f12431f.contains(r10) == true) goto L14;
        this.f12431f.add(r10);     // Catch: Throwable -> L9
        l(this.f12429d);     // Catch: Throwable -> L9
        k(this.f12429d, f12424h);     // Catch: Throwable -> L9
        return;
    L14:
        return;
    L15:
        return;
    }

    public void d(Runnable r10) {
        z3.c r11 = this.f12428c;
        if (r11 == null) goto L8;
        if (r10 == null) goto L9;
        r11.d(q(r10, "post"));
        return;
    L9:
        return;
    }

    public void e(z3.d r10, long r11) {
        z3.c r12 = this.f12428c;
        if (r12 == null) goto L8;
        if (r10 == null) goto L9;
        r12.b(r10, r11);
        return;
    L9:
        return;
    }

    public boolean g() {
        if (this.f12428c != null) goto L5;
    L7:
        return false;
    L5:
        if (Thread.currentThread().getId() != this.f12428c.i(AsyncTaskType.LIGHT_WEIGHT)) goto L7;
        return true;
    }

    public void h(ExecutorService r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        monitor-enter(this);
        this.f12426a = r10;     // Catch: Throwable -> L10
        z3.c r11 = this.f12428c;     // Catch: Throwable -> L10
        if (r11 == null) goto L8;
        r11.e(r10);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void i(Runnable r10) {
        if (this.f12428c == null) goto L10;
        if (r10 != null) goto L6;
        return;
    L6:
        if (this.f12427b == false) goto L12;
        this.f12428c.d(q(r10, "post"));
        return;
    L12:
        return;
    }

    public void j(Runnable r10, long r11) {
        if (this.f12428c == null) goto L10;
        if (r10 != null) goto L6;
        return;
    L6:
        if (this.f12427b == false) goto L12;
        this.f12428c.b(q(r10, "postDelayed"), r11);
        return;
    L12:
        return;
    }

    public void k(z3.d r10, long r11) {
        if (this.f12428c == null) goto L10;
        if (r10 != null) goto L6;
        return;
    L6:
        if (this.f12427b == false) goto L12;
        this.f12428c.b(r10, r11);
        return;
    L12:
        return;
    }

    public void l(z3.d r10) {
        z3.c r11 = this.f12428c;
        if (r11 == null) goto L8;
        if (r10 == null) goto L9;
        r11.f(r10);
        return;
    L9:
        return;
    }

    public void m(e r10) {
        if (r10 == null) goto L8;
        this.f12431f.remove(r10);     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    public void n() {
        this.f12427b = true;
        if (this.f12431f.isEmpty() == true) goto L6;
        l(this.f12429d);
        k(this.f12429d, f12424h);
    L6:
        if (this.f12432g.isEmpty() == true) goto L9;
        l(this.f12430e);
        k(this.f12430e, f12425i);
        return;
    }

    public void o() {
        this.f12427b = false;
        l(this.f12429d);
        l(this.f12430e);
    }

    @SuppressLint({"CI_NotAllowInvokeExecutorsMethods"})
    public void p(Runnable r10) {
        if (this.f12426a != null) goto L17;
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L6:
        if (this.f12426a != null) goto L12;
        z3.c r11 = this.f12428c;     // Catch: Throwable -> L14
        if (r11 == null) goto L11;
        ExecutorService r12 = r11.h();     // Catch: Throwable -> L14
    L10:
        this.f12426a = r12;     // Catch: Throwable -> L14
        goto L12
    L11:
        r12 = Executors.newFixedThreadPool(1, new c(this));     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);     // Catch: Throwable -> L14
    L17:
        this.f12426a.submit(r10);
    }
}
