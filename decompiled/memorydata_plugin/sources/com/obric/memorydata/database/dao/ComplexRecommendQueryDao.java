package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.aq;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH'¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/database/dao/ComplexRecommendQueryDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/ComplexRecommendQuery;", "getTableName", "", "getComplexRecommendQuery", "", "limit", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ComplexRecommendQueryDao extends BaseDao<aq> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(ComplexRecommendQueryDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((ComplexRecommendQueryDao) ZeusTransformUtils.wrapperContextForParams(r2, ComplexRecommendQueryDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(ComplexRecommendQueryDao r2) {
            ComplexRecommendQueryDao r3 = (ComplexRecommendQueryDao) ZeusTransformUtils.wrapperContextForParams(r2, ComplexRecommendQueryDao.class, "com.obric.memorydata.plugin");
            return "ComplexRecommendQuery";
        }

        public static List<aq> queryAll(ComplexRecommendQueryDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((ComplexRecommendQueryDao) ZeusTransformUtils.wrapperContextForParams(r2, ComplexRecommendQueryDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(ComplexRecommendQueryDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((ComplexRecommendQueryDao) ZeusTransformUtils.wrapperContextForParams(r2, ComplexRecommendQueryDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static aq queryById(ComplexRecommendQueryDao r2, long r3) {
            return (aq) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((ComplexRecommendQueryDao) ZeusTransformUtils.wrapperContextForParams(r2, ComplexRecommendQueryDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), aq.class, "com.obric.memorydata.plugin");
        }

        public static List<aq> queryByIds(ComplexRecommendQueryDao r2, List<Long> r3) {
            ComplexRecommendQueryDao r4 = (ComplexRecommendQueryDao) ZeusTransformUtils.wrapperContextForParams(r2, ComplexRecommendQueryDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static aq queryByUUID(ComplexRecommendQueryDao r2, String r3) {
            ComplexRecommendQueryDao r4 = (ComplexRecommendQueryDao) ZeusTransformUtils.wrapperContextForParams(r2, ComplexRecommendQueryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (aq) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), aq.class, "com.obric.memorydata.plugin");
        }

        public static aq queryOne(ComplexRecommendQueryDao r2) {
            return (aq) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((ComplexRecommendQueryDao) ZeusTransformUtils.wrapperContextForParams(r2, ComplexRecommendQueryDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), aq.class, "com.obric.memorydata.plugin");
        }

        public static List<aq> queryWithLimitAndOffset(ComplexRecommendQueryDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((ComplexRecommendQueryDao) ZeusTransformUtils.wrapperContextForParams(r2, ComplexRecommendQueryDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    List<aq> getComplexRecommendQuery(int r1);

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();
}
