package com.obric.memorydata.database.dao;

import androidx.lifecycle.LiveData;
import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.je;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0004H'J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0004H'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0004H'¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/database/dao/UserProfileDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/UserProfileEntity;", "getTableName", "", "queryOneRecordBy", "uriKey", "queryOneRecord", "Landroidx/lifecycle/LiveData;", "deleteByUriKey", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface UserProfileDao extends BaseDao<je> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(UserProfileDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((UserProfileDao) ZeusTransformUtils.wrapperContextForParams(r2, UserProfileDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(UserProfileDao r2) {
            UserProfileDao r3 = (UserProfileDao) ZeusTransformUtils.wrapperContextForParams(r2, UserProfileDao.class, "com.obric.memorydata.plugin");
            return "UserProfile";
        }

        public static List<je> queryAll(UserProfileDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((UserProfileDao) ZeusTransformUtils.wrapperContextForParams(r2, UserProfileDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(UserProfileDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((UserProfileDao) ZeusTransformUtils.wrapperContextForParams(r2, UserProfileDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static je queryById(UserProfileDao r2, long r3) {
            return (je) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((UserProfileDao) ZeusTransformUtils.wrapperContextForParams(r2, UserProfileDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), je.class, "com.obric.memorydata.plugin");
        }

        public static List<je> queryByIds(UserProfileDao r2, List<Long> r3) {
            UserProfileDao r4 = (UserProfileDao) ZeusTransformUtils.wrapperContextForParams(r2, UserProfileDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static je queryByUUID(UserProfileDao r2, String r3) {
            UserProfileDao r4 = (UserProfileDao) ZeusTransformUtils.wrapperContextForParams(r2, UserProfileDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (je) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), je.class, "com.obric.memorydata.plugin");
        }

        public static je queryOne(UserProfileDao r2) {
            return (je) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((UserProfileDao) ZeusTransformUtils.wrapperContextForParams(r2, UserProfileDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), je.class, "com.obric.memorydata.plugin");
        }

        public static List<je> queryWithLimitAndOffset(UserProfileDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((UserProfileDao) ZeusTransformUtils.wrapperContextForParams(r2, UserProfileDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    int deleteByUriKey(String r1);

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    LiveData<je> queryOneRecord(String r1);

    je queryOneRecordBy(String r1);
}
