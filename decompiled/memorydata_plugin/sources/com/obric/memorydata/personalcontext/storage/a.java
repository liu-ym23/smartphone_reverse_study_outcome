package com.obric.memorydata.personalcontext.storage;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.database.backup.appentity.AbstractFakeAppEntity;
import com.obric.memorydata.database.dao.IAppEntityContentTimeDao;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.dao.IAppEntityVectorCopilotDao;
import com.obric.memorydata.database.entity.cu;
import com.obric.memorydata.database.index.EntityIndexEngine;
import com.obric.memorydata.database.index.ao;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.bridge.AppEntityIndexBridgeAPI;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.personalcontext.EntityManager;
import com.obric.memorydata.personalcontext.api.PersonalContextAPI;
import com.obric.search.api.schema.impl.FullTextSearchSchema;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001a\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0005H&J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH&J&\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u00112\u0006\u0010\u000b\u001a\u00020\nH\u0016J,\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\rH\u0016J&\u0010\u001a\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\rH\u0002J$\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\r2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\rH\u0004J\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\rH\u0002JF\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00112\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00120!2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010%\u001a\u00020\u0005H\u0016J\u0018\u0010&\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\nH&¨\u0006'"}, d2 = {"Lcom/obric/memorydata/personalcontext/storage/AbstractAppEntityStorage;", "Lcom/obric/memorydata/personalcontext/storage/IAppEntityStorage;", "<init>", "()V", "index", "", "appEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "delete", "entityId", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "transformAppEntityToRawDbEntity", "Lcom/obric/memorydata/database/IAppEntityRawDbData;", "isLazyIndex", "getRawDbEntityFromEntityId", "getRawDbEntityFromEntityIdList", "", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "entitiesIds", "bulkDelete", "type", "", "isSupportBulkDelete", "getRawDbEntityByAppEntityAndHistoryEntity", "historyEntity", "transformWithPoisonSnapshot", "prepareRawDbEntityForUpsert", "rawDbEntity", "prepareHistoryEntityForPoisonSnapshot", "bulkPreIndex", "", "entityTableDao", "Lcom/obric/memorydata/database/dao/IAppEntityRawDbDao;", "appEntitiesById", "", "entities", "isUpdate", "isEnableLazyIndex", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class a {
    public a() {
    }

    private final com.obric.memorydata.database.a a(AppEntity r3, boolean r4, com.obric.memorydata.database.a r5) {
        com.obric.memorydata.database.a r6 = (com.obric.memorydata.database.a) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.database.a r7 = a(r3, r4);
        if (r7 != null) goto L7;
        return null;
    L7:
        return a(r3, r7, r6);
    }

    public static /* synthetic */ com.obric.memorydata.database.a a(a r2, AppEntity r3, com.obric.memorydata.database.a r4, com.obric.memorydata.database.a r5, int r6, Object r7) {
        com.obric.memorydata.database.a r8 = (com.obric.memorydata.database.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.database.a r9 = (com.obric.memorydata.database.a) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L10;
        if ((r6 & 4) == 0) goto L8;
        r9 = null;
    L8:
        return r2.a(r3, r8, r9);
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: prepareRawDbEntityForUpsert");
    }

    static /* synthetic */ com.obric.memorydata.database.a a(a r2, AppEntity r3, boolean r4, com.obric.memorydata.database.a r5, int r6, Object r7) {
        com.obric.memorydata.database.a r8 = (com.obric.memorydata.database.a) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L10;
        if ((r6 & 4) == 0) goto L8;
        r8 = null;
    L8:
        return r2.a(r3, r4, r8);
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: transformWithPoisonSnapshot");
    }

    private final com.obric.memorydata.database.entity.d a(com.obric.memorydata.database.a r3) {
        com.obric.memorydata.database.a r2 = (com.obric.memorydata.database.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, com.obric.memorydata.database.entity.d.class) == false) goto L5;
        com.obric.memorydata.database.entity.d r4 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
    L6:
        if (r4 != null) goto L9;
        return null;
    L9:
        if (r4.getContentHash() != null) goto L14;
        AppEntity r5 = r4.convertToAppEntity();
        if (r5 != null) goto L13;
        return r4;
    L13:
        r4.setContentHash(com.obric.memorydata.personalcontext.poison.a.f12244a.a(r5));
    L14:
        return r4;
    L5:
        r4 = null;
        goto L6
    }

    public final com.obric.memorydata.database.a a(AppEntity r4, com.obric.memorydata.database.a r5, com.obric.memorydata.database.a r6) {
        com.obric.memorydata.database.a r7 = (com.obric.memorydata.database.a) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.database.a r8 = (com.obric.memorydata.database.a) ZeusTransformUtils.wrapperContextForParams(r6, com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "appEntity");
        Intrinsics.checkNotNullParameter(r7, "rawDbEntity");
        String r0 = com.obric.memorydata.personalcontext.poison.a.f12244a.a(r4);
        r4.setContentHash(r0);
        if (ZeusTransformUtils.instanceOf(r7, com.obric.memorydata.database.entity.d.class) == false) goto L5;
        com.obric.memorydata.database.entity.d r9 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r7, com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
    L6:
        if (r9 == null) goto L10;
        r9.setContentHash(r0);
        r9.setPoisonLabel(null);
        r9.setPoisonLabelVersion(null);
        com.obric.memorydata.database.entity.d r3 = a(r8);
        if (r3 == null) goto L10;
        r9.preparePoisonSnapshotForUpsert(r3);
    L10:
        return r7;
    L5:
        r9 = null;
        goto L6
    }

    public abstract com.obric.memorydata.database.a a(AppEntity r1, boolean r2);

    public abstract com.obric.memorydata.database.a a(String r1, String r2);

    public com.obric.memorydata.database.entity.d a(AppEntity r3, com.obric.memorydata.database.a r4) {
        com.obric.memorydata.database.a r5 = (com.obric.memorydata.database.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "appEntity");
        com.obric.memorydata.database.a r2 = a(r3, true, r5);
        if (ZeusTransformUtils.instanceOf(r2, com.obric.memorydata.database.entity.d.class) == true) goto L7;
        return null;
    L7:
        return (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
    }

    public List<Long> a(IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r2, Map<String, ? extends AppEntity> r3, List<? extends com.obric.memorydata.database.entity.d> r4, boolean r5) {
        IAppEntityRawDbDao r1 = (IAppEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "entityTableDao");
        Intrinsics.checkNotNullParameter(r6, "appEntitiesById");
        Intrinsics.checkNotNullParameter(r7, "entities");
        if (r5 == false) goto L6;
        r1.updateAll(r7);
        return CollectionsKt.emptyList();
    L6:
        return r1.insertAll(r7);
    }

    public List<String> a(List<String> r18, int r19, String r20) {
        List<String> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "entitiesIds");
        Intrinsics.checkNotNullParameter(r20, ObricMemoryConstants.KEY_PACKAGE_NAME);
        if (IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getBoolean("is_on_avoid_data_import_switch_on", false) == true) goto L5;
        Iterator<String> r4 = r2.iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        com.obric.memorydata.database.util.b.f9624a.a(r20, String.valueOf(r19), (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin"));
        goto L8
    L10:
        List<com.obric.memorydata.database.entity.d> r5 = a(r2, r20);
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L13;
    L16:
        boolean r7 = true;
    L17:
        if (r7 == false) goto L19;
        return r2;
    L19:
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r8.iterator();
    L21:
        if (r10.hasNext() == false) goto L23;
        r9.add(((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r10.next(), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin")).getEntityId());
        goto L21
    L23:
        List<String> r11 = (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin");
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r12.iterator();
    L25:
        if (r14.hasNext() == false) goto L27;
        r13.add(Long.valueOf(((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r14.next(), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin")).getId()));
        goto L25
    L27:
        List<Long> r15 = (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin");
        EntityIndexEngine r16 = com.obric.memorydata.database.index.s.a();
        if (r16.hasKeywordIndex(r19) == false) goto L33;
        FullTextSearchSchema r17 = r16.getKeywordSchema(r19);
        if (r17 == null) goto L33;
        com.obric.memorydata.database.index.t.f9438a.a(r17, r15);
    L33:
        if (com.obric.memorydata.database.index.s.a().isBuildMetaInfoFullContent(r19) == false) goto L35;
        AppEntityIndexBridgeAPI.INSTANCE.deleteMetaFullContentKeyword(r19, r15);
    L35:
        IAppEntityContentTimeDao<com.obric.memorydata.database.entity.b> r110 = com.obric.memorydata.database.index.s.a().getContentTimeDao(r19);
        if (r110 == null) goto L38;
        r110.deleteByRawDbIds(r15);
    L38:
        IAppEntityVectorCopilotDao<com.obric.memorydata.database.entity.i> r111 = com.obric.memorydata.database.index.s.a().getTextVectorCopilotDao(r19);
        IAppEntityVectorCopilotDao<com.obric.memorydata.database.entity.i> r112 = com.obric.memorydata.database.index.s.a().getImageVectorCopilotDao(r19);
        if (r111 == null) goto L45;
        Iterator r113 = ((Iterable) ZeusTransformUtils.preCheckCast(r111.queryByRawDbIds(r15), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L42:
        if (r113.hasNext() == false) goto L44;
        PersonalContextAPI.INSTANCE.deleteVectorCopilotItem(r111.getTableName(), ((com.obric.memorydata.database.entity.i) ZeusTransformUtils.preCheckCast(r113.next(), com.obric.memorydata.database.entity.i.class, "com.obric.memorydata.plugin")).a());
        goto L42
    L44:
        r111.deleteByRawDbIds(r15);
    L45:
        if (r112 == null) goto L51;
        Iterator r21 = ((Iterable) ZeusTransformUtils.preCheckCast(r112.queryByRawDbIds(r15), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L48:
        if (r21.hasNext() == false) goto L50;
        PersonalContextAPI.INSTANCE.deleteVectorCopilotItem(r112.getTableName(), ((com.obric.memorydata.database.entity.i) ZeusTransformUtils.preCheckCast(r21.next(), com.obric.memorydata.database.entity.i.class, "com.obric.memorydata.plugin")).a());
        goto L48
    L50:
        r112.deleteByRawDbIds(r15);
    L51:
        int r22 = cu.f8996a.a(r19);
        Iterable r23 = (Iterable) ZeusTransformUtils.preCheckCast(SetsKt.setOf(new Integer[]{Integer.valueOf(r19), Integer.valueOf(r22)}), Iterable.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.database.manager.c r24 = com.obric.memorydata.database.manager.c.f9561a;
        Map r114 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r25 = r23.iterator();
    L53:
        if (r25.hasNext() == false) goto L58;
        Object r115 = r25.next();
        String r116 = r24.a(((Number) ZeusTransformUtils.preCheckCast(r115, Number.class, "com.obric.memorydata.plugin")).intValue());
        Object r117 = r114.get(r116);
        if (r117 != null) goto L57;
        r117 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r114.put(r116, r117);
    L57:
        ((List) ZeusTransformUtils.preCheckCast(r117, List.class, "com.obric.memorydata.plugin")).add(r115);
        goto L53
    L58:
        Iterator r26 = r114.entrySet().iterator();
    L60:
        if (r26.hasNext() == false) goto L62;
        Map.Entry r27 = (Map.Entry) ZeusTransformUtils.preCheckCast(r26.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        ao.a(ao.f9372a, (String) ZeusTransformUtils.preCheckCast(r27.getKey(), String.class, "com.obric.memorydata.plugin"), r15, CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r27.getValue(), List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), null, 8, null);
        goto L60
    L62:
        EntityManager.INSTANCE.deleteLazyIndexHistoryEntityList(r19, r20, r11);
        PersonalContextAPI.INSTANCE.onBulkEntityDelete(r22, r15, r11, r5);
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r0 = com.obric.memorydata.database.index.s.a().getRawDaoByEntityType(r19);
        if (r0 == null) goto L65;
        r0.deleteByRawDbIds(r15);
    L65:
        return r2;
    L13:
        if (r6.isEmpty() == true) goto L16;
        r7 = false;
        goto L17
    L5:
        return CollectionsKt.emptyList();
    }

    public List<com.obric.memorydata.database.entity.d> a(List<String> r2, String r3) {
        Intrinsics.checkNotNullParameter((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"), "entitiesIds");
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return null;
    }

    public boolean a() {
        return false;
    }

    public abstract boolean a(int r1, String r2);

    public boolean a(AppEntity r8) {
        Intrinsics.checkNotNullParameter(r8, "appEntity");
        com.obric.memorydata.database.a r7 = a(this, r8, false, null, 4, null);
        if (r7 != null) goto L7;
        return false;
    L7:
        return r7.index(ZeusTransformUtils.instanceOf(r8, AbstractFakeAppEntity.class));
    }

    public boolean delete(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "entityId");
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
        com.obric.memorydata.database.a r1 = a(r2, r3);
        if (r1 != null) goto L7;
        return true;
    L7:
        return r1.delete();
    }
}
