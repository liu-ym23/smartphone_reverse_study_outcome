package o;

import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<V> implements ga.a<V> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final boolean f9546n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Logger f9547o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final AbstractC0124a f9548p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Object f9549q = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Object f9550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile d f9551b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile h f9552m;

    /* JADX INFO: renamed from: o.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0124a {
        public abstract boolean a(a<?> r8, d r10, d r11);

        public abstract boolean b(a<?> r8, Object r10, Object r11);

        public abstract boolean c(a<?> r8, h r10, h r11);

        public abstract void d(h r8, h r10);

        public abstract void e(h r8, Thread r10);
    }

    public static final class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f9553b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f9554c = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f9555a;

        static {
            if (a.f9546n == false) goto L5;
            f9554c = null;
            f9553b = null;
            return;
        L5:
            f9554c = new b(false, null);
            f9553b = new b(true, null);
        }

        public b(boolean r8, Throwable r10) {
            this.f9555a = r10;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f9556a;

        /* JADX INFO: renamed from: o.a$c$a, reason: collision with other inner class name */
        public class C0125a extends Throwable {
            public C0125a() {
                super("Failure occurred while trying to finish a future.");
            }

            @Override // java.lang.Throwable
            public final synchronized Throwable fillInStackTrace() {
                monitor-enter(this);
                monitor-exit(this);
                return this;
            }
        }

        static {
            new c(new C0125a());
        }

        public c(Throwable r8) {
            boolean r10 = a.f9546n;
            r8.getClass();
            this.f9556a = r8;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final d f9557d = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f9558a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f9559b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public d f9560c;

        static {
            f9557d = new d(null, null);
        }

        public d(Executor r8, Runnable r10) {
            this.f9558a = r10;
            this.f9559b = r8;
        }
    }

    public static final class e extends AbstractC0124a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<h, Thread> f9561a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<h, h> f9562b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<a, h> f9563c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<a, d> f9564d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<a, Object> f9565e;

        public e(AtomicReferenceFieldUpdater<h, Thread> r8, AtomicReferenceFieldUpdater<h, h> r10, AtomicReferenceFieldUpdater<a, h> r11, AtomicReferenceFieldUpdater<a, d> r12, AtomicReferenceFieldUpdater<a, Object> r13) {
            this.f9561a = r8;
            this.f9562b = r10;
            this.f9563c = r11;
            this.f9564d = r12;
            this.f9565e = r13;
        }

        @Override // o.a.AbstractC0124a
        public final boolean a(a<?> r8, d r10, d r11) {
        L2:
            AtomicReferenceFieldUpdater<a, d> r12 = this.f9564d;
            if (r12.compareAndSet(r8, r10, r11) == true) goto L4;
            if (r12.get(r8) == r10) goto L2;
            return false;
        L4:
            return true;
        }

        @Override // o.a.AbstractC0124a
        public final boolean b(a<?> r8, Object r10, Object r11) {
        L2:
            AtomicReferenceFieldUpdater<a, Object> r12 = this.f9565e;
            if (r12.compareAndSet(r8, r10, r11) == true) goto L4;
            if (r12.get(r8) == r10) goto L2;
            return false;
        L4:
            return true;
        }

        @Override // o.a.AbstractC0124a
        public final boolean c(a<?> r8, h r10, h r11) {
        L2:
            AtomicReferenceFieldUpdater<a, h> r12 = this.f9563c;
            if (r12.compareAndSet(r8, r10, r11) == true) goto L4;
            if (r12.get(r8) == r10) goto L2;
            return false;
        L4:
            return true;
        }

        @Override // o.a.AbstractC0124a
        public final void d(h r8, h r10) {
            this.f9562b.lazySet(r8, r10);
        }

        @Override // o.a.AbstractC0124a
        public final void e(h r8, Thread r10) {
            this.f9561a.lazySet(r8, r10);
        }
    }

    public static final class f<V> implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }
    }

    public static final class g extends AbstractC0124a {
        @Override // o.a.AbstractC0124a
        public final boolean a(a<?> r8, d r10, d r11) {
            monitor-enter(r8);
        L12:
            th = move-exception;
            throw th;
        L4:
            if (r8.f9551b != r10) goto L9;
            r8.f9551b = r11;     // Catch: Throwable -> L12
            monitor-exit(r8);     // Catch: Throwable -> L12
            return true;
        L9:
            monitor-exit(r8);     // Catch: Throwable -> L12
            return false;
        }

        @Override // o.a.AbstractC0124a
        public final boolean b(a<?> r8, Object r10, Object r11) {
            monitor-enter(r8);
        L12:
            th = move-exception;
            throw th;
        L4:
            if (r8.f9550a != r10) goto L9;
            r8.f9550a = r11;     // Catch: Throwable -> L12
            monitor-exit(r8);     // Catch: Throwable -> L12
            return true;
        L9:
            monitor-exit(r8);     // Catch: Throwable -> L12
            return false;
        }

        @Override // o.a.AbstractC0124a
        public final boolean c(a<?> r8, h r10, h r11) {
            monitor-enter(r8);
        L12:
            th = move-exception;
            throw th;
        L4:
            if (r8.f9552m != r10) goto L9;
            r8.f9552m = r11;     // Catch: Throwable -> L12
            monitor-exit(r8);     // Catch: Throwable -> L12
            return true;
        L9:
            monitor-exit(r8);     // Catch: Throwable -> L12
            return false;
        }

        @Override // o.a.AbstractC0124a
        public final void d(h r8, h r10) {
            r8.f9568b = r10;
        }

        @Override // o.a.AbstractC0124a
        public final void e(h r8, Thread r10) {
            r8.f9567a = r10;
        }
    }

    public static final class h {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final h f9566c = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile Thread f9567a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile h f9568b;

        static {
            f9566c = new h(0);
        }

        public h() {
            a.f9548p.e(this, Thread.currentThread());
        }

        public h(int r8) {
        }
    }

    static {
        f9546n = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        f9547o = Logger.getLogger(a.class.getName());
        AbstractC0124a r8 = new e(AtomicReferenceFieldUpdater.newUpdater(h.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(h.class, h.class, "b"), AtomicReferenceFieldUpdater.newUpdater(a.class, h.class, "m"), AtomicReferenceFieldUpdater.newUpdater(a.class, d.class, "b"), AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "a"));     // Catch: Throwable -> L5
        th = null;
    L7:
        f9548p = r8;
        if (th == null) goto L10;
        f9547o.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
    L10:
        f9549q = new Object();
        return;
    L5:
        th = th;
        r8 = new g();
        goto L7
    }

    public a() {
    }

    public static void c(a<?> r8) {
    L2:
        h r10 = r8.f9552m;
        if (f9548p.c(r8, r10, h.f9566c) == false) goto L2;
    L5:
        if (r10 == null) goto L10;
        Thread r11 = r10.f9567a;
        if (r11 == null) goto L9;
        r10.f9567a = null;
        LockSupport.unpark(r11);
    L9:
        r10 = r10.f9568b;
    L10:
        d r12 = r8.f9551b;
        if (f9548p.a(r8, r12, d.f9557d) == false) goto L10;
        d r13 = null;
    L13:
        if (r12 == null) goto L15;
        d r14 = r12.f9560c;
        r12.f9560c = r13;
        r13 = r12;
        r12 = r14;
    L15:
        if (r13 == null) goto L21;
        d r15 = r13.f9560c;
        Runnable r16 = r13.f9558a;
        if ((r16 instanceof f) == true) goto L19;
        d(r13.f9559b, r16);
        r13 = r15;
        goto L15
    L19:
        ((f) r16).getClass();
        throw null;
    }

    public static void d(Executor r8, Runnable r10) {
        r8.execute(r10);     // Catch: RuntimeException -> L4
        return;
    L4:
        e = move-exception;
        f9547o.log(Level.SEVERE, "RuntimeException while executing runnable " + r10 + " with executor " + r8, e);
    }

    @Override // ga.a
    public final void a(Executor r8, Runnable r10) {
        r8.getClass();
        d r11 = this.f9551b;
        d r12 = d.f9557d;
        if (r11 == r12) goto L10;
        d r13 = new d(r8, r10);
    L5:
        r13.f9560c = r11;
        if (f9548p.a(this, r11, r13) == true) goto L7;
        r11 = this.f9551b;
        if (r11 != r12) goto L5;
    L7:
        return;
    L10:
        d(r8, r10);
    }

    public final void b(StringBuilder r8) {
        boolean r10 = false;
    L25:
        V r11 = get();     // Catch: Throwable -> L15 InterruptedException -> L24
    L4:
        if (r10 == false) goto L6;
        Thread.currentThread().interrupt();     // Catch: RuntimeException -> L11 ExecutionException -> L13 CancellationException -> L20
    L6:
        r8.append("SUCCESS, result=[");     // Catch: RuntimeException -> L11 ExecutionException -> L13 CancellationException -> L20
        if (r11 != this) goto L9;
        String r12 = "this future";
    L10:
        r8.append(r12);     // Catch: RuntimeException -> L11 ExecutionException -> L13 CancellationException -> L20
        r8.append("]");     // Catch: RuntimeException -> L11 ExecutionException -> L13 CancellationException -> L20
        return;
    L9:
        r12 = String.valueOf(r11);     // Catch: RuntimeException -> L11 ExecutionException -> L13 CancellationException -> L20
    L24:
        r10 = true;
    L15:
        th = move-exception;
        if (r10 == false) goto L18;
        Thread.currentThread().interrupt();     // Catch: RuntimeException -> L11 ExecutionException -> L13 CancellationException -> L20
    L18:
        throw th;     // Catch: RuntimeException -> L11 ExecutionException -> L13 CancellationException -> L20
    L20:
        String r13 = "CANCELLED";
    L21:
        r8.append(r13);
        return;
    L11:
        e = move-exception;
        r8.append("UNKNOWN, cause=[");
        r8.append(e.getClass());
        r13 = " thrown from get()]";
    L13:
        e = move-exception;
        r8.append("FAILURE, cause=[");
        r8.append(e.getCause());
        r8.append("]");
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean r8) {
        Object r10 = this.f9550a;
        if (r10 != null) goto L5;
        boolean r11 = true;
    L7:
        if ((r11 | (r10 instanceof f)) == false) goto L24;
        if (f9546n == false) goto L11;
        b r12 = new b(r8, new CancellationException("Future.cancel() was called."));
    L15:
        if (f9548p.b(this, r10, r12) == true) goto L16;
        r10 = this.f9550a;
        if ((r10 instanceof f) == true) goto L15;
    L16:
        c(this);
        if ((r10 instanceof f) == false) goto L29;
        ((f) r10).getClass();
        throw null;
    L29:
        return true;
    L11:
        if (r8 == false) goto L13;
        r12 = b.f9553b;
        goto L15
    L13:
        r12 = b.f9554c;
    L24:
        return false;
    L5:
        r11 = false;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final V e(Object r8) {
        if ((r8 instanceof b) == false) goto L5;
        Throwable r10 = ((b) r8).f9555a;
        CancellationException r11 = new CancellationException("Task was cancelled.");
        r11.initCause(r10);
        throw r11;
    L5:
        if ((r8 instanceof c) == true) goto L12;
        if (r8 != f9549q) goto L10;
        return null;
    L10:
        return r8;
    L12:
        throw new ExecutionException(((c) r8).f9556a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String f() {
        Object r8 = this.f9550a;
        if ((r8 instanceof f) == false) goto L7;
        StringBuilder r10 = new StringBuilder("setFuture=[");
        ((f) r8).getClass();
        r10.append("null");
        r10.append("]");
        return r10.toString();
    L7:
        if ((this instanceof ScheduledFuture) == true) goto L9;
        return null;
    L9:
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public final void g(h r8) {
        r8.f9567a = null;
    L3:
        h r10 = this.f9552m;
        if (r10 == h.f9566c) goto L5;
        h r11 = null;
    L7:
        if (r10 == null) goto L19;
        h r12 = r10.f9568b;
        if (r10.f9567a == null) goto L11;
        r11 = r10;
    L18:
        r10 = r12;
        goto L7
    L11:
        if (r11 == null) goto L16;
        r11.f9568b = r12;
        if (r11.f9567a != null) goto L18;
    L16:
        if (f9548p.c(this, r10, r12) == true) goto L18;
    L19:
        return;
    }

    @Override // java.util.concurrent.Future
    public final V get() {
        if (Thread.interrupted() == true) goto L34;
        Object r8 = this.f9550a;
        if (r8 == null) goto L7;
        boolean r10 = true;
    L9:
        if ((r10 & (!(r8 instanceof f))) == true) goto L11;
        h r11 = this.f9552m;
        h r12 = h.f9566c;
        if (r11 == r12) goto L32;
        h r13 = new h();
    L15:
        AbstractC0124a r14 = f9548p;
        r14.d(r13, r11);
        if (r14.c(this, r11, r13) == true) goto L17;
        r11 = this.f9552m;
        if (r11 != r12) goto L15;
    L17:
        LockSupport.park(this);
        if (Thread.interrupted() == true) goto L27;
        Object r15 = this.f9550a;
        if (r15 == null) goto L22;
        boolean r16 = true;
    L24:
        if ((r16 & (!(r15 instanceof f))) == false) goto L17;
        return e(r15);
    L22:
        r16 = false;
        goto L24
    L27:
        g(r13);
        throw new InterruptedException();
    L32:
        return e(this.f9550a);
    L11:
        return e(r8);
    L7:
        r10 = false;
        goto L9
    L34:
        throw new InterruptedException();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f9550a instanceof b;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        Object r8 = this.f9550a;
        if (r8 == null) goto L5;
        boolean r10 = true;
    L7:
        return (!(r8 instanceof f)) & r10;
    L5:
        r10 = false;
        goto L7
    }

    public final String toString() {
        StringBuilder r8 = new StringBuilder();
        r8.append(super.toString());
        r8.append("[status=");
        if ((this.f9550a instanceof b) == false) goto L7;
        String r10 = "CANCELLED";
    L5:
        r8.append(r10);
    L21:
        r8.append("]");
        return r8.toString();
    L7:
        if (isDone() == false) goto L23;
    L8:
        b(r8);
        goto L21
    L23:
        String r11 = f();     // Catch: RuntimeException -> L11
    L13:
        if (r11 == null) goto L18;
        if (r11.isEmpty() == true) goto L18;
        r8.append("PENDING, info=[");
        r8.append(r11);
        r8.append("]");
    L18:
        if (isDone() == true) goto L8;
        r10 = "PENDING";
    L11:
        e = move-exception;
        r11 = "Exception thrown from implementation: " + e.getClass();
        goto L13
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x00b6 -> B:56:0x00bc). Please report as a decompilation issue!!! */
    @Override // java.util.concurrent.Future
    public final V get(long r18, TimeUnit r20) {
        long r8 = r20.toNanos(r18);
        if (Thread.interrupted() == true) goto L82;
        Object r10 = this.f9550a;
        if (r10 == null) goto L7;
        boolean r11 = true;
    L9:
        if ((r11 & (!(r10 instanceof f))) == false) goto L13;
        return e(r10);
    L13:
        if (r8 <= 0) goto L15;
        long r12 = System.nanoTime() + r8;
    L17:
        if (r8 < 1000) goto L42;
        h r13 = this.f9552m;
        h r14 = h.f9566c;
        if (r13 == r14) goto L41;
        h r15 = new h();
    L21:
        AbstractC0124a r16 = f9548p;
        r16.d(r15, r13);
        if (r16.c(this, r13, r15) == true) goto L23;
        r13 = this.f9552m;
        if (r13 != r14) goto L21;
    L23:
        LockSupport.parkNanos(this, r8);
        if (Thread.interrupted() == true) goto L36;
        Object r17 = this.f9550a;
        if (r17 == null) goto L28;
        boolean r19 = true;
    L30:
        if ((r19 & (!(r17 instanceof f))) == true) goto L32;
        r8 = r12 - System.nanoTime();
        if (r8 >= 1000) goto L23;
        g(r15);
        boolean r21 = true;
        long r110 = 1000;
        long r22 = r8;
        long r111 = r12;
        TimeUnit r23 = r20;
        TimeUnit r24 = r23;
        long r25 = r18;
        a<V> r26 = this;
    L56:
        long r27 = 0;
    L44:
        if (r22 <= r27) goto L59;
        Object r28 = r26.f9550a;
        if (r28 == null) goto L48;
        boolean r29 = r21;
    L50:
        if ((r29 & ((r28 instanceof f) ^ r21)) == false) goto L54;
        return r26.e(r28);
    L54:
        if (Thread.interrupted() == true) goto L58;
        r22 = r111 - System.nanoTime();
        goto L56
    L58:
        throw new InterruptedException();
    L48:
        r29 = false;
        goto L50
    L59:
        String r30 = toString();
        String r31 = r23.toString();
        Locale r112 = Locale.ROOT;
        String r32 = r31.toLowerCase(r112);
        String r33 = "Waited " + r25 + " " + r23.toString().toLowerCase(r112);
        if ((r22 + r110) >= 0) goto L76;
        String r34 = defpackage.a.e(r33, " (plus ");
        long r35 = -r22;
        long r113 = r24.convert(r35, TimeUnit.NANOSECONDS);
        long r36 = r35 - r24.toNanos(r113);
        if (r113 != 0) goto L64;
    L67:
        if (r113 <= 0) goto L72;
        String r37 = r34 + r113 + " " + r32;
        if (r21 == false) goto L71;
        r37 = defpackage.a.e(r37, ",");
    L71:
        r34 = defpackage.a.e(r37, " ");
    L72:
        if (r21 == false) goto L74;
        r34 = r34 + r36 + " nanoseconds ";
    L74:
        r33 = defpackage.a.e(r34, "delay)");
        goto L76
    L64:
        if (r36 > r110) goto L67;
        r21 = false;
    L76:
        if (isDone() == false) goto L80;
        throw new TimeoutException(defpackage.a.e(r33, " but future completed as timeout expired"));
    L80:
        throw new TimeoutException(defpackage.a.f(r33, " for ", r30));
    L32:
        return e(r17);
    L28:
        r19 = false;
        goto L30
    L36:
        g(r15);
        throw new InterruptedException();
    L41:
        return e(this.f9550a);
    L42:
        r110 = 1000;
        r111 = r12;
        r27 = 0;
        r21 = true;
        r22 = r8;
        r23 = r20;
        r24 = r23;
        r25 = r18;
        r26 = this;
        goto L44
    L15:
        r12 = 0;
        goto L17
    L7:
        r11 = false;
        goto L9
    L82:
        throw new InterruptedException();
    }
}
