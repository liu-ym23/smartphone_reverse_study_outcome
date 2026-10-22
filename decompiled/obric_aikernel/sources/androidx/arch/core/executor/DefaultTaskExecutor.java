package androidx.arch.core.executor;

import android.os.Build;
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
    private static class Api28Impl {
        private Api28Impl() {
        }

        @NonNull
        public static Handler createAsync(@NonNull Looper r10) {
            return Handler.createAsync(r10);
        }
    }

    public DefaultTaskExecutor() {
        this.mLock = new Object();
        this.mDiskIO = Executors.newFixedThreadPool(4, new AnonymousClass1(this));
    }

    @NonNull
    private static Handler createAsync(@NonNull Looper r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 28) goto L7;
        return Api28Impl.createAsync(r10);
    L7:
        if (r11 < 17) goto L13;
        return (Handler) Handler.class.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{r10, null, Boolean.TRUE});
    L11:
        return new Handler(r10);
    L13:
        return new Handler(r10);
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public void executeOnDiskIO(@NonNull Runnable r10) {
        this.mDiskIO.execute(r10);
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public boolean isMainThread() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public void postToMainThread(@NonNull Runnable r10) {
        if (this.mMainHandler != null) goto L14;
        Object r11 = this.mLock;
        monitor-enter(r11);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.mMainHandler != null) goto L9;
        this.mMainHandler = createAsync(Looper.getMainLooper());     // Catch: Throwable -> L11
    L9:
        monitor-exit(r11);     // Catch: Throwable -> L11
    L14:
        this.mMainHandler.post(r10);
    }
}
