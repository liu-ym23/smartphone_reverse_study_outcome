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
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005H\u0016J\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u00172\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u0017H\u0016J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u0017H\u0016J\u0014\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000eH\u0016J\u0014\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000eH\u0016J&\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00102\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0#H\u0016J\u001e\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010'\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010(\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\fH\u0016J\u001a\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\fH\u0016J\b\u0010,\u001a\u00020\u0014H\u0016R#\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/obric/memorydata/database/entity/RawCommonPhotoIndex_Impl;", "Lcom/obric/memorydata/database/entity/RawCommonPhotoIndex;", "<init>", "()V", "entityIndexHelper", "Lcom/obric/memorydata/database/index/EntityIndexHelper;", "Lcom/obric/memorydata/database/entity/RawCommonPhotoEntity;", "Lcom/obric/memorydata/database/entity/CommonPhotoEntityTextVectorCopilotEntity;", "Lcom/obric/memorydata/database/entity/AbstractContentTimeEntity;", "getEntityIndexHelper", "()Lcom/obric/memorydata/database/index/EntityIndexHelper;", "TAG", "", "buildKeywordIndexMap", "", "entity", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "getKeywordSchema", "Lcom/obric/search/api/schema/impl/FullTextSearchSchema;", "hasKeywordSchema", "", "getEntityIndexHelperInstance", "getNeedUpdateColumns", "", "oldRawEntity", "newRawEntity", "getAllColumns", "getPendingTaskColumns", "getKeywordColumnMap", "getContentTimeColumns", "assignmentAssociateField", "", "oldEntity", "newEntity", "changeColumns", "", "generateIndexPendingTask", "", "Lcom/obric/memorydata/database/entity/IndexPendingEntity;", "columnName", "executeIndexPendingTask", "updateField", "getValueByColumn", "", "isBuildMetaInfoFullContent", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class RawCommonPhotoIndex_Impl implements fu {
    private final String TAG;
    private final com.obric.memorydata.database.index.t<ft, an, b> entityIndexHelper;

    public RawCommonPhotoIndex_Impl() {
        com.obric.memorydata.database.index.t<ft, an, b> r0 = new com.obric.memorydata.database.index.t();
        this.entityIndexHelper = r0;
        this.TAG = "RawCommonPhotoIndex_Impl";
        IAppEntityRawDbDao<? extends d> r1 = getRawDao();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.memorydata.database.dao.IAppEntityRawDbDao<com.obric.memorydata.database.entity.RawCommonPhotoEntity>");
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

    private static final Unit executeIndexPendingTask$lambda$3(RawCommonPhotoIndex_Impl r4, d r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "it");
        IAppEntityRawDbDao<? extends d> r0 = r4.getRawDao();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.obric.memorydata.database.dao.IAppEntityRawDbDao<com.obric.memorydata.database.entity.RawCommonPhotoEntity>");
        List<T> r7 = r0.queryByEntityId(((ft) ZeusTransformUtils.preCheckCast(r5, ft.class, "com.obric.memorydata.plugin")).getEntityId(), ((ft) ZeusTransformUtils.preCheckCast(r5, ft.class, "com.obric.memorydata.plugin")).getPackageName());
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L6;
        ft r8 = (ft) ZeusTransformUtils.preCheckCast(r7.get(0), ft.class, "com.obric.memorydata.plugin");
        r8.a(r4.entityIndexHelper.a(r8.c(), r6));
        r0.update(r8);
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit executeIndexPendingTask$lambda$4(RawCommonPhotoIndex_Impl r6, d r7, String r8) {
        Intrinsics.checkNotNullParameter(r8, "it");
        IAppEntityRawDbDao<? extends d> r0 = r6.getRawDao();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.obric.memorydata.database.dao.IAppEntityRawDbDao<com.obric.memorydata.database.entity.RawCommonPhotoEntity>");
        List<T> r9 = r0.queryByEntityId(((ft) ZeusTransformUtils.preCheckCast(r7, ft.class, "com.obric.memorydata.plugin")).getEntityId(), ((ft) ZeusTransformUtils.preCheckCast(r7, ft.class, "com.obric.memorydata.plugin")).getPackageName());
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L6;
        ft r10 = (ft) ZeusTransformUtils.preCheckCast(r9.get(0), ft.class, "com.obric.memorydata.plugin");
        r6.entityIndexHelper.a(r10.getId(), r6.buildKeywordIndexMap((d) ZeusTransformUtils.preCheckCast(r10, d.class, "com.obric.memorydata.plugin")));
        r10.b(r6.entityIndexHelper.a(r10.d(), r8));
        r0.update(r10);
        r6.entityIndexHelper.b(r10.getId(), r6.buildKeywordIndexMap((d) ZeusTransformUtils.preCheckCast(r10, d.class, "com.obric.memorydata.plugin")));
    L6:
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit lambda$N_N6GEhgG_ThHZmpx8WTSmjTP_M(RawCommonPhotoIndex_Impl r0, d r1, String r2) {
        return executeIndexPendingTask$lambda$4(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$Xt15Nr1lUZYcCOZLZMGHCUfQZtw(RawCommonPhotoIndex_Impl r0, d r1, String r2) {
        return executeIndexPendingTask$lambda$3(r0, r1, r2);
    }

    @Override // com.obric.memorydata.database.index.e
    public void assignmentAssociateField(d r3, d r4, Set<String> r5) {
        Set r2 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "oldEntity");
        Intrinsics.checkNotNullParameter(r4, "newEntity");
        Intrinsics.checkNotNullParameter(r2, "changeColumns");
        if (ZeusTransformUtils.instanceOf(r3, ft.class) == false) goto L16;
        if (ZeusTransformUtils.instanceOf(r4, ft.class) == false) goto L14;
        if (r2.contains("caption") == true) goto L10;
        ((ft) ZeusTransformUtils.preCheckCast(r4, ft.class, "com.obric.memorydata.plugin")).a(((ft) ZeusTransformUtils.preCheckCast(r3, ft.class, "com.obric.memorydata.plugin")).c());
    L10:
        if (r2.contains("ocr") == true) goto L17;
        ((ft) ZeusTransformUtils.preCheckCast(r4, ft.class, "com.obric.memorydata.plugin")).b(((ft) ZeusTransformUtils.preCheckCast(r3, ft.class, "com.obric.memorydata.plugin")).d());
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
        if (ZeusTransformUtils.instanceOf(r3, ft.class) == false) goto L9;
        Map<String, String> r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        String r4 = ((ft) ZeusTransformUtils.preCheckCast(r3, ft.class, "com.obric.memorydata.plugin")).d();
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
        if (ZeusTransformUtils.instanceOf(r25, ft.class) == false) goto L38;
        long r9 = System.currentTimeMillis();
        EntityIndexRecordInfo r11 = com.obric.memorydata.database.util.b.f9624a.a(r25);
        if (Intrinsics.areEqual(r26, "insert_keyword_task") == false) goto L7;
        boolean r14 = this.entityIndexHelper.b(((ft) ZeusTransformUtils.preCheckCast(r25, ft.class, "com.obric.memorydata.plugin")).getId(), buildKeywordIndexMap(r25));
    L9:
        if (Intrinsics.areEqual(r26, "file") == false) goto L11;
        boolean r16 = this.entityIndexHelper.b(r25, "file", ((ft) ZeusTransformUtils.preCheckCast(r25, ft.class, "com.obric.memorydata.plugin")).a(), false);
    L13:
        if (Intrinsics.areEqual(r26, "caption") == false) goto L19;
        Function1<? super String, Unit> r6 = new $$Lambda$RawCommonPhotoIndex_Impl$Xt15Nr1lUZYcCOZLZMGHCUfQZtw(this, r25);
        com.obric.memorydata.database.index.t<ft, an, b> r1 = this.entityIndexHelper;
        String r2 = ((ft) ZeusTransformUtils.preCheckCast(r25, ft.class, "com.obric.memorydata.plugin")).a();
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L17;
        String r4 = r2;
    L18:
        boolean r7 = r1.b(r25, "caption", r4, "", r6);
    L21:
        if (Intrinsics.areEqual(r26, "ocr") == false) goto L27;
        Function1<? super String, Unit> r5 = new $$Lambda$RawCommonPhotoIndex_Impl$N_N6GEhgG_ThHZmpx8WTSmjTP_M(this, r25);
        com.obric.memorydata.database.index.t<ft, an, b> r0 = this.entityIndexHelper;
        String r3 = ((ft) ZeusTransformUtils.preCheckCast(r25, ft.class, "com.obric.memorydata.plugin")).a();
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L25;
        String r8 = r3;
    L26:
        boolean r17 = r0.a(r25, "ocr", r8, "common1", r5);
    L28:
        if (r11 == null) goto L30;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", com.obric.memorydata.utils.u.a(r11), false, 4, null);
        com.obric.memorydata.database.util.b.f9624a.a("entityIndexTaskCost", String.valueOf(((ft) ZeusTransformUtils.preCheckCast(r25, ft.class, "com.obric.memorydata.plugin")).getType()), r26, System.currentTimeMillis() - r9);
    L30:
        if (r16 == false) goto L36;
        if (r7 == false) goto L36;
        if (r17 == false) goto L36;
        if (r14 == false) goto L36;
        return true;
    L36:
        return false;
    L25:
        r8 = null;
        goto L26
    L27:
        r17 = true;
        goto L28
    L17:
        r4 = null;
        goto L18
    L19:
        r7 = true;
        goto L21
    L11:
        r16 = true;
        goto L13
    L7:
        r14 = true;
        goto L9
    L38:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public List<cd> generateIndexPendingTask(String r34, d r35) {
        Intrinsics.checkNotNullParameter(r34, "columnName");
        Intrinsics.checkNotNullParameter(r35, "entity");
        if (ZeusTransformUtils.instanceOf(r35, ft.class) == false) goto L48;
        switch(r34.hashCode()) {
            case -1937787423: goto L41;
            case 109854: goto L30;
            case 3143036: goto L21;
            case 552573414: goto L8;
            default: goto L46;
        };
    L8:
        if (r34.equals("caption") == false) goto L46;
        if (((ft) ZeusTransformUtils.preCheckCast(r35, ft.class, "com.obric.memorydata.plugin")).a() == null) goto L46;
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L19;
        if (DeviceInfoState.INSTANCE.isSupportVLM() == false) goto L19;
        return CollectionsKt.listOf(new cd(0, ((ft) ZeusTransformUtils.preCheckCast(r35, ft.class, "com.obric.memorydata.plugin")).getId(), ((ft) ZeusTransformUtils.preCheckCast(r35, ft.class, "com.obric.memorydata.plugin")).getType(), ((ft) ZeusTransformUtils.preCheckCast(r35, ft.class, "com.obric.memorydata.plugin")).getTimestamp(), ((ft) ZeusTransformUtils.preCheckCast(r35, ft.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, r34, "caption", 0, 0, null, false, 0, 0, 32353, null));
    L19:
        return CollectionsKt.emptyList();
    L21:
        if (r34.equals("file") == false) goto L46;
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L28;
        return this.entityIndexHelper.a(r35, r34, ((ft) ZeusTransformUtils.preCheckCast(r35, ft.class, "com.obric.memorydata.plugin")).a().toString(), false);
    L28:
        return CollectionsKt.emptyList();
    L30:
        if (r34.equals("ocr") == false) goto L46;
        if (((ft) ZeusTransformUtils.preCheckCast(r35, ft.class, "com.obric.memorydata.plugin")).a() == null) goto L46;
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L39;
        return CollectionsKt.listOf(new cd(0, ((ft) ZeusTransformUtils.preCheckCast(r35, ft.class, "com.obric.memorydata.plugin")).getId(), ((ft) ZeusTransformUtils.preCheckCast(r35, ft.class, "com.obric.memorydata.plugin")).getType(), ((ft) ZeusTransformUtils.preCheckCast(r35, ft.class, "com.obric.memorydata.plugin")).getTimestamp(), ((ft) ZeusTransformUtils.preCheckCast(r35, ft.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, r34, "ocr", 0, 0, null, false, 0, 0, 32353, null));
    L39:
        return CollectionsKt.emptyList();
    L41:
        if (r34.equals("insert_keyword_task") == false) goto L46;
        return CollectionsKt.listOf(new cd(0, ((ft) ZeusTransformUtils.preCheckCast(r35, ft.class, "com.obric.memorydata.plugin")).getId(), ((ft) ZeusTransformUtils.preCheckCast(r35, ft.class, "com.obric.memorydata.plugin")).getType(), ((ft) ZeusTransformUtils.preCheckCast(r35, ft.class, "com.obric.memorydata.plugin")).getTimestamp(), ((ft) ZeusTransformUtils.preCheckCast(r35, ft.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, "insert_keyword_task", "keyword", 0, 0, null, false, 0, 0, 32353, null));
    L46:
        return CollectionsKt.emptyList();
    L48:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public Set<String> getAllColumns() {
        Set<String> r2 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        r2.add("file");
        r2.add("caption");
        r2.add("ocr");
        return r2;
    }

    @Override // com.obric.memorydata.database.index.e
    public Map<String, String> getContentTimeColumns() {
        return (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityContentTimeDao<? extends b> getContentTimeDao() {
        return fu.a.d(this);
    }

    public final com.obric.memorydata.database.index.t<ft, an, b> getEntityIndexHelper() {
        return this.entityIndexHelper;
    }

    @Override // com.obric.memorydata.database.index.e
    public com.obric.memorydata.database.index.t<ft, an, b> getEntityIndexHelperInstance() {
        return this.entityIndexHelper;
    }

    @Override // com.obric.memorydata.database.index.e
    public IHistoryEntityDao<? extends c> getHistoryEntityDao() {
        return fu.a.e(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityVectorCopilotDao<? extends i> getImageCopilotDao() {
        return fu.a.c(this);
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
        if (ZeusTransformUtils.instanceOf(r9, ft.class) == false) goto L13;
        if (ZeusTransformUtils.instanceOf(r10, ft.class) == false) goto L11;
        Set<String> r8 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        if (gd.f9146a.a(((ft) ZeusTransformUtils.preCheckCast(r9, ft.class, "com.obric.memorydata.plugin")).a(), ((ft) ZeusTransformUtils.preCheckCast(r10, ft.class, "com.obric.memorydata.plugin")).a(), Type.FILE_ENTITY, null, false) == true) goto L9;
        r8.add("file");
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
        r2.add("file");
        r2.add("caption");
        r2.add("ocr");
        return r2;
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityRawDbDao<? extends d> getRawDao() {
        return fu.a.a(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityVectorCopilotDao<? extends i> getTextCopilotDao() {
        return fu.a.b(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public Object getValueByColumn(d r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "entity");
        Intrinsics.checkNotNullParameter(r4, "columnName");
        if (ZeusTransformUtils.instanceOf(r3, ft.class) == false) goto L25;
        int r2 = r4.hashCode();
        if (r2 == 109854) goto L20;
        if (r2 == 3143036) goto L16;
        if (r2 == 552573414) goto L12;
    L21:
        return null;
    L12:
        if (r4.equals("caption") == false) goto L21;
        return ((ft) ZeusTransformUtils.preCheckCast(r3, ft.class, "com.obric.memorydata.plugin")).c();
    L16:
        if (r4.equals("file") == false) goto L21;
        return ((ft) ZeusTransformUtils.preCheckCast(r3, ft.class, "com.obric.memorydata.plugin")).a();
    L20:
        if (r4.equals("ocr") == false) goto L21;
        return ((ft) ZeusTransformUtils.preCheckCast(r3, ft.class, "com.obric.memorydata.plugin")).d();
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
