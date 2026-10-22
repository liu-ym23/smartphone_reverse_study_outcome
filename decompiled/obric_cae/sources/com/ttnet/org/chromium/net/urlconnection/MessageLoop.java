package com.ttnet.org.chromium.net.urlconnection;

import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class MessageLoop implements Executor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long INVALID_THREAD_ID = -1;
    private boolean mLoopFailed;
    private boolean mLoopRunning;
    private InterruptedIOException mPriorInterruptedIOException;
    private RuntimeException mPriorRuntimeException;
    private final BlockingQueue<Runnable> mQueue;
    private long mThreadId;

    public MessageLoop() {
        this.mThreadId = -1;
        this.mQueue = new LinkedBlockingQueue();
    }

    private boolean calledOnValidThread() {
        long r8 = this.mThreadId;
        if (r8 != (-1)) goto L7;
        this.mThreadId = Thread.currentThread().getId();
        return true;
    L7:
        if (r8 == Thread.currentThread().getId()) goto L11;
        return false;
    L11:
        return true;
    }

    private Runnable take(boolean r8, long r10) {
        if (r8 == true) goto L5;
        Runnable r11 = this.mQueue.take();     // Catch: InterruptedException -> L11
    L4:
        Runnable r12 = r11;     // Catch: InterruptedException -> L11
        if (r12 == null) goto L10;
        return r12;
    L10:
        throw new SocketTimeoutException();
    L5:
        r11 = this.mQueue.poll(r10, TimeUnit.NANOSECONDS);     // Catch: InterruptedException -> L11
    L11:
        e = move-exception;
        InterruptedIOException r13 = new InterruptedIOException();
        r13.initCause(e);
        throw r13;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r8) {
        if (r8 == null) goto L9;
        this.mQueue.put(r8);     // Catch: InterruptedException -> L5
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

    public void quit() {
        this.mLoopRunning = false;
    }

    public void reset() {
        this.mLoopFailed = false;
    }

    public void loop(int r10) {
        long r8 = System.nanoTime();
        long r11 = TimeUnit.NANOSECONDS.convert(r10, TimeUnit.MILLISECONDS);
        if (this.mLoopFailed == false) goto L10;
        InterruptedIOException r12 = this.mPriorInterruptedIOException;
        if (r12 == null) goto L8;
        throw r12;
    L8:
        throw this.mPriorRuntimeException;
    L10:
        if (this.mLoopRunning == true) goto L32;
        this.mLoopRunning = true;
    L13:
        if (this.mLoopRunning == false) goto L30;
        if (r10 == 0) goto L33;
        Runnable r13 = take(true, (r11 - System.nanoTime()) + r8);     // Catch: RuntimeException -> L21 InterruptedIOException -> L24 SocketTimeoutException -> L27
    L18:
        r13.run();     // Catch: RuntimeException -> L21 InterruptedIOException -> L24 SocketTimeoutException -> L27
        goto L13
    L33:
        r13 = take(false, 0);     // Catch: RuntimeException -> L21 InterruptedIOException -> L24 SocketTimeoutException -> L27
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
}
