package androidx.core.provider;

import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class SelfDestructiveThread {
    private static final int MSG_DESTRUCTION = 0;
    private static final int MSG_INVOKE_RUNNABLE = 1;
    private Handler.Callback mCallback;
    private final int mDestructAfterMillisec;
    private int mGeneration;
    private Handler mHandler;
    private final Object mLock;
    private final int mPriority;
    private HandlerThread mThread;
    private final String mThreadName;

    public interface ReplyCallback<T> {
        void onReply(T r1);
    }

    public SelfDestructiveThread(String r2, int r3, int r4) {
        this.mLock = new Object();
        this.mCallback = new AnonymousClass1(this);
        this.mThreadName = r2;
        this.mPriority = r3;
        this.mDestructAfterMillisec = r4;
        this.mGeneration = 0;
    }

    private void post(Runnable r6) {
        Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r6, Runnable.class, "com.obric.memorydata.plugin");
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mThread != null) goto L7;
        HandlerThread r1 = new HandlerThread(this.mThreadName, this.mPriority);     // Catch: Throwable -> L10
        this.mThread = r1;     // Catch: Throwable -> L10
        r1.start();     // Catch: Throwable -> L10
        this.mHandler = new Handler(this.mThread.getLooper(), this.mCallback);     // Catch: Throwable -> L10
        this.mGeneration++;     // Catch: Throwable -> L10
    L7:
        this.mHandler.removeMessages(0);     // Catch: Throwable -> L10
        Handler r5 = this.mHandler;     // Catch: Throwable -> L10
        r5.sendMessage(r5.obtainMessage(1, r7));     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
    }

    public int getGeneration() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int r1 = this.mGeneration;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isRunning() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mThread == null) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    void onDestruction() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mHandler.hasMessages(1) == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        this.mThread.quit();     // Catch: Throwable -> L11
        this.mThread = null;     // Catch: Throwable -> L11
        this.mHandler = null;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    void onInvokeRunnable(Runnable r5) {
        ((Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.memorydata.plugin")).run();
        Object r6 = this.mLock;
        monitor-enter(r6);
        this.mHandler.removeMessages(0);     // Catch: Throwable -> L7
        Handler r0 = this.mHandler;     // Catch: Throwable -> L7
        r0.sendMessageDelayed(r0.obtainMessage(0), this.mDestructAfterMillisec);     // Catch: Throwable -> L7
        monitor-exit(r6);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public <T> void postAndReply(Callable<T> r3, ReplyCallback<T> r4) {
        final Callable r5 = (Callable) ZeusTransformUtils.wrapperContextForParams(r3, Callable.class, "com.obric.memorydata.plugin");
        final ReplyCallback r6 = (ReplyCallback) ZeusTransformUtils.wrapperContextForParams(r4, ReplyCallback.class, "com.obric.memorydata.plugin");
        final Handler r0 = CalleeHandler.create();
        post(new AnonymousClass2(this, r5, r0, r6));
    }

    public <T> T postAndWait(Callable<T> r12, int r13) {
        final Callable r3 = (Callable) ZeusTransformUtils.wrapperContextForParams(r12, Callable.class, "com.obric.memorydata.plugin");
        final ReentrantLock r14 = new ReentrantLock();
        final Condition r7 = r14.newCondition();
        final AtomicReference r8 = new AtomicReference();
        final AtomicBoolean r9 = new AtomicBoolean(true);
        post(new AnonymousClass3(this, r8, r3, r14, r9, r7));
        r14.lock();
    L20:
        th = move-exception;
        r14.unlock();
        throw th;
    L4:
        if (r9.get() == true) goto L8;
        T r11 = (T) r8.get();
        r14.unlock();
        return r11;
    L8:
        long r0 = TimeUnit.MILLISECONDS.toNanos(r13);     // Catch: Throwable -> L20
    L25:
        r0 = r7.awaitNanos(r0);     // Catch: InterruptedException -> L23 Throwable -> L20
    L11:
        if (r9.get() == false) goto L12;
        if (r0 > 0) goto L25;
        throw new InterruptedException(LocationMonitorConst.TIMEOUT);     // Catch: Throwable -> L20
    L12:
        T r15 = (T) r8.get();
        r14.unlock();
        return r15;
    }
}
