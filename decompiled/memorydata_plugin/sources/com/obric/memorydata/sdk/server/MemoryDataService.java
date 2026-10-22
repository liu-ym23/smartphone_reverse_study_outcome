package com.obric.memorydata.sdk.server;

import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin_api.MemoryPluginActiveState;
import com.obric.memorydata.sdk.service.BinderCode;
import com.volcengine.zeus.service.PluginService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\rH\u0016J\u0018\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\tH\u0002J\b\u0010\u0018\u001a\u00020\rH\u0002R\u0012\u0010\u0004\u001a\u00060\u0005R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/sdk/server/MemoryDataService;", "Landroid/app/Service;", "<init>", "()V", "binder", "Lcom/obric/memorydata/sdk/server/MemoryDataService$MemoryDataServiceBinder;", "serviceMap", "", "Lcom/obric/memorydata/sdk/service/BinderCode;", "Lcom/obric/memorydata/sdk/server/IPoolService;", "loaded", "Ljava/util/concurrent/atomic/AtomicBoolean;", "onCreate", "", "onBind", "Landroid/os/IBinder;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "onUnbind", "", "onDestroy", "registerServices", "binderCode", "service", "ensureProvidersLoaded", "Companion", "MemoryDataServiceBinder", "memoryDataSDKServer_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryDataService extends PluginService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12855a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f12856b;
    private final Map<BinderCode, IPoolService> c;
    private final AtomicBoolean d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/sdk/server/MemoryDataService$Companion;", "", "<init>", "()V", "TAG", "", "memoryDataSDKServer_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/sdk/server/MemoryDataService$MemoryDataServiceBinder;", "Lcom/obric/memorydata/sdk/service/IMemoryDataService$Stub;", "<init>", "(Lcom/obric/memorydata/sdk/server/MemoryDataService;)V", "onTransact", "", "code", "", "data", "Landroid/os/Parcel;", "reply", "flags", "queryBinder", "Landroid/os/IBinder;", "binderCode", "memoryDataSDKServer_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private final class b extends com.obric.memorydata.sdk.service.a.AbstractBinderC0703a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MemoryDataService f12857a;

        public b(MemoryDataService r3) {
            this.f12857a = (MemoryDataService) ZeusTransformUtils.wrapperContextForParams(r3, MemoryDataService.class, "com.obric.memorydata.plugin");
        }

        @Override // com.obric.memorydata.sdk.service.a
        public IBinder a(int r11) {
            BinderCode r0 = BinderCode.Companion.a(r11);
            Object r1 = null;
            if (r0 != null) goto L7;
            IRunLog r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            StringBuilder r10 = new StringBuilder().append("BinderCode:").append(r11).append(" illegal!");
        L5:
            IRunLog.a.b(r2, "MemoryDataService", r10.toString(), null, 4, null);
            return null;
        L7:
            IPoolService r3 = (IPoolService) ZeusTransformUtils.preCheckCast(MemoryDataService.a(this.f12857a).get(r0), IPoolService.class, "com.obric.memorydata.plugin");
            if (r3 != null) goto L22;
            r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            r10 = new StringBuilder().append("No provider for code=").append(r0).append(", keys=").append(MemoryDataService.a(this.f12857a).keySet());
            goto L5
        L22:
            Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L12
            b r12 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
            Object r13 = Result.m1421constructorimpl(r3.provideBinder());     // Catch: Throwable -> L12
        L14:
            Throwable r5 = Result.m1424exceptionOrNullimpl(r13);
            if (r5 != null) goto L17;
            r1 = r13;
        L18:
            IBinder r14 = (IBinder) ZeusTransformUtils.preCheckCast(r1, IBinder.class, "com.obric.memorydata.plugin");
            if (r14 != null) goto L21;
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryDataService", "IBinder:" + r11 + " null! provider=" + r3.getClass().getName(), null, 4, null);
        L21:
            return r14;
        L17:
            RunLog.INSTANCE.error("MemoryDataService", "provideBinder failed for " + r3.getClass().getName() + ", code=" + r0, r5);
        L12:
            th = move-exception;
            Result.Companion r6 = Result.Companion;
            r13 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L14
        }

        @Override // com.obric.memorydata.sdk.service.a.AbstractBinderC0703a, android.os.Binder
        public boolean onTransact(int r2, Parcel r3, Parcel r4, int r5) {
            Intrinsics.checkNotNullParameter(r3, "data");
            MemoryPluginActiveState.onEnter();
            boolean r1 = super.onTransact(r2, r3, r4, r5);     // Catch: Throwable -> L6
            MemoryPluginActiveState.onExit();
            return r1;
        L6:
            th = move-exception;
            MemoryPluginActiveState.onExit();
            throw th;
        }
    }

    static {
        f12855a = new a(null);
    }

    public MemoryDataService() {
        this.f12856b = new b(this);
        this.c = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.d = new AtomicBoolean(false);
    }

    public static final /* synthetic */ Map a(MemoryDataService r2) {
        return ((MemoryDataService) ZeusTransformUtils.wrapperContextForParams(r2, MemoryDataService.class, "com.obric.memorydata.plugin")).c;
    }

    private final void a() {
        if (this.d.get() == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L42:
        th = move-exception;
        throw th;
    L7:
        if (this.d.get() == false) goto L10;
        monitor-exit(this);
        return;
    L10:
        ClassLoader r0 = getClass().getClassLoader();     // Catch: Throwable -> L42
        if (r0 != null) goto L13;
        r0 = IPoolService.class.getClassLoader();     // Catch: Throwable -> L42
    L13:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryDataService", "ServiceLoader classLoader=" + r0, false, 4, null);     // Catch: Throwable -> L42
        if (r0 == null) goto L17;
        ServiceLoader r1 = ServiceLoader.load(IPoolService.class, r0);     // Catch: Throwable -> L38
    L18:
        int r2 = 0;
    L50:
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L33
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L33
    L20:
        if (r3.hasNext() == false) goto L35;
        IPoolService r4 = (IPoolService) ZeusTransformUtils.preCheckCast(r3.next(), IPoolService.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
        r2 = r2 + 1;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L26
        MemoryDataService r6 = (MemoryDataService) ZeusTransformUtils.preCheckCast(this, MemoryDataService.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
        Object r7 = Result.m1421constructorimpl(r4.provideBinderCode());     // Catch: Throwable -> L26
    L28:
        Throwable r8 = Result.m1424exceptionOrNullimpl(r7);     // Catch: Throwable -> L33
        if (r8 == null) goto L30;
        RunLog.INSTANCE.error("MemoryDataService", "provideBinderCode failed: " + r4.getClass().getName(), r8);     // Catch: Throwable -> L33
        goto L20
    L30:
        BinderCode r9 = (BinderCode) ZeusTransformUtils.preCheckCast(r7, BinderCode.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryDataService", "load provider: " + r4.getClass().getName() + ", code=" + r9, false, 4, null);     // Catch: Throwable -> L33
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L33
        a(r9, r4);     // Catch: Throwable -> L33
        goto L20
    L26:
        th = move-exception;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L33
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L33
    L35:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryDataService", "ServiceLoader loaded count=" + r2 + ", keys=" + this.c.keySet(), false, 4, null);     // Catch: Throwable -> L42
        this.d.set(true);     // Catch: Throwable -> L42
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L42
        monitor-exit(this);
        return;
    L33:
        th = move-exception;
        RunLog.INSTANCE.error("MemoryDataService", "iterate ServiceLoader failed", th);     // Catch: Throwable -> L42
        goto L35
    L17:
        r1 = ServiceLoader.load(IPoolService.class);     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        RunLog.INSTANCE.error("MemoryDataService", "ServiceLoader.load failed", th);     // Catch: Throwable -> L42
        this.d.set(true);     // Catch: Throwable -> L42
    }

    private final void a(BinderCode r3, IPoolService r4) {
        IPoolService r5 = (IPoolService) ZeusTransformUtils.wrapperContextForParams(r4, IPoolService.class, "com.obric.memorydata.plugin");
        this.c.put(r3, r5);
    }

    public IBinder onBind(Intent r10) {
        Intrinsics.checkNotNullParameter(r10, MemorySourceLinkType.INTENT);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryDataService", "onBind", false, 4, null);
        a();
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.c.values(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        IPoolService r1 = (IPoolService) ZeusTransformUtils.preCheckCast(r0.next(), IPoolService.class, "com.obric.memorydata.plugin");
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L8
        MemoryDataService r4 = (MemoryDataService) ZeusTransformUtils.preCheckCast(this, MemoryDataService.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        r1.onBind(r10);     // Catch: Throwable -> L8
        Object r5 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r6 = Result.m1424exceptionOrNullimpl(r5);
        if (r6 == null) goto L4;
        RunLog.INSTANCE.error("MemoryDataService", "provider onBind failed: " + r1.getClass().getName(), r6);
    L8:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    L14:
        return (IBinder) ZeusTransformUtils.preCheckCast(this.f12856b, IBinder.class, "com.obric.memorydata.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryDataService", "onCreate", false, 4, null);
        super/*android.app.Service*/.onCreate();
        a();
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.c.values(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        IPoolService r1 = (IPoolService) ZeusTransformUtils.preCheckCast(r0.next(), IPoolService.class, "com.obric.memorydata.plugin");
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L8
        MemoryDataService r4 = (MemoryDataService) ZeusTransformUtils.preCheckCast(this, MemoryDataService.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        r1.onCreate();     // Catch: Throwable -> L8
        Object r5 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r6 = Result.m1424exceptionOrNullimpl(r5);
        if (r6 == null) goto L4;
        RunLog.INSTANCE.error("MemoryDataService", "provider onCreate failed: " + r1.getClass().getName(), r6);
    L8:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDestroy() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryDataService", "onDestroy", false, 4, null);
        super/*android.app.Service*/.onDestroy();
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.c.values(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        IPoolService r1 = (IPoolService) ZeusTransformUtils.preCheckCast(r0.next(), IPoolService.class, "com.obric.memorydata.plugin");
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L8
        MemoryDataService r4 = (MemoryDataService) ZeusTransformUtils.preCheckCast(this, MemoryDataService.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        r1.onDestroy();     // Catch: Throwable -> L8
        Object r5 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r6 = Result.m1424exceptionOrNullimpl(r5);
        if (r6 == null) goto L4;
        RunLog.INSTANCE.error("MemoryDataService", "provider onDestroy failed: " + r1.getClass().getName(), r6);
    L8:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    L13:
        this.c.clear();
        this.d.set(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onUnbind(Intent r10) {
        Intrinsics.checkNotNullParameter(r10, MemorySourceLinkType.INTENT);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryDataService", "onUnbind", false, 4, null);
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.c.values(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        IPoolService r1 = (IPoolService) ZeusTransformUtils.preCheckCast(r0.next(), IPoolService.class, "com.obric.memorydata.plugin");
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L8
        MemoryDataService r4 = (MemoryDataService) ZeusTransformUtils.preCheckCast(this, MemoryDataService.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        Object r5 = Result.m1421constructorimpl(Boolean.valueOf(r1.onUnbind(r10)));     // Catch: Throwable -> L8
    L10:
        Throwable r6 = Result.m1424exceptionOrNullimpl(r5);
        if (r6 == null) goto L4;
        RunLog.INSTANCE.error("MemoryDataService", "provider onUnbind failed: " + r1.getClass().getName(), r6);
    L8:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    L14:
        return super/*android.app.Service*/.onUnbind(r10);
    }
}
