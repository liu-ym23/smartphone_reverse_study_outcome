package androidx.loader.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.TimeUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class AsyncTaskLoader<D> extends Loader<D> {
    static final boolean DEBUG = false;
    static final String TAG = "AsyncTaskLoader";
    volatile AsyncTaskLoader<D>.LoadTask mCancellingTask;
    private final Executor mExecutor;
    Handler mHandler;
    long mLastLoadCompleteTime;
    volatile AsyncTaskLoader<D>.LoadTask mTask;
    long mUpdateThrottle;

    final class LoadTask extends ModernAsyncTask<Void, Void, D> implements Runnable {
        private final CountDownLatch mDone;
        final /* synthetic */ AsyncTaskLoader this$0;
        boolean waiting;

        LoadTask(AsyncTaskLoader r10) {
            this.this$0 = r10;
            this.mDone = new CountDownLatch(1);
        }

        @Override // androidx.loader.content.ModernAsyncTask
        protected /* bridge */ /* synthetic */ Object doInBackground(Void[] r10) {
            return doInBackground2(r10);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected D doInBackground2(Void... r10) {
            return (D) this.this$0.onLoadInBackground();
        L4:
            e = move-exception;
            if (isCancelled() == false) goto L9;
            return null;
        L9:
            throw e;
        }

        @Override // androidx.loader.content.ModernAsyncTask
        protected void onCancelled(D r10) {
            this.this$0.dispatchOnCancelled(this, r10);     // Catch: Throwable -> L5
            this.mDone.countDown();
            return;
        L5:
            th = move-exception;
            this.mDone.countDown();
            throw th;
        }

        @Override // androidx.loader.content.ModernAsyncTask
        protected void onPostExecute(D r10) {
            this.this$0.dispatchOnLoadComplete(this, r10);     // Catch: Throwable -> L5
            this.mDone.countDown();
            return;
        L5:
            th = move-exception;
            this.mDone.countDown();
            throw th;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.waiting = false;
            this.this$0.executePendingTask();
        }

        public void waitForLoader() {
            this.mDone.await();     // Catch: InterruptedException -> L4
            return;
        }
    }

    public AsyncTaskLoader(@NonNull Context r10) {
        this(r10, ModernAsyncTask.THREAD_POOL_EXECUTOR);
    }

    private AsyncTaskLoader(@NonNull Context r10, @NonNull Executor r11) {
        super(r10);
        this.mLastLoadCompleteTime = -10000;
        this.mExecutor = r11;
    }

    public void cancelLoadInBackground() {
    }

    void dispatchOnCancelled(AsyncTaskLoader<D>.LoadTask r10, D r11) {
        onCanceled(r11);
        if (this.mCancellingTask != r10) goto L6;
        rollbackContentChanged();
        this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
        this.mCancellingTask = null;
        deliverCancellation();
        executePendingTask();
        return;
    }

    void dispatchOnLoadComplete(AsyncTaskLoader<D>.LoadTask r10, D r11) {
        if (this.mTask == r10) goto L6;
        dispatchOnCancelled(r10, r11);
        return;
    L6:
        if (isAbandoned() == false) goto L8;
        onCanceled(r11);
        return;
    L8:
        commitContentChanged();
        this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
        this.mTask = null;
        deliverResult(r11);
    }

    @Override // androidx.loader.content.Loader
    @Deprecated
    public void dump(String r10, FileDescriptor r11, PrintWriter r12, String[] r13) {
        super.dump(r10, r11, r12, r13);
        if (this.mTask == null) goto L6;
        r12.print(r10);
        r12.print("mTask=");
        r12.print(this.mTask);
        r12.print(" waiting=");
        r12.println(this.mTask.waiting);
    L6:
        if (this.mCancellingTask == null) goto L9;
        r12.print(r10);
        r12.print("mCancellingTask=");
        r12.print(this.mCancellingTask);
        r12.print(" waiting=");
        r12.println(this.mCancellingTask.waiting);
    L9:
        if (this.mUpdateThrottle == 0) goto L12;
        r12.print(r10);
        r12.print("mUpdateThrottle=");
        TimeUtils.formatDuration(this.mUpdateThrottle, r12);
        r12.print(" mLastLoadCompleteTime=");
        TimeUtils.formatDuration(this.mLastLoadCompleteTime, SystemClock.uptimeMillis(), r12);
        r12.println();
        return;
    }

    void executePendingTask() {
        if (this.mCancellingTask == null) goto L5;
        return;
    L5:
        if (this.mTask != null) goto L7;
        return;
    L7:
        if (this.mTask.waiting == false) goto L10;
        this.mTask.waiting = false;
        this.mHandler.removeCallbacks(this.mTask);
    L10:
        if (this.mUpdateThrottle > 0) goto L12;
    L15:
        this.mTask.executeOnExecutor(this.mExecutor, null);
        return;
    L12:
        if (SystemClock.uptimeMillis() >= (this.mLastLoadCompleteTime + this.mUpdateThrottle)) goto L15;
        this.mTask.waiting = true;
        this.mHandler.postAtTime(this.mTask, this.mLastLoadCompleteTime + this.mUpdateThrottle);
    }

    public boolean isLoadInBackgroundCanceled() {
        if (this.mCancellingTask == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Nullable
    public abstract D loadInBackground();

    @Override // androidx.loader.content.Loader
    protected boolean onCancelLoad() {
        if (this.mTask != null) goto L5;
        return false;
    L5:
        if (this.mStarted == true) goto L8;
        this.mContentChanged = true;
    L8:
        if (this.mCancellingTask == null) goto L15;
        if (this.mTask.waiting == false) goto L12;
        this.mTask.waiting = false;
        this.mHandler.removeCallbacks(this.mTask);
    L12:
        this.mTask = null;
        return false;
    L15:
        if (this.mTask.waiting == false) goto L18;
        this.mTask.waiting = false;
        this.mHandler.removeCallbacks(this.mTask);
        this.mTask = null;
        return false;
    L18:
        boolean r10 = this.mTask.cancel(false);
        if (r10 == false) goto L21;
        this.mCancellingTask = this.mTask;
        cancelLoadInBackground();
    L21:
        this.mTask = null;
        return r10;
    }

    public void onCanceled(@Nullable D r10) {
    }

    @Override // androidx.loader.content.Loader
    protected void onForceLoad() {
        super.onForceLoad();
        cancelLoad();
        this.mTask = new LoadTask(this);
        executePendingTask();
    }

    @Nullable
    protected D onLoadInBackground() {
        return loadInBackground();
    }

    public void setUpdateThrottle(long r10) {
        this.mUpdateThrottle = r10;
        if (r10 == 0) goto L6;
        this.mHandler = new Handler();
        return;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void waitForLoader() {
        AsyncTaskLoader<D>.LoadTask r10 = this.mTask;
        if (r10 == null) goto L6;
        r10.waitForLoader();
        return;
    }
}
