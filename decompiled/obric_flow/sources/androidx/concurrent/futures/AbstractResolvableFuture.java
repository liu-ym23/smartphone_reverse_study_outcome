package androidx.concurrent.futures;

import ai.j0;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.common.util.concurrent.w0;
import java.util.Locale;
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
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class AbstractResolvableFuture<V> implements w0 {
    static final AtomicHelper ATOMIC_HELPER = null;
    static final boolean GENERATE_CANCELLATION_CAUSES = false;
    private static final Object NULL = null;
    private static final long SPIN_THRESHOLD_NANOS = 1000;
    private static final Logger log = null;

    @Nullable
    volatile Listener listeners;

    @Nullable
    volatile Object value;

    @Nullable
    volatile Waiter waiters;

    /* JADX INFO: renamed from: androidx.concurrent.futures.AbstractResolvableFuture$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static abstract class AtomicHelper {
        private AtomicHelper() {
        }

        public abstract boolean casListeners(AbstractResolvableFuture<?> r5, Listener r10, Listener r11);

        public abstract boolean casValue(AbstractResolvableFuture<?> r5, Object r10, Object r11);

        public abstract boolean casWaiters(AbstractResolvableFuture<?> r5, Waiter r10, Waiter r11);

        public abstract void putNext(Waiter r5, Waiter r10);

        public abstract void putThread(Waiter r5, Thread r10);

        public /* synthetic */ AtomicHelper(AnonymousClass1 r5) {
            this();
        }
    }

    public static final class Cancellation {
        static final Cancellation CAUSELESS_CANCELLED = null;
        static final Cancellation CAUSELESS_INTERRUPTED = null;

        @Nullable
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

        public Cancellation(boolean r5, @Nullable Throwable r10) {
            this.wasInterrupted = r5;
            this.cause = r10;
        }
    }

    public static final class Failure {
        static final Failure FALLBACK_INSTANCE = null;
        final Throwable exception;

        static {
            final String r5 = "Failure occurred while trying to finish a future.";
            FALLBACK_INSTANCE = new Failure(new AnonymousClass1(r5));
        }

        public Failure(Throwable r5) {
            this.exception = (Throwable) AbstractResolvableFuture.checkNotNull(r5);
        }
    }

    public static final class Listener {
        static final Listener TOMBSTONE = null;
        final Executor executor;

        @Nullable
        Listener next;
        final Runnable task;

        static {
            TOMBSTONE = new Listener(null, null);
        }

        public Listener(Runnable r5, Executor r10) {
            this.task = r5;
            this.executor = r10;
        }
    }

    public static final class SafeAtomicHelper extends AtomicHelper {
        final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Listener> listenersUpdater;
        final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> valueUpdater;
        final AtomicReferenceFieldUpdater<Waiter, Waiter> waiterNextUpdater;
        final AtomicReferenceFieldUpdater<Waiter, Thread> waiterThreadUpdater;
        final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Waiter> waitersUpdater;

        public SafeAtomicHelper(AtomicReferenceFieldUpdater<Waiter, Thread> r5, AtomicReferenceFieldUpdater<Waiter, Waiter> r10, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Waiter> r11, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Listener> r12, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> r13) {
            super(null);
            this.waiterThreadUpdater = r5;
            this.waiterNextUpdater = r10;
            this.waitersUpdater = r11;
            this.listenersUpdater = r12;
            this.valueUpdater = r13;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public boolean casListeners(AbstractResolvableFuture<?> r5, Listener r10, Listener r11) {
            AtomicReferenceFieldUpdater<AbstractResolvableFuture, Listener> r12 = this.listenersUpdater;
        L4:
            if (r12.compareAndSet(r5, r10, r11) == true) goto L5;
            if (r12.get(r5) == r10) goto L4;
            return false;
        L5:
            return true;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public boolean casValue(AbstractResolvableFuture<?> r5, Object r10, Object r11) {
            AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> r12 = this.valueUpdater;
        L4:
            if (r12.compareAndSet(r5, r10, r11) == true) goto L5;
            if (r12.get(r5) == r10) goto L4;
            return false;
        L5:
            return true;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public boolean casWaiters(AbstractResolvableFuture<?> r5, Waiter r10, Waiter r11) {
            AtomicReferenceFieldUpdater<AbstractResolvableFuture, Waiter> r12 = this.waitersUpdater;
        L4:
            if (r12.compareAndSet(r5, r10, r11) == true) goto L5;
            if (r12.get(r5) == r10) goto L4;
            return false;
        L5:
            return true;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public void putNext(Waiter r5, Waiter r10) {
            this.waiterNextUpdater.lazySet(r5, r10);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public void putThread(Waiter r5, Thread r10) {
            this.waiterThreadUpdater.lazySet(r5, r10);
        }
    }

    public static final class SetFuture<V> implements Runnable {
        final w0 future;
        final AbstractResolvableFuture<V> owner;

        public SetFuture(AbstractResolvableFuture<V> r5, w0 r10) {
            this.owner = r5;
            this.future = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.owner.value == this) goto L5;
            return;
        L5:
            Object r5 = AbstractResolvableFuture.getFutureValue(this.future);
            if (AbstractResolvableFuture.ATOMIC_HELPER.casValue(this.owner, this, r5) == false) goto L9;
            AbstractResolvableFuture.complete(this.owner);
            return;
        }
    }

    public static final class SynchronizedHelper extends AtomicHelper {
        public SynchronizedHelper() {
            super(null);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public boolean casListeners(AbstractResolvableFuture<?> r5, Listener r10, Listener r11) {
            monitor-enter(r5);
        L9:
            th = move-exception;
            throw th;
        L4:
            if (r5.listeners != r10) goto L11;
            r5.listeners = r11;     // Catch: Throwable -> L9
            monitor-exit(r5);     // Catch: Throwable -> L9
            return true;
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L9
            return false;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public boolean casValue(AbstractResolvableFuture<?> r5, Object r10, Object r11) {
            monitor-enter(r5);
        L9:
            th = move-exception;
            throw th;
        L4:
            if (r5.value != r10) goto L11;
            r5.value = r11;     // Catch: Throwable -> L9
            monitor-exit(r5);     // Catch: Throwable -> L9
            return true;
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L9
            return false;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public boolean casWaiters(AbstractResolvableFuture<?> r5, Waiter r10, Waiter r11) {
            monitor-enter(r5);
        L9:
            th = move-exception;
            throw th;
        L4:
            if (r5.waiters != r10) goto L11;
            r5.waiters = r11;     // Catch: Throwable -> L9
            monitor-exit(r5);     // Catch: Throwable -> L9
            return true;
        L11:
            monitor-exit(r5);     // Catch: Throwable -> L9
            return false;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public void putNext(Waiter r5, Waiter r10) {
            r5.next = r10;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper
        public void putThread(Waiter r5, Thread r10) {
            r5.thread = r10;
        }
    }

    public static final class Waiter {
        static final Waiter TOMBSTONE = null;

        @Nullable
        volatile Waiter next;

        @Nullable
        volatile Thread thread;

        static {
            TOMBSTONE = new Waiter(false);
        }

        public Waiter(boolean r5) {
        }

        public void setNext(Waiter r5) {
            AbstractResolvableFuture.ATOMIC_HELPER.putNext(this, r5);
        }

        public void unpark() {
            Thread r5 = this.thread;
            if (r5 == null) goto L6;
            this.thread = null;
            LockSupport.unpark(r5);
            return;
        }

        public Waiter() {
            AbstractResolvableFuture.ATOMIC_HELPER.putThread(this, Thread.currentThread());
        }
    }

    static {
        GENERATE_CANCELLATION_CAUSES = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        log = Logger.getLogger(AbstractResolvableFuture.class.getName());
        AtomicHelper r5 = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Waiter.class, "next"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Waiter.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Listener.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Object.class, "value"));     // Catch: Throwable -> L5
        th = null;
    L7:
        ATOMIC_HELPER = r5;
        if (th == null) goto L10;
        log.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
    L10:
        NULL = new Object();
        return;
    L5:
        th = th;
        r5 = new SynchronizedHelper();
        goto L7
    }

    public AbstractResolvableFuture() {
    }

    private void addDoneString(StringBuilder r5) {
        Object r10 = getUninterruptibly(this);     // Catch: RuntimeException -> L5 ExecutionException -> L7 CancellationException -> L10
        r5.append("SUCCESS, result=[");     // Catch: RuntimeException -> L5 ExecutionException -> L7 CancellationException -> L10
        r5.append(userObjectToString(r10));     // Catch: RuntimeException -> L5 ExecutionException -> L7 CancellationException -> L10
        r5.append("]");     // Catch: RuntimeException -> L5 ExecutionException -> L7 CancellationException -> L10
    L17:
        return;
    L10:
        r5.append("CANCELLED");
        return;
    L5:
        e = move-exception;
        r5.append("UNKNOWN, cause=[");
        r5.append(e.getClass());
        r5.append(" thrown from get()]");
        return;
    L7:
        e = move-exception;
        r5.append("FAILURE, cause=[");
        r5.append(e.getCause());
        r5.append("]");
    }

    private static CancellationException cancellationExceptionWithCause(@Nullable String r5, @Nullable Throwable r10) {
        CancellationException r11 = new CancellationException(r5);
        r11.initCause(r10);
        return r11;
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T r5) {
        r5.getClass();
        return r5;
    }

    private Listener clearListeners(Listener r5) {
    L2:
        Listener r10 = this.listeners;
        if (ATOMIC_HELPER.casListeners(this, r10, Listener.TOMBSTONE) == false) goto L2;
    L4:
        Listener r11 = r5;
        r5 = r10;
        if (r5 == null) goto L7;
        r10 = r5.next;
        r5.next = r11;
        goto L4
    L7:
        return r11;
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
    public static void complete(AbstractResolvableFuture<V> r5) {
        Listener r10 = null;
    L3:
        r5.releaseWaiters();
        r5.afterDone();
        Listener r11 = r5.clearListeners(r10);
    L4:
        if (r11 == null) goto L14;
        r10 = r11.next;
        Runnable r12 = r11.task;
        if ((r12 instanceof SetFuture) == false) goto L12;
        SetFuture r13 = (SetFuture) r12;
        r5 = r13.owner;
        if (r5.value != r13) goto L13;
        Object r14 = getFutureValue(r13.future);
        if (ATOMIC_HELPER.casValue(r5, r13, r14) == true) goto L3;
    L13:
        r11 = r10;
        goto L4
    L12:
        executeListener(r12, r11.executor);
        goto L13
    }

    private static void executeListener(Runnable r5, Executor r10) {
        r10.execute(r5);     // Catch: RuntimeException -> L4
        return;
    L4:
        e = move-exception;
        log.log(Level.SEVERE, "RuntimeException while executing runnable " + r5 + " with executor " + r10, e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private V getDoneValue(Object r5) throws ExecutionException {
        if ((r5 instanceof Cancellation) == true) goto L14;
        if ((r5 instanceof Failure) == true) goto L12;
        if (r5 != NULL) goto L10;
        return null;
    L10:
        return r5;
    L12:
        throw new ExecutionException(((Failure) r5).exception);
    L14:
        throw cancellationExceptionWithCause("Task was cancelled.", ((Cancellation) r5).cause);
    }

    public static Object getFutureValue(w0 r5) {
        if ((r5 instanceof AbstractResolvableFuture) == false) goto L13;
        Object r10 = ((AbstractResolvableFuture) r5).value;
        if ((r10 instanceof Cancellation) == false) goto L39;
        Cancellation r11 = (Cancellation) r10;
        if (r11.wasInterrupted == true) goto L9;
        return r10;
    L9:
        if (r11.cause == null) goto L12;
        return new Cancellation(false, r11.cause);
    L12:
        return Cancellation.CAUSELESS_CANCELLED;
    L39:
        return r10;
    L13:
        boolean r12 = r5.isCancelled();
        if (((!GENERATE_CANCELLATION_CAUSES) & r12) == true) goto L16;
        Object r13 = getUninterruptibly(r5);     // Catch: Throwable -> L21 CancellationException -> L23 ExecutionException -> L25
        if (r13 != null) goto L27;
    L42:
        return NULL;
    L27:
        return r13;
    L23:
        e = move-exception;
        if (r12 == true) goto L34;
        return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + r5, e));
    L34:
        return new Cancellation(false, e);
    L25:
        e = move-exception;
        return new Failure(e.getCause());
    L21:
        th = move-exception;
        return new Failure(th);
    L16:
        return Cancellation.CAUSELESS_CANCELLED;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static <V> V getUninterruptibly(Future<V> r5) throws ExecutionException {
        boolean r10 = false;
    L12:
        V r11 = r5.get();     // Catch: Throwable -> L7 InterruptedException -> L11
    L4:
        if (r10 == false) goto L6;
        Thread.currentThread().interrupt();
    L6:
        return r11;
    L11:
        r10 = true;
    L7:
        th = move-exception;
        if (r10 == false) goto L10;
        Thread.currentThread().interrupt();
    L10:
        throw th;
    }

    private void releaseWaiters() {
    L2:
        Waiter r5 = this.waiters;
        if (ATOMIC_HELPER.casWaiters(this, r5, Waiter.TOMBSTONE) == false) goto L2;
    L4:
        if (r5 == null) goto L6;
        r5.unpark();
        r5 = r5.next;
        goto L4
    }

    private void removeWaiter(Waiter r5) {
        r5.thread = null;
    L3:
        Waiter r10 = this.waiters;
        if (r10 == Waiter.TOMBSTONE) goto L5;
        Waiter r11 = null;
    L7:
        if (r10 == null) goto L19;
        Waiter r12 = r10.next;
        if (r10.thread == null) goto L11;
        r11 = r10;
    L18:
        r10 = r12;
        goto L7
    L11:
        if (r11 == null) goto L16;
        r11.next = r12;
        if (r11.thread != null) goto L18;
    L16:
        if (ATOMIC_HELPER.casWaiters(this, r10, r12) == true) goto L18;
    L19:
        return;
    }

    private String userObjectToString(Object r5) {
        if (r5 != this) goto L6;
        return "this future";
    L6:
        return String.valueOf(r5);
    }

    @Override // com.google.common.util.concurrent.w0
    public final void addListener(Runnable r5, Executor r10) {
        checkNotNull(r5);
        checkNotNull(r10);
        Listener r11 = this.listeners;
        if (r11 == Listener.TOMBSTONE) goto L10;
        Listener r12 = new Listener(r5, r10);
    L5:
        r12.next = r11;
        if (ATOMIC_HELPER.casListeners(this, r11, r12) == true) goto L7;
        r11 = this.listeners;
        if (r11 != Listener.TOMBSTONE) goto L5;
    L7:
        return;
    L10:
        executeListener(r5, r10);
    }

    public void afterDone() {
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean r10) {
        Object r5 = this.value;
        if (r5 != null) goto L5;
        boolean r11 = true;
    L7:
        if ((r11 | (r5 instanceof SetFuture)) == false) goto L35;
        if (GENERATE_CANCELLATION_CAUSES == false) goto L11;
        Cancellation r12 = new Cancellation(r10, new CancellationException("Future.cancel() was called."));
    L14:
        boolean r13 = false;
    L16:
        if (ATOMIC_HELPER.casValue(this, r5, r12) == true) goto L17;
        r5 = this.value;
        if ((r5 instanceof SetFuture) == true) goto L16;
        return r13;
    L17:
        if (r10 == false) goto L19;
        this.interruptTask();
    L19:
        complete(this);
        if ((r5 instanceof SetFuture) == false) goto L47;
        w0 r14 = ((SetFuture) r5).future;
        if ((r14 instanceof AbstractResolvableFuture) == false) goto L30;
        AbstractResolvableFuture<V> this = (AbstractResolvableFuture) r14;
        r5 = this.value;
        if (r5 != null) goto L26;
        boolean r15 = true;
    L28:
        if ((r15 | (r5 instanceof SetFuture)) == false) goto L48;
        r13 = true;
        goto L16
    L48:
        return true;
    L26:
        r15 = false;
        goto L28
    L30:
        r14.cancel(r10);
        return true;
    L47:
        return true;
    L11:
        if (r10 == false) goto L13;
        r12 = Cancellation.CAUSELESS_INTERRUPTED;
        goto L14
    L13:
        r12 = Cancellation.CAUSELESS_CANCELLED;
        goto L14
    L35:
        return false;
    L5:
        r11 = false;
        goto L7
    }

    @Override // java.util.concurrent.Future
    public final V get(long r18, TimeUnit r20) throws InterruptedException, TimeoutException, ExecutionException {
        long r5 = r20.toNanos(r18);
        if (Thread.interrupted() == true) goto L81;
        Object r10 = this.value;
        if (r10 == null) goto L7;
        boolean r11 = true;
    L9:
        if ((r11 & (!(r10 instanceof SetFuture))) == false) goto L13;
        return getDoneValue(r10);
    L13:
        if (r5 <= 0) goto L15;
        long r12 = System.nanoTime() + r5;
    L17:
        if (r5 < 1000) goto L43;
        Waiter r13 = this.waiters;
        if (r13 == Waiter.TOMBSTONE) goto L41;
        Waiter r15 = new Waiter();
    L21:
        r15.setNext(r13);
        if (ATOMIC_HELPER.casWaiters(this, r13, r15) == true) goto L23;
        r13 = this.waiters;
        if (r13 != Waiter.TOMBSTONE) goto L21;
    L23:
        LockSupport.parkNanos(this, r5);
        if (Thread.interrupted() == true) goto L36;
        Object r14 = this.value;
        if (r14 == null) goto L28;
        boolean r16 = true;
    L30:
        if ((r16 & (!(r14 instanceof SetFuture))) == true) goto L32;
        r5 = r12 - System.nanoTime();
        if (r5 >= 1000) goto L23;
        removeWaiter(r15);
        goto L43
    L32:
        return getDoneValue(r14);
    L28:
        r16 = false;
        goto L30
    L36:
        removeWaiter(r15);
        throw new InterruptedException();
    L41:
        return getDoneValue(this.value);
    L43:
        if (r5 <= 0) goto L57;
        Object r17 = this.value;
        if (r17 == null) goto L47;
        boolean r19 = true;
    L49:
        if ((r19 & (!(r17 instanceof SetFuture))) == true) goto L51;
        if (Thread.interrupted() == true) goto L56;
        r5 = r12 - System.nanoTime();
        goto L43
    L56:
        throw new InterruptedException();
    L51:
        return getDoneValue(r17);
    L47:
        r19 = false;
        goto L49
    L57:
        String r21 = toString();
        String r22 = r20.toString();
        Locale r110 = Locale.ROOT;
        String r23 = r22.toLowerCase(r110);
        StringBuilder r24 = j0.t(r18, "Waited ", " ");
        r24.append(r20.toString().toLowerCase(r110));
        String r25 = r24.toString();
        if ((r5 + 1000) >= 0) goto L75;
        String r26 = j0.j(r25, " (plus ");
        long r27 = -r5;
        long r111 = r20.convert(r27, TimeUnit.NANOSECONDS);
        long r28 = r27 - r20.toNanos(r111);
        if (r111 != 0) goto L62;
    L65:
        boolean r112 = true;
    L66:
        if (r111 <= 0) goto L71;
        String r29 = r26 + r111 + " " + r23;
        if (r112 == false) goto L70;
        r29 = j0.j(r29, ",");
    L70:
        r26 = j0.j(r29, " ");
    L71:
        if (r112 == false) goto L73;
        r26 = r26 + r28 + " nanoseconds ";
    L73:
        r25 = j0.j(r26, "delay)");
        goto L75
    L62:
        if (r28 > 1000) goto L65;
        r112 = false;
    L75:
        if (isDone() == false) goto L79;
        throw new TimeoutException(j0.j(r25, " but future completed as timeout expired"));
    L79:
        throw new TimeoutException(j0.D(r25, " for ", r21));
    L15:
        r12 = 0;
        goto L17
    L7:
        r11 = false;
        goto L9
    L81:
        throw new InterruptedException();
    }

    public void interruptTask() {
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.value instanceof Cancellation;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        Object r5 = this.value;
        if (r5 == null) goto L5;
        boolean r10 = true;
    L7:
        return (!(r5 instanceof SetFuture)) & r10;
    L5:
        r10 = false;
        goto L7
    }

    public final void maybePropagateCancellationTo(@Nullable Future<?> r5) {
        if (r5 == null) goto L4;
        boolean r10 = true;
    L6:
        if ((r10 & isCancelled()) == false) goto L9;
        r5.cancel(wasInterrupted());
        return;
    L9:
        return;
    L4:
        r10 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public String pendingToString() {
        Object r5 = this.value;
        if ((r5 instanceof SetFuture) == false) goto L7;
        return j0.q(new StringBuilder("setFuture=["), userObjectToString(((SetFuture) r5).future), "]");
    L7:
        if ((this instanceof ScheduledFuture) == true) goto L9;
        return null;
    L9:
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
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
    public boolean set(@Nullable V r5) {
        if (r5 != null) goto L5;
        r5 = (V) NULL;
    L5:
        if (ATOMIC_HELPER.casValue(this, null, r5) == false) goto L8;
        complete(this);
        return true;
    L8:
        return false;
    }

    public boolean setException(Throwable r5) {
        Failure r10 = new Failure((Throwable) checkNotNull(r5));
        if (ATOMIC_HELPER.casValue(this, null, r10) == false) goto L6;
        complete(this);
        return true;
    L6:
        return false;
    }

    public boolean setFuture(w0 r10) {
        checkNotNull(r10);
        Object r5 = this.value;
        if (r5 != null) goto L23;
        if (r10.isDone() == false) goto L11;
        Object r11 = getFutureValue(r10);
        if (ATOMIC_HELPER.casValue(this, null, r11) == false) goto L10;
        complete(this);
        return true;
    L10:
        return false;
    L11:
        SetFuture r12 = new SetFuture(this, r10);
        if (ATOMIC_HELPER.casValue(this, null, r12) == true) goto L26;
        r5 = this.value;
        goto L23
    L26:
        r10.addListener(r12, DirectExecutor.INSTANCE);     // Catch: Throwable -> L15
    L20:
        return true;
    L15:
        th = move-exception;
        Failure r13 = new Failure(th);     // Catch: Throwable -> L18
    L19:
        ATOMIC_HELPER.casValue(this, r12, r13);
    L18:
        r13 = Failure.FALLBACK_INSTANCE;
    L23:
        if ((r5 instanceof Cancellation) == false) goto L25;
        r10.cancel(((Cancellation) r5).wasInterrupted);
    L25:
        return false;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder();
        r5.append(super.toString());
        r5.append("[status=");
        if (isCancelled() == false) goto L6;
        r5.append("CANCELLED");
    L20:
        r5.append("]");
        return r5.toString();
    L6:
        if (isDone() == false) goto L22;
        addDoneString(r5);
        goto L20
    L22:
        String r10 = pendingToString();     // Catch: RuntimeException -> L10
    L12:
        if (r10 == null) goto L17;
        if (r10.isEmpty() == true) goto L17;
        r5.append("PENDING, info=[");
        r5.append(r10);
        r5.append("]");
    L17:
        if (isDone() == false) goto L19;
        addDoneString(r5);
        goto L20
    L19:
        r5.append("PENDING");
    L10:
        e = move-exception;
        r10 = "Exception thrown from implementation: " + e.getClass();
        goto L12
    }

    public final boolean wasInterrupted() {
        Object r5 = this.value;
        if ((r5 instanceof Cancellation) == true) goto L5;
    L7:
        return false;
    L5:
        if (((Cancellation) r5).wasInterrupted == false) goto L7;
        return true;
    }

    @Override // java.util.concurrent.Future
    public final V get() throws InterruptedException, ExecutionException {
        if (Thread.interrupted() == true) goto L34;
        Object r5 = this.value;
        if (r5 == null) goto L7;
        boolean r10 = true;
    L9:
        if ((r10 & (!(r5 instanceof SetFuture))) == true) goto L11;
        Waiter r11 = this.waiters;
        if (r11 == Waiter.TOMBSTONE) goto L32;
        Waiter r12 = new Waiter();
    L15:
        r12.setNext(r11);
        if (ATOMIC_HELPER.casWaiters(this, r11, r12) == true) goto L17;
        r11 = this.waiters;
        if (r11 != Waiter.TOMBSTONE) goto L15;
    L17:
        LockSupport.park(this);
        if (Thread.interrupted() == true) goto L27;
        Object r13 = this.value;
        if (r13 == null) goto L22;
        boolean r14 = true;
    L24:
        if ((r14 & (!(r13 instanceof SetFuture))) == false) goto L17;
        return getDoneValue(r13);
    L22:
        r14 = false;
        goto L24
    L27:
        removeWaiter(r12);
        throw new InterruptedException();
    L32:
        return getDoneValue(this.value);
    L11:
        return getDoneValue(r5);
    L7:
        r10 = false;
        goto L9
    L34:
        throw new InterruptedException();
    }
}
