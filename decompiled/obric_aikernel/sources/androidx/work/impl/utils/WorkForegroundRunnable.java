package androidx.work.impl.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.ForegroundUpdater;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class WorkForegroundRunnable implements Runnable {
    static final String TAG = null;
    final Context mContext;
    final ForegroundUpdater mForegroundUpdater;
    final SettableFuture<Void> mFuture;
    final TaskExecutor mTaskExecutor;
    final WorkSpec mWorkSpec;
    final ListenableWorker mWorker;

    static {
        TAG = Logger.tagWithPrefix("WorkForegroundRunnable");
    }

    @SuppressLint({"LambdaLast"})
    public WorkForegroundRunnable(@NonNull Context r10, @NonNull WorkSpec r11, @NonNull ListenableWorker r12, @NonNull ForegroundUpdater r13, @NonNull TaskExecutor r14) {
        this.mFuture = SettableFuture.create();
        this.mContext = r10;
        this.mWorkSpec = r11;
        this.mWorker = r12;
        this.mForegroundUpdater = r13;
        this.mTaskExecutor = r14;
    }

    public static /* synthetic */ void a(WorkForegroundRunnable r10, SettableFuture r11) {
        r10.lambda$run$0(r11);
    }

    private /* synthetic */ void lambda$run$0(SettableFuture r10) {
        if (this.mFuture.isCancelled() == true) goto L5;
        r10.setFuture(this.mWorker.getForegroundInfoAsync());
        return;
    L5:
        r10.cancel(true);
    }

    @NonNull
    public c6.a<Void> getFuture() {
        return this.mFuture;
    }

    @Override // java.lang.Runnable
    @SuppressLint({"UnsafeExperimentalUsageError"})
    public void run() {
        if (this.mWorkSpec.expedited == true) goto L5;
    L9:
        this.mFuture.set(null);
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 31) goto L9;
        final SettableFuture r10 = SettableFuture.create();
        this.mTaskExecutor.getMainThreadExecutor().execute(new c(this, r10));
        r10.addListener(new AnonymousClass1(this, r10), this.mTaskExecutor.getMainThreadExecutor());
    }
}
