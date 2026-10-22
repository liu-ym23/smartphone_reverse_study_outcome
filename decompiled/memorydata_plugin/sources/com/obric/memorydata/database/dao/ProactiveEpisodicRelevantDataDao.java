package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.entity.es;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H'J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H'¢\u0006\u0002\u0010\tJ\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0004H'J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u0006H'J2\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H'J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0002H'J\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\bH'J\u0016\u0010\u0019\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0004H'J\b\u0010\u001a\u001a\u00020\u0006H\u0016¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/database/dao/ProactiveEpisodicRelevantDataDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/ProactiveEpisodicRelevantData;", "queryByEpisodicId", "", "episodicId", "", "queryDetailStatusByEpisodicId", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "queryByEpisodicIds", "episodicIds", "queryLatestBySourceLink", "sourceLink", "queryLatestRecentInApp", ObricMemoryConstants.KEY_PACKAGE_NAME, "activityName", "ruleFamily", "fromTime", "", "toTime", "insert", "entity", "updateDetailStatusByEpisodicId", "detailStatus", "deleteByIds", "getTableName", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ProactiveEpisodicRelevantDataDao extends BaseDao<es> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(ProactiveEpisodicRelevantDataDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((ProactiveEpisodicRelevantDataDao) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveEpisodicRelevantDataDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(ProactiveEpisodicRelevantDataDao r2) {
            ProactiveEpisodicRelevantDataDao r3 = (ProactiveEpisodicRelevantDataDao) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveEpisodicRelevantDataDao.class, "com.obric.memorydata.plugin");
            return "ProactiveEpisodicRelevantData";
        }

        public static List<es> queryAll(ProactiveEpisodicRelevantDataDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((ProactiveEpisodicRelevantDataDao) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveEpisodicRelevantDataDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(ProactiveEpisodicRelevantDataDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((ProactiveEpisodicRelevantDataDao) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveEpisodicRelevantDataDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static es queryById(ProactiveEpisodicRelevantDataDao r2, long r3) {
            return (es) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((ProactiveEpisodicRelevantDataDao) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveEpisodicRelevantDataDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), es.class, "com.obric.memorydata.plugin");
        }

        public static List<es> queryByIds(ProactiveEpisodicRelevantDataDao r2, List<Long> r3) {
            ProactiveEpisodicRelevantDataDao r4 = (ProactiveEpisodicRelevantDataDao) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveEpisodicRelevantDataDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static es queryByUUID(ProactiveEpisodicRelevantDataDao r2, String r3) {
            ProactiveEpisodicRelevantDataDao r4 = (ProactiveEpisodicRelevantDataDao) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveEpisodicRelevantDataDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (es) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), es.class, "com.obric.memorydata.plugin");
        }

        public static es queryOne(ProactiveEpisodicRelevantDataDao r2) {
            return (es) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((ProactiveEpisodicRelevantDataDao) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveEpisodicRelevantDataDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), es.class, "com.obric.memorydata.plugin");
        }

        public static List<es> queryWithLimitAndOffset(ProactiveEpisodicRelevantDataDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((ProactiveEpisodicRelevantDataDao) ZeusTransformUtils.wrapperContextForParams(r2, ProactiveEpisodicRelevantDataDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    int deleteByIds(List<String> r1);

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    long insert(es r1);

    List<es> queryByEpisodicId(String r1);

    List<es> queryByEpisodicIds(List<String> r1);

    Integer queryDetailStatusByEpisodicId(String r1);

    es queryLatestBySourceLink(String r1);

    es queryLatestRecentInApp(String r1, String r2, String r3, long r4, long r6);

    int updateDetailStatusByEpisodicId(String r1, int r2);
}
