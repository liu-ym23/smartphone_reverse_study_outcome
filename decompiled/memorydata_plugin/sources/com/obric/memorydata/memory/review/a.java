package com.obric.memorydata.memory.review;

import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.obric.memorydata.database.c.f;
import com.obric.memorydata.database.dao.AutoMemoryProDao;
import com.obric.memorydata.database.dao.SemanticMemoryDao;
import com.obric.memorydata.database.entity.AutoMemoryProEntity;
import com.obric.memorydata.database.entity.ip;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.database.manager.PersonalMemoryFrameDb;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.cu;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005J\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u001c\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u001a2\u0006\u0010\u001b\u001a\u00020\u0015H\u0002J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0015H\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/memory/review/MemoryReviewSnapshotMaintenance;", "", "<init>", "()V", "TAG", "", "BACKFILL_PAGE_SIZE", "", "DISTINCT_DAY_CLEANUP_THRESHOLD", "scope", "Lkotlinx/coroutines/CoroutineScope;", "backfillRunning", "Ljava/util/concurrent/atomic/AtomicBoolean;", "cleanupRunning", "enqueueBackfillTodayMissingSnapshots", "", InfoRequestQPSOptTraceLogger.REASON, "enqueueCleanupOldSnapshots", "backfillTodayMissingSnapshots", "backfillAutoMemoryPro", "todayStart", "", "tomorrowStart", "backfillPersonalMemory", "cleanupOldSnapshots", "dayWindow", "Lkotlin/Pair;", "now", "startOfYesterday", "startOfDayCalendar", "Ljava/util/Calendar;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10372a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final al f10373b = null;
    private static final AtomicBoolean c = null;
    private static final AtomicBoolean d = null;

    static {
        f10372a = new a();
        f10373b = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")));
        c = new AtomicBoolean(false);
        d = new AtomicBoolean(false);
    }

    private a() {
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final int a(long r9, long r11) {
        AutoMemoryProDao r8 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getAutoMemoryProDao();
        long r1 = 0;
        int r3 = 0;
    L3:
        List<T> r2 = r8.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM AutoMemoryPro src\nWHERE src.timestamp >= ?\n    AND src.timestamp < ?\n    AND src.id > ?\n    AND NOT EXISTS (\n        SELECT 1 FROM AutoMemoryProSnapShot snapshot\n        WHERE snapshot.auto_memory_pro_id = src.id\n    )\nORDER BY src.id ASC\nLIMIT ?", new Object[]{Long.valueOf(r9), Long.valueOf(r11), Long.valueOf(r1), 100}), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        if (r2.isEmpty() == true) goto L6;
        com.obric.memorydata.database.c.a.f8848a.a(r2);
        r3 = r3 + r2.size();
        r1 = ((AutoMemoryProEntity) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r2), AutoMemoryProEntity.class, "com.obric.memorydata.plugin")).getId();
        goto L3
    L6:
        return r3;
    }

    public static final /* synthetic */ AtomicBoolean a() {
        return c;
    }

    private final Pair<Long, Long> a(long r3) {
        Calendar r2 = c(r3);
        long r4 = r2.getTimeInMillis();
        r2.add(6, 1);
        return TuplesKt.to(Long.valueOf(r4), Long.valueOf(r2.getTimeInMillis()));
    }

    public static final /* synthetic */ void a(a r0, String r1) {
        r0.c(r1);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final int b(long r9, long r11) {
        SemanticMemoryDao r8 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao();
        long r1 = 0;
        int r3 = 0;
    L3:
        List<T> r2 = r8.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM UnionSemanticMemory src\nWHERE src.modifyTime >= ?\n    AND src.modifyTime < ?\n    AND src.id > ?\n    AND src.product_type != ?\n    AND NOT EXISTS (\n        SELECT 1 FROM UnionSemanticMemorySnapShot snapshot\n        WHERE snapshot.union_semantic_memory_id = src.id\n    )\nORDER BY src.id ASC\nLIMIT ?", new Object[]{Long.valueOf(r9), Long.valueOf(r11), Long.valueOf(r1), 1004, 100}), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        if (r2.isEmpty() == true) goto L6;
        f.f8859a.a(r2);
        r3 = r3 + r2.size();
        r1 = ((ip) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r2), ip.class, "com.obric.memorydata.plugin")).getId();
        goto L3
    L6:
        return r3;
    }

    private final long b(long r1) {
        Calendar r0 = c(r1);
        r0.add(6, -1);
        return r0.getTimeInMillis();
    }

    public static final /* synthetic */ AtomicBoolean b() {
        return d;
    }

    public static final /* synthetic */ void b(a r0, String r1) {
        r0.d(r1);
    }

    private final Calendar c(long r1) {
        Calendar r0 = Calendar.getInstance();
        r0.setTimeInMillis(r1);
        r0.set(11, 0);
        r0.set(12, 0);
        r0.set(13, 0);
        r0.set(14, 0);
        Intrinsics.checkNotNullExpressionValue(r0, "apply(...)");
        return r0;
    }

    private final void c(String r9) {
        if (com.obric.memorydata.database.c.b.f8850a.a() == true) goto L5;
        return;
    L5:
        Pair<Long, Long> r0 = a(System.currentTimeMillis());
        long r1 = ((Number) ZeusTransformUtils.preCheckCast(r0.component1(), Number.class, "com.obric.memorydata.plugin")).longValue();
        long r4 = ((Number) ZeusTransformUtils.preCheckCast(r0.component2(), Number.class, "com.obric.memorydata.plugin")).longValue();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryReviewSnapshotMaintenance", "backfill finished, reason=" + r9 + ", autoMemoryPro=" + a(r1, r4) + ", personalMemory=" + b(r1, r4), false, 4, null);
    }

    private final void d(String r18) {
        PersonalMemoryFrameDb r0 = MemoryDbEngine.INSTANCE.getPersonalDbEngine();
        List r1 = CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(r0.getAutoMemoryProSnapShotDao().queryDistinctSnapshotLocalDays(3), Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r0.getUnionSemanticMemorySnapShotDao().queryDistinctSnapshotLocalDays(3), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"));
        if (r1.size() >= 3) goto L5;
        return;
    L5:
        long r2 = b(System.currentTimeMillis());
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryReviewSnapshotMaintenance", "cleanup finished, reason=" + r18 + ", days=" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 0, null, null, 63, null) + ", cutoff=" + r2 + ", deletedAuto=" + r0.getAutoMemoryProSnapShotDao().deleteBeforeSnapshotTime(r2) + ", deletedPersonal=" + r0.getUnionSemanticMemorySnapShotDao().deleteBeforeSnapshotTime(r2), false, 4, null);
    }

    public final void a(String r13) {
        Intrinsics.checkNotNullParameter(r13, InfoRequestQPSOptTraceLogger.REASON);
        if (com.obric.memorydata.database.c.b.f8850a.a() == true) goto L6;
        return;
    L6:
        if (c.compareAndSet(false, true) == true) goto L9;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryReviewSnapshotMaintenance", "backfill already running, reason=" + r13, false, 4, null);
        return;
    L9:
        i.a(f10373b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new MemoryReviewSnapshotMaintenance$enqueueBackfillTodayMissingSnapshots$1(r13, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final void b(String r7) {
        Intrinsics.checkNotNullParameter(r7, InfoRequestQPSOptTraceLogger.REASON);
        if (d.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        i.a(f10373b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new MemoryReviewSnapshotMaintenance$enqueueCleanupOldSnapshots$1(r7, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }
}
