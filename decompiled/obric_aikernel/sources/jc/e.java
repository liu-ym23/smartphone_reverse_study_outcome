package jc;

import com.ttnet.org.chromium.base.TimeUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nTaskRunner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TaskRunner.kt\nokhttp3/internal/concurrent/TaskRunner\n+ 2 Util.kt\nokhttp3/internal/Util\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,314:1\n608#2,4:315\n608#2,4:319\n615#2,4:323\n608#2,4:327\n608#2,4:331\n1#3:335\n*S KotlinDebug\n*F\n+ 1 TaskRunner.kt\nokhttp3/internal/concurrent/TaskRunner\n*L\n79#1:315,4\n97#1:319,4\n108#1:323,4\n126#1:327,4\n152#1:331,4\n*E\n"})
public final class e {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f9925h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @JvmField
    public static final e f9926i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Logger f9927j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f9928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f9929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f9930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f9931d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<jc.d> f9932e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<jc.d> f9933f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Runnable f9934g;

    public interface a {
        void a(e r10, long r11);

        void b(e r10);

        long c();

        void execute(Runnable r10);
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }

        public final Logger a() {
            return e.a();
        }
    }

    @SourceDebugExtension({"SMAP\nTaskRunner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TaskRunner.kt\nokhttp3/internal/concurrent/TaskRunner$RealBackend\n+ 2 Util.kt\nokhttp3/internal/Util\n*L\n1#1,314:1\n560#2:315\n*S KotlinDebug\n*F\n+ 1 TaskRunner.kt\nokhttp3/internal/concurrent/TaskRunner$RealBackend\n*L\n281#1:315\n*E\n"})
    public static final class c implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ThreadPoolExecutor f9935a;

        public c(ThreadFactory r10) {
            Intrinsics.checkNotNullParameter(r10, "threadFactory");
            this.f9935a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), r10);
        }

        @Override // jc.e.a
        public void a(e r10, long r11) {
            Intrinsics.checkNotNullParameter(r10, "taskRunner");
            long r12 = r11 / TimeUtils.NANOSECONDS_PER_MILLISECOND;
            long r13 = r11 - (TimeUtils.NANOSECONDS_PER_MILLISECOND * r12);
            if (r12 <= 0) goto L5;
        L6:
            r10.wait(r12, (int) r13);
            return;
        L5:
            if (r11 > 0) goto L6;
        }

        @Override // jc.e.a
        public void b(e r10) {
            Intrinsics.checkNotNullParameter(r10, "taskRunner");
            r10.notify();
        }

        @Override // jc.e.a
        public long c() {
            return System.nanoTime();
        }

        @Override // jc.e.a
        public void execute(Runnable r10) {
            Intrinsics.checkNotNullParameter(r10, "runnable");
            this.f9935a.execute(r10);
        }
    }

    @SourceDebugExtension({"SMAP\nTaskRunner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TaskRunner.kt\nokhttp3/internal/concurrent/TaskRunner$runnable$1\n+ 2 TaskLogger.kt\nokhttp3/internal/concurrent/TaskLoggerKt\n*L\n1#1,314:1\n35#2,19:315\n*S KotlinDebug\n*F\n+ 1 TaskRunner.kt\nokhttp3/internal/concurrent/TaskRunner$runnable$1\n*L\n62#1:315,19\n*E\n"})
    public static final class d implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ e f9936c;

        d(e r10) {
            this.f9936c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
        L2:
            e r10 = this.f9936c;
            monitor-enter(r10);
            jc.a r11 = r10.d();     // Catch: Throwable -> L23
            monitor-exit(r10);
            if (r11 == null) goto L7;
            jc.d r12 = r11.d();
            Intrinsics.checkNotNull(r12);
            e r13 = this.f9936c;
            long r14 = -1;
            boolean r15 = e.f9925h.a().isLoggable(Level.FINE);
            if (r15 == false) goto L28;
            r14 = r12.h().g().c();
            jc.b.a(r11, r12, "starting");
        L28:
            e.b(r13, r11);     // Catch: Throwable -> L17
            Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L15
            if (r15 == false) goto L2;
            jc.b.a(r11, r12, "finished run in " + jc.b.b(r12.h().g().c() - r14));
            goto L2
        L17:
            th = move-exception;
            r13.g().execute(this);     // Catch: Throwable -> L15
            throw th;     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            if (r15 == false) goto L22;
            jc.b.a(r11, r12, "failed a run in " + jc.b.b(r12.h().g().c() - r14));
        L22:
            throw th;
        L7:
            return;
        L23:
            th = move-exception;
            throw th;
        }
    }

    static {
        f9925h = new b(null);
        f9926i = new e(new c(hc.e.N(hc.e.f9284h + " TaskRunner", true)));
        Logger r10 = Logger.getLogger(e.class.getName());
        Intrinsics.checkNotNullExpressionValue(r10, "getLogger(TaskRunner::class.java.name)");
        f9927j = r10;
    }

    public e(a r10) {
        Intrinsics.checkNotNullParameter(r10, "backend");
        this.f9928a = r10;
        this.f9929b = 10000;
        this.f9932e = new ArrayList();
        this.f9933f = new ArrayList();
        this.f9934g = new d(this);
    }

    public static final /* synthetic */ Logger a() {
        return f9927j;
    }

    public static final /* synthetic */ void b(e r10, jc.a r11) {
        r10.j(r11);
    }

    private final void c(jc.a r10, long r11) {
        if (hc.e.f9283g == true) goto L5;
    L9:
        jc.d r12 = r10.d();
        Intrinsics.checkNotNull(r12);
        if (r12.c() != r10) goto L12;
        boolean r13 = true;
    L13:
        if (r13 == false) goto L25;
        boolean r14 = r12.d();
        r12.m(false);
        r12.l(null);
        this.f9932e.remove(r12);
        if (r11 == (-1)) goto L21;
        if (r14 == true) goto L21;
        if (r12.g() == true) goto L21;
        r12.k(r10, r11, true);
    L21:
        if ((!r12.e().isEmpty()) == false) goto L26;
        this.f9933f.add(r12);
        return;
    L26:
        return;
    L25:
        throw new IllegalStateException("Check failed.".toString());
    L12:
        r13 = false;
        goto L13
    L5:
        if (Thread.holdsLock(this) == true) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    }

    private final void e(jc.a r10) {
        if (hc.e.f9283g == true) goto L5;
    L9:
        r10.g(-1);
        jc.d r11 = r10.d();
        Intrinsics.checkNotNull(r11);
        r11.e().remove(r10);
        this.f9933f.remove(r11);
        r11.l(r10);
        this.f9932e.add(r11);
        return;
    L5:
        if (Thread.holdsLock(this) == true) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    }

    private final void j(jc.a r10) {
        if (hc.e.f9283g == true) goto L5;
    L9:
        Thread r11 = Thread.currentThread();
        String r12 = r11.getName();
        r11.setName(r10.b());
        long r13 = r10.f();     // Catch: Throwable -> L19
        monitor-enter(this);
        c(r10, r13);     // Catch: Throwable -> L16
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(this);
        r11.setName(r12);
        return;
    L16:
        th = move-exception;
        throw th;
    L19:
        th = move-exception;
        monitor-enter(this);
        c(r10, -1);     // Catch: Throwable -> L25
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L25
        r11.setName(r12);
        throw th;
    L25:
        th = move-exception;
        throw th;
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public final jc.a d() {
        if (hc.e.f9283g == false) goto L10;
        if (Thread.holdsLock(this) == true) goto L10;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    L10:
        if (this.f9933f.isEmpty() == true) goto L11;
        long r10 = this.f9928a.c();
        long r11 = Long.MAX_VALUE;
        Iterator<jc.d> r12 = this.f9933f.iterator();
        jc.a r13 = null;
    L14:
        if (r12.hasNext() == false) goto L21;
        jc.a r14 = r12.next().e().get(0);
        long r15 = Math.max(0, r14.c() - r10);
        if (r15 > 0) goto L17;
        if (r13 != null) goto L19;
        r13 = r14;
        goto L14
    L19:
        boolean r16 = true;
    L22:
        if (r13 != null) goto L23;
        if (this.f9930c == true) goto L34;
        this.f9930c = true;
        this.f9931d = r10 + r11;
        this.f9928a.a(this, r11);     // Catch: Throwable -> L40 InterruptedException -> L42
    L39:
        this.f9930c = false;
    L42:
        f();     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        this.f9930c = false;
        throw th;
    L34:
        if (r11 >= (this.f9931d - r10)) goto L36;
        this.f9928a.b(this);
    L36:
        return null;
    L23:
        e(r13);
        if (r16 == false) goto L26;
    L29:
        this.f9928a.execute(this.f9934g);
    L30:
        return r13;
    L26:
        if (this.f9930c == true) goto L30;
        if ((!this.f9933f.isEmpty()) == false) goto L30;
    L17:
        r11 = Math.min(r15, r11);
        goto L14
    L21:
        r16 = false;
        goto L22
    L11:
        return null;
    }

    public final void f() {
        int r10 = this.f9932e.size();
    L3:
        r10 = r10 - 1;
        if ((-1) >= r10) goto L6;
        this.f9932e.get(r10).b();
        goto L3
    L6:
        int r11 = this.f9933f.size() - 1;
    L7:
        if ((-1) >= r11) goto L12;
        jc.d r12 = this.f9933f.get(r11);
        r12.b();
        if (r12.e().isEmpty() == false) goto L11;
        this.f9933f.remove(r11);
    L11:
        r11 = r11 - 1;
        goto L7
    }

    public final a g() {
        return this.f9928a;
    }

    public final void h(jc.d r10) {
        Intrinsics.checkNotNullParameter(r10, "taskQueue");
        if (hc.e.f9283g == false) goto L10;
        if (Thread.holdsLock(this) == true) goto L10;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    L10:
        if (r10.c() != null) goto L16;
        if ((!r10.e().isEmpty()) == false) goto L14;
        hc.e.c(this.f9933f, r10);
        goto L16
    L14:
        this.f9933f.remove(r10);
    L16:
        if (this.f9930c == false) goto L18;
        this.f9928a.b(this);
        return;
    L18:
        this.f9928a.execute(this.f9934g);
    }

    public final jc.d i() {
        monitor-enter(this);
        int r10 = this.f9929b;     // Catch: Throwable -> L7
        this.f9929b = r10 + 1;     // Catch: Throwable -> L7
        monitor-exit(this);
        StringBuilder r11 = new StringBuilder();
        r11.append('Q');
        r11.append(r10);
        return new jc.d(this, r11.toString());
    L7:
        th = move-exception;
        throw th;
    }
}
