package androidx.work.multiprocess;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Data;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ForegroundInfo;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkContinuation;
import androidx.work.WorkInfo;
import androidx.work.WorkQuery;
import androidx.work.WorkRequest;
import androidx.work.impl.WorkManagerImpl;
import c6.a;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public abstract class RemoteWorkManager {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected RemoteWorkManager() {
    }

    @NonNull
    public static RemoteWorkManager getInstance(@NonNull Context r10) {
        RemoteWorkManager r11 = WorkManagerImpl.getInstance(r10).getRemoteWorkManager();
        if (r11 == null) goto L6;
        return r11;
    L6:
        throw new IllegalStateException("Unable to initialize RemoteWorkManager");
    }

    @NonNull
    public final RemoteWorkContinuation beginUniqueWork(@NonNull String r10, @NonNull ExistingWorkPolicy r11, @NonNull OneTimeWorkRequest r12) {
        return beginUniqueWork(r10, r11, Collections.singletonList(r12));
    }

    @NonNull
    public abstract RemoteWorkContinuation beginUniqueWork(@NonNull String r10, @NonNull ExistingWorkPolicy r11, @NonNull List<OneTimeWorkRequest> r12);

    @NonNull
    public final RemoteWorkContinuation beginWith(@NonNull OneTimeWorkRequest r10) {
        return beginWith(Collections.singletonList(r10));
    }

    @NonNull
    public abstract RemoteWorkContinuation beginWith(@NonNull List<OneTimeWorkRequest> r10);

    @NonNull
    public abstract a<Void> cancelAllWork();

    @NonNull
    public abstract a<Void> cancelAllWorkByTag(@NonNull String r10);

    @NonNull
    public abstract a<Void> cancelUniqueWork(@NonNull String r10);

    @NonNull
    public abstract a<Void> cancelWorkById(@NonNull UUID r10);

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public abstract a<Void> enqueue(@NonNull WorkContinuation r10);

    @NonNull
    public abstract a<Void> enqueue(@NonNull WorkRequest r10);

    @NonNull
    public abstract a<Void> enqueue(@NonNull List<WorkRequest> r10);

    @NonNull
    public abstract a<Void> enqueueUniquePeriodicWork(@NonNull String r10, @NonNull ExistingPeriodicWorkPolicy r11, @NonNull PeriodicWorkRequest r12);

    @NonNull
    public final a<Void> enqueueUniqueWork(@NonNull String r10, @NonNull ExistingWorkPolicy r11, @NonNull OneTimeWorkRequest r12) {
        return enqueueUniqueWork(r10, r11, Collections.singletonList(r12));
    }

    @NonNull
    public abstract a<Void> enqueueUniqueWork(@NonNull String r10, @NonNull ExistingWorkPolicy r11, @NonNull List<OneTimeWorkRequest> r12);

    @NonNull
    public abstract a<List<WorkInfo>> getWorkInfos(@NonNull WorkQuery r10);

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public abstract a<Void> setForegroundAsync(@NonNull String r10, @NonNull ForegroundInfo r11);

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public abstract a<Void> setProgress(@NonNull UUID r10, @NonNull Data r11);
}
