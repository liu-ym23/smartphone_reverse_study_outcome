package com.ttnet.org.chromium.net.urlconnection;

import com.bytedance.crash.service.INetworkCallback;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class MessageLoop implements Executor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long INVALID_THREAD_ID = -1;
    private static final AtomicBoolean mDisableValidThreadAssert = null;
    private boolean mLoopFailed;
    private boolean mLoopRunning;
    private InterruptedIOException mPriorInterruptedIOException;
    private RuntimeException mPriorRuntimeException;
    private final BlockingQueue<Runnable> mQueue;
    private long mThreadId;

    static {
        mDisableValidThreadAssert = new AtomicBoolean(false);
    }

    public MessageLoop() {
        this.mThreadId = -1;
        this.mQueue = new LinkedBlockingQueue();
    }

    private boolean calledOnValidThread() {
        if (mDisableValidThreadAssert.get() == false) goto L5;
        return true;
    L5:
        long r10 = this.mThreadId;
        if (r10 != (-1)) goto L10;
        this.mThreadId = Thread.currentThread().getId();
        return true;
    L10:
        if (r10 == Thread.currentThread().getId()) goto L14;
        return false;
    L14:
        return true;
    }

    public static void disableVaildThreadAssert(boolean r10) {
        mDisableValidThreadAssert.set(r10);
    }

    private Runnable take(boolean r10, long r11) {
        if (r10 == true) goto L5;
        Runnable r12 = this.mQueue.take();     // Catch: InterruptedException -> L11
    L4:
        Runnable r13 = r12;     // Catch: InterruptedException -> L11
        if (r13 == null) goto L10;
        return r13;
    L10:
        throw new SocketTimeoutException(INetworkCallback.TYPE_TTNET);
    L5:
        r12 = this.mQueue.poll(r11, TimeUnit.NANOSECONDS);     // Catch: InterruptedException -> L11
    L11:
        e = move-exception;
        InterruptedIOException r14 = new InterruptedIOException();
        r14.initCause(e);
        throw r14;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r10) {
        if (r10 == null) goto L9;
        this.mQueue.put(r10);     // Catch: InterruptedException -> L5
        return;
    L5:
        e = move-exception;
        throw new RejectedExecutionException(e);
    L9:
        throw new IllegalArgumentException();
    }

    public boolean hasLoopFailed() {
        return this.mLoopFailed;
    }

    public boolean isRunning() {
        return this.mLoopRunning;
    }

    public void loop() {
        loop(0);
    }

    public void loop(int r10) {
        long r11 = System.nanoTime();
        long r12 = TimeUnit.NANOSECONDS.convert(r10, TimeUnit.MILLISECONDS);
        if (this.mLoopFailed == false) goto L10;
        InterruptedIOException r13 = this.mPriorInterruptedIOException;
        if (r13 == null) goto L8;
        throw r13;
    L8:
        throw this.mPriorRuntimeException;
    L10:
        if (this.mLoopRunning == true) goto L32;
        this.mLoopRunning = true;
    L13:
        if (this.mLoopRunning == false) goto L30;
        if (r10 == 0) goto L33;
        Runnable r14 = take(true, (r12 - System.nanoTime()) + r11);     // Catch: RuntimeException -> L21 InterruptedIOException -> L24 SocketTimeoutException -> L27
    L18:
        r14.run();     // Catch: RuntimeException -> L21 InterruptedIOException -> L24 SocketTimeoutException -> L27
        goto L13
    L33:
        r14 = take(false, 0);     // Catch: RuntimeException -> L21 InterruptedIOException -> L24 SocketTimeoutException -> L27
    L27:
        e = move-exception;
        this.mLoopRunning = false;
        this.mLoopFailed = true;
        throw e;
    L24:
        e = move-exception;
        this.mLoopRunning = false;
        this.mLoopFailed = true;
        this.mPriorInterruptedIOException = e;
        throw e;
    L21:
        e = move-exception;
        this.mLoopRunning = false;
        this.mLoopFailed = true;
        this.mPriorRuntimeException = e;
        throw e;
    L30:
        return;
    L32:
        throw new IllegalStateException("Cannot run loop when it is already running.");
    }

    public void quit() {
        this.mLoopRunning = false;
    }

    public void reset() {
        this.mLoopFailed = false;
    }
}
