package com.obric.memorydata.database.index;

import com.obric.memorydata.database.dao.IAppEntityContentTimeDao;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.dao.IAppEntityRawFileTextDbDao;
import com.obric.memorydata.database.dao.IAppEntityVectorCopilotDao;
import com.obric.memorydata.database.dao.IHistoryEntityDao;
import com.obric.memorydata.database.entity.cd;
import com.obric.memorydata.database.entity.cu;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.search.api.schema.impl.FullTextSearchSchema;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u0000 :2\u00020\u0001:\u0001:B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u001c\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\u0006\u0010\f\u001a\u00020\u0006J\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00162\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\u0006J\u0016\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a2\u0006\u0010\f\u001a\u00020\u0006J\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d2\u0006\u0010\f\u001a\u00020\u0006J\u0016\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d2\u0006\u0010\f\u001a\u00020\u0006J\u0016\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!2\u0006\u0010\f\u001a\u00020\u0006J\u0010\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010%\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\u0006J\f\u0010&\u001a\b\u0012\u0004\u0012\u00020$0'J\u0012\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00160'J\u001e\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000f0*2\u0006\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u0011H&J\u0016\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000f0*2\u0006\u0010\u0010\u001a\u00020\u0011H&J\u001c\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H&J\u001c\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H&J&\u00100\u001a\u0002012\u0006\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u00112\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u000f03H&J\u0018\u00104\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00105\u001a\u00020\u000fH&J\"\u00106\u001a\b\u0012\u0004\u0012\u0002070'2\u0006\u00108\u001a\u00020\u00112\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u000f03R-\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006;"}, d2 = {"Lcom/obric/memorydata/database/index/EntityIndexEngine;", "", "<init>", "()V", "entityIndexImplMap", "Ljava/util/HashMap;", "", "Lcom/obric/memorydata/database/index/BaseEntityIndex;", "Lkotlin/collections/HashMap;", "getEntityIndexImplMap", "()Ljava/util/HashMap;", "normalizeEntityType", "entityType", "getKeywordIndexMap", "", "", "entity", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "getHistoryEntityDao", "Lcom/obric/memorydata/database/dao/IHistoryEntityDao;", "Lcom/obric/memorydata/database/entity/AbstractHistoryEntity;", "getRawDaoByEntityType", "Lcom/obric/memorydata/database/dao/IAppEntityRawDbDao;", "isBuildMetaInfoFullContent", "", "getRawFileTextDaoByEntityType", "Lcom/obric/memorydata/database/dao/IAppEntityRawFileTextDbDao;", "Lcom/obric/memorydata/database/entity/AbstractRawFileTextDbEntity;", "getTextVectorCopilotDao", "Lcom/obric/memorydata/database/dao/IAppEntityVectorCopilotDao;", "Lcom/obric/memorydata/database/entity/AbstractVectorCopilotEntity;", "getImageVectorCopilotDao", "getContentTimeDao", "Lcom/obric/memorydata/database/dao/IAppEntityContentTimeDao;", "Lcom/obric/memorydata/database/entity/AbstractContentTimeEntity;", "getKeywordSchema", "Lcom/obric/search/api/schema/impl/FullTextSearchSchema;", "hasKeywordIndex", "getAllKeywordSchema", "", "getAllRawDao", "getNeedUpdateColumns", "", "oldEntity", "newEntity", "getAllColumns", "getKeywordColumnMap", "getContentTimeColumns", "assignmentAssociateField", "", "changeColumns", "", "executeIndexPendingTask", "updateField", "getEntityIndexPendingList", "Lcom/obric/memorydata/database/entity/IndexPendingEntity;", "abstractRawDbEntity", "columns", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class EntityIndexEngine {
    public static final a Companion = null;
    private static final String TAG = "EntityIndexEngine";
    private final HashMap<Integer, e> entityIndexImplMap;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/database/index/EntityIndexEngine$Companion;", "", "<init>", "()V", "TAG", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public EntityIndexEngine() {
        this.entityIndexImplMap = new HashMap();
    }

    private final int normalizeEntityType(int r1) {
        return cu.f8996a.a(r1);
    }

    public abstract void assignmentAssociateField(com.obric.memorydata.database.entity.d r1, com.obric.memorydata.database.entity.d r2, Set<String> r3);

    public abstract boolean executeIndexPendingTask(com.obric.memorydata.database.entity.d r1, String r2);

    public abstract Set<String> getAllColumns(com.obric.memorydata.database.entity.d r1);

    public final List<FullTextSearchSchema> getAllKeywordSchema() {
        ArrayList r0 = new ArrayList();
        Iterator r4 = ((Map) ZeusTransformUtils.preCheckCast(this.entityIndexImplMap, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        FullTextSearchSchema r1 = ((e) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), e.class, "com.obric.memorydata.plugin")).getKeywordSchema();
        if (r1 == null) goto L4;
        r0.add(r1);
        goto L4
    L8:
        r0.add(com.obric.memorydata.database.util.c.f9626a.c());
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<IAppEntityRawDbDao<com.obric.memorydata.database.entity.d>> getAllRawDao() {
        List<IAppEntityRawDbDao<com.obric.memorydata.database.entity.d>> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r4 = ((Map) ZeusTransformUtils.preCheckCast(this.entityIndexImplMap, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L11;
        IAppEntityRawDbDao<? extends com.obric.memorydata.database.entity.d> r1 = ((e) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), e.class, "com.obric.memorydata.plugin")).getRawDao();
        if (ZeusTransformUtils.instanceOf(r1, IAppEntityRawDbDao.class) == true) goto L9;
        r1 = null;
    L9:
        if (r1 == null) goto L4;
        r0.add(r1);
        goto L4
    L11:
        return r0;
    }

    public abstract Map<String, String> getContentTimeColumns(com.obric.memorydata.database.entity.d r1);

    /* JADX WARN: Multi-variable type inference failed */
    public final IAppEntityContentTimeDao<com.obric.memorydata.database.entity.b> getContentTimeDao(int r2) {
        e r1 = (e) ZeusTransformUtils.preCheckCast(this.entityIndexImplMap.get(Integer.valueOf(normalizeEntityType(r2))), e.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L5;
        IAppEntityContentTimeDao r3 = r1.getContentTimeDao();
    L7:
        if (ZeusTransformUtils.instanceOf(r3, IAppEntityContentTimeDao.class) == true) goto L9;
        return null;
    L9:
        return r3;
    L5:
        r3 = null;
        goto L7
    }

    public final HashMap<Integer, e> getEntityIndexImplMap() {
        return this.entityIndexImplMap;
    }

    public final List<cd> getEntityIndexPendingList(com.obric.memorydata.database.entity.d r8, Set<String> r9) {
        Set r10 = (Set) ZeusTransformUtils.wrapperContextForParams(r9, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "abstractRawDbEntity");
        Intrinsics.checkNotNullParameter(r10, "columns");
        List<cd> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        e r7 = (e) ZeusTransformUtils.preCheckCast(this.entityIndexImplMap.get(Integer.valueOf(r8.getType())), e.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L12;
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r11.hasNext() == false) goto L12;
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(r7.generateIndexPendingTask((String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin"), r8), Collection.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L10
    L10:
        e = move-exception;
        RunLog.INSTANCE.error(TAG, "getEntityIndexPendingList error, rawDbId: " + r8.getId() + ", type: " + r8.getType(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    L12:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final IHistoryEntityDao<com.obric.memorydata.database.entity.c> getHistoryEntityDao(int r2) {
        e r1 = (e) ZeusTransformUtils.preCheckCast(this.entityIndexImplMap.get(Integer.valueOf(normalizeEntityType(r2))), e.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L5;
        IHistoryEntityDao r3 = r1.getHistoryEntityDao();
    L7:
        if (ZeusTransformUtils.instanceOf(r3, IHistoryEntityDao.class) == true) goto L9;
        return null;
    L9:
        return r3;
    L5:
        r3 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final IAppEntityVectorCopilotDao<com.obric.memorydata.database.entity.i> getImageVectorCopilotDao(int r2) {
        e r1 = (e) ZeusTransformUtils.preCheckCast(this.entityIndexImplMap.get(Integer.valueOf(normalizeEntityType(r2))), e.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L5;
        IAppEntityVectorCopilotDao r3 = r1.getImageCopilotDao();
    L7:
        if (ZeusTransformUtils.instanceOf(r3, IAppEntityVectorCopilotDao.class) == true) goto L9;
        return null;
    L9:
        return r3;
    L5:
        r3 = null;
        goto L7
    }

    public abstract Map<String, String> getKeywordColumnMap(com.obric.memorydata.database.entity.d r1);

    public final Map<String, String> getKeywordIndexMap(com.obric.memorydata.database.entity.d r3) {
        Intrinsics.checkNotNullParameter(r3, "entity");
        e r2 = (e) ZeusTransformUtils.preCheckCast(this.entityIndexImplMap.get(Integer.valueOf(r3.getType())), e.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.buildKeywordIndexMap(r3);
    }

    public final FullTextSearchSchema getKeywordSchema(int r2) {
        int r3 = normalizeEntityType(r2);
        e r1 = (e) ZeusTransformUtils.preCheckCast(this.entityIndexImplMap.get(Integer.valueOf(r3)), e.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.getKeywordSchema();
    }

    public abstract Set<String> getNeedUpdateColumns(com.obric.memorydata.database.entity.d r1, com.obric.memorydata.database.entity.d r2);

    /* JADX WARN: Multi-variable type inference failed */
    public final IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> getRawDaoByEntityType(int r2) {
        e r1 = (e) ZeusTransformUtils.preCheckCast(this.entityIndexImplMap.get(Integer.valueOf(normalizeEntityType(r2))), e.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L5;
        IAppEntityRawDbDao r3 = r1.getRawDao();
    L7:
        if (ZeusTransformUtils.instanceOf(r3, IAppEntityRawDbDao.class) == true) goto L9;
        return null;
    L9:
        return r3;
    L5:
        r3 = null;
        goto L7
    }

    public final IAppEntityRawFileTextDbDao<com.obric.memorydata.database.entity.f> getRawFileTextDaoByEntityType(int r3) {
        e r2 = (e) ZeusTransformUtils.preCheckCast(this.entityIndexImplMap.get(Integer.valueOf(normalizeEntityType(r3))), e.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L5;
        IAppEntityRawDbDao<? extends com.obric.memorydata.database.entity.d> r4 = r2.getRawDao();
    L7:
        if (ZeusTransformUtils.instanceOf(r4, IAppEntityRawFileTextDbDao.class) == true) goto L9;
        return null;
    L9:
        return (IAppEntityRawFileTextDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawFileTextDbDao.class, "com.obric.memorydata.plugin");
    L5:
        r4 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final IAppEntityVectorCopilotDao<com.obric.memorydata.database.entity.i> getTextVectorCopilotDao(int r2) {
        e r1 = (e) ZeusTransformUtils.preCheckCast(this.entityIndexImplMap.get(Integer.valueOf(normalizeEntityType(r2))), e.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L5;
        IAppEntityVectorCopilotDao r3 = r1.getTextCopilotDao();
    L7:
        if (ZeusTransformUtils.instanceOf(r3, IAppEntityVectorCopilotDao.class) == true) goto L9;
        return null;
    L9:
        return r3;
    L5:
        r3 = null;
        goto L7
    }

    public final boolean hasKeywordIndex(int r4) {
        int r5 = normalizeEntityType(r4);
        e r0 = (e) ZeusTransformUtils.preCheckCast(this.entityIndexImplMap.get(Integer.valueOf(r5)), e.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        boolean r1 = r0.hasKeywordSchema();
    L6:
        if (r1 == false) goto L14;
        e r3 = (e) ZeusTransformUtils.preCheckCast(this.entityIndexImplMap.get(Integer.valueOf(r5)), e.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L10;
        FullTextSearchSchema r6 = r3.getKeywordSchema();
    L11:
        if (r6 == null) goto L15;
        return true;
    L15:
        return false;
    L10:
        r6 = null;
        goto L11
    L14:
        return false;
    L5:
        r1 = false;
        goto L6
    }

    public final boolean isBuildMetaInfoFullContent(int r2) {
        int r3 = normalizeEntityType(r2);
        e r1 = (e) ZeusTransformUtils.preCheckCast(this.entityIndexImplMap.get(Integer.valueOf(r3)), e.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L8;
        if (r1.isBuildMetaInfoFullContent() != true) goto L8;
        return true;
    L8:
        return false;
    }
}
