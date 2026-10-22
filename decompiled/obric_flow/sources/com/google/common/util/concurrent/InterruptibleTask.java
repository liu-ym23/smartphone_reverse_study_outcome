package com.google.common.util.concurrent;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.AbstractOwnableSynchronizer;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes2.dex */
abstract class InterruptibleTask<T> extends AtomicReference<Runnable> implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.bytedance.android.anniex.worker.a f9394a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bytedance.android.anniex.worker.a f9395b = null;

    public static final class Blocker extends AbstractOwnableSynchronizer implements Runnable {
        private final InterruptibleTask<?> task;

        public Blocker(InterruptibleTask r5, v0 r10) {
            this.task = r5;
        }

        public static void access$200(Blocker r5, Thread r10) {
            r5.setExclusiveOwnerThread(r10);
        }

        @Override // java.lang.Runnable
        public void run() {
        }

        public String toString() {
            return this.task.toString();
        }
    }

    static {
        f9394a = new com.bytedance.android.anniex.worker.a(12);
        f9395b = new com.bytedance.android.anniex.worker.a(12);
    }

    public InterruptibleTask() {
    }

    public final void a(Thread r10) {
        Runnable r5 = get();
        Blocker r11 = null;
        boolean r12 = false;
        int r13 = 0;
    L3:
        boolean r14 = r5 instanceof Blocker;
        com.bytedance.android.anniex.worker.a r15 = f9395b;
        if (r14 == true) goto L10;
        if (r5 == r15) goto L10;
        if (r12 == false) goto L30;
        r10.interrupt();
        return;
    L30:
        return;
    L10:
        if (r14 == false) goto L12;
        r11 = (Blocker) r5;
    L12:
        r13 = r13 + 1;
        if (r13 <= 1000) goto L24;
        if (r5 == r15) goto L18;
        if (compareAndSet(r5, r15) == true) goto L18;
    L25:
        r5 = get();
    L18:
        if (Thread.interrupted() == true) goto L22;
        if (r12 == true) goto L22;
        r12 = false;
    L23:
        LockSupport.park(r11);
    L22:
        r12 = true;
        goto L23
    L24:
        Thread.yield();
        goto L25
    }

    public abstract void afterRanInterruptiblyFailure(Throwable r5);

    public abstract void afterRanInterruptiblySuccess(T r5);

    public final void interruptTask() {
        com.bytedance.android.anniex.worker.a r5 = f9395b;
        com.bytedance.android.anniex.worker.a r10 = f9394a;
        Runnable r11 = get();
        if ((r11 instanceof Thread) == false) goto L15;
        Blocker r12 = new Blocker(this, null);
        Blocker.access$200(r12, Thread.currentThread());
        if (compareAndSet(r11, r12) == false) goto L18;
        ((Thread) r11).interrupt();     // Catch: Throwable -> L10
        if (getAndSet(r10) != r5) goto L19;
        LockSupport.unpark((Thread) r11);
        return;
    L19:
        return;
    L10:
        th = move-exception;
        if (getAndSet(r10) != r5) goto L14;
        LockSupport.unpark((Thread) r11);
    L14:
        throw th;
    L18:
        return;
    }

    public abstract boolean isDone();

    @Override // java.lang.Runnable
    public final void run() {
        Thread r5 = Thread.currentThread();
        T r10 = null;
        if (compareAndSet(null, r5) == true) goto L5;
        return;
    L5:
        boolean r11 = isDone();
        com.bytedance.android.anniex.worker.a r12 = f9394a;
        if (r11 == true) goto L16;
        r10 = runInterruptibly();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (compareAndSet(r5, r12) == true) goto L13;
        a(r5);
    L13:
        if (r11 == true) goto L23;
        afterRanInterruptiblyFailure(th);
        return;
    L23:
        return;
    L16:
        if (compareAndSet(r5, r12) == true) goto L18;
        a(r5);
    L18:
        if (r11 == true) goto L25;
        afterRanInterruptiblySuccess(r10);
        return;
    }

    public abstract T runInterruptibly() throws Exception;

    public abstract String toPendingString();

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        Runnable r5 = get();
        if (r5 != f9394a) goto L6;
        String r10 = "running=[DONE]";
    L12:
        String r11 = toPendingString();
        return androidx.room.jarjarred.org.antlr.runtime.a.m(androidx.room.jarjarred.org.antlr.runtime.a.g(androidx.room.jarjarred.org.antlr.runtime.a.g(2, r10), r11), r10, ", ", r11);
    L6:
        if ((r5 instanceof Blocker) == false) goto L9;
        r10 = "running=[INTERRUPTED]";
        goto L12
    L9:
        if ((r5 instanceof Thread) == false) goto L11;
        String r12 = ((Thread) r5).getName();
        r10 = androidx.room.jarjarred.org.antlr.runtime.a.m(androidx.room.jarjarred.org.antlr.runtime.a.g(21, r12), "running=[RUNNING ON ", r12, "]");
        goto L12
    L11:
        r10 = "running=[NOT STARTED YET]";
        goto L12
    }
}
