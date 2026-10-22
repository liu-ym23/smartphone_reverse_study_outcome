package androidx.core.provider;

import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@Deprecated
public class SelfDestructiveThread {
    private static final int MSG_DESTRUCTION = 0;
    private static final int MSG_INVOKE_RUNNABLE = 1;
    private Handler.Callback mCallback;
    private final int mDestructAfterMillisec;

    @GuardedBy("mLock")
    private int mGeneration;

    @GuardedBy("mLock")
    private Handler mHandler;
    private final Object mLock;
    private final int mPriority;

    @GuardedBy("mLock")
    private HandlerThread mThread;
    private final String mThreadName;

    public interface ReplyCallback<T> {
        void onReply(T r10);
    }

    public SelfDestructiveThread(String r10, int r11, int r12) {
        this.mLock = new Object();
        this.mCallback = new AnonymousClass1(this);
        this.mThreadName = r10;
        this.mPriority = r11;
        this.mDestructAfterMillisec = r12;
        this.mGeneration = 0;
    }

    private void post(Runnable r10) {
        Object r11 = this.mLock;
        monitor-enter(r11);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mThread != null) goto L7;
        HandlerThread r12 = new HandlerThread(this.mThreadName, this.mPriority);     // Catch: Throwable -> L10
        this.mThread = r12;     // Catch: Throwable -> L10
        r12.start();     // Catch: Throwable -> L10
        this.mHandler = new Handler(this.mThread.getLooper(), this.mCallback);     // Catch: Throwable -> L10
        this.mGeneration++;     // Catch: Throwable -> L10
    L7:
        this.mHandler.removeMessages(0);     // Catch: Throwable -> L10
        Handler r13 = this.mHandler;     // Catch: Throwable -> L10
        r13.sendMessage(r13.obtainMessage(1, r10));     // Catch: Throwable -> L10
        monitor-exit(r11);     // Catch: Throwable -> L10
    }

    @VisibleForTesting
    public int getGeneration() {
        Object r10 = this.mLock;
        monitor-enter(r10);
        int r11 = this.mGeneration;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @VisibleForTesting
    public boolean isRunning() {
        Object r10 = this.mLock;
        monitor-enter(r10);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mThread == null) goto L7;
        boolean r11 = true;
    L8:
        monitor-exit(r10);     // Catch: Throwable -> L10
        return r11;
    L7:
        r11 = false;
        goto L8
    }

    void onDestruction() {
        Object r10 = this.mLock;
        monitor-enter(r10);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mHandler.hasMessages(1) == false) goto L8;
        monitor-exit(r10);     // Catch: Throwable -> L11
        return;
    L8:
        this.mThread.quit();     // Catch: Throwable -> L11
        this.mThread = null;     // Catch: Throwable -> L11
        this.mHandler = null;     // Catch: Throwable -> L11
        monitor-exit(r10);     // Catch: Throwable -> L11
    }

    void onInvokeRunnable(Runnable r10) {
        r10.run();
        Object r11 = this.mLock;
        monitor-enter(r11);
        this.mHandler.removeMessages(0);     // Catch: Throwable -> L7
        Handler r12 = this.mHandler;     // Catch: Throwable -> L7
        r12.sendMessageDelayed(r12.obtainMessage(0), this.mDestructAfterMillisec);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public <T> void postAndReply(final Callable<T> r10, final ReplyCallback<T> r11) {
        final Handler r12 = CalleeHandler.create();
        post(new AnonymousClass2(this, r10, r12, r11));
    }

    public <T> T postAndWait(final Callable<T> r13, int r14) {
        final ReentrantLock r10 = new ReentrantLock();
        final Condition r11 = r10.newCondition();
        final AtomicReference r12 = new AtomicReference();
        final AtomicBoolean r15 = new AtomicBoolean(true);
        post(new AnonymousClass3(this, r12, r13, r10, r15, r11));
        r10.lock();
    L20:
        th = move-exception;
        r10.unlock();
        throw th;
    L4:
        if (r15.get() == true) goto L8;
        T r16 = (T) r12.get();
        r10.unlock();
        return r16;
    L8:
        long r17 = TimeUnit.MILLISECONDS.toNanos(r14);     // Catch: Throwable -> L20
    L24:
        r17 = r11.awaitNanos(r17);     // Catch: InterruptedException -> L23 Throwable -> L20
    L11:
        if (r15.get() == false) goto L12;
        if (r17 > 0) goto L24;
        throw new InterruptedException("timeout");     // Catch: Throwable -> L20
    L12:
        T r18 = (T) r12.get();
        r10.unlock();
        return r18;
    }
}
