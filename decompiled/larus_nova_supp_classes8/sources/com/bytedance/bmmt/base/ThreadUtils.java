package com.bytedance.bmmt.base;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class ThreadUtils {

    /* JADX INFO: renamed from: com.bytedance.bmmt.base.ThreadUtils$1CaughtException, reason: invalid class name */
    public class C1CaughtException {
        Exception e;

        public C1CaughtException() {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.bmmt.base.ThreadUtils$1Result, reason: invalid class name */
    public class C1Result {
        public V value;

        public C1Result() {
        }
    }

    public interface BlockingOperation {
        void run() throws InterruptedException;
    }

    public static class ThreadChecker {
        private Thread thread;

        public void detachThread() {
            this.thread = null;
        }

        public void checkIsOnValidThread() {
            if (this.thread != null) goto L6;
            this.thread = ThreadMethodProxy.currentThread();
        L6:
            if (ThreadMethodProxy.currentThread() != this.thread) goto L9;
            return;
        L9:
            throw new IllegalStateException("Wrong thread");
        }

        public ThreadChecker() {
            this.thread = ThreadMethodProxy.currentThread();
        }
    }

    public ThreadUtils() {
    }

    public static void checkIsOnMainThread() {
        if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L6;
        return;
    L6:
        throw new IllegalStateException("Not on main thread!");
    }

    public static void awaitUninterruptibly(final CountDownLatch r1) {
        executeUninterruptibly(new AnonymousClass2(r1));
    }

    public static void executeUninterruptibly(BlockingOperation r1) {
        boolean r0 = false;
    L8:
        r1.run();     // Catch: InterruptedException -> L7
        if (r0 == false) goto L11;
        ThreadMethodProxy.currentThread().interrupt();
        return;
    L11:
        return;
    L7:
        r0 = true;
        goto L8
    }

    public static void joinUninterruptibly(final Thread r1) {
        executeUninterruptibly(new AnonymousClass1(r1));
    }

    public static boolean awaitUninterruptibly(CountDownLatch r9, long r10) {
        long r0 = SystemClock.elapsedRealtime();
        boolean r2 = false;
        long r3 = r10;
        boolean r5 = false;
    L10:
        r2 = r9.await(r3, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L5
    L7:
        if (r5 == false) goto L9;
        ThreadMethodProxy.currentThread().interrupt();
    L9:
        return r2;
    L5:
        r3 = r10 - (SystemClock.elapsedRealtime() - r0);
        r5 = true;
        if (r3 > 0) goto L10;
        goto L7
    }

    public static StackTraceElement[] concatStackTraces(StackTraceElement[] r3, StackTraceElement[] r4) {
        StackTraceElement[] r0 = new StackTraceElement[r3.length + r4.length];
        System.arraycopy(r3, 0, r0, 0, r3.length);
        System.arraycopy(r4, 0, r0, r3.length, r4.length);
        return r0;
    }

    public static <V> V invokeAtFrontUninterruptibly(Handler r4, final Callable<V> r5) {
        if (ThreadMethodProxy.getLooperThread(r4.getLooper()) == ThreadMethodProxy.currentThread()) goto L19;
        final C1Result r0 = new C1Result();
        final C1CaughtException r1 = new C1CaughtException();
        final CountDownLatch r2 = new CountDownLatch(1);
        if (r4.post(new AnonymousClass3(r0, r5, r1, r2)) == true) goto L13;
        return null;
    L13:
        awaitUninterruptibly(r2);
        if (r1.e == null) goto L16;
        RuntimeException r6 = new RuntimeException(r1.e);
        r6.setStackTrace(concatStackTraces(r1.e.getStackTrace(), r6.getStackTrace()));
        throw r6;
    L16:
        return r0.value;
    L19:
        return r5.call();
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static boolean joinUninterruptibly(Thread r9, long r10) {
        long r0 = SystemClock.elapsedRealtime();
        boolean r2 = false;
        long r3 = r10;
    L4:
        if (r3 <= 0) goto L8;
        ThreadMethodProxy.join(r9, r3);     // Catch: InterruptedException -> L7
    L7:
        r3 = r10 - (SystemClock.elapsedRealtime() - r0);
        r2 = true;
    L8:
        if (r2 == false) goto L11;
        ThreadMethodProxy.currentThread().interrupt();
    L11:
        return !ThreadMethodProxy.isAlive(r9);
    }

    public static void invokeAtFrontUninterruptibly(Handler r1, final Runnable r2) {
        invokeAtFrontUninterruptibly(r1, new AnonymousClass4(r2));
    }
}
