package androidx.recyclerview.widget;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
class MessageThreadUtil<T> implements ThreadUtil<T> {

    /* JADX INFO: renamed from: androidx.recyclerview.widget.MessageThreadUtil$1, reason: invalid class name */
    public class AnonymousClass1 implements ThreadUtil.MainThreadCallback<T> {
        static final int ADD_TILE = 2;
        static final int REMOVE_TILE = 3;
        static final int UPDATE_ITEM_COUNT = 1;
        private final Handler mMainThreadHandler;
        private Runnable mMainThreadRunnable;
        final MessageQueue mQueue;
        final /* synthetic */ MessageThreadUtil this$0;
        final /* synthetic */ ThreadUtil.MainThreadCallback val$callback;

        public AnonymousClass1(MessageThreadUtil r5, ThreadUtil.MainThreadCallback r10) {
            this.this$0 = r5;
            this.val$callback = r10;
            this.mQueue = new MessageQueue();
            this.mMainThreadHandler = new Handler(Looper.getMainLooper());
            this.mMainThreadRunnable = new RunnableC00071(this);
        }

        private void sendMessage(SyncQueueItem r5) {
            this.mQueue.sendMessage(r5);
            this.mMainThreadHandler.post(this.mMainThreadRunnable);
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void addTile(int r5, TileList.Tile<T> r10) {
            sendMessage(SyncQueueItem.obtainMessage(2, r5, r10));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void removeTile(int r5, int r10) {
            sendMessage(SyncQueueItem.obtainMessage(3, r5, r10));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void updateItemCount(int r5, int r10) {
            sendMessage(SyncQueueItem.obtainMessage(1, r5, r10));
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.MessageThreadUtil$2, reason: invalid class name */
    public class AnonymousClass2 implements ThreadUtil.BackgroundCallback<T> {
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

        public AnonymousClass2(MessageThreadUtil r5, ThreadUtil.BackgroundCallback r10) {
            this.this$0 = r5;
            this.val$callback = r10;
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

        private void sendMessage(SyncQueueItem r5) {
            this.mQueue.sendMessage(r5);
            maybeExecuteBackgroundRunnable();
        }

        private void sendMessageAtFrontOfQueue(SyncQueueItem r5) {
            this.mQueue.sendMessageAtFrontOfQueue(r5);
            maybeExecuteBackgroundRunnable();
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void loadTile(int r5, int r10) {
            sendMessage(SyncQueueItem.obtainMessage(3, r5, r10));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void recycleTile(TileList.Tile<T> r5) {
            sendMessage(SyncQueueItem.obtainMessage(4, 0, r5));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void refresh(int r5) {
            sendMessageAtFrontOfQueue(SyncQueueItem.obtainMessage(1, r5, null));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void updateRange(int r10, int r11, int r12, int r13, int r14) {
            sendMessageAtFrontOfQueue(SyncQueueItem.obtainMessage(2, r10, r11, r12, r13, r14, null));
        }
    }

    public static class MessageQueue {
        private final Object mLock;
        private SyncQueueItem mRoot;

        public MessageQueue() {
            this.mLock = new Object();
        }

        public SyncQueueItem next() {
            Object r5 = this.mLock;
            monitor-enter(r5);
            SyncQueueItem r10 = this.mRoot;     // Catch: Throwable -> L9
            if (r10 != null) goto L11;
            monitor-exit(r5);     // Catch: Throwable -> L9
            return null;
        L11:
            this.mRoot = r10.next;     // Catch: Throwable -> L9
            monitor-exit(r5);     // Catch: Throwable -> L9
            return r10;
        L9:
            th = move-exception;
            throw th;
        }

        public void removeMessages(int r5) {
            Object r10 = this.mLock;
            monitor-enter(r10);
        L23:
            SyncQueueItem r11 = this.mRoot;     // Catch: Throwable -> L9
            if (r11 == null) goto L11;
            if (r11.what != r5) goto L11;
            this.mRoot = r11.next;     // Catch: Throwable -> L9
            r11.recycle();     // Catch: Throwable -> L9
        L11:
            if (r11 == null) goto L19;
            SyncQueueItem r12 = r11.next;     // Catch: Throwable -> L9
        L13:
            if (r12 == null) goto L19;
            SyncQueueItem r13 = r12.next;     // Catch: Throwable -> L9
            if (r12.what != r5) goto L17;
            r11.next = r13;     // Catch: Throwable -> L9
            r12.recycle();     // Catch: Throwable -> L9
        L18:
            r12 = r13;
            goto L13
        L17:
            r11 = r12;
        L19:
            monitor-exit(r10);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }

        public void sendMessage(SyncQueueItem r5) {
            Object r10 = this.mLock;
            monitor-enter(r10);
            SyncQueueItem r11 = this.mRoot;     // Catch: Throwable -> L9
            if (r11 != null) goto L11;
            this.mRoot = r5;     // Catch: Throwable -> L9
            monitor-exit(r10);     // Catch: Throwable -> L9
            return;
        L11:
            SyncQueueItem r12 = r11.next;     // Catch: Throwable -> L9
            if (r12 == null) goto L14;
            r11 = r12;
            goto L11
        L14:
            r11.next = r5;     // Catch: Throwable -> L9
            monitor-exit(r10);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }

        public void sendMessageAtFrontOfQueue(SyncQueueItem r5) {
            Object r10 = this.mLock;
            monitor-enter(r10);
            r5.next = this.mRoot;     // Catch: Throwable -> L7
            this.mRoot = r5;     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public static class SyncQueueItem {
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

        public SyncQueueItem() {
        }

        public static SyncQueueItem obtainMessage(int r5, int r10, int r11, int r12, int r13, int r14, Object r15) {
            Object r16 = sPoolLock;
            monitor-enter(r16);
            SyncQueueItem r17 = sPool;     // Catch: Throwable -> L7
            if (r17 != null) goto L9;
            r17 = new SyncQueueItem();     // Catch: Throwable -> L7
        L10:
            r17.what = r5;     // Catch: Throwable -> L7
            r17.arg1 = r10;     // Catch: Throwable -> L7
            r17.arg2 = r11;     // Catch: Throwable -> L7
            r17.arg3 = r12;     // Catch: Throwable -> L7
            r17.arg4 = r13;     // Catch: Throwable -> L7
            r17.arg5 = r14;     // Catch: Throwable -> L7
            r17.data = r15;     // Catch: Throwable -> L7
            monitor-exit(r16);     // Catch: Throwable -> L7
            return r17;
        L9:
            sPool = r17.next;     // Catch: Throwable -> L7
            r17.next = null;     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            throw th;
        }

        public void recycle() {
            this.next = null;
            this.arg5 = 0;
            this.arg4 = 0;
            this.arg3 = 0;
            this.arg2 = 0;
            this.arg1 = 0;
            this.what = 0;
            this.data = null;
            Object r5 = sPoolLock;
            monitor-enter(r5);
            SyncQueueItem r10 = sPool;     // Catch: Throwable -> L7
            if (r10 == null) goto L9;
            this.next = r10;     // Catch: Throwable -> L7
        L9:
            sPool = this;     // Catch: Throwable -> L7
            monitor-exit(r5);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public static SyncQueueItem obtainMessage(int r10, int r11, int r12) {
            return obtainMessage(r10, r11, r12, 0, 0, 0, null);
        }

        public static SyncQueueItem obtainMessage(int r10, int r11, Object r12) {
            return obtainMessage(r10, r11, 0, 0, 0, 0, r12);
        }
    }

    public MessageThreadUtil() {
    }

    @Override // androidx.recyclerview.widget.ThreadUtil
    public ThreadUtil.BackgroundCallback<T> getBackgroundProxy(ThreadUtil.BackgroundCallback<T> r5) {
        return new AnonymousClass2(this, r5);
    }

    @Override // androidx.recyclerview.widget.ThreadUtil
    public ThreadUtil.MainThreadCallback<T> getMainThreadProxy(ThreadUtil.MainThreadCallback<T> r5) {
        return new AnonymousClass1(this, r5);
    }
}
