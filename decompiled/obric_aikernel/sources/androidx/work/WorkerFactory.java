package androidx.work;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
public abstract class WorkerFactory {
    private static final String TAG = null;

    static {
        TAG = Logger.tagWithPrefix("WorkerFactory");
    }

    public WorkerFactory() {
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static WorkerFactory getDefaultWorkerFactory() {
        return new AnonymousClass1();
    }

    @Nullable
    public abstract ListenableWorker createWorker(@NonNull Context r10, @NonNull String r11, @NonNull WorkerParameters r12);

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final ListenableWorker createWorkerWithDefaultFallback(@NonNull Context r10, @NonNull String r11, @NonNull WorkerParameters r12) {
        ListenableWorker r13 = createWorker(r10, r11, r12);
        if (r13 != null) goto L15;
        Class r14 = null;
        r14 = Class.forName(r11).asSubclass(ListenableWorker.class);     // Catch: Throwable -> L7
    L9:
        if (r14 == null) goto L15;
        r13 = (ListenableWorker) r14.getDeclaredConstructor(new Class[]{Context.class, WorkerParameters.class}).newInstance(new Object[]{r10, r12});     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Logger.get().error(TAG, "Could not instantiate " + r11, th);
    L7:
        th = move-exception;
        Logger.get().error(TAG, "Invalid class: " + r11, th);
    L15:
        if (r13 != null) goto L17;
    L21:
        return r13;
    L17:
        if (r13.isUsed() == false) goto L21;
        throw new IllegalStateException("WorkerFactory (" + getClass().getName() + ") returned an instance of a ListenableWorker (" + r11 + ") which has already been invoked. createWorker() must always return a new instance of a ListenableWorker.");
    }
}
