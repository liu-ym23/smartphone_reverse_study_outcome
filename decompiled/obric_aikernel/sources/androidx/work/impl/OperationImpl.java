package androidx.work.impl;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.work.Operation;
import androidx.work.impl.utils.futures.SettableFuture;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class OperationImpl implements Operation {
    private final SettableFuture<Operation.State.SUCCESS> mOperationFuture;
    private final MutableLiveData<Operation.State> mOperationState;

    public OperationImpl() {
        this.mOperationState = new MutableLiveData();
        this.mOperationFuture = SettableFuture.create();
        markState(Operation.IN_PROGRESS);
    }

    @Override // androidx.work.Operation
    @NonNull
    public c6.a<Operation.State.SUCCESS> getResult() {
        return this.mOperationFuture;
    }

    @Override // androidx.work.Operation
    @NonNull
    public LiveData<Operation.State> getState() {
        return this.mOperationState;
    }

    public void markState(@NonNull Operation.State r10) {
        this.mOperationState.postValue(r10);
        if ((r10 instanceof Operation.State.SUCCESS) == false) goto L6;
        this.mOperationFuture.set((Operation.State.SUCCESS) r10);
        return;
    L6:
        if ((r10 instanceof Operation.State.FAILURE) == false) goto L10;
        this.mOperationFuture.setException(((Operation.State.FAILURE) r10).getThrowable());
        return;
    }
}
