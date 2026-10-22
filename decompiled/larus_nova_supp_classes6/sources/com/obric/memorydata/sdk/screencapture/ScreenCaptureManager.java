package com.obric.memorydata.sdk.screencapture;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.obric.capabilitykit.PackageUtils;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.memorydata.sdk.service.IScreenCaptureService;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u001c\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&H\u0007J\u000e\u0010'\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"J\u000e\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u0005J2\u0010)\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\n2\u0006\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020,2\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&H\u0007J4\u0010-\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\n2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00052\u0014\u0010#\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u000102\u0012\u0004\u0012\u00020\u001f01J0\u00103\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\"2\u0006\u0010+\u001a\u00020,2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J \u00104\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010+\u001a\u00020,2\u0006\u0010#\u001a\u00020$H\u0002J.\u00105\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00052\u0014\u0010#\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u000102\u0012\u0004\u0012\u00020\u001f01H\u0002J\u0018\u00106\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\n2\u0006\u0010%\u001a\u00020&H\u0003J\b\u00107\u001a\u00020\u001fH\u0002J\b\u00108\u001a\u00020\u001fH\u0002J\b\u00109\u001a\u00020\u001fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001d¨\u0006:"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/ScreenCaptureManager;", "", "<init>", "()V", "TAG", "", "SCREEN_CAPTURE_SERVICE", "service", "Lcom/obric/memorydata/sdk/service/IScreenCaptureService;", "appContext", "Landroid/content/Context;", "mainHandler", "Landroid/os/Handler;", "workHandler", "getWorkHandler", "()Landroid/os/Handler;", "workHandler$delegate", "Lkotlin/Lazy;", "isBound", "", "isBinding", "bindingLock", "pendingOperations", "", "Lcom/obric/memorydata/sdk/screencapture/PendingOperation;", "pendingCaptureOperations", "Lcom/obric/memorydata/sdk/screencapture/PendingCaptureOperation;", "connection", "com/obric/memorydata/sdk/screencapture/ScreenCaptureManager$connection$1", "Lcom/obric/memorydata/sdk/screencapture/ScreenCaptureManager$connection$1;", "register", "", "context", "screenEventReaction", "Lcom/obric/memorydata/sdk/screencapture/ScreenEventReaction;", "callback", "Lcom/obric/memorydata/sdk/screencapture/EventReactionCallback;", "bindFlag", "", "unregister", "reactionId", "registerOneShot", "reaction", "timeout", "", "captureCurrent", "taskOptions", "Lcom/obric/memorydata/sdk/screencapture/TaskOptions;", "targetPackage", "Lkotlin/Function1;", "Lcom/obric/memorydata/sdk/screencapture/ScreenData;", "registerInternal", "registerRemote", "captureCurrentRemote", "bindService", "unbindService", "autoUnbindServiceIfNeed", "drainPendingOperationsAsync", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class ScreenCaptureManager {
    public static final ScreenCaptureManager INSTANCE = null;
    private static final String SCREEN_CAPTURE_SERVICE = "com.obric.memorydata.action.SCREEN_CAPTURE_SERVICE";
    private static final String TAG = "ScreenCaptureManager";
    private static Context appContext;
    private static final Object bindingLock = null;
    private static final a connection = null;
    private static boolean isBinding;
    private static boolean isBound;
    private static Handler mainHandler;
    private static final List<d> pendingCaptureOperations = null;
    private static final List<e> pendingOperations = null;
    private static IScreenCaptureService service;
    private static final Lazy workHandler$delegate = null;

    public static final class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public final void onBindingDied(ComponentName r2) {
            if (r2 == null) goto L5;
            r2.getClassName();
        L5:
            super.onBindingDied(r2);
            ScreenCaptureManager.access$unbindService(ScreenCaptureManager.INSTANCE);     // Catch: Exception -> L16
        L7:
            Object r3 = ScreenCaptureManager.access$getBindingLock$p();
            monitor-enter(r3);
            ScreenCaptureManager.access$setService$p(null);     // Catch: Throwable -> L13
            ScreenCaptureManager.access$setBound$p(false);     // Catch: Throwable -> L13
            ScreenCaptureManager.access$setBinding$p(false);     // Catch: Throwable -> L13
            Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L13
            monitor-exit(r3);
            return;
        L13:
            th = move-exception;
            throw th;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r2) {
            if (r2 == null) goto L5;
            r2.getClassName();
        L5:
            Object r3 = ScreenCaptureManager.access$getBindingLock$p();
            monitor-enter(r3);
            ScreenCaptureManager.access$setService$p(null);     // Catch: Throwable -> L11
            ScreenCaptureManager.access$setBound$p(false);     // Catch: Throwable -> L11
            ScreenCaptureManager.access$setBinding$p(false);     // Catch: Throwable -> L11
            Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L11
            monitor-exit(r3);
            return;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r2, IBinder r3) {
            if (r2 == null) goto L5;
            r2.getClassName();
        L5:
            Object r4 = ScreenCaptureManager.access$getBindingLock$p();
            monitor-enter(r4);
            ScreenCaptureManager.access$setService$p(IScreenCaptureService.Stub.asInterface(r3));     // Catch: Throwable -> L10
            ScreenCaptureManager.access$setBound$p(true);     // Catch: Throwable -> L10
            ScreenCaptureManager.access$setBinding$p(false);     // Catch: Throwable -> L10
            ScreenCaptureManager.access$drainPendingOperationsAsync(ScreenCaptureManager.INSTANCE);     // Catch: Throwable -> L10
            Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L10
            monitor-exit(r4);
            return;
        L10:
            th = move-exception;
            throw th;
        }
    }

    private ScreenCaptureManager() {
    }

    public static /* synthetic */ Handler a() {
        return workHandler_delegate$lambda$0();
    }

    public static /* synthetic */ void b(Function0 r0) {
        captureCurrent$lambda$3$lambda$2$lambda$1(r0);
    }

    public static /* synthetic */ void c() {
        autoUnbindServiceIfNeed$lambda$12();
    }

    public static /* synthetic */ void d(d r0) {
        drainPendingOperationsAsync$lambda$18$lambda$17$lambda$16(r0);
    }

    public static /* synthetic */ Unit e(Function0 r0) {
        return captureCurrent$lambda$3$lambda$2(r0);
    }

    public static /* synthetic */ void f(List r0, List r1) {
        drainPendingOperationsAsync$lambda$18(r0, r1);
    }

    public static /* synthetic */ Unit g(Function0 r0) {
        return captureCurrentRemote$lambda$6(r0);
    }

    public static /* synthetic */ void h(Function0 r0) {
        captureCurrentRemote$lambda$6$lambda$5(r0);
    }

    public static /* synthetic */ Unit i() {
        return captureCurrentRemote$lambda$7();
    }

    public final void register(Context r9, ScreenEventReaction r10, c r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "screenEventReaction");
        Intrinsics.checkNotNullParameter(r11, "callback");
        register$default(this, r9, r10, r11, 0, 8, null);
    }

    public final void registerOneShot(Context r11, ScreenEventReaction r12, long r13, c r15) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "reaction");
        Intrinsics.checkNotNullParameter(r15, "callback");
        registerOneShot$default(this, r11, r12, r13, r15, 0, 16, null);
    }

    static {
        INSTANCE = new ScreenCaptureManager();
        mainHandler = new Handler(Looper.getMainLooper());
        workHandler$delegate = LazyKt.lazy(new j());
        bindingLock = new Object();
        pendingOperations = new ArrayList();
        pendingCaptureOperations = new ArrayList();
        connection = new a();
    }

    private final void autoUnbindServiceIfNeed() {
        mainHandler.post(new n());
    }

    private static final void autoUnbindServiceIfNeed$lambda$12() {
        Object r0 = bindingLock;
        monitor-enter(r0);
        int r1 = 0;
        IScreenCaptureService r2 = service;     // Catch: Throwable -> L9 Exception -> L11
        if (r2 == null) goto L12;
        r1 = r2.getScreenEventReactionCount();     // Catch: Throwable -> L9 Exception -> L11
    L9:
        th = move-exception;
        throw th;
    L12:
        if (r1 != 0) goto L14;
        INSTANCE.unbindService();     // Catch: Throwable -> L9
    L14:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r0);
    }

    private static final Unit captureCurrentRemote$lambda$7() {
        INSTANCE.autoUnbindServiceIfNeed();
        return Unit.INSTANCE;
    }

    private final void drainPendingOperationsAsync() {
        List<e> r0 = pendingOperations;
        if ((!r0.isEmpty()) == false) goto L5;
    L6:
        List r1 = CollectionsKt.toList(r0);
        r0.clear();
        List<d> r2 = pendingCaptureOperations;
        List r3 = CollectionsKt.toList(r2);
        r2.clear();
        getWorkHandler().post(new m(r1, r3));
        return;
    L5:
        if ((!pendingCaptureOperations.isEmpty()) == true) goto L6;
    }

    private final Handler getWorkHandler() {
        return (Handler) workHandler$delegate.getValue();
    }

    private final void unbindService() {
        if (isBound == false) goto L9;
        Context r0 = appContext;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("appContext");
        r0 = null;
    L7:
        r0.unbindService(connection);
        isBound = false;
        return;
    }

    private static final Handler workHandler_delegate$lambda$0() {
        PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2("screen_capture_worker");
        ThreadMethodProxy.start(r0);
        return new Handler(r0.getLooper());
    }

    public static final /* synthetic */ Object access$getBindingLock$p() {
        return bindingLock;
    }

    public static final /* synthetic */ Handler access$getMainHandler$p() {
        return mainHandler;
    }

    public static final /* synthetic */ void access$autoUnbindServiceIfNeed(ScreenCaptureManager r0) {
        r0.autoUnbindServiceIfNeed();
    }

    public static final /* synthetic */ void access$drainPendingOperationsAsync(ScreenCaptureManager r0) {
        r0.drainPendingOperationsAsync();
    }

    public static final /* synthetic */ void access$setBinding$p(boolean r0) {
        isBinding = r0;
    }

    public static final /* synthetic */ void access$setBound$p(boolean r0) {
        isBound = r0;
    }

    public static final /* synthetic */ void access$setService$p(IScreenCaptureService r0) {
        service = r0;
    }

    public static final /* synthetic */ void access$unbindService(ScreenCaptureManager r0) {
        r0.unbindService();
    }

    private static final Unit captureCurrent$lambda$3$lambda$2(final Function0 r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        mainHandler.post(new g(r2));
        return Unit.INSTANCE;
    }

    private static final void captureCurrent$lambda$3$lambda$2$lambda$1(Function0 r0) {
        r0.invoke();
    }

    private static final Unit captureCurrentRemote$lambda$6(final Function0 r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        mainHandler.post(new f(r2));
        return Unit.INSTANCE;
    }

    private static final void captureCurrentRemote$lambda$6$lambda$5(Function0 r0) {
        r0.invoke();
    }

    private static final void drainPendingOperationsAsync$lambda$18$lambda$17$lambda$16(d r1) {
        r1.c.invoke(null);
    }

    public final void unregister(String r2) {
        Intrinsics.checkNotNullParameter(r2, "reactionId");
        IScreenCaptureService r0 = service;
        if (r0 == null) goto L6;
        r0.unregister(r2);
    L6:
        autoUnbindServiceIfNeed();
    }

    public final void unregister(ScreenEventReaction r2) {
        Intrinsics.checkNotNullParameter(r2, "screenEventReaction");
        unregister(r2.a);
    }

    private final boolean bindService(Context r7, int r8) {
        Object r0 = bindingLock;
        monitor-enter(r0);
    L29:
        th = move-exception;
        throw th;
    L6:
        if (isBinding == false) goto L10;
        monitor-exit(r0);
        return false;
    L10:
        isBinding = true;     // Catch: Throwable -> L29
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L29
        monitor-exit(r0);
        Intent r4 = new Intent(SCREEN_CAPTURE_SERVICE);
        if (Intrinsics.areEqual("com.obric.memorydata", r7.getPackageName()) == false) goto L15;
        String r5 = "com.obric.memorydata";
    L16:
        r4.setPackage(r5);
        boolean r9 = r7.bindService(r4, connection, r8 | 1);
        if (r9 == true) goto L28;
        ComponentName r10 = r4.getComponent();
        if (r10 == null) goto L21;
        r10.getShortClassName();
    L21:
        monitor-enter(r0);
        isBinding = false;     // Catch: Throwable -> L25
        monitor-exit(r0);
    L25:
        th = move-exception;
        throw th;
    L28:
        return r9;
    L15:
        r5 = PackageUtils.NOVA_PKG_NAME;
        goto L16
    }

    private static final void drainPendingOperationsAsync$lambda$18(List r5, List r6) {
        Iterator r7 = r5.iterator();
    L4:
        if (r7.hasNext() == false) goto L9;
        e r0 = (e) r7.next();
        INSTANCE.registerRemote(r0.a, r0.b, null);     // Catch: Exception -> L8
        goto L4
    L9:
        Iterator r8 = r6.iterator();
    L11:
        if (r8.hasNext() == false) goto L16;
        d r9 = (d) r8.next();
        INSTANCE.captureCurrentRemote(r9.a, r9.b, r9.c);     // Catch: Exception -> L15
    L15:
        mainHandler.post(new l(r9));
        goto L11
    }

    private final void captureCurrentRemote(TaskOptions r4, String r5, Function1<? super ScreenData, Unit> r6) {
        final b r0 = new b(new h(), r6, new i());
        final ScreenData r7 = null;
        IScreenCaptureService r1 = service;     // Catch: Exception -> L8
        if (r1 == null) goto L6;
        r1.captureCurrent(r4, r5, new captureCurrentRemote.1(r0));     // Catch: Exception -> L8
    L10:
        return;
    L6:
        r0.a.invoke(new com.obric.memorydata.sdk.screencapture.a(r0, r7));     // Catch: Exception -> L8
    L8:
        r0.a.invoke(new com.obric.memorydata.sdk.screencapture.a(r0, r7));
    }

    private final void registerRemote(ScreenEventReaction r4, long r5, c r7) {
        boolean r0 = Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());
        IScreenCaptureService r1 = service;
        if (r1 == null) goto L5;
        r1.register(r4, r5, new registerRemote.1(r0, r7));
        return;
    L5:
        String r6 = r4.a;
    }

    public final void captureCurrent(Context r3, TaskOptions r4, String r5, Function1<? super ScreenData, Unit> r6) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "taskOptions");
        Intrinsics.checkNotNullParameter(r5, "targetPackage");
        Intrinsics.checkNotNullParameter(r6, "callback");
        appContext = r3.getApplicationContext();
        Object r7 = bindingLock;
        monitor-enter(r7);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (isBound == false) goto L7;
        INSTANCE.captureCurrentRemote(r4, r5, r6);     // Catch: Throwable -> L19
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L19
    L17:
        monitor-exit(r7);
        return;
    L7:
        d r1 = new d(r4, r5, r6);     // Catch: Throwable -> L19
        List<d> r9 = pendingCaptureOperations;     // Catch: Throwable -> L19
        r9.add(r1);     // Catch: Throwable -> L19
        if (isBinding == true) goto L16;
        ScreenCaptureManager r10 = INSTANCE;     // Catch: Throwable -> L19
        Context r11 = appContext;     // Catch: Throwable -> L19
        if (r11 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("appContext");     // Catch: Throwable -> L19
        r11 = null;
    L13:
        if (r10.bindService(r11, 64) == true) goto L15;
        k r12 = new k();     // Catch: Throwable -> L19
        Intrinsics.checkNotNullParameter(r9, "pendingCaptureOperations");     // Catch: Throwable -> L19
        Intrinsics.checkNotNullParameter(r1, "operation");     // Catch: Throwable -> L19
        Intrinsics.checkNotNullParameter(r12, "post");     // Catch: Throwable -> L19
        r9.remove(r1);     // Catch: Throwable -> L19
        r12.invoke(new q(r1));     // Catch: Throwable -> L19
    L15:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L19
        goto L17
    L16:
        new StringBuilder("Service binding in progress, queued captureCurrent for package: ").append(r5);     // Catch: Throwable -> L19
        goto L17
    }

    public final void register(Context r9, ScreenEventReaction r10, c r11, int r12) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "screenEventReaction");
        Intrinsics.checkNotNullParameter(r11, "callback");
        registerInternal(r9, r10, 0, r11, r12);
    }

    private final void registerInternal(Context r2, ScreenEventReaction r3, long r4, c r6, int r7) {
        appContext = r2.getApplicationContext();
        Object r5 = bindingLock;
        monitor-enter(r5);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (isBound == false) goto L8;
        INSTANCE.registerRemote(r3, r4, r6);     // Catch: Throwable -> L16
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L16
    L14:
        monitor-exit(r5);
        return;
    L8:
        if (isBinding == true) goto L13;
        e r9 = new e(r3, r4);     // Catch: Throwable -> L16
        pendingOperations.add(r9);     // Catch: Throwable -> L16
        ScreenCaptureManager r10 = INSTANCE;     // Catch: Throwable -> L16
        Context r11 = appContext;     // Catch: Throwable -> L16
        if (r11 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("appContext");     // Catch: Throwable -> L16
        r11 = null;
    L12:
        r10.bindService(r11, r7);     // Catch: Throwable -> L16
        goto L14
    L13:
        e r12 = new e(r3, r4);     // Catch: Throwable -> L16
        pendingOperations.add(r12);     // Catch: Throwable -> L16
        String r13 = r3.a;     // Catch: Throwable -> L16
        goto L14
    }

    public final void registerOneShot(Context r2, ScreenEventReaction r3, long r4, c r6, int r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "reaction");
        Intrinsics.checkNotNullParameter(r6, "callback");
        registerInternal(r2, r3, r4, r6, r7);
    }

    public static /* synthetic */ void register$default(ScreenCaptureManager r0, Context r1, ScreenEventReaction r2, c r3, int r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = 64;
    L5:
        r0.register(r1, r2, r3, r4);
    }

    public static /* synthetic */ void registerOneShot$default(ScreenCaptureManager r7, Context r8, ScreenEventReaction r9, long r10, c r12, int r13, int r14, Object r15) {
        if ((r14 & 16) == 0) goto L5;
        int r6 = 64;
    L6:
        r7.registerOneShot(r8, r9, r10, r12, r6);
        return;
    L5:
        r6 = r13;
        goto L6
    }
}
