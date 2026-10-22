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
        void onReply(T r5);
    }

    public SelfDestructiveThread(String r5, int r10, int r11) {
        this.mLock = new Object();
        this.mCallback = new AnonymousClass1(this);
        this.mThreadName = r5;
        this.mPriority = r10;
        this.mDestructAfterMillisec = r11;
        this.mGeneration = 0;
    }

    private void post(Runnable r10) {
        Object r5 = this.mLock;
        monitor-enter(r5);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mThread != null) goto L9;
        HandlerThread r11 = new HandlerThread(this.mThreadName, this.mPriority);     // Catch: Throwable -> L7
        this.mThread = r11;     // Catch: Throwable -> L7
        r11.start();     // Catch: Throwable -> L7
        this.mHandler = new Handler(this.mThread.getLooper(), this.mCallback);     // Catch: Throwable -> L7
        this.mGeneration++;     // Catch: Throwable -> L7
    L9:
        this.mHandler.removeMessages(0);     // Catch: Throwable -> L7
        Handler r12 = this.mHandler;     // Catch: Throwable -> L7
        r12.sendMessage(r12.obtainMessage(1, r10));     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
    }

    @VisibleForTesting
    public int getGeneration() {
        Object r5 = this.mLock;
        monitor-enter(r5);
        int r10 = this.mGeneration;     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @VisibleForTesting
    public boolean isRunning() {
        Object r5 = this.mLock;
        monitor-enter(r5);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mThread == null) goto L7;
        boolean r10 = true;
    L8:
        monitor-exit(r5);     // Catch: Throwable -> L10
        return r10;
    L7:
        r10 = false;
        goto L8
    }

    public void onDestruction() {
        Object r5 = this.mLock;
        monitor-enter(r5);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mHandler.hasMessages(1) == false) goto L10;
        monitor-exit(r5);     // Catch: Throwable -> L8
        return;
    L10:
        this.mThread.quit();     // Catch: Throwable -> L8
        this.mThread = null;     // Catch: Throwable -> L8
        this.mHandler = null;     // Catch: Throwable -> L8
        monitor-exit(r5);     // Catch: Throwable -> L8
    }

    public void onInvokeRunnable(Runnable r5) {
        r5.run();
        Object r10 = this.mLock;
        monitor-enter(r10);
        this.mHandler.removeMessages(0);     // Catch: Throwable -> L7
        Handler r11 = this.mHandler;     // Catch: Throwable -> L7
        r11.sendMessageDelayed(r11.obtainMessage(0), this.mDestructAfterMillisec);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public <T> void postAndReply(final Callable<T> r5, final ReplyCallback<T> r10) {
        final Handler r11 = CalleeHandler.create();
        post(new AnonymousClass2(this, r5, r11, r10));
    }

    public <T> T postAndWait(final Callable<T> r13, int r14) throws InterruptedException {
        final ReentrantLock r10 = new ReentrantLock();
        final Condition r11 = r10.newCondition();
        final AtomicReference r12 = new AtomicReference();
        final AtomicBoolean r15 = new AtomicBoolean(true);
        post(new AnonymousClass3(this, r12, r13, r10, r15, r11));
        r10.lock();
    L8:
        th = move-exception;
        r10.unlock();
        throw th;
    L4:
        if (r15.get() == true) goto L10;
        T r16 = (T) r12.get();
        r10.unlock();
        return r16;
    L10:
        long r17 = TimeUnit.MILLISECONDS.toNanos(r14);     // Catch: Throwable -> L8
    L26:
        r17 = r11.awaitNanos(r17);     // Catch: Throwable -> L8 InterruptedException -> L24
    L13:
        if (r15.get() == false) goto L14;
        if (r17 > 0) goto L26;
        throw new InterruptedException("timeout");     // Catch: Throwable -> L8
    L14:
        T r18 = (T) r12.get();
        r10.unlock();
        return r18;
    }
}
