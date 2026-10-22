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

    public final class LoadTask extends ModernAsyncTask<Void, Void, D> implements Runnable {
        private final CountDownLatch mDone;
        final /* synthetic */ AsyncTaskLoader this$0;
        boolean waiting;

        public LoadTask(AsyncTaskLoader r5) {
            this.this$0 = r5;
            this.mDone = new CountDownLatch(1);
        }

        @Override // androidx.loader.content.ModernAsyncTask
        public /* bridge */ /* synthetic */ Object doInBackground(Void[] r5) {
            return doInBackground2(r5);
        }

        @Override // androidx.loader.content.ModernAsyncTask
        public void onCancelled(D r5) {
            this.this$0.dispatchOnCancelled(this, r5);     // Catch: Throwable -> L5
            this.mDone.countDown();
            return;
        L5:
            th = move-exception;
            this.mDone.countDown();
            throw th;
        }

        @Override // androidx.loader.content.ModernAsyncTask
        public void onPostExecute(D r5) {
            this.this$0.dispatchOnLoadComplete(this, r5);     // Catch: Throwable -> L5
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

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        public D doInBackground2(Void... r5) {
            return (D) this.this$0.onLoadInBackground();
        L4:
            e = move-exception;
            if (isCancelled() == false) goto L9;
            return null;
        L9:
            throw e;
        }
    }

    public AsyncTaskLoader(@NonNull Context r5) {
        this(r5, ModernAsyncTask.THREAD_POOL_EXECUTOR);
    }

    public void cancelLoadInBackground() {
    }

    public void dispatchOnCancelled(AsyncTaskLoader<D>.LoadTask r5, D r10) {
        onCanceled(r10);
        if (this.mCancellingTask != r5) goto L6;
        rollbackContentChanged();
        this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
        this.mCancellingTask = null;
        deliverCancellation();
        executePendingTask();
        return;
    }

    public void dispatchOnLoadComplete(AsyncTaskLoader<D>.LoadTask r5, D r10) {
        if (this.mTask == r5) goto L6;
        dispatchOnCancelled(r5, r10);
        return;
    L6:
        if (isAbandoned() == false) goto L8;
        onCanceled(r10);
        return;
    L8:
        commitContentChanged();
        this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
        this.mTask = null;
        deliverResult(r10);
    }

    @Override // androidx.loader.content.Loader
    @Deprecated
    public void dump(String r5, FileDescriptor r10, PrintWriter r11, String[] r12) {
        super.dump(r5, r10, r11, r12);
        if (this.mTask == null) goto L6;
        r11.print(r5);
        r11.print("mTask=");
        r11.print(this.mTask);
        r11.print(" waiting=");
        r11.println(this.mTask.waiting);
    L6:
        if (this.mCancellingTask == null) goto L9;
        r11.print(r5);
        r11.print("mCancellingTask=");
        r11.print(this.mCancellingTask);
        r11.print(" waiting=");
        r11.println(this.mCancellingTask.waiting);
    L9:
        if (this.mUpdateThrottle == 0) goto L12;
        r11.print(r5);
        r11.print("mUpdateThrottle=");
        TimeUtils.formatDuration(this.mUpdateThrottle, r11);
        r11.print(" mLastLoadCompleteTime=");
        TimeUtils.formatDuration(this.mLastLoadCompleteTime, SystemClock.uptimeMillis(), r11);
        r11.println();
        return;
    }

    public void executePendingTask() {
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
    public boolean onCancelLoad() {
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
        boolean r5 = this.mTask.cancel(false);
        if (r5 == false) goto L21;
        this.mCancellingTask = this.mTask;
        cancelLoadInBackground();
    L21:
        this.mTask = null;
        return r5;
    }

    public void onCanceled(@Nullable D r5) {
    }

    @Override // androidx.loader.content.Loader
    public void onForceLoad() {
        super.onForceLoad();
        cancelLoad();
        this.mTask = new LoadTask(this);
        executePendingTask();
    }

    @Nullable
    public D onLoadInBackground() {
        return loadInBackground();
    }

    public void setUpdateThrottle(long r5) {
        this.mUpdateThrottle = r5;
        if (r5 == 0) goto L6;
        this.mHandler = new Handler();
        return;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void waitForLoader() {
        AsyncTaskLoader<D>.LoadTask r5 = this.mTask;
        if (r5 == null) goto L6;
        r5.waitForLoader();
        return;
    }

    private AsyncTaskLoader(@NonNull Context r5, @NonNull Executor r10) {
        super(r5);
        this.mLastLoadCompleteTime = -10000;
        this.mExecutor = r10;
    }
}
