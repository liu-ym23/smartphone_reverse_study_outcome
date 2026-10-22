package com.obric.aiproactive.impl.aidb.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.dao.BaseDao;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH§@¢\u0006\u0002\u0010\nJ$\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH'J\u000e\u0010\r\u001a\u00020\u000eH§@¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\fH'¨\u0006\u0011"}, d2 = {"Lcom/obric/aiproactive/impl/aidb/dao/AiProactiveEventRecordDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/aiproactive/impl/aidb/entity/AiProactiveEventRecordEntity;", "getTableName", "", "listTodayRecords", "", "startOfDay", "", "endOfDay", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeTodayRecords", "Lkotlinx/coroutines/flow/Flow;", "countAllRecords", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeAllRecordCount", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface c extends BaseDao<com.obric.aiproactive.impl.aidb.a.c> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static com.obric.aiproactive.impl.aidb.a.c a(c r2, long r3) {
            return (com.obric.aiproactive.impl.aidb.a.c) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), com.obric.aiproactive.impl.aidb.a.c.class, "com.obric.memorydata.plugin");
        }

        public static com.obric.aiproactive.impl.aidb.a.c a(c r2, String r3) {
            c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (com.obric.aiproactive.impl.aidb.a.c) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), com.obric.aiproactive.impl.aidb.a.c.class, "com.obric.memorydata.plugin");
        }

        public static String a(c r2) {
            c r3 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
            return "ProactiveEventRecords";
        }

        public static List<com.obric.aiproactive.impl.aidb.a.c> a(c r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<com.obric.aiproactive.impl.aidb.a.c> a(c r2, List<Long> r3) {
            c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<com.obric.aiproactive.impl.aidb.a.c> b(c r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int c(c r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int d(c r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static com.obric.aiproactive.impl.aidb.a.c e(c r2) {
            return (com.obric.aiproactive.impl.aidb.a.c) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), com.obric.aiproactive.impl.aidb.a.c.class, "com.obric.memorydata.plugin");
        }
    }

    Object countAllRecords(Continuation<? super Integer> r1);

    Object listTodayRecords(long r1, long r3, Continuation<? super List<com.obric.aiproactive.impl.aidb.a.c>> r5);

    kotlinx.coroutines.flow.i<Integer> observeAllRecordCount();

    kotlinx.coroutines.flow.i<List<com.obric.aiproactive.impl.aidb.a.c>> observeTodayRecords(long r1, long r3);
}
