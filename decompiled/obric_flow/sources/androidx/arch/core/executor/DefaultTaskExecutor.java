package androidx.arch.core.executor;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class DefaultTaskExecutor extends TaskExecutor {
    private final ExecutorService mDiskIO;
    private final Object mLock;

    @Nullable
    private volatile Handler mMainHandler;

    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        @NonNull
        public static Handler createAsync(@NonNull Looper r5) {
            return Handler.createAsync(r5);
        }
    }

    public DefaultTaskExecutor() {
        this.mLock = new Object();
        this.mDiskIO = Executors.newFixedThreadPool(4, new AnonymousClass1(this));
    }

    @NonNull
    private static Handler createAsync(@NonNull Looper r5) {
        return Api28Impl.createAsync(r5);
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public void executeOnDiskIO(@NonNull Runnable r5) {
        this.mDiskIO.execute(r5);
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public boolean isMainThread() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public void postToMainThread(@NonNull Runnable r5) {
        if (this.mMainHandler != null) goto L15;
        Object r10 = this.mLock;
        monitor-enter(r10);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (this.mMainHandler != null) goto L11;
        this.mMainHandler = createAsync(Looper.getMainLooper());     // Catch: Throwable -> L9
    L11:
        monitor-exit(r10);     // Catch: Throwable -> L9
    L15:
        this.mMainHandler.post(r5);
    }
}
