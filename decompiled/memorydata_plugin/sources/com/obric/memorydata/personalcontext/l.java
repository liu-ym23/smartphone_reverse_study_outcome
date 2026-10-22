package com.obric.memorydata.personalcontext;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.EntityClassData;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.memorydata.database.backup.appentity.AbstractFakeAppEntity;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.dao.IHistoryEntityDao;
import com.obric.memorydata.database.dao.IndexPendingDao;
import com.obric.memorydata.database.entity.cd;
import com.obric.memorydata.database.entity.cu;
import com.obric.memorydata.database.index.ao;
import com.obric.memorydata.database.index.aq;
import com.obric.memorydata.database.index.ax;
import com.obric.memorydata.database.index.bc;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u000fJ\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u000e\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001cJ\u001e\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001cJ\u001e\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005J$\u0010!\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00052\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050\fJ \u0010#\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005J,\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/memorydata/personalcontext/LazyIndexModeHelper;", "", "<init>", "()V", "TAG", "", "BULK_PRE_INDEX_BATCH_SIZE", "", "getLazyIndexEntityIds", "", "Lkotlin/Pair;", "entities", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "isLazyIndexEntity", "", "type", ObricMemoryConstants.KEY_PACKAGE_NAME, "isBackUp", "index", "reallyIndex", "entityPendingEntity", "Lcom/obric/memorydata/database/entity/IndexPendingEntity;", "buildEntityFromJson", "json", "removeLazyIndexHistoryEntity", "", "dbId", "", "resumeLazyIndexPendingTask", "rawDbId", "deleteLazyIndexHistoryEntity", "entityId", "deleteLazyIndexHistoryEntityList", "entityIds", "getLazyIndexHistoryEntity", "indexByType", "indexEntities", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f12228a = null;

    static {
        f12228a = new l();
    }

    private l() {
    }

    private final AppEntity a(String r4) {
        JsonObject r3 = new JsonParser().parse(r4).getAsJsonObject();
        JsonElement r0 = r3.get(AbstractFakeAppEntity.FAKE_ENTITY_FLAG);
        if (r0 == null) goto L5;
        Boolean r1 = Boolean.valueOf(r0.getAsBoolean());
    L7:
        if (Intrinsics.areEqual(r1, true) == false) goto L11;
        AbstractFakeAppEntity.a r5 = AbstractFakeAppEntity.Companion;
        Intrinsics.checkNotNull(r3);
        Object r6 = r5.a(r3);
    L10:
        return (AppEntity) ZeusTransformUtils.preCheckCast(r6, AppEntity.class, "com.obric.memorydata.plugin");
    L11:
        int r7 = r3.get("type").getAsInt();
        EntityClassData r2 = (EntityClassData) ZeusTransformUtils.preCheckCast(EntityType.INSTANCE.getClassMap().get(Integer.valueOf(r7)), EntityClassData.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L17;
        Class r8 = r2.getClazz();
        if (r8 == null) goto L17;
        r6 = EntityExtKt.getEntityKeepTimeStampGson().fromJson(r4, r8);
    L17:
        throw new IllegalArgumentException("Unknown entity type: " + r7);
    L5:
        r1 = null;
        goto L7
    }

    private final synchronized List<String> a(List<? extends AppEntity> r52, int r53, String r54) {
        int r14 = r53;
        monitor-enter(this);
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r52, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        Map r4 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        Iterator r5 = r3.iterator();     // Catch: Throwable -> L169
    L6:
        if (r5.hasNext() == false) goto L11;
        Object r6 = r5.next();     // Catch: Throwable -> L169
        String r7 = ((AppEntity) ZeusTransformUtils.preCheckCast(r6, AppEntity.class, "com.obric.memorydata.plugin")).getId();     // Catch: Throwable -> L169
        Object r8 = r4.get(r7);     // Catch: Throwable -> L169
        if (r8 != null) goto L10;
        r8 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        r4.put(r7, r8);     // Catch: Throwable -> L169
    L10:
        ((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin")).add(r6);     // Catch: Throwable -> L169
        goto L6
    L11:
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r4.size()), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        Iterator r10 = r4.entrySet().iterator();     // Catch: Throwable -> L169
    L13:
        if (r10.hasNext() == false) goto L15;
        r9.add((AppEntity) ZeusTransformUtils.preCheckCast(CollectionsKt.last((List) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), List.class, "com.obric.memorydata.plugin")), AppEntity.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L169
        goto L13
    L15:
        List r11 = (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r12 = com.obric.memorydata.database.index.s.a().getRawDaoByEntityType(r14);     // Catch: Throwable -> L169
        if (r12 == null) goto L168;
        IHistoryEntityDao<com.obric.memorydata.database.entity.c> r13 = com.obric.memorydata.database.index.s.a().getHistoryEntityDao(r14);     // Catch: Throwable -> L169
        if (r13 == null) goto L166;
        com.obric.memorydata.personalcontext.storage.a r15 = q.f12255a.a(r14, ZeusTransformUtils.instanceOf(CollectionsKt.firstOrNull(r2), AbstractFakeAppEntity.class));     // Catch: Throwable -> L169
        if (r15 == null) goto L164;
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        Iterator r18 = r16.iterator();     // Catch: Throwable -> L169
    L23:
        if (r18.hasNext() == false) goto L25;
        r17.add(((AppEntity) ZeusTransformUtils.preCheckCast(r18.next(), AppEntity.class, "com.obric.memorydata.plugin")).getId());     // Catch: Throwable -> L169
        goto L23
    L25:
        List<String> r19 = (List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        Iterable r20 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        Map<String, ? extends AppEntity> r110 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r20, 10)), 16)), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        Iterator r21 = r20.iterator();     // Catch: Throwable -> L169
    L27:
        if (r21.hasNext() == false) goto L29;
        Object r22 = r21.next();     // Catch: Throwable -> L169
        r110.put(((AppEntity) ZeusTransformUtils.preCheckCast(r22, AppEntity.class, "com.obric.memorydata.plugin")).getId(), r22);     // Catch: Throwable -> L169
        goto L27
    L29:
        Iterable r23 = (Iterable) ZeusTransformUtils.preCheckCast(r13.queryByEntityIdListAndPackageName(r19, r54), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        Collection r24 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r23, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        Iterator r25 = r23.iterator();     // Catch: Throwable -> L169
    L31:
        if (r25.hasNext() == false) goto L33;
        r24.add(((com.obric.memorydata.database.entity.c) ZeusTransformUtils.preCheckCast(r25.next(), com.obric.memorydata.database.entity.c.class, "com.obric.memorydata.plugin")).getRawDbEntity().getEntityId());     // Catch: Throwable -> L169
        goto L31
    L33:
        Set r26 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r24, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L169
        List<T> r1 = r12.queryByEntityIdListAndPackageName(r19, r54);     // Catch: Throwable -> L169
        Iterable r27 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        Map r28 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r27, 10)), 16)), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        Iterator r29 = r27.iterator();     // Catch: Throwable -> L169
    L35:
        if (r29.hasNext() == false) goto L37;
        Object r111 = r29.next();     // Catch: Throwable -> L169
        r28.put(((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r111, com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin")).getEntityId(), r111);     // Catch: Throwable -> L169
        goto L35
    L37:
        Iterable r30 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        Collection r112 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r30, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        Iterator r31 = r30.iterator();     // Catch: Throwable -> L169
    L39:
        if (r31.hasNext() == false) goto L41;
        r112.add(Long.valueOf(((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r31.next(), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin")).getId()));     // Catch: Throwable -> L169
        goto L39
    L41:
        List<Long> r32 = (List) ZeusTransformUtils.preCheckCast(r112, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r32, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L44;
        List<cd> r33 = com.obric.memorydata.database.manager.c.f9561a.b(r14).queryWithRawDbIdsAndColumn(r32, r14, "lazy_index_task");     // Catch: Throwable -> L169
    L45:
        if (r33 == null) goto L52;
        Iterable r34 = (Iterable) ZeusTransformUtils.preCheckCast(r33, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        Collection r113 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r34, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        Iterator r35 = r34.iterator();     // Catch: Throwable -> L169
    L48:
        if (r35.hasNext() == false) goto L50;
        r113.add(Long.valueOf(((cd) ZeusTransformUtils.preCheckCast(r35.next(), cd.class, "com.obric.memorydata.plugin")).b()));     // Catch: Throwable -> L169
        goto L48
    L50:
        Set r36 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r113, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L169
        if (r36 == null) goto L52;
    L53:
        List<com.obric.memorydata.database.entity.c> r37 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        Iterator r38 = r1.iterator();     // Catch: Throwable -> L169
    L55:
        if (r38.hasNext() == false) goto L67;
        com.obric.memorydata.database.entity.d r114 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r38.next(), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        if (r26.contains(r114.getEntityId()) == true) goto L55;
        if (r36.contains(Long.valueOf(r114.getId())) == true) goto L55;
        com.obric.memorydata.database.entity.c r115 = r114.convertToRawHistoryEntity();     // Catch: Throwable -> L169
        if (r115 != null) goto L65;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LazyIndexModeHelper", "convertToRawHistoryEntity failed, entityId: " + r114.getEntityId(), null, 4, null);     // Catch: Throwable -> L169
        Unit r116 = Unit.INSTANCE;     // Catch: Throwable -> L169
        goto L55
    L65:
        Boolean.valueOf(r37.add(r115));     // Catch: Throwable -> L169
        goto L55
    L67:
        r13.insertAll(r37);     // Catch: Throwable -> L169
        List<? extends com.obric.memorydata.database.entity.d> r39 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        List<? extends com.obric.memorydata.database.entity.d> r40 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        long r117 = System.currentTimeMillis();     // Catch: Throwable -> L169
        Iterator r41 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L169
    L69:
        if (r41.hasNext() == false) goto L79;
        AppEntity r42 = (AppEntity) ZeusTransformUtils.preCheckCast(r41.next(), AppEntity.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        com.obric.memorydata.database.entity.d r43 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r28.get(r42.getId()), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        com.obric.memorydata.database.entity.d r44 = r15.a(r42, (com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(r43, com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L169
        if (r44 == null) goto L72;
        if (r43 == null) goto L75;
        r44.setUuid(r43.getUuid());     // Catch: Throwable -> L169
    L75:
        r44.setTimestamp(r117);     // Catch: Throwable -> L169
        if (r43 == null) goto L77;
        r44.setId(r43.getId());     // Catch: Throwable -> L169
        r39.add(r44);     // Catch: Throwable -> L169
        goto L69
    L77:
        r40.add(r44);     // Catch: Throwable -> L169
        goto L69
    L72:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LazyIndexModeHelper", "getRawDbEntityByAppEntityAndHistoryEntity failed, entityId: " + r42.getId(), null, 4, null);     // Catch: Throwable -> L169
        goto L69
    L79:
        Set r45 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        List r46 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        List r47 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        List r48 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        Map r118 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r40, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L87;
        Iterable r49 = (Iterable) ZeusTransformUtils.preCheckCast(r12.queryByIds(r15.a(r12, r110, r40, false)), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        Collection r50 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r49, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        Iterator r51 = r49.iterator();     // Catch: Throwable -> L169
    L83:
        if (r51.hasNext() == false) goto L85;
        com.obric.memorydata.database.entity.d r119 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r51.next(), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        r45.add(r119.getEntityId());     // Catch: Throwable -> L169
        r46.add(Long.valueOf(r119.getId()));     // Catch: Throwable -> L169
        r47.add(Long.valueOf(r119.getId()));     // Catch: Throwable -> L169
        r118.put(Long.valueOf(r119.getId()), r119.getEntityId());     // Catch: Throwable -> L169
        r50.add(Unit.INSTANCE);     // Catch: Throwable -> L169
        goto L83
    L85:
        List r55 = (List) ZeusTransformUtils.preCheckCast(r50, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
    L87:
        Set r120 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r39, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L107;
        r15.a(r12, r110, r39, true);     // Catch: Throwable -> L169
        Iterable r56 = (Iterable) ZeusTransformUtils.preCheckCast(r39, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        Map r57 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r56, 10)), 16)), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        Iterator r58 = r56.iterator();     // Catch: Throwable -> L169
    L91:
        if (r58.hasNext() == false) goto L93;
        Object r59 = r58.next();     // Catch: Throwable -> L169
        r57.put(Long.valueOf(((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r59, com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin")).getId()), r59);     // Catch: Throwable -> L169
        goto L91
    L93:
        Iterator r60 = ((Iterable) ZeusTransformUtils.preCheckCast(r12.queryByIds(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r57.keySet(), Iterable.class, "com.obric.memorydata.plugin"))), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L169
    L95:
        if (r60.hasNext() == false) goto L107;
        com.obric.memorydata.database.entity.d r61 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r60.next(), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        com.obric.memorydata.database.entity.d r62 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r57.get(Long.valueOf(r61.getId())), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        if (r62 == null) goto L95;
        if (r62.getId() != r61.getId()) goto L95;
        if (Intrinsics.areEqual(r62.getEntityId(), r61.getEntityId()) == false) goto L95;
        if (r62.getHashCodeValue() != r61.getHashCodeValue()) goto L95;
        if (r62.getModifyTime() != r61.getModifyTime()) goto L95;
        r45.add(r61.getEntityId());     // Catch: Throwable -> L169
        r120.add(Long.valueOf(r61.getId()));     // Catch: Throwable -> L169
        r46.add(Long.valueOf(r61.getId()));     // Catch: Throwable -> L169
        r48.add(Long.valueOf(r61.getId()));     // Catch: Throwable -> L169
        r118.put(Long.valueOf(r61.getId()), r61.getEntityId());     // Catch: Throwable -> L169
    L107:
        Iterable r63 = (Iterable) ZeusTransformUtils.preCheckCast(r118.entrySet(), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        Map r121 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r63, 10)), 16)), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        Iterator r64 = r63.iterator();     // Catch: Throwable -> L169
    L109:
        if (r64.hasNext() == false) goto L112;
        Map.Entry r65 = (Map.Entry) ZeusTransformUtils.preCheckCast(r64.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        Pair r66 = TuplesKt.to(r65.getValue(), r65.getKey());     // Catch: Throwable -> L169
        r121.put(r66.getFirst(), r66.getSecond());     // Catch: Throwable -> L169
        goto L109
    L112:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r46, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L155;
        IndexPendingDao r67 = com.obric.memorydata.database.manager.c.f9561a.b(r14);     // Catch: Throwable -> L169
        List<Long> r68 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        String r310 = com.obric.memorydata.database.manager.c.f9561a.a(r14);     // Catch: Throwable -> L169
        List<Long> r510 = r68;
        long r69 = r117;
        boolean r122 = true;
        Iterator r210 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new Pair[]{TuplesKt.to(r47, new bc.c(r69)), TuplesKt.to(r48, new bc.a(r69))}), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L169
    L115:
        if (r210.hasNext() == false) goto L139;
        Pair r70 = (Pair) ZeusTransformUtils.preCheckCast(r210.next(), Pair.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        List r71 = (List) ZeusTransformUtils.preCheckCast(r70.component1(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        bc r311 = (bc) ZeusTransformUtils.preCheckCast(r70.component2(), bc.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        if (r71.isEmpty() == true) goto L137;
        Iterable r72 = (Iterable) ZeusTransformUtils.preCheckCast(r71, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        Collection r73 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        Iterator r211 = r72.iterator();     // Catch: Throwable -> L169
    L120:
        if (r211.hasNext() == false) goto L136;
        long r212 = ((Number) ZeusTransformUtils.preCheckCast(r211.next(), Number.class, "com.obric.memorydata.plugin")).longValue();     // Catch: Throwable -> L169
        String r74 = (String) ZeusTransformUtils.preCheckCast(r118.get(Long.valueOf(r212)), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        if (r74 == null) goto L124;
        AppEntity r75 = (AppEntity) ZeusTransformUtils.preCheckCast(r110.get(r74), AppEntity.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
    L125:
        if (r75 != null) goto L127;
        long r312 = r69;
        cd r76 = null;
    L132:
        if (r76 == null) goto L134;
        Collection r77 = r73;
        r77.add(r76);     // Catch: Throwable -> L169
    L135:
        r73 = r77;
        r69 = r312;
        r110 = r110;
        r122 = r122;
        r510 = r510;
        r67 = r67;
        r71 = r71;
        r45 = r45;
        r118 = r118;
        r121 = r121;
        r120 = r120;
        goto L120
    L134:
        r77 = r73;
        goto L135
    L127:
        long r213 = r75.getCreateTime();     // Catch: Throwable -> L169
        if (ZeusTransformUtils.instanceOf(r75, AbstractFakeAppEntity.class) == false) goto L130;
        String r78 = ((AbstractFakeAppEntity) ZeusTransformUtils.preCheckCast(r75, AbstractFakeAppEntity.class, "com.obric.memorydata.plugin")).toExtraJsonString();     // Catch: Throwable -> L169
    L131:
        String r313 = r78;
        Intrinsics.checkNotNull(r313);     // Catch: Throwable -> L169
        long r410 = r69;
        r312 = r410;
        r76 = new cd(0, r212, r53, r410, r213, 0, 0, "lazy_index_task", "lazy_index_task", 0, 0, r313, false, 0, 0, 30305, null);     // Catch: Throwable -> L169
        goto L132
    L130:
        r78 = EntityExtKt.getEntityKeepTimeStampGson().toJson(r75);     // Catch: Throwable -> L169
        goto L131
    L124:
        r75 = null;
        goto L125
    L136:
        long r314 = r69;
        IndexPendingDao r411 = r67;
        Set r412 = r45;
        Map r413 = r118;
        Map r414 = r121;
        Set r511 = r120;
        Map<String, ? extends AppEntity> r315 = r110;
        boolean r415 = r122;
        List<Long> r79 = r510;
        int r80 = r53;
        CollectionsKt.addAll((Collection) ZeusTransformUtils.preCheckCast(r79, Collection.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(ao.a(ao.f9372a, r310, CollectionsKt.listOf(new ax.a(r71, r80, "lazy_index_task")), (List) ZeusTransformUtils.preCheckCast(r73, List.class, "com.obric.memorydata.plugin"), r311, null, 16, null).a(), Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L169
    L138:
        r510 = r79;
        r14 = r80;
        r69 = r314;
        r110 = r315;
        r122 = r415;
        r67 = r411;
        r45 = r412;
        r118 = r413;
        r121 = r414;
        r120 = r511;
        goto L115
    L137:
        r314 = r69;
        r411 = r67;
        r412 = r45;
        r413 = r118;
        r414 = r121;
        r511 = r120;
        r315 = r110;
        r80 = r14;
        r415 = r122;
        r79 = r510;
        goto L138
    L139:
        Map r416 = r118;
        Map r417 = r121;
        Set r512 = r120;
        int r81 = r14;
        List<cd> r82 = r67.queryByIds(r510);     // Catch: Throwable -> L169
        Set r83 = r45;
        HashSet r84 = new HashSet((Collection) ZeusTransformUtils.preCheckCast(r83, Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L169
        Iterator r85 = ((Iterable) ZeusTransformUtils.preCheckCast(r82, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L169
    L141:
        if (r85.hasNext() == false) goto L146;
        Map r86 = r416;
        String r87 = (String) ZeusTransformUtils.preCheckCast(r86.get(Long.valueOf(((cd) ZeusTransformUtils.preCheckCast(r85.next(), cd.class, "com.obric.memorydata.plugin")).b())), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        if (r87 == null) goto L145;
        r84.remove(r87);     // Catch: Throwable -> L169
    L145:
        r416 = r86;
        goto L141
    L146:
        Iterator r88 = ((Iterable) ZeusTransformUtils.preCheckCast(r84, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L169
    L148:
        if (r88.hasNext() == false) goto L154;
        String r89 = (String) ZeusTransformUtils.preCheckCast(r88.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        r83.remove(r89);     // Catch: Throwable -> L169
        Map r90 = r417;
        Long r91 = (Long) ZeusTransformUtils.preCheckCast(r90.get(r89), Long.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L169
        if (r91 == null) goto L152;
        Set r92 = r512;
        r92.remove(r91);     // Catch: Throwable -> L169
    L153:
        r417 = r90;
        r512 = r92;
        goto L148
    L152:
        r92 = r512;
        goto L153
    L154:
        Set r93 = r512;
    L157:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r93, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L159;
        com.obric.memorydata.database.manager.c.f9561a.b(r81).setStateByRawDbIdListAndEntityType(0, 4, CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r93, Iterable.class, "com.obric.memorydata.plugin")), r53, "lazy_index_task");     // Catch: Throwable -> L169
    L159:
        List<String> r94 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r83, Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L169
        monitor-exit(this);
        return r94;
    L155:
        r83 = r45;
        r93 = r120;
        r81 = r14;
    L52:
        r36 = SetsKt.emptySet();     // Catch: Throwable -> L169
        goto L53
    L44:
        r33 = null;
        goto L45
    L164:
        throw new IllegalArgumentException("entityStorage is null, type: " + r14);     // Catch: Throwable -> L169
    L166:
        throw new IllegalArgumentException("historyTableDao is null, type: " + r14);     // Catch: Throwable -> L169
    L168:
        throw new IllegalArgumentException("entityTableDao is null, type: " + r14);     // Catch: Throwable -> L169
    L169:
        th = move-exception;
        throw th;
    }

    private static final boolean a(AppEntity r1) {
        return EntityManager.INSTANCE.index(r1);
    }

    public static /* synthetic */ boolean a(l r0, int r1, String r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = false;
    L6:
        return r0.a(r1, r2, r3);
    }

    private static final boolean b(cd r12) {
        String r1 = r12.l();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L21;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LazyIndexModeHelper", "reallyIndex, entityJson is null", null, 4, null);
        return false;
    L21:
        final AppEntity r3 = f12228a.a(r1);     // Catch: JsonSyntaxException -> L15 IllegalArgumentException -> L18
        if (r3 != null) goto L14;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LazyIndexModeHelper", "reallyIndex, buildEntityFromJson failed, entityType: " + r12.c() + " , rawDbId: " + r12.b(), null, 4, null);     // Catch: JsonSyntaxException -> L15 IllegalArgumentException -> L18
        return false;
    L14:
        return ((Boolean) ZeusTransformUtils.preCheckCast(aq.f9375a.a(cu.f8996a.a(r3.getType()), r3.getPackageName(), r3.getId(), r12.d(), new $$Lambda$l$NmBixMas79p6LomxRQ1xrqc20(r3)), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L15:
        e = move-exception;
        RunLog.INSTANCE.error("LazyIndexModeHelper", "reallyIndex, parseJson failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return false;
    L18:
        e = move-exception;
        RunLog.INSTANCE.error("LazyIndexModeHelper", "reallyIndex, fromJsonKeepTimeStamp failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return false;
    L5:
        r2 = false;
        goto L6
    }

    /* JADX INFO: renamed from: lambda$NmBi-xMas79p6LomxRQ1-xrqc20, reason: not valid java name */
    public static /* synthetic */ boolean m1083lambda$NmBixMas79p6LomxRQ1xrqc20(AppEntity r0) {
        return a(r0);
    }

    public static /* synthetic */ boolean lambda$rXH5P5Tp9axWRiBUw5q9RUAYaAQ(cd r0) {
        return b(r0);
    }

    public final Set<Pair<String, Integer>> a(List<? extends AppEntity> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "entities");
        Set<Pair<String, Integer>> r0 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        Iterator r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L8;
        AppEntity r2 = (AppEntity) ZeusTransformUtils.preCheckCast(r9.next(), AppEntity.class, "com.obric.memorydata.plugin");
        if (a(r2.getType(), r2.get_packageName(), ZeusTransformUtils.instanceOf(r2, AbstractFakeAppEntity.class)) == false) goto L4;
        r0.add(new Pair(r2.getId(), Integer.valueOf(r2.getType())));
        goto L4
    L8:
        return r0;
    }

    public final void a(int r7, long r8) {
        IHistoryEntityDao<com.obric.memorydata.database.entity.c> r6 = com.obric.memorydata.database.index.s.a().getHistoryEntityDao(r7);
        if (r6 != null) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LazyIndexModeHelper", "removeLazyIndexHistoryEntity, historyTableDao is null, type: " + r7, null, 4, null);
        return;
    L6:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LazyIndexModeHelper", "removeLazyIndexHistoryEntity, dbId: " + r8 + ", result: " + r6.deleteById(r8), false, 4, null);
    }

    public final void a(int r7, String r8, long r9) {
        Intrinsics.checkNotNullParameter(r8, ObricMemoryConstants.KEY_PACKAGE_NAME);
        com.obric.memorydata.database.manager.c.f9561a.b(r7).setStateByRawDbIdListAndEntityType(4, 0, CollectionsKt.listOf(Long.valueOf(r9)), r7, "lazy_index_task");
    }

    public final void a(int r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r3, "entityId");
        IHistoryEntityDao<com.obric.memorydata.database.entity.c> r0 = com.obric.memorydata.database.index.s.a().getHistoryEntityDao(r1);
        if (r0 != null) goto L6;
        RunLog.INSTANCE.debug("LazyIndexModeHelper", "getLazyIndexHistoryEntity, historyTableDao is null, type: " + r1);
        return;
    L6:
        r0.deleteByEntityId(r3, r2);
    }

    public final void a(int r2, String r3, List<String> r4) {
        List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r1, "entityIds");
        IHistoryEntityDao<com.obric.memorydata.database.entity.c> r5 = com.obric.memorydata.database.index.s.a().getHistoryEntityDao(r2);
        if (r5 != null) goto L6;
        RunLog.INSTANCE.debug("LazyIndexModeHelper", "getLazyIndexHistoryEntity, historyTableDao is null, type: " + r2);
        return;
    L6:
        r5.deleteByEntityIdList(r1, r3);
    }

    public final boolean a(int r1, String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        com.obric.memorydata.personalcontext.storage.a r0 = q.f12255a.a(r1, r3);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a(r1, r2);
    }

    public final boolean a(final cd r2) {
        Intrinsics.checkNotNullParameter(r2, "entityPendingEntity");
        return ((Boolean) ZeusTransformUtils.preCheckCast(com.obric.memorydata.personalcontext.util.i.f12376a.a(new $$Lambda$l$rXH5P5Tp9axWRiBUw5q9RUAYaAQ(r2)), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public final Object b(int r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r10, "entityId");
        IHistoryEntityDao<com.obric.memorydata.database.entity.c> r7 = com.obric.memorydata.database.index.s.a().getHistoryEntityDao(r8);
        if (r7 != null) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LazyIndexModeHelper", "getLazyIndexHistoryEntity, historyTableDao is null, type: " + r8, null, 4, null);
        return null;
    L6:
        List<T> r11 = r7.queryByEntityId(r10, r9);
        if (r11.isEmpty() == false) goto L11;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LazyIndexModeHelper", "getLazyIndexHistoryEntity, historyEntity is null, type: " + r8 + ", entityId: " + r10, false, 4, null);
        return null;
    L11:
        return (com.obric.memorydata.database.entity.c) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r11), com.obric.memorydata.database.entity.c.class, "com.obric.memorydata.plugin");
    }

    public final List<String> b(List<? extends AppEntity> r11) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "entities");
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
        Map r13 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L9;
        Object r1 = r14.next();
        Integer r2 = Integer.valueOf(((AppEntity) ZeusTransformUtils.preCheckCast(r1, AppEntity.class, "com.obric.memorydata.plugin")).getType());
        Object r3 = r13.get(r2);
        if (r3 != null) goto L8;
        r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r13.put(r2, r3);
    L8:
        ((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin")).add(r1);
        goto L4
    L9:
        List<String> r15 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r16 = r13.entrySet().iterator();
    L11:
        if (r16.hasNext() == false) goto L37;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r16.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        int r5 = ((Number) ZeusTransformUtils.preCheckCast(r4.getKey(), Number.class, "com.obric.memorydata.plugin")).intValue();
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4.getValue(), List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Map r7 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r8 = r6.iterator();
    L14:
        if (r8.hasNext() == false) goto L19;
        Object r9 = r8.next();
        String r17 = ((AppEntity) ZeusTransformUtils.preCheckCast(r9, AppEntity.class, "com.obric.memorydata.plugin")).get_packageName();
        Object r18 = r7.get(r17);
        if (r18 != null) goto L18;
        r18 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r7.put(r17, r18);
    L18:
        ((List) ZeusTransformUtils.preCheckCast(r18, List.class, "com.obric.memorydata.plugin")).add(r9);
        goto L14
    L19:
        Iterator r19 = r7.entrySet().iterator();
    L21:
        if (r19.hasNext() == false) goto L11;
        Map.Entry r20 = (Map.Entry) ZeusTransformUtils.preCheckCast(r19.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r21 = (String) ZeusTransformUtils.preCheckCast(r20.getKey(), String.class, "com.obric.memorydata.plugin");
        Iterable r22 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r20.getValue(), List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Map r23 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r24 = r22.iterator();
    L24:
        if (r24.hasNext() == false) goto L29;
        Object r25 = r24.next();
        String r26 = ((AppEntity) ZeusTransformUtils.preCheckCast(r25, AppEntity.class, "com.obric.memorydata.plugin")).getId();
        Object r27 = r23.get(r26);
        if (r27 != null) goto L28;
        r27 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r23.put(r26, r27);
    L28:
        ((List) ZeusTransformUtils.preCheckCast(r27, List.class, "com.obric.memorydata.plugin")).add(r25);
        goto L24
    L29:
        Collection r28 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r23.size()), Collection.class, "com.obric.memorydata.plugin");
        Iterator r29 = r23.entrySet().iterator();
    L31:
        if (r29.hasNext() == false) goto L33;
        r28.add((AppEntity) ZeusTransformUtils.preCheckCast(CollectionsKt.last((List) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r29.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), List.class, "com.obric.memorydata.plugin")), AppEntity.class, "com.obric.memorydata.plugin"));
        goto L31
    L33:
        Iterator r30 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r28, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), 100), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L35:
        if (r30.hasNext() == false) goto L21;
        List<? extends AppEntity> r31 = (List) ZeusTransformUtils.preCheckCast(r30.next(), List.class, "com.obric.memorydata.plugin");
        r15.addAll((Collection) ZeusTransformUtils.preCheckCast(f12228a.a(r31, r5, r21), Collection.class, "com.obric.memorydata.plugin"));
        goto L35
    L37:
        return r15;
    }
}
