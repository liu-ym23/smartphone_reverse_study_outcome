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
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005H\u0016J\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u00172\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u0017H\u0016J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u0017H\u0016J\u0014\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000eH\u0016J\u0014\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000eH\u0016J&\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00102\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0#H\u0016J\u001e\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010'\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010(\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\fH\u0016J\u001a\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\fH\u0016J\b\u0010,\u001a\u00020\u0014H\u0016R#\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/obric/memorydata/database/entity/RawMetaLocationIndex_Impl;", "Lcom/obric/memorydata/database/entity/RawMetaLocationIndex;", "<init>", "()V", "entityIndexHelper", "Lcom/obric/memorydata/database/index/EntityIndexHelper;", "Lcom/obric/memorydata/database/entity/RawMetaLocationEntity;", "Lcom/obric/memorydata/database/entity/MetaLocationEntityTextVectorCopilotEntity;", "Lcom/obric/memorydata/database/entity/AbstractContentTimeEntity;", "getEntityIndexHelper", "()Lcom/obric/memorydata/database/index/EntityIndexHelper;", "TAG", "", "buildKeywordIndexMap", "", "entity", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "getKeywordSchema", "Lcom/obric/search/api/schema/impl/FullTextSearchSchema;", "hasKeywordSchema", "", "getEntityIndexHelperInstance", "getNeedUpdateColumns", "", "oldRawEntity", "newRawEntity", "getAllColumns", "getPendingTaskColumns", "getKeywordColumnMap", "getContentTimeColumns", "assignmentAssociateField", "", "oldEntity", "newEntity", "changeColumns", "", "generateIndexPendingTask", "", "Lcom/obric/memorydata/database/entity/IndexPendingEntity;", "columnName", "executeIndexPendingTask", "updateField", "getValueByColumn", "", "isBuildMetaInfoFullContent", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class RawMetaLocationIndex_Impl implements gr {
    private final String TAG;
    private final com.obric.memorydata.database.index.t<gq, dm, b> entityIndexHelper;

    public RawMetaLocationIndex_Impl() {
        com.obric.memorydata.database.index.t<gq, dm, b> r0 = new com.obric.memorydata.database.index.t();
        this.entityIndexHelper = r0;
        this.TAG = "RawMetaLocationIndex_Impl";
        IAppEntityRawDbDao<? extends d> r1 = getRawDao();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.memorydata.database.dao.IAppEntityRawDbDao<com.obric.memorydata.database.entity.RawMetaLocationEntity>");
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
        if (ZeusTransformUtils.instanceOf(r2, gq.class) == false) goto L10;
        if (ZeusTransformUtils.instanceOf(r3, gq.class) == false) goto L8;
        return;
    L8:
        throw new IllegalStateException("Check failed.".toString());
    L10:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public Map<String, String> buildKeywordIndexMap(d r4) {
        Intrinsics.checkNotNullParameter(r4, "entity");
        if (ZeusTransformUtils.instanceOf(r4, gq.class) == false) goto L33;
        Map<String, String> r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        String r0 = ((gq) ZeusTransformUtils.preCheckCast(r4, gq.class, "com.obric.memorydata.plugin")).b();
        if (r0 == null) goto L7;
        r3.put("common1", r0);
    L7:
        String r1 = ((gq) ZeusTransformUtils.preCheckCast(r4, gq.class, "com.obric.memorydata.plugin")).c();
        if (r1 == null) goto L10;
        r3.put("common2", r1);
    L10:
        String r2 = ((gq) ZeusTransformUtils.preCheckCast(r4, gq.class, "com.obric.memorydata.plugin")).d();
        if (r2 == null) goto L13;
        r3.put("common3", r2);
    L13:
        String r5 = ((gq) ZeusTransformUtils.preCheckCast(r4, gq.class, "com.obric.memorydata.plugin")).e();
        if (r5 == null) goto L16;
        r3.put("common4", r5);
    L16:
        String r6 = ((gq) ZeusTransformUtils.preCheckCast(r4, gq.class, "com.obric.memorydata.plugin")).f();
        if (r6 == null) goto L19;
        r3.put("common5", r6);
    L19:
        String r7 = ((gq) ZeusTransformUtils.preCheckCast(r4, gq.class, "com.obric.memorydata.plugin")).g();
        if (r7 == null) goto L22;
        r3.put("common6", r7);
    L22:
        String r8 = ((gq) ZeusTransformUtils.preCheckCast(r4, gq.class, "com.obric.memorydata.plugin")).h();
        if (r8 == null) goto L25;
        r3.put("common7", r8);
    L25:
        String r9 = ((gq) ZeusTransformUtils.preCheckCast(r4, gq.class, "com.obric.memorydata.plugin")).i();
        if (r9 == null) goto L28;
        r3.put("common8", r9);
    L28:
        String r10 = ((gq) ZeusTransformUtils.preCheckCast(r4, gq.class, "com.obric.memorydata.plugin")).j();
        if (r10 == null) goto L31;
        r3.put("common9", r10);
    L31:
        return r3;
    L33:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public boolean executeIndexPendingTask(d r17, String r18) {
        Intrinsics.checkNotNullParameter(r17, "entity");
        Intrinsics.checkNotNullParameter(r18, "updateField");
        if (ZeusTransformUtils.instanceOf(r17, gq.class) == false) goto L24;
        long r4 = System.currentTimeMillis();
        EntityIndexRecordInfo r2 = com.obric.memorydata.database.util.b.f9624a.a(r17);
        if (Intrinsics.areEqual(r18, "insert_keyword_task") == false) goto L7;
        boolean r6 = this.entityIndexHelper.b(((gq) ZeusTransformUtils.preCheckCast(r17, gq.class, "com.obric.memorydata.plugin")).getId(), buildKeywordIndexMap(r17));
    L9:
        if (Intrinsics.areEqual(r18, "fullAddress") == false) goto L15;
        String r10 = ((gq) ZeusTransformUtils.preCheckCast(r17, gq.class, "com.obric.memorydata.plugin")).j();
        if (r10 == null) goto L13;
        boolean r0 = this.entityIndexHelper.b(r17, "fullAddress", r10, "DEFAULT");
    L14:
        boolean r9 = r0;
    L16:
        if (r2 == null) goto L18;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", com.obric.memorydata.utils.u.a(r2), false, 4, null);
        com.obric.memorydata.database.util.b.f9624a.a("entityIndexTaskCost", String.valueOf(((gq) ZeusTransformUtils.preCheckCast(r17, gq.class, "com.obric.memorydata.plugin")).getType()), r18, System.currentTimeMillis() - r4);
    L18:
        if (r9 == false) goto L21;
        if (r6 == false) goto L21;
        return true;
    L21:
        return false;
    L13:
        r0 = true;
        goto L14
    L15:
        r9 = true;
        goto L16
    L7:
        r6 = true;
        goto L9
    L24:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public List<cd> generateIndexPendingTask(String r28, d r29) {
        Intrinsics.checkNotNullParameter(r28, "columnName");
        Intrinsics.checkNotNullParameter(r29, "entity");
        if (ZeusTransformUtils.instanceOf(r29, gq.class) == false) goto L21;
        if (Intrinsics.areEqual(r28, "fullAddress") == false) goto L15;
        if (((gq) ZeusTransformUtils.preCheckCast(r29, gq.class, "com.obric.memorydata.plugin")).j() == null) goto L19;
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L13;
        return this.entityIndexHelper.a(r29, r28, ((gq) ZeusTransformUtils.preCheckCast(r29, gq.class, "com.obric.memorydata.plugin")).j().toString());
    L13:
        return CollectionsKt.emptyList();
    L19:
        return CollectionsKt.emptyList();
    L15:
        if (Intrinsics.areEqual(r28, "insert_keyword_task") == false) goto L19;
        return CollectionsKt.listOf(new cd(0, ((gq) ZeusTransformUtils.preCheckCast(r29, gq.class, "com.obric.memorydata.plugin")).getId(), ((gq) ZeusTransformUtils.preCheckCast(r29, gq.class, "com.obric.memorydata.plugin")).getType(), ((gq) ZeusTransformUtils.preCheckCast(r29, gq.class, "com.obric.memorydata.plugin")).getTimestamp(), ((gq) ZeusTransformUtils.preCheckCast(r29, gq.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, "insert_keyword_task", "keyword", 0, 0, null, false, 0, 0, 32353, null));
    L21:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public Set<String> getAllColumns() {
        Set<String> r2 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        r2.add("country");
        r2.add("stateOrProvince");
        r2.add("administrativeArea");
        r2.add("locality");
        r2.add("subLocality");
        r2.add("thoroughfare");
        r2.add("subThoroughfare");
        r2.add("namedLocation");
        r2.add("fullAddress");
        return r2;
    }

    @Override // com.obric.memorydata.database.index.e
    public Map<String, String> getContentTimeColumns() {
        return (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityContentTimeDao<? extends b> getContentTimeDao() {
        return gr.a.d(this);
    }

    public final com.obric.memorydata.database.index.t<gq, dm, b> getEntityIndexHelper() {
        return this.entityIndexHelper;
    }

    @Override // com.obric.memorydata.database.index.e
    public com.obric.memorydata.database.index.t<gq, dm, b> getEntityIndexHelperInstance() {
        return this.entityIndexHelper;
    }

    @Override // com.obric.memorydata.database.index.e
    public IHistoryEntityDao<? extends c> getHistoryEntityDao() {
        return gr.a.e(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityVectorCopilotDao<? extends i> getImageCopilotDao() {
        return gr.a.c(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public Map<String, String> getKeywordColumnMap() {
        Map<String, String> r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        r2.put("country", "common1");
        r2.put("stateOrProvince", "common2");
        r2.put("administrativeArea", "common3");
        r2.put("locality", "common4");
        r2.put("subLocality", "common5");
        r2.put("thoroughfare", "common6");
        r2.put("subThoroughfare", "common7");
        r2.put("namedLocation", "common8");
        r2.put("fullAddress", "common9");
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
        if (ZeusTransformUtils.instanceOf(r9, gq.class) == false) goto L37;
        if (ZeusTransformUtils.instanceOf(r10, gq.class) == false) goto L35;
        Set<String> r8 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        if (gd.f9146a.a(((gq) ZeusTransformUtils.preCheckCast(r9, gq.class, "com.obric.memorydata.plugin")).b(), ((gq) ZeusTransformUtils.preCheckCast(r10, gq.class, "com.obric.memorydata.plugin")).b(), null, null, false) == true) goto L10;
        r8.add("country");
    L10:
        if (gd.f9146a.a(((gq) ZeusTransformUtils.preCheckCast(r9, gq.class, "com.obric.memorydata.plugin")).c(), ((gq) ZeusTransformUtils.preCheckCast(r10, gq.class, "com.obric.memorydata.plugin")).c(), null, null, false) == true) goto L13;
        r8.add("stateOrProvince");
    L13:
        if (gd.f9146a.a(((gq) ZeusTransformUtils.preCheckCast(r9, gq.class, "com.obric.memorydata.plugin")).d(), ((gq) ZeusTransformUtils.preCheckCast(r10, gq.class, "com.obric.memorydata.plugin")).d(), null, null, false) == true) goto L16;
        r8.add("administrativeArea");
    L16:
        if (gd.f9146a.a(((gq) ZeusTransformUtils.preCheckCast(r9, gq.class, "com.obric.memorydata.plugin")).e(), ((gq) ZeusTransformUtils.preCheckCast(r10, gq.class, "com.obric.memorydata.plugin")).e(), null, null, false) == true) goto L19;
        r8.add("locality");
    L19:
        if (gd.f9146a.a(((gq) ZeusTransformUtils.preCheckCast(r9, gq.class, "com.obric.memorydata.plugin")).f(), ((gq) ZeusTransformUtils.preCheckCast(r10, gq.class, "com.obric.memorydata.plugin")).f(), null, null, false) == true) goto L22;
        r8.add("subLocality");
    L22:
        if (gd.f9146a.a(((gq) ZeusTransformUtils.preCheckCast(r9, gq.class, "com.obric.memorydata.plugin")).g(), ((gq) ZeusTransformUtils.preCheckCast(r10, gq.class, "com.obric.memorydata.plugin")).g(), null, null, false) == true) goto L25;
        r8.add("thoroughfare");
    L25:
        if (gd.f9146a.a(((gq) ZeusTransformUtils.preCheckCast(r9, gq.class, "com.obric.memorydata.plugin")).h(), ((gq) ZeusTransformUtils.preCheckCast(r10, gq.class, "com.obric.memorydata.plugin")).h(), null, null, false) == true) goto L28;
        r8.add("subThoroughfare");
    L28:
        if (gd.f9146a.a(((gq) ZeusTransformUtils.preCheckCast(r9, gq.class, "com.obric.memorydata.plugin")).i(), ((gq) ZeusTransformUtils.preCheckCast(r10, gq.class, "com.obric.memorydata.plugin")).i(), null, null, false) == true) goto L31;
        r8.add("namedLocation");
    L31:
        if (gd.f9146a.a(((gq) ZeusTransformUtils.preCheckCast(r9, gq.class, "com.obric.memorydata.plugin")).j(), ((gq) ZeusTransformUtils.preCheckCast(r10, gq.class, "com.obric.memorydata.plugin")).j(), Type.TEXT, null, false) == true) goto L33;
        r8.add("fullAddress");
    L33:
        return r8;
    L35:
        throw new IllegalStateException("Check failed.".toString());
    L37:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public Set<String> getPendingTaskColumns() {
        Set<String> r2 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        r2.add("insert_keyword_task");
        r2.add("fullAddress");
        return r2;
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityRawDbDao<? extends d> getRawDao() {
        return gr.a.a(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityVectorCopilotDao<? extends i> getTextCopilotDao() {
        return gr.a.b(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public Object getValueByColumn(d r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "entity");
        Intrinsics.checkNotNullParameter(r2, "columnName");
        if (ZeusTransformUtils.instanceOf(r1, gq.class) == false) goto L10;
        if (Intrinsics.areEqual(r2, "fullAddress") == true) goto L11;
        return null;
    L11:
        return ((gq) ZeusTransformUtils.preCheckCast(r1, gq.class, "com.obric.memorydata.plugin")).j();
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
