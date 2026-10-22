package androidx.work.impl;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.LiveData;
import androidx.work.ArrayCreatingInputMerger;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Logger;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Operation;
import androidx.work.WorkContinuation;
import androidx.work.WorkInfo;
import androidx.work.WorkRequest;
import androidx.work.impl.utils.EnqueueRunnable;
import androidx.work.impl.utils.StatusRunnable;
import androidx.work.impl.workers.CombineContinuationsWorker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class WorkContinuationImpl extends WorkContinuation {
    private static final String TAG = null;
    private final List<String> mAllIds;
    private boolean mEnqueued;
    private final ExistingWorkPolicy mExistingWorkPolicy;
    private final List<String> mIds;
    private final String mName;
    private Operation mOperation;
    private final List<WorkContinuationImpl> mParents;
    private final List<? extends WorkRequest> mWork;
    private final WorkManagerImpl mWorkManagerImpl;

    static {
        TAG = Logger.tagWithPrefix("WorkContinuationImpl");
    }

    public WorkContinuationImpl(@NonNull WorkManagerImpl r10, @Nullable String r11, @NonNull ExistingWorkPolicy r12, @NonNull List<? extends WorkRequest> r13) {
        this(r10, r11, r12, r13, null);
    }

    public WorkContinuationImpl(@NonNull WorkManagerImpl r10, @Nullable String r11, @NonNull ExistingWorkPolicy r12, @NonNull List<? extends WorkRequest> r13, @Nullable List<WorkContinuationImpl> r14) {
        this.mWorkManagerImpl = r10;
        this.mName = r11;
        this.mExistingWorkPolicy = r12;
        this.mWork = r13;
        this.mParents = r14;
        this.mIds = new ArrayList(r13.size());
        this.mAllIds = new ArrayList();
        if (r14 == null) goto L8;
        Iterator<WorkContinuationImpl> r15 = r14.iterator();
    L6:
        if (r15.hasNext() == false) goto L8;
        WorkContinuationImpl r16 = r15.next();
        this.mAllIds.addAll(r16.mAllIds);
    L8:
        int r17 = 0;
    L10:
        if (r17 >= r13.size()) goto L12;
        String r18 = r13.get(r17).getStringId();
        this.mIds.add(r18);
        this.mAllIds.add(r18);
        r17 = r17 + 1;
        goto L10
    }

    public WorkContinuationImpl(@NonNull WorkManagerImpl r10, @NonNull List<? extends WorkRequest> r11) {
        this(r10, null, ExistingWorkPolicy.KEEP, r11, null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    private static boolean hasCycles(@NonNull WorkContinuationImpl r10, @NonNull Set<String> r11) {
        r11.addAll(r10.getIds());
        Set<String> r12 = prerequisitesFor(r10);
        Iterator<String> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        if (r12.contains(r13.next()) == false) goto L4;
        return true;
    L8:
        List<WorkContinuationImpl> r14 = r10.getParents();
        if (r14 != null) goto L11;
    L18:
        r11.removeAll(r10.getIds());
        return false;
    L11:
        if (r14.isEmpty() == true) goto L18;
        Iterator<WorkContinuationImpl> r15 = r14.iterator();
    L14:
        if (r15.hasNext() == false) goto L18;
        if (hasCycles(r15.next(), r11) == false) goto L14;
        return true;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static Set<String> prerequisitesFor(@NonNull WorkContinuationImpl r10) {
        HashSet r11 = new HashSet();
        List<WorkContinuationImpl> r12 = r10.getParents();
        if (r12 != null) goto L5;
    L10:
        return r11;
    L5:
        if (r12.isEmpty() == true) goto L10;
        Iterator<WorkContinuationImpl> r13 = r12.iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        r11.addAll(r13.next().getIds());
        goto L8
    }

    @Override // androidx.work.WorkContinuation
    @NonNull
    protected WorkContinuation combineInternal(@NonNull List<WorkContinuation> r10) {
        OneTimeWorkRequest r11 = new OneTimeWorkRequest.Builder(CombineContinuationsWorker.class).setInputMerger(ArrayCreatingInputMerger.class).build();
        ArrayList r12 = new ArrayList(r10.size());
        Iterator<WorkContinuation> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L7;
        r12.add((WorkContinuationImpl) r13.next());
        goto L4
    L7:
        return new WorkContinuationImpl(this.mWorkManagerImpl, null, ExistingWorkPolicy.KEEP, Collections.singletonList(r11), r12);
    }

    @Override // androidx.work.WorkContinuation
    @NonNull
    public Operation enqueue() {
        if (this.mEnqueued == true) goto L5;
        EnqueueRunnable r10 = new EnqueueRunnable(this);
        this.mWorkManagerImpl.getWorkTaskExecutor().executeOnTaskThread(r10);
        this.mOperation = r10.getOperation();
    L7:
        return this.mOperation;
    L5:
        Logger.get().warning(TAG, "Already enqueued work ids (" + TextUtils.join(", ", this.mIds) + ")");
        goto L7
    }

    @NonNull
    public List<String> getAllIds() {
        return this.mAllIds;
    }

    @NonNull
    public ExistingWorkPolicy getExistingWorkPolicy() {
        return this.mExistingWorkPolicy;
    }

    @NonNull
    public List<String> getIds() {
        return this.mIds;
    }

    @Nullable
    public String getName() {
        return this.mName;
    }

    @Nullable
    public List<WorkContinuationImpl> getParents() {
        return this.mParents;
    }

    @NonNull
    public List<? extends WorkRequest> getWork() {
        return this.mWork;
    }

    @Override // androidx.work.WorkContinuation
    @NonNull
    public c6.a<List<WorkInfo>> getWorkInfos() {
        StatusRunnable<List<WorkInfo>> r10 = StatusRunnable.forStringIds(this.mWorkManagerImpl, this.mAllIds);
        this.mWorkManagerImpl.getWorkTaskExecutor().executeOnTaskThread(r10);
        return r10.getFuture();
    }

    @Override // androidx.work.WorkContinuation
    @NonNull
    public LiveData<List<WorkInfo>> getWorkInfosLiveData() {
        return this.mWorkManagerImpl.getWorkInfosById(this.mAllIds);
    }

    @NonNull
    public WorkManagerImpl getWorkManagerImpl() {
        return this.mWorkManagerImpl;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean hasCycles() {
        return hasCycles(this, new HashSet());
    }

    public boolean isEnqueued() {
        return this.mEnqueued;
    }

    public void markEnqueued() {
        this.mEnqueued = true;
    }

    @Override // androidx.work.WorkContinuation
    @NonNull
    public WorkContinuation then(@NonNull List<OneTimeWorkRequest> r10) {
        if (r10.isEmpty() == false) goto L6;
        return this;
    L6:
        return new WorkContinuationImpl(this.mWorkManagerImpl, this.mName, ExistingWorkPolicy.KEEP, r10, Collections.singletonList(this));
    }
}
