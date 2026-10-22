package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.bs;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/obric/memorydata/database/dao/EpisodicTopicMemoryTextVectorCopilotDao;", "Lcom/obric/memorydata/database/dao/IAppEntityVectorCopilotDao;", "Lcom/obric/memorydata/database/entity/EpisodicTopicMemoryTextVectorCopilotEntity;", "getTableName", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface EpisodicTopicMemoryTextVectorCopilotDao extends IAppEntityVectorCopilotDao<bs> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String buildColumnGroup(EpisodicTopicMemoryTextVectorCopilotDao r2, Set<String> r3) {
            EpisodicTopicMemoryTextVectorCopilotDao r4 = (EpisodicTopicMemoryTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "columnSet");
            return IAppEntityVectorCopilotDao.DefaultImpls.buildColumnGroup((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static int deleteAll(EpisodicTopicMemoryTextVectorCopilotDao r2) {
            return IAppEntityVectorCopilotDao.DefaultImpls.deleteAll((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((EpisodicTopicMemoryTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"));
        }

        public static int deleteByRawDbId(EpisodicTopicMemoryTextVectorCopilotDao r2, long r3) {
            return IAppEntityVectorCopilotDao.DefaultImpls.deleteByRawDbId((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((EpisodicTopicMemoryTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static void deleteByRawDbIdAndColumns(EpisodicTopicMemoryTextVectorCopilotDao r2, long r3, Set<String> r5) {
            EpisodicTopicMemoryTextVectorCopilotDao r4 = (EpisodicTopicMemoryTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
            IAppEntityVectorCopilotDao.DefaultImpls.deleteByRawDbIdAndColumns((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3, r6);
        }

        public static void deleteByRawDbIdAndType(EpisodicTopicMemoryTextVectorCopilotDao r2, long r3, int r5) {
            IAppEntityVectorCopilotDao.DefaultImpls.deleteByRawDbIdAndType((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((EpisodicTopicMemoryTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3, r5);
        }

        public static void deleteByRawDbIdAndTypeColumns(EpisodicTopicMemoryTextVectorCopilotDao r2, long r3, int r5, Set<String> r6) {
            EpisodicTopicMemoryTextVectorCopilotDao r4 = (EpisodicTopicMemoryTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
            IAppEntityVectorCopilotDao.DefaultImpls.deleteByRawDbIdAndTypeColumns((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3, r5, r7);
        }

        public static int deleteByRawDbIds(EpisodicTopicMemoryTextVectorCopilotDao r2, List<Long> r3) {
            EpisodicTopicMemoryTextVectorCopilotDao r4 = (EpisodicTopicMemoryTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "rawDbIds");
            return IAppEntityVectorCopilotDao.DefaultImpls.deleteByRawDbIds((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static String getTableName(EpisodicTopicMemoryTextVectorCopilotDao r2) {
            EpisodicTopicMemoryTextVectorCopilotDao r3 = (EpisodicTopicMemoryTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            return "EpisodicTopicMemoryTextVectorCopilot";
        }

        public static boolean isEmpty(EpisodicTopicMemoryTextVectorCopilotDao r2) {
            return IAppEntityVectorCopilotDao.DefaultImpls.isEmpty((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((EpisodicTopicMemoryTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"));
        }

        public static List<bs> queryAll(EpisodicTopicMemoryTextVectorCopilotDao r2) {
            return IAppEntityVectorCopilotDao.DefaultImpls.queryAll((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((EpisodicTopicMemoryTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(EpisodicTopicMemoryTextVectorCopilotDao r2) {
            return IAppEntityVectorCopilotDao.DefaultImpls.queryAllCount((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((EpisodicTopicMemoryTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"));
        }

        public static bs queryById(EpisodicTopicMemoryTextVectorCopilotDao r2, long r3) {
            return (bs) ZeusTransformUtils.preCheckCast(IAppEntityVectorCopilotDao.DefaultImpls.queryById((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((EpisodicTopicMemoryTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3), bs.class, "com.obric.memorydata.plugin");
        }

        public static List<bs> queryByIds(EpisodicTopicMemoryTextVectorCopilotDao r2, List<Long> r3) {
            EpisodicTopicMemoryTextVectorCopilotDao r4 = (EpisodicTopicMemoryTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return IAppEntityVectorCopilotDao.DefaultImpls.queryByIds((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<bs> queryByRawDbId(EpisodicTopicMemoryTextVectorCopilotDao r2, long r3) {
            return IAppEntityVectorCopilotDao.DefaultImpls.queryByRawDbId((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((EpisodicTopicMemoryTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<bs> queryByRawDbIdAndColumns(EpisodicTopicMemoryTextVectorCopilotDao r2, long r3, Set<String> r5) {
            EpisodicTopicMemoryTextVectorCopilotDao r4 = (EpisodicTopicMemoryTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
            return IAppEntityVectorCopilotDao.DefaultImpls.queryByRawDbIdAndColumns((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3, r6);
        }

        public static List<bs> queryByRawDbIdListAndColumnContent(EpisodicTopicMemoryTextVectorCopilotDao r2, List<Long> r3, String r4) {
            EpisodicTopicMemoryTextVectorCopilotDao r5 = (EpisodicTopicMemoryTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "rawDbIds");
            Intrinsics.checkNotNullParameter(r4, "rawDbColumn");
            return IAppEntityVectorCopilotDao.DefaultImpls.queryByRawDbIdListAndColumnContent((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static List<bs> queryByRawDbIds(EpisodicTopicMemoryTextVectorCopilotDao r2, List<Long> r3) {
            EpisodicTopicMemoryTextVectorCopilotDao r4 = (EpisodicTopicMemoryTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "rawDbIds");
            return IAppEntityVectorCopilotDao.DefaultImpls.queryByRawDbIds((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static bs queryByUUID(EpisodicTopicMemoryTextVectorCopilotDao r2, String r3) {
            EpisodicTopicMemoryTextVectorCopilotDao r4 = (EpisodicTopicMemoryTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (bs) ZeusTransformUtils.preCheckCast(IAppEntityVectorCopilotDao.DefaultImpls.queryByUUID((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3), bs.class, "com.obric.memorydata.plugin");
        }

        public static bs queryOne(EpisodicTopicMemoryTextVectorCopilotDao r2) {
            return (bs) ZeusTransformUtils.preCheckCast(IAppEntityVectorCopilotDao.DefaultImpls.queryOne((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((EpisodicTopicMemoryTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin")), bs.class, "com.obric.memorydata.plugin");
        }

        public static List<bs> queryWithLimitAndOffset(EpisodicTopicMemoryTextVectorCopilotDao r2, int r3, int r4) {
            return IAppEntityVectorCopilotDao.DefaultImpls.queryWithLimitAndOffset((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((EpisodicTopicMemoryTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicTopicMemoryTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();
}
