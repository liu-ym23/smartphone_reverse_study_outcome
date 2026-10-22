package androidx.work;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.LiveData;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class WorkContinuation {
    public WorkContinuation() {
    }

    @NonNull
    public static WorkContinuation combine(@NonNull List<WorkContinuation> r10) {
        return r10.get(0).combineInternal(r10);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected abstract WorkContinuation combineInternal(@NonNull List<WorkContinuation> r10);

    @NonNull
    public abstract Operation enqueue();

    @NonNull
    public abstract c6.a<List<WorkInfo>> getWorkInfos();

    @NonNull
    public abstract LiveData<List<WorkInfo>> getWorkInfosLiveData();

    @NonNull
    public final WorkContinuation then(@NonNull OneTimeWorkRequest r10) {
        return then(Collections.singletonList(r10));
    }

    @NonNull
    public abstract WorkContinuation then(@NonNull List<OneTimeWorkRequest> r10);
}
