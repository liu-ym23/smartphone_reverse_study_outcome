package androidx.work.impl.utils;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.ProgressUpdater;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class WorkProgressUpdater implements ProgressUpdater {
    static final String TAG = null;
    final TaskExecutor mTaskExecutor;
    final WorkDatabase mWorkDatabase;

    static {
        TAG = Logger.tagWithPrefix("WorkProgressUpdater");
    }

    public WorkProgressUpdater(@NonNull WorkDatabase r10, @NonNull TaskExecutor r11) {
        this.mWorkDatabase = r10;
        this.mTaskExecutor = r11;
    }

    @Override // androidx.work.ProgressUpdater
    @NonNull
    public c6.a<Void> updateProgress(@NonNull Context r10, @NonNull final UUID r11, @NonNull final Data r12) {
        final SettableFuture r13 = SettableFuture.create();
        this.mTaskExecutor.executeOnTaskThread(new AnonymousClass1(this, r11, r12, r13));
        return r13;
    }
}
