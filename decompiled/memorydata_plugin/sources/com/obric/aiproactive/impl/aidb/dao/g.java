package com.obric.aiproactive.impl.aidb.dao;

import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.dao.BaseDao;
import com.obric.memorydata.database.entity.ChatMessage;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0017\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\tJ\u001c\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u000b2\u0006\u0010\u0007\u001a\u00020\bH'J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\tJ\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\bH'J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H'J&\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0013H§@¢\u0006\u0002\u0010\u0016JD\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u0013H§@¢\u0006\u0002\u0010\u001bJ2\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u0013H§@¢\u0006\u0002\u0010\u001eJ<\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u0013H§@¢\u0006\u0002\u0010 J\u0018\u0010!\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u0013H§@¢\u0006\u0002\u0010\"J\u0017\u0010#\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u0013H'¢\u0006\u0002\u0010$J\u0010\u0010%\u001a\u0004\u0018\u00010\u0013H§@¢\u0006\u0002\u0010&J\u0018\u0010'\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u0013H§@¢\u0006\u0002\u0010\"J\u0016\u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020\u0013H§@¢\u0006\u0002\u0010\"¨\u0006*"}, d2 = {"Lcom/obric/aiproactive/impl/aidb/dao/AiProactiveRecommendationDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/aiproactive/impl/aidb/entity/AiProactiveRecommendationEntity;", "getTableName", "", "listRecommendations", "", ChatMessage.TYPE_QUERY, "Landroidx/sqlite/db/SupportSQLiteQuery;", "(Landroidx/sqlite/db/SupportSQLiteQuery;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeRecommendations", "Lkotlinx/coroutines/flow/Flow;", "queryInt", "", "queryIntSync", "listArtifactJsonSync", "updateCardStatus", "", OaidModel.KEY_ID, "", "cardStatus", "updated", "(JLjava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCardStatusAndFeedback", "feedbackType", "feedbackReason", "feedbackText", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateActionExecuteList", "actionExecuteList", "(JLjava/lang/String;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateFeedback", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findTraceIdById", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findTraceIdByIdSync", "(J)Ljava/lang/Long;", "findLatestTraceId", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findRecommendTextById", "deleteByTraceId", "traceId", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface g extends BaseDao<com.obric.aiproactive.impl.aidb.a.g> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static com.obric.aiproactive.impl.aidb.a.g a(g r2, long r3) {
            return (com.obric.aiproactive.impl.aidb.a.g) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), com.obric.aiproactive.impl.aidb.a.g.class, "com.obric.memorydata.plugin");
        }

        public static com.obric.aiproactive.impl.aidb.a.g a(g r2, String r3) {
            g r4 = (g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (com.obric.aiproactive.impl.aidb.a.g) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), com.obric.aiproactive.impl.aidb.a.g.class, "com.obric.memorydata.plugin");
        }

        public static String a(g r2) {
            g r3 = (g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.memorydata.plugin");
            return "ProactiveRecommendation";
        }

        public static List<com.obric.aiproactive.impl.aidb.a.g> a(g r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<com.obric.aiproactive.impl.aidb.a.g> a(g r2, List<Long> r3) {
            g r4 = (g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<com.obric.aiproactive.impl.aidb.a.g> b(g r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int c(g r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int d(g r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static com.obric.aiproactive.impl.aidb.a.g e(g r2) {
            return (com.obric.aiproactive.impl.aidb.a.g) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), com.obric.aiproactive.impl.aidb.a.g.class, "com.obric.memorydata.plugin");
        }
    }

    Object findLatestTraceId(Continuation<? super Long> r1);

    Object findRecommendTextById(long r1, Continuation<? super String> r3);

    Object findTraceIdById(long r1, Continuation<? super Long> r3);

    Long findTraceIdByIdSync(long r1);

    List<String> listArtifactJsonSync();

    Object listRecommendations(SupportSQLiteQuery r1, Continuation<? super List<com.obric.aiproactive.impl.aidb.a.g>> r2);

    kotlinx.coroutines.flow.i<List<com.obric.aiproactive.impl.aidb.a.g>> observeRecommendations(SupportSQLiteQuery r1);

    Object queryInt(SupportSQLiteQuery r1, Continuation<? super Integer> r2);

    int queryIntSync(SupportSQLiteQuery r1);

    Object updateActionExecuteList(long r1, String r3, String r4, long r5, Continuation<? super Unit> r7);

    Object updateCardStatus(long r1, String r3, long r4, Continuation<? super Unit> r6);

    Object updateCardStatusAndFeedback(long r1, String r3, String r4, String r5, String r6, long r7, Continuation<? super Unit> r9);

    Object updateFeedback(long r1, String r3, String r4, String r5, long r6, Continuation<? super Unit> r8);
}
