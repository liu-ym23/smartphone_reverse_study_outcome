package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.in;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/obric/memorydata/database/dao/EpisodicMemoryContentTimeDao;", "Lcom/obric/memorydata/database/dao/IAppEntityContentTimeDao;", "Lcom/obric/memorydata/database/entity/ShortMemoryContentTimeEntity;", "getTableName", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface EpisodicMemoryContentTimeDao extends IAppEntityContentTimeDao<in> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String buildColumnGroup(EpisodicMemoryContentTimeDao r2, Set<String> r3) {
            EpisodicMemoryContentTimeDao r4 = (EpisodicMemoryContentTimeDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryContentTimeDao.class, "com.obric.memorydata.plugin");
            Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "columnSet");
            return IAppEntityContentTimeDao.DefaultImpls.buildColumnGroup((IAppEntityContentTimeDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityContentTimeDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static int deleteAll(EpisodicMemoryContentTimeDao r2) {
            return IAppEntityContentTimeDao.DefaultImpls.deleteAll((IAppEntityContentTimeDao) ZeusTransformUtils.preCheckCast((EpisodicMemoryContentTimeDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryContentTimeDao.class, "com.obric.memorydata.plugin"), IAppEntityContentTimeDao.class, "com.obric.memorydata.plugin"));
        }

        public static int deleteByRawDbId(EpisodicMemoryContentTimeDao r2, long r3) {
            return IAppEntityContentTimeDao.DefaultImpls.deleteByRawDbId((IAppEntityContentTimeDao) ZeusTransformUtils.preCheckCast((EpisodicMemoryContentTimeDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryContentTimeDao.class, "com.obric.memorydata.plugin"), IAppEntityContentTimeDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static void deleteByRawDbIdAndColumns(EpisodicMemoryContentTimeDao r2, long r3, Set<String> r5) {
            EpisodicMemoryContentTimeDao r4 = (EpisodicMemoryContentTimeDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryContentTimeDao.class, "com.obric.memorydata.plugin");
            Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
            IAppEntityContentTimeDao.DefaultImpls.deleteByRawDbIdAndColumns((IAppEntityContentTimeDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityContentTimeDao.class, "com.obric.memorydata.plugin"), r3, r6);
        }

        public static int deleteByRawDbIds(EpisodicMemoryContentTimeDao r2, List<Long> r3) {
            EpisodicMemoryContentTimeDao r4 = (EpisodicMemoryContentTimeDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryContentTimeDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "rawDbIds");
            return IAppEntityContentTimeDao.DefaultImpls.deleteByRawDbIds((IAppEntityContentTimeDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityContentTimeDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static String getTableName(EpisodicMemoryContentTimeDao r2) {
            EpisodicMemoryContentTimeDao r3 = (EpisodicMemoryContentTimeDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryContentTimeDao.class, "com.obric.memorydata.plugin");
            return "ShortMemoryContentTime";
        }

        public static List<in> queryAll(EpisodicMemoryContentTimeDao r2) {
            return IAppEntityContentTimeDao.DefaultImpls.queryAll((IAppEntityContentTimeDao) ZeusTransformUtils.preCheckCast((EpisodicMemoryContentTimeDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryContentTimeDao.class, "com.obric.memorydata.plugin"), IAppEntityContentTimeDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(EpisodicMemoryContentTimeDao r2) {
            return IAppEntityContentTimeDao.DefaultImpls.queryAllCount((IAppEntityContentTimeDao) ZeusTransformUtils.preCheckCast((EpisodicMemoryContentTimeDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryContentTimeDao.class, "com.obric.memorydata.plugin"), IAppEntityContentTimeDao.class, "com.obric.memorydata.plugin"));
        }

        public static in queryById(EpisodicMemoryContentTimeDao r2, long r3) {
            return (in) ZeusTransformUtils.preCheckCast(IAppEntityContentTimeDao.DefaultImpls.queryById((IAppEntityContentTimeDao) ZeusTransformUtils.preCheckCast((EpisodicMemoryContentTimeDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryContentTimeDao.class, "com.obric.memorydata.plugin"), IAppEntityContentTimeDao.class, "com.obric.memorydata.plugin"), r3), in.class, "com.obric.memorydata.plugin");
        }

        public static List<in> queryByIds(EpisodicMemoryContentTimeDao r2, List<Long> r3) {
            EpisodicMemoryContentTimeDao r4 = (EpisodicMemoryContentTimeDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryContentTimeDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return IAppEntityContentTimeDao.DefaultImpls.queryByIds((IAppEntityContentTimeDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityContentTimeDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static in queryByUUID(EpisodicMemoryContentTimeDao r2, String r3) {
            EpisodicMemoryContentTimeDao r4 = (EpisodicMemoryContentTimeDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryContentTimeDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (in) ZeusTransformUtils.preCheckCast(IAppEntityContentTimeDao.DefaultImpls.queryByUUID((IAppEntityContentTimeDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityContentTimeDao.class, "com.obric.memorydata.plugin"), r3), in.class, "com.obric.memorydata.plugin");
        }

        public static in queryOne(EpisodicMemoryContentTimeDao r2) {
            return (in) ZeusTransformUtils.preCheckCast(IAppEntityContentTimeDao.DefaultImpls.queryOne((IAppEntityContentTimeDao) ZeusTransformUtils.preCheckCast((EpisodicMemoryContentTimeDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryContentTimeDao.class, "com.obric.memorydata.plugin"), IAppEntityContentTimeDao.class, "com.obric.memorydata.plugin")), in.class, "com.obric.memorydata.plugin");
        }

        public static List<in> queryWithLimitAndOffset(EpisodicMemoryContentTimeDao r2, int r3, int r4) {
            return IAppEntityContentTimeDao.DefaultImpls.queryWithLimitAndOffset((IAppEntityContentTimeDao) ZeusTransformUtils.preCheckCast((EpisodicMemoryContentTimeDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryContentTimeDao.class, "com.obric.memorydata.plugin"), IAppEntityContentTimeDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();
}
