package com.obric.memorydata.awareness.location;

import android.content.Context;
import android.os.PowerManager;
import android.os.SystemClock;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.obric.aiproactive.api.ProactiveRecommendationEnabledStore;
import com.obric.aiproactive.api.ae;
import com.obric.memorydata.ability.d;
import com.obric.memorydata.ability.data.h;
import com.obric.memorydata.ability.data.p;
import com.obric.memorydata.ability.data.u;
import com.obric.memorydata.ability.f;
import com.obric.memorydata.ability.k;
import com.obric.memorydata.awareness.api.ILocationSnapshot;
import com.obric.memorydata.awareness.api.LocationSnapshot;
import com.obric.memorydata.awareness.impl.AwarenessManagerImpl;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.task.TaskRegister;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.impl.g;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.obric.memorydata.utils.handler.GlobalHandlerUtil;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u0013H\u0002J\b\u0010\u001f\u001a\u00020\u0013H\u0002J\b\u0010 \u001a\u00020\u0013H\u0002J\b\u0010!\u001a\u00020\u001dH\u0002J\b\u0010\"\u001a\u00020\u001dH\u0002J\b\u0010#\u001a\u00020\u001dH\u0002J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020\u001dH\u0002J\b\u0010(\u001a\u00020\u001dH\u0002J\u0010\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\u001aH\u0002J\b\u0010+\u001a\u00020\u001dH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/obric/memorydata/awareness/location/LocationCollector;", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "<init>", "()V", "TAG", "", "WIFI_LOCATION_REQUEST_INTERVAL", "", "WIFI_LOCATION_REQUEST_DELAY", "abilityManager", "Lcom/obric/memorydata/ability/AbilityManager;", "locationSubscribeParams", "Lcom/obric/memorydata/ability/AbilityParams;", "screenSubscribeParams", "wifiSubscribeParams", "preTimeStamp", "lastWifiLocationRequestElapsedTime", "currentState", "screenSubscribed", "", "locationSubscribed", "wifiSubscribed", "startupLocationRequested", "proactiveRecommendationEnabledListener", "Lcom/obric/aiproactive/api/ProactiveRecommendationEnabledListener;", "screenOnFrequencyTimeUnit", "Lcom/obric/memorydata/task/impl/TaskTimeUnit;", "screenOffFrequencyTimeUnit", "startCollect", "", "isPeriodicCollecting", "canRequestWifiLocation", "shouldCollectLocationContinuously", "syncCollectState", "syncWifiSubscription", "stopPeriodicCollect", "onDataReceive", "data", "Lcom/obric/memorydata/ability/data/IStandardData;", "requestStartupLocation", "requestLocationForWifiFence", "setupLocationTask", "timeUnit", "removeLocationTask", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8753a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d f8754b = null;
    private static final f c = null;
    private static final f d = null;
    private static final f e = null;
    private static long f;
    private static long g;
    private static String h;
    private static boolean i;
    private static boolean j;
    private static boolean k;
    private static boolean l;
    private static final ae m = null;
    private static final g n = null;
    private static final g o = null;

    /* JADX INFO: renamed from: com.obric.memorydata.awareness.location.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/awareness/location/LocationCollector$requestLocationForWifiFence$1$1$requested$1", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "onDataReceive", "", "data", "Lcom/obric/memorydata/ability/data/IStandardData;", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0447a implements k {
        C0447a() {
        }

        @Override // com.obric.memorydata.ability.k
        public void a(h r2) {
            Intrinsics.checkNotNullParameter((h) ZeusTransformUtils.wrapperContextForParams(r2, h.class, "com.obric.memorydata.plugin"), "data");
        }

        @Override // com.obric.memorydata.ability.k
        public String g_() {
            return k.a.a(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/awareness/location/LocationCollector$requestStartupLocation$requested$1", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "onDataReceive", "", "data", "Lcom/obric/memorydata/ability/data/IStandardData;", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f8755a;

        b(boolean r1) {
            this.f8755a = r1;
        }

        @Override // com.obric.memorydata.ability.k
        public void a(h r3) {
            h r4 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "data");
            if (ZeusTransformUtils.instanceOf(r4, com.obric.memorydata.ability.data.k.class) == true) goto L5;
            return;
        L5:
            if (this.f8755a == false) goto L9;
            ((com.obric.memorydata.ability.data.k) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.ability.data.k.class, "com.obric.memorydata.plugin")).collectNewData();
            ((com.obric.memorydata.ability.data.k) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.ability.data.k.class, "com.obric.memorydata.plugin")).a();
            return;
        }

        @Override // com.obric.memorydata.ability.k
        public String g_() {
            return k.a.a(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/obric/memorydata/awareness/location/LocationCollector$startCollect$1", "Lcom/obric/memorydata/middleware/api/store/StoreChangeListener;", "onKeyChanged", "", "repoName", "", "key", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements com.obric.memorydata.middleware.api.store.b {
        c() {
        }

        private static final void a() {
            a.a(a.f8753a);
        }

        public static /* synthetic */ void lambda$qZEJirqIMJzgnwGCA1kTKmQcCeI() {
            a();
        }

        @Override // com.obric.memorydata.middleware.api.store.b
        public void onKeyChanged(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "repoName");
            Intrinsics.checkNotNullParameter(r2, "key");
            if (Intrinsics.areEqual(r2, "auto_learn_common_address") == false) goto L6;
            ThreadPoolContainer.Companion.getInstance().execute($$Lambda$a$c$qZEJirqIMJzgnwGCA1kTKmQcCeI.INSTANCE);
            return;
        }
    }

    static {
        f8753a = new a();
        f8754b = new d();
        c = new f(100000004, MapsKt.mapOf(TuplesKt.to("mode", "collect_geography")));
        d = new f(100000005, MapsKt.mapOf(TuplesKt.to("mode", LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL)));
        e = new f(100000002, MapsKt.mapOf(TuplesKt.to("action", 3)));
        h = com.tom_roush.pdfbox.pdmodel.a.d.f.g;
        m = $$Lambda$a$XzAJcuuX4ZG1Co0QTfhvb3P_2wY.INSTANCE;
        n = new g(10, TimeUnit.MINUTES);
        o = new g(1, TimeUnit.HOURS);
    }

    private a() {
    }

    public static final /* synthetic */ void a(a r0) {
        r0.f();
    }

    private final void a(g r3) {
        if (e() == true) goto L6;
        k();
        return;
    L6:
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder(AwarenessLocationTask.NAME).setExistingTaskPolicy(ExistingTaskPolicy.KEEP_IN_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setDelay(r3), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
    }

    private static final void a(boolean r1) {
        ThreadPoolContainer.Companion.getInstance().execute($$Lambda$a$GtCBiL6bP2AwmSPQgID5TsdoLY.INSTANCE);
    }

    private final synchronized boolean c() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (i == false) goto L8;
        if (j == false) goto L8;
        boolean r0 = true;
    L9:
        monitor-exit(this);
        return r0;
    L8:
        r0 = false;
        goto L9
    }

    private final synchronized boolean d() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (k == false) goto L8;
        if (com.obric.memorydata.b.a.f8796a.b() == false) goto L8;
        boolean r0 = true;
    L9:
        monitor-exit(this);
        return r0;
    L8:
        r0 = false;
        goto L9
    }

    private final boolean e() {
        if (com.obric.memorydata.b.a.f8796a.b() == true) goto L5;
    L9:
        return false;
    L5:
        if (com.obric.memorydata.address.a.f8427a.a() == false) goto L7;
    L8:
        return true;
    L7:
        if (ProactiveRecommendationEnabledStore.INSTANCE.isEnabled() == false) goto L9;
        goto L8
    }

    private final synchronized void f() {
        monitor-enter(this);
        g();     // Catch: Throwable -> L32
        if (e() == true) goto L6;
        h();     // Catch: Throwable -> L32
    L30:
        monitor-exit(this);
        return;
    L6:
        if (c() == false) goto L10;
        monitor-exit(this);
        return;
    L10:
        if (i == true) goto L13;
        i = f8754b.a(d, (k) ZeusTransformUtils.preCheckCast(this, k.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L32
    L13:
        if (j == true) goto L16;
        j = f8754b.a(c, (k) ZeusTransformUtils.preCheckCast(this, k.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L32
    L16:
        if (c() == true) goto L20;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LocationCollector", "subscribe failed, screenSubscribed=" + i + ", locationSubscribed=" + j, null, 4, null);     // Catch: Throwable -> L32
        k();     // Catch: Throwable -> L32
        monitor-exit(this);
        return;
    L20:
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("power");     // Catch: Throwable -> L32
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.os.PowerManager");     // Catch: Throwable -> L32
        if (((PowerManager) ZeusTransformUtils.preCheckCast(r0, PowerManager.class, "com.obric.memorydata.plugin")).isInteractive() == false) goto L23;
        String r1 = com.tom_roush.pdfbox.pdmodel.a.d.f.f;
    L24:
        h = r1;     // Catch: Throwable -> L32
        if (Intrinsics.areEqual(r1, com.tom_roush.pdfbox.pdmodel.a.d.f.f) == false) goto L27;
        g r2 = n;     // Catch: Throwable -> L32
    L28:
        a(r2);     // Catch: Throwable -> L32
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LocationCollector", "start periodic location collection", false, 4, null);     // Catch: Throwable -> L32
        goto L30
    L27:
        r2 = o;     // Catch: Throwable -> L32
        goto L28
    L23:
        r1 = com.tom_roush.pdfbox.pdmodel.a.d.f.g;
    L32:
        th = move-exception;
        throw th;
    }

    private final void g() {
        boolean r0 = com.obric.memorydata.b.a.f8796a.b();
        if (r0 != k) goto L5;
        return;
    L5:
        d r2 = f8754b;
        f r3 = e;
        k r7 = (k) ZeusTransformUtils.preCheckCast(this, k.class, "com.obric.memorydata.plugin");
        if (r0 == false) goto L8;
        boolean r8 = r2.a(r3, r7);
    L9:
        if (r8 == false) goto L11;
        k = r0;
        return;
    L11:
        IRunLog r1 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r9 = new StringBuilder().append("failed to ");
        if (r0 == false) goto L14;
        String r4 = AwarenessManagerImpl.ACTION_SUBSCRIBE;
    L15:
        IRunLog.a.a(r1, "LocationCollector", r9.append(r4).append(" wifi changes").toString(), null, 4, null);
        return;
    L14:
        r4 = "unsubscribe";
        goto L15
    L8:
        r8 = r2.b(r3, r7);
        goto L9
    }

    private final synchronized void h() {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L4:
        if (i == false) goto L10;
        if (f8754b.b(d, (k) ZeusTransformUtils.preCheckCast(this, k.class, "com.obric.memorydata.plugin")) == true) goto L8;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LocationCollector", "failed to unsubscribe screen state", null, 4, null);     // Catch: Throwable -> L18
    L8:
        i = false;     // Catch: Throwable -> L18
    L10:
        if (j == true) goto L12;
    L15:
        k();     // Catch: Throwable -> L18
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LocationCollector", "stop periodic location collection, screenSubscribed=" + i + ", locationSubscribed=" + j, false, 4, null);     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L12:
        if (f8754b.b(c, (k) ZeusTransformUtils.preCheckCast(this, k.class, "com.obric.memorydata.plugin")) == true) goto L14;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LocationCollector", "failed to unsubscribe location changes", null, 4, null);     // Catch: Throwable -> L18
    L14:
        j = false;     // Catch: Throwable -> L18
        goto L15
    }

    private final void i() {
        if (com.obric.memorydata.b.a.f8796a.b() == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LocationCollector", "skip startup location request because location permission is unavailable", false, 4, null);
        return;
    L6:
        monitor-enter(this);
    L25:
        th = move-exception;
        throw th;
    L8:
        if (l == false) goto L12;
        monitor-exit(this);
        return;
    L12:
        l = true;     // Catch: Throwable -> L25
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(this);
        boolean r0 = true ^ c();
        if (f8754b.query(new f(100000004, MapsKt.emptyMap()), (k) ZeusTransformUtils.preCheckCast(new b(r0), k.class, "com.obric.memorydata.plugin")) == true) goto L24;
        monitor-enter(this);
        l = false;     // Catch: Throwable -> L21
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(this);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LocationCollector", "failed to request startup location", null, 4, null);
        return;
    L21:
        th = move-exception;
        throw th;
    }

    private final synchronized void j() {
        monitor-enter(this);
        long r0 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L13
        long r2 = g;     // Catch: Throwable -> L13
        if (r2 != 0) goto L6;
    L10:
        g = r0;     // Catch: Throwable -> L13
        GlobalHandlerUtil.Companion.getInstance().postDelay(5000, $$Lambda$a$FyDD5dLcOunr4tRoX7KgsUQ8ok.INSTANCE);     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L6:
        if ((r0 - r2) >= 300000) goto L10;
        RunLog.INSTANCE.debug("LocationCollector", "skip wifi location request because it is rate limited");     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private final void k() {
        com.obric.memorydata.task.scheduler.impl.c.f12961a.d().a(AwarenessLocationTask.NAME);
    }

    private static final void l() {
        f8753a.f();
    }

    public static /* synthetic */ void lambda$9OQupebUXLwbK0nS0K34Ov68IT8() {
        q();
    }

    /* JADX INFO: renamed from: lambda$A0IN2YIt6Qz-I6h3FQ9tGAfEXOg, reason: not valid java name */
    public static /* synthetic */ void m524lambda$A0IN2YIt6QzI6h3FQ9tGAfEXOg() {
        p();
    }

    /* JADX INFO: renamed from: lambda$FyDD5dLc-Ounr4tRoX7KgsUQ8ok, reason: not valid java name */
    public static /* synthetic */ void m525lambda$FyDD5dLcOunr4tRoX7KgsUQ8ok() {
        s();
    }

    /* JADX INFO: renamed from: lambda$GtCBiL6bP2AwmSPQgI-D5TsdoLY, reason: not valid java name */
    public static /* synthetic */ void m526lambda$GtCBiL6bP2AwmSPQgID5TsdoLY() {
        l();
    }

    public static /* synthetic */ void lambda$LimK6MHbTQHPxyCdiaPQTgB2ecg() {
        o();
    }

    public static /* synthetic */ void lambda$QNxpUVQ2wU4Jd4K1jieD6WGzstQ() {
        r();
    }

    public static /* synthetic */ Unit lambda$UhlOsNtQbJ3Mg_XAZLhNAZow8uU() {
        return n();
    }

    public static /* synthetic */ void lambda$XzAJcuuX4ZG1Co0QTfhvb3P_2wY(boolean r0) {
        a(r0);
    }

    /* JADX INFO: renamed from: lambda$YrtENafA-YESuWtyVFQF46Mkce4, reason: not valid java name */
    public static /* synthetic */ void m527lambda$YrtENafAYESuWtyVFQF46Mkce4() {
        m();
    }

    private static final void m() {
        a r0 = f8753a;
        r0.f();
        r0.i();
    }

    private static final Unit n() {
        ThreadPoolContainer.Companion.getInstance().execute($$Lambda$a$YrtENafAYESuWtyVFQF46Mkce4.INSTANCE);
        return Unit.INSTANCE;
    }

    private static final void o() {
        f8753a.i();
    }

    private static final void p() {
        f8753a.f();
    }

    private static final void q() {
        if (f8753a.e() == false) goto L6;
        ILocationSnapshot.a.a((ILocationSnapshot) ZeusTransformUtils.preCheckCast(LocationSnapshot.INSTANCE, ILocationSnapshot.class, "com.obric.memorydata.plugin"), 0, 1, null);
        return;
    }

    private static final void r() {
        if (f8753a.d() == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LocationCollector", "skip wifi location request because location permission is unavailable", false, 4, null);
        return;
    L6:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LocationCollector", "request location after wifi connected", false, 4, null);
        if (f8754b.query(new f(100000001, MapsKt.emptyMap()), (k) ZeusTransformUtils.preCheckCast(new C0447a(), k.class, "com.obric.memorydata.plugin")) == true) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LocationCollector", "failed to request location after wifi connected", null, 4, null);
        return;
    }

    private static final void s() {
        ThreadPoolContainer.Companion.getInstance().execute($$Lambda$a$QNxpUVQ2wU4Jd4K1jieD6WGzstQ.INSTANCE);
    }

    @Override // com.obric.memorydata.ability.k
    public void a(h r9) {
        h r10 = (h) ZeusTransformUtils.wrapperContextForParams(r9, h.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "data");
        if (ZeusTransformUtils.instanceOf(r10, u.class) == false) goto L12;
        if (((u) ZeusTransformUtils.preCheckCast(r10, u.class, "com.obric.memorydata.plugin")).a() != 3) goto L12;
        if (com.obric.memorydata.b.a.f8796a.b() == false) goto L9;
        j();
        return;
    L9:
        f();
        return;
    L12:
        if (e() == true) goto L16;
        f();
        return;
    L16:
        if (c() == true) goto L20;
        ThreadPoolContainer.Companion.getInstance().execute($$Lambda$a$A0IN2YIt6QzI6h3FQ9tGAfEXOg.INSTANCE);
        return;
    L20:
        if (ZeusTransformUtils.instanceOf(r10, p.class) == false) goto L32;
        RunLog.INSTANCE.debug("LocationCollector", "receive screen state, state: " + ((p) ZeusTransformUtils.preCheckCast(r10, p.class, "com.obric.memorydata.plugin")).a());
        if (Intrinsics.areEqual(((p) ZeusTransformUtils.preCheckCast(r10, p.class, "com.obric.memorydata.plugin")).a(), com.tom_roush.pdfbox.pdmodel.a.d.f.f) == false) goto L28;
        long r2 = System.currentTimeMillis();
        if ((r2 - f) <= 300000) goto L26;
        ThreadPoolContainer.Companion.getInstance().execute($$Lambda$a$9OQupebUXLwbK0nS0K34Ov68IT8.INSTANCE);
        f = r2;
    L26:
        k();
        g r0 = n;
    L30:
        a(r0);
        h = ((p) ZeusTransformUtils.preCheckCast(r10, p.class, "com.obric.memorydata.plugin")).a();
        return;
    L28:
        if (Intrinsics.areEqual(((p) ZeusTransformUtils.preCheckCast(r10, p.class, "com.obric.memorydata.plugin")).a(), com.tom_roush.pdfbox.pdmodel.a.d.f.g) == false) goto L40;
        k();
        r0 = o;
        goto L30
    L40:
        return;
    L32:
        if (ZeusTransformUtils.instanceOf(r10, com.obric.memorydata.ability.data.k.class) == false) goto L42;
        RunLog.INSTANCE.debug("LocationCollector", "receive location data, current state: " + h);
        k();
        if (Intrinsics.areEqual(h, com.tom_roush.pdfbox.pdmodel.a.d.f.f) == false) goto L36;
        g r1 = n;
    L37:
        a(r1);
        ((com.obric.memorydata.ability.data.k) ZeusTransformUtils.preCheckCast(r10, com.obric.memorydata.ability.data.k.class, "com.obric.memorydata.plugin")).collectNewData();
        ((com.obric.memorydata.ability.data.k) ZeusTransformUtils.preCheckCast(r10, com.obric.memorydata.ability.data.k.class, "com.obric.memorydata.plugin")).a();
        return;
    L36:
        r1 = o;
        goto L37
    }

    public final synchronized void b() {
        monitor-enter(this);
        TaskRegister.f12863a.a(AwarenessLocationTask.NAME, AwarenessLocationTask.class);     // Catch: Throwable -> L6
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).registerChangeListener((com.obric.memorydata.middleware.api.store.b) ZeusTransformUtils.preCheckCast(new c(), com.obric.memorydata.middleware.api.store.b.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L6
        com.obric.memorydata.b.a.f8796a.a($$Lambda$a$UhlOsNtQbJ3Mg_XAZLhNAZow8uU.INSTANCE);     // Catch: Throwable -> L6
        ProactiveRecommendationEnabledStore.INSTANCE.registerListener(m, false);     // Catch: Throwable -> L6
        f();     // Catch: Throwable -> L6
        ThreadPoolContainer.Companion.getInstance().execute($$Lambda$a$LimK6MHbTQHPxyCdiaPQTgB2ecg.INSTANCE);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.memorydata.ability.k
    public String g_() {
        return k.a.a(this);
    }
}
