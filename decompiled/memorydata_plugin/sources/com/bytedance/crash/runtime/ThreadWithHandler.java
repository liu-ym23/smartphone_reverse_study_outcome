package com.bytedance.crash.runtime;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes2.dex */
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

        CheckCacheRunnable(ThreadWithHandler r1) {
            this.this$0 = r1;
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
            ThreadWithHandler.access$100(this.this$0).sendMessageAtFrontOfQueue((Message) ZeusTransformUtils.preCheckCast(ThreadWithHandler.access$300(this.this$0).poll(), Message.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L9
            goto L3
        }

        void solveNormalCacheQueue() {
        L3:
            if (ThreadWithHandler.access$200(this.this$0).isEmpty() == true) goto L8;
            MessageEntity r0 = (MessageEntity) ZeusTransformUtils.preCheckCast(ThreadWithHandler.access$200(this.this$0).poll(), MessageEntity.class, "com.obric.memorydata.plugin");
            if (ThreadWithHandler.access$100(this.this$0) == null) goto L3;
            ThreadWithHandler.access$100(this.this$0).sendMessageAtTime(r0.msg, r0.time);     // Catch: Throwable -> L9
            goto L3
        }
    }

    interface ComparableDiffType<A, B> {
        boolean equals(A r1, B r2);
    }

    class InnerThread extends HandlerThread {
        static final int MAX_CRASH_TIME = 5;
        volatile int mCrashTimes;
        volatile boolean mUploadTimes;
        final /* synthetic */ ThreadWithHandler this$0;

        InnerThread(ThreadWithHandler r1, String r2) {
            this.this$0 = r1;
            super(r2);
        }

        InnerThread(ThreadWithHandler r1, String r2, int r3) {
            this.this$0 = r1;
            super(r2, r3);
        }

        /* JADX INFO: Infinite loop detected, blocks: 19, insns: 0 */
        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            super.onLooperPrepared();
            Object r0 = ThreadWithHandler.access$000(this.this$0);
            monitor-enter(r0);
            ThreadWithHandler.access$102(this.this$0, new Handler());     // Catch: Throwable -> L18
            monitor-exit(r0);     // Catch: Throwable -> L18
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

        MessageEntity(Message r1, long r2) {
            this.msg = r1;
            this.time = r2;
        }
    }

    static {
        compareEntityRunnable = new AnonymousClass1();
        compareMessageRunnable = new AnonymousClass2();
    }

    public ThreadWithHandler(String r2) {
        this.mCacheQueue = new ConcurrentLinkedQueue();
        this.mFrontCacheQueue = new ConcurrentLinkedQueue();
        this.mLock = new Object();
        this.mThread = new InnerThread(this, r2);
    }

    public ThreadWithHandler(String r2, int r3) {
        this.mCacheQueue = new ConcurrentLinkedQueue();
        this.mFrontCacheQueue = new ConcurrentLinkedQueue();
        this.mLock = new Object();
        this.mThread = new InnerThread(this, r2, r3);
    }

    static /* synthetic */ Object access$000(ThreadWithHandler r0) {
        return r0.mLock;
    }

    static /* synthetic */ Handler access$100(ThreadWithHandler r0) {
        return r0.mRealHandler;
    }

    static /* synthetic */ Handler access$102(ThreadWithHandler r0, Handler r1) {
        r0.mRealHandler = r1;
        return r1;
    }

    static /* synthetic */ Queue access$200(ThreadWithHandler r0) {
        return r0.mCacheQueue;
    }

    static /* synthetic */ Queue access$300(ThreadWithHandler r0) {
        return r0.mFrontCacheQueue;
    }

    private Message getPostMessage(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        return Message.obtain(this.mRealHandler, r4);
    }

    private Message getPostMessage(Runnable r3, Object r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        Message r2 = Message.obtain(this.mRealHandler, r5);
        r2.obj = r4;
        return r2;
    }

    private static <L, O> boolean removeAll(Collection<L> r2, O r3, ComparableDiffType<? super L, O> r4) {
        Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        ComparableDiffType r6 = (ComparableDiffType) ZeusTransformUtils.wrapperContextForParams(r4, ComparableDiffType.class, "com.obric.memorydata.plugin");
        boolean r0 = false;
        if (r5 != null) goto L5;
    L15:
        return r0;
    L5:
        if (r5.isEmpty() == true) goto L15;
        if (r6 == null) goto L15;
        Iterator r7 = r5.iterator();     // Catch: Throwable -> L16
    L10:
        if (r7.hasNext() == false) goto L15;
        if (r6.equals(r7.next(), r3) == false) goto L10;
        r7.remove();     // Catch: Throwable -> L16
        r0 = true;
        goto L10
    }

    private boolean sendEmptyMessageDelayed(int r2, long r3) {
        Message r0 = Message.obtain();
        r0.what = r2;
        return sendMessageDelayed(r0, r3);
    }

    private boolean sendMessageAtFrontOfQueue(Message r4) {
        if (this.mRealHandler != null) goto L20;
        Object r0 = this.mLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.mRealHandler != null) goto L11;
        this.mFrontCacheQueue.add(r4);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return true;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
    L20:
        return this.mRealHandler.sendMessageAtFrontOfQueue(r4);
    L18:
        return true;
    }

    private boolean sendMessageAtTime(Message r4, long r5) {
        if (this.mRealHandler != null) goto L19;
        Object r0 = this.mLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.mRealHandler != null) goto L11;
        this.mCacheQueue.add(new MessageEntity(r4, r5));     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return true;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
    L19:
        return this.mRealHandler.sendMessageAtTime(r4, r5);
    L18:
        return true;
    }

    private boolean sendMessageDelayed(Message r4, long r5) {
        if (r5 >= 0) goto L6;
        r5 = 0;
    L6:
        return sendMessageAtTime(r4, SystemClock.uptimeMillis() + r5);
    }

    public Handler getHandler() {
        return this.mRealHandler;
    }

    public HandlerThread getThread() {
        return this.mThread;
    }

    public final boolean post(Runnable r3) {
        return sendMessageDelayed(getPostMessage((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin")), 0);
    }

    public final boolean postAtFrontOfQueue(Runnable r3) {
        return sendMessageAtFrontOfQueue(getPostMessage((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin")));
    }

    public final boolean postAtTime(Runnable r3, long r4) {
        return sendMessageAtTime(getPostMessage((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin")), r4);
    }

    public final boolean postAtTime(Runnable r3, Object r4, long r5) {
        return sendMessageAtTime(getPostMessage((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin"), r4), r5);
    }

    public final boolean postDelayed(Runnable r3, long r4) {
        return sendMessageDelayed(getPostMessage((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin")), r4);
    }

    public final boolean postDelayed(Runnable r3, Object r4, long r5) {
        return sendMessageDelayed(getPostMessage((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin"), r4), r5);
    }

    public final void removeCallbacks(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        if (this.mCacheQueue.isEmpty() == true) goto L5;
    L6:
        removeAll(this.mCacheQueue, r4, compareEntityRunnable);
        removeAll(this.mFrontCacheQueue, r4, compareMessageRunnable);
    L8:
        if (this.mRealHandler == null) goto L11;
        this.mRealHandler.removeCallbacks(r4);
        return;
    L11:
        return;
    L5:
        if (this.mFrontCacheQueue.isEmpty() == true) goto L8;
        goto L6
    }

    public final boolean sendEmptyMessage(int r3) {
        return sendEmptyMessageDelayed(r3, 0);
    }

    public final boolean sendEmptyMessageAtTime(int r2, long r3) {
        Message r0 = Message.obtain();
        r0.what = r2;
        return sendMessageAtTime(r0, r3);
    }

    public final boolean sendMessage(Message r3) {
        return sendMessageDelayed(r3, 0);
    }

    public void start() {
        this.mThread.start();
    }
}
