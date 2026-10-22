package com.ttnet.org.chromium.net.urlconnection;

import com.bytedance.crash.service.INetworkCallback;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes6.dex */
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
        long r2 = this.mThreadId;
        if (r2 != (-1)) goto L10;
        this.mThreadId = Thread.currentThread().getId();
        return true;
    L10:
        if (r2 == Thread.currentThread().getId()) goto L14;
        return false;
    L14:
        return true;
    }

    public static void disableVaildThreadAssert(boolean r1) {
        mDisableValidThreadAssert.set(r1);
    }

    private Runnable take(boolean r2, long r3) {
        if (r2 == true) goto L6;
        Object r1 = ZeusTransformUtils.preCheckCast(this.mQueue.take(), Runnable.class, "com.obric.memorydata.plugin");     // Catch: InterruptedException -> L12
    L5:
        Runnable r4 = (Runnable) r1;     // Catch: InterruptedException -> L12
        if (r4 == null) goto L11;
        return r4;
    L11:
        throw new SocketTimeoutException(INetworkCallback.TYPE_TTNET);
    L6:
        r1 = ZeusTransformUtils.preCheckCast(this.mQueue.poll(r3, TimeUnit.NANOSECONDS), Runnable.class, "com.obric.memorydata.plugin");     // Catch: InterruptedException -> L12
    L12:
        e = move-exception;
        InterruptedIOException r5 = new InterruptedIOException();
        r5.initCause(e);
        throw r5;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L10;
        this.mQueue.put(r4);     // Catch: InterruptedException -> L6
        return;
    L6:
        e = move-exception;
        throw new RejectedExecutionException(e);
    L10:
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

    public void loop(int r9) {
        long r0 = System.nanoTime();
        long r2 = TimeUnit.NANOSECONDS.convert(r9, TimeUnit.MILLISECONDS);
        if (this.mLoopFailed == false) goto L10;
        InterruptedIOException r10 = this.mPriorInterruptedIOException;
        if (r10 == null) goto L8;
        throw r10;
    L8:
        throw this.mPriorRuntimeException;
    L10:
        if (this.mLoopRunning == true) goto L32;
        this.mLoopRunning = true;
    L13:
        if (this.mLoopRunning == false) goto L30;
        if (r9 == 0) goto L33;
        Runnable r6 = take(true, (r2 - System.nanoTime()) + r0);     // Catch: RuntimeException -> L21 InterruptedIOException -> L24 SocketTimeoutException -> L27
    L18:
        r6.run();     // Catch: RuntimeException -> L21 InterruptedIOException -> L24 SocketTimeoutException -> L27
        goto L13
    L33:
        r6 = take(false, 0);     // Catch: RuntimeException -> L21 InterruptedIOException -> L24 SocketTimeoutException -> L27
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

    public boolean onValidThread() {
        long r0 = this.mThreadId;
        if (r0 != (-1)) goto L5;
    L8:
        return true;
    L5:
        if (r0 == Thread.currentThread().getId()) goto L8;
        return false;
    }

    public void quit() {
        this.mLoopRunning = false;
    }

    public void reset() {
        this.mLoopFailed = false;
    }
}
