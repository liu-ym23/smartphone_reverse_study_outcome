package com.obric.memorydata.personalcontext.util;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.EntityProvider;
import com.obric.capabilitykit.sync.EntityCheckHashCodeSlotData;
import com.obric.capabilitykit.sync.EntityCountTimeSlotData;
import com.obric.capabilitykit.sync.EntityHashData;
import com.obric.memorydata.constants.DevTrackerEventId;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.index.EntityIndexEngine;
import com.obric.memorydata.database.index.s;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.EntityManager;
import com.obric.memorydata.personalcontext.api.IEntityManager;
import com.obric.memorydata.utils.ah;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007J<\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0007J&\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0007JD\u0010\u001a\u001a\u00020\t2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u00102\u0006\u0010\u001c\u001a\u00020\u00122\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/memorydata/personalcontext/util/EntityDataSyncUtil;", "", "<init>", "()V", "TAG", "", "isSyncAfterEnableApp", "", "setAfterEnableAppSyncFlag", "", "flag", "checkEntityCountDiff", "Ljava/util/ArrayList;", "Lcom/obric/capabilitykit/sync/EntityCountTimeSlotData;", "Lkotlin/collections/ArrayList;", "countTimeSlotDataList", "", "entityType", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "disablePrune", "checkEntityHashCodeDiff", "Lcom/obric/memorydata/personalcontext/util/EntityDataSyncUtil$CheckEntityHashCodeDiffResult;", "checkHashCodeData", "Lcom/obric/capabilitykit/sync/EntityCheckHashCodeSlotData;", "isLazyDeleteDataParam", "getEntityCountDiff", "slotDataList", "currentNodeIndex", "diffResult", "", "CheckEntityHashCodeDiffResult", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f12369a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f12370b;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B;\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\u0004\b\u0007\u0010\bR!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR%\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/personalcontext/util/EntityDataSyncUtil$CheckEntityHashCodeDiffResult;", "", "needUpdateIds", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "needDeleteIds", "<init>", "(Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getNeedUpdateIds", "()Ljava/util/ArrayList;", "getNeedDeleteIds", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ArrayList<String> f12371a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayList<String> f12372b;

        public a(ArrayList<String> r2, ArrayList<String> r3) {
            Intrinsics.checkNotNullParameter(r2, "needUpdateIds");
            this.f12371a = r2;
            this.f12372b = r3;
        }

        public final ArrayList<String> a() {
            return this.f12371a;
        }

        public final ArrayList<String> b() {
            return this.f12372b;
        }
    }

    static {
        f12369a = new e();
    }

    private e() {
    }

    private final void a(List<EntityCountTimeSlotData> r14, int r15, List<EntityCountTimeSlotData> r16, int r17, String r18, boolean r19) {
        List<EntityCountTimeSlotData> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        List<EntityCountTimeSlotData> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin");
        EntityCountTimeSlotData r9 = (EntityCountTimeSlotData) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r7, r15), EntityCountTimeSlotData.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L5;
        return;
    L5:
        if (r19 == true) goto L17;
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r1 = s.a().getRawDaoByEntityType(r17);
        if (r1 == null) goto L9;
        Integer r0 = Integer.valueOf(r1.getCountByPackageNameWithTimeStamp(r18, r9.getStartTime(), r9.getEndTimeLong()));
    L10:
        int r2 = r9.getCount();
        if (r0 == null) goto L17;
        if (r0.intValue() != r2) goto L17;
        return;
    L9:
        r0 = null;
    L17:
        boolean r3 = false;
        boolean r11 = true;
        if (r9.getLeftIndex() == (-1)) goto L21;
        a(r7, r9.getLeftIndex(), r8, r17, r18, r19);
        r3 = true;
    L21:
        if (r9.getRightIndex() == (-1)) goto L23;
        a(r7, r9.getRightIndex(), r8, r17, r18, r19);
    L24:
        if (r11 == true) goto L27;
        r8.add(r9);
        return;
    L27:
        return;
    L23:
        r11 = r3;
        goto L24
    }

    public final a a(EntityCheckHashCodeSlotData r23, int r24, String r25, boolean r26) {
        Intrinsics.checkNotNullParameter(r23, "checkHashCodeData");
        Intrinsics.checkNotNullParameter(r25, ObricMemoryConstants.KEY_PACKAGE_NAME);
        ArrayList r9 = new ArrayList();
        EntityIndexEngine r1 = s.a();
        ArrayList r2 = new ArrayList();
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r3 = r1.getRawDaoByEntityType(r24);
        int r10 = 0;
        if (r26 == false) goto L5;
    L8:
        boolean r12 = true;
    L10:
        if (f12370b == true) goto L12;
        RunLog.INSTANCE.debug("EntityDataSyncUtil", "checkEntityHashCodeDiff, checkHashCodeData: " + r23 + ", entityType: " + r24 + ", packageName: " + r25);
    L12:
        ArrayList r14 = null;
        if (r3 != null) goto L16;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityDataSyncUtil", "checkEntityHashCodeDiff not found rawDao, entityType: " + r24, null, 4, null);
        return new a(r2, null);
    L16:
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r3.getHashCodeListByPackageNameWithTimeStamp(r25, r23.getStartTime(), r23.getEndTime()), Iterable.class, "com.obric.memorydata.plugin");
        Map r5 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r4, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r6 = r4.iterator();
    L18:
        if (r6.hasNext() == false) goto L20;
        Object r7 = r6.next();
        r5.put(((com.obric.memorydata.database.model.c) ZeusTransformUtils.preCheckCast(r7, com.obric.memorydata.database.model.c.class, "com.obric.memorydata.plugin")).a(), r7);
        goto L18
    L20:
        Map r8 = MapsKt.toMutableMap(r5);
        if (f12370b == false) goto L27;
        j r11 = j.f12378a;
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r23.getHashCodeData(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r13.iterator();
    L24:
        if (r16.hasNext() == false) goto L26;
        r15.add(((EntityHashData) ZeusTransformUtils.preCheckCast(r16.next(), EntityHashData.class, "com.obric.memorydata.plugin")).getId());
        goto L24
    L26:
        r11.b((List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin"), r24, r25);
    L27:
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(r23.getHashCodeData(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L29:
        if (r0.hasNext() == false) goto L38;
        EntityHashData r17 = (EntityHashData) ZeusTransformUtils.preCheckCast(r0.next(), EntityHashData.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.database.model.c r18 = (com.obric.memorydata.database.model.c) ZeusTransformUtils.preCheckCast(r8.get(r17.getId()), com.obric.memorydata.database.model.c.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L32;
        r8.remove(r17.getId());
        if (r18.b() == r17.getHashCodeValue()) goto L29;
        RunLog.INSTANCE.debug("EntityDataSyncUtil", "hashCode is diff, id: " + r17.getId() + " appHashCode: " + r17.getHashCodeValue() + " pcHshCode: " + r18.b());
    L33:
        r9.add(r17.getId());
        goto L29
    L32:
        RunLog.INSTANCE.debug("EntityDataSyncUtil", "entity not found, id: " + r17.getId());
        goto L33
    L38:
        if ((!r8.isEmpty()) == false) goto L44;
        ArrayList r19 = new ArrayList();
        r19.addAll((Collection) ZeusTransformUtils.preCheckCast(r8.keySet(), Collection.class, "com.obric.memorydata.plugin"));
        RunLog.INSTANCE.debug("EntityDataSyncUtil", "entities need delete, entityList: " + r19);
        if (r12 == true) goto L43;
        IEntityManager.a.a((IEntityManager) ZeusTransformUtils.preCheckCast(EntityManager.INSTANCE, IEntityManager.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.preCheckCast(r19, List.class, "com.obric.memorydata.plugin"), r24, r25, null, 8, null);
    L43:
        ArrayList r20 = r19;
    L45:
        Collection r21 = (Collection) ZeusTransformUtils.preCheckCast(r20, Collection.class, "com.obric.memorydata.plugin");
        if (r21 != null) goto L48;
    L51:
        boolean r22 = true;
    L52:
        if (r22 == true) goto L54;
    L55:
        JSONObject r27 = new JSONObject();
        r27.put(EntityProvider.KEY_ENTITY_TYPE, r24);
        r27.put("entity_package_name", r25);
        if (r20 == null) goto L58;
        r10 = r20.size();
    L58:
        r27.put("need_delete_entity_size", r10);
        r27.put("need_reindex_entity_size", r9.size());
        ah.a(DevTrackerEventId.ENTITY_CONSISTENCY_STATE, r27);
        IRunLog r110 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        String r28 = r27.toString();
        Intrinsics.checkNotNullExpressionValue(r28, "toString(...)");
        IRunLog.a.a(r110, "EntityDataSyncUtil", r28, false, 4, null);
    L60:
        if (f12370b == false) goto L63;
        j.f12378a.a((List) ZeusTransformUtils.preCheckCast(r20, List.class, "com.obric.memorydata.plugin"), r24, r25);
        r20 = null;
    L63:
        if (r12 == false) goto L66;
        r14 = r20;
    L66:
        return new a(r9, r14);
    L54:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L60;
    L48:
        if (r21.isEmpty() == true) goto L51;
        r22 = false;
        goto L52
    L44:
        r20 = null;
        goto L45
    L5:
        if (f12370b == true) goto L8;
        r12 = false;
        goto L10
    }

    public final ArrayList<EntityCountTimeSlotData> a(List<EntityCountTimeSlotData> r12, int r13, String r14, boolean r15) {
        List<EntityCountTimeSlotData> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "countTimeSlotDataList");
        Intrinsics.checkNotNullParameter(r14, ObricMemoryConstants.KEY_PACKAGE_NAME);
        long r9 = System.currentTimeMillis();
        ArrayList<EntityCountTimeSlotData> r16 = new ArrayList();
        if (r15 == false) goto L5;
    L8:
        boolean r17 = true;
    L9:
        a(r3, 0, (List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.memorydata.plugin"), r13, r14, r17);
        RunLog.INSTANCE.debug("EntityDataSyncUtil", "checkEntityCountDiff, entityType: " + r13 + ", packageName: " + r14 + ", cost: " + (System.currentTimeMillis() - r9));
        return r16;
    L5:
        if (f12370b == true) goto L8;
        r17 = false;
        goto L9
    }

    public final void a(boolean r7) {
        f12370b = r7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityDataSyncUtil", "setAfterEnableAppSyncFlag, flag: " + r7, false, 4, null);
    }
}
