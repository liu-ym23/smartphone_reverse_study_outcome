package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.jg;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0004H'¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/database/dao/UserProfileMemoryDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/UserProfileMemoryEntity;", "getTableName", "", "queryOneRecordBy", "profileKey", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface UserProfileMemoryDao extends BaseDao<jg> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(UserProfileMemoryDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((UserProfileMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, UserProfileMemoryDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(UserProfileMemoryDao r2) {
            UserProfileMemoryDao r3 = (UserProfileMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, UserProfileMemoryDao.class, "com.obric.memorydata.plugin");
            return "UserProfileMemoryEntity";
        }

        public static List<jg> queryAll(UserProfileMemoryDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((UserProfileMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, UserProfileMemoryDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(UserProfileMemoryDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((UserProfileMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, UserProfileMemoryDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static jg queryById(UserProfileMemoryDao r2, long r3) {
            return (jg) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((UserProfileMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, UserProfileMemoryDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), jg.class, "com.obric.memorydata.plugin");
        }

        public static List<jg> queryByIds(UserProfileMemoryDao r2, List<Long> r3) {
            UserProfileMemoryDao r4 = (UserProfileMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, UserProfileMemoryDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static jg queryByUUID(UserProfileMemoryDao r2, String r3) {
            UserProfileMemoryDao r4 = (UserProfileMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, UserProfileMemoryDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (jg) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), jg.class, "com.obric.memorydata.plugin");
        }

        public static jg queryOne(UserProfileMemoryDao r2) {
            return (jg) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((UserProfileMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, UserProfileMemoryDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), jg.class, "com.obric.memorydata.plugin");
        }

        public static List<jg> queryWithLimitAndOffset(UserProfileMemoryDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((UserProfileMemoryDao) ZeusTransformUtils.wrapperContextForParams(r2, UserProfileMemoryDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    jg queryOneRecordBy(String r1);
}
