package androidx.room;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import android.util.Log;
import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class MultiInstanceInvalidationClient {
    private final Context appContext;
    private final IMultiInstanceInvalidationCallback callback;
    private int clientId;
    private final Executor executor;
    private final InvalidationTracker invalidationTracker;
    private final String name;
    public InvalidationTracker.Observer observer;
    private final Runnable removeObserverRunnable;
    private IMultiInstanceInvalidationService service;
    private final ServiceConnection serviceConnection;
    private final Runnable setUpRunnable;
    private final AtomicBoolean stopped;

    public MultiInstanceInvalidationClient(Context r10, String r11, Intent r12, InvalidationTracker r13, Executor r14) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r12, "serviceIntent");
        Intrinsics.checkNotNullParameter(r13, "invalidationTracker");
        Intrinsics.checkNotNullParameter(r14, "executor");
        this.name = r11;
        this.invalidationTracker = r13;
        this.executor = r14;
        Context r15 = r10.getApplicationContext();
        this.appContext = r15;
        this.callback = new MultiInstanceInvalidationClient$callback$1(this);
        this.stopped = new AtomicBoolean(false);
        ServiceConnection r16 = new MultiInstanceInvalidationClient$serviceConnection$1(this);
        this.serviceConnection = r16;
        this.setUpRunnable = new d(this);
        this.removeObserverRunnable = new e(this);
        Object[] r17 = r13.getTableIdLookup$room_runtime_release().keySet().toArray(new String[0]);
        Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        final String[] r18 = (String[]) r17;
        setObserver(new AnonymousClass1(this, r18));
        r15.bindService(r12, r16, 1);
    }

    public static /* synthetic */ void a(MultiInstanceInvalidationClient r10) {
        setUpRunnable$lambda$1(r10);
    }

    public static /* synthetic */ void b(MultiInstanceInvalidationClient r10) {
        removeObserverRunnable$lambda$2(r10);
    }

    private static final void removeObserverRunnable$lambda$2(MultiInstanceInvalidationClient r10) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        r10.invalidationTracker.removeObserver(r10.getObserver());
    }

    private static final void setUpRunnable$lambda$1(MultiInstanceInvalidationClient r10) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        IMultiInstanceInvalidationService r11 = r10.service;     // Catch: RemoteException -> L7
        if (r11 == null) goto L12;
        r10.clientId = r11.registerCallback(r10.callback, r10.name);     // Catch: RemoteException -> L7
        r10.invalidationTracker.addObserver(r10.getObserver());     // Catch: RemoteException -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        Log.w(Room.LOG_TAG, "Cannot register multi-instance invalidation callback", e);
    }

    public final IMultiInstanceInvalidationCallback getCallback() {
        return this.callback;
    }

    public final int getClientId() {
        return this.clientId;
    }

    public final Executor getExecutor() {
        return this.executor;
    }

    public final InvalidationTracker getInvalidationTracker() {
        return this.invalidationTracker;
    }

    public final String getName() {
        return this.name;
    }

    public final InvalidationTracker.Observer getObserver() {
        InvalidationTracker.Observer r10 = this.observer;
        if (r10 == null) goto L5;
        return r10;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("observer");
        return null;
    }

    public final Runnable getRemoveObserverRunnable() {
        return this.removeObserverRunnable;
    }

    public final IMultiInstanceInvalidationService getService() {
        return this.service;
    }

    public final ServiceConnection getServiceConnection() {
        return this.serviceConnection;
    }

    public final Runnable getSetUpRunnable() {
        return this.setUpRunnable;
    }

    public final AtomicBoolean getStopped() {
        return this.stopped;
    }

    public final void setClientId(int r10) {
        this.clientId = r10;
    }

    public final void setObserver(InvalidationTracker.Observer r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.observer = r10;
    }

    public final void setService(IMultiInstanceInvalidationService r10) {
        this.service = r10;
    }

    public final void stop() {
        if (this.stopped.compareAndSet(false, true) == false) goto L15;
        this.invalidationTracker.removeObserver(getObserver());
        IMultiInstanceInvalidationService r10 = this.service;     // Catch: RemoteException -> L9
        if (r10 == null) goto L11;
        r10.unregisterCallback(this.callback, this.clientId);     // Catch: RemoteException -> L9
    L11:
        this.appContext.unbindService(this.serviceConnection);
        return;
    L9:
        e = move-exception;
        Log.w(Room.LOG_TAG, "Cannot unregister multi-instance invalidation callback", e);
        goto L11
    }
}
