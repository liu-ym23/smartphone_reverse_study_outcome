package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.memorydata.database.entity.bu;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000e\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H'J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H'J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H'J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH'J&\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0004H'J\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0004H'J\u000f\u0010\u0012\u001a\u0004\u0018\u00010\u000eH'¢\u0006\u0002\u0010\u0013J\u001f\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH'¢\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000eH'J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH'J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000eH'J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004H'J\u0018\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0004H'¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/database/dao/EvaluationSourceDataDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/EvaluationSourceDataEntity;", "getTableName", "", "queryBySessionType", "", "sessionType", "queryBySessionTypes", "sessionTypes", "queryByDataContentAndSessionType", "dataContent", "queryByUserIndex", "userIndex", "", "queryByUserIndexDataIdAndSessionType", "dataId", "queryByDataIdAndSessionType", "queryMaxUserIndex", "()Ljava/lang/Integer;", "queryMaxSessionIdByUserIndexAndDataId", "(II)Ljava/lang/Integer;", "queryByDataId", "deleteByDataId", "deleteByUserIndex", "queryBySessionTypeAndExtra", WsConstants.KEY_EXTRA, "deleteBySessionTypeAndExtra", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface EvaluationSourceDataDao extends BaseDao<bu> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(EvaluationSourceDataDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((EvaluationSourceDataDao) ZeusTransformUtils.wrapperContextForParams(r2, EvaluationSourceDataDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(EvaluationSourceDataDao r2) {
            EvaluationSourceDataDao r3 = (EvaluationSourceDataDao) ZeusTransformUtils.wrapperContextForParams(r2, EvaluationSourceDataDao.class, "com.obric.memorydata.plugin");
            return "EvaluationSourceData";
        }

        public static List<bu> queryAll(EvaluationSourceDataDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((EvaluationSourceDataDao) ZeusTransformUtils.wrapperContextForParams(r2, EvaluationSourceDataDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(EvaluationSourceDataDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((EvaluationSourceDataDao) ZeusTransformUtils.wrapperContextForParams(r2, EvaluationSourceDataDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static bu queryById(EvaluationSourceDataDao r2, long r3) {
            return (bu) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((EvaluationSourceDataDao) ZeusTransformUtils.wrapperContextForParams(r2, EvaluationSourceDataDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), bu.class, "com.obric.memorydata.plugin");
        }

        public static List<bu> queryByIds(EvaluationSourceDataDao r2, List<Long> r3) {
            EvaluationSourceDataDao r4 = (EvaluationSourceDataDao) ZeusTransformUtils.wrapperContextForParams(r2, EvaluationSourceDataDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static bu queryByUUID(EvaluationSourceDataDao r2, String r3) {
            EvaluationSourceDataDao r4 = (EvaluationSourceDataDao) ZeusTransformUtils.wrapperContextForParams(r2, EvaluationSourceDataDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (bu) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), bu.class, "com.obric.memorydata.plugin");
        }

        public static bu queryOne(EvaluationSourceDataDao r2) {
            return (bu) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((EvaluationSourceDataDao) ZeusTransformUtils.wrapperContextForParams(r2, EvaluationSourceDataDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), bu.class, "com.obric.memorydata.plugin");
        }

        public static List<bu> queryWithLimitAndOffset(EvaluationSourceDataDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((EvaluationSourceDataDao) ZeusTransformUtils.wrapperContextForParams(r2, EvaluationSourceDataDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    int deleteByDataId(int r1);

    int deleteBySessionTypeAndExtra(String r1, String r2);

    int deleteByUserIndex(int r1);

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    bu queryByDataContentAndSessionType(String r1, String r2);

    List<bu> queryByDataId(int r1);

    List<bu> queryByDataIdAndSessionType(int r1, String r2);

    List<bu> queryBySessionType(String r1);

    bu queryBySessionTypeAndExtra(String r1, String r2);

    List<bu> queryBySessionTypes(List<String> r1);

    List<bu> queryByUserIndex(int r1);

    List<bu> queryByUserIndexDataIdAndSessionType(int r1, int r2, String r3);

    Integer queryMaxSessionIdByUserIndexAndDataId(int r1, int r2);

    Integer queryMaxUserIndex();
}
