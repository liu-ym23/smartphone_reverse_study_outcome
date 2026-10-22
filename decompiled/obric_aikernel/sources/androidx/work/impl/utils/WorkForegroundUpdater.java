package androidx.work.impl.utils;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.ForegroundInfo;
import androidx.work.ForegroundUpdater;
import androidx.work.Logger;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class WorkForegroundUpdater implements ForegroundUpdater {
    private static final String TAG = null;
    final ForegroundProcessor mForegroundProcessor;
    private final TaskExecutor mTaskExecutor;
    final WorkSpecDao mWorkSpecDao;

    static {
        TAG = Logger.tagWithPrefix("WMFgUpdater");
    }

    public WorkForegroundUpdater(@NonNull WorkDatabase r10, @NonNull ForegroundProcessor r11, @NonNull TaskExecutor r12) {
        this.mForegroundProcessor = r11;
        this.mTaskExecutor = r12;
        this.mWorkSpecDao = r10.workSpecDao();
    }

    @Override // androidx.work.ForegroundUpdater
    @NonNull
    public c6.a<Void> setForegroundAsync(@NonNull final Context r10, @NonNull final UUID r11, @NonNull final ForegroundInfo r12) {
        final SettableFuture r13 = SettableFuture.create();
        this.mTaskExecutor.executeOnTaskThread(new AnonymousClass1(this, r13, r11, r12, r10));
        return r13;
    }
}
