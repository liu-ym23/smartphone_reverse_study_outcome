package com.obric.sva.sdk.ipc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.keepalive.ObricKeepAliveLevelController;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.memorydata.plugin_api.BuildConfig;
import com.obric.sva.sdk.utils.LogUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0016J\u0006\u0010\"\u001a\u00020 J\b\u0010#\u001a\u00020 H\u0002J\u0010\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020\u0005H\u0002J\u0010\u0010&\u001a\u00020 2\u0006\u0010%\u001a\u00020\u0005H\u0002J\u0010\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\fH\u0002J\u0018\u0010)\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\f2\u0006\u0010*\u001a\u00020\u001aH\u0002J\u0010\u0010+\u001a\u00020 2\u0006\u0010%\u001a\u00020\u0005H\u0002J\u0010\u0010,\u001a\u00020 2\u0006\u0010%\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/obric/sva/sdk/ipc/MainProcessKeepAliveBinder;", "", "<init>", "()V", "TAG", "", "START_NOVA_SERVICE_CLASS", "ACTION_START_NOVA_SERVICE", "EXTRA_CALLER", "EXTRA_REASON", "CALLER_WAKEUP_INTERACTOR_KEEP_ALIVE", "REBIND_DELAY_MS", "", "workerThread", "Landroid/os/HandlerThread;", "workerHandler", "Landroid/os/Handler;", "getWorkerHandler", "()Landroid/os/Handler;", "workerHandler$delegate", "Lkotlin/Lazy;", "context", "Landroid/content/Context;", "isBound", "", "activeConnection", "Landroid/content/ServiceConnection;", "listenerRegistered", "lifecycleGeneration", "rebindRunnable", "Ljava/lang/Runnable;", "init", "", "appContext", BuildConfig.BUILD_TYPE, "registerLevelChangeListenerIfNeeded", "evaluateOnWorker", MainProcessKeepAliveBinder.EXTRA_REASON, "bindOnWorker", "createServiceConnection", "generation", "isCurrentConnection", "connection", "unbindOnWorker", "scheduleRebindIfNeeded", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class MainProcessKeepAliveBinder {
    private static final String ACTION_START_NOVA_SERVICE = "com.obric.assistant.action.START_NOVA_SERVICE";
    private static final String CALLER_WAKEUP_INTERACTOR_KEEP_ALIVE = "wakeup_interactor_keep_alive";
    private static final String EXTRA_CALLER = "caller";
    private static final String EXTRA_REASON = "reason";
    public static final MainProcessKeepAliveBinder INSTANCE = null;
    private static final long REBIND_DELAY_MS = 5000;
    private static final String START_NOVA_SERVICE_CLASS = "com.obric.assistant.processesmanager.ObricStartNovaService";
    private static final String TAG = "MainProcessKeepAliveBinder";
    private static volatile ServiceConnection activeConnection;
    private static volatile Context context;
    private static volatile boolean isBound;
    private static volatile long lifecycleGeneration;
    private static volatile boolean listenerRegistered;
    private static final Runnable rebindRunnable = null;
    private static final Lazy workerHandler$delegate = null;
    private static final HandlerThread workerThread = null;

    /* JADX INFO: renamed from: com.obric.sva.sdk.ipc.MainProcessKeepAliveBinder$createServiceConnection$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u000b"}, d2 = {"com/obric/sva/sdk/ipc/MainProcessKeepAliveBinder$createServiceConnection$1", "Landroid/content/ServiceConnection;", "onServiceConnected", "", "name", "Landroid/content/ComponentName;", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "onBindingDied", "onNullBinding", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class AnonymousClass1 implements ServiceConnection {
        final /* synthetic */ long $generation;

        public static /* synthetic */ void a(long r0, AnonymousClass1 r2, ComponentName r3) {
            onNullBinding$lambda$3(r0, r2, r3);
        }

        public static /* synthetic */ void b(long r0, AnonymousClass1 r2, ComponentName r3) {
            onBindingDied$lambda$2(r0, r2, r3);
        }

        public static /* synthetic */ void c(long r0, AnonymousClass1 r2, ComponentName r3) {
            onServiceDisconnected$lambda$1(r0, r2, r3);
        }

        public static /* synthetic */ void d(long r0, AnonymousClass1 r2, ComponentName r3) {
            onServiceConnected$lambda$0(r0, r2, r3);
        }

        public AnonymousClass1(long r1) {
            this.$generation = r1;
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName r5) {
            MainProcessKeepAliveBinder.access$getWorkerHandler(MainProcessKeepAliveBinder.INSTANCE).post(new g(this.$generation, this, r5));
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName r5) {
            MainProcessKeepAliveBinder.access$getWorkerHandler(MainProcessKeepAliveBinder.INSTANCE).post(new i(this.$generation, this, r5));
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r5) {
            MainProcessKeepAliveBinder.access$getWorkerHandler(MainProcessKeepAliveBinder.INSTANCE).post(new h(this.$generation, this, r5));
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(final ComponentName r4, IBinder r5) {
            Handler r6 = MainProcessKeepAliveBinder.access$getWorkerHandler(MainProcessKeepAliveBinder.INSTANCE);
            final long r0 = this.$generation;
            r6.post(new j(r0, this, r4));
        }

        private static final void onBindingDied$lambda$2(long r5, AnonymousClass1 r7, ComponentName r8) {
            MainProcessKeepAliveBinder r0 = MainProcessKeepAliveBinder.INSTANCE;
            if (MainProcessKeepAliveBinder.access$isCurrentConnection(r0, r5, r7) == true) goto L6;
            LogUtils.i(MainProcessKeepAliveBinder.TAG, "ignore stale onBindingDied name=" + r8 + " generation=" + r5 + " current=" + MainProcessKeepAliveBinder.access$getLifecycleGeneration$p(), new Object[0]);
            return;
        L6:
            LogUtils.w(MainProcessKeepAliveBinder.TAG, "onBindingDied name=" + r8 + " generation=" + r5, new Object[0]);
            MainProcessKeepAliveBinder.access$unbindOnWorker(r0, "binding_died");
            MainProcessKeepAliveBinder.access$scheduleRebindIfNeeded(r0, "binding_died");
        }

        private static final void onNullBinding$lambda$3(long r5, AnonymousClass1 r7, ComponentName r8) {
            MainProcessKeepAliveBinder r0 = MainProcessKeepAliveBinder.INSTANCE;
            if (MainProcessKeepAliveBinder.access$isCurrentConnection(r0, r5, r7) == true) goto L6;
            LogUtils.i(MainProcessKeepAliveBinder.TAG, "ignore stale onNullBinding name=" + r8 + " generation=" + r5 + " current=" + MainProcessKeepAliveBinder.access$getLifecycleGeneration$p(), new Object[0]);
            return;
        L6:
            LogUtils.w(MainProcessKeepAliveBinder.TAG, "onNullBinding name=" + r8 + " generation=" + r5, new Object[0]);
            MainProcessKeepAliveBinder.access$unbindOnWorker(r0, "null_binding");
        }

        private static final void onServiceConnected$lambda$0(long r4, AnonymousClass1 r6, ComponentName r7) {
            if (MainProcessKeepAliveBinder.access$isCurrentConnection(MainProcessKeepAliveBinder.INSTANCE, r4, r6) == true) goto L6;
            LogUtils.i(MainProcessKeepAliveBinder.TAG, "ignore stale onServiceConnected name=" + r7 + " generation=" + r4 + " current=" + MainProcessKeepAliveBinder.access$getLifecycleGeneration$p(), new Object[0]);
            return;
        L6:
            LogUtils.i(MainProcessKeepAliveBinder.TAG, "onServiceConnected name=" + r7 + " generation=" + r4, new Object[0]);
        }

        private static final void onServiceDisconnected$lambda$1(long r4, AnonymousClass1 r6, ComponentName r7) {
            if (MainProcessKeepAliveBinder.access$isCurrentConnection(MainProcessKeepAliveBinder.INSTANCE, r4, r6) == true) goto L6;
            LogUtils.i(MainProcessKeepAliveBinder.TAG, "ignore stale onServiceDisconnected name=" + r7 + " generation=" + r4 + " current=" + MainProcessKeepAliveBinder.access$getLifecycleGeneration$p(), new Object[0]);
            return;
        L6:
            LogUtils.w(MainProcessKeepAliveBinder.TAG, "onServiceDisconnected name=" + r7 + " generation=" + r4, new Object[0]);
        }
    }

    private MainProcessKeepAliveBinder() {
    }

    public static /* synthetic */ Unit a(String r0) {
        return registerLevelChangeListenerIfNeeded$lambda$7$lambda$6(r0);
    }

    public static /* synthetic */ void b(String r0) {
        registerLevelChangeListenerIfNeeded$lambda$7$lambda$6$lambda$5(r0);
    }

    public static /* synthetic */ Handler c() {
        return workerHandler_delegate$lambda$0();
    }

    public static /* synthetic */ void d(long r0, Context r2) {
        init$lambda$3(r0, r2);
    }

    public static /* synthetic */ void e() {
        rebindRunnable$lambda$1();
    }

    public static /* synthetic */ void f(long r0) {
        release$lambda$4(r0);
    }

    static {
        INSTANCE = new MainProcessKeepAliveBinder();
        workerThread = new PthreadHandlerThreadV2("main-process-keep-alive-binder");
        workerHandler$delegate = LazyKt.lazy(new c());
        rebindRunnable = new d();
    }

    private final Handler getWorkerHandler() {
        return (Handler) workerHandler$delegate.getValue();
    }

    private static final void rebindRunnable$lambda$1() {
        INSTANCE.evaluateOnWorker("rebind_delay");
    }

    private final void registerLevelChangeListenerIfNeeded() {
        if (listenerRegistered == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (listenerRegistered == false) goto L11;
        monitor-exit(this);
        return;
    L11:
        listenerRegistered = true;     // Catch: Throwable -> L14
        ObricKeepAliveLevelController r0 = ObricKeepAliveLevelController.a;     // Catch: Throwable -> L14
        Function1<String, Unit> r1 = new a();     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter(r1, "listener");     // Catch: Throwable -> L14
        ObricKeepAliveLevelController.e.add(r1);     // Catch: Throwable -> L14
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(this);
    }

    private static final Handler workerHandler_delegate$lambda$0() {
        HandlerThread r0 = workerThread;
        if (ThreadMethodProxy.isAlive(r0) == true) goto L6;
        ThreadMethodProxy.start(r0);
    L6:
        return new Handler(r0.getLooper());
    }

    public final void release() {
        long r0 = lifecycleGeneration;
        getWorkerHandler().post(new b(r0));
    }

    public static final /* synthetic */ long access$getLifecycleGeneration$p() {
        return lifecycleGeneration;
    }

    public static final /* synthetic */ Handler access$getWorkerHandler(MainProcessKeepAliveBinder r0) {
        return r0.getWorkerHandler();
    }

    private final void bindOnWorker(String r8) {
        Context r0 = context;
        if (r0 != null) goto L6;
        return;
    L6:
        if (isBound == false) goto L9;
        LogUtils.i(TAG, "bind skipped: already bound reason=" + r8, new Object[0]);
        return;
    L9:
        ServiceConnection r1 = createServiceConnection(lifecycleGeneration);
        Intent r4 = new Intent();
        r4.setClassName(r0.getPackageName(), START_NOVA_SERVICE_CLASS);
        r4.setAction(ACTION_START_NOVA_SERVICE);
        r4.putExtra(EXTRA_CALLER, CALLER_WAKEUP_INTERACTOR_KEEP_ALIVE);
        r4.putExtra(EXTRA_REASON, r8);
        activeConnection = r1;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L12
        Object r2 = Result.constructor-impl(Boolean.valueOf(r0.bindService(r4, r1, 65)));     // Catch: Throwable -> L12
    L14:
        Throwable r6 = Result.exceptionOrNull-impl(r2);
        if (r6 == null) goto L19;
        LogUtils.e(TAG, "bind failed reason=" + r8 + " error=" + r6.getMessage(), new Object[0]);
        if (activeConnection != r1) goto L19;
        activeConnection = null;
    L19:
        Boolean r3 = Boolean.FALSE;
        if (Result.isFailure-impl(r2) == false) goto L22;
        r2 = r3;
    L22:
        isBound = ((Boolean) r2).booleanValue();
        LogUtils.i(TAG, "bind result=" + isBound + " reason=" + r8 + " flags=AUTO_CREATE|IMPORTANT", new Object[0]);
        if (isBound == true) goto L28;
        scheduleRebindIfNeeded("bind_failed");
        return;
    L28:
        return;
    L12:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    private final ServiceConnection createServiceConnection(long r2) {
        return new AnonymousClass1(r2);
    }

    private final void evaluateOnWorker(String r3) {
        ObricKeepAliveLevelController r0 = ObricKeepAliveLevelController.a;
        String r1 = ObricKeepAliveLevelController.c;
        if (r1 != null) goto L6;
        r1 = ObricFeatureServiceDelegate.b.f();
    L6:
        if (Intrinsics.areEqual(r1, "HighLevel") == false) goto L8;
        bindOnWorker(r3);
        return;
    L8:
        getWorkerHandler().removeCallbacks(rebindRunnable);
        unbindOnWorker(r3);
    }

    private static final Unit registerLevelChangeListenerIfNeeded$lambda$7$lambda$6(String r2) {
        Intrinsics.checkNotNullParameter(r2, "level");
        INSTANCE.getWorkerHandler().post(new e(r2));
        return Unit.INSTANCE;
    }

    private static final void registerLevelChangeListenerIfNeeded$lambda$7$lambda$6$lambda$5(String r2) {
        LogUtils.i(TAG, "keep alive level changed level=" + r2, new Object[0]);
        INSTANCE.evaluateOnWorker("level_changed");
    }

    private static final void release$lambda$4(long r3) {
        if (lifecycleGeneration == r3) goto L6;
        LogUtils.i(TAG, "release skipped: stale generation=" + r3 + " current=" + lifecycleGeneration, new Object[0]);
        return;
    L6:
        MainProcessKeepAliveBinder r4 = INSTANCE;
        r4.getWorkerHandler().removeCallbacks(rebindRunnable);
        r4.unbindOnWorker(BuildConfig.BUILD_TYPE);
        context = null;
    }

    private final void scheduleRebindIfNeeded(String r7) {
        ObricKeepAliveLevelController r0 = ObricKeepAliveLevelController.a;
        String r1 = ObricKeepAliveLevelController.c;
        if (r1 != null) goto L6;
        r1 = ObricFeatureServiceDelegate.b.f();
    L6:
        if (Intrinsics.areEqual(r1, "HighLevel") == true) goto L9;
        LogUtils.i(TAG, "skip rebind reason=" + r7 + ", effective level is not high", new Object[0]);
        return;
    L9:
        Handler r2 = getWorkerHandler();
        Runnable r3 = rebindRunnable;
        r2.removeCallbacks(r3);
        getWorkerHandler().postDelayed(r3, REBIND_DELAY_MS);
        LogUtils.i(TAG, "schedule rebind reason=" + r7 + " delayMs=5000", new Object[0]);
    }

    private final void unbindOnWorker(String r6) {
        if (isBound == true) goto L5;
        return;
    L5:
        Context r0 = context;
        ServiceConnection r1 = activeConnection;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L12
        if (r0 == null) goto L10;
        if (r1 == null) goto L10;
        r0.unbindService(r1);     // Catch: Throwable -> L12
    L10:
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L17;
        LogUtils.e(TAG, "unbind failed reason=" + r6 + " error=" + r4.getMessage(), new Object[0]);
    L17:
        isBound = false;
        activeConnection = null;
        LogUtils.i(TAG, "unbind reason=" + r6, new Object[0]);
        return;
    L12:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public final void init(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "appContext");
        final Context r6 = r5.getApplicationContext();
        monitor-enter(this);
        lifecycleGeneration++;     // Catch: Throwable -> L8
        final long r0 = lifecycleGeneration;     // Catch: Throwable -> L8
        monitor-exit(this);
        registerLevelChangeListenerIfNeeded();
        getWorkerHandler().post(new f(r0, r6));
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static final /* synthetic */ void access$scheduleRebindIfNeeded(MainProcessKeepAliveBinder r0, String r1) {
        r0.scheduleRebindIfNeeded(r1);
    }

    public static final /* synthetic */ void access$unbindOnWorker(MainProcessKeepAliveBinder r0, String r1) {
        r0.unbindOnWorker(r1);
    }

    private static final void init$lambda$3(long r3, Context r5) {
        if (lifecycleGeneration == r3) goto L6;
        LogUtils.i(TAG, "init skipped: stale generation=" + r3 + " current=" + lifecycleGeneration, new Object[0]);
        return;
    L6:
        context = r5;
        INSTANCE.evaluateOnWorker("init");
    }

    private final boolean isCurrentConnection(long r4, ServiceConnection r6) {
        if (lifecycleGeneration == r4) goto L5;
    L7:
        return false;
    L5:
        if (activeConnection != r6) goto L7;
        return true;
    }

    public static final /* synthetic */ boolean access$isCurrentConnection(MainProcessKeepAliveBinder r0, long r1, ServiceConnection r3) {
        return r0.isCurrentConnection(r1, r3);
    }
}
