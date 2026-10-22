package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.arch.core.executor.ArchTaskExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class ComputableLiveData<T> {
    private final LiveData<T> _liveData;
    private final AtomicBoolean computing;
    private final Executor executor;
    private final AtomicBoolean invalid;

    @JvmField
    public final Runnable invalidationRunnable;
    private final LiveData<T> liveData;

    @JvmField
    public final Runnable refreshRunnable;

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public ComputableLiveData() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @JvmOverloads
    public ComputableLiveData(Executor r10) {
        Intrinsics.checkNotNullParameter(r10, "executor");
        this.executor = r10;
        LiveData<T> r11 = new ComputableLiveData$_liveData$1(this);
        this._liveData = r11;
        this.liveData = r11;
        this.invalid = new AtomicBoolean(true);
        this.computing = new AtomicBoolean(false);
        this.refreshRunnable = new a(this);
        this.invalidationRunnable = new b(this);
    }

    public /* synthetic */ ComputableLiveData(Executor r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = ArchTaskExecutor.getIOThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(r10, "getIOThreadExecutor()");
    L5:
        this(r10);
    }

    public static /* synthetic */ void a(ComputableLiveData r10) {
        refreshRunnable$lambda$0(r10);
    }

    public static /* synthetic */ void b(ComputableLiveData r10) {
        invalidationRunnable$lambda$1(r10);
    }

    @VisibleForTesting
    public static /* synthetic */ void getInvalidationRunnable$lifecycle_livedata_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getRefreshRunnable$lifecycle_livedata_release$annotations() {
    }

    private static final void invalidationRunnable$lambda$1(ComputableLiveData r10) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        boolean r11 = r10.getLiveData().hasActiveObservers();
        if (r10.invalid.compareAndSet(false, true) == false) goto L7;
        if (r11 == false) goto L8;
        r10.executor.execute(r10.refreshRunnable);
        return;
    L8:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void refreshRunnable$lambda$0(ComputableLiveData r10) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
    L3:
        boolean r11 = false;
        if (r10.computing.compareAndSet(false, true) == false) goto L15;
        Object r12 = null;
        boolean r13 = false;
    L19:
        if (r10.invalid.compareAndSet(true, false) == false) goto L9;
        r12 = r10.compute();     // Catch: Throwable -> L12
        r13 = true;
        goto L19
    L9:
        if (r13 == false) goto L11;
        r10.getLiveData().postValue(r12);     // Catch: Throwable -> L12
    L11:
        r10.computing.set(false);
        r11 = r13;
    L12:
        th = move-exception;
        r10.computing.set(false);
        throw th;
    L15:
        if (r11 == false) goto L18;
        if (r10.invalid.get() == true) goto L3;
        return;
    }

    @WorkerThread
    protected abstract T compute();

    public final AtomicBoolean getComputing$lifecycle_livedata_release() {
        return this.computing;
    }

    public final Executor getExecutor$lifecycle_livedata_release() {
        return this.executor;
    }

    public final AtomicBoolean getInvalid$lifecycle_livedata_release() {
        return this.invalid;
    }

    public LiveData<T> getLiveData() {
        return this.liveData;
    }

    public void invalidate() {
        ArchTaskExecutor.getInstance().executeOnMainThread(this.invalidationRunnable);
    }
}
