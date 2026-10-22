package com.obric.aiproactive.impl.aidb;

import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0080@¢\u0006\u0002\u0010\t\u001a\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000\u001a\b\u0010\u000b\u001a\u00020\fH\u0002\u001a\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0000\u001a\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0000\u001a \u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0000\u001a\u0018\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0013H\u0000\u001a4\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0019\u0018\u00010\u00182\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u0001H\u0000\u001a?\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00012\u0012\b\u0002\u0010\u001e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001f0\u00192\b\b\u0002\u0010 \u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010!\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"ARTIFACTS_COLUMN", "", "PENDING_CARD_STATUS", "RECOMMENDATION_COLUMNS", "", "hasRecommendationArtifactsColumn", "", "dao", "Lcom/obric/aiproactive/impl/aidb/dao/AiProactiveRecommendationDao;", "(Lcom/obric/aiproactive/impl/aidb/dao/AiProactiveRecommendationDao;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasRecommendationArtifactsColumnSync", "artifactsColumnCountQuery", "Landroidx/sqlite/db/SupportSQLiteQuery;", "buildPendingRecommendationsQuery", "Lcom/obric/aiproactive/impl/aidb/RecommendationQuerySpec;", "hasArtifactsColumn", "buildAllRecommendationsQuery", "buildRecommendationsByCreatedWindowQuery", "earliestTimeMillis", "", "latestTimeMillis", "buildRecommendationByIdQuery", OaidModel.KEY_ID, "buildArtifactFixtureCleanupSelection", "Lkotlin/Pair;", "", "fixtureDirectoryPrefix", "fixtureErrorCode", "recommendationQuery", "whereClause", "args", "", "limitOne", "(ZLjava/lang/String;[Ljava/lang/Object;Z)Lcom/obric/aiproactive/impl/aidb/RecommendationQuerySpec;", "ai_proactive_impl_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<String> f6365a = null;

    static {
        f6365a = CollectionsKt.listOf(new String[]{OaidModel.KEY_ID, "timestamp", "recommend_text", "recommend_title", "recommend_title_masked", "action_execute_list", "emoji", "display_duration_seconds", "score", InfoRequestQPSOptTraceLogger.REASON, "evidence", "card_status", "feedback_type", "feedback_reason", "feedback_text", "trace_id", "created", "updated"});
    }

    private static final SupportSQLiteQuery a() {
        return (SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT COUNT(*) FROM pragma_table_info('ProactiveRecommendation') WHERE name = 'artifacts_json'"), SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
    }

    public static final u a(boolean r7) {
        return a(r7, "card_status IS NULL OR card_status = ?", new String[]{"PENDING"}, false, 8, null);
    }

    public static final u a(boolean r2, long r3) {
        return a(r2, "id = ?", new Long[]{Long.valueOf(r3)}, true);
    }

    public static final u a(boolean r7, long r8, long r10) {
        return a(r7, "created >= ? AND created <= ?", new Long[]{Long.valueOf(r8), Long.valueOf(r10)}, false, 8, null);
    }

    private static final u a(boolean r15, String r16, Object[] r17, boolean r18) {
        if (r15 == false) goto L5;
        String r1 = "artifacts_json";
    L6:
        StringBuilder r2 = new StringBuilder();
        r2.append("SELECT ");
        r2.append(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(f6365a, Collection.class, "com.obric.memorydata.plugin"), r1), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(", ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null));
        r2.append(" FROM ");
        r2.append("ProactiveRecommendation");
        if (r16 == null) goto L9;
        r2.append(" WHERE (" + r16 + ')');
    L9:
        r2.append(" ORDER BY created DESC, id DESC");
        if (r18 == false) goto L12;
        r2.append(" LIMIT 1");
    L12:
        String r0 = r2.toString();
        Intrinsics.checkNotNullExpressionValue(r0, "toString(...)");
        return new u(r0, r17);
    L5:
        r1 = "NULL AS artifacts_json";
        goto L6
    }

    static /* synthetic */ u a(boolean r1, String r2, Object[] r3, boolean r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r3 = new Object[0];
    L9:
        if ((r5 & 8) == 0) goto L12;
        r4 = false;
    L12:
        return a(r1, r2, r3, r4);
    }

    public static final Object a(com.obric.aiproactive.impl.aidb.dao.g r5, Continuation<? super Boolean> r6) {
        com.obric.aiproactive.impl.aidb.dao.g r7 = (com.obric.aiproactive.impl.aidb.dao.g) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.aiproactive.impl.aidb.dao.g.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, AiProactiveRecommendationSchemaCompatKt$hasRecommendationArtifactsColumn$1.class) == false) goto L7;
        AiProactiveRecommendationSchemaCompatKt$hasRecommendationArtifactsColumn$1 r0 = (AiProactiveRecommendationSchemaCompatKt$hasRecommendationArtifactsColumn$1) ZeusTransformUtils.preCheckCast(r8, AiProactiveRecommendationSchemaCompatKt$hasRecommendationArtifactsColumn$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r9);
    L18:
        if (((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).intValue() > 0) goto L22;
        r4 = false;
    L22:
        return Boxing.boxBoolean(r4);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        SupportSQLiteQuery r10 = a();
        r0.label = 1;
        r9 = r7.queryInt(r10, r0);
        if (r9 != r2) goto L18;
        return r2;
    L7:
        r0 = new AiProactiveRecommendationSchemaCompatKt$hasRecommendationArtifactsColumn$1(r8);
        goto L8
    }

    public static final boolean a(com.obric.aiproactive.impl.aidb.dao.g r2) {
        com.obric.aiproactive.impl.aidb.dao.g r3 = (com.obric.aiproactive.impl.aidb.dao.g) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.aiproactive.impl.aidb.dao.g.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "dao");
        if (r3.queryIntSync(a()) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final u b(boolean r6) {
        return a(r6, null, null, false, 14, null);
    }
}
