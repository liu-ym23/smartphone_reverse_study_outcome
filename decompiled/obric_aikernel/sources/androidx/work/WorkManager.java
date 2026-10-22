package androidx.work;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.LiveData;
import androidx.work.impl.WorkManagerImpl;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"AddedAbstractMethod"})
public abstract class WorkManager {

    public static final enum UpdateResult extends Enum<UpdateResult> {
        private static final /* synthetic */ UpdateResult[] $VALUES = null;
        public static final UpdateResult APPLIED_FOR_NEXT_RUN = null;
        public static final UpdateResult APPLIED_IMMEDIATELY = null;
        public static final UpdateResult NOT_APPLIED = null;

        private static /* synthetic */ UpdateResult[] $values() {
            return new UpdateResult[]{NOT_APPLIED, APPLIED_IMMEDIATELY, APPLIED_FOR_NEXT_RUN};
        }

        static {
            NOT_APPLIED = new UpdateResult("NOT_APPLIED", 0);
            APPLIED_IMMEDIATELY = new UpdateResult("APPLIED_IMMEDIATELY", 1);
            APPLIED_FOR_NEXT_RUN = new UpdateResult("APPLIED_FOR_NEXT_RUN", 2);
            $VALUES = $values();
        }

        private UpdateResult(String r10, int r11) {
            super(r10, r11);
        }

        public static UpdateResult valueOf(String r10) {
            return (UpdateResult) Enum.valueOf(UpdateResult.class, r10);
        }

        public static UpdateResult[] values() {
            return (UpdateResult[]) $VALUES.clone();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected WorkManager() {
    }

    @NonNull
    @Deprecated
    public static WorkManager getInstance() {
        WorkManagerImpl r10 = WorkManagerImpl.getInstance();
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new IllegalStateException("WorkManager is not initialized properly.  The most likely cause is that you disabled WorkManagerInitializer in your manifest but forgot to call WorkManager#initialize in your Application#onCreate or a ContentProvider.");
    }

    @NonNull
    public static WorkManager getInstance(@NonNull Context r10) {
        return WorkManagerImpl.getInstance(r10);
    }

    public static void initialize(@NonNull Context r10, @NonNull Configuration r11) {
        WorkManagerImpl.initialize(r10, r11);
    }

    public static boolean isInitialized() {
        return WorkManagerImpl.isInitialized();
    }

    @NonNull
    public final WorkContinuation beginUniqueWork(@NonNull String r10, @NonNull ExistingWorkPolicy r11, @NonNull OneTimeWorkRequest r12) {
        return beginUniqueWork(r10, r11, Collections.singletonList(r12));
    }

    @NonNull
    public abstract WorkContinuation beginUniqueWork(@NonNull String r10, @NonNull ExistingWorkPolicy r11, @NonNull List<OneTimeWorkRequest> r12);

    @NonNull
    public final WorkContinuation beginWith(@NonNull OneTimeWorkRequest r10) {
        return beginWith(Collections.singletonList(r10));
    }

    @NonNull
    public abstract WorkContinuation beginWith(@NonNull List<OneTimeWorkRequest> r10);

    @NonNull
    public abstract Operation cancelAllWork();

    @NonNull
    public abstract Operation cancelAllWorkByTag(@NonNull String r10);

    @NonNull
    public abstract Operation cancelUniqueWork(@NonNull String r10);

    @NonNull
    public abstract Operation cancelWorkById(@NonNull UUID r10);

    @NonNull
    public abstract PendingIntent createCancelPendingIntent(@NonNull UUID r10);

    @NonNull
    public final Operation enqueue(@NonNull WorkRequest r10) {
        return enqueue(Collections.singletonList(r10));
    }

    @NonNull
    public abstract Operation enqueue(@NonNull List<? extends WorkRequest> r10);

    @NonNull
    public abstract Operation enqueueUniquePeriodicWork(@NonNull String r10, @NonNull ExistingPeriodicWorkPolicy r11, @NonNull PeriodicWorkRequest r12);

    @NonNull
    public Operation enqueueUniqueWork(@NonNull String r10, @NonNull ExistingWorkPolicy r11, @NonNull OneTimeWorkRequest r12) {
        return enqueueUniqueWork(r10, r11, Collections.singletonList(r12));
    }

    @NonNull
    public abstract Operation enqueueUniqueWork(@NonNull String r10, @NonNull ExistingWorkPolicy r11, @NonNull List<OneTimeWorkRequest> r12);

    @NonNull
    public abstract Configuration getConfiguration();

    @NonNull
    public abstract c6.a<Long> getLastCancelAllTimeMillis();

    @NonNull
    public abstract LiveData<Long> getLastCancelAllTimeMillisLiveData();

    @NonNull
    public abstract c6.a<WorkInfo> getWorkInfoById(@NonNull UUID r10);

    @NonNull
    public abstract LiveData<WorkInfo> getWorkInfoByIdLiveData(@NonNull UUID r10);

    @NonNull
    public abstract c6.a<List<WorkInfo>> getWorkInfos(@NonNull WorkQuery r10);

    @NonNull
    public abstract c6.a<List<WorkInfo>> getWorkInfosByTag(@NonNull String r10);

    @NonNull
    public abstract LiveData<List<WorkInfo>> getWorkInfosByTagLiveData(@NonNull String r10);

    @NonNull
    public abstract c6.a<List<WorkInfo>> getWorkInfosForUniqueWork(@NonNull String r10);

    @NonNull
    public abstract LiveData<List<WorkInfo>> getWorkInfosForUniqueWorkLiveData(@NonNull String r10);

    @NonNull
    public abstract LiveData<List<WorkInfo>> getWorkInfosLiveData(@NonNull WorkQuery r10);

    @NonNull
    public abstract Operation pruneWork();

    @NonNull
    public abstract c6.a<UpdateResult> updateWork(@NonNull WorkRequest r10);
}
