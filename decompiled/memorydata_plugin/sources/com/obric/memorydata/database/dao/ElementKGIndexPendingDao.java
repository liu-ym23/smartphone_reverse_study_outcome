package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.az;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH'J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0006H'J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH'J\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH'J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH'J\b\u0010\u0012\u001a\u00020\nH'J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H'J\b\u0010\u0014\u001a\u00020\u000eH'¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/database/dao/ElementKGIndexPendingDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/ElementKGIndexPendingEntity;", "getTableName", "", "queryWithRawDb", "", "rawDbId", "", "entityType", "", "queryWithId", "ids", "updateAsLowPowerIndexed", "", OaidModel.KEY_ID, "queryIndexed", "deleteByRawDb", "getTotalCount", "getAllItems", "deleteItemsWithIndexed", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ElementKGIndexPendingDao extends BaseDao<az> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(ElementKGIndexPendingDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((ElementKGIndexPendingDao) ZeusTransformUtils.wrapperContextForParams(r2, ElementKGIndexPendingDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(ElementKGIndexPendingDao r2) {
            ElementKGIndexPendingDao r3 = (ElementKGIndexPendingDao) ZeusTransformUtils.wrapperContextForParams(r2, ElementKGIndexPendingDao.class, "com.obric.memorydata.plugin");
            return "ElementKGIndexPending";
        }

        public static List<az> queryAll(ElementKGIndexPendingDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((ElementKGIndexPendingDao) ZeusTransformUtils.wrapperContextForParams(r2, ElementKGIndexPendingDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(ElementKGIndexPendingDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((ElementKGIndexPendingDao) ZeusTransformUtils.wrapperContextForParams(r2, ElementKGIndexPendingDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static az queryById(ElementKGIndexPendingDao r2, long r3) {
            return (az) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((ElementKGIndexPendingDao) ZeusTransformUtils.wrapperContextForParams(r2, ElementKGIndexPendingDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), az.class, "com.obric.memorydata.plugin");
        }

        public static List<az> queryByIds(ElementKGIndexPendingDao r2, List<Long> r3) {
            ElementKGIndexPendingDao r4 = (ElementKGIndexPendingDao) ZeusTransformUtils.wrapperContextForParams(r2, ElementKGIndexPendingDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static az queryByUUID(ElementKGIndexPendingDao r2, String r3) {
            ElementKGIndexPendingDao r4 = (ElementKGIndexPendingDao) ZeusTransformUtils.wrapperContextForParams(r2, ElementKGIndexPendingDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (az) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), az.class, "com.obric.memorydata.plugin");
        }

        public static az queryOne(ElementKGIndexPendingDao r2) {
            return (az) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((ElementKGIndexPendingDao) ZeusTransformUtils.wrapperContextForParams(r2, ElementKGIndexPendingDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), az.class, "com.obric.memorydata.plugin");
        }

        public static List<az> queryWithLimitAndOffset(ElementKGIndexPendingDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((ElementKGIndexPendingDao) ZeusTransformUtils.wrapperContextForParams(r2, ElementKGIndexPendingDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    int deleteByRawDb(long r1, int r3);

    void deleteItemsWithIndexed();

    List<az> getAllItems();

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    int getTotalCount();

    List<az> queryIndexed(long r1, int r3);

    List<az> queryWithId(List<Long> r1);

    List<az> queryWithRawDb(long r1, int r3);

    void updateAsLowPowerIndexed(long r1);
}
