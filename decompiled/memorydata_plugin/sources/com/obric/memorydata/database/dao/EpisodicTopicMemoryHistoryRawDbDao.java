package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.entity.bq;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/database/dao/EpisodicTopicMemoryHistoryRawDbDao;", "Lcom/obric/memorydata/database/dao/IHistoryEntityDao;", "Lcom/obric/memorydata/database/entity/EpisodicTopicMemoryHistoryEntity;", "getTableName", "", "getPrefix", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface EpisodicTopicMemoryHistoryRawDbDao extends IHistoryEntityDao<bq> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(EpisodicTopicMemoryHistoryRawDbDao r2) {
            return IHistoryEntityDao.DefaultImpls.deleteAll((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((EpisodicTopicMemoryHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryHistoryRawDbDao.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin"));
        }

        public static int deleteByEntityId(EpisodicTopicMemoryHistoryRawDbDao r2, String r3, String r4) {
            EpisodicTopicMemoryHistoryRawDbDao r5 = (EpisodicTopicMemoryHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IHistoryEntityDao.DefaultImpls.deleteByEntityId((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r5, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static int deleteByEntityIdList(EpisodicTopicMemoryHistoryRawDbDao r2, List<String> r3, String r4) {
            EpisodicTopicMemoryHistoryRawDbDao r5 = (EpisodicTopicMemoryHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityIds");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IHistoryEntityDao.DefaultImpls.deleteByEntityIdList((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r5, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static int deleteByEntityIdListAndPackageName(EpisodicTopicMemoryHistoryRawDbDao r2, List<String> r3, String r4) {
            EpisodicTopicMemoryHistoryRawDbDao r5 = (EpisodicTopicMemoryHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityIds");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IHistoryEntityDao.DefaultImpls.deleteByEntityIdListAndPackageName((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r5, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static int deleteById(EpisodicTopicMemoryHistoryRawDbDao r2, long r3) {
            return IHistoryEntityDao.DefaultImpls.deleteById((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((EpisodicTopicMemoryHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryHistoryRawDbDao.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static String getPrefix(EpisodicTopicMemoryHistoryRawDbDao r2) {
            EpisodicTopicMemoryHistoryRawDbDao r3 = (EpisodicTopicMemoryHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            return "episodic_topic_memory_";
        }

        public static String getTableName(EpisodicTopicMemoryHistoryRawDbDao r2) {
            EpisodicTopicMemoryHistoryRawDbDao r3 = (EpisodicTopicMemoryHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            return "EpisodicTopicMemoryHistoryEntity";
        }

        public static List<bq> queryAll(EpisodicTopicMemoryHistoryRawDbDao r2) {
            return IHistoryEntityDao.DefaultImpls.queryAll((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((EpisodicTopicMemoryHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryHistoryRawDbDao.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(EpisodicTopicMemoryHistoryRawDbDao r2) {
            return IHistoryEntityDao.DefaultImpls.queryAllCount((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((EpisodicTopicMemoryHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryHistoryRawDbDao.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin"));
        }

        public static List<bq> queryByEntityId(EpisodicTopicMemoryHistoryRawDbDao r2, String r3, String r4) {
            EpisodicTopicMemoryHistoryRawDbDao r5 = (EpisodicTopicMemoryHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IHistoryEntityDao.DefaultImpls.queryByEntityId((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r5, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<bq> queryByEntityIdListAndPackageName(EpisodicTopicMemoryHistoryRawDbDao r2, List<String> r3, String r4) {
            EpisodicTopicMemoryHistoryRawDbDao r5 = (EpisodicTopicMemoryHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityIds");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IHistoryEntityDao.DefaultImpls.queryByEntityIdListAndPackageName((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r5, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static bq queryById(EpisodicTopicMemoryHistoryRawDbDao r2, long r3) {
            return (bq) ZeusTransformUtils.preCheckCast(IHistoryEntityDao.DefaultImpls.queryById((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((EpisodicTopicMemoryHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryHistoryRawDbDao.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r3), bq.class, "com.obric.memorydata.plugin");
        }

        public static List<bq> queryByIds(EpisodicTopicMemoryHistoryRawDbDao r2, List<Long> r3) {
            EpisodicTopicMemoryHistoryRawDbDao r4 = (EpisodicTopicMemoryHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return IHistoryEntityDao.DefaultImpls.queryByIds((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r4, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static bq queryByUUID(EpisodicTopicMemoryHistoryRawDbDao r2, String r3) {
            EpisodicTopicMemoryHistoryRawDbDao r4 = (EpisodicTopicMemoryHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (bq) ZeusTransformUtils.preCheckCast(IHistoryEntityDao.DefaultImpls.queryByUUID((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r4, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r3), bq.class, "com.obric.memorydata.plugin");
        }

        public static bq queryOne(EpisodicTopicMemoryHistoryRawDbDao r2) {
            return (bq) ZeusTransformUtils.preCheckCast(IHistoryEntityDao.DefaultImpls.queryOne((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((EpisodicTopicMemoryHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryHistoryRawDbDao.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin")), bq.class, "com.obric.memorydata.plugin");
        }

        public static List<bq> queryWithLimitAndOffset(EpisodicTopicMemoryHistoryRawDbDao r2, int r3, int r4) {
            return IHistoryEntityDao.DefaultImpls.queryWithLimitAndOffset((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((EpisodicTopicMemoryHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryHistoryRawDbDao.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    String getPrefix();

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();
}
