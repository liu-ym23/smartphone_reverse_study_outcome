package androidx.arch.core.executor;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ArchTaskExecutor extends TaskExecutor {

    @NonNull
    private static final Executor sIOThreadExecutor = null;
    private static volatile ArchTaskExecutor sInstance;

    @NonNull
    private static final Executor sMainThreadExecutor = null;

    @NonNull
    private final TaskExecutor mDefaultTaskExecutor;

    @NonNull
    private TaskExecutor mDelegate;

    static {
        sMainThreadExecutor = new a(0);
        sIOThreadExecutor = new a(1);
    }

    private ArchTaskExecutor() {
        DefaultTaskExecutor r5 = new DefaultTaskExecutor();
        this.mDefaultTaskExecutor = r5;
        this.mDelegate = r5;
    }

    public static /* synthetic */ void a(Runnable r5) {
        lambda$static$0(r5);
    }

    public static /* synthetic */ void b(Runnable r5) {
        lambda$static$1(r5);
    }

    @NonNull
    public static Executor getIOThreadExecutor() {
        return sIOThreadExecutor;
    }

    @NonNull
    public static ArchTaskExecutor getInstance() {
        if (sInstance == null) goto L7;
        return sInstance;
    L7:
        monitor-enter(ArchTaskExecutor.class);
    L11:
        th = move-exception;
        throw th;
    L9:
        if (sInstance != null) goto L13;
        sInstance = new ArchTaskExecutor();     // Catch: Throwable -> L11
    L13:
        monitor-exit(ArchTaskExecutor.class);     // Catch: Throwable -> L11
        return sInstance;
    }

    @NonNull
    public static Executor getMainThreadExecutor() {
        return sMainThreadExecutor;
    }

    private static /* synthetic */ void lambda$static$0(Runnable r5) {
        getInstance().postToMainThread(r5);
    }

    private static /* synthetic */ void lambda$static$1(Runnable r5) {
        getInstance().executeOnDiskIO(r5);
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public void executeOnDiskIO(@NonNull Runnable r5) {
        this.mDelegate.executeOnDiskIO(r5);
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public boolean isMainThread() {
        return this.mDelegate.isMainThread();
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public void postToMainThread(@NonNull Runnable r5) {
        this.mDelegate.postToMainThread(r5);
    }

    public void setDelegate(@Nullable TaskExecutor r5) {
        if (r5 != null) goto L4;
        r5 = this.mDefaultTaskExecutor;
    L4:
        this.mDelegate = r5;
    }
}
