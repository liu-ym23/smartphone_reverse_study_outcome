package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.em;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH'¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/database/dao/PoiInfoGroupDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/PoiInfoGroupEntity;", "getTableName", "", "queryWithRefSource", "", OaidModel.KEY_ID, "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface PoiInfoGroupDao extends BaseDao<em> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(PoiInfoGroupDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((PoiInfoGroupDao) ZeusTransformUtils.wrapperContextForParams(r2, PoiInfoGroupDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(PoiInfoGroupDao r2) {
            PoiInfoGroupDao r3 = (PoiInfoGroupDao) ZeusTransformUtils.wrapperContextForParams(r2, PoiInfoGroupDao.class, "com.obric.memorydata.plugin");
            return "PoiInfoGroup";
        }

        public static List<em> queryAll(PoiInfoGroupDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((PoiInfoGroupDao) ZeusTransformUtils.wrapperContextForParams(r2, PoiInfoGroupDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(PoiInfoGroupDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((PoiInfoGroupDao) ZeusTransformUtils.wrapperContextForParams(r2, PoiInfoGroupDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static em queryById(PoiInfoGroupDao r2, long r3) {
            return (em) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((PoiInfoGroupDao) ZeusTransformUtils.wrapperContextForParams(r2, PoiInfoGroupDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), em.class, "com.obric.memorydata.plugin");
        }

        public static List<em> queryByIds(PoiInfoGroupDao r2, List<Long> r3) {
            PoiInfoGroupDao r4 = (PoiInfoGroupDao) ZeusTransformUtils.wrapperContextForParams(r2, PoiInfoGroupDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static em queryByUUID(PoiInfoGroupDao r2, String r3) {
            PoiInfoGroupDao r4 = (PoiInfoGroupDao) ZeusTransformUtils.wrapperContextForParams(r2, PoiInfoGroupDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (em) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), em.class, "com.obric.memorydata.plugin");
        }

        public static em queryOne(PoiInfoGroupDao r2) {
            return (em) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((PoiInfoGroupDao) ZeusTransformUtils.wrapperContextForParams(r2, PoiInfoGroupDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), em.class, "com.obric.memorydata.plugin");
        }

        public static List<em> queryWithLimitAndOffset(PoiInfoGroupDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((PoiInfoGroupDao) ZeusTransformUtils.wrapperContextForParams(r2, PoiInfoGroupDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    List<em> queryWithRefSource(long r1);
}
