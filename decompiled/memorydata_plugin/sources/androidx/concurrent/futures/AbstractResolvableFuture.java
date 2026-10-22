package androidx.concurrent.futures;

import com.bytedance.crash.entity.EventBody;
import com.google.common.util.concurrent.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractResolvableFuture<V> implements l<V> {
    static final AtomicHelper ATOMIC_HELPER = null;
    static final boolean GENERATE_CANCELLATION_CAUSES = false;
    private static final Object NULL = null;
    private static final long SPIN_THRESHOLD_NANOS = 1000;
    private static final Logger log = null;
    volatile Listener listeners;
    volatile Object value;
    volatile Waiter waiters;

    /* JADX INFO: renamed from: androidx.concurrent.futures.AbstractResolvableFuture$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static abstract class AtomicHelper {
        private AtomicHelper() {
        }

        /* synthetic */ AtomicHelper(AnonymousClass1 r1) {
            this();
        }

        abstract boolean casListeners(AbstractResolvableFuture<?> r1, Listener r2, Listener r3);

        abstract boolean casValue(AbstractResolvableFuture<?> r1, Object r2, Object r3);

        abstract boolean casWaiters(AbstractResolvableFuture<?> r1, Waiter r2, Waiter r3);

        abstract void putNext(Waiter r1, Waiter r2);

        abstract void putThread(Waiter r1, Thread r2);
    }

    private static final class Cancellation {
        static final Cancellation CAUSELESS_CANCELLED = null;
        static final Cancellation CAUSELESS_INTERRUPTED = null;
        final Throwable cause;
        final boolean wasInterrupted;

        static {
            if (AbstractResolvableFuture.GENERATE_CANCELLATION_CAUSES == false) goto L5;
            CAUSELESS_CANCELLED = null;
            CAUSELESS_INTERRUPTED = null;
            return;
        L5:
            CAUSELESS_CANCELLED = new Cancellation(false, null);
            CAUSELESS_INTERRUPTED = new Cancellation(true, null);
        }

        Cancellation(boolean r1, Throwable r2) {
            this.wasInterrupted = r1;
            this.cause = r2;
        }
    }

    private static final class Failure {
        static final Failure FALLBACK_INSTANCE = null;
        final Throwable exception;

        static {
            final String r2 = "Failure occurred while trying to finish a future.";
            FALLBACK_INSTANCE = new Failure(new AnonymousClass1(r2));
        }

        Failure(Throwable r3) {
            this.exception = (Throwable) ZeusTransformUtils.preCheckCast(AbstractResolvableFuture.checkNotNull(r3), Throwable.class, "com.obric.memorydata.plugin");
        }
    }

    private static final class Listener {
        static final Listener TOMBSTONE = null;
        final Executor executor;
        Listener next;
        final Runnable task;

        static {
            TOMBSTONE = new Listener(null, null);
        }

        Listener(Runnable r3, Executor r4) {
            Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
            Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.memorydata.plugin");
            this.task = r5;
            this.executor = r6;
        }
    }

    private static final class SafeAtomicHelper extends AtomicHelper {
        final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Listener> listenersUpdater;
        final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> valueUpdater;
        final AtomicReferenceFieldUpdater<Waiter, Waiter> waiterNextUpdater;
        final AtomicReferenceFieldUpdater<Waiter, Thread> waiterThreadUpdater;
        final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Waiter> waitersUpdater;

        SafeAtomicHelper(AtomicReferenceFieldUpdater<Waiter, Thread> r2, AtomicReferenceFieldUpdater<Waiter, Waiter> r3, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Waiter> r4, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Listener> r5, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> r6) {
            super(null);
            this.waiterThreadUpdater = r2;
            this.waiterNextUpdater = r3;
            this.waitersUpdater = r4;
            this.listenersUpdater = r5;
            this.valueUpdater = r6;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        boolean casListeners(AbstractResolvableFuture<?> r1, Listener r2, Listener r3) {
            return this.listenersUpdater.compareAndSet(r1, r2, r3);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        boolean casValue(AbstractResolvableFuture<?> r1, Object r2, Object r3) {
            return this.valueUpdater.compareAndSet(r1, r2, r3);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        boolean casWaiters(AbstractResolvableFuture<?> r1, Waiter r2, Waiter r3) {
            return this.waitersUpdater.compareAndSet(r1, r2, r3);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        void putNext(Waiter r1, Waiter r2) {
            this.waiterNextUpdater.lazySet(r1, r2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        void putThread(Waiter r1, Thread r2) {
            this.waiterThreadUpdater.lazySet(r1, r2);
        }
    }

    private static final class SetFuture<V> implements Runnable {
        final l<? extends V> future;
        final AbstractResolvableFuture<V> owner;

        SetFuture(AbstractResolvableFuture<V> r3, l<? extends V> r4) {
            l<? extends V> r5 = (l) ZeusTransformUtils.wrapperContextForParams(r4, l.class, "com.obric.memorydata.plugin");
            this.owner = r3;
            this.future = r5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.owner.value == this) goto L5;
            return;
        L5:
            Object r0 = AbstractResolvableFuture.getFutureValue(this.future);
            if (AbstractResolvableFuture.ATOMIC_HELPER.casValue(this.owner, this, r0) == false) goto L9;
            AbstractResolvableFuture.complete(this.owner);
            return;
        }
    }

    private static final class SynchronizedHelper extends AtomicHelper {
        SynchronizedHelper() {
            super(null);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        boolean casListeners(AbstractResolvableFuture<?> r1, Listener r2, Listener r3) {
            monitor-enter(r1);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (r1.listeners != r2) goto L9;
            r1.listeners = r3;     // Catch: Throwable -> L11
            monitor-exit(r1);     // Catch: Throwable -> L11
            return true;
        L9:
            monitor-exit(r1);     // Catch: Throwable -> L11
            return false;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        boolean casValue(AbstractResolvableFuture<?> r1, Object r2, Object r3) {
            monitor-enter(r1);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (r1.value != r2) goto L9;
            r1.value = r3;     // Catch: Throwable -> L11
            monitor-exit(r1);     // Catch: Throwable -> L11
            return true;
        L9:
            monitor-exit(r1);     // Catch: Throwable -> L11
            return false;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        boolean casWaiters(AbstractResolvableFuture<?> r1, Waiter r2, Waiter r3) {
            monitor-enter(r1);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (r1.waiters != r2) goto L9;
            r1.waiters = r3;     // Catch: Throwable -> L11
            monitor-exit(r1);     // Catch: Throwable -> L11
            return true;
        L9:
            monitor-exit(r1);     // Catch: Throwable -> L11
            return false;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        void putNext(Waiter r1, Waiter r2) {
            r1.next = r2;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        void putThread(Waiter r1, Thread r2) {
            r1.thread = r2;
        }
    }

    private static final class Waiter {
        static final Waiter TOMBSTONE = null;
        volatile Waiter next;
        volatile Thread thread;

        static {
            TOMBSTONE = new Waiter(false);
        }

        Waiter() {
            AbstractResolvableFuture.ATOMIC_HELPER.putThread(this, Thread.currentThread());
        }

        Waiter(boolean r1) {
        }

        void setNext(Waiter r2) {
            AbstractResolvableFuture.ATOMIC_HELPER.putNext(this, r2);
        }

        void unpark() {
            Thread r0 = this.thread;
            if (r0 == null) goto L6;
            this.thread = null;
            LockSupport.unpark(r0);
            return;
        }
    }

    static {
        GENERATE_CANCELLATION_CAUSES = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        log = Logger.getLogger(AbstractResolvableFuture.class.getName());
        AtomicHelper r1 = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Waiter.class, "next"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Waiter.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Listener.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Object.class, EventBody.KEY_VALUE));     // Catch: Throwable -> L5
        th = null;
    L7:
        ATOMIC_HELPER = r1;
        if (th == null) goto L10;
        log.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
    L10:
        NULL = new Object();
        return;
    L5:
        th = th;
        r1 = new SynchronizedHelper();
        goto L7
    }

    public AbstractResolvableFuture() {
    }

    private void addDoneString(StringBuilder r4) {
        Object r1 = getUninterruptibly(this);     // Catch: RuntimeException -> L5 CancellationException -> L7 ExecutionException -> L8
        r4.append("SUCCESS, result=[").append(userObjectToString(r1)).append("]");     // Catch: RuntimeException -> L5 CancellationException -> L7 ExecutionException -> L8
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

    private static CancellationException cancellationExceptionWithCause(String r1, Throwable r2) {
        CancellationException r0 = new CancellationException(r1);
        r0.initCause(r2);
        return r0;
    }

    static <T> T checkNotNull(T r0) {
        Objects.requireNonNull(r0);
        return r0;
    }

    private Listener clearListeners(Listener r4) {
    L2:
        Listener r0 = this.listeners;
        if (ATOMIC_HELPER.casListeners(this, r0, Listener.TOMBSTONE) == false) goto L2;
    L4:
        Listener r3 = r4;
        r4 = r0;
        if (r4 == null) goto L7;
        r0 = r4.next;
        r4.next = r3;
        goto L4
    L7:
        return r3;
    }

    static void complete(AbstractResolvableFuture<?> r4) {
        Listener r0 = null;
        AbstractResolvableFuture r5 = r4;
    L3:
        r5.releaseWaiters();
        r5.afterDone();
        Listener r6 = r5.clearListeners(r0);
    L4:
        if (r6 == null) goto L14;
        r0 = r6.next;
        Runnable r1 = r6.task;
        if (ZeusTransformUtils.instanceOf(r1, SetFuture.class) == false) goto L12;
        SetFuture r7 = (SetFuture) ZeusTransformUtils.preCheckCast(r1, SetFuture.class, "com.obric.memorydata.plugin");
        AbstractResolvableFuture<V> r2 = r7.owner;
        if (r2.value != r7) goto L13;
        Object r3 = getFutureValue(r7.future);
        if (ATOMIC_HELPER.casValue(r2, r7, r3) == false) goto L13;
        r5 = r2;
    L13:
        r6 = r0;
        goto L4
    L12:
        executeListener(r1, r6.executor);
        goto L13
    }

    private static void executeListener(Runnable r5, Executor r6) {
        Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.memorydata.plugin");
        Executor r8 = (Executor) ZeusTransformUtils.wrapperContextForParams(r6, Executor.class, "com.obric.memorydata.plugin");
        r8.execute(r7);     // Catch: RuntimeException -> L5
        return;
    L5:
        e = move-exception;
        log.log(Level.SEVERE, "RuntimeException while executing runnable " + r7 + " with executor " + r8, e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private V getDoneValue(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, Cancellation.class) == true) goto L14;
        if (ZeusTransformUtils.instanceOf(r3, Failure.class) == true) goto L12;
        if (r3 != NULL) goto L10;
        return null;
    L10:
        return r3;
    L12:
        throw new ExecutionException(((Failure) ZeusTransformUtils.preCheckCast(r3, Failure.class, "com.obric.memorydata.plugin")).exception);
    L14:
        throw cancellationExceptionWithCause("Task was cancelled.", ((Cancellation) ZeusTransformUtils.preCheckCast(r3, Cancellation.class, "com.obric.memorydata.plugin")).cause);
    }

    static Object getFutureValue(l<?> r5) {
        l r6 = (l) ZeusTransformUtils.wrapperContextForParams(r5, l.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, AbstractResolvableFuture.class) == false) goto L13;
        Object r7 = ((AbstractResolvableFuture) ZeusTransformUtils.preCheckCast(r6, AbstractResolvableFuture.class, "com.obric.memorydata.plugin")).value;
        if (ZeusTransformUtils.instanceOf(r7, Cancellation.class) == false) goto L35;
        Cancellation r0 = (Cancellation) ZeusTransformUtils.preCheckCast(r7, Cancellation.class, "com.obric.memorydata.plugin");
        if (r0.wasInterrupted == true) goto L9;
        return r7;
    L9:
        if (r0.cause == null) goto L12;
        return new Cancellation(false, r0.cause);
    L12:
        return Cancellation.CAUSELESS_CANCELLED;
    L35:
        return r7;
    L13:
        boolean r1 = r6.isCancelled();
        if (((!GENERATE_CANCELLATION_CAUSES) & r1) == true) goto L16;
        Object r2 = getUninterruptibly(r6);     // Catch: Throwable -> L21 CancellationException -> L24 ExecutionException -> L30
        if (r2 != null) goto L38;
        return NULL;
    L38:
        return r2;
    L24:
        e = move-exception;
        if (r1 == true) goto L29;
        return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + r6, e));
    L29:
        return new Cancellation(false, e);
    L30:
        e = move-exception;
        return new Failure(e.getCause());
    L21:
        th = move-exception;
        return new Failure(th);
    L16:
        return Cancellation.CAUSELESS_CANCELLED;
    }

    static <V> V getUninterruptibly(Future<V> r2) {
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

    private void releaseWaiters() {
    L2:
        Waiter r0 = this.waiters;
        if (ATOMIC_HELPER.casWaiters(this, r0, Waiter.TOMBSTONE) == false) goto L2;
    L4:
        if (r0 == null) goto L6;
        r0.unpark();
        r0 = r0.next;
        goto L4
    }

    private void removeWaiter(Waiter r5) {
        r5.thread = null;
    L3:
        Waiter r6 = this.waiters;
        if (r6 == Waiter.TOMBSTONE) goto L5;
        Waiter r1 = null;
    L7:
        if (r6 == null) goto L19;
        Waiter r2 = r6.next;
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
        if (ATOMIC_HELPER.casWaiters(this, r6, r2) == true) goto L18;
    L19:
        return;
    }

    private String userObjectToString(Object r1) {
        if (r1 != this) goto L6;
        return "this future";
    L6:
        return String.valueOf(r1);
    }

    @Override // com.google.common.util.concurrent.l
    public final void addListener(Runnable r4, Executor r5) {
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
        Executor r7 = (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.memorydata.plugin");
        checkNotNull(r6);
        checkNotNull(r7);
        Listener r0 = this.listeners;
        if (r0 == Listener.TOMBSTONE) goto L10;
        Listener r1 = new Listener(r6, r7);
    L5:
        r1.next = r0;
        if (ATOMIC_HELPER.casListeners(this, r0, r1) == true) goto L7;
        r0 = this.listeners;
        if (r0 != Listener.TOMBSTONE) goto L5;
    L7:
        return;
    L10:
        executeListener(r6, r7);
    }

    public void afterDone() {
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean r8) {
        Object r1 = this.value;
        if (r1 != null) goto L5;
        boolean r4 = true;
    L7:
        if ((r4 | ZeusTransformUtils.instanceOf(r1, SetFuture.class)) == false) goto L35;
        if (GENERATE_CANCELLATION_CAUSES == false) goto L11;
        Cancellation r5 = new Cancellation(r8, new CancellationException("Future.cancel() was called."));
    L14:
        boolean r6 = false;
    L16:
        if (ATOMIC_HELPER.casValue(this, r1, r5) == true) goto L17;
        r1 = this.value;
        if (ZeusTransformUtils.instanceOf(r1, SetFuture.class) == true) goto L16;
        return r6;
    L17:
        if (r8 == false) goto L19;
        this.interruptTask();
    L19:
        complete(this);
        if (ZeusTransformUtils.instanceOf(r1, SetFuture.class) == false) goto L47;
        l<? extends V> r7 = ((SetFuture) ZeusTransformUtils.preCheckCast(r1, SetFuture.class, "com.obric.memorydata.plugin")).future;
        if (ZeusTransformUtils.instanceOf(r7, AbstractResolvableFuture.class) == false) goto L30;
        AbstractResolvableFuture<V> this = (AbstractResolvableFuture) ZeusTransformUtils.preCheckCast(r7, AbstractResolvableFuture.class, "com.obric.memorydata.plugin");
        r1 = this.value;
        if (r1 != null) goto L26;
        boolean r9 = true;
    L28:
        if ((r9 | ZeusTransformUtils.instanceOf(r1, SetFuture.class)) == false) goto L48;
        r6 = true;
        goto L16
    L48:
        return true;
    L26:
        r9 = false;
        goto L28
    L30:
        r7.cancel(r8);
        return true;
    L47:
        return true;
    L11:
        if (r8 == false) goto L13;
        r5 = Cancellation.CAUSELESS_INTERRUPTED;
        goto L14
    L13:
        r5 = Cancellation.CAUSELESS_CANCELLED;
        goto L14
    L35:
        return false;
    L5:
        r4 = false;
        goto L7
    }

    @Override // java.util.concurrent.Future
    public final V get() {
        if (Thread.interrupted() == true) goto L34;
        Object r0 = this.value;
        if (r0 == null) goto L7;
        boolean r3 = true;
    L9:
        if ((r3 & (!ZeusTransformUtils.instanceOf(r0, SetFuture.class))) == true) goto L11;
        Waiter r1 = this.waiters;
        if (r1 == Waiter.TOMBSTONE) goto L32;
        Waiter r4 = new Waiter();
    L15:
        r4.setNext(r1);
        if (ATOMIC_HELPER.casWaiters(this, r1, r4) == true) goto L17;
        r1 = this.waiters;
        if (r1 != Waiter.TOMBSTONE) goto L15;
    L17:
        LockSupport.park(this);
        if (Thread.interrupted() == true) goto L27;
        Object r2 = this.value;
        if (r2 == null) goto L22;
        boolean r5 = true;
    L24:
        if ((r5 & (!ZeusTransformUtils.instanceOf(r2, SetFuture.class))) == false) goto L17;
        return getDoneValue(r2);
    L22:
        r5 = false;
        goto L24
    L27:
        removeWaiter(r4);
        throw new InterruptedException();
    L32:
        return getDoneValue(this.value);
    L11:
        return getDoneValue(r0);
    L7:
        r3 = false;
        goto L9
    L34:
        throw new InterruptedException();
    }

    @Override // java.util.concurrent.Future
    public final V get(long r20, TimeUnit r22) {
        long r4 = r22.toNanos(r20);
        if (Thread.interrupted() == true) goto L81;
        Object r6 = this.value;
        if (r6 == null) goto L7;
        boolean r9 = true;
    L9:
        if ((r9 & (!ZeusTransformUtils.instanceOf(r6, SetFuture.class))) == false) goto L13;
        return getDoneValue(r6);
    L13:
        if (r4 <= 0) goto L15;
        long r11 = System.nanoTime() + r4;
    L17:
        if (r4 < 1000) goto L43;
        Waiter r7 = this.waiters;
        if (r7 == Waiter.TOMBSTONE) goto L41;
        Waiter r15 = new Waiter();
    L21:
        r15.setNext(r7);
        if (ATOMIC_HELPER.casWaiters(this, r7, r15) == true) goto L23;
        r7 = this.waiters;
        if (r7 != Waiter.TOMBSTONE) goto L21;
    L23:
        LockSupport.parkNanos(this, r4);
        if (Thread.interrupted() == true) goto L36;
        Object r5 = this.value;
        if (r5 == null) goto L28;
        boolean r8 = true;
    L30:
        if ((r8 & (!ZeusTransformUtils.instanceOf(r5, SetFuture.class))) == true) goto L32;
        r4 = r11 - System.nanoTime();
        if (r4 >= 1000) goto L23;
        removeWaiter(r15);
        goto L43
    L32:
        return getDoneValue(r5);
    L28:
        r8 = false;
        goto L30
    L36:
        removeWaiter(r15);
        throw new InterruptedException();
    L41:
        return getDoneValue(this.value);
    L43:
        if (r4 <= 0) goto L57;
        Object r10 = this.value;
        if (r10 == null) goto L47;
        boolean r12 = true;
    L49:
        if ((r12 & (!ZeusTransformUtils.instanceOf(r10, SetFuture.class))) == true) goto L51;
        if (Thread.interrupted() == true) goto L56;
        r4 = r11 - System.nanoTime();
        goto L43
    L56:
        throw new InterruptedException();
    L51:
        return getDoneValue(r10);
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

    public void interruptTask() {
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return ZeusTransformUtils.instanceOf(this.value, Cancellation.class);
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        Object r3 = this.value;
        if (r3 == null) goto L5;
        boolean r1 = true;
    L7:
        return (!ZeusTransformUtils.instanceOf(r3, SetFuture.class)) & r1;
    L5:
        r1 = false;
        goto L7
    }

    final void maybePropagateCancellationTo(Future<?> r3) {
        Future r4 = (Future) ZeusTransformUtils.wrapperContextForParams(r3, Future.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L5;
        boolean r0 = true;
    L7:
        if ((r0 & isCancelled()) == false) goto L10;
        r4.cancel(wasInterrupted());
        return;
    L10:
        return;
    L5:
        r0 = false;
        goto L7
    }

    public String pendingToString() {
        Object r0 = this.value;
        if (ZeusTransformUtils.instanceOf(r0, SetFuture.class) == false) goto L8;
        StringBuilder r4 = new StringBuilder().append("setFuture=[").append(userObjectToString(((SetFuture) ZeusTransformUtils.preCheckCast(r0, SetFuture.class, "com.obric.memorydata.plugin")).future));
        String r1 = "]";
    L6:
        return r4.append(r1).toString();
    L8:
        if (ZeusTransformUtils.instanceOf(this, ScheduledFuture.class) == false) goto L10;
        r4 = new StringBuilder().append("remaining delay=[").append(((ScheduledFuture) ZeusTransformUtils.preCheckCast(this, ScheduledFuture.class, "com.obric.memorydata.plugin")).getDelay(TimeUnit.MILLISECONDS));
        r1 = " ms]";
        goto L6
    L10:
        return null;
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
    public boolean set(V r3) {
        if (r3 != null) goto L5;
        r3 = (V) NULL;
    L5:
        if (ATOMIC_HELPER.casValue(this, null, r3) == false) goto L8;
        complete(this);
        return true;
    L8:
        return false;
    }

    public boolean setException(Throwable r4) {
        Failure r0 = new Failure((Throwable) ZeusTransformUtils.preCheckCast(checkNotNull(r4), Throwable.class, "com.obric.memorydata.plugin"));
        if (ATOMIC_HELPER.casValue(this, null, r0) == false) goto L6;
        complete(this);
        return true;
    L6:
        return false;
    }

    public boolean setFuture(l<? extends V> r7) {
        l r8 = (l) ZeusTransformUtils.wrapperContextForParams(r7, l.class, "com.obric.memorydata.plugin");
        checkNotNull(r8);
        Object r0 = this.value;
        if (r0 != null) goto L23;
        if (r8.isDone() == false) goto L11;
        Object r9 = getFutureValue(r8);
        if (ATOMIC_HELPER.casValue(this, null, r9) == false) goto L10;
        complete(this);
        return true;
    L10:
        return false;
    L11:
        SetFuture r1 = new SetFuture(this, r8);
        if (ATOMIC_HELPER.casValue(this, null, r1) == true) goto L28;
        r0 = this.value;
        goto L23
    L28:
        r8.addListener(r1, DirectExecutor.INSTANCE);     // Catch: Throwable -> L15
    L20:
        return true;
    L15:
        th = move-exception;
        Failure r2 = new Failure(th);     // Catch: Throwable -> L18
    L19:
        ATOMIC_HELPER.casValue(this, r1, r2);
    L18:
        r2 = Failure.FALLBACK_INSTANCE;
    L23:
        if (ZeusTransformUtils.instanceOf(r0, Cancellation.class) == false) goto L25;
        r8.cancel(((Cancellation) ZeusTransformUtils.preCheckCast(r0, Cancellation.class, "com.obric.memorydata.plugin")).wasInterrupted);
    L25:
        return false;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder().append(super.toString()).append("[status=");
        if (isCancelled() == false) goto L7;
        String r5 = "CANCELLED";
    L5:
        r0.append(r5);
    L22:
        return r0.append("]").toString();
    L7:
        if (isDone() == false) goto L23;
    L8:
        addDoneString(r0);
        goto L22
    L23:
        String r1 = pendingToString();     // Catch: RuntimeException -> L11
    L13:
        if (r1 == null) goto L18;
        if (r1.isEmpty() == true) goto L18;
        r0.append("PENDING, info=[").append(r1).append("]");
    L18:
        if (isDone() == true) goto L8;
        r5 = "PENDING";
    L11:
        e = move-exception;
        r1 = "Exception thrown from implementation: " + e.getClass();
        goto L13
    }

    public final boolean wasInterrupted() {
        Object r2 = this.value;
        if (ZeusTransformUtils.instanceOf(r2, Cancellation.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (((Cancellation) ZeusTransformUtils.preCheckCast(r2, Cancellation.class, "com.obric.memorydata.plugin")).wasInterrupted == false) goto L7;
        return true;
    }
}
