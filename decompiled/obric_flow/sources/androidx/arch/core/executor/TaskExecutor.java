package androidx.arch.core.executor;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class TaskExecutor {
    public TaskExecutor() {
    }

    public abstract void executeOnDiskIO(@NonNull Runnable r5);

    public void executeOnMainThread(@NonNull Runnable r5) {
        if (isMainThread() == false) goto L5;
        r5.run();
        return;
    L5:
        postToMainThread(r5);
    }

    public abstract boolean isMainThread();

    public abstract void postToMainThread(@NonNull Runnable r5);
}
