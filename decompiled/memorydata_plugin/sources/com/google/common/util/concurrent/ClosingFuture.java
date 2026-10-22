package com.google.common.util.concurrent;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class ClosingFuture<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f4804a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicReference<State> f4805b;
    private final CloseableList c;
    private final g<V> d;

    /* JADX INFO: renamed from: com.google.common.util.concurrent.ClosingFuture$1, reason: invalid class name */
    class AnonymousClass1 {
    }

    /* JADX INFO: renamed from: com.google.common.util.concurrent.ClosingFuture$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4806a = null;

        static {
            int[] r0 = new int[State.values().length];
            f4806a = r0;
            r0[State.SUBSUMED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f4806a[State.WILL_CREATE_VALUE_AND_CLOSER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f4806a[State.WILL_CLOSE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f4806a[State.CLOSING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f4806a[State.CLOSED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f4806a[State.OPEN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    private static final class CloseableList extends IdentityHashMap<AutoCloseable, Executor> implements Closeable {
        private volatile boolean closed;
        private final c closer;
        private volatile CountDownLatch whenClosed;

        private CloseableList() {
            this.closer = new c(this);
        }

        /* synthetic */ CloseableList(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ c access$300(CloseableList r0) {
            return r0.closer;
        }

        void add(AutoCloseable r3, Executor r4) {
            AutoCloseable r5 = (AutoCloseable) ZeusTransformUtils.wrapperContextForParams(r3, AutoCloseable.class, "com.obric.memorydata.plugin");
            Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.memorydata.plugin");
            com.google.common.base.n.a(r6);
            if (r5 != null) goto L5;
            return;
        L5:
            monitor-enter(this);
        L14:
            th = move-exception;
            throw th;
        L7:
            if (this.closed == true) goto L11;
            put(r5, r6);     // Catch: Throwable -> L14
            monitor-exit(this);     // Catch: Throwable -> L14
            return;
        L11:
            monitor-exit(this);     // Catch: Throwable -> L14
            ClosingFuture.a(r5, r6);
        }

        <V, U> g<U> applyAsyncClosingFunction(a<V, U> r3, V r4) {
            a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
            CloseableList r0 = new CloseableList();
            ClosingFuture<U> r6 = r5.a(r0.closer, r4);     // Catch: Throwable -> L6
            ClosingFuture.a(r6, r0);     // Catch: Throwable -> L6
            g<U> r7 = ClosingFuture.a(r6);     // Catch: Throwable -> L6
            add(r0, s.a());
            return r7;
        L6:
            th = move-exception;
            add(r0, s.a());
            throw th;
        }

        <V, U> l<U> applyClosingFunction(b<? super V, U> r3, V r4) {
            b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
            CloseableList r0 = new CloseableList();
            l<U> r6 = h.a(r5.a(r0.closer, r4));     // Catch: Throwable -> L6
            add(r0, s.a());
            return r6;
        L6:
            th = move-exception;
            add(r0, s.a());
            throw th;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed == false) goto L5;
            return;
        L5:
            monitor-enter(this);
        L20:
            th = move-exception;
            throw th;
        L7:
            if (this.closed == false) goto L10;
            monitor-exit(this);     // Catch: Throwable -> L20
            return;
        L10:
            this.closed = true;     // Catch: Throwable -> L20
            monitor-exit(this);     // Catch: Throwable -> L20
            Iterator<Map.Entry<AutoCloseable, Executor>> r0 = entrySet().iterator();
        L14:
            if (r0.hasNext() == false) goto L16;
            Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            ClosingFuture.a((AutoCloseable) ZeusTransformUtils.preCheckCast(r1.getKey(), AutoCloseable.class, "com.obric.memorydata.plugin"), (Executor) ZeusTransformUtils.preCheckCast(r1.getValue(), Executor.class, "com.obric.memorydata.plugin"));
            goto L14
        L16:
            clear();
            if (this.whenClosed == null) goto L25;
            this.whenClosed.countDown();
            return;
        }

        CountDownLatch whenClosedCountDown() {
            boolean r1 = false;
            if (this.closed == true) goto L5;
            monitor-enter(this);
        L18:
            th = move-exception;
            throw th;
        L8:
            if (this.closed == false) goto L13;
            CountDownLatch r0 = new CountDownLatch(0);     // Catch: Throwable -> L18
            monitor-exit(this);     // Catch: Throwable -> L18
            return r0;
        L13:
            if (this.whenClosed != null) goto L15;
            r1 = true;
        L15:
            com.google.common.base.n.b(r1);     // Catch: Throwable -> L18
            CountDownLatch r2 = new CountDownLatch(1);     // Catch: Throwable -> L18
            this.whenClosed = r2;     // Catch: Throwable -> L18
            monitor-exit(this);     // Catch: Throwable -> L18
            return r2;
        L5:
            return new CountDownLatch(0);
        }
    }

    static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State CLOSED = null;
        public static final State CLOSING = null;
        public static final State OPEN = null;
        public static final State SUBSUMED = null;
        public static final State WILL_CLOSE = null;
        public static final State WILL_CREATE_VALUE_AND_CLOSER = null;

        private static /* synthetic */ State[] $values() {
            return new State[]{OPEN, SUBSUMED, WILL_CLOSE, CLOSING, CLOSED, WILL_CREATE_VALUE_AND_CLOSER};
        }

        static {
            OPEN = new State("OPEN", 0);
            SUBSUMED = new State("SUBSUMED", 1);
            WILL_CLOSE = new State("WILL_CLOSE", 2);
            CLOSING = new State("CLOSING", 3);
            CLOSED = new State("CLOSED", 4);
            WILL_CREATE_VALUE_AND_CLOSER = new State("WILL_CREATE_VALUE_AND_CLOSER", 5);
            $VALUES = $values();
        }

        private State(String r1, int r2) {
            super(r1, r2);
        }

        public static State valueOf(String r2) {
            return (State) ZeusTransformUtils.preCheckCast(Enum.valueOf(State.class, r2), State.class, "com.obric.memorydata.plugin");
        }

        public static State[] values() {
            return (State[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), State[].class, "com.obric.memorydata.plugin");
        }
    }

    @FunctionalInterface
    public interface a<T, U> {
        ClosingFuture<U> a(c r1, T r2);
    }

    @FunctionalInterface
    public interface b<T, U> {
        U a(c r1, T r2);
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CloseableList f4808a;

        c(CloseableList r1) {
            this.f4808a = r1;
        }
    }

    static {
        f4804a = Logger.getLogger(ClosingFuture.class.getName());
    }

    static /* synthetic */ g a(ClosingFuture r0) {
        return r0.d;
    }

    private void a(CloseableList r3) {
        a(State.OPEN, State.SUBSUMED);
        r3.add(this.c, s.a());
    }

    private void a(State r2, State r3) {
        com.google.common.base.n.b(b(r2, r3), "Expected state to be %s, but it was %s", r2, r3);
    }

    static /* synthetic */ void a(ClosingFuture r0, CloseableList r1) {
        r0.a(r1);
    }

    static /* synthetic */ void a(ClosingFuture r0, State r1, State r2) {
        r0.a(r1, r2);
    }

    private static /* synthetic */ void a(AutoCloseable r3) {
        ((AutoCloseable) ZeusTransformUtils.wrapperContextForParams(r3, AutoCloseable.class, "com.obric.memorydata.plugin")).close();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        v.a(e);
        f4804a.log(Level.WARNING, "thrown by close()", e);
    }

    static /* synthetic */ void a(AutoCloseable r2, Executor r3) {
        b((AutoCloseable) ZeusTransformUtils.wrapperContextForParams(r2, AutoCloseable.class, "com.obric.memorydata.plugin"), (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.memorydata.plugin"));
    }

    private void b() {
        f4804a.log(Level.FINER, "closing {0}", this);
        this.c.close();
    }

    static /* synthetic */ void b(ClosingFuture r0) {
        r0.b();
    }

    private static void b(AutoCloseable r5, Executor r6) {
        final AutoCloseable r7 = (AutoCloseable) ZeusTransformUtils.wrapperContextForParams(r5, AutoCloseable.class, "com.obric.memorydata.plugin");
        Executor r8 = (Executor) ZeusTransformUtils.wrapperContextForParams(r6, Executor.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L13;
        return;
    L13:
        r8.execute(new $$Lambda$ClosingFuture$MOVxckGNcGf6QXz6KrTccwsrclw(r7));     // Catch: RejectedExecutionException -> L7
        return;
    L7:
        e = move-exception;
        Logger r1 = f4804a;
        if (r1.isLoggable(Level.WARNING) == false) goto L11;
        r1.log(Level.WARNING, String.format("while submitting close to %s; will close inline", new Object[]{r8}), e);
    L11:
        b(r7, s.a());
    }

    private boolean b(State r1, State r2) {
        return this.f4805b.compareAndSet(r1, r2);
    }

    public static /* synthetic */ void lambda$MOVxckGNcGf6QXz6KrTccwsrclw(AutoCloseable r0) {
        a(r0);
    }

    public g<V> a() {
        if (b(State.OPEN, State.WILL_CLOSE) == false) goto L6;
        f4804a.log(Level.FINER, "will close {0}", this);
        this.d.addListener(new AnonymousClass3(this), s.a());
    L17:
        return this.d;
    L6:
        switch(AnonymousClass2.f4806a[((State) ZeusTransformUtils.preCheckCast(this.f4805b.get(), State.class, "com.obric.memorydata.plugin")).ordinal()]) {
            case 1: goto L15;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L11;
            case 5: goto L11;
            case 6: goto L9;
            default: goto L17;
        };
    L9:
        throw new AssertionError();
    L11:
        throw new IllegalStateException("Cannot call finishToFuture() twice");
    L13:
        throw new IllegalStateException("Cannot call finishToFuture() after calling finishToValueAndCloser()");
    L15:
        throw new IllegalStateException("Cannot call finishToFuture() after deriving another step");
    }

    public void finalize() {
        if (((State) ZeusTransformUtils.preCheckCast(this.f4805b.get(), State.class, "com.obric.memorydata.plugin")).equals(State.OPEN) == false) goto L6;
        f4804a.log(Level.SEVERE, "Uh oh! An open ClosingFuture has leaked and will close: {0}", this);
        a();
        return;
    }

    public String toString() {
        return com.google.common.base.i.a(this).a("state", this.f4805b.get()).a(this.d).toString();
    }
}
