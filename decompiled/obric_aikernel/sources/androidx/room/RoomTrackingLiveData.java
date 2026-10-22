package androidx.room;

import android.annotation.SuppressLint;
import androidx.lifecycle.LiveData;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedApi"})
public final class RoomTrackingLiveData<T> extends LiveData<T> {
    private final Callable<T> computeFunction;
    private final AtomicBoolean computing;
    private final InvalidationLiveDataContainer container;
    private final RoomDatabase database;
    private final boolean inTransaction;
    private final AtomicBoolean invalid;
    private final Runnable invalidationRunnable;
    private final InvalidationTracker.Observer observer;
    private final Runnable refreshRunnable;
    private final AtomicBoolean registeredObserver;

    public RoomTrackingLiveData(RoomDatabase r10, InvalidationLiveDataContainer r11, boolean r12, Callable<T> r13, final String[] r14) {
        Intrinsics.checkNotNullParameter(r10, "database");
        Intrinsics.checkNotNullParameter(r11, "container");
        Intrinsics.checkNotNullParameter(r13, "computeFunction");
        Intrinsics.checkNotNullParameter(r14, "tableNames");
        this.database = r10;
        this.container = r11;
        this.inTransaction = r12;
        this.computeFunction = r13;
        this.observer = new RoomTrackingLiveData$observer$1(r14, this);
        this.invalid = new AtomicBoolean(true);
        this.computing = new AtomicBoolean(false);
        this.registeredObserver = new AtomicBoolean(false);
        this.refreshRunnable = new y(this);
        this.invalidationRunnable = new z(this);
    }

    public static /* synthetic */ void a(RoomTrackingLiveData r10) {
        refreshRunnable$lambda$0(r10);
    }

    public static /* synthetic */ void b(RoomTrackingLiveData r10) {
        invalidationRunnable$lambda$1(r10);
    }

    private static final void invalidationRunnable$lambda$1(RoomTrackingLiveData r10) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        boolean r11 = r10.hasActiveObservers();
        if (r10.invalid.compareAndSet(false, true) == false) goto L7;
        if (r11 == false) goto L8;
        r10.getQueryExecutor().execute(r10.refreshRunnable);
        return;
    L8:
        return;
    }

    private static final void refreshRunnable$lambda$0(RoomTrackingLiveData r10) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        if (r10.registeredObserver.compareAndSet(false, true) == false) goto L6;
        r10.database.getInvalidationTracker().addWeakObserver(r10.observer);
    L6:
        if (r10.computing.compareAndSet(false, true) == false) goto L21;
        T r11 = null;
        boolean r12 = false;
    L26:
    L18:
        th = move-exception;
        r10.computing.set(false);
        throw th;
    L9:
        if (r10.invalid.compareAndSet(true, false) == false) goto L15;
        r11 = r10.computeFunction.call();     // Catch: Exception -> L12 Throwable -> L18
        r12 = true;
        goto L26
    L12:
        e = move-exception;
        throw new RuntimeException("Exception while computing database live data.", e);     // Catch: Throwable -> L18
    L15:
        if (r12 == false) goto L17;
        r10.postValue(r11);     // Catch: Throwable -> L18
    L17:
        r10.computing.set(false);
    L22:
        if (r12 == false) goto L25;
        if (r10.invalid.get() == true) goto L6;
        return;
    L25:
        return;
    L21:
        r12 = false;
        goto L22
    }

    public final Callable<T> getComputeFunction() {
        return this.computeFunction;
    }

    public final AtomicBoolean getComputing() {
        return this.computing;
    }

    public final RoomDatabase getDatabase() {
        return this.database;
    }

    public final boolean getInTransaction() {
        return this.inTransaction;
    }

    public final AtomicBoolean getInvalid() {
        return this.invalid;
    }

    public final Runnable getInvalidationRunnable() {
        return this.invalidationRunnable;
    }

    public final InvalidationTracker.Observer getObserver() {
        return this.observer;
    }

    public final Executor getQueryExecutor() {
        boolean r10 = this.inTransaction;
        RoomDatabase r11 = this.database;
        if (r10 == false) goto L6;
        return r11.getTransactionExecutor();
    L6:
        return r11.getQueryExecutor();
    }

    public final Runnable getRefreshRunnable() {
        return this.refreshRunnable;
    }

    public final AtomicBoolean getRegisteredObserver() {
        return this.registeredObserver;
    }

    @Override // androidx.lifecycle.LiveData
    protected void onActive() {
        super.onActive();
        InvalidationLiveDataContainer r10 = this.container;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Any>");
        r10.onActive(this);
        getQueryExecutor().execute(this.refreshRunnable);
    }

    @Override // androidx.lifecycle.LiveData
    protected void onInactive() {
        super.onInactive();
        InvalidationLiveDataContainer r10 = this.container;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Any>");
        r10.onInactive(this);
    }
}
