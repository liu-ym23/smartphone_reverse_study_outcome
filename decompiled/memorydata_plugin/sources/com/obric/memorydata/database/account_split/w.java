package com.obric.memorydata.database.account_split;

import com.obric.memorydata.database.dao.BaseDao;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.database.manager.MemoryFrameDb;
import com.obric.memorydata.database.manager.PersonalMemoryFrameDb;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u001f\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00100\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u001f\u0010\u0012\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00100\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/database/account_split/PersonalDbSplitTableRegistry;", "", "<init>", "()V", "globalDb", "Lcom/obric/memorydata/database/manager/MemoryFrameDb;", "personalDb", "Lcom/obric/memorydata/database/manager/PersonalMemoryFrameDb;", "specs", "", "Lcom/obric/memorydata/database/account_split/PersonalDbSplitTableSpec;", "getSpecs", "()Ljava/util/List;", "migrationSpecs", "getMigrationSpecs", "restoreSpecs", "Lcom/obric/memorydata/database/account_split/LegacyBackupPersonalDbSplitTableSpec;", "getRestoreSpecs", "deleteSpecs", "getDeleteSpecs", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f8834a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final MemoryFrameDb f8835b = null;
    private static final PersonalMemoryFrameDb c = null;
    private static final List<x> d = null;
    private static final List<x> e = null;
    private static final List<l<?, ?>> f = null;
    private static final List<l<?, ?>> g = null;

    static {
        f8834a = new w();
        MemoryFrameDb r0 = MemoryDbEngine.INSTANCE.getGlobalDbEngine();
        f8835b = r0;
        PersonalMemoryFrameDb r1 = MemoryDbEngine.INSTANCE.getPersonalDbEngine();
        c = r1;
        List<x> r2 = CollectionsKt.listOf(new x[]{new t((BaseDao) ZeusTransformUtils.preCheckCast(r0.getAssistantChatDao$database_obricRelease(), BaseDao.class, "com.obric.memorydata.plugin"), (BaseDao) ZeusTransformUtils.preCheckCast(r1.getAssistantChatDao(), BaseDao.class, "com.obric.memorydata.plugin"), null, 4, null), new t((BaseDao) ZeusTransformUtils.preCheckCast(r0.getComplexRecommendQueryDao$database_obricRelease(), BaseDao.class, "com.obric.memorydata.plugin"), (BaseDao) ZeusTransformUtils.preCheckCast(r1.getComplexRecommendQueryDao(), BaseDao.class, "com.obric.memorydata.plugin"), null, 4, null), new j(r0, r1), new t((BaseDao) ZeusTransformUtils.preCheckCast(r0.getEpisodicMemoryHistoryRawDbDao$database_obricRelease(), BaseDao.class, "com.obric.memorydata.plugin"), (BaseDao) ZeusTransformUtils.preCheckCast(r1.getEpisodicMemoryHistoryRawDbDao(), BaseDao.class, "com.obric.memorydata.plugin"), "episodic_memory_personalDbSplitMigrated"), new t((BaseDao) ZeusTransformUtils.preCheckCast(r0.getEpisodicMemoryTextVectorCopilotDao$database_obricRelease(), BaseDao.class, "com.obric.memorydata.plugin"), (BaseDao) ZeusTransformUtils.preCheckCast(r1.getEpisodicMemoryTextVectorCopilotDao(), BaseDao.class, "com.obric.memorydata.plugin"), null, 4, null), new t((BaseDao) ZeusTransformUtils.preCheckCast(r0.getEpisodicMemoryContentTimeDao$database_obricRelease(), BaseDao.class, "com.obric.memorydata.plugin"), (BaseDao) ZeusTransformUtils.preCheckCast(r1.getEpisodicMemoryContentTimeDao(), BaseDao.class, "com.obric.memorydata.plugin"), null, 4, null), new y(r0, r1), new o(r0, r1), new u(r0, r1), new t((BaseDao) ZeusTransformUtils.preCheckCast(r0.getPendingContextDao$database_obricRelease(), BaseDao.class, "com.obric.memorydata.plugin"), (BaseDao) ZeusTransformUtils.preCheckCast(r1.getPendingContextDao(), BaseDao.class, "com.obric.memorydata.plugin"), null, 4, null), new t((BaseDao) ZeusTransformUtils.preCheckCast(r0.getPendingEpisodicDao$database_obricRelease(), BaseDao.class, "com.obric.memorydata.plugin"), (BaseDao) ZeusTransformUtils.preCheckCast(r1.getPendingEpisodicDao(), BaseDao.class, "com.obric.memorydata.plugin"), null, 4, null), new t((BaseDao) ZeusTransformUtils.preCheckCast(r0.getPendingSemanticDao$database_obricRelease(), BaseDao.class, "com.obric.memorydata.plugin"), (BaseDao) ZeusTransformUtils.preCheckCast(r1.getPendingSemanticDao(), BaseDao.class, "com.obric.memorydata.plugin"), null, 4, null), new p(r0, r1), new q(r0, r1), new s(r0, r1), new k(r0, r1), new t((BaseDao) ZeusTransformUtils.preCheckCast(r0.getEpisodicTopicMemoryHistoryRawDbDao$database_obricRelease(), BaseDao.class, "com.obric.memorydata.plugin"), (BaseDao) ZeusTransformUtils.preCheckCast(r1.getEpisodicTopicMemoryHistoryRawDbDao(), BaseDao.class, "com.obric.memorydata.plugin"), "episodic_topic_memory_personalDbSplitMigrated"), new t((BaseDao) ZeusTransformUtils.preCheckCast(r0.getEpisodicTopicMemoryTextVectorCopilotDao$database_obricRelease(), BaseDao.class, "com.obric.memorydata.plugin"), (BaseDao) ZeusTransformUtils.preCheckCast(r1.getEpisodicTopicMemoryTextVectorCopilotDao(), BaseDao.class, "com.obric.memorydata.plugin"), null, 4, null), new i(r0, r1), new n(r0, r1), new t((BaseDao) ZeusTransformUtils.preCheckCast(r0.getLifelogHistoryRawDbDao$database_obricRelease(), BaseDao.class, "com.obric.memorydata.plugin"), (BaseDao) ZeusTransformUtils.preCheckCast(r1.getLifelogHistoryRawDbDao(), BaseDao.class, "com.obric.memorydata.plugin"), "lifelog_personalDbSplitMigrated"), new t((BaseDao) ZeusTransformUtils.preCheckCast(r0.getLifeLogTextVectorCopilotDao$database_obricRelease(), BaseDao.class, "com.obric.memorydata.plugin"), (BaseDao) ZeusTransformUtils.preCheckCast(r1.getLifeLogTextVectorCopilotDao(), BaseDao.class, "com.obric.memorydata.plugin"), null, 4, null), new t((BaseDao) ZeusTransformUtils.preCheckCast(r0.getMemoryBaseRequirementDao$database_obricRelease(), BaseDao.class, "com.obric.memorydata.plugin"), (BaseDao) ZeusTransformUtils.preCheckCast(r1.getMemoryBaseRequirementDao(), BaseDao.class, "com.obric.memorydata.plugin"), null, 4, null), new t((BaseDao) ZeusTransformUtils.preCheckCast(r0.getMemoryBaseSceneDao$database_obricRelease(), BaseDao.class, "com.obric.memorydata.plugin"), (BaseDao) ZeusTransformUtils.preCheckCast(r1.getMemoryBaseSceneDao(), BaseDao.class, "com.obric.memorydata.plugin"), null, 4, null), new aa(r0, r1), new t((BaseDao) ZeusTransformUtils.preCheckCast(r0.getRawUserProfileHistoryRawDbDao$database_obricRelease(), BaseDao.class, "com.obric.memorydata.plugin"), (BaseDao) ZeusTransformUtils.preCheckCast(r1.getRawUserProfileHistoryRawDbDao(), BaseDao.class, "com.obric.memorydata.plugin"), "user_profile_personalDbSplitMigrated"), new t((BaseDao) ZeusTransformUtils.preCheckCast(r0.getUserProfileTextVectorCopilotDao$database_obricRelease(), BaseDao.class, "com.obric.memorydata.plugin"), (BaseDao) ZeusTransformUtils.preCheckCast(r1.getUserProfileTextVectorCopilotDao(), BaseDao.class, "com.obric.memorydata.plugin"), null, 4, null), new t((BaseDao) ZeusTransformUtils.preCheckCast(r0.getUserProfileDao$database_obricRelease(), BaseDao.class, "com.obric.memorydata.plugin"), (BaseDao) ZeusTransformUtils.preCheckCast(r1.getUserProfileDao(), BaseDao.class, "com.obric.memorydata.plugin"), null, 4, null), new t((BaseDao) ZeusTransformUtils.preCheckCast(r0.getMiddleUserProfileDao$database_obricRelease(), BaseDao.class, "com.obric.memorydata.plugin"), (BaseDao) ZeusTransformUtils.preCheckCast(r1.getMiddleUserProfileDao(), BaseDao.class, "com.obric.memorydata.plugin"), null, 4, null), new t((BaseDao) ZeusTransformUtils.preCheckCast(r0.getUserProfileMemoryDao$database_obricRelease(), BaseDao.class, "com.obric.memorydata.plugin"), (BaseDao) ZeusTransformUtils.preCheckCast(r1.getUserProfileMemoryDao(), BaseDao.class, "com.obric.memorydata.plugin"), null, 4, null), new t((BaseDao) ZeusTransformUtils.preCheckCast(r0.getUserKeywordDao$database_obricRelease(), BaseDao.class, "com.obric.memorydata.plugin"), (BaseDao) ZeusTransformUtils.preCheckCast(r1.getUserKeywordDao(), BaseDao.class, "com.obric.memorydata.plugin"), null, 4, null), new ae(r0, r1), new t((BaseDao) ZeusTransformUtils.preCheckCast(r0.getUnionSemanticMemoryExtDao$database_obricRelease(), BaseDao.class, "com.obric.memorydata.plugin"), (BaseDao) ZeusTransformUtils.preCheckCast(r1.getUnionSemanticMemoryExtDao(), BaseDao.class, "com.obric.memorydata.plugin"), null, 4, null), new t((BaseDao) ZeusTransformUtils.preCheckCast(r0.getUnionSemanticTypeSummaryDao$database_obricRelease(), BaseDao.class, "com.obric.memorydata.plugin"), (BaseDao) ZeusTransformUtils.preCheckCast(r1.getUnionSemanticTypeSummaryDao(), BaseDao.class, "com.obric.memorydata.plugin"), null, 4, null), new t((BaseDao) ZeusTransformUtils.preCheckCast(r0.getMemoryProcessUserInsightDao$database_obricRelease(), BaseDao.class, "com.obric.memorydata.plugin"), (BaseDao) ZeusTransformUtils.preCheckCast(r1.getMemoryProcessUserInsightDao(), BaseDao.class, "com.obric.memorydata.plugin"), null, 4, null), new t((BaseDao) ZeusTransformUtils.preCheckCast(r0.getUnionUserInsightDao$database_obricRelease(), BaseDao.class, "com.obric.memorydata.plugin"), (BaseDao) ZeusTransformUtils.preCheckCast(r1.getUnionUserInsightDao(), BaseDao.class, "com.obric.memorydata.plugin"), null, 4, null), new t((BaseDao) ZeusTransformUtils.preCheckCast(r0.getUnionUserPersonaDao$database_obricRelease(), BaseDao.class, "com.obric.memorydata.plugin"), (BaseDao) ZeusTransformUtils.preCheckCast(r1.getUnionUserPersonaDao(), BaseDao.class, "com.obric.memorydata.plugin"), null, 4, null), new t((BaseDao) ZeusTransformUtils.preCheckCast(r0.getSemanticMemoryHistoryRawDbDao$database_obricRelease(), BaseDao.class, "com.obric.memorydata.plugin"), (BaseDao) ZeusTransformUtils.preCheckCast(r1.getSemanticMemoryHistoryRawDbDao(), BaseDao.class, "com.obric.memorydata.plugin"), "semantic_personalDbSplitMigrated"), new t((BaseDao) ZeusTransformUtils.preCheckCast(r0.getSemanticTextCopilotDao$database_obricRelease(), BaseDao.class, "com.obric.memorydata.plugin"), (BaseDao) ZeusTransformUtils.preCheckCast(r1.getSemanticTextCopilotDao(), BaseDao.class, "com.obric.memorydata.plugin"), null, 4, null), new ad(r0, r1), new z(r0, r1), new ag(r0, r1), new af(r0, r1), new c(r0, r1), new h(r0, r1), new g(r0, r1), new t((BaseDao) ZeusTransformUtils.preCheckCast(r0.getAutoMemoryProEvaluationStatsDao$database_obricRelease(), BaseDao.class, "com.obric.memorydata.plugin"), (BaseDao) ZeusTransformUtils.preCheckCast(r1.getAutoMemoryProEvaluationStatsDao(), BaseDao.class, "com.obric.memorydata.plugin"), null, 4, null), new t((BaseDao) ZeusTransformUtils.preCheckCast(r0.getAutoMemoryProHistoryRawDbDao$database_obricRelease(), BaseDao.class, "com.obric.memorydata.plugin"), (BaseDao) ZeusTransformUtils.preCheckCast(r1.getAutoMemoryProHistoryRawDbDao(), BaseDao.class, "com.obric.memorydata.plugin"), "auto_memory_pro_personalDbSplitMigrated"), new t((BaseDao) ZeusTransformUtils.preCheckCast(r0.getAutoMemoryProTextVectorCopilotDao$database_obricRelease(), BaseDao.class, "com.obric.memorydata.plugin"), (BaseDao) ZeusTransformUtils.preCheckCast(r1.getAutoMemoryProTextVectorCopilotDao(), BaseDao.class, "com.obric.memorydata.plugin"), null, 4, null), new t((BaseDao) ZeusTransformUtils.preCheckCast(r0.getAutoMemoryProRawSourceDao$database_obricRelease(), BaseDao.class, "com.obric.memorydata.plugin"), (BaseDao) ZeusTransformUtils.preCheckCast(r1.getAutoMemoryProRawSourceDao(), BaseDao.class, "com.obric.memorydata.plugin"), null, 4, null), new f(r0, r1), new e(r0, r1), new d(r0, r1), new ac(r0, r1), new ab(r0, r1), new b(r0, r1), new r(r0, r1), new t((BaseDao) ZeusTransformUtils.preCheckCast(r0.getAssistantChatMessageDao$database_obricRelease(), BaseDao.class, "com.obric.memorydata.plugin"), (BaseDao) ZeusTransformUtils.preCheckCast(r1.getAssistantChatMessageDao(), BaseDao.class, "com.obric.memorydata.plugin"), null, 4, null)});
        d = r2;
        e = r2;
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Object r6 = r5.next();
        if (ZeusTransformUtils.instanceOf(r6, l.class) == false) goto L4;
        r4.add(r6);
        goto L4
    L8:
        f = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.asReversed(d), Iterable.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r7.iterator();
    L10:
        if (r9.hasNext() == false) goto L14;
        Object r10 = r9.next();
        if (ZeusTransformUtils.instanceOf(r10, l.class) == false) goto L10;
        r8.add(r10);
        goto L10
    L14:
        g = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin");
    }

    private w() {
    }

    public final List<x> a() {
        return e;
    }

    public final List<l<?, ?>> b() {
        return f;
    }

    public final List<l<?, ?>> c() {
        return g;
    }
}
