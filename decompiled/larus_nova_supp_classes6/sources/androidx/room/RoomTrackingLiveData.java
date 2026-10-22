package androidx.room;

import androidx.lifecycle.LiveData;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
class RoomTrackingLiveData<T> extends LiveData<T> {
    final Callable<T> mComputeFunction;
    final AtomicBoolean mComputing;
    private final InvalidationLiveDataContainer mContainer;
    final RoomDatabase mDatabase;
    final boolean mInTransaction;
    final AtomicBoolean mInvalid;
    final Runnable mInvalidationRunnable;
    final InvalidationTracker$Observer mObserver;
    final Runnable mRefreshRunnable;
    final AtomicBoolean mRegisteredObserver;

    public Executor getQueryExecutor() {
        if (this.mInTransaction == false) goto L7;
        return this.mDatabase.getTransactionExecutor();
    L7:
        return this.mDatabase.getQueryExecutor();
    }

    public void onActive() {
        super.onActive();
        this.mContainer.onActive(this);
        getQueryExecutor().execute(this.mRefreshRunnable);
    }

    public void onInactive() {
        super.onInactive();
        this.mContainer.onInactive(this);
    }

    public static /* synthetic */ void access$000(RoomTrackingLiveData r0, Object r1) {
        r0.postValue(r1);
    }

    public RoomTrackingLiveData(RoomDatabase r3, InvalidationLiveDataContainer r4, boolean r5, Callable<T> r6, String[] r7) {
        this.mInvalid = new AtomicBoolean(true);
        this.mComputing = new AtomicBoolean(false);
        this.mRegisteredObserver = new AtomicBoolean(false);
        this.mRefreshRunnable = new 1(this);
        this.mInvalidationRunnable = new 2(this);
        this.mDatabase = r3;
        this.mInTransaction = r5;
        this.mComputeFunction = r6;
        this.mContainer = r4;
        this.mObserver = new 3(this, r7);
    }
}
