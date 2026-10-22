package androidx.room;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import android.util.Log;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0006\u00109\u001a\u00020:R\u0016\u0010\r\u001a\n \u000e*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0011\u0010/\u001a\u000200¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u00103\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b4\u0010(R\u0011\u00105\u001a\u000206¢\u0006\b\n\u0000\u001a\u0004\b7\u00108¨\u0006;"}, d2 = {"Landroidx/room/MultiInstanceInvalidationClient;", "", "context", "Landroid/content/Context;", ActivityLifecycle.NAME, "", "serviceIntent", "Landroid/content/Intent;", "invalidationTracker", "Landroidx/room/InvalidationTracker;", "executor", "Ljava/util/concurrent/Executor;", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;Landroidx/room/InvalidationTracker;Ljava/util/concurrent/Executor;)V", "appContext", "kotlin.jvm.PlatformType", "callback", "Landroidx/room/IMultiInstanceInvalidationCallback;", "getCallback", "()Landroidx/room/IMultiInstanceInvalidationCallback;", "clientId", "", "getClientId", "()I", "setClientId", "(I)V", "getExecutor", "()Ljava/util/concurrent/Executor;", "getInvalidationTracker", "()Landroidx/room/InvalidationTracker;", "getName", "()Ljava/lang/String;", "observer", "Landroidx/room/InvalidationTracker$Observer;", "getObserver", "()Landroidx/room/InvalidationTracker$Observer;", "setObserver", "(Landroidx/room/InvalidationTracker$Observer;)V", "removeObserverRunnable", "Ljava/lang/Runnable;", "getRemoveObserverRunnable", "()Ljava/lang/Runnable;", "service", "Landroidx/room/IMultiInstanceInvalidationService;", "getService", "()Landroidx/room/IMultiInstanceInvalidationService;", "setService", "(Landroidx/room/IMultiInstanceInvalidationService;)V", "serviceConnection", "Landroid/content/ServiceConnection;", "getServiceConnection", "()Landroid/content/ServiceConnection;", "setUpRunnable", "getSetUpRunnable", "stopped", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getStopped", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "stop", "", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

    public MultiInstanceInvalidationClient(Context r3, String r4, Intent r5, InvalidationTracker r6, Executor r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Executor r9 = (Executor) ZeusTransformUtils.wrapperContextForParams(r7, Executor.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r4, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r5, "serviceIntent");
        Intrinsics.checkNotNullParameter(r6, "invalidationTracker");
        Intrinsics.checkNotNullParameter(r9, "executor");
        this.name = r4;
        this.invalidationTracker = r6;
        this.executor = r9;
        Context r10 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.appContext = r10;
        this.callback = (IMultiInstanceInvalidationCallback) ZeusTransformUtils.preCheckCast(new MultiInstanceInvalidationClient$callback$1(this), IMultiInstanceInvalidationCallback.class, "com.obric.memorydata.plugin");
        this.stopped = new AtomicBoolean(false);
        ServiceConnection r11 = (ServiceConnection) ZeusTransformUtils.preCheckCast(new MultiInstanceInvalidationClient$serviceConnection$1(this), ServiceConnection.class, "com.obric.memorydata.plugin");
        this.serviceConnection = r11;
        this.setUpRunnable = new $$Lambda$MultiInstanceInvalidationClient$OUFtvTStWETjeJxrBwS2HtXq3VE(this);
        this.removeObserverRunnable = new $$Lambda$MultiInstanceInvalidationClient$at7cvPuqmY8Y6FAv2N0cZPhRid0(this);
        Object[] r12 = ((Collection) ZeusTransformUtils.preCheckCast(r6.getTableIdLookup$room_runtime_release().keySet(), Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        final String[] r13 = (String[]) ZeusTransformUtils.preCheckCast(r12, String[].class, "com.obric.memorydata.plugin");
        setObserver((InvalidationTracker.Observer) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, r13), InvalidationTracker.Observer.class, "com.obric.memorydata.plugin"));
        ZeusTransformUtils.bindService(r10, r5, r11, 1, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ void lambda$OUFtvTStWETjeJxrBwS2HtXq3VE(MultiInstanceInvalidationClient r0) {
        setUpRunnable$lambda$1(r0);
    }

    public static /* synthetic */ void lambda$at7cvPuqmY8Y6FAv2N0cZPhRid0(MultiInstanceInvalidationClient r0) {
        removeObserverRunnable$lambda$2(r0);
    }

    private static final void removeObserverRunnable$lambda$2(MultiInstanceInvalidationClient r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.invalidationTracker.removeObserver(r1.getObserver());
    }

    private static final void setUpRunnable$lambda$1(MultiInstanceInvalidationClient r3) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        IMultiInstanceInvalidationService r0 = r3.service;     // Catch: RemoteException -> L7
        if (r0 == null) goto L12;
        r3.clientId = r0.registerCallback(r3.callback, r3.name);     // Catch: RemoteException -> L7
        r3.invalidationTracker.addObserver(r3.getObserver());     // Catch: RemoteException -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        Log.w(Room.LOG_TAG, "Cannot register multi-instance invalidation callback", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
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
        InvalidationTracker.Observer r0 = this.observer;
        if (r0 == null) goto L5;
        return r0;
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

    public final void setClientId(int r1) {
        this.clientId = r1;
    }

    public final void setObserver(InvalidationTracker.Observer r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.observer = r2;
    }

    public final void setService(IMultiInstanceInvalidationService r3) {
        this.service = (IMultiInstanceInvalidationService) ZeusTransformUtils.wrapperContextForParams(r3, IMultiInstanceInvalidationService.class, "com.obric.memorydata.plugin");
    }

    public final void stop() {
        if (this.stopped.compareAndSet(false, true) == false) goto L15;
        this.invalidationTracker.removeObserver(getObserver());
        IMultiInstanceInvalidationService r1 = this.service;     // Catch: RemoteException -> L9
        if (r1 == null) goto L11;
        r1.unregisterCallback(this.callback, this.clientId);     // Catch: RemoteException -> L9
    L11:
        ZeusTransformUtils.unbindService(this.appContext, this.serviceConnection, "com.obric.memorydata.plugin");
        return;
    L9:
        e = move-exception;
        Log.w(Room.LOG_TAG, "Cannot unregister multi-instance invalidation callback", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L11
    }
}
