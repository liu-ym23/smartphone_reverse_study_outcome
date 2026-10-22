package androidx.arch.core.executor;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class TaskExecutor {
    public TaskExecutor() {
    }

    public abstract void executeOnDiskIO(@NonNull Runnable r10);

    public void executeOnMainThread(@NonNull Runnable r10) {
        if (isMainThread() == false) goto L5;
        r10.run();
        return;
    L5:
        postToMainThread(r10);
    }

    public abstract boolean isMainThread();

    public abstract void postToMainThread(@NonNull Runnable r10);
}
