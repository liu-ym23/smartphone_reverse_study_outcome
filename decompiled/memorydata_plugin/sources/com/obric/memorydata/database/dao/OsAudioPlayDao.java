package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.eb;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH'¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/database/dao/OsAudioPlayDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/OsAudioPlayEntity;", "getTableName", "", "queryRecords", "", "startTimeStamp", "", "endTimeStamp", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface OsAudioPlayDao extends BaseDao<eb> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(OsAudioPlayDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((OsAudioPlayDao) ZeusTransformUtils.wrapperContextForParams(r2, OsAudioPlayDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(OsAudioPlayDao r2) {
            OsAudioPlayDao r3 = (OsAudioPlayDao) ZeusTransformUtils.wrapperContextForParams(r2, OsAudioPlayDao.class, "com.obric.memorydata.plugin");
            return "RawAudioPlay";
        }

        public static List<eb> queryAll(OsAudioPlayDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((OsAudioPlayDao) ZeusTransformUtils.wrapperContextForParams(r2, OsAudioPlayDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(OsAudioPlayDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((OsAudioPlayDao) ZeusTransformUtils.wrapperContextForParams(r2, OsAudioPlayDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static eb queryById(OsAudioPlayDao r2, long r3) {
            return (eb) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((OsAudioPlayDao) ZeusTransformUtils.wrapperContextForParams(r2, OsAudioPlayDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), eb.class, "com.obric.memorydata.plugin");
        }

        public static List<eb> queryByIds(OsAudioPlayDao r2, List<Long> r3) {
            OsAudioPlayDao r4 = (OsAudioPlayDao) ZeusTransformUtils.wrapperContextForParams(r2, OsAudioPlayDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static eb queryByUUID(OsAudioPlayDao r2, String r3) {
            OsAudioPlayDao r4 = (OsAudioPlayDao) ZeusTransformUtils.wrapperContextForParams(r2, OsAudioPlayDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (eb) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), eb.class, "com.obric.memorydata.plugin");
        }

        public static eb queryOne(OsAudioPlayDao r2) {
            return (eb) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((OsAudioPlayDao) ZeusTransformUtils.wrapperContextForParams(r2, OsAudioPlayDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), eb.class, "com.obric.memorydata.plugin");
        }

        public static List<eb> queryWithLimitAndOffset(OsAudioPlayDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((OsAudioPlayDao) ZeusTransformUtils.wrapperContextForParams(r2, OsAudioPlayDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    List<eb> queryRecords(long r1, long r3);
}
