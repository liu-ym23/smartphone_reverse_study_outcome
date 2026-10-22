package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.ic;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH'¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/database/dao/ScreenStateDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/ScreenStateEntity;", "getTableName", "", "queryOnAndOffEvents", "", "startTime", "", "endTime", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ScreenStateDao extends BaseDao<ic> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(ScreenStateDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((ScreenStateDao) ZeusTransformUtils.wrapperContextForParams(r2, ScreenStateDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(ScreenStateDao r2) {
            ScreenStateDao r3 = (ScreenStateDao) ZeusTransformUtils.wrapperContextForParams(r2, ScreenStateDao.class, "com.obric.memorydata.plugin");
            return "RawScreenState";
        }

        public static List<ic> queryAll(ScreenStateDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((ScreenStateDao) ZeusTransformUtils.wrapperContextForParams(r2, ScreenStateDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(ScreenStateDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((ScreenStateDao) ZeusTransformUtils.wrapperContextForParams(r2, ScreenStateDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static ic queryById(ScreenStateDao r2, long r3) {
            return (ic) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((ScreenStateDao) ZeusTransformUtils.wrapperContextForParams(r2, ScreenStateDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), ic.class, "com.obric.memorydata.plugin");
        }

        public static List<ic> queryByIds(ScreenStateDao r2, List<Long> r3) {
            ScreenStateDao r4 = (ScreenStateDao) ZeusTransformUtils.wrapperContextForParams(r2, ScreenStateDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static ic queryByUUID(ScreenStateDao r2, String r3) {
            ScreenStateDao r4 = (ScreenStateDao) ZeusTransformUtils.wrapperContextForParams(r2, ScreenStateDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (ic) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), ic.class, "com.obric.memorydata.plugin");
        }

        public static ic queryOne(ScreenStateDao r2) {
            return (ic) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((ScreenStateDao) ZeusTransformUtils.wrapperContextForParams(r2, ScreenStateDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), ic.class, "com.obric.memorydata.plugin");
        }

        public static List<ic> queryWithLimitAndOffset(ScreenStateDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((ScreenStateDao) ZeusTransformUtils.wrapperContextForParams(r2, ScreenStateDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    List<ic> queryOnAndOffEvents(long r1, long r3);
}
