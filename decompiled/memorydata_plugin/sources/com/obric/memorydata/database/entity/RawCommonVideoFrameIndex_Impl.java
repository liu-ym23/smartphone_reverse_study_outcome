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
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005H\u0016J\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u00172\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u0017H\u0016J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u0017H\u0016J\u0014\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000eH\u0016J\u0014\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000eH\u0016J&\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00102\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0#H\u0016J\u001e\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010'\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010(\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\fH\u0016J\u001a\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\fH\u0016J\b\u0010,\u001a\u00020\u0014H\u0016R#\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/obric/memorydata/database/entity/RawCommonVideoFrameIndex_Impl;", "Lcom/obric/memorydata/database/entity/RawCommonVideoFrameIndex;", "<init>", "()V", "entityIndexHelper", "Lcom/obric/memorydata/database/index/EntityIndexHelper;", "Lcom/obric/memorydata/database/entity/RawCommonVideoFrameEntity;", "Lcom/obric/memorydata/database/entity/CommonVideoFrameEntityTextVectorCopilotEntity;", "Lcom/obric/memorydata/database/entity/AbstractContentTimeEntity;", "getEntityIndexHelper", "()Lcom/obric/memorydata/database/index/EntityIndexHelper;", "TAG", "", "buildKeywordIndexMap", "", "entity", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "getKeywordSchema", "Lcom/obric/search/api/schema/impl/FullTextSearchSchema;", "hasKeywordSchema", "", "getEntityIndexHelperInstance", "getNeedUpdateColumns", "", "oldRawEntity", "newRawEntity", "getAllColumns", "getPendingTaskColumns", "getKeywordColumnMap", "getContentTimeColumns", "assignmentAssociateField", "", "oldEntity", "newEntity", "changeColumns", "", "generateIndexPendingTask", "", "Lcom/obric/memorydata/database/entity/IndexPendingEntity;", "columnName", "executeIndexPendingTask", "updateField", "getValueByColumn", "", "isBuildMetaInfoFullContent", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class RawCommonVideoFrameIndex_Impl implements fw {
    private final String TAG;
    private final com.obric.memorydata.database.index.t<fv, ap, b> entityIndexHelper;

    public RawCommonVideoFrameIndex_Impl() {
        com.obric.memorydata.database.index.t<fv, ap, b> r0 = new com.obric.memorydata.database.index.t();
        this.entityIndexHelper = r0;
        this.TAG = "RawCommonVideoFrameIndex_Impl";
        IAppEntityRawDbDao<? extends d> r1 = getRawDao();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.memorydata.database.dao.IAppEntityRawDbDao<com.obric.memorydata.database.entity.RawCommonVideoFrameEntity>");
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

    private static final Unit executeIndexPendingTask$lambda$3(RawCommonVideoFrameIndex_Impl r4, d r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "it");
        IAppEntityRawDbDao<? extends d> r0 = r4.getRawDao();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.obric.memorydata.database.dao.IAppEntityRawDbDao<com.obric.memorydata.database.entity.RawCommonVideoFrameEntity>");
        List<T> r7 = r0.queryByEntityId(((fv) ZeusTransformUtils.preCheckCast(r5, fv.class, "com.obric.memorydata.plugin")).getEntityId(), ((fv) ZeusTransformUtils.preCheckCast(r5, fv.class, "com.obric.memorydata.plugin")).getPackageName());
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L6;
        fv r8 = (fv) ZeusTransformUtils.preCheckCast(r7.get(0), fv.class, "com.obric.memorydata.plugin");
        r8.a(r4.entityIndexHelper.a(r8.d(), r6));
        r0.update(r8);
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit executeIndexPendingTask$lambda$4(RawCommonVideoFrameIndex_Impl r6, d r7, String r8) {
        Intrinsics.checkNotNullParameter(r8, "it");
        IAppEntityRawDbDao<? extends d> r0 = r6.getRawDao();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.obric.memorydata.database.dao.IAppEntityRawDbDao<com.obric.memorydata.database.entity.RawCommonVideoFrameEntity>");
        List<T> r9 = r0.queryByEntityId(((fv) ZeusTransformUtils.preCheckCast(r7, fv.class, "com.obric.memorydata.plugin")).getEntityId(), ((fv) ZeusTransformUtils.preCheckCast(r7, fv.class, "com.obric.memorydata.plugin")).getPackageName());
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L6;
        fv r10 = (fv) ZeusTransformUtils.preCheckCast(r9.get(0), fv.class, "com.obric.memorydata.plugin");
        r6.entityIndexHelper.a(r10.getId(), r6.buildKeywordIndexMap((d) ZeusTransformUtils.preCheckCast(r10, d.class, "com.obric.memorydata.plugin")));
        r10.b(r6.entityIndexHelper.a(r10.e(), r8));
        r0.update(r10);
        r6.entityIndexHelper.b(r10.getId(), r6.buildKeywordIndexMap((d) ZeusTransformUtils.preCheckCast(r10, d.class, "com.obric.memorydata.plugin")));
    L6:
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$gvgOz_e4Z5QJaDvgC-8vbPqGnIE, reason: not valid java name */
    public static /* synthetic */ Unit m544lambda$gvgOz_e4Z5QJaDvgC8vbPqGnIE(RawCommonVideoFrameIndex_Impl r0, d r1, String r2) {
        return executeIndexPendingTask$lambda$3(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$xE-4JpDVEe95lIhRwvbCHmDlsCc, reason: not valid java name */
    public static /* synthetic */ Unit m545lambda$xE4JpDVEe95lIhRwvbCHmDlsCc(RawCommonVideoFrameIndex_Impl r0, d r1, String r2) {
        return executeIndexPendingTask$lambda$4(r0, r1, r2);
    }

    @Override // com.obric.memorydata.database.index.e
    public void assignmentAssociateField(d r3, d r4, Set<String> r5) {
        Set r2 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "oldEntity");
        Intrinsics.checkNotNullParameter(r4, "newEntity");
        Intrinsics.checkNotNullParameter(r2, "changeColumns");
        if (ZeusTransformUtils.instanceOf(r3, fv.class) == false) goto L16;
        if (ZeusTransformUtils.instanceOf(r4, fv.class) == false) goto L14;
        if (r2.contains("caption") == true) goto L10;
        ((fv) ZeusTransformUtils.preCheckCast(r4, fv.class, "com.obric.memorydata.plugin")).a(((fv) ZeusTransformUtils.preCheckCast(r3, fv.class, "com.obric.memorydata.plugin")).d());
    L10:
        if (r2.contains("ocr") == true) goto L17;
        ((fv) ZeusTransformUtils.preCheckCast(r4, fv.class, "com.obric.memorydata.plugin")).b(((fv) ZeusTransformUtils.preCheckCast(r3, fv.class, "com.obric.memorydata.plugin")).e());
        return;
    L17:
        return;
    L14:
        throw new IllegalStateException("Check failed.".toString());
    L16:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public Map<String, String> buildKeywordIndexMap(d r3) {
        Intrinsics.checkNotNullParameter(r3, "entity");
        if (ZeusTransformUtils.instanceOf(r3, fv.class) == false) goto L9;
        Map<String, String> r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        String r4 = ((fv) ZeusTransformUtils.preCheckCast(r3, fv.class, "com.obric.memorydata.plugin")).e();
        if (r4 == null) goto L7;
        r2.put("common1", r4);
    L7:
        return r2;
    L9:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public boolean executeIndexPendingTask(final d r25, String r26) {
        Intrinsics.checkNotNullParameter(r25, "entity");
        Intrinsics.checkNotNullParameter(r26, "updateField");
        if (ZeusTransformUtils.instanceOf(r25, fv.class) == false) goto L41;
        long r10 = System.currentTimeMillis();
        EntityIndexRecordInfo r12 = com.obric.memorydata.database.util.b.f9624a.a(r25);
        if (Intrinsics.areEqual(r26, "insert_keyword_task") == false) goto L7;
        boolean r15 = this.entityIndexHelper.b(((fv) ZeusTransformUtils.preCheckCast(r25, fv.class, "com.obric.memorydata.plugin")).getId(), buildKeywordIndexMap(r25));
    L9:
        if (Intrinsics.areEqual(r26, "caption") == false) goto L15;
        Function1<? super String, Unit> r6 = new $$Lambda$RawCommonVideoFrameIndex_Impl$gvgOz_e4Z5QJaDvgC8vbPqGnIE(this, r25);
        com.obric.memorydata.database.index.t<fv, ap, b> r1 = this.entityIndexHelper;
        Long r2 = Long.valueOf(((fv) ZeusTransformUtils.preCheckCast(r25, fv.class, "com.obric.memorydata.plugin")).f());
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L13;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin");
    L14:
        boolean r16 = r1.b(r25, "caption", r4, "", r6);
    L17:
        if (Intrinsics.areEqual(r26, "ocr") == false) goto L23;
        Function1<? super String, Unit> r7 = new $$Lambda$RawCommonVideoFrameIndex_Impl$xE4JpDVEe95lIhRwvbCHmDlsCc(this, r25);
        com.obric.memorydata.database.index.t<fv, ap, b> r3 = this.entityIndexHelper;
        Long r5 = Long.valueOf(((fv) ZeusTransformUtils.preCheckCast(r25, fv.class, "com.obric.memorydata.plugin")).f());
        if (ZeusTransformUtils.instanceOf(r5, String.class) == false) goto L21;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin");
    L22:
        boolean r17 = r3.a(r25, "ocr", r8, "common1", r7);
    L25:
        if (Intrinsics.areEqual(r26, "photoEntityDbId") == false) goto L30;
        boolean r9 = this.entityIndexHelper.a(r25, "file", ((fv) ZeusTransformUtils.preCheckCast(r25, fv.class, "com.obric.memorydata.plugin")).f(), ((fv) ZeusTransformUtils.preCheckCast(r25, fv.class, "com.obric.memorydata.plugin")).c());
        if (r9 == false) goto L29;
        this.entityIndexHelper.a(r25, "file", ((fv) ZeusTransformUtils.preCheckCast(r25, fv.class, "com.obric.memorydata.plugin")).f());
    L29:
        boolean r11 = r9;
    L31:
        if (r12 == null) goto L33;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", com.obric.memorydata.utils.u.a(r12), false, 4, null);
        com.obric.memorydata.database.util.b.f9624a.a("entityIndexTaskCost", String.valueOf(((fv) ZeusTransformUtils.preCheckCast(r25, fv.class, "com.obric.memorydata.plugin")).getType()), r26, System.currentTimeMillis() - r10);
    L33:
        if (r11 == false) goto L38;
        if (r16 == false) goto L38;
        if (r17 == false) goto L38;
        if (r15 == false) goto L38;
        return true;
    L38:
        return false;
    L30:
        r11 = true;
        goto L31
    L21:
        r8 = null;
        goto L22
    L23:
        r17 = true;
        goto L25
    L13:
        r4 = null;
        goto L14
    L15:
        r16 = true;
        goto L17
    L7:
        r15 = true;
        goto L9
    L41:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public List<cd> generateIndexPendingTask(String r34, d r35) {
        Intrinsics.checkNotNullParameter(r34, "columnName");
        Intrinsics.checkNotNullParameter(r35, "entity");
        if (ZeusTransformUtils.instanceOf(r35, fv.class) == false) goto L44;
        switch(r34.hashCode()) {
            case -1937787423: goto L37;
            case -1493819250: goto L28;
            case 109854: goto L19;
            case 552573414: goto L8;
            default: goto L42;
        };
    L8:
        if (r34.equals("caption") == false) goto L42;
        ((fv) ZeusTransformUtils.preCheckCast(r35, fv.class, "com.obric.memorydata.plugin")).f();
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L17;
        if (DeviceInfoState.INSTANCE.isSupportVLM() == false) goto L17;
        return CollectionsKt.listOf(new cd(0, ((fv) ZeusTransformUtils.preCheckCast(r35, fv.class, "com.obric.memorydata.plugin")).getId(), ((fv) ZeusTransformUtils.preCheckCast(r35, fv.class, "com.obric.memorydata.plugin")).getType(), ((fv) ZeusTransformUtils.preCheckCast(r35, fv.class, "com.obric.memorydata.plugin")).getTimestamp(), ((fv) ZeusTransformUtils.preCheckCast(r35, fv.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, r34, "caption", 0, 0, null, false, 0, 0, 32353, null));
    L17:
        return CollectionsKt.emptyList();
    L19:
        if (r34.equals("ocr") == false) goto L42;
        ((fv) ZeusTransformUtils.preCheckCast(r35, fv.class, "com.obric.memorydata.plugin")).f();
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L26;
        return CollectionsKt.listOf(new cd(0, ((fv) ZeusTransformUtils.preCheckCast(r35, fv.class, "com.obric.memorydata.plugin")).getId(), ((fv) ZeusTransformUtils.preCheckCast(r35, fv.class, "com.obric.memorydata.plugin")).getType(), ((fv) ZeusTransformUtils.preCheckCast(r35, fv.class, "com.obric.memorydata.plugin")).getTimestamp(), ((fv) ZeusTransformUtils.preCheckCast(r35, fv.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, r34, "ocr", 0, 0, null, false, 0, 0, 32353, null));
    L26:
        return CollectionsKt.emptyList();
    L28:
        if (r34.equals("photoEntityDbId") == false) goto L42;
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L35;
        return CollectionsKt.listOf(new cd(0, ((fv) ZeusTransformUtils.preCheckCast(r35, fv.class, "com.obric.memorydata.plugin")).getId(), ((fv) ZeusTransformUtils.preCheckCast(r35, fv.class, "com.obric.memorydata.plugin")).getType(), ((fv) ZeusTransformUtils.preCheckCast(r35, fv.class, "com.obric.memorydata.plugin")).getTimestamp(), ((fv) ZeusTransformUtils.preCheckCast(r35, fv.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, r34, "video_frame", 0, 0, null, false, 0, 0, 32353, null));
    L35:
        return CollectionsKt.emptyList();
    L37:
        if (r34.equals("insert_keyword_task") == false) goto L42;
        return CollectionsKt.listOf(new cd(0, ((fv) ZeusTransformUtils.preCheckCast(r35, fv.class, "com.obric.memorydata.plugin")).getId(), ((fv) ZeusTransformUtils.preCheckCast(r35, fv.class, "com.obric.memorydata.plugin")).getType(), ((fv) ZeusTransformUtils.preCheckCast(r35, fv.class, "com.obric.memorydata.plugin")).getTimestamp(), ((fv) ZeusTransformUtils.preCheckCast(r35, fv.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, "insert_keyword_task", "keyword", 0, 0, null, false, 0, 0, 32353, null));
    L42:
        return CollectionsKt.emptyList();
    L44:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public Set<String> getAllColumns() {
        Set<String> r2 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        r2.add("caption");
        r2.add("ocr");
        r2.add("photoEntityDbId");
        return r2;
    }

    @Override // com.obric.memorydata.database.index.e
    public Map<String, String> getContentTimeColumns() {
        return (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityContentTimeDao<? extends b> getContentTimeDao() {
        return fw.a.d(this);
    }

    public final com.obric.memorydata.database.index.t<fv, ap, b> getEntityIndexHelper() {
        return this.entityIndexHelper;
    }

    @Override // com.obric.memorydata.database.index.e
    public com.obric.memorydata.database.index.t<fv, ap, b> getEntityIndexHelperInstance() {
        return this.entityIndexHelper;
    }

    @Override // com.obric.memorydata.database.index.e
    public IHistoryEntityDao<? extends c> getHistoryEntityDao() {
        return fw.a.e(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityVectorCopilotDao<? extends i> getImageCopilotDao() {
        return fw.a.c(this);
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
        if (ZeusTransformUtils.instanceOf(r9, fv.class) == false) goto L13;
        if (ZeusTransformUtils.instanceOf(r10, fv.class) == false) goto L11;
        Set<String> r8 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        if (gd.f9146a.a(Long.valueOf(((fv) ZeusTransformUtils.preCheckCast(r9, fv.class, "com.obric.memorydata.plugin")).f()), Long.valueOf(((fv) ZeusTransformUtils.preCheckCast(r10, fv.class, "com.obric.memorydata.plugin")).f()), Type.VIDEO_FRAME, null, false) == true) goto L9;
        r8.add("photoEntityDbId");
        r8.add("caption");
        r8.add("ocr");
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
        r2.add("insert_keyword_task");
        r2.add("caption");
        r2.add("ocr");
        r2.add("photoEntityDbId");
        return r2;
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityRawDbDao<? extends d> getRawDao() {
        return fw.a.a(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityVectorCopilotDao<? extends i> getTextCopilotDao() {
        return fw.a.b(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public Object getValueByColumn(d r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "entity");
        Intrinsics.checkNotNullParameter(r4, "columnName");
        if (ZeusTransformUtils.instanceOf(r3, fv.class) == false) goto L25;
        int r2 = r4.hashCode();
        if (r2 == (-1493819250)) goto L20;
        if (r2 == 109854) goto L16;
        if (r2 == 552573414) goto L12;
    L21:
        return null;
    L12:
        if (r4.equals("caption") == false) goto L21;
        return ((fv) ZeusTransformUtils.preCheckCast(r3, fv.class, "com.obric.memorydata.plugin")).d();
    L16:
        if (r4.equals("ocr") == false) goto L21;
        return ((fv) ZeusTransformUtils.preCheckCast(r3, fv.class, "com.obric.memorydata.plugin")).e();
    L20:
        if (r4.equals("photoEntityDbId") == false) goto L21;
        return Long.valueOf(((fv) ZeusTransformUtils.preCheckCast(r3, fv.class, "com.obric.memorydata.plugin")).f());
    L25:
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
