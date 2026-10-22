package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.work.WorkInfo;
import androidx.work.WorkQuery;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.utils.futures.SettableFuture;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class StatusRunnable<T> implements Runnable {
    private final SettableFuture<T> mFuture;

    public StatusRunnable() {
        this.mFuture = SettableFuture.create();
    }

    @NonNull
    public static StatusRunnable<List<WorkInfo>> forStringIds(@NonNull final WorkManagerImpl r10, @NonNull final List<String> r11) {
        return new AnonymousClass1(r10, r11);
    }

    @NonNull
    public static StatusRunnable<List<WorkInfo>> forTag(@NonNull final WorkManagerImpl r10, @NonNull final String r11) {
        return new AnonymousClass3(r10, r11);
    }

    @NonNull
    public static StatusRunnable<WorkInfo> forUUID(@NonNull final WorkManagerImpl r10, @NonNull final UUID r11) {
        return new AnonymousClass2(r10, r11);
    }

    @NonNull
    public static StatusRunnable<List<WorkInfo>> forUniqueWork(@NonNull final WorkManagerImpl r10, @NonNull final String r11) {
        return new AnonymousClass4(r10, r11);
    }

    @NonNull
    public static StatusRunnable<List<WorkInfo>> forWorkQuerySpec(@NonNull final WorkManagerImpl r10, @NonNull final WorkQuery r11) {
        return new AnonymousClass5(r10, r11);
    }

    @NonNull
    public c6.a<T> getFuture() {
        return this.mFuture;
    }

    @Override // java.lang.Runnable
    public void run() {
        T r10 = runInternal();     // Catch: Throwable -> L4
        this.mFuture.set(r10);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        this.mFuture.setException(th);
    }

    @WorkerThread
    abstract T runInternal();
}
