package com.obric.memorydata.memory.contextsync;

import com.obric.memorydata.database.dao.MemoryContextSyncDao;
import com.obric.memorydata.database.entity.cm;
import com.obric.memorydata.database.entity.cn;
import com.obric.memorydata.database.entity.ip;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.memory.ui.list.PendingPersonalInfoNotificationTask;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.impl.NativeTask;
import com.obric.memorydata.task.impl.TaskResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010J\u001e\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010J2\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0007H\u0002J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0015H\u0002J*\u0010\u001c\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J7\u0010\u001e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0019H\u0002¢\u0006\u0002\u0010 JH\u0010!\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J \u0010#\u001a\u00020$2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0007H\u0002J\u0018\u0010%\u001a\u00020$2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u0007H\u0002J(\u0010'\u001a\u00020$2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0007H\u0002J8\u0010(\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J$\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020-0*2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J \u0010.\u001a\u0004\u0018\u00010+*\u00020-2\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J&\u00101\u001a\u00020\u00132\f\u00102\u001a\b\u0012\u0004\u0012\u0002030*2\u0006\u00104\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J(\u00105\u001a\u00020$2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u00106\u001a\u00020\u0013H\u0002J \u00107\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u00108\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J \u00109\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0007H\u0002J\u0016\u0010:\u001a\u00020\u0013*\u0004\u0018\u00010\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0014\u0010;\u001a\u00020\u0017*\u00020\u00152\u0006\u0010<\u001a\u00020\u0007H\u0002J\b\u0010=\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/obric/memorydata/memory/contextsync/MemoryContextSyncWorker;", "", "<init>", "()V", "TAG", "", "SETTINGS_BATCH_BARRIER_MS", "", "runAlignment", "Lcom/obric/memorydata/task/impl/TaskResult;", "task", "Lcom/obric/memorydata/task/impl/NativeTask;", AILabCheckPermissionTask.KEY_SOURCE, "Lcom/obric/memorydata/memory/contextsync/MemoryContextAlignmentSource;", "requestedGeneration", "attempt", "", "runBatch", "handleUnchangedProviderRefresh", "", "snapshot", "Lcom/obric/memorydata/memory/contextsync/MemoryContextSwitchSnapshot;", "state", "Lcom/obric/memorydata/database/entity/MemoryContextSyncStateEntity;", "dao", "Lcom/obric/memorydata/database/dao/MemoryContextSyncDao;", PendingPersonalInfoNotificationTask.KEY_GENERATION, "queryAlignmentSnapshot", "shouldForceFull", "providerFullRequired", "prepareAlignment", "forceFull", "(Lcom/obric/memorydata/memory/contextsync/MemoryContextAlignmentSource;ZZJLcom/obric/memorydata/database/dao/MemoryContextSyncDao;)Ljava/lang/Long;", "finishSettingsAlignment", "userId", "applySettingsSuccess", "", "rebuildFullPending", "successTime", "handleAlignedSemanticChange", "sendPendingBatch", "prepareBatch", "", "Lcom/obric/memorydata/memory/contextsync/MemoryContextBatchItem;", "pending", "Lcom/obric/memorydata/database/entity/MemoryContextSyncPendingEntity;", "toBatchItem", "entity", "Lcom/obric/memorydata/database/entity/UnionSemanticMemoryEntity;", "applyBatchResults", "results", "Lcom/obric/memorydata/memory/contextsync/MemoryContextBatchResult;", "requestCount", "scheduleRemaining", "shouldBackoff", "retryAlignment", "retryBatch", "isCurrent", "matches", "toState", "batchNotBeforeMs", "success", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f10105a = null;

    static {
        f10105a = new h();
    }

    private h() {
    }

    private final cn a(e r10, long r11) {
        return new cn(0, r10.a(), r10.b(), r10.c(), r11, 1, null);
    }

    private final a a(cm r25, ip r26, MemoryContextSyncDao r27) {
        MemoryContextSyncDao r1 = (MemoryContextSyncDao) ZeusTransformUtils.wrapperContextForParams(r27, MemoryContextSyncDao.class, "com.obric.memorydata.plugin");
        Boolean r9 = null;
        if (r25.b() != 1) goto L7;
        if (r26 != null) goto L7;
        r1.replacePendingIfUnchanged(r25.a(), r25.b(), r25.c(), 2, Math.max(System.currentTimeMillis(), r25.c() + 1));
        return null;
    L7:
        String r11 = r25.a();
        int r12 = r25.b();
        if (r26 == null) goto L10;
        Long r15 = Long.valueOf(r26.getCreateTime());
    L11:
        if (r26 == null) goto L13;
        String r16 = r26.getEntityId();
    L14:
        if (r26 == null) goto L16;
        long r0 = r26.getModifyTime();
    L17:
        long r13 = r0;
        long r22 = r25.c();
        if (r26 == null) goto L20;
        String r17 = r26.c();
    L21:
        if (r26 == null) goto L23;
        String r18 = Integer.valueOf(r26.i()).toString();
    L24:
        if (r26 == null) goto L26;
        String r19 = r26.a();
    L27:
        if (r26 == null) goto L29;
        String r20 = r26.b();
    L30:
        if (r26 == null) goto L33;
        r9 = Boolean.valueOf(r26.g());
    L33:
        return new a(r11, r12, r13, r15, r16, r17, r18, r19, r20, r9, r22);
    L29:
        r20 = null;
        goto L30
    L26:
        r19 = null;
        goto L27
    L23:
        r18 = null;
        goto L24
    L20:
        r17 = null;
        goto L21
    L16:
        r0 = r25.c();
        goto L17
    L13:
        r16 = null;
        goto L14
    L10:
        r15 = null;
        goto L11
    }

    private final e a() {
        d.f10097a.a((Function0) ZeusTransformUtils.preCheckCast(new MemoryContextSyncWorker$queryAlignmentSnapshot$1(f.f10102a), Function0.class, "com.obric.memorydata.plugin"));
        return d.f10097a.a();
    }

    private final TaskResult a(long r2, int r4) {
        f.f10102a.a(r2, r4);
        return b();
    }

    private final TaskResult a(MemoryContextAlignmentSource r2, long r3, int r5) {
        f.f10102a.a(r2, r3, r5);
        return b();
    }

    private final TaskResult a(NativeTask r2, MemoryContextAlignmentSource r3, e r4, String r5, long r6, boolean r8, boolean r9, int r10) {
        if (a(r2, r5, r6) == false) goto L5;
        e r0 = d.f10097a.a();
        if (r0 != null) goto L11;
        return a(r3, r6, r10);
    L11:
        if (Intrinsics.areEqual(r0, r4) == true) goto L15;
        f.f10102a.b();
    L14:
        return b();
    L15:
        a(r4, r8, r6);
        if (a(r2, r5, r6) == true) goto L18;
        f.f10102a.c();
        goto L14
    L18:
        if (r9 == false) goto L20;
        f.f10102a.c(r6);
    L20:
        f.f10102a.e();
        goto L14
    L5:
        return b();
    }

    private final TaskResult a(NativeTask r17, String r18, e r19, MemoryContextSyncDao r20, long r21, int r23) {
        MemoryContextSyncDao r1 = (MemoryContextSyncDao) ZeusTransformUtils.wrapperContextForParams(r20, MemoryContextSyncDao.class, "com.obric.memorydata.plugin");
        String r7 = c.f10095a.c(r18);
        List<cm> r8 = r1.queryPending(30);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_MemoryContextSyncWorker", "pending batch loaded, count=" + r8.size() + ", limit=30", false, 4, null);
        if (r8.isEmpty() == false) goto L7;
        if (r7 != null) goto L7;
        return b();
    L7:
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(a(r8, r1), Iterable.class, "com.obric.memorydata.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r9.iterator();
    L8:
        boolean r12 = false;
        if (r11.hasNext() == false) goto L17;
        Object r13 = r11.next();
        a r14 = (a) ZeusTransformUtils.preCheckCast(r13, a.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L13;
    L14:
        r12 = true;
    L15:
        if (r12 == false) goto L8;
        r10.add(r13);
        goto L8
    L13:
        if (r14.b() != 1) goto L15;
    L17:
        List<a> r5 = (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin");
        if (r5.isEmpty() == false) goto L24;
        if (r7 != null) goto L24;
        int r4 = 0;
        boolean r6 = false;
    L21:
        a(r1, r21, r4, r6);
    L23:
        return b();
    L24:
        i r15 = i.f10106a;
        if (r7 == null) goto L27;
        r12 = true;
    L27:
        List<b> r16 = r15.a(r5, r12);
        if (r16 != null) goto L32;
        return a(r21, r23);
    L32:
        if (a(r17, r18, r21) == true) goto L36;
        return b();
    L36:
        if (Intrinsics.areEqual(d.f10097a.a(), r19) == true) goto L38;
        f.f10102a.b();
        goto L23
    L38:
        if (r7 != null) goto L40;
    L43:
        r6 = a(r16, r5.size(), r1);
        r4 = r23;
        goto L21
    L40:
        if (c.f10095a.c(r18, r7) == true) goto L43;
        return a(r21, r23);
    }

    private final Long a(MemoryContextAlignmentSource r7, boolean r8, boolean r9, long r10, MemoryContextSyncDao r12) {
        MemoryContextSyncDao r6 = (MemoryContextSyncDao) ZeusTransformUtils.wrapperContextForParams(r12, MemoryContextSyncDao.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_MemoryContextSyncWorker", "alignment decision, source=" + r7 + ", forceFull=" + r8 + ", providerFullRequired=" + r9 + ", generation=" + r10, false, 4, null);
        if (r8 == false) goto L5;
        if (r9 == false) goto L8;
    L15:
        f.f10102a.d();
    L16:
        r6.clearState();
        return Long.valueOf(r10);
    L8:
        if (r7 == MemoryContextAlignmentSource.PROVIDER_CHANGED) goto L15;
        Long r11 = f.f10102a.a(r10);
        if (r11 == null) goto L13;
        r10 = r11.longValue();
        goto L16
    L13:
        return null;
    L5:
        return Long.valueOf(r10);
    }

    private final List<a> a(List<cm> r7, MemoryContextSyncDao r8) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        MemoryContextSyncDao r9 = (MemoryContextSyncDao) ZeusTransformUtils.wrapperContextForParams(r8, MemoryContextSyncDao.class, "com.obric.memorydata.plugin");
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L11;
        Object r2 = r11.next();
        boolean r4 = true;
        if (((cm) ZeusTransformUtils.preCheckCast(r2, cm.class, "com.obric.memorydata.plugin")).b() == 1) goto L9;
        r4 = false;
    L9:
        if (r4 == false) goto L4;
        r1.add(r2);
        goto L4
    L11:
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r12.iterator();
    L13:
        if (r13.hasNext() == false) goto L15;
        r3.add(((cm) ZeusTransformUtils.preCheckCast(r13.next(), cm.class, "com.obric.memorydata.plugin")).a());
        goto L13
    L15:
        List<String> r14 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
        if (r14.isEmpty() == false) goto L18;
        Map r15 = MapsKt.emptyMap();
    L28:
        List<a> r5 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L30:
        if (r16.hasNext() == false) goto L35;
        cm r17 = (cm) ZeusTransformUtils.preCheckCast(r16.next(), cm.class, "com.obric.memorydata.plugin");
        a r18 = f10105a.a(r17, (ip) ZeusTransformUtils.preCheckCast(r15.get(r17.a()), ip.class, "com.obric.memorydata.plugin"), r9);
        if (r18 == null) goto L30;
        r5.add(r18);
        goto L30
    L35:
        return r5;
    L18:
        Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast(r9.queryTargetSemanticByUuids(r14), Iterable.class, "com.obric.memorydata.plugin");
        Collection r20 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r21 = r19.iterator();
    L20:
        if (r21.hasNext() == false) goto L27;
        ip r22 = (ip) ZeusTransformUtils.preCheckCast(r21.next(), ip.class, "com.obric.memorydata.plugin");
        String r23 = r22.getUuid();
        if (r23 == null) goto L24;
        Pair r24 = TuplesKt.to(r23, r22);
    L25:
        if (r24 == null) goto L20;
        r20.add(r24);
        goto L20
    L24:
        r24 = null;
        goto L25
    L27:
        r15 = MapsKt.toMap((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r20, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        goto L28
    }

    private final void a(MemoryContextSyncDao r2, final long r3) {
        final MemoryContextSyncDao r1 = (MemoryContextSyncDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryContextSyncDao.class, "com.obric.memorydata.plugin");
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().runInTransaction(new $$Lambda$h$Vn8gTb9ih8iAL_fHi_43aTiYCWU(r1, r3));
    }

    private final void a(MemoryContextSyncDao r9, long r10, int r12, boolean r13) {
        if (((MemoryContextSyncDao) ZeusTransformUtils.wrapperContextForParams(r9, MemoryContextSyncDao.class, "com.obric.memorydata.plugin")).countPending() > 0) goto L6;
        f.f10102a.e();
        return;
    L6:
        if (r13 == false) goto L8;
        f.f10102a.a(r10, r12);
        return;
    L8:
        f.a(f.f10102a, r10, 0, 0, 6, null);
    }

    private final void a(e r9, cn r10, MemoryContextSyncDao r11, long r12) {
        MemoryContextSyncDao r8 = (MemoryContextSyncDao) ZeusTransformUtils.wrapperContextForParams(r11, MemoryContextSyncDao.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_MemoryContextSyncWorker", "alignment decision, source=" + MemoryContextAlignmentSource.SEMANTIC_CHANGED + ", forceFull=false, stateMatches=true, generation=" + r12, false, 4, null);
        if (r9.d() == true) goto L6;
        f.f10102a.d();
        r8.clearPending();
        return;
    L6:
        f.a(f.f10102a, r12, 0, RangesKt.coerceAtLeast(r10.e() - System.currentTimeMillis(), 0), 2, null);
    }

    private final void a(e r19, boolean r20, long r21) {
        MemoryContextSyncDao r3 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryContextSyncDao();
        long r4 = System.currentTimeMillis();
        if (r19.d() == true) goto L6;
        f.f10102a.d();
        r3.clearPending();
        r3.upsertState(a(r19, 0));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_MemoryContextSyncWorker", "settings applied, semanticSyncEnabled=false, pendingCleared=true", false, 4, null);
        return;
    L6:
        if (r20 == false) goto L8;
        a(r3, r4);
    L8:
        r3.upsertState(a(r19, r4 + 30000));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_MemoryContextSyncWorker", "settings applied, semanticSyncEnabled=true, forceFull=" + r20 + ", pendingCount=" + r3.countPending() + ", batchDelayMs=30000", false, 4, null);
        f.a(f.f10102a, r21, 0, 30000, 2, null);
    }

    private final boolean a(cn r2, e r3) {
        if (r2 != null) goto L4;
    L10:
        return false;
    L4:
        if (r2.b() != r3.a()) goto L10;
        if (r2.c() != r3.b()) goto L10;
        if (r2.d() != r3.c()) goto L10;
        return true;
    }

    private final boolean a(MemoryContextAlignmentSource r15, e r16, cn r17, MemoryContextSyncDao r18, long r19) {
        MemoryContextSyncDao r1 = (MemoryContextSyncDao) ZeusTransformUtils.wrapperContextForParams(r18, MemoryContextSyncDao.class, "com.obric.memorydata.plugin");
        if (r17 != null) goto L6;
        return false;
    L6:
        if (g.f10104a.a(r15, true, a(r17, r16)) == true) goto L8;
        return false;
    L8:
        f.f10102a.c(r19);
        int r12 = r1.countPending();
        String r2 = f.f10102a.f();
        if (r2 != null) goto L11;
    L16:
        boolean r3 = false;
    L18:
        if (r16.d() == false) goto L22;
        if (r12 > 0) goto L21;
        if (r3 == false) goto L22;
    L21:
        boolean r13 = true;
    L23:
        if (r13 == false) goto L25;
        f.a(f.f10102a, r19, 0, RangesKt.coerceAtLeast(r17.e() - System.currentTimeMillis(), 0), 2, null);
    L25:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_MemoryContextSyncWorker", "provider refresh ignored, reason=settings_snapshot_unchanged, generation=" + r19 + ", pendingCount=" + r12 + ", batchResumed=" + r13, false, 4, null);
        return true;
    L22:
        r13 = false;
        goto L23
    L11:
        if (c.f10095a.c(r2) == null) goto L13;
        boolean r4 = true;
    L14:
        if (r4 != true) goto L16;
        r3 = true;
        goto L18
    L13:
        r4 = false;
        goto L14
    }

    private final boolean a(MemoryContextAlignmentSource r3, boolean r4, cn r5, e r6) {
        g r0 = g.f10104a;
        if (r5 == null) goto L5;
        boolean r1 = true;
    L7:
        return r0.a(r3, r4, r1, a(r5, r6));
    L5:
        r1 = false;
        goto L7
    }

    private final boolean a(NativeTask r1, String r2, long r3) {
        if (r1.isCancelled() == false) goto L5;
    L7:
        return false;
    L5:
        if (f.f10102a.a(r2, r3) == false) goto L7;
        return true;
    }

    private final boolean a(List<b> r11, int r12, MemoryContextSyncDao r13) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        MemoryContextSyncDao r14 = (MemoryContextSyncDao) ZeusTransformUtils.wrapperContextForParams(r13, MemoryContextSyncDao.class, "com.obric.memorydata.plugin");
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r15.hasNext() == false) goto L9;
        b r4 = (b) ZeusTransformUtils.preCheckCast(r15.next(), b.class, "com.obric.memorydata.plugin");
        if (g.f10104a.c(r4.d()) == true) goto L7;
        r3 = r3 + 1;
        goto L4
    L7:
        r2 = r2 + r14.deletePendingIfUnchanged(r4.a(), r4.b(), r4.c());
        goto L4
    L9:
        int r16 = RangesKt.coerceAtLeast(r12 - r10.size(), 0);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_MemoryContextSyncWorker", "batch result applied, terminal=" + r2 + ", retryable=" + r3 + ", missing=" + r16, false, 4, null);
        if (r3 > 0) goto L12;
        if (r16 > 0) goto L12;
        return false;
    L12:
        return true;
    }

    private final TaskResult b() {
        return new TaskResult(0, null, null, null, 14, null);
    }

    private static final void b(MemoryContextSyncDao r2, long r3) {
        MemoryContextSyncDao r4 = (MemoryContextSyncDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryContextSyncDao.class, "com.obric.memorydata.plugin");
        r4.clearPending();
        r4.insertFullPending(r3);
    }

    public static /* synthetic */ void lambda$Vn8gTb9ih8iAL_fHi_43aTiYCWU(MemoryContextSyncDao r0, long r1) {
        b(r0, r1);
    }

    public final TaskResult a(NativeTask r18, long r19, int r21) {
        Intrinsics.checkNotNullParameter(r18, "task");
        String r2 = f.f10102a.f();
        if (r2 != null) goto L7;
        return b();
    L7:
        if (a(r18, r2, r19) == true) goto L11;
        return b();
    L11:
        if (c.f10095a.b(r2) == false) goto L13;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_MemoryContextSyncWorker", "batch start, generation=" + r19 + ", attempt=" + r21, false, 4, null);
        e r3 = d.f10097a.a();
        if (r3 == null) goto L17;
        MemoryContextSyncDao r4 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryContextSyncDao();
        cn r9 = r4.queryState();
        if (r9 != null) goto L21;
    L33:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_MemoryContextSyncWorker", "batch stopped, reason=settings_snapshot_changed", false, 4, null);
        f.f10102a.c();
        return b();
    L21:
        if (a(r9, r3) == false) goto L33;
        if (r3.d() == true) goto L27;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_MemoryContextSyncWorker", "batch stopped, reason=semantic_sync_disabled", false, 4, null);
        f.f10102a.d();
        r4.clearPending();
        return b();
    L27:
        long r10 = r9.e() - System.currentTimeMillis();
        if (r10 <= 0) goto L32;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_MemoryContextSyncWorker", "batch delayed, reason=settings_barrier, delayMs=" + r10, false, 4, null);
        f.f10102a.a(r19, r21, r10);
        return b();
    L32:
        return a(r18, r2, r3, r4, r19, r21);
    L17:
        return a(r19, r21);
    L13:
        return a(r19, r21);
    }

    public final TaskResult a(NativeTask r17, MemoryContextAlignmentSource r18, long r19, int r21) {
        Intrinsics.checkNotNullParameter(r17, "task");
        Intrinsics.checkNotNullParameter(r18, AILabCheckPermissionTask.KEY_SOURCE);
        String r13 = f.f10102a.f();
        if (r13 != null) goto L7;
        return b();
    L7:
        if (f.f10102a.a(r13, r19) == true) goto L11;
        return b();
    L11:
        if (c.f10095a.b(r13) == false) goto L13;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_MemoryContextSyncWorker", "alignment start, source=" + r18 + ", generation=" + r19 + ", attempt=" + r21, false, 4, null);
        e r14 = a();
        if (r14 == null) goto L17;
        MemoryContextSyncDao r15 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryContextSyncDao();
        cn r5 = r15.queryState();
        boolean r6 = f.f10102a.b(r19);
        if (a(r18, r14, r5, r15, r19) == true) goto L21;
        if (r5 != null) goto L24;
    L27:
        boolean r10 = a(r18, r6, r5, r14);
        Long r0 = a(r18, r10, r6, r19, r15);
        if (r0 == null) goto L40;
        long r7 = r0.longValue();
        if (a(r17, r13, r7) == true) goto L34;
        return b();
    L34:
        if (i.f10106a.a(r14) == true) goto L38;
        return a(r18, r7, r21);
    L38:
        return a(r17, r18, r14, r13, r7, r10, r6, r21);
    L40:
        return b();
    L24:
        if (g.f10104a.b(r18, r6, a(r5, r14)) == false) goto L27;
        a(r14, r5, r15, r19);
        return b();
    L21:
        return b();
    L17:
        return a(r18, r19, r21);
    L13:
        return a(r18, r19, r21);
    }
}
