package com.obric.memorydata.database.entity;

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
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005H\u0016J\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u00172\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u0017H\u0016J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u0017H\u0016J\u0014\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000eH\u0016J\u0014\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000eH\u0016J&\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00102\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0#H\u0016J\u001e\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010'\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010(\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\fH\u0016J\u001a\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\fH\u0016J\b\u0010,\u001a\u00020\u0014H\u0016R#\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/obric/memorydata/database/entity/RawVideoFrameIndex_Impl;", "Lcom/obric/memorydata/database/entity/RawVideoFrameIndex;", "<init>", "()V", "entityIndexHelper", "Lcom/obric/memorydata/database/index/EntityIndexHelper;", "Lcom/obric/memorydata/database/entity/RawVideoFrameEntity;", "Lcom/obric/memorydata/database/entity/VideoFrameEntityTextVectorCopilotEntity;", "Lcom/obric/memorydata/database/entity/AbstractContentTimeEntity;", "getEntityIndexHelper", "()Lcom/obric/memorydata/database/index/EntityIndexHelper;", "TAG", "", "buildKeywordIndexMap", "", "entity", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "getKeywordSchema", "Lcom/obric/search/api/schema/impl/FullTextSearchSchema;", "hasKeywordSchema", "", "getEntityIndexHelperInstance", "getNeedUpdateColumns", "", "oldRawEntity", "newRawEntity", "getAllColumns", "getPendingTaskColumns", "getKeywordColumnMap", "getContentTimeColumns", "assignmentAssociateField", "", "oldEntity", "newEntity", "changeColumns", "", "generateIndexPendingTask", "", "Lcom/obric/memorydata/database/entity/IndexPendingEntity;", "columnName", "executeIndexPendingTask", "updateField", "getValueByColumn", "", "isBuildMetaInfoFullContent", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class RawVideoFrameIndex_Impl implements hs {
    private final String TAG;
    private final com.obric.memorydata.database.index.t<hr, ji, b> entityIndexHelper;

    public RawVideoFrameIndex_Impl() {
        com.obric.memorydata.database.index.t<hr, ji, b> r0 = new com.obric.memorydata.database.index.t();
        this.entityIndexHelper = r0;
        this.TAG = "RawVideoFrameIndex_Impl";
        IAppEntityRawDbDao<? extends d> r1 = getRawDao();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.memorydata.database.dao.IAppEntityRawDbDao<com.obric.memorydata.database.entity.RawVideoFrameEntity>");
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
        if (ZeusTransformUtils.instanceOf(r2, hr.class) == false) goto L10;
        if (ZeusTransformUtils.instanceOf(r3, hr.class) == false) goto L8;
        return;
    L8:
        throw new IllegalStateException("Check failed.".toString());
    L10:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public Map<String, String> buildKeywordIndexMap(d r3) {
        Intrinsics.checkNotNullParameter(r3, "entity");
        if (ZeusTransformUtils.instanceOf(r3, hr.class) == false) goto L9;
        Map<String, String> r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        String r4 = ((hr) ZeusTransformUtils.preCheckCast(r3, hr.class, "com.obric.memorydata.plugin")).e();
        if (r4 == null) goto L7;
        r2.put("common1", r4);
    L7:
        return r2;
    L9:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public boolean executeIndexPendingTask(d r25, String r26) {
        Intrinsics.checkNotNullParameter(r25, "entity");
        Intrinsics.checkNotNullParameter(r26, "updateField");
        if (ZeusTransformUtils.instanceOf(r25, hr.class) == false) goto L37;
        long r10 = System.currentTimeMillis();
        EntityIndexRecordInfo r12 = com.obric.memorydata.database.util.b.f9624a.a(r25);
        if (Intrinsics.areEqual(r26, "insert_keyword_task") == false) goto L7;
        boolean r15 = this.entityIndexHelper.b(((hr) ZeusTransformUtils.preCheckCast(r25, hr.class, "com.obric.memorydata.plugin")).getId(), buildKeywordIndexMap(r25));
    L9:
        if (Intrinsics.areEqual(r26, "meta_full_content") == false) goto L11;
        boolean r16 = com.obric.memorydata.database.index.t.f9438a.a(r25);
    L13:
        if (Intrinsics.areEqual(r26, "caption") == false) goto L19;
        String r2 = ((hr) ZeusTransformUtils.preCheckCast(r25, hr.class, "com.obric.memorydata.plugin")).d();
        if (r2 == null) goto L17;
        boolean r1 = this.entityIndexHelper.b(r25, "caption", r2, "DEFAULT");
    L18:
        boolean r17 = r1;
    L21:
        if (Intrinsics.areEqual(r26, "photoEntityDbId") == false) goto L26;
        boolean r3 = this.entityIndexHelper.a(r25, "file", ((hr) ZeusTransformUtils.preCheckCast(r25, hr.class, "com.obric.memorydata.plugin")).f(), ((hr) ZeusTransformUtils.preCheckCast(r25, hr.class, "com.obric.memorydata.plugin")).c());
        if (r3 == false) goto L25;
        this.entityIndexHelper.a(r25, "file", ((hr) ZeusTransformUtils.preCheckCast(r25, hr.class, "com.obric.memorydata.plugin")).f());
    L25:
        boolean r6 = r3;
    L27:
        if (r12 == null) goto L29;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", com.obric.memorydata.utils.u.a(r12), false, 4, null);
        com.obric.memorydata.database.util.b.f9624a.a("entityIndexTaskCost", String.valueOf(((hr) ZeusTransformUtils.preCheckCast(r25, hr.class, "com.obric.memorydata.plugin")).getType()), r26, System.currentTimeMillis() - r10);
    L29:
        if (r6 == false) goto L34;
        if (r17 == false) goto L34;
        if (r15 == false) goto L34;
        if (r16 == false) goto L34;
        return true;
    L34:
        return false;
    L26:
        r6 = true;
        goto L27
    L17:
        r1 = true;
        goto L18
    L19:
        r17 = true;
        goto L21
    L11:
        r16 = true;
        goto L13
    L7:
        r15 = true;
        goto L9
    L37:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public List<cd> generateIndexPendingTask(String r34, d r35) {
        Intrinsics.checkNotNullParameter(r34, "columnName");
        Intrinsics.checkNotNullParameter(r35, "entity");
        if (ZeusTransformUtils.instanceOf(r35, hr.class) == false) goto L40;
        switch(r34.hashCode()) {
            case -1937787423: goto L33;
            case -1536949565: goto L28;
            case -1493819250: goto L19;
            case 552573414: goto L8;
            default: goto L38;
        };
    L8:
        if (r34.equals("caption") == false) goto L38;
        if (((hr) ZeusTransformUtils.preCheckCast(r35, hr.class, "com.obric.memorydata.plugin")).d() == null) goto L38;
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L17;
        return this.entityIndexHelper.a(r35, r34, String.valueOf(((hr) ZeusTransformUtils.preCheckCast(r35, hr.class, "com.obric.memorydata.plugin")).d()));
    L17:
        return CollectionsKt.emptyList();
    L19:
        if (r34.equals("photoEntityDbId") == false) goto L38;
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L26;
        return CollectionsKt.listOf(new cd(0, ((hr) ZeusTransformUtils.preCheckCast(r35, hr.class, "com.obric.memorydata.plugin")).getId(), ((hr) ZeusTransformUtils.preCheckCast(r35, hr.class, "com.obric.memorydata.plugin")).getType(), ((hr) ZeusTransformUtils.preCheckCast(r35, hr.class, "com.obric.memorydata.plugin")).getTimestamp(), ((hr) ZeusTransformUtils.preCheckCast(r35, hr.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, r34, "video_frame", 0, 0, null, false, 0, 0, 32353, null));
    L26:
        return CollectionsKt.emptyList();
    L28:
        if (r34.equals("meta_full_content") == false) goto L38;
        return CollectionsKt.listOf(new cd(0, ((hr) ZeusTransformUtils.preCheckCast(r35, hr.class, "com.obric.memorydata.plugin")).getId(), ((hr) ZeusTransformUtils.preCheckCast(r35, hr.class, "com.obric.memorydata.plugin")).getType(), ((hr) ZeusTransformUtils.preCheckCast(r35, hr.class, "com.obric.memorydata.plugin")).getTimestamp(), ((hr) ZeusTransformUtils.preCheckCast(r35, hr.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, "meta_full_content", "meta_full_content", 0, 0, null, false, 0, 0, 32353, null));
    L33:
        if (r34.equals("insert_keyword_task") == false) goto L38;
        return CollectionsKt.listOf(new cd(0, ((hr) ZeusTransformUtils.preCheckCast(r35, hr.class, "com.obric.memorydata.plugin")).getId(), ((hr) ZeusTransformUtils.preCheckCast(r35, hr.class, "com.obric.memorydata.plugin")).getType(), ((hr) ZeusTransformUtils.preCheckCast(r35, hr.class, "com.obric.memorydata.plugin")).getTimestamp(), ((hr) ZeusTransformUtils.preCheckCast(r35, hr.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, "insert_keyword_task", "keyword", 0, 0, null, false, 0, 0, 32353, null));
    L38:
        return CollectionsKt.emptyList();
    L40:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public Set<String> getAllColumns() {
        Set<String> r2 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        r2.add("caption");
        r2.add("ocr");
        r2.add("photoEntityDbId");
        r2.add("meta_full_content");
        return r2;
    }

    @Override // com.obric.memorydata.database.index.e
    public Map<String, String> getContentTimeColumns() {
        return (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityContentTimeDao<? extends b> getContentTimeDao() {
        return hs.a.d(this);
    }

    public final com.obric.memorydata.database.index.t<hr, ji, b> getEntityIndexHelper() {
        return this.entityIndexHelper;
    }

    @Override // com.obric.memorydata.database.index.e
    public com.obric.memorydata.database.index.t<hr, ji, b> getEntityIndexHelperInstance() {
        return this.entityIndexHelper;
    }

    @Override // com.obric.memorydata.database.index.e
    public IHistoryEntityDao<? extends c> getHistoryEntityDao() {
        return hs.a.e(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityVectorCopilotDao<? extends i> getImageCopilotDao() {
        return hs.a.c(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public Map<String, String> getKeywordColumnMap() {
        Map<String, String> r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        r2.put("ocr", "common1");
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
        if (ZeusTransformUtils.instanceOf(r9, hr.class) == false) goto L20;
        if (ZeusTransformUtils.instanceOf(r10, hr.class) == false) goto L18;
        Set<String> r8 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        if (gd.f9146a.a(((hr) ZeusTransformUtils.preCheckCast(r9, hr.class, "com.obric.memorydata.plugin")).d(), ((hr) ZeusTransformUtils.preCheckCast(r10, hr.class, "com.obric.memorydata.plugin")).d(), Type.TEXT, null, false) == true) goto L10;
        r8.add("caption");
    L10:
        if (gd.f9146a.a(((hr) ZeusTransformUtils.preCheckCast(r9, hr.class, "com.obric.memorydata.plugin")).e(), ((hr) ZeusTransformUtils.preCheckCast(r10, hr.class, "com.obric.memorydata.plugin")).e(), null, null, false) == true) goto L13;
        r8.add("ocr");
    L13:
        if (gd.f9146a.a(Long.valueOf(((hr) ZeusTransformUtils.preCheckCast(r9, hr.class, "com.obric.memorydata.plugin")).f()), Long.valueOf(((hr) ZeusTransformUtils.preCheckCast(r10, hr.class, "com.obric.memorydata.plugin")).f()), Type.VIDEO_FRAME, null, false) == true) goto L15;
        r8.add("photoEntityDbId");
    L15:
        r8.add("meta_full_content");
        return r8;
    L18:
        throw new IllegalStateException("Check failed.".toString());
    L20:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public Set<String> getPendingTaskColumns() {
        Set<String> r2 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        r2.add("insert_keyword_task");
        r2.add("meta_full_content");
        r2.add("caption");
        r2.add("photoEntityDbId");
        return r2;
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityRawDbDao<? extends d> getRawDao() {
        return hs.a.a(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityVectorCopilotDao<? extends i> getTextCopilotDao() {
        return hs.a.b(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public Object getValueByColumn(d r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        Intrinsics.checkNotNullParameter(r3, "columnName");
        if (ZeusTransformUtils.instanceOf(r2, hr.class) == false) goto L13;
        if (Intrinsics.areEqual(r3, "caption") == false) goto L8;
        return ((hr) ZeusTransformUtils.preCheckCast(r2, hr.class, "com.obric.memorydata.plugin")).d();
    L8:
        if (Intrinsics.areEqual(r3, "photoEntityDbId") == true) goto L15;
        return null;
    L15:
        return Long.valueOf(((hr) ZeusTransformUtils.preCheckCast(r2, hr.class, "com.obric.memorydata.plugin")).f());
    L13:
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
