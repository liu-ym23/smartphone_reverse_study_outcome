package com.obric.memorydata.sdk.screencapture;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.sdk.screencapture.event.ScreenEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
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

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u001c\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&H\u0007J\u000e\u0010'\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"J\u000e\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u0005J2\u0010)\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\n2\u0006\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020,2\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&H\u0007J4\u0010-\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\n2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00052\u0014\u0010#\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u000102\u0012\u0004\u0012\u00020\u001f01J0\u00103\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\"2\u0006\u0010+\u001a\u00020,2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J \u00104\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010+\u001a\u00020,2\u0006\u0010#\u001a\u00020$H\u0002J.\u00105\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00052\u0014\u0010#\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u000102\u0012\u0004\u0012\u00020\u001f01H\u0002J\u0018\u00106\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\n2\u0006\u0010%\u001a\u00020&H\u0003J\b\u00107\u001a\u00020\u001fH\u0002J\b\u00108\u001a\u00020\u001fH\u0002J\b\u00109\u001a\u00020\u001fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001d¨\u0006:"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/ScreenCaptureManager;", "", "<init>", "()V", "TAG", "", "SCREEN_CAPTURE_SERVICE", "service", "Lcom/obric/memorydata/sdk/service/IScreenCaptureService;", "appContext", "Landroid/content/Context;", "mainHandler", "Landroid/os/Handler;", "workHandler", "getWorkHandler", "()Landroid/os/Handler;", "workHandler$delegate", "Lkotlin/Lazy;", "isBound", "", "isBinding", "bindingLock", "pendingOperations", "", "Lcom/obric/memorydata/sdk/screencapture/PendingOperation;", "pendingCaptureOperations", "Lcom/obric/memorydata/sdk/screencapture/PendingCaptureOperation;", WsConstants.KEY_CONNECTION, "com/obric/memorydata/sdk/screencapture/ScreenCaptureManager$connection$1", "Lcom/obric/memorydata/sdk/screencapture/ScreenCaptureManager$connection$1;", "register", "", "context", "screenEventReaction", "Lcom/obric/memorydata/sdk/screencapture/ScreenEventReaction;", "callback", "Lcom/obric/memorydata/sdk/screencapture/EventReactionCallback;", "bindFlag", "", "unregister", "reactionId", "registerOneShot", "reaction", LocationMonitorConst.TIMEOUT, "", "captureCurrent", "taskOptions", "Lcom/obric/memorydata/sdk/screencapture/TaskOptions;", "targetPackage", "Lkotlin/Function1;", "Lcom/obric/memorydata/sdk/screencapture/ScreenData;", "registerInternal", "registerRemote", "captureCurrentRemote", "bindService", "unbindService", "autoUnbindServiceIfNeed", "drainPendingOperationsAsync", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScreenCaptureManager {
    public static final ScreenCaptureManager INSTANCE = null;
    private static final String SCREEN_CAPTURE_SERVICE = "com.obric.memorydata.action.SCREEN_CAPTURE_SERVICE";
    private static final String TAG = "ScreenCaptureManager";
    private static Context appContext;
    private static final Object bindingLock = null;
    private static final b connection = null;
    private static boolean isBinding;
    private static boolean isBound;
    private static Handler mainHandler;
    private static final List<e> pendingCaptureOperations = null;
    private static final List<f> pendingOperations = null;
    private static com.obric.memorydata.sdk.service.b service;
    private static final Lazy workHandler$delegate = null;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"com/obric/memorydata/sdk/screencapture/ScreenCaptureManager$captureCurrentRemote$1", "Lcom/obric/memorydata/sdk/screencapture/ICaptureCurrentCallback$Stub;", "onCaptured", "", "data", "Lcom/obric/memorydata/sdk/screencapture/ScreenData;", "onError", "errorCode", "", "errorMessage", "", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends com.obric.memorydata.sdk.screencapture.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.obric.memorydata.sdk.screencapture.a f12841a;

        a(com.obric.memorydata.sdk.screencapture.a r1) {
            this.f12841a = r1;
        }

        @Override // com.obric.memorydata.sdk.screencapture.c
        public void a(int r3, String r4) {
            Log.w(ScreenCaptureManager.TAG, "captureCurrent error code=" + r3 + " message=" + r4);
            this.f12841a.a(null);
        }

        @Override // com.obric.memorydata.sdk.screencapture.c
        public void a(ScreenData r1) {
            this.f12841a.a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\n"}, d2 = {"com/obric/memorydata/sdk/screencapture/ScreenCaptureManager$connection$1", "Landroid/content/ServiceConnection;", "onServiceConnected", "", ActivityLifecycle.NAME, "Landroid/content/ComponentName;", "binder", "Landroid/os/IBinder;", "onServiceDisconnected", "onBindingDied", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements ServiceConnection {
        b() {
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName r5) {
            StringBuilder r1 = new StringBuilder().append("onBindingDied: name=");
            if (r5 == null) goto L5;
            String r3 = r5.getClassName();
        L6:
            Log.w(ScreenCaptureManager.TAG, r1.append(r3).toString());
            super.onBindingDied(r5);
            ScreenCaptureManager.access$unbindService(ScreenCaptureManager.INSTANCE);     // Catch: Exception -> L9
        L11:
            Object r4 = ScreenCaptureManager.access$getBindingLock$p();
            monitor-enter(r4);
            ScreenCaptureManager r6 = ScreenCaptureManager.INSTANCE;     // Catch: Throwable -> L16
            ScreenCaptureManager.access$setService$p(null);     // Catch: Throwable -> L16
            ScreenCaptureManager r7 = ScreenCaptureManager.INSTANCE;     // Catch: Throwable -> L16
            ScreenCaptureManager.access$setBound$p(false);     // Catch: Throwable -> L16
            ScreenCaptureManager r0 = ScreenCaptureManager.INSTANCE;     // Catch: Throwable -> L16
            ScreenCaptureManager.access$setBinding$p(false);     // Catch: Throwable -> L16
            Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L16
            monitor-exit(r4);
            return;
        L16:
            th = move-exception;
            throw th;
        L9:
            e = move-exception;
            Log.e(ScreenCaptureManager.TAG, "Failed to unbind service", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
            goto L11
        L5:
            r3 = null;
            goto L6
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r3, IBinder r4) {
            IBinder r2 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r4, IBinder.class, "com.obric.memorydata.plugin");
            StringBuilder r0 = new StringBuilder().append("onServiceConnected: name=");
            if (r3 == null) goto L5;
            String r5 = r3.getClassName();
        L6:
            Log.i(ScreenCaptureManager.TAG, r0.append(r5).toString());
            Object r6 = ScreenCaptureManager.access$getBindingLock$p();
            monitor-enter(r6);
            ScreenCaptureManager r7 = ScreenCaptureManager.INSTANCE;     // Catch: Throwable -> L11
            ScreenCaptureManager.access$setService$p(com.obric.memorydata.sdk.service.b.a.a(r2));     // Catch: Throwable -> L11
            ScreenCaptureManager r8 = ScreenCaptureManager.INSTANCE;     // Catch: Throwable -> L11
            ScreenCaptureManager.access$setBound$p(true);     // Catch: Throwable -> L11
            ScreenCaptureManager r9 = ScreenCaptureManager.INSTANCE;     // Catch: Throwable -> L11
            ScreenCaptureManager.access$setBinding$p(false);     // Catch: Throwable -> L11
            ScreenCaptureManager.access$drainPendingOperationsAsync(ScreenCaptureManager.INSTANCE);     // Catch: Throwable -> L11
            Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L11
            monitor-exit(r6);
            return;
        L11:
            th = move-exception;
            throw th;
        L5:
            r5 = null;
            goto L6
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r3) {
            StringBuilder r0 = new StringBuilder().append("onServiceDisconnected: name=");
            if (r3 == null) goto L5;
            String r4 = r3.getClassName();
        L6:
            Log.w(ScreenCaptureManager.TAG, r0.append(r4).toString());
            Object r2 = ScreenCaptureManager.access$getBindingLock$p();
            monitor-enter(r2);
            ScreenCaptureManager r5 = ScreenCaptureManager.INSTANCE;     // Catch: Throwable -> L11
            ScreenCaptureManager.access$setService$p(null);     // Catch: Throwable -> L11
            ScreenCaptureManager r6 = ScreenCaptureManager.INSTANCE;     // Catch: Throwable -> L11
            ScreenCaptureManager.access$setBound$p(false);     // Catch: Throwable -> L11
            ScreenCaptureManager r1 = ScreenCaptureManager.INSTANCE;     // Catch: Throwable -> L11
            ScreenCaptureManager.access$setBinding$p(false);     // Catch: Throwable -> L11
            Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L11
            monitor-exit(r2);
            return;
        L11:
            th = move-exception;
            throw th;
        L5:
            r4 = null;
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"com/obric/memorydata/sdk/screencapture/ScreenCaptureManager$registerRemote$1", "Lcom/obric/memorydata/sdk/screencapture/IEventReactionCallback$Stub;", "onEvent", "", "event", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent;", "data", "Lcom/obric/memorydata/sdk/screencapture/ScreenData;", "onError", "errorCode", "", "errorMessage", "", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f12842a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.memorydata.sdk.screencapture.b f12843b;

        c(boolean r3, com.obric.memorydata.sdk.screencapture.b r4) {
            com.obric.memorydata.sdk.screencapture.b r5 = (com.obric.memorydata.sdk.screencapture.b) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.memorydata.sdk.screencapture.b.class, "com.obric.memorydata.plugin");
            this.f12842a = r3;
            this.f12843b = r5;
        }

        private static final void a(com.obric.memorydata.sdk.screencapture.b r2, int r3, String r4) {
            ((com.obric.memorydata.sdk.screencapture.b) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.memorydata.sdk.screencapture.b.class, "com.obric.memorydata.plugin")).a(r3, r4);
        }

        private static final void a(com.obric.memorydata.sdk.screencapture.b r2, ScreenEvent r3, ScreenData r4) {
            ((com.obric.memorydata.sdk.screencapture.b) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.memorydata.sdk.screencapture.b.class, "com.obric.memorydata.plugin")).a(r3, r4);
        }

        /* JADX INFO: renamed from: lambda$-IBLxn5zvdNEmMKKU24N5OqsU8w, reason: not valid java name */
        public static /* synthetic */ void m1184lambda$IBLxn5zvdNEmMKKU24N5OqsU8w(com.obric.memorydata.sdk.screencapture.b r0, int r1, String r2) {
            a(r0, r1, r2);
        }

        public static /* synthetic */ void lambda$T9L1kuvEnf7nUQVcgqcWqeH6sAw(com.obric.memorydata.sdk.screencapture.b r0, ScreenEvent r1, ScreenData r2) {
            a(r0, r1, r2);
        }

        @Override // com.obric.memorydata.sdk.screencapture.d
        public void a(final int r3, final String r4) {
            Intrinsics.checkNotNullParameter(r4, "errorMessage");
            if (this.f12842a == false) goto L5;
            Handler r0 = ScreenCaptureManager.access$getMainHandler$p();
            final com.obric.memorydata.sdk.screencapture.b r2 = this.f12843b;
            r0.post(new $$Lambda$ScreenCaptureManager$c$IBLxn5zvdNEmMKKU24N5OqsU8w(r2, r3, r4));
        L6:
            ScreenCaptureManager.access$autoUnbindServiceIfNeed(ScreenCaptureManager.INSTANCE);
            return;
        L5:
            this.f12843b.a(r3, r4);
            goto L6
        }

        @Override // com.obric.memorydata.sdk.screencapture.d
        public void a(final ScreenEvent r3, final ScreenData r4) {
            Intrinsics.checkNotNullParameter(r3, "event");
            Intrinsics.checkNotNullParameter(r4, "data");
            if (this.f12842a == false) goto L5;
            Handler r0 = ScreenCaptureManager.access$getMainHandler$p();
            final com.obric.memorydata.sdk.screencapture.b r2 = this.f12843b;
            r0.post(new $$Lambda$ScreenCaptureManager$c$T9L1kuvEnf7nUQVcgqcWqeH6sAw(r2, r3, r4));
        L6:
            ScreenCaptureManager.access$autoUnbindServiceIfNeed(ScreenCaptureManager.INSTANCE);
            return;
        L5:
            this.f12843b.a(r3, r4);
            goto L6
        }
    }

    static {
        INSTANCE = new ScreenCaptureManager();
        mainHandler = new Handler(Looper.getMainLooper());
        workHandler$delegate = LazyKt.lazy($$Lambda$ScreenCaptureManager$8H0q3nT2xcCnfXHb41hf79sQ9Ao.INSTANCE);
        bindingLock = new Object();
        pendingOperations = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        pendingCaptureOperations = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        connection = new b();
    }

    private ScreenCaptureManager() {
    }

    public static final /* synthetic */ void access$autoUnbindServiceIfNeed(ScreenCaptureManager r0) {
        r0.autoUnbindServiceIfNeed();
    }

    public static final /* synthetic */ void access$drainPendingOperationsAsync(ScreenCaptureManager r0) {
        r0.drainPendingOperationsAsync();
    }

    public static final /* synthetic */ Object access$getBindingLock$p() {
        return bindingLock;
    }

    public static final /* synthetic */ Handler access$getMainHandler$p() {
        return mainHandler;
    }

    public static final /* synthetic */ void access$setBinding$p(boolean r0) {
        isBinding = r0;
    }

    public static final /* synthetic */ void access$setBound$p(boolean r0) {
        isBound = r0;
    }

    public static final /* synthetic */ void access$setService$p(com.obric.memorydata.sdk.service.b r2) {
        service = (com.obric.memorydata.sdk.service.b) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.memorydata.sdk.service.b.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void access$unbindService(ScreenCaptureManager r0) {
        r0.unbindService();
    }

    private final void autoUnbindServiceIfNeed() {
        Log.i(TAG, "autoUnbindServiceIfNeed: isBound=" + isBound);
        mainHandler.post($$Lambda$ScreenCaptureManager$FBh8Jm9KrR3rS8s8SxGh9kvJ0.INSTANCE);
    }

    private static final void autoUnbindServiceIfNeed$lambda$12() {
        Object r0 = bindingLock;
        monitor-enter(r0);
        int r1 = 0;
        com.obric.memorydata.sdk.service.b r2 = service;     // Catch: Throwable -> L9 Exception -> L11
        if (r2 == null) goto L13;
        r1 = r2.a();     // Catch: Throwable -> L9 Exception -> L11
    L13:
        if (r1 != 0) goto L15;
        INSTANCE.unbindService();     // Catch: Throwable -> L9
    L15:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r0);
        return;
    L11:
        e = move-exception;
        Log.w(TAG, "getScreenEventReactionCount failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private final boolean bindService(Context r7, int r8) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Object r9 = bindingLock;
        monitor-enter(r9);
    L31:
        th = move-exception;
        throw th;
    L6:
        if (isBinding == false) goto L10;
        monitor-exit(r9);
        return false;
    L10:
        isBinding = true;     // Catch: Throwable -> L31
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L31
        monitor-exit(r9);
        Log.i(TAG, "bind service");
        Intent r3 = new Intent(SCREEN_CAPTURE_SERVICE);
        if (Intrinsics.areEqual(BuildConfig.LIBRARY_PACKAGE_NAME, r6.getPackageName()) == false) goto L15;
        String r4 = BuildConfig.LIBRARY_PACKAGE_NAME;
    L16:
        r3.setPackage(r4);
        boolean r10 = ZeusTransformUtils.bindService(r6, r3, (ServiceConnection) ZeusTransformUtils.preCheckCast(connection, ServiceConnection.class, "com.obric.memorydata.plugin"), r8 | 1, "com.obric.memorydata.plugin");
        if (r10 == true) goto L30;
        StringBuilder r0 = new StringBuilder().append("not found service ");
        ComponentName r5 = r3.getComponent();
        if (r5 == null) goto L21;
        String r11 = r5.getShortClassName();
    L22:
        Log.w(TAG, r0.append(r11).toString());
        monitor-enter(r9);
        isBinding = false;     // Catch: Throwable -> L27
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L27
        monitor-exit(r9);
    L27:
        th = move-exception;
        throw th;
    L21:
        r11 = null;
    L30:
        return r10;
    L15:
        r4 = "com.larus.nova";
        goto L16
    }

    private static final Unit captureCurrent$lambda$3$lambda$2(Function0 r2) {
        final Function0 r3 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "it");
        mainHandler.post(new $$Lambda$ScreenCaptureManager$EW9At8LVy6Wyg0dNmkHTxGpMDw(r3));
        return Unit.INSTANCE;
    }

    private static final void captureCurrent$lambda$3$lambda$2$lambda$1(Function0 r2) {
        ((Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin")).invoke();
    }

    private final void captureCurrentRemote(TaskOptions r6, String r7, Function1<? super ScreenData, Unit> r8) {
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r8, Function1.class, "com.obric.memorydata.plugin");
        Log.i(TAG, "captureCurrent queued/bound package=" + r7);
        com.obric.memorydata.sdk.screencapture.a r0 = new com.obric.memorydata.sdk.screencapture.a($$Lambda$ScreenCaptureManager$Y1h9DfbLTNQTr7nGvNkapJOXFNw.INSTANCE, r9, $$Lambda$ScreenCaptureManager$y1UrvPKhMWPsbVf6kzSxMjSItHs.INSTANCE);
        com.obric.memorydata.sdk.service.b r3 = service;     // Catch: Exception -> L8
        if (r3 == null) goto L6;
        r3.a(r6, r7, (com.obric.memorydata.sdk.screencapture.c) ZeusTransformUtils.preCheckCast(new a(r0), com.obric.memorydata.sdk.screencapture.c.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L8
    L11:
        return;
    L6:
        ScreenCaptureManager r5 = (ScreenCaptureManager) ZeusTransformUtils.preCheckCast(this, ScreenCaptureManager.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L8
        Log.w(TAG, "Service is null when trying to capture current screen: " + r7);     // Catch: Exception -> L8
        r0.a(null);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        Log.w(TAG, "captureCurrent remote call failed: " + r7, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        r0.a(null);
    }

    private static final Unit captureCurrentRemote$lambda$6(Function0 r2) {
        final Function0 r3 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "it");
        mainHandler.post(new $$Lambda$ScreenCaptureManager$hEerfR3LMNwhew9U5Mah9suaz14(r3));
        return Unit.INSTANCE;
    }

    private static final void captureCurrentRemote$lambda$6$lambda$5(Function0 r2) {
        ((Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin")).invoke();
    }

    private static final Unit captureCurrentRemote$lambda$7() {
        INSTANCE.autoUnbindServiceIfNeed();
        return Unit.INSTANCE;
    }

    private final void drainPendingOperationsAsync() {
        List<f> r0 = pendingOperations;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L5;
    L6:
        final List r1 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"));
        r0.clear();
        List<e> r2 = pendingCaptureOperations;
        final List r3 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin"));
        r2.clear();
        getWorkHandler().post(new $$Lambda$ScreenCaptureManager$RGUts4Cvd8hrgfo15xNeNay8DhI(r1, r3));
        return;
    L5:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(pendingCaptureOperations, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L6;
    }

    private static final void drainPendingOperationsAsync$lambda$18(List r7, List r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        f r0 = (f) ZeusTransformUtils.preCheckCast(r11.next(), f.class, "com.obric.memorydata.plugin");
        INSTANCE.registerRemote(r0.a(), r0.b(), r0.c());     // Catch: Exception -> L8
    L8:
        e = move-exception;
        Log.e(TAG, "Failed to process pending operation", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L4
    L10:
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L12:
        if (r12.hasNext() == false) goto L18;
        final e r13 = (e) ZeusTransformUtils.preCheckCast(r12.next(), e.class, "com.obric.memorydata.plugin");
        INSTANCE.captureCurrentRemote(r13.a(), r13.b(), r13.c());     // Catch: Exception -> L16
    L16:
        e = move-exception;
        Log.e(TAG, "Failed to process pending capture operation", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        mainHandler.post(new $$Lambda$ScreenCaptureManager$VRZwURWUYvZAdsAC5VmvCad3T4(r13));
        goto L12
    }

    private static final void drainPendingOperationsAsync$lambda$18$lambda$17$lambda$16(e r1) {
        r1.c().invoke(null);
    }

    private final Handler getWorkHandler() {
        return (Handler) ZeusTransformUtils.preCheckCast(workHandler$delegate.getValue(), Handler.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ Handler lambda$8H0q3nT2xcCnfXHb41hf79sQ9Ao() {
        return workHandler_delegate$lambda$0();
    }

    /* JADX INFO: renamed from: lambda$EW9At-8LVy6Wyg0dNmkHTxGpMDw, reason: not valid java name */
    public static /* synthetic */ void m1180lambda$EW9At8LVy6Wyg0dNmkHTxGpMDw(Function0 r0) {
        captureCurrent$lambda$3$lambda$2$lambda$1(r0);
    }

    /* JADX INFO: renamed from: lambda$FBh8Jm9KrR3r-S8s8SxGh9kv-J0, reason: not valid java name */
    public static /* synthetic */ void m1181lambda$FBh8Jm9KrR3rS8s8SxGh9kvJ0() {
        autoUnbindServiceIfNeed$lambda$12();
    }

    /* JADX INFO: renamed from: lambda$NW-AxE4P-eGd3Hj74eTi40uDrEY, reason: not valid java name */
    public static /* synthetic */ Unit m1182lambda$NWAxE4PeGd3Hj74eTi40uDrEY(Function0 r0) {
        return captureCurrent$lambda$3$lambda$2(r0);
    }

    public static /* synthetic */ void lambda$RGUts4Cvd8hrgfo15xNeNay8DhI(List r0, List r1) {
        drainPendingOperationsAsync$lambda$18(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$VRZwURWUYvZA-dsAC5VmvCad3T4, reason: not valid java name */
    public static /* synthetic */ void m1183lambda$VRZwURWUYvZAdsAC5VmvCad3T4(e r0) {
        drainPendingOperationsAsync$lambda$18$lambda$17$lambda$16(r0);
    }

    public static /* synthetic */ Unit lambda$Y1h9DfbLTNQTr7nGvNkapJOXFNw(Function0 r0) {
        return captureCurrentRemote$lambda$6(r0);
    }

    public static /* synthetic */ void lambda$hEerfR3LMNwhew9U5Mah9suaz14(Function0 r0) {
        captureCurrentRemote$lambda$6$lambda$5(r0);
    }

    public static /* synthetic */ Unit lambda$y1UrvPKhMWPsbVf6kzSxMjSItHs() {
        return captureCurrentRemote$lambda$7();
    }

    public static /* synthetic */ void register$default(ScreenCaptureManager r1, Context r2, ScreenEventReaction r3, com.obric.memorydata.sdk.screencapture.b r4, int r5, int r6, Object r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.sdk.screencapture.b r9 = (com.obric.memorydata.sdk.screencapture.b) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.memorydata.sdk.screencapture.b.class, "com.obric.memorydata.plugin");
        if ((r6 & 8) == 0) goto L5;
        r5 = 64;
    L5:
        r1.register(r8, r3, r9, r5);
    }

    private final void registerInternal(Context r3, ScreenEventReaction r4, long r5, com.obric.memorydata.sdk.screencapture.b r7, int r8) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.sdk.screencapture.b r6 = (com.obric.memorydata.sdk.screencapture.b) ZeusTransformUtils.wrapperContextForParams(r7, com.obric.memorydata.sdk.screencapture.b.class, "com.obric.memorydata.plugin");
        Log.i(TAG, "registerInternal: isBound=" + isBound + ", isBinding=" + isBinding);
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r9, "getApplicationContext(...)");
        appContext = r9;
        Object r10 = bindingLock;
        monitor-enter(r10);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (isBound == false) goto L8;
        INSTANCE.registerRemote(r4, r5, r6);     // Catch: Throwable -> L16
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L16
    L14:
        monitor-exit(r10);
        return;
    L8:
        if (isBinding == true) goto L13;
        pendingOperations.add(new f(r4, r5, r6));     // Catch: Throwable -> L16
        ScreenCaptureManager r12 = INSTANCE;     // Catch: Throwable -> L16
        Context r13 = appContext;     // Catch: Throwable -> L16
        if (r13 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("appContext");     // Catch: Throwable -> L16
        r13 = null;
    L12:
        Boolean.valueOf(r12.bindService(r13, r8));     // Catch: Throwable -> L16
        goto L14
    L13:
        pendingOperations.add(new f(r4, r5, r6));     // Catch: Throwable -> L16
        Integer.valueOf(Log.i(TAG, "Service binding in progress, queued registration for reaction: " + r4.getId()));     // Catch: Throwable -> L16
        goto L14
    }

    public static /* synthetic */ void registerOneShot$default(ScreenCaptureManager r9, Context r10, ScreenEventReaction r11, long r12, com.obric.memorydata.sdk.screencapture.b r14, int r15, int r16, Object r17) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.sdk.screencapture.b r7 = (com.obric.memorydata.sdk.screencapture.b) ZeusTransformUtils.wrapperContextForParams(r14, com.obric.memorydata.sdk.screencapture.b.class, "com.obric.memorydata.plugin");
        if ((r16 & 16) == 0) goto L5;
        int r8 = 64;
    L6:
        r9.registerOneShot(r3, r11, r12, r7, r8);
        return;
    L5:
        r8 = r15;
        goto L6
    }

    private final void registerRemote(ScreenEventReaction r4, long r5, com.obric.memorydata.sdk.screencapture.b r7) {
        com.obric.memorydata.sdk.screencapture.b r3 = (com.obric.memorydata.sdk.screencapture.b) ZeusTransformUtils.wrapperContextForParams(r7, com.obric.memorydata.sdk.screencapture.b.class, "com.obric.memorydata.plugin");
        boolean r8 = Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());
        com.obric.memorydata.sdk.service.b r1 = service;
        if (r1 == null) goto L5;
        r1.a(r4, r5, (d) ZeusTransformUtils.preCheckCast(new c(r8, r3), d.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        Log.w(TAG, "Service is null when trying to register reaction: " + r4.getId());
    }

    private final void unbindService() {
        if (isBound == false) goto L9;
        Log.i(TAG, "unbind service");
        Context r3 = appContext;
        if (r3 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("appContext");
        r3 = null;
    L7:
        ZeusTransformUtils.unbindService(r3, (ServiceConnection) ZeusTransformUtils.preCheckCast(connection, ServiceConnection.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        isBound = false;
        return;
    }

    private static final Handler workHandler_delegate$lambda$0() {
        HandlerThread r0 = new HandlerThread("screen_capture_worker");
        r0.start();
        return new Handler(r0.getLooper());
    }

    public final void captureCurrent(Context r2, TaskOptions r3, String r4, Function1<? super ScreenData, Unit> r5) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Function1<? super ScreenData, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r3, "taskOptions");
        Intrinsics.checkNotNullParameter(r4, "targetPackage");
        Intrinsics.checkNotNullParameter(r6, "callback");
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r7, "getApplicationContext(...)");
        appContext = r7;
        Object r8 = bindingLock;
        monitor-enter(r8);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (isBound == false) goto L8;
        INSTANCE.captureCurrentRemote(r3, r4, r6);     // Catch: Throwable -> L19
    L7:
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L19
    L17:
        monitor-exit(r8);
        return;
    L8:
        e r10 = new e(r3, r4, r6);     // Catch: Throwable -> L19
        List<e> r11 = pendingCaptureOperations;     // Catch: Throwable -> L19
        r11.add(r10);     // Catch: Throwable -> L19
        if (isBinding == true) goto L16;
        ScreenCaptureManager r12 = INSTANCE;     // Catch: Throwable -> L19
        Context r13 = appContext;     // Catch: Throwable -> L19
        if (r13 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("appContext");     // Catch: Throwable -> L19
        r13 = null;
    L14:
        if (r12.bindService(r13, 64) == true) goto L7;
        g.a(r11, r10, $$Lambda$ScreenCaptureManager$NWAxE4PeGd3Hj74eTi40uDrEY.INSTANCE);     // Catch: Throwable -> L19
        goto L7
    L16:
        Integer.valueOf(Log.i(TAG, "Service binding in progress, queued captureCurrent for package: " + r4));     // Catch: Throwable -> L19
        goto L17
    }

    public final void register(Context r10, ScreenEventReaction r11, com.obric.memorydata.sdk.screencapture.b r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.sdk.screencapture.b r5 = (com.obric.memorydata.sdk.screencapture.b) ZeusTransformUtils.wrapperContextForParams(r12, com.obric.memorydata.sdk.screencapture.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r11, "screenEventReaction");
        Intrinsics.checkNotNullParameter(r5, "callback");
        register$default(this, r3, r11, r5, 0, 8, null);
    }

    public final void register(Context r10, ScreenEventReaction r11, com.obric.memorydata.sdk.screencapture.b r12, int r13) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.sdk.screencapture.b r7 = (com.obric.memorydata.sdk.screencapture.b) ZeusTransformUtils.wrapperContextForParams(r12, com.obric.memorydata.sdk.screencapture.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r11, "screenEventReaction");
        Intrinsics.checkNotNullParameter(r7, "callback");
        registerInternal(r3, r11, 0, r7, r13);
    }

    public final void registerOneShot(Context r12, ScreenEventReaction r13, long r14, com.obric.memorydata.sdk.screencapture.b r16) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.sdk.screencapture.b r7 = (com.obric.memorydata.sdk.screencapture.b) ZeusTransformUtils.wrapperContextForParams(r16, com.obric.memorydata.sdk.screencapture.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r13, "reaction");
        Intrinsics.checkNotNullParameter(r7, "callback");
        registerOneShot$default(this, r3, r13, r14, r7, 0, 16, null);
    }

    public final void registerOneShot(Context r10, ScreenEventReaction r11, long r12, com.obric.memorydata.sdk.screencapture.b r14, int r15) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.sdk.screencapture.b r7 = (com.obric.memorydata.sdk.screencapture.b) ZeusTransformUtils.wrapperContextForParams(r14, com.obric.memorydata.sdk.screencapture.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r11, "reaction");
        Intrinsics.checkNotNullParameter(r7, "callback");
        registerInternal(r3, r11, r12, r7, r15);
    }

    public final void unregister(ScreenEventReaction r2) {
        Intrinsics.checkNotNullParameter(r2, "screenEventReaction");
        unregister(r2.getId());
    }

    public final void unregister(String r3) {
        Intrinsics.checkNotNullParameter(r3, "reactionId");
        com.obric.memorydata.sdk.service.b r0 = service;
        if (r0 == null) goto L5;
        r0.a(r3);
    L6:
        autoUnbindServiceIfNeed();
        return;
    L5:
        Log.w(TAG, "Service not available when unregistering reaction: " + r3);
        goto L6
    }
}
