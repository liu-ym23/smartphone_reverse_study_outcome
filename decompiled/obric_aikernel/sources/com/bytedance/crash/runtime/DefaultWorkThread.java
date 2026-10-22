package com.bytedance.crash.runtime;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.util.NpthLog;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
public class DefaultWorkThread extends HandlerThread {
    private static final int MAX_CRASH_TIME = 5;
    private static volatile DefaultWorkThread mInstance;
    private final Queue<CachedRunnable> mCacheQueue;
    private int mCrashTimes;
    private Handler mHandler;

    static class CachedRunnable {
        long mAtTimeMillis;
        Runnable mRunnable;

        CachedRunnable(Runnable r10, long r11) {
            this.mRunnable = r10;
            this.mAtTimeMillis = r11;
        }
    }

    private DefaultWorkThread() {
        super("npth-worker");
        this.mCacheQueue = new ConcurrentLinkedQueue();
    }

    public static Handler getHandler() {
        return instance().mHandler;
    }

    public static Thread getThread() {
        return instance();
    }

    private static DefaultWorkThread instance() {
        if (mInstance != null) goto L15;
        monitor-enter(DefaultWorkThread.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new DefaultWorkThread();     // Catch: Throwable -> L11
        mInstance.start();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DefaultWorkThread.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    public static boolean isCurrentThread() {
        if (Thread.currentThread() != getThread()) goto L6;
        return true;
    L6:
        return false;
    }

    public static void post(Runnable r10) {
        instance().postInner(r10, 0);
    }

    public static void postAtFront(Runnable r10) {
        instance().postRunnableAtTime(r10, 0);
    }

    private void postCachedRunnable() {
        Queue<CachedRunnable> r10 = this.mCacheQueue;
        monitor-enter(r10);
    L18:
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mCacheQueue.isEmpty() == true) goto L10;
        CachedRunnable r11 = this.mCacheQueue.poll();     // Catch: Throwable -> L12
        if (r11 == null) goto L18;
        Message r12 = Message.obtain(this.mHandler, r11.mRunnable);     // Catch: Throwable -> L15
        this.mHandler.sendMessageAtTime(r12, r11.mAtTimeMillis);     // Catch: Throwable -> L15
        goto L18
    L10:
        monitor-exit(r10);     // Catch: Throwable -> L12
    }

    public static void postDelayed(Runnable r10, long r11) {
        instance().postInner(r10, r11);
    }

    private void postInner(Runnable r10, long r11) {
        if (r11 >= 0) goto L5;
        r11 = 0;
    L5:
        postRunnableAtTime(r10, SystemClock.uptimeMillis() + r11);
    }

    private void postRunnableAtTime(Runnable r10, long r11) {
        if (this.mHandler != null) goto L16;
        Queue<CachedRunnable> r12 = this.mCacheQueue;
        monitor-enter(r12);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.mHandler != null) goto L11;
        this.mCacheQueue.add(new CachedRunnable(r10, r11));     // Catch: Throwable -> L13
        monitor-exit(r12);     // Catch: Throwable -> L13
        return;
    L11:
        monitor-exit(r12);     // Catch: Throwable -> L13
    L16:
        Message r13 = Message.obtain(this.mHandler, r10);
        this.mHandler.sendMessageAtTime(r13, r11);
    }

    public static void removeCallbacks(Runnable r10) {
        instance().removeRunnable(r10);
    }

    private void removeRunnable(Runnable r10) {
        Queue<CachedRunnable> r11 = this.mCacheQueue;
        monitor-enter(r11);
        Iterator<CachedRunnable> r12 = this.mCacheQueue.iterator();     // Catch: Throwable -> L15
    L6:
        if (r12.hasNext() == false) goto L10;
        if (r12.next().mRunnable.equals(r10) == false) goto L6;
        r12.remove();     // Catch: Throwable -> L15
        goto L6
    L10:
        monitor-exit(r11);     // Catch: Throwable -> L15
        Handler r13 = this.mHandler;
        if (r13 == null) goto L25;
        r13.removeCallbacks(r10);
        return;
    L25:
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private void updateThrowable(Throwable r10) {
        int r11 = this.mCrashTimes;     // Catch: Throwable -> L10
        if (r11 > 5) goto L8;
        if (r11 != 5) goto L6;
        String r12 = "NPTH_ERR_MAX";
    L7:
        NpthMonitor.reportInnerException(r12, r10);     // Catch: Throwable -> L10
        goto L8
    L6:
        r12 = Constants.NPTH_CATCH;
    L8:
        this.mCrashTimes++;     // Catch: Throwable -> L10
        return;
    }

    /* JADX INFO: Infinite loop detected, blocks: 9, insns: 0 */
    @Override // android.os.HandlerThread
    protected void onLooperPrepared() {
        super.onLooperPrepared();
        this.mHandler = new Handler(Looper.myLooper());
        postCachedRunnable();
    L7:
        Looper.loop();     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        NpthLog.i(th);
        updateThrowable(th);
        goto L7
    }
}
