package com.obric.memorydata.database.entity;

import com.obric.aikernel.sdk.ext.Params;
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
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005H\u0016J\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u00172\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u0017H\u0016J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u0017H\u0016J\u0014\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000eH\u0016J\u0014\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000eH\u0016J&\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00102\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0#H\u0016J\u001e\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010'\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010(\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\fH\u0016J\u001a\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\fH\u0016J\b\u0010,\u001a\u00020\u0014H\u0016R#\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/obric/memorydata/database/entity/RawNoteRecordingTextEntityIndex_Impl;", "Lcom/obric/memorydata/database/entity/RawNoteRecordingTextEntityIndex;", "<init>", "()V", "entityIndexHelper", "Lcom/obric/memorydata/database/index/EntityIndexHelper;", "Lcom/obric/memorydata/database/entity/RawNoteRecordingTextEntity;", "Lcom/obric/memorydata/database/entity/NoteRecordingTextEntityTextVectorCopilotEntity;", "Lcom/obric/memorydata/database/entity/AbstractContentTimeEntity;", "getEntityIndexHelper", "()Lcom/obric/memorydata/database/index/EntityIndexHelper;", "TAG", "", "buildKeywordIndexMap", "", "entity", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "getKeywordSchema", "Lcom/obric/search/api/schema/impl/FullTextSearchSchema;", "hasKeywordSchema", "", "getEntityIndexHelperInstance", "getNeedUpdateColumns", "", "oldRawEntity", "newRawEntity", "getAllColumns", "getPendingTaskColumns", "getKeywordColumnMap", "getContentTimeColumns", "assignmentAssociateField", "", "oldEntity", "newEntity", "changeColumns", "", "generateIndexPendingTask", "", "Lcom/obric/memorydata/database/entity/IndexPendingEntity;", "columnName", "executeIndexPendingTask", "updateField", "getValueByColumn", "", "isBuildMetaInfoFullContent", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class RawNoteRecordingTextEntityIndex_Impl implements gz {
    private final String TAG;
    private final com.obric.memorydata.database.index.t<gy, dz, b> entityIndexHelper;

    public RawNoteRecordingTextEntityIndex_Impl() {
        com.obric.memorydata.database.index.t<gy, dz, b> r0 = new com.obric.memorydata.database.index.t();
        this.entityIndexHelper = r0;
        this.TAG = "RawNoteRecordingTextEntityIndex_Impl";
        IAppEntityRawDbDao<? extends d> r1 = getRawDao();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.memorydata.database.dao.IAppEntityRawDbDao<com.obric.memorydata.database.entity.RawNoteRecordingTextEntity>");
        IAppEntityVectorCopilotDao<? extends h> r2 = getTextCopilotDao();
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
        r0.a(r1, r2, r3, r4, false);
    }

    @Override // com.obric.memorydata.database.index.e
    public void assignmentAssociateField(d r2, d r3, Set<String> r4) {
        Set r1 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "oldEntity");
        Intrinsics.checkNotNullParameter(r3, "newEntity");
        Intrinsics.checkNotNullParameter(r1, "changeColumns");
        if (ZeusTransformUtils.instanceOf(r2, gy.class) == false) goto L10;
        if (ZeusTransformUtils.instanceOf(r3, gy.class) == false) goto L8;
        return;
    L8:
        throw new IllegalStateException("Check failed.".toString());
    L10:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public Map<String, String> buildKeywordIndexMap(d r2) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        if (ZeusTransformUtils.instanceOf(r2, gy.class) == false) goto L7;
        return (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    L7:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public boolean executeIndexPendingTask(d r16, String r17) {
        Intrinsics.checkNotNullParameter(r16, "entity");
        Intrinsics.checkNotNullParameter(r17, "updateField");
        if (ZeusTransformUtils.instanceOf(r16, gy.class) == false) goto L12;
        long r1 = System.currentTimeMillis();
        EntityIndexRecordInfo r4 = com.obric.memorydata.database.util.b.f9624a.a(r16);
        boolean r5 = true;
        if (Intrinsics.areEqual(r17, Params.CONTENT) == false) goto L7;
        r5 = this.entityIndexHelper.b(r16, Params.CONTENT, ((gy) ZeusTransformUtils.preCheckCast(r16, gy.class, "com.obric.memorydata.plugin")).b(), "DEFAULT");
    L7:
        boolean r6 = r5;
        if (r4 == null) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", com.obric.memorydata.utils.u.a(r4), false, 4, null);
        com.obric.memorydata.database.util.b.f9624a.a("entityIndexTaskCost", String.valueOf(((gy) ZeusTransformUtils.preCheckCast(r16, gy.class, "com.obric.memorydata.plugin")).getType()), r17, System.currentTimeMillis() - r1);
    L10:
        return r6;
    L12:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public List<cd> generateIndexPendingTask(String r28, d r29) {
        Intrinsics.checkNotNullParameter(r28, "columnName");
        Intrinsics.checkNotNullParameter(r29, "entity");
        if (ZeusTransformUtils.instanceOf(r29, gy.class) == false) goto L19;
        if (Intrinsics.areEqual(r28, Params.CONTENT) == false) goto L13;
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L11;
        return this.entityIndexHelper.a(r29, r28, ((gy) ZeusTransformUtils.preCheckCast(r29, gy.class, "com.obric.memorydata.plugin")).b().toString());
    L11:
        return CollectionsKt.emptyList();
    L13:
        if (Intrinsics.areEqual(r28, "insert_keyword_task") == false) goto L17;
        return CollectionsKt.listOf(new cd(0, ((gy) ZeusTransformUtils.preCheckCast(r29, gy.class, "com.obric.memorydata.plugin")).getId(), ((gy) ZeusTransformUtils.preCheckCast(r29, gy.class, "com.obric.memorydata.plugin")).getType(), ((gy) ZeusTransformUtils.preCheckCast(r29, gy.class, "com.obric.memorydata.plugin")).getTimestamp(), ((gy) ZeusTransformUtils.preCheckCast(r29, gy.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, "insert_keyword_task", "keyword", 0, 0, null, false, 0, 0, 32353, null));
    L17:
        return CollectionsKt.emptyList();
    L19:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public Set<String> getAllColumns() {
        Set<String> r2 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        r2.add(Params.CONTENT);
        return r2;
    }

    @Override // com.obric.memorydata.database.index.e
    public Map<String, String> getContentTimeColumns() {
        return (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityContentTimeDao<? extends b> getContentTimeDao() {
        return gz.a.d(this);
    }

    public final com.obric.memorydata.database.index.t<gy, dz, b> getEntityIndexHelper() {
        return this.entityIndexHelper;
    }

    @Override // com.obric.memorydata.database.index.e
    public com.obric.memorydata.database.index.t<gy, dz, b> getEntityIndexHelperInstance() {
        return this.entityIndexHelper;
    }

    @Override // com.obric.memorydata.database.index.e
    public IHistoryEntityDao<? extends c> getHistoryEntityDao() {
        return gz.a.e(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityVectorCopilotDao<? extends i> getImageCopilotDao() {
        return gz.a.c(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public Map<String, String> getKeywordColumnMap() {
        return (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.index.e
    public FullTextSearchSchema getKeywordSchema() {
        return this.entityIndexHelper.a();
    }

    @Override // com.obric.memorydata.database.index.e
    public Set<String> getNeedUpdateColumns(d r9, d r10) {
        Intrinsics.checkNotNullParameter(r9, "oldRawEntity");
        Intrinsics.checkNotNullParameter(r10, "newRawEntity");
        if (ZeusTransformUtils.instanceOf(r9, gy.class) == false) goto L13;
        if (ZeusTransformUtils.instanceOf(r10, gy.class) == false) goto L11;
        Set<String> r8 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        if (gd.f9146a.a(((gy) ZeusTransformUtils.preCheckCast(r9, gy.class, "com.obric.memorydata.plugin")).b(), ((gy) ZeusTransformUtils.preCheckCast(r10, gy.class, "com.obric.memorydata.plugin")).b(), Type.FILE_CONTENT_TEXT, null, false) == true) goto L9;
        r8.add(Params.CONTENT);
    L9:
        return r8;
    L11:
        throw new IllegalStateException("Check failed.".toString());
    L13:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public Set<String> getPendingTaskColumns() {
        Set<String> r2 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        r2.add(Params.CONTENT);
        return r2;
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityRawDbDao<? extends d> getRawDao() {
        return gz.a.a(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityVectorCopilotDao<? extends h> getTextCopilotDao() {
        return gz.a.b(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public Object getValueByColumn(d r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "entity");
        Intrinsics.checkNotNullParameter(r2, "columnName");
        if (ZeusTransformUtils.instanceOf(r1, gy.class) == false) goto L10;
        if (Intrinsics.areEqual(r2, Params.CONTENT) == true) goto L11;
        return null;
    L11:
        return ((gy) ZeusTransformUtils.preCheckCast(r1, gy.class, "com.obric.memorydata.plugin")).b();
    L10:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public boolean hasKeywordSchema() {
        return this.entityIndexHelper.b();
    }

    @Override // com.obric.memorydata.database.index.e
    public boolean isBuildMetaInfoFullContent() {
        return false;
    }
}
