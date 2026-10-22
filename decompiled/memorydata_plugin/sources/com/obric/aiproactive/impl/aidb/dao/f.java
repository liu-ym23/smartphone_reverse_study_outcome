package com.obric.aiproactive.impl.aidb.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.dao.BaseDao;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/obric/aiproactive/impl/aidb/dao/AiProactivePreferenceDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/aiproactive/impl/aidb/entity/AiProactivePreferenceEntity;", "getTableName", "", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface f extends BaseDao<com.obric.aiproactive.impl.aidb.a.f> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static com.obric.aiproactive.impl.aidb.a.f a(f r2, long r3) {
            return (com.obric.aiproactive.impl.aidb.a.f) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), com.obric.aiproactive.impl.aidb.a.f.class, "com.obric.memorydata.plugin");
        }

        public static com.obric.aiproactive.impl.aidb.a.f a(f r2, String r3) {
            f r4 = (f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (com.obric.aiproactive.impl.aidb.a.f) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), com.obric.aiproactive.impl.aidb.a.f.class, "com.obric.memorydata.plugin");
        }

        public static String a(f r2) {
            f r3 = (f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.memorydata.plugin");
            return "ProactivePreference";
        }

        public static List<com.obric.aiproactive.impl.aidb.a.f> a(f r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<com.obric.aiproactive.impl.aidb.a.f> a(f r2, List<Long> r3) {
            f r4 = (f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<com.obric.aiproactive.impl.aidb.a.f> b(f r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int c(f r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int d(f r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static com.obric.aiproactive.impl.aidb.a.f e(f r2) {
            return (com.obric.aiproactive.impl.aidb.a.f) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((f) ZeusTransformUtils.wrapperContextForParams(r2, f.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), com.obric.aiproactive.impl.aidb.a.f.class, "com.obric.memorydata.plugin");
        }
    }
}
