package com.google.common.util.concurrent;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<V> extends com.google.common.util.concurrent.a.a implements l<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final boolean f4831a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Logger f4832b = null;
    private static final AbstractC0205a c = null;
    private static final Object d = null;
    private volatile d listeners;
    private volatile Object value;
    private volatile k waiters;

    /* JADX INFO: renamed from: com.google.common.util.concurrent.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: renamed from: com.google.common.util.concurrent.a$a, reason: collision with other inner class name */
    private static abstract class AbstractC0205a {
        private AbstractC0205a() {
        }

        /* synthetic */ AbstractC0205a(AnonymousClass1 r1) {
            this();
        }

        abstract d a(a<?> r1, d r2);

        abstract k a(a<?> r1, k r2);

        abstract void a(k r1, k r2);

        abstract void a(k r1, Thread r2);

        abstract boolean a(a<?> r1, d r2, d r3);

        abstract boolean a(a<?> r1, k r2, k r3);

        abstract boolean a(a<?> r1, Object r2, Object r3);
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final b f4833a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final b f4834b = null;
        final boolean c;
        final Throwable d;

        static {
            if (a.f4831a == false) goto L5;
            f4834b = null;
            f4833a = null;
            return;
        L5:
            f4834b = new b(false, null);
            f4833a = new b(true, null);
        }

        b(boolean r1, Throwable r2) {
            this.c = r1;
            this.d = r2;
        }
    }

    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final c f4835a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Throwable f4836b;

        static {
            final String r2 = "Failure occurred while trying to finish a future.";
            f4835a = new c(new AbstractFuture$Failure$1(r2));
        }

        c(Throwable r3) {
            this.f4836b = (Throwable) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r3), Throwable.class, "com.obric.memorydata.plugin");
        }
    }

    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final d f4837a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Runnable f4838b;
        final Executor c;
        d next;

        static {
            f4837a = new d();
        }

        d() {
            this.f4838b = null;
            this.c = null;
        }

        d(Runnable r3, Executor r4) {
            Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
            Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.memorydata.plugin");
            this.f4838b = r5;
            this.c = r6;
        }
    }

    private static final class e extends AbstractC0205a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<k, Thread> f4839a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<k, k> f4840b;
        final AtomicReferenceFieldUpdater<a, k> c;
        final AtomicReferenceFieldUpdater<a, d> d;
        final AtomicReferenceFieldUpdater<a, Object> e;

        e(AtomicReferenceFieldUpdater<k, Thread> r2, AtomicReferenceFieldUpdater<k, k> r3, AtomicReferenceFieldUpdater<a, k> r4, AtomicReferenceFieldUpdater<a, d> r5, AtomicReferenceFieldUpdater<a, Object> r6) {
            super(null);
            this.f4839a = r2;
            this.f4840b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }

        @Override // com.google.common.util.concurrent.a.AbstractC0205a
        d a(a<?> r1, d r2) {
            return (d) ZeusTransformUtils.preCheckCast(this.d.getAndSet(r1, r2), d.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.util.concurrent.a.AbstractC0205a
        k a(a<?> r1, k r2) {
            return (k) ZeusTransformUtils.preCheckCast(this.c.getAndSet(r1, r2), k.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.util.concurrent.a.AbstractC0205a
        void a(k r1, k r2) {
            this.f4840b.lazySet(r1, r2);
        }

        @Override // com.google.common.util.concurrent.a.AbstractC0205a
        void a(k r1, Thread r2) {
            this.f4839a.lazySet(r1, r2);
        }

        @Override // com.google.common.util.concurrent.a.AbstractC0205a
        boolean a(a<?> r1, d r2, d r3) {
            return this.d.compareAndSet(r1, r2, r3);
        }

        @Override // com.google.common.util.concurrent.a.AbstractC0205a
        boolean a(a<?> r1, k r2, k r3) {
            return this.c.compareAndSet(r1, r2, r3);
        }

        @Override // com.google.common.util.concurrent.a.AbstractC0205a
        boolean a(a<?> r1, Object r2, Object r3) {
            return this.e.compareAndSet(r1, r2, r3);
        }
    }

    private static final class f<V> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final a<V> f4841a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final l<? extends V> f4842b;

        f(a<V> r3, l<? extends V> r4) {
            l<? extends V> r5 = (l) ZeusTransformUtils.wrapperContextForParams(r4, l.class, "com.obric.memorydata.plugin");
            this.f4841a = r3;
            this.f4842b = r5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.a(this.f4841a) == this) goto L5;
            return;
        L5:
            Object r0 = a.b(this.f4842b);
            if (a.f().a(this.f4841a, this, r0) == false) goto L9;
            a.a(this.f4841a, false);
            return;
        }
    }

    private static final class g extends AbstractC0205a {
        private g() {
            super(null);
        }

        /* synthetic */ g(AnonymousClass1 r1) {
            this();
        }

        @Override // com.google.common.util.concurrent.a.AbstractC0205a
        d a(a<?> r1, d r2) {
            monitor-enter(r1);
            d r0 = a.c(r1);     // Catch: Throwable -> L8
            if (r0 == r2) goto L6;
            a.a(r1, r2);     // Catch: Throwable -> L8
        L6:
            monitor-exit(r1);     // Catch: Throwable -> L8
            return r0;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.util.concurrent.a.AbstractC0205a
        k a(a<?> r1, k r2) {
            monitor-enter(r1);
            k r0 = a.b(r1);     // Catch: Throwable -> L8
            if (r0 == r2) goto L6;
            a.a(r1, r2);     // Catch: Throwable -> L8
        L6:
            monitor-exit(r1);     // Catch: Throwable -> L8
            return r0;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.util.concurrent.a.AbstractC0205a
        void a(k r1, k r2) {
            r1.next = r2;
        }

        @Override // com.google.common.util.concurrent.a.AbstractC0205a
        void a(k r1, Thread r2) {
            r1.thread = r2;
        }

        @Override // com.google.common.util.concurrent.a.AbstractC0205a
        boolean a(a<?> r1, d r2, d r3) {
            monitor-enter(r1);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (a.c(r1) != r2) goto L9;
            a.a(r1, r3);     // Catch: Throwable -> L11
            monitor-exit(r1);     // Catch: Throwable -> L11
            return true;
        L9:
            monitor-exit(r1);     // Catch: Throwable -> L11
            return false;
        }

        @Override // com.google.common.util.concurrent.a.AbstractC0205a
        boolean a(a<?> r1, k r2, k r3) {
            monitor-enter(r1);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (a.b(r1) != r2) goto L9;
            a.a(r1, r3);     // Catch: Throwable -> L11
            monitor-exit(r1);     // Catch: Throwable -> L11
            return true;
        L9:
            monitor-exit(r1);     // Catch: Throwable -> L11
            return false;
        }

        @Override // com.google.common.util.concurrent.a.AbstractC0205a
        boolean a(a<?> r1, Object r2, Object r3) {
            monitor-enter(r1);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (a.a(r1) != r2) goto L9;
            a.a(r1, r3);     // Catch: Throwable -> L11
            monitor-exit(r1);     // Catch: Throwable -> L11
            return true;
        L9:
            monitor-exit(r1);     // Catch: Throwable -> L11
            return false;
        }
    }

    interface h<V> extends l<V> {
    }

    static abstract class i<V> extends a<V> implements h<V> {
        i() {
        }

        @Override // com.google.common.util.concurrent.a, com.google.common.util.concurrent.l
        public final void addListener(Runnable r3, Executor r4) {
            super.addListener((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin"), (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.util.concurrent.a, java.util.concurrent.Future
        public final boolean cancel(boolean r1) {
            return super.cancel(r1);
        }

        @Override // com.google.common.util.concurrent.a, java.util.concurrent.Future
        public final V get() {
            return (V) super.get();
        }

        @Override // com.google.common.util.concurrent.a, java.util.concurrent.Future
        public final V get(long r1, TimeUnit r3) {
            return (V) super.get(r1, r3);
        }

        @Override // com.google.common.util.concurrent.a, java.util.concurrent.Future
        public final boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // com.google.common.util.concurrent.a, java.util.concurrent.Future
        public final boolean isDone() {
            return super.isDone();
        }
    }

    private static final class j extends AbstractC0205a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Unsafe f4843a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final long f4844b = 0;
        static final long c = 0;
        static final long d = 0;
        static final long e = 0;
        static final long f = 0;

        static {
            Unsafe r0 = Unsafe.getUnsafe();     // Catch: SecurityException -> L4
        L18:
            c = r0.objectFieldOffset(a.class.getDeclaredField("waiters"));     // Catch: RuntimeException -> L7 NoSuchFieldException -> L9
            f4844b = r0.objectFieldOffset(a.class.getDeclaredField("listeners"));     // Catch: RuntimeException -> L7 NoSuchFieldException -> L9
            d = r0.objectFieldOffset(a.class.getDeclaredField(EventBody.KEY_VALUE));     // Catch: RuntimeException -> L7 NoSuchFieldException -> L9
            e = r0.objectFieldOffset(k.class.getDeclaredField("thread"));     // Catch: RuntimeException -> L7 NoSuchFieldException -> L9
            f = r0.objectFieldOffset(k.class.getDeclaredField("next"));     // Catch: RuntimeException -> L7 NoSuchFieldException -> L9
            f4843a = r0;     // Catch: RuntimeException -> L7 NoSuchFieldException -> L9
            return;
        L9:
            e = move-exception;
            throw new RuntimeException(e);
        L7:
            e = move-exception;
            throw e;
        L4:
            r0 = (Unsafe) ZeusTransformUtils.preCheckCast(AccessController.doPrivileged(new AnonymousClass1()), Unsafe.class, "com.obric.memorydata.plugin");     // Catch: PrivilegedActionException -> L12
        L12:
            e = move-exception;
            throw new RuntimeException("Could not initialize intrinsics", e.getCause());
        }

        private j() {
            super(null);
        }

        /* synthetic */ j(AnonymousClass1 r1) {
            this();
        }

        @Override // com.google.common.util.concurrent.a.AbstractC0205a
        d a(a<?> r3, d r4) {
            return (d) ZeusTransformUtils.preCheckCast(f4843a.getAndSetObject(r3, f4844b, r4), d.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.util.concurrent.a.AbstractC0205a
        k a(a<?> r3, k r4) {
            return (k) ZeusTransformUtils.preCheckCast(f4843a.getAndSetObject(r3, c, r4), k.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.util.concurrent.a.AbstractC0205a
        void a(k r3, k r4) {
            f4843a.putObject(r3, f, r4);
        }

        @Override // com.google.common.util.concurrent.a.AbstractC0205a
        void a(k r3, Thread r4) {
            f4843a.putObject(r3, e, r4);
        }

        @Override // com.google.common.util.concurrent.a.AbstractC0205a
        boolean a(a<?> r7, d r8, d r9) {
            return f4843a.compareAndSwapObject(r7, f4844b, r8, r9);
        }

        @Override // com.google.common.util.concurrent.a.AbstractC0205a
        boolean a(a<?> r7, k r8, k r9) {
            return f4843a.compareAndSwapObject(r7, c, r8, r9);
        }

        @Override // com.google.common.util.concurrent.a.AbstractC0205a
        boolean a(a<?> r7, Object r8, Object r9) {
            return f4843a.compareAndSwapObject(r7, d, r8, r9);
        }
    }

    private static final class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final k f4845a = null;
        volatile k next;
        volatile Thread thread;

        static {
            f4845a = new k(false);
        }

        k() {
            a.f().a(this, Thread.currentThread());
        }

        k(boolean r1) {
        }

        void a() {
            Thread r0 = this.thread;
            if (r0 == null) goto L6;
            this.thread = null;
            LockSupport.unpark(r0);
            return;
        }

        void a(k r2) {
            a.f().a(this, r2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.logging.Logger] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.google.common.util.concurrent.a$1] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.Throwable] */
    static {
        boolean r1 = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));     // Catch: SecurityException -> L5
    L6:
        f4831a = r1;
        f4832b = Logger.getLogger(a.class.getName());
        ?? r2 = 0;
        r2 = 0;
        AbstractC0205a r3 = new j(r2);     // Catch: Throwable -> L9
        e = null;
    L14:
        c = r3;
        if (r2 == 0) goto L17;
        ?? r0 = f4832b;
        r0.log(Level.SEVERE, "UnsafeAtomicHelper is broken!", e);
        r0.log(Level.SEVERE, "SafeAtomicHelper is broken!", r2);
    L17:
        d = new Object();
        return;
    L9:
        e = e;
        r3 = new e(AtomicReferenceFieldUpdater.newUpdater(k.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(k.class, k.class, "next"), AtomicReferenceFieldUpdater.newUpdater(a.class, k.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(a.class, d.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, EventBody.KEY_VALUE));     // Catch: Throwable -> L12
    L12:
        e = move-exception;
        r3 = new g(r2);
        r2 = e;
    L5:
        r1 = false;
        goto L6
    }

    public a() {
    }

    private d a(d r4) {
        d r5 = c.a(this, d.f4837a);
        d r3 = r4;
    L3:
        if (r5 == null) goto L5;
        d r0 = r5.next;
        r5.next = r3;
        r3 = r5;
        r5 = r0;
        goto L3
    L5:
        return r3;
    }

    static /* synthetic */ d a(a r0, d r1) {
        r0.listeners = r1;
        return r1;
    }

    static /* synthetic */ k a(a r0, k r1) {
        r0.waiters = r1;
        return r1;
    }

    static /* synthetic */ Object a(a r0) {
        return r0.value;
    }

    static /* synthetic */ Object a(a r0, Object r1) {
        r0.value = r1;
        return r1;
    }

    private static CancellationException a(String r1, Throwable r2) {
        CancellationException r0 = new CancellationException(r1);
        r0.initCause(r2);
        return r0;
    }

    private void a(k r5) {
        r5.thread = null;
    L3:
        k r6 = this.waiters;
        if (r6 == k.f4845a) goto L5;
        k r1 = null;
    L7:
        if (r6 == null) goto L19;
        k r2 = r6.next;
        if (r6.thread == null) goto L11;
        r1 = r6;
    L18:
        r6 = r2;
        goto L7
    L11:
        if (r1 == null) goto L16;
        r1.next = r2;
        if (r1.thread != null) goto L18;
    L16:
        if (c.a(this, r6, r2) == true) goto L18;
    L19:
        return;
    }

    static /* synthetic */ void a(a r0, boolean r1) {
        b(r0, r1);
    }

    private static void a(Runnable r5, Executor r6) {
        Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.memorydata.plugin");
        Executor r8 = (Executor) ZeusTransformUtils.wrapperContextForParams(r6, Executor.class, "com.obric.memorydata.plugin");
        r8.execute(r7);     // Catch: RuntimeException -> L5
        return;
    L5:
        e = move-exception;
        f4832b.log(Level.SEVERE, "RuntimeException while executing runnable " + r7 + " with executor " + r8, e);
    }

    private void a(StringBuilder r6) {
        int r0 = r6.length();
        r6.append("PENDING");
        Object r1 = this.value;
        if (ZeusTransformUtils.instanceOf(r1, f.class) == false) goto L15;
        r6.append(", setFuture=[");
        b(r6, ((f) ZeusTransformUtils.preCheckCast(r1, f.class, "com.obric.memorydata.plugin")).f4842b);
        r6.append("]");
    L12:
        if (isDone() == false) goto L17;
        r6.delete(r0, r6.length());
        b(r6);
        return;
    L17:
        return;
    L15:
        String r2 = com.google.common.base.q.a(e());     // Catch: Throwable -> L7
    L9:
        if (r2 == null) goto L12;
        r6.append(", info=[").append(r2).append("]");
    L7:
        e = move-exception;
        r2 = "Exception thrown from implementation: " + e.getClass();
        goto L9
    }

    private void a(StringBuilder r1, Object r2) {
        if (r2 != null) goto L5;
        String r0 = "null";
    L4:
        r1.append(r0);
        return;
    L5:
        if (r2 != this) goto L7;
        r0 = "this future";
        goto L4
    L7:
        r1.append(r2.getClass().getName()).append("@").append(Integer.toHexString(System.identityHashCode(r2)));
    }

    static /* synthetic */ k b(a r0) {
        return r0.waiters;
    }

    static /* synthetic */ Object b(l r2) {
        return c((l) ZeusTransformUtils.wrapperContextForParams(r2, l.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private V b(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, b.class) == true) goto L14;
        if (ZeusTransformUtils.instanceOf(r3, c.class) == true) goto L12;
        if (r3 == d) goto L9;
        return r3;
    L9:
        return (V) t.a();
    L12:
        throw new ExecutionException(((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.memorydata.plugin")).f4836b);
    L14:
        throw a("Task was cancelled.", ((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin")).d);
    }

    private static <V> V b(Future<V> r2) {
        Future r3 = (Future) ZeusTransformUtils.wrapperContextForParams(r2, Future.class, "com.obric.memorydata.plugin");
        boolean r0 = false;
    L12:
        V r4 = (V) r3.get();
    L4:
        if (r0 == false) goto L6;
        Thread.currentThread().interrupt();
    L6:
        return r4;
    L11:
        r0 = true;
    L7:
        th = move-exception;
        if (r0 == false) goto L10;
        Thread.currentThread().interrupt();
    L10:
        throw th;
    }

    private static void b(a<?> r4, boolean r5) {
        d r0 = null;
        a r6 = r4;
    L3:
        r6.g();
        if (r5 == false) goto L6;
        r6.a();
        r5 = false;
    L6:
        r6.c();
        d r7 = r6.a(r0);
    L7:
        if (r7 == null) goto L17;
        r0 = r7.next;
        Runnable r1 = (Runnable) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r7.f4838b), Runnable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, f.class) == false) goto L15;
        f r8 = (f) ZeusTransformUtils.preCheckCast(r1, f.class, "com.obric.memorydata.plugin");
        a<V> r2 = r8.f4841a;
        if (((a) r2).value != r8) goto L16;
        Object r3 = c(r8.f4842b);
        if (c.a(r2, r8, r3) == false) goto L16;
        r6 = r2;
    L16:
        r7 = r0;
        goto L7
    L15:
        a(r1, (Executor) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r7.c), Executor.class, "com.obric.memorydata.plugin"));
        goto L16
    }

    private void b(StringBuilder r4) {
        Object r1 = b(this);     // Catch: RuntimeException -> L5 CancellationException -> L7 ExecutionException -> L8
        r4.append("SUCCESS, result=[");     // Catch: RuntimeException -> L5 CancellationException -> L7 ExecutionException -> L8
        a(r4, r1);     // Catch: RuntimeException -> L5 CancellationException -> L7 ExecutionException -> L8
        r4.append("]");     // Catch: RuntimeException -> L5 CancellationException -> L7 ExecutionException -> L8
    L15:
        return;
    L7:
        r4.append("CANCELLED");
        return;
    L5:
        e = move-exception;
        r4.append("UNKNOWN, cause=[").append(e.getClass()).append(" thrown from get()]");
        return;
    L8:
        e = move-exception;
        r4.append("FAILURE, cause=[").append(e.getCause()).append("]");
    }

    private void b(StringBuilder r1, Object r2) {
        if (r2 != this) goto L4;
        r1.append("this future");     // Catch: Throwable -> L6
    L9:
        return;
    L4:
        r1.append(r2);     // Catch: Throwable -> L6
    L6:
        e = move-exception;
        r1.append("Exception thrown from implementation: ").append(e.getClass());
    }

    static /* synthetic */ d c(a r0) {
        return r0.listeners;
    }

    private static Object c(l<?> r6) {
        l r7 = (l) ZeusTransformUtils.wrapperContextForParams(r6, l.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, h.class) == false) goto L15;
        Object r8 = ((a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.memorydata.plugin")).value;
        if (ZeusTransformUtils.instanceOf(r8, b.class) == false) goto L13;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r8, b.class, "com.obric.memorydata.plugin");
        if (r0.c == false) goto L13;
        if (r0.d == null) goto L11;
        r8 = new b(false, r0.d);
        goto L13
    L11:
        r8 = b.f4834b;
    L13:
        return Objects.requireNonNull(r8);
    L15:
        if (ZeusTransformUtils.instanceOf(r7, com.google.common.util.concurrent.a.a.class) == false) goto L20;
        Throwable r1 = com.google.common.util.concurrent.a.b.a((com.google.common.util.concurrent.a.a) ZeusTransformUtils.preCheckCast(r7, com.google.common.util.concurrent.a.a.class, "com.obric.memorydata.plugin"));
        if (r1 == null) goto L20;
        return new c(r1);
    L20:
        boolean r2 = r7.isCancelled();
        if (((!f4831a) & r2) == true) goto L23;
        Object r3 = b(r7);     // Catch: Throwable -> L31 CancellationException -> L34 ExecutionException -> L40
        if (r2 == true) goto L27;
        if (r3 == null) goto L30;
        return r3;
    L30:
        return d;
    L27:
        return new b(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + r7));
    L31:
        e = move-exception;
        return new c(e);
    L34:
        e = move-exception;
        if (r2 == true) goto L39;
        return new c(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + r7, e));
    L39:
        return new b(false, e);
    L40:
        e = move-exception;
        if (r2 == false) goto L45;
        return new b(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + r7, e));
    L45:
        return new c(e.getCause());
    L23:
        return Objects.requireNonNull(b.f4834b);
    }

    static /* synthetic */ AbstractC0205a f() {
        return c;
    }

    private void g() {
        k r2 = c.a(this, k.f4845a);
    L3:
        if (r2 == null) goto L5;
        r2.a();
        r2 = r2.next;
        goto L3
    }

    public void a() {
    }

    final void a(Future<?> r3) {
        Future r4 = (Future) ZeusTransformUtils.wrapperContextForParams(r3, Future.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L5;
        boolean r0 = true;
    L7:
        if ((r0 & isCancelled()) == false) goto L10;
        r4.cancel(b());
        return;
    L10:
        return;
    L5:
        r0 = false;
        goto L7
    }

    public boolean a(l<? extends V> r7) {
        l r8 = (l) ZeusTransformUtils.wrapperContextForParams(r7, l.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r8);
        Object r0 = this.value;
        if (r0 != null) goto L23;
        if (r8.isDone() == false) goto L11;
        Object r9 = c(r8);
        if (c.a(this, null, r9) == false) goto L10;
        b(this, false);
        return true;
    L10:
        return false;
    L11:
        f r1 = new f(this, r8);
        if (c.a(this, null, r1) == true) goto L26;
        r0 = this.value;
        goto L23
    L26:
        r8.addListener(r1, DirectExecutor.INSTANCE);     // Catch: Throwable -> L15
    L20:
        return true;
    L15:
        e = move-exception;
        c r2 = new c(e);     // Catch: Throwable -> L18
    L19:
        c.a(this, r1, r2);
    L18:
        r2 = c.f4835a;
    L23:
        if (ZeusTransformUtils.instanceOf(r0, b.class) == false) goto L25;
        r8.cancel(((b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.memorydata.plugin")).c);
    L25:
        return false;
    }

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
    public boolean a(V r3) {
        if (r3 != null) goto L5;
        r3 = (V) d;
    L5:
        if (c.a(this, null, r3) == false) goto L8;
        b(this, false);
        return true;
    L8:
        return false;
    }

    public boolean a(Throwable r4) {
        c r0 = new c((Throwable) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r4), Throwable.class, "com.obric.memorydata.plugin"));
        if (c.a(this, null, r0) == false) goto L6;
        b(this, false);
        return true;
    L6:
        return false;
    }

    @Override // com.google.common.util.concurrent.l
    public void addListener(Runnable r4, Executor r5) {
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
        Executor r7 = (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r6, "Runnable was null.");
        com.google.common.base.n.a(r7, "Executor was null.");
        if (isDone() == true) goto L12;
        d r0 = this.listeners;
        if (r0 == d.f4837a) goto L12;
        d r1 = new d(r6, r7);
    L7:
        r1.next = r0;
        if (c.a(this, r0, r1) == true) goto L9;
        r0 = this.listeners;
        if (r0 != d.f4837a) goto L7;
    L9:
        return;
    L12:
        a(r6, r7);
    }

    public final boolean b() {
        Object r2 = this.value;
        if (ZeusTransformUtils.instanceOf(r2, b.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (((b) ZeusTransformUtils.preCheckCast(r2, b.class, "com.obric.memorydata.plugin")).c == false) goto L7;
        return true;
    }

    public void c() {
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean r7) {
        Object r0 = this.value;
        if (r0 != null) goto L5;
        boolean r3 = true;
    L7:
        if ((r3 | ZeusTransformUtils.instanceOf(r0, f.class)) == false) goto L34;
        if (f4831a == false) goto L11;
        Object r4 = new b(r7, new CancellationException("Future.cancel() was called."));
    L15:
        boolean r5 = false;
    L17:
        if (c.a(this, r0, r4) == true) goto L18;
        r0 = this.value;
        if (ZeusTransformUtils.instanceOf(r0, f.class) == true) goto L17;
        return r5;
    L18:
        b(this, r7);
        if (ZeusTransformUtils.instanceOf(r0, f.class) == false) goto L46;
        l<? extends V> r6 = ((f) ZeusTransformUtils.preCheckCast(r0, f.class, "com.obric.memorydata.plugin")).f4842b;
        if (ZeusTransformUtils.instanceOf(r6, h.class) == false) goto L29;
        a<V> this = (a) ZeusTransformUtils.preCheckCast(r6, a.class, "com.obric.memorydata.plugin");
        r0 = this.value;
        if (r0 != null) goto L25;
        boolean r8 = true;
    L27:
        if ((r8 | ZeusTransformUtils.instanceOf(r0, f.class)) == false) goto L47;
        r5 = true;
        goto L17
    L47:
        return true;
    L25:
        r8 = false;
        goto L27
    L29:
        r6.cancel(r7);
        return true;
    L46:
        return true;
    L11:
        if (r7 == false) goto L13;
        b r9 = b.f4833a;
    L14:
        r4 = Objects.requireNonNull(r9);
        goto L15
    L13:
        r9 = b.f4834b;
        goto L14
    L34:
        return false;
    L5:
        r3 = false;
        goto L7
    }

    @Override // com.google.common.util.concurrent.a.a
    public final Throwable d() {
        if (ZeusTransformUtils.instanceOf(this, h.class) == false) goto L8;
        Object r2 = this.value;
        if (ZeusTransformUtils.instanceOf(r2, c.class) == true) goto L7;
        return null;
    L7:
        return ((c) ZeusTransformUtils.preCheckCast(r2, c.class, "com.obric.memorydata.plugin")).f4836b;
    L8:
        return null;
    }

    public String e() {
        if (ZeusTransformUtils.instanceOf(this, ScheduledFuture.class) == true) goto L5;
        return null;
    L5:
        return "remaining delay=[" + ((ScheduledFuture) ZeusTransformUtils.preCheckCast(this, ScheduledFuture.class, "com.obric.memorydata.plugin")).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    @Override // java.util.concurrent.Future
    public V get() {
        if (Thread.interrupted() == true) goto L34;
        Object r0 = this.value;
        if (r0 == null) goto L7;
        boolean r3 = true;
    L9:
        if ((r3 & (!ZeusTransformUtils.instanceOf(r0, f.class))) == true) goto L11;
        k r1 = this.waiters;
        if (r1 == k.f4845a) goto L32;
        k r4 = new k();
    L15:
        r4.a(r1);
        if (c.a(this, r1, r4) == true) goto L17;
        r1 = this.waiters;
        if (r1 != k.f4845a) goto L15;
    L17:
        LockSupport.park(this);
        if (Thread.interrupted() == true) goto L27;
        Object r2 = this.value;
        if (r2 == null) goto L22;
        boolean r5 = true;
    L24:
        if ((r5 & (!ZeusTransformUtils.instanceOf(r2, f.class))) == false) goto L17;
        return b(r2);
    L22:
        r5 = false;
        goto L24
    L27:
        a(r4);
        throw new InterruptedException();
    L32:
        return b(Objects.requireNonNull(this.value));
    L11:
        return b(r0);
    L7:
        r3 = false;
        goto L9
    L34:
        throw new InterruptedException();
    }

    @Override // java.util.concurrent.Future
    public V get(long r20, TimeUnit r22) {
        long r4 = r22.toNanos(r20);
        if (Thread.interrupted() == true) goto L81;
        Object r6 = this.value;
        if (r6 == null) goto L7;
        boolean r9 = true;
    L9:
        if ((r9 & (!ZeusTransformUtils.instanceOf(r6, f.class))) == false) goto L13;
        return b(r6);
    L13:
        if (r4 <= 0) goto L15;
        long r11 = System.nanoTime() + r4;
    L17:
        if (r4 < 1000) goto L43;
        k r7 = this.waiters;
        if (r7 == k.f4845a) goto L41;
        k r15 = new k();
    L21:
        r15.a(r7);
        if (c.a(this, r7, r15) == true) goto L23;
        r7 = this.waiters;
        if (r7 != k.f4845a) goto L21;
    L23:
        u.a(this, r4);
        if (Thread.interrupted() == true) goto L36;
        Object r5 = this.value;
        if (r5 == null) goto L28;
        boolean r8 = true;
    L30:
        if ((r8 & (!ZeusTransformUtils.instanceOf(r5, f.class))) == true) goto L32;
        r4 = r11 - System.nanoTime();
        if (r4 >= 1000) goto L23;
        a(r15);
        goto L43
    L32:
        return b(r5);
    L28:
        r8 = false;
        goto L30
    L36:
        a(r15);
        throw new InterruptedException();
    L41:
        return b(Objects.requireNonNull(this.value));
    L43:
        if (r4 <= 0) goto L57;
        Object r10 = this.value;
        if (r10 == null) goto L47;
        boolean r12 = true;
    L49:
        if ((r12 & (!ZeusTransformUtils.instanceOf(r10, f.class))) == true) goto L51;
        if (Thread.interrupted() == true) goto L56;
        r4 = r11 - System.nanoTime();
        goto L43
    L56:
        throw new InterruptedException();
    L51:
        return b(r10);
    L47:
        r12 = false;
        goto L49
    L57:
        String r13 = toString();
        String r14 = r22.toString().toLowerCase(Locale.ROOT);
        String r1 = "Waited " + r20 + " " + r22.toString().toLowerCase(Locale.ROOT);
        if ((r4 + 1000) >= 0) goto L75;
        String r2 = r1 + " (plus ";
        long r16 = -r4;
        long r17 = r22.convert(r16, TimeUnit.NANOSECONDS);
        long r18 = r16 - r22.toNanos(r17);
        if (r17 != 0) goto L62;
    L65:
        boolean r19 = true;
    L66:
        if (r17 <= 0) goto L71;
        String r3 = r2 + r17 + " " + r14;
        if (r19 == false) goto L70;
        r3 = r3 + ",";
    L70:
        r2 = r3 + " ";
    L71:
        if (r19 == false) goto L73;
        r2 = r2 + r18 + " nanoseconds ";
    L73:
        r1 = r2 + "delay)";
        goto L75
    L62:
        if (r18 > 1000) goto L65;
        r19 = false;
    L75:
        if (isDone() == false) goto L79;
        throw new TimeoutException(r1 + " but future completed as timeout expired");
    L79:
        throw new TimeoutException(r1 + " for " + r13);
    L15:
        r11 = 0;
        goto L17
    L7:
        r9 = false;
        goto L9
    L81:
        throw new InterruptedException();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return ZeusTransformUtils.instanceOf(this.value, b.class);
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        Object r3 = this.value;
        if (r3 == null) goto L5;
        boolean r1 = true;
    L7:
        return (!ZeusTransformUtils.instanceOf(r3, f.class)) & r1;
    L5:
        r1 = false;
        goto L7
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.") == false) goto L5;
        String r1 = getClass().getSimpleName();
    L6:
        r0.append(r1);
        r0.append('@').append(Integer.toHexString(System.identityHashCode(this))).append("[status=");
        if (isCancelled() == false) goto L10;
        r0.append("CANCELLED");
    L14:
        return r0.append("]").toString();
    L10:
        if (isDone() == false) goto L12;
        b(r0);
        goto L14
    L12:
        a(r0);
        goto L14
    L5:
        r1 = getClass().getName();
        goto L6
    }
}
