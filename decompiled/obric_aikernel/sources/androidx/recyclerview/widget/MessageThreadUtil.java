package androidx.recyclerview.widget;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
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

        AnonymousClass1(MessageThreadUtil r10, ThreadUtil.MainThreadCallback r11) {
            this.this$0 = r10;
            this.val$callback = r11;
            this.mQueue = new MessageQueue();
            this.mMainThreadHandler = new Handler(Looper.getMainLooper());
            this.mMainThreadRunnable = new RunnableC00211(this);
        }

        private void sendMessage(SyncQueueItem r10) {
            this.mQueue.sendMessage(r10);
            this.mMainThreadHandler.post(this.mMainThreadRunnable);
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void addTile(int r10, TileList.Tile<T> r11) {
            sendMessage(SyncQueueItem.obtainMessage(2, r10, r11));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void removeTile(int r10, int r11) {
            sendMessage(SyncQueueItem.obtainMessage(3, r10, r11));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void updateItemCount(int r10, int r11) {
            sendMessage(SyncQueueItem.obtainMessage(1, r10, r11));
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

        AnonymousClass2(MessageThreadUtil r10, ThreadUtil.BackgroundCallback r11) {
            this.this$0 = r10;
            this.val$callback = r11;
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

        private void sendMessage(SyncQueueItem r10) {
            this.mQueue.sendMessage(r10);
            maybeExecuteBackgroundRunnable();
        }

        private void sendMessageAtFrontOfQueue(SyncQueueItem r10) {
            this.mQueue.sendMessageAtFrontOfQueue(r10);
            maybeExecuteBackgroundRunnable();
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void loadTile(int r10, int r11) {
            sendMessage(SyncQueueItem.obtainMessage(3, r10, r11));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void recycleTile(TileList.Tile<T> r10) {
            sendMessage(SyncQueueItem.obtainMessage(4, 0, r10));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void refresh(int r10) {
            sendMessageAtFrontOfQueue(SyncQueueItem.obtainMessage(1, r10, null));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void updateRange(int r10, int r11, int r12, int r13, int r14) {
            sendMessageAtFrontOfQueue(SyncQueueItem.obtainMessage(2, r10, r11, r12, r13, r14, null));
        }
    }

    static class MessageQueue {
        private SyncQueueItem mRoot;

        MessageQueue() {
        }

        synchronized SyncQueueItem next() {
            monitor-enter(this);
            SyncQueueItem r10 = this.mRoot;     // Catch: Throwable -> L11
            if (r10 == null) goto L6;
            this.mRoot = r10.next;     // Catch: Throwable -> L11
            monitor-exit(this);
            return r10;
        L6:
            monitor-exit(this);
            return null;
        L11:
            th = move-exception;
            throw th;
        }

        synchronized void removeMessages(int r10) {
            monitor-enter(this);
        L22:
            SyncQueueItem r11 = this.mRoot;     // Catch: Throwable -> L19
            if (r11 == null) goto L8;
            if (r11.what != r10) goto L8;
            this.mRoot = r11.next;     // Catch: Throwable -> L19
            r11.recycle();     // Catch: Throwable -> L19
        L8:
            if (r11 == null) goto L17;
            SyncQueueItem r12 = r11.next;     // Catch: Throwable -> L19
        L10:
            if (r12 == null) goto L17;
            SyncQueueItem r13 = r12.next;     // Catch: Throwable -> L19
            if (r12.what != r10) goto L15;
            r11.next = r13;     // Catch: Throwable -> L19
            r12.recycle();     // Catch: Throwable -> L19
        L16:
            r12 = r13;
            goto L10
        L15:
            r11 = r12;
        L17:
            monitor-exit(this);
            return;
        L19:
            th = move-exception;
            throw th;
        }

        synchronized void sendMessage(SyncQueueItem r10) {
            monitor-enter(this);
            SyncQueueItem r11 = this.mRoot;     // Catch: Throwable -> L14
            if (r11 != null) goto L8;
            this.mRoot = r10;     // Catch: Throwable -> L14
            monitor-exit(this);
            return;
        L8:
            SyncQueueItem r12 = r11.next;     // Catch: Throwable -> L14
            if (r12 == null) goto L11;
            r11 = r12;
            goto L8
        L11:
            r11.next = r10;     // Catch: Throwable -> L14
            monitor-exit(this);
            return;
        L14:
            th = move-exception;
            throw th;
        }

        synchronized void sendMessageAtFrontOfQueue(SyncQueueItem r10) {
            monitor-enter(this);
            r10.next = this.mRoot;     // Catch: Throwable -> L6
            this.mRoot = r10;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
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

        static SyncQueueItem obtainMessage(int r10, int r11, int r12) {
            return obtainMessage(r10, r11, r12, 0, 0, 0, null);
        }

        static SyncQueueItem obtainMessage(int r10, int r11, int r12, int r13, int r14, int r15, Object r16) {
            Object r17 = sPoolLock;
            monitor-enter(r17);
            SyncQueueItem r18 = sPool;     // Catch: Throwable -> L11
            if (r18 != null) goto L7;
            r18 = new SyncQueueItem();     // Catch: Throwable -> L11
        L8:
            r18.what = r10;     // Catch: Throwable -> L11
            r18.arg1 = r11;     // Catch: Throwable -> L11
            r18.arg2 = r12;     // Catch: Throwable -> L11
            r18.arg3 = r13;     // Catch: Throwable -> L11
            r18.arg4 = r14;     // Catch: Throwable -> L11
            r18.arg5 = r15;     // Catch: Throwable -> L11
            r18.data = r16;     // Catch: Throwable -> L11
            monitor-exit(r17);     // Catch: Throwable -> L11
            return r18;
        L7:
            sPool = r18.next;     // Catch: Throwable -> L11
            r18.next = null;     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            throw th;
        }

        static SyncQueueItem obtainMessage(int r10, int r11, Object r12) {
            return obtainMessage(r10, r11, 0, 0, 0, 0, r12);
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
            Object r10 = sPoolLock;
            monitor-enter(r10);
            SyncQueueItem r11 = sPool;     // Catch: Throwable -> L10
            if (r11 == null) goto L7;
            this.next = r11;     // Catch: Throwable -> L10
        L7:
            sPool = this;     // Catch: Throwable -> L10
            monitor-exit(r10);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }
    }

    MessageThreadUtil() {
    }

    @Override // androidx.recyclerview.widget.ThreadUtil
    public ThreadUtil.BackgroundCallback<T> getBackgroundProxy(ThreadUtil.BackgroundCallback<T> r10) {
        return new AnonymousClass2(this, r10);
    }

    @Override // androidx.recyclerview.widget.ThreadUtil
    public ThreadUtil.MainThreadCallback<T> getMainThreadProxy(ThreadUtil.MainThreadCallback<T> r10) {
        return new AnonymousClass1(this, r10);
    }
}
