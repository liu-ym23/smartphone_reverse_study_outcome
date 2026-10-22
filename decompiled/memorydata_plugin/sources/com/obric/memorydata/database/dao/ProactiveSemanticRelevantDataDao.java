package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.fa;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H'J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0004H'J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u0006H'J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H'J\b\u0010\u000e\u001a\u00020\u0006H\u0016¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/database/dao/ProactiveSemanticRelevantDataDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/ProactiveSemanticRelevantData;", "queryByMemoryId", "", "memoryId", "", "queryByMemoryIds", "memoryIds", "queryFirstBySourceScreenshot", "sourceScreenshot", "insert", "", "entity", "getTableName", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ProactiveSemanticRelevantDataDao extends BaseDao<fa> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(ProactiveSemanticRelevantDataDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((ProactiveSemanticRelevantDataDao) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveSemanticRelevantDataDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(ProactiveSemanticRelevantDataDao r2) {
            ProactiveSemanticRelevantDataDao r3 = (ProactiveSemanticRelevantDataDao) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveSemanticRelevantDataDao.class, "com.obric.memorydata.plugin");
            return "ProactiveSemanticRelevantData";
        }

        public static List<fa> queryAll(ProactiveSemanticRelevantDataDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((ProactiveSemanticRelevantDataDao) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveSemanticRelevantDataDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(ProactiveSemanticRelevantDataDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((ProactiveSemanticRelevantDataDao) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveSemanticRelevantDataDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static fa queryById(ProactiveSemanticRelevantDataDao r2, long r3) {
            return (fa) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((ProactiveSemanticRelevantDataDao) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveSemanticRelevantDataDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), fa.class, "com.obric.memorydata.plugin");
        }

        public static List<fa> queryByIds(ProactiveSemanticRelevantDataDao r2, List<Long> r3) {
            ProactiveSemanticRelevantDataDao r4 = (ProactiveSemanticRelevantDataDao) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveSemanticRelevantDataDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static fa queryByUUID(ProactiveSemanticRelevantDataDao r2, String r3) {
            ProactiveSemanticRelevantDataDao r4 = (ProactiveSemanticRelevantDataDao) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveSemanticRelevantDataDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (fa) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), fa.class, "com.obric.memorydata.plugin");
        }

        public static fa queryOne(ProactiveSemanticRelevantDataDao r2) {
            return (fa) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((ProactiveSemanticRelevantDataDao) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveSemanticRelevantDataDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), fa.class, "com.obric.memorydata.plugin");
        }

        public static List<fa> queryWithLimitAndOffset(ProactiveSemanticRelevantDataDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((ProactiveSemanticRelevantDataDao) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveSemanticRelevantDataDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    long insert(fa r1);

    List<fa> queryByMemoryId(String r1);

    List<fa> queryByMemoryIds(List<String> r1);

    fa queryFirstBySourceScreenshot(String r1);
}
