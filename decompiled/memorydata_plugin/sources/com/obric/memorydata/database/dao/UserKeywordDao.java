package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.database.entity.jc;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0007\u001a\u00020\bH'J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u0004H'J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH'J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H'¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/database/dao/UserKeywordDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/UserKeywordEntity;", "getTableName", "", "queryWithLimitAndDesc", "", "limit", "", "queryByName", ActivityLifecycle.NAME, "queryRecent", "insertIfAbsent", "", "entity", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface UserKeywordDao extends BaseDao<jc> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(UserKeywordDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((UserKeywordDao) ZeusTransformUtils.wrapperContextForParams(r2, UserKeywordDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(UserKeywordDao r2) {
            UserKeywordDao r3 = (UserKeywordDao) ZeusTransformUtils.wrapperContextForParams(r2, UserKeywordDao.class, "com.obric.memorydata.plugin");
            return "UserKeyword";
        }

        public static List<jc> queryAll(UserKeywordDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((UserKeywordDao) ZeusTransformUtils.wrapperContextForParams(r2, UserKeywordDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(UserKeywordDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((UserKeywordDao) ZeusTransformUtils.wrapperContextForParams(r2, UserKeywordDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static jc queryById(UserKeywordDao r2, long r3) {
            return (jc) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((UserKeywordDao) ZeusTransformUtils.wrapperContextForParams(r2, UserKeywordDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), jc.class, "com.obric.memorydata.plugin");
        }

        public static List<jc> queryByIds(UserKeywordDao r2, List<Long> r3) {
            UserKeywordDao r4 = (UserKeywordDao) ZeusTransformUtils.wrapperContextForParams(r2, UserKeywordDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static jc queryByUUID(UserKeywordDao r2, String r3) {
            UserKeywordDao r4 = (UserKeywordDao) ZeusTransformUtils.wrapperContextForParams(r2, UserKeywordDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (jc) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), jc.class, "com.obric.memorydata.plugin");
        }

        public static jc queryOne(UserKeywordDao r2) {
            return (jc) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((UserKeywordDao) ZeusTransformUtils.wrapperContextForParams(r2, UserKeywordDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), jc.class, "com.obric.memorydata.plugin");
        }

        public static List<jc> queryWithLimitAndOffset(UserKeywordDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((UserKeywordDao) ZeusTransformUtils.wrapperContextForParams(r2, UserKeywordDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    long insertIfAbsent(jc r1);

    jc queryByName(String r1);

    List<jc> queryRecent(int r1);

    List<String> queryWithLimitAndDesc(int r1);
}
