package com.obric.memorydata.database.index;

import android.database.sqlite.SQLiteException;
import androidx.room.RoomDatabase;
import com.obric.aiproactive.impl.livecard.ProactiveLiveCardDisplayTool;
import com.obric.cae.userAware.WifiScanStateMachine;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010/\u001a\u000200J\u0006\u00101\u001a\u000200J\b\u00102\u001a\u000200H\u0016J\b\u00103\u001a\u000200H\u0002J \u00104\u001a\n\u0012\u0004\u0012\u000206\u0018\u0001052\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0002J\u001e\u0010;\u001a\u00020<2\u0006\u00107\u001a\u0002082\f\u0010=\u001a\b\u0012\u0004\u0012\u00020>05H\u0002J\u0016\u0010?\u001a\u00020<2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020605H\u0002J\u0018\u0010@\u001a\u00020<2\u0006\u0010A\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u0013H\u0002J\u0010\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u0005H\u0002J\u001f\u0010F\u001a\u00020<2\u0006\u0010G\u001a\u00020\u00052\f\u0010H\u001a\b\u0012\u0004\u0012\u0002000IH\u0082\bJ\u001f\u0010J\u001a\u00020<2\u0006\u0010G\u001a\u00020\u00052\f\u0010H\u001a\b\u0012\u0004\u0012\u00020<0IH\u0082\bJ\u0018\u0010K\u001a\u0002002\u0006\u0010G\u001a\u00020\u00052\u0006\u0010L\u001a\u00020MH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u001a\u001a\u0004\b\"\u0010#R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u001a\u001a\u0004\b'\u0010(R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u001a\u001a\u0004\b,\u0010-R\u0014\u0010N\u001a\b\u0012\u0004\u0012\u00020\u000505X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/obric/memorydata/database/index/IndexDashboardPeriodicReporter;", "Lcom/obric/memorydata/middleware/api/bdtracker/DailyReportCallback;", "<init>", "()V", "TAG", "", "BACKLOG_EVENT", "COVERAGE_EVENT", "BACKLOG_DAY_KEY", "COVERAGE_HOUR_KEY", "PAGE_SIZE", "", "registered", "Ljava/util/concurrent/atomic/AtomicBoolean;", "opportunityInFlight", "backlogReportLock", "", "dashboardReportLock", "pendingBacklogReport", "Lcom/obric/memorydata/database/index/PendingDashboardReport;", "pendingCoverageReport", "store", "Lcom/obric/memorydata/middleware/api/store/IStore;", "getStore", "()Lcom/obric/memorydata/middleware/api/store/IStore;", "store$delegate", "Lkotlin/Lazy;", "backlogCollector", "Lcom/obric/memorydata/database/index/IndexDashboardBacklogCollector;", "getBacklogCollector", "()Lcom/obric/memorydata/database/index/IndexDashboardBacklogCollector;", "backlogCollector$delegate", "hourlyRunner", "Lcom/obric/memorydata/database/index/IndexDashboardHourlyCoverageRunner;", "getHourlyRunner", "()Lcom/obric/memorydata/database/index/IndexDashboardHourlyCoverageRunner;", "hourlyRunner$delegate", "dailyRunner", "Lcom/obric/memorydata/database/index/IndexDashboardDailyBacklogRunner;", "getDailyRunner", "()Lcom/obric/memorydata/database/index/IndexDashboardDailyBacklogRunner;", "dailyRunner$delegate", "backlogTriggerRouter", "Lcom/obric/memorydata/database/index/IndexDashboardBacklogTriggerRouter;", "getBacklogTriggerRouter", "()Lcom/obric/memorydata/database/index/IndexDashboardBacklogTriggerRouter;", "backlogTriggerRouter$delegate", "register", "", "onNaturalRunOpportunity", "onDailyReport", "scheduleDailyBacklog", "collectCoverage", "", "Lcom/obric/memorydata/database/index/CoverageMetric;", "snapshotAtMs", "", "policy", "Lcom/obric/memorydata/database/index/CoveragePolicyIdentity;", "reportBacklog", "", "metrics", "Lcom/obric/memorydata/database/index/BacklogMetric;", "reportCoverage", "reportDashboardPayloads", "event", "report", "ownerStore", "Lcom/obric/memorydata/database/index/OwnerStore;", "owner", "failOpen", "operation", "block", "Lkotlin/Function0;", "failOpenResult", "logFailure", "error", "", "OWNER_TYPES", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ak implements com.obric.memorydata.middleware.api.bdtracker.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ak f9361a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f9362b = null;
    private static final AtomicBoolean c = null;
    private static final Object d = null;
    private static final Object e = null;
    private static aw f;
    private static aw g;
    private static final Lazy h = null;
    private static final Lazy i = null;
    private static final Lazy j = null;
    private static final Lazy k = null;
    private static final Lazy l = null;
    private static final List<String> m = null;

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/obric/memorydata/database/index/IndexDashboardPeriodicReporter$dailyRunner$2$2", "Lcom/obric/memorydata/database/index/BacklogDayWatermark;", "readUtcDay", "", "saveUtcDay", "", "utcDay", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements com.obric.memorydata.database.index.a {
        a() {
        }

        @Override // com.obric.memorydata.database.index.a
        public long a() {
            return ak.a(ak.f9361a).getLong("index_dashboard_backlog_attempted_utc_day", Long.MIN_VALUE);
        }

        @Override // com.obric.memorydata.database.index.a
        public boolean a(long r2) {
            return ak.a(ak.f9361a).syncSave("index_dashboard_backlog_attempted_utc_day", r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/obric/memorydata/database/index/IndexDashboardPeriodicReporter$hourlyRunner$2$2", "Lcom/obric/memorydata/database/index/CoverageHourWatermark;", "readUtcHour", "", "saveUtcHour", "", "utcHour", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements g {
        b() {
        }

        @Override // com.obric.memorydata.database.index.g
        public long a() {
            return ak.a(ak.f9361a).getLong("index_dashboard_coverage_attempted_utc_hour", Long.MIN_VALUE);
        }

        @Override // com.obric.memorydata.database.index.g
        public boolean a(long r2) {
            return ak.a(ak.f9361a).syncSave("index_dashboard_coverage_attempted_utc_hour", r2);
        }
    }

    static {
        f9361a = new ak();
        f9362b = new AtomicBoolean(false);
        c = new AtomicBoolean(false);
        d = new Object();
        e = new Object();
        h = LazyKt.lazy($$Lambda$ak$pKyprOMIgbwD7PMlNj2XSrpqj8.INSTANCE);
        i = LazyKt.lazy($$Lambda$ak$SULOa8BIftS05q1Wi4ebDa7VckQ.INSTANCE);
        j = LazyKt.lazy($$Lambda$ak$qX9ShxjufJGGzplvMahxL5aFrQE.INSTANCE);
        k = LazyKt.lazy($$Lambda$ak$ZYcCVkcgT_ke7vLwXitkjM3xUwA.INSTANCE);
        l = LazyKt.lazy($$Lambda$ak$tvggdjv1ZhuaP6V1VOvVWeSNnPc.INSTANCE);
        m = CollectionsKt.listOf(new String[]{"PUBLIC", "USER"});
    }

    private ak() {
    }

    private static final long a(IAppEntityRawDbDao r2) {
        return ((IAppEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin")).queryAllCount();
    }

    private final av a(String r3) {
        if (Intrinsics.areEqual(r3, "PUBLIC") == false) goto L6;
        return new av((RoomDatabase) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine(), RoomDatabase.class, "com.obric.memorydata.plugin"), MemoryDbEngine.INSTANCE.getGlobalDbEngine().getIndexPendingDao(), MemoryDbEngine.INSTANCE.getGlobalDbEngine().getEntityIndexLifecycleDao());
    L6:
        if (Intrinsics.areEqual(r3, "USER") == false) goto L10;
        return new av((RoomDatabase) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine(), RoomDatabase.class, "com.obric.memorydata.plugin"), MemoryDbEngine.INSTANCE.getPersonalDbEngine().getIndexPendingDao(), MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEntityIndexLifecycleDao());
    L10:
        throw new IllegalStateException(("unknown owner=" + r3).toString());
    }

    private static final j a(EntityIndexEngine r3, int r4) {
        final IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r5 = r3.getRawDaoByEntityType(r4);
        if (r5 == null) goto L7;
        return new j((Function2) ZeusTransformUtils.preCheckCast(new IndexDashboardPeriodicReporter$collectCoverage$unknownPolicyCount$1$1$1(r5), Function2.class, "com.obric.memorydata.plugin"), new $$Lambda$ak$NMjOpDL9agpR5WPxLgjJTlpyNE8(r5));
    L7:
        throw new IllegalStateException("missing raw dao for registered entityType=" + r4);
    }

    public static final /* synthetic */ IStore a(ak r0) {
        return r0.d();
    }

    private static final List a(long r2) {
        return f9361a.e().a(r2, IndexDashboardCoverageV1Policy.f9304a.a());
    }

    private final List<h> a(long r19, i r21) {
        final EntityIndexEngine r0 = s.a();     // Catch: RuntimeException -> L41 SQLiteException -> L45
        ae r3 = new ae(r21.a(), IndexDashboardCoverageV1Policy.f9304a.a(), r19);     // Catch: RuntimeException -> L41 SQLiteException -> L45
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sorted((Iterable) ZeusTransformUtils.preCheckCast(IndexDashboardCoverageV1Policy.f9304a.a(), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L41 SQLiteException -> L45
        com.obric.memorydata.database.manager.c r5 = com.obric.memorydata.database.manager.c.f9561a;     // Catch: RuntimeException -> L41 SQLiteException -> L45
        Map r6 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L41 SQLiteException -> L45
        Iterator r7 = r4.iterator();     // Catch: RuntimeException -> L41 SQLiteException -> L45
    L5:
        if (r7.hasNext() == false) goto L10;
        Object r8 = r7.next();     // Catch: RuntimeException -> L41 SQLiteException -> L45
        String r9 = r5.a(((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).intValue());     // Catch: RuntimeException -> L41 SQLiteException -> L45
        Object r10 = r6.get(r9);     // Catch: RuntimeException -> L41 SQLiteException -> L45
        if (r10 != null) goto L9;
        r10 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L41 SQLiteException -> L45
        r6.put(r9, r10);     // Catch: RuntimeException -> L41 SQLiteException -> L45
    L9:
        ((List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin")).add(r8);     // Catch: RuntimeException -> L41 SQLiteException -> L45
        goto L5
    L10:
        Set<Integer> r11 = r0.getEntityIndexImplMap().keySet();     // Catch: RuntimeException -> L41 SQLiteException -> L45
        Intrinsics.checkNotNullExpressionValue(r11, "<get-keys>(...)");     // Catch: RuntimeException -> L41 SQLiteException -> L45
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L41 SQLiteException -> L45
        Set<Integer> r13 = IndexDashboardCoverageV1Policy.f9304a.a();     // Catch: RuntimeException -> L41 SQLiteException -> L45
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L41 SQLiteException -> L45
        Iterator r15 = r12.iterator();     // Catch: RuntimeException -> L41 SQLiteException -> L45
    L12:
        if (r15.hasNext() == false) goto L16;
        Object r16 = r15.next();     // Catch: RuntimeException -> L41 SQLiteException -> L45
        if (r13.contains(Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r16, Number.class, "com.obric.memorydata.plugin")).intValue())) == true) goto L12;
        r14.add(r16);     // Catch: RuntimeException -> L41 SQLiteException -> L45
        goto L12
    L16:
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L41 SQLiteException -> L45
        Set<Integer> r18 = IndexDashboardCoverageV1Policy.f9304a.b();     // Catch: RuntimeException -> L41 SQLiteException -> L45
        Collection r20 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L41 SQLiteException -> L45
        Iterator r22 = r17.iterator();     // Catch: RuntimeException -> L41 SQLiteException -> L45
    L18:
        if (r22.hasNext() == false) goto L22;
        Object r23 = r22.next();     // Catch: RuntimeException -> L41 SQLiteException -> L45
        if (r18.contains(Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r23, Number.class, "com.obric.memorydata.plugin")).intValue())) == true) goto L18;
        r20.add(r23);     // Catch: RuntimeException -> L41 SQLiteException -> L45
        goto L18
    L22:
        Iterable r24 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sorted((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r20, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L41 SQLiteException -> L45
        com.obric.memorydata.database.manager.c r25 = com.obric.memorydata.database.manager.c.f9561a;     // Catch: RuntimeException -> L41 SQLiteException -> L45
        Map r26 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L41 SQLiteException -> L45
        Iterator r27 = r24.iterator();     // Catch: RuntimeException -> L41 SQLiteException -> L45
    L24:
        if (r27.hasNext() == false) goto L29;
        Object r28 = r27.next();     // Catch: RuntimeException -> L41 SQLiteException -> L45
        String r29 = r25.a(((Number) ZeusTransformUtils.preCheckCast(r28, Number.class, "com.obric.memorydata.plugin")).intValue());     // Catch: RuntimeException -> L41 SQLiteException -> L45
        Object r110 = r26.get(r29);     // Catch: RuntimeException -> L41 SQLiteException -> L45
        if (r110 != null) goto L28;
        r110 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L41 SQLiteException -> L45
        r26.put(r29, r110);     // Catch: RuntimeException -> L41 SQLiteException -> L45
    L28:
        ((List) ZeusTransformUtils.preCheckCast(r110, List.class, "com.obric.memorydata.plugin")).add(r28);     // Catch: RuntimeException -> L41 SQLiteException -> L45
        goto L24
    L29:
        long r30 = 0;
        Iterator r31 = ((Iterable) ZeusTransformUtils.preCheckCast(m, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: RuntimeException -> L41 SQLiteException -> L45
    L31:
        if (r31.hasNext() == false) goto L39;
        String r111 = (String) ZeusTransformUtils.preCheckCast(r31.next(), String.class, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L41 SQLiteException -> L45
        av r112 = f9361a.a(r111);     // Catch: RuntimeException -> L41 SQLiteException -> L45
        int r113 = r21.a();     // Catch: RuntimeException -> L41 SQLiteException -> L45
        List r32 = (List) ZeusTransformUtils.preCheckCast(r6.get(r111), List.class, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L41 SQLiteException -> L45
        if (r32 != null) goto L35;
        r32 = CollectionsKt.emptyList();     // Catch: RuntimeException -> L41 SQLiteException -> L45
    L35:
        List r114 = r32;
        List r33 = (List) ZeusTransformUtils.preCheckCast(r26.get(r111), List.class, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L41 SQLiteException -> L45
        if (r33 != null) goto L38;
        r33 = CollectionsKt.emptyList();     // Catch: RuntimeException -> L41 SQLiteException -> L45
    L38:
        r30 = r30 + al.a(r111, r112, r113, 500, r114, r33, new $$Lambda$ak$Bw_j7xzXOkkvBo1wRWfTEJR_eoo(r0), (Function1) ZeusTransformUtils.preCheckCast(new IndexDashboardPeriodicReporter$collectCoverage$unknownPolicyCount$1$2(r3), Function1.class, "com.obric.memorydata.plugin"));     // Catch: RuntimeException -> L41 SQLiteException -> L45
        goto L31
    L39:
        goto L43
    L67:
        return r3.a(r30);
    L41:
        e = move-exception;
        a("coverage collection", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    L43:
        return null;
    }

    private final void a(String r3, Throwable r4) {
        RunLog.INSTANCE.error("IndexDashboardPeriodicReporter", r3 + " failed", r4);     // Catch: Throwable -> L4
        return;
    }

    private final boolean a(long r12, List<com.obric.memorydata.database.index.b> r14) {
        List<com.obric.memorydata.database.index.b> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        long r5 = Math.floorDiv(r12, WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS) * WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS;
        Object r15 = e;
        monitor-enter(r15);
        aw r0 = f;     // Catch: Throwable -> L19
        if (r0 != null) goto L7;
    L15:
        r0 = new aw(r5, aj.f9360a.a(r12, r11), null, 4, null);     // Catch: Throwable -> L19
    L16:
        ak r13 = f9361a;     // Catch: Throwable -> L19
        f = r0;     // Catch: Throwable -> L19
        boolean r16 = r13.a("entity_index_dashboard_backlog", r0);     // Catch: Throwable -> L19
        monitor-exit(r15);
        return r16;
    L7:
        if (r0.a() != r5) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == true) goto L13;
        r0 = null;
    L13:
        if (r0 == null) goto L15;
    L9:
        r1 = false;
    L19:
        th = move-exception;
        throw th;
    }

    public static final /* synthetic */ boolean a(ak r2, List r3) {
        return r2.a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    private final boolean a(final String r3, final aw r4) {
        return r4.c().a(r4.b().size(), new $$Lambda$ak$y_SQq8AongFGRlhDKpxzyLxlTB8(r3, r4));
    }

    private static final boolean a(String r2, aw r3, int r4) {
        return Tracker.INSTANCE.reportEventAccepted(r2, (JSONObject) ZeusTransformUtils.preCheckCast(r3.b().get(r4), JSONObject.class, "com.obric.memorydata.plugin"));
    }

    private final boolean a(List<h> r18) {
        List<h> r0 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        h r4 = (h) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r0), h.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
        boolean r5 = true;
        if (r4 == null) goto L33;
        long r11 = Math.floorDiv(r4.l(), ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS) * ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS;     // Catch: Throwable -> L26
        Object r6 = e;     // Catch: Throwable -> L26
        monitor-enter(r6);     // Catch: Throwable -> L26
        aw r7 = g;     // Catch: Throwable -> L22
        if (r7 != null) goto L10;
    L18:
        r7 = new aw(r11, aj.f9360a.a(r0), null, 4, null);     // Catch: Throwable -> L22
    L19:
        ak r1 = f9361a;     // Catch: Throwable -> L22
        g = r7;     // Catch: Throwable -> L22
        boolean r2 = r1.a("entity_index_dashboard_coverage", r7);     // Catch: Throwable -> L22
        monitor-exit(r6);     // Catch: Throwable -> L26 Throwable -> L26
        return r2;
    L10:
        if (r7.a() == r11) goto L13;
        r5 = false;
    L13:
        if (r5 == true) goto L16;
        r7 = null;
    L16:
        if (r7 == null) goto L18;
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26 Throwable -> L26
    L33:
        return true;
    L26:
        e = move-exception;
        a("report coverage", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return false;
    }

    private static final List b(long r1, i r3) {
        Intrinsics.checkNotNullParameter(r3, "policy");
        return f9361a.a(r1, r3);
    }

    private static final List b(String r13) {
        Intrinsics.checkNotNullParameter(r13, "owner");
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(f9361a.a(r13).c().queryBacklogRows(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        aa r3 = (aa) ZeusTransformUtils.preCheckCast(r2.next(), aa.class, "com.obric.memorydata.plugin");
        r1.add(new d(r13, r3.a(), r3.b(), r3.c(), r3.d()));
        goto L4
    L7:
        return (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void b(ak r0) {
        r0.i();
    }

    private static final boolean b(long r4, List r6) {
        List<com.obric.memorydata.database.index.b> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "metrics");
        ak r0 = f9361a;
        return r0.a(r4, r7);
    L5:
        e = move-exception;
        r0.a("report backlog", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return false;
    }

    private final IStore d() {
        return (IStore) ZeusTransformUtils.preCheckCast(h.getValue(), IStore.class, "com.obric.memorydata.plugin");
    }

    private final ac e() {
        return (ac) ZeusTransformUtils.preCheckCast(i.getValue(), ac.class, "com.obric.memorydata.plugin");
    }

    private final ag f() {
        return (ag) ZeusTransformUtils.preCheckCast(j.getValue(), ag.class, "com.obric.memorydata.plugin");
    }

    private final af g() {
        return (af) ZeusTransformUtils.preCheckCast(k.getValue(), af.class, "com.obric.memorydata.plugin");
    }

    private final ad h() {
        return (ad) ZeusTransformUtils.preCheckCast(l.getValue(), ad.class, "com.obric.memorydata.plugin");
    }

    private final void i() {
        ThreadPoolContainer.Companion.execute($$Lambda$ak$5QiIPZv_nYwgIHYxscQLf6dGOts.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        e = move-exception;
        a("schedule daily backlog", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    private static final IStore j() {
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
    }

    private static final ac k() {
        return new ac($$Lambda$ak$UprX86qpPeEEVrIfmOSGbOCzSPY.INSTANCE);
    }

    private static final i l() {
        return new i(1);
    }

    public static /* synthetic */ i lambda$2tSeHIldBeQW3N3WJTET9puZ77U() {
        return l();
    }

    public static /* synthetic */ void lambda$5QiIPZv_nYwgIHYxscQLf6dGOts() {
        r();
    }

    public static /* synthetic */ List lambda$AKJeZSgYz3ARifGQv8gNKtKIryY(long r0) {
        return a(r0);
    }

    public static /* synthetic */ j lambda$Bw_j7xzXOkkvBo1wRWfTEJR_eoo(EntityIndexEngine r0, int r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ long lambda$NMjOpDL9agpR5WPxLgjJTlpyNE8(IAppEntityRawDbDao r2) {
        return a(r2);
    }

    public static /* synthetic */ void lambda$NQJha2WtFgAzet67iVZkcmRC6yQ() {
        q();
    }

    public static /* synthetic */ boolean lambda$OAtM4dqe6N4CxFPGaKLSApZ_mIc(long r0, List r2) {
        return b(r0, r2);
    }

    public static /* synthetic */ Unit lambda$QcYCCgfrEQHVDpJIJC6pm90vOZ0() {
        return o();
    }

    public static /* synthetic */ ac lambda$SULOa8BIftS05q1Wi4ebDa7VckQ() {
        return k();
    }

    public static /* synthetic */ List lambda$UprX86qpPeEEVrIfmOSGbOCzSPY(String r0) {
        return b(r0);
    }

    public static /* synthetic */ af lambda$ZYcCVkcgT_ke7vLwXitkjM3xUwA() {
        return n();
    }

    /* JADX INFO: renamed from: lambda$pKyprOMI-gbwD7PMlNj2XSrpqj8, reason: not valid java name */
    public static /* synthetic */ IStore m562lambda$pKyprOMIgbwD7PMlNj2XSrpqj8() {
        return j();
    }

    public static /* synthetic */ ag lambda$qX9ShxjufJGGzplvMahxL5aFrQE() {
        return m();
    }

    public static /* synthetic */ ad lambda$tvggdjv1ZhuaP6V1VOvVWeSNnPc() {
        return p();
    }

    /* JADX INFO: renamed from: lambda$vx4AaIKj8ek58vbqC0Z-A2xYvaM, reason: not valid java name */
    public static /* synthetic */ List m563lambda$vx4AaIKj8ek58vbqC0ZA2xYvaM(long r0, i r2) {
        return b(r0, r2);
    }

    public static /* synthetic */ boolean lambda$y_SQq8AongFGRlhDKpxzyLxlTB8(String r0, aw r1, int r2) {
        return a(r0, r1, r2);
    }

    private static final ag m() {
        return new ag((Function0) ZeusTransformUtils.preCheckCast(IndexDashboardPeriodicReporter$hourlyRunner$2$1.INSTANCE, Function0.class, "com.obric.memorydata.plugin"), (g) ZeusTransformUtils.preCheckCast(new b(), g.class, "com.obric.memorydata.plugin"), $$Lambda$ak$2tSeHIldBeQW3N3WJTET9puZ77U.INSTANCE, $$Lambda$ak$vx4AaIKj8ek58vbqC0ZA2xYvaM.INSTANCE, (Function1) ZeusTransformUtils.preCheckCast(new IndexDashboardPeriodicReporter$hourlyRunner$2$5(f9361a), Function1.class, "com.obric.memorydata.plugin"));
    }

    private static final af n() {
        return new af((Function0) ZeusTransformUtils.preCheckCast(IndexDashboardPeriodicReporter$dailyRunner$2$1.INSTANCE, Function0.class, "com.obric.memorydata.plugin"), (com.obric.memorydata.database.index.a) ZeusTransformUtils.preCheckCast(new a(), com.obric.memorydata.database.index.a.class, "com.obric.memorydata.plugin"), $$Lambda$ak$AKJeZSgYz3ARifGQv8gNKtKIryY.INSTANCE, $$Lambda$ak$OAtM4dqe6N4CxFPGaKLSApZ_mIc.INSTANCE);
    }

    private static final Unit o() {
        Tracker.INSTANCE.startDailyReport();
        return Unit.INSTANCE;
    }

    private static final ad p() {
        return new ad($$Lambda$ak$QcYCCgfrEQHVDpJIJC6pm90vOZ0.INSTANCE, (Function0) ZeusTransformUtils.preCheckCast(new IndexDashboardPeriodicReporter$backlogTriggerRouter$2$2(f9361a), Function0.class, "com.obric.memorydata.plugin"));
    }

    private static final void q() {
        ak r2 = f9361a;     // Catch: Throwable -> L22
        r2.h().a();     // Catch: LinkageError -> L6 RuntimeException -> L9 Throwable -> L22
    L11:
        ak r3 = f9361a;     // Catch: Throwable -> L22
        r3.f().a();     // Catch: LinkageError -> L14 RuntimeException -> L17 Throwable -> L22
    L20:
        c.set(false);
        return;
    L14:
        e = move-exception;
        Throwable r0 = (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
    L16:
        r3.a("hourly coverage", r0);     // Catch: Throwable -> L22
    L17:
        e = move-exception;
        r0 = (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        goto L16
    L6:
        e = move-exception;
        Throwable r4 = (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
    L8:
        r2.a("start daily report", r4);     // Catch: Throwable -> L22
    L9:
        e = move-exception;
        r4 = (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        c.set(false);
        throw th;
    }

    private static final void r() {
        ak r0 = f9361a;
        Object r2 = d;     // Catch: Throwable -> L11
        monitor-enter(r2);     // Catch: Throwable -> L11
        r0.g().a();     // Catch: Throwable -> L8
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r2);     // Catch: Throwable -> L11 Throwable -> L11
        return;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11 Throwable -> L11
    L11:
        e = move-exception;
        r0.a("daily backlog", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.middleware.api.bdtracker.a
    public void a() {
        h().b();
    }

    public final void b() {
        if (f9362b.compareAndSet(false, true) == false) goto L11;
        Tracker.INSTANCE.registerDailyReportCallback((com.obric.memorydata.middleware.api.bdtracker.a) ZeusTransformUtils.preCheckCast(this, com.obric.memorydata.middleware.api.bdtracker.a.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L6
        return;
    L6:
        e = move-exception;
        f9362b.set(false);
        a("register daily callback", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return;
    }

    public final void c() {
        b();
        long r2 = System.currentTimeMillis();
        long r4 = Math.floorDiv(r2, ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS);
        long r3 = Math.floorDiv(r2, WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS);
        if (r4 > d().getLong("index_dashboard_coverage_attempted_utc_hour", Long.MIN_VALUE)) goto L8;
        if (r3 > d().getLong("index_dashboard_backlog_attempted_utc_day", Long.MIN_VALUE)) goto L8;
        return;
    L8:
        if (c.compareAndSet(false, true) == true) goto L15;
        return;
    L15:
        ThreadPoolContainer.Companion.execute($$Lambda$ak$NQJha2WtFgAzet67iVZkcmRC6yQ.INSTANCE);     // Catch: Throwable -> L12
        return;
    L12:
        e = move-exception;
        c.set(false);
        a("schedule natural opportunity", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }
}
