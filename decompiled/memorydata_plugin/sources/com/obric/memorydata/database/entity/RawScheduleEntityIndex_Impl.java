package com.obric.memorydata.database.entity;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.annotation.Type;
import com.obric.memorydata.database.dao.IAppEntityContentTimeDao;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.dao.IAppEntityVectorCopilotDao;
import com.obric.memorydata.database.dao.IHistoryEntityDao;
import com.obric.memorydata.database.index.EntityIndexRecordInfo;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.search.api.schema.impl.FullTextSearchSchema;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005H\u0016J\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u00172\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u0017H\u0016J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u0017H\u0016J\u0014\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000eH\u0016J\u0014\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000eH\u0016J&\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00102\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0#H\u0016J\u001e\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010'\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010(\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\fH\u0016J\u001a\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\fH\u0016J\b\u0010,\u001a\u00020\u0014H\u0016R#\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/obric/memorydata/database/entity/RawScheduleEntityIndex_Impl;", "Lcom/obric/memorydata/database/entity/RawScheduleEntityIndex;", "<init>", "()V", "entityIndexHelper", "Lcom/obric/memorydata/database/index/EntityIndexHelper;", "Lcom/obric/memorydata/database/entity/RawScheduleEntity;", "Lcom/obric/memorydata/database/entity/ScheduleEntityTextVectorCopilotEntity;", "Lcom/obric/memorydata/database/entity/AbstractContentTimeEntity;", "getEntityIndexHelper", "()Lcom/obric/memorydata/database/index/EntityIndexHelper;", "TAG", "", "buildKeywordIndexMap", "", "entity", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "getKeywordSchema", "Lcom/obric/search/api/schema/impl/FullTextSearchSchema;", "hasKeywordSchema", "", "getEntityIndexHelperInstance", "getNeedUpdateColumns", "", "oldRawEntity", "newRawEntity", "getAllColumns", "getPendingTaskColumns", "getKeywordColumnMap", "getContentTimeColumns", "assignmentAssociateField", "", "oldEntity", "newEntity", "changeColumns", "", "generateIndexPendingTask", "", "Lcom/obric/memorydata/database/entity/IndexPendingEntity;", "columnName", "executeIndexPendingTask", "updateField", "getValueByColumn", "", "isBuildMetaInfoFullContent", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class RawScheduleEntityIndex_Impl implements hm {
    private final String TAG;
    private final com.obric.memorydata.database.index.t<hl, ia, b> entityIndexHelper;

    public RawScheduleEntityIndex_Impl() {
        com.obric.memorydata.database.index.t<hl, ia, b> r0 = new com.obric.memorydata.database.index.t();
        this.entityIndexHelper = r0;
        this.TAG = "RawScheduleEntityIndex_Impl";
        IAppEntityRawDbDao<? extends d> r1 = getRawDao();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.memorydata.database.dao.IAppEntityRawDbDao<com.obric.memorydata.database.entity.RawScheduleEntity>");
        IAppEntityVectorCopilotDao<? extends i> r2 = getTextCopilotDao();
        IAppEntityContentTimeDao<? extends b> r4 = null;
        if (ZeusTransformUtils.instanceOf(r2, IAppEntityVectorCopilotDao.class) == true) goto L6;
        r2 = null;
    L6:
        IAppEntityVectorCopilotDao<? extends i> r3 = getImageCopilotDao();
        if (ZeusTransformUtils.instanceOf(r3, IAppEntityVectorCopilotDao.class) == true) goto L10;
        r3 = null;
    L10:
        IAppEntityContentTimeDao<? extends b> r6 = getContentTimeDao();
        if (ZeusTransformUtils.instanceOf(r6, IAppEntityContentTimeDao.class) == false) goto L13;
        r4 = r6;
    L13:
        r0.a(r1, r2, r3, r4, true);
    }

    @Override // com.obric.memorydata.database.index.e
    public void assignmentAssociateField(d r2, d r3, Set<String> r4) {
        Set r1 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "oldEntity");
        Intrinsics.checkNotNullParameter(r3, "newEntity");
        Intrinsics.checkNotNullParameter(r1, "changeColumns");
        if (ZeusTransformUtils.instanceOf(r2, hl.class) == false) goto L10;
        if (ZeusTransformUtils.instanceOf(r3, hl.class) == false) goto L8;
        return;
    L8:
        throw new IllegalStateException("Check failed.".toString());
    L10:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public Map<String, String> buildKeywordIndexMap(d r3) {
        Intrinsics.checkNotNullParameter(r3, "entity");
        if (ZeusTransformUtils.instanceOf(r3, hl.class) == false) goto L7;
        Map<String, String> r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        r2.put("common1", ((hl) ZeusTransformUtils.preCheckCast(r3, hl.class, "com.obric.memorydata.plugin")).a());
        return r2;
    L7:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public boolean executeIndexPendingTask(d r18, String r19) {
        Intrinsics.checkNotNullParameter(r18, "entity");
        Intrinsics.checkNotNullParameter(r19, "updateField");
        if (ZeusTransformUtils.instanceOf(r18, hl.class) == false) goto L25;
        long r4 = System.currentTimeMillis();
        EntityIndexRecordInfo r2 = com.obric.memorydata.database.util.b.f9624a.a(r18);
        if (Intrinsics.areEqual(r19, "insert_keyword_task") == false) goto L7;
        boolean r6 = this.entityIndexHelper.b(((hl) ZeusTransformUtils.preCheckCast(r18, hl.class, "com.obric.memorydata.plugin")).getId(), buildKeywordIndexMap(r18));
    L9:
        if (Intrinsics.areEqual(r19, "meta_full_content") == false) goto L11;
        boolean r9 = com.obric.memorydata.database.index.t.f9438a.a(r18);
    L13:
        if (Intrinsics.areEqual(r19, "fullContent") == false) goto L15;
        boolean r10 = this.entityIndexHelper.c(r18, "fullContent", ((hl) ZeusTransformUtils.preCheckCast(r18, hl.class, "com.obric.memorydata.plugin")).j(), "DEFAULT");
    L16:
        if (r2 == null) goto L18;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", com.obric.memorydata.utils.u.a(r2), false, 4, null);
        com.obric.memorydata.database.util.b.f9624a.a("entityIndexTaskCost", String.valueOf(((hl) ZeusTransformUtils.preCheckCast(r18, hl.class, "com.obric.memorydata.plugin")).getType()), r19, System.currentTimeMillis() - r4);
    L18:
        if (r10 == false) goto L22;
        if (r6 == false) goto L22;
        if (r9 == false) goto L22;
        return true;
    L22:
        return false;
    L15:
        r10 = true;
        goto L16
    L11:
        r9 = true;
        goto L13
    L7:
        r6 = true;
        goto L9
    L25:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public List<cd> generateIndexPendingTask(String r34, d r35) {
        Intrinsics.checkNotNullParameter(r34, "columnName");
        Intrinsics.checkNotNullParameter(r35, "entity");
        if (ZeusTransformUtils.instanceOf(r35, hl.class) == false) goto L32;
        int r0 = r34.hashCode();
        if (r0 == (-1937787423)) goto L26;
        if (r0 == (-1536949565)) goto L21;
        if (r0 != (-193103126)) goto L28;
        if (r34.equals("fullContent") == false) goto L28;
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L19;
        return CollectionsKt.listOf(new cd(0, ((hl) ZeusTransformUtils.preCheckCast(r35, hl.class, "com.obric.memorydata.plugin")).getId(), ((hl) ZeusTransformUtils.preCheckCast(r35, hl.class, "com.obric.memorydata.plugin")).getType(), ((hl) ZeusTransformUtils.preCheckCast(r35, hl.class, "com.obric.memorydata.plugin")).getTimestamp(), ((hl) ZeusTransformUtils.preCheckCast(r35, hl.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, r34, "full_content", 0, 0, null, false, 0, 0, 32353, null));
    L19:
        return CollectionsKt.emptyList();
    L28:
        return CollectionsKt.emptyList();
    L21:
        if (r34.equals("meta_full_content") == false) goto L28;
        return CollectionsKt.listOf(new cd(0, ((hl) ZeusTransformUtils.preCheckCast(r35, hl.class, "com.obric.memorydata.plugin")).getId(), ((hl) ZeusTransformUtils.preCheckCast(r35, hl.class, "com.obric.memorydata.plugin")).getType(), ((hl) ZeusTransformUtils.preCheckCast(r35, hl.class, "com.obric.memorydata.plugin")).getTimestamp(), ((hl) ZeusTransformUtils.preCheckCast(r35, hl.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, "meta_full_content", "meta_full_content", 0, 0, null, false, 0, 0, 32353, null));
    L26:
        if (r34.equals("insert_keyword_task") == false) goto L28;
        return CollectionsKt.listOf(new cd(0, ((hl) ZeusTransformUtils.preCheckCast(r35, hl.class, "com.obric.memorydata.plugin")).getId(), ((hl) ZeusTransformUtils.preCheckCast(r35, hl.class, "com.obric.memorydata.plugin")).getType(), ((hl) ZeusTransformUtils.preCheckCast(r35, hl.class, "com.obric.memorydata.plugin")).getTimestamp(), ((hl) ZeusTransformUtils.preCheckCast(r35, hl.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, "insert_keyword_task", "keyword", 0, 0, null, false, 0, 0, 32353, null));
    L32:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public Set<String> getAllColumns() {
        Set<String> r2 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        r2.add(ActivityLifecycle.NAME);
        r2.add("fullContent");
        r2.add("meta_full_content");
        return r2;
    }

    @Override // com.obric.memorydata.database.index.e
    public Map<String, String> getContentTimeColumns() {
        return (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityContentTimeDao<? extends b> getContentTimeDao() {
        return hm.a.d(this);
    }

    public final com.obric.memorydata.database.index.t<hl, ia, b> getEntityIndexHelper() {
        return this.entityIndexHelper;
    }

    @Override // com.obric.memorydata.database.index.e
    public com.obric.memorydata.database.index.t<hl, ia, b> getEntityIndexHelperInstance() {
        return this.entityIndexHelper;
    }

    @Override // com.obric.memorydata.database.index.e
    public IHistoryEntityDao<? extends c> getHistoryEntityDao() {
        return hm.a.e(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityVectorCopilotDao<? extends i> getImageCopilotDao() {
        return hm.a.c(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public Map<String, String> getKeywordColumnMap() {
        Map<String, String> r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        r2.put(ActivityLifecycle.NAME, "common1");
        return r2;
    }

    @Override // com.obric.memorydata.database.index.e
    public FullTextSearchSchema getKeywordSchema() {
        return this.entityIndexHelper.a();
    }

    @Override // com.obric.memorydata.database.index.e
    public Set<String> getNeedUpdateColumns(d r9, d r10) {
        Intrinsics.checkNotNullParameter(r9, "oldRawEntity");
        Intrinsics.checkNotNullParameter(r10, "newRawEntity");
        if (ZeusTransformUtils.instanceOf(r9, hl.class) == false) goto L17;
        if (ZeusTransformUtils.instanceOf(r10, hl.class) == false) goto L15;
        Set<String> r8 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        if (gd.f9146a.a(((hl) ZeusTransformUtils.preCheckCast(r9, hl.class, "com.obric.memorydata.plugin")).a(), ((hl) ZeusTransformUtils.preCheckCast(r10, hl.class, "com.obric.memorydata.plugin")).a(), null, null, false) == true) goto L10;
        r8.add(ActivityLifecycle.NAME);
    L10:
        if (gd.f9146a.a(((hl) ZeusTransformUtils.preCheckCast(r9, hl.class, "com.obric.memorydata.plugin")).j(), ((hl) ZeusTransformUtils.preCheckCast(r10, hl.class, "com.obric.memorydata.plugin")).j(), Type.FULL_CONTENT, null, false) == true) goto L12;
        r8.add("fullContent");
    L12:
        r8.add("meta_full_content");
        return r8;
    L15:
        throw new IllegalStateException("Check failed.".toString());
    L17:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public Set<String> getPendingTaskColumns() {
        Set<String> r2 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        r2.add("insert_keyword_task");
        r2.add("meta_full_content");
        r2.add("fullContent");
        return r2;
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityRawDbDao<? extends d> getRawDao() {
        return hm.a.a(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityVectorCopilotDao<? extends i> getTextCopilotDao() {
        return hm.a.b(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public Object getValueByColumn(d r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "entity");
        Intrinsics.checkNotNullParameter(r2, "columnName");
        if (ZeusTransformUtils.instanceOf(r1, hl.class) == false) goto L10;
        if (Intrinsics.areEqual(r2, "fullContent") == true) goto L11;
        return null;
    L11:
        return ((hl) ZeusTransformUtils.preCheckCast(r1, hl.class, "com.obric.memorydata.plugin")).j();
    L10:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public boolean hasKeywordSchema() {
        return this.entityIndexHelper.b();
    }

    @Override // com.obric.memorydata.database.index.e
    public boolean isBuildMetaInfoFullContent() {
        return true;
    }
}
