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
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005H\u0016J\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u00172\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u0017H\u0016J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u0017H\u0016J\u0014\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000eH\u0016J\u0014\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000eH\u0016J&\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00102\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0#H\u0016J\u001e\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010'\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010(\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\fH\u0016J\u001a\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\fH\u0016J\b\u0010,\u001a\u00020\u0014H\u0016R#\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/obric/memorydata/database/entity/RawContactIndex_Impl;", "Lcom/obric/memorydata/database/entity/RawContactIndex;", "<init>", "()V", "entityIndexHelper", "Lcom/obric/memorydata/database/index/EntityIndexHelper;", "Lcom/obric/memorydata/database/entity/RawContactEntity;", "Lcom/obric/memorydata/database/entity/ContactEntityTextVectorCopilotEntity;", "Lcom/obric/memorydata/database/entity/AbstractContentTimeEntity;", "getEntityIndexHelper", "()Lcom/obric/memorydata/database/index/EntityIndexHelper;", "TAG", "", "buildKeywordIndexMap", "", "entity", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "getKeywordSchema", "Lcom/obric/search/api/schema/impl/FullTextSearchSchema;", "hasKeywordSchema", "", "getEntityIndexHelperInstance", "getNeedUpdateColumns", "", "oldRawEntity", "newRawEntity", "getAllColumns", "getPendingTaskColumns", "getKeywordColumnMap", "getContentTimeColumns", "assignmentAssociateField", "", "oldEntity", "newEntity", "changeColumns", "", "generateIndexPendingTask", "", "Lcom/obric/memorydata/database/entity/IndexPendingEntity;", "columnName", "executeIndexPendingTask", "updateField", "getValueByColumn", "", "isBuildMetaInfoFullContent", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class RawContactIndex_Impl implements fy {
    private final String TAG;
    private final com.obric.memorydata.database.index.t<fx, as, b> entityIndexHelper;

    public RawContactIndex_Impl() {
        com.obric.memorydata.database.index.t<fx, as, b> r0 = new com.obric.memorydata.database.index.t();
        this.entityIndexHelper = r0;
        this.TAG = "RawContactIndex_Impl";
        IAppEntityRawDbDao<? extends d> r1 = getRawDao();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.memorydata.database.dao.IAppEntityRawDbDao<com.obric.memorydata.database.entity.RawContactEntity>");
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

    private static final Unit executeIndexPendingTask$lambda$12$lambda$11(RawContactIndex_Impl r3, d r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        IAppEntityRawDbDao<? extends d> r6 = r3.getRawDao();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type com.obric.memorydata.database.dao.IAppEntityRawDbDao<com.obric.memorydata.database.entity.RawContactEntity>");
        List<T> r7 = r6.queryByEntityId(((fx) ZeusTransformUtils.preCheckCast(r4, fx.class, "com.obric.memorydata.plugin")).getEntityId(), ((fx) ZeusTransformUtils.preCheckCast(r4, fx.class, "com.obric.memorydata.plugin")).getPackageName());
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L6;
        fx r8 = (fx) ZeusTransformUtils.preCheckCast(r7.get(0), fx.class, "com.obric.memorydata.plugin");
        r8.a(r5);
        r6.update(r8);
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit executeIndexPendingTask$lambda$14$lambda$13(RawContactIndex_Impl r3, d r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        IAppEntityRawDbDao<? extends d> r6 = r3.getRawDao();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type com.obric.memorydata.database.dao.IAppEntityRawDbDao<com.obric.memorydata.database.entity.RawContactEntity>");
        List<T> r7 = r6.queryByEntityId(((fx) ZeusTransformUtils.preCheckCast(r4, fx.class, "com.obric.memorydata.plugin")).getEntityId(), ((fx) ZeusTransformUtils.preCheckCast(r4, fx.class, "com.obric.memorydata.plugin")).getPackageName());
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L6;
        fx r8 = (fx) ZeusTransformUtils.preCheckCast(r7.get(0), fx.class, "com.obric.memorydata.plugin");
        r8.b(r5);
        r6.update(r8);
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit executeIndexPendingTask$lambda$16$lambda$15(RawContactIndex_Impl r3, d r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        IAppEntityRawDbDao<? extends d> r6 = r3.getRawDao();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type com.obric.memorydata.database.dao.IAppEntityRawDbDao<com.obric.memorydata.database.entity.RawContactEntity>");
        List<T> r7 = r6.queryByEntityId(((fx) ZeusTransformUtils.preCheckCast(r4, fx.class, "com.obric.memorydata.plugin")).getEntityId(), ((fx) ZeusTransformUtils.preCheckCast(r4, fx.class, "com.obric.memorydata.plugin")).getPackageName());
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L6;
        fx r8 = (fx) ZeusTransformUtils.preCheckCast(r7.get(0), fx.class, "com.obric.memorydata.plugin");
        r8.c(r5);
        r6.update(r8);
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit executeIndexPendingTask$lambda$18$lambda$17(RawContactIndex_Impl r3, d r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        IAppEntityRawDbDao<? extends d> r6 = r3.getRawDao();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type com.obric.memorydata.database.dao.IAppEntityRawDbDao<com.obric.memorydata.database.entity.RawContactEntity>");
        List<T> r7 = r6.queryByEntityId(((fx) ZeusTransformUtils.preCheckCast(r4, fx.class, "com.obric.memorydata.plugin")).getEntityId(), ((fx) ZeusTransformUtils.preCheckCast(r4, fx.class, "com.obric.memorydata.plugin")).getPackageName());
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L6;
        fx r8 = (fx) ZeusTransformUtils.preCheckCast(r7.get(0), fx.class, "com.obric.memorydata.plugin");
        r8.d(r5);
        r6.update(r8);
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit executeIndexPendingTask$lambda$20$lambda$19(RawContactIndex_Impl r3, d r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        IAppEntityRawDbDao<? extends d> r6 = r3.getRawDao();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type com.obric.memorydata.database.dao.IAppEntityRawDbDao<com.obric.memorydata.database.entity.RawContactEntity>");
        List<T> r7 = r6.queryByEntityId(((fx) ZeusTransformUtils.preCheckCast(r4, fx.class, "com.obric.memorydata.plugin")).getEntityId(), ((fx) ZeusTransformUtils.preCheckCast(r4, fx.class, "com.obric.memorydata.plugin")).getPackageName());
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L6;
        fx r8 = (fx) ZeusTransformUtils.preCheckCast(r7.get(0), fx.class, "com.obric.memorydata.plugin");
        r8.e(r5);
        r6.update(r8);
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit executeIndexPendingTask$lambda$22$lambda$21(RawContactIndex_Impl r3, d r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        IAppEntityRawDbDao<? extends d> r6 = r3.getRawDao();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type com.obric.memorydata.database.dao.IAppEntityRawDbDao<com.obric.memorydata.database.entity.RawContactEntity>");
        List<T> r7 = r6.queryByEntityId(((fx) ZeusTransformUtils.preCheckCast(r4, fx.class, "com.obric.memorydata.plugin")).getEntityId(), ((fx) ZeusTransformUtils.preCheckCast(r4, fx.class, "com.obric.memorydata.plugin")).getPackageName());
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L6;
        fx r8 = (fx) ZeusTransformUtils.preCheckCast(r7.get(0), fx.class, "com.obric.memorydata.plugin");
        r8.f(r5);
        r6.update(r8);
    L6:
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$5Bxf_ynFQ4OzcRtIo01lqE-KLUU, reason: not valid java name */
    public static /* synthetic */ Unit m546lambda$5Bxf_ynFQ4OzcRtIo01lqEKLUU(RawContactIndex_Impl r0, d r1, String r2) {
        return executeIndexPendingTask$lambda$22$lambda$21(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$ERX7ziGA0nRY-4JNXGhCZ7rP6hQ, reason: not valid java name */
    public static /* synthetic */ Unit m547lambda$ERX7ziGA0nRY4JNXGhCZ7rP6hQ(RawContactIndex_Impl r0, d r1, String r2) {
        return executeIndexPendingTask$lambda$12$lambda$11(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$KgzX04ZcBasPmG6V-wkfPTmVveA, reason: not valid java name */
    public static /* synthetic */ Unit m548lambda$KgzX04ZcBasPmG6VwkfPTmVveA(RawContactIndex_Impl r0, d r1, String r2) {
        return executeIndexPendingTask$lambda$16$lambda$15(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$XL3a2nGPlaOfacsPZsfMrdRFZBo(RawContactIndex_Impl r0, d r1, String r2) {
        return executeIndexPendingTask$lambda$20$lambda$19(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$YvKDX9aQDkMCuZo4nGCLXj7-i1c, reason: not valid java name */
    public static /* synthetic */ Unit m549lambda$YvKDX9aQDkMCuZo4nGCLXj7i1c(RawContactIndex_Impl r0, d r1, String r2) {
        return executeIndexPendingTask$lambda$18$lambda$17(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$dUr8hKEF7wQ9XlsydWbrbWfVtuQ(RawContactIndex_Impl r0, d r1, String r2) {
        return executeIndexPendingTask$lambda$14$lambda$13(r0, r1, r2);
    }

    @Override // com.obric.memorydata.database.index.e
    public void assignmentAssociateField(d r3, d r4, Set<String> r5) {
        Set r2 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "oldEntity");
        Intrinsics.checkNotNullParameter(r4, "newEntity");
        Intrinsics.checkNotNullParameter(r2, "changeColumns");
        if (ZeusTransformUtils.instanceOf(r3, fx.class) == false) goto L28;
        if (ZeusTransformUtils.instanceOf(r4, fx.class) == false) goto L26;
        if (r2.contains("telephonesValues") == true) goto L10;
        ((fx) ZeusTransformUtils.preCheckCast(r4, fx.class, "com.obric.memorydata.plugin")).a(((fx) ZeusTransformUtils.preCheckCast(r3, fx.class, "com.obric.memorydata.plugin")).c());
    L10:
        if (r2.contains("credentialValues") == true) goto L13;
        ((fx) ZeusTransformUtils.preCheckCast(r4, fx.class, "com.obric.memorydata.plugin")).b(((fx) ZeusTransformUtils.preCheckCast(r3, fx.class, "com.obric.memorydata.plugin")).h());
    L13:
        if (r2.contains("emailsValues") == true) goto L16;
        ((fx) ZeusTransformUtils.preCheckCast(r4, fx.class, "com.obric.memorydata.plugin")).c(((fx) ZeusTransformUtils.preCheckCast(r3, fx.class, "com.obric.memorydata.plugin")).j());
    L16:
        if (r2.contains("addressesValues") == true) goto L19;
        ((fx) ZeusTransformUtils.preCheckCast(r4, fx.class, "com.obric.memorydata.plugin")).d(((fx) ZeusTransformUtils.preCheckCast(r3, fx.class, "com.obric.memorydata.plugin")).l());
    L19:
        if (r2.contains("anniversariesValues") == true) goto L22;
        ((fx) ZeusTransformUtils.preCheckCast(r4, fx.class, "com.obric.memorydata.plugin")).e(((fx) ZeusTransformUtils.preCheckCast(r3, fx.class, "com.obric.memorydata.plugin")).p());
    L22:
        if (r2.contains("relationShipsValues") == true) goto L29;
        ((fx) ZeusTransformUtils.preCheckCast(r4, fx.class, "com.obric.memorydata.plugin")).f(((fx) ZeusTransformUtils.preCheckCast(r3, fx.class, "com.obric.memorydata.plugin")).s());
        return;
    L29:
        return;
    L26:
        throw new IllegalStateException("Check failed.".toString());
    L28:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public Map<String, String> buildKeywordIndexMap(d r4) {
        Intrinsics.checkNotNullParameter(r4, "entity");
        if (ZeusTransformUtils.instanceOf(r4, fx.class) == false) goto L21;
        Map<String, String> r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        r3.put("common1", ((fx) ZeusTransformUtils.preCheckCast(r4, fx.class, "com.obric.memorydata.plugin")).a());
        String r0 = ((fx) ZeusTransformUtils.preCheckCast(r4, fx.class, "com.obric.memorydata.plugin")).e();
        if (r0 == null) goto L7;
        r3.put("common2", r0);
    L7:
        String r1 = ((fx) ZeusTransformUtils.preCheckCast(r4, fx.class, "com.obric.memorydata.plugin")).m();
        if (r1 == null) goto L10;
        r3.put("common3", r1);
    L10:
        String r2 = ((fx) ZeusTransformUtils.preCheckCast(r4, fx.class, "com.obric.memorydata.plugin")).u();
        if (r2 == null) goto L13;
        r3.put("common4", r2);
    L13:
        String r5 = ((fx) ZeusTransformUtils.preCheckCast(r4, fx.class, "com.obric.memorydata.plugin")).v();
        if (r5 == null) goto L16;
        r3.put("common5", r5);
    L16:
        String r6 = ((fx) ZeusTransformUtils.preCheckCast(r4, fx.class, "com.obric.memorydata.plugin")).w();
        if (r6 == null) goto L19;
        r3.put("common6", r6);
    L19:
        return r3;
    L21:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public boolean executeIndexPendingTask(final d r25, String r26) {
        Intrinsics.checkNotNullParameter(r25, "entity");
        Intrinsics.checkNotNullParameter(r26, "updateField");
        if (ZeusTransformUtils.instanceOf(r25, fx.class) == false) goto L67;
        long r4 = System.currentTimeMillis();
        EntityIndexRecordInfo r2 = com.obric.memorydata.database.util.b.f9624a.a(r25);
        if (Intrinsics.areEqual(r26, "insert_keyword_task") == false) goto L7;
        boolean r6 = this.entityIndexHelper.b(((fx) ZeusTransformUtils.preCheckCast(r25, fx.class, "com.obric.memorydata.plugin")).getId(), buildKeywordIndexMap(r25));
    L9:
        if (Intrinsics.areEqual(r26, "meta_full_content") == false) goto L11;
        boolean r9 = com.obric.memorydata.database.index.t.f9438a.a(r25);
    L13:
        if (Intrinsics.areEqual(r26, "telephonesValues") == true) goto L15;
    L17:
        boolean r10 = true;
    L19:
        if (Intrinsics.areEqual(r26, "credentialValues") == true) goto L21;
    L23:
        boolean r11 = true;
    L25:
        if (Intrinsics.areEqual(r26, "emailsValues") == true) goto L27;
    L29:
        boolean r12 = true;
    L31:
        if (Intrinsics.areEqual(r26, "addressesValues") == true) goto L33;
    L35:
        boolean r8 = true;
    L37:
        if (Intrinsics.areEqual(r26, "anniversariesValues") == true) goto L39;
    L41:
        boolean r13 = true;
    L43:
        if (Intrinsics.areEqual(r26, "relationShipsValues") == true) goto L45;
    L47:
        boolean r7 = true;
    L49:
        if (Intrinsics.areEqual(r26, "fullContent") == false) goto L51;
        boolean r14 = this.entityIndexHelper.c(r25, "fullContent", ((fx) ZeusTransformUtils.preCheckCast(r25, fx.class, "com.obric.memorydata.plugin")).t(), "DEFAULT");
    L52:
        if (r2 == null) goto L54;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EntityIndexHelper", com.obric.memorydata.utils.u.a(r2), false, 4, null);
        com.obric.memorydata.database.util.b.f9624a.a("entityIndexTaskCost", String.valueOf(((fx) ZeusTransformUtils.preCheckCast(r25, fx.class, "com.obric.memorydata.plugin")).getType()), r26, System.currentTimeMillis() - r4);
    L54:
        if (r14 == false) goto L64;
        if (r8 == false) goto L64;
        if (r13 == false) goto L64;
        if (r7 == false) goto L64;
        if (r11 == false) goto L64;
        if (r10 == false) goto L64;
        if (r12 == false) goto L64;
        if (r6 == false) goto L64;
        if (r9 == false) goto L64;
        return true;
    L64:
        return false;
    L51:
        r14 = true;
        goto L52
    L45:
        if (((fx) ZeusTransformUtils.preCheckCast(r25, fx.class, "com.obric.memorydata.plugin")).r() == null) goto L47;
        r7 = com.obric.memorydata.database.index.t.f9438a.a(((fx) ZeusTransformUtils.preCheckCast(r25, fx.class, "com.obric.memorydata.plugin")).r(), "relationType,relationship", new $$Lambda$RawContactIndex_Impl$5Bxf_ynFQ4OzcRtIo01lqEKLUU(this, r25));
        goto L49
    L39:
        if (((fx) ZeusTransformUtils.preCheckCast(r25, fx.class, "com.obric.memorydata.plugin")).o() == null) goto L41;
        r13 = com.obric.memorydata.database.index.t.f9438a.a(((fx) ZeusTransformUtils.preCheckCast(r25, fx.class, "com.obric.memorydata.plugin")).o(), "anniversaryDate,anniversaryName", new $$Lambda$RawContactIndex_Impl$XL3a2nGPlaOfacsPZsfMrdRFZBo(this, r25));
        goto L43
    L33:
        if (((fx) ZeusTransformUtils.preCheckCast(r25, fx.class, "com.obric.memorydata.plugin")).k() == null) goto L35;
        r8 = com.obric.memorydata.database.index.t.f9438a.a(((fx) ZeusTransformUtils.preCheckCast(r25, fx.class, "com.obric.memorydata.plugin")).k(), "address,addressType", new $$Lambda$RawContactIndex_Impl$YvKDX9aQDkMCuZo4nGCLXj7i1c(this, r25));
        goto L37
    L27:
        if (((fx) ZeusTransformUtils.preCheckCast(r25, fx.class, "com.obric.memorydata.plugin")).i() == null) goto L29;
        r12 = com.obric.memorydata.database.index.t.f9438a.a(((fx) ZeusTransformUtils.preCheckCast(r25, fx.class, "com.obric.memorydata.plugin")).i(), "emailAddress,emailAddressType", new $$Lambda$RawContactIndex_Impl$KgzX04ZcBasPmG6VwkfPTmVveA(this, r25));
        goto L31
    L21:
        if (((fx) ZeusTransformUtils.preCheckCast(r25, fx.class, "com.obric.memorydata.plugin")).g() == null) goto L23;
        r11 = com.obric.memorydata.database.index.t.f9438a.a(((fx) ZeusTransformUtils.preCheckCast(r25, fx.class, "com.obric.memorydata.plugin")).g(), "credentialNumber,credentialType", new $$Lambda$RawContactIndex_Impl$dUr8hKEF7wQ9XlsydWbrbWfVtuQ(this, r25));
        goto L25
    L15:
        if (((fx) ZeusTransformUtils.preCheckCast(r25, fx.class, "com.obric.memorydata.plugin")).b() == null) goto L17;
        r10 = com.obric.memorydata.database.index.t.f9438a.a(((fx) ZeusTransformUtils.preCheckCast(r25, fx.class, "com.obric.memorydata.plugin")).b(), "contactType,telephone", new $$Lambda$RawContactIndex_Impl$ERX7ziGA0nRY4JNXGhCZ7rP6hQ(this, r25));
        goto L19
    L11:
        r9 = true;
        goto L13
    L7:
        r6 = true;
        goto L9
    L67:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public List<cd> generateIndexPendingTask(String r34, d r35) {
        Intrinsics.checkNotNullParameter(r34, "columnName");
        Intrinsics.checkNotNullParameter(r35, "entity");
        if (ZeusTransformUtils.instanceOf(r35, fx.class) == false) goto L71;
        switch(r34.hashCode()) {
            case -1937787423: goto L64;
            case -1536949565: goto L59;
            case -634557923: goto L52;
            case -530929935: goto L45;
            case -193103126: goto L36;
            case -49163175: goto L29;
            case 534039280: goto L22;
            case 1284784996: goto L15;
            case 1363055705: goto L8;
            default: goto L69;
        };
    L8:
        if (r34.equals("credentialValues") == false) goto L69;
        if (((fx) ZeusTransformUtils.preCheckCast(r35, fx.class, "com.obric.memorydata.plugin")).h() == null) goto L69;
        return CollectionsKt.listOf(new cd(0, ((fx) ZeusTransformUtils.preCheckCast(r35, fx.class, "com.obric.memorydata.plugin")).getId(), ((fx) ZeusTransformUtils.preCheckCast(r35, fx.class, "com.obric.memorydata.plugin")).getType(), ((fx) ZeusTransformUtils.preCheckCast(r35, fx.class, "com.obric.memorydata.plugin")).getTimestamp(), ((fx) ZeusTransformUtils.preCheckCast(r35, fx.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, r34, "extract", 0, 0, null, false, 0, 0, 32353, null));
    L15:
        if (r34.equals("addressesValues") == false) goto L69;
        if (((fx) ZeusTransformUtils.preCheckCast(r35, fx.class, "com.obric.memorydata.plugin")).l() == null) goto L69;
        return CollectionsKt.listOf(new cd(0, ((fx) ZeusTransformUtils.preCheckCast(r35, fx.class, "com.obric.memorydata.plugin")).getId(), ((fx) ZeusTransformUtils.preCheckCast(r35, fx.class, "com.obric.memorydata.plugin")).getType(), ((fx) ZeusTransformUtils.preCheckCast(r35, fx.class, "com.obric.memorydata.plugin")).getTimestamp(), ((fx) ZeusTransformUtils.preCheckCast(r35, fx.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, r34, "extract", 0, 0, null, false, 0, 0, 32353, null));
    L22:
        if (r34.equals("anniversariesValues") == false) goto L69;
        if (((fx) ZeusTransformUtils.preCheckCast(r35, fx.class, "com.obric.memorydata.plugin")).p() == null) goto L69;
        return CollectionsKt.listOf(new cd(0, ((fx) ZeusTransformUtils.preCheckCast(r35, fx.class, "com.obric.memorydata.plugin")).getId(), ((fx) ZeusTransformUtils.preCheckCast(r35, fx.class, "com.obric.memorydata.plugin")).getType(), ((fx) ZeusTransformUtils.preCheckCast(r35, fx.class, "com.obric.memorydata.plugin")).getTimestamp(), ((fx) ZeusTransformUtils.preCheckCast(r35, fx.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, r34, "extract", 0, 0, null, false, 0, 0, 32353, null));
    L29:
        if (r34.equals("emailsValues") == false) goto L69;
        if (((fx) ZeusTransformUtils.preCheckCast(r35, fx.class, "com.obric.memorydata.plugin")).j() == null) goto L69;
        return CollectionsKt.listOf(new cd(0, ((fx) ZeusTransformUtils.preCheckCast(r35, fx.class, "com.obric.memorydata.plugin")).getId(), ((fx) ZeusTransformUtils.preCheckCast(r35, fx.class, "com.obric.memorydata.plugin")).getType(), ((fx) ZeusTransformUtils.preCheckCast(r35, fx.class, "com.obric.memorydata.plugin")).getTimestamp(), ((fx) ZeusTransformUtils.preCheckCast(r35, fx.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, r34, "extract", 0, 0, null, false, 0, 0, 32353, null));
    L36:
        if (r34.equals("fullContent") == false) goto L69;
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L43;
        return CollectionsKt.listOf(new cd(0, ((fx) ZeusTransformUtils.preCheckCast(r35, fx.class, "com.obric.memorydata.plugin")).getId(), ((fx) ZeusTransformUtils.preCheckCast(r35, fx.class, "com.obric.memorydata.plugin")).getType(), ((fx) ZeusTransformUtils.preCheckCast(r35, fx.class, "com.obric.memorydata.plugin")).getTimestamp(), ((fx) ZeusTransformUtils.preCheckCast(r35, fx.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, r34, "full_content", 0, 0, null, false, 0, 0, 32353, null));
    L43:
        return CollectionsKt.emptyList();
    L45:
        if (r34.equals("telephonesValues") == false) goto L69;
        if (((fx) ZeusTransformUtils.preCheckCast(r35, fx.class, "com.obric.memorydata.plugin")).c() == null) goto L69;
        return CollectionsKt.listOf(new cd(0, ((fx) ZeusTransformUtils.preCheckCast(r35, fx.class, "com.obric.memorydata.plugin")).getId(), ((fx) ZeusTransformUtils.preCheckCast(r35, fx.class, "com.obric.memorydata.plugin")).getType(), ((fx) ZeusTransformUtils.preCheckCast(r35, fx.class, "com.obric.memorydata.plugin")).getTimestamp(), ((fx) ZeusTransformUtils.preCheckCast(r35, fx.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, r34, "extract", 0, 0, null, false, 0, 0, 32353, null));
    L52:
        if (r34.equals("relationShipsValues") == false) goto L69;
        if (((fx) ZeusTransformUtils.preCheckCast(r35, fx.class, "com.obric.memorydata.plugin")).s() == null) goto L69;
        return CollectionsKt.listOf(new cd(0, ((fx) ZeusTransformUtils.preCheckCast(r35, fx.class, "com.obric.memorydata.plugin")).getId(), ((fx) ZeusTransformUtils.preCheckCast(r35, fx.class, "com.obric.memorydata.plugin")).getType(), ((fx) ZeusTransformUtils.preCheckCast(r35, fx.class, "com.obric.memorydata.plugin")).getTimestamp(), ((fx) ZeusTransformUtils.preCheckCast(r35, fx.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, r34, "extract", 0, 0, null, false, 0, 0, 32353, null));
    L59:
        if (r34.equals("meta_full_content") == false) goto L69;
        return CollectionsKt.listOf(new cd(0, ((fx) ZeusTransformUtils.preCheckCast(r35, fx.class, "com.obric.memorydata.plugin")).getId(), ((fx) ZeusTransformUtils.preCheckCast(r35, fx.class, "com.obric.memorydata.plugin")).getType(), ((fx) ZeusTransformUtils.preCheckCast(r35, fx.class, "com.obric.memorydata.plugin")).getTimestamp(), ((fx) ZeusTransformUtils.preCheckCast(r35, fx.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, "meta_full_content", "meta_full_content", 0, 0, null, false, 0, 0, 32353, null));
    L64:
        if (r34.equals("insert_keyword_task") == false) goto L69;
        return CollectionsKt.listOf(new cd(0, ((fx) ZeusTransformUtils.preCheckCast(r35, fx.class, "com.obric.memorydata.plugin")).getId(), ((fx) ZeusTransformUtils.preCheckCast(r35, fx.class, "com.obric.memorydata.plugin")).getType(), ((fx) ZeusTransformUtils.preCheckCast(r35, fx.class, "com.obric.memorydata.plugin")).getTimestamp(), ((fx) ZeusTransformUtils.preCheckCast(r35, fx.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, "insert_keyword_task", "keyword", 0, 0, null, false, 0, 0, 32353, null));
    L69:
        return CollectionsKt.emptyList();
    L71:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public Set<String> getAllColumns() {
        Set<String> r2 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        r2.add(ActivityLifecycle.NAME);
        r2.add("telephonesValues");
        r2.add("note");
        r2.add("credentialValues");
        r2.add("emailsValues");
        r2.add("addressesValues");
        r2.add("company");
        r2.add("anniversariesValues");
        r2.add("relationShipsValues");
        r2.add("fullContent");
        r2.add("department");
        r2.add("jobTitle");
        r2.add("subNote");
        r2.add("meta_full_content");
        return r2;
    }

    @Override // com.obric.memorydata.database.index.e
    public Map<String, String> getContentTimeColumns() {
        return (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityContentTimeDao<? extends b> getContentTimeDao() {
        return fy.a.d(this);
    }

    public final com.obric.memorydata.database.index.t<fx, as, b> getEntityIndexHelper() {
        return this.entityIndexHelper;
    }

    @Override // com.obric.memorydata.database.index.e
    public com.obric.memorydata.database.index.t<fx, as, b> getEntityIndexHelperInstance() {
        return this.entityIndexHelper;
    }

    @Override // com.obric.memorydata.database.index.e
    public IHistoryEntityDao<? extends c> getHistoryEntityDao() {
        return fy.a.e(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityVectorCopilotDao<? extends i> getImageCopilotDao() {
        return fy.a.c(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public Map<String, String> getKeywordColumnMap() {
        Map<String, String> r2 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        r2.put(ActivityLifecycle.NAME, "common1");
        r2.put("note", "common2");
        r2.put("company", "common3");
        r2.put("department", "common4");
        r2.put("jobTitle", "common5");
        r2.put("subNote", "common6");
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
        if (ZeusTransformUtils.instanceOf(r9, fx.class) == false) goto L50;
        if (ZeusTransformUtils.instanceOf(r10, fx.class) == false) goto L48;
        Set<String> r8 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        if (gd.f9146a.a(((fx) ZeusTransformUtils.preCheckCast(r9, fx.class, "com.obric.memorydata.plugin")).a(), ((fx) ZeusTransformUtils.preCheckCast(r10, fx.class, "com.obric.memorydata.plugin")).a(), null, null, false) == true) goto L10;
        r8.add(ActivityLifecycle.NAME);
    L10:
        if (gd.f9146a.a(((fx) ZeusTransformUtils.preCheckCast(r9, fx.class, "com.obric.memorydata.plugin")).b(), ((fx) ZeusTransformUtils.preCheckCast(r10, fx.class, "com.obric.memorydata.plugin")).b(), Type.EXTRACT, "contactType,telephone", false) == true) goto L13;
        r8.add("telephonesValues");
    L13:
        if (gd.f9146a.a(((fx) ZeusTransformUtils.preCheckCast(r9, fx.class, "com.obric.memorydata.plugin")).e(), ((fx) ZeusTransformUtils.preCheckCast(r10, fx.class, "com.obric.memorydata.plugin")).e(), null, null, false) == true) goto L16;
        r8.add("note");
    L16:
        if (gd.f9146a.a(((fx) ZeusTransformUtils.preCheckCast(r9, fx.class, "com.obric.memorydata.plugin")).g(), ((fx) ZeusTransformUtils.preCheckCast(r10, fx.class, "com.obric.memorydata.plugin")).g(), Type.EXTRACT, "credentialNumber,credentialType", false) == true) goto L19;
        r8.add("credentialValues");
    L19:
        if (gd.f9146a.a(((fx) ZeusTransformUtils.preCheckCast(r9, fx.class, "com.obric.memorydata.plugin")).i(), ((fx) ZeusTransformUtils.preCheckCast(r10, fx.class, "com.obric.memorydata.plugin")).i(), Type.EXTRACT, "emailAddress,emailAddressType", false) == true) goto L22;
        r8.add("emailsValues");
    L22:
        if (gd.f9146a.a(((fx) ZeusTransformUtils.preCheckCast(r9, fx.class, "com.obric.memorydata.plugin")).k(), ((fx) ZeusTransformUtils.preCheckCast(r10, fx.class, "com.obric.memorydata.plugin")).k(), Type.EXTRACT, "address,addressType", false) == true) goto L25;
        r8.add("addressesValues");
    L25:
        if (gd.f9146a.a(((fx) ZeusTransformUtils.preCheckCast(r9, fx.class, "com.obric.memorydata.plugin")).m(), ((fx) ZeusTransformUtils.preCheckCast(r10, fx.class, "com.obric.memorydata.plugin")).m(), null, null, false) == true) goto L28;
        r8.add("company");
    L28:
        if (gd.f9146a.a(((fx) ZeusTransformUtils.preCheckCast(r9, fx.class, "com.obric.memorydata.plugin")).o(), ((fx) ZeusTransformUtils.preCheckCast(r10, fx.class, "com.obric.memorydata.plugin")).o(), Type.EXTRACT, "anniversaryDate,anniversaryName", false) == true) goto L31;
        r8.add("anniversariesValues");
    L31:
        if (gd.f9146a.a(((fx) ZeusTransformUtils.preCheckCast(r9, fx.class, "com.obric.memorydata.plugin")).r(), ((fx) ZeusTransformUtils.preCheckCast(r10, fx.class, "com.obric.memorydata.plugin")).r(), Type.EXTRACT, "relationType,relationship", false) == true) goto L34;
        r8.add("relationShipsValues");
    L34:
        if (gd.f9146a.a(((fx) ZeusTransformUtils.preCheckCast(r9, fx.class, "com.obric.memorydata.plugin")).t(), ((fx) ZeusTransformUtils.preCheckCast(r10, fx.class, "com.obric.memorydata.plugin")).t(), Type.FULL_CONTENT, null, false) == true) goto L37;
        r8.add("fullContent");
    L37:
        if (gd.f9146a.a(((fx) ZeusTransformUtils.preCheckCast(r9, fx.class, "com.obric.memorydata.plugin")).u(), ((fx) ZeusTransformUtils.preCheckCast(r10, fx.class, "com.obric.memorydata.plugin")).u(), null, null, false) == true) goto L40;
        r8.add("department");
    L40:
        if (gd.f9146a.a(((fx) ZeusTransformUtils.preCheckCast(r9, fx.class, "com.obric.memorydata.plugin")).v(), ((fx) ZeusTransformUtils.preCheckCast(r10, fx.class, "com.obric.memorydata.plugin")).v(), null, null, false) == true) goto L43;
        r8.add("jobTitle");
    L43:
        if (gd.f9146a.a(((fx) ZeusTransformUtils.preCheckCast(r9, fx.class, "com.obric.memorydata.plugin")).w(), ((fx) ZeusTransformUtils.preCheckCast(r10, fx.class, "com.obric.memorydata.plugin")).w(), null, null, false) == true) goto L45;
        r8.add("subNote");
    L45:
        r8.add("meta_full_content");
        return r8;
    L48:
        throw new IllegalStateException("Check failed.".toString());
    L50:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.e
    public Set<String> getPendingTaskColumns() {
        Set<String> r2 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        r2.add("insert_keyword_task");
        r2.add("meta_full_content");
        r2.add("telephonesValues");
        r2.add("credentialValues");
        r2.add("emailsValues");
        r2.add("addressesValues");
        r2.add("anniversariesValues");
        r2.add("relationShipsValues");
        r2.add("fullContent");
        return r2;
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityRawDbDao<? extends d> getRawDao() {
        return fy.a.a(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public IAppEntityVectorCopilotDao<? extends i> getTextCopilotDao() {
        return fy.a.b(this);
    }

    @Override // com.obric.memorydata.database.index.e
    public Object getValueByColumn(d r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "entity");
        Intrinsics.checkNotNullParameter(r3, "columnName");
        if (ZeusTransformUtils.instanceOf(r2, fx.class) == false) goto L37;
        switch(r3.hashCode()) {
            case -634557923: goto L31;
            case -530929935: goto L28;
            case -193103126: goto L24;
            case -49163175: goto L20;
            case 534039280: goto L16;
            case 1284784996: goto L12;
            case 1363055705: goto L8;
            default: goto L34;
        };
    L34:
        return null;
    L8:
        if (r3.equals("credentialValues") == false) goto L34;
        return ((fx) ZeusTransformUtils.preCheckCast(r2, fx.class, "com.obric.memorydata.plugin")).h();
    L12:
        if (r3.equals("addressesValues") == false) goto L34;
        return ((fx) ZeusTransformUtils.preCheckCast(r2, fx.class, "com.obric.memorydata.plugin")).l();
    L16:
        if (r3.equals("anniversariesValues") == false) goto L34;
        return ((fx) ZeusTransformUtils.preCheckCast(r2, fx.class, "com.obric.memorydata.plugin")).p();
    L20:
        if (r3.equals("emailsValues") == false) goto L34;
        return ((fx) ZeusTransformUtils.preCheckCast(r2, fx.class, "com.obric.memorydata.plugin")).j();
    L24:
        if (r3.equals("fullContent") == false) goto L34;
        return ((fx) ZeusTransformUtils.preCheckCast(r2, fx.class, "com.obric.memorydata.plugin")).t();
    L28:
        if (r3.equals("telephonesValues") == false) goto L34;
        return ((fx) ZeusTransformUtils.preCheckCast(r2, fx.class, "com.obric.memorydata.plugin")).c();
    L31:
        if (r3.equals("relationShipsValues") == false) goto L34;
        return ((fx) ZeusTransformUtils.preCheckCast(r2, fx.class, "com.obric.memorydata.plugin")).s();
    L37:
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
