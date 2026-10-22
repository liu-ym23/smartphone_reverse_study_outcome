package androidx.work;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class DelegatingWorkerFactory extends WorkerFactory {
    private static final String TAG = null;
    private final List<WorkerFactory> mFactories;

    static {
        TAG = Logger.tagWithPrefix("DelegatingWkrFctry");
    }

    public DelegatingWorkerFactory() {
        this.mFactories = new CopyOnWriteArrayList();
    }

    public final void addFactory(@NonNull WorkerFactory r10) {
        this.mFactories.add(r10);
    }

    @Override // androidx.work.WorkerFactory
    @Nullable
    public final ListenableWorker createWorker(@NonNull Context r10, @NonNull String r11, @NonNull WorkerParameters r12) {
        Iterator<WorkerFactory> r13 = this.mFactories.iterator();
    L4:
        if (r13.hasNext() == false) goto L12;
        ListenableWorker r14 = r13.next().createWorker(r10, r11, r12);     // Catch: Throwable -> L9
        if (r14 == null) goto L4;
        return r14;
    L9:
        th = move-exception;
        Logger.get().error(TAG, "Unable to instantiate a ListenableWorker (" + r11 + ")", th);
        throw th;
    L12:
        return null;
    }

    @NonNull
    @VisibleForTesting
    List<WorkerFactory> getFactories() {
        return this.mFactories;
    }
}
