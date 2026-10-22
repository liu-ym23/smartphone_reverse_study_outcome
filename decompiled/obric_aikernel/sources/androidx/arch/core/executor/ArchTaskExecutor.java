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
        sMainThreadExecutor = b.f233c;
        sIOThreadExecutor = a.f232c;
    }

    private ArchTaskExecutor() {
        DefaultTaskExecutor r10 = new DefaultTaskExecutor();
        this.mDefaultTaskExecutor = r10;
        this.mDelegate = r10;
    }

    public static /* synthetic */ void a(Runnable r10) {
        lambda$static$1(r10);
    }

    public static /* synthetic */ void b(Runnable r10) {
        lambda$static$0(r10);
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
    L14:
        th = move-exception;
        throw th;
    L9:
        if (sInstance != null) goto L11;
        sInstance = new ArchTaskExecutor();     // Catch: Throwable -> L14
    L11:
        monitor-exit(ArchTaskExecutor.class);     // Catch: Throwable -> L14
        return sInstance;
    }

    @NonNull
    public static Executor getMainThreadExecutor() {
        return sMainThreadExecutor;
    }

    private static /* synthetic */ void lambda$static$0(Runnable r10) {
        getInstance().postToMainThread(r10);
    }

    private static /* synthetic */ void lambda$static$1(Runnable r10) {
        getInstance().executeOnDiskIO(r10);
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public void executeOnDiskIO(@NonNull Runnable r10) {
        this.mDelegate.executeOnDiskIO(r10);
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public boolean isMainThread() {
        return this.mDelegate.isMainThread();
    }

    @Override // androidx.arch.core.executor.TaskExecutor
    public void postToMainThread(@NonNull Runnable r10) {
        this.mDelegate.postToMainThread(r10);
    }

    public void setDelegate(@Nullable TaskExecutor r10) {
        if (r10 != null) goto L4;
        r10 = this.mDefaultTaskExecutor;
    L4:
        this.mDelegate = r10;
    }
}
