package t1;

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
    public static final boolean f12212n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Logger f12213o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final AbstractC0159a f12214p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Object f12215q = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Object f12216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile d f12217b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile h f12218m;

    /* JADX INFO: renamed from: t1.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0159a {
        public abstract boolean a(a<?> r8, d r10, d r11);

        public abstract boolean b(a<?> r8, Object r10, Object r11);

        public abstract boolean c(a<?> r8, h r10, h r11);

        public abstract void d(h r8, h r10);

        public abstract void e(h r8, Thread r10);
    }

    public static final class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f12219c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f12220d = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f12221a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Throwable f12222b;

        static {
            if (a.f12212n == false) goto L5;
            f12220d = null;
            f12219c = null;
            return;
        L5:
            f12220d = new b(false, null);
            f12219c = new b(true, null);
        }

        public b(boolean r8, Throwable r10) {
            this.f12221a = r8;
            this.f12222b = r10;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f12223b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f12224a;

        /* JADX INFO: renamed from: t1.a$c$a, reason: collision with other inner class name */
        public class C0160a extends Throwable {
            public C0160a() {
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
            f12223b = new c(new C0160a());
        }

        public c(Throwable r8) {
            boolean r10 = a.f12212n;
            r8.getClass();
            this.f12224a = r8;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final d f12225d = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f12226a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f12227b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public d f12228c;

        static {
            f12225d = new d(null, null);
        }

        public d(Executor r8, Runnable r10) {
            this.f12226a = r10;
            this.f12227b = r8;
        }
    }

    public static final class e extends AbstractC0159a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<h, Thread> f12229a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<h, h> f12230b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<a, h> f12231c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<a, d> f12232d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<a, Object> f12233e;

        public e(AtomicReferenceFieldUpdater<h, Thread> r8, AtomicReferenceFieldUpdater<h, h> r10, AtomicReferenceFieldUpdater<a, h> r11, AtomicReferenceFieldUpdater<a, d> r12, AtomicReferenceFieldUpdater<a, Object> r13) {
            this.f12229a = r8;
            this.f12230b = r10;
            this.f12231c = r11;
            this.f12232d = r12;
            this.f12233e = r13;
        }

        @Override // t1.a.AbstractC0159a
        public final boolean a(a<?> r8, d r10, d r11) {
        L2:
            AtomicReferenceFieldUpdater<a, d> r12 = this.f12232d;
            if (r12.compareAndSet(r8, r10, r11) == true) goto L4;
            if (r12.get(r8) == r10) goto L2;
            return false;
        L4:
            return true;
        }

        @Override // t1.a.AbstractC0159a
        public final boolean b(a<?> r8, Object r10, Object r11) {
        L2:
            AtomicReferenceFieldUpdater<a, Object> r12 = this.f12233e;
            if (r12.compareAndSet(r8, r10, r11) == true) goto L4;
            if (r12.get(r8) == r10) goto L2;
            return false;
        L4:
            return true;
        }

        @Override // t1.a.AbstractC0159a
        public final boolean c(a<?> r8, h r10, h r11) {
        L2:
            AtomicReferenceFieldUpdater<a, h> r12 = this.f12231c;
            if (r12.compareAndSet(r8, r10, r11) == true) goto L4;
            if (r12.get(r8) == r10) goto L2;
            return false;
        L4:
            return true;
        }

        @Override // t1.a.AbstractC0159a
        public final void d(h r8, h r10) {
            this.f12230b.lazySet(r8, r10);
        }

        @Override // t1.a.AbstractC0159a
        public final void e(h r8, Thread r10) {
            this.f12229a.lazySet(r8, r10);
        }
    }

    public static final class f<V> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a<V> f12234a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ga.a<? extends V> f12235b;

        public f(a<V> r8, ga.a<? extends V> r10) {
            this.f12234a = r8;
            this.f12235b = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f12234a.f12216a == this) goto L5;
            return;
        L5:
            Object r8 = a.f(this.f12235b);
            if (a.f12214p.b(this.f12234a, this, r8) == false) goto L9;
            a.c(this.f12234a);
            return;
        }
    }

    public static final class g extends AbstractC0159a {
        @Override // t1.a.AbstractC0159a
        public final boolean a(a<?> r8, d r10, d r11) {
            monitor-enter(r8);
        L12:
            th = move-exception;
            throw th;
        L4:
            if (r8.f12217b != r10) goto L9;
            r8.f12217b = r11;     // Catch: Throwable -> L12
            monitor-exit(r8);     // Catch: Throwable -> L12
            return true;
        L9:
            monitor-exit(r8);     // Catch: Throwable -> L12
            return false;
        }

        @Override // t1.a.AbstractC0159a
        public final boolean b(a<?> r8, Object r10, Object r11) {
            monitor-enter(r8);
        L12:
            th = move-exception;
            throw th;
        L4:
            if (r8.f12216a != r10) goto L9;
            r8.f12216a = r11;     // Catch: Throwable -> L12
            monitor-exit(r8);     // Catch: Throwable -> L12
            return true;
        L9:
            monitor-exit(r8);     // Catch: Throwable -> L12
            return false;
        }

        @Override // t1.a.AbstractC0159a
        public final boolean c(a<?> r8, h r10, h r11) {
            monitor-enter(r8);
        L12:
            th = move-exception;
            throw th;
        L4:
            if (r8.f12218m != r10) goto L9;
            r8.f12218m = r11;     // Catch: Throwable -> L12
            monitor-exit(r8);     // Catch: Throwable -> L12
            return true;
        L9:
            monitor-exit(r8);     // Catch: Throwable -> L12
            return false;
        }

        @Override // t1.a.AbstractC0159a
        public final void d(h r8, h r10) {
            r8.f12238b = r10;
        }

        @Override // t1.a.AbstractC0159a
        public final void e(h r8, Thread r10) {
            r8.f12237a = r10;
        }
    }

    public static final class h {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final h f12236c = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile Thread f12237a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile h f12238b;

        static {
            f12236c = new h(0);
        }

        public h() {
            a.f12214p.e(this, Thread.currentThread());
        }

        public h(int r8) {
        }
    }

    static {
        f12212n = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        f12213o = Logger.getLogger(a.class.getName());
        AbstractC0159a r8 = new e(AtomicReferenceFieldUpdater.newUpdater(h.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(h.class, h.class, "b"), AtomicReferenceFieldUpdater.newUpdater(a.class, h.class, "m"), AtomicReferenceFieldUpdater.newUpdater(a.class, d.class, "b"), AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "a"));     // Catch: Throwable -> L5
        th = null;
    L7:
        f12214p = r8;
        if (th == null) goto L10;
        f12213o.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
    L10:
        f12215q = new Object();
        return;
    L5:
        th = th;
        r8 = new g();
        goto L7
    }

    public a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [t1.a$a] */
    /* JADX WARN: Type inference failed for: r3v2, types: [t1.a$a] */
    /* JADX WARN: Type inference failed for: r6v0, types: [t1.a<?>] */
    /* JADX WARN: Type inference failed for: r6v1, types: [t1.a] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void c(a<?> r8) {
        d r10 = null;
    L3:
        h r11 = r8.f12218m;
        if (f12214p.c(r8, r11, h.f12236c) == false) goto L3;
    L5:
        if (r11 == null) goto L10;
        Thread r12 = r11.f12237a;
        if (r12 == null) goto L9;
        r11.f12237a = null;
        LockSupport.unpark(r12);
    L9:
        r11 = r11.f12238b;
    L10:
        d r13 = r8.f12217b;
        if (f12214p.a(r8, r13, d.f12225d) == false) goto L10;
    L12:
        if (r13 == null) goto L14;
        d r14 = r13.f12228c;
        r13.f12228c = r10;
        r10 = r13;
        r13 = r14;
    L14:
        if (r10 == null) goto L24;
        d r15 = r10.f12228c;
        Runnable r16 = r10.f12226a;
        if ((r16 instanceof f) == false) goto L22;
        f r17 = (f) r16;
        a<V> r18 = r17.f12234a;
        if (r18.f12216a != r17) goto L23;
        if (f12214p.b(r18, r17, f(r17.f12235b)) == false) goto L23;
        r10 = r15;
        r8 = r18;
    L23:
        r10 = r15;
        goto L14
    L22:
        d(r10.f12227b, r16);
        goto L23
    }

    public static void d(Executor r8, Runnable r10) {
        r8.execute(r10);     // Catch: RuntimeException -> L4
        return;
    L4:
        e = move-exception;
        f12213o.log(Level.SEVERE, "RuntimeException while executing runnable " + r10 + " with executor " + r8, e);
    }

    public static Object f(ga.a<?> r8) {
        if ((r8 instanceof a) == false) goto L13;
        Object r10 = ((a) r8).f12216a;
        if ((r10 instanceof b) == false) goto L47;
        b r11 = (b) r10;
        if (r11.f12221a == true) goto L9;
        return r10;
    L9:
        if (r11.f12222b == null) goto L12;
        return new b(false, r11.f12222b);
    L12:
        return b.f12220d;
    L47:
        return r10;
    L13:
        boolean r12 = r8.isCancelled();
        boolean r13 = true;
        if (((!f12212n) & r12) == true) goto L16;
        boolean r14 = false;
    L44:
        Object r15 = r8.get();     // Catch: Throwable -> L30 InterruptedException -> L43
    L19:
        if (r14 == false) goto L21;
        Thread.currentThread().interrupt();     // Catch: Throwable -> L23 CancellationException -> L25 ExecutionException -> L27
    L21:
        if (r15 == null) goto L50;
        return r15;
    L50:
        return f12215q;
    L43:
        r14 = r13;
    L30:
        th = move-exception;
        if (r14 == false) goto L33;
        Thread.currentThread().interrupt();     // Catch: Throwable -> L23 CancellationException -> L25 ExecutionException -> L27
    L33:
        throw th;     // Catch: Throwable -> L23 CancellationException -> L25 ExecutionException -> L27
    L25:
        e = move-exception;
        if (r12 == true) goto L40;
        return new c(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + r8, e));
    L40:
        return new b(false, e);
    L27:
        e = move-exception;
        return new c(e.getCause());
    L23:
        th = move-exception;
        return new c(th);
    L16:
        return b.f12220d;
    }

    @Override // ga.a
    public final void a(Executor r8, Runnable r10) {
        r8.getClass();
        d r11 = this.f12217b;
        d r12 = d.f12225d;
        if (r11 == r12) goto L10;
        d r13 = new d(r8, r10);
    L5:
        r13.f12228c = r11;
        if (f12214p.a(this, r11, r13) == true) goto L7;
        r11 = this.f12217b;
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
        Object r10 = this.f12216a;
        if (r10 != null) goto L5;
        boolean r11 = true;
    L7:
        if ((r11 | (r10 instanceof f)) == false) goto L33;
        if (f12212n == false) goto L11;
        b r12 = new b(r8, new CancellationException("Future.cancel() was called."));
    L14:
        boolean r13 = false;
    L16:
        if (f12214p.b(this, r10, r12) == true) goto L17;
        r10 = this.f12216a;
        if ((r10 instanceof f) == true) goto L16;
        return r13;
    L17:
        c(this);
        if ((r10 instanceof f) == false) goto L45;
        ga.a<? extends V> r14 = ((f) r10).f12235b;
        if ((r14 instanceof a) == false) goto L28;
        a<V> this = (a) r14;
        r10 = this.f12216a;
        if (r10 != null) goto L24;
        boolean r15 = true;
    L26:
        if ((r15 | (r10 instanceof f)) == false) goto L46;
        r13 = true;
        goto L16
    L46:
        return true;
    L24:
        r15 = false;
        goto L26
    L28:
        r14.cancel(r8);
        return true;
    L45:
        return true;
    L11:
        if (r8 == false) goto L13;
        r12 = b.f12219c;
        goto L14
    L13:
        r12 = b.f12220d;
        goto L14
    L33:
        return false;
    L5:
        r11 = false;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final V e(Object r8) {
        if ((r8 instanceof b) == false) goto L5;
        Throwable r10 = ((b) r8).f12222b;
        CancellationException r11 = new CancellationException("Task was cancelled.");
        r11.initCause(r10);
        throw r11;
    L5:
        if ((r8 instanceof c) == true) goto L12;
        if (r8 != f12215q) goto L10;
        return null;
    L10:
        return r8;
    L12:
        throw new ExecutionException(((c) r8).f12224a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String g() {
        Object r8 = this.f12216a;
        if ((r8 instanceof f) == false) goto L11;
        StringBuilder r10 = new StringBuilder("setFuture=[");
        ga.a<? extends V> r11 = ((f) r8).f12235b;
        if (r11 != this) goto L7;
        String r12 = "this future";
    L9:
        return android.aimedia.a.i(r10, r12, "]");
    L7:
        r12 = String.valueOf(r11);
        goto L9
    L11:
        if ((this instanceof ScheduledFuture) == true) goto L13;
        return null;
    L13:
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    @Override // java.util.concurrent.Future
    public final V get() {
        if (Thread.interrupted() == true) goto L34;
        Object r8 = this.f12216a;
        if (r8 == null) goto L7;
        boolean r10 = true;
    L9:
        if ((r10 & (!(r8 instanceof f))) == true) goto L11;
        h r11 = this.f12218m;
        h r12 = h.f12236c;
        if (r11 == r12) goto L32;
        h r13 = new h();
    L15:
        AbstractC0159a r14 = f12214p;
        r14.d(r13, r11);
        if (r14.c(this, r11, r13) == true) goto L17;
        r11 = this.f12218m;
        if (r11 != r12) goto L15;
    L17:
        LockSupport.park(this);
        if (Thread.interrupted() == true) goto L27;
        Object r15 = this.f12216a;
        if (r15 == null) goto L22;
        boolean r16 = true;
    L24:
        if ((r16 & (!(r15 instanceof f))) == false) goto L17;
        return e(r15);
    L22:
        r16 = false;
        goto L24
    L27:
        h(r13);
        throw new InterruptedException();
    L32:
        return e(this.f12216a);
    L11:
        return e(r8);
    L7:
        r10 = false;
        goto L9
    L34:
        throw new InterruptedException();
    }

    public final void h(h r8) {
        r8.f12237a = null;
    L3:
        h r10 = this.f12218m;
        if (r10 == h.f12236c) goto L5;
        h r11 = null;
    L7:
        if (r10 == null) goto L19;
        h r12 = r10.f12238b;
        if (r10.f12237a == null) goto L11;
        r11 = r10;
    L18:
        r10 = r12;
        goto L7
    L11:
        if (r11 == null) goto L16;
        r11.f12238b = r12;
        if (r11.f12237a != null) goto L18;
    L16:
        if (f12214p.c(this, r10, r12) == true) goto L18;
    L19:
        return;
    }

    public boolean i(ga.a<? extends V> r8) {
        r8.getClass();
        Object r10 = this.f12216a;
        if (r10 != null) goto L23;
        if (r8.isDone() == false) goto L11;
        Object r11 = f(r8);
        if (f12214p.b(this, null, r11) == false) goto L10;
        c(this);
        return true;
    L10:
        return false;
    L11:
        f r12 = new f(this, r8);
        if (f12214p.b(this, null, r12) == true) goto L26;
        r10 = this.f12216a;
        goto L23
    L26:
        r8.a(t1.b.f12239a, r12);     // Catch: Throwable -> L15
    L20:
        return true;
    L15:
        th = move-exception;
        c r13 = new c(th);     // Catch: Throwable -> L18
    L19:
        f12214p.b(this, r12, r13);
    L18:
        r13 = c.f12223b;
    L23:
        if ((r10 instanceof b) == false) goto L25;
        r8.cancel(((b) r10).f12221a);
    L25:
        return false;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f12216a instanceof b;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        Object r8 = this.f12216a;
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
        if ((this.f12216a instanceof b) == false) goto L7;
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
        String r11 = g();     // Catch: RuntimeException -> L11
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
        Object r10 = this.f12216a;
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
        h r13 = this.f12218m;
        h r14 = h.f12236c;
        if (r13 == r14) goto L41;
        h r15 = new h();
    L21:
        AbstractC0159a r16 = f12214p;
        r16.d(r15, r13);
        if (r16.c(this, r13, r15) == true) goto L23;
        r13 = this.f12218m;
        if (r13 != r14) goto L21;
    L23:
        LockSupport.parkNanos(this, r8);
        if (Thread.interrupted() == true) goto L36;
        Object r17 = this.f12216a;
        if (r17 == null) goto L28;
        boolean r19 = true;
    L30:
        if ((r19 & (!(r17 instanceof f))) == true) goto L32;
        r8 = r12 - System.nanoTime();
        if (r8 >= 1000) goto L23;
        h(r15);
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
        Object r28 = r26.f12216a;
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
        h(r15);
        throw new InterruptedException();
    L41:
        return e(this.f12216a);
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
