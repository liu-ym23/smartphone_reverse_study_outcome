package com.bytedance.crash.runtime;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.bytedance.crash.diagnose.NpthMonitor;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class ThreadWithHandler {
    private static final ComparableDiffType<MessageEntity, Runnable> compareEntityRunnable = null;
    private static final ComparableDiffType<Message, Runnable> compareMessageRunnable = null;
    private final Queue<MessageEntity> mCacheQueue;
    private final Queue<Message> mFrontCacheQueue;
    private final Object mLock;
    private volatile Handler mRealHandler;
    private final HandlerThread mThread;

    class CheckCacheRunnable implements Runnable {
        final /* synthetic */ ThreadWithHandler this$0;

        CheckCacheRunnable(ThreadWithHandler r10) {
            this.this$0 = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            solveFrontCacheQueue();
            solveNormalCacheQueue();
        }

        void solveFrontCacheQueue() {
        L3:
            if (ThreadWithHandler.access$300(this.this$0).isEmpty() == true) goto L8;
            if (ThreadWithHandler.access$100(this.this$0) == null) goto L3;
            ThreadWithHandler.access$100(this.this$0).sendMessageAtFrontOfQueue((Message) ThreadWithHandler.access$300(this.this$0).poll());     // Catch: Throwable -> L9
            goto L3
        }

        void solveNormalCacheQueue() {
        L3:
            if (ThreadWithHandler.access$200(this.this$0).isEmpty() == true) goto L8;
            MessageEntity r10 = (MessageEntity) ThreadWithHandler.access$200(this.this$0).poll();
            if (ThreadWithHandler.access$100(this.this$0) == null) goto L3;
            ThreadWithHandler.access$100(this.this$0).sendMessageAtTime(r10.msg, r10.time);     // Catch: Throwable -> L9
            goto L3
        }
    }

    interface ComparableDiffType<A, B> {
        boolean equals(A r10, B r11);
    }

    class InnerThread extends HandlerThread {
        static final int MAX_CRASH_TIME = 5;
        volatile int mCrashTimes;
        volatile boolean mUploadTimes;
        final /* synthetic */ ThreadWithHandler this$0;

        InnerThread(ThreadWithHandler r10, String r11) {
            this.this$0 = r10;
            super(r11);
        }

        InnerThread(ThreadWithHandler r10, String r11, int r12) {
            this.this$0 = r10;
            super(r11, r12);
        }

        /* JADX INFO: Infinite loop detected, blocks: 19, insns: 0 */
        @Override // android.os.HandlerThread
        protected void onLooperPrepared() {
            super.onLooperPrepared();
            Object r10 = ThreadWithHandler.access$000(this.this$0);
            monitor-enter(r10);
            ThreadWithHandler.access$102(this.this$0, new Handler());     // Catch: Throwable -> L18
            monitor-exit(r10);     // Catch: Throwable -> L18
            ThreadWithHandler.access$100(this.this$0).post(new CheckCacheRunnable(this.this$0));
        L24:
            Looper.loop();     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            if (this.mCrashTimes >= 5) goto L14;
            NpthMonitor.reportInnerException(th);     // Catch: Throwable -> L21
        L16:
            this.mCrashTimes++;     // Catch: Throwable -> L21
            goto L24
        L14:
            if (this.mUploadTimes == true) goto L16;
            this.mUploadTimes = true;     // Catch: Throwable -> L21
            NpthMonitor.reportInnerException("NPTH_ERR_MAX", new RuntimeException());     // Catch: Throwable -> L21
        L18:
            th = move-exception;
            throw th;
        }
    }

    static class MessageEntity {
        Message msg;
        long time;

        MessageEntity(Message r10, long r11) {
            this.msg = r10;
            this.time = r11;
        }
    }

    static {
        compareEntityRunnable = new AnonymousClass1();
        compareMessageRunnable = new AnonymousClass2();
    }

    public ThreadWithHandler(String r10) {
        this.mCacheQueue = new ConcurrentLinkedQueue();
        this.mFrontCacheQueue = new ConcurrentLinkedQueue();
        this.mLock = new Object();
        this.mThread = new InnerThread(this, r10);
    }

    public ThreadWithHandler(String r10, int r11) {
        this.mCacheQueue = new ConcurrentLinkedQueue();
        this.mFrontCacheQueue = new ConcurrentLinkedQueue();
        this.mLock = new Object();
        this.mThread = new InnerThread(this, r10, r11);
    }

    static /* synthetic */ Object access$000(ThreadWithHandler r10) {
        return r10.mLock;
    }

    static /* synthetic */ Handler access$100(ThreadWithHandler r10) {
        return r10.mRealHandler;
    }

    static /* synthetic */ Handler access$102(ThreadWithHandler r10, Handler r11) {
        r10.mRealHandler = r11;
        return r11;
    }

    static /* synthetic */ Queue access$200(ThreadWithHandler r10) {
        return r10.mCacheQueue;
    }

    static /* synthetic */ Queue access$300(ThreadWithHandler r10) {
        return r10.mFrontCacheQueue;
    }

    private Message getPostMessage(Runnable r10) {
        return Message.obtain(this.mRealHandler, r10);
    }

    private Message getPostMessage(Runnable r10, Object r11) {
        Message r12 = Message.obtain(this.mRealHandler, r10);
        r12.obj = r11;
        return r12;
    }

    private static <L, O> boolean removeAll(Collection<L> r10, O r11, ComparableDiffType<? super L, O> r12) {
        boolean r13 = false;
        if (r10 != null) goto L5;
    L15:
        return r13;
    L5:
        if (r10.isEmpty() == true) goto L15;
        if (r12 == null) goto L15;
        Iterator<L> r14 = r10.iterator();     // Catch: Throwable -> L16
    L10:
        if (r14.hasNext() == false) goto L15;
        if (r12.equals(r14.next(), r11) == false) goto L10;
        r14.remove();     // Catch: Throwable -> L16
        r13 = true;
        goto L10
    }

    private boolean sendEmptyMessageDelayed(int r10, long r11) {
        Message r12 = Message.obtain();
        r12.what = r10;
        return sendMessageDelayed(r12, r11);
    }

    private boolean sendMessageAtFrontOfQueue(Message r10) {
        if (this.mRealHandler != null) goto L20;
        Object r11 = this.mLock;
        monitor-enter(r11);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.mRealHandler != null) goto L11;
        this.mFrontCacheQueue.add(r10);     // Catch: Throwable -> L13
        monitor-exit(r11);     // Catch: Throwable -> L13
        return true;
    L11:
        monitor-exit(r11);     // Catch: Throwable -> L13
    L20:
        return this.mRealHandler.sendMessageAtFrontOfQueue(r10);
    L18:
        return true;
    }

    private boolean sendMessageAtTime(Message r10, long r11) {
        if (this.mRealHandler != null) goto L19;
        Object r12 = this.mLock;
        monitor-enter(r12);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.mRealHandler != null) goto L11;
        this.mCacheQueue.add(new MessageEntity(r10, r11));     // Catch: Throwable -> L13
        monitor-exit(r12);     // Catch: Throwable -> L13
        return true;
    L11:
        monitor-exit(r12);     // Catch: Throwable -> L13
    L19:
        return this.mRealHandler.sendMessageAtTime(r10, r11);
    L18:
        return true;
    }

    private boolean sendMessageDelayed(Message r10, long r11) {
        if (r11 >= 0) goto L6;
        r11 = 0;
    L6:
        return sendMessageAtTime(r10, SystemClock.uptimeMillis() + r11);
    }

    @Nullable
    public Handler getHandler() {
        return this.mRealHandler;
    }

    public HandlerThread getThread() {
        return this.mThread;
    }

    public final boolean post(Runnable r10) {
        return sendMessageDelayed(getPostMessage(r10), 0);
    }

    public final boolean postAtFrontOfQueue(Runnable r10) {
        return sendMessageAtFrontOfQueue(getPostMessage(r10));
    }

    public final boolean postAtTime(Runnable r10, long r11) {
        return sendMessageAtTime(getPostMessage(r10), r11);
    }

    public final boolean postAtTime(Runnable r10, Object r11, long r12) {
        return sendMessageAtTime(getPostMessage(r10, r11), r12);
    }

    public final boolean postDelayed(Runnable r10, long r11) {
        return sendMessageDelayed(getPostMessage(r10), r11);
    }

    public final boolean postDelayed(Runnable r10, Object r11, long r12) {
        return sendMessageDelayed(getPostMessage(r10, r11), r12);
    }

    public final void removeCallbacks(Runnable r10) {
        if (this.mCacheQueue.isEmpty() == true) goto L5;
    L6:
        removeAll(this.mCacheQueue, r10, compareEntityRunnable);
        removeAll(this.mFrontCacheQueue, r10, compareMessageRunnable);
    L8:
        if (this.mRealHandler == null) goto L11;
        this.mRealHandler.removeCallbacks(r10);
        return;
    L11:
        return;
    L5:
        if (this.mFrontCacheQueue.isEmpty() == true) goto L8;
        goto L6
    }

    public final boolean sendEmptyMessage(int r10) {
        return sendEmptyMessageDelayed(r10, 0);
    }

    public final boolean sendEmptyMessageAtTime(int r10, long r11) {
        Message r12 = Message.obtain();
        r12.what = r10;
        return sendMessageAtTime(r12, r11);
    }

    public final boolean sendMessage(Message r10) {
        return sendMessageDelayed(r10, 0);
    }

    public void start() {
        this.mThread.start();
    }
}
