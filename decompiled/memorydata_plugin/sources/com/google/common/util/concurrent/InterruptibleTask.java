package com.google.common.util.concurrent;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.AbstractOwnableSynchronizer;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes2.dex */
abstract class InterruptibleTask<T> extends AtomicReference<Runnable> implements Runnable {
    private static final Runnable DONE = null;
    private static final int MAX_BUSY_WAIT_SPINS = 1000;
    private static final Runnable PARKED = null;

    /* JADX INFO: renamed from: com.google.common.util.concurrent.InterruptibleTask$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    static final class Blocker extends AbstractOwnableSynchronizer implements Runnable {
        private final InterruptibleTask<?> task;

        private Blocker(InterruptibleTask<?> r1) {
            this.task = r1;
        }

        /* synthetic */ Blocker(InterruptibleTask r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ void access$200(Blocker r0, Thread r1) {
            r0.setOwner(r1);
        }

        private void setOwner(Thread r1) {
            super.setExclusiveOwnerThread(r1);
        }

        Thread getOwner() {
            return super.getExclusiveOwnerThread();
        }

        @Override // java.lang.Runnable
        public void run() {
        }

        public String toString() {
            return this.task.toString();
        }
    }

    private static final class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    static {
        AnonymousClass1 r1 = null;
        DONE = new a(r1);
        PARKED = new a(r1);
    }

    InterruptibleTask() {
    }

    private void waitForInterrupt(Thread r9) {
        Runnable r0 = (Runnable) ZeusTransformUtils.preCheckCast(get(), Runnable.class, "com.obric.memorydata.plugin");
        Blocker r3 = null;
        boolean r4 = false;
        int r5 = 0;
    L4:
        if (ZeusTransformUtils.instanceOf(r0, Blocker.class) == true) goto L12;
        if (r0 == PARKED) goto L12;
        if (r4 == false) goto L33;
        r9.interrupt();
        return;
    L33:
        return;
    L12:
        if (ZeusTransformUtils.instanceOf(r0, Blocker.class) == false) goto L14;
        r3 = (Blocker) ZeusTransformUtils.preCheckCast(r0, Blocker.class, "com.obric.memorydata.plugin");
    L14:
        r5 = r5 + 1;
        if (r5 <= 1000) goto L27;
        Runnable r7 = PARKED;
        if (r0 == r7) goto L21;
        if (compareAndSet(r0, r7) == true) goto L21;
    L28:
        r0 = (Runnable) ZeusTransformUtils.preCheckCast(get(), Runnable.class, "com.obric.memorydata.plugin");
    L21:
        if (Thread.interrupted() == true) goto L25;
        if (r4 == true) goto L25;
        r4 = false;
    L26:
        LockSupport.park(r3);
    L25:
        r4 = true;
        goto L26
    L27:
        Thread.yield();
        goto L28
    }

    abstract void afterRanInterruptiblyFailure(Throwable r1);

    abstract void afterRanInterruptiblySuccess(T r1);

    final void interruptTask() {
        Runnable r0 = (Runnable) ZeusTransformUtils.preCheckCast(get(), Runnable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, Thread.class) == false) goto L15;
        Blocker r1 = new Blocker(this, null);
        Blocker.access$200(r1, Thread.currentThread());
        if (compareAndSet(r0, r1) == false) goto L18;
        ((Thread) ZeusTransformUtils.preCheckCast(r0, Thread.class, "com.obric.memorydata.plugin")).interrupt();     // Catch: Throwable -> L10
        if (((Runnable) ZeusTransformUtils.preCheckCast(getAndSet(DONE), Runnable.class, "com.obric.memorydata.plugin")) != PARKED) goto L19;
        LockSupport.unpark((Thread) ZeusTransformUtils.preCheckCast(r0, Thread.class, "com.obric.memorydata.plugin"));
        return;
    L19:
        return;
    L10:
        th = move-exception;
        if (((Runnable) ZeusTransformUtils.preCheckCast(getAndSet(DONE), Runnable.class, "com.obric.memorydata.plugin")) != PARKED) goto L14;
        LockSupport.unpark((Thread) ZeusTransformUtils.preCheckCast(r0, Thread.class, "com.obric.memorydata.plugin"));
    L14:
        throw th;
    L18:
        return;
    }

    abstract boolean isDone();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        Thread r0 = Thread.currentThread();
        Object r1 = null;
        if (compareAndSet(null, r0) == true) goto L5;
        return;
    L5:
        boolean r2 = !isDone();
        if (r2 == false) goto L24;
        r1 = runInterruptibly();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        v.a(th);     // Catch: Throwable -> L16
        if (compareAndSet(r0, DONE) == true) goto L14;
        waitForInterrupt(r0);
    L14:
        if (r2 == false) goto L33;
        afterRanInterruptiblyFailure(th);
        return;
    L33:
        return;
    L16:
        th = move-exception;
        if (compareAndSet(r0, DONE) == true) goto L20;
        waitForInterrupt(r0);
    L20:
        if (r2 == false) goto L22;
        afterRanInterruptiblySuccess(t.a(null));
    L22:
        throw th;
    L24:
        if (compareAndSet(r0, DONE) == true) goto L26;
        waitForInterrupt(r0);
    L26:
        if (r2 == false) goto L35;
        afterRanInterruptiblySuccess(t.a(r1));
        return;
    }

    abstract T runInterruptibly();

    abstract String toPendingString();

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        Runnable r0 = (Runnable) ZeusTransformUtils.preCheckCast(get(), Runnable.class, "com.obric.memorydata.plugin");
        if (r0 != DONE) goto L6;
        String r1 = "running=[DONE]";
    L13:
        return r1 + ", " + toPendingString();
    L6:
        if (ZeusTransformUtils.instanceOf(r0, Blocker.class) == false) goto L9;
        r1 = "running=[INTERRUPTED]";
        goto L13
    L9:
        if (ZeusTransformUtils.instanceOf(r0, Thread.class) == false) goto L11;
        r1 = "running=[RUNNING ON " + ((Thread) ZeusTransformUtils.preCheckCast(r0, Thread.class, "com.obric.memorydata.plugin")).getName() + "]";
        goto L13
    L11:
        r1 = "running=[NOT STARTED YET]";
        goto L13
    }
}
