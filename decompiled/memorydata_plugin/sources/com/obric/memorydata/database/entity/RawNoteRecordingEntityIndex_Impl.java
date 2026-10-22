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
import com.ttnet.org.chromium.net.NetError;
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
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005H\u0016J\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u00172\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u0017H\u0016J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u0017H\u0016J\u0014\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000eH\u0016J\u0014\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000eH\u0016J&\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00102\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0#H\u0016J\u001e\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010'\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010(\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\fH\u0016J\u001a\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\fH\u0016J\b\u0010,\u001a\u00020\u0014H\u0016R#\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/obric/memorydata/database/entity/RawNoteRecordingEntityIndex_Impl;", "Lcom/obric/memorydata/database/entity/RawNoteRecordingEntityIndex;", "<init>", "()V", "entityIndexHelper", "Lcom/obric/memorydata/database/index/EntityIndexHelper;", "Lcom/obric/memorydata/database/entity/RawNoteRecordingEntity;", "Lcom/obric/memorydata/database/entity/NoteRecordingEntityTextVectorCopilotEntity;", "Lcom/obric/memorydata/database/entity/AbstractContentTimeEntity;", "getEntityIndexHelper", "()Lcom/obric/memorydata/database/index/EntityIndexHelper;", "TAG", "", "buildKeywordIndexMap", "", "entity", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "getKeywordSchema", "Lcom/obric/search/api/schema/impl/FullTextSearchSchema;", "hasKeywordSchema", "", "getEntityIndexHelperInstance", "getNeedUpdateColumns", "", "oldRawEntity", "newRawEntity", "getAllColumns", "getPendingTaskColumns", "getKeywordColumnMap", "getContentTimeColumns", "assignmentAssociateField", "", "oldEntity", "newEntity", "changeColumns", "", "generateIndexPendingTask", "", "Lcom/obric/memorydata/database/entity/IndexPendingEntity;", "columnName", "executeIndexPendingTask", "updateField", "getValueByColumn", "", "isBuildMetaInfoFullContent", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class RawNoteRecordingEntityIndex_Impl implements gx {
    private final String TAG;
    private final com.obric.memorydata.database.index.t<gw, dy, b> entityIndexHelper;

    public RawNoteRecordingEntityIndex_Impl() {
        com.obric.memorydata.database.index.t<gw, dy, b> r0 = new com.obric.memorydata.database.index.t();
        this.entityIndexHelper = r0;
        this.TAG = "RawNoteRecordingEntityIndex_Impl";
        IAppEntityRawDbDao<? extends d> r1 = getRawDao();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.memorydata.database.dao.IAppEntityRawDbDao<com.obric.memorydata.database.entity.RawNoteRecordingEntity>");
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
        if (ZeusTransformUtils.instanceOf(r2, gw.class) == false) goto L10;
        if (ZeusTransformUtils.instanceOf(r3, gw.class) == false) goto L8;
        return;
    L8:
        throw new IllegalStateException("Check failed.".toString());
    L10:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public Map<String, String> buildKeywordIndexMap(d r4) {
        Intrinsics.checkNotNullParameter(r4, "entity");
        if (ZeusTransformUtils.instanceOf(r4, gw.class) == false) goto L9;
        Map<String, String> r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        r3.put("common1", ((gw) ZeusTransformUtils.preCheckCast(r4, gw.class, "com.obric.memorydata.plugin")).c());
        String r5 = ((gw) ZeusTransformUtils.preCheckCast(r4, gw.class, "com.obric.memorydata.plugin")).j();
        if (r5 == null) goto L7;
        r3.put("common2", r5);
    L7:
        return r3;
    L9:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public boolean executeIndexPendingTask(d r19, String r20) {
        Intrinsics.checkNotNullParameter(r19, "entity");
        Intrinsics.checkNotNullParameter(r20, "updateField");
        if (ZeusTransformUtils.instanceOf(r19, gw.class) == false) goto L31;
        long r4 = System.currentTimeMillis();
        EntityIndexRecordInfo r2 = com.obric.memorydata.database.util.b.f9624a.a(r19);
        if (Intrinsics.areEqual(r20, "insert_keyword_task") == false) goto L7;
        boolean r6 = this.entityIndexHelper.b(((gw) ZeusTransformUtils.preCheckCast(r19, gw.class, "com.obric.memorydata.plugin")).getId(), buildKeywordIndexMap(r19));
    L9:
        if (Intrinsics.areEqual(r20, "transcript") == false) goto L13;
        String r13 = ((gw) ZeusTransformUtils.preCheckCast(r19, gw.class, "com.obric.memorydata.plugin")).f();
        if (r13 == null) goto L13;
        boolean r9 = this.entityIndexHelper.a((e) ZeusTransformUtils.preCheckCast(r19, e.class, "com.obric.memorydata.plugin"), r13, true, NetError.ERR_TOO_MANY_REDIRECTS, "txt", new String[0]);
    L15:
        if (Intrinsics.areEqual(r20, "summary") == false) goto L21;
        String r12 = ((gw) ZeusTransformUtils.preCheckCast(r19, gw.class, "com.obric.memorydata.plugin")).g();
        if (r12 == null) goto L19;
        boolean r0 = this.entityIndexHelper.b(r19, "summary", r12, "DEFAULT");
    L20:
        boolean r11 = r0;
    L22:
        if (r2 == null) goto L24;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", com.obric.memorydata.utils.u.a(r2), false, 4, null);
        com.obric.memorydata.database.util.b.f9624a.a("entityIndexTaskCost", String.valueOf(((gw) ZeusTransformUtils.preCheckCast(r19, gw.class, "com.obric.memorydata.plugin")).getType()), r20, System.currentTimeMillis() - r4);
    L24:
        if (r11 == false) goto L29;
        if (r9 == false) goto L29;
        if (r6 == false) goto L29;
        return true;
    L29:
        return false;
    L19:
        r0 = true;
        goto L20
    L21:
        r11 = true;
    L13:
        r9 = true;
        goto L15
    L7:
        r6 = true;
        goto L9
    L31:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public List<cd> generateIndexPendingTask(String r34, d r35) {
        Intrinsics.checkNotNullParameter(r34, "columnName");
        Intrinsics.checkNotNullParameter(r35, "entity");
        if (ZeusTransformUtils.instanceOf(r35, gw.class) == false) goto L36;
        int r0 = r34.hashCode();
        if (r0 == (-1937787423)) goto L30;
        if (r0 == (-1857640538)) goto L19;
        if (r0 != (-1729759306)) goto L32;
        if (r34.equals("transcript") == false) goto L32;
        if (((gw) ZeusTransformUtils.preCheckCast(r35, gw.class, "com.obric.memorydata.plugin")).f() == null) goto L32;
        return CollectionsKt.listOf(new cd(0, ((gw) ZeusTransformUtils.preCheckCast(r35, gw.class, "com.obric.memorydata.plugin")).getId(), ((gw) ZeusTransformUtils.preCheckCast(r35, gw.class, "com.obric.memorydata.plugin")).getType(), ((gw) ZeusTransformUtils.preCheckCast(r35, gw.class, "com.obric.memorydata.plugin")).getTimestamp(), ((gw) ZeusTransformUtils.preCheckCast(r35, gw.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, r34, "file_text", 0, 0, null, false, 0, 0, 32353, null));
    L32:
        return CollectionsKt.emptyList();
    L19:
        if (r34.equals("summary") == false) goto L32;
        if (((gw) ZeusTransformUtils.preCheckCast(r35, gw.class, "com.obric.memorydata.plugin")).g() == null) goto L32;
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L28;
        return this.entityIndexHelper.a(r35, r34, ((gw) ZeusTransformUtils.preCheckCast(r35, gw.class, "com.obric.memorydata.plugin")).g().toString());
    L28:
        return CollectionsKt.emptyList();
    L30:
        if (r34.equals("insert_keyword_task") == false) goto L32;
        return CollectionsKt.listOf(new cd(0, ((gw) ZeusTransformUtils.preCheckCast(r35, gw.class, "com.obric.memorydata.plugin")).getId(), ((gw) ZeusTransformUtils.preCheckCast(r35, gw.class, "com.obric.memorydata.plugin")).getType(), ((gw) ZeusTransformUtils.preCheckCast(r35, gw.class, "com.obric.memorydata.plugin")).getTimestamp(), ((gw) ZeusTransformUtils.preCheckCast(r35, gw.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, "insert_keyword_task", "keyword", 0, 0, null, false, 0, 0, 32353, null));
    L36:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public Set<String> getAllColumns() {
        Set<String> r2 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        r2.add(ActivityLifecycle.NAME);
        r2.add("transcript");
        r2.add("summary");
        r2.add("sourceAppName");
        return r2;
    }

    @Override // com.obric.memorydata.database.index.e
    public Map<String, String> getContentTimeColumns() {
        return (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityContentTimeDao<? extends b> getContentTimeDao() {
        return gx.a.d(this);
    }

    public final com.obric.memorydata.database.index.t<gw, dy, b> getEntityIndexHelper() {
        return this.entityIndexHelper;
    }

    @Override // com.obric.memorydata.database.index.e
    public com.obric.memorydata.database.index.t<gw, dy, b> getEntityIndexHelperInstance() {
        return this.entityIndexHelper;
    }

    @Override // com.obric.memorydata.database.index.e
    public IHistoryEntityDao<? extends c> getHistoryEntityDao() {
        return gx.a.e(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityVectorCopilotDao<? extends i> getImageCopilotDao() {
        return gx.a.c(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public Map<String, String> getKeywordColumnMap() {
        Map<String, String> r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        r2.put(ActivityLifecycle.NAME, "common1");
        r2.put("sourceAppName", "common2");
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
        if (ZeusTransformUtils.instanceOf(r9, gw.class) == false) goto L22;
        if (ZeusTransformUtils.instanceOf(r10, gw.class) == false) goto L20;
        Set<String> r8 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        if (gd.f9146a.a(((gw) ZeusTransformUtils.preCheckCast(r9, gw.class, "com.obric.memorydata.plugin")).c(), ((gw) ZeusTransformUtils.preCheckCast(r10, gw.class, "com.obric.memorydata.plugin")).c(), null, null, false) == true) goto L10;
        r8.add(ActivityLifecycle.NAME);
    L10:
        if (gd.f9146a.a(((gw) ZeusTransformUtils.preCheckCast(r9, gw.class, "com.obric.memorydata.plugin")).g(), ((gw) ZeusTransformUtils.preCheckCast(r10, gw.class, "com.obric.memorydata.plugin")).g(), Type.TEXT, null, false) == true) goto L13;
        r8.add("summary");
    L13:
        if (gd.f9146a.a(((gw) ZeusTransformUtils.preCheckCast(r9, gw.class, "com.obric.memorydata.plugin")).j(), ((gw) ZeusTransformUtils.preCheckCast(r10, gw.class, "com.obric.memorydata.plugin")).j(), null, null, false) == true) goto L16;
        r8.add("sourceAppName");
    L16:
        if (gd.f9146a.a(((gw) ZeusTransformUtils.preCheckCast(r9, gw.class, "com.obric.memorydata.plugin")).f(), ((gw) ZeusTransformUtils.preCheckCast(r10, gw.class, "com.obric.memorydata.plugin")).f(), null, null, false) == true) goto L18;
        r8.add("transcript");
    L18:
        return r8;
    L20:
        throw new IllegalStateException("Check failed.".toString());
    L22:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public Set<String> getPendingTaskColumns() {
        Set<String> r2 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        r2.add("insert_keyword_task");
        r2.add("summary");
        return r2;
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityRawDbDao<? extends d> getRawDao() {
        return gx.a.a(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityVectorCopilotDao<? extends i> getTextCopilotDao() {
        return gx.a.b(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public Object getValueByColumn(d r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "entity");
        Intrinsics.checkNotNullParameter(r2, "columnName");
        if (ZeusTransformUtils.instanceOf(r1, gw.class) == false) goto L10;
        if (Intrinsics.areEqual(r2, "summary") == true) goto L11;
        return null;
    L11:
        return ((gw) ZeusTransformUtils.preCheckCast(r1, gw.class, "com.obric.memorydata.plugin")).g();
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
