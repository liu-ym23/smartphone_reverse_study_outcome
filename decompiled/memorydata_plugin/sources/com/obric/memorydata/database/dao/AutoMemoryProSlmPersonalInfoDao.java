package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.AutoMemoryProSlmPersonalInfoEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/obric/memorydata/database/dao/AutoMemoryProSlmPersonalInfoDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/AutoMemoryProSlmPersonalInfoEntity;", "getTableName", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface AutoMemoryProSlmPersonalInfoDao extends BaseDao<AutoMemoryProSlmPersonalInfoEntity> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(AutoMemoryProSlmPersonalInfoDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((AutoMemoryProSlmPersonalInfoDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryProSlmPersonalInfoDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(AutoMemoryProSlmPersonalInfoDao r2) {
            AutoMemoryProSlmPersonalInfoDao r3 = (AutoMemoryProSlmPersonalInfoDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryProSlmPersonalInfoDao.class, "com.obric.memorydata.plugin");
            return "AutoMemoryProSlmPersonalInfo";
        }

        public static List<AutoMemoryProSlmPersonalInfoEntity> queryAll(AutoMemoryProSlmPersonalInfoDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((AutoMemoryProSlmPersonalInfoDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryProSlmPersonalInfoDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(AutoMemoryProSlmPersonalInfoDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((AutoMemoryProSlmPersonalInfoDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryProSlmPersonalInfoDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static AutoMemoryProSlmPersonalInfoEntity queryById(AutoMemoryProSlmPersonalInfoDao r2, long r3) {
            return (AutoMemoryProSlmPersonalInfoEntity) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((AutoMemoryProSlmPersonalInfoDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryProSlmPersonalInfoDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), AutoMemoryProSlmPersonalInfoEntity.class, "com.obric.memorydata.plugin");
        }

        public static List<AutoMemoryProSlmPersonalInfoEntity> queryByIds(AutoMemoryProSlmPersonalInfoDao r2, List<Long> r3) {
            AutoMemoryProSlmPersonalInfoDao r4 = (AutoMemoryProSlmPersonalInfoDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryProSlmPersonalInfoDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static AutoMemoryProSlmPersonalInfoEntity queryByUUID(AutoMemoryProSlmPersonalInfoDao r2, String r3) {
            AutoMemoryProSlmPersonalInfoDao r4 = (AutoMemoryProSlmPersonalInfoDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryProSlmPersonalInfoDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (AutoMemoryProSlmPersonalInfoEntity) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), AutoMemoryProSlmPersonalInfoEntity.class, "com.obric.memorydata.plugin");
        }

        public static AutoMemoryProSlmPersonalInfoEntity queryOne(AutoMemoryProSlmPersonalInfoDao r2) {
            return (AutoMemoryProSlmPersonalInfoEntity) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((AutoMemoryProSlmPersonalInfoDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryProSlmPersonalInfoDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), AutoMemoryProSlmPersonalInfoEntity.class, "com.obric.memorydata.plugin");
        }

        public static List<AutoMemoryProSlmPersonalInfoEntity> queryWithLimitAndOffset(AutoMemoryProSlmPersonalInfoDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((AutoMemoryProSlmPersonalInfoDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryProSlmPersonalInfoDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();
}
