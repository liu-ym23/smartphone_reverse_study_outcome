package com.obric.memorydata.awareness;

import com.obric.memorydata.ability.data.g;
import com.obric.memorydata.ability.data.h;
import com.obric.memorydata.ability.f;
import com.obric.memorydata.ability.k;
import com.obric.memorydata.awareness.api.ILocationSnapshot;
import com.obric.memorydata.database.entity.cl;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u0000H\u0007J\u0018\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\u0018\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J$\u0010\u0016\u001a\u00020\u00172\u001a\u0010\u0018\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u00170\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/awareness/LocationSnapshot;", "Lcom/obric/memorydata/awareness/api/ILocationSnapshot;", "<init>", "()V", "TAG", "", "LOCATION_QUERY_TIMEOUT_MILLIS", "", "locationQueryExecutor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "Ljava/util/concurrent/ExecutorService;", "locationQueryCoordinator", "Lcom/obric/memorydata/awareness/LocationQueryCoordinator;", "getInst", "getLocation", "", "", "effectiveTimeInterval", "getCachedLocation", "isRequesting", "", "queryLocationFromAbility", "", "complete", "Lkotlin/Function1;", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LocationSnapshot implements ILocationSnapshot {
    public static final LocationSnapshot INSTANCE = null;
    private static final long LOCATION_QUERY_TIMEOUT_MILLIS = 10000;
    private static final String TAG = "LocationSnapshot";
    private static final c locationQueryCoordinator = null;
    private static final ExecutorService locationQueryExecutor = null;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/awareness/LocationSnapshot$queryLocationFromAbility$success$1", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "onDataReceive", "", "data", "Lcom/obric/memorydata/ability/data/IStandardData;", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<List<Double>, Unit> f8502a;

        a(Function1<? super List<Double>, Unit> r3) {
            this.f8502a = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        }

        @Override // com.obric.memorydata.ability.k
        public void a(h r6) {
            h r7 = (h) ZeusTransformUtils.wrapperContextForParams(r6, h.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, "data");
            boolean r0 = ZeusTransformUtils.instanceOf(r7, g.class);
            Function1<List<Double>, Unit> r5 = this.f8502a;
            if (r0 == false) goto L5;
            List<Double> r8 = CollectionsKt.listOf(new Double[]{Double.valueOf(((g) ZeusTransformUtils.preCheckCast(r7, g.class, "com.obric.memorydata.plugin")).a()), Double.valueOf(((g) ZeusTransformUtils.preCheckCast(r7, g.class, "com.obric.memorydata.plugin")).b())});
        L6:
            r5.invoke(r8);
            return;
        L5:
            r8 = null;
            goto L6
        }

        @Override // com.obric.memorydata.ability.k
        public String g_() {
            return k.a.a(this);
        }
    }

    static {
        INSTANCE = new LocationSnapshot();
        locationQueryExecutor = Executors.newSingleThreadExecutor($$Lambda$LocationSnapshot$jUHGjAxcyysSsQPmvLVqjquvl78.INSTANCE);
        locationQueryCoordinator = new c(10000, $$Lambda$LocationSnapshot$p0etGMfCVeYRa4jblKtozyo_Oko.INSTANCE);
    }

    private LocationSnapshot() {
    }

    @JvmStatic
    public static final LocationSnapshot getInst() {
        return INSTANCE;
    }

    public static /* synthetic */ void lambda$8SGTyM2SfhlQTXpeKFRLbuuEcYY(Function1 r0) {
        locationQueryCoordinator$lambda$2$lambda$1(r0);
    }

    public static /* synthetic */ Thread lambda$jUHGjAxcyysSsQPmvLVqjquvl78(Runnable r0) {
        return locationQueryExecutor$lambda$0(r0);
    }

    public static /* synthetic */ Unit lambda$p0etGMfCVeYRa4jblKtozyo_Oko(Function1 r0) {
        return locationQueryCoordinator$lambda$2(r0);
    }

    private static final Unit locationQueryCoordinator$lambda$2(Function1 r7) {
        final Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "complete");
        locationQueryExecutor.execute(new $$Lambda$LocationSnapshot$8SGTyM2SfhlQTXpeKFRLbuuEcYY(r8));     // Catch: RejectedExecutionException -> L5
    L7:
        return Unit.INSTANCE;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "location query executor rejected task", null, 4, null);
        r8.invoke(null);
        goto L7
    }

    private static final void locationQueryCoordinator$lambda$2$lambda$1(Function1 r2) {
        Function1<? super List<Double>, Unit> r3 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        INSTANCE.queryLocationFromAbility(r3);
    }

    private static final Thread locationQueryExecutor$lambda$0(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin"), "locationSnapshot-query");
    }

    private final void queryLocationFromAbility(Function1<? super List<Double>, Unit> r5) {
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        if (new com.obric.memorydata.ability.d().query(new f(100000001, MapsKt.emptyMap()), (k) ZeusTransformUtils.preCheckCast(new a(r4), k.class, "com.obric.memorydata.plugin")) == true) goto L6;
        r4.invoke(null);
        return;
    }

    @Override // com.obric.memorydata.awareness.api.ILocationSnapshot
    public List<Double> getCachedLocation(long r7) {
        long r6 = RangesKt.coerceAtLeast(r7, 1000);
        cl r8 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getLocationDao().queryLastRecord();
        if (r8 != null) goto L5;
    L8:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "cached location unavailable", false, 4, null);
        return null;
    L5:
        if ((System.currentTimeMillis() - r8.c()) >= r6) goto L8;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "return cached location", false, 4, null);
        return CollectionsKt.listOf(new Double[]{Double.valueOf(r8.d()), Double.valueOf(r8.e())});
    }

    @Override // com.obric.memorydata.awareness.api.ILocationSnapshot
    public List<Double> getLocation(long r10) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "getLocation effectiveTimeInterval " + r10, false, 4, null);
        List<Double> r9 = getCachedLocation(r10);
        if (r9 == null) goto L5;
        return r9;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "query location from ability", false, 4, null);
        long r11 = System.currentTimeMillis();
        List<Double> r12 = locationQueryCoordinator.a();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "queryLocationFromAbility finished, cost: " + (System.currentTimeMillis() - r11), false, 4, null);
        return r12;
    }

    @Override // com.obric.memorydata.awareness.api.ILocationSnapshot
    public boolean isRequesting() {
        return locationQueryCoordinator.b();
    }
}
