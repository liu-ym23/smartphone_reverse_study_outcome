package androidx.recyclerview.widget;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
class MessageThreadUtil<T> implements ThreadUtil<T> {

    /* JADX INFO: renamed from: androidx.recyclerview.widget.MessageThreadUtil$1, reason: invalid class name */
    class AnonymousClass1 implements ThreadUtil.MainThreadCallback<T> {
        static final int ADD_TILE = 2;
        static final int REMOVE_TILE = 3;
        static final int UPDATE_ITEM_COUNT = 1;
        private final Handler mMainThreadHandler;
        private Runnable mMainThreadRunnable;
        final MessageQueue mQueue;
        final /* synthetic */ MessageThreadUtil this$0;
        final /* synthetic */ ThreadUtil.MainThreadCallback val$callback;

        AnonymousClass1(MessageThreadUtil r3, ThreadUtil.MainThreadCallback r4) {
            ThreadUtil.MainThreadCallback r5 = (ThreadUtil.MainThreadCallback) ZeusTransformUtils.wrapperContextForParams(r4, ThreadUtil.MainThreadCallback.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.val$callback = r5;
            this.mQueue = new MessageQueue();
            this.mMainThreadHandler = new Handler(Looper.getMainLooper());
            this.mMainThreadRunnable = new RunnableC00441(this);
        }

        private void sendMessage(SyncQueueItem r2) {
            this.mQueue.sendMessage(r2);
            this.mMainThreadHandler.post(this.mMainThreadRunnable);
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void addTile(int r2, TileList.Tile<T> r3) {
            sendMessage(SyncQueueItem.obtainMessage(2, r2, r3));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void removeTile(int r2, int r3) {
            sendMessage(SyncQueueItem.obtainMessage(3, r2, r3));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void updateItemCount(int r2, int r3) {
            sendMessage(SyncQueueItem.obtainMessage(1, r2, r3));
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.MessageThreadUtil$2, reason: invalid class name */
    class AnonymousClass2 implements ThreadUtil.BackgroundCallback<T> {
        static final int LOAD_TILE = 3;
        static final int RECYCLE_TILE = 4;
        static final int REFRESH = 1;
        static final int UPDATE_RANGE = 2;
        private Runnable mBackgroundRunnable;
        AtomicBoolean mBackgroundRunning;
        private final Executor mExecutor;
        final MessageQueue mQueue;
        final /* synthetic */ MessageThreadUtil this$0;
        final /* synthetic */ ThreadUtil.BackgroundCallback val$callback;

        AnonymousClass2(MessageThreadUtil r3, ThreadUtil.BackgroundCallback r4) {
            ThreadUtil.BackgroundCallback r5 = (ThreadUtil.BackgroundCallback) ZeusTransformUtils.wrapperContextForParams(r4, ThreadUtil.BackgroundCallback.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.val$callback = r5;
            this.mQueue = new MessageQueue();
            this.mExecutor = AsyncTask.THREAD_POOL_EXECUTOR;
            this.mBackgroundRunning = new AtomicBoolean(false);
            this.mBackgroundRunnable = new AnonymousClass1(this);
        }

        private void maybeExecuteBackgroundRunnable() {
            if (this.mBackgroundRunning.compareAndSet(false, true) == false) goto L6;
            this.mExecutor.execute(this.mBackgroundRunnable);
            return;
        }

        private void sendMessage(SyncQueueItem r2) {
            this.mQueue.sendMessage(r2);
            maybeExecuteBackgroundRunnable();
        }

        private void sendMessageAtFrontOfQueue(SyncQueueItem r2) {
            this.mQueue.sendMessageAtFrontOfQueue(r2);
            maybeExecuteBackgroundRunnable();
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void loadTile(int r2, int r3) {
            sendMessage(SyncQueueItem.obtainMessage(3, r2, r3));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void recycleTile(TileList.Tile<T> r3) {
            sendMessage(SyncQueueItem.obtainMessage(4, 0, r3));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void refresh(int r3) {
            sendMessageAtFrontOfQueue(SyncQueueItem.obtainMessage(1, r3, null));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void updateRange(int r8, int r9, int r10, int r11, int r12) {
            sendMessageAtFrontOfQueue(SyncQueueItem.obtainMessage(2, r8, r9, r10, r11, r12, null));
        }
    }

    static class MessageQueue {
        private final Object mLock;
        private SyncQueueItem mRoot;

        MessageQueue() {
            this.mLock = new Object();
        }

        SyncQueueItem next() {
            Object r0 = this.mLock;
            monitor-enter(r0);
            SyncQueueItem r1 = this.mRoot;     // Catch: Throwable -> L12
            if (r1 == null) goto L7;
            this.mRoot = r1.next;     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r1;
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return null;
        L12:
            th = move-exception;
            throw th;
        }

        void removeMessages(int r5) {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L23:
            SyncQueueItem r1 = this.mRoot;     // Catch: Throwable -> L20
            if (r1 == null) goto L9;
            if (r1.what != r5) goto L9;
            SyncQueueItem r2 = this.mRoot;     // Catch: Throwable -> L20
            this.mRoot = r2.next;     // Catch: Throwable -> L20
            r2.recycle();     // Catch: Throwable -> L20
        L9:
            SyncQueueItem r4 = this.mRoot;     // Catch: Throwable -> L20
            if (r4 == null) goto L18;
            SyncQueueItem r3 = r4.next;     // Catch: Throwable -> L20
        L12:
            if (r3 == null) goto L18;
            SyncQueueItem r6 = r3.next;     // Catch: Throwable -> L20
            if (r3.what != r5) goto L16;
            r4.next = r6;     // Catch: Throwable -> L20
            r3.recycle();     // Catch: Throwable -> L20
        L17:
            r3 = r6;
            goto L12
        L16:
            r4 = r3;
        L18:
            monitor-exit(r0);     // Catch: Throwable -> L20
            return;
        L20:
            th = move-exception;
            throw th;
        }

        void sendMessage(SyncQueueItem r3) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            SyncQueueItem r1 = this.mRoot;     // Catch: Throwable -> L15
            if (r1 != null) goto L10;
            this.mRoot = r3;     // Catch: Throwable -> L15
            monitor-exit(r0);     // Catch: Throwable -> L15
            return;
        L10:
            if (r1.next == null) goto L12;
            r1 = r1.next;     // Catch: Throwable -> L15
            goto L10
        L12:
            r1.next = r3;     // Catch: Throwable -> L15
            monitor-exit(r0);     // Catch: Throwable -> L15
            return;
        L15:
            th = move-exception;
            throw th;
        }

        void sendMessageAtFrontOfQueue(SyncQueueItem r3) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            r3.next = this.mRoot;     // Catch: Throwable -> L7
            this.mRoot = r3;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    static class SyncQueueItem {
        private static SyncQueueItem sPool;
        private static final Object sPoolLock = null;
        public int arg1;
        public int arg2;
        public int arg3;
        public int arg4;
        public int arg5;
        public Object data;
        SyncQueueItem next;
        public int what;

        static {
            sPoolLock = new Object();
        }

        SyncQueueItem() {
        }

        static SyncQueueItem obtainMessage(int r7, int r8, int r9) {
            return obtainMessage(r7, r8, r9, 0, 0, 0, null);
        }

        static SyncQueueItem obtainMessage(int r3, int r4, int r5, int r6, int r7, int r8, Object r9) {
            Object r0 = sPoolLock;
            monitor-enter(r0);
            SyncQueueItem r1 = sPool;     // Catch: Throwable -> L11
            if (r1 != null) goto L7;
            r1 = new SyncQueueItem();     // Catch: Throwable -> L11
        L8:
            r1.what = r3;     // Catch: Throwable -> L11
            r1.arg1 = r4;     // Catch: Throwable -> L11
            r1.arg2 = r5;     // Catch: Throwable -> L11
            r1.arg3 = r6;     // Catch: Throwable -> L11
            r1.arg4 = r7;     // Catch: Throwable -> L11
            r1.arg5 = r8;     // Catch: Throwable -> L11
            r1.data = r9;     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return r1;
        L7:
            sPool = r1.next;     // Catch: Throwable -> L11
            r1.next = null;     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            throw th;
        }

        static SyncQueueItem obtainMessage(int r7, int r8, Object r9) {
            return obtainMessage(r7, r8, 0, 0, 0, 0, r9);
        }

        void recycle() {
            this.next = null;
            this.arg5 = 0;
            this.arg4 = 0;
            this.arg3 = 0;
            this.arg2 = 0;
            this.arg1 = 0;
            this.what = 0;
            this.data = null;
            Object r0 = sPoolLock;
            monitor-enter(r0);
            SyncQueueItem r1 = sPool;     // Catch: Throwable -> L10
            if (r1 == null) goto L7;
            this.next = r1;     // Catch: Throwable -> L10
        L7:
            sPool = this;     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }
    }

    MessageThreadUtil() {
    }

    @Override // androidx.recyclerview.widget.ThreadUtil
    public ThreadUtil.BackgroundCallback<T> getBackgroundProxy(ThreadUtil.BackgroundCallback<T> r3) {
        return new AnonymousClass2(this, (ThreadUtil.BackgroundCallback) ZeusTransformUtils.wrapperContextForParams(r3, ThreadUtil.BackgroundCallback.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.recyclerview.widget.ThreadUtil
    public ThreadUtil.MainThreadCallback<T> getMainThreadProxy(ThreadUtil.MainThreadCallback<T> r3) {
        return new AnonymousClass1(this, (ThreadUtil.MainThreadCallback) ZeusTransformUtils.wrapperContextForParams(r3, ThreadUtil.MainThreadCallback.class, "com.obric.memorydata.plugin"));
    }
}
