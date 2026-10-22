package androidx.loader.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.util.TimeUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

        LoadTask(AsyncTaskLoader r2) {
            this.this$0 = r2;
            this.mDone = new CountDownLatch(1);
        }

        @Override // androidx.loader.content.ModernAsyncTask
        public /* synthetic */ Object doInBackground(Void[] r3) {
            return doInBackground2((Void[]) ZeusTransformUtils.preCheckCast(r3, Void[].class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        public D doInBackground2(Void... r1) {
            return (D) this.this$0.onLoadInBackground();
        L4:
            e = move-exception;
            if (isCancelled() == false) goto L9;
            return null;
        L9:
            throw e;
        }

        @Override // androidx.loader.content.ModernAsyncTask
        public void onCancelled(D r2) {
            this.this$0.dispatchOnCancelled(this, r2);     // Catch: Throwable -> L5
            this.mDone.countDown();
            return;
        L5:
            th = move-exception;
            this.mDone.countDown();
            throw th;
        }

        @Override // androidx.loader.content.ModernAsyncTask
        public void onPostExecute(D r2) {
            this.this$0.dispatchOnLoadComplete(this, r2);     // Catch: Throwable -> L5
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

    public AsyncTaskLoader(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), ModernAsyncTask.THREAD_POOL_EXECUTOR);
    }

    private AsyncTaskLoader(Context r3, Executor r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.memorydata.plugin");
        super(r5);
        this.mLastLoadCompleteTime = -10000;
        this.mExecutor = r6;
    }

    public void cancelLoadInBackground() {
    }

    void dispatchOnCancelled(AsyncTaskLoader<D>.LoadTask r1, D r2) {
        onCanceled(r2);
        if (this.mCancellingTask != r1) goto L6;
        rollbackContentChanged();
        this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
        this.mCancellingTask = null;
        deliverCancellation();
        executePendingTask();
        return;
    }

    void dispatchOnLoadComplete(AsyncTaskLoader<D>.LoadTask r3, D r4) {
        if (this.mTask == r3) goto L6;
        dispatchOnCancelled(r3, r4);
        return;
    L6:
        if (isAbandoned() == false) goto L8;
        onCanceled(r4);
        return;
    L8:
        commitContentChanged();
        this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
        this.mTask = null;
        deliverResult(r4);
    }

    @Override // androidx.loader.content.Loader
    @Deprecated
    public void dump(String r5, FileDescriptor r6, PrintWriter r7, String[] r8) {
        super.dump(r5, r6, r7, r8);
        if (this.mTask == null) goto L6;
        r7.print(r5);
        r7.print("mTask=");
        r7.print(this.mTask);
        r7.print(" waiting=");
        r7.println(this.mTask.waiting);
    L6:
        if (this.mCancellingTask == null) goto L9;
        r7.print(r5);
        r7.print("mCancellingTask=");
        r7.print(this.mCancellingTask);
        r7.print(" waiting=");
        r7.println(this.mCancellingTask.waiting);
    L9:
        if (this.mUpdateThrottle == 0) goto L12;
        r7.print(r5);
        r7.print("mUpdateThrottle=");
        TimeUtils.formatDuration(this.mUpdateThrottle, r7);
        r7.print(" mLastLoadCompleteTime=");
        TimeUtils.formatDuration(this.mLastLoadCompleteTime, SystemClock.uptimeMillis(), r7);
        r7.println();
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
        this.mTask.executeOnExecutor(this.mExecutor, (Void[]) ZeusTransformUtils.preCheckCast(null, Void[].class, "com.obric.memorydata.plugin"));
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
        boolean r0 = this.mTask.cancel(false);
        if (r0 == false) goto L21;
        this.mCancellingTask = this.mTask;
        cancelLoadInBackground();
    L21:
        this.mTask = null;
        return r0;
    }

    public void onCanceled(D r1) {
    }

    @Override // androidx.loader.content.Loader
    public void onForceLoad() {
        super.onForceLoad();
        cancelLoad();
        this.mTask = new LoadTask(this);
        executePendingTask();
    }

    public D onLoadInBackground() {
        return loadInBackground();
    }

    public void setUpdateThrottle(long r3) {
        this.mUpdateThrottle = r3;
        if (r3 == 0) goto L6;
        this.mHandler = new Handler();
        return;
    }

    public void waitForLoader() {
        AsyncTaskLoader<D>.LoadTask r0 = this.mTask;
        if (r0 == null) goto L6;
        r0.waitForLoader();
        return;
    }
}
