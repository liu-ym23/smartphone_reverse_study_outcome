package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.ab;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH'J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0004H'J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0017¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/database/dao/AutoMemorySemanticRelevantDataDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/AutoMemorySemanticRelevantData;", "getTableName", "", "countByMemoryIdAndRuleId", "", "memoryId", "", "ruleId", "updateEmptySourceTypeByMemoryIdAndRuleId", "sourceType", "insertIfAbsent", "", "entity", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface AutoMemorySemanticRelevantDataDao extends BaseDao<ab> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(AutoMemorySemanticRelevantDataDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((AutoMemorySemanticRelevantDataDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemorySemanticRelevantDataDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(AutoMemorySemanticRelevantDataDao r2) {
            AutoMemorySemanticRelevantDataDao r3 = (AutoMemorySemanticRelevantDataDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemorySemanticRelevantDataDao.class, "com.obric.memorydata.plugin");
            return "AutoMemorySemanticRelevantData";
        }

        public static boolean insertIfAbsent(AutoMemorySemanticRelevantDataDao r4, ab r5) {
            AutoMemorySemanticRelevantDataDao r6 = (AutoMemorySemanticRelevantDataDao) ZeusTransformUtils.wrapperContextForParams(r4, AutoMemorySemanticRelevantDataDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "entity");
            if (r6.countByMemoryIdAndRuleId(r5.b(), r5.c()) <= 0) goto L6;
            return false;
        L6:
            if (r6.insert(r5) <= 0) goto L9;
            return true;
        L9:
            return false;
        }

        public static List<ab> queryAll(AutoMemorySemanticRelevantDataDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((AutoMemorySemanticRelevantDataDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemorySemanticRelevantDataDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(AutoMemorySemanticRelevantDataDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((AutoMemorySemanticRelevantDataDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemorySemanticRelevantDataDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static ab queryById(AutoMemorySemanticRelevantDataDao r2, long r3) {
            return (ab) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((AutoMemorySemanticRelevantDataDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemorySemanticRelevantDataDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), ab.class, "com.obric.memorydata.plugin");
        }

        public static List<ab> queryByIds(AutoMemorySemanticRelevantDataDao r2, List<Long> r3) {
            AutoMemorySemanticRelevantDataDao r4 = (AutoMemorySemanticRelevantDataDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemorySemanticRelevantDataDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static ab queryByUUID(AutoMemorySemanticRelevantDataDao r2, String r3) {
            AutoMemorySemanticRelevantDataDao r4 = (AutoMemorySemanticRelevantDataDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemorySemanticRelevantDataDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (ab) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), ab.class, "com.obric.memorydata.plugin");
        }

        public static ab queryOne(AutoMemorySemanticRelevantDataDao r2) {
            return (ab) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((AutoMemorySemanticRelevantDataDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemorySemanticRelevantDataDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), ab.class, "com.obric.memorydata.plugin");
        }

        public static List<ab> queryWithLimitAndOffset(AutoMemorySemanticRelevantDataDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((AutoMemorySemanticRelevantDataDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemorySemanticRelevantDataDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    int countByMemoryIdAndRuleId(long r1, long r3);

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    boolean insertIfAbsent(ab r1);

    int updateEmptySourceTypeByMemoryIdAndRuleId(long r1, long r3, String r5);
}
